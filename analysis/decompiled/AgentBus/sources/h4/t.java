package h4;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class t implements t3.j {

    /* renamed from: a, reason: collision with root package name */
    public final e4.a f4158a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4159b;

    public t(e4.a aVar, int i2) throws InvalidAlgorithmParameterException {
        this.f4158a = aVar;
        this.f4159b = i2;
        if (i2 < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        aVar.i(i2, new byte[0]);
    }

    @Override // t3.j
    public final void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (!MessageDigest.isEqual(b(bArr2), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    @Override // t3.j
    public final byte[] b(byte[] bArr) {
        return this.f4158a.i(this.f4159b, bArr);
    }
}
