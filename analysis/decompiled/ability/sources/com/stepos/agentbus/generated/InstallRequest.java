package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003JU\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006#"}, d2 = {"Lcom/stepos/agentbus/generated/InstallRequest;", "", "id", "", "version", "blobRef", AgentBusWakeContract.EXTRA_SOURCE, "Lcom/stepos/agentbus/generated/InstallSource;", GuiTaskProgressKt.GuiTaskProgress_KEY_EXTRAS, "", "catalogDescription", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentbus/generated/InstallSource;Ljava/util/Map;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getVersion", "getBlobRef", "getSource", "()Lcom/stepos/agentbus/generated/InstallSource;", "getExtras", "()Ljava/util/Map;", "getCatalogDescription", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class InstallRequest {
    private final String blobRef;
    private final String catalogDescription;
    private final Map<String, Object> extras;
    private final String id;
    private final InstallSource source;
    private final String version;

    public InstallRequest(String id, String version, String blobRef, InstallSource source, Map<String, ? extends Object> extras, String str) {
        k.f(id, "id");
        k.f(version, "version");
        k.f(blobRef, "blobRef");
        k.f(source, "source");
        k.f(extras, "extras");
        this.id = id;
        this.version = version;
        this.blobRef = blobRef;
        this.source = source;
        this.extras = extras;
        this.catalogDescription = str;
    }

    public static /* synthetic */ InstallRequest copy$default(InstallRequest installRequest, String str, String str2, String str3, InstallSource installSource, Map map, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = installRequest.id;
        }
        if ((i & 2) != 0) {
            str2 = installRequest.version;
        }
        if ((i & 4) != 0) {
            str3 = installRequest.blobRef;
        }
        if ((i & 8) != 0) {
            installSource = installRequest.source;
        }
        if ((i & 16) != 0) {
            map = installRequest.extras;
        }
        if ((i & 32) != 0) {
            str4 = installRequest.catalogDescription;
        }
        Map map2 = map;
        String str5 = str4;
        return installRequest.copy(str, str2, str3, installSource, map2, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBlobRef() {
        return this.blobRef;
    }

    /* renamed from: component4, reason: from getter */
    public final InstallSource getSource() {
        return this.source;
    }

    public final Map<String, Object> component5() {
        return this.extras;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCatalogDescription() {
        return this.catalogDescription;
    }

    public final InstallRequest copy(String id, String version, String blobRef, InstallSource source, Map<String, ? extends Object> extras, String catalogDescription) {
        k.f(id, "id");
        k.f(version, "version");
        k.f(blobRef, "blobRef");
        k.f(source, "source");
        k.f(extras, "extras");
        return new InstallRequest(id, version, blobRef, source, extras, catalogDescription);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstallRequest)) {
            return false;
        }
        InstallRequest installRequest = (InstallRequest) other;
        return k.b(this.id, installRequest.id) && k.b(this.version, installRequest.version) && k.b(this.blobRef, installRequest.blobRef) && this.source == installRequest.source && k.b(this.extras, installRequest.extras) && k.b(this.catalogDescription, installRequest.catalogDescription);
    }

    public final String getBlobRef() {
        return this.blobRef;
    }

    public final String getCatalogDescription() {
        return this.catalogDescription;
    }

    public final Map<String, Object> getExtras() {
        return this.extras;
    }

    public final String getId() {
        return this.id;
    }

    public final InstallSource getSource() {
        return this.source;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int iF = androidx.appfunctions.metadata.a.f(this.extras, (this.source.hashCode() + B7.a.c(B7.a.c(this.id.hashCode() * 31, 31, this.version), 31, this.blobRef)) * 31, 31);
        String str = this.catalogDescription;
        return iF + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.id;
        String str2 = this.version;
        String str3 = this.blobRef;
        InstallSource installSource = this.source;
        Map<String, Object> map = this.extras;
        String str4 = this.catalogDescription;
        StringBuilder sbW = B7.a.w("InstallRequest(id=", str, ", version=", str2, ", blobRef=");
        sbW.append(str3);
        sbW.append(", source=");
        sbW.append(installSource);
        sbW.append(", extras=");
        sbW.append(map);
        sbW.append(", catalogDescription=");
        sbW.append(str4);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ InstallRequest(String str, String str2, String str3, InstallSource installSource, Map map, String str4, int i, e eVar) {
        this(str, str2, str3, (i & 8) != 0 ? InstallSource.LOCAL : installSource, (i & 16) != 0 ? kotlin.collections.a.M() : map, (i & 32) != 0 ? null : str4);
    }
}
