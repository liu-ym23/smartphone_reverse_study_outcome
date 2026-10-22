package androidx.appfunctions.metadata;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\r\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "", "valueType", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "description", "", AppAgent.CONSTRUCT, "(Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;Ljava/lang/String;)V", "getValueType", "()Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "getDescription", "()Ljava/lang/String;", "equals", "", "other", "hashCode", "", "toString", "toAppFunctionResponseMetadataDocument", "Landroidx/appfunctions/metadata/AppFunctionResponseMetadataDocument;", "toAppFunctionResponseMetadataDocument$appfunctions", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppFunctionResponseMetadata {
    private final String description;
    private final AppFunctionDataTypeMetadata valueType;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionResponseMetadata(AppFunctionDataTypeMetadata valueType) {
        this(valueType, null, 2, 0 == true ? 1 : 0);
        k.f(valueType, "valueType");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!AppFunctionResponseMetadata.class.equals(other != null ? other.getClass() : null)) {
            return false;
        }
        k.d(other, "null cannot be cast to non-null type androidx.appfunctions.metadata.AppFunctionResponseMetadata");
        AppFunctionResponseMetadata appFunctionResponseMetadata = (AppFunctionResponseMetadata) other;
        return k.b(this.valueType, appFunctionResponseMetadata.valueType) && k.b(this.description, appFunctionResponseMetadata.description);
    }

    public final String getDescription() {
        return this.description;
    }

    public final AppFunctionDataTypeMetadata getValueType() {
        return this.valueType;
    }

    public int hashCode() {
        return this.description.hashCode() + (this.valueType.hashCode() * 31);
    }

    public final AppFunctionResponseMetadataDocument toAppFunctionResponseMetadataDocument$appfunctions() {
        return new AppFunctionResponseMetadataDocument(null, null, this.valueType.toAppFunctionDataTypeMetadataDocument$appfunctions(), this.description, 3, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionResponseMetadata(valueType=");
        sb.append(this.valueType);
        sb.append(", description=");
        return B7.a.g(')', this.description, sb);
    }

    public AppFunctionResponseMetadata(AppFunctionDataTypeMetadata valueType, String description) {
        k.f(valueType, "valueType");
        k.f(description, "description");
        this.valueType = valueType;
        this.description = description;
    }

    public /* synthetic */ AppFunctionResponseMetadata(AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, String str, int i, e eVar) {
        this(appFunctionDataTypeMetadata, (i & 2) != 0 ? "" : str);
    }
}
