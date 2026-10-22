package androidx.appfunctions.metadata;

import androidx.appsearch.annotation.Document;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Document
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001d"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionResponseMetadataDocument;", "", "namespace", "", "id", "valueType", "Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "description", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;Ljava/lang/String;)V", "getNamespace", "()Ljava/lang/String;", "getId", "getValueType", "()Landroidx/appfunctions/metadata/AppFunctionDataTypeMetadataDocument;", "getDescription", "toAppFunctionResponseMetadata", "Landroidx/appfunctions/metadata/AppFunctionResponseMetadata;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AppFunctionResponseMetadataDocument {

    @Document.StringProperty
    private final String description;

    @Document.Id
    private final String id;

    @Document.Namespace
    private final String namespace;

    @Document.DocumentProperty
    private final AppFunctionDataTypeMetadataDocument valueType;

    public AppFunctionResponseMetadataDocument(String namespace, String id, AppFunctionDataTypeMetadataDocument valueType, String str) {
        k.f(namespace, "namespace");
        k.f(id, "id");
        k.f(valueType, "valueType");
        this.namespace = namespace;
        this.id = id;
        this.valueType = valueType;
        this.description = str;
    }

    public static /* synthetic */ AppFunctionResponseMetadataDocument copy$default(AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument, String str, String str2, AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionResponseMetadataDocument.namespace;
        }
        if ((i & 2) != 0) {
            str2 = appFunctionResponseMetadataDocument.id;
        }
        if ((i & 4) != 0) {
            appFunctionDataTypeMetadataDocument = appFunctionResponseMetadataDocument.valueType;
        }
        if ((i & 8) != 0) {
            str3 = appFunctionResponseMetadataDocument.description;
        }
        return appFunctionResponseMetadataDocument.copy(str, str2, appFunctionDataTypeMetadataDocument, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNamespace() {
        return this.namespace;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final AppFunctionDataTypeMetadataDocument getValueType() {
        return this.valueType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AppFunctionResponseMetadataDocument copy(String namespace, String id, AppFunctionDataTypeMetadataDocument valueType, String description) {
        k.f(namespace, "namespace");
        k.f(id, "id");
        k.f(valueType, "valueType");
        return new AppFunctionResponseMetadataDocument(namespace, id, valueType, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionResponseMetadataDocument)) {
            return false;
        }
        AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument = (AppFunctionResponseMetadataDocument) other;
        return k.b(this.namespace, appFunctionResponseMetadataDocument.namespace) && k.b(this.id, appFunctionResponseMetadataDocument.id) && k.b(this.valueType, appFunctionResponseMetadataDocument.valueType) && k.b(this.description, appFunctionResponseMetadataDocument.description);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.id;
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final AppFunctionDataTypeMetadataDocument getValueType() {
        return this.valueType;
    }

    public int hashCode() {
        int iHashCode = (this.valueType.hashCode() + B7.a.c(this.namespace.hashCode() * 31, 31, this.id)) * 31;
        String str = this.description;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final AppFunctionResponseMetadata toAppFunctionResponseMetadata() {
        AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = this.valueType.toAppFunctionDataTypeMetadata();
        String str = this.description;
        if (str == null) {
            str = "";
        }
        return new AppFunctionResponseMetadata(appFunctionDataTypeMetadata, str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AppFunctionResponseMetadataDocument(namespace=");
        sb.append(this.namespace);
        sb.append(", id=");
        sb.append(this.id);
        sb.append(", valueType=");
        sb.append(this.valueType);
        sb.append(", description=");
        return B7.a.g(')', this.description, sb);
    }

    public /* synthetic */ AppFunctionResponseMetadataDocument(String str, String str2, AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument, String str3, int i, e eVar) {
        this((i & 1) != 0 ? AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE : str, (i & 2) != 0 ? AppFunctionMetadataKt.APP_FUNCTION_ID_EMPTY : str2, appFunctionDataTypeMetadataDocument, (i & 8) != 0 ? null : str3);
    }
}
