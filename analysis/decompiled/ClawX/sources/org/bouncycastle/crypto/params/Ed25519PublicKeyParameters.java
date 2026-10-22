package org.bouncycastle.crypto.params;

import java.io.EOFException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;
import u7.a;
import v7.b;
import v7.e;
import v7.f;

/* loaded from: classes.dex */
public final class Ed25519PublicKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 32;
    private final e publicPoint;

    public Ed25519PublicKeyParameters(InputStream inputStream) throws EOFException {
        super(false);
        byte[] bArr = new byte[32];
        if (32 != Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of Ed25519 public key");
        }
        this.publicPoint = parse(bArr, 0);
    }

    private static e parse(byte[] bArr, int i8) {
        boolean z;
        byte[] bArr2 = new byte[32];
        System.arraycopy(bArr, i8, bArr2, 0, 32);
        int iG = f.g(bArr2, 28) & Integer.MAX_VALUE;
        int[] iArr = f.f6009b;
        int i9 = iArr[7] ^ iG;
        int[] iArr2 = f.f6010c;
        int i10 = iArr2[7] ^ iG;
        int[] iArr3 = f.d;
        int i11 = iArr3[7] ^ iG;
        for (int i12 = 6; i12 > 0; i12--) {
            int iG2 = f.g(bArr2, i12 * 4);
            iG |= iG2;
            i9 |= iArr[i12] ^ iG2;
            i10 |= iArr2[i12] ^ iG2;
            i11 |= iG2 ^ iArr3[i12];
        }
        int iG3 = f.g(bArr2, 0);
        if ((iG != 0 || iG3 - Integer.MIN_VALUE > -2147483647) && (i9 != 0 || Integer.MIN_VALUE + iG3 < iArr[0] - (-2147483647))) {
            z = (((iArr2[0] ^ iG3) | i10) != 0) & (((iArr3[0] ^ iG3) | i11) != 0);
        } else {
            z = false;
        }
        e eVar = null;
        if (z) {
            b bVar = new b(0);
            if (f.i(bArr2, false, bVar)) {
                int[] iArr4 = new int[20];
                a.j(0, 0, bVar.f5999a, iArr4);
                a.j(0, 10, bVar.f6000b, iArr4);
                eVar = new e(iArr4);
            }
        }
        if (eVar != null) {
            return eVar;
        }
        throw new IllegalArgumentException("invalid public key");
    }

    private static byte[] validate(byte[] bArr) {
        if (bArr.length == 32) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 32");
    }

    public void encode(byte[] bArr, int i8) {
        f.p(this.publicPoint, bArr, i8);
    }

    public byte[] getEncoded() {
        byte[] bArr = new byte[32];
        encode(bArr, 0);
        return bArr;
    }

    public boolean verify(int i8, byte[] bArr, byte[] bArr2, int i9, int i10, byte[] bArr3, int i11) {
        if (i8 == 0) {
            if (bArr == null) {
                return f.y(bArr3, i11, this.publicPoint, null, (byte) 0, bArr2, i9, i10);
            }
            throw new IllegalArgumentException("ctx");
        }
        if (i8 == 1) {
            if (bArr == null) {
                throw new NullPointerException("'ctx' cannot be null");
            }
            if (bArr.length <= 255) {
                return f.y(bArr3, i11, this.publicPoint, bArr, (byte) 0, bArr2, i9, i10);
            }
            throw new IllegalArgumentException("ctx");
        }
        if (i8 != 2) {
            throw new IllegalArgumentException("algorithm");
        }
        if (bArr == null) {
            throw new NullPointerException("'ctx' cannot be null");
        }
        if (bArr.length > 255) {
            throw new IllegalArgumentException("ctx");
        }
        if (64 == i10) {
            return f.y(bArr3, i11, this.publicPoint, bArr, (byte) 1, bArr2, i9, 64);
        }
        throw new IllegalArgumentException("msgLen");
    }

    public Ed25519PublicKeyParameters(e eVar) {
        super(false);
        if (eVar == null) {
            throw new NullPointerException("'publicPoint' cannot be null");
        }
        this.publicPoint = eVar;
    }

    public Ed25519PublicKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public Ed25519PublicKeyParameters(byte[] bArr, int i8) {
        super(false);
        this.publicPoint = parse(bArr, i8);
    }
}
