package org.yaml.snakeyaml.serializer;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.comments.CommentLine;
import org.yaml.snakeyaml.emitter.Emitable;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.CommentEvent;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.ImplicitTuple;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.nodes.AnchorNode;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.resolver.Resolver;
import org.yaml.snakeyaml.util.MergeUtils;

/* loaded from: classes5.dex */
public final class Serializer {
    private final AnchorGenerator anchorGenerator;
    private final Map<Node, String> anchors;
    private Boolean closed;
    private final boolean dereferenceAliases;
    private final Emitable emitter;
    private final boolean explicitEnd;
    private final Tag explicitRoot;
    private final boolean explicitStart;
    private final MergeUtils mergeUtils;
    private final Set<Node> recursive;
    private final Resolver resolver;
    private final Set<Node> serializedNodes;
    private final Map<String, String> useTags;
    private DumperOptions.Version useVersion;

    /* renamed from: org.yaml.snakeyaml.serializer.Serializer$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$org$yaml$snakeyaml$nodes$NodeId;

        static {
            int[] iArr = new int[NodeId.values().length];
            $SwitchMap$org$yaml$snakeyaml$nodes$NodeId = iArr;
            try {
                iArr[NodeId.sequence.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$nodes$NodeId[NodeId.mapping.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$nodes$NodeId[NodeId.scalar.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Serializer(Emitable emitable, Resolver resolver, DumperOptions dumperOptions, Tag tag) {
        if (emitable == null) {
            throw new NullPointerException("Emitter must  be provided");
        }
        if (resolver == null) {
            throw new NullPointerException("Resolver must  be provided");
        }
        if (dumperOptions == null) {
            throw new NullPointerException("DumperOptions must  be provided");
        }
        this.emitter = emitable;
        this.resolver = resolver;
        this.explicitStart = dumperOptions.isExplicitStart();
        this.explicitEnd = dumperOptions.isExplicitEnd();
        if (dumperOptions.getVersion() != null) {
            this.useVersion = dumperOptions.getVersion();
        }
        this.useTags = dumperOptions.getTags();
        this.serializedNodes = new HashSet();
        this.anchors = new HashMap();
        this.anchorGenerator = dumperOptions.getAnchorGenerator();
        this.dereferenceAliases = dumperOptions.isDereferenceAliases();
        this.recursive = Collections.newSetFromMap(new IdentityHashMap());
        this.closed = null;
        this.explicitRoot = tag;
        this.mergeUtils = new MergeUtils() { // from class: org.yaml.snakeyaml.serializer.Serializer.1
            @Override // org.yaml.snakeyaml.util.MergeUtils
            public MappingNode asMappingNode(Node node) {
                if (node instanceof MappingNode) {
                    return (MappingNode) node;
                }
                throw new SerializerException("expecting MappingNode while processing merge.");
            }
        };
    }

    private void anchorNode(Node node) {
        if (node.getNodeId() == NodeId.anchor) {
            node = ((AnchorNode) node).getRealNode();
        }
        if (this.anchors.containsKey(node)) {
            if (this.anchors.get(node) == null) {
                this.anchors.put(node, this.anchorGenerator.nextAnchor(node));
                return;
            }
            return;
        }
        this.anchors.put(node, node.getAnchor() != null ? this.anchorGenerator.nextAnchor(node) : null);
        int i10 = AnonymousClass2.$SwitchMap$org$yaml$snakeyaml$nodes$NodeId[node.getNodeId().ordinal()];
        if (i10 == 1) {
            Iterator<Node> it = ((SequenceNode) node).getValue().iterator();
            while (it.hasNext()) {
                anchorNode(it.next());
            }
        } else {
            if (i10 != 2) {
                return;
            }
            for (NodeTuple nodeTuple : ((MappingNode) node).getValue()) {
                Node keyNode = nodeTuple.getKeyNode();
                Node valueNode = nodeTuple.getValueNode();
                anchorNode(keyNode);
                anchorNode(valueNode);
            }
        }
    }

    private void serializeComments(List<CommentLine> list) throws IOException {
        if (list == null) {
            return;
        }
        for (CommentLine commentLine : list) {
            this.emitter.emit(new CommentEvent(commentLine.getCommentType(), commentLine.getValue(), commentLine.getStartMark(), commentLine.getEndMark()));
        }
    }

    private void serializeNode(Node node, Node node2) throws IOException {
        if (node.getNodeId() == NodeId.anchor) {
            node = ((AnchorNode) node).getRealNode();
        }
        if (this.dereferenceAliases && this.recursive.contains(node)) {
            throw new SerializerException("Cannot dereferenceAliases for recursive structures.");
        }
        this.recursive.add(node);
        String str = !this.dereferenceAliases ? this.anchors.get(node) : null;
        if (this.dereferenceAliases || !this.serializedNodes.contains(node)) {
            this.serializedNodes.add(node);
            int i10 = AnonymousClass2.$SwitchMap$org$yaml$snakeyaml$nodes$NodeId[node.getNodeId().ordinal()];
            if (i10 == 1) {
                SequenceNode sequenceNode = (SequenceNode) node;
                serializeComments(node.getBlockComments());
                this.emitter.emit(new SequenceStartEvent(str, node.getTag().getValue(), node.getTag().equals(this.resolver.resolve(NodeId.sequence, null, true)), null, null, sequenceNode.getFlowStyle()));
                Iterator<Node> it = sequenceNode.getValue().iterator();
                while (it.hasNext()) {
                    serializeNode(it.next(), node);
                }
                this.emitter.emit(new SequenceEndEvent(null, null));
                serializeComments(node.getInLineComments());
                serializeComments(node.getEndComments());
            } else if (i10 != 3) {
                serializeComments(node.getBlockComments());
                if (node.getTag() != Tag.COMMENT) {
                    boolean zEquals = node.getTag().equals(this.resolver.resolve(NodeId.mapping, null, true));
                    MappingNode mappingNode = (MappingNode) node;
                    List<NodeTuple> value = mappingNode.getValue();
                    if (this.dereferenceAliases && mappingNode.isMerged()) {
                        value = this.mergeUtils.flatten(mappingNode);
                    }
                    this.emitter.emit(new MappingStartEvent(str, mappingNode.getTag().getValue(), zEquals, null, null, mappingNode.getFlowStyle()));
                    for (NodeTuple nodeTuple : value) {
                        Node keyNode = nodeTuple.getKeyNode();
                        Node valueNode = nodeTuple.getValueNode();
                        serializeNode(keyNode, mappingNode);
                        serializeNode(valueNode, mappingNode);
                    }
                    this.emitter.emit(new MappingEndEvent(null, null));
                    serializeComments(node.getInLineComments());
                    serializeComments(node.getEndComments());
                }
            } else {
                ScalarNode scalarNode = (ScalarNode) node;
                serializeComments(node.getBlockComments());
                Resolver resolver = this.resolver;
                NodeId nodeId = NodeId.scalar;
                this.emitter.emit(new ScalarEvent(str, node.getTag().getValue(), new ImplicitTuple(node.getTag().equals(resolver.resolve(nodeId, scalarNode.getValue(), true)), node.getTag().equals(this.resolver.resolve(nodeId, scalarNode.getValue(), false))), scalarNode.getValue(), null, null, scalarNode.getScalarStyle()));
                serializeComments(node.getInLineComments());
                serializeComments(node.getEndComments());
            }
        } else {
            this.emitter.emit(new AliasEvent(str, null, null));
        }
        this.recursive.remove(node);
    }

    public void close() throws IOException {
        Boolean bool = this.closed;
        if (bool == null) {
            throw new SerializerException("serializer is not opened");
        }
        Boolean bool2 = Boolean.TRUE;
        if (bool2.equals(bool)) {
            return;
        }
        this.emitter.emit(new StreamEndEvent(null, null));
        this.closed = bool2;
        this.serializedNodes.clear();
        this.anchors.clear();
        this.recursive.clear();
    }

    public void open() throws IOException {
        Boolean bool = this.closed;
        if (bool == null) {
            this.emitter.emit(new StreamStartEvent(null, null));
            this.closed = Boolean.FALSE;
        } else {
            if (!Boolean.TRUE.equals(bool)) {
                throw new SerializerException("serializer is already opened");
            }
            throw new SerializerException("serializer is closed");
        }
    }

    public void serialize(Node node) throws IOException {
        Boolean bool = this.closed;
        if (bool == null) {
            throw new SerializerException("serializer is not opened");
        }
        if (bool.booleanValue()) {
            throw new SerializerException("serializer is closed");
        }
        this.emitter.emit(new DocumentStartEvent(null, null, this.explicitStart, this.useVersion, this.useTags));
        anchorNode(node);
        Tag tag = this.explicitRoot;
        if (tag != null) {
            node.setTag(tag);
        }
        serializeNode(node, null);
        this.emitter.emit(new DocumentEndEvent(null, null, this.explicitEnd));
        this.serializedNodes.clear();
        this.anchors.clear();
        this.recursive.clear();
    }
}
