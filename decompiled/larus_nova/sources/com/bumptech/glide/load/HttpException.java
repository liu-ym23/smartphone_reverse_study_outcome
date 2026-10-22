package com.bumptech.glide.load;

import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public int getStatusCode() {
        return this.statusCode;
    }

    public HttpException(int r100) {
        this("Http request failed with status code: " + r100, r100);
    }

    public HttpException(String r100) {
        this(r100, -1);
    }

    public HttpException(String r100, int r101) {
        this(r100, r101, null);
    }

    public HttpException(String r100, int r101, Throwable r102) {
        super(r100, r102);
        this.statusCode = r101;
    }
}
