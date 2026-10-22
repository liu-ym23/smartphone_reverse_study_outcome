package V9;

import java.io.OutputStream;

/* loaded from: classes4.dex */
public final class f extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1417a;

    public f(g gVar) {
        this.f1417a = gVar;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
    }

    public final String toString() {
        return this.f1417a + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        this.f1417a.L(i);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] data, int i, int i6) {
        kotlin.jvm.internal.k.f(data, "data");
        this.f1417a.m1write(data, i, i6);
    }
}
