package com.obric.agent.trace.toolmetrics;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: OmniClientToolTraceStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f15939a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f15940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<String, com.obric.agent.trace.toolmetrics.a> f15942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f15943e;
    private final Object f;
    private final LinkedHashMap<String, Long> g;

    /* JADX INFO: compiled from: OmniClientToolTraceStore.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f15939a = new a(null);
    }

    public x() {
        int r0 = 0;
        this(r0, r0, 3, null);
    }

    public x(int r1, int r2) {
        this.f15940b = r1;
        this.f15941c = r2;
        this.f15942d = new ConcurrentHashMap();
        this.f15943e = new ConcurrentHashMap();
        this.f = new Object();
        this.g = new LinkedHashMap();
    }

    public /* synthetic */ x(int r1, int r2, int r3, d.h.b.h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 1024;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = 4096;
    L8:
        this(r1, r2);
    }

    public final com.obric.agent.trace.toolmetrics.a a(com.obric.agent.trace.toolmetrics.a r10) {
        d.h.b.o.e(r10, "state");
        ((Map) ZeusTransformUtils.preCheckCast(this.f15942d, Map.class, "com.obric.aiagent.plugin")).put(r10.a(), r10);
        k r0 = r10.e();
        if (r0 == null) goto L5;
        String r1 = r0.c();
    L6:
        a(r10, r1);
        if (this.f15942d.size() > this.f15940b) goto L9;
        return null;
    L9:
        Collection<com.obric.agent.trace.toolmetrics.a> r2 = this.f15942d.values();
        d.h.b.o.c(r2, "<get-values>(...)");
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r3.iterator();
    L11:
        if (r5.hasNext() == false) goto L15;
        Object r6 = r5.next();
        if ((!d.h.b.o.a(((com.obric.agent.trace.toolmetrics.a) ZeusTransformUtils.preCheckCast(r6, com.obric.agent.trace.toolmetrics.a.class, "com.obric.aiagent.plugin")).a(), r10.a())) == false) goto L11;
        r4.add(r6);
        goto L11
    L15:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        if (r11.hasNext() == true) goto L18;
        Object r7 = null;
    L27:
        com.obric.agent.trace.toolmetrics.a r12 = (com.obric.agent.trace.toolmetrics.a) ZeusTransformUtils.preCheckCast(r7, com.obric.agent.trace.toolmetrics.a.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L31;
        return null;
    L31:
        if (this.f15942d.remove(r12.a(), r12) == false) goto L41;
        b(r12);
        return r12;
    L41:
        return null;
    L18:
        r7 = r11.next();
        if (r11.hasNext() == false) goto L27;
        long r8 = ((com.obric.agent.trace.toolmetrics.a) ZeusTransformUtils.preCheckCast(r7, com.obric.agent.trace.toolmetrics.a.class, "com.obric.aiagent.plugin")).b();
    L22:
        Object r9 = r11.next();
        long r13 = ((com.obric.agent.trace.toolmetrics.a) ZeusTransformUtils.preCheckCast(r9, com.obric.agent.trace.toolmetrics.a.class, "com.obric.aiagent.plugin")).b();
        if (r8 <= r13) goto L26;
        r7 = r9;
        r8 = r13;
    L26:
        if (r11.hasNext() == true) goto L22;
    L5:
        r1 = null;
        goto L6
    }

    public final com.obric.agent.trace.toolmetrics.a a(String r2) {
        d.h.b.o.e(r2, "traceId");
        return (com.obric.agent.trace.toolmetrics.a) ZeusTransformUtils.preCheckCast(this.f15942d.get(r2), com.obric.agent.trace.toolmetrics.a.class, "com.obric.aiagent.plugin");
    }

    public final com.obric.agent.trace.toolmetrics.a b(String r3) {
        d.h.b.o.e(r3, "messageId");
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.f15943e.get(r3), String.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return (com.obric.agent.trace.toolmetrics.a) ZeusTransformUtils.preCheckCast(this.f15942d.get(r4), com.obric.agent.trace.toolmetrics.a.class, "com.obric.aiagent.plugin");
    }

    public final void a(com.obric.agent.trace.toolmetrics.a r3, String r4) {
        d.h.b.o.e(r3, "state");
        if (r4 != null) goto L5;
        return;
    L5:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
        r4 = null;
    L8:
        if (r4 == null) goto L12;
        ((Map) ZeusTransformUtils.preCheckCast(this.f15943e, Map.class, "com.obric.aiagent.plugin")).put(r4, r3.a());
        return;
    }

    public final boolean a(String r2, com.obric.agent.trace.toolmetrics.a r3) {
        d.h.b.o.e(r2, "traceId");
        d.h.b.o.e(r3, "state");
        if (this.f15942d.remove(r2, r3) == true) goto L6;
        return false;
    L6:
        b(r3);
        return true;
    }

    public final List<com.obric.agent.trace.toolmetrics.a> a() {
        Collection<com.obric.agent.trace.toolmetrics.a> r2 = this.f15942d.values();
        d.h.b.o.c(r2, "<get-values>(...)");
        return d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin"));
    }

    public final void a(String r4, long r5) {
        d.h.b.o.e(r4, "traceId");
        Object r0 = this.f;
        monitor-enter(r0);
        Long r6 = Long.valueOf(r5);     // Catch: Throwable -> L16
        ((Map) ZeusTransformUtils.preCheckCast(this.g, Map.class, "com.obric.aiagent.plugin")).put(r4, r6);     // Catch: Throwable -> L16
    L6:
        if (this.g.size() <= this.f15941c) goto L13;
        Set<Map.Entry<String, Long>> r7 = this.g.entrySet();     // Catch: Throwable -> L16
        d.h.b.o.c(r7, "<get-entries>(...)");     // Catch: Throwable -> L16
        Map.Entry r8 = (Map.Entry) ZeusTransformUtils.preCheckCast(d.a.p.f((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r8 == null) goto L13;
        String r9 = (String) ZeusTransformUtils.preCheckCast(r8.getKey(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r9 == null) goto L13;
        this.g.remove(r9);     // Catch: Throwable -> L16
    L13:
        d.x r3 = d.x.f38692a;     // Catch: Throwable -> L16
        monitor-exit(r0);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    public final boolean c(String r2) {
        d.h.b.o.e(r2, "traceId");
        Object r0 = this.f;
        monitor-enter(r0);
        boolean r1 = this.g.containsKey(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private final void b(com.obric.agent.trace.toolmetrics.a r4) {
        k r0 = r4.e();
        if (r0 == null) goto L13;
        String r1 = r0.c();
        if (r1 != null) goto L7;
        return;
    L7:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L15;
        this.f15943e.remove(r1, r4.a());
        return;
    L15:
        return;
    }
}
