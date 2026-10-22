package com.android.server.connectivity;

import android.content.Context;
import android.net.ConnectivityMetricsEvent;
import android.net.IIpConnectivityMetrics;
import android.net.INetdEventCallback;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkStack;
import android.net.metrics.ApfProgramEvent;
import android.os.Binder;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.ArrayMap;
import android.util.Base64;
import android.util.Log;
import com.android.internal.util.RingBuffer;
import com.android.internal.util.TokenBucket;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.connectivity.metrics.nano.IpConnectivityLogClass;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.ToIntFunction;

/* JADX INFO: loaded from: classes.dex */
public final class IpConnectivityMetrics extends SystemService {
    private static final boolean DBG = false;
    private static final int DEFAULT_BUFFER_SIZE = 2000;
    private static final int DEFAULT_LOG_SIZE = 500;
    private static final int ERROR_RATE_LIMITED = -1;
    private static final int MAXIMUM_BUFFER_SIZE = 20000;
    private static final int MAXIMUM_CONNECT_LATENCY_RECORDS = 20000;
    private static final int NYC = 0;
    private static final int NYC_MR1 = 1;
    private static final int NYC_MR2 = 2;
    private static final ToIntFunction<Context> READ_BUFFER_SIZE = null;
    private static final String SERVICE_NAME = "connmetrics";
    private static final String TAG = null;
    public static final int VERSION = 2;
    public final Impl impl;
    private final ArrayMap<Class<?>, TokenBucket> mBuckets;
    private ArrayList<ConnectivityMetricsEvent> mBuffer;
    private int mCapacity;
    private final ToIntFunction<Context> mCapacityGetter;
    final DefaultNetworkMetrics mDefaultNetworkMetrics;
    private int mDropped;
    private final RingBuffer<ConnectivityMetricsEvent> mEventLog;
    private final Object mLock;
    NetdEventListenerService mNetdListener;

    public final class Impl extends IIpConnectivityMetrics.Stub {
        static final String CMD_DEFAULT = "";
        static final String CMD_FLUSH = "flush";
        static final String CMD_LIST = "list";
        static final String CMD_PROTO = "proto";
        static final String CMD_PROTO_BIN = "--proto";
        final /* synthetic */ IpConnectivityMetrics this$0;

        public Impl(IpConnectivityMetrics this$0) {
            this.this$0 = this$0;
        }

        public int logEvent(ConnectivityMetricsEvent event) {
            NetworkStack.checkNetworkStackPermission(this.this$0.getContext());
            return IpConnectivityMetrics.m3054$$Nest$mappend(this.this$0, event);
        }

        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            enforceDumpPermission();
            byte r1 = 0;
            if (args.length <= 0) goto L5;
            String cmd = args[0];
        L7:
            switch(cmd.hashCode()) {
                case -1616754616: goto L19;
                case 3322014: goto L16;
                case 97532676: goto L13;
                case 106940904: goto L10;
                default: goto L21;
            };
        L21:
            r1 = -1;
        L22:
            switch(r1) {
                case 0: goto L29;
                case 1: goto L27;
                case 2: goto L25;
                default: goto L23;
            };
        L23:
            IpConnectivityMetrics.m3056$$Nest$mcmdList(this.this$0, pw);
            return;
        L25:
            IpConnectivityMetrics.m3057$$Nest$mcmdListAsBinaryProto(this.this$0, new FileOutputStream(fd));
            return;
        L27:
            IpConnectivityMetrics.m3058$$Nest$mcmdListAsTextProto(this.this$0, pw);
            return;
        L29:
            IpConnectivityMetrics.m3055$$Nest$mcmdFlush(this.this$0, pw);
            return;
        L10:
            if (cmd.equals(CMD_PROTO) == false) goto L21;
            r1 = 1;
            goto L22
        L13:
            if (cmd.equals(CMD_FLUSH) == false) goto L21;
        L16:
            if (cmd.equals(CMD_LIST) == false) goto L21;
            r1 = 3;
            goto L22
        L19:
            if (cmd.equals("--proto") == false) goto L21;
            r1 = 2;
            goto L22
        L5:
            cmd = "";
            goto L7
        }

        private void enforceDumpPermission() {
            enforcePermission("android.permission.DUMP");
        }

        private void enforcePermission(String what) {
            this.this$0.getContext().enforceCallingOrSelfPermission(what, "IpConnectivityMetrics");
        }

        private void enforceNetdEventListeningPermission() {
            int uid = Binder.getCallingUid();
            if (uid != 1000) goto L6;
            return;
        L6:
            throw new SecurityException(String.format("Uid %d has no permission to listen for netd events.", new Object[]{Integer.valueOf(uid)}));
        }

