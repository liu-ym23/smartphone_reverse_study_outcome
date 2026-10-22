package com.google.gson.stream;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class MalformedJsonException extends IOException {
    private static final long serialVersionUID = 1;

    public MalformedJsonException(String r1) {
        super(r1);
    }

    public MalformedJsonException(String r1, Throwable r2) {
        super(r1, r2);
    }

    public MalformedJsonException(Throwable r1) {
        super(r1);
    }
}
