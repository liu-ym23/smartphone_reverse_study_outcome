package okio;

import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class Pipe {
    final Buffer buffer;

    @Nullable
    private Sink foldedSink;
    final long maxBufferSize;
    private final Sink sink;
    boolean sinkClosed;
    private final Source source;
    boolean sourceClosed;

    final class PipeSink implements Sink {
        final /* synthetic */ Pipe this$0;
        final PushableTimeout timeout;

        PipeSink(Pipe r1) {
            this.this$0 = r1;
            this.timeout = new PushableTimeout();
        }

        @Override // okio.Sink
        public void write(Buffer r8, long r9) throws IOException {
            Buffer r0 = this.this$0.buffer;
            monitor-enter(r0);
        L31:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.sinkClosed == true) goto L30;
        L7:
            if (r9 <= 0) goto L19;
            if (Pipe.access$000(this.this$0) != null) goto L10;
            if (this.this$0.sourceClosed == true) goto L18;
            long r3 = this.this$0.maxBufferSize - this.this$0.buffer.size();     // Catch: Throwable -> L31
            if (r3 == 0) goto L15;
            long r1 = Math.min(r3, r9);     // Catch: Throwable -> L31
            this.this$0.buffer.write(r8, r1);     // Catch: Throwable -> L31
            r9 = r9 - r1;     // Catch: Throwable -> L31
            this.this$0.buffer.notifyAll();     // Catch: Throwable -> L31
            goto L7
        L15:
            this.timeout.waitUntilNotified(this.this$0.buffer);     // Catch: Throwable -> L31
            goto L7
        L18:
            throw new IOException("source is closed");     // Catch: Throwable -> L31
        L10:
            Sink r2 = Pipe.access$000(this.this$0);     // Catch: Throwable -> L31
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L31
            if (r2 == null) goto L28;
            this.timeout.push(r2.timeout());
            r2.write(r8, r9);     // Catch: Throwable -> L25
            this.timeout.pop();
            return;
        L25:
            th = move-exception;
            this.timeout.pop();
            throw th;
        L28:
            return;
        L19:
            r2 = null;
            goto L20
        L30:
            throw new IllegalStateException("closed");     // Catch: Throwable -> L31
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Buffer r0 = this.this$0.buffer;
            monitor-enter(r0);
        L28:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.sinkClosed == true) goto L27;
            if (Pipe.access$000(this.this$0) == null) goto L10;
            Sink r1 = Pipe.access$000(this.this$0);     // Catch: Throwable -> L28
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L28
            if (r1 == null) goto L25;
            this.timeout.push(r1.timeout());
            r1.flush();     // Catch: Throwable -> L22
            this.timeout.pop();
            return;
        L22:
            th = move-exception;
            this.timeout.pop();
            throw th;
        L25:
            return;
        L10:
            if (this.this$0.sourceClosed == true) goto L12;
        L16:
            r1 = null;
            goto L17
        L12:
            if (this.this$0.buffer.size() <= 0) goto L16;
            throw new IOException("source is closed");     // Catch: Throwable -> L28
        L27:
            throw new IllegalStateException("closed");     // Catch: Throwable -> L28
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Buffer r0 = this.this$0.buffer;
            monitor-enter(r0);
        L28:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.sinkClosed == false) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L28
            return;
        L9:
            if (Pipe.access$000(this.this$0) == null) goto L12;
            Sink r1 = Pipe.access$000(this.this$0);     // Catch: Throwable -> L28
        L19:
            monitor-exit(r0);     // Catch: Throwable -> L28
            if (r1 == null) goto L27;
            this.timeout.push(r1.timeout());
            r1.close();     // Catch: Throwable -> L24
            this.timeout.pop();
            return;
        L24:
            th = move-exception;
            this.timeout.pop();
            throw th;
        L27:
            return;
        L12:
            if (this.this$0.sourceClosed == true) goto L14;
        L18:
            this.this$0.sinkClosed = true;     // Catch: Throwable -> L28
            this.this$0.buffer.notifyAll();     // Catch: Throwable -> L28
            r1 = null;
            goto L19
        L14:
            if (this.this$0.buffer.size() <= 0) goto L18;
            throw new IOException("source is closed");     // Catch: Throwable -> L28
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }
    }

    final class PipeSource implements Source {
        final /* synthetic */ Pipe this$0;
        final Timeout timeout;

        PipeSource(Pipe r1) {
            this.this$0 = r1;
            this.timeout = new Timeout();
        }

        @Override // okio.Source
        public long read(Buffer r6, long r7) throws IOException {
            Buffer r0 = this.this$0.buffer;
            monitor-enter(r0);
        L19:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.sourceClosed == true) goto L18;
        L7:
            if (this.this$0.buffer.size() != 0) goto L14;
            if (this.this$0.sinkClosed == true) goto L10;
            this.timeout.waitUntilNotified(this.this$0.buffer);     // Catch: Throwable -> L19
            goto L7
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L19
            return -1;
        L14:
            long r8 = this.this$0.buffer.read(r6, r7);     // Catch: Throwable -> L19
            this.this$0.buffer.notifyAll();     // Catch: Throwable -> L19
            monitor-exit(r0);     // Catch: Throwable -> L19
            return r8;
        L18:
            throw new IllegalStateException("closed");     // Catch: Throwable -> L19
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Buffer r0 = this.this$0.buffer;
            monitor-enter(r0);
            this.this$0.sourceClosed = true;     // Catch: Throwable -> L7
            this.this$0.buffer.notifyAll();     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    static /* synthetic */ Sink access$000(Pipe r0) {
        return r0.foldedSink;
    }

    public Pipe(long r3) {
        this.buffer = new Buffer();
        this.sink = new PipeSink(this);
        this.source = new PipeSource(this);
        if (r3 < 1) goto L7;
        this.maxBufferSize = r3;
        return;
    L7:
        throw new IllegalArgumentException("maxBufferSize < 1: " + r3);
    }

    public final Source source() {
        return this.source;
    }

    public final Sink sink() {
        return this.sink;
    }

    public void fold(Sink r8) throws IOException {
    L2:
        Buffer r0 = this.buffer;
        monitor-enter(r0);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (this.foldedSink != null) goto L28;
        if (this.buffer.exhausted() == true) goto L8;
        boolean r1 = this.sinkClosed;     // Catch: Throwable -> L29
        Buffer r3 = new Buffer();     // Catch: Throwable -> L29
        Buffer r4 = this.buffer;     // Catch: Throwable -> L29
        r3.write(r4, r4.size);     // Catch: Throwable -> L29
        this.buffer.notifyAll();     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        r8.write(r3, r3.size);     // Catch: Throwable -> L18
        if (r1 == true) goto L15;
        r8.flush();     // Catch: Throwable -> L18
        goto L2
    L15:
        r8.close();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        monitor-enter(this.buffer);
        this.sourceClosed = true;     // Catch: Throwable -> L24
        this.buffer.notifyAll();     // Catch: Throwable -> L24
        throw th;
    L24:
        th = move-exception;
        throw th;
    L8:
        this.sourceClosed = true;     // Catch: Throwable -> L29
        this.foldedSink = r8;     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        return;
    L28:
        throw new IllegalStateException("sink already folded");     // Catch: Throwable -> L29
    }
}
