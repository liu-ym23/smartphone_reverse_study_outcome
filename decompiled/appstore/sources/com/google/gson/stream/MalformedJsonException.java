package com.google.gson.stream;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class MalformedJsonException extends IOException {
    private static final long serialVersionUID = 1;

    public MalformedJsonException(String r10) {
        super(r10);
    }

    public MalformedJsonException(String r10, Throwable r11) {
        super(r10);
        initCause(r11);
    }

    public MalformedJsonException(Throwable r10) {
        initCause(r10);
    }
}
