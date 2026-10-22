package hb;

import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j extends i {

    /* renamed from: a, reason: collision with root package name */
    public final FileOutputStream f9399a;

    public j(FileOutputStream fileOutputStream) throws IOException {
        this.f9399a = fileOutputStream;
        fileOutputStream.getChannel().position(0L);
    }

    @Override // hb.i
    public final void a(long j10) throws IOException {
        this.f9399a.getChannel().position(j10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f9399a.close();
    }

    @Override // hb.i
    public final void flush() throws IOException {
        this.f9399a.flush();
    }

    @Override // hb.i
    public final void o(byte[] bArr, int i10) throws IOException {
        this.f9399a.write(bArr, 0, i10);
    }
}
