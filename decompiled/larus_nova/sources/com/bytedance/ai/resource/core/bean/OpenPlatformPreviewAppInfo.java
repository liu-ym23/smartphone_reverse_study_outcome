package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\rHÆ\u0003Jn\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfo;", "", b.f276376z, "", "appName", "iconUrl", "defaultEnabled", "", "testVersions", "", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersion;", "auditVersions", "formalVersions", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersionPage;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersionPage;)V", "getAppKey", "()Ljava/lang/String;", "getAppName", "getIconUrl", "getDefaultEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTestVersions", "()Ljava/util/List;", "getAuditVersions", "getFormalVersions", "()Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersionPage;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewVersionPage;)Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfo;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformPreviewAppInfo {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("app_name")
    private final String appName;

    @SerializedName("audit_versions")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformPreviewVersion> auditVersions;

    @SerializedName("default_enabled")
    private final Boolean defaultEnabled;

    @SerializedName("formal_versions")
    private final OpenPlatformPreviewVersionPage formalVersions;

    @SerializedName("icon_url")
    private final String iconUrl;

    @SerializedName("test_versions")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<OpenPlatformPreviewVersion> testVersions;

    public OpenPlatformPreviewAppInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformPreviewAppInfo copy$default(OpenPlatformPreviewAppInfo r100, String r101, String r102, String r103, Boolean r104, List r110, List r111, OpenPlatformPreviewVersionPage r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.appKey;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.appName;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.iconUrl;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.defaultEnabled;
    L14:
        Boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.testVersions;
    L17:
        List r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.auditVersions;
    L20:
        List r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.formalVersions;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.appKey;
    }

    public final String component2() {
        return this.appName;
    }

    public final String component3() {
        return this.iconUrl;
    }

    public final Boolean component4() {
        return this.defaultEnabled;
    }

    public final List<OpenPlatformPreviewVersion> component5() {
        return this.testVersions;
    }

    public final List<OpenPlatformPreviewVersion> component6() {
        return this.auditVersions;
    }

    public final OpenPlatformPreviewVersionPage component7() {
        return this.formalVersions;
    }

    public final OpenPlatformPreviewAppInfo copy(String r110, String r111, String r112, Boolean r113, List<OpenPlatformPreviewVersion> r114, List<OpenPlatformPreviewVersion> r115, OpenPlatformPreviewVersionPage r116) {
        return new OpenPlatformPreviewAppInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenPlatformPreviewAppInfo) == true) goto L8;
        return false;
    L8:
        OpenPlatformPreviewAppInfo r101 = (OpenPlatformPreviewAppInfo) r100;
        if (Intrinsics.areEqual(this.appKey, r101.appKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appName, r101.appName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.iconUrl, r101.iconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.defaultEnabled, r101.defaultEnabled) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.testVersions, r101.testVersions) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.auditVersions, r101.auditVersions) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.formalVersions, r101.formalVersions) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.appKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.appName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.iconUrl;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.defaultEnabled;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<OpenPlatformPreviewVersion> r113 = this.testVersions;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<OpenPlatformPreviewVersion> r116 = this.auditVersions;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        OpenPlatformPreviewVersionPage r119 = this.formalVersions;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "OpenPlatformPreviewAppInfo(appKey=" + this.appKey + ", appName=" + this.appName + ", iconUrl=" + this.iconUrl + ", defaultEnabled=" + this.defaultEnabled + ", testVersions=" + this.testVersions + ", auditVersions=" + this.auditVersions + ", formalVersions=" + this.formalVersions + ')';
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final List<OpenPlatformPreviewVersion> getAuditVersions() {
        return this.auditVersions;
    }

    public final Boolean getDefaultEnabled() {
        return this.defaultEnabled;
    }

    public final OpenPlatformPreviewVersionPage getFormalVersions() {
        return this.formalVersions;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final List<OpenPlatformPreviewVersion> getTestVersions() {
        return this.testVersions;
    }

    public OpenPlatformPreviewAppInfo(String r100, String r101, String r102, Boolean r103, List<OpenPlatformPreviewVersion> r104, List<OpenPlatformPreviewVersion> r105, OpenPlatformPreviewVersionPage r106) {
        this.appKey = r100;
        this.appName = r101;
        this.iconUrl = r102;
        this.defaultEnabled = r103;
        this.testVersions = r104;
        this.auditVersions = r105;
        this.formalVersions = r106;
    }

    public /* synthetic */ OpenPlatformPreviewAppInfo(String r100, String r101, String r102, Boolean r110, List r111, List r112, OpenPlatformPreviewVersionPage r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        Boolean r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        r111 = CollectionsKt.emptyList();
    L21:
        List r106 = r111;
        if ((r114 & 32) == 0) goto L24;
        r112 = CollectionsKt.emptyList();
    L24:
        List r107 = r112;
        if ((r114 & 64) == 0) goto L27;
        OpenPlatformPreviewVersionPage r117 = null;
    L28:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L27:
        r117 = r113;
        goto L28
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
