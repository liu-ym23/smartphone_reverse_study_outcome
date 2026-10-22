package org.bouncycastle.crypto.params;

import java.io.EOFException;
import java.io.InputStream;
import java.security.SecureRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;
import v7.a;
import v7.f;

/* loaded from: classes.dex */
public final class X25519PrivateKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 32;
    public static final int SECRET_SIZE = 32;
    private final byte[] data;

    public X25519PrivateKeyParameters(InputStream inputStream) throws EOFException {
        super(true);
        byte[] bArr = new byte[32];
        this.data = bArr;
        if (32 != Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of X25519 private key");
        }
    }

    private static byte[] validate(byte[] bArr) {
        if (bArr.length == 32) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 32");
    }

    public void encode(byte[] bArr, int i8) {
        System.arraycopy(this.data, 0, bArr, i8, 32);
    }

    public X25519PublicKeyParameters generatePublicKey() {
        byte[] bArr = new byte[32];
        int[] iArr = new int[10];
        int[] iArr2 = new int[10];
        byte[] bArr2 = new byte[32];
        f.R(this.data, bArr2);
        a aVar = new a();
        f.V(bArr2, aVar);
        int[] iArr3 = new int[10];
        int[] iArr4 = new int[10];
        int[] iArr5 = new int[10];
        int[] iArr6 = new int[10];
        u7.a.M(aVar.f5995a, iArr4);
        u7.a.M(aVar.f5996b, iArr5);
        u7.a.M(aVar.f5997c, iArr6);
        u7.a.E(iArr4, iArr5, iArr3);
        u7.a.P(iArr4, iArr5, iArr4);
        u7.a.E(iArr4, iArr6, iArr4);
        u7.a.M(iArr6, iArr6);
        u7.a.E(iArr3, f.f6015i, iArr3);
        u7.a.a(iArr3, iArr6, iArr3);
        u7.a.a(iArr3, iArr4, iArr3);
        u7.a.H(iArr3);
        u7.a.H(iArr5);
        u7.a.H(iArr6);
        if ((u7.a.A(iArr3) & (~u7.a.A(iArr5)) & (~u7.a.A(iArr6))) == 0) {
            throw new IllegalStateException();
        }
        u7.a.j(0, 0, aVar.f5996b, iArr);
        u7.a.j(0, 0, aVar.f5997c, iArr2);
        u7.a.c(iArr2, iArr, iArr, iArr2);
        u7.a.y(iArr2, iArr2);
        u7.a.E(iArr, iArr2, iArr);
        u7.a.H(iArr);
        u7.a.u(bArr, iArr, 0, 0);
        u7.a.u(bArr, iArr, 5, 16);
        return new X25519PublicKeyParameters(bArr, 0);
    }

    public void generateSecret(X25519PublicKeyParameters x25519PublicKeyParameters, byte[] bArr, int i8) {
        byte[] bArr2 = new byte[32];
        x25519PublicKeyParameters.encode(bArr2, 0);
        byte[] bArr3 = this.data;
        int[] iArr = new int[8];
        for (int i9 = 0; i9 < 8; i9++) {
            int i10 = i9 * 4;
            iArr[i9] = ((bArr3[i10 + 2] & 255) << 16) | (bArr3[i10] & 255) | ((bArr3[i10 + 1] & 255) << 8) | (bArr3[i10 + 3] << 24);
        }
        iArr[0] = iArr[0] & (-8);
        int i11 = iArr[7] & Integer.MAX_VALUE;
        iArr[7] = i11;
        iArr[7] = i11 | 1073741824;
        int[] iArr2 = new int[10];
        u7.a.o(bArr2, iArr2, 0, 0);
        u7.a.o(bArr2, iArr2, 16, 5);
        iArr2[9] = iArr2[9] & 16777215;
        int[] iArr3 = new int[10];
        u7.a.j(0, 0, iArr2, iArr3);
        int[] iArr4 = new int[10];
        boolean z = true;
        iArr4[0] = 1;
        int[] iArr5 = new int[10];
        iArr5[0] = 1;
        int[] iArr6 = new int[10];
        int[] iArr7 = new int[10];
        int[] iArr8 = new int[10];
        int i12 = 254;
        int i13 = 1;
        while (true) {
            u7.a.c(iArr5, iArr6, iArr7, iArr5);
            u7.a.c(iArr3, iArr4, iArr6, iArr3);
            u7.a.E(iArr7, iArr3, iArr7);
            u7.a.E(iArr5, iArr6, iArr5);
            u7.a.M(iArr6, iArr6);
            u7.a.M(iArr3, iArr3);
            u7.a.P(iArr6, iArr3, iArr8);
            u7.a.D(iArr8, iArr4);
            u7.a.a(iArr4, iArr3, iArr4);
            u7.a.E(iArr4, iArr8, iArr4);
            u7.a.E(iArr3, iArr6, iArr3);
            u7.a.c(iArr7, iArr5, iArr5, iArr6);
            u7.a.M(iArr5, iArr5);
            u7.a.M(iArr6, iArr6);
            u7.a.E(iArr6, iArr2, iArr6);
            boolean z2 = z;
            int i14 = i12 - 1;
            int i15 = (iArr[i14 >>> 5] >>> (i14 & 31)) & 1;
            int i16 = i13 ^ i15;
            u7.a.l(i16, iArr3, iArr5);
            u7.a.l(i16, iArr4, iArr6);
            if (i14 < 3) {
                break;
            }
            i13 = i15;
            i12 = i14;
            z = z2;
        }
        for (int i17 = 0; i17 < 3; i17++) {
            int[] iArr9 = new int[10];
            int[] iArr10 = new int[10];
            u7.a.c(iArr3, iArr4, iArr9, iArr10);
            u7.a.M(iArr9, iArr9);
            u7.a.M(iArr10, iArr10);
            u7.a.E(iArr9, iArr10, iArr3);
            u7.a.P(iArr9, iArr10, iArr9);
            u7.a.D(iArr9, iArr4);
            u7.a.a(iArr4, iArr10, iArr4);
            u7.a.E(iArr4, iArr9, iArr4);
        }
        u7.a.y(iArr4, iArr4);
        u7.a.E(iArr3, iArr4, iArr3);
        u7.a.H(iArr3);
        u7.a.u(bArr, iArr3, 0, i8);
        u7.a.u(bArr, iArr3, 5, i8 + 16);
        if (Arrays.areAllZeroes(bArr, i8, 32)) {
            throw new IllegalStateException("X25519 agreement failed");
        }
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }

    public X25519PrivateKeyParameters(SecureRandom secureRandom) {
        super(true);
        byte[] bArr = new byte[32];
        this.data = bArr;
        if (bArr.length != 32) {
            throw new IllegalArgumentException("k");
        }
        secureRandom.nextBytes(bArr);
        u7.a.e(bArr);
    }

    public X25519PrivateKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public X25519PrivateKeyParameters(byte[] bArr, int i8) {
        super(true);
        byte[] bArr2 = new byte[32];
        this.data = bArr2;
        System.arraycopy(bArr, i8, bArr2, 0, 32);
    }
}
