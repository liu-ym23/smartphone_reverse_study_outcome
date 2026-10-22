package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class KeyParameter implements CipherParameters {
    private byte[] key;

    private KeyParameter(int i8) {
        this.key = new byte[i8];
    }

    public void copyTo(byte[] bArr, int i8, int i9) {
        byte[] bArr2 = this.key;
        if (bArr2.length != i9) {
            throw new IllegalArgumentException("len");
        }
        System.arraycopy(bArr2, 0, bArr, i8, i9);
    }

    public byte[] getKey() {
        return this.key;
    }

    public int getKeyLength() {
        return this.key.length;
    }

    public KeyParameter reverse() {
        KeyParameter keyParameter = new KeyParameter(this.key.length);
        Arrays.reverse(this.key, keyParameter.key);
        return keyParameter;
    }

    public KeyParameter(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public KeyParameter(byte[] bArr, int i8, int i9) {
        this(i9);
        System.arraycopy(bArr, i8, this.key, 0, i9);
    }
}
