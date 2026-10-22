package com.alibaba.fastjson.util;

import java.lang.ref.SoftReference;
import java.nio.charset.CharsetDecoder;

/* JADX INFO: loaded from: classes28.dex */
public class ThreadLocalCache {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BYTES_CACH_INIT_SIZE = 1024;
    public static final int BYTES_CACH_INIT_SIZE_EXP = 10;
    public static final int BYTES_CACH_MAX_SIZE = 131072;
    public static final int BYTES_CACH_MAX_SIZE_EXP = 17;
    public static final int CHARS_CACH_INIT_SIZE = 1024;
    public static final int CHARS_CACH_INIT_SIZE_EXP = 10;
    public static final int CHARS_CACH_MAX_SIZE = 131072;
    public static final int CHARS_CACH_MAX_SIZE_EXP = 17;
    private static final ThreadLocal<SoftReference<byte[]>> bytesBufLocal = null;
    private static final ThreadLocal<SoftReference<char[]>> charsBufLocal = null;
    private static final ThreadLocal<CharsetDecoder> decoderLocal = null;

    public ThreadLocalCache() {
    }

    static {
        charsBufLocal = new ThreadLocal();
        decoderLocal = new ThreadLocal();
        bytesBufLocal = new ThreadLocal();
    }

    public static void clearBytes() {
        bytesBufLocal.set(null);
    }

    public static void clearChars() {
        charsBufLocal.set(null);
    }

    public static CharsetDecoder getUTF8Decoder() {
        ThreadLocal<CharsetDecoder> r100 = decoderLocal;
        CharsetDecoder r101 = r100.get();
        if (r101 != null) goto L6;
        UTF8Decoder r102 = new UTF8Decoder();
        r100.set(r102);
        return r102;
    L6:
        return r101;
    }

    private static char[] allocate(int r100) {
        if (r100 > 131072) goto L5;
        char[] r101 = new char[getAllocateLengthExp(10, 17, r100)];
        charsBufLocal.set(new SoftReference(r101));
        return r101;
    L5:
        return new char[r100];
    }

    private static byte[] allocateBytes(int r100) {
        if (r100 > 131072) goto L5;
        byte[] r101 = new byte[getAllocateLengthExp(10, 17, r100)];
        bytesBufLocal.set(new SoftReference(r101));
        return r101;
    L5:
        return new byte[r100];
    }

    public static byte[] getBytes(int r100) {
        SoftReference<byte[]> r101 = bytesBufLocal.get();
        if (r101 == null) goto L5;
        byte[] r102 = r101.get();
        if (r102 != null) goto L11;
        return allocateBytes(r100);
    L11:
        if (r102.length < r100) goto L13;
        return r102;
    L13:
        return allocateBytes(r100);
    L5:
        return allocateBytes(r100);
    }

    public static char[] getChars(int r100) {
        SoftReference<char[]> r101 = charsBufLocal.get();
        if (r101 == null) goto L5;
        char[] r102 = r101.get();
        if (r102 != null) goto L11;
        return allocate(r100);
    L11:
        if (r102.length < r100) goto L13;
        return r102;
    L13:
        return allocate(r100);
    L5:
        return allocate(r100);
    }

    private static int getAllocateLengthExp(int r100, int r101, int r102) {
        if ((r102 >>> r100) > 0) goto L7;
        return 1 << r100;
    L7:
        return 1 << (32 - Integer.numberOfLeadingZeros(r102 - 1));
    }
}
