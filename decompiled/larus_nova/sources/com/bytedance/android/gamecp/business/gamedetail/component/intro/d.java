package com.bytedance.android.gamecp.business.gamedetail.component.intro;

import com.bytedance.android.gamecp.business.gamedetail.base.model.u;
import com.bytedance.android.gamecp.business.h;
import com.bytedance.android.gamecp.business.j;
import com.bytedance.android.gamecp.host_api.model.GameImageBundler;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R6\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010\"\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000e\"\u0004\b$\u0010\u0010R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R*\u0010-\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\f\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010\u0010R$\u00100\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010'\u001a\u0004\b1\u0010)\"\u0004\b2\u0010+R$\u00103\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010'\u001a\u0004\b4\u0010)\"\u0004\b5\u0010+¨\u00066"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/intro/d;", "", "", "downloadStatus", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "setDownloadStatus", "(Ljava/lang/Long;)V", "", "Lcom/bytedance/android/gamecp/business/gamedetail/component/intro/f;", "images", "Ljava/util/List;", "f", "()Ljava/util/List;", "setImages", "(Ljava/util/List;)V", "Ljava/util/ArrayList;", "Lcom/bytedance/android/gamecp/business/gamedetail/base/model/u;", "Lkotlin/collections/ArrayList;", "videoList", "Ljava/util/ArrayList;", "getVideoList", "()Ljava/util/ArrayList;", "setVideoList", "(Ljava/util/ArrayList;)V", "Lcom/bytedance/android/gamecp/business/h;", "evaluationVideoList", "Lcom/bytedance/android/gamecp/business/h;", "c", "()Lcom/bytedance/android/gamecp/business/h;", "setEvaluationVideoList", "(Lcom/bytedance/android/gamecp/business/h;)V", "Lcom/bytedance/android/gamecp/business/j;", "gameAwardList", "d", "setGameAwardList", "", "showBusinessInfo", "Ljava/lang/Boolean;", "getShowBusinessInfo", "()Ljava/lang/Boolean;", "setShowBusinessInfo", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/android/gamecp/host_api/model/GameImageBundler;", "gameImages", "e", "setGameImages", "complianceElementsVisible", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setComplianceElementsVisible", "onlineTimeVisible", "getOnlineTimeVisible", "setOnlineTimeVisible", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("compliance_elements_visible")
    private Boolean complianceElementsVisible;

    @SerializedName("download_status")
    private Long downloadStatus;

    @SerializedName("evaluation_video_list")
    private h evaluationVideoList;

    @SerializedName("game_award_list")
    private List<j> gameAwardList;

    @SerializedName("game_images")
    private List<GameImageBundler> gameImages;

    @SerializedName("images")
    private List<f> images;

    @SerializedName("online_time_visible")
    private Boolean onlineTimeVisible;

    @SerializedName("show_business_info")
    private Boolean showBusinessInfo;

    @SerializedName("videos")
    private ArrayList<u> videoList;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L24;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.downloadStatus, r101.downloadStatus) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.images, r101.images) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.videoList, r101.videoList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.evaluationVideoList, r101.evaluationVideoList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.gameAwardList, r101.gameAwardList) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.showBusinessInfo, r101.showBusinessInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.gameImages, r101.gameImages) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.complianceElementsVisible, r101.complianceElementsVisible) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.onlineTimeVisible, r101.onlineTimeVisible) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.downloadStatus;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<f> r104 = this.images;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ArrayList<u> r107 = this.videoList;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        h r110 = this.evaluationVideoList;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<j> r113 = this.gameAwardList;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.showBusinessInfo;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<GameImageBundler> r119 = this.gameImages;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.complianceElementsVisible;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.onlineTimeVisible;
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
        return "GameIntroData(downloadStatus=" + this.downloadStatus + ", images=" + this.images + ", videoList=" + this.videoList + ", evaluationVideoList=" + this.evaluationVideoList + ", gameAwardList=" + this.gameAwardList + ", showBusinessInfo=" + this.showBusinessInfo + ", gameImages=" + this.gameImages + ", complianceElementsVisible=" + this.complianceElementsVisible + ", onlineTimeVisible=" + this.onlineTimeVisible + ")";
    }

    public d() {
        Boolean r100 = Boolean.FALSE;
        this.downloadStatus = -1L;
        this.images = null;
        this.videoList = null;
        this.evaluationVideoList = null;
        this.gameAwardList = null;
        this.showBusinessInfo = r100;
        this.gameImages = null;
        this.complianceElementsVisible = r100;
        this.onlineTimeVisible = r100;
    }

    public final Boolean a() {
        return this.complianceElementsVisible;
    }

    public final Long b() {
        return this.downloadStatus;
    }

    public final h c() {
        return this.evaluationVideoList;
    }

    public final List<j> d() {
        return this.gameAwardList;
    }

    public final List<GameImageBundler> e() {
        return this.gameImages;
    }

    public final List<f> f() {
        return this.images;
    }
}
