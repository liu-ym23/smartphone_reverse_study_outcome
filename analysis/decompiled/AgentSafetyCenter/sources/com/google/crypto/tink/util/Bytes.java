package com.google.crypto.tink.util;

import com.google.crypto.tink.subtle.Hex;
import g5.f;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class Bytes {
    private final byte[] data;

    private Bytes(byte[] bArr, int i, int i3) {
        byte[] bArr2 = new byte[i3];
        this.data = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i3);
    }

    public static Bytes copyFrom(byte[] bArr) {
        if (bArr != null) {
            return copyFrom(bArr, 0, bArr.length);
        }
        f.g("data must be non-null");
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Bytes) {
            return Arrays.equals(((Bytes) obj).data, this.data);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.data);
    }

    public int size() {
        return this.data.length;
    }

    public byte[] toByteArray() {
        byte[] bArr = this.data;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public String toString() {
        return "Bytes(" + Hex.encode(this.data) + ")";
    }

    public static Bytes copyFrom(byte[] bArr, int i, int i3) {
        if (bArr != null) {
            return new Bytes(bArr, i, i3);
        }
        f.g("data must be non-null");
        return null;
    }
}
