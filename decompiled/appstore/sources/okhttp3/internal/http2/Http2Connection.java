package okhttp3.internal.http2;

import androidx.core.internal.view.SupportMenu;
import fg.j;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.channels.Channel;
import okhttp3.Protocol;
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class Http2Connection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ExecutorService listenerExecutor = null;
    private boolean awaitingPong;
    long bytesLeftInWriteWindow;
    final boolean client;
    final Set<Integer> currentPushRequests;
    final String hostname;
    int lastGoodStreamId;
    final Listener listener;
    int nextStreamId;
    Settings okHttpSettings;
    final Settings peerSettings;
    private final ExecutorService pushExecutor;
    final PushObserver pushObserver;
    final ReaderRunnable readerRunnable;
    boolean receivedInitialPeerSettings;
    boolean shutdown;
    final Socket socket;
    final Map<Integer, Http2Stream> streams;
    long unacknowledgedBytesRead;
    final Http2Writer writer;
    private final ScheduledExecutorService writerExecutor;

    public static class Builder {
        boolean client;
        String hostname;
        Listener listener;
        int pingIntervalMillis;
        PushObserver pushObserver;
        BufferedSink sink;
        Socket socket;
        BufferedSource source;

        public Builder(boolean r10) {
            this.listener = Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
            this.client = r10;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }

        public Builder listener(Listener r10) {
            this.listener = r10;
            return this;
        }

        public Builder pingIntervalMillis(int r10) {
            this.pingIntervalMillis = r10;
            return this;
        }

        public Builder pushObserver(PushObserver r10) {
            this.pushObserver = r10;
            return this;
        }

        public Builder socket(Socket r10) throws IOException {
            return socket(r10, ((InetSocketAddress) r10.getRemoteSocketAddress()).getHostName(), j.d(j.m(r10)), j.c(j.i(r10)));
        }

        public Builder socket(Socket r10, String r11, BufferedSource r12, BufferedSink r13) {
            this.socket = r10;
            this.hostname = r11;
            this.source = r12;
            this.sink = r13;
            return this;
        }
    }

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = null;

        static {
            REFUSE_INCOMING_STREAMS = new AnonymousClass1();
        }

        public Listener() {
        }

        public void onSettings(Http2Connection r10) {
        }

        public abstract void onStream(Http2Stream r10) throws IOException;
    }

    public final class PingRunnable extends NamedRunnable {
        final int payload1;
        final int payload2;
        final boolean reply;
        final /* synthetic */ Http2Connection this$0;

        public PingRunnable(Http2Connection r10, boolean r11, int r12, int r13) {
            this.this$0 = r10;
            super("OkHttp %s ping %08x%08x", new Object[]{r10.hostname, Integer.valueOf(r12), Integer.valueOf(r13)});
            this.reply = r11;
            this.payload1 = r12;
            this.payload2 = r13;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            this.this$0.writePing(this.reply, this.payload1, this.payload2);
        }
    }

    public class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        final Http2Reader reader;
        final /* synthetic */ Http2Connection this$0;

        public ReaderRunnable(Http2Connection r10, Http2Reader r11) {
            this.this$0 = r10;
            super("OkHttp %s", new Object[]{r10.hostname});
            this.reader = r11;
        }

        private void applyAndAckSettings(final Settings r10) {
            ScheduledExecutorService r11 = Http2Connection.access$200(this.this$0);     // Catch: RejectedExecutionException -> L4
            final String r12 = "OkHttp %s ACK Settings";
            final Object[] r13 = {this.this$0.hostname};     // Catch: RejectedExecutionException -> L4
            r11.execute(new AnonymousClass3(this, r12, r13, r10));     // Catch: RejectedExecutionException -> L4
            return;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int r10, String r11, ByteString r12, String r13, int r14, long r15) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean r10, int r11, BufferedSource r12, int r13) throws IOException {
            if (this.this$0.pushedStream(r11) == false) goto L6;
            this.this$0.pushDataLater(r11, r12, r13, r10);
            return;
        L6:
            Http2Stream r14 = this.this$0.getStream(r11);
            if (r14 != null) goto L10;
            this.this$0.writeSynResetLater(r11, ErrorCode.PROTOCOL_ERROR);
            r12.skip(r13);
            return;
        L10:
            r14.receiveData(r12, r13);
            if (r10 == false) goto L14;
            r14.receiveFin();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            ErrorCode r10 = ErrorCode.INTERNAL_ERROR;
            this.reader.readConnectionPreface(this);     // Catch: Throwable -> L13 IOException -> L15
        L5:
            if (this.reader.nextFrame(false, this) == true) goto L5;
            ErrorCode r11 = ErrorCode.NO_ERROR;     // Catch: Throwable -> L13 IOException -> L15
            r10 = ErrorCode.CANCEL;     // Catch: Throwable -> L11 IOException -> L25
            this.this$0.close(r11, r10);     // Catch: IOException -> L23
            ErrorCode r12 = r11;
        L26:
            goto L10
        L11:
            th = th;
        L34:
            this.this$0.close(r12, r10);     // Catch: IOException -> L24
        L21:
            Util.closeQuietly(this.reader);
            throw th;
        L13:
            th = th;
            r12 = r10;
        L16:
            r10 = ErrorCode.PROTOCOL_ERROR;     // Catch: Throwable -> L11
            Http2Connection r13 = this.this$0;     // Catch: IOException -> L23
            r13.close(r10, r10);     // Catch: IOException -> L23
            r12 = r13;
        L10:
            Util.closeQuietly(this.reader);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int r10, ErrorCode r11, ByteString r12) {
            r12.size();
            Http2Connection r13 = this.this$0;
            monitor-enter(r13);
            Http2Stream[] r14 = (Http2Stream[]) this.this$0.streams.values().toArray(new Http2Stream[this.this$0.streams.size()]);     // Catch: Throwable -> L15
            this.this$0.shutdown = true;     // Catch: Throwable -> L15
            monitor-exit(r13);     // Catch: Throwable -> L15
            int r15 = r14.length;
            int r16 = 0;
        L7:
            if (r16 >= r15) goto L14;
            Http2Stream r17 = r14[r16];
            if (r17.getId() <= r10) goto L13;
            if (r17.isLocallyInitiated() == false) goto L13;
            r17.receiveRstStream(ErrorCode.REFUSED_STREAM);
            this.this$0.removeStream(r17.getId());
        L13:
            r16 = r16 + 1;
            goto L7
        L14:
            return;
        L15:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean r10, int r11, int r12, List<Header> r13) {
            if (this.this$0.pushedStream(r11) == false) goto L6;
            this.this$0.pushHeadersLater(r11, r13, r10);
            return;
        L6:
            Http2Connection r14 = this.this$0;
            monitor-enter(r14);
            Http2Stream r15 = this.this$0.getStream(r11);     // Catch: Throwable -> L14
            if (r15 != null) goto L27;
            Http2Connection r16 = this.this$0;     // Catch: Throwable -> L14
            if (r16.shutdown == false) goto L17;
            monitor-exit(r14);     // Catch: Throwable -> L14
            return;
        L17:
            if (r11 > r16.lastGoodStreamId) goto L21;
            monitor-exit(r14);     // Catch: Throwable -> L14
            return;
        L21:
            if ((r11 % 2) != (r16.nextStreamId % 2)) goto L24;
            monitor-exit(r14);     // Catch: Throwable -> L14
            return;
        L24:
            final Http2Stream r17 = new Http2Stream(r11, this.this$0, false, r10, r13);     // Catch: Throwable -> L14
            Http2Connection r18 = this.this$0;     // Catch: Throwable -> L14
            r18.lastGoodStreamId = r11;     // Catch: Throwable -> L14
            r18.streams.put(Integer.valueOf(r11), r17);     // Catch: Throwable -> L14
            ExecutorService r19 = Http2Connection.access$100();     // Catch: Throwable -> L14
            final String r20 = "OkHttp %s stream %d";
            final Object[] r21 = {this.this$0.hostname, Integer.valueOf(r11)};     // Catch: Throwable -> L14
            r19.execute(new AnonymousClass1(this, r20, r21, r17));     // Catch: Throwable -> L14
            monitor-exit(r14);     // Catch: Throwable -> L14
            return;
        L27:
            monitor-exit(r14);     // Catch: Throwable -> L14
            r15.receiveHeaders(r13);
            if (r10 == false) goto L35;
            r15.receiveFin();
            return;
        L35:
            return;
        L14:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean r10, int r11, int r12) {
            if (r10 == false) goto L16;
            Http2Connection r13 = this.this$0;
            monitor-enter(r13);
            Http2Connection.access$302(this.this$0, false);     // Catch: Throwable -> L8
            this.this$0.notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r13);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L16:
            Http2Connection.access$200(this.this$0).execute(new PingRunnable(this.this$0, true, r11, r12));     // Catch: RejectedExecutionException -> L13
            return;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int r10, int r11, int r12, boolean r13) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int r10, int r11, List<Header> r12) {
            this.this$0.pushRequestLater(r11, r12);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int r10, ErrorCode r11) {
            if (this.this$0.pushedStream(r10) == false) goto L6;
            this.this$0.pushResetLater(r10, r11);
            return;
        L6:
            Http2Stream r12 = this.this$0.removeStream(r10);
            if (r12 == null) goto L10;
            r12.receiveRstStream(r11);
            return;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void settings(boolean r10, Settings r11) {
            Http2Connection r12 = this.this$0;
            monitor-enter(r12);
            int r13 = this.this$0.peerSettings.getInitialWindowSize();     // Catch: Throwable -> L7
            if (r10 == false) goto L9;
            this.this$0.peerSettings.clear();     // Catch: Throwable -> L7
        L9:
            this.this$0.peerSettings.merge(r11);     // Catch: Throwable -> L7
            applyAndAckSettings(r11);     // Catch: Throwable -> L7
            int r14 = this.this$0.peerSettings.getInitialWindowSize();     // Catch: Throwable -> L7
            Http2Stream[] r15 = null;
            if (r14 == (-1)) goto L18;
            if (r14 == r13) goto L18;
            long r16 = r14 - r13;     // Catch: Throwable -> L7
            Http2Connection r17 = this.this$0;     // Catch: Throwable -> L7
            if (r17.receivedInitialPeerSettings == true) goto L16;
            r17.addBytesToWriteWindow(r16);     // Catch: Throwable -> L7
            this.this$0.receivedInitialPeerSettings = true;     // Catch: Throwable -> L7
        L16:
            if (this.this$0.streams.isEmpty() == true) goto L19;
            r15 = (Http2Stream[]) this.this$0.streams.values().toArray(new Http2Stream[this.this$0.streams.size()]);     // Catch: Throwable -> L7
        L19:
            ExecutorService r18 = Http2Connection.access$100();     // Catch: Throwable -> L7
            final String r19 = "OkHttp %s settings";
            final Object[] r20 = {this.this$0.hostname};     // Catch: Throwable -> L7
            r18.execute(new AnonymousClass2(this, r19, r20));     // Catch: Throwable -> L7
            monitor-exit(r12);     // Catch: Throwable -> L7
            if (r15 != null) goto L23;
            return;
        L23:
            if (r16 == 0) goto L43;
            int r21 = r15.length;
            int r22 = 0;
        L25:
            if (r22 >= r21) goto L44;
            Http2Stream r23 = r15[r22];
            monitor-enter(r23);
            r23.addBytesToWriteWindow(r16);     // Catch: Throwable -> L31
            monitor-exit(r23);     // Catch: Throwable -> L31
            r22 = r22 + 1;     // Catch: Throwable -> L31
        L31:
            th = move-exception;
            throw th;
        L44:
            return;
        L43:
            return;
        L18:
            r16 = 0;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int r10, long r11) {
            if (r10 != 0) goto L11;
            Http2Connection r12 = this.this$0;
            monitor-enter(r12);
            Http2Connection r13 = this.this$0;     // Catch: Throwable -> L8
            r13.bytesLeftInWriteWindow += r11;     // Catch: Throwable -> L8
            r13.notifyAll();     // Catch: Throwable -> L8
            monitor-exit(r12);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L11:
            Http2Stream r14 = this.this$0.getStream(r10);
            if (r14 == null) goto L25;
            monitor-enter(r14);
            r14.addBytesToWriteWindow(r11);     // Catch: Throwable -> L17
            monitor-exit(r14);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }
    }

    static {
        listenerExecutor = new ThreadPoolExecutor(0, Channel.UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));
    }

    public Http2Connection(Builder r24) {
        this.streams = new LinkedHashMap();
        this.unacknowledgedBytesRead = 0;
        this.okHttpSettings = new Settings();
        Settings r10 = new Settings();
        this.peerSettings = r10;
        this.receivedInitialPeerSettings = false;
        this.currentPushRequests = new LinkedHashSet();
        this.pushObserver = r24.pushObserver;
        boolean r11 = r24.client;
        this.client = r11;
        this.listener = r24.listener;
        if (r11 == false) goto L5;
        int r12 = 1;
    L6:
        this.nextStreamId = r12;
        if (r11 == false) goto L10;
        this.nextStreamId = r12 + 2;
    L10:
        if (r11 == false) goto L12;
        this.okHttpSettings.set(7, OKHTTP_CLIENT_WINDOW_SIZE);
    L12:
        String r13 = r24.hostname;
        this.hostname = r13;
        ScheduledThreadPoolExecutor r14 = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", new Object[]{r13}), false));
        this.writerExecutor = r14;
        if (r24.pingIntervalMillis == 0) goto L15;
        PingRunnable r15 = new PingRunnable(this, false, 0, 0);
        int r16 = r24.pingIntervalMillis;
        r14.scheduleAtFixedRate(r15, r16, r16, TimeUnit.MILLISECONDS);
    L15:
        this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", new Object[]{r13}), true));
        r10.set(7, SupportMenu.USER_MASK);
        r10.set(5, 16384);
        this.bytesLeftInWriteWindow = r10.getInitialWindowSize();
        this.socket = r24.socket;
        this.writer = new Http2Writer(r24.sink, r11);
        this.readerRunnable = new ReaderRunnable(this, new Http2Reader(r24.source, r11));
        return;
    L5:
        r12 = 2;
        goto L6
    }

    public static /* synthetic */ void access$000(Http2Connection r10) {
        r10.failConnection();
    }

    public static /* synthetic */ ExecutorService access$100() {
        return listenerExecutor;
    }

    public static /* synthetic */ ScheduledExecutorService access$200(Http2Connection r10) {
        return r10.writerExecutor;
    }

    public static /* synthetic */ boolean access$302(Http2Connection r10, boolean r11) {
        r10.awaitingPong = r11;
        return r11;
    }

    private void failConnection() {
        ErrorCode r10 = ErrorCode.PROTOCOL_ERROR;     // Catch: IOException -> L4
        close(r10, r10);     // Catch: IOException -> L4
        return;
    }

    public void addBytesToWriteWindow(long r10) {
        this.bytesLeftInWriteWindow += r10;
        if (r10 <= 0) goto L6;
        notifyAll();
        return;
    }

    public synchronized void awaitPong() throws IOException, InterruptedException {
        monitor-enter(this);
    L13:
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.awaitingPong == false) goto L9;
        wait();     // Catch: Throwable -> L7
        goto L13
    L9:
        monitor-exit(this);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() throws IOException {
        this.writer.flush();
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public synchronized Http2Stream getStream(int r10) {
        monitor-enter(this);
        Http2Stream r11 = this.streams.get(Integer.valueOf(r10));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isShutdown() {
        monitor-enter(this);
        boolean r10 = this.shutdown;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int maxConcurrentStreams() {
        monitor-enter(this);
        int r10 = this.peerSettings.getMaxConcurrentStreams(Channel.UNLIMITED);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public Http2Stream newStream(List<Header> r10, boolean r11) throws IOException {
        return newStream(0, r10, r11);
    }

    public synchronized int openStreamCount() {
        monitor-enter(this);
        int r10 = this.streams.size();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public void pushDataLater(final int r10, BufferedSource r11, final int r12, final boolean r13) throws IOException {
        final Buffer r14 = new Buffer();
        long r15 = r12;
        r11.require(r15);
        r11.read(r14, r15);
        if (r14.size() != r15) goto L7;
        ExecutorService r16 = this.pushExecutor;
        final Object[] r17 = {this.hostname, Integer.valueOf(r10)};
        final String r18 = "OkHttp %s Push Data[%s]";
        r16.execute(new AnonymousClass5(this, r18, r17, r10, r14, r12, r13));
        return;
    L7:
        throw new IOException(r14.size() + " != " + r12);
    }

    public void pushHeadersLater(final int r10, final List<Header> r11, final boolean r12) {
        ExecutorService r13 = this.pushExecutor;     // Catch: RejectedExecutionException -> L4
        final String r14 = "OkHttp %s Push Headers[%s]";
        final Object[] r15 = {this.hostname, Integer.valueOf(r10)};     // Catch: RejectedExecutionException -> L4
        r13.execute(new AnonymousClass4(this, r14, r15, r10, r11, r12));     // Catch: RejectedExecutionException -> L4
        return;
    }

    public void pushRequestLater(final int r10, final List<Header> r11) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.currentPushRequests.contains(Integer.valueOf(r10)) == false) goto L10;
        writeSynResetLater(r10, ErrorCode.PROTOCOL_ERROR);     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L10:
        this.currentPushRequests.add(Integer.valueOf(r10));     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        ExecutorService r12 = this.pushExecutor;     // Catch: RejectedExecutionException -> L16
        final String r13 = "OkHttp %s Push Request[%s]";
        final Object[] r14 = {this.hostname, Integer.valueOf(r10)};     // Catch: RejectedExecutionException -> L16
        r12.execute(new AnonymousClass3(this, r13, r14, r10, r11));     // Catch: RejectedExecutionException -> L16
        return;
    }

    public void pushResetLater(final int r10, final ErrorCode r11) {
        ExecutorService r12 = this.pushExecutor;
        final Object[] r13 = {this.hostname, Integer.valueOf(r10)};
        final String r14 = "OkHttp %s Push Reset[%s]";
        r12.execute(new AnonymousClass6(this, r14, r13, r10, r11));
    }

    public Http2Stream pushStream(int r10, List<Header> r11, boolean r12) throws IOException {
        if (this.client == true) goto L7;
        return newStream(r10, r11, r12);
    L7:
        throw new IllegalStateException("Client cannot push requests.");
    }

    public boolean pushedStream(int r10) {
        if (r10 != 0) goto L4;
    L6:
        return false;
    L4:
        if ((r10 & 1) != 0) goto L6;
        return true;
    }

    public synchronized Http2Stream removeStream(int r10) {
        monitor-enter(this);
        Http2Stream r11 = this.streams.remove(Integer.valueOf(r10));     // Catch: Throwable -> L6
        notifyAll();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    public void setSettings(Settings r10) throws IOException {
        Http2Writer r11 = this.writer;
        monitor-enter(r11);
        monitor-enter(this);     // Catch: Throwable -> L12
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L6:
        if (this.shutdown == true) goto L17;
        this.okHttpSettings.merge(r10);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        this.writer.settings(r10);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L17:
        throw new ConnectionShutdownException();     // Catch: Throwable -> L14
    L12:
        th = move-exception;
        throw th;
    }

    public void shutdown(ErrorCode r10) throws IOException {
        Http2Writer r11 = this.writer;
        monitor-enter(r11);
        monitor-enter(this);     // Catch: Throwable -> L10
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L6:
        if (this.shutdown == false) goto L15;
        monitor-exit(this);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L15:
        this.shutdown = true;     // Catch: Throwable -> L12
        int r12 = this.lastGoodStreamId;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        this.writer.goAway(r12, r10, Util.EMPTY_BYTE_ARRAY);     // Catch: Throwable -> L10
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void start() throws IOException {
        start(true);
    }

    public void writeData(int r10, boolean r11, Buffer r12, long r13) throws IOException {
        if (r13 != 0) goto L7;
        this.writer.data(r11, r10, r12, 0);
        return;
    L7:
        if (r13 <= 0) goto L31;
        monitor-enter(this);
    L32:
        long r14 = this.bytesLeftInWriteWindow;     // Catch: Throwable -> L14 InterruptedException -> L27
        if (r14 > 0) goto L18;
        if (this.streams.containsKey(Integer.valueOf(r10)) == false) goto L17;
        wait();     // Catch: Throwable -> L14 InterruptedException -> L27
        goto L32
    L17:
        throw new IOException("stream closed");     // Catch: Throwable -> L14 InterruptedException -> L27
        goto L28
    L18:
        int r15 = Math.min((int) Math.min(r13, r14), this.writer.maxDataLength());     // Catch: Throwable -> L14
        long r16 = r15;
        this.bytesLeftInWriteWindow -= r16;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        r13 = r13 - r16;
        Http2Writer r17 = this.writer;
        if (r11 == true) goto L23;
    L25:
        boolean r18 = false;
    L26:
        r17.data(r18, r10, r12, r15);
        goto L7
    L23:
        if (r13 != 0) goto L25;
        r18 = true;
    L14:
        th = move-exception;
        throw th;
    L28:
        throw new InterruptedIOException();     // Catch: Throwable -> L14
    }

    public void writePing(boolean r10, int r11, int r12) {
        if (r10 == true) goto L16;
        monitor-enter(this);
        boolean r13 = this.awaitingPong;     // Catch: Throwable -> L9
        this.awaitingPong = true;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        if (r13 == false) goto L16;
        failConnection();
        return;
    L9:
        th = move-exception;
        throw th;
    L16:
        this.writer.ping(r10, r11, r12);     // Catch: IOException -> L14
        return;
    L14:
        failConnection();
    }

    public void writePingAndAwaitPong() throws IOException, InterruptedException {
        writePing(false, 1330343787, -257978967);
        awaitPong();
    }

    public void writeSynReply(int r10, boolean r11, List<Header> r12) throws IOException {
        this.writer.synReply(r11, r10, r12);
    }

    public void writeSynReset(int r10, ErrorCode r11) throws IOException {
        this.writer.rstStream(r10, r11);
    }

    public void writeSynResetLater(final int r10, final ErrorCode r11) {
        ScheduledExecutorService r12 = this.writerExecutor;     // Catch: RejectedExecutionException -> L4
        final String r13 = "OkHttp %s stream %d";
        final Object[] r14 = {this.hostname, Integer.valueOf(r10)};     // Catch: RejectedExecutionException -> L4
        r12.execute(new AnonymousClass1(this, r13, r14, r10, r11));     // Catch: RejectedExecutionException -> L4
        return;
    }

    public void writeWindowUpdateLater(final int r10, final long r11) {
        ScheduledExecutorService r12 = this.writerExecutor;     // Catch: RejectedExecutionException -> L4
        final String r13 = "OkHttp Window Update %s stream %d";
        final Object[] r14 = {this.hostname, Integer.valueOf(r10)};     // Catch: RejectedExecutionException -> L4
        r12.execute(new AnonymousClass2(this, r13, r14, r10, r11));     // Catch: RejectedExecutionException -> L4
        return;
    }

    private Http2Stream newStream(int r11, List<Header> r12, boolean r13) throws IOException {
        boolean r10 = !r13;
        Http2Writer r14 = this.writer;
        monitor-enter(r14);
        monitor-enter(this);     // Catch: Throwable -> L27
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L6:
        if (this.nextStreamId <= 1073741823) goto L11;
        shutdown(ErrorCode.REFUSED_STREAM);     // Catch: Throwable -> L8
    L11:
        if (this.shutdown == true) goto L39;
        int r15 = this.nextStreamId;     // Catch: Throwable -> L8
        this.nextStreamId = r15 + 2;     // Catch: Throwable -> L8
        Http2Stream r16 = new Http2Stream(r15, this, r10, false, r12);     // Catch: Throwable -> L8
        if (r13 == true) goto L15;
    L20:
        boolean r17 = true;
    L22:
        if (r16.isOpen() == false) goto L24;
        this.streams.put(Integer.valueOf(r15), r16);     // Catch: Throwable -> L8
    L24:
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r11 != 0) goto L30;
        this.writer.synStream(r10, r15, r11, r12);     // Catch: Throwable -> L27
    L32:
        monitor-exit(r14);     // Catch: Throwable -> L27
        if (r17 == false) goto L35;
        this.writer.flush();
    L35:
        return r16;
    L30:
        if (this.client == true) goto L37;
        this.writer.pushPromise(r11, r15, r12);     // Catch: Throwable -> L27
        goto L32
    L37:
        throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");     // Catch: Throwable -> L27
    L15:
        if (this.bytesLeftInWriteWindow == 0) goto L20;
        if (r16.bytesLeftInWriteWindow == 0) goto L20;
        r17 = false;
        goto L22
    L39:
        throw new ConnectionShutdownException();     // Catch: Throwable -> L8
    L27:
        th = move-exception;
        throw th;
    }

    public void close(ErrorCode r10, ErrorCode r11) throws IOException {
        Http2Stream[] r12 = null;
        shutdown(r10);     // Catch: IOException -> L5
        e = null;
    L6:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L8:
        if (this.streams.isEmpty() == true) goto L12;
        r12 = (Http2Stream[]) this.streams.values().toArray(new Http2Stream[this.streams.size()]);     // Catch: Throwable -> L10
        this.streams.clear();     // Catch: Throwable -> L10
    L12:
        monitor-exit(this);     // Catch: Throwable -> L10
        if (r12 == null) goto L39;
        int r13 = r12.length;
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L39;
        r12[r14].close(r11);     // Catch: IOException -> L19
    L22:
        r14 = r14 + 1;
    L19:
        e = move-exception;
        if (e == null) goto L22;
        e = e;
    L39:
        this.writer.close();     // Catch: IOException -> L25
    L45:
        this.socket.close();     // Catch: IOException -> L30
    L31:
        this.writerExecutor.shutdown();
        this.pushExecutor.shutdown();
        if (e != null) goto L34;
        return;
    L34:
        throw e;
    L30:
        e = e;
    L25:
        e = move-exception;
        if (e != null) goto L45;
        e = e;
    L5:
        e = e;
        goto L6
    }

    public void start(boolean r10) throws IOException {
        if (r10 == false) goto L6;
        this.writer.connectionPreface();
        this.writer.settings(this.okHttpSettings);
        int r11 = this.okHttpSettings.getInitialWindowSize();
        if (r11 == 65535) goto L6;
        this.writer.windowUpdate(0, r11 - SupportMenu.USER_MASK);
    L6:
        new Thread(this.readerRunnable).start();
    }
}
