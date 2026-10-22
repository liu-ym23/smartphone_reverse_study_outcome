package com.apm.lite.j;

import java.io.DataOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class f extends DataOutputStream {
    public f(OutputStream r100) {
        super(r100);
    }

    public final void a() {
        super.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
