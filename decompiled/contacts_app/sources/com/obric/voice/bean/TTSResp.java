package com.obric.voice.bean;

import com.google.gson.annotations.SerializedName;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TTSResp.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/obric/voice/bean/TTSResp;", "", AccountConst.KEY_ERROR_CODE, "", "errorMessage", "offsetInBytes", "", "sizeInBytes", "(Ljava/lang/String;Ljava/lang/String;II)V", "getErrorCode", "()Ljava/lang/String;", "getErrorMessage", "getOffsetInBytes", "()I", "getSizeInBytes", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TTSResp {

    @SerializedName(AccountConst.KEY_ERROR_CODE)
    private final String errorCode;

    @SerializedName("errorMessage")
    private final String errorMessage;

    @SerializedName("offsetInBytes")
    private final int offsetInBytes;

    @SerializedName("sizeInBytes")
    private final int sizeInBytes;

    public TTSResp() {
        this(null, null, 0, 0, 15, null);
    }

    public static /* synthetic */ TTSResp copy$default(TTSResp r0, String r1, String r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.errorCode;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.errorMessage;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.offsetInBytes;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.sizeInBytes;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.errorCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final int component3() {
        return this.offsetInBytes;
    }

    public final int component4() {
        return this.sizeInBytes;
    }

    public final TTSResp copy(String r1, String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, AccountConst.KEY_ERROR_CODE);
        Intrinsics.checkNotNullParameter(r2, "errorMessage");
        return new TTSResp(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TTSResp) == true) goto L8;
        return false;
    L8:
        TTSResp r6 = (TTSResp) r5;
        if (Intrinsics.areEqual(this.errorCode, r6.errorCode) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorMessage, r6.errorMessage) == true) goto L15;
        return false;
    L15:
        if (this.offsetInBytes == r6.offsetInBytes) goto L18;
        return false;
    L18:
        if (this.sizeInBytes == r6.sizeInBytes) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.errorCode.hashCode() * 31) + this.errorMessage.hashCode()) * 31) + Integer.hashCode(this.offsetInBytes)) * 31) + Integer.hashCode(this.sizeInBytes);
    }

    public String toString() {
        return "TTSResp(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", offsetInBytes=" + this.offsetInBytes + ", sizeInBytes=" + this.sizeInBytes + ')';
    }

    public TTSResp(String r2, String r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, AccountConst.KEY_ERROR_CODE);
        Intrinsics.checkNotNullParameter(r3, "errorMessage");
        this.errorCode = r2;
        this.errorMessage = r3;
        this.offsetInBytes = r4;
        this.sizeInBytes = r5;
    }

    public /* synthetic */ TTSResp(String r2, String r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = "0";
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0;
    L14:
        this(r2, r3, r4, r5);
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final int getOffsetInBytes() {
        return this.offsetInBytes;
    }

    public final int getSizeInBytes() {
        return this.sizeInBytes;
    }
}
