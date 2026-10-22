package com.obric.autogui.agents.scripted.impl;

import android.content.Context;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.device.AODeviceInfo;
import com.obric.autogui.resourcemanage.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: ScriptResourceUpdateExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    private static final String TAG = "Script-ScriptResourceDownloader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f27095a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.a<x> f27096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.a<x> f27097c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ScheduledExecutorService f27098d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d.h.a.b<com.obric.autogui.resourcemanage.k, Boolean> f27099e;
    private final d.h.a.b<Context, x> f;
    private final Object g;
    private final AtomicLong h;
    private b i;
    private final d.f j;
    private final d.f k;

    /* JADX INFO: compiled from: ScriptResourceUpdateExecutor.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ScriptResourceUpdateExecutor.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f27100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.autogui.resourcemanage.k f27101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final j f27102c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f27100a, r6.f27100a) == true) goto L12;
            return false;
        L12:
            if (this.f27101b == r6.f27101b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f27102c, r6.f27102c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f27100a.hashCode() * 31) + this.f27101b.hashCode()) * 31) + this.f27102c.hashCode();
        }

        public String toString() {
            return "RoundState(context=" + this.f27100a + ", scene=" + this.f27101b + ", gate=" + this.f27102c + ')';
        }

        public b(Context r3, com.obric.autogui.resourcemanage.k r4, j r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "context");
            d.h.b.o.e(r4, DBHelper.BATTERY_COL_SCENE);
            d.h.b.o.e(r5, "gate");
            this.f27100a = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            this.f27101b = r4;
            this.f27102c = r5;
        }

        public final Context getContext() {
            return this.f27100a;
        }

        public final com.obric.autogui.resourcemanage.k a() {
            return this.f27101b;
        }

        public final j b() {
            return this.f27102c;
        }
    }

    static {
        f27095a = new a(null);
    }

    private static final com.obric.autogui.resourcemanage.j a(com.obric.autogui.resourcemanage.j r1, com.obric.autogui.resourcemanage.v r2) {
        d.h.b.o.e(r2, "it");
        return r1;
    }

    public static /* synthetic */ x lambda$1nftbKgiTbjuWnzBPfM0iszN6Xc(com.obric.autogui.resourcemanage.q r0, Context r1, com.obric.autogui.resourcemanage.x r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$3lzz7KvtgzU3lahOy1kccDG_AhQ(com.obric.autogui.resourcemanage.q r0, Context r1, com.obric.autogui.resourcemanage.x r2) {
        return b(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$57DC2U5q1ZyioO3bzn-2h5Oq174, reason: not valid java name */
    public static /* synthetic */ com.obric.autogui.resourcemanage.j m736lambda$57DC2U5q1ZyioO3bzn2h5Oq174(com.obric.autogui.resourcemanage.j r0, com.obric.autogui.resourcemanage.v r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$7gkB-r-QBp7f9ZKfAkCXMMeFimA, reason: not valid java name */
    public static /* synthetic */ x m737lambda$7gkBrQBp7f9ZKfAkCXMMeFimA(d.h.a.a r0, com.obric.autogui.resourcemanage.o r1, File r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$KXagB0olcxjUruAx4yxO4E6xpVI(b r0, com.obric.autogui.agents.scripted.c.d r1, v r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$Uqx1p_w6GCJ7Lt3-SupByYMfALI, reason: not valid java name */
    public static /* synthetic */ x m738lambda$Uqx1p_w6GCJ7Lt3SupByYMfALI(com.obric.autogui.resourcemanage.q r0, Context r1, com.obric.autogui.resourcemanage.k r2, h r3, d.h.a.b r4) {
        return a(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ com.obric.autogui.resourcemanage.j lambda$WsaWlyg4V7vCgRoBf9bRCSOHEU0(v r0) {
        return b(r0);
    }

    /* JADX INFO: renamed from: lambda$XF4URfWPCSNFmJQ9FhGJO-8txt4, reason: not valid java name */
    public static /* synthetic */ x m739lambda$XF4URfWPCSNFmJQ9FhGJO8txt4(v r0, b r1, com.obric.autogui.resourcemanage.x r2) {
        return b(r0, r1, r2);
    }

    public static /* synthetic */ x lambda$jMNfN57Ov17n_QVrJHEMyrkN8kw(v r0, b r1, com.obric.autogui.resourcemanage.x r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ com.obric.autogui.resourcemanage.m lambda$vnV76R4rERaZyKUK2CyDCCYurBA() {
        return g();
    }

    /* JADX INFO: renamed from: lambda$wH0iiDLljLC-9crXLH1I6jSImnw, reason: not valid java name */
    public static /* synthetic */ com.obric.autogui.resourcemanage.j m740lambda$wH0iiDLljLC9crXLH1I6jSImnw(v r0) {
        return a(r0);
    }

    /* JADX INFO: renamed from: lambda$yL6DvORtV6Nsh--Wganrg5vzjME, reason: not valid java name */
    public static /* synthetic */ x m741lambda$yL6DvORtV6NshWganrg5vzjME(com.obric.autogui.resourcemanage.q r0, Context r1, com.obric.autogui.resourcemanage.k r2, h r3, d.h.a.b r4) {
        return b(r0, r1, r2, r3, r4);
    }

    public v(d.h.a.a<x> r3, d.h.a.a<x> r4, ScheduledExecutorService r5, d.h.a.b<? super com.obric.autogui.resourcemanage.k, Boolean> r6, d.h.a.b<? super Context, x> r7) {
        d.h.a.a<x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        ScheduledExecutorService r10 = (ScheduledExecutorService) ZeusTransformUtils.wrapperContextForParams(r5, ScheduledExecutorService.class, "com.obric.aiagent.plugin");
        d.h.a.b<com.obric.autogui.resourcemanage.k, Boolean> r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<Context, x> r12 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "onEngineResourceUpdated");
        d.h.b.o.e(r9, "onScriptResourceUpdated");
        d.h.b.o.e(r10, "scheduledExecutor");
        d.h.b.o.e(r11, "isSceneEnabled");
        d.h.b.o.e(r12, "onRoundComplete");
        this.f27096b = r8;
        this.f27097c = r9;
        this.f27098d = r10;
        this.f27099e = r11;
        this.f = r12;
        this.g = new Object();
        this.h = new AtomicLong(0);
        this.j = d.g.a(new $$Lambda$v$wH0iiDLljLC9crXLH1I6jSImnw(this));
        this.k = d.g.a(new $$Lambda$v$WsaWlyg4V7vCgRoBf9bRCSOHEU0(this));
    }

    private static final com.obric.autogui.resourcemanage.j a(v r0) {
        return r0.f();
    }

    private final com.obric.autogui.resourcemanage.j c() {
        return (com.obric.autogui.resourcemanage.j) ZeusTransformUtils.preCheckCast(this.j.b(), com.obric.autogui.resourcemanage.j.class, "com.obric.aiagent.plugin");
    }

    private static final com.obric.autogui.resourcemanage.j b(v r0) {
        return r0.f();
    }

    private final com.obric.autogui.resourcemanage.j d() {
        return (com.obric.autogui.resourcemanage.j) ZeusTransformUtils.preCheckCast(this.k.b(), com.obric.autogui.resourcemanage.j.class, "com.obric.aiagent.plugin");
    }

    public final void a(Context r26, final com.obric.autogui.resourcemanage.k r27, d.h.a.a<x> r28) {
        final Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r26, Context.class, "com.obric.aiagent.plugin");
        d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r28, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "context");
        d.h.b.o.e(r27, DBHelper.BATTERY_COL_SCENE);
        d.h.b.o.e(r0, "onRoundRegistered");
        final b r12 = a(r11, r27);
        r0.invoke();
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f27099e.invoke(r27), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L6;
        b(r12, com.obric.autogui.resourcemanage.x.f30692a);
        return;
    L6:
        final com.obric.autogui.agents.scripted.c.d r2 = com.obric.autogui.agents.scripted.c.b.f26918a.h();
        final d.h.a.b r13 = new $$Lambda$v$jMNfN57Ov17n_QVrJHEMyrkN8kw(this, r12);
        final d.h.a.b r14 = new $$Lambda$v$XF4URfWPCSNFmJQ9FhGJO8txt4(this, r12);
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L9
        v r3 = (v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        Object r4 = d.n.f(u.a(AODeviceInfo.INSTANCE.getDeviceInfo()));     // Catch: Throwable -> L9
    L11:
        Throwable r5 = d.n.c(r4);
        if (r5 == null) goto L15;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "Failed to get device ids for resource round", r5);
    L15:
        if (d.n.b(r4) == false) goto L17;
        r4 = null;
    L17:
        final h r16 = (h) ZeusTransformUtils.preCheckCast(r4, h.class, "com.obric.aiagent.plugin");
        if (r16 != null) goto L107;
        r13.invoke(com.obric.autogui.resourcemanage.x.f30693b);
        r14.invoke(com.obric.autogui.resourcemanage.x.f30693b);
        return;
    L107:
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L23
        v r7 = (v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
        Object r8 = d.n.f(r7.a("com.obric.script_engine", r16.b(), "a16274c24b53998c33b1a2d4ada77a00", "8e9cd56f0ab8ae65558e4ac7dc45c16e", r7.c(), r2.f(), r7.f27096b));     // Catch: Throwable -> L23
    L25:
        Throwable r9 = d.n.c(r8);
        if (r9 == null) goto L29;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "Failed to create engine resource downloader", r9);
    L29:
        if (d.n.b(r8) == false) goto L31;
        r8 = null;
    L31:
        final com.obric.autogui.resourcemanage.q r10 = (com.obric.autogui.resourcemanage.q) ZeusTransformUtils.preCheckCast(r8, com.obric.autogui.resourcemanage.q.class, "com.obric.aiagent.plugin");
        d.n.a r15 = d.n.f38560a;     // Catch: Throwable -> L34
        v r17 = (v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L34
        Object r18 = d.n.f(r17.a("com.obric.ability.script", r16.b(), "24623d25d9f2012388913ea24cdc668b", "6b814c7dd76a9c86d3b76ddba393f02c", r17.d(), r2.f(), r17.f27097c));     // Catch: Throwable -> L34
    L36:
        Throwable r19 = d.n.c(r18);
        if (r19 == null) goto L40;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "Failed to create script resource downloader", r19);
    L40:
        if (d.n.b(r18) == false) goto L42;
        r18 = null;
    L42:
        final com.obric.autogui.resourcemanage.q r20 = (com.obric.autogui.resourcemanage.q) ZeusTransformUtils.preCheckCast(r18, com.obric.autogui.resourcemanage.q.class, "com.obric.aiagent.plugin");
        d.h.a.b[] r21 = new d.h.a.b[2];
        if (r10 == null) goto L45;
        d.h.a.b r22 = new $$Lambda$v$1nftbKgiTbjuWnzBPfM0iszN6Xc(r10, r11);
    L46:
        r21[0] = r22;
        if (r20 == null) goto L49;
        d.h.a.b r23 = new $$Lambda$v$3lzz7KvtgzU3lahOy1kccDG_AhQ(r20, r11);
    L50:
        r21[1] = r23;
        List<? extends d.h.a.b<? super com.obric.autogui.resourcemanage.x, x>> r24 = d.a.p.e(r21);
        if (r12.b().a(r24) == true) goto L54;
        return;
    L54:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f27099e.invoke(r27), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L111;
        a(r12, com.obric.autogui.resourcemanage.x.f30692a);
        return;
    L111:
        d.n.a r25 = d.n.f38560a;     // Catch: Throwable -> L59
        final v r29 = (v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L59
        Object r30 = d.n.f(r29.f27098d.schedule(new $$Lambda$v$KXagB0olcxjUruAx4yxO4E6xpVI(r12, r2, r29), r2.e(), TimeUnit.MILLISECONDS));     // Catch: Throwable -> L59
    L61:
        Throwable r31 = d.n.c(r30);
        if (r31 == null) goto L65;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "Failed to schedule resource round watchdog", r31);
    L65:
        if (d.n.b(r30) == false) goto L67;
        Object r32 = null;
    L68:
        ScheduledFuture<?> r33 = (ScheduledFuture) ZeusTransformUtils.preCheckCast(r32, ScheduledFuture.class, "com.obric.aiagent.plugin");
        if (r33 == null) goto L71;
        r12.b().a(r33);
    L71:
        if (r10 != null) goto L105;
        r13.invoke(com.obric.autogui.resourcemanage.x.f30693b);
        com.obric.autogui.resourcemanage.q r110 = r20;
        Context r210 = r11;
    L86:
        if (r110 != null) goto L89;
        r14.invoke(com.obric.autogui.resourcemanage.x.f30693b);
        return;
    L89:
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f27099e.invoke(r27), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == true) goto L113;
        a(r12, com.obric.autogui.resourcemanage.x.f30692a);
        return;
    L113:
        d.n.a r34 = d.n.f38560a;     // Catch: Throwable -> L94
        v r35 = (v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L94
        final com.obric.autogui.resourcemanage.q r36 = r110;
        final Context r37 = r210;
        Object r38 = d.n.f(Boolean.valueOf(r12.b().a(new $$Lambda$v$yL6DvORtV6NshWganrg5vzjME(r36, r37, r27, r16, r14))));     // Catch: Throwable -> L94
    L96:
        Throwable r39 = d.n.c(r38);
        if (r39 == null) goto L99;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "Script resource round failed synchronously", r39);
        r14.invoke(com.obric.autogui.resourcemanage.x.f30693b);
    L99:
        d.n.g(r38);
        return;
    L94:
        th = move-exception;
        d.n.a r40 = d.n.f38560a;
        r38 = d.n.f(d.o.a(th));
        goto L96
    L105:
        d.n.a r41 = d.n.f38560a;     // Catch: Throwable -> L79
        v r42 = (v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L79
        j r43 = r12.b();     // Catch: Throwable -> L79
        r210 = r11;
        r110 = r20;
        Object r44 = d.n.f(Boolean.valueOf(r43.a(new $$Lambda$v$Uqx1p_w6GCJ7Lt3SupByYMfALI(r10, r11, r27, r16, r13))));     // Catch: Throwable -> L77
    L82:
        Throwable r45 = d.n.c(r44);
        if (r45 == null) goto L85;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "Engine resource round failed synchronously", r45);
        r13.invoke(com.obric.autogui.resourcemanage.x.f30693b);
    L85:
        d.n.g(r44);
    L77:
        th = th;
    L81:
        d.n.a r46 = d.n.f38560a;
        r44 = d.n.f(d.o.a(th));
    L79:
        th = th;
        r110 = r20;
        r210 = r11;
        goto L81
    L67:
        r32 = r30;
    L59:
        th = move-exception;
        d.n.a r47 = d.n.f38560a;
        r30 = d.n.f(d.o.a(th));
        goto L61
    L49:
        r23 = null;
        goto L50
    L45:
        r22 = null;
    L34:
        th = move-exception;
        d.n.a r48 = d.n.f38560a;
        r18 = d.n.f(d.o.a(th));
    L23:
        th = move-exception;
        d.n.a r49 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
    L9:
        th = move-exception;
        d.n.a r50 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
        goto L11
    }

    private static final x a(v r2, b r3, com.obric.autogui.resourcemanage.x r4) {
        d.h.b.o.e(r4, "result");
        r2.a(r3, 0, "com.obric.script_engine", r4);
        return x.f38692a;
    }

    private static final x b(v r2, b r3, com.obric.autogui.resourcemanage.x r4) {
        d.h.b.o.e(r4, "result");
        r2.a(r3, 1, "com.obric.ability.script", r4);
        return x.f38692a;
    }

    private static final x a(com.obric.autogui.resourcemanage.q r2, Context r3, com.obric.autogui.resourcemanage.x r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "result");
        r2.a(r5, r4);
        return x.f38692a;
    }

    private static final x b(com.obric.autogui.resourcemanage.q r2, Context r3, com.obric.autogui.resourcemanage.x r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "result");
        r2.a(r5, r4);
        return x.f38692a;
    }

    private static final void a(b r3, com.obric.autogui.agents.scripted.c.d r4, v r5) {
        com.obric.autogui.agents.scripted.c.c.a(TAG, "Resource round generation=" + r3.b().a() + " timed out after " + r4.e() + " ms");
        r5.a(r3, com.obric.autogui.resourcemanage.x.f30693b);
    }

    private static final x a(com.obric.autogui.resourcemanage.q r2, Context r3, com.obric.autogui.resourcemanage.k r4, h r5, d.h.a.b r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super com.obric.autogui.resourcemanage.x, x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        r2.a(r7, r4, r5.a(), r8);
        return x.f38692a;
    }

    private static final x b(com.obric.autogui.resourcemanage.q r2, Context r3, com.obric.autogui.resourcemanage.k r4, h r5, d.h.a.b r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d.h.a.b<? super com.obric.autogui.resourcemanage.x, x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        r2.a(r7, r4, r5.a(), r8);
        return x.f38692a;
    }

    public final void a() {
        b r0 = e();
        if (r0 == null) goto L6;
        a(r0, com.obric.autogui.resourcemanage.x.f30693b);
        return;
    }

    public final void b() {
        b r0 = e();
        if (r0 == null) goto L6;
        a(r0, com.obric.autogui.resourcemanage.x.f30695d);
        return;
    }

    private final b a(Context r6, com.obric.autogui.resourcemanage.k r7) {
        b r2 = new b((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"), r7, new j(this.h.incrementAndGet(), 2));
        Object r8 = this.g;
        monitor-enter(r8);
        b r9 = this.i;     // Catch: Throwable -> L9
        this.i = r2;     // Catch: Throwable -> L9
        monitor-exit(r8);
        if (r9 == null) goto L8;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "Replacing unfinished resource round generation=" + r9.b().a());
        a(r9, com.obric.autogui.resourcemanage.x.f30693b);
    L8:
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    private final b e() {
        Object r0 = this.g;
        monitor-enter(r0);
        b r1 = this.i;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private final void a(b r7, com.obric.autogui.resourcemanage.x r8) {
        List<d.h.a.b<com.obric.autogui.resourcemanage.x, x>> r0 = r7.b().b();
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r1.hasNext() == false) goto L16;
        d.h.a.b r2 = (d.h.a.b) ZeusTransformUtils.preCheckCast(r1.next(), d.h.a.b.class, "com.obric.aiagent.plugin");
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L11
        v r4 = (v) ZeusTransformUtils.preCheckCast(this, v.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        r2.invoke(r8);     // Catch: Throwable -> L11
        Object r5 = d.n.f(x.f38692a);     // Catch: Throwable -> L11
    L13:
        Throwable r6 = d.n.c(r5);
        if (r6 == null) goto L7;
        com.obric.autogui.agents.scripted.c.c.a(TAG, "Failed to abort resource round generation=" + r7.b().a(), r6);
    L11:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L13
    L16:
        b(r7, r8);
    }

    private final void b(b r3, com.obric.autogui.resourcemanage.x r4) {
        a(r3, 0, "com.obric.script_engine", r4);
        a(r3, 1, "com.obric.ability.script", r4);
    }

    private final void a(b r5, int r6, String r7, com.obric.autogui.resourcemanage.x r8) {
        i r9 = r5.b().a(r6);
        if (r9 != i.f27000a) goto L6;
        return;
    L6:
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L9;
        Loog.INSTANCE.d(TAG, "Resource update terminal. generation=" + r5.b().a() + ", pkg=" + r7 + ", scene=" + r5.a() + ", result=" + r8);
    L9:
        if (r9 != i.f27002c) goto L12;
        a(r5);
        return;
    }

    private final void a(b r3) {
        Object r0 = this.g;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.i != r3) goto L8;
        this.i = null;     // Catch: Throwable -> L13
        boolean r1 = true;
    L9:
        monitor-exit(r0);
        if (r1 == false) goto L18;
        this.f.invoke((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return;
    L18:
        return;
    L8:
        r1 = false;
        goto L9
    }

    private final com.obric.autogui.resourcemanage.q a(String r16, String r17, String r18, String r19, final com.obric.autogui.resourcemanage.j r20, int r21, d.h.a.a<x> r22) {
        final d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r22, d.h.a.a.class, "com.obric.aiagent.plugin");
        return ac.a(ac.f30597a, (com.obric.autogui.resourcemanage.u) ZeusTransformUtils.preCheckCast(new com.obric.autogui.resourcemanage.b(r16, r17), com.obric.autogui.resourcemanage.u.class, "com.obric.aiagent.plugin"), new com.obric.autogui.resourcemanage.p(r18, r19, 0, r21, 0, null, 0, 116, null), new $$Lambda$v$57DC2U5q1ZyioO3bzn2h5Oq174(r20), null, null, null, null, null, new $$Lambda$v$7gkBrQBp7f9ZKfAkCXMMeFimA(r0), null, 760, null);
    }

    private final com.obric.autogui.resourcemanage.j f() {
        com.obric.autogui.agents.scripted.c.d r11 = com.obric.autogui.agents.scripted.c.b.f26918a.h();
        return new com.obric.autogui.resourcemanage.j(null, r11.a(), r11.b(), false, false, 25, null).a($$Lambda$v$vnV76R4rERaZyKUK2CyDCCYurBA.INSTANCE);
    }

    private static final com.obric.autogui.resourcemanage.m g() {
        com.obric.autogui.agents.scripted.c.d r0 = com.obric.autogui.agents.scripted.c.b.f26918a.h();
        return new com.obric.autogui.resourcemanage.m(r0.a(), r0.b());
    }

    private static final x a(d.h.a.a r3, com.obric.autogui.resourcemanage.o r4, File r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "description");
        d.h.b.o.e(r5, "dir");
        if (AOSystemTools.INSTANCE.isDebugVersion() == false) goto L5;
        Loog.INSTANCE.d(TAG, "Resource updated: description=" + r4 + ", dir=" + r5);
    L5:
        r6.invoke();
        return x.f38692a;
    }
}
