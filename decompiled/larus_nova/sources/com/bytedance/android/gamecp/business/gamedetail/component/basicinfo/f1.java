package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u0005\u0017R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/f1;", "", "Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/f1$a;", "evaluationInfo", "Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/f1$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/f1$a;", "", "showSafeTag", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "hasMiniGame", "getHasMiniGame", "", "Lcom/bytedance/android/gamecp/business/gamedetail/component/orderbasicinfo/a$a;", "reserveNoticeList", "Ljava/util/List;", "d", "()Ljava/util/List;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/officialaccount/g;", "officialAccountInfo", "Lcom/bytedance/android/gamecp/business/gamedetail/component/officialaccount/g;", "b", "()Lcom/bytedance/android/gamecp/business/gamedetail/component/officialaccount/g;", "Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/f1$b;", "pcConfigsInfo", "c", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f1 {

    @SerializedName("evaluation_info")
    private final a evaluationInfo;

    @SerializedName("has_mini_game")
    private final Boolean hasMiniGame;

    @SerializedName("official_account_info")
    private final com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.g officialAccountInfo;

    @SerializedName("pc_configs")
    private final List<b> pcConfigsInfo;

    @SerializedName("notice_list")
    private final List<com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a> reserveNoticeList;

    @SerializedName("show_safe_tag")
    private final Boolean showSafeTag;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/f1$a;", "", "", "handleEvaluation", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "", "avgGrade", "Ljava/lang/Double;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Double;", "total", "e", "", "hide", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "hiddenCommentTotal", "c", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
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

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/basicinfo/f1$b;", "", "", "text", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "schema", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("schema")
        private final String schema;

        @SerializedName("name")
        private final String text;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.text, r101.text) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.text;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.schema;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "PCConfigInfo(text=" + this.text + ", schema=" + this.schema + ")";
        }

        public b() {
            this.text = null;
            this.schema = null;
        }

        public final String a() {
            return this.schema;
        }

        public final String b() {
            return this.text;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f1) == false) goto L18;
        f1 r101 = (f1) r100;
        if (Intrinsics.areEqual(this.evaluationInfo, r101.evaluationInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showSafeTag, r101.showSafeTag) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.hasMiniGame, r101.hasMiniGame) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reserveNoticeList, r101.reserveNoticeList) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.officialAccountInfo, r101.officialAccountInfo) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.pcConfigsInfo, r101.pcConfigsInfo) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
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
        List<com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a> r110 = this.reserveNoticeList;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.g r113 = this.officialAccountInfo;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<b> r116 = this.pcConfigsInfo;
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
        return "GameBasicInfoDataV3(evaluationInfo=" + this.evaluationInfo + ", showSafeTag=" + this.showSafeTag + ", hasMiniGame=" + this.hasMiniGame + ", reserveNoticeList=" + this.reserveNoticeList + ", officialAccountInfo=" + this.officialAccountInfo + ", pcConfigsInfo=" + this.pcConfigsInfo + ")";
    }

    public f1() {
        Boolean r100 = Boolean.FALSE;
        this.evaluationInfo = null;
        this.showSafeTag = r100;
        this.hasMiniGame = r100;
        this.reserveNoticeList = null;
        this.officialAccountInfo = null;
        this.pcConfigsInfo = null;
    }

    public final a a() {
        return this.evaluationInfo;
    }

    public final com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.g b() {
        return this.officialAccountInfo;
    }

    public final List<b> c() {
        return this.pcConfigsInfo;
    }

    public final List<com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo.a.C0891a> d() {
        return this.reserveNoticeList;
    }

    public final Boolean e() {
        return this.showSafeTag;
    }
}
