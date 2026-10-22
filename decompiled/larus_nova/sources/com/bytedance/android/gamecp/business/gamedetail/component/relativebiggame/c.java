package com.bytedance.android.gamecp.business.gamedetail.component.relativebiggame;

import androidx.camera.video.AudioStats;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/relativebiggame/c;", "", "", "id", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "name", "e", "", PromotionProductPrivilegesStruct.TAGS, "Ljava/util/List;", "f", "()Ljava/util/List;", "", "avgScore", "Ljava/lang/Double;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Double;", "evaluationScore", "c", "Lcom/bytedance/android/gamecp/business/gamedetail/component/relativebiggame/d;", "downloadInfo", "Lcom/bytedance/android/gamecp/business/gamedetail/component/relativebiggame/d;", "b", "()Lcom/bytedance/android/gamecp/business/gamedetail/component/relativebiggame/d;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("avg_score")
    private final Double avgScore;

    @SerializedName("download_info")
    private final d downloadInfo;

    @SerializedName("evaluation_score")
    private final Double evaluationScore;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f54905id;

    @SerializedName("name")
    private final String name;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private final List<String> tags;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f54905id, r101.f54905id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tags, r101.tags) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avgScore, r101.avgScore) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.evaluationScore, r101.evaluationScore) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.downloadInfo, r101.downloadInfo) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f54905id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.tags;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Double r110 = this.avgScore;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Double r113 = this.evaluationScore;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        d r116 = this.downloadInfo;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "RelativeBigGameDownloadBtnData(id=" + this.f54905id + ", name=" + this.name + ", tags=" + this.tags + ", avgScore=" + this.avgScore + ", evaluationScore=" + this.evaluationScore + ", downloadInfo=" + this.downloadInfo + ")";
    }

    public c() {
        Double r100 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        Double r101 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
        this.f54905id = "";
        this.name = "";
        this.tags = null;
        this.avgScore = r100;
        this.evaluationScore = r101;
        this.downloadInfo = null;
    }

    public final Double a() {
        return this.avgScore;
    }

    public final d b() {
        return this.downloadInfo;
    }

    public final Double c() {
        return this.evaluationScore;
    }

    public final String d() {
        return this.f54905id;
    }

    public final String e() {
        return this.name;
    }

    public final List<String> f() {
        return this.tags;
    }
}
