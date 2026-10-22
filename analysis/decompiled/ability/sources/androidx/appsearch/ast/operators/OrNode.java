package androidx.appsearch.ast.operators;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.ast.Node;
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
public final class OrNode implements Node {
    private List<Node> mChildren;

    public OrNode(@NonNull List<Node> list) {
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(list.size() >= 2, "Number of nodes must be at least two.");
        this.mChildren = new ArrayList(list);
    }

    public void addChild(@NonNull Node node) {
        this.mChildren.add((Node) Preconditions.checkNotNull(node));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || OrNode.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.mChildren, ((OrNode) obj).mChildren);
    }

    @Override // androidx.appsearch.ast.Node
    @NonNull
    public List<Node> getChildren() {
        return Collections.unmodifiableList(this.mChildren);
    }

    public int getIndexOfChild(@NonNull Node node) {
        Preconditions.checkNotNull(node);
        return this.mChildren.indexOf(node);
    }

    public int hashCode() {
        return Objects.hashCode(this.mChildren);
    }

    public boolean removeChild(@NonNull Node node) {
        Preconditions.checkState(this.mChildren.size() > 2, "List of child nodes must contain at least 3 nodes in order to remove.");
        Preconditions.checkNotNull(node);
        return this.mChildren.remove(node);
    }

    public void setChild(int i, @NonNull Node node) {
        Preconditions.checkArgumentInRange(i, 0, this.mChildren.size() - 1, "Index");
        this.mChildren.set(i, (Node) Preconditions.checkNotNull(node));
    }

    public void setChildren(@NonNull List<Node> list) {
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(list.size() >= 2, "Number of nodes must be at least two.");
        this.mChildren = new ArrayList(list);
    }

    @NonNull
    public String toString() {
        return "(" + TextUtils.join(" OR ", this.mChildren) + ")";
    }

    public OrNode(@NonNull Node node, @NonNull Node node2, @NonNull Node... nodeArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add((Node) Preconditions.checkNotNull(node));
        arrayList.add((Node) Preconditions.checkNotNull(node2));
        arrayList.addAll(List.of((Object[]) Preconditions.checkNotNull(nodeArr)));
        this.mChildren = arrayList;
    }
}
