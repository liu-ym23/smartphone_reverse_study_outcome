package com.bytedance.android.gamecp.business.gamedetail.component.comment;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/component/comment/a;", "", "", "totalNum", "Ljava/lang/Long;", "b", "()Ljava/lang/Long;", "", "evaluationEntrance", "Ljava/lang/Boolean;", "getEvaluationEntrance", "()Ljava/lang/Boolean;", "", "Lcom/bytedance/android/gamecp/business/comment/data/b;", "commentDetail", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("evaluation_info")
    private final List<com.bytedance.android.gamecp.business.comment.data.b> commentDetail;

    @SerializedName("evaluation_entrance")
    private final Boolean evaluationEntrance;

    @SerializedName("total")
    private final Long totalNum;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.totalNum, r101.totalNum) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.evaluationEntrance, r101.evaluationEntrance) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.commentDetail, r101.commentDetail) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.totalNum;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.evaluationEntrance;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<com.bytedance.android.gamecp.business.comment.data.b> r107 = this.commentDetail;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameCommentData(totalNum=" + this.totalNum + ", evaluationEntrance=" + this.evaluationEntrance + ", commentDetail=" + this.commentDetail + ")";
    }

    public a() {
        this.totalNum = null;
        this.evaluationEntrance = null;
        this.commentDetail = null;
    }

    public final List<com.bytedance.android.gamecp.business.comment.data.b> a() {
        return this.commentDetail;
    }

    public final Long b() {
        return this.totalNum;
    }
}
