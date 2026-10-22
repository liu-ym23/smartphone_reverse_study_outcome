package h4;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class c implements p {

    /* renamed from: d, reason: collision with root package name */
    public static final fb.c f4114d = new fb.c(1);

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f4115a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4116b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4117c;

    public c(int i2, byte[] bArr) throws GeneralSecurityException {
        if (!m.x.b(2)) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        z.a(bArr.length);
        this.f4115a = new SecretKeySpec(bArr, "AES");
        int blockSize = ((Cipher) f4114d.get()).getBlockSize();
        this.f4117c = blockSize;
        if (i2 < 12 || i2 > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f4116b = i2;
    }

    public final void a(byte[] bArr, int i2, int i10, byte[] bArr2, int i11, byte[] bArr3, boolean z4) throws GeneralSecurityException {
        Cipher cipher = (Cipher) f4114d.get();
        byte[] bArr4 = new byte[this.f4117c];
        System.arraycopy(bArr3, 0, bArr4, 0, this.f4116b);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        SecretKeySpec secretKeySpec = this.f4115a;
        if (z4) {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } else {
            cipher.init(2, secretKeySpec, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i2, i10, bArr2, i11) != i10) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }
}
