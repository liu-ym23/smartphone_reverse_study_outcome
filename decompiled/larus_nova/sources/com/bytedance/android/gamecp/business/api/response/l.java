package com.bytedance.android.gamecp.business.api.response;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.game_evaluation.api.MakeScoreCommentResponse.Data")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/business/api/response/l;", "", "", "evaluationId", "Ljava/lang/String;", "popupText", "freqToast", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l implements vh7.h {

    @SerializedName("evaluation_id")
    public String evaluationId;

    @SerializedName("freq_toast")
    public String freqToast;

    @SerializedName("popup_text")
    public String popupText;

    public l() {
        this.evaluationId = "";
        this.popupText = "";
        this.freqToast = "";
    }

    public l(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.evaluationId = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.popupText = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.freqToast = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.evaluationId != null) goto L19;
        this.evaluationId = "";
    L19:
        if (this.popupText != null) goto L22;
        this.popupText = "";
    L22:
        if (this.freqToast != null) goto L37;
        this.freqToast = "";
        return;
    }
}
