package com.obric.aiagent.skill.manager.impl;

import android.os.SystemClock;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SkillScanPerformanceState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class el {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Gson f19825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f19826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.f f19827c;

    /* JADX INFO: renamed from: lambda$FtLHg6QTAW59s-ab3uRDrrvODbk, reason: not valid java name */
    public static /* synthetic */ Keva m282lambda$FtLHg6QTAW59sab3uRDrrvODbk() {
        return b();
    }

    public el() {
        this.f19825a = new Gson();
        this.f19826b = new Object();
        this.f19827c = d.g.a($$Lambda$el$FtLHg6QTAW59sab3uRDrrvODbk.INSTANCE);
    }

    private final Keva a() {
        return (Keva) ZeusTransformUtils.preCheckCast(this.f19827c.b(), Keva.class, "com.obric.aiagent.plugin");
    }

    private static final Keva b() {
        return cx.f19710a.a();
    }

    public final ej a(gj r25, String r26) {
        d.h.b.o.e(r25, "record");
        Object r2 = this.f19826b;
        monitor-enter(r2);
        String r5 = r25.a();     // Catch: Throwable -> L16
        int r6 = r25.b();     // Catch: Throwable -> L16
        long r7 = r25.c();     // Catch: Throwable -> L16
        String r12 = eb.a();     // Catch: Throwable -> L16
        if (r26 == null) goto L12;
        String r1 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L16
        if (r1 == null) goto L12;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L12;
        String r13 = r1;
    L13:
        ej r3 = new ej(0, r5, r6, r7, null, 0, r12, r13, null, 0, 0, 0, 0, false, 16177, null);     // Catch: Throwable -> L16
        a(r3);     // Catch: Throwable -> L16
        monitor-exit(r2);
        return r3;
    L12:
        r13 = null;
    L16:
        th = move-exception;
        throw th;
    }

    public final ei a(gj r27, dy r28) {
        d.h.b.o.e(r27, "record");
        d.h.b.o.e(r28, "operation");
        Object r1 = this.f19826b;
        monitor-enter(r1);
        ej r2 = a(r27);     // Catch: Throwable -> L11
        Integer r4 = (Integer) ZeusTransformUtils.preCheckCast(r2.h().get(r28.a()), Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (r4 == null) goto L7;
        int r5 = r4.intValue();     // Catch: Throwable -> L11
    L8:
        int r13 = r5 + 1;     // Catch: Throwable -> L11
        ej r3 = ej.a(r2, 0, null, 0, 0, null, 0, null, null, d.a.ao.a(r2.h(), d.s.a(r28.a(), Integer.valueOf(r13))), 0, 0, 0, 0, false, 16127, null);     // Catch: Throwable -> L11
        a(r3);     // Catch: Throwable -> L11
        ei r0 = new ei(r3, r13);     // Catch: Throwable -> L11
        monitor-exit(r1);
        return r0;
    L7:
        r5 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    public final ej b(gj r25, String r26) {
        d.h.b.o.e(r25, "record");
        d.h.b.o.e(r26, DBDefinition.TASK_ID);
        Object r2 = this.f19826b;
        monitor-enter(r2);
        ej r3 = a(r25);     // Catch: Throwable -> L11
        String r9 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r26, CharSequence.class, "com.obric.aiagent.plugin")).toString();     // Catch: Throwable -> L11
        if (d.h.b.o.a(r3.d(), r9) == true) goto L8;
        r3 = ej.a(r3, 0, null, 0, 0, r9, SystemClock.elapsedRealtime(), null, null, null, 0, 0, 0, 0, false, 463, null);     // Catch: Throwable -> L11
    L8:
        a(r3);     // Catch: Throwable -> L11
        monitor-exit(r2);
        return r3;
    L11:
        th = move-exception;
        throw th;
    }

    public final ej a(gj r26, String r27, long r28, int r30) {
        d.h.b.o.e(r26, "record");
        d.h.b.o.e(r27, DBDefinition.TASK_ID);
        Object r3 = this.f19826b;
        monitor-enter(r3);
        ej r4 = c(r26, r27);     // Catch: Throwable -> L13
        boolean r6 = true;
        int r15 = r4.i() + 1;     // Catch: Throwable -> L13
        long r19 = r4.k() + d.l.n.a(r28, 0);     // Catch: Throwable -> L13
        long r1 = Math.max(r4.l(), r28);     // Catch: Throwable -> L13
        if (r4.m() == false) goto L7;
    L10:
        ej r2 = ej.a(r4, 0, null, 0, 0, null, 0, null, null, null, r15, 0, r19, r1, r6, 1535, null);     // Catch: Throwable -> L13
        a(r2);     // Catch: Throwable -> L13
        monitor-exit(r3);
        return r2;
    L7:
        if (r15 >= r30) goto L10;
        r6 = false;
    L13:
        th = move-exception;
        throw th;
    }

    public final ej a(gj r26, String r27, long r28) {
        d.h.b.o.e(r26, "record");
        d.h.b.o.e(r27, DBDefinition.TASK_ID);
        Object r3 = this.f19826b;
        monitor-enter(r3);
        ej r4 = c(r26, r27);     // Catch: Throwable -> L7
        ej r1 = ej.a(r4, 0, null, 0, 0, null, 0, null, null, null, 0, r4.j() + 1, r4.k() + d.l.n.a(r28, 0), Math.max(r4.l(), r28), false, 9215, null);     // Catch: Throwable -> L7
        a(r1);     // Catch: Throwable -> L7
        monitor-exit(r3);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final void a(String r3) {
        d.h.b.o.e(r3, "slug");
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L10;
        return;
    L10:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L7
        el r2 = (el) ZeusTransformUtils.preCheckCast(this, el.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        r2.a().erase(r2.c(r3));     // Catch: Throwable -> L7
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        d.n.f(d.o.a(th));
    }

    private final ej a(gj r24) {
        ej r1 = b(r24.a());
        if (r1 == null) goto L11;
        if (r1.b() != r24.b()) goto L11;
        if (r1.c() != r24.c()) goto L13;
        return r1;
    L13:
        return ej.a(r1, 0, null, 0, r24.c(), "", 0, null, null, null, 0, 0, 0, 0, false, 455, null);
    L11:
        return new ej(0, r24.a(), r24.b(), r24.c(), null, 0, eb.a(), null, null, 0, 0, 0, 0, false, 16305, null);
    }

    private final ej c(gj r22, String r23) {
        ej r0 = a(r22);
        String r6 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (d.h.b.o.a(r0.d(), r6) == false) goto L6;
        return r0;
    L6:
        return ej.a(r0, 0, null, 0, 0, r6, SystemClock.elapsedRealtime(), null, null, null, 0, 0, 0, 0, false, 463, null);
    }

    private final ej b(String r5) {
        Object r1 = null;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L14
        el r4 = (el) ZeusTransformUtils.preCheckCast(this, el.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        String r6 = r4.a().getString(r4.c(r5), "");     // Catch: Throwable -> L14
        if (r6 != null) goto L6;
    L11:
        ej r7 = null;
    L12:
        Object r8 = d.n.f(r7);     // Catch: Throwable -> L14
    L17:
        if (d.n.b(r8) == true) goto L21;
        r1 = r8;
    L21:
        return (ej) ZeusTransformUtils.preCheckCast(r1, ej.class, "com.obric.aiagent.plugin");
    L6:
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L9;
        r6 = null;
    L9:
        if (r6 == null) goto L11;
        r7 = (ej) ZeusTransformUtils.preCheckCast(r4.f19825a.fromJson(r6, ej.class), ej.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
        goto L17
    }

    private final void a(ej r3) {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L4
        el r2 = (el) ZeusTransformUtils.preCheckCast(this, el.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
        r2.a().storeString(r2.c(r3.a()), r2.f19825a.toJson(r3));     // Catch: Throwable -> L4
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        d.n.f(d.o.a(th));
    }

    private final String c(String r2) {
        return "scan_performance_v1_" + r2;
    }
}
