package com.bytedance.android.gamecp.business.comment.data;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.game_evaluation.api.MakeReplyResponse.Data")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/gamecp/business/comment/data/r;", "", "", "auditStatus", "I", "", "replyId", "Ljava/lang/String;", "auditToast", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r implements vh7.h {

    @SerializedName("audit_status")
    public int auditStatus;

    @SerializedName("audit_toast")
    public String auditToast;

    @SerializedName("comment_id")
    public String replyId;

    public static final class a {
    }

    static {
    }

    public r() {
        this.replyId = "";
        this.auditToast = "";
    }

    public r(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.replyId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.auditStatus = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.auditToast = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.replyId != null) goto L19;
        this.replyId = "";
    L19:
        if (this.auditToast != null) goto L34;
        this.auditToast = "";
        return;
    }
}
