package com.stepos.ability.net.biz.model;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010&\u001a\u00020\u0003H\u0016J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u00103\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J®\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006:"}, d2 = {"Lcom/stepos/ability/net/biz/model/AppItem;", "", "appName", "", "appVersion", "appDesc", "appSource", "packageName", "appId", "", "authType", "signature", "icon", "mcpUrl", "mcpTag", "mcpType", "tools", "", "Lcom/stepos/ability/net/biz/model/ToolItem;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAppName", "()Ljava/lang/String;", "getAppVersion", "getAppDesc", "getAppSource", "getPackageName", "getAppId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAuthType", "getSignature", "getIcon", "getMcpUrl", "getMcpTag", "getMcpType", "getTools", "()Ljava/util/List;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/stepos/ability/net/biz/model/AppItem;", "equals", "", "other", "hashCode", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppItem {

    @SerializedName("appDesc")
    private final String appDesc;

    @SerializedName("appId")
    private final Integer appId;

    @SerializedName("appName")
    private final String appName;

    @SerializedName("appSource")
    private final String appSource;

    @SerializedName("appVersion")
    private final String appVersion;

    @SerializedName("authType")
    private final String authType;

    @SerializedName("icon")
    private final String icon;

    @SerializedName("mcpTag")
    private final String mcpTag;

    @SerializedName("mcpType")
    private final String mcpType;

    @SerializedName("mcpUrl")
    private final String mcpUrl;

    @SerializedName("packageName")
    private final String packageName;

    @SerializedName("signature")
    private final String signature;

    @SerializedName("tools")
    private final List<ToolItem> tools;

    public AppItem(String appName, String str, String str2, String str3, String str4, Integer num, String str5, String str6, String str7, String str8, String str9, String str10, List<ToolItem> list) {
        k.f(appName, "appName");
        this.appName = appName;
        this.appVersion = str;
        this.appDesc = str2;
        this.appSource = str3;
        this.packageName = str4;
        this.appId = num;
        this.authType = str5;
        this.signature = str6;
        this.icon = str7;
        this.mcpUrl = str8;
        this.mcpTag = str9;
        this.mcpType = str10;
        this.tools = list;
    }

    public static /* synthetic */ AppItem copy$default(AppItem appItem, String str, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, String str8, String str9, String str10, String str11, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = appItem.appName;
        }
        return appItem.copy(str, (i & 2) != 0 ? appItem.appVersion : str2, (i & 4) != 0 ? appItem.appDesc : str3, (i & 8) != 0 ? appItem.appSource : str4, (i & 16) != 0 ? appItem.packageName : str5, (i & 32) != 0 ? appItem.appId : num, (i & 64) != 0 ? appItem.authType : str6, (i & 128) != 0 ? appItem.signature : str7, (i & 256) != 0 ? appItem.icon : str8, (i & 512) != 0 ? appItem.mcpUrl : str9, (i & 1024) != 0 ? appItem.mcpTag : str10, (i & 2048) != 0 ? appItem.mcpType : str11, (i & 4096) != 0 ? appItem.tools : list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component10, reason: from getter */
    public final String getMcpUrl() {
        return this.mcpUrl;
    }

    /* renamed from: component11, reason: from getter */
    public final String getMcpTag() {
        return this.mcpTag;
    }

    /* renamed from: component12, reason: from getter */
    public final String getMcpType() {
        return this.mcpType;
    }

    public final List<ToolItem> component13() {
        return this.tools;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAppDesc() {
        return this.appDesc;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAppSource() {
        return this.appSource;
    }

    /* renamed from: component5, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getAppId() {
        return this.appId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getAuthType() {
        return this.authType;
    }

    /* renamed from: component8, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    /* renamed from: component9, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    public final AppItem copy(String appName, String appVersion, String appDesc, String appSource, String packageName, Integer appId, String authType, String signature, String icon, String mcpUrl, String mcpTag, String mcpType, List<ToolItem> tools) {
        k.f(appName, "appName");
        return new AppItem(appName, appVersion, appDesc, appSource, packageName, appId, authType, signature, icon, mcpUrl, mcpTag, mcpType, tools);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppItem)) {
            return false;
        }
        AppItem appItem = (AppItem) other;
        return k.b(this.appName, appItem.appName) && k.b(this.appVersion, appItem.appVersion) && k.b(this.appDesc, appItem.appDesc) && k.b(this.appSource, appItem.appSource) && k.b(this.packageName, appItem.packageName) && k.b(this.appId, appItem.appId) && k.b(this.authType, appItem.authType) && k.b(this.signature, appItem.signature) && k.b(this.icon, appItem.icon) && k.b(this.mcpUrl, appItem.mcpUrl) && k.b(this.mcpTag, appItem.mcpTag) && k.b(this.mcpType, appItem.mcpType) && k.b(this.tools, appItem.tools);
    }

    public final String getAppDesc() {
        return this.appDesc;
    }

    public final Integer getAppId() {
        return this.appId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppSource() {
        return this.appSource;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getAuthType() {
        return this.authType;
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

    public final List<ToolItem> getTools() {
        return this.tools;
    }

    public int hashCode() {
        int iHashCode = this.appName.hashCode() * 31;
        String str = this.appVersion;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.appDesc;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.appSource;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.packageName;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.appId;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        String str5 = this.authType;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.signature;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.icon;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.mcpUrl;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.mcpTag;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.mcpType;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        List<ToolItem> list = this.tools;
        return iHashCode12 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        String str = this.appName;
        String str2 = this.appVersion;
        String str3 = this.packageName;
        List<ToolItem> list = this.tools;
        int size = list != null ? list.size() : 0;
        StringBuilder sbW = a.w("AppItem(appName=", str, ", appVersion=", str2, ", packageName=");
        sbW.append(str3);
        sbW.append(", toolCount=");
        sbW.append(size);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ AppItem(String str, String str2, String str3, String str4, String str5, Integer num, String str6, String str7, String str8, String str9, String str10, String str11, List list, int i, e eVar) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, str5, (i & 32) != 0 ? null : num, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & 2048) != 0 ? null : str11, (i & 4096) != 0 ? null : list);
    }
}
