package com.google.protobuf;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
final class UnsafeUtil {
    private static final long ARRAY_BASE_OFFSET = 0;
    private static final long BUFFER_ADDRESS_OFFSET = 0;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = false;
    private static final Unsafe UNSAFE = null;

    static {
        UNSAFE = getUnsafe();
        HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
        HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
        ARRAY_BASE_OFFSET = byteArrayBaseOffset();
        BUFFER_ADDRESS_OFFSET = fieldOffset(field(Buffer.class, "address"));
    }

    private UnsafeUtil() {
    }

    public static long addressOffset(ByteBuffer r10) {
        return UNSAFE.getLong(r10, BUFFER_ADDRESS_OFFSET);
    }

    private static int byteArrayBaseOffset() {
        if (HAS_UNSAFE_ARRAY_OPERATIONS == true) goto L7;
        return -1;
    L7:
        return UNSAFE.arrayBaseOffset(byte[].class);
    }

    public static void copyMemory(byte[] r10, long r11, byte[] r12, long r13, long r15) {
        UNSAFE.copyMemory(r10, r11, r12, r13, r15);
    }

    private static java.lang.reflect.Field field(Class<?> r10, String r11) {
        java.lang.reflect.Field r12 = r10.getDeclaredField(r11);     // Catch: Throwable -> L4
        r12.setAccessible(true);     // Catch: Throwable -> L4
        return r12;
    L4:
        return null;
    }

    private static long fieldOffset(java.lang.reflect.Field r10) {
        if (r10 == null) goto L7;
        Unsafe r11 = UNSAFE;
        if (r11 == null) goto L7;
        return r11.objectFieldOffset(r10);
    L7:
        return -1;
    }

    public static long getArrayBaseOffset() {
        return ARRAY_BASE_OFFSET;
    }

    public static byte getByte(byte[] r10, long r11) {
        return UNSAFE.getByte(r10, r11);
    }

    public static long getLong(byte[] r10, long r11) {
        return UNSAFE.getLong(r10, r11);
    }

    private static Unsafe getUnsafe() {
        return (Unsafe) AccessController.doPrivileged(new AnonymousClass1());
    L4:
        return null;
    }

    public static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    public static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    public static void putByte(byte[] r10, long r11, byte r12) {
        UNSAFE.putByte(r10, r11, r12);
    }

    private static boolean supportsUnsafeArrayOperations() {
        Unsafe r10 = UNSAFE;
        if (r10 != null) goto L9;
    L6:
        return false;
    L9:
        Class<?> r11 = r10.getClass();     // Catch: Throwable -> L8
        r11.getMethod("arrayBaseOffset", new Class[]{Class.class});     // Catch: Throwable -> L8
        Class r12 = Long.TYPE;     // Catch: Throwable -> L8
        r11.getMethod("getByte", new Class[]{Object.class, r12});     // Catch: Throwable -> L8
        r11.getMethod("putByte", new Class[]{Object.class, r12, Byte.TYPE});     // Catch: Throwable -> L8
        r11.getMethod("getLong", new Class[]{Object.class, r12});     // Catch: Throwable -> L8
        r11.getMethod("copyMemory", new Class[]{Object.class, r12, Object.class, r12, r12});     // Catch: Throwable -> L8
        return true;
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        Unsafe r10 = UNSAFE;
        if (r10 != null) goto L9;
    L6:
        return false;
    L9:
        Class<?> r11 = r10.getClass();     // Catch: Throwable -> L8
        r11.getMethod("objectFieldOffset", new Class[]{java.lang.reflect.Field.class});     // Catch: Throwable -> L8
        Class r12 = Long.TYPE;     // Catch: Throwable -> L8
        r11.getMethod("getByte", new Class[]{r12});     // Catch: Throwable -> L8
        r11.getMethod("getLong", new Class[]{Object.class, r12});     // Catch: Throwable -> L8
        r11.getMethod("putByte", new Class[]{r12, Byte.TYPE});     // Catch: Throwable -> L8
        r11.getMethod("getLong", new Class[]{r12});     // Catch: Throwable -> L8
        r11.getMethod("copyMemory", new Class[]{r12, r12, r12});     // Catch: Throwable -> L8
        return true;
    }

    public static void copyMemory(long r10, long r11, long r12) {
        UNSAFE.copyMemory(r10, r11, r12);
    }

    public static byte getByte(long r10) {
        return UNSAFE.getByte(r10);
    }

    public static long getLong(long r10) {
        return UNSAFE.getLong(r10);
    }

    public static void putByte(long r10, byte r11) {
        UNSAFE.putByte(r10, r11);
    }
}
