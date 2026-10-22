package o3;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

/* renamed from: o3.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1760c extends FilterOutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ R5.b f5419a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1760c(R5.b bVar, FileOutputStream fileOutputStream) {
        super(fileOutputStream);
        this.f5419a = bVar;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        try {
            ((FilterOutputStream) this).out.close();
        } catch (IOException unused) {
            this.f5419a.f1153a = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public final void flush() throws IOException {
        try {
            ((FilterOutputStream) this).out.flush();
        } catch (IOException unused) {
            this.f5419a.f1153a = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) throws IOException {
        try {
            ((FilterOutputStream) this).out.write(i);
        } catch (IOException unused) {
            this.f5419a.f1153a = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i6) throws IOException {
        try {
            ((FilterOutputStream) this).out.write(bArr, i, i6);
        } catch (IOException unused) {
            this.f5419a.f1153a = true;
        }
    }
}
