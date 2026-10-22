package com.stepos.ame.sdk;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/stepos/ame/sdk/HmxVerifyResult;", "", "fastRpcReturn", "", "dspStatus", "checksumMilli", "dspElapsedUs", "<init>", "(IIII)V", "getFastRpcReturn", "()I", "getDspStatus", "getChecksumMilli", "getDspElapsedUs", "component1", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "toString", "", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class HmxVerifyResult {
    private final int checksumMilli;
    private final int dspElapsedUs;
    private final int dspStatus;
    private final int fastRpcReturn;

    public HmxVerifyResult(int i10, int i11, int i12, int i13) {
        this.fastRpcReturn = i10;
        this.dspStatus = i11;
        this.checksumMilli = i12;
        this.dspElapsedUs = i13;
    }

    public static /* synthetic */ HmxVerifyResult copy$default(HmxVerifyResult hmxVerifyResult, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = hmxVerifyResult.fastRpcReturn;
        }
        if ((i14 & 2) != 0) {
            i11 = hmxVerifyResult.dspStatus;
        }
        if ((i14 & 4) != 0) {
            i12 = hmxVerifyResult.checksumMilli;
        }
        if ((i14 & 8) != 0) {
            i13 = hmxVerifyResult.dspElapsedUs;
        }
        return hmxVerifyResult.copy(i10, i11, i12, i13);
    }

    /* renamed from: component1, reason: from getter */
    public final int getFastRpcReturn() {
        return this.fastRpcReturn;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDspStatus() {
        return this.dspStatus;
    }

    /* renamed from: component3, reason: from getter */
    public final int getChecksumMilli() {
        return this.checksumMilli;
    }

    /* renamed from: component4, reason: from getter */
    public final int getDspElapsedUs() {
        return this.dspElapsedUs;
    }

    public final HmxVerifyResult copy(int fastRpcReturn, int dspStatus, int checksumMilli, int dspElapsedUs) {
        return new HmxVerifyResult(fastRpcReturn, dspStatus, checksumMilli, dspElapsedUs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HmxVerifyResult)) {
            return false;
        }
        HmxVerifyResult hmxVerifyResult = (HmxVerifyResult) other;
        return this.fastRpcReturn == hmxVerifyResult.fastRpcReturn && this.dspStatus == hmxVerifyResult.dspStatus && this.checksumMilli == hmxVerifyResult.checksumMilli && this.dspElapsedUs == hmxVerifyResult.dspElapsedUs;
    }

    public final int getChecksumMilli() {
        return this.checksumMilli;
    }

    public final int getDspElapsedUs() {
        return this.dspElapsedUs;
    }

    public final int getDspStatus() {
        return this.dspStatus;
    }

    public final int getFastRpcReturn() {
        return this.fastRpcReturn;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.fastRpcReturn) * 31) + Integer.hashCode(this.dspStatus)) * 31) + Integer.hashCode(this.checksumMilli)) * 31) + Integer.hashCode(this.dspElapsedUs);
    }

    public String toString() {
        return "HmxVerifyResult(fastRpcReturn=" + this.fastRpcReturn + ", dspStatus=" + this.dspStatus + ", checksumMilli=" + this.checksumMilli + ", dspElapsedUs=" + this.dspElapsedUs + ")";
    }
}
