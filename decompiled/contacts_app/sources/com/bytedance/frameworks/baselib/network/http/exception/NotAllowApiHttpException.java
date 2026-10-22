package com.bytedance.frameworks.baselib.network.http.exception;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class NotAllowApiHttpException extends IOException {
    private static final long serialVersionUID = -5588326043064908201L;

    public NotAllowApiHttpException() {
    }

    public NotAllowApiHttpException(String r1) {
        super(r1);
    }

    public NotAllowApiHttpException(Throwable r1) {
        initCause(r1);
    }

    public NotAllowApiHttpException(String r1, Throwable r2) {
        super(r1);
        initCause(r2);
    }
}
