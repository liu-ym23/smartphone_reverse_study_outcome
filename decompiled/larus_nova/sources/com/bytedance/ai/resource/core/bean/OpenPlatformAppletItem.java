package com.bytedance.ai.resource.core.bean;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019Jt\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/OpenPlatformAppletItem;", "", RuleConditionBean.VERSION_CODE_KEY, "", "appId", "packageName", "resourceUrls", "", "resourceUrl", "digest", "aid", "verifySignature", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getVersionCode", "()Ljava/lang/String;", "getAppId", "getPackageName", "getResourceUrls", "()Ljava/util/List;", "getResourceUrl", "getDigest", "getAid", "getVerifySignature", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/ai/resource/core/bean/OpenPlatformAppletItem;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPlatformAppletItem {

    @SerializedName("parent_applet_id")
    private final String aid;

    @SerializedName("resource_id")
    private final String appId;
    private final String digest;

    @SerializedName("package_name")
    private final String packageName;

    @SerializedName("download_url")
    private final String resourceUrl;

    @SerializedName("download_url_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> resourceUrls;

    @SerializedName("sign_verify_switch")
    private final Boolean verifySignature;

    @SerializedName("applet_version_code")
    private final String versionCode;

    public OpenPlatformAppletItem() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPlatformAppletItem copy$default(OpenPlatformAppletItem r100, String r110, String r111, String r112, List r113, String r114, String r115, String r116, Boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.versionCode;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.appId;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.packageName;
    L15:
        if ((r118 & 8) == 0) goto L17;
        List r104 = r100.resourceUrls;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.resourceUrl;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = r100.digest;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.aid;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Boolean r108 = r100.verifySignature;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.versionCode;
    }

    public final String component2() {
        return this.appId;
    }

    public final String component3() {
        return this.packageName;
    }

    public final List<String> component4() {
        return this.resourceUrls;
    }

    public final String component5() {
        return this.resourceUrl;
    }

    public final String component6() {
        return this.digest;
    }

    public final String component7() {
        return this.aid;
    }

    public final Boolean component8() {
        return this.verifySignature;
    }

    public final OpenPlatformAppletItem copy(String r110, String r111, String r112, List<String> r113, String r114, String r115, String r116, Boolean r117) {
        return new OpenPlatformAppletItem(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenPlatformAppletItem) == true) goto L8;
        return false;
    L8:
        OpenPlatformAppletItem r101 = (OpenPlatformAppletItem) r100;
        if (Intrinsics.areEqual(this.versionCode, r101.versionCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.resourceUrls, r101.resourceUrls) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.resourceUrl, r101.resourceUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.digest, r101.digest) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.aid, r101.aid) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.verifySignature, r101.verifySignature) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.versionCode;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.appId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.packageName;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.resourceUrls;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.resourceUrl;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.digest;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.aid;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.verifySignature;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
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
        return "OpenPlatformAppletItem(versionCode=" + this.versionCode + ", appId=" + this.appId + ", packageName=" + this.packageName + ", resourceUrls=" + this.resourceUrls + ", resourceUrl=" + this.resourceUrl + ", digest=" + this.digest + ", aid=" + this.aid + ", verifySignature=" + this.verifySignature + ')';
    }

    public final String getAid() {
        return this.aid;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDigest() {
        return this.digest;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getResourceUrl() {
        return this.resourceUrl;
    }

    public final List<String> getResourceUrls() {
        return this.resourceUrls;
    }

    public final Boolean getVerifySignature() {
        return this.verifySignature;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public OpenPlatformAppletItem(String r100, String r101, String r102, List<String> r103, String r104, String r105, String r106, Boolean r107) {
        this.versionCode = r100;
        this.appId = r101;
        this.packageName = r102;
        this.resourceUrls = r103;
        this.resourceUrl = r104;
        this.digest = r105;
        this.aid = r106;
        this.verifySignature = r107;
    }

    public /* synthetic */ OpenPlatformAppletItem(String r110, String r111, String r112, List r113, String r114, String r115, String r116, Boolean r117, int r118, DefaultConstructorMarker r119) {
        Boolean r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        List r104 = CollectionsKt.emptyList();
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
