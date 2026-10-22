package com.bytedance.android.sdk.bdticketguard;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001J\t\u0010\f\u001a\u00020\u0006HÖ\u0001J\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/AttestationRemoteException;", "Lcom/bytedance/android/sdk/bdticketguard/NonRetryableException;", "Lcom/bytedance/android/sdk/bdticketguard/d;", "component1", "", "component2", "", "component3", "snapshot", "errorCode", "logId", "copy", "toString", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/sdk/bdticketguard/d;", "getSnapshot", "()Lcom/bytedance/android/sdk/bdticketguard/d;", "I", "getErrorCode", "()I", "Ljava/lang/String;", "getLogId", "()Ljava/lang/String;", "getMessage", "message", "<init>", "(Lcom/bytedance/android/sdk/bdticketguard/d;ILjava/lang/String;)V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class AttestationRemoteException extends NonRetryableException {
    private final int errorCode;
    private final String logId;
    private final d snapshot;

    public static /* synthetic */ AttestationRemoteException copy$default(AttestationRemoteException r100, d r101, int r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.snapshot;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.errorCode;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.logId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final d component1() {
        return this.snapshot;
    }

    public final int component2() {
        return this.errorCode;
    }

    public final String component3() {
        return this.logId;
    }

    public final AttestationRemoteException copy(d r100, int r101, String r102) {
        return new AttestationRemoteException(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
    L17:
        return true;
    L5:
        if ((r100 instanceof AttestationRemoteException) == false) goto L16;
        AttestationRemoteException r101 = (AttestationRemoteException) r100;
        if (Intrinsics.areEqual(this.snapshot, r101.snapshot) == false) goto L16;
        if (this.errorCode != r101.errorCode) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L16;
        if (Intrinsics.areEqual(this.logId, r101.logId) == false) goto L16;
    L11:
        r102 = false;
    L16:
        return false;
    }

    public int hashCode() {
        d r100 = this.snapshot;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.errorCode) * 31;
        String r104 = this.logId;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "AttestationRemoteException(snapshot=" + this.snapshot + ", errorCode=" + this.errorCode + ", logId=" + this.logId + ")";
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Attestation failed, error code: " + this.errorCode + ", logId: " + this.logId;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final d getSnapshot() {
        return this.snapshot;
    }

    public AttestationRemoteException(d r100, int r101, String r102) {
        this.snapshot = r100;
        this.errorCode = r101;
        this.logId = r102;
    }
}
