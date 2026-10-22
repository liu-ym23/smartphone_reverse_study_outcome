package androidx.appsearch.ast.query;

import androidx.appfunctions.metadata.a;
import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.ast.FunctionNode;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.core.util.Preconditions;

@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_ABSTRACT_SYNTAX_TREES)
/* loaded from: classes.dex */
public final class GetSearchStringParameterNode implements FunctionNode {
    private int mSearchStringIndex;

    public GetSearchStringParameterNode(int i) {
        Preconditions.checkArgument(i >= 0, "SearchStringIndex must be non-negative.");
        this.mSearchStringIndex = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && GetSearchStringParameterNode.class == obj.getClass() && this.mSearchStringIndex == ((GetSearchStringParameterNode) obj).mSearchStringIndex;
    }

    @Override // androidx.appsearch.ast.FunctionNode
    public String getFunctionName() {
        return FunctionNode.FUNCTION_NAME_GET_SEARCH_STRING_PARAMETER;
    }

    public int getSearchStringIndex() {
        return this.mSearchStringIndex;
    }

    public int hashCode() {
        return Integer.hashCode(this.mSearchStringIndex);
    }

    public void setSearchStringIndex(int i) {
        Preconditions.checkArgument(i >= 0, "SearchStringIndex must be non-negative.");
        this.mSearchStringIndex = i;
    }

    public String toString() {
        return a.o(new StringBuilder("getSearchStringParameter("), ")", this.mSearchStringIndex);
    }
}
