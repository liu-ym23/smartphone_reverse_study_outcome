package com.obric.Intelligentcall.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallForMeBean.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/obric/Intelligentcall/bean/CallForMeBean;", "", "callId", "", "callParams", "Lcom/obric/Intelligentcall/bean/CallDetailData;", "(Ljava/lang/String;Lcom/obric/Intelligentcall/bean/CallDetailData;)V", "getCallId", "()Ljava/lang/String;", "getCallParams", "()Lcom/obric/Intelligentcall/bean/CallDetailData;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallForMeBean {

    @SerializedName("callId")
    private final String callId;

    @SerializedName("params")
    private final CallDetailData callParams;

    public static /* synthetic */ CallForMeBean copy$default(CallForMeBean r0, String r1, CallDetailData r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.callId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.callParams;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.callId;
    }

    public final CallDetailData component2() {
        return this.callParams;
    }

    public final CallForMeBean copy(String r1, CallDetailData r2) {
        Intrinsics.checkNotNullParameter(r1, "callId");
        Intrinsics.checkNotNullParameter(r2, "callParams");
        return new CallForMeBean(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CallForMeBean) == true) goto L8;
        return false;
    L8:
        CallForMeBean r6 = (CallForMeBean) r5;
        if (Intrinsics.areEqual(this.callId, r6.callId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.callParams, r6.callParams) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.callId.hashCode() * 31) + this.callParams.hashCode();
    }

    public String toString() {
        return "CallForMeBean(callId=" + this.callId + ", callParams=" + this.callParams + ')';
    }

    public CallForMeBean(String r2, CallDetailData r3) {
        Intrinsics.checkNotNullParameter(r2, "callId");
        Intrinsics.checkNotNullParameter(r3, "callParams");
        this.callId = r2;
        this.callParams = r3;
    }

    public final String getCallId() {
        return this.callId;
    }

    public final CallDetailData getCallParams() {
        return this.callParams;
    }
}
