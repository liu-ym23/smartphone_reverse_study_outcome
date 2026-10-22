package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import org.apache.commons.compress.utils.ByteUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ZipShort implements Cloneable, Serializable {
    public static final ZipShort ZERO = null;
    private static final long serialVersionUID = 1;
    private final int value;

    static {
        ZERO = new ZipShort(0);
    }

    public ZipShort(int value) {
        this.value = value;
    }

    public ZipShort(byte[] bytes) {
        this(bytes, 0);
    }

    public ZipShort(byte[] bytes, int offset) {
        this.value = getValue(bytes, offset);
    }

    public byte[] getBytes() {
        byte[] result = new byte[2];
        ByteUtils.toLittleEndian(result, this.value, 0, 2);
        return result;
    }

    public int getValue() {
        return this.value;
    }

    public static byte[] getBytes(int value) {
        byte[] result = new byte[2];
        putShort(value, result, 0);
        return result;
    }

    public static void putShort(int value, byte[] buf, int offset) {
        ByteUtils.toLittleEndian(buf, value, offset, 2);
    }

    public static int getValue(byte[] bytes, int offset) {
        return (int) ByteUtils.fromLittleEndian(bytes, offset, 2);
    }

    public static int getValue(byte[] bytes) {
        return getValue(bytes, 0);
    }

    public boolean equals(Object o) {
        if (o != null) goto L5;
    L11:
        return false;
    L5:
        if ((o instanceof ZipShort) == false) goto L11;
        if (this.value != ((ZipShort) o).getValue()) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return this.value;
    }

    public Object clone() {
        return super.clone();
    L4:
        cnfe = move-exception;
        throw new RuntimeException(cnfe);
    }

    public String toString() {
        return "ZipShort value: " + this.value;
    }
}
