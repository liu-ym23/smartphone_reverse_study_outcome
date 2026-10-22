package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u000b\"\u0004\b\f\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/SwitchResolutionResult;", "", "isSuccess", "", "(Z)V", "errorCode", "", "getErrorCode", "()I", "setErrorCode", "(I)V", "()Z", "setSuccess", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SwitchResolutionResult {
    private int errorCode;
    private boolean isSuccess;

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public SwitchResolutionResult(boolean r100) {
        this.isSuccess = r100;
    }

    public final void setErrorCode(int r100) {
        this.errorCode = r100;
    }

    public final void setSuccess(boolean r100) {
        this.isSuccess = r100;
    }
}
