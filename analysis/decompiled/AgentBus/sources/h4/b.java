package h4;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class b extends q {

    /* renamed from: a, reason: collision with root package name */
    public final int f4107a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4108b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4109c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4110d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4111e;

    /* renamed from: f, reason: collision with root package name */
    public final String f4112f;

    /* renamed from: g, reason: collision with root package name */
    public final byte[] f4113g;

    public b(byte[] bArr, String str, int i2, String str2, int i10, int i11) throws GeneralSecurityException {
        if (!m.x.a(1)) {
            throw new GeneralSecurityException("Can not use AES-CTR-HMAC streaming in FIPS-mode.");
        }
        int length = bArr.length;
        if (length < 16 || length < i2) {
            throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, i2));
        }
        z.a(i2);
        if (i10 < 10) {
            throw new InvalidAlgorithmParameterException(n.f.c(i10, "tag size too small "));
        }
        if ((str2.equals("HmacSha1") && i10 > 20) || ((str2.equals("HmacSha256") && i10 > 32) || (str2.equals("HmacSha512") && i10 > 64))) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        if (((i11 - i10) - i2) - 8 <= 0) {
            throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
        }
        this.f4113g = Arrays.copyOf(bArr, bArr.length);
        this.f4112f = str;
        this.f4107a = i2;
        this.f4108b = str2;
        this.f4109c = i10;
        this.f4110d = i11;
        this.f4111e = i11 - i10;
    }

    public static byte[] i(b bVar, byte[] bArr, long j2, boolean z4) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.put(bArr);
        if (0 > j2 || j2 >= 4294967296L) {
            throw new GeneralSecurityException("Index out of range");
        }
        byteBufferAllocate.putInt((int) j2);
        byteBufferAllocate.put(z4 ? (byte) 1 : (byte) 0);
        byteBufferAllocate.putInt(0);
        return byteBufferAllocate.array();
    }

    @Override // h4.q
    public final int c() {
        return e();
    }

    @Override // h4.q
    public final int d() {
        return this.f4110d;
    }

    @Override // h4.q
    public final int e() {
        return this.f4107a + 8;
    }

    @Override // h4.q
    public final int f() {
        return this.f4111e;
    }

    @Override // h4.q
    public final v g() {
        a4.p pVar = new a4.p();
        pVar.f197k = this;
        return pVar;
    }

    @Override // h4.q
    public final w h(byte[] bArr) {
        return new a(this, bArr);
    }
}
