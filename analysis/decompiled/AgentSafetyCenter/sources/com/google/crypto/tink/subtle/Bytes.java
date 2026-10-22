package com.google.crypto.tink.subtle;

import b8.z;
import com.google.crypto.tink.shaded.protobuf.Reader;
import g5.f;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class Bytes {
    private Bytes() {
    }

    public static int byteArrayToInt(byte[] bArr, int i, int i3) {
        int i10 = 0;
        for (int i11 = 0; i11 < i3; i11++) {
            i10 += (bArr[i11 + i] & 255) << (i11 * 8);
        }
        return i10;
    }

    public static byte[] concat(byte[]... bArr) throws GeneralSecurityException {
        int length = 0;
        for (byte[] bArr2 : bArr) {
            if (length > Reader.READ_DONE - bArr2.length) {
                z.l("exceeded size limit");
                return null;
            }
            length += bArr2.length;
        }
        byte[] bArr3 = new byte[length];
        int length2 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, length2, bArr4.length);
            length2 += bArr4.length;
        }
        return bArr3;
    }

    public static final boolean equal(byte[] bArr, byte[] bArr2) {
        return MessageDigest.isEqual(bArr, bArr2);
    }

    public static byte[] intToByteArray(int i, int i3) {
        byte[] bArr = new byte[i];
        for (int i10 = 0; i10 < i; i10++) {
            bArr[i10] = (byte) ((i3 >> (i10 * 8)) & 255);
        }
        return bArr;
    }

    public static final void xor(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i) {
        if (i < 0 || byteBuffer2.remaining() < i || byteBuffer3.remaining() < i || byteBuffer.remaining() < i) {
            f.s("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
            return;
        }
        for (int i3 = 0; i3 < i; i3++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static final byte[] xorEnd(byte[] bArr, byte[] bArr2) {
        if (bArr.length < bArr2.length) {
            f.s("xorEnd requires a.length >= b.length");
            return null;
        }
        int length = bArr.length - bArr2.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        for (int i = 0; i < bArr2.length; i++) {
            int i3 = length + i;
            bArrCopyOf[i3] = (byte) (bArrCopyOf[i3] ^ bArr2[i]);
        }
        return bArrCopyOf;
    }

    public static int byteArrayToInt(byte[] bArr, int i) {
        return byteArrayToInt(bArr, 0, i);
    }

    public static int byteArrayToInt(byte[] bArr) {
        return byteArrayToInt(bArr, bArr.length);
    }

    public static final byte[] xor(byte[] bArr, int i, byte[] bArr2, int i3, int i10) {
        if (i10 >= 0 && bArr.length - i10 >= i && bArr2.length - i10 >= i3) {
            byte[] bArr3 = new byte[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                bArr3[i11] = (byte) (bArr[i11 + i] ^ bArr2[i11 + i3]);
            }
            return bArr3;
        }
        f.s("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        return null;
    }

    public static final byte[] xor(byte[] bArr, byte[] bArr2) {
        if (bArr.length == bArr2.length) {
            return xor(bArr, 0, bArr2, 0, bArr.length);
        }
        f.s("The lengths of x and y should match.");
        return null;
    }
}
