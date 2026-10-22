package com.google.protobuf;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes2.dex */
final class UnsafeUtil {
    private static final long BOOLEAN_ARRAY_BASE_OFFSET = 0;
    private static final long BOOLEAN_ARRAY_INDEX_SCALE = 0;
    private static final long BUFFER_ADDRESS_OFFSET = 0;
    private static final int BYTE_ARRAY_ALIGNMENT = 0;
    static final long BYTE_ARRAY_BASE_OFFSET = 0;
    private static final long DOUBLE_ARRAY_BASE_OFFSET = 0;
    private static final long DOUBLE_ARRAY_INDEX_SCALE = 0;
    private static final long FLOAT_ARRAY_BASE_OFFSET = 0;
    private static final long FLOAT_ARRAY_INDEX_SCALE = 0;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = false;
    private static final long INT_ARRAY_BASE_OFFSET = 0;
    private static final long INT_ARRAY_INDEX_SCALE = 0;
    private static final boolean IS_ANDROID_32 = false;
    private static final boolean IS_ANDROID_64 = false;
    static final boolean IS_BIG_ENDIAN = false;
    private static final long LONG_ARRAY_BASE_OFFSET = 0;
    private static final long LONG_ARRAY_INDEX_SCALE = 0;
    private static final MemoryAccessor MEMORY_ACCESSOR = null;
    private static final Class<?> MEMORY_CLASS = null;
    private static final long OBJECT_ARRAY_BASE_OFFSET = 0;
    private static final long OBJECT_ARRAY_INDEX_SCALE = 0;
    private static final int STRIDE = 8;
    private static final int STRIDE_ALIGNMENT_MASK = 7;
    private static final Unsafe UNSAFE = null;

    private static final class Android32MemoryAccessor extends MemoryAccessor {
        private static final long SMALL_ADDRESS_MASK = -1;

