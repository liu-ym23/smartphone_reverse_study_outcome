package i4;

import D7.v;
import android.util.Log;
import com.stepos.ability.mcpserver.model.McpServerConfig;
import com.stepos.ability.mcpserver.model.McpServerState;
import com.stepos.ability.mcpserver.monitor.McpServerMonitor$Outcome;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.k;

/* renamed from: i4.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1554b {
    public static final long[] m = {1, 5, 10, 25, 50, 100, 250, 500, 1000, 2500, 5000, 10000};

    /* renamed from: a, reason: collision with root package name */
    public final McpServerConfig f4607a;
    public volatile McpServerState b;
    public final LinkedHashMap c;
    public final AtomicLong[] d;
    public final AtomicLong e;
    public final AtomicLong f;
    public final AtomicLong g;
    public final AtomicLong h;
    public final AtomicLong i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicLong f4608j;
    public final AtomicLong k;
    public final AtomicLong l;

    public C1554b(McpServerConfig config) {
        k.f(config, "config");
        this.f4607a = config;
        this.b = McpServerState.NotStarted.INSTANCE;
        McpServerMonitor$Outcome[] mcpServerMonitor$OutcomeArrValues = McpServerMonitor$Outcome.values();
        int iP = kotlin.collections.a.P(mcpServerMonitor$OutcomeArrValues.length);
        LinkedHashMap linkedHashMap = new LinkedHashMap(iP < 16 ? 16 : iP);
        for (McpServerMonitor$Outcome mcpServerMonitor$Outcome : mcpServerMonitor$OutcomeArrValues) {
            linkedHashMap.put(mcpServerMonitor$Outcome, new AtomicLong(0L));
        }
        this.c = linkedHashMap;
        AtomicLong[] atomicLongArr = new AtomicLong[13];
        for (int i = 0; i < 13; i++) {
            atomicLongArr[i] = new AtomicLong(0L);
        }
        this.d = atomicLongArr;
        this.e = new AtomicLong(0L);
        this.f = new AtomicLong(0L);
        this.g = new AtomicLong(0L);
        this.h = new AtomicLong(0L);
        this.i = new AtomicLong(0L);
        this.f4608j = new AtomicLong(0L);
        this.k = new AtomicLong(0L);
        this.l = new AtomicLong(0L);
    }

    public final void a(McpServerMonitor$Outcome mcpServerMonitor$Outcome) {
        LinkedHashMap linkedHashMap = this.c;
        ((AtomicLong) kotlin.collections.a.N(mcpServerMonitor$Outcome, linkedHashMap)).incrementAndGet();
        int statsLogEveryRequests = this.f4607a.getStatsLogEveryRequests();
        if (statsLogEveryRequests > 0) {
            if (this.l.incrementAndGet() % statsLogEveryRequests == 0) {
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    McpServerMonitor$Outcome mcpServerMonitor$Outcome2 = (McpServerMonitor$Outcome) entry.getKey();
                    AtomicLong atomicLong = (AtomicLong) entry.getValue();
                    String lowerCase = mcpServerMonitor$Outcome2.name().toLowerCase(Locale.ROOT);
                    k.e(lowerCase, "toLowerCase(...)");
                    linkedHashMap2.put(lowerCase, Long.valueOf(atomicLong.get()));
                }
                long j5 = ((AtomicLong) kotlin.collections.a.N(McpServerMonitor$Outcome.b, linkedHashMap)).get() + ((AtomicLong) kotlin.collections.a.N(McpServerMonitor$Outcome.f3192a, linkedHashMap)).get();
                linkedHashMap2.put("latency_p50_ms", Long.valueOf(b(0.5d)));
                linkedHashMap2.put("latency_p95_ms", Long.valueOf(b(0.95d)));
                linkedHashMap2.put("latency_p99_ms", Long.valueOf(b(0.99d)));
                linkedHashMap2.put("latency_max_ms", Long.valueOf(this.f.get()));
                linkedHashMap2.put("latency_avg_ms", Long.valueOf(j5 > 0 ? this.e.get() / j5 : 0L));
                linkedHashMap2.put("cache_hit", Long.valueOf(this.g.get()));
                linkedHashMap2.put("cache_miss", Long.valueOf(this.h.get()));
                linkedHashMap2.put("cache_coalesced", Long.valueOf(this.i.get()));
                linkedHashMap2.put("cloud_verify_throttled", Long.valueOf(this.f4608j.get()));
                linkedHashMap2.put("handshake_throttled", Long.valueOf(this.k.get()));
                Log.i("McpServerMonitor", "stats " + v.I0(linkedHashMap2.entrySet(), " ", null, null, new com.uxsense.parse.b(18), 30));
            }
        }
    }

    public final long b(double d) {
        AtomicLong[] atomicLongArr = this.d;
        long j5 = 0;
        long j6 = 0;
        for (AtomicLong atomicLong : atomicLongArr) {
            j6 += atomicLong.get();
        }
        if (j6 == 0) {
            return 0L;
        }
        long jCeil = (long) Math.ceil(j6 * d);
        if (jCeil < 1) {
            jCeil = 1;
        }
        int length = atomicLongArr.length;
        for (int i = 0; i < length; i++) {
            j5 += atomicLongArr[i].get();
            if (j5 >= jCeil) {
                if (i < 12) {
                    return m[i];
                }
                return -1L;
            }
        }
        return -1L;
    }

    public final void c(McpServerState state) {
        k.f(state, "state");
        this.b = state;
        if (state instanceof McpServerState.Running) {
            Log.i("McpServerMonitor", "MCP Server started, listening on port " + ((McpServerState.Running) state).getPort());
            return;
        }
        if (!(state instanceof McpServerState.Failed)) {
            if (!state.equals(McpServerState.NotStarted.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            Log.i("McpServerMonitor", "MCP Server not started");
            return;
        }
        McpServerState.Failed failed = (McpServerState.Failed) state;
        Log.e("McpServerMonitor", "MCP Server FAILED to start: " + failed.getReason() + " (portInUse=" + failed.getPortInUse() + "). 服务未启动，所有 MCP 调用都会连接失败。");
    }
}
