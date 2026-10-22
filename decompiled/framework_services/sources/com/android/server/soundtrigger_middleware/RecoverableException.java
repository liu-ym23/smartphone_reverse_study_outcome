package com.android.server.soundtrigger_middleware;

/* JADX INFO: loaded from: classes3.dex */
public class RecoverableException extends RuntimeException {
    public final int errorCode;

    public RecoverableException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public RecoverableException(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return super.toString() + " (code " + this.errorCode + ")";
    }
}
