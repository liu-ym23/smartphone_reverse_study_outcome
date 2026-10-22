package androidx.appfunctions.metadata;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001Ba\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010$\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0003H\u0016Jq\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b*R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0018R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006+"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionMetadata;", "", "id", "", "packageName", "isEnabled", "", "schema", "Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", "parameters", "", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "response", "Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "components", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "description", "deprecation", "Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadata;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/appfunctions/metadata/AppFunctionSchemaMetadata;Ljava/util/List;Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;Ljava/lang/String;Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadata;)V", "getId", "()Ljava/lang/String;", "getPackageName", "()Z", "getSchema", "()Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", "getParameters", "()Ljava/util/List;", "getResponse", "()Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "getComponents", "()Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "getDescription", "getDeprecation", "()Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadata;", "equals", "other", "hashCode", "", "toString", "copy", "copy$appfunctions", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppFunctionMetadata {
    private final AppFunctionComponentsMetadata components;
    private final AppFunctionDeprecationMetadata deprecation;
    private final String description;
    private final String id;
    private final boolean isEnabled;
    private final String packageName;
    private final List<AppFunctionParameterMetadata> parameters;
    private final AppFunctionResponseMetadata response;
    private final AppFunctionSchemaMetadata schema;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionMetadata(String id, String packageName, boolean z10, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List<AppFunctionParameterMetadata> parameters, AppFunctionResponseMetadata response) {
        this(id, packageName, z10, appFunctionSchemaMetadata, parameters, response, null, null, null, 448, null);
        k.f(id, "id");
        k.f(packageName, "packageName");
        k.f(parameters, "parameters");
        k.f(response, "response");
    }

    public static /* synthetic */ AppFunctionMetadata copy$appfunctions$default(AppFunctionMetadata appFunctionMetadata, String str, String str2, boolean z10, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionComponentsMetadata appFunctionComponentsMetadata, String str3, AppFunctionDeprecationMetadata appFunctionDeprecationMetadata, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionMetadata.id;
        }
        if ((i & 2) != 0) {
            str2 = appFunctionMetadata.packageName;
        }
        if ((i & 4) != 0) {
            z10 = appFunctionMetadata.isEnabled;
        }
        if ((i & 8) != 0) {
            appFunctionSchemaMetadata = appFunctionMetadata.schema;
        }
        if ((i & 16) != 0) {
            list = appFunctionMetadata.parameters;
        }
        if ((i & 32) != 0) {
            appFunctionResponseMetadata = appFunctionMetadata.response;
        }
        if ((i & 64) != 0) {
            appFunctionComponentsMetadata = appFunctionMetadata.components;
        }
        if ((i & 128) != 0) {
            str3 = appFunctionMetadata.description;
        }
        if ((i & 256) != 0) {
            appFunctionDeprecationMetadata = appFunctionMetadata.deprecation;
        }
        String str4 = str3;
        AppFunctionDeprecationMetadata appFunctionDeprecationMetadata2 = appFunctionDeprecationMetadata;
        AppFunctionResponseMetadata appFunctionResponseMetadata2 = appFunctionResponseMetadata;
        AppFunctionComponentsMetadata appFunctionComponentsMetadata2 = appFunctionComponentsMetadata;
        List list2 = list;
        boolean z11 = z10;
        return appFunctionMetadata.copy$appfunctions(str, str2, z11, appFunctionSchemaMetadata, list2, appFunctionResponseMetadata2, appFunctionComponentsMetadata2, str4, appFunctionDeprecationMetadata2);
    }

    public final AppFunctionMetadata copy$appfunctions(String id, String packageName, boolean isEnabled, AppFunctionSchemaMetadata schema, List<AppFunctionParameterMetadata> parameters, AppFunctionResponseMetadata response, AppFunctionComponentsMetadata components, String description, AppFunctionDeprecationMetadata deprecation) {
        k.f(id, "id");
        k.f(packageName, "packageName");
        k.f(parameters, "parameters");
        k.f(response, "response");
        k.f(components, "components");
        k.f(description, "description");
        return new AppFunctionMetadata(id, packageName, isEnabled, schema, parameters, response, components, description, deprecation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!AppFunctionMetadata.class.equals(other != null ? other.getClass() : null)) {
            return false;
        }
        k.d(other, "null cannot be cast to non-null type androidx.appfunctions.metadata.AppFunctionMetadata");
        AppFunctionMetadata appFunctionMetadata = (AppFunctionMetadata) other;
        return k.b(this.id, appFunctionMetadata.id) && this.isEnabled == appFunctionMetadata.isEnabled && k.b(this.packageName, appFunctionMetadata.packageName) && k.b(this.schema, appFunctionMetadata.schema) && k.b(this.parameters, appFunctionMetadata.parameters) && k.b(this.response, appFunctionMetadata.response) && k.b(this.components, appFunctionMetadata.components) && k.b(this.description, appFunctionMetadata.description) && k.b(this.deprecation, appFunctionMetadata.deprecation);
    }

    public final AppFunctionComponentsMetadata getComponents() {
        return this.components;
    }

    public final AppFunctionDeprecationMetadata getDeprecation() {
        return this.deprecation;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.id;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final List<AppFunctionParameterMetadata> getParameters() {
        return this.parameters;
    }

    public final AppFunctionResponseMetadata getResponse() {
        return this.response;
    }

    public final AppFunctionSchemaMetadata getSchema() {
        return this.schema;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.isEnabled), this.id, this.packageName, this.schema, this.parameters, this.response, this.components, this.description, this.deprecation);
    }

    /* renamed from: isEnabled, reason: from getter */
    public final boolean getIsEnabled() {
        return this.isEnabled;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionMetadata(");
        sb.append("id='" + this.id + "', ");
        sb.append("packageName='" + this.packageName + "', ");
        sb.append("isEnabled=" + this.isEnabled + ", ");
        sb.append("schema=" + this.schema + ", ");
        sb.append("parameters=" + this.parameters + ", ");
        sb.append("response=" + this.response + ", ");
        StringBuilder sb2 = new StringBuilder("components=");
        sb2.append(this.components);
        sb.append(sb2.toString());
        sb.append("description=" + this.description);
        sb.append("deprecation=" + this.deprecation);
        sb.append(")");
        return sb.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionMetadata(String id, String packageName, boolean z10, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List<AppFunctionParameterMetadata> parameters, AppFunctionResponseMetadata response, AppFunctionComponentsMetadata components) {
        this(id, packageName, z10, appFunctionSchemaMetadata, parameters, response, components, null, null, 384, null);
        k.f(id, "id");
        k.f(packageName, "packageName");
        k.f(parameters, "parameters");
        k.f(response, "response");
        k.f(components, "components");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionMetadata(String id, String packageName, boolean z10, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List<AppFunctionParameterMetadata> parameters, AppFunctionResponseMetadata response, AppFunctionComponentsMetadata components, String description) {
        this(id, packageName, z10, appFunctionSchemaMetadata, parameters, response, components, description, null, 256, null);
        k.f(id, "id");
        k.f(packageName, "packageName");
        k.f(parameters, "parameters");
        k.f(response, "response");
        k.f(components, "components");
        k.f(description, "description");
    }

    public AppFunctionMetadata(String id, String packageName, boolean z10, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List<AppFunctionParameterMetadata> parameters, AppFunctionResponseMetadata response, AppFunctionComponentsMetadata components, String description, AppFunctionDeprecationMetadata appFunctionDeprecationMetadata) {
        k.f(id, "id");
        k.f(packageName, "packageName");
        k.f(parameters, "parameters");
        k.f(response, "response");
        k.f(components, "components");
        k.f(description, "description");
        this.id = id;
        this.packageName = packageName;
        this.isEnabled = z10;
        this.schema = appFunctionSchemaMetadata;
        this.parameters = parameters;
        this.response = response;
        this.components = components;
        this.description = description;
        this.deprecation = appFunctionDeprecationMetadata;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ AppFunctionMetadata(String str, String str2, boolean z10, AppFunctionSchemaMetadata appFunctionSchemaMetadata, List list, AppFunctionResponseMetadata appFunctionResponseMetadata, AppFunctionComponentsMetadata appFunctionComponentsMetadata, String str3, AppFunctionDeprecationMetadata appFunctionDeprecationMetadata, int i, e eVar) {
        AppFunctionComponentsMetadata appFunctionComponentsMetadata2;
        Map map = null;
        Object[] objArr = 0;
        if ((i & 64) != 0) {
            appFunctionComponentsMetadata2 = new AppFunctionComponentsMetadata(map, 1, objArr == true ? 1 : 0);
        } else {
            appFunctionComponentsMetadata2 = appFunctionComponentsMetadata;
        }
        this(str, str2, z10, appFunctionSchemaMetadata, list, appFunctionResponseMetadata, appFunctionComponentsMetadata2, (i & 128) != 0 ? "" : str3, (i & 256) != 0 ? null : appFunctionDeprecationMetadata);
    }
}
