package com.bytedance.android.gamecp.business.comment.data;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.game_evaluation.api.MakeCommentResponse.Data")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/data/q;", "", "", "evaluationId", "J", "", "auditStatus", "I", "", "auditToast", "Ljava/lang/String;", "", "Lcom/bytedance/android/gamecp/business/comment/data/b;", "userDetailList", "Ljava/util/List;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q implements vh7.h {

    @SerializedName("audit_status")
    public int auditStatus;

    @SerializedName("audit_toast")
    public String auditToast;

    @SerializedName("evaluation_id")
    public long evaluationId;

    @SerializedName("user_evaluation_detail")
    public List<? extends b> userDetailList;

    public static final class a {
    }

    static {
    }

    public q() {
        this.auditToast = "";
    }

    public q(am3.g r100) {
        this.userDetailList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.evaluationId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.auditStatus = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.auditToast = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 5) goto L13;
        this.userDetailList.add(new b(r100));
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
        if (this.auditToast != null) goto L37;
        this.auditToast = "";
        return;
    }
}
