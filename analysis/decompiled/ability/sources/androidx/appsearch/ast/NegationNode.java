package androidx.appsearch.ast;

import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_ABSTRACT_SYNTAX_TREES)
/* loaded from: classes.dex */
public final class NegationNode implements Node {
    private final List<Node> mChildren;

    public NegationNode(Node node) {
        ArrayList arrayList = new ArrayList(1);
        this.mChildren = arrayList;
        arrayList.add((Node) Preconditions.checkNotNull(node));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NegationNode.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.mChildren, ((NegationNode) obj).mChildren);
    }

    public Node getChild() {
        return this.mChildren.get(0);
    }

    @Override // androidx.appsearch.ast.Node
    public List<Node> getChildren() {
        return Collections.unmodifiableList(this.mChildren);
    }

    public int hashCode() {
        return Objects.hashCode(this.mChildren);
    }

    public void setChild(Node node) {
        this.mChildren.set(0, (Node) Preconditions.checkNotNull(node));
    }

    public String toString() {
        return "NOT " + getChild();
    }
}
