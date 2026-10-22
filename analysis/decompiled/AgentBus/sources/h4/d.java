package h4;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class d implements t3.a {

    /* renamed from: e, reason: collision with root package name */
    public static final fb.c f4118e = new fb.c(2);

    /* renamed from: f, reason: collision with root package name */
    public static final fb.c f4119f = new fb.c(3);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f4120a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f4121b;

    /* renamed from: c, reason: collision with root package name */
    public final SecretKeySpec f4122c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4123d;

    public d(int i2, byte[] bArr) throws GeneralSecurityException {
        if (!m.x.a(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i2 != 12 && i2 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.f4123d = i2;
        z.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f4122c = secretKeySpec;
        Cipher cipher = (Cipher) f4118e.get();
        cipher.init(1, secretKeySpec);
        byte[] bArrC = c(cipher.doFinal(new byte[16]));
        this.f4120a = bArrC;
        this.f4121b = c(bArrC);
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i2 = 0;
        while (i2 < 15) {
            int i10 = i2 + 1;
            bArr2[i2] = (byte) (((bArr[i2] << 1) ^ ((bArr[i10] & 255) >>> 7)) & 255);
            i2 = i10;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (bArr[15] << 1));
        return bArr2;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
        return bArr3;
    }

    @Override // t3.a
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i2 = this.f4123d;
        if (length > 2147483631 - i2) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + i2 + 16];
        byte[] bArrA = u.a(i2);
        System.arraycopy(bArrA, 0, bArr3, 0, i2);
        Cipher cipher = (Cipher) f4118e.get();
        SecretKeySpec secretKeySpec = this.f4122c;
        cipher.init(1, secretKeySpec);
        byte[] bArrD = d(cipher, 0, bArrA, 0, bArrA.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrD2 = d(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = (Cipher) f4119f.get();
        cipher2.init(1, secretKeySpec, new IvParameterSpec(bArrD));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.f4123d);
        byte[] bArrD3 = d(cipher, 2, bArr3, this.f4123d, bArr.length);
        int length2 = bArr.length + i2;
        for (int i10 = 0; i10 < 16; i10++) {
            bArr3[length2 + i10] = (byte) ((bArrD2[i10] ^ bArrD[i10]) ^ bArrD3[i10]);
        }
        return bArr3;
    }

    @Override // t3.a
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i2 = this.f4123d;
        int i10 = (length - i2) - 16;
        if (i10 < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        Cipher cipher = (Cipher) f4118e.get();
        SecretKeySpec secretKeySpec = this.f4122c;
        cipher.init(1, secretKeySpec);
        byte[] bArrD = d(cipher, 0, bArr, 0, this.f4123d);
        byte[] bArr3 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrD2 = d(cipher, 1, bArr3, 0, bArr3.length);
        byte[] bArrD3 = d(cipher, 2, bArr, this.f4123d, i10);
        int length2 = bArr.length - 16;
        byte b10 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            b10 = (byte) (b10 | (((bArr[length2 + i11] ^ bArrD2[i11]) ^ bArrD[i11]) ^ bArrD3[i11]));
        }
        if (b10 != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher2 = (Cipher) f4119f.get();
        cipher2.init(1, secretKeySpec, new IvParameterSpec(bArrD));
        return cipher2.doFinal(bArr, i2, i10);
    }

    public final byte[] d(Cipher cipher, int i2, byte[] bArr, int i10, int i11) throws BadPaddingException, IllegalBlockSizeException {
        byte[] bArrCopyOf;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i2;
        byte[] bArr3 = this.f4120a;
        if (i11 == 0) {
            return cipher.doFinal(e(bArr2, bArr3));
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        int i12 = 0;
        while (i11 - i12 > 16) {
            for (int i13 = 0; i13 < 16; i13++) {
                bArrDoFinal[i13] = (byte) (bArrDoFinal[i13] ^ bArr[(i10 + i12) + i13]);
            }
            bArrDoFinal = cipher.doFinal(bArrDoFinal);
            i12 += 16;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i12 + i10, i10 + i11);
        if (bArrCopyOfRange.length == 16) {
            bArrCopyOf = e(bArrCopyOfRange, bArr3);
        } else {
            bArrCopyOf = Arrays.copyOf(this.f4121b, 16);
            for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
                bArrCopyOf[i14] = (byte) (bArrCopyOf[i14] ^ bArrCopyOfRange[i14]);
            }
            bArrCopyOf[bArrCopyOfRange.length] = (byte) (bArrCopyOf[bArrCopyOfRange.length] ^ 128);
        }
        return cipher.doFinal(e(bArrDoFinal, bArrCopyOf));
    }
}
