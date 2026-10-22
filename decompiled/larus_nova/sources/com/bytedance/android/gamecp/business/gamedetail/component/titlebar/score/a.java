package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.score;

import com.bytedance.android.gamecp.business.gamedetail.component.basicinfo.f1;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/titlebar/score/a;", "", "", "avgScore", "Ljava/lang/Double;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Double;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/f1$a;", "evaluationInfo", "Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/f1$a;", "b", "()Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/f1$a;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("avg_score")
    private final Double avgScore;

    @SerializedName("evaluation_info")
    private final f1.a evaluationInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.avgScore, r101.avgScore) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.evaluationInfo, r101.evaluationInfo) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Double r100 = this.avgScore;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        f1.a r104 = this.evaluationInfo;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TitleScoreInfoData(avgScore=" + this.avgScore + ", evaluationInfo=" + this.evaluationInfo + ")";
    }

    public a() {
        this.avgScore = null;
        this.evaluationInfo = null;
    }

    public final Double a() {
        return this.avgScore;
    }

    public final f1.a b() {
        return this.evaluationInfo;
    }
}
