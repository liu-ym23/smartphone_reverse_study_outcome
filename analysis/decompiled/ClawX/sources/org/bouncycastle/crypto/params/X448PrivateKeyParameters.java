package org.bouncycastle.crypto.params;

import java.io.EOFException;
import java.io.InputStream;
import java.security.SecureRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;
import u7.a;
import v7.d;
import v7.f;

/* loaded from: classes.dex */
public final class X448PrivateKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 56;
    public static final int SECRET_SIZE = 56;
    private final byte[] data;

    public X448PrivateKeyParameters(InputStream inputStream) throws EOFException {
        super(true);
        byte[] bArr = new byte[56];
        this.data = bArr;
        if (56 != Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of X448 private key");
        }
    }

    private static byte[] validate(byte[] bArr) {
        if (bArr.length == 56) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 56");
    }

    public void encode(byte[] bArr, int i8) {
        System.arraycopy(this.data, 0, bArr, i8, 56);
    }

    public X448PublicKeyParameters generatePublicKey() {
        byte[] bArr = new byte[56];
        int[] iArr = new int[16];
        int[] iArr2 = new int[16];
        byte[] bArr2 = new byte[57];
        f.S(this.data, bArr2);
        d dVar = new d(1);
        f.W(bArr2, dVar);
        int[] iArr3 = new int[16];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[16];
        int[] iArr6 = new int[16];
        a.O(dVar.f6004a, iArr4);
        a.O(dVar.f6005b, iArr5);
        a.O(dVar.f6006c, iArr6);
        a.F(iArr4, iArr5, iArr3);
        a.b(iArr4, iArr5, iArr4);
        a.F(iArr4, iArr6, iArr4);
        a.O(iArr6, iArr6);
        a.C(39081, iArr3, iArr3);
        a.Q(iArr3, iArr6, iArr3);
        a.b(iArr3, iArr4, iArr3);
        a.K(1, iArr3);
        a.K(-1, iArr3);
        a.K(1, iArr5);
        a.K(-1, iArr5);
        a.K(1, iArr6);
        a.K(-1, iArr6);
        if (((~a.B(iArr6)) & a.B(iArr3) & (~a.B(iArr5))) == 0) {
            throw new IllegalStateException();
        }
        a.k(0, 0, dVar.f6004a, iArr);
        a.k(0, 0, dVar.f6005b, iArr2);
        a.z(iArr, iArr);
        a.F(iArr, iArr2, iArr);
        a.O(iArr, iArr);
        a.K(1, iArr);
        a.K(-1, iArr);
        a.s(bArr, 0, iArr);
        return new X448PublicKeyParameters(bArr, 0);
    }

    public void generateSecret(X448PublicKeyParameters x448PublicKeyParameters, byte[] bArr, int i8) {
        byte[] bArr2 = new byte[56];
        x448PublicKeyParameters.encode(bArr2, 0);
        byte[] bArr3 = this.data;
        int[] iArr = new int[14];
        for (int i9 = 0; i9 < 14; i9++) {
            int i10 = i9 * 4;
            iArr[i9] = ((bArr3[i10 + 1] & 255) << 8) | (bArr3[i10] & 255) | ((bArr3[i10 + 2] & 255) << 16) | (bArr3[i10 + 3] << 24);
        }
        iArr[0] = iArr[0] & (-4);
        iArr[13] = iArr[13] | Integer.MIN_VALUE;
        int[] iArr2 = new int[16];
        a.r(bArr2, iArr2, 0, 0);
        a.r(bArr2, iArr2, 7, 2);
        a.r(bArr2, iArr2, 14, 4);
        a.r(bArr2, iArr2, 21, 6);
        a.r(bArr2, iArr2, 28, 8);
        a.r(bArr2, iArr2, 35, 10);
        a.r(bArr2, iArr2, 42, 12);
        a.r(bArr2, iArr2, 49, 14);
        int[] iArr3 = new int[16];
        a.k(0, 0, iArr2, iArr3);
        int[] iArr4 = new int[16];
        iArr4[0] = 1;
        int[] iArr5 = new int[16];
        iArr5[0] = 1;
        int[] iArr6 = new int[16];
        int[] iArr7 = new int[16];
        int[] iArr8 = new int[16];
        int i11 = 447;
        int i12 = 1;
        while (true) {
            a.b(iArr5, iArr6, iArr7);
            a.Q(iArr5, iArr6, iArr5);
            a.b(iArr3, iArr4, iArr6);
            a.Q(iArr3, iArr4, iArr3);
            a.F(iArr7, iArr3, iArr7);
            a.F(iArr5, iArr6, iArr5);
            a.O(iArr6, iArr6);
            a.O(iArr3, iArr3);
            a.Q(iArr6, iArr3, iArr8);
            a.C(39082, iArr8, iArr4);
            a.b(iArr4, iArr3, iArr4);
            a.F(iArr4, iArr8, iArr4);
            a.F(iArr3, iArr6, iArr3);
            a.Q(iArr7, iArr5, iArr6);
            a.b(iArr7, iArr5, iArr5);
            a.O(iArr5, iArr5);
            a.O(iArr6, iArr6);
            a.F(iArr6, iArr2, iArr6);
            i11--;
            int i13 = (iArr[i11 >>> 5] >>> (i11 & 31)) & 1;
            int i14 = i12 ^ i13;
            a.m(i14, iArr3, iArr5);
            a.m(i14, iArr4, iArr6);
            if (i11 < 2) {
                break;
            } else {
                i12 = i13;
            }
        }
        for (int i15 = 0; i15 < 2; i15++) {
            int[] iArr9 = new int[16];
            int[] iArr10 = new int[16];
            a.b(iArr3, iArr4, iArr9);
            a.Q(iArr3, iArr4, iArr10);
            a.O(iArr9, iArr9);
            a.O(iArr10, iArr10);
            a.F(iArr9, iArr10, iArr3);
            a.Q(iArr9, iArr10, iArr9);
            a.C(39082, iArr9, iArr4);
            a.b(iArr4, iArr10, iArr4);
            a.F(iArr4, iArr9, iArr4);
        }
        a.z(iArr4, iArr4);
        a.F(iArr3, iArr4, iArr3);
        a.K(1, iArr3);
        a.K(-1, iArr3);
        a.s(bArr, i8, iArr3);
        if (Arrays.areAllZeroes(bArr, i8, 56)) {
            throw new IllegalStateException("X448 agreement failed");
        }
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }

    public X448PrivateKeyParameters(SecureRandom secureRandom) {
        super(true);
        byte[] bArr = new byte[56];
        this.data = bArr;
        if (bArr.length != 56) {
            throw new IllegalArgumentException("k");
        }
        secureRandom.nextBytes(bArr);
        a.f(bArr);
    }

    public X448PrivateKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public X448PrivateKeyParameters(byte[] bArr, int i8) {
        super(true);
        byte[] bArr2 = new byte[56];
        this.data = bArr2;
        System.arraycopy(bArr, i8, bArr2, 0, 56);
    }
}
