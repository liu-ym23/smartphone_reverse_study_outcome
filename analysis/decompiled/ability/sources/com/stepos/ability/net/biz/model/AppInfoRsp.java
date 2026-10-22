package com.stepos.ability.net.biz.model;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ju\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010¨\u0006+"}, d2 = {"Lcom/stepos/ability/net/biz/model/AppInfoRsp;", "", "appName", "", "appVersion", "description", AgentBusWakeContract.EXTRA_SOURCE, "packageName", "signature", "icon", "mcpUrl", "mcpTag", "mcpType", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "getAppVersion", "getDescription", "getSource", "getPackageName", "getSignature", "getIcon", "getMcpUrl", "getMcpTag", "getMcpType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppInfoRsp {
    private final String appName;
    private final String appVersion;
    private final String description;
    private final String icon;
    private final String mcpTag;
    private final String mcpType;
    private final String mcpUrl;
    private final String packageName;
    private final String signature;
    private final String source;

    public AppInfoRsp(String appName, String appVersion, String description, String source, String packageName, String signature, String str, String str2, String str3, String str4) {
        k.f(appName, "appName");
        k.f(appVersion, "appVersion");
        k.f(description, "description");
        k.f(source, "source");
        k.f(packageName, "packageName");
        k.f(signature, "signature");
        this.appName = appName;
        this.appVersion = appVersion;
        this.description = description;
        this.source = source;
        this.packageName = packageName;
        this.signature = signature;
        this.icon = str;
        this.mcpUrl = str2;
        this.mcpTag = str3;
        this.mcpType = str4;
    }

    public static /* synthetic */ AppInfoRsp copy$default(AppInfoRsp appInfoRsp, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appInfoRsp.appName;
        }
        if ((i & 2) != 0) {
            str2 = appInfoRsp.appVersion;
        }
        if ((i & 4) != 0) {
            str3 = appInfoRsp.description;
        }
        if ((i & 8) != 0) {
            str4 = appInfoRsp.source;
        }
        if ((i & 16) != 0) {
            str5 = appInfoRsp.packageName;
        }
        if ((i & 32) != 0) {
            str6 = appInfoRsp.signature;
        }
        if ((i & 64) != 0) {
            str7 = appInfoRsp.icon;
        }
        if ((i & 128) != 0) {
            str8 = appInfoRsp.mcpUrl;
        }
        if ((i & 256) != 0) {
            str9 = appInfoRsp.mcpTag;
        }
        if ((i & 512) != 0) {
            str10 = appInfoRsp.mcpType;
        }
        String str11 = str9;
        String str12 = str10;
        String str13 = str7;
        String str14 = str8;
        String str15 = str5;
        String str16 = str6;
        return appInfoRsp.copy(str, str2, str3, str4, str15, str16, str13, str14, str11, str12);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component10, reason: from getter */
    public final String getMcpType() {
        return this.mcpType;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSource() {
        return this.source;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    /* renamed from: component7, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component8, reason: from getter */
    public final String getMcpUrl() {
        return this.mcpUrl;
    }

    /* renamed from: component9, reason: from getter */
    public final String getMcpTag() {
        return this.mcpTag;
    }

    public final AppInfoRsp copy(String appName, String appVersion, String description, String source, String packageName, String signature, String icon, String mcpUrl, String mcpTag, String mcpType) {
        k.f(appName, "appName");
        k.f(appVersion, "appVersion");
        k.f(description, "description");
        k.f(source, "source");
        k.f(packageName, "packageName");
        k.f(signature, "signature");
        return new AppInfoRsp(appName, appVersion, description, source, packageName, signature, icon, mcpUrl, mcpTag, mcpType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppInfoRsp)) {
            return false;
        }
        AppInfoRsp appInfoRsp = (AppInfoRsp) other;
        return k.b(this.appName, appInfoRsp.appName) && k.b(this.appVersion, appInfoRsp.appVersion) && k.b(this.description, appInfoRsp.description) && k.b(this.source, appInfoRsp.source) && k.b(this.packageName, appInfoRsp.packageName) && k.b(this.signature, appInfoRsp.signature) && k.b(this.icon, appInfoRsp.icon) && k.b(this.mcpUrl, appInfoRsp.mcpUrl) && k.b(this.mcpTag, appInfoRsp.mcpTag) && k.b(this.mcpType, appInfoRsp.mcpType);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getMcpTag() {
        return this.mcpTag;
    }

    public final String getMcpType() {
        return this.mcpType;
    }

    public final String getMcpUrl() {
        return this.mcpUrl;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final String getSource() {
        return this.source;
    }

    public int hashCode() {
        int iC = a.c(a.c(a.c(a.c(a.c(this.appName.hashCode() * 31, 31, this.appVersion), 31, this.description), 31, this.source), 31, this.packageName), 31, this.signature);
        String str = this.icon;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.mcpUrl;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mcpTag;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.mcpType;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        String str = this.appName;
        String str2 = this.appVersion;
        String str3 = this.description;
        String str4 = this.source;
        String str5 = this.packageName;
        String str6 = this.signature;
        String str7 = this.icon;
        String str8 = this.mcpUrl;
        String str9 = this.mcpTag;
        String str10 = this.mcpType;
        StringBuilder sbW = a.w("AppInfoRsp(appName=", str, ", appVersion=", str2, ", description=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", source=", str4, ", packageName=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str5, ", signature=", str6, ", icon=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str7, ", mcpUrl=", str8, ", mcpTag=");
        return androidx.appfunctions.metadata.a.p(sbW, str9, ", mcpType=", str10, ")");
    }
}
