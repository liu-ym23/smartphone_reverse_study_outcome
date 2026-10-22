package com.bytedance.android.gamecp.business.gamedetail.component.downloadbutton;

import androidx.camera.video.AudioStats;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/downloadbutton/d;", "", "", "avgScore", "Ljava/lang/Double;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Double;", "evaluationScore", "c", "Lcom/bytedance/android/gamecp/business/gamedetail/component/downloadbutton/h;", "downloadInfo", "Lcom/bytedance/android/gamecp/business/gamedetail/component/downloadbutton/h;", "b", "()Lcom/bytedance/android/gamecp/business/gamedetail/component/downloadbutton/h;", "", "subTitle", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "isPreDownloadPeriod", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("avg_score")
    private final Double avgScore;

    @SerializedName("download_info")
    private final h downloadInfo;

    @SerializedName("evaluation_score")
    private final Double evaluationScore;

    @SerializedName("is_in_pre_download_period")
    private final Boolean isPreDownloadPeriod;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private final String subTitle;

    public d() {
        this(null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.avgScore, r101.avgScore) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.evaluationScore, r101.evaluationScore) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.downloadInfo, r101.downloadInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.isPreDownloadPeriod, r101.isPreDownloadPeriod) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Double r100 = this.avgScore;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Double r104 = this.evaluationScore;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        h r107 = this.downloadInfo;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.subTitle;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isPreDownloadPeriod;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "GameDownloadBtnData(avgScore=" + this.avgScore + ", evaluationScore=" + this.evaluationScore + ", downloadInfo=" + this.downloadInfo + ", subTitle=" + this.subTitle + ", isPreDownloadPeriod=" + this.isPreDownloadPeriod + ")";
    }

    public final Double a() {
        return this.avgScore;
    }

    public final h b() {
        return this.downloadInfo;
    }

    public final Double c() {
        return this.evaluationScore;
    }

    public final String d() {
        return this.subTitle;
    }

    public final Boolean e() {
        return this.isPreDownloadPeriod;
    }

    public d(Double r100, Double r101, h r102, int r103) {
        int r104 = r103 & 1;
        Double r105 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        if (r104 == 0) goto L6;
        r100 = r105;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = r105;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this.avgScore = r100;
        this.evaluationScore = r101;
        this.downloadInfo = r102;
        this.subTitle = null;
        this.isPreDownloadPeriod = null;
    }
}
