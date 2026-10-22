package com.obric.agent.trace.toolmetrics;

import com.obric.funcall_api.bean.AppActionRequest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: OmniClientNetworkDeliveryTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f15887a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f15888b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LinkedHashMap<Long, f> f15889c = null;

    private static final boolean c(long r2) {
        if (r2 < 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX INFO: renamed from: lambda$a0Uaw-DsCKvNwTfwUnVC3OeWEuI, reason: not valid java name */
    public static /* synthetic */ long m110lambda$a0UawDsCKvNwTfwUnVC3OeWEuI(AppActionRequest r2) {
        return a(r2);
    }

    /* JADX INFO: renamed from: lambda$oFx0za-8vHOFz5AhicWMlWFThsg, reason: not valid java name */
    public static /* synthetic */ boolean m111lambda$oFx0za8vHOFz5AhicWMlWFThsg(long r0) {
        return c(r0);
    }

    private g() {
    }

    static {
        f15887a = new g();
        f15888b = new Object();
        f15889c = new LinkedHashMap(256, 0.75f, true);
    }

    public final void a(long r6, f r8) {
        d.h.b.o.e(r8, "channel");
        IOmniClientToolTraceService r5 = IOmniClientToolTraceService.Companion.a();
        if (r5 == null) goto L5;
        z r0 = r5.findByMessageId(String.valueOf(r6));
    L6:
        if (r5 == null) goto L23;
        if (r0 == null) goto L28;
        Object r1 = f15888b;
        monitor-enter(r1);
    L24:
        LinkedHashMap<Long, f> r2 = f15889c;     // Catch: Throwable -> L20
        if (r2.size() < 256) goto L16;
        Iterator<Map.Entry<Long, f>> r3 = r2.entrySet().iterator();     // Catch: Throwable -> L20
        if (r3.hasNext() == false) goto L16;
        r3.next();     // Catch: Throwable -> L20
        r3.remove();     // Catch: Throwable -> L20
    L16:
        Long r7 = Long.valueOf(r6);     // Catch: Throwable -> L20
        ((Map) ZeusTransformUtils.preCheckCast(r2, Map.class, "com.obric.aiagent.plugin")).put(r7, r8);     // Catch: Throwable -> L20
        d.x r9 = d.x.f38692a;     // Catch: Throwable -> L20
        monitor-exit(r1);
        r5.markProgress(r0, r8.b());
        return;
    L20:
        th = move-exception;
        throw th;
    L28:
        return;
    L23:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void a(List<AppActionRequest> r8, f r9, m r10, u r11) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "requests");
        d.h.b.o.e(r9, "channel");
        d.h.b.o.e(r11, "fragment");
        Iterator r12 = d.n.m.j(d.n.m.a(d.n.m.d(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin")), $$Lambda$g$a0UawDsCKvNwTfwUnVC3OeWEuI.INSTANCE), $$Lambda$g$oFx0za8vHOFz5AhicWMlWFThsg.INSTANCE)).a();
    L4:
        if (r12.hasNext() == false) goto L6;
        long r2 = ((Number) ZeusTransformUtils.preCheckCast(r12.next(), Number.class, "com.obric.aiagent.plugin")).longValue();
        f15887a.a(r2, r9, r10, r11);
        goto L4
    }

    private static final long a(AppActionRequest r2) {
        d.h.b.o.e(r2, "it");
        return r2.getMessageId();
    }

    public final boolean a(long r2) {
        Object r1 = f15888b;
        monitor-enter(r1);
        boolean r3 = f15889c.containsKey(Long.valueOf(r2));     // Catch: Throwable -> L7
        monitor-exit(r1);
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b(long r2) {
        Object r1 = f15888b;
        monitor-enter(r1);
        f r3 = (f) ZeusTransformUtils.preCheckCast(f15889c.remove(Long.valueOf(r2)), f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final void a(long r11, f r13, m r14, u r15) {
        Object r0 = f15888b;
        monitor-enter(r0);
        f r1 = (f) ZeusTransformUtils.preCheckCast(f15889c.get(Long.valueOf(r11)), f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        monitor-exit(r0);
        if (r1 == r13) goto L8;
        return;
    L8:
        IOmniClientToolTraceService r2 = IOmniClientToolTraceService.Companion.a();
        if (r2 == null) goto L11;
        z r3 = r2.findByMessageId(String.valueOf(r11));
    L12:
        if (r2 == null) goto L15;
        if (r3 == null) goto L15;
        r2.markProgress(r3, r13.c());
        r2.append(r3, new n(null, null, null, r14, r15, 7, null));
        r2.finish(r3);
    L15:
        b(r11);
        return;
    L11:
        r3 = null;
    L17:
        th = move-exception;
        throw th;
    }
}
