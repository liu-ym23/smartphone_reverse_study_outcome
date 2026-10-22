package com.bytedance.location.protobuf;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
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

        private static int smallAddress(long address) {
            return (int) ((-1) & address);
        }

        Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(Field field) {
            return field.get(null);
        L6:
            return null;
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object target, long offset) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$200(target, offset);
        L7:
            return UnsafeUtil.access$300(target, offset);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object target, long offset, byte value) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$400(target, offset, value);
            return;
        L5:
            UnsafeUtil.access$500(target, offset, value);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object target, long offset) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$600(target, offset);
        L7:
            return UnsafeUtil.access$700(target, offset);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object target, long offset, boolean value) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$800(target, offset, value);
            return;
        L5:
            UnsafeUtil.access$900(target, offset, value);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object target, long offset) {
            return Float.intBitsToFloat(getInt(target, offset));
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object target, long offset, float value) {
            putInt(target, offset, Float.floatToIntBits(value));
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object target, long offset) {
            return Double.longBitsToDouble(getLong(target, offset));
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object target, long offset, double value) {
            putLong(target, offset, Double.doubleToLongBits(value));
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long address) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long address, byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long address) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long address, int value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long address) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long address, long value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long srcOffset, byte[] target, long targetIndex, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] src, long srcIndex, long targetOffset, long length) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class Android64MemoryAccessor extends MemoryAccessor {
        Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(Field field) {
            return field.get(null);
        L6:
            return null;
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object target, long offset) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$200(target, offset);
        L7:
            return UnsafeUtil.access$300(target, offset);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object target, long offset, byte value) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$400(target, offset, value);
            return;
        L5:
            UnsafeUtil.access$500(target, offset, value);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object target, long offset) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L7;
            return UnsafeUtil.access$600(target, offset);
        L7:
            return UnsafeUtil.access$700(target, offset);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object target, long offset, boolean value) {
            if (UnsafeUtil.IS_BIG_ENDIAN == false) goto L5;
            UnsafeUtil.access$800(target, offset, value);
            return;
        L5:
            UnsafeUtil.access$900(target, offset, value);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object target, long offset) {
            return Float.intBitsToFloat(getInt(target, offset));
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object target, long offset, float value) {
            putInt(target, offset, Float.floatToIntBits(value));
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object target, long offset) {
            return Double.longBitsToDouble(getLong(target, offset));
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object target, long offset, double value) {
            putLong(target, offset, Double.doubleToLongBits(value));
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long address) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long address, byte value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long address) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long address, int value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long address) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long address, long value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long srcOffset, byte[] target, long targetIndex, long length) {
            throw new UnsupportedOperationException();
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] src, long srcIndex, long targetOffset, long length) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class JvmMemoryAccessor extends MemoryAccessor {
        JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public Object getStaticObject(Field field) {
            return getObject(this.unsafe.staticFieldBase(field), this.unsafe.staticFieldOffset(field));
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeArrayOperations() {
            if (super.supportsUnsafeArrayOperations() == true) goto L10;
            return false;
        L10:
            Class<?> clazz = this.unsafe.getClass();     // Catch: Throwable -> L7
            clazz.getMethod("getByte", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});     // Catch: Throwable -> L7
            return true;
        L7:
            e = move-exception;
            UnsafeUtil.access$000(e);
            return false;
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(Object target, long offset) {
            return this.unsafe.getByte(target, offset);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object target, long offset, byte value) {
            this.unsafe.putByte(target, offset, value);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object target, long offset) {
            return this.unsafe.getBoolean(target, offset);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object target, long offset, boolean value) {
            this.unsafe.putBoolean(target, offset, value);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object target, long offset) {
            return this.unsafe.getFloat(target, offset);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object target, long offset, float value) {
            this.unsafe.putFloat(target, offset, value);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object target, long offset) {
            return this.unsafe.getDouble(target, offset);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object target, long offset, double value) {
            this.unsafe.putDouble(target, offset, value);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            if (super.supportsUnsafeByteBufferOperations() == true) goto L10;
            return false;
        L10:
            Class<?> clazz = this.unsafe.getClass();     // Catch: Throwable -> L7
            clazz.getMethod("getByte", new Class[]{Long.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("getInt", new Class[]{Long.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("getLong", new Class[]{Long.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            return true;
        L7:
            e = move-exception;
            UnsafeUtil.access$000(e);
            return false;
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public byte getByte(long address) {
            return this.unsafe.getByte(address);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(long address, byte value) {
            this.unsafe.putByte(address, value);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public int getInt(long address) {
            return this.unsafe.getInt(address);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putInt(long address, int value) {
            this.unsafe.putInt(address, value);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public long getLong(long address) {
            return this.unsafe.getLong(address);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void putLong(long address, long value) {
            this.unsafe.putLong(address, value);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(long srcOffset, byte[] target, long targetIndex, long length) {
            this.unsafe.copyMemory(null, srcOffset, target, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + targetIndex, length);
        }

        @Override // com.bytedance.location.protobuf.UnsafeUtil.MemoryAccessor
        public void copyMemory(byte[] src, long srcIndex, long targetOffset, long length) {
            this.unsafe.copyMemory(src, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + srcIndex, null, targetOffset, length);
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

        public abstract Object getStaticObject(Field r1);

        public abstract void putBoolean(Object r1, long r2, boolean r4);

        public abstract void putByte(long r1, byte r3);

        public abstract void putByte(Object r1, long r2, byte r4);

        public abstract void putDouble(Object r1, long r2, double r4);

        public abstract void putFloat(Object r1, long r2, float r4);

        public abstract void putInt(long r1, int r3);

        public abstract void putLong(long r1, long r3);

        MemoryAccessor(Unsafe unsafe) {
            this.unsafe = unsafe;
        }

        public final long objectFieldOffset(Field field) {
            return this.unsafe.objectFieldOffset(field);
        }

        public final int arrayBaseOffset(Class<?> clazz) {
            return this.unsafe.arrayBaseOffset(clazz);
        }

        public final int arrayIndexScale(Class<?> clazz) {
            return this.unsafe.arrayIndexScale(clazz);
        }

        public boolean supportsUnsafeArrayOperations() {
            if (this.unsafe != null) goto L10;
            return false;
        L10:
            Class<?> clazz = this.unsafe.getClass();     // Catch: Throwable -> L7
            clazz.getMethod("objectFieldOffset", new Class[]{Field.class});     // Catch: Throwable -> L7
            clazz.getMethod("arrayBaseOffset", new Class[]{Class.class});     // Catch: Throwable -> L7
            clazz.getMethod("arrayIndexScale", new Class[]{Class.class});     // Catch: Throwable -> L7
            clazz.getMethod("getInt", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("getLong", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("getObject", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L7
            clazz.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});     // Catch: Throwable -> L7
            return true;
        L7:
            e = move-exception;
            UnsafeUtil.access$000(e);
            return false;
        }

        public final int getInt(Object target, long offset) {
            return this.unsafe.getInt(target, offset);
        }

        public final void putInt(Object target, long offset, int value) {
            this.unsafe.putInt(target, offset, value);
        }

        public final long getLong(Object target, long offset) {
            return this.unsafe.getLong(target, offset);
        }

        public final void putLong(Object target, long offset, long value) {
            this.unsafe.putLong(target, offset, value);
        }

        public final Object getObject(Object target, long offset) {
            return this.unsafe.getObject(target, offset);
        }

        public final void putObject(Object target, long offset, Object value) {
            this.unsafe.putObject(target, offset, value);
        }

        public boolean supportsUnsafeByteBufferOperations() {
            if (this.unsafe != null) goto L12;
            return false;
        L12:
            Class<?> clazz = this.unsafe.getClass();     // Catch: Throwable -> L9
            clazz.getMethod("objectFieldOffset", new Class[]{Field.class});     // Catch: Throwable -> L9
            clazz.getMethod("getLong", new Class[]{Object.class, Long.TYPE});     // Catch: Throwable -> L9
            if (UnsafeUtil.access$100() != null) goto L8;
            return false;
        L8:
            return true;
        L9:
            e = move-exception;
            UnsafeUtil.access$000(e);
            return false;
        }
    }

    static /* synthetic */ void access$000(Throwable x0) {
        logMissingMethod(x0);
    }

    static /* synthetic */ Field access$100() {
        return bufferAddressField();
    }

    static /* synthetic */ byte access$200(Object x0, long x1) {
        return getByteBigEndian(x0, x1);
    }

    static /* synthetic */ byte access$300(Object x0, long x1) {
        return getByteLittleEndian(x0, x1);
    }

    static /* synthetic */ void access$400(Object x0, long x1, byte x2) {
        putByteBigEndian(x0, x1, x2);
    }

    static /* synthetic */ void access$500(Object x0, long x1, byte x2) {
        putByteLittleEndian(x0, x1, x2);
    }

    static /* synthetic */ boolean access$600(Object x0, long x1) {
        return getBooleanBigEndian(x0, x1);
    }

    static /* synthetic */ boolean access$700(Object x0, long x1) {
        return getBooleanLittleEndian(x0, x1);
    }

    static /* synthetic */ void access$800(Object x0, long x1, boolean x2) {
        putBooleanBigEndian(x0, x1, x2);
    }

    static /* synthetic */ void access$900(Object x0, long x1, boolean x2) {
        putBooleanLittleEndian(x0, x1, x2);
    }

    static {
        UNSAFE = getUnsafe();
        MEMORY_CLASS = Android.getMemoryClass();
        IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
        IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
        MEMORY_ACCESSOR = getMemoryAccessor();
        HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
        HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
        BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset(byte[].class);
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
        BYTE_ARRAY_ALIGNMENT = (int) (BYTE_ARRAY_BASE_OFFSET & 7);
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

    static <T> T allocateInstance(Class<T> r2) {
        return (T) UNSAFE.allocateInstance(r2);
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    static long objectFieldOffset(Field field) {
        return MEMORY_ACCESSOR.objectFieldOffset(field);
    }

    private static int arrayBaseOffset(Class<?> clazz) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS == true) goto L7;
        return -1;
    L7:
        return MEMORY_ACCESSOR.arrayBaseOffset(clazz);
    }

    private static int arrayIndexScale(Class<?> clazz) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS == true) goto L7;
        return -1;
    L7:
        return MEMORY_ACCESSOR.arrayIndexScale(clazz);
    }

    static byte getByte(Object target, long offset) {
        return MEMORY_ACCESSOR.getByte(target, offset);
    }

    static void putByte(Object target, long offset, byte value) {
        MEMORY_ACCESSOR.putByte(target, offset, value);
    }

    static int getInt(Object target, long offset) {
        return MEMORY_ACCESSOR.getInt(target, offset);
    }

    static void putInt(Object target, long offset, int value) {
        MEMORY_ACCESSOR.putInt(target, offset, value);
    }

    static long getLong(Object target, long offset) {
        return MEMORY_ACCESSOR.getLong(target, offset);
    }

    static void putLong(Object target, long offset, long value) {
        MEMORY_ACCESSOR.putLong(target, offset, value);
    }

    static boolean getBoolean(Object target, long offset) {
        return MEMORY_ACCESSOR.getBoolean(target, offset);
    }

    static void putBoolean(Object target, long offset, boolean value) {
        MEMORY_ACCESSOR.putBoolean(target, offset, value);
    }

    static float getFloat(Object target, long offset) {
        return MEMORY_ACCESSOR.getFloat(target, offset);
    }

    static void putFloat(Object target, long offset, float value) {
        MEMORY_ACCESSOR.putFloat(target, offset, value);
    }

    static double getDouble(Object target, long offset) {
        return MEMORY_ACCESSOR.getDouble(target, offset);
    }

    static void putDouble(Object target, long offset, double value) {
        MEMORY_ACCESSOR.putDouble(target, offset, value);
    }

    static Object getObject(Object target, long offset) {
        return MEMORY_ACCESSOR.getObject(target, offset);
    }

    static void putObject(Object target, long offset, Object value) {
        MEMORY_ACCESSOR.putObject(target, offset, value);
    }

    static byte getByte(byte[] target, long index) {
        return MEMORY_ACCESSOR.getByte(target, BYTE_ARRAY_BASE_OFFSET + index);
    }

    static void putByte(byte[] target, long index, byte value) {
        MEMORY_ACCESSOR.putByte(target, BYTE_ARRAY_BASE_OFFSET + index, value);
    }

    static int getInt(int[] target, long index) {
        return MEMORY_ACCESSOR.getInt(target, INT_ARRAY_BASE_OFFSET + (INT_ARRAY_INDEX_SCALE * index));
    }

    static void putInt(int[] target, long index, int value) {
        MEMORY_ACCESSOR.putInt(target, INT_ARRAY_BASE_OFFSET + (INT_ARRAY_INDEX_SCALE * index), value);
    }

    static long getLong(long[] target, long index) {
        return MEMORY_ACCESSOR.getLong(target, LONG_ARRAY_BASE_OFFSET + (LONG_ARRAY_INDEX_SCALE * index));
    }

    static void putLong(long[] target, long index, long value) {
        MEMORY_ACCESSOR.putLong(target, LONG_ARRAY_BASE_OFFSET + (LONG_ARRAY_INDEX_SCALE * index), value);
    }

    static boolean getBoolean(boolean[] target, long index) {
        return MEMORY_ACCESSOR.getBoolean(target, BOOLEAN_ARRAY_BASE_OFFSET + (BOOLEAN_ARRAY_INDEX_SCALE * index));
    }

    static void putBoolean(boolean[] target, long index, boolean value) {
        MEMORY_ACCESSOR.putBoolean(target, BOOLEAN_ARRAY_BASE_OFFSET + (BOOLEAN_ARRAY_INDEX_SCALE * index), value);
    }

    static float getFloat(float[] target, long index) {
        return MEMORY_ACCESSOR.getFloat(target, FLOAT_ARRAY_BASE_OFFSET + (FLOAT_ARRAY_INDEX_SCALE * index));
    }

    static void putFloat(float[] target, long index, float value) {
        MEMORY_ACCESSOR.putFloat(target, FLOAT_ARRAY_BASE_OFFSET + (FLOAT_ARRAY_INDEX_SCALE * index), value);
    }

    static double getDouble(double[] target, long index) {
        return MEMORY_ACCESSOR.getDouble(target, DOUBLE_ARRAY_BASE_OFFSET + (DOUBLE_ARRAY_INDEX_SCALE * index));
    }

    static void putDouble(double[] target, long index, double value) {
        MEMORY_ACCESSOR.putDouble(target, DOUBLE_ARRAY_BASE_OFFSET + (DOUBLE_ARRAY_INDEX_SCALE * index), value);
    }

    static Object getObject(Object[] target, long index) {
        return MEMORY_ACCESSOR.getObject(target, OBJECT_ARRAY_BASE_OFFSET + (OBJECT_ARRAY_INDEX_SCALE * index));
    }

    static void putObject(Object[] target, long index, Object value) {
        MEMORY_ACCESSOR.putObject(target, OBJECT_ARRAY_BASE_OFFSET + (OBJECT_ARRAY_INDEX_SCALE * index), value);
    }

    static void copyMemory(byte[] src, long srcIndex, long targetOffset, long length) {
        MEMORY_ACCESSOR.copyMemory(src, srcIndex, targetOffset, length);
    }

    static void copyMemory(long srcOffset, byte[] target, long targetIndex, long length) {
        MEMORY_ACCESSOR.copyMemory(srcOffset, target, targetIndex, length);
    }

    static void copyMemory(byte[] src, long srcIndex, byte[] target, long targetIndex, long length) {
        System.arraycopy(src, (int) srcIndex, target, (int) targetIndex, (int) length);
    }

    static byte getByte(long address) {
        return MEMORY_ACCESSOR.getByte(address);
    }

    static void putByte(long address, byte value) {
        MEMORY_ACCESSOR.putByte(address, value);
    }

    static int getInt(long address) {
        return MEMORY_ACCESSOR.getInt(address);
    }

    static void putInt(long address, int value) {
        MEMORY_ACCESSOR.putInt(address, value);
    }

    static long getLong(long address) {
        return MEMORY_ACCESSOR.getLong(address);
    }

    static void putLong(long address, long value) {
        MEMORY_ACCESSOR.putLong(address, value);
    }

    static long addressOffset(ByteBuffer buffer) {
        return MEMORY_ACCESSOR.getLong(buffer, BUFFER_ADDRESS_OFFSET);
    }

    static Object getStaticObject(Field field) {
        return MEMORY_ACCESSOR.getStaticObject(field);
    }

    static Unsafe getUnsafe() {
        Unsafe unsafe = (Unsafe) AccessController.doPrivileged(new AnonymousClass1());     // Catch: Throwable -> L5
        return unsafe;
    L6:
        return null;
    }

    private static MemoryAccessor getMemoryAccessor() {
        if (UNSAFE != null) goto L6;
        return null;
    L6:
        if (Android.isOnAndroidDevice() == false) goto L17;
        if (IS_ANDROID_64 == false) goto L12;
        return new Android64MemoryAccessor(UNSAFE);
    L12:
        if (IS_ANDROID_32 == true) goto L14;
        return null;
    L14:
        return new Android32MemoryAccessor(UNSAFE);
    L17:
        return new JvmMemoryAccessor(UNSAFE);
    }

    private static boolean supportsUnsafeArrayOperations() {
        if (MEMORY_ACCESSOR != null) goto L7;
        return false;
    L7:
        return MEMORY_ACCESSOR.supportsUnsafeArrayOperations();
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        if (MEMORY_ACCESSOR != null) goto L7;
        return false;
    L7:
        return MEMORY_ACCESSOR.supportsUnsafeByteBufferOperations();
    }

    static boolean determineAndroidSupportByAddressSize(Class<?> addressClass) {
        if (Android.isOnAndroidDevice() == true) goto L9;
        return false;
    L9:
        Class<?> clazz = MEMORY_CLASS;     // Catch: Throwable -> L7
        clazz.getMethod("peekLong", new Class[]{addressClass, Boolean.TYPE});     // Catch: Throwable -> L7
        clazz.getMethod("pokeLong", new Class[]{addressClass, Long.TYPE, Boolean.TYPE});     // Catch: Throwable -> L7
        clazz.getMethod("pokeInt", new Class[]{addressClass, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L7
        clazz.getMethod("peekInt", new Class[]{addressClass, Boolean.TYPE});     // Catch: Throwable -> L7
        clazz.getMethod("pokeByte", new Class[]{addressClass, Byte.TYPE});     // Catch: Throwable -> L7
        clazz.getMethod("peekByte", new Class[]{addressClass});     // Catch: Throwable -> L7
        clazz.getMethod("pokeByteArray", new Class[]{addressClass, byte[].class, Integer.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
        clazz.getMethod("peekByteArray", new Class[]{addressClass, byte[].class, Integer.TYPE, Integer.TYPE});     // Catch: Throwable -> L7
        return true;
    L8:
        return false;
    }

    private static Field bufferAddressField() {
        if (Android.isOnAndroidDevice() == false) goto L7;
        Field field = field(Buffer.class, "effectiveDirectAddress");
        if (field == null) goto L7;
        return field;
    L7:
        Field field2 = field(Buffer.class, "address");
        if (field2 != null) goto L10;
    L12:
        return null;
    L10:
        if (field2.getType() != Long.TYPE) goto L12;
        return field2;
    }

    private static int firstDifferingByteIndexNativeEndian(long left, long right) {
        if (IS_BIG_ENDIAN == false) goto L5;
        int n = Long.numberOfLeadingZeros(left ^ right);
    L7:
        return n >> 3;
    L5:
        n = Long.numberOfTrailingZeros(left ^ right);
        goto L7
    }

    static int mismatch(byte[] left, int leftOff, byte[] right, int rightOff, int length) {
        if (leftOff < 0) goto L34;
        if (rightOff < 0) goto L34;
        if (length < 0) goto L34;
        if ((leftOff + length) > left.length) goto L34;
        if ((rightOff + length) > right.length) goto L34;
        int index = 0;
        if (HAS_UNSAFE_ARRAY_OPERATIONS == false) goto L26;
        int leftAlignment = (BYTE_ARRAY_ALIGNMENT + leftOff) & 7;
    L12:
        if (index >= length) goto L19;
        if ((leftAlignment & 7) == 0) goto L19;
        if (left[leftOff + index] != right[rightOff + index]) goto L17;
        index = index + 1;
        leftAlignment = leftAlignment + 1;
        goto L12
    L17:
        return index;
    L19:
        int strideLength = ((length - index) & (-8)) + index;
    L20:
        if (index >= strideLength) goto L26;
        long leftLongWord = getLong(left, (BYTE_ARRAY_BASE_OFFSET + ((long) leftOff)) + ((long) index));
        long rightLongWord = getLong(right, (BYTE_ARRAY_BASE_OFFSET + ((long) rightOff)) + ((long) index));
        if (leftLongWord != rightLongWord) goto L24;
        index = index + 8;
        goto L20
    L24:
        return firstDifferingByteIndexNativeEndian(leftLongWord, rightLongWord) + index;
    L26:
        if (index >= length) goto L31;
        if (left[leftOff + index] != right[rightOff + index]) goto L29;
        index = index + 1;
        goto L26
    L29:
        return index;
    L31:
        return -1;
    L34:
        throw new IndexOutOfBoundsException();
    }

    private static long fieldOffset(Field field) {
        if (field != null) goto L4;
    L7:
        return -1;
    L4:
        if (MEMORY_ACCESSOR == null) goto L7;
        return MEMORY_ACCESSOR.objectFieldOffset(field);
    }

    private static Field field(Class<?> clazz, String fieldName) {
        Field field = clazz.getDeclaredField(fieldName);     // Catch: Throwable -> L4
        return field;
    L6:
        return null;
    }

    private static byte getByteBigEndian(Object target, long offset) {
        return (byte) ((getInt(target, (-4) & offset) >>> ((int) (((~offset) & 3) << 3))) & 255);
    }

    private static byte getByteLittleEndian(Object target, long offset) {
        return (byte) ((getInt(target, (-4) & offset) >>> ((int) ((3 & offset) << 3))) & 255);
    }

    private static void putByteBigEndian(Object target, long offset, byte value) {
        int intValue = getInt(target, offset & (-4));
        int shift = ((~((int) offset)) & 3) << 3;
        int output = ((~(255 << shift)) & intValue) | ((value & CecDeviceType.INACTIVE) << shift);
        putInt(target, (-4) & offset, output);
    }

    private static void putByteLittleEndian(Object target, long offset, byte value) {
        int intValue = getInt(target, offset & (-4));
        int shift = (((int) offset) & 3) << 3;
        int output = ((~(255 << shift)) & intValue) | ((value & CecDeviceType.INACTIVE) << shift);
        putInt(target, (-4) & offset, output);
    }

    private static boolean getBooleanBigEndian(Object target, long offset) {
        if (getByteBigEndian(target, offset) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean getBooleanLittleEndian(Object target, long offset) {
        if (getByteLittleEndian(target, offset) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private static void putBooleanBigEndian(Object r1, long r2, boolean r4) {
        putByteBigEndian(r1, r2, r4 ? 1 : 0);
    }

    private static void putBooleanLittleEndian(Object r1, long r2, boolean r4) {
        putByteLittleEndian(r1, r2, r4 ? 1 : 0);
    }

    private static void logMissingMethod(Throwable e) {
        Logger.getLogger(UnsafeUtil.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + e);
    }
}
