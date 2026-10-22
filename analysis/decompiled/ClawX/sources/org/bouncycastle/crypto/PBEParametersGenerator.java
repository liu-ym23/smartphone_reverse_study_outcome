package org.bouncycastle.crypto;

import org.bouncycastle.util.Strings;

/* loaded from: classes.dex */
public abstract class PBEParametersGenerator {
    protected int iterationCount;
    protected byte[] password;
    protected byte[] salt;

    public static byte[] PKCS12PasswordToBytes(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(cArr.length + 1) * 2];
        for (int i8 = 0; i8 != cArr.length; i8++) {
            int i9 = i8 * 2;
            char c3 = cArr[i8];
            bArr[i9] = (byte) (c3 >>> '\b');
            bArr[i9 + 1] = (byte) c3;
        }
        return bArr;
    }

    public static byte[] PKCS5PasswordToBytes(char[] cArr) {
        if (cArr == null) {
            return new byte[0];
        }
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i8 = 0; i8 != length; i8++) {
            bArr[i8] = (byte) cArr[i8];
        }
        return bArr;
    }

    public static byte[] PKCS5PasswordToUTF8Bytes(char[] cArr) {
        return cArr != null ? Strings.toUTF8ByteArray(cArr) : new byte[0];
    }

    public abstract CipherParameters generateDerivedMacParameters(int i8);

    public abstract CipherParameters generateDerivedParameters(int i8);

    public abstract CipherParameters generateDerivedParameters(int i8, int i9);

    public int getIterationCount() {
        return this.iterationCount;
    }

    public byte[] getPassword() {
        return this.password;
    }

    public byte[] getSalt() {
        return this.salt;
    }

    public void init(byte[] bArr, byte[] bArr2, int i8) {
        this.password = bArr;
        this.salt = bArr2;
        this.iterationCount = i8;
    }
}
