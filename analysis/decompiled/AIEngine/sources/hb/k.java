package hb;

import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k extends i {

    /* renamed from: a, reason: collision with root package name */
    public final RandomAccessFile f9400a;

    public k(RandomAccessFile randomAccessFile) throws IOException {
        this.f9400a = randomAccessFile;
        randomAccessFile.seek(0L);
    }

    @Override // hb.i
    public final void a(long j10) throws IOException {
        this.f9400a.seek(j10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f9400a.close();
    }

    @Override // hb.i
    public final void o(byte[] bArr, int i10) throws IOException {
        this.f9400a.write(bArr, 0, i10);
    }

    @Override // hb.i
    public final void flush() {
    }
}
