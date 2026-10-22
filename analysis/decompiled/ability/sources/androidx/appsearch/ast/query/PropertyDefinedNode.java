package androidx.appsearch.ast.query;

import androidx.appsearch.app.ExperimentalAppSearchApi;
import androidx.appsearch.app.PropertyPath;
import androidx.appsearch.ast.FunctionNode;
import androidx.appsearch.flags.FlaggedApi;
import androidx.appsearch.flags.Flags;
import androidx.core.util.Preconditions;
import java.util.Objects;

@ExperimentalAppSearchApi
@FlaggedApi(Flags.FLAG_ENABLE_ABSTRACT_SYNTAX_TREES)
/* loaded from: classes.dex */
public final class PropertyDefinedNode implements FunctionNode {
    private PropertyPath mPropertyPath;

    public PropertyDefinedNode(PropertyPath propertyPath) {
        this.mPropertyPath = (PropertyPath) Preconditions.checkNotNull(propertyPath);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PropertyDefinedNode.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.mPropertyPath, ((PropertyDefinedNode) obj).mPropertyPath);
    }

    @Override // androidx.appsearch.ast.FunctionNode
    public String getFunctionName() {
        return FunctionNode.FUNCTION_NAME_PROPERTY_DEFINED;
    }

    public PropertyPath getPropertyPath() {
        return this.mPropertyPath;
    }

    public int hashCode() {
        return Objects.hashCode(this.mPropertyPath);
    }

    public void setPropertyPath(PropertyPath propertyPath) {
        this.mPropertyPath = (PropertyPath) Preconditions.checkNotNull(propertyPath);
    }

    public String toString() {
        return "propertyDefined(\"" + this.mPropertyPath + "\")";
    }
}
