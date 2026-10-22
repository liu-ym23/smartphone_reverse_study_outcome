package com.apm.lite.j;

import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class l extends GZIPOutputStream {
    public l(OutputStream r100) {
        super(r100);
    }

    public final void a() {
        super.close();
    }

    public final void b() {
        super.finish();
    }

    @Override // java.util.zip.DeflaterOutputStream, java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.util.zip.GZIPOutputStream, java.util.zip.DeflaterOutputStream
    public final void finish() {
    }
}
