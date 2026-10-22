package org.bouncycastle.crypto.params;

import java.io.EOFException;
import java.io.InputStream;
import java.security.SecureRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.Streams;
import v7.f;

/* loaded from: classes.dex */
public final class Ed25519PrivateKeyParameters extends AsymmetricKeyParameter {
    public static final int KEY_SIZE = 32;
    public static final int SIGNATURE_SIZE = 64;
    private Ed25519PublicKeyParameters cachedPublicKey;
    private final byte[] data;

    public Ed25519PrivateKeyParameters(InputStream inputStream) throws EOFException {
        super(true);
        byte[] bArr = new byte[32];
        this.data = bArr;
        if (32 != Streams.readFully(inputStream, bArr)) {
            throw new EOFException("EOF encountered in middle of Ed25519 private key");
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

    public Ed25519PublicKeyParameters generatePublicKey() {
        Ed25519PublicKeyParameters ed25519PublicKeyParameters;
        synchronized (this.data) {
            try {
                if (this.cachedPublicKey == null) {
                    this.cachedPublicKey = new Ed25519PublicKeyParameters(f.r(this.data));
                }
                ed25519PublicKeyParameters = this.cachedPublicKey;
            } catch (Throwable th) {
                throw th;
            }
        }
        return ed25519PublicKeyParameters;
    }

    public byte[] getEncoded() {
        return Arrays.clone(this.data);
    }

    public void sign(int i8, Ed25519PublicKeyParameters ed25519PublicKeyParameters, byte[] bArr, byte[] bArr2, int i9, int i10, byte[] bArr3, int i11) {
        sign(i8, bArr, bArr2, i9, i10, bArr3, i11);
    }

    public Ed25519PrivateKeyParameters(SecureRandom secureRandom) {
        super(true);
        byte[] bArr = new byte[32];
        this.data = bArr;
        if (bArr.length != 32) {
            throw new IllegalArgumentException("k");
        }
        secureRandom.nextBytes(bArr);
    }

    public void sign(int i8, byte[] bArr, byte[] bArr2, int i9, int i10, byte[] bArr3, int i11) {
        byte[] bArr4 = new byte[32];
        generatePublicKey().encode(bArr4, 0);
        if (i8 == 0) {
            if (bArr != null) {
                throw new IllegalArgumentException("ctx");
            }
            f.w(this.data, bArr4, null, (byte) 0, bArr2, i9, i10, bArr3, i11);
            return;
        }
        if (i8 == 1) {
            if (bArr == null) {
                throw new NullPointerException("'ctx' cannot be null");
            }
            if (bArr.length > 255) {
                throw new IllegalArgumentException("ctx");
            }
            f.w(this.data, bArr4, bArr, (byte) 0, bArr2, i9, i10, bArr3, i11);
            return;
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
        if (64 != i10) {
            throw new IllegalArgumentException("msgLen");
        }
        f.w(this.data, bArr4, bArr, (byte) 1, bArr2, i9, 64, bArr3, i11);
    }

    public Ed25519PrivateKeyParameters(byte[] bArr) {
        this(validate(bArr), 0);
    }

    public Ed25519PrivateKeyParameters(byte[] bArr, int i8) {
        super(true);
        byte[] bArr2 = new byte[32];
        this.data = bArr2;
        System.arraycopy(bArr, i8, bArr2, 0, 32);
    }
}
