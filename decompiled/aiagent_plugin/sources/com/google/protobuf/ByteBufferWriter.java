package com.google.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes2.dex */
final class ByteBufferWriter {
    private static final ThreadLocal<SoftReference<byte[]>> BUFFER = null;
    private static final float BUFFER_REALLOCATION_THRESHOLD = 0.5f;
    private static final long CHANNEL_FIELD_OFFSET = 0;
    private static final Class<?> FILE_OUTPUT_STREAM_CLASS = null;
    private static final int MAX_CACHED_BUFFER_SIZE = 16384;
    private static final int MIN_CACHED_BUFFER_SIZE = 1024;

    private static boolean needToReallocate(int r1, int r2) {
        if (r2 < r1) goto L4;
    L6:
        return false;
    L4:
        if (r2 >= (r1 * BUFFER_REALLOCATION_THRESHOLD)) goto L6;
        return true;
    }

    private ByteBufferWriter() {
    }

    static {
        BUFFER = new ThreadLocal();
        Class<?> r0 = safeGetClass("java.io.FileOutputStream");
        FILE_OUTPUT_STREAM_CLASS = r0;
        CHANNEL_FIELD_OFFSET = getChannelFieldOffset(r0);
    }

    static void clearCachedBuffer() {
        BUFFER.set(null);
    }

    static void write(ByteBuffer r4, OutputStream r5) {
        int r0 = r4.position();
    L15:
        th = move-exception;
        Java8Compatibility.position(r4, r0);
        throw th;
    L4:
        if (r4.hasArray() == false) goto L7;
        r5.write(r4.array(), r4.arrayOffset() + r4.position(), r4.remaining());     // Catch: Throwable -> L15
    L13:
        Java8Compatibility.position(r4, r0);
        return;
    L7:
        if (writeToChannel(r4, r5) == true) goto L13;
        byte[] r1 = getOrCreateBuffer(r4.remaining());     // Catch: Throwable -> L15
    L10:
        if (r4.hasRemaining() == false) goto L13;
        int r2 = Math.min(r4.remaining(), r1.length);     // Catch: Throwable -> L15
        r4.get(r1, 0, r2);     // Catch: Throwable -> L15
        r5.write(r1, 0, r2);     // Catch: Throwable -> L15
        goto L10
    }

    private static byte[] getOrCreateBuffer(int r2) {
        int r3 = Math.max(r2, 1024);
        byte[] r0 = getBuffer();
        if (r0 != null) goto L5;
    L6:
        r0 = new byte[r3];
        if (r3 > 16384) goto L9;
        setBuffer(r0);
    L9:
        return r0;
    L5:
        if (needToReallocate(r3, r0.length) == false) goto L9;
        goto L6
    }

    private static byte[] getBuffer() {
        SoftReference r0 = (SoftReference) ZeusTransformUtils.preCheckCast(BUFFER.get(), SoftReference.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        return null;
    L6:
        return (byte[]) ZeusTransformUtils.preCheckCast(r0.get(), byte[].class, "com.obric.aiagent.plugin");
    }

    private static void setBuffer(byte[] r2) {
        BUFFER.set(new SoftReference(r2));
    }

    private static boolean writeToChannel(ByteBuffer r4, OutputStream r5) {
        long r0 = CHANNEL_FIELD_OFFSET;
        if (r0 >= 0) goto L5;
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(FILE_OUTPUT_STREAM_CLASS, r5) == false) goto L17;
        WritableByteChannel r2 = null;
        r2 = (WritableByteChannel) ZeusTransformUtils.preCheckCast(UnsafeUtil.getObject(r5, r0), WritableByteChannel.class, "com.obric.aiagent.plugin");     // Catch: ClassCastException -> L14
    L9:
        if (r2 == null) goto L18;
        r2.write(r4);
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    private static Class<?> safeGetClass(String r1) {
        return ZeusTransformUtils.forName(r1, "com.obric.aiagent.plugin");
    L4:
        return null;
    }

    private static long getChannelFieldOffset(Class<?> r2) {
        if (r2 != null) goto L10;
        return -1;
    L10:
        if (UnsafeUtil.hasUnsafeArrayOperations() == false) goto L12;
        return UnsafeUtil.objectFieldOffset(r2.getDeclaredField("channel"));
    L12:
        return -1;
    L13:
        return -1;
    }
}
