package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0012\u0010\nR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\nR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\nR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0005R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\b\u001a\u0004\b\u001a\u0010\nR$\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/b;", "", "", "isDownloadSupport", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "", "downloadExtra", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setDownloadExtra", "(Ljava/lang/String;)V", "antiHijackContent", "getAntiHijackContent", "antiHijackImage", "getAntiHijackImage", "iosAppId", "c", "iosBundleId", "d", "openGameUrl", "f", "hasGroupTask", "b", "unsupportedDownloadToast", "h", "", "relatedPkgNames", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/o;", "officialSamePackageTipsInfo", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/o;", "e", "()Lcom/bytedance/android/gamecp/business/gamedetail/base/model/o;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("anti_hijack_content")
    private final String antiHijackContent;

    @SerializedName("anti_hijack_image")
    private final String antiHijackImage;

    @SerializedName("download_extra")
    private String downloadExtra;

    @SerializedName("has_group_task")
    private final Boolean hasGroupTask;

    @SerializedName("ios_app_id")
    private final String iosAppId;

    @SerializedName("ios_bundle_id")
    private final String iosBundleId;

    @SerializedName("is_download_support")
    private final Boolean isDownloadSupport;

    @SerializedName("official_package_info")
    private final o officialSamePackageTipsInfo;

    @SerializedName("open_game_url")
    private final String openGameUrl;

    @SerializedName("related_pkg_names")
    private final List<String> relatedPkgNames;

    @SerializedName("unsupported_download_toast")
    private final String unsupportedDownloadToast;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L28;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.isDownloadSupport, r101.isDownloadSupport) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.downloadExtra, r101.downloadExtra) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.antiHijackContent, r101.antiHijackContent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.antiHijackImage, r101.antiHijackImage) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.iosAppId, r101.iosAppId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.iosBundleId, r101.iosBundleId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.openGameUrl, r101.openGameUrl) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.hasGroupTask, r101.hasGroupTask) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.unsupportedDownloadToast, r101.unsupportedDownloadToast) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.relatedPkgNames, r101.relatedPkgNames) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.officialSamePackageTipsInfo, r101.officialSamePackageTipsInfo) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        Boolean r100 = this.isDownloadSupport;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.downloadExtra;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.antiHijackContent;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.antiHijackImage;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.iosAppId;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.iosBundleId;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.openGameUrl;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.hasGroupTask;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.unsupportedDownloadToast;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        List<String> r128 = this.relatedPkgNames;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        o r131 = this.officialSamePackageTipsInfo;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommonDownloadInfo(isDownloadSupport=" + this.isDownloadSupport + ", downloadExtra=" + this.downloadExtra + ", antiHijackContent=" + this.antiHijackContent + ", antiHijackImage=" + this.antiHijackImage + ", iosAppId=" + this.iosAppId + ", iosBundleId=" + this.iosBundleId + ", openGameUrl=" + this.openGameUrl + ", hasGroupTask=" + this.hasGroupTask + ", unsupportedDownloadToast=" + this.unsupportedDownloadToast + ", relatedPkgNames=" + this.relatedPkgNames + ", officialSamePackageTipsInfo=" + this.officialSamePackageTipsInfo + ")";
    }

    public b() {
        this.isDownloadSupport = null;
        this.downloadExtra = "";
        this.antiHijackContent = "";
        this.antiHijackImage = "";
        this.iosAppId = "";
        this.iosBundleId = "";
        this.openGameUrl = "";
        this.hasGroupTask = null;
        this.unsupportedDownloadToast = "";
        this.relatedPkgNames = null;
        this.officialSamePackageTipsInfo = null;
    }

    public final String a() {
        return this.downloadExtra;
    }

    public final Boolean b() {
        return this.hasGroupTask;
    }

    public final String c() {
        return this.iosAppId;
    }

    public final String d() {
        return this.iosBundleId;
    }

    public final o e() {
        return this.officialSamePackageTipsInfo;
    }

    public final String f() {
        return this.openGameUrl;
    }

    public final List<String> g() {
        return this.relatedPkgNames;
    }

    public final String h() {
        return this.unsupportedDownloadToast;
    }
}
