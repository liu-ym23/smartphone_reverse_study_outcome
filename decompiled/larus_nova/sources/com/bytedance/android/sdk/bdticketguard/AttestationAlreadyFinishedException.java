package com.bytedance.android.sdk.bdticketguard;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/AttestationAlreadyFinishedException;", "Lcom/bytedance/android/sdk/bdticketguard/NonRetryableException;", "lastResult", "Lcom/bytedance/android/sdk/bdticketguard/AttestationResult;", "(Lcom/bytedance/android/sdk/bdticketguard/AttestationResult;)V", "getLastResult", "()Lcom/bytedance/android/sdk/bdticketguard/AttestationResult;", "message", "", "getMessage", "()Ljava/lang/String;", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
public final class AttestationAlreadyFinishedException extends NonRetryableException {
    private final AttestationResult lastResult;

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Attestation already finished";
    }

    public final AttestationResult getLastResult() {
        return this.lastResult;
    }

    public AttestationAlreadyFinishedException(AttestationResult r100) {
        this.lastResult = r100;
    }
}
