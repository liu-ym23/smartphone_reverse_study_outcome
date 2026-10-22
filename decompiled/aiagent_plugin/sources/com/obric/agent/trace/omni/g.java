package com.obric.agent.trace.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: OmniEventStore.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15631a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, f> f15632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<String, Long> f15633c;

    /* JADX INFO: compiled from: OmniEventStore.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f15631a = new a(null);
    }

    public static /* synthetic */ f lambda$TYRKOJzuiXW2m2te36ZXjodneKs(d.h.a.b r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ f lambda$hbWWVBmf5xUxXV2PYX6mP0mcA6M(g r0, String r1) {
        return a(r0, r1);
    }

    public g() {
        this.f15632b = new ConcurrentHashMap();
        this.f15633c = new ConcurrentHashMap();
    }

    public final f a(String r3) {
        d.h.b.o.e(r3, "bucketKey");
        b(r3);
        ConcurrentHashMap<String, f> r0 = this.f15632b;
        final d.h.a.b r1 = new $$Lambda$g$hbWWVBmf5xUxXV2PYX6mP0mcA6M(this);
        f r2 = r0.computeIfAbsent(r3, new $$Lambda$g$TYRKOJzuiXW2m2te36ZXjodneKs(r1));
        d.h.b.o.c(r2, "computeIfAbsent(...)");
        return (f) ZeusTransformUtils.preCheckCast(r2, f.class, "com.obric.aiagent.plugin");
    }

    private static final f a(d.h.a.b r2, Object r3) {
        return (f) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), f.class, "com.obric.aiagent.plugin");
    }

    private static final f a(g r2, String r3) {
        d.h.b.o.e(r3, "it");
        ((Map) ZeusTransformUtils.preCheckCast(r2.f15633c, Map.class, "com.obric.aiagent.plugin")).put(r3, Long.valueOf(System.currentTimeMillis()));
        return new f(null, null, 3, null);
    }

    public final f b(String r7) {
        d.h.b.o.e(r7, "bucketKey");
        f r0 = (f) ZeusTransformUtils.preCheckCast(this.f15632b.get(r7), f.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L12;
        long r3 = System.currentTimeMillis();
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(this.f15633c.get(r7), Long.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L7;
        long r2 = r1.longValue();
    L9:
        if ((r3 - r2) <= 43200000) goto L12;
        this.f15633c.remove(r7);
        this.f15632b.remove(r7);
        return null;
    L7:
        r2 = 0;
    L12:
        return r0;
    }

    public final void a(String r3, f r4, long r5) {
        d.h.b.o.e(r3, "bucketKey");
        d.h.b.o.e(r4, "bucket");
        Long r6 = Long.valueOf(r5);
        ((Map) ZeusTransformUtils.preCheckCast(this.f15633c, Map.class, "com.obric.aiagent.plugin")).put(r3, r6);
        ((Map) ZeusTransformUtils.preCheckCast(this.f15632b, Map.class, "com.obric.aiagent.plugin")).put(r3, r4);
    }

    public final Long c(String r2) {
        d.h.b.o.e(r2, "bucketKey");
        return (Long) ZeusTransformUtils.preCheckCast(this.f15633c.get(r2), Long.class, "com.obric.aiagent.plugin");
    }

    public final f d(String r2) {
        d.h.b.o.e(r2, "bucketKey");
        this.f15633c.remove(r2);
        return (f) ZeusTransformUtils.preCheckCast(this.f15632b.remove(r2), f.class, "com.obric.aiagent.plugin");
    }
}
