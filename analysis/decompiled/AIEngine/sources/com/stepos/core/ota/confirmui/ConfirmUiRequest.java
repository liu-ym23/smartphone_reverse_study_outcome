package com.stepos.core.ota.confirmui;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ConfirmUiRequest {
    private final zb.a<lb.n> onShowFailed;
    private final ConfirmDialogParams params;
    private final long perfT0;
    private final String perfTraceId;
    private final String reqId;

    public ConfirmUiRequest(String reqId, ConfirmDialogParams params, String perfTraceId, long j10, zb.a<lb.n> onShowFailed) {
        kotlin.jvm.internal.g.f(reqId, "reqId");
        kotlin.jvm.internal.g.f(params, "params");
        kotlin.jvm.internal.g.f(perfTraceId, "perfTraceId");
        kotlin.jvm.internal.g.f(onShowFailed, "onShowFailed");
        this.reqId = reqId;
        this.params = params;
        this.perfTraceId = perfTraceId;
        this.perfT0 = j10;
        this.onShowFailed = onShowFailed;
    }

    public static /* synthetic */ ConfirmUiRequest copy$default(ConfirmUiRequest confirmUiRequest, String str, ConfirmDialogParams confirmDialogParams, String str2, long j10, zb.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = confirmUiRequest.reqId;
        }
        if ((i10 & 2) != 0) {
            confirmDialogParams = confirmUiRequest.params;
        }
        if ((i10 & 4) != 0) {
            str2 = confirmUiRequest.perfTraceId;
        }
        if ((i10 & 8) != 0) {
            j10 = confirmUiRequest.perfT0;
        }
        if ((i10 & 16) != 0) {
            aVar = confirmUiRequest.onShowFailed;
        }
        zb.a aVar2 = aVar;
        String str3 = str2;
        return confirmUiRequest.copy(str, confirmDialogParams, str3, j10, aVar2);
    }

    public final String component1() {
        return this.reqId;
    }

    public final ConfirmDialogParams component2() {
        return this.params;
    }

    public final String component3() {
        return this.perfTraceId;
    }

    public final long component4() {
        return this.perfT0;
    }

    public final zb.a<lb.n> component5() {
        return this.onShowFailed;
    }

    public final ConfirmUiRequest copy(String reqId, ConfirmDialogParams params, String perfTraceId, long j10, zb.a<lb.n> onShowFailed) {
        kotlin.jvm.internal.g.f(reqId, "reqId");
        kotlin.jvm.internal.g.f(params, "params");
        kotlin.jvm.internal.g.f(perfTraceId, "perfTraceId");
        kotlin.jvm.internal.g.f(onShowFailed, "onShowFailed");
        return new ConfirmUiRequest(reqId, params, perfTraceId, j10, onShowFailed);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfirmUiRequest)) {
            return false;
        }
        ConfirmUiRequest confirmUiRequest = (ConfirmUiRequest) obj;
        return kotlin.jvm.internal.g.b(this.reqId, confirmUiRequest.reqId) && kotlin.jvm.internal.g.b(this.params, confirmUiRequest.params) && kotlin.jvm.internal.g.b(this.perfTraceId, confirmUiRequest.perfTraceId) && this.perfT0 == confirmUiRequest.perfT0 && kotlin.jvm.internal.g.b(this.onShowFailed, confirmUiRequest.onShowFailed);
    }

    public final zb.a<lb.n> getOnShowFailed() {
        return this.onShowFailed;
    }

    public final ConfirmDialogParams getParams() {
        return this.params;
    }

    public final long getPerfT0() {
        return this.perfT0;
    }

    public final String getPerfTraceId() {
        return this.perfTraceId;
    }

    public final String getReqId() {
        return this.reqId;
    }

    public int hashCode() {
        return this.onShowFailed.hashCode() + a0.a.c(v1.d.a((this.params.hashCode() + (this.reqId.hashCode() * 31)) * 31, 31, this.perfTraceId), this.perfT0, 31);
    }

    public String toString() {
        String str = this.reqId;
        ConfirmDialogParams confirmDialogParams = this.params;
        String str2 = this.perfTraceId;
        long j10 = this.perfT0;
        zb.a<lb.n> aVar = this.onShowFailed;
        StringBuilder sb2 = new StringBuilder("ConfirmUiRequest(reqId=");
        sb2.append(str);
        sb2.append(", params=");
        sb2.append(confirmDialogParams);
        sb2.append(", perfTraceId=");
        com.stepos.core.ota.d.p(j10, str2, ", perfT0=", sb2);
        sb2.append(", onShowFailed=");
        sb2.append(aVar);
        sb2.append(")");
        return sb2.toString();
    }
}
