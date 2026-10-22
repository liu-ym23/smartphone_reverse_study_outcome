package com.ss.android.socialbase.downloader.model;

import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes4.dex */
public class RandomAccessOutputStream implements Closeable {
    private static final int MAX_FLUSH_BUFFER_SIZE = 131072;
    private static final int MIN_FLUSH_BUFFER_SIZE = 8192;
    private RandomOutputStream randomAccess;

    private class BufferRandomAccessOutputStream implements RandomOutputStream {
        private FileDescriptor fd;
        private BufferedOutputStream outputStream;
        private RandomAccessFile randomAccess;
        final /* synthetic */ RandomAccessOutputStream this$0;

        public BufferRandomAccessOutputStream(RandomAccessOutputStream r2, File r3, int r4) {
            this.this$0 = r2;
            RandomAccessFile r5 = new RandomAccessFile(r3, "rw");     // Catch: IOException -> L13
            this.randomAccess = r5;     // Catch: IOException -> L13
            this.fd = r5.getFD();     // Catch: IOException -> L13
            if (r4 > 0) goto L6;
            this.outputStream = new BufferedOutputStream(new FileOutputStream(this.randomAccess.getFD()));     // Catch: IOException -> L13
            return;
        L6:
            if (r4 >= 8192) goto L8;
            r4 = 8192;
        L10:
            this.outputStream = new BufferedOutputStream(new FileOutputStream(this.randomAccess.getFD()), r4);     // Catch: IOException -> L13
            return;
        L8:
            if (r4 <= 131072) goto L10;
            r4 = 131072;
        L13:
            e = move-exception;
            throw new BaseException(DownloadErrorCode.ERROR_OUTPUT_STREAM_CREATE_IO, e);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void write(byte[] r1, int r2, int r3) {
            this.outputStream.write(r1, r2, r3);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void flushAndSync() {
            BufferedOutputStream r0 = this.outputStream;
            if (r0 == null) goto L5;
            r0.flush();
        L5:
            FileDescriptor r1 = this.fd;
            if (r1 == null) goto L9;
            r1.sync();
            return;
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void flush() {
            BufferedOutputStream r0 = this.outputStream;
            if (r0 == null) goto L6;
            r0.flush();
            return;
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void sync() {
            FileDescriptor r0 = this.fd;
            if (r0 == null) goto L6;
            r0.sync();
            return;
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void close() {
            DownloadUtils.safeClose(new Closeable[]{this.outputStream, this.randomAccess});
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void setLength(long r1) {
            this.randomAccess.setLength(r1);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void seek(long r1) {
            this.randomAccess.seek(r1);
        }
    }

    private class ChannelRandomAccessOutputStream implements RandomOutputStream {
        private ByteBuffer byteBuffer;
        private FileChannel fileChannel;
        private RandomAccessFile randomAccess;
        final /* synthetic */ RandomAccessOutputStream this$0;

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void sync() {
        }

        public ChannelRandomAccessOutputStream(RandomAccessOutputStream r2, File r3) {
            this.this$0 = r2;
            RandomAccessFile r4 = new RandomAccessFile(r3, "rw");     // Catch: IOException -> L5
            this.randomAccess = r4;     // Catch: IOException -> L5
            this.fileChannel = r4.getChannel();     // Catch: IOException -> L5
            this.byteBuffer = ByteBuffer.allocateDirect(DownloadConstants.TTNET_DEFAULT_BUFFER_SIZE);     // Catch: IOException -> L5
            return;
        L5:
            e = move-exception;
            throw new BaseException(DownloadErrorCode.ERROR_OUTPUT_STREAM_CREATE_IO, e);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void write(byte[] r2, int r3, int r4) {
            this.byteBuffer.clear();
            this.byteBuffer.put(r2, r3, r4);
            this.byteBuffer.flip();
        L4:
            if (this.byteBuffer.hasRemaining() == false) goto L6;
            this.fileChannel.write(this.byteBuffer);
            goto L4
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void flushAndSync() {
            flush();
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void flush() {
            this.fileChannel.force(true);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void close() {
            DownloadUtils.safeClose(new Closeable[]{this.fileChannel, this.randomAccess});
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void setLength(long r1) {
            this.randomAccess.setLength(r1);
        }

        @Override // com.ss.android.socialbase.downloader.model.RandomAccessOutputStream.RandomOutputStream
        public void seek(long r1) {
            this.fileChannel.position(r1);
        }
    }

    private interface RandomOutputStream {
        void close();

        void flush();

        void flushAndSync();

        void seek(long r1);

        void setLength(long r1);

        void sync();

        void write(byte[] r1, int r2, int r3);
    }

    public RandomAccessOutputStream(File r2, int r3) {
        this(r2, r3, false);
    }

    public RandomAccessOutputStream(File r1, int r2, boolean r3) {
        if (r3 == false) goto L5;
        this.randomAccess = new ChannelRandomAccessOutputStream(this, r1);
        return;
    L5:
        this.randomAccess = new BufferRandomAccessOutputStream(this, r1, r2);
    }

    public void write(byte[] r1, int r2, int r3) {
        this.randomAccess.write(r1, r2, r3);
    }

    public void flushAndSync() {
        this.randomAccess.flushAndSync();
    }

    public void flush() {
        this.randomAccess.flush();
    }

    public void sync() {
        this.randomAccess.sync();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.randomAccess.close();
    }

    public void seek(long r1) {
        this.randomAccess.seek(r1);
    }

    public void setLength(long r1) {
        this.randomAccess.setLength(r1);
    }
}
