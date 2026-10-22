package com.bytedance.location.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes3.dex */
final class ByteBufferWriter {
    private static final ThreadLocal<SoftReference<byte[]>> BUFFER = null;
    private static final float BUFFER_REALLOCATION_THRESHOLD = 0.5f;
    private static final long CHANNEL_FIELD_OFFSET = 0;
    private static final Class<?> FILE_OUTPUT_STREAM_CLASS = null;
    private static final int MAX_CACHED_BUFFER_SIZE = 16384;
    private static final int MIN_CACHED_BUFFER_SIZE = 1024;

    private ByteBufferWriter() {
    }

    static {
        BUFFER = new ThreadLocal();
        FILE_OUTPUT_STREAM_CLASS = safeGetClass("java.io.FileOutputStream");
        CHANNEL_FIELD_OFFSET = getChannelFieldOffset(FILE_OUTPUT_STREAM_CLASS);
    }

    static void clearCachedBuffer() {
        BUFFER.set(null);
    }

    static void write(ByteBuffer buffer, OutputStream output) throws IOException {
        int initialPos = buffer.position();
    L6:
        th = move-exception;
        buffer.position(initialPos);
        throw th;
    L4:
        if (buffer.hasArray() == false) goto L9;
        output.write(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());     // Catch: Throwable -> L6
    L15:
        buffer.position(initialPos);
        return;
    L9:
        if (writeToChannel(buffer, output) == true) goto L15;
        byte[] array = getOrCreateBuffer(buffer.remaining());     // Catch: Throwable -> L6
    L12:
        if (buffer.hasRemaining() == false) goto L15;
        int length = Math.min(buffer.remaining(), array.length);     // Catch: Throwable -> L6
        buffer.get(array, 0, length);     // Catch: Throwable -> L6
        output.write(array, 0, length);     // Catch: Throwable -> L6
        goto L12
    }

    private static byte[] getOrCreateBuffer(int requestedSize) {
        int requestedSize2 = Math.max(requestedSize, 1024);
        byte[] buffer = getBuffer();
        if (buffer != null) goto L5;
    L6:
        buffer = new byte[requestedSize2];
        if (requestedSize2 > 16384) goto L9;
        setBuffer(buffer);
    L9:
        return buffer;
    L5:
        if (needToReallocate(requestedSize2, buffer.length) == false) goto L9;
        goto L6
    }

    private static boolean needToReallocate(int requestedSize, int bufferLength) {
        if (bufferLength < requestedSize) goto L4;
    L6:
        return false;
    L4:
        if (bufferLength >= (requestedSize * BUFFER_REALLOCATION_THRESHOLD)) goto L6;
        return true;
    }

    private static byte[] getBuffer() {
        SoftReference<byte[]> sr = BUFFER.get();
        if (sr != null) goto L6;
        return null;
    L6:
        return sr.get();
    }

    private static void setBuffer(byte[] value) {
        BUFFER.set(new SoftReference(value));
    }

    private static boolean writeToChannel(ByteBuffer buffer, OutputStream output) throws IOException {
        if (CHANNEL_FIELD_OFFSET >= 0) goto L5;
        return false;
    L5:
        if (FILE_OUTPUT_STREAM_CLASS.isInstance(output) == false) goto L17;
        WritableByteChannel channel = null;
        channel = (WritableByteChannel) UnsafeUtil.getObject(output, CHANNEL_FIELD_OFFSET);     // Catch: ClassCastException -> L9
    L10:
        if (channel == null) goto L18;
        channel.write(buffer);
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    private static Class<?> safeGetClass(String className) {
        return Class.forName(className);
    L5:
        return null;
    }

    private static long getChannelFieldOffset(Class<?> clazz) {
        if (clazz == null) goto L14;
        if (UnsafeUtil.hasUnsafeArrayOperations() == false) goto L15;
        Field field = clazz.getDeclaredField("channel");     // Catch: Throwable -> L7
        return UnsafeUtil.objectFieldOffset(field);
    L15:
        return -1;
    L10:
        return -1;
    L14:
        return -1;
    }
}
