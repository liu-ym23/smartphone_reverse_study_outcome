package com.obric.aiagent.skill.manager.impl;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SkillPerformanceTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final hd f19701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f19704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f19705e;
    private final LinkedHashMap<String, Object> f;
    private com.obric.aiagent.skill.manager.api.e g;
    private String h;
    private final String i;

    public ct(hd r2, String r3, String r4, long r5) {
        d.h.b.o.e(r2, "reporter");
        d.h.b.o.e(r3, "requestedSlug");
        this.f19701a = r2;
        this.f19702b = r3;
        this.f19703c = r4;
        this.f19704d = r5;
        this.f19705e = new AtomicBoolean(false);
        this.f = new LinkedHashMap();
        this.h = "input";
        this.i = eb.a();
    }

    public /* synthetic */ ct(hd r7, String r8, String r9, long r10, int r12, d.h.b.h r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = SystemClock.elapsedRealtime();
    L5:
        this(r7, r8, r9, r10);
    }

    public final void a(com.obric.aiagent.skill.manager.api.e r1) {
        if (r1 == null) goto L5;
        this.g = r1;
        return;
    }

    public final void a(String r2) {
        d.h.b.o.e(r2, "stage");
        this.h = r2;
    }

    public final void a(String r3, Object r4) {
        d.h.b.o.e(r3, "key");
        d.h.b.o.e(r4, "value");
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(r3, r4);
    }

    public final void a(Map<String, ? extends Object> r3) {
        Map<? extends String, ? extends Object> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "values");
        this.f.putAll(r4);
    }

    public final void a(String r3, long r4) {
        d.h.b.o.e(r3, "key");
        ((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin")).put(r3, Long.valueOf(eb.a(r4)));
    }

    public static /* synthetic */ void a(ct r1, dz r2, String r3, com.obric.aiagent.skill.manager.api.u.a r4, dw r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = r1.h;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = null;
    L9:
        if ((r6 & 8) == 0) goto L13;
        if (r4 == null) goto L12;
        r5 = eb.a(r4);
        goto L13
    L12:
        r5 = null;
    L13:
        r1.a(r2, r3, r4, r5);
    }

    public final void a(dz r17, String r18, com.obric.aiagent.skill.manager.api.u.a r19, dw r20) {
        d.h.b.o.e(r17, "result");
        if (this.f19705e.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        com.obric.aiagent.skill.manager.api.e r1 = this.g;
        hd r15 = this.f19701a;
        long r4 = eb.a(this.f19704d);
        String r6 = this.i;
        String r7 = this.f19703c;
        if (r1 == null) goto L9;
        String r2 = r1.a();
        if (r2 == null) goto L9;
    L10:
        String r8 = r2;
        if (r1 == null) goto L13;
        Integer r9 = Integer.valueOf(r1.j());
    L14:
        if (r1 == null) goto L18;
        com.obric.aiagent.skill.manager.api.aq r3 = r1.g();
        if (r3 == null) goto L18;
        String r10 = r3.a();
    L19:
        if (r19 == null) goto L21;
        Boolean r13 = Boolean.valueOf(r19.b());
    L22:
        r15.a(new cs(r17, r4, r6, r7, r8, r9, r10, r20, r18, r13, d.a.ao.d((Map) ZeusTransformUtils.preCheckCast(this.f, Map.class, "com.obric.aiagent.plugin"))));
        return;
    L21:
        r13 = null;
    L18:
        r10 = null;
        goto L19
    L13:
        r9 = null;
    L9:
        r2 = this.f19702b;
        goto L10
    }
}
