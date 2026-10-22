package com.obric.aiagent.skill.manager.impl;

import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SkillPerformanceTracking.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final dy f19797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final hd f19798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f19800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19801e;
    private final long f;
    private final boolean g;
    private final AtomicBoolean h;

    public ea(dy r2, hd r3, String r4, int r5, String r6, long r7, boolean r9) {
        d.h.b.o.e(r2, "operation");
        d.h.b.o.e(r3, "reporter");
        d.h.b.o.e(r4, "traceId");
        this.f19797a = r2;
        this.f19798b = r3;
        this.f19799c = r4;
        this.f19800d = r5;
        this.f19801e = r6;
        this.f = r7;
        this.g = r9;
        this.h = new AtomicBoolean(false);
    }

    public /* synthetic */ ea(dy r11, hd r12, String r13, int r14, String r15, long r16, boolean r18, int r19, d.h.b.h r20) {
        if ((r19 & 4) == 0) goto L5;
        String r4 = eb.a();
    L7:
        if ((r19 & 8) == 0) goto L9;
        int r5 = 1;
    L11:
        if ((r19 & 16) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r19 & 32) == 0) goto L17;
        long r7 = SystemClock.elapsedRealtime();
    L19:
        if ((r19 & 64) == 0) goto L21;
        boolean r9 = true;
    L22:
        this(r11, r12, r4, r5, r6, r7, r9);
        return;
    L21:
        r9 = r18;
        goto L22
    L17:
        r7 = r16;
        goto L19
    L13:
        r6 = r15;
        goto L15
    L9:
        r5 = r14;
        goto L11
    L5:
        r4 = r13;
        goto L7
    }

    public final String a() {
        return this.f19799c;
    }

    public static /* synthetic */ void a(ea r12, dz r13, com.obric.aiagent.skill.manager.api.e r14, String r15, Integer r16, String r17, String r18, dw r19, String r20, Boolean r21, Boolean r22, Map r23, int r24, Object r25) {
        Map<String, ? extends Object> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r23, Map.class, "com.obric.aiagent.plugin");
        Boolean r3 = null;
        if ((r24 & 2) == 0) goto L5;
        com.obric.aiagent.skill.manager.api.e r2 = null;
    L7:
        if ((r24 & 4) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r24 & 8) == 0) goto L13;
        Integer r5 = null;
    L15:
        if ((r24 & 16) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r24 & 32) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r24 & 64) == 0) goto L25;
        dw r8 = null;
    L27:
        if ((r24 & 128) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r24 & 256) == 0) goto L33;
        Boolean r10 = null;
    L35:
        if ((r24 & 512) != 0) goto L39;
        r3 = r22;
    L39:
        if ((r24 & 1024) == 0) goto L41;
        r1 = d.a.ao.b();
    L41:
        r12.a(r13, r2, r4, r5, r6, r7, r8, r9, r10, r3, r1);
        return;
    L33:
        r10 = r21;
        goto L35
    L29:
        r9 = r20;
        goto L31
    L25:
        r8 = r19;
        goto L27
    L21:
        r7 = r18;
        goto L23
    L17:
        r6 = r17;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r4 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final void a(dz r21, com.obric.aiagent.skill.manager.api.e r22, String r23, Integer r24, String r25, String r26, dw r27, String r28, Boolean r29, Boolean r30, Map<String, ? extends Object> r31) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r31, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r21, "result");
        d.h.b.o.e(r1, "dimensions");
        if (this.g == true) goto L6;
        return;
    L6:
        if (this.h.compareAndSet(false, true) == true) goto L8;
        return;
    L8:
        this.f19798b.a(new dx(this.f19797a, r21, eb.a(this.f), this.f19799c, this.f19800d, r23, r24, r25, r26, this.f19801e, r27, r28, r29, r30, r1).a(r22));
    }
}
