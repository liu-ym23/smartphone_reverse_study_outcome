package org.yaml.snakeyaml.nodes;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.List;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.error.Mark;

/* loaded from: classes5.dex */
public class SequenceNode extends CollectionNode<Node> {
    private final List<Node> value;

    public SequenceNode(Tag tag, boolean z10, List<Node> list, Mark mark, Mark mark2, DumperOptions.FlowStyle flowStyle) {
        super(tag, mark, mark2, flowStyle);
        if (list == null) {
            throw new NullPointerException("value in a Node is required.");
        }
        this.value = list;
        this.resolved = z10;
    }

    @Override // org.yaml.snakeyaml.nodes.Node
    public NodeId getNodeId() {
        return NodeId.sequence;
    }

    @Override // org.yaml.snakeyaml.nodes.CollectionNode
    public List<Node> getValue() {
        return this.value;
    }

    public void setListType(Class<? extends Object> cls) {
        Iterator<Node> it = this.value.iterator();
        while (it.hasNext()) {
            it.next().setType(cls);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (Node node : getValue()) {
            if (node instanceof CollectionNode) {
                sb2.append(System.identityHashCode(node));
            } else {
                sb2.append(node.toString());
            }
            sb2.append(Const.STR_MART_COMMA);
        }
        if (sb2.length() > 0) {
            sb2.deleteCharAt(sb2.length() - 1);
        }
        return "<" + getClass().getName() + " (tag=" + getTag() + ", value=[" + ((Object) sb2) + "])>";
    }

    public SequenceNode(Tag tag, List<Node> list, DumperOptions.FlowStyle flowStyle) {
        this(tag, true, list, null, null, flowStyle);
    }
}
