package com.bytedance.retrofit2;

import com.android.contacts.util.HanziToPinyin;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient SsResponse<?> response;

    private static String getMessage(SsResponse<?> r2) {
        Utils.checkNotNull(r2, "response == null");
        return "HTTP " + r2.code() + HanziToPinyin.Token.SEPARATOR + r2.message();
    }

    public HttpException(SsResponse<?> r2) {
        super(getMessage(r2));
        this.code = r2.code();
        this.message = r2.message();
        this.response = r2;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    @Nullable
    public SsResponse<?> response() {
        return this.response;
    }
}
