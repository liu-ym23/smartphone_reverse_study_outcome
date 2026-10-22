package androidx.appsearch.ast.query;

import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.app.PropertyPath;
import androidx.appsearch.ast.FunctionNode;
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
public final class SearchNode implements FunctionNode {
    private final List<Node> mChildren;
    private final List<PropertyPath> mPropertyPaths;

    public SearchNode(Node node, List<PropertyPath> list) {
        this.mChildren = new ArrayList(1);
        Preconditions.checkNotNull(node);
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            Preconditions.checkNotNull(list.get(i));
        }
        this.mChildren.add(node);
        this.mPropertyPaths = new ArrayList(list);
    }

    private String escapeQuery(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '\"' || str.charAt(i) == '\\') {
                sb.append('\\');
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public void addPropertyPath(PropertyPath propertyPath) {
        this.mPropertyPaths.add((PropertyPath) Preconditions.checkNotNull(propertyPath));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SearchNode.class == obj.getClass()) {
            SearchNode searchNode = (SearchNode) obj;
            if (Objects.equals(this.mChildren, searchNode.mChildren) && Objects.equals(this.mPropertyPaths, searchNode.mPropertyPaths)) {
                return true;
            }
        }
        return false;
    }

    public Node getChild() {
        return this.mChildren.get(0);
    }

    @Override // androidx.appsearch.ast.Node
    public List<Node> getChildren() {
        return Collections.unmodifiableList(this.mChildren);
    }

    @Override // androidx.appsearch.ast.FunctionNode
    public String getFunctionName() {
        return FunctionNode.FUNCTION_NAME_SEARCH;
    }

    public List<PropertyPath> getPropertyPaths() {
        return Collections.unmodifiableList(this.mPropertyPaths);
    }

    public int hashCode() {
        return Objects.hash(this.mChildren, this.mPropertyPaths);
    }

    public void setChild(Node node) {
        this.mChildren.set(0, (Node) Preconditions.checkNotNull(node));
    }

    public void setPropertyPaths(List<PropertyPath> list) {
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            Preconditions.checkNotNull(list.get(i));
        }
        this.mPropertyPaths.clear();
        this.mPropertyPaths.addAll(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("search(\"");
        sb.append(escapeQuery(getChild().toString()));
        sb.append("\"");
        if (!this.mPropertyPaths.isEmpty()) {
            sb.append(", createList(");
            for (int i = 0; i < this.mPropertyPaths.size() - 1; i++) {
                sb.append("\"");
                sb.append(this.mPropertyPaths.get(i));
                sb.append("\", ");
            }
            sb.append("\"");
            sb.append(this.mPropertyPaths.get(r4.size() - 1));
            sb.append("\")");
        }
        sb.append(")");
        return sb.toString();
    }

    public SearchNode(Node node) {
        this(node, Collections.EMPTY_LIST);
    }
}
