package X0;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReference<byte[]> f5775a = new AtomicReference<>();

    static final class b {

        /* renamed from: a, reason: collision with root package name */
        final int f5778a;

        /* renamed from: b, reason: collision with root package name */
        final int f5779b;

        /* renamed from: c, reason: collision with root package name */
        final byte[] f5780c;

        b(byte[] bArr, int i5, int i6) {
            this.f5780c = bArr;
            this.f5778a = i5;
            this.f5779b = i6;
        }
    }

    public static ByteBuffer a(File file) throws Throwable {
        Throwable th;
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                    try {
                        channel.close();
                    } catch (IOException unused) {
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return mappedByteBufferLoad;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = channel;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (randomAccessFile == null) {
                        throw th;
                    }
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
        }
    }

    private static b b(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        b bVarB = b(byteBuffer);
        if (bVarB != null && bVarB.f5778a == 0 && bVarB.f5779b == bVarB.f5780c.length) {
            return byteBuffer.array();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.limit()];
        byteBufferAsReadOnlyBuffer.position(0);
        byteBufferAsReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static void d(ByteBuffer byteBuffer, File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        byteBuffer.position(0);
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                channel = randomAccessFile.getChannel();
                channel.write(byteBuffer);
                channel.force(false);
                channel.close();
                randomAccessFile.close();
                try {
                    channel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th) {
                th = th;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static InputStream e(ByteBuffer byteBuffer) {
        return new C0087a(byteBuffer);
    }

    /* renamed from: X0.a$a, reason: collision with other inner class name */
    private static class C0087a extends InputStream {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f5776a;

        /* renamed from: b, reason: collision with root package name */
        private int f5777b = -1;

        C0087a(ByteBuffer byteBuffer) {
            this.f5776a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f5776a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i5) {
            this.f5777b = this.f5776a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f5776a.hasRemaining()) {
                return this.f5776a.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            int i5 = this.f5777b;
            if (i5 == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f5776a.position(i5);
        }

        @Override // java.io.InputStream
        public long skip(long j5) {
            if (!this.f5776a.hasRemaining()) {
                return -1L;
            }
            long jMin = Math.min(j5, available());
            this.f5776a.position((int) (r2.position() + jMin));
            return jMin;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i5, int i6) {
            if (!this.f5776a.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i6, available());
            this.f5776a.get(bArr, i5, iMin);
            return iMin;
        }
    }
}
