package org.bouncycastle.crypto.params;

import java.io.EOFException;
import java.io.InputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.util.io.Streams;
import u7.a;
import v7.b;
import v7.f;
import v7.h;

/* loaded from: classes.dex */
public final class Ed448PublicKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 57;
    private final h publicPoint;

    public Ed448PublicKeyParameters(InputStream inputStream) throws EOFException {
        super(false);
        byte[] bArr = new byte[57];
        if (57 != Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of Ed448 public key");
        }
        this.publicPoint = parse(bArr, 0);
    }

    private static h parse(byte[] bArr, int i8) {
        byte[] bArr2 = new byte[57];
        System.arraycopy(bArr, i8, bArr2, 0, 57);
        int[] iArr = f.f6023q;
        h hVar = null;
        if ((bArr2[56] & AbstractJsonLexerKt.TC_INVALID) == 0) {
            int iG = f.g(bArr2, 52);
            int i9 = iArr[13] ^ iG;
            int i10 = 12;
            while (true) {
                if (i10 > 0) {
                    int iG2 = f.g(bArr2, i10 * 4);
                    if (i9 == 0 && iG2 - Integer.MIN_VALUE > iArr[i10] - Integer.MIN_VALUE) {
                        break;
                    }
                    iG |= iG2;
                    i9 |= iArr[i10] ^ iG2;
                    i10--;
                } else {
                    int iG3 = f.g(bArr2, 0);
                    if ((iG != 0 || iG3 - Integer.MIN_VALUE > -2147483647) && (i9 != 0 || iG3 - Integer.MIN_VALUE < iArr[0] - (-2147483647))) {
                        b bVar = new b(2);
                        if (f.j(bArr2, false, bVar)) {
                            int[] iArr2 = new int[32];
                            a.k(0, 0, bVar.f5999a, iArr2);
                            a.k(0, 16, bVar.f6000b, iArr2);
                            hVar = new h(iArr2);
                        }
                    }
                }
            }
        }
        if (hVar != null) {
            return hVar;
        }
        throw new IllegalArgumentException("invalid public key");
    }

    private static byte[] validate(byte[] bArr) {
        if (bArr.length == 57) {
            return bArr;
        }
        throw new IllegalArgumentException("'buf' must have length 57");
    }

    public void encode(byte[] bArr, int i8) {
        f.q(this.publicPoint, bArr, i8);
    }

    public byte[] getEncoded() {
        byte[] bArr = new byte[57];
        encode(bArr, 0);
        return bArr;
    }

    public boolean verify(int i8, byte[] bArr, byte[] bArr2, int i9, int i10, byte[] bArr3, int i11) {
        if (i8 == 0) {
            if (bArr == null) {
                throw new NullPointerException("'ctx' cannot be null");
            }
            if (bArr.length <= 255) {
                return f.z(bArr3, i11, this.publicPoint, bArr, (byte) 0, bArr2, i9, i10);
            }
            throw new IllegalArgumentException("ctx");
        }
        if (i8 != 1) {
            throw new IllegalArgumentException("algorithm");
        }
        if (bArr == null) {
            throw new NullPointerException("'ctx' cannot be null");
        }
        if (bArr.length > 255) {
            throw new IllegalArgumentException("ctx");
        }
        if (64 == i10) {
            return f.z(bArr3, i11, this.publicPoint, bArr, (byte) 1, bArr2, i9, 64);
        }
        throw new IllegalArgumentException("msgLen");
    }

    public Ed448PublicKeyParameters(h hVar) {
        super(false);
        if (hVar == null) {
            throw new NullPointerException("'publicPoint' cannot be null");
        }
        this.publicPoint = hVar;
    }

    public Ed448PublicKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public Ed448PublicKeyParameters(byte[] bArr, int i8) {
        super(false);
        this.publicPoint = parse(bArr, i8);
    }
}
