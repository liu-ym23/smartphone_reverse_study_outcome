package org.yaml.snakeyaml.composer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.comments.CommentEventsCollector;
import org.yaml.snakeyaml.comments.CommentLine;
import org.yaml.snakeyaml.comments.CommentType;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.NodeEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.parser.Parser;
import org.yaml.snakeyaml.resolver.Resolver;
import org.yaml.snakeyaml.util.MergeUtils;

/* loaded from: classes5.dex */
public class Composer {
    private final Map<String, Node> anchors;
    private final CommentEventsCollector blockCommentsCollector;
    private final CommentEventsCollector inlineCommentsCollector;
    private final LoaderOptions loadingConfig;
    private final MergeUtils mergeUtils;
    private final int nestingDepthLimit;
    protected final Parser parser;
    private final Set<Node> recursiveNodes;
    private final Resolver resolver;
    private int nonScalarAliasesCount = 0;
    private int nestingDepth = 0;

    public Composer(Parser parser, Resolver resolver, LoaderOptions loaderOptions) {
        if (parser == null) {
            throw new NullPointerException("Parser must be provided");
        }
        if (resolver == null) {
            throw new NullPointerException("Resolver must be provided");
        }
        if (loaderOptions == null) {
            throw new NullPointerException("LoaderOptions must be provided");
        }
        this.parser = parser;
        this.resolver = resolver;
        this.anchors = new HashMap();
        this.recursiveNodes = new HashSet();
        this.loadingConfig = loaderOptions;
        this.blockCommentsCollector = new CommentEventsCollector(parser, CommentType.BLANK_LINE, CommentType.BLOCK);
        this.inlineCommentsCollector = new CommentEventsCollector(parser, CommentType.IN_LINE);
        this.nestingDepthLimit = loaderOptions.getNestingDepthLimit();
        this.mergeUtils = new MergeUtils() { // from class: org.yaml.snakeyaml.composer.Composer.1
            @Override // org.yaml.snakeyaml.util.MergeUtils
            public MappingNode asMappingNode(Node node) {
                return Composer.this.asMappingNode(node);
            }
        };
    }

    private Node composeNode(Node node) {
        Node nodeComposeScalarNode;
        this.blockCommentsCollector.collectEvents();
        if (node != null) {
            this.recursiveNodes.add(node);
        }
        if (this.parser.checkEvent(Event.ID.Alias)) {
            AliasEvent aliasEvent = (AliasEvent) this.parser.getEvent();
            String anchor = aliasEvent.getAnchor();
            if (!this.anchors.containsKey(anchor)) {
                throw new ComposerException("found undefined alias " + anchor, aliasEvent.getStartMark());
            }
            nodeComposeScalarNode = this.anchors.get(anchor);
            if (!(nodeComposeScalarNode instanceof ScalarNode)) {
                int i10 = this.nonScalarAliasesCount + 1;
                this.nonScalarAliasesCount = i10;
                if (i10 > this.loadingConfig.getMaxAliasesForCollections()) {
                    throw new YAMLException("Number of aliases for non-scalar nodes exceeds the specified max=" + this.loadingConfig.getMaxAliasesForCollections());
                }
            }
            if (this.recursiveNodes.remove(nodeComposeScalarNode)) {
                nodeComposeScalarNode.setTwoStepsConstruction(true);
            }
            this.blockCommentsCollector.consume();
            this.inlineCommentsCollector.collectEvents().consume();
        } else {
            String anchor2 = ((NodeEvent) this.parser.peekEvent()).getAnchor();
            increaseNestingDepth();
            nodeComposeScalarNode = this.parser.checkEvent(Event.ID.Scalar) ? composeScalarNode(anchor2, this.blockCommentsCollector.consume()) : this.parser.checkEvent(Event.ID.SequenceStart) ? composeSequenceNode(anchor2) : composeMappingNode(anchor2);
            decreaseNestingDepth();
        }
        this.recursiveNodes.remove(node);
        return nodeComposeScalarNode;
    }

    private void decreaseNestingDepth() {
        int i10 = this.nestingDepth;
        if (i10 <= 0) {
            throw new YAMLException("Nesting Depth cannot be negative");
        }
        this.nestingDepth = i10 - 1;
    }

