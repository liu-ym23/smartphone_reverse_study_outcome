package com.bytedance.android.live.base.model.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes45.dex */
public class NetworkErrorException extends IOException {
    private String message;
    public int statusCode;

    @Override // java.lang.Throwable
    public String toString() {
        String r100 = super.toString();
        if (r100 != null) goto L5;
        return r100;
    L5:
        return r100 + "NetworkErrorException{statusCode=" + this.statusCode + ", message='" + this.message + "'}";
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public NetworkErrorException(int r100, String r101) {
        this.statusCode = r100;
        this.message = r101;
    }

    public NetworkErrorException(int r100, String r101, String r102, Throwable r103) {
        super(r102, r103);
        this.statusCode = r100;
        this.message = r101;
    }
}
