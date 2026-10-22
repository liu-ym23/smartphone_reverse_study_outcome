package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class ByteBufferUtil {
    private static final AtomicReference<byte[]> BUFFER_REF = null;
    private static final int BUFFER_SIZE = 16384;

    public static class ByteBufferStream extends InputStream {
        private static final int UNSET = -1;

        @NonNull
        private final ByteBuffer byteBuffer;
        private int markPos;

        public ByteBufferStream(@NonNull ByteBuffer r10) {
            this.markPos = -1;
            this.byteBuffer = r10;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.byteBuffer.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int r10) {
            monitor-enter(this);
            this.markPos = this.byteBuffer.position();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.byteBuffer.hasRemaining() == true) goto L7;
            return -1;
        L7:
            return this.byteBuffer.get();
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            monitor-enter(this);
            int r10 = this.markPos;     // Catch: Throwable -> L8
            if (r10 == (-1)) goto L11;
            this.byteBuffer.position(r10);     // Catch: Throwable -> L8
            monitor-exit(this);
            return;
        L11:
            throw new IOException("Cannot reset to unset mark position");     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        @Override // java.io.InputStream
        public long skip(long r10) throws IOException {
            if (this.byteBuffer.hasRemaining() == true) goto L6;
            return -1;
        L6:
            long r11 = Math.min(r10, available());
            ByteBuffer r12 = this.byteBuffer;
            r12.position((int) (((long) r12.position()) + r11));
            return r11;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] r10, int r11, int r12) throws IOException {
            if (this.byteBuffer.hasRemaining() == true) goto L6;
            return -1;
        L6:
            int r13 = Math.min(r12, available());
            this.byteBuffer.get(r10, r11, r13);
            return r13;
        }
    }

    public static final class SafeArray {
        final byte[] data;
        final int limit;
        final int offset;

        public SafeArray(@NonNull byte[] r10, int r11, int r12) {
            this.data = r10;
            this.offset = r11;
            this.limit = r12;
        }
    }

    static {
        BUFFER_REF = new AtomicReference();
    }

    private ByteBufferUtil() {
    }

    @NonNull
    public static ByteBuffer fromFile(@NonNull File r10) throws IOException {
        FileChannel r11 = null;
        long r12 = r10.length();     // Catch: Throwable -> L14
        if (r12 > 2147483647L) goto L19;
        if (r12 == 0) goto L17;
        RandomAccessFile r13 = new RandomAccessFile(r10, "r");     // Catch: Throwable -> L14
        r11 = r13.getChannel();     // Catch: Throwable -> L12
        MappedByteBuffer r14 = r11.map(FileChannel.MapMode.READ_ONLY, 0, r12).load();     // Catch: Throwable -> L12
        r11.close();     // Catch: IOException -> L25
    L34:
        r13.close();     // Catch: IOException -> L26
    L11:
        return r14;
    L12:
        th = th;
    L20:
        if (r11 != null) goto L38;
    L22:
        if (r13 == null) goto L40;
        r13.close();     // Catch: IOException -> L28
        throw th;
    L41:
        throw th;
    L40:
        throw th;
    L38:
        r11.close();     // Catch: IOException -> L27
        goto L22
    L17:
        throw new IOException("File unsuitable for memory mapping");     // Catch: Throwable -> L14
    L19:
        throw new IOException("File too large to map into memory");     // Catch: Throwable -> L14
    L14:
        th = th;
        r13 = null;
        goto L20
    }

    @NonNull
    public static ByteBuffer fromStream(@NonNull InputStream r10) throws IOException {
        ByteArrayOutputStream r11 = new ByteArrayOutputStream(16384);
        byte[] r12 = BUFFER_REF.getAndSet(null);
        if (r12 != null) goto L5;
        r12 = new byte[16384];
    L5:
        int r13 = r10.read(r12);
        if (r13 < 0) goto L8;
        r11.write(r12, 0, r13);
        goto L5
    L8:
        BUFFER_REF.set(r12);
        byte[] r14 = r11.toByteArray();
        return (ByteBuffer) ByteBuffer.allocateDirect(r14.length).put(r14).position(0);
    }

    @Nullable
    private static SafeArray getSafeArray(@NonNull ByteBuffer r10) {
        if (r10.isReadOnly() == false) goto L5;
        return null;
    L5:
        if (r10.hasArray() == true) goto L7;
        return null;
    L7:
        return new SafeArray(r10.array(), r10.arrayOffset(), r10.limit());
    }

    @NonNull
    public static byte[] toBytes(@NonNull ByteBuffer r10) {
        SafeArray r11 = getSafeArray(r10);
        if (r11 != null) goto L5;
    L9:
        ByteBuffer r12 = r10.asReadOnlyBuffer();
        byte[] r13 = new byte[r12.limit()];
        r12.position(0);
        r12.get(r13);
        return r13;
    L5:
        if (r11.offset != 0) goto L9;
        if (r11.limit != r11.data.length) goto L9;
        return r10.array();
    }

    public static void toFile(@NonNull ByteBuffer r10, @NonNull File r11) throws IOException {
        r10.position(0);
        FileChannel r12 = null;
        RandomAccessFile r13 = new RandomAccessFile(r11, "rw");     // Catch: Throwable -> L10
        r12 = r13.getChannel();     // Catch: Throwable -> L8
        r12.write(r10);     // Catch: Throwable -> L8
        r12.force(false);     // Catch: Throwable -> L8
        r12.close();     // Catch: Throwable -> L8
        r13.close();     // Catch: Throwable -> L8
        r12.close();     // Catch: IOException -> L17
    L27:
        r13.close();     // Catch: IOException -> L18
        return;
    L33:
        return;
    L8:
        th = th;
    L12:
        if (r12 != null) goto L31;
    L14:
        if (r13 == null) goto L34;
        r13.close();     // Catch: IOException -> L20
        throw th;
    L35:
        throw th;
    L34:
        throw th;
    L31:
        r12.close();     // Catch: IOException -> L19
    L10:
        th = th;
        r13 = null;
        goto L12
    }

    public static void toStream(@NonNull ByteBuffer r10, @NonNull OutputStream r11) throws IOException {
        SafeArray r12 = getSafeArray(r10);
        if (r12 == null) goto L5;
        byte[] r13 = r12.data;
        int r14 = r12.offset;
        r11.write(r13, r14, r12.limit + r14);
        return;
    L5:
        byte[] r15 = BUFFER_REF.getAndSet(null);
        if (r15 != null) goto L9;
        r15 = new byte[16384];
    L9:
        if (r10.remaining() <= 0) goto L11;
        int r16 = Math.min(r10.remaining(), r15.length);
        r10.get(r15, 0, r16);
        r11.write(r15, 0, r16);
        goto L9
    L11:
        BUFFER_REF.set(r15);
    }

    @NonNull
    public static InputStream toStream(@NonNull ByteBuffer r10) {
        return new ByteBufferStream(r10);
    }
}
