package com.bytedance.android.gamecp.business.comment.data;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.data.EvaluationSummary")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0016\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/data/l;", "", "", "avgGrade", "D", "", "total", "J", "", "isEvaluated", "Z", "", "hiddenEvaluation", "I", "handleEvaluation", "hiddenCommentSummary", "hiddenCommentTotal", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public class l implements vh7.h {

    @SerializedName("avg_grade")
    public double avgGrade;

    @SerializedName("handle_evaluation")
    public int handleEvaluation;

    @SerializedName("hidden_comment_summary")
    public boolean hiddenCommentSummary;

    @SerializedName("hidden_total")
    public boolean hiddenCommentTotal;

    @SerializedName("hidden_evaluation")
    public int hiddenEvaluation;

    @SerializedName("is_evaluated")
    public boolean isEvaluated;

    @SerializedName("total")
    public long total;

    public static final class a {
    }

    static {
    }

    public l() {
        this.hiddenEvaluation = 1;
    }

    public l(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L14;
        switch(r103) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            default: goto L6;
        };
    L7:
        this.hiddenCommentTotal = am3.h.a(r100);
        goto L3
    L8:
        this.hiddenCommentSummary = am3.h.a(r100);
        goto L3
    L9:
        this.handleEvaluation = r100.i();
        goto L3
    L10:
        this.hiddenEvaluation = r100.i();
        r102 = r102 | true;
        goto L3
    L11:
        this.isEvaluated = am3.h.a(r100);
        goto L3
    L12:
        this.total = r100.j();
        goto L3
    L13:
        this.avgGrade = Double.longBitsToDouble(r100.h());
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L14:
        r100.d(r101);
        if ((r102 & true) == true) goto L36;
        this.hiddenEvaluation = 1;
        return;
    }
}
