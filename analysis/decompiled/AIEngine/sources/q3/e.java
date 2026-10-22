package q3;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f11556a;

    public e(ByteBuffer byteBuffer) {
        this.f11556a = byteBuffer;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f11556a.remaining();
    }

    @Override // java.io.InputStream
    public final int read() {
        ByteBuffer byteBuffer = this.f11556a;
        if (byteBuffer.hasRemaining()) {
            return byteBuffer.get() & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) {
        ByteBuffer byteBuffer = this.f11556a;
        if (!byteBuffer.hasRemaining()) {
            return -1;
        }
        int iMin = Math.min(i11, byteBuffer.remaining());
        byteBuffer.get(bArr, i10, iMin);
        return iMin;
    }
}
