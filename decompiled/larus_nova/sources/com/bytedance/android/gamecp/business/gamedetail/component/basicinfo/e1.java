package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/e1;", "", "Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/e1$a;", "evaluationInfo", "Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/e1$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/e1$a;", "", "showSafeTag", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "hasMiniGame", "getHasMiniGame", "Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbasicinfo/a$a;", "reserveNotice", "Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbasicinfo/a$a;", "b", "()Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbasicinfo/a$a;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e1 {

    @SerializedName("evaluation_info")
    private final a evaluationInfo;

    @SerializedName("has_mini_game")
    private final Boolean hasMiniGame;

    @SerializedName("notice")
    private final com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a reserveNotice;

    @SerializedName("show_safe_tag")
    private final Boolean showSafeTag;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/e1$a;", "", "", "handleEvaluation", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "", "avgGrade", "Ljava/lang/Double;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Double;", "total", "e", "", "hide", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "hiddenCommentTotal", "c", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("evaluation_avg_grade")
        private final Double avgGrade;

        @SerializedName("handle_evaluation")
        private final Long handleEvaluation;

        @SerializedName("hidden_comment_total")
        private final Boolean hiddenCommentTotal;

        @SerializedName("hidden_comment_summary")
        private final Boolean hide;

        @SerializedName("evaluation_total")
        private final Long total;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L16;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.handleEvaluation, r101.handleEvaluation) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.avgGrade, r101.avgGrade) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.total, r101.total) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.hide, r101.hide) == true) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.hiddenCommentTotal, r101.hiddenCommentTotal) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            Long r100 = this.handleEvaluation;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Double r104 = this.avgGrade;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            Long r107 = this.total;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            Boolean r110 = this.hide;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            Boolean r113 = this.hiddenCommentTotal;
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
            return "EvaluationInfo(handleEvaluation=" + this.handleEvaluation + ", avgGrade=" + this.avgGrade + ", total=" + this.total + ", hide=" + this.hide + ", hiddenCommentTotal=" + this.hiddenCommentTotal + ")";
        }

        public a() {
            Boolean r100 = Boolean.FALSE;
            this.handleEvaluation = null;
            this.avgGrade = null;
            this.total = null;
            this.hide = null;
            this.hiddenCommentTotal = r100;
        }

        public final Double a() {
            return this.avgGrade;
        }

        public final Long b() {
            return this.handleEvaluation;
        }

        public final Boolean c() {
            return this.hiddenCommentTotal;
        }

        public final Boolean d() {
            return this.hide;
        }

        public final Long e() {
            return this.total;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e1) == false) goto L14;
        e1 r101 = (e1) r100;
        if (Intrinsics.areEqual(this.evaluationInfo, r101.evaluationInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showSafeTag, r101.showSafeTag) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.hasMiniGame, r101.hasMiniGame) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reserveNotice, r101.reserveNotice) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        a r100 = this.evaluationInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.showSafeTag;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.hasMiniGame;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a r110 = this.reserveNotice;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "GameBasicInfoData(evaluationInfo=" + this.evaluationInfo + ", showSafeTag=" + this.showSafeTag + ", hasMiniGame=" + this.hasMiniGame + ", reserveNotice=" + this.reserveNotice + ")";
    }

    public e1() {
        Boolean r100 = Boolean.FALSE;
        this.evaluationInfo = null;
        this.showSafeTag = r100;
        this.hasMiniGame = r100;
        this.reserveNotice = null;
    }

    public final a a() {
        return this.evaluationInfo;
    }

    public final com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a b() {
        return this.reserveNotice;
    }

    public final Boolean c() {
        return this.showSafeTag;
    }
}
