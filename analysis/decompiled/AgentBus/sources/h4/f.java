package h4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes.dex */
public final class f extends q {

    /* renamed from: a, reason: collision with root package name */
    public final int f4129a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4130b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4131c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4132d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f4133e;

    public f(int i2, int i10, String str, byte[] bArr) throws InvalidAlgorithmParameterException {
        if (bArr.length < 16 || bArr.length < i2) {
            throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, i2));
        }
        z.a(i2);
        if (i10 <= e() + 16) {
            throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
        }
        this.f4133e = Arrays.copyOf(bArr, bArr.length);
        this.f4132d = str;
        this.f4129a = i2;
        this.f4130b = i10;
        this.f4131c = i10 - 16;
    }

    public static GCMParameterSpec i(byte[] bArr, long j2, boolean z4) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.put(bArr);
        if (0 > j2 || j2 >= 4294967296L) {
            throw new GeneralSecurityException("Index out of range");
        }
        byteBufferAllocate.putInt((int) j2);
        byteBufferAllocate.put(z4 ? (byte) 1 : (byte) 0);
        return new GCMParameterSpec(128, byteBufferAllocate.array());
    }

    @Override // h4.q
    public final int c() {
        return e();
    }

    @Override // h4.q
    public final int d() {
        return this.f4130b;
    }

    @Override // h4.q
    public final int e() {
        return this.f4129a + 8;
    }

    @Override // h4.q
    public final int f() {
        return this.f4131c;
    }

    @Override // h4.q
    public final v g() {
        return new i5.f(this);
    }

    @Override // h4.q
    public final w h(byte[] bArr) {
        return new e(this, bArr);
    }
}
