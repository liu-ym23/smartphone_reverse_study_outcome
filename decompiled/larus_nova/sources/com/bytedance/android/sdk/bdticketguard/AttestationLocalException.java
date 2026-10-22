package com.bytedance.android.sdk.bdticketguard;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B-\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017B%\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0018R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/AttestationLocalException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "Lcom/bytedance/android/sdk/bdticketguard/d;", "snapshot", "Lcom/bytedance/android/sdk/bdticketguard/d;", "getSnapshot", "()Lcom/bytedance/android/sdk/bdticketguard/d;", "", "localErrorCode", "I", "getLocalErrorCode", "()I", "", "errorMessage", "Ljava/lang/String;", "getErrorMessage", "()Ljava/lang/String;", "getMessage", "message", "", "cause", "<init>", "(Lcom/bytedance/android/sdk/bdticketguard/d;ILjava/lang/String;Ljava/lang/Throwable;)V", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class AttestationLocalException extends RuntimeException {
    private final String errorMessage;
    private final int localErrorCode;
    private final d snapshot;

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Attestation local exception, error code: " + this.localErrorCode + ", error message: " + this.errorMessage;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final int getLocalErrorCode() {
        return this.localErrorCode;
    }

    public final d getSnapshot() {
        return this.snapshot;
    }

    public AttestationLocalException(int r100, String r101, Throwable r102) {
        this(null, r100, r101, r102);
    }

    public AttestationLocalException(d r100, int r101, String r102, Throwable r103) {
        super(r102, r103);
        this.snapshot = r100;
        this.localErrorCode = r101;
        this.errorMessage = r102;
    }

    public /* synthetic */ AttestationLocalException(int r100, String r101, Throwable r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }

    public /* synthetic */ AttestationLocalException(d r100, int r101, String r102, Throwable r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 8) == 0) goto L5;
        r103 = null;
    L5:
        this(r100, r101, r102, r103);
    }
}
