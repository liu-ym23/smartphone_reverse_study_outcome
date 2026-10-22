package com.baidu.b.c.d;

import B0.g;
import androidx.room.AbstractC0351g;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.MGF1ParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import kotlin.UByte;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final Map f4861a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b, reason: collision with root package name */
    private final int f4862b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4863c;

    /* renamed from: d, reason: collision with root package name */
    private SecureRandom f4864d;

    /* renamed from: e, reason: collision with root package name */
    private final int f4865e;

    /* renamed from: f, reason: collision with root package name */
    private MessageDigest f4866f;

    /* renamed from: g, reason: collision with root package name */
    private MessageDigest f4867g;

    /* renamed from: h, reason: collision with root package name */
    private byte[] f4868h;

    private f(int i4, int i5, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] value;
        String str;
        this.f4862b = i4;
        this.f4863c = i5;
        this.f4864d = secureRandom;
        if (i5 < 64) {
            throw new InvalidKeyException("Padded size must be at least 64");
        }
        if (i4 == 1 || i4 == 2) {
            i5 -= 11;
        } else if (i4 != 3) {
            if (i4 != 4) {
                throw new InvalidKeyException(AbstractC0351g.m("Invalid padding: ", i4));
            }
            String str2 = "SHA-1";
            if (oAEPParameterSpec != null) {
                try {
                    String digestAlgorithm = oAEPParameterSpec.getDigestAlgorithm();
                    String mGFAlgorithm = oAEPParameterSpec.getMGFAlgorithm();
                    if (!mGFAlgorithm.equalsIgnoreCase("MGF1")) {
                        throw new InvalidAlgorithmParameterException("Unsupported MGF algo: ".concat(mGFAlgorithm));
                    }
                    String digestAlgorithm2 = ((MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters()).getDigestAlgorithm();
                    PSource pSource = oAEPParameterSpec.getPSource();
                    String algorithm = pSource.getAlgorithm();
                    if (!algorithm.equalsIgnoreCase("PSpecified")) {
                        throw new InvalidAlgorithmParameterException("Unsupported pSource algo: ".concat(algorithm));
                    }
                    value = ((PSource.PSpecified) pSource).getValue();
                    str = digestAlgorithm;
                    str2 = digestAlgorithm2;
                } catch (NoSuchAlgorithmException e4) {
                    e = e4;
                    throw new InvalidKeyException(g.n("Digest ", str2, " not available"), e);
                }
            } else {
                value = null;
                str = "SHA-1";
            }
            try {
                this.f4866f = MessageDigest.getInstance(str);
                this.f4867g = MessageDigest.getInstance(str2);
                byte[] bArrA = a(this.f4866f, value);
                this.f4868h = bArrA;
                int length = (i5 - 2) - (bArrA.length * 2);
                this.f4865e = length;
                if (length > 0) {
                    return;
                }
                throw new InvalidKeyException("Key is too short for encryption using OAEPPadding with " + str + " and MGF1" + str2);
            } catch (NoSuchAlgorithmException e5) {
                e = e5;
                str2 = str;
                throw new InvalidKeyException(g.n("Digest ", str2, " not available"), e);
            }
        }
        this.f4865e = i5;
    }

    private byte[] c(byte[] bArr) throws BadPaddingException {
        int i4;
        int i5;
        int i6 = this.f4863c;
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, 0, bArr2, i6 - bArr.length, bArr.length);
        int length = (this.f4863c - 3) - bArr.length;
        bArr2[0] = 0;
        int i7 = this.f4862b;
        bArr2[1] = (byte) i7;
        int i8 = -1;
        int i9 = 2;
        if (i7 != 1) {
            if (this.f4864d == null) {
                this.f4864d = b.f4848a;
            }
            byte[] bArr3 = new byte[64];
            while (true) {
                int i10 = length - 1;
                if (length <= 0) {
                    break;
                }
                while (true) {
                    if (i8 < 0) {
                        this.f4864d.nextBytes(bArr3);
                        i8 = 63;
                    }
                    i4 = i8 - 1;
                    i5 = bArr3[i8] & UByte.MAX_VALUE;
                    if (i5 != 0) {
                        break;
                    }
                    i8 = i4;
                }
                bArr2[i9] = (byte) i5;
                i8 = i4;
                length = i10;
                i9++;
            }
        } else {
            while (true) {
                int i11 = length - 1;
                if (length <= 0) {
                    break;
                }
                bArr2[i9] = -1;
                length = i11;
                i9++;
            }
        }
        return bArr2;
    }

    private byte[] d(byte[] bArr) throws BadPaddingException {
        if (bArr[0] != 0) {
            throw new BadPaddingException("Data must start with zero");
        }
        if (bArr[1] != this.f4862b) {
            throw new BadPaddingException("Blocktype mismatch: " + ((int) bArr[1]));
        }
        int i4 = 2;
        while (true) {
            int i5 = i4 + 1;
            int i6 = bArr[i4] & UByte.MAX_VALUE;
            if (i6 == 0) {
                int length = bArr.length - i5;
                if (length > this.f4865e) {
                    throw new BadPaddingException("Padding string too short");
                }
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, bArr.length - length, bArr2, 0, length);
                return bArr2;
            }
            if (i5 == bArr.length) {
                throw new BadPaddingException("Padding string not terminated");
            }
            if (this.f4862b == 1 && i6 != 255) {
                throw new BadPaddingException(AbstractC0351g.m("Padding byte not 0xff: ", i6));
            }
            i4 = i5;
        }
    }

    private byte[] e(byte[] bArr) throws BadPaddingException, DigestException {
        if (this.f4864d == null) {
            this.f4864d = b.f4848a;
        }
        int length = this.f4868h.length;
        byte[] bArr2 = new byte[length];
        this.f4864d.nextBytes(bArr2);
        int i4 = this.f4863c;
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr2, 0, bArr3, 1, length);
        int i5 = length + 1;
        int i6 = i4 - i5;
        int length2 = this.f4863c - bArr.length;
        System.arraycopy(this.f4868h, 0, bArr3, i5, length);
        bArr3[length2 - 1] = 1;
        System.arraycopy(bArr, 0, bArr3, length2, bArr.length);
        a(bArr3, 1, length, bArr3, i5, i6);
        a(bArr3, i5, i6, bArr3, 1, length);
        return bArr3;
    }

    private byte[] f(byte[] bArr) throws BadPaddingException, DigestException {
        int length = this.f4868h.length;
        if (bArr[0] != 0) {
            throw new BadPaddingException("Data must start with zero");
        }
        int i4 = length + 1;
        int length2 = bArr.length - i4;
        a(bArr, i4, length2, bArr, 1, length);
        a(bArr, 1, length, bArr, i4, length2);
        for (int i5 = 0; i5 < length; i5++) {
            if (this.f4868h[i5] != bArr[i4 + i5]) {
                throw new BadPaddingException("lHash mismatch");
            }
        }
        int i6 = i4 + length;
        do {
            byte b4 = bArr[i6];
            if (b4 != 0) {
                int i7 = i6 + 1;
                if (b4 != 1) {
                    throw new BadPaddingException("Padding string not terminated by 0x01 byte");
                }
                int length3 = bArr.length - i7;
                byte[] bArr2 = new byte[length3];
                System.arraycopy(bArr, i7, bArr2, 0, length3);
                return bArr2;
            }
            i6++;
        } while (i6 < bArr.length);
        throw new BadPaddingException("Padding string not terminated");
    }

    public int a() {
        return this.f4865e;
    }

    public byte[] b(byte[] bArr) throws BadPaddingException {
        if (bArr.length != this.f4863c) {
            throw new BadPaddingException("Padded length must be " + this.f4863c);
        }
        int i4 = this.f4862b;
        if (i4 == 1 || i4 == 2) {
            return d(bArr);
        }
        if (i4 == 3) {
            return bArr;
        }
        if (i4 == 4) {
            return f(bArr);
        }
        throw new AssertionError();
    }

    public static f a(int i4, int i5, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        return new f(i4, i5, secureRandom, null);
    }

    public static f a(int i4, int i5, SecureRandom secureRandom, OAEPParameterSpec oAEPParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        return new f(i4, i5, secureRandom, oAEPParameterSpec);
    }

    private void a(byte[] bArr, int i4, int i5, byte[] bArr2, int i6, int i7) throws BadPaddingException, DigestException {
        byte[] bArr3 = new byte[4];
        byte[] bArr4 = new byte[20];
        while (i7 > 0) {
            this.f4867g.update(bArr, i4, i5);
            this.f4867g.update(bArr3);
            try {
                this.f4867g.digest(bArr4, 0, 20);
                for (int i8 = 0; i8 < 20 && i7 > 0; i8++) {
                    bArr2[i6] = (byte) (bArr4[i8] ^ bArr2[i6]);
                    i7--;
                    i6++;
                }
                if (i7 > 0) {
                    int i9 = 3;
                    while (true) {
                        byte b4 = (byte) (bArr3[i9] + 1);
                        bArr3[i9] = b4;
                        if (b4 != 0 || i9 <= 0) {
                            break;
                        } else {
                            i9--;
                        }
                    }
                }
            } catch (DigestException e4) {
                throw new BadPaddingException(e4.toString());
            }
        }
    }

    private static byte[] a(MessageDigest messageDigest, byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return messageDigest.digest(bArr);
        }
        String algorithm = messageDigest.getAlgorithm();
        Map map = f4861a;
        byte[] bArr2 = (byte[]) map.get(algorithm);
        if (bArr2 != null) {
            return bArr2;
        }
        byte[] bArrDigest = messageDigest.digest();
        map.put(algorithm, bArrDigest);
        return bArrDigest;
    }

    public byte[] a(byte[] bArr) throws BadPaddingException {
        if (bArr.length > this.f4865e) {
            throw new BadPaddingException("Data must be shorter than " + (this.f4865e + 1) + " bytes");
        }
        int i4 = this.f4862b;
        if (i4 == 1 || i4 == 2) {
            return c(bArr);
        }
        if (i4 == 3) {
            return bArr;
        }
        if (i4 == 4) {
            return e(bArr);
        }
        throw new AssertionError();
    }

    public byte[] a(byte[] bArr, int i4, int i5) throws BadPaddingException {
        return a(b.a(bArr, i4, i5));
    }
}
