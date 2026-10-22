package l2;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import javax.crypto.AEADBadTagException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import k4.v;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d implements y1.c {

    /* renamed from: c, reason: collision with root package name */
    public static final List f3773c = Arrays.asList(64);
    public static final byte[] d = new byte[16];

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f3774e = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1};

    /* renamed from: a, reason: collision with root package name */
    public final a4.d f3775a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f3776b;

    public d(byte[] bArr) throws GeneralSecurityException {
        if (!a8.b.a(1)) {
            throw new GeneralSecurityException("Can not use AES-SIV in FIPS-mode.");
        }
        if (!f3773c.contains(Integer.valueOf(bArr.length))) {
            throw new InvalidKeyException(m0.f.e(new StringBuilder("invalid key size: "), bArr.length, " bytes; key must have 64 bytes"));
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, bArr.length / 2);
        this.f3776b = Arrays.copyOfRange(bArr, bArr.length / 2, bArr.length);
        this.f3775a = new a4.d(bArrCopyOfRange);
    }

    @Override // y1.c
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length > 2147483631) {
            throw new GeneralSecurityException("plaintext too long");
        }
        Cipher cipher = (Cipher) i.f3785b.f3787a.a("AES/CTR/NoPadding");
        byte[] bArrC = c(bArr2, bArr);
        byte[] bArr3 = (byte[]) bArrC.clone();
        bArr3[8] = (byte) (bArr3[8] & AbstractJsonLexerKt.TC_INVALID);
        bArr3[12] = (byte) (bArr3[12] & AbstractJsonLexerKt.TC_INVALID);
        cipher.init(1, new SecretKeySpec(this.f3776b, "AES"), new IvParameterSpec(bArr3));
        return v.q(bArrC, cipher.doFinal(bArr));
    }

    @Override // y1.c
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length < 16) {
            throw new GeneralSecurityException("Ciphertext too short.");
        }
        Cipher cipher = (Cipher) i.f3785b.f3787a.a("AES/CTR/NoPadding");
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 16);
        byte[] bArr3 = (byte[]) bArrCopyOfRange.clone();
        bArr3[8] = (byte) (bArr3[8] & AbstractJsonLexerKt.TC_INVALID);
        bArr3[12] = (byte) (bArr3[12] & AbstractJsonLexerKt.TC_INVALID);
        cipher.init(2, new SecretKeySpec(this.f3776b, "AES"), new IvParameterSpec(bArr3));
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
        byte[] bArrV0;
        int length = bArr.length;
        a4.d dVar = this.f3775a;
        if (length == 0) {
            return dVar.e(f3774e, 16);
        }
        byte[] bArrE = dVar.e(d, 16);
        for (int i8 = 0; i8 < bArr.length - 1; i8++) {
            byte[] bArr2 = bArr[i8];
            if (bArr2 == null) {
                bArr2 = new byte[0];
            }
            bArrE = v.v0(a.a.q(bArrE), dVar.e(bArr2, 16));
        }
        byte[] bArr3 = bArr[bArr.length - 1];
        if (bArr3.length >= 16) {
            if (bArr3.length < bArrE.length) {
                throw new IllegalArgumentException("xorEnd requires a.length >= b.length");
            }
            int length2 = bArr3.length - bArrE.length;
            bArrV0 = Arrays.copyOf(bArr3, bArr3.length);
            for (int i9 = 0; i9 < bArrE.length; i9++) {
                int i10 = length2 + i9;
                bArrV0[i10] = (byte) (bArrV0[i10] ^ bArrE[i9]);
            }
        } else {
            if (bArr3.length >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr3, 16);
            bArrCopyOf[bArr3.length] = -128;
            bArrV0 = v.v0(bArrCopyOf, a.a.q(bArrE));
        }
        return dVar.e(bArrV0, 16);
    }
}
