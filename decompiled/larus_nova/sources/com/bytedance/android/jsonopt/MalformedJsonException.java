package com.bytedance.android.jsonopt;

import java.io.IOException;

/* JADX INFO: loaded from: classes44.dex */
public final class MalformedJsonException extends IOException {
    private static final long serialVersionUID = 1;

    public MalformedJsonException(Throwable r100) {
        initCause(r100);
    }

    public MalformedJsonException(String r100) {
        super(r100);
    }

    public MalformedJsonException(String r100, Throwable r101) {
        super(r100);
        initCause(r101);
    }
}
