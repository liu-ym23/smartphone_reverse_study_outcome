package com.autonavi.base.ae.gmap;

import com.amap.api.mapcore.util.z8;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes39.dex */
final class TileRequestTraceController {
    private static final String PHASE_ACTIVE = "active";
    private static final String PHASE_DESTROYED = "destroyed";
    private static final String PHASE_DESTROYING = "destroying";
    static final String REQUEST_TAG = "MapNetworkRequestTrace";
    static final String TILE_TAG = "MapTileTrace";
    private volatile int level;
    private final MapNetworkMetrics metrics;
    private volatile TraceSession session;
    private final ThreadLocal<TerminalDispatchTrace> terminalDispatchTrace;

    public static final class TerminalDispatchTrace {
        final long handler;
        boolean tileCallbackObserved;
        boolean tileSuccess;
        boolean userCallbackDispatched;
        boolean userCallbackSet;

        public TerminalDispatchTrace(long r100) {
            this.handler = r100;
        }
    }

    public static final class TraceSession {
        boolean destroyedLogged;
        final AtomicLong failureCount;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        final long f30028id;
        final AtomicLong maxDurationMs;
        volatile String phase;
        final AtomicLong successCount;
        final AtomicLong terminalCount;

        public TraceSession(long r100) {
            this.terminalCount = new AtomicLong();
            this.successCount = new AtomicLong();
            this.failureCount = new AtomicLong();
            this.maxDurationMs = new AtomicLong();
            this.phase = "active";
            this.f30028id = r100;
        }
    }

    private static String levelName(int r100) {
        if (r100 < 2) goto L7;
        return "detail";
    L7:
        if (r100 < 1) goto L10;
        return "summary";
    L10:
        return "off";
    }

    private static int normalizeLevel(int r100) {
        if (r100 >= 0) goto L4;
    L6:
        return 0;
    L4:
        if (r100 > 2) goto L6;
        return r100;
    }

    private TraceSession ensureSession() {
        TraceSession r100 = this.session;
        if (r100 == null) goto L5;
        return r100;
    L5:
        monitor-enter(this);
        TraceSession r101 = this.session;     // Catch: Throwable -> L11
        if (r101 != null) goto L9;
        r101 = new TraceSession(System.currentTimeMillis());     // Catch: Throwable -> L11
        this.session = r101;     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return r101;
    L11:
        th = move-exception;
        throw th;
    }

    private long sessionId() {
        TraceSession r100 = this.session;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.f30028id;
    }

    public boolean isDetailEnabled() {
        if (this.level < 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEnabled() {
        if (this.level >= 1) goto L7;
        return false;
    L7:
        return true;
    }

    public TileRequestTraceController() {
        this.metrics = new MapNetworkMetrics();
        this.terminalDispatchTrace = new ThreadLocal();
        this.level = 0;
    }

    public void onSubmitted() {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        this.metrics.onSubmitted();
    }

    public boolean requiresInternalTileCallback() {
        return isEnabled();
    }

    private static long nonNegative(long r100) {
        return Math.max(0, r100);
    }

    private static String sanitizeEndpoint(String r100) {
        if (r100 != null) goto L4;
        return "empty";
    L4:
        if (r100.length() == 0) goto L20;
        int r101 = r100.indexOf(63);
        if (r101 < 0) goto L9;
        r100 = r100.substring(0, r101);
    L9:
        int r102 = r100.indexOf("://");
        if (r102 < 0) goto L18;
        int r103 = r100.indexOf(47, r102 + 3);
        if (r103 >= 0) goto L19;
        return HTTP.URL_DEFAULT;
    L19:
        return r100.substring(r103);
    L18:
        return r100;
    L20:
        return "empty";
    }

    public TerminalDispatchTrace beginNativeTerminal(long r100) {
        if (isDetailEnabled() == true) goto L6;
        return null;
    L6:
        TerminalDispatchTrace r101 = new TerminalDispatchTrace(r100);
        this.terminalDispatchTrace.set(r101);
        return r101;
    }

    public void endNativeTerminal(TerminalDispatchTrace r100) {
        if (r100 == null) goto L5;
        this.terminalDispatchTrace.remove();
        return;
    }

    public void onManagerDestroyed(int r100) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        TraceSession r101 = ensureSession();
        r101.phase = PHASE_DESTROYED;
        logSessionDestroyed(r101, "manager_destroyed", r100);
    }

    private TraceSession startSession(long r100, String r101) {
        TraceSession r102 = new TraceSession(System.currentTimeMillis());
        this.session = r102;
        levelName(this.level);
        return r102;
    }

    private static void updateMax(AtomicLong r100, long r101) {
    L2:
        long r102 = r100.get();
        if (r101 <= r102) goto L4;
        if (r100.compareAndSet(r102, r101) == false) goto L2;
        return;
    }

    public void forceMetricsSnapshot(z8 r100, int r101) {
        if (isEnabled() == false) goto L6;
        this.metrics.forceSnapshot(r100, r101);
        return;
    }

    public void onAccepted(NetworkRequestLifecycle.RequestContext r100, int r101) {
        if (isDetailEnabled() == true) goto L5;
        return;
    L5:
        sessionId();
        long r102 = r100.handler;
    }

    public void onCallbackRegistration(boolean r100, boolean r101) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        sessionId();
        requiresInternalTileCallback();
    }

