package androidx.appfunctions.metadata;

import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\r\u0010\u0016\u001a\u00020\u0017H\u0000¢\u0006\u0002\b\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0019"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "", HintConstants.AUTOFILL_HINT_NAME, "", "isRequired", "", "dataType", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "description", AppAgent.CONSTRUCT, "(Ljava/lang/String;ZLandroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "()Z", "getDataType", "()Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "getDescription", "equals", "other", "hashCode", "", "toString", "toAppFunctionParameterMetadataDocument", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadataDocument;", "toAppFunctionParameterMetadataDocument$appfunctions", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppFunctionParameterMetadata {
    private final AppFunctionDataTypeMetadata dataType;
    private final String description;
    private final boolean isRequired;
    private final String name;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionParameterMetadata(String name, boolean z10, AppFunctionDataTypeMetadata dataType) {
        this(name, z10, dataType, null, 8, null);
        k.f(name, "name");
        k.f(dataType, "dataType");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!AppFunctionParameterMetadata.class.equals(other != null ? other.getClass() : null)) {
            return false;
        }
        k.d(other, "null cannot be cast to non-null type androidx.appfunctions.metadata.AppFunctionParameterMetadata");
        AppFunctionParameterMetadata appFunctionParameterMetadata = (AppFunctionParameterMetadata) other;
        return k.b(this.name, appFunctionParameterMetadata.name) && this.isRequired == appFunctionParameterMetadata.isRequired && k.b(this.dataType, appFunctionParameterMetadata.dataType) && k.b(this.description, appFunctionParameterMetadata.description);
    }

    public final AppFunctionDataTypeMetadata getDataType() {
        return this.dataType;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.description.hashCode() + ((this.dataType.hashCode() + a.d(this.name.hashCode() * 31, 31, this.isRequired)) * 31);
    }

    /* renamed from: isRequired, reason: from getter */
    public final boolean getIsRequired() {
        return this.isRequired;
    }

    public final AppFunctionParameterMetadataDocument toAppFunctionParameterMetadataDocument$appfunctions() {
        return new AppFunctionParameterMetadataDocument(null, null, this.name, this.isRequired, this.dataType.toAppFunctionDataTypeMetadataDocument$appfunctions(), this.description, 3, null);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionParameterMetadata(name=");
        sb.append(this.name);
        sb.append(", isRequired=");
        sb.append(this.isRequired);
        sb.append(", dataType=");
        sb.append(this.dataType);
        sb.append(",description=");
        return B7.a.g(')', this.description, sb);
    }

    public AppFunctionParameterMetadata(String name, boolean z10, AppFunctionDataTypeMetadata dataType, String description) {
        k.f(name, "name");
        k.f(dataType, "dataType");
        k.f(description, "description");
        this.name = name;
        this.isRequired = z10;
        this.dataType = dataType;
        this.description = description;
    }

    public /* synthetic */ AppFunctionParameterMetadata(String str, boolean z10, AppFunctionDataTypeMetadata appFunctionDataTypeMetadata, String str2, int i, e eVar) {
        this(str, z10, appFunctionDataTypeMetadata, (i & 8) != 0 ? "" : str2);
    }
}
