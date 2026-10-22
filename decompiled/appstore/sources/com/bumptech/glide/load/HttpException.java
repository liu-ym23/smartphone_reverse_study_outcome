package com.bumptech.glide.load;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public HttpException(int r10) {
        this("Http request failed with status code: " + r10, r10);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public HttpException(String r10) {
        this(r10, -1);
    }

    public HttpException(String r10, int r11) {
        this(r10, r11, null);
    }

    public HttpException(String r10, int r11, @Nullable Throwable r12) {
        super(r10, r12);
        this.statusCode = r11;
    }
}
