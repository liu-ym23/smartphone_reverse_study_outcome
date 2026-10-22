package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes4.dex */
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

    public class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        final /* synthetic */ Relay this$0;
        private final Timeout timeout;

        public RelaySource(Relay r10) {
            this.this$0 = r10;
            this.timeout = new Timeout();
            this.fileOperator = new FileOperator(r10.file.getChannel());
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator != null) goto L5;
            return;
        L5:
            RandomAccessFile r10 = null;
            this.fileOperator = null;
            Relay r11 = this.this$0;
            monitor-enter(r11);
            Relay r12 = this.this$0;     // Catch: Throwable -> L10
            int r13 = r12.sourceCount - 1;     // Catch: Throwable -> L10
            r12.sourceCount = r13;     // Catch: Throwable -> L10
            if (r13 != 0) goto L12;
            RandomAccessFile r14 = r12.file;     // Catch: Throwable -> L10
            r12.file = null;     // Catch: Throwable -> L10
            r10 = r14;
        L12:
            monitor-exit(r11);     // Catch: Throwable -> L10
            if (r10 == null) goto L20;
            Util.closeQuietly(r10);
            return;
        L20:
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // okio.Source
        public long read(Buffer r22, long r23) throws IOException {
            if (this.fileOperator == null) goto L71;
            Relay r10 = this.this$0;
            monitor-enter(r10);
        L81:
            long r11 = this.sourcePos;     // Catch: Throwable -> L12
            Relay r12 = this.this$0;     // Catch: Throwable -> L12
            long r13 = r12.upstreamPos;     // Catch: Throwable -> L12
            if (r11 != r13) goto L59;
            if (r12.complete == true) goto L10;
            if (r12.upstreamReader == null) goto L17;
            this.timeout.waitUntilNotified(r12);     // Catch: Throwable -> L12
            goto L81
        L17:
            r12.upstreamReader = Thread.currentThread();     // Catch: Throwable -> L12
            monitor-exit(r10);     // Catch: Throwable -> L12
            Relay r14 = this.this$0;     // Catch: Throwable -> L31
            long r15 = r14.upstream.read(r14.upstreamBuffer, r14.bufferMaxSize);     // Catch: Throwable -> L31
            if (r15 != (-1)) goto L33;
            this.this$0.commit(r13);     // Catch: Throwable -> L31
            Relay r16 = this.this$0;
            monitor-enter(r16);
            Relay r17 = this.this$0;     // Catch: Throwable -> L28
            r17.upstreamReader = null;     // Catch: Throwable -> L28
            r17.notifyAll();     // Catch: Throwable -> L28
            monitor-exit(r16);     // Catch: Throwable -> L28
            return -1;
        L28:
            th = move-exception;
            throw th;
        L33:
            long r18 = Math.min(r15, r23);     // Catch: Throwable -> L31
            this.this$0.upstreamBuffer.d(r22, 0, r18);     // Catch: Throwable -> L31
            this.sourcePos += r18;     // Catch: Throwable -> L31
            this.fileOperator.write(r13 + 32, this.this$0.upstreamBuffer.b(), r15);     // Catch: Throwable -> L31
            Relay r19 = this.this$0;     // Catch: Throwable -> L31
            monitor-enter(r19);     // Catch: Throwable -> L31
            Relay r20 = this.this$0;     // Catch: Throwable -> L38
            r20.buffer.write(r20.upstreamBuffer, r15);     // Catch: Throwable -> L38
            long r21 = this.this$0.buffer.size();     // Catch: Throwable -> L38
            Relay r24 = this.this$0;     // Catch: Throwable -> L38
            if (r21 <= r24.bufferMaxSize) goto L40;
            Buffer r25 = r24.buffer;     // Catch: Throwable -> L38
            r25.skip(r25.size() - this.this$0.bufferMaxSize);     // Catch: Throwable -> L38
        L40:
            Relay r26 = this.this$0;     // Catch: Throwable -> L38
            r26.upstreamPos += r15;     // Catch: Throwable -> L38
            monitor-exit(r19);     // Catch: Throwable -> L38
            monitor-enter(r26);
            Relay r27 = this.this$0;     // Catch: Throwable -> L46
            r27.upstreamReader = null;     // Catch: Throwable -> L46
            r27.notifyAll();     // Catch: Throwable -> L46
            monitor-exit(r26);     // Catch: Throwable -> L46
            return r18;
        L46:
            th = move-exception;
            throw th;
        L38:
            th = move-exception;
            throw th;     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            monitor-enter(this.this$0);
            Relay r28 = this.this$0;     // Catch: Throwable -> L56
            r28.upstreamReader = null;     // Catch: Throwable -> L56
            r28.notifyAll();     // Catch: Throwable -> L56
            throw th;
        L56:
            th = move-exception;
            throw th;
        L10:
            monitor-exit(r10);     // Catch: Throwable -> L12
            return -1;
        L59:
            long r29 = r13 - r12.buffer.size();     // Catch: Throwable -> L12
            long r110 = this.sourcePos;     // Catch: Throwable -> L12
            if (r110 >= r29) goto L65;
            monitor-exit(r10);     // Catch: Throwable -> L12
            long r30 = Math.min(r23, r13 - r110);
            this.fileOperator.read(this.sourcePos + 32, r22, r30);
            this.sourcePos += r30;
            return r30;
        L65:
            long r31 = Math.min(r23, r13 - r110);     // Catch: Throwable -> L12
            this.this$0.buffer.d(r22, this.sourcePos - r29, r31);     // Catch: Throwable -> L12
            this.sourcePos += r31;     // Catch: Throwable -> L12
            monitor-exit(r10);     // Catch: Throwable -> L12
            return r31;
        L12:
            th = move-exception;
            throw th;
        L71:
            throw new IllegalStateException("closed");
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    static {
        PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
        PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    }

    private Relay(RandomAccessFile r10, Source r11, long r12, ByteString r13, long r14) {
        this.upstreamBuffer = new Buffer();
        this.buffer = new Buffer();
        this.file = r10;
        this.upstream = r11;
        if (r11 != null) goto L5;
        boolean r15 = true;
    L6:
        this.complete = r15;
        this.upstreamPos = r12;
        this.metadata = r13;
        this.bufferMaxSize = r14;
        return;
    L5:
        r15 = false;
        goto L6
    }

    public static Relay edit(File r10, Source r11, ByteString r12, long r13) throws IOException {
        RandomAccessFile r14 = new RandomAccessFile(r10, "rw");
        Relay r15 = new Relay(r14, r11, 0, r12, r13);
        r14.setLength(0);
        r15.writeHeader(PREFIX_DIRTY, -1, -1);
        return r15;
    }

    public static Relay read(File r10) throws IOException {
        RandomAccessFile r11 = new RandomAccessFile(r10, "rw");
        FileOperator r12 = new FileOperator(r11.getChannel());
        Buffer r13 = new Buffer();
        r12.read(0, r13, 32);
        ByteString r14 = PREFIX_CLEAN;
        if (r13.readByteString(r14.size()).equals(r14) == false) goto L7;
        long r15 = r13.readLong();
        long r16 = r13.readLong();
        Buffer r17 = new Buffer();
        r12.read(r15 + 32, r17, r16);
        return new Relay(r11, null, r15, r17.readByteString(), 0);
    L7:
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(ByteString r10, long r11, long r12) throws IOException {
        Buffer r13 = new Buffer();
        r13.q(r10);
        r13.y(r11);
        r13.y(r12);
        if (r13.size() != 32) goto L7;
        new FileOperator(this.file.getChannel()).write(0, r13, 32);
        return;
    L7:
        throw new IllegalArgumentException();
    }

    private void writeMetadata(long r10) throws IOException {
        Buffer r11 = new Buffer();
        r11.q(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + r10, r11, this.metadata.size());
    }

    public void commit(long r10) throws IOException {
        writeMetadata(r10);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, r10, this.metadata.size());
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

    public boolean isClosed() {
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
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.file != null) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L8
        return null;
    L10:
        this.sourceCount++;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return new RelaySource(this);
    }
}
