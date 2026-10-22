package com.google.crypto.tink.subtle;

import b8.z;
import com.google.crypto.tink.KeyWrap;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class Kwp implements KeyWrap {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int MAX_WRAP_KEY_SIZE = 4096;
    static final int MIN_WRAP_KEY_SIZE = 16;
    static final byte[] PREFIX = {-90, 89, 89, -90};
    static final int ROUNDS = 6;
    private final SecretKey aesKey;

    public Kwp(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length == 16 || bArr.length == 32) {
            this.aesKey = new SecretKeySpec(bArr, "AES");
        } else {
            z.l("Unsupported key length");
            throw null;
        }
    }

    private byte[] computeW(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr2.length <= 8 || bArr2.length > 2147483631 || bArr.length != 8) {
            z.l("computeW called with invalid parameters");
            return null;
        }
        int iWrappingSize = wrappingSize(bArr2.length);
        byte[] bArr3 = new byte[iWrappingSize];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, 8, bArr2.length);
        int i = (iWrappingSize / 8) - 1;
        Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        engineFactory.init(1, this.aesKey);
        byte[] bArr4 = new byte[16];
        System.arraycopy(bArr3, 0, bArr4, 0, 8);
        for (int i3 = 0; i3 < 6; i3++) {
            int i10 = 0;
            while (i10 < i) {
                int i11 = i10 + 1;
                int i12 = i11 * 8;
                System.arraycopy(bArr3, i12, bArr4, 8, 8);
                engineFactory.doFinal(bArr4, 0, 16, bArr4);
                int i13 = (i3 * i) + i10 + 1;
                for (int i14 = 0; i14 < 4; i14++) {
                    int i15 = 7 - i14;
                    bArr4[i15] = (byte) (bArr4[i15] ^ ((byte) (i13 & 255)));
                    i13 >>>= 8;
                }
                System.arraycopy(bArr4, 8, bArr3, i12, 8);
                i10 = i11;
            }
        }
        System.arraycopy(bArr4, 0, bArr3, 0, 8);
        return bArr3;
    }

    private byte[] invertW(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length < 24 || bArr.length % 8 != 0) {
            z.l("Incorrect data size");
            return null;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        int length = bArrCopyOf.length / 8;
        int i = length - 1;
        Cipher engineFactory = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        engineFactory.init(2, this.aesKey);
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArrCopyOf, 0, bArr2, 0, 8);
        for (int i3 = 5; i3 >= 0; i3--) {
            for (int i10 = length - 2; i10 >= 0; i10--) {
                int i11 = (i10 + 1) * 8;
                System.arraycopy(bArrCopyOf, i11, bArr2, 8, 8);
                int i12 = (i3 * i) + i10 + 1;
                for (int i13 = 0; i13 < 4; i13++) {
                    int i14 = 7 - i13;
                    bArr2[i14] = (byte) (((byte) (i12 & 255)) ^ bArr2[i14]);
                    i12 >>>= 8;
                }
                engineFactory.doFinal(bArr2, 0, 16, bArr2);
                System.arraycopy(bArr2, 8, bArrCopyOf, i11, 8);
            }
        }
        System.arraycopy(bArr2, 0, bArrCopyOf, 0, 8);
        return bArrCopyOf;
    }

    private int wrappingSize(int i) {
        return (7 - ((i + 7) % 8)) + i + 8;
    }

    @Override // com.google.crypto.tink.KeyWrap
    public byte[] unwrap(byte[] bArr) throws GeneralSecurityException {
        int i;
        if (bArr.length < wrappingSize(16)) {
            z.l("Wrapped key size is too small");
            return null;
        }
        if (bArr.length > wrappingSize(4096)) {
            z.l("Wrapped key size is too large");
            return null;
        }
        if (bArr.length % 8 != 0) {
            z.l("Wrapped key size must be a multiple of 8 bytes");
            return null;
        }
        byte[] bArrInvertW = invertW(bArr);
        boolean z10 = true;
        boolean z11 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= 4) {
                break;
            }
            if (PREFIX[i3] != bArrInvertW[i3]) {
                z10 = false;
            }
            i3++;
        }
        int i10 = 0;
        for (i = 4; i < 8; i++) {
            i10 = (i10 << 8) + (bArrInvertW[i] & 255);
        }
        if (wrappingSize(i10) == bArrInvertW.length) {
            for (int i11 = i10 + 8; i11 < bArrInvertW.length; i11++) {
                if (bArrInvertW[i11] != 0) {
                    z10 = false;
                }
            }
            z11 = z10;
        }
        if (z11) {
            return Arrays.copyOfRange(bArrInvertW, 8, i10 + 8);
        }
        throw new BadPaddingException("Invalid padding");
    }

    @Override // com.google.crypto.tink.KeyWrap
    public byte[] wrap(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length < 16) {
            z.l("Key size of key to wrap too small");
            return null;
        }
        if (bArr.length > 4096) {
            z.l("Key size of key to wrap too large");
            return null;
        }
        byte[] bArr2 = new byte[8];
        byte[] bArr3 = PREFIX;
        System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
        for (int i = 0; i < 4; i++) {
            bArr2[i + 4] = (byte) ((bArr.length >> ((3 - i) * 8)) & 255);
        }
        return computeW(bArr2, bArr);
    }
}