        private static int smallAddress(long r2) {
            return (int) (r2 & (-1));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        Android32MemoryAccessor(Unsafe r3) {
            super((Unsafe) ZeusTransformUtils.wrapperContextForParams(r3, Unsafe.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field r1) {
            return r1.get(null);
        L8:
            return null;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object r1, long r2) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$200(r1, r2);
        L7:
            return UnsafeUtil.access$300(r1, r2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object r1, long r2, byte r4) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$400(r1, r2, r4);
            return;
        L5:
            UnsafeUtil.access$500(r1, r2, r4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object r1, long r2) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$600(r1, r2);
        L7:
            return UnsafeUtil.access$700(r1, r2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object r1, long r2, boolean r4) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$800(r1, r2, r4);
            return;
        L5:
            UnsafeUtil.access$900(r1, r2, r4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object r1, long r2) {
            return Float.intBitsToFloat(getInt(r1, r2));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object r1, long r2, float r4) {
            putInt(r1, r2, Float.floatToIntBits(r4));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object r1, long r2) {
            return Double.longBitsToDouble(getLong(r1, r2));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object r7, long r8, double r10) {
            putLong(r7, r8, Double.doubleToLongBits(r10));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long r1, byte r3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long r1, int r3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long r1, long r3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long r1, byte[] r3, long r4, long r6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] r1, long r2, long r4, long r6) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class Android64MemoryAccessor extends MemoryAccessor {
        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        Android64MemoryAccessor(Unsafe r3) {
            super((Unsafe) ZeusTransformUtils.wrapperContextForParams(r3, Unsafe.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field r1) {
            return r1.get(null);
        L8:
            return null;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object r1, long r2) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$200(r1, r2);
        L7:
            return UnsafeUtil.access$300(r1, r2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object r1, long r2, byte r4) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$400(r1, r2, r4);
            return;
        L5:
            UnsafeUtil.access$500(r1, r2, r4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object r1, long r2) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$600(r1, r2);
        L7:
            return UnsafeUtil.access$700(r1, r2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object r1, long r2, boolean r4) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$800(r1, r2, r4);
            return;
        L5:
            UnsafeUtil.access$900(r1, r2, r4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object r1, long r2) {
            return Float.intBitsToFloat(getInt(r1, r2));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object r1, long r2, float r4) {
            putInt(r1, r2, Float.floatToIntBits(r4));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object r1, long r2) {
            return Double.longBitsToDouble(getLong(r1, r2));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object r7, long r8, double r10) {
            putLong(r7, r8, Double.doubleToLongBits(r10));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long r1, byte r3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long r1, int r3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long r1) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long r1, long r3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long r1, byte[] r3, long r4, long r6) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] r1, long r2, long r4, long r6) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class JvmMemoryAccessor extends MemoryAccessor {
        JvmMemoryAccessor(Unsafe r3) {
            super((Unsafe) ZeusTransformUtils.wrapperContextForParams(r3, Unsafe.class, "com.obric.aiagent.plugin"));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(java.lang.reflect.Field r4) {
            return getObject(this.unsafe.staticFieldBase(r4), this.unsafe.staticFieldOffset(r4));
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeArrayOperations() {
            if (super.supportsUnsafeArrayOperations() == true) goto L10;
            return false;
        L10:
            Class<?> r7 = this.unsafe.getClass();     // Catch: Throwable -> L7
            r7.getMethod("getByte", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            UnsafeUtil.access$000(th);
            return false;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object r1, long r2) {
            return this.unsafe.getByte(r1, r2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object r1, long r2, byte r4) {
            this.unsafe.putByte(r1, r2, r4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object r1, long r2) {
            return this.unsafe.getBoolean(r1, r2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object r1, long r2, boolean r4) {
            this.unsafe.putBoolean(r1, r2, r4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object r1, long r2) {
            return this.unsafe.getFloat(r1, r2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object r1, long r2, float r4) {
            this.unsafe.putFloat(r1, r2, r4);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object r1, long r2) {
            return this.unsafe.getDouble(r1, r2);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object r7, long r8, double r10) {
            this.unsafe.putDouble(r7, r8, r10);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            if (super.supportsUnsafeByteBufferOperations() == true) goto L10;
            return false;
        L10:
            Class<?> r7 = this.unsafe.getClass();     // Catch: Throwable -> L7
            r7.getMethod("getByte", new Class[]{Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("getInt", new Class[]{Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("getLong", new Class[]{Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            r7.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            UnsafeUtil.access$000(th);
            return false;
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long r1) {
            return this.unsafe.getByte(r1);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long r1, byte r3) {
            this.unsafe.putByte(r1, r3);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long r1) {
            return this.unsafe.getInt(r1);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long r1, int r3) {
            this.unsafe.putInt(r1, r3);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long r1) {
            return this.unsafe.getLong(r1);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long r1, long r3) {
            this.unsafe.putLong(r1, r3);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long r10, byte[] r12, long r13, long r15) {
            this.unsafe.copyMemory(null, r10, r12, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + r13, r15);
        }

        @Override // com.google.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] r10, long r11, long r13, long r15) {
            this.unsafe.copyMemory(r10, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + r11, null, r13, r15);
        }
    }

    private static abstract class MemoryAccessor {
        Unsafe unsafe;

        public abstract void copyMemory(long r1, byte[] r3, long r4, long r6);

        public abstract void copyMemory(byte[] r1, long r2, long r4, long r6);

        public abstract boolean getBoolean(Object r1, long r2);

        public abstract byte getByte(long r1);

        public abstract byte getByte(Object r1, long r2);

        public abstract double getDouble(Object r1, long r2);

        public abstract float getFloat(Object r1, long r2);

        public abstract int getInt(long r1);

        public abstract long getLong(long r1);

        public abstract Object getStaticObject(java.lang.reflect.Field r1);

        public abstract void putBoolean(Object r1, long r2, boolean r4);

        public abstract void putByte(long r1, byte r3);

        public abstract void putByte(Object r1, long r2, byte r4);

        public abstract void putDouble(Object r1, long r2, double r4);

        public abstract void putFloat(Object r1, long r2, float r4);

        public abstract void putInt(long r1, int r3);

        public abstract void putLong(long r1, long r3);

        MemoryAccessor(Unsafe r3) {
            this.unsafe = (Unsafe) ZeusTransformUtils.wrapperContextForParams(r3, Unsafe.class, "com.obric.aiagent.plugin");
        }

        public final long objectFieldOffset(java.lang.reflect.Field r1) {
            return this.unsafe.objectFieldOffset(r1);
        }

        public final int arrayBaseOffset(Class<?> r1) {
            return this.unsafe.arrayBaseOffset(r1);
        }

        public final int arrayIndexScale(Class<?> r1) {
            return this.unsafe.arrayIndexScale(r1);
        }

        public boolean supportsUnsafeArrayOperations() {
            Unsafe r7 = this.unsafe;
            if (r7 != null) goto L10;
            return false;
        L10:
            Class<?> r8 = r7.getClass();     // Catch: Throwable -> L7
            r8.getMethod("objectFieldOffset", new Class[]{java.lang.reflect.Field.class});     // Catch: Throwable -> L7
            r8.getMethod("arrayBaseOffset", new Class[]{Class.class});     // Catch: Throwable -> L7
            r8.getMethod("arrayIndexScale", new Class[]{Class.class});     // Catch: Throwable -> L7
            r8.getMethod("getInt", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r8.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
            r8.getMethod("getLong", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r8.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            r8.getMethod("getObject", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            r8.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});     // Catch: Throwable -> L7
            return true;
        L7:
            th = move-exception;
            UnsafeUtil.access$000(th);
            return false;
        }

        public final int getInt(Object r1, long r2) {
            return this.unsafe.getInt(r1, r2);
        }

        public final void putInt(Object r1, long r2, int r4) {
            this.unsafe.putInt(r1, r2, r4);
        }

        public final long getLong(Object r1, long r2) {
            return this.unsafe.getLong(r1, r2);
        }

        public final void putLong(Object r7, long r8, long r10) {
            this.unsafe.putLong(r7, r8, r10);
        }

        public final Object getObject(Object r1, long r2) {
            return this.unsafe.getObject(r1, r2);
        }

        public final void putObject(Object r1, long r2, Object r4) {
            this.unsafe.putObject(r1, r2, r4);
        }

        public boolean supportsUnsafeByteBufferOperations() {
            Unsafe r5 = this.unsafe;
            if (r5 != null) goto L12;
            return false;
        L12:
            Class<?> r6 = r5.getClass();     // Catch: Throwable -> L9
            r6.getMethod("objectFieldOffset", new Class[]{java.lang.reflect.Field.class});     // Catch: Throwable -> L9
            r6.getMethod("getLong", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L9
            if (UnsafeUtil.access$100() != null) goto L8;
            return false;
        L8:
            return true;
        L9:
            th = move-exception;
            UnsafeUtil.access$000(th);
            return false;
        }
    }

    static /* synthetic */ void access$000(Throwable r0) {
        logMissingMethod(r0);
    }

    static /* synthetic */ java.lang.reflect.Field access$100() {
        return bufferAddressField();
    }

    static /* synthetic */ byte access$200(Object r0, long r1) {
        return getByteBigEndian(r0, r1);
    }

    static /* synthetic */ byte access$300(Object r0, long r1) {
        return getByteLittleEndian(r0, r1);
    }

    static /* synthetic */ void access$400(Object r0, long r1, byte r3) {
        putByteBigEndian(r0, r1, r3);
    }

    static /* synthetic */ void access$500(Object r0, long r1, byte r3) {
        putByteLittleEndian(r0, r1, r3);
    }

    static /* synthetic */ boolean access$600(Object r0, long r1) {
        return getBooleanBigEndian(r0, r1);
    }

    static /* synthetic */ boolean access$700(Object r0, long r1) {
        return getBooleanLittleEndian(r0, r1);
    }

    static /* synthetic */ void access$800(Object r0, long r1, boolean r3) {
        putBooleanBigEndian(r0, r1, r3);
    }

    static /* synthetic */ void access$900(Object r0, long r1, boolean r3) {
        putBooleanLittleEndian(r0, r1, r3);
    }

    static {
        UNSAFE = getUnsafe();
        MEMORY_CLASS = Android.getMemoryClass();
        IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
        IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
        MEMORY_ACCESSOR = getMemoryAccessor();
        HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
        HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
        long r5 = arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = r5;
        BOOLEAN_ARRAY_BASE_OFFSET = arrayBaseOffset(boolean[].class);
        BOOLEAN_ARRAY_INDEX_SCALE = arrayIndexScale(boolean[].class);
        INT_ARRAY_BASE_OFFSET = arrayBaseOffset(int[].class);
        INT_ARRAY_INDEX_SCALE = arrayIndexScale(int[].class);
        LONG_ARRAY_BASE_OFFSET = arrayBaseOffset(long[].class);
        LONG_ARRAY_INDEX_SCALE = arrayIndexScale(long[].class);
        FLOAT_ARRAY_BASE_OFFSET = arrayBaseOffset(float[].class);
        FLOAT_ARRAY_INDEX_SCALE = arrayIndexScale(float[].class);
        DOUBLE_ARRAY_BASE_OFFSET = arrayBaseOffset(double[].class);
        DOUBLE_ARRAY_INDEX_SCALE = arrayIndexScale(double[].class);
        OBJECT_ARRAY_BASE_OFFSET = arrayBaseOffset(Object[].class);
        OBJECT_ARRAY_INDEX_SCALE = arrayIndexScale(Object[].class);
        BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
        BYTE_ARRAY_ALIGNMENT = (int) (7 & r5);
        if (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN) goto L5;
        boolean r0 = true;
    L6:
        IS_BIG_ENDIAN = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    private UnsafeUtil() {
    }

    static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    static boolean isAndroid64() {
        return IS_ANDROID_64;
    }

    static <T> T allocateInstance(Class<T> r1) {
        return (T) UNSAFE.allocateInstance(r1);
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    static long objectFieldOffset(java.lang.reflect.Field r2) {
        return MEMORY_ACCESSOR.objectFieldOffset(r2);
    }

    private static int arrayBaseOffset(Class<?> r1) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS == true) goto L7;
        return -1;
    L7:
        return MEMORY_ACCESSOR.arrayBaseOffset(r1);
    }

    private static int arrayIndexScale(Class<?> r1) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS == true) goto L7;
        return -1;
    L7:
        return MEMORY_ACCESSOR.arrayIndexScale(r1);
    }

    static byte getByte(Object r1, long r2) {
        return MEMORY_ACCESSOR.getByte(r1, r2);
    }

    static void putByte(Object r1, long r2, byte r4) {
        MEMORY_ACCESSOR.putByte(r1, r2, r4);
    }

    static int getInt(Object r1, long r2) {
        return MEMORY_ACCESSOR.getInt(r1, r2);
    }

    static void putInt(Object r1, long r2, int r4) {
        MEMORY_ACCESSOR.putInt(r1, r2, r4);
    }

    static long getLong(Object r1, long r2) {
        return MEMORY_ACCESSOR.getLong(r1, r2);
    }

    static void putLong(Object r6, long r7, long r9) {
        MEMORY_ACCESSOR.putLong(r6, r7, r9);
    }

    static boolean getBoolean(Object r1, long r2) {
        return MEMORY_ACCESSOR.getBoolean(r1, r2);
    }

    static void putBoolean(Object r1, long r2, boolean r4) {
        MEMORY_ACCESSOR.putBoolean(r1, r2, r4);
    }

    static float getFloat(Object r1, long r2) {
        return MEMORY_ACCESSOR.getFloat(r1, r2);
    }

    static void putFloat(Object r1, long r2, float r4) {
        MEMORY_ACCESSOR.putFloat(r1, r2, r4);
    }

    static double getDouble(Object r1, long r2) {
        return MEMORY_ACCESSOR.getDouble(r1, r2);
    }

    static void putDouble(Object r6, long r7, double r9) {
        MEMORY_ACCESSOR.putDouble(r6, r7, r9);
    }

    static Object getObject(Object r1, long r2) {
        return MEMORY_ACCESSOR.getObject(r1, r2);
    }

    static void putObject(Object r1, long r2, Object r4) {
        MEMORY_ACCESSOR.putObject(r1, r2, r4);
    }

    static byte getByte(byte[] r3, long r4) {
        return MEMORY_ACCESSOR.getByte(r3, BYTE_ARRAY_BASE_OFFSET + r4);
    }

    static void putByte(byte[] r3, long r4, byte r6) {
        MEMORY_ACCESSOR.putByte(r3, BYTE_ARRAY_BASE_OFFSET + r4, r6);
    }

    static int getInt(int[] r5, long r6) {
        return MEMORY_ACCESSOR.getInt(r5, INT_ARRAY_BASE_OFFSET + (r6 * INT_ARRAY_INDEX_SCALE));
    }

    static void putInt(int[] r5, long r6, int r8) {
        MEMORY_ACCESSOR.putInt(r5, INT_ARRAY_BASE_OFFSET + (r6 * INT_ARRAY_INDEX_SCALE), r8);
    }

    static long getLong(long[] r5, long r6) {
        return MEMORY_ACCESSOR.getLong(r5, LONG_ARRAY_BASE_OFFSET + (r6 * LONG_ARRAY_INDEX_SCALE));
    }

    static void putLong(long[] r6, long r7, long r9) {
        MEMORY_ACCESSOR.putLong(r6, LONG_ARRAY_BASE_OFFSET + (r7 * LONG_ARRAY_INDEX_SCALE), r9);
    }

    static boolean getBoolean(boolean[] r5, long r6) {
        return MEMORY_ACCESSOR.getBoolean(r5, BOOLEAN_ARRAY_BASE_OFFSET + (r6 * BOOLEAN_ARRAY_INDEX_SCALE));
    }

    static void putBoolean(boolean[] r5, long r6, boolean r8) {
        MEMORY_ACCESSOR.putBoolean(r5, BOOLEAN_ARRAY_BASE_OFFSET + (r6 * BOOLEAN_ARRAY_INDEX_SCALE), r8);
    }

    static float getFloat(float[] r5, long r6) {
        return MEMORY_ACCESSOR.getFloat(r5, FLOAT_ARRAY_BASE_OFFSET + (r6 * FLOAT_ARRAY_INDEX_SCALE));
    }

    static void putFloat(float[] r5, long r6, float r8) {
        MEMORY_ACCESSOR.putFloat(r5, FLOAT_ARRAY_BASE_OFFSET + (r6 * FLOAT_ARRAY_INDEX_SCALE), r8);
    }

    static double getDouble(double[] r5, long r6) {
        return MEMORY_ACCESSOR.getDouble(r5, DOUBLE_ARRAY_BASE_OFFSET + (r6 * DOUBLE_ARRAY_INDEX_SCALE));
    }

    static void putDouble(double[] r6, long r7, double r9) {
        MEMORY_ACCESSOR.putDouble(r6, DOUBLE_ARRAY_BASE_OFFSET + (r7 * DOUBLE_ARRAY_INDEX_SCALE), r9);
    }

    static Object getObject(Object[] r5, long r6) {
        return MEMORY_ACCESSOR.getObject(r5, OBJECT_ARRAY_BASE_OFFSET + (r6 * OBJECT_ARRAY_INDEX_SCALE));
    }

    static void putObject(Object[] r5, long r6, Object r8) {
        MEMORY_ACCESSOR.putObject(r5, OBJECT_ARRAY_BASE_OFFSET + (r6 * OBJECT_ARRAY_INDEX_SCALE), r8);
    }

    static void copyMemory(byte[] r8, long r9, long r11, long r13) {
        MEMORY_ACCESSOR.copyMemory(r8, r9, r11, r13);
    }

    static void copyMemory(long r8, byte[] r10, long r11, long r13) {
        MEMORY_ACCESSOR.copyMemory(r8, r10, r11, r13);
    }

    static void copyMemory(byte[] r0, long r1, byte[] r3, long r4, long r6) {
        System.arraycopy(r0, (int) r1, r3, (int) r4, (int) r6);
    }

    static byte getByte(long r1) {
        return MEMORY_ACCESSOR.getByte(r1);
    }

    static void putByte(long r1, byte r3) {
        MEMORY_ACCESSOR.putByte(r1, r3);
    }

    static int getInt(long r1) {
        return MEMORY_ACCESSOR.getInt(r1);
    }

    static void putInt(long r1, int r3) {
        MEMORY_ACCESSOR.putInt(r1, r3);
    }

    static long getLong(long r1) {
        return MEMORY_ACCESSOR.getLong(r1);
    }

    static void putLong(long r1, long r3) {
        MEMORY_ACCESSOR.putLong(r1, r3);
    }

    static long addressOffset(ByteBuffer r3) {
        return MEMORY_ACCESSOR.getLong(r3, BUFFER_ADDRESS_OFFSET);
    }

    static Object getStaticObject(java.lang.reflect.Field r1) {
        return MEMORY_ACCESSOR.getStaticObject(r1);
    }

    static Unsafe getUnsafe() {
        return (Unsafe) ZeusTransformUtils.preCheckCast(AccessController.doPrivileged(new AnonymousClass1()), Unsafe.class, "com.obric.aiagent.plugin");
    L4:
        return null;
    }

    private static MemoryAccessor getMemoryAccessor() {
        Unsafe r0 = UNSAFE;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (Android.isOnAndroidDevice() == false) goto L16;
        if (IS_ANDROID_64 == false) goto L12;
        return new Android64MemoryAccessor(r0);
    L12:
        if (IS_ANDROID_32 == true) goto L14;
        return null;
    L14:
        return new Android32MemoryAccessor(r0);
    L16:
        return new JvmMemoryAccessor(r0);
    }

    private static boolean supportsUnsafeArrayOperations() {
        MemoryAccessor r0 = MEMORY_ACCESSOR;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.supportsUnsafeArrayOperations();
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        MemoryAccessor r0 = MEMORY_ACCESSOR;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.supportsUnsafeByteBufferOperations();
    }

    static boolean determineAndroidSupportByAddressSize(Class<?> r10) {
        if (Android.isOnAndroidDevice() == true) goto L8;
        return false;
    L8:
        Class<?> r1 = MEMORY_CLASS;     // Catch: Throwable -> L7
        r1.getMethod("peekLong", new Class[]{r10, Boolean.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("pokeLong", new Class[]{r10, Long.TYPE, Boolean.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("pokeInt", new Class[]{r10, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("peekInt", new Class[]{r10, Boolean.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("pokeByte", new Class[]{r10, Byte.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("peekByte", new Class[]{r10});     // Catch: Throwable -> L7
        r1.getMethod("pokeByteArray", new Class[]{r10, byte[].class, Integer.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
        r1.getMethod("peekByteArray", new Class[]{r10, byte[].class, Integer.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
        return true;
    L7:
        return false;
    }

    private static java.lang.reflect.Field bufferAddressField() {
        if (Android.isOnAndroidDevice() == false) goto L7;
        java.lang.reflect.Field r0 = field(Buffer.class, "effectiveDirectAddress");
        if (r0 == null) goto L7;
        return r0;
    L7:
        java.lang.reflect.Field r1 = field(Buffer.class, SensitiveType.ADDRESS);
        if (r1 != null) goto L10;
    L12:
        return null;
    L10:
        if (r1.getType() != Long.TYPE) goto L12;
        return r1;
    }

    private static int firstDifferingByteIndexNativeEndian(long r1, long r3) {
        if (IS_BIG_ENDIAN == false) goto L5;
        int r2 = Long.numberOfLeadingZeros(r1 ^ r3);
    L7:
        return r2 >> 3;
    L5:
        r2 = Long.numberOfTrailingZeros(r1 ^ r3);
        goto L7
    }

    static int mismatch(byte[] r10, int r11, byte[] r12, int r13, int r14) {
        if (r11 < 0) goto L34;
        if (r13 < 0) goto L34;
        if (r14 < 0) goto L34;
        if ((r11 + r14) > r10.length) goto L34;
        if ((r13 + r14) > r12.length) goto L34;
        int r0 = 0;
        if (HAS_UNSAFE_ARRAY_OPERATIONS == false) goto L26;
        int r1 = (BYTE_ARRAY_ALIGNMENT + r11) & 7;
    L12:
        if (r0 >= r14) goto L19;
        if ((r1 & 7) == 0) goto L19;
        if (r10[r11 + r0] != r12[r13 + r0]) goto L17;
        r0 = r0 + 1;
        r1 = r1 + 1;
        goto L12
    L17:
        return r0;
    L19:
        int r2 = ((r14 - r0) & (-8)) + r0;
    L20:
        if (r0 >= r2) goto L26;
        long r3 = BYTE_ARRAY_BASE_OFFSET;
        long r6 = r0;
        long r4 = getLong(r10, (((long) r11) + r3) + r6);
        long r5 = getLong(r12, (r3 + ((long) r13)) + r6);
        if (r4 != r5) goto L24;
        r0 = r0 + 8;
        goto L20
    L24:
        return r0 + firstDifferingByteIndexNativeEndian(r4, r5);
    L26:
        if (r0 >= r14) goto L31;
        if (r10[r11 + r0] != r12[r13 + r0]) goto L29;
        r0 = r0 + 1;
        goto L26
    L29:
        return r0;
    L31:
        return -1;
    L34:
        throw new IndexOutOfBoundsException();
    }

    private static long fieldOffset(java.lang.reflect.Field r2) {
        if (r2 == null) goto L7;
        MemoryAccessor r0 = MEMORY_ACCESSOR;
        if (r0 == null) goto L7;
        return r0.objectFieldOffset(r2);
    L7:
        return -1;
    }

    private static java.lang.reflect.Field field(Class<?> r0, String r1) {
        return r0.getDeclaredField(r1);
    L4:
        return null;
    }

    private static byte getByteBigEndian(Object r2, long r3) {
        return (byte) ((getInt(r2, (-4) & r3) >>> ((int) (((~r3) & 3) << 3))) & 255);
    }

    private static byte getByteLittleEndian(Object r2, long r3) {
        return (byte) ((getInt(r2, (-4) & r3) >>> ((int) ((r3 & 3) << 3))) & 255);
    }

    private static void putByteBigEndian(Object r4, long r5, byte r7) {
        long r0 = (-4) & r5;
        int r2 = getInt(r4, r0);
        int r6 = ((~((int) r5)) & 3) << 3;
        int r3 = r2 & (~(255 << r6));
        putInt(r4, r0, ((255 & r7) << r6) | r3);
    }

    private static void putByteLittleEndian(Object r4, long r5, byte r7) {
        long r0 = (-4) & r5;
        int r6 = (((int) r5) & 3) << 3;
        int r2 = getInt(r4, r0) & (~(255 << r6));
        putInt(r4, r0, ((255 & r7) << r6) | r2);
    }

    private static boolean getBooleanBigEndian(Object r0, long r1) {
        if (getByteBigEndian(r0, r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean getBooleanLittleEndian(Object r0, long r1) {
        if (getByteLittleEndian(r0, r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static void putBooleanBigEndian(Object r0, long r1, boolean r3) {
        putByteBigEndian(r0, r1, r3 ? 1 : 0);
    }

    private static void putBooleanLittleEndian(Object r0, long r1, boolean r3) {
        putByteLittleEndian(r0, r1, r3 ? 1 : 0);
    }

    private static void logMissingMethod(Throwable r4) {
        Logger.getLogger(UnsafeUtil.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + r4);
    }
}
