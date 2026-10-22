package l2;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements y1.a {

    /* renamed from: e, reason: collision with root package name */
    public static final a2.b f3766e = new a2.b(3);

    /* renamed from: f, reason: collision with root package name */
    public static final a2.b f3767f = new a2.b(4);

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3768a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f3769b;

    /* renamed from: c, reason: collision with root package name */
    public final SecretKeySpec f3770c;
    public final int d;

    public b(byte[] bArr, int i8) throws GeneralSecurityException {
        if (!a8.b.a(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i8 != 12 && i8 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.d = i8;
        o.a(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.f3770c = secretKeySpec;
        Cipher cipher = (Cipher) f3766e.get();
        cipher.init(1, secretKeySpec);
        byte[] bArrC = c(cipher.doFinal(new byte[16]));
        this.f3768a = bArrC;
        this.f3769b = c(bArrC);
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i8 = 0;
        while (i8 < 15) {
            int i9 = i8 + 1;
            bArr2[i8] = (byte) (((bArr[i8] << 1) ^ ((bArr[i9] & 255) >>> 7)) & 255);
            i8 = i9;
        }
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (bArr[15] << 1));
        return bArr2;
    }

    public static byte[] e(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i8 = 0; i8 < length; i8++) {
            bArr3[i8] = (byte) (bArr[i8] ^ bArr2[i8]);
        }
        return bArr3;
    }

    @Override // y1.a
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i8 = this.d;
        if (length > 2147483631 - i8) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + i8 + 16];
        byte[] bArrA = n.a(i8);
        System.arraycopy(bArrA, 0, bArr3, 0, i8);
        Cipher cipher = (Cipher) f3766e.get();
        SecretKeySpec secretKeySpec = this.f3770c;
        cipher.init(1, secretKeySpec);
        byte[] bArrD = d(cipher, 0, bArrA, 0, bArrA.length);
        byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrD2 = d(cipher, 1, bArr4, 0, bArr4.length);
        Cipher cipher2 = (Cipher) f3767f.get();
        cipher2.init(1, secretKeySpec, new IvParameterSpec(bArrD));
        cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.d);
        byte[] bArrD3 = d(cipher, 2, bArr3, this.d, bArr.length);
        int length2 = bArr.length + i8;
        for (int i9 = 0; i9 < 16; i9++) {
            bArr3[length2 + i9] = (byte) ((bArrD2[i9] ^ bArrD[i9]) ^ bArrD3[i9]);
        }
        return bArr3;
    }

    @Override // y1.a
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i8 = this.d;
        int i9 = (length - i8) - 16;
        if (i9 < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        Cipher cipher = (Cipher) f3766e.get();
        SecretKeySpec secretKeySpec = this.f3770c;
        cipher.init(1, secretKeySpec);
        byte[] bArrD = d(cipher, 0, bArr, 0, this.d);
        byte[] bArr3 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArrD2 = d(cipher, 1, bArr3, 0, bArr3.length);
        byte[] bArrD3 = d(cipher, 2, bArr, this.d, i9);
        int length2 = bArr.length - 16;
        byte b9 = 0;
        for (int i10 = 0; i10 < 16; i10++) {
            b9 = (byte) (b9 | (((bArr[length2 + i10] ^ bArrD2[i10]) ^ bArrD[i10]) ^ bArrD3[i10]));
        }
        if (b9 != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher2 = (Cipher) f3767f.get();
        cipher2.init(1, secretKeySpec, new IvParameterSpec(bArrD));
        return cipher2.doFinal(bArr, i8, i9);
    }

    public final byte[] d(Cipher cipher, int i8, byte[] bArr, int i9, int i10) throws BadPaddingException, IllegalBlockSizeException {
        byte[] bArrCopyOf;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i8;
        byte[] bArr3 = this.f3768a;
        if (i10 == 0) {
            return cipher.doFinal(e(bArr2, bArr3));
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        int i11 = 0;
        while (i10 - i11 > 16) {
            for (int i12 = 0; i12 < 16; i12++) {
                bArrDoFinal[i12] = (byte) (bArrDoFinal[i12] ^ bArr[(i9 + i11) + i12]);
            }
            bArrDoFinal = cipher.doFinal(bArrDoFinal);
            i11 += 16;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i11 + i9, i9 + i10);
        if (bArrCopyOfRange.length == 16) {
            bArrCopyOf = e(bArrCopyOfRange, bArr3);
        } else {
            bArrCopyOf = Arrays.copyOf(this.f3769b, 16);
            for (int i13 = 0; i13 < bArrCopyOfRange.length; i13++) {
                bArrCopyOf[i13] = (byte) (bArrCopyOf[i13] ^ bArrCopyOfRange[i13]);
            }
            bArrCopyOf[bArrCopyOfRange.length] = (byte) (bArrCopyOf[bArrCopyOfRange.length] ^ 128);
        }
        return cipher.doFinal(e(bArrDoFinal, bArrCopyOf));
    }
}
