package com.volcengine.tos;

/* loaded from: classes3.dex */
public class TosException extends RuntimeException {
    public TosException() {
    }

    public String getCode() {
        return "";
    }

    public int getStatusCode() {
        return 0;
    }

    public TosException(Throwable th) {
        super(th);
    }

    public TosException(String str, Throwable th) {
        super(str, th);
    }
}
