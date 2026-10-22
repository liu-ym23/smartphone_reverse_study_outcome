package com.android.server.appfunctions;

/* JADX INFO: loaded from: classes.dex */
public class AppSearchException extends RuntimeException {
    private final int resultCode;

    public AppSearchException(int resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

    public int getResultCode() {
        return this.resultCode;
    }
}