        public boolean addNetdEventCallback(int callerType, INetdEventCallback callback) {
            enforceNetdEventListeningPermission();
            if (this.this$0.mNetdListener != null) goto L7;
            return false;
        L7:
            return this.this$0.mNetdListener.addNetdEventCallback(callerType, callback);
        }

        public boolean removeNetdEventCallback(int callerType) {
            enforceNetdEventListeningPermission();
            if (this.this$0.mNetdListener != null) goto L7;
            return true;
        L7:
            return this.this$0.mNetdListener.removeNetdEventCallback(callerType);
        }

        public void logDefaultNetworkValidity(boolean valid) {
            NetworkStack.checkNetworkStackPermission(this.this$0.getContext());
            this.this$0.mDefaultNetworkMetrics.logDefaultNetworkValidity(SystemClock.elapsedRealtime(), valid);
        }

        public void logDefaultNetworkEvent(Network defaultNetwork, int score, boolean validated, LinkProperties lp, NetworkCapabilities nc, Network previousDefaultNetwork, int previousScore, LinkProperties previousLp, NetworkCapabilities previousNc) {
            NetworkStack.checkNetworkStackPermission(this.this$0.getContext());
            long timeMs = SystemClock.elapsedRealtime();
            this.this$0.mDefaultNetworkMetrics.logDefaultNetworkEvent(timeMs, defaultNetwork, score, validated, lp, nc, previousDefaultNetwork, previousScore, previousLp, previousNc);
        }
    }

    public interface Logger {
        DefaultNetworkMetrics defaultNetworkMetrics();
    }

    private class LoggerImpl implements Logger {
        final /* synthetic */ IpConnectivityMetrics this$0;

        /* synthetic */ LoggerImpl(IpConnectivityMetrics r1, IpConnectivityMetricsIA r2) {
            this(r1);
        }

        private LoggerImpl(IpConnectivityMetrics r1) {
            this.this$0 = r1;
        }

        @Override // com.android.server.connectivity.IpConnectivityMetrics.Logger
        public DefaultNetworkMetrics defaultNetworkMetrics() {
            return this.this$0.mDefaultNetworkMetrics;
        }
    }

    public static /* synthetic */ void $r8$lambda$kUsw8Mb0hpZU68y1IIE9EGj6t_k(PrintWriter r0, IpConnectivityLogClass.IpConnectivityEvent r1) {
        lambda$cmdListAsTextProto$0(r0, r1);
    }

    public static /* synthetic */ int $r8$lambda$vBvdubbZbE8NJB5mMZ6KhHRxliM(Context r0) {
        return lambda$static$1(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$mappend, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3054$$Nest$mappend(IpConnectivityMetrics r0, ConnectivityMetricsEvent r1) {
        return r0.append(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcmdFlush, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3055$$Nest$mcmdFlush(IpConnectivityMetrics r0, PrintWriter r1) {
        r0.cmdFlush(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcmdList, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3056$$Nest$mcmdList(IpConnectivityMetrics r0, PrintWriter r1) {
        r0.cmdList(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcmdListAsBinaryProto, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3057$$Nest$mcmdListAsBinaryProto(IpConnectivityMetrics r0, OutputStream r1) {
        r0.cmdListAsBinaryProto(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mcmdListAsTextProto, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3058$$Nest$mcmdListAsTextProto(IpConnectivityMetrics r0, PrintWriter r1) {
        r0.cmdListAsTextProto(r1);
    }

    static {
        TAG = IpConnectivityMetrics.class.getSimpleName();
        READ_BUFFER_SIZE = new IpConnectivityMetrics$$ExternalSyntheticLambda1();
    }

    public IpConnectivityMetrics(Context ctx, ToIntFunction<Context> capacityGetter) {
        super(ctx);
        this.mLock = new Object();
        this.impl = new Impl(this);
        this.mEventLog = new RingBuffer(ConnectivityMetricsEvent.class, 500);
        this.mBuckets = makeRateLimitingBuckets();
        this.mDefaultNetworkMetrics = new DefaultNetworkMetrics();
        this.mCapacityGetter = capacityGetter;
        initBuffer();
    }

    public IpConnectivityMetrics(Context ctx) {
        this(ctx, READ_BUFFER_SIZE);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L6;
        this.mNetdListener = new NetdEventListenerService(getContext());
        publishBinderService(SERVICE_NAME, this.impl);
        publishBinderService(NetdEventListenerService.SERVICE_NAME, this.mNetdListener);
        LocalServices.addService(Logger.class, new LoggerImpl(this, null));
        return;
    }

    public int bufferCapacity() {
        return this.mCapacityGetter.applyAsInt(getContext());
    }

    private void initBuffer() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDropped = 0;     // Catch: Throwable -> L8
        this.mCapacity = bufferCapacity();     // Catch: Throwable -> L8
        this.mBuffer = new ArrayList(this.mCapacity);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private int append(ConnectivityMetricsEvent event) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mEventLog.append(event);     // Catch: Throwable -> L8
        int left = this.mCapacity - this.mBuffer.size();     // Catch: Throwable -> L8
        if (event != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return left;
    L11:
        if (isRateLimited(event) == false) goto L15;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return -1;
    L15:
        if (left != 0) goto L20;
        this.mDropped++;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return 0;
    L20:
        this.mBuffer.add(event);     // Catch: Throwable -> L8
        int r2 = left - 1;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return r2;
    L8:
        th = move-exception;
        throw th;
    }

    private boolean isRateLimited(ConnectivityMetricsEvent event) {
        TokenBucket tb = this.mBuckets.get(event.data.getClass());
        if (tb != null) goto L5;
    L7:
        return false;
    L5:
        if (tb.get() == true) goto L7;
        return true;
    }

    private String flushEncodedOutput() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ArrayList<ConnectivityMetricsEvent> events = this.mBuffer;     // Catch: Throwable -> L15
        int dropped = this.mDropped;     // Catch: Throwable -> L15
        initBuffer();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        List<IpConnectivityLogClass.IpConnectivityEvent> protoEvents = IpConnectivityEventBuilder.toProto(events);
        this.mDefaultNetworkMetrics.flushEvents(protoEvents);
        if (this.mNetdListener == null) goto L18;
        this.mNetdListener.flushStatistics(protoEvents);
    L18:
        byte[] data = IpConnectivityEventBuilder.serialize(dropped, protoEvents);     // Catch: IOException -> L12
        return Base64.encodeToString(data, 0);
    L12:
        e = move-exception;
        Log.e(TAG, "could not serialize events", e);
        return "";
    L15:
        th = move-exception;
        throw th;
    }

    private void cmdFlush(PrintWriter pw) {
        pw.print(flushEncodedOutput());
    }

    private void cmdList(PrintWriter pw) {
        pw.println("metrics events:");
        List<ConnectivityMetricsEvent> events = getEvents();
        Iterator<ConnectivityMetricsEvent> r1 = events.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ConnectivityMetricsEvent ev = r1.next();
        pw.println(ev.toString());
        goto L4
    L6:
        pw.println("");
        if (this.mNetdListener == null) goto L9;
        this.mNetdListener.list(pw);
    L9:
        pw.println("");
        this.mDefaultNetworkMetrics.listEvents(pw);
    }

    private List<IpConnectivityLogClass.IpConnectivityEvent> listEventsAsProtos() {
        List<IpConnectivityLogClass.IpConnectivityEvent> events = IpConnectivityEventBuilder.toProto(getEvents());
        if (this.mNetdListener == null) goto L5;
        events.addAll(this.mNetdListener.listAsProtos());
    L5:
        events.addAll(this.mDefaultNetworkMetrics.listEventsAsProto());
        return events;
    }

    private void cmdListAsTextProto(final PrintWriter pw) {
        listEventsAsProtos().forEach(new IpConnectivityMetrics$$ExternalSyntheticLambda0(pw));
    }

    private static /* synthetic */ void lambda$cmdListAsTextProto$0(PrintWriter pw, IpConnectivityLogClass.IpConnectivityEvent e) {
        pw.print(e.toString());
    }

    private void cmdListAsBinaryProto(OutputStream out) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int dropped = this.mDropped;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        byte[] data = IpConnectivityEventBuilder.serialize(dropped, listEventsAsProtos());     // Catch: IOException -> L8
        out.write(data);     // Catch: IOException -> L8
        out.flush();     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        Log.e(TAG, "could not serialize events", e);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private List<ConnectivityMetricsEvent> getEvents() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<ConnectivityMetricsEvent> r1 = Arrays.asList((ConnectivityMetricsEvent[]) this.mEventLog.toArray());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ int lambda$static$1(Context ctx) {
        int size = Settings.Global.getInt(ctx.getContentResolver(), "connectivity_metrics_buffer_size", 2000);
        if (size > 0) goto L6;
        return 2000;
    L6:
        return Math.min(size, 20000);
    }

    private static ArrayMap<Class<?>, TokenBucket> makeRateLimitingBuckets() {
        ArrayMap<Class<?>, TokenBucket> map = new ArrayMap();
        map.put(ApfProgramEvent.class, new TokenBucket(60000, 50));
        return map;
    }
}
