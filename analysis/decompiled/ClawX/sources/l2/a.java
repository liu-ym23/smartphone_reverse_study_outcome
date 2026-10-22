package l2;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements j {
    public static final a2.b d = new a2.b(2);

    /* renamed from: a, reason: collision with root package name */
    public final SecretKeySpec f3763a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3764b;

    /* renamed from: c, reason: collision with root package name */
    public final int f3765c;

    public a(byte[] bArr, int i8) throws GeneralSecurityException {
        if (!a8.b.b(2)) {
            throw new GeneralSecurityException("Can not use AES-CTR in FIPS-mode, as BoringCrypto module is not available.");
        }
        o.a(bArr.length);
        this.f3763a = new SecretKeySpec(bArr, "AES");
        int blockSize = ((Cipher) d.get()).getBlockSize();
        this.f3765c = blockSize;
        if (i8 < 12 || i8 > blockSize) {
            throw new GeneralSecurityException("invalid IV size");
        }
        this.f3764b = i8;
    }

    public final void a(byte[] bArr, int i8, int i9, byte[] bArr2, int i10, byte[] bArr3, boolean z) throws GeneralSecurityException {
        Cipher cipher = (Cipher) d.get();
        byte[] bArr4 = new byte[this.f3765c];
        System.arraycopy(bArr3, 0, bArr4, 0, this.f3764b);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr4);
        SecretKeySpec secretKeySpec = this.f3763a;
        if (z) {
            cipher.init(1, secretKeySpec, ivParameterSpec);
        } else {
            cipher.init(2, secretKeySpec, ivParameterSpec);
        }
        if (cipher.doFinal(bArr, i8, i9, bArr2, i10) != i9) {
            throw new GeneralSecurityException("stored output's length does not match input's length");
        }
    }
}