    private void increaseNestingDepth() {
        int i10 = this.nestingDepth;
        if (i10 <= this.nestingDepthLimit) {
            this.nestingDepth = i10 + 1;
            return;
        }
        throw new YAMLException("Nesting Depth exceeded max " + this.nestingDepthLimit);
    }

    public MappingNode asMappingNode(Node node) {
        if (node instanceof MappingNode) {
            return (MappingNode) node;
        }
        Node node2 = this.anchors.get(node.getAnchor());
        if (node2 instanceof MappingNode) {
            return (MappingNode) node2;
        }
        throw new ComposerException("Expected mapping node or an anchor referencing mapping", this.parser.peekEvent().getStartMark());
    }

    public boolean checkNode() {
        if (this.parser.checkEvent(Event.ID.StreamStart)) {
            this.parser.getEvent();
        }
        return !this.parser.checkEvent(Event.ID.StreamEnd);
    }

    public Node composeKeyNode(MappingNode mappingNode) {
        return composeNode(mappingNode);
    }

    public void composeMappingChildren(List<NodeTuple> list, MappingNode mappingNode) {
        Node nodeComposeKeyNode = composeKeyNode(mappingNode);
        if (nodeComposeKeyNode.getTag().equals(Tag.MERGE)) {
            mappingNode.setMerged(true);
        }
        list.add(new NodeTuple(nodeComposeKeyNode, composeValueNode(mappingNode)));
    }

    public Node composeMappingNode(String str) {
        Tag tagResolve;
        boolean z10;
        MappingStartEvent mappingStartEvent = (MappingStartEvent) this.parser.getEvent();
        String tag = mappingStartEvent.getTag();
        if (tag == null || tag.equals("!")) {
            tagResolve = this.resolver.resolve(NodeId.mapping, null, mappingStartEvent.getImplicit());
            z10 = true;
        } else {
            tagResolve = new Tag(tag);
            if (tagResolve.isCustomGlobal() && !this.loadingConfig.getTagInspector().isGlobalTagAllowed(tagResolve)) {
                throw new ComposerException("Global tag is not allowed: " + tag, mappingStartEvent.getStartMark());
            }
            z10 = false;
        }
        Tag tag2 = tagResolve;
        ArrayList arrayList = new ArrayList();
        MappingNode mappingNode = new MappingNode(tag2, z10, arrayList, mappingStartEvent.getStartMark(), null, mappingStartEvent.getFlowStyle());
        if (mappingStartEvent.isFlow()) {
            mappingNode.setBlockComments(this.blockCommentsCollector.consume());
        }
        if (str != null) {
            mappingNode.setAnchor(str);
            this.anchors.put(str, mappingNode);
        }
        while (true) {
            Parser parser = this.parser;
            Event.ID id = Event.ID.MappingEnd;
            if (parser.checkEvent(id)) {
                break;
            }
            this.blockCommentsCollector.collectEvents();
            if (this.parser.checkEvent(id)) {
                break;
            }
            composeMappingChildren(arrayList, mappingNode);
        }
        if (mappingStartEvent.isFlow()) {
            mappingNode.setInLineComments(this.inlineCommentsCollector.collectEvents().consume());
        }
        mappingNode.setEndMark(this.parser.getEvent().getEndMark());
        this.inlineCommentsCollector.collectEvents();
        if (!this.inlineCommentsCollector.isEmpty()) {
            mappingNode.setInLineComments(this.inlineCommentsCollector.consume());
        }
        if (this.loadingConfig.isMergeOnCompose() && mappingNode.isMerged()) {
            mappingNode.setValue(this.mergeUtils.flatten(mappingNode));
            mappingNode.setMerged(false);
        }
        return mappingNode;
    }

    public Node composeScalarNode(String str, List<CommentLine> list) {
        Tag tagResolve;
        boolean z10;
        ScalarEvent scalarEvent = (ScalarEvent) this.parser.getEvent();
        String tag = scalarEvent.getTag();
        if (tag == null || tag.equals("!")) {
            tagResolve = this.resolver.resolve(NodeId.scalar, scalarEvent.getValue(), scalarEvent.getImplicit().canOmitTagInPlainScalar());
            z10 = true;
        } else {
            tagResolve = new Tag(tag);
            if (tagResolve.isCustomGlobal() && !this.loadingConfig.getTagInspector().isGlobalTagAllowed(tagResolve)) {
                throw new ComposerException("Global tag is not allowed: " + tag, scalarEvent.getStartMark());
            }
            z10 = false;
        }
        ScalarNode scalarNode = new ScalarNode(tagResolve, z10, scalarEvent.getValue(), scalarEvent.getStartMark(), scalarEvent.getEndMark(), scalarEvent.getScalarStyle());
        if (str != null) {
            scalarNode.setAnchor(str);
            this.anchors.put(str, scalarNode);
        }
        scalarNode.setBlockComments(list);
        scalarNode.setInLineComments(this.inlineCommentsCollector.collectEvents().consume());
        return scalarNode;
    }

