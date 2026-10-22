package androidx.appfunctions.metadata;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBG\b\u0007\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\r\u0010\u0019\u001a\u00020\u001aH\u0010¢\u0006\u0002\b\u001bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionObjectTypeMetadata;", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadata;", "properties", "", "", "required", "", "qualifiedName", "isNullable", "", "description", AppAgent.CONSTRUCT, "(Ljava/util/Map;Ljava/util/List;Ljava/lang/String;ZLjava/lang/String;)V", "getProperties", "()Ljava/util/Map;", "getRequired", "()Ljava/util/List;", "getQualifiedName", "()Ljava/lang/String;", "equals", "other", "", "hashCode", "", "toString", "toAppFunctionDataTypeMetadataDocument", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "toAppFunctionDataTypeMetadataDocument$appfunctions", "Companion", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppFunctionObjectTypeMetadata extends AppFunctionDataTypeMetadata {
    public static final int TYPE = 3;
    private final Map<String, AppFunctionDataTypeMetadata> properties;
    private final String qualifiedName;
    private final List<String> required;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionObjectTypeMetadata(Map<String, ? extends AppFunctionDataTypeMetadata> properties, List<String> required, String str, boolean z10) {
        this(properties, required, str, z10, null, 16, null);
        k.f(properties, "properties");
        k.f(required, "required");
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public boolean equals(Object other) {
        if (!super.equals(other) || !(other instanceof AppFunctionObjectTypeMetadata)) {
            return false;
        }
        AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata = (AppFunctionObjectTypeMetadata) other;
        return k.b(this.properties, appFunctionObjectTypeMetadata.properties) && k.b(this.required, appFunctionObjectTypeMetadata.required) && k.b(this.qualifiedName, appFunctionObjectTypeMetadata.qualifiedName);
    }

    public final Map<String, AppFunctionDataTypeMetadata> getProperties() {
        return this.properties;
    }

    public final String getQualifiedName() {
        return this.qualifiedName;
    }

    public final List<String> getRequired() {
        return this.required;
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public int hashCode() {
        int iHashCode = this.required.hashCode() + a.f(this.properties, super.hashCode() * 31, 31);
        String str = this.qualifiedName;
        if (str == null) {
            return iHashCode;
        }
        return str.hashCode() + (iHashCode * 31);
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public AppFunctionDataTypeMetadataDocument toAppFunctionDataTypeMetadataDocument$appfunctions() {
        Map<String, AppFunctionDataTypeMetadata> map = this.properties;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, AppFunctionDataTypeMetadata> entry : map.entrySet()) {
            String key = entry.getKey();
            AppFunctionDataTypeMetadata value = entry.getValue();
            if (key == null) {
                throw new IllegalStateException("Required value was null.");
            }
            arrayList.add(new AppFunctionNamedDataTypeMetadataDocument(null, null, key, value.toAppFunctionDataTypeMetadataDocument$appfunctions(), 3, null));
        }
        List<String> list = this.required;
        String str = this.qualifiedName;
        boolean isNullable = getIsNullable();
        String description = getDescription();
        if (description.length() == 0) {
            description = null;
        }
        return new AppFunctionDataTypeMetadataDocument(null, null, 3, null, arrayList, null, null, list, null, isNullable, str, description, null, 4459, null);
    }

    @Override // androidx.appfunctions.metadata.AppFunctionDataTypeMetadata
    public String toString() {
        return "AppFunctionObjectTypeMetadata(properties=" + this.properties + ", required=" + this.required + ", qualifiedName=" + this.qualifiedName + ", isNullable=" + getIsNullable() + ",description=" + getDescription() + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppFunctionObjectTypeMetadata(Map<String, ? extends AppFunctionDataTypeMetadata> properties, List<String> required, String str, boolean z10, String description) {
        super(z10, description);
        k.f(properties, "properties");
        k.f(required, "required");
        k.f(description, "description");
        this.properties = properties;
        this.required = required;
        this.qualifiedName = str;
    }

    public /* synthetic */ AppFunctionObjectTypeMetadata(Map map, List list, String str, boolean z10, String str2, int i, e eVar) {
        this(map, list, str, z10, (i & 16) != 0 ? "" : str2);
    }
}
