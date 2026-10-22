package com.bumptech.glide.util;

import androidx.collection.SieveCacheKt;
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
import kotlin.UByte;

/* JADX INFO: loaded from: classes39.dex */
public final class ByteBufferUtil {
    private static final AtomicReference<byte[]> BUFFER_REF = null;
    private static final int BUFFER_SIZE = 16384;

    public static class ByteBufferStream extends InputStream {
        private static final int UNSET = -1;
        private final ByteBuffer byteBuffer;
        private int markPos;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            monitor-enter(this);
            int r100 = this.markPos;     // Catch: Throwable -> L10
            if (r100 == (-1)) goto L9;
            this.byteBuffer.position(r100);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L9:
            throw new IOException("Cannot reset to unset mark position");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.byteBuffer.remaining();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.byteBuffer.hasRemaining() == true) goto L7;
            return -1;
        L7:
            return this.byteBuffer.get() & UByte.MAX_VALUE;
        }

        public ByteBufferStream(ByteBuffer r100) {
            this.markPos = -1;
            this.byteBuffer = r100;
        }

        @Override // java.io.InputStream
        public synchronized void mark(int r100) {
            monitor-enter(this);
            this.markPos = this.byteBuffer.position();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        @Override // java.io.InputStream
        public long skip(long r100) throws IOException {
            if (this.byteBuffer.hasRemaining() == true) goto L6;
            return -1;
        L6:
            long r101 = Math.min(r100, available());
            ByteBuffer r102 = this.byteBuffer;
            r102.position((int) (((long) r102.position()) + r101));
            return r101;
        }

        @Override // java.io.InputStream
        public int read(byte[] r100, int r101, int r102) throws IOException {
            if (this.byteBuffer.hasRemaining() == true) goto L6;
            return -1;
        L6:
            int r103 = Math.min(r102, available());
            this.byteBuffer.get(r100, r101, r103);
            return r103;
        }
    }

    public static final class SafeArray {
        final byte[] data;
        final int limit;
        final int offset;

        public SafeArray(byte[] r100, int r101, int r102) {
            this.data = r100;
            this.offset = r101;
            this.limit = r102;
        }
    }

    static {
        BUFFER_REF = new AtomicReference();
    }

    private ByteBufferUtil() {
    }

    public static ByteBuffer fromFile(File r100) throws IOException {
        FileChannel r101 = null;
        File r102 = GlideCommonUtils.getDecryptFile(r100);     // Catch: Throwable -> L22
        if (r102 == null) goto L6;
        long r103 = r102.length();     // Catch: Throwable -> L22
    L8:
        if (r103 > SieveCacheKt.NodeLinkMask) goto L21;
        if (r103 == 0) goto L19;
        RandomAccessFile r104 = new RandomAccessFile(r102, "r");     // Catch: Throwable -> L22
        r101 = r104.getChannel();     // Catch: Throwable -> L16
        MappedByteBuffer r105 = r101.map(FileChannel.MapMode.READ_ONLY, 0, r103).load();     // Catch: Throwable -> L16
        r101.close();     // Catch: IOException -> L31
    L34:
        r104.close();     // Catch: IOException -> L32
    L15:
        return r105;
    L16:
        th = th;
    L24:
        if (r101 != null) goto L40;
    L28:
        if (r104 == null) goto L45;
        r104.close();     // Catch: IOException -> L33
        throw th;
    L46:
        throw th;
    L45:
        throw th;
    L40:
        r101.close();     // Catch: IOException -> L27
        goto L28
    L19:
        throw new IOException("File unsuitable for memory mapping");     // Catch: Throwable -> L22
    L21:
        throw new IOException("File too large to map into memory");     // Catch: Throwable -> L22
    L6:
        r103 = 0;
    L22:
        th = th;
        r104 = null;
        goto L24
    }

    public static ByteBuffer fromStream(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream(16384);
        byte[] r102 = BUFFER_REF.getAndSet(null);
        if (r102 != null) goto L5;
        r102 = new byte[16384];
    L5:
        int r103 = r100.read(r102);
        if (r103 < 0) goto L8;
        r101.write(r102, 0, r103);
        goto L5
    L8:
        BUFFER_REF.set(r102);
        byte[] r104 = r101.toByteArray();
        return (ByteBuffer) ByteBuffer.allocateDirect(r104.length).put(r104).position(0);
    }

    private static SafeArray getSafeArray(ByteBuffer r100) {
        if (r100.isReadOnly() == false) goto L5;
        return null;
    L5:
        if (r100.hasArray() == true) goto L7;
        return null;
    L7:
        return new SafeArray(r100.array(), r100.arrayOffset(), r100.limit());
    }

    public static byte[] toBytes(ByteBuffer r100) {
        SafeArray r101 = getSafeArray(r100);
        if (r101 != null) goto L5;
    L9:
        ByteBuffer r102 = r100.asReadOnlyBuffer();
        byte[] r103 = new byte[r102.limit()];
        r102.position(0);
        r102.get(r103);
        return r103;
    L5:
        if (r101.offset != 0) goto L9;
        if (r101.limit != r101.data.length) goto L9;
        return r100.array();
    }

    public static InputStream toStream(ByteBuffer r100) {
        return new ByteBufferStream(r100);
    }

    public static void toFile(ByteBuffer r100, File r101) throws IOException {
        r100.position(0);
        FileChannel r102 = null;
        RandomAccessFile r103 = new RandomAccessFile(r101, "rw");     // Catch: Throwable -> L10
        r102 = r103.getChannel();     // Catch: Throwable -> L8
        r102.write(r100);     // Catch: Throwable -> L8
        r102.force(false);     // Catch: Throwable -> L8
        r102.close();     // Catch: Throwable -> L8
        r103.close();     // Catch: Throwable -> L8
        r102.close();     // Catch: IOException -> L19
    L24:
        r103.close();     // Catch: IOException -> L20
        return;
    L34:
        return;
    L8:
        th = th;
    L12:
        if (r102 != null) goto L32;
    L16:
        if (r103 == null) goto L35;
        r103.close();     // Catch: IOException -> L21
        throw th;
    L36:
        throw th;
    L35:
        throw th;
    L32:
        r102.close();     // Catch: IOException -> L15
    L10:
        th = th;
        r103 = null;
        goto L12
    }

    public static void toStream(ByteBuffer r100, OutputStream r101) throws IOException {
        SafeArray r102 = getSafeArray(r100);
        if (r102 == null) goto L5;
        byte[] r103 = r102.data;
        int r104 = r102.offset;
        r101.write(r103, r104, r102.limit + r104);
        return;
    L5:
        byte[] r105 = BUFFER_REF.getAndSet(null);
        if (r105 != null) goto L9;
        r105 = new byte[16384];
    L9:
        if (r100.remaining() <= 0) goto L11;
        int r106 = Math.min(r100.remaining(), r105.length);
        r100.get(r105, 0, r106);
        r101.write(r105, 0, r106);
        goto L9
    L11:
        BUFFER_REF.set(r105);
    }
}
