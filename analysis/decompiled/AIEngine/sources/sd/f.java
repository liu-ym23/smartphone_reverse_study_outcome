package sd;

import java.io.OutputStream;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f11934a;

    public f(e eVar) {
        this.f11934a = eVar;
    }

    public final String toString() {
        return this.f11934a + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i10) {
        this.f11934a.O0(i10);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] data, int i10, int i11) {
        kotlin.jvm.internal.g.f(data, "data");
        this.f11934a.m177write(data, i10, i11);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
    }
}
