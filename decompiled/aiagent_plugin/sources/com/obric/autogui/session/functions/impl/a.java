package com.obric.autogui.session.functions.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.SystemClock;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: AutoCancelHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "AutoCancel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0848a f31020a = null;
    private static final AtomicInteger i = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.session.functions.a f31021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f31022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d.h.a.b<d.c.d<? super x>, Object> f31023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ca f31024e;
    private Integer f;
    private PluginBroadcastReceiver g;
    private AtomicBoolean h;

    /* JADX INFO: renamed from: com.obric.autogui.session.functions.impl.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AutoCancelHelper.kt */
    public static final class C0848a {
        public /* synthetic */ C0848a(h r1) {
            this();
        }

        private C0848a() {
        }
    }

    /* JADX INFO: compiled from: AutoCancelHelper.kt */
    @f(b = "AutoCancelHelper.kt", c = {138}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.AutoCancelHelper$executeCancellation$1")
    static final class b extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f31026b;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31026b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f31026b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31025a;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            o.a(r5);     // Catch: Throwable -> L7
        L15:
            Loog.INSTANCE.i(a.TAG, " - [AutoCancel] cancellationRunnable invoked successfully. jobId: " + a.b(this.f31026b));     // Catch: Throwable -> L7
        L16:
            this.f31026b.d();
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            o.a(r5);
            d.h.a.b<d.c.d<? super x>, Object> r6 = this.f31026b.b();     // Catch: Throwable -> L7
            this.f31025a = 1;     // Catch: Throwable -> L7
            if (r6.invoke(this) != r0) goto L15;
            return r0;
        L7:
            th = move-exception;
            Loog.INSTANCE.e(a.TAG, " - [AutoCancel] unexpected exception during cancellation: " + th + ". jobId: " + a.b(this.f31026b), th);     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            this.f31026b.d();
            throw th;
        }
    }

    /* JADX INFO: compiled from: AutoCancelHelper.kt */
    public static final class c extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f31027a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f31028b;

        c(int r1, a r2) {
            this.f31027a = r1;
            this.f31028b = r2;
        }

        public void onReceive(Context r3, Intent r4) {
            d.h.b.o.e((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), "context");
            d.h.b.o.e(r4, MemorySourceLinkType.INTENT);
            if (d.h.b.o.a(r4.getAction(), "com.obric.autogui.ACTION_AUTO_CANCEL_JOB") == true) goto L5;
            return;
        L5:
            if (r4.getIntExtra(Ext.KEY_JOB_ID, -1) != this.f31027a) goto L9;
            Loog.INSTANCE.i(a.TAG, " - [AutoCancel] triggered by AlarmManager. jobId: " + this.f31027a);
            a.a(this.f31028b);
            return;
        }
    }

    /* JADX INFO: compiled from: AutoCancelHelper.kt */
    @f(b = "AutoCancelHelper.kt", c = {160}, d = "invokeSuspend", e = "com.obric.autogui.session.functions.impl.AutoCancelHelper$start$1")
    static final class d extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f31029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f31030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f31031c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f31032d;

        d(a r3, int r4, d.c.d<? super d> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31031c = r3;
            this.f31032d = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f31031c, this.f31032d, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31030b;
            if (r1 == 0) goto L10;
            if (r1 != 1) goto L9;
            long r2 = this.f31029a;
            o.a(r11);     // Catch: Throwable -> L17 CancellationException -> L27
        L15:
            Loog.INSTANCE.i(a.TAG, " - [AutoCancel] triggered by postDelay. jobId: " + this.f31032d);     // Catch: Throwable -> L17 CancellationException -> L27
            a.a(this.f31031c);     // Catch: Throwable -> L17 CancellationException -> L27
        L16:
            a.a(this.f31031c, null);
            a.c(this.f31031c);
            a.d(this.f31031c);
            return x.f38692a;
        L20:
            long r5 = AOSystemTools.INSTANCE.nowTimeMillis() - r2;     // Catch: Throwable -> L24
            Loog.INSTANCE.i(a.TAG, " - [AutoCancel] cancelled awaiting. already: " + r5 + "ms; remaining: " + (this.f31031c.a() - r5) + "ms. jobId: " + this.f31032d);     // Catch: Throwable -> L24
            goto L16
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            o.a(r11);
            long r6 = AOSystemTools.INSTANCE.nowTimeMillis();
            AOThreadingTools r12 = AOThreadingTools.INSTANCE;     // Catch: Throwable -> L17 CancellationException -> L19
            long r7 = this.f31031c.a();     // Catch: Throwable -> L17 CancellationException -> L19
            d.c.d<? super x> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17 CancellationException -> L19
            this.f31029a = r6;     // Catch: Throwable -> L17 CancellationException -> L19
            this.f31030b = 1;     // Catch: Throwable -> L17 CancellationException -> L19
            if (r12.delayForMillis(r7, r3) != r0) goto L14;
            return r0;
        L14:
            r2 = r6;
        L19:
            r2 = r6;
        L17:
            th = move-exception;
            Loog.INSTANCE.e(a.TAG, " - [AutoCancel] unexpected exception: " + th + ". jobId: " + this.f31032d, th);     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            a.a(this.f31031c, null);
            a.c(this.f31031c);
            a.d(this.f31031c);
            throw th;
        }
    }

    public a(com.obric.autogui.session.functions.a r3, long r4, d.h.a.b<? super d.c.d<? super x>, ? extends Object> r6) {
        d.h.a.b<d.c.d<? super x>, Object> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "forFunc");
        d.h.b.o.e(r7, "cancellationRunnable");
        this.f31021b = r3;
        this.f31022c = r4;
        this.f31023d = r7;
        this.h = new AtomicBoolean(false);
    }

    public static final /* synthetic */ void a(a r0) {
        r0.f();
    }

    public static final /* synthetic */ void a(a r2, ca r3) {
        r2.f31024e = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ Integer b(a r0) {
        return r0.f;
    }

    public static final /* synthetic */ void c(a r0) {
        r0.e();
    }

    public static final /* synthetic */ void d(a r0) {
        r0.unregisterReceiver();
    }

    public final long a() {
        return this.f31022c;
    }

    public final d.h.a.b<d.c.d<? super x>, Object> b() {
        return this.f31023d;
    }

    static {
        f31020a = new C0848a(null);
        i = new AtomicInteger(100000);
    }

    private final void registerReceiver(int r6) {
        if (this.g == null) goto L5;
        return;
    L5:
        c r0 = new c(r6, this);
        IntentFilter r7 = new IntentFilter("com.obric.autogui.ACTION_AUTO_CANCEL_JOB");
        if (Build.VERSION.SDK_INT < 33) goto L8;
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r0, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r7, 4, "com.obric.aiagent.plugin");
    L9:
        this.g = (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r0, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin");
        return;
    L8:
        ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), (PluginBroadcastReceiver) ZeusTransformUtils.preCheckCast(r0, PluginBroadcastReceiver.class, "com.obric.aiagent.plugin"), r7, "com.obric.aiagent.plugin");
        goto L9
    }

    private final synchronized void unregisterReceiver() {
        monitor-enter(this);
        PluginBroadcastReceiver r0 = this.g;     // Catch: Throwable -> L10
        if (r0 != null) goto L14;
    L8:
        monitor-exit(this);
        return;
    L14:
        ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r0, "com.obric.aiagent.plugin");     // Catch: Throwable -> L13
    L7:
        this.g = null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private final PendingIntent a(int r5) {
        Intent r4 = new Intent("com.obric.autogui.ACTION_AUTO_CANCEL_JOB");
        r4.setPackage(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getPackageName());
        r4.putExtra(Ext.KEY_JOB_ID, r5);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        int r0 = 201326592;
    L6:
        PendingIntent r6 = PendingIntent.getBroadcast((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5, r4, r0);
        d.h.b.o.c(r6, "getBroadcast(...)");
        return r6;
    L5:
        r0 = 134217728;
        goto L6
    }

    private final void b(int r10) {
        Object r1 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("alarm");
        if (ZeusTransformUtils.instanceOf(r1, AlarmManager.class) == false) goto L5;
        AlarmManager r2 = (AlarmManager) ZeusTransformUtils.preCheckCast(r1, AlarmManager.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 != null) goto L8;
        return;
    L8:
        PendingIntent r3 = a(r10);
        long r4 = SystemClock.elapsedRealtime() + this.f31022c;
    L21:
        th = move-exception;
        Loog.INSTANCE.e(TAG, " - [AutoCancel] failed to schedule AlarmManager", th);
        return;
    L10:
        if (Build.VERSION.SDK_INT < 23) goto L12;
        r2.setExactAndAllowWhileIdle(2, r4, r3);     // Catch: Throwable -> L15
    L13:
        Loog.INSTANCE.i(TAG, " - [AutoCancel] scheduled AlarmManager with jobId: " + r10);     // Catch: Throwable -> L15
        return;
    L12:
        r2.setExact(2, r4, r3);     // Catch: Throwable -> L15
    L16:
        if (Build.VERSION.SDK_INT < 23) goto L18;
        r2.setAndAllowWhileIdle(2, r4, r3);     // Catch: Throwable -> L21
    L19:
        Loog.INSTANCE.i(TAG, " - [AutoCancel] scheduled inexact AlarmManager with jobId: " + r10 + " (fallback)");     // Catch: Throwable -> L21
        return;
    L18:
        r2.set(2, r4, r3);     // Catch: Throwable -> L21
        goto L19
    L5:
        r2 = null;
        goto L6
    }

    private final synchronized void e() {
        monitor-enter(this);
        Integer r0 = this.f;     // Catch: Throwable -> L14
        if (r0 == null) goto L12;
        int r1 = ((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue();     // Catch: Throwable -> L14
        Object r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("alarm");     // Catch: Throwable -> L14
        if (ZeusTransformUtils.instanceOf(r2, AlarmManager.class) == false) goto L8;
        AlarmManager r3 = (AlarmManager) ZeusTransformUtils.preCheckCast(r2, AlarmManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
    L9:
        if (r3 == null) goto L11;
        r3.cancel(a(r1));     // Catch: Throwable -> L14
    L11:
        Loog.INSTANCE.i(TAG, " - [AutoCancel] cancelled AlarmManager with jobId: " + r1);     // Catch: Throwable -> L14
        this.f = null;     // Catch: Throwable -> L14
        goto L12
    L8:
        r3 = null;
    L12:
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private final void f() {
        if (this.h.compareAndSet(false, true) == true) goto L6;
        Loog.INSTANCE.w(TAG, " - [AutoCancel] executeCancellation ignored, already executed. jobId: " + this.f);
        return;
    L6:
        Loog.INSTANCE.i(TAG, " - [AutoCancel] executeCancellation started. jobId: " + this.f);
        i.a(this.f31021b.b().h().getCoroutineScope(), null, null, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void c() {
        this.h.set(false);
        com.obric.autogui.session.a r0 = this.f31021b.b();
        int r1 = i.getAndIncrement();
        this.f = Integer.valueOf(r1);
        Loog.INSTANCE.i(TAG, " - [AutoCancel] start called. generated jobId: " + r1 + ", timeout: " + this.f31022c + "ms");
        registerReceiver(r1);
        b(r1);
        this.f31024e = i.a(r0.h().getCoroutineScope(), null, null, (m) ZeusTransformUtils.preCheckCast(new d(this, r1, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void d() {
        Loog.INSTANCE.i(TAG, " - [AutoCancel] maybeCancel called. current jobId: " + this.f);
        ca r0 = this.f31024e;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        this.f31024e = null;
        e();
        unregisterReceiver();
    }
}
