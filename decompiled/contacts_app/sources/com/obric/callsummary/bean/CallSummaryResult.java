package com.obric.callsummary.bean;

import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallSummaryResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/obric/callsummary/bean/CallSummaryResult;", "", AccountConst.KEY_ERROR_CODE, "", "errorMessage", "", "data", "Lcom/obric/callsummary/bean/CallSummary;", "inputTextLength", "outputTextLength", "(ILjava/lang/String;Lcom/obric/callsummary/bean/CallSummary;II)V", "getData", "()Lcom/obric/callsummary/bean/CallSummary;", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "getInputTextLength", "getOutputTextLength", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallSummaryResult {
    private final CallSummary data;
    private final int errorCode;
    private final String errorMessage;
    private final int inputTextLength;
    private final int outputTextLength;

    public CallSummaryResult() {
        this(0, null, null, 0, 0, 31, null);
    }

    public static /* synthetic */ CallSummaryResult copy$default(CallSummaryResult r3, int r4, String r5, CallSummary r6, int r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.errorCode;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.errorMessage;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.data;
    L11:
        CallSummary r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.inputTextLength;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.outputTextLength;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final CallSummary component3() {
        return this.data;
    }

    public final int component4() {
        return this.inputTextLength;
    }

    public final int component5() {
        return this.outputTextLength;
    }

    public final CallSummaryResult copy(int r7, String r8, CallSummary r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "errorMessage");
        Intrinsics.checkNotNullParameter(r9, "data");
        return new CallSummaryResult(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CallSummaryResult) == true) goto L8;
        return false;
    L8:
        CallSummaryResult r6 = (CallSummaryResult) r5;
        if (this.errorCode == r6.errorCode) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorMessage, r6.errorMessage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L18;
        return false;
    L18:
        if (this.inputTextLength == r6.inputTextLength) goto L21;
        return false;
    L21:
        if (this.outputTextLength == r6.outputTextLength) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.errorCode) * 31) + this.errorMessage.hashCode()) * 31) + this.data.hashCode()) * 31) + Integer.hashCode(this.inputTextLength)) * 31) + Integer.hashCode(this.outputTextLength);
    }

    public String toString() {
        return "CallSummaryResult(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ", inputTextLength=" + this.inputTextLength + ", outputTextLength=" + this.outputTextLength + ')';
    }

    public CallSummaryResult(int r2, String r3, CallSummary r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "errorMessage");
        Intrinsics.checkNotNullParameter(r4, "data");
        this.errorCode = r2;
        this.errorMessage = r3;
        this.data = r4;
        this.inputTextLength = r5;
        this.outputTextLength = r6;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public /* synthetic */ CallSummaryResult(int r13, String r14, CallSummary r15, int r16, int r17, int r18, DefaultConstructorMarker r19) {
        int r1 = 0;
        if ((r18 & 1) == 0) goto L5;
        int r0 = 0;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r2 = "";
    L11:
        if ((r18 & 4) == 0) goto L13;
        CallSummary r3 = new CallSummary(null, null, null, null, 0, 31, null);
    L15:
        if ((r18 & 8) == 0) goto L17;
        int r4 = 0;
    L19:
        if ((r18 & 16) != 0) goto L22;
        r1 = r17;
    L22:
        this(r0, r2, r3, r4, r1);
        return;
    L17:
        r4 = r16;
        goto L19
    L13:
        r3 = r15;
        goto L15
    L9:
        r2 = r14;
        goto L11
    L5:
        r0 = r13;
        goto L7
    }

    public final CallSummary getData() {
        return this.data;
    }

    public final int getInputTextLength() {
        return this.inputTextLength;
    }

    public final int getOutputTextLength() {
        return this.outputTextLength;
    }
}
