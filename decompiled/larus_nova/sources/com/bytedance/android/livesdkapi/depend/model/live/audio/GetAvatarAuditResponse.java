package com.bytedance.android.livesdkapi.depend.model.live.audio;

import am3.g;
import com.alipay.sdk.m.u.i;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u000fH\u0016R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR&\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/GetAvatarAuditResponse;", "", "()V", "auditId", "", "getAuditId$annotations", "getAuditId", "()J", "setAuditId", "(J)V", "auditResult", "getAuditResult$annotations", "getAuditResult", "setAuditResult", "reason", "", "getReason$annotations", "getReason", "()Ljava/lang/String;", "setReason", "(Ljava/lang/String;)V", "toString", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GetAvatarAuditResponse implements h {
    private long auditId;
    private long auditResult;
    private String reason;

    public GetAvatarAuditResponse() {
    }

    public GetAvatarAuditResponse(g r100) {
        long r101 = r100.c();
    L4:
        if (r100.f() == (-1)) goto L6;
        am3.h.e(r100);
        goto L4
    L6:
        r100.d(r101);
    }

    @FieldName(name = "review_id")
    public static /* synthetic */ void getAuditId$annotations() {
    }

    @FieldName(name = "audit_res")
    public static /* synthetic */ void getAuditResult$annotations() {
    }

    @FieldName(name = "reason")
    public static /* synthetic */ void getReason$annotations() {
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("{auditResult=");
        r100.append(this.auditResult);
        r100.append(", reason=");
        String r101 = this.reason;
        if (r101 != null) goto L6;
        r101 = "null";
    L6:
        r100.append(r101);
        r100.append(", auditId=");
        r100.append(this.auditId);
        r100.append(i.f25855d);
        return r100.toString();
    }

    public final long getAuditId() {
        return this.auditId;
    }

    public final long getAuditResult() {
        return this.auditResult;
    }

    public final String getReason() {
        return this.reason;
    }

    public final void setAuditId(long r100) {
        this.auditId = r100;
    }

    public final void setAuditResult(long r100) {
        this.auditResult = r100;
    }

    public final void setReason(String r100) {
        this.reason = r100;
    }
}
