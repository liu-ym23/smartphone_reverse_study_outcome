package S;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import k3.C0694i;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class r extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1768a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1769b;

    public r(FileOutputStream fileOutputStream) {
        Intrinsics.checkNotNullParameter(fileOutputStream, "fileOutputStream");
        this.f1769b = fileOutputStream;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        switch (this.f1768a) {
            case 0:
                ((FileOutputStream) this.f1769b).flush();
                break;
        }
    }

    public final String toString() {
        switch (this.f1768a) {
            case 1:
                return ((C0694i) this.f1769b) + ".outputStream()";
            default:
                return super.toString();
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i4) throws IOException {
        Object obj = this.f1769b;
        switch (this.f1768a) {
            case 0:
                ((FileOutputStream) obj).write(i4);
                break;
            default:
                ((C0694i) obj).V(i4);
                break;
        }
    }

    public r(C0694i c0694i) {
        this.f1769b = c0694i;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] b4) throws IOException {
        switch (this.f1768a) {
            case 0:
                Intrinsics.checkNotNullParameter(b4, "b");
                ((FileOutputStream) this.f1769b).write(b4);
                break;
            default:
                super.write(b4);
                break;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bytes, int i4, int i5) throws IOException {
        Object obj = this.f1769b;
        switch (this.f1768a) {
            case 0:
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                ((FileOutputStream) obj).write(bytes, i4, i5);
                break;
            default:
                Intrinsics.checkNotNullParameter(bytes, "data");
                ((C0694i) obj).S(i4, i5, bytes);
                break;
        }
    }
}
