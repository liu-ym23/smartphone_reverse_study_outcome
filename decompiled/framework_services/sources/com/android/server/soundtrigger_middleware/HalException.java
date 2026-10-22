package com.android.server.soundtrigger_middleware;

/* JADX INFO: loaded from: classes3.dex */
public class HalException extends RuntimeException {
    public final int errorCode;

    public HalException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public HalException(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + " (code " + this.errorCode + ")";
    }
}