    public Node composeSequenceNode(String str) {
        Tag tagResolve;
        boolean z10;
        SequenceStartEvent sequenceStartEvent = (SequenceStartEvent) this.parser.getEvent();
        String tag = sequenceStartEvent.getTag();
        if (tag == null || tag.equals("!")) {
            tagResolve = this.resolver.resolve(NodeId.sequence, null, sequenceStartEvent.getImplicit());
            z10 = true;
        } else {
            tagResolve = new Tag(tag);
            if (tagResolve.isCustomGlobal() && !this.loadingConfig.getTagInspector().isGlobalTagAllowed(tagResolve)) {
                throw new ComposerException("Global tag is not allowed: " + tag, sequenceStartEvent.getStartMark());
            }
            z10 = false;
        }
        boolean z11 = z10;
        Tag tag2 = tagResolve;
        ArrayList arrayList = new ArrayList();
        SequenceNode sequenceNode = new SequenceNode(tag2, z11, arrayList, sequenceStartEvent.getStartMark(), null, sequenceStartEvent.getFlowStyle());
        if (sequenceStartEvent.isFlow()) {
            sequenceNode.setBlockComments(this.blockCommentsCollector.consume());
        }
        if (str != null) {
            sequenceNode.setAnchor(str);
            this.anchors.put(str, sequenceNode);
        }
        while (true) {
            Parser parser = this.parser;
            Event.ID id = Event.ID.SequenceEnd;
            if (parser.checkEvent(id)) {
                break;
            }
            this.blockCommentsCollector.collectEvents();
            if (this.parser.checkEvent(id)) {
                break;
            }
            arrayList.add(composeNode(sequenceNode));
        }
        if (sequenceStartEvent.isFlow()) {
            sequenceNode.setInLineComments(this.inlineCommentsCollector.collectEvents().consume());
        }
        sequenceNode.setEndMark(this.parser.getEvent().getEndMark());
        this.inlineCommentsCollector.collectEvents();
        if (!this.inlineCommentsCollector.isEmpty()) {
            sequenceNode.setInLineComments(this.inlineCommentsCollector.consume());
        }
        return sequenceNode;
    }

    public Node composeValueNode(MappingNode mappingNode) {
        return composeNode(mappingNode);
    }

    public Node getNode() {
        this.blockCommentsCollector.collectEvents();
        if (this.parser.checkEvent(Event.ID.StreamEnd)) {
            List<CommentLine> listConsume = this.blockCommentsCollector.consume();
            Mark startMark = listConsume.get(0).getStartMark();
            MappingNode mappingNode = new MappingNode(Tag.COMMENT, false, Collections.EMPTY_LIST, startMark, null, DumperOptions.FlowStyle.BLOCK);
            mappingNode.setBlockComments(listConsume);
            return mappingNode;
        }
        this.parser.getEvent();
        Node nodeComposeNode = composeNode(null);
        this.blockCommentsCollector.collectEvents();
        if (!this.blockCommentsCollector.isEmpty()) {
            nodeComposeNode.setEndComments(this.blockCommentsCollector.consume());
        }
        this.parser.getEvent();
        this.anchors.clear();
        this.recursiveNodes.clear();
        return nodeComposeNode;
    }

    public Node getSingleNode() {
        this.parser.getEvent();
        Parser parser = this.parser;
        Event.ID id = Event.ID.StreamEnd;
        Node node = !parser.checkEvent(id) ? getNode() : null;
        if (this.parser.checkEvent(id)) {
            this.parser.getEvent();
            return node;
        }
        throw new ComposerException("expected a single document in the stream", node != null ? node.getStartMark() : null, "but found another document", this.parser.getEvent().getStartMark());
    }
}
