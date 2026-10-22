package com.obric.voice.bean;

import com.google.gson.annotations.SerializedName;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ASRResp.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003JY\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0016\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006'"}, d2 = {"Lcom/obric/voice/bean/ASRResp;", "", "text", "", "asrState", AccountConst.KEY_ERROR_CODE, "errorMessage", "asrEnd", "", "vadEnd", "startTime", "", "endTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZDD)V", "getAsrEnd", "()Z", "getAsrState", "()Ljava/lang/String;", "getEndTime", "()D", "getErrorCode", "getErrorMessage", "getStartTime", "getText", "getVadEnd", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ASRResp {

    @SerializedName("AsrEnd")
    private final boolean asrEnd;

    @SerializedName("AsrState")
    private final String asrState;

    @SerializedName("endTime")
    private final double endTime;

    @SerializedName(AccountConst.KEY_ERROR_CODE)
    private final String errorCode;

    @SerializedName("errorMessage")
    private final String errorMessage;

    @SerializedName("startTime")
    private final double startTime;

    @SerializedName("text")
    private final String text;

    @SerializedName("VadEnd")
    private final boolean vadEnd;

    public ASRResp() {
        this(null, null, null, null, false, false, 0.0d, 0.0d, 255, null);
    }

    public static /* synthetic */ ASRResp copy$default(ASRResp r12, String r13, String r14, String r15, String r16, boolean r17, boolean r18, double r19, double r21, int r23, Object r24) {
        if ((r23 & 1) == 0) goto L5;
        String r2 = r12.text;
    L7:
        if ((r23 & 2) == 0) goto L9;
        String r3 = r12.asrState;
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r4 = r12.errorCode;
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r5 = r12.errorMessage;
    L19:
        if ((r23 & 16) == 0) goto L21;
        boolean r6 = r12.asrEnd;
    L23:
        if ((r23 & 32) == 0) goto L25;
        boolean r7 = r12.vadEnd;
    L27:
        if ((r23 & 64) == 0) goto L29;
        double r8 = r12.startTime;
    L31:
        if ((r23 & 128) == 0) goto L33;
        double r10 = r12.endTime;
    L35:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r10);
    L33:
        r10 = r21;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.asrState;
    }

    public final String component3() {
        return this.errorCode;
    }

    public final String component4() {
        return this.errorMessage;
    }

    public final boolean component5() {
        return this.asrEnd;
    }

    public final boolean component6() {
        return this.vadEnd;
    }

    public final double component7() {
        return this.startTime;
    }

    public final double component8() {
        return this.endTime;
    }

    public final ASRResp copy(String r13, String r14, String r15, String r16, boolean r17, boolean r18, double r19, double r21) {
        Intrinsics.checkNotNullParameter(r13, "text");
        Intrinsics.checkNotNullParameter(r14, "asrState");
        Intrinsics.checkNotNullParameter(r15, AccountConst.KEY_ERROR_CODE);
        Intrinsics.checkNotNullParameter(r16, "errorMessage");
        return new ASRResp(r13, r14, r15, r16, r17, r18, r19, r21);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ASRResp) == true) goto L8;
        return false;
    L8:
        ASRResp r9 = (ASRResp) r8;
        if (Intrinsics.areEqual(this.text, r9.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.asrState, r9.asrState) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.errorCode, r9.errorCode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.errorMessage, r9.errorMessage) == true) goto L21;
        return false;
    L21:
        if (this.asrEnd == r9.asrEnd) goto L24;
        return false;
    L24:
        if (this.vadEnd == r9.vadEnd) goto L27;
        return false;
    L27:
        if (Double.compare(this.startTime, r9.startTime) == 0) goto L30;
        return false;
    L30:
        if (Double.compare(this.endTime, r9.endTime) == 0) goto L32;
        return false;
    L32:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int r0 = ((((((this.text.hashCode() * 31) + this.asrState.hashCode()) * 31) + this.errorCode.hashCode()) * 31) + this.errorMessage.hashCode()) * 31;
        boolean r1 = this.asrEnd;
        ?? r2 = 1;
        ?? r3 = r1;
        if (r1 == false) goto L5;
        r3 = 1;
    L5:
        int r4 = (r0 + r3) * 31;
        boolean r5 = this.vadEnd;
        if (r5 == true) goto L10;
        r2 = r5;
    L10:
        return ((((r4 + r2) * 31) + Double.hashCode(this.startTime)) * 31) + Double.hashCode(this.endTime);
    }

    public String toString() {
        return "ASRResp(text=" + this.text + ", asrState=" + this.asrState + ", errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", asrEnd=" + this.asrEnd + ", vadEnd=" + this.vadEnd + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
    }

    public ASRResp(String r2, String r3, String r4, String r5, boolean r6, boolean r7, double r8, double r10) {
        Intrinsics.checkNotNullParameter(r2, "text");
        Intrinsics.checkNotNullParameter(r3, "asrState");
        Intrinsics.checkNotNullParameter(r4, AccountConst.KEY_ERROR_CODE);
        Intrinsics.checkNotNullParameter(r5, "errorMessage");
        this.text = r2;
        this.asrState = r3;
        this.errorCode = r4;
        this.errorMessage = r5;
        this.asrEnd = r6;
        this.vadEnd = r7;
        this.startTime = r8;
        this.endTime = r10;
    }

    public /* synthetic */ ASRResp(String r3, String r4, String r5, String r6, boolean r7, boolean r8, double r9, double r11, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r13 & 2) == 0) goto L9;
        r4 = "ASR_STARTED";
    L9:
        if ((r13 & 4) == 0) goto L12;
        r5 = "0";
    L12:
        if ((r13 & 8) == 0) goto L15;
        r6 = "";
    L15:
        if ((r13 & 16) == 0) goto L18;
        r7 = false;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r8 = false;
    L21:
        if ((r13 & 64) == 0) goto L24;
        r9 = 0.0d;
    L24:
        if ((r13 & 128) == 0) goto L26;
        r11 = 0.0d;
    L26:
        this(r3, r4, r5, r6, r7, r8, r9, r11);
    }

    public final String getText() {
        return this.text;
    }

    public final String getAsrState() {
        return this.asrState;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final boolean getAsrEnd() {
        return this.asrEnd;
    }

    public final boolean getVadEnd() {
        return this.vadEnd;
    }

    public final double getStartTime() {
        return this.startTime;
    }

    public final double getEndTime() {
        return this.endTime;
    }
}
