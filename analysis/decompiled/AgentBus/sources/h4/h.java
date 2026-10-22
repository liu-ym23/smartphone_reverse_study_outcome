package h4;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import w7.e0;

/* loaded from: classes.dex */
public final class h implements t3.c {

    /* renamed from: c, reason: collision with root package name */
    public static final List f4136c = Arrays.asList(64);

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f4137d = new byte[16];

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f4138e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    /* renamed from: a, reason: collision with root package name */
    public final i5.l f4139a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f4140b;

    public h(byte[] bArr) throws GeneralSecurityException {
        if (!m.x.a(1)) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        if (f4136c.contains(Integer.valueOf(bArr.length))) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
            this.f4140b = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
            this.f4139a = new i5.l(bArrCopyOfRange);
        } else {
            throw new InvalidKeyException("invalid key size: " + bArr.length + " bytes; key must have 64 bytes");
        }
    }

    @Override // t3.c
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483631) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher cipher = (Cipher) m.f4149b.f4151a.a("AES/CTR/NoPadding");
        byte[] bArrC = c(bArr2, bArr);
        byte[] bArr3 = (byte[]) bArrC.clone();
        bArr3[8] = (byte) (bArr3[8] & 127);
        bArr3[12] = (byte) (bArr3[12] & 127);
        cipher.init(1, new SecretKeySpec(this.f4140b, "AES"), new IvParameterSpec(bArr3));
        return e0.k(bArrC, cipher.doFinal(bArr));
    }

    @Override // t3.c
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        Cipher cipher = (Cipher) m.f4149b.f4151a.a("AES/CTR/NoPadding");
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 16);
        byte[] bArr3 = (byte[]) bArrCopyOfRange.clone();
        bArr3[8] = (byte) (bArr3[8] & 127);
        bArr3[12] = (byte) (bArr3[12] & 127);
        cipher.init(2, new SecretKeySpec(this.f4140b, "AES"), new IvParameterSpec(bArr3));
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, 16, bArr.length);
        byte[] bArrDoFinal = cipher.doFinal(bArrCopyOfRange2);
        if (bArrCopyOfRange2.length == 0 && bArrDoFinal == null && "The Android Project".equals(System.getProperty("java.vendor"))) {
            bArrDoFinal = new byte[0];
        }
        if (MessageDigest.isEqual(bArrCopyOfRange, c(bArr2, bArrDoFinal))) {
            return bArrDoFinal;
        }
        throw new AEADBadTagException("Integrity check failed.");
    }

    public final byte[] c(byte[]... bArr) throws GeneralSecurityException {
        byte[] bArrR;
        int length = bArr.length;
        i5.l lVar = this.f4139a;
        if (length == 0) {
            return lVar.i(16, f4138e);
        }
        byte[] bArrI = lVar.i(16, f4137d);
        for (int i2 = 0; i2 < bArr.length - 1; i2++) {
            byte[] bArr2 = bArr[i2];
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            bArrI = e0.R(a.a.n(bArrI), lVar.i(16, bArr2));
        }
        byte[] bArr3 = bArr[bArr.length - 1];
        if (bArr3.length >= 16) {
            if (bArr3.length < bArrI.length) {
                throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
            }
            int length2 = bArr3.length - bArrI.length;
            bArrR = Arrays.copyOf(bArr3, bArr3.length);
            for (int i10 = 0; i10 < bArrI.length; i10++) {
                int i11 = length2 + i10;
                bArrR[i11] = (byte) (bArrR[i11] ^ bArrI[i10]);
            }
        } else {
            if (bArr3.length >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr3, 16);
            bArrCopyOf[bArr3.length] = -128;
            bArrR = e0.R(bArrCopyOf, a.a.n(bArrI));
        }
        return lVar.i(16, bArrR);
    }
}
