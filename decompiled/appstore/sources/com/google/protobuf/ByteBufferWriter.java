package com.google.protobuf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
final class ByteBufferWriter {
    private static final ThreadLocal<SoftReference<byte[]>> BUFFER = null;
    private static final float BUFFER_REALLOCATION_THRESHOLD = 0.5f;
    private static final int MAX_CACHED_BUFFER_SIZE = 16384;
    private static final int MIN_CACHED_BUFFER_SIZE = 1024;

    static {
        BUFFER = new ThreadLocal();
    }

    private ByteBufferWriter() {
    }

    public static void clearCachedBuffer() {
        BUFFER.set(null);
    }

    private static byte[] getBuffer() {
        SoftReference<byte[]> r10 = BUFFER.get();
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.get();
    }

    private static byte[] getOrCreateBuffer(int r10) {
        int r11 = Math.max(r10, 1024);
        byte[] r12 = getBuffer();
        if (r12 != null) goto L5;
    L6:
        r12 = new byte[r11];
        if (r11 > 16384) goto L9;
        setBuffer(r12);
    L9:
        return r12;
    L5:
        if (needToReallocate(r11, r12.length) == false) goto L9;
        goto L6
    }

    private static boolean needToReallocate(int r10, int r11) {
        if (r11 < r10) goto L4;
    L6:
        return false;
    L4:
        if (r11 >= (r10 * BUFFER_REALLOCATION_THRESHOLD)) goto L6;
        return true;
    }

    private static void setBuffer(byte[] r10) {
        BUFFER.set(new SoftReference(r10));
    }

    public static void write(ByteBuffer r10, OutputStream r11) throws IOException {
        int r12 = r10.position();
    L6:
        th = move-exception;
        r10.position(r12);
        throw th;
    L4:
        if (r10.hasArray() == false) goto L9;
        r11.write(r10.array(), r10.arrayOffset() + r10.position(), r10.remaining());     // Catch: Throwable -> L6
    L16:
        r10.position(r12);
        return;
    L9:
        if ((r11 instanceof FileOutputStream) == false) goto L11;
        ((FileOutputStream) r11).getChannel().write(r10);     // Catch: Throwable -> L6
        goto L16
    L11:
        byte[] r13 = getOrCreateBuffer(r10.remaining());     // Catch: Throwable -> L6
    L13:
        if (r10.hasRemaining() == false) goto L16;
        int r14 = Math.min(r10.remaining(), r13.length);     // Catch: Throwable -> L6
        r10.get(r13, 0, r14);     // Catch: Throwable -> L6
        r11.write(r13, 0, r14);     // Catch: Throwable -> L6
        goto L13
    }
}
