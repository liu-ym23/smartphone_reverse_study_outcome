package okhttp3.internal.ws;

import B0.g;
import ch.qos.logback.core.joran.action.Action;
import h3.B;
import h3.C0611u;
import h3.C0616z;
import h3.InterfaceC0591A;
import h3.InterfaceC0602k;
import h3.InterfaceC0603l;
import h3.Q;
import h3.S;
import h3.T;
import h3.U;
import h3.V;
import h3.b0;
import h3.i0;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import k3.InterfaceC0695j;
import k3.InterfaceC0696k;
import k3.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt__StringsJVMKt;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.WebSocketReader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s.AbstractC0831a;

@Metadata(d1 = {"\u0000Ä\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0081\u00012\u00020\u00012\u00020\u0002:\n\u0082\u0001\u0081\u0001\u0083\u0001\u0084\u0001\u0085\u0001BB\u0012\u0006\u0010~\u001a\u00020}\u0012\u0006\u0010Q\u001a\u00020\u0003\u0012\u0006\u0010T\u001a\u00020S\u0012\u0006\u0010Y\u001a\u00020X\u0012\u0006\u0010[\u001a\u00020\u0006\u0012\b\u0010]\u001a\u0004\u0018\u00010J\u0012\u0006\u0010_\u001a\u00020\u0006¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001d\u0010\u000bJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010$\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\t¢\u0006\u0004\b&\u0010\u000bJ\r\u0010(\u001a\u00020'¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020'¢\u0006\u0004\b*\u0010)J\r\u0010+\u001a\u00020'¢\u0006\u0004\b+\u0010)J\u0017\u0010-\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0017H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u0010-\u001a\u00020\t2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b-\u00101J\u0017\u00103\u001a\u00020\t2\u0006\u00102\u001a\u00020/H\u0016¢\u0006\u0004\b3\u00101J\u0017\u00104\u001a\u00020\t2\u0006\u00102\u001a\u00020/H\u0016¢\u0006\u0004\b4\u00101J\u001f\u00107\u001a\u00020\t2\u0006\u00105\u001a\u00020'2\u0006\u00106\u001a\u00020\u0017H\u0016¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u0017H\u0016¢\u0006\u0004\b9\u0010:J\u0017\u00109\u001a\u00020\u001e2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b9\u0010;J\u0015\u0010<\u001a\u00020\u001e2\u0006\u00102\u001a\u00020/¢\u0006\u0004\b<\u0010;J!\u0010=\u001a\u00020\u001e2\u0006\u00105\u001a\u00020'2\b\u00106\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b=\u0010>J'\u0010=\u001a\u00020\u001e2\u0006\u00105\u001a\u00020'2\b\u00106\u001a\u0004\u0018\u00010\u00172\u0006\u0010?\u001a\u00020\u0006¢\u0006\u0004\b=\u0010@J\u000f\u0010B\u001a\u00020\u001eH\u0000¢\u0006\u0004\bA\u0010 J\u000f\u0010D\u001a\u00020\tH\u0000¢\u0006\u0004\bC\u0010\u000bJ#\u0010H\u001a\u00020\t2\n\u0010G\u001a\u00060Ej\u0002`F2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\bH\u0010IJ\u0013\u0010K\u001a\u00020\u001e*\u00020JH\u0002¢\u0006\u0004\bK\u0010LJ\u001f\u00109\u001a\u00020\u001e2\u0006\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u00020'H\u0002¢\u0006\u0004\b9\u0010OJ\u000f\u0010P\u001a\u00020\tH\u0002¢\u0006\u0004\bP\u0010\u000bR\u0014\u0010Q\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u001a\u0010T\u001a\u00020S8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u0014\u0010Y\u001a\u00020X8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010[\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010]\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010_\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010\\R\u0014\u0010`\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b`\u0010aR\u0018\u0010c\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010i\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010l\u001a\u0004\u0018\u00010k8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0016\u0010o\u001a\u00020n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010aR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010qR\u001a\u0010s\u001a\b\u0012\u0004\u0012\u00020/0r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00010r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010tR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\\R\u0016\u0010v\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0016\u0010x\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0018\u0010z\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010aR\u0016\u0010{\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010wR\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010yR\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010yR\u0016\u0010+\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010yR\u0016\u0010|\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010w¨\u0006\u0086\u0001"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket;", "", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "Lh3/V;", "request", "()Lh3/V;", "", "queueSize", "()J", "", "cancel", "()V", "Lh3/S;", "client", "connect", "(Lh3/S;)V", "Lh3/b0;", "response", "Lokhttp3/internal/connection/Exchange;", "exchange", "checkUpgradeSuccess$okhttp", "(Lh3/b0;Lokhttp3/internal/connection/Exchange;)V", "checkUpgradeSuccess", "", "name", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "streams", "initReaderAndWriter", "(Ljava/lang/String;Lokhttp3/internal/ws/RealWebSocket$Streams;)V", "loopReader", "", "processNextFrame", "()Z", "timeout", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "awaitTermination", "(JLjava/util/concurrent/TimeUnit;)V", "tearDown", "", "sentPingCount", "()I", "receivedPingCount", "receivedPongCount", "text", "onReadMessage", "(Ljava/lang/String;)V", "Lk3/l;", "bytes", "(Lk3/l;)V", "payload", "onReadPing", "onReadPong", "code", "reason", "onReadClose", "(ILjava/lang/String;)V", "send", "(Ljava/lang/String;)Z", "(Lk3/l;)Z", "pong", "close", "(ILjava/lang/String;)Z", "cancelAfterCloseMillis", "(ILjava/lang/String;J)Z", "writeOneFrame$okhttp", "writeOneFrame", "writePingFrame$okhttp", "writePingFrame", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "failWebSocket", "(Ljava/lang/Exception;Lh3/b0;)V", "Lokhttp3/internal/ws/WebSocketExtensions;", "isValid", "(Lokhttp3/internal/ws/WebSocketExtensions;)Z", "data", "formatOpcode", "(Lk3/l;I)Z", "runWriter", "originalRequest", "Lh3/V;", "Lh3/i0;", "listener", "Lh3/i0;", "getListener$okhttp", "()Lh3/i0;", "Ljava/util/Random;", "random", "Ljava/util/Random;", "pingIntervalMillis", "J", "extensions", "Lokhttp3/internal/ws/WebSocketExtensions;", "minimumDeflateSize", Action.KEY_ATTRIBUTE, "Ljava/lang/String;", "Lh3/k;", "call", "Lh3/k;", "Lokhttp3/internal/concurrent/Task;", "writerTask", "Lokhttp3/internal/concurrent/Task;", "Lokhttp3/internal/ws/WebSocketReader;", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "Lokhttp3/internal/ws/WebSocketWriter;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "Lokhttp3/internal/concurrent/TaskQueue;", "taskQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/util/ArrayDeque;", "pongQueue", "Ljava/util/ArrayDeque;", "messageAndCloseQueue", "enqueuedClose", "Z", "receivedCloseCode", "I", "receivedCloseReason", "failed", "awaitingPong", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Lh3/V;Lh3/i0;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;J)V", "Companion", "Close", "Message", "Streams", "WriterTask", "okhttp"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class RealWebSocket implements WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private boolean awaitingPong;

    @Nullable
    private InterfaceC0602k call;
    private boolean enqueuedClose;

    @Nullable
    private WebSocketExtensions extensions;
    private boolean failed;

    @NotNull
    private final String key;

    @NotNull
    private final i0 listener;

    @NotNull
    private final ArrayDeque<Object> messageAndCloseQueue;
    private long minimumDeflateSize;

    @Nullable
    private String name;

    @NotNull
    private final V originalRequest;
    private final long pingIntervalMillis;

    @NotNull
    private final ArrayDeque<l> pongQueue;
    private long queueSize;

    @NotNull
    private final Random random;

    @Nullable
    private WebSocketReader reader;
    private int receivedCloseCode;

    @Nullable
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;

    @Nullable
    private Streams streams;

    @NotNull
    private TaskQueue taskQueue;

    @Nullable
    private WebSocketWriter writer;

    @Nullable
    private Task writerTask;

    @NotNull
    private static final List<T> ONLY_HTTP1 = CollectionsKt.listOf(T.HTTP_1_1);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Close;", "", "", "code", "I", "getCode", "()I", "Lk3/l;", "reason", "Lk3/l;", "getReason", "()Lk3/l;", "", "cancelAfterCloseMillis", "J", "getCancelAfterCloseMillis", "()J", "<init>", "(ILk3/l;J)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;

        @Nullable
        private final l reason;

        public Close(int i4, @Nullable l lVar, long j4) {
            this.code = i4;
            this.reason = lVar;
            this.cancelAfterCloseMillis = j4;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        @Nullable
        public final l getReason() {
            return this.reason;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "", "formatOpcode", "I", "getFormatOpcode", "()I", "Lk3/l;", "data", "Lk3/l;", "getData", "()Lk3/l;", "<init>", "(ILk3/l;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class Message {

        @NotNull
        private final l data;
        private final int formatOpcode;

        public Message(int i4, @NotNull l data) {
            Intrinsics.checkNotNullParameter(data, "data");
            this.formatOpcode = i4;
            this.data = data;
        }

        @NotNull
        public final l getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "", "client", "Z", "getClient", "()Z", "Lk3/k;", "source", "Lk3/k;", "getSource", "()Lk3/k;", "Lk3/j;", "sink", "Lk3/j;", "getSink", "()Lk3/j;", "<init>", "(ZLk3/k;Lk3/j;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static abstract class Streams implements Closeable {
        private final boolean client;

        @NotNull
        private final InterfaceC0695j sink;

        @NotNull
        private final InterfaceC0696k source;

        public Streams(boolean z4, @NotNull InterfaceC0696k source, @NotNull InterfaceC0695j sink) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(sink, "sink");
            this.client = z4;
            this.source = source;
            this.sink = sink;
        }

        public final boolean getClient() {
            return this.client;
        }

        @NotNull
        public final InterfaceC0695j getSink() {
            return this.sink;
        }

        @NotNull
        public final InterfaceC0696k getSource() {
            return this.source;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/ws/RealWebSocket$WriterTask;", "Lokhttp3/internal/concurrent/Task;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "runOnce", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class WriterTask extends Task {
        final /* synthetic */ RealWebSocket this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WriterTask(RealWebSocket this$0) {
            super(Intrinsics.stringPlus(this$0.name, " writer"), false, 2, null);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() throws IOException {
            try {
                return this.this$0.writeOneFrame$okhttp() ? 0L : -1L;
            } catch (IOException e4) {
                this.this$0.failWebSocket(e4, null);
                return -1L;
            }
        }
    }

    public RealWebSocket(@NotNull TaskRunner taskRunner, @NotNull V originalRequest, @NotNull i0 listener, @NotNull Random random, long j4, @Nullable WebSocketExtensions webSocketExtensions, long j5) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(originalRequest, "originalRequest");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter(random, "random");
        this.originalRequest = originalRequest;
        this.random = random;
        this.pingIntervalMillis = j4;
        this.extensions = webSocketExtensions;
        this.minimumDeflateSize = j5;
        this.taskQueue = taskRunner.newQueue();
        this.pongQueue = new ArrayDeque<>();
        this.messageAndCloseQueue = new ArrayDeque<>();
        this.receivedCloseCode = -1;
        if (!Intrinsics.areEqual("GET", originalRequest.f12827b)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Request must be GET: ", originalRequest.f12827b).toString());
        }
        l lVar = l.f13358d;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        Unit unit = Unit.INSTANCE;
        this.key = C0611u.s(bArr).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (!webSocketExtensions.unknownValues && webSocketExtensions.clientMaxWindowBits == null) {
            return webSocketExtensions.serverMaxWindowBits == null || new IntRange(8, 15).contains(webSocketExtensions.serverMaxWindowBits.intValue());
        }
        return false;
    }

    private final void runWriter() {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0L, 2, null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + this);
    }

    public final void awaitTermination(long timeout, @NotNull TimeUnit timeUnit) throws InterruptedException {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.taskQueue.idleLatch().await(timeout, timeUnit);
    }

    public void cancel() {
        InterfaceC0602k interfaceC0602k = this.call;
        Intrinsics.checkNotNull(interfaceC0602k);
        interfaceC0602k.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(@NotNull b0 response, @Nullable Exchange exchange) throws IOException {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.f12867d != 101) {
            StringBuilder sb = new StringBuilder("Expected HTTP 101 response but was '");
            sb.append(response.f12867d);
            sb.append(' ');
            throw new ProtocolException(g.q(sb, response.f12866c, '\''));
        }
        String strB = b0.b(response, "Connection");
        if (!StringsKt__StringsJVMKt.equals("Upgrade", strB, true)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + ((Object) strB) + '\'');
        }
        String strB2 = b0.b(response, "Upgrade");
        if (!StringsKt__StringsJVMKt.equals("websocket", strB2, true)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + ((Object) strB2) + '\'');
        }
        String strB3 = b0.b(response, "Sec-WebSocket-Accept");
        l lVar = l.f13358d;
        String strA = C0611u.k(Intrinsics.stringPlus(this.key, WebSocketProtocol.ACCEPT_MAGIC)).b("SHA-1").a();
        if (Intrinsics.areEqual(strA, strB3)) {
            if (exchange == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strA + "' but was '" + ((Object) strB3) + '\'');
    }

    public boolean close(int code, @Nullable String reason) {
        return close(code, reason, 60000L);
    }

    public final void connect(@NotNull S client) throws IOException {
        Intrinsics.checkNotNullParameter(client, "client");
        if (this.originalRequest.b("Sec-WebSocket-Extensions") != null) {
            failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), null);
            return;
        }
        client.getClass();
        Intrinsics.checkNotNullParameter(client, "okHttpClient");
        Q q4 = new Q();
        q4.f12755a = client.f12787a;
        q4.f12756b = client.f12788b;
        CollectionsKt__MutableCollectionsKt.addAll(q4.f12757c, client.f12789c);
        CollectionsKt__MutableCollectionsKt.addAll(q4.f12758d, client.f12790d);
        q4.f12759e = client.f12791e;
        q4.f12760f = client.f12792f;
        q4.f12761g = client.f12793g;
        q4.f12762h = client.f12794h;
        q4.f12763i = client.f12795i;
        q4.f12764j = client.f12796j;
        q4.f12765k = client.f12797k;
        q4.f12766l = client.f12798l;
        q4.f12767m = client.f12799m;
        q4.f12768n = client.f12800n;
        q4.f12769o = client.f12801o;
        q4.f12770p = client.f12802p;
        q4.f12771q = client.f12803q;
        q4.f12772r = client.f12804r;
        q4.f12773s = client.f12805s;
        q4.f12774t = client.f12806t;
        q4.f12775u = client.f12807u;
        q4.f12776v = client.f12808v;
        q4.f12777w = client.f12809w;
        q4.f12778x = client.f12810x;
        q4.f12779y = client.f12811y;
        q4.f12780z = client.f12812z;
        q4.f12751A = client.f12783A;
        q4.f12752B = client.f12784B;
        q4.f12753C = client.f12785C;
        q4.f12754D = client.f12786D;
        C0616z eventListener = B.f12700a;
        Intrinsics.checkNotNullParameter(eventListener, "eventListener");
        InterfaceC0591A interfaceC0591AAsFactory = Util.asFactory(eventListener);
        Intrinsics.checkNotNullParameter(interfaceC0591AAsFactory, "<set-?>");
        q4.f12759e = interfaceC0591AAsFactory;
        List<T> protocols = ONLY_HTTP1;
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        List mutableList = CollectionsKt.toMutableList((Collection) protocols);
        T t4 = T.H2_PRIOR_KNOWLEDGE;
        if (!mutableList.contains(t4) && !mutableList.contains(T.HTTP_1_1)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("protocols must contain h2_prior_knowledge or http/1.1: ", mutableList).toString());
        }
        if (mutableList.contains(t4) && mutableList.size() > 1) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("protocols containing h2_prior_knowledge cannot use other protocols: ", mutableList).toString());
        }
        if (!(!mutableList.contains(T.HTTP_1_0))) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("protocols must not contain http/1.0: ", mutableList).toString());
        }
        if (!(!mutableList.contains(null))) {
            throw new IllegalArgumentException("protocols must not contain null".toString());
        }
        mutableList.remove(T.SPDY_3);
        if (!Intrinsics.areEqual(mutableList, q4.f12774t)) {
            q4.f12754D = null;
        }
        List listUnmodifiableList = Collections.unmodifiableList(mutableList);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(protocolsCopy)");
        Intrinsics.checkNotNullParameter(listUnmodifiableList, "<set-?>");
        q4.f12774t = listUnmodifiableList;
        S s4 = new S(q4);
        U uC = this.originalRequest.c();
        uC.c("Upgrade", "websocket");
        uC.c("Connection", "Upgrade");
        uC.c("Sec-WebSocket-Key", this.key);
        uC.c("Sec-WebSocket-Version", "13");
        uC.c("Sec-WebSocket-Extensions", "permessage-deflate");
        final V vB = uC.b();
        RealCall realCall = new RealCall(s4, vB, true);
        this.call = realCall;
        Intrinsics.checkNotNull(realCall);
        realCall.enqueue(new InterfaceC0603l() { // from class: okhttp3.internal.ws.RealWebSocket.connect.1
            @Override // h3.InterfaceC0603l
            public void onFailure(@NotNull InterfaceC0602k call, @NotNull IOException e4) throws IOException {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e4, "e");
                RealWebSocket.this.failWebSocket(e4, null);
            }

            @Override // h3.InterfaceC0603l
            public void onResponse(@NotNull InterfaceC0602k call, @NotNull b0 response) throws IOException {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                Exchange exchange = response.f12876m;
                try {
                    RealWebSocket.this.checkUpgradeSuccess$okhttp(response, exchange);
                    Intrinsics.checkNotNull(exchange);
                    Streams streamsNewWebSocketStreams = exchange.newWebSocketStreams();
                    WebSocketExtensions webSocketExtensions = WebSocketExtensions.INSTANCE.parse(response.f12869f);
                    RealWebSocket.this.extensions = webSocketExtensions;
                    if (!RealWebSocket.this.isValid(webSocketExtensions)) {
                        RealWebSocket realWebSocket = RealWebSocket.this;
                        synchronized (realWebSocket) {
                            realWebSocket.messageAndCloseQueue.clear();
                            realWebSocket.close(1010, "unexpected Sec-WebSocket-Extensions in response header");
                        }
                    }
                    try {
                        RealWebSocket.this.initReaderAndWriter(Util.okHttpName + " WebSocket " + vB.f12826a.h(), streamsNewWebSocketStreams);
                        RealWebSocket.this.getListener$okhttp();
                        throw null;
                    } catch (Exception e4) {
                        RealWebSocket.this.failWebSocket(e4, null);
                    }
                } catch (IOException e5) {
                    if (exchange != null) {
                        exchange.webSocketUpgradeFailed();
                    }
                    RealWebSocket.this.failWebSocket(e5, response);
                    Util.closeQuietly(response);
                }
            }
        });
    }

    public final void failWebSocket(@NotNull Exception e4, @Nullable b0 response) throws IOException {
        Intrinsics.checkNotNullParameter(e4, "e");
        synchronized (this) {
            if (this.failed) {
                return;
            }
            this.failed = true;
            Streams streams = this.streams;
            this.streams = null;
            WebSocketReader webSocketReader = this.reader;
            this.reader = null;
            WebSocketWriter webSocketWriter = this.writer;
            this.writer = null;
            this.taskQueue.shutdown();
            Unit unit = Unit.INSTANCE;
            try {
                throw null;
            } catch (Throwable th) {
                if (streams != null) {
                    Util.closeQuietly(streams);
                }
                if (webSocketReader != null) {
                    Util.closeQuietly(webSocketReader);
                }
                if (webSocketWriter != null) {
                    Util.closeQuietly(webSocketWriter);
                }
                throw th;
            }
        }
    }

    @NotNull
    public final i0 getListener$okhttp() {
        return null;
    }

    public final void initReaderAndWriter(@NotNull String name, @NotNull Streams streams) throws IOException {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(streams, "streams");
        WebSocketExtensions webSocketExtensions = this.extensions;
        Intrinsics.checkNotNull(webSocketExtensions);
        synchronized (this) {
            try {
                this.name = name;
                this.streams = streams;
                this.writer = new WebSocketWriter(streams.getClient(), streams.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams.getClient()), this.minimumDeflateSize);
                this.writerTask = new WriterTask(this);
                long j4 = this.pingIntervalMillis;
                if (j4 != 0) {
                    final long nanos = TimeUnit.MILLISECONDS.toNanos(j4);
                    TaskQueue taskQueue = this.taskQueue;
                    final String strStringPlus = Intrinsics.stringPlus(name, " ping");
                    taskQueue.schedule(new Task(strStringPlus, this, nanos) { // from class: okhttp3.internal.ws.RealWebSocket$initReaderAndWriter$lambda-3$$inlined$schedule$1
                        final /* synthetic */ String $name;
                        final /* synthetic */ long $pingIntervalNanos$inlined;
                        final /* synthetic */ RealWebSocket this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(strStringPlus, false, 2, null);
                            this.$name = strStringPlus;
                            this.this$0 = this;
                            this.$pingIntervalNanos$inlined = nanos;
                        }

                        @Override // okhttp3.internal.concurrent.Task
                        public long runOnce() throws IOException {
                            this.this$0.writePingFrame$okhttp();
                            return this.$pingIntervalNanos$inlined;
                        }
                    }, nanos);
                }
                if (!this.messageAndCloseQueue.isEmpty()) {
                    runWriter();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.reader = new WebSocketReader(streams.getClient(), streams.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!streams.getClient()));
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int code, @NotNull String reason) throws IOException {
        Streams streams;
        WebSocketReader webSocketReader;
        WebSocketWriter webSocketWriter;
        Intrinsics.checkNotNullParameter(reason, "reason");
        if (code == -1) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        synchronized (this) {
            try {
                if (this.receivedCloseCode != -1) {
                    throw new IllegalStateException("already closed".toString());
                }
                this.receivedCloseCode = code;
                this.receivedCloseReason = reason;
                if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                    streams = this.streams;
                    this.streams = null;
                    webSocketReader = this.reader;
                    this.reader = null;
                    webSocketWriter = this.writer;
                    this.writer = null;
                    this.taskQueue.shutdown();
                } else {
                    streams = null;
                    webSocketReader = null;
                    webSocketWriter = null;
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        try {
            throw null;
        } catch (Throwable th2) {
            if (streams != null) {
                Util.closeQuietly(streams);
            }
            if (webSocketReader != null) {
                Util.closeQuietly(webSocketReader);
            }
            if (webSocketWriter != null) {
                Util.closeQuietly(webSocketWriter);
            }
            throw th2;
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull l bytes) throws IOException {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        throw null;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(@NotNull l payload) {
        try {
            Intrinsics.checkNotNullParameter(payload, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(payload);
                runWriter();
                this.receivedPingCount++;
            }
        } finally {
        }
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(@NotNull l payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final synchronized boolean pong(@NotNull l payload) {
        try {
            Intrinsics.checkNotNullParameter(payload, "payload");
            if (!this.failed && (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty())) {
                this.pongQueue.add(payload);
                runWriter();
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean processNextFrame() throws IOException {
        try {
            WebSocketReader webSocketReader = this.reader;
            Intrinsics.checkNotNull(webSocketReader);
            webSocketReader.processNextFrame();
            return this.receivedCloseCode == -1;
        } catch (Exception e4) {
            this.failWebSocket(e4, null);
            return false;
        }
    }

    public synchronized long queueSize() {
        return this.queueSize;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    @NotNull
    /* renamed from: request, reason: from getter */
    public V getOriginalRequest() {
        return this.originalRequest;
    }

    public boolean send(@NotNull l bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        return send(bytes, 2);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006e A[Catch: all -> 0x0077, TRY_ENTER, TryCatch #0 {all -> 0x0077, blocks: (B:29:0x006e, B:32:0x0079, B:34:0x007d, B:35:0x008d, B:37:0x009c, B:40:0x009f, B:41:0x00a0, B:42:0x00a1, B:44:0x00a5, B:56:0x00ca, B:57:0x00cd, B:58:0x00ce, B:59:0x00d3, B:36:0x008e), top: B:72:0x006c, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0079 A[Catch: all -> 0x0077, TryCatch #0 {all -> 0x0077, blocks: (B:29:0x006e, B:32:0x0079, B:34:0x007d, B:35:0x008d, B:37:0x009c, B:40:0x009f, B:41:0x00a0, B:42:0x00a1, B:44:0x00a5, B:56:0x00ca, B:57:0x00cd, B:58:0x00ce, B:59:0x00d3, B:36:0x008e), top: B:72:0x006c, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ba A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c0 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c6 A[DONT_GENERATE] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v2, types: [okhttp3.internal.ws.WebSocketWriter] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean writeOneFrame$okhttp() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writeOneFrame$okhttp():boolean");
    }

    public final void writePingFrame$okhttp() throws IOException {
        synchronized (this) {
            try {
                if (this.failed) {
                    return;
                }
                WebSocketWriter webSocketWriter = this.writer;
                if (webSocketWriter == null) {
                    return;
                }
                int i4 = this.awaitingPong ? this.sentPingCount : -1;
                this.sentPingCount++;
                this.awaitingPong = true;
                Unit unit = Unit.INSTANCE;
                if (i4 != -1) {
                    StringBuilder sb = new StringBuilder("sent ping but didn't receive pong within ");
                    sb.append(this.pingIntervalMillis);
                    sb.append("ms (after ");
                    failWebSocket(new SocketTimeoutException(AbstractC0831a.d(sb, i4 - 1, " successful ping/pongs)")), null);
                    return;
                }
                try {
                    webSocketWriter.writePing(l.f13358d);
                } catch (IOException e4) {
                    failWebSocket(e4, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized boolean close(int code, @Nullable String reason, long cancelAfterCloseMillis) {
        l lVarK;
        try {
            WebSocketProtocol.INSTANCE.validateCloseCode(code);
            if (reason != null) {
                l lVar = l.f13358d;
                lVarK = C0611u.k(reason);
                if (lVarK.f13359a.length > 123) {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("reason.size() > 123: ", reason).toString());
                }
            } else {
                lVarK = null;
            }
            if (!this.failed && !this.enqueuedClose) {
                this.enqueuedClose = true;
                this.messageAndCloseQueue.add(new Close(code, lVarK, cancelAfterCloseMillis));
                runWriter();
                return true;
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized boolean send(l data, int formatOpcode) {
        if (!this.failed && !this.enqueuedClose) {
            if (this.queueSize + data.c() > MAX_QUEUE_SIZE) {
                close(1001, null);
                return false;
            }
            this.queueSize += data.c();
            this.messageAndCloseQueue.add(new Message(formatOpcode, data));
            runWriter();
            return true;
        }
        return false;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(@NotNull String text) throws IOException {
        Intrinsics.checkNotNullParameter(text, "text");
        throw null;
    }

    public boolean send(@NotNull String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        l lVar = l.f13358d;
        return send(C0611u.k(text), 1);
    }
}
