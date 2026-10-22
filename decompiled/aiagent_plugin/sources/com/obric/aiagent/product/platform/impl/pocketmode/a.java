package com.obric.aiagent.product.platform.impl.pocketmode;

import android.app.Application;
import android.app.KeyguardManager;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.a.e;
import com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector;
import com.obric.aiagent.product.platform.api.vibratefeedback.FeedbackType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.d;
import d.c.b.a.l;
import d.f;
import d.g;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.x;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: CommonPocketModeDetector.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements IPocketModeDetector {
    private static final String TAG = "CommonPocketModeDetector";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0407a f18854a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f18855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final f<Sensor> f18856c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final f<SensorManager> f18857d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final f<KeyguardManager> f18858e = null;
    private static w<Boolean> f;
    private static final Runnable g = null;
    private static final CommonPocketModeDetector$Companion$sensorEventListener$1 h = null;
    private static boolean i;
    private static boolean j;

    /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.pocketmode.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CommonPocketModeDetector.kt */
    public static final class C0407a {

        /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.pocketmode.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ThreadUtils.kt */
        public static final class RunnableC0408a implements Runnable {
            public RunnableC0408a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (a.f() == true) goto L9;
                Sensor r4 = C0407a.a(a.f18854a);
                if (r4 == null) goto L10;
                C0407a r0 = a.f18854a;
                a.a(true);
                a(C0407a.b(a.f18854a), (SensorEventListener) ZeusTransformUtils.preCheckCast(a.g(), SensorEventListener.class, "com.obric.aiagent.plugin"), r4, 0, e.f18781a.a());
                ILogDepend.Companion.i(a.TAG, "sensor registered");
                return;
            L10:
                return;
            }

            public static boolean a(SensorManager r3, SensorEventListener r4, Sensor r5, int r6, Handler r7) {
                SensorEventListener r8 = (SensorEventListener) ZeusTransformUtils.wrapperContextForParams(r4, SensorEventListener.class, "com.obric.aiagent.plugin");
                if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
                Boolean r9 = Boolean.valueOf(r3.registerListener(r8, r5, r6, r7));
                o.a(r9, "null cannot be cast to non-null type kotlin.Boolean");
                return ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
            L6:
                Boolean r10 = Boolean.valueOf(r3.registerListener(r8, r5, r6, r7));
                o.a(r10, "null cannot be cast to non-null type kotlin.Boolean");
                boolean r11 = ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
                int r12 = 0;
                if (r8 == null) goto L9;
                int r13 = r8.hashCode();
            L10:
                if (r5 == null) goto L12;
                r12 = r5.hashCode();
            L12:
                com.obric.performance.power.monitor.h.b.a(new com.obric.performance.power.monitor.h.a(r13, Integer.valueOf(r12)));
                return r11;
            L9:
                r13 = 0;
                goto L10
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.pocketmode.a$a$b */
        /* JADX INFO: compiled from: ThreadUtils.kt */
        public static final class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (a.f() == true) goto L9;
                Sensor r4 = C0407a.a(a.f18854a);
                if (r4 == null) goto L10;
                C0407a r0 = a.f18854a;
                a.a(true);
                a(C0407a.b(a.f18854a), (SensorEventListener) ZeusTransformUtils.preCheckCast(a.g(), SensorEventListener.class, "com.obric.aiagent.plugin"), r4, 0, e.f18781a.a());
                ILogDepend.Companion.i(a.TAG, "sensor registered");
                return;
            L10:
                return;
            }

            public static boolean a(SensorManager r3, SensorEventListener r4, Sensor r5, int r6, Handler r7) {
                SensorEventListener r8 = (SensorEventListener) ZeusTransformUtils.wrapperContextForParams(r4, SensorEventListener.class, "com.obric.aiagent.plugin");
                if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
                Boolean r9 = Boolean.valueOf(r3.registerListener(r8, r5, r6, r7));
                o.a(r9, "null cannot be cast to non-null type kotlin.Boolean");
                return ((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
            L6:
                Boolean r10 = Boolean.valueOf(r3.registerListener(r8, r5, r6, r7));
                o.a(r10, "null cannot be cast to non-null type kotlin.Boolean");
                boolean r11 = ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
                int r12 = 0;
                if (r8 == null) goto L9;
                int r13 = r8.hashCode();
            L10:
                if (r5 == null) goto L12;
                r12 = r5.hashCode();
            L12:
                com.obric.performance.power.monitor.h.b.a(new com.obric.performance.power.monitor.h.a(r13, Integer.valueOf(r12)));
                return r11;
            L9:
                r13 = 0;
                goto L10
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.pocketmode.a$a$c */
        /* JADX INFO: compiled from: ThreadUtils.kt */
        public static final class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (a.f() == false) goto L8;
                C0407a r3 = a.f18854a;
                a.a(false);
                if (C0407a.a(a.f18854a) == null) goto L9;
                a(C0407a.b(a.f18854a), (SensorEventListener) ZeusTransformUtils.preCheckCast(a.g(), SensorEventListener.class, "com.obric.aiagent.plugin"));
                ILogDepend.Companion.i(a.TAG, "sensor unregistered");
                return;
            L9:
                return;
            }

            public static void a(SensorManager r2, SensorEventListener r3) {
                SensorEventListener r4 = (SensorEventListener) ZeusTransformUtils.wrapperContextForParams(r3, SensorEventListener.class, "com.obric.aiagent.plugin");
                if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
                r2.unregisterListener(r4);
                return;
            L6:
                r2.unregisterListener(r4);
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                com.obric.performance.power.monitor.h.b.b(new com.obric.performance.power.monitor.h.a(r5, null));
                return;
            L9:
                r5 = 0;
                goto L10
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.product.platform.impl.pocketmode.a$a$d */
        /* JADX INFO: compiled from: ThreadUtils.kt */
        public static final class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                if (a.f() == false) goto L8;
                C0407a r3 = a.f18854a;
                a.a(false);
                if (C0407a.a(a.f18854a) == null) goto L9;
                a(C0407a.b(a.f18854a), (SensorEventListener) ZeusTransformUtils.preCheckCast(a.g(), SensorEventListener.class, "com.obric.aiagent.plugin"));
                ILogDepend.Companion.i(a.TAG, "sensor unregistered");
                return;
            L9:
                return;
            }

            public static void a(SensorManager r2, SensorEventListener r3) {
                SensorEventListener r4 = (SensorEventListener) ZeusTransformUtils.wrapperContextForParams(r3, SensorEventListener.class, "com.obric.aiagent.plugin");
                if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
                r2.unregisterListener(r4);
                return;
            L6:
                r2.unregisterListener(r4);
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                com.obric.performance.power.monitor.h.b.b(new com.obric.performance.power.monitor.h.a(r5, null));
                return;
            L9:
                r5 = 0;
                goto L10
            }
        }

        public /* synthetic */ C0407a(h r1) {
            this();
        }

        private C0407a() {
        }

        public static final /* synthetic */ Sensor a(C0407a r0) {
            return r0.a();
        }

        public static final /* synthetic */ SensorManager b(C0407a r0) {
            return r0.b();
        }

        public static final /* synthetic */ KeyguardManager c(C0407a r0) {
            return r0.c();
        }

        public static final /* synthetic */ void d(C0407a r0) {
            r0.d();
        }

        public static final /* synthetic */ Sensor e(C0407a r0) {
            return r0.g();
        }

        public static final /* synthetic */ void f(C0407a r0) {
            r0.f();
        }

        private final Sensor a() {
            return (Sensor) ZeusTransformUtils.preCheckCast(a.a().b(), Sensor.class, "com.obric.aiagent.plugin");
        }

        private final SensorManager b() {
            return (SensorManager) ZeusTransformUtils.preCheckCast(a.b().b(), SensorManager.class, "com.obric.aiagent.plugin");
        }

        private final KeyguardManager c() {
            return (KeyguardManager) ZeusTransformUtils.preCheckCast(a.c().b(), KeyguardManager.class, "com.obric.aiagent.plugin");
        }

        private final void d() {
            a.a(-1);
            e.f18781a.a().removeCallbacks(a.d());
            if (a() != null) goto L8;
            ILogDepend.Companion.w(a.TAG, "startSelfCheck: proximity sensor is null, treat as uncovered");
            a.a(0);
            w r3 = a.e();
            if (r3 == null) goto L10;
            r3.a(true);
            return;
        L10:
            return;
        L8:
            e();
            e.f18781a.a().postDelayed(a.d(), 200);
        }

        private final void e() {
            e.f18781a.a((Runnable) ZeusTransformUtils.preCheckCast(new b(), Runnable.class, "com.obric.aiagent.plugin"));
        }

        private final void f() {
            e.f18781a.a((Runnable) ZeusTransformUtils.preCheckCast(new d(), Runnable.class, "com.obric.aiagent.plugin"));
        }

        private final Sensor g() {
            List<Sensor> r5 = b().getSensorList(8);
            if (r5 != null) goto L5;
        L19:
            ILogDepend.Companion.i(a.TAG, "can't find proper sensor");
            return null;
        L5:
            if (r5.isEmpty() == true) goto L19;
            if (r5.size() == 1) goto L10;
            Iterator<Sensor> r0 = r5.iterator();
        L13:
            if (r0.hasNext() == false) goto L18;
            Sensor r1 = (Sensor) ZeusTransformUtils.preCheckCast(r0.next(), Sensor.class, "com.obric.aiagent.plugin");
            if (r1.isWakeUpSensor() == false) goto L13;
            return r1;
        L18:
            return (Sensor) ZeusTransformUtils.preCheckCast(r5.get(0), Sensor.class, "com.obric.aiagent.plugin");
        L10:
            return (Sensor) ZeusTransformUtils.preCheckCast(r5.get(0), Sensor.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: CommonPocketModeDetector.kt */
    @d.c.b.a.f(b = "CommonPocketModeDetector.kt", c = {189}, d = "awaitCheckPassed$suspendImpl", e = "com.obric.aiagent.product.platform.impl.pocketmode.CommonPocketModeDetector")
    static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f18859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f18860b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f18861c;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18860b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f18859a = r3;
            this.f18861c |= Integer.MIN_VALUE;
            return a.a(this.f18860b, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CommonPocketModeDetector.kt */
    @d.c.b.a.f(b = "CommonPocketModeDetector.kt", c = {190}, d = "invokeSuspend", e = "com.obric.aiagent.product.platform.impl.pocketmode.CommonPocketModeDetector$awaitCheckPassed$result$1")
    static final class c extends l implements m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f18862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w<Boolean> f18863b;

        c(w<Boolean> r3, d.c.d<? super c> r4) {
            w<Boolean> r5 = (w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18863b = r5;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f18863b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f18862a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            w<Boolean> r6 = this.f18863b;
            d.c.d<? super Boolean> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f18862a = 1;
            r5 = r6.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: lambda$387J-J1OeX8Vqa0cNMe2dPvRAu8, reason: not valid java name */
    public static /* synthetic */ void m230lambda$387JJ1OeX8Vqa0cNMe2dPvRAu8() {
        l();
    }

    /* JADX INFO: renamed from: lambda$9FioA8ftrqIV-V_QyyDQVtnc4hE, reason: not valid java name */
    public static /* synthetic */ SensorManager m231lambda$9FioA8ftrqIVV_QyyDQVtnc4hE() {
        return j();
    }

    public static /* synthetic */ Sensor lambda$KRA870IaNaDKt2nH9InE1nDSVVQ() {
        return i();
    }

    /* JADX INFO: renamed from: lambda$_YawY0pcdLI2rl9JC8KcdQ-1Sfs, reason: not valid java name */
    public static /* synthetic */ KeyguardManager m232lambda$_YawY0pcdLI2rl9JC8KcdQ1Sfs() {
        return k();
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public Object awaitCheckPassed(d.c.d<? super Boolean> r3) {
        return a(this, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public a() {
    }

    public static final /* synthetic */ f a() {
        return f18856c;
    }

    public static final /* synthetic */ void a(int r0) {
        f18855b = r0;
    }

    public static final /* synthetic */ void a(boolean r0) {
        i = r0;
    }

    public static final /* synthetic */ f b() {
        return f18857d;
    }

    public static final /* synthetic */ f c() {
        return f18858e;
    }

    public static final /* synthetic */ Runnable d() {
        return g;
    }

    public static final /* synthetic */ w e() {
        return f;
    }

    public static final /* synthetic */ boolean f() {
        return i;
    }

    public static final /* synthetic */ CommonPocketModeDetector$Companion$sensorEventListener$1 g() {
        return h;
    }

    public static final /* synthetic */ int h() {
        return f18855b;
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [com.obric.aiagent.product.platform.impl.pocketmode.CommonPocketModeDetector$Companion$sensorEventListener$1] */
    static {
        f18854a = new C0407a(null);
        f18855b = -1;
        f18856c = g.a($$Lambda$a$KRA870IaNaDKt2nH9InE1nDSVVQ.INSTANCE);
        f18857d = g.a($$Lambda$a$9FioA8ftrqIVV_QyyDQVtnc4hE.INSTANCE);
        f18858e = g.a($$Lambda$a$_YawY0pcdLI2rl9JC8KcdQ1Sfs.INSTANCE);
        g = $$Lambda$a$387JJ1OeX8Vqa0cNMe2dPvRAu8.INSTANCE;
        h = new CommonPocketModeDetector$Companion$sensorEventListener$1();
    }

    private static final Sensor i() {
        return C0407a.e(f18854a);
    }

    private static final SensorManager j() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("sensor");
        o.a(r0, "null cannot be cast to non-null type android.hardware.SensorManager");
        return (SensorManager) ZeusTransformUtils.preCheckCast(r0, SensorManager.class, "com.obric.aiagent.plugin");
    }

    private static final KeyguardManager k() {
        Object r0 = ((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getSystemService("keyguard");
        o.a(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
        return (KeyguardManager) ZeusTransformUtils.preCheckCast(r0, KeyguardManager.class, "com.obric.aiagent.plugin");
    }

    private static final void l() {
        ILogDepend.Companion.e(TAG, "force unregister sensor listener, is there something wrong?!");
        C0407a.f(f18854a);
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void init() {
        ILogDepend.Companion.i(TAG, "call init()");
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void checkAsync() {
        C0407a r0 = f18854a;
        j = false;
        if (C0407a.c(r0).isKeyguardLocked() == true) goto L5;
        f = y.a(true);
        j = true;
        return;
    L5:
        if (isPocketModeManuallyDismissed() == false) goto L7;
    L13:
        f = y.a(true);
        j = true;
        ILogDepend.Companion.i(TAG, "checkAsync() key guard locked, pocket mode not enable");
        return;
    L7:
        if (isPocketModeEnabled() == false) goto L13;
        w<Boolean> r5 = f;
        if (r5 == null) goto L12;
        ca.a.a((ca) ZeusTransformUtils.preCheckCast(r5, ca.class, "com.obric.aiagent.plugin"), null, 1, null);
    L12:
        f = y.a(null, 1, null);
        C0407a.d(r0);
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isCheckPassed() {
        ILogDepend.Companion.i(TAG, "isCheckPassed, checkPass = " + j + ", selfCheckResult = " + f18855b + ", isPocketModeEnabled = " + isPocketModeEnabled() + ", isPocketModeManuallyDismissed = " + isPocketModeManuallyDismissed());
        boolean r1 = true;
        if (j == true) goto L9;
        if (f18855b != 1) goto L9;
        r1 = false;
    L9:
        f18855b = -1;
        return r1;
    L11:
        th = move-exception;
        f18855b = -1;
        throw th;
    }

    static /* synthetic */ Object a(a r8, d.c.d<? super Boolean> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r10, b.class, "com.obric.aiagent.plugin");
        if ((r0.f18861c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f18861c -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f18859a;
        Object r12 = d.c.a.b.a();
        int r2 = r0.f18861c;
        Boolean r3 = null;
        if (r2 == 0) goto L17;
        if (r2 != 1) goto L16;
        d.o.a(r11);     // Catch: CancellationException -> L13
    L29:
        r3 = (Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L13
    L32:
        if (r3 != null) goto L35;
        ILogDepend.Companion.w(TAG, "awaitCheckPassed: timeout, return true");
        return d.c.b.a.b.a(true);
    L35:
        ILogDepend.Companion.i(TAG, "awaitCheckPassed: result = " + r3);
        return r3;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        d.o.a(r11);
        ILogDepend.Companion r13 = ILogDepend.Companion;
        StringBuilder r4 = new StringBuilder().append("awaitCheckPassed start, checkDeferred.isCompleted = ");
        w<Boolean> r6 = f;
        if (r6 == null) goto L20;
        Boolean r7 = d.c.b.a.b.a(r6.i());
    L21:
        r13.i(TAG, r4.append(r7).append(", checkPass = ").append(j).append(", selfCheckResult = ").append(f18855b).toString());
        w<Boolean> r14 = f;
        if (r14 != null) goto L26;
        return d.c.b.a.b.a(true);
    L26:
        m r15 = (m) ZeusTransformUtils.preCheckCast(new c(r14, null), m.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L13
        r0.f18861c = 1;     // Catch: CancellationException -> L13
        r11 = dg.b(100, r15, r0);     // Catch: CancellationException -> L13
        if (r11 != r12) goto L29;
        return r12;
    L20:
        r7 = null;
    L13:
        e = move-exception;
        ILogDepend.Companion.w(TAG, "awaitCheckPassed: deferred cancelled", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    L7:
        r0 = new b(r8, r10);
        goto L8
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void onUserActionBlocked(boolean r4, boolean r5, d.h.a.a<x> r6) {
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r7, "showToastAction");
        ILogDepend.Companion.i(TAG, "onUserActionBlocked() needVibrate:" + r4 + ", isAppBackground:" + r5);
        if (r4 == false) goto L5;
        com.obric.aiagent.product.platform.impl.f.c.f18847a.a(FeedbackType.WARNING.getTypeName());
    L5:
        if (r5 == false) goto L7;
        showProximityNearAlert();
        return;
    L7:
        r7.invoke();
    }
}
