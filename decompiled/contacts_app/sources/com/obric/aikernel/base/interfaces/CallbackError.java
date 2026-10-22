package com.obric.aikernel.base.interfaces;

import com.obric.callsummary.widget.CallSummaryWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallbackError.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/obric/aikernel/base/interfaces/CallbackError;", "", "code", "", "subCode", CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY, "", "(IILjava/lang/String;)V", "getCode", "()I", "getSubCode", "getSummary", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "BaseInterfaces_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CallbackError {
    private final int code;
    private final int subCode;
    private final String summary;

    public static /* synthetic */ CallbackError copy$default(CallbackError r0, int r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.subCode;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.summary;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.code;
    }

    public final int component2() {
        return this.subCode;
    }

    public final String component3() {
        return this.summary;
    }

    public final CallbackError copy(int r1, int r2, String r3) {
        return new CallbackError(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CallbackError) == true) goto L8;
        return false;
    L8:
        CallbackError r6 = (CallbackError) r5;
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (this.subCode == r6.subCode) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.summary, r6.summary) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((Integer.hashCode(this.code) * 31) + Integer.hashCode(this.subCode)) * 31;
        String r2 = this.summary;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "CallbackError(code=" + this.code + ", subCode=" + this.subCode + ", summary=" + this.summary + ')';
    }

    public CallbackError(int r1, int r2, String r3) {
        this.code = r1;
        this.subCode = r2;
        this.summary = r3;
    }

    public final int getCode() {
        return this.code;
    }

    public final int getSubCode() {
        return this.subCode;
    }

    public final String getSummary() {
        return this.summary;
    }
}
