package com.bytedance.ai.resource.core.bean;

import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bc\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\"Jj\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u00065"}, d2 = {"Lcom/bytedance/ai/resource/core/bean/AIPackageResponseItem;", "", "appId", "", "packageName", RuleConditionBean.VERSION_CODE_KEY, "digest", "resourceUrl", "resourceUrls", "", "signaturePublicKeyVersion", "verifySignature", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "getPackageName", "setPackageName", "getVersionCode", "setVersionCode", "getDigest", "setDigest", "getResourceUrl", "setResourceUrl", "getResourceUrls", "()Ljava/util/List;", "setResourceUrls", "(Ljava/util/List;)V", "getSignaturePublicKeyVersion", "setSignaturePublicKeyVersion", "getVerifySignature", "()Ljava/lang/Boolean;", "setVerifySignature", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/ai/resource/core/bean/AIPackageResponseItem;", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIPackageResponseItem {
    private String appId;
    private String digest;
    private String packageName;
    private String resourceUrl;
    private List<String> resourceUrls;
    private String signaturePublicKeyVersion;
    private Boolean verifySignature;
    private String versionCode;

    public AIPackageResponseItem() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIPackageResponseItem copy$default(AIPackageResponseItem r100, String r110, String r111, String r112, String r113, String r114, List r115, String r116, Boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.appId;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.packageName;
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = r100.versionCode;
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = r100.digest;
    L19:
        if ((r118 & 16) == 0) goto L21;
        String r105 = r100.resourceUrl;
    L23:
        if ((r118 & 32) == 0) goto L25;
        List r106 = r100.resourceUrls;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.signaturePublicKeyVersion;
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
        return this.appId;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.versionCode;
    }

    public final String component4() {
        return this.digest;
    }

    public final String component5() {
        return this.resourceUrl;
    }

    public final List<String> component6() {
        return this.resourceUrls;
    }

    public final String component7() {
        return this.signaturePublicKeyVersion;
    }

    public final Boolean component8() {
        return this.verifySignature;
    }

    public final AIPackageResponseItem copy(String r110, String r111, String r112, String r113, String r114, List<String> r115, String r116, Boolean r117) {
        Intrinsics.checkNotNullParameter(r110, "appId");
        Intrinsics.checkNotNullParameter(r111, "packageName");
        Intrinsics.checkNotNullParameter(r112, RuleConditionBean.VERSION_CODE_KEY);
        Intrinsics.checkNotNullParameter(r113, "digest");
        Intrinsics.checkNotNullParameter(r114, "resourceUrl");
        return new AIPackageResponseItem(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIPackageResponseItem) == true) goto L8;
        return false;
    L8:
        AIPackageResponseItem r101 = (AIPackageResponseItem) r100;
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r101.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.versionCode, r101.versionCode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.digest, r101.digest) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.resourceUrl, r101.resourceUrl) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.resourceUrls, r101.resourceUrls) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.signaturePublicKeyVersion, r101.signaturePublicKeyVersion) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.verifySignature, r101.verifySignature) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((this.appId.hashCode() * 31) + this.packageName.hashCode()) * 31) + this.versionCode.hashCode()) * 31) + this.digest.hashCode()) * 31) + this.resourceUrl.hashCode()) * 31;
        List<String> r101 = this.resourceUrls;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.signaturePublicKeyVersion;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Boolean r108 = this.verifySignature;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "AIPackageResponseItem(appId=" + this.appId + ", packageName=" + this.packageName + ", versionCode=" + this.versionCode + ", digest=" + this.digest + ", resourceUrl=" + this.resourceUrl + ", resourceUrls=" + this.resourceUrls + ", signaturePublicKeyVersion=" + this.signaturePublicKeyVersion + ", verifySignature=" + this.verifySignature + ')';
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

    public final String getSignaturePublicKeyVersion() {
        return this.signaturePublicKeyVersion;
    }

    public final Boolean getVerifySignature() {
        return this.verifySignature;
    }

    public final String getVersionCode() {
        return this.versionCode;
    }

    public final void setAppId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.appId = r100;
    }

    public final void setDigest(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.digest = r100;
    }

    public final void setPackageName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.packageName = r100;
    }

    public final void setResourceUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resourceUrl = r100;
    }

    public final void setResourceUrls(List<String> r100) {
        this.resourceUrls = r100;
    }

    public final void setSignaturePublicKeyVersion(String r100) {
        this.signaturePublicKeyVersion = r100;
    }

    public final void setVerifySignature(Boolean r100) {
        this.verifySignature = r100;
    }

    public final void setVersionCode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.versionCode = r100;
    }

    public AIPackageResponseItem(String r100, String r101, String r102, String r103, String r104, List<String> r105, String r106, Boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "packageName");
        Intrinsics.checkNotNullParameter(r102, RuleConditionBean.VERSION_CODE_KEY);
        Intrinsics.checkNotNullParameter(r103, "digest");
        Intrinsics.checkNotNullParameter(r104, "resourceUrl");
        this.appId = r100;
        this.packageName = r101;
        this.versionCode = r102;
        this.digest = r103;
        this.resourceUrl = r104;
        this.resourceUrls = r105;
        this.signaturePublicKeyVersion = r106;
        this.verifySignature = r107;
    }

    public /* synthetic */ AIPackageResponseItem(String r110, String r111, String r112, String r113, String r114, List r115, String r116, Boolean r117, int r118, DefaultConstructorMarker r119) {
        String r100 = "";
        if ((r118 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r118 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r118 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r118 & 16) != 0) goto L22;
        r100 = r114;
    L22:
        String r105 = null;
        if ((r118 & 32) == 0) goto L25;
        List r106 = null;
    L27:
        if ((r118 & 64) != 0) goto L31;
        r105 = r116;
    L31:
        if ((r118 & 128) == 0) goto L33;
        Boolean r107 = Boolean.FALSE;
    L34:
        this(r101, r102, r103, r104, r100, r106, r105, r107);
        return;
    L33:
        r107 = r117;
        goto L34
    L25:
        r106 = r115;
        goto L27
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
