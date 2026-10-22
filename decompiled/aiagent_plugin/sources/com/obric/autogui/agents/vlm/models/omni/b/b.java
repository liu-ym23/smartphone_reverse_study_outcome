package com.obric.autogui.agents.vlm.models.omni.b;

import android.os.SystemClock;
import com.obric.agent.trace.toolmetrics.IOmniClientToolTraceService;
import com.obric.agent.trace.toolmetrics.u;
import com.obric.agent.trace.toolmetrics.v;
import com.obric.agent.trace.toolmetrics.z;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.n;
import d.x;
import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: OmniGuiToolTraceContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f28214a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final z f28215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EnumMap<f, Long> f28216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final EnumMap<c, Long> f28217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final EnumMap<c, Long> f28218e;
    private final LinkedHashMap<String, Object> f;
    private final LinkedHashMap<String, Object> g;
    private boolean h;
    private boolean i;

    /* JADX INFO: compiled from: OmniGuiToolTraceContext.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final b a(DispatchContext r3) {
            o.e(r3, "dispatchContext");
            Map<String, String> r2 = r3.getExt();
            h r4 = null;
            if (r2 == null) goto L13;
            String r5 = (String) ZeusTransformUtils.preCheckCast(r2.get("omni_client_tool_trace_id"), String.class, "com.obric.aiagent.plugin");
            if (r5 == null) goto L13;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
            r5 = null;
        L10:
            if (r5 == null) goto L13;
            b r0 = new b(new z(r5), r4);
            r0.a(f.f28226a);
            return r0;
        L13:
            return null;
        }
    }

    static {
        f28214a = new a(null);
    }

    public /* synthetic */ b(z r1, h r2) {
        this(r1);
    }

    private b(z r2) {
        this.f28215b = r2;
        this.f28216c = new EnumMap(f.class);
        this.f28217d = new EnumMap(c.class);
        this.f28218e = new EnumMap(c.class);
        this.f = new LinkedHashMap();
        this.g = new LinkedHashMap();
    }

    public final void a(com.obric.autogui.agents.vlm.models.omni.intent.g r3) {
        o.e(r3, Ext.KEY_REQUEST);
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.i == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f.clear();     // Catch: Throwable -> L11
        this.f.putAll(d.f28224a.a(r3));     // Catch: Throwable -> L11
        x r4 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final void a(Map<String, ? extends Object> r3) {
        Map<? extends String, ? extends Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        o.e(r4, "fields");
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.i == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.g.putAll(r4);     // Catch: Throwable -> L11
        x r5 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final void a(f r9) {
        o.e(r9, "point");
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.i == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        StringBuilder r0 = new StringBuilder().append("gui.");     // Catch: Throwable -> L18
        String r1 = r9.name();     // Catch: Throwable -> L18
        Locale r2 = Locale.US;     // Catch: Throwable -> L18
        o.c(r2, "US");     // Catch: Throwable -> L18
        String r3 = r1.toLowerCase(r2);     // Catch: Throwable -> L18
        o.c(r3, "toLowerCase(...)");     // Catch: Throwable -> L18
        a(r0.append(r3).toString());     // Catch: Throwable -> L18
        if (a(this, r9, SystemClock.elapsedRealtime(), null, 4, null) == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        if (r9 != f.f28230e) goto L15;
        this.i = true;     // Catch: Throwable -> L18
        b((Map) ZeusTransformUtils.preCheckCast(this.f28216c, Map.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
    L15:
        x r10 = x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(this);
    }

    public final void a(c r5) {
        o.e(r5, "detail");
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.i == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        StringBuilder r0 = new StringBuilder().append("gui.");     // Catch: Throwable -> L11
        String r1 = r5.name();     // Catch: Throwable -> L11
        Locale r2 = Locale.US;     // Catch: Throwable -> L11
        o.c(r2, "US");     // Catch: Throwable -> L11
        String r3 = r1.toLowerCase(r2);     // Catch: Throwable -> L11
        o.c(r3, "toLowerCase(...)");     // Catch: Throwable -> L11
        a(r0.append(r3).append(".started").toString());     // Catch: Throwable -> L11
        a(r5, SystemClock.elapsedRealtime());     // Catch: Throwable -> L11
        x r6 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final void b(c r5) {
        o.e(r5, "detail");
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.i == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        StringBuilder r0 = new StringBuilder().append("gui.");     // Catch: Throwable -> L11
        String r1 = r5.name();     // Catch: Throwable -> L11
        Locale r2 = Locale.US;     // Catch: Throwable -> L11
        o.c(r2, "US");     // Catch: Throwable -> L11
        String r3 = r1.toLowerCase(r2);     // Catch: Throwable -> L11
        o.c(r3, "toLowerCase(...)");     // Catch: Throwable -> L11
        a(r0.append(r3).append(".finished").toString());     // Catch: Throwable -> L11
        b(r5, SystemClock.elapsedRealtime());     // Catch: Throwable -> L11
        x r6 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    private final void a(c r2, long r3) {
        if (this.f28217d.containsKey(r2) == false) goto L5;
        return;
    L5:
        Long r4 = Long.valueOf(r3);
        ((Map) ZeusTransformUtils.preCheckCast(this.f28217d, Map.class, "com.obric.aiagent.plugin")).put(r2, r4);
    }

    private final void b(c r6, long r7) {
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(this.f28217d.remove(r6), Long.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L12;
        long r8 = r7 - r0.longValue();
        long r1 = 0;
        if (r8 >= 0) goto L7;
        return;
    L7:
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(this.f28218e, Map.class, "com.obric.aiagent.plugin");
        Long r5 = (Long) ZeusTransformUtils.preCheckCast(this.f28218e.get(r6), Long.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L10;
        r1 = r5.longValue();
    L10:
        r3.put(r6, Long.valueOf(r1 + r8));
        return;
    }

    public final void a() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.i == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.h = true;     // Catch: Throwable -> L11
        b(a(SystemClock.elapsedRealtime()));     // Catch: Throwable -> L11
        x r0 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public final void b() {
        a(f.f28230e);
    }

    static /* synthetic */ boolean a(b r1, f r2, long r3, Map r5, int r6, Object r7) {
        Map<f, Long> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r8 = (Map) ZeusTransformUtils.preCheckCast(r1.f28216c, Map.class, "com.obric.aiagent.plugin");
    L6:
        return r1.a(r2, r3, r8);
    }

    private final boolean a(f r2, long r3, Map<f, Long> r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r2.a() == true) goto L9;
        if (r1.containsKey(r2) == false) goto L9;
        return false;
    L9:
        if (r2 != f.f28228c) goto L11;
        r1.remove(f.f28229d);
    L11:
        r1.put(r2, Long.valueOf(r3));
        return true;
    }

    private final Map<f, Long> a(long r5) {
        EnumMap r0 = new EnumMap(this.f28216c);
        a(f.f28230e, r5, (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin"));
        return (Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.aiagent.plugin");
    }

    private final void b(Map<f, Long> r11) {
        Map<f, Long> r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        Map<String, Object> r12 = d.f28224a.a(r3, (Map) ZeusTransformUtils.preCheckCast(this.f28218e, Map.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.aiagent.plugin"), this.h);
        n.a r0 = n.f38560a;     // Catch: Throwable -> L9
        b r10 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        IOmniClientToolTraceService r1 = IOmniClientToolTraceService.Companion.a();     // Catch: Throwable -> L9
        if (r1 == null) goto L6;
        r1.append(r10.f28215b, new com.obric.agent.trace.toolmetrics.n(null, null, null, null, new u(v.f15931b, "gui", r12), 15, null));     // Catch: Throwable -> L9
        x r13 = x.f38692a;     // Catch: Throwable -> L9
    L7:
        n.f(r13);     // Catch: Throwable -> L9
        return;
    L6:
        r13 = null;
    L9:
        th = move-exception;
        n.a r14 = n.f38560a;
        n.f(d.o.a(th));
    }

    private final void a(String r3) {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L8
        b r2 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        IOmniClientToolTraceService r1 = IOmniClientToolTraceService.Companion.a();     // Catch: Throwable -> L8
        if (r1 == null) goto L5;
        r1.markProgress(r2.f28215b, r3);     // Catch: Throwable -> L8
        x r4 = x.f38692a;     // Catch: Throwable -> L8
    L6:
        n.f(r4);     // Catch: Throwable -> L8
        return;
    L5:
        r4 = null;
    L8:
        th = move-exception;
        n.a r5 = n.f38560a;
        n.f(d.o.a(th));
    }
}
