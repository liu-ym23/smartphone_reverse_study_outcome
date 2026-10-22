package h4;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import w7.e0;

/* loaded from: classes.dex */
public final class k implements t3.a {

    /* renamed from: a, reason: collision with root package name */
    public final p f4144a;

    /* renamed from: b, reason: collision with root package name */
    public final t3.j f4145b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4146c;

    public k(p pVar, t3.j jVar, int i2) {
        this.f4144a = pVar;
        this.f4145b = jVar;
        this.f4146c = i2;
    }

    @Override // t3.a
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        c cVar = (c) this.f4144a;
        cVar.getClass();
        int length = bArr.length;
        int i2 = cVar.f4116b;
        int i10 = Integer.MAX_VALUE - i2;
        if (length > i10) {
            throw new GeneralSecurityException(n.f.c(i10, "plaintext length can not exceed "));
        }
        byte[] bArr3 = new byte[bArr.length + i2];
        byte[] bArrA = u.a(i2);
        System.arraycopy(bArrA, 0, bArr3, 0, i2);
        cVar.a(bArr, 0, bArr.length, bArr3, cVar.f4116b, bArrA, true);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        return e0.k(bArr3, this.f4145b.b(e0.k(bArr2, bArr3, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8))));
    }

    @Override // t3.a
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i2 = this.f4146c;
        if (length < i2) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length - i2);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, bArr.length - i2, bArr.length);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        this.f4145b.a(bArrCopyOfRange2, e0.k(bArr2, bArrCopyOfRange, Arrays.copyOf(ByteBuffer.allocate(8).putLong(bArr2.length * 8).array(), 8)));
        c cVar = (c) this.f4144a;
        cVar.getClass();
        int length2 = bArrCopyOfRange.length;
        int i10 = cVar.f4116b;
        if (length2 < i10) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        byte[] bArr3 = new byte[i10];
        System.arraycopy(bArrCopyOfRange, 0, bArr3, 0, i10);
        int length3 = bArrCopyOfRange.length;
        int i11 = cVar.f4116b;
        byte[] bArr4 = new byte[length3 - i11];
        cVar.a(bArrCopyOfRange, i11, bArrCopyOfRange.length - i11, bArr4, 0, bArr3, false);
        return bArr4;
    }
}
