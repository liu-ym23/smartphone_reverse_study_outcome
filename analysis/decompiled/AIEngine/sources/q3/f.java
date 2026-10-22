package q3;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f11557a;

    public f(ByteBuffer byteBuffer) {
        this.f11557a = byteBuffer;
    }

    @Override // java.io.OutputStream
    public final void write(int i10) {
        this.f11557a.put((byte) i10);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i10, int i11) {
        this.f11557a.put(bArr, i10, i11);
    }
}
