package androidx.appfunctions.metadata;

import androidx.appsearch.annotation.Document;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Document(name = C$$__AppSearch__AppFunctionMetadataDocument.SCHEMA_NAME)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u0086\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0002\u00100J\u0014\u00101\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00103\u001a\u000204HÖ\u0081\u0004J\n\u00105\u001a\u00020\u0003HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00066"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionMetadataDocument;", "", "namespace", "", "id", "isEnabledByDefault", "", "schemaCategory", "schemaName", "schemaVersion", "", "parameters", "", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadataDocument;", "response", "Landroidx/appfunctions/metadata/AppFunctionResponseMetadataDocument;", "description", "deprecation", "Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadataDocument;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Landroidx/appfunctions/metadata/AppFunctionResponseMetadataDocument;Ljava/lang/String;Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadataDocument;)V", "getNamespace", "()Ljava/lang/String;", "getId", "()Z", "getSchemaCategory", "getSchemaName", "getSchemaVersion", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getParameters", "()Ljava/util/List;", "getResponse", "()Landroidx/appfunctions/metadata/AppFunctionResponseMetadataDocument;", "getDescription", "getDeprecation", "()Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadataDocument;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Landroidx/appfunctions/metadata/AppFunctionResponseMetadataDocument;Ljava/lang/String;Landroidx/appfunctions/metadata/AppFunctionDeprecationMetadataDocument;)Landroidx/appfunctions/metadata/AppFunctionMetadataDocument;", "equals", "other", "hashCode", "", "toString", AppFunctionMetadataKt.APP_FUNCTION_NAMESPACE}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class AppFunctionMetadataDocument {

    @Document.DocumentProperty
    private final AppFunctionDeprecationMetadataDocument deprecation;

    @Document.StringProperty
    private final String description;

    @Document.Id
    private final String id;

    @Document.BooleanProperty(name = "enabledByDefault")
    private final boolean isEnabledByDefault;

    @Document.Namespace
    private final String namespace;

    @Document.DocumentProperty
    private final List<AppFunctionParameterMetadataDocument> parameters;

    @Document.DocumentProperty
    private final AppFunctionResponseMetadataDocument response;

    @Document.StringProperty
    private final String schemaCategory;

    @Document.StringProperty
    private final String schemaName;

    @Document.LongProperty
    private final Long schemaVersion;

    public AppFunctionMetadataDocument(String namespace, String id, boolean z10, String str, String str2, Long l, List<AppFunctionParameterMetadataDocument> list, AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument, String str3, AppFunctionDeprecationMetadataDocument appFunctionDeprecationMetadataDocument) {
        k.f(namespace, "namespace");
        k.f(id, "id");
        this.namespace = namespace;
        this.id = id;
        this.isEnabledByDefault = z10;
        this.schemaCategory = str;
        this.schemaName = str2;
        this.schemaVersion = l;
        this.parameters = list;
        this.response = appFunctionResponseMetadataDocument;
        this.description = str3;
        this.deprecation = appFunctionDeprecationMetadataDocument;
    }

    public static /* synthetic */ AppFunctionMetadataDocument copy$default(AppFunctionMetadataDocument appFunctionMetadataDocument, String str, String str2, boolean z10, String str3, String str4, Long l, List list, AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument, String str5, AppFunctionDeprecationMetadataDocument appFunctionDeprecationMetadataDocument, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appFunctionMetadataDocument.namespace;
        }
        if ((i & 2) != 0) {
            str2 = appFunctionMetadataDocument.id;
        }
        if ((i & 4) != 0) {
            z10 = appFunctionMetadataDocument.isEnabledByDefault;
        }
        if ((i & 8) != 0) {
            str3 = appFunctionMetadataDocument.schemaCategory;
        }
        if ((i & 16) != 0) {
            str4 = appFunctionMetadataDocument.schemaName;
        }
        if ((i & 32) != 0) {
            l = appFunctionMetadataDocument.schemaVersion;
        }
        if ((i & 64) != 0) {
            list = appFunctionMetadataDocument.parameters;
        }
        if ((i & 128) != 0) {
            appFunctionResponseMetadataDocument = appFunctionMetadataDocument.response;
        }
        if ((i & 256) != 0) {
            str5 = appFunctionMetadataDocument.description;
        }
        if ((i & 512) != 0) {
            appFunctionDeprecationMetadataDocument = appFunctionMetadataDocument.deprecation;
        }
        String str6 = str5;
        AppFunctionDeprecationMetadataDocument appFunctionDeprecationMetadataDocument2 = appFunctionDeprecationMetadataDocument;
        List list2 = list;
        AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument2 = appFunctionResponseMetadataDocument;
        String str7 = str4;
        Long l5 = l;
        return appFunctionMetadataDocument.copy(str, str2, z10, str3, str7, l5, list2, appFunctionResponseMetadataDocument2, str6, appFunctionDeprecationMetadataDocument2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getNamespace() {
        return this.namespace;
    }

    /* renamed from: component10, reason: from getter */
    public final AppFunctionDeprecationMetadataDocument getDeprecation() {
        return this.deprecation;
    }

    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsEnabledByDefault() {
        return this.isEnabledByDefault;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSchemaCategory() {
        return this.schemaCategory;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSchemaName() {
        return this.schemaName;
    }

    /* renamed from: component6, reason: from getter */
    public final Long getSchemaVersion() {
        return this.schemaVersion;
    }

    public final List<AppFunctionParameterMetadataDocument> component7() {
        return this.parameters;
    }

    /* renamed from: component8, reason: from getter */
    public final AppFunctionResponseMetadataDocument getResponse() {
        return this.response;
    }

    /* renamed from: component9, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AppFunctionMetadataDocument copy(String namespace, String id, boolean isEnabledByDefault, String schemaCategory, String schemaName, Long schemaVersion, List<AppFunctionParameterMetadataDocument> parameters, AppFunctionResponseMetadataDocument response, String description, AppFunctionDeprecationMetadataDocument deprecation) {
        k.f(namespace, "namespace");
        k.f(id, "id");
        return new AppFunctionMetadataDocument(namespace, id, isEnabledByDefault, schemaCategory, schemaName, schemaVersion, parameters, response, description, deprecation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppFunctionMetadataDocument)) {
            return false;
        }
        AppFunctionMetadataDocument appFunctionMetadataDocument = (AppFunctionMetadataDocument) other;
        return k.b(this.namespace, appFunctionMetadataDocument.namespace) && k.b(this.id, appFunctionMetadataDocument.id) && this.isEnabledByDefault == appFunctionMetadataDocument.isEnabledByDefault && k.b(this.schemaCategory, appFunctionMetadataDocument.schemaCategory) && k.b(this.schemaName, appFunctionMetadataDocument.schemaName) && k.b(this.schemaVersion, appFunctionMetadataDocument.schemaVersion) && k.b(this.parameters, appFunctionMetadataDocument.parameters) && k.b(this.response, appFunctionMetadataDocument.response) && k.b(this.description, appFunctionMetadataDocument.description) && k.b(this.deprecation, appFunctionMetadataDocument.deprecation);
    }

    public final AppFunctionDeprecationMetadataDocument getDeprecation() {
        return this.deprecation;
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

    public final List<AppFunctionParameterMetadataDocument> getParameters() {
        return this.parameters;
    }

    public final AppFunctionResponseMetadataDocument getResponse() {
        return this.response;
    }

    public final String getSchemaCategory() {
        return this.schemaCategory;
    }

    public final String getSchemaName() {
        return this.schemaName;
    }

    public final Long getSchemaVersion() {
        return this.schemaVersion;
    }

    public int hashCode() {
        int iD = a.d(B7.a.c(this.namespace.hashCode() * 31, 31, this.id), 31, this.isEnabledByDefault);
        String str = this.schemaCategory;
        int iHashCode = (iD + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.schemaName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.schemaVersion;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        List<AppFunctionParameterMetadataDocument> list = this.parameters;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument = this.response;
        int iHashCode5 = (iHashCode4 + (appFunctionResponseMetadataDocument == null ? 0 : appFunctionResponseMetadataDocument.hashCode())) * 31;
        String str3 = this.description;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        AppFunctionDeprecationMetadataDocument appFunctionDeprecationMetadataDocument = this.deprecation;
        return iHashCode6 + (appFunctionDeprecationMetadataDocument != null ? appFunctionDeprecationMetadataDocument.hashCode() : 0);
    }

    public final boolean isEnabledByDefault() {
        return this.isEnabledByDefault;
    }

    public String toString() {
        return "AppFunctionMetadataDocument(namespace=" + this.namespace + ", id=" + this.id + ", isEnabledByDefault=" + this.isEnabledByDefault + ", schemaCategory=" + this.schemaCategory + ", schemaName=" + this.schemaName + ", schemaVersion=" + this.schemaVersion + ", parameters=" + this.parameters + ", response=" + this.response + ", description=" + this.description + ", deprecation=" + this.deprecation + ')';
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ AppFunctionMetadataDocument(java.lang.String r2, java.lang.String r3, boolean r4, java.lang.String r5, java.lang.String r6, java.lang.Long r7, java.util.List r8, androidx.appfunctions.metadata.AppFunctionResponseMetadataDocument r9, java.lang.String r10, androidx.appfunctions.metadata.AppFunctionDeprecationMetadataDocument r11, int r12, kotlin.jvm.internal.e r13) {
        /*
            r1 = this;
            r13 = r12 & 1
            if (r13 == 0) goto L6
            java.lang.String r2 = "appfunctions"
        L6:
            r13 = r12 & 2
            if (r13 == 0) goto Ld
            java.lang.String r3 = "unused"
        Ld:
            r13 = r12 & 256(0x100, float:3.59E-43)
            r0 = 0
            if (r13 == 0) goto L13
            r10 = r0
        L13:
            r12 = r12 & 512(0x200, float:7.17E-43)
            if (r12 == 0) goto L23
            r13 = r0
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L2e
        L23:
            r13 = r11
            r12 = r10
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L2e:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appfunctions.metadata.AppFunctionMetadataDocument.<init>(java.lang.String, java.lang.String, boolean, java.lang.String, java.lang.String, java.lang.Long, java.util.List, androidx.appfunctions.metadata.AppFunctionResponseMetadataDocument, java.lang.String, androidx.appfunctions.metadata.AppFunctionDeprecationMetadataDocument, int, kotlin.jvm.internal.e):void");
    }
}
