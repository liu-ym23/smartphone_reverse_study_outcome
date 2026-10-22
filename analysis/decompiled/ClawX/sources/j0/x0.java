package j0;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class x0 extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final FileOutputStream f3463a;

    public x0(FileOutputStream fileOutputStream) {
        this.f3463a = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        this.f3463a.flush();
    }

    @Override // java.io.OutputStream
    public final void write(int i8) throws IOException {
        this.f3463a.write(i8);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] b9) throws IOException {
        kotlin.jvm.internal.p.e(b9, "b");
        this.f3463a.write(b9);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bytes, int i8, int i9) throws IOException {
        kotlin.jvm.internal.p.e(bytes, "bytes");
        this.f3463a.write(bytes, i8, i9);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
