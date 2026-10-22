package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes5.dex */
final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final ByteString PREFIX_CLEAN = null;
    static final ByteString PREFIX_DIRTY = null;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final Buffer buffer;
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final ByteString metadata;
    int sourceCount;
    Source upstream;
    final Buffer upstreamBuffer;
    long upstreamPos;
    Thread upstreamReader;

    class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        final /* synthetic */ Relay this$0;
        private final Timeout timeout;

        RelaySource(Relay r2) {
            this.this$0 = r2;
            this.timeout = new Timeout();
            this.fileOperator = new FileOperator(r2.file.getChannel());
        }

        @Override // okio.Source
        public long read(Buffer r22, long r23) throws IOException {
            if (this.fileOperator == null) goto L73;
            Relay r4 = this.this$0;
            monitor-enter(r4);
        L80:
            long r5 = this.sourcePos;     // Catch: Throwable -> L69
            long r7 = this.this$0.upstreamPos;     // Catch: Throwable -> L69
            if (r5 != r7) goto L18;
            if (this.this$0.complete == true) goto L10;
            if (this.this$0.upstreamReader == null) goto L15;
            this.timeout.waitUntilNotified(this.this$0);     // Catch: Throwable -> L69
            goto L80
        L15:
            this.this$0.upstreamReader = Thread.currentThread();     // Catch: Throwable -> L69
            monitor-exit(r4);     // Catch: Throwable -> L69
            char r0 = 1;
        L23:
            if (r0 != 2) goto L83;
            long r2 = Math.min(r23, r7 - this.sourcePos);
            this.fileOperator.read(this.sourcePos + 32, r22, r2);
            this.sourcePos += r2;
            return r2;
        L83:
            long r6 = this.this$0.upstream.read(this.this$0.upstreamBuffer, this.this$0.bufferMaxSize);     // Catch: Throwable -> L56
            if (r6 != (-1)) goto L38;
            this.this$0.commit(r7);     // Catch: Throwable -> L56
            Relay r3 = this.this$0;
            monitor-enter(r3);
            this.this$0.upstreamReader = null;     // Catch: Throwable -> L35
            this.this$0.notifyAll();     // Catch: Throwable -> L35
            monitor-exit(r3);     // Catch: Throwable -> L35
            return -1;
        L35:
            th = move-exception;
            throw th;
        L38:
            long r8 = Math.min(r6, r23);     // Catch: Throwable -> L56
            this.this$0.upstreamBuffer.copyTo(r22, 0, r8);     // Catch: Throwable -> L56
            this.sourcePos += r8;     // Catch: Throwable -> L56
            this.fileOperator.write(r7 + 32, this.this$0.upstreamBuffer.m2398clone(), r6);     // Catch: Throwable -> L56
            Relay r9 = this.this$0;     // Catch: Throwable -> L56
            monitor-enter(r9);     // Catch: Throwable -> L56
            this.this$0.buffer.write(this.this$0.upstreamBuffer, r6);     // Catch: Throwable -> L53
            if (this.this$0.buffer.size() <= this.this$0.bufferMaxSize) goto L43;
            this.this$0.buffer.skip(this.this$0.buffer.size() - this.this$0.bufferMaxSize);     // Catch: Throwable -> L53
        L43:
            this.this$0.upstreamPos += r6;     // Catch: Throwable -> L53
            monitor-exit(r9);     // Catch: Throwable -> L53
            Relay r10 = this.this$0;
            monitor-enter(r10);
            this.this$0.upstreamReader = null;     // Catch: Throwable -> L50
            this.this$0.notifyAll();     // Catch: Throwable -> L50
            monitor-exit(r10);     // Catch: Throwable -> L50
            return r8;
        L50:
            th = move-exception;
            throw th;
        L53:
            th = move-exception;
            throw th;     // Catch: Throwable -> L56
        L56:
            th = move-exception;
            monitor-enter(this.this$0);
            this.this$0.upstreamReader = null;     // Catch: Throwable -> L62
            this.this$0.notifyAll();     // Catch: Throwable -> L62
            throw th;
        L62:
            th = move-exception;
            throw th;
        L10:
            monitor-exit(r4);     // Catch: Throwable -> L69
            return -1;
        L18:
            long r11 = r7 - this.this$0.buffer.size();     // Catch: Throwable -> L69
            long r13 = this.sourcePos;     // Catch: Throwable -> L69
            if (r13 >= r11) goto L66;
            monitor-exit(r4);     // Catch: Throwable -> L69
            r0 = 2;
            goto L23
        L66:
            long r12 = Math.min(r23, r7 - r13);     // Catch: Throwable -> L69
            this.this$0.buffer.copyTo(r22, this.sourcePos - r11, r12);     // Catch: Throwable -> L69
            this.sourcePos += r12;     // Catch: Throwable -> L69
            monitor-exit(r4);     // Catch: Throwable -> L69
            return r12;
        L69:
            th = move-exception;
            throw th;
        L73:
            throw new IllegalStateException("closed");
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator != null) goto L5;
            return;
        L5:
            RandomAccessFile r0 = null;
            this.fileOperator = null;
            Relay r1 = this.this$0;
            monitor-enter(r1);
            this.this$0.sourceCount--;     // Catch: Throwable -> L14
            if (this.this$0.sourceCount != 0) goto L10;
            RandomAccessFile r2 = this.this$0.file;     // Catch: Throwable -> L14
            this.this$0.file = null;     // Catch: Throwable -> L14
            r0 = r2;
        L10:
            monitor-exit(r1);     // Catch: Throwable -> L14
            if (r0 == null) goto L19;
            Util.closeQuietly(r0);
            return;
        L19:
            return;
        L14:
            th = move-exception;
            throw th;
        }
    }

    static {
        PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
        PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile r2, Source r3, long r4, ByteString r6, long r7) {
        this.upstreamBuffer = new Buffer();
        this.buffer = new Buffer();
        this.file = r2;
        this.upstream = r3;
        if (r3 != null) goto L5;
        boolean r5 = true;
    L6:
        this.complete = r5;
        this.upstreamPos = r4;
        this.metadata = r6;
        this.bufferMaxSize = r7;
        return;
    L5:
        r5 = false;
        goto L6
    }

    public static Relay edit(File r9, Source r10, ByteString r11, long r12) throws IOException {
        RandomAccessFile r8 = new RandomAccessFile(r9, "rw");
        Relay r13 = new Relay(r8, r10, 0, r11, r12);
        r8.setLength(0);
        r13.writeHeader(PREFIX_DIRTY, -1, -1);
        return r13;
    }

    public static Relay read(File r10) throws IOException {
        RandomAccessFile r1 = new RandomAccessFile(r10, "rw");
        FileOperator r11 = new FileOperator(r1.getChannel());
        Buffer r0 = new Buffer();
        r11.read(0, r0, 32);
        ByteString r2 = PREFIX_CLEAN;
        if (r0.readByteString(r2.size()).equals(r2) == false) goto L7;
        long r8 = r0.readLong();
        long r6 = r0.readLong();
        Buffer r3 = new Buffer();
        r11.read(r8 + 32, r3, r6);
        return new Relay(r1, null, r8, r3.readByteString(), 0);
    L7:
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(ByteString r2, long r3, long r5) throws IOException {
        Buffer r0 = new Buffer();
        r0.write(r2);
        r0.writeLong(r3);
        r0.writeLong(r5);
        if (r0.size() != 32) goto L7;
        new FileOperator(this.file.getChannel()).write(0, r0, 32);
        return;
    L7:
        throw new IllegalArgumentException();
    }

    private void writeMetadata(long r7) throws IOException {
        Buffer r3 = new Buffer();
        r3.write(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + r7, r3, this.metadata.size());
    }

    void commit(long r9) throws IOException {
        writeMetadata(r9);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, r9, this.metadata.size());
        this.file.getChannel().force(false);
        monitor-enter(this);
        this.complete = true;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        Util.closeQuietly(this.upstream);
        this.upstream = null;
        return;
    L9:
        th = move-exception;
        throw th;
    }

    boolean isClosed() {
        if (this.file != null) goto L5;
        return true;
    L5:
        return false;
    }

    public ByteString metadata() {
        return this.metadata;
    }

    public Source newSource() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.file != null) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L12
        return null;
    L8:
        this.sourceCount++;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return new RelaySource(this);
    }
}
