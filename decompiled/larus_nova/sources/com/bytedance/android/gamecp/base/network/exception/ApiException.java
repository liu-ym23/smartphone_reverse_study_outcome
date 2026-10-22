package com.bytedance.android.gamecp.base.network.exception;

/* JADX INFO: loaded from: classes44.dex */
public class ApiException extends Exception {
    private final int mErrorCode;
    private int requestType;

    @Override // java.lang.Throwable
    public String getMessage() {
        return " TYPE = ApiException, errorCode = " + this.mErrorCode + " " + super.getMessage();
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }

    public ApiException(int r100) {
        this.mErrorCode = r100;
    }

    public ApiException(int r100, Throwable r101) {
        super(r101);
        this.mErrorCode = r100;
    }
}
