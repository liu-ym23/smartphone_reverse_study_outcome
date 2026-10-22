package com.google.common.hash;

import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteOrder;
import java.security.AccessController;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
final class LittleEndianByteArray {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final LittleEndianBytes byteArray = null;

    /* JADX INFO: renamed from: com.google.common.hash.LittleEndianByteArray$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static abstract enum JavaLittleEndianBytes extends Enum<JavaLittleEndianBytes> implements LittleEndianBytes {
        private static final /* synthetic */ JavaLittleEndianBytes[] $VALUES = null;
        public static final JavaLittleEndianBytes INSTANCE = null;

        static {
            final String r10 = "INSTANCE";
            final int r11 = 0;
            JavaLittleEndianBytes r12 = new AnonymousClass1(r10, r11);
            INSTANCE = r12;
            $VALUES = new JavaLittleEndianBytes[]{r12};
        }

        private JavaLittleEndianBytes(String r10, int r11) {
            super(r10, r11);
        }

        public static JavaLittleEndianBytes valueOf(String r10) {
            return (JavaLittleEndianBytes) Enum.valueOf(JavaLittleEndianBytes.class, r10);
        }

        public static JavaLittleEndianBytes[] values() {
            return (JavaLittleEndianBytes[]) $VALUES.clone();
        }

        public /* synthetic */ JavaLittleEndianBytes(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    public interface LittleEndianBytes {
        long getLongLittleEndian(byte[] r10, int r11);

        void putLongLittleEndian(byte[] r10, int r11, long r12);
    }

    public static abstract enum UnsafeByteArray extends Enum<UnsafeByteArray> implements LittleEndianBytes {
        private static final /* synthetic */ UnsafeByteArray[] $VALUES = null;
        private static final int BYTE_ARRAY_BASE_OFFSET = 0;
        public static final UnsafeByteArray UNSAFE_BIG_ENDIAN = null;
        public static final UnsafeByteArray UNSAFE_LITTLE_ENDIAN = null;
        private static final Unsafe theUnsafe = null;

        static {
            final String r10 = "UNSAFE_LITTLE_ENDIAN";
            final int r11 = 0;
            UnsafeByteArray r12 = new AnonymousClass1(r10, r11);
            UNSAFE_LITTLE_ENDIAN = r12;
            final String r13 = "UNSAFE_BIG_ENDIAN";
            final int r14 = 1;
            UnsafeByteArray r15 = new AnonymousClass2(r13, r14);
            UNSAFE_BIG_ENDIAN = r15;
            $VALUES = new UnsafeByteArray[]{r12, r15};
            Unsafe r16 = getUnsafe();
            theUnsafe = r16;
            BYTE_ARRAY_BASE_OFFSET = r16.arrayBaseOffset(byte[].class);
            if (r16.arrayIndexScale(byte[].class) != 1) goto L6;
            return;
        L6:
            throw new AssertionError();
        }

        private UnsafeByteArray(String r10, int r11) {
            super(r10, r11);
        }

        public static /* synthetic */ int access$100() {
            return BYTE_ARRAY_BASE_OFFSET;
        }

        public static /* synthetic */ Unsafe access$200() {
            return theUnsafe;
        }

        private static Unsafe getUnsafe() {
            return Unsafe.getUnsafe();
        L4:
            return (Unsafe) AccessController.doPrivileged(new AnonymousClass3());
        L6:
            e = move-exception;
            throw new RuntimeException("Could not initialize intrinsics", e.getCause());
        }

        public static UnsafeByteArray valueOf(String r10) {
            return (UnsafeByteArray) Enum.valueOf(UnsafeByteArray.class, r10);
        }

        public static UnsafeByteArray[] values() {
            return (UnsafeByteArray[]) $VALUES.clone();
        }

        public /* synthetic */ UnsafeByteArray(String r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }
    }

    static {
        LittleEndianBytes r10 = JavaLittleEndianBytes.INSTANCE;
        if ("amd64".equals(System.getProperty("os.arch")) == true) goto L6;
    L12:
        goto L9
    L6:
        if (ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) == false) goto L8;
        r10 = UnsafeByteArray.UNSAFE_LITTLE_ENDIAN;     // Catch: Throwable -> L11
        goto L12
    L8:
        r10 = UnsafeByteArray.UNSAFE_BIG_ENDIAN;     // Catch: Throwable -> L11
    L9:
        byteArray = r10;
    }

    private LittleEndianByteArray() {
    }

    public static int load32(byte[] r10, int r11) {
        int r12 = ((r10[r11] & UnsignedBytes.MAX_VALUE) | ((r10[r11 + 1] & UnsignedBytes.MAX_VALUE) << 8)) | ((r10[r11 + 2] & UnsignedBytes.MAX_VALUE) << 16);
        return ((r10[r11 + 3] & UnsignedBytes.MAX_VALUE) << 24) | r12;
    }

    public static long load64(byte[] r10, int r11) {
        return byteArray.getLongLittleEndian(r10, r11);
    }

    public static long load64Safely(byte[] r10, int r11, int r12) {
        int r13 = Math.min(r12, 8);
        long r14 = 0;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L5;
        r14 = r14 | ((((long) r10[r11 + r15]) & 255) << (r15 * 8));
        r15 = r15 + 1;
        goto L3
    L5:
        return r14;
    }

    public static void store64(byte[] r10, int r11, long r12) {
        byteArray.putLongLittleEndian(r10, r11, r12);
    }

    public static boolean usingUnsafe() {
        return byteArray instanceof UnsafeByteArray;
    }
}