    public void onEvicted(long r100, long r101) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        this.metrics.onEvicted(r101);
        if (isDetailEnabled() == false) goto L9;
        sessionId();
        nonNegative(System.currentTimeMillis() - r101);
        return;
    }

    public void onReceiveIgnored(long r100, int r101) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        sessionId();
    }

    private void logSessionDestroyed(TraceSession r100, String r101, int r102) {
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (r100.destroyedLogged == false) goto L7;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L7:
        r100.destroyedLogged = true;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        r100.terminalCount.get();
        r100.successCount.get();
        r100.failureCount.get();
        r100.maxDurationMs.get();
    }

    public void onEngineCreated(long r100, int r101, int r102) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        TraceSession r103 = this.session;
        if (r103 != null) goto L8;
    L11:
        r103 = startSession(r100, "engine_created");
    L13:
        if (isDetailEnabled() == false) goto L16;
        long r104 = r103.f30028id;
        return;
    L16:
        return;
    L8:
        if (PHASE_DESTROYED.equals(r103.phase) == true) goto L11;
        r103.phase = "active";
        goto L13
    }

    public void onEngineDestroying(long r100, int r101, int r102) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        ensureSession().phase = PHASE_DESTROYING;
    }

    public void onPoolRejected(long r100, z8 r101, int r102) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        this.metrics.onPoolRejected(r101, r102);
        if (isDetailEnabled() == false) goto L9;
        sessionId();
        return;
    }

    public void onTerminalException(long r100, String r101, Throwable r102) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        sessionId();
        r102.getClass();
    }

    public void onTerminalIgnored(long r100, String r101, int r102) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        sessionId();
    }

    public void onEngineDestroyed(long r100, int r101, int r102, int r103) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        TraceSession r104 = ensureSession();
        if (r101 != 0) goto L8;
        r104.phase = PHASE_DESTROYED;
        logSessionDestroyed(r104, "last_engine_destroyed", r103);
        return;
    L8:
        if (r102 <= 0) goto L10;
        String r105 = PHASE_DESTROYING;
    L11:
        r104.phase = r105;
        if (isDetailEnabled() == true) goto L14;
        return;
    L14:
        return;
    L10:
        r105 = "active";
        goto L11
    }

    public void onParsed(NetworkRequestLifecycle.RequestContext r100, String r101, Map<String, String> r102, int r103) {
        if (isDetailEnabled() == true) goto L5;
        return;
    L5:
        r100.setTraceInfo(sanitizeEndpoint(r101), TileRequestIdentifier.create(r101, r102));
        sessionId();
        if (r102 != null) goto L8;
        Object r104 = "[]";
    L9:
        Objects.toString(r104);
        return;
    L8:
        r104 = r102.keySet();
        goto L9
    }

    public synchronized void configure(int r100, z8 r101, int r102, int r103, int r104) {
        monitor-enter(this);
        int r105 = normalizeLevel(r100);     // Catch: Throwable -> L20
        int r106 = this.level;     // Catch: Throwable -> L20
        if (r106 != r105) goto L7;
        monitor-exit(this);
        return;
    L7:
        if (r105 != 0) goto L14;
        this.metrics.forceSnapshot(r101, r104);     // Catch: Throwable -> L20
        TraceSession r107 = this.session;     // Catch: Throwable -> L20
        if (r107 == null) goto L11;
        r107.phase = PHASE_DESTROYED;     // Catch: Throwable -> L20
        logSessionDestroyed(r107, "log_disabled", r104);     // Catch: Throwable -> L20
    L11:
        this.level = r105;     // Catch: Throwable -> L20
        this.metrics.setEnabled(false, r101, r102);     // Catch: Throwable -> L20
        this.session = null;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L14:
        this.level = r105;     // Catch: Throwable -> L20
        this.metrics.setEnabled(true, r101, r102);     // Catch: Throwable -> L20
        levelName(r105);     // Catch: Throwable -> L20
        if (r106 != 0) goto L18;
        if (r103 <= 0) goto L18;
        startSession(0, "log_enabled");     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public void onDrainIncomplete(String r100, String r101, long r102, int r103, String r104) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        sessionId();
    }

    public void onRejected(long r100, String r101, boolean r102, z8 r103, int r104) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        this.metrics.onRejected(r103, r104);
        if (isDetailEnabled() == false) goto L9;
        sessionId();
        return;
    }

    public void onTileTerminal(boolean r100, long r101, String r102, boolean r103, boolean r104) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        TraceSession r105 = ensureSession();
        r105.terminalCount.incrementAndGet();
        if (r100 == false) goto L8;
        r105.successCount.incrementAndGet();
    L9:
        if (r100 == false) goto L11;
        r105.failureCount.get();
    L12:
        updateMax(r105.maxDurationMs, r101);
        TerminalDispatchTrace r106 = this.terminalDispatchTrace.get();
        if (r106 == null) goto L16;
        r106.tileCallbackObserved = true;
        r106.tileSuccess = r100;
        r106.userCallbackSet = r103;
        r106.userCallbackDispatched = r104;
    L16:
        if (isDetailEnabled() == true) goto L18;
        return;
    L18:
        return;
    L11:
        r105.failureCount.incrementAndGet();
        goto L12
    L8:
        r105.successCount.get();
        goto L9
    }

    public void onTerminal(NetworkRequestLifecycle.RequestContext r110, boolean r111, String r112, int r113, String r114, boolean r210, long r211, long r212, long r213, z8 r214, int r215, TerminalDispatchTrace r216) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        this.metrics.onTerminal(r111, r114, r210, r211, r212, r213, r214, r215);
        if (isDetailEnabled() == true) goto L9;
        return;
    L9:
        if (r213 <= 0) goto L11;
        long r100 = r213;
    L13:
        if (r212 <= 0) goto L15;
        nonNegative(r212 - r211);
    L15:
        if (r212 <= 0) goto L17;
        nonNegative(r100 - r212);
    L17:
        nonNegative(r100 - r211);
        sessionId();
        long r101 = r110.handler;
        r110.getTraceEndpoint();
        r110.getTraceTileIdentifier();
        if (r216 == null) goto L20;
        boolean r102 = r216.tileCallbackObserved;
    L20:
        if (r216 != null) goto L22;
        return;
    L22:
        if (r216.tileCallbackObserved == false) goto L26;
        Boolean.toString(r216.tileSuccess);
        return;
    L26:
        return;
    L11:
        r100 = System.currentTimeMillis();
        goto L13
    }
}
