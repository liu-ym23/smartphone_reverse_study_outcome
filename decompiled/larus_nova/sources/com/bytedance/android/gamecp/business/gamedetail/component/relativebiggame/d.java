package com.bytedance.android.gamecp.business.gamedetail.component.relativebiggame;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/relativebiggame/d;", "", "", "antiHijackContent", "Ljava/lang/String;", "getAntiHijackContent", "()Ljava/lang/String;", "antiHijackImage", "getAntiHijackImage", "downloadExtra", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "hasGroupTask", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "id", "getId", "name", "getName", "isDownloadSupport", "packageSizeSwitch", "c", "", "supportPlatform", "Ljava/lang/Long;", "d", "()Ljava/lang/Long;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("anti_hijack_content")
    private final String antiHijackContent;

    @SerializedName("anti_hijack_image")
    private final String antiHijackImage;

    @SerializedName("download_extra")
    private final String downloadExtra;

    @SerializedName("has_group_task")
    private final Boolean hasGroupTask;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f54906id;

    @SerializedName("is_download_support")
    private final Boolean isDownloadSupport;

    @SerializedName("name")
    private final String name;

    @SerializedName("package_size_switch")
    private final Boolean packageSizeSwitch;

    @SerializedName("support_platforms")
    private final Long supportPlatform;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L24;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.antiHijackContent, r101.antiHijackContent) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.antiHijackImage, r101.antiHijackImage) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.downloadExtra, r101.downloadExtra) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.hasGroupTask, r101.hasGroupTask) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f54906id, r101.f54906id) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.isDownloadSupport, r101.isDownloadSupport) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.packageSizeSwitch, r101.packageSizeSwitch) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.supportPlatform, r101.supportPlatform) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        String r100 = this.antiHijackContent;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.antiHijackImage;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.downloadExtra;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.hasGroupTask;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f54906id;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.name;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Boolean r119 = this.isDownloadSupport;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.packageSizeSwitch;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.supportPlatform;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
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
        return "RelativeBigGameDownloadInfo(antiHijackContent=" + this.antiHijackContent + ", antiHijackImage=" + this.antiHijackImage + ", downloadExtra=" + this.downloadExtra + ", hasGroupTask=" + this.hasGroupTask + ", id=" + this.f54906id + ", name=" + this.name + ", isDownloadSupport=" + this.isDownloadSupport + ", packageSizeSwitch=" + this.packageSizeSwitch + ", supportPlatform=" + this.supportPlatform + ")";
    }

    public d() {
        this.antiHijackContent = "";
        this.antiHijackImage = "";
        this.downloadExtra = "";
        this.hasGroupTask = null;
        this.f54906id = "";
        this.name = "";
        this.isDownloadSupport = null;
        this.packageSizeSwitch = null;
        this.supportPlatform = 0L;
    }

    public final String a() {
        return this.downloadExtra;
    }

    public final Boolean b() {
        return this.hasGroupTask;
    }

    public final Boolean c() {
        return this.packageSizeSwitch;
    }

    public final Long d() {
        return this.supportPlatform;
    }
}
