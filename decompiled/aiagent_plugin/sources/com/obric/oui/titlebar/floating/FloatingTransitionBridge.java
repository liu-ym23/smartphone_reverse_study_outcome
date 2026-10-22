package com.obric.oui.titlebar.floating;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.Log;
import android.view.IFloatingTransitionCallback;
import android.view.IFloatingTransitionSession;
import android.view.IFloatingTransitionStateProvider;
import android.view.Surface;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.autogui.effects.VDPlayerEffectProviderImpl;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBarActionHost;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.h.b.z;
import d.l.n;
import d.x;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: FloatingTransitionBridge.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FloatingTransitionBridge {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final Map<IBinder, FloatingTransitionBridge> f36697J = null;
    private static final String TAG = "FloatingTrans-Bridge";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f36698a = null;
    private d.h.a.a<x> A;
    private boolean B;
    private c C;
    private volatile boolean D;
    private volatile boolean E;
    private final List<OFloatingTitleBarActionHost> F;
    private Runnable G;
    private final IFloatingTransitionCallback.Stub H;
    private final IFloatingTransitionStateProvider.Stub I;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OFloatingTitleBar f36699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f36700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private IBinder f36701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f36702e;
    private final List<d.h.a.a<x>> f;
    private OFloatingTitleBarActionHost g;
    private boolean h;
    private Method i;
    private Method j;
    private Class<?> k;
    private Method l;
    private Method m;
    private Method n;
    private Method o;
    private Method p;
    private a q;
    private Bundle r;
    private volatile boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private OFloatingTitleBarActionHost y;
    private boolean z;

    /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
    private static final class TransitionCallback extends IFloatingTransitionCallback.Stub {
        private final WeakReference<FloatingTransitionBridge> bridgeRef;

        public TransitionCallback(FloatingTransitionBridge r2) {
            o.e(r2, "bridge");
            this.bridgeRef = new WeakReference(r2);
        }

        @Override // android.view.IFloatingTransitionCallback
        public boolean onTransitionStart(SurfaceControl r3, SurfaceControl r4, Bundle r5) {
            FloatingTransitionBridge r2 = (FloatingTransitionBridge) ZeusTransformUtils.preCheckCast(this.bridgeRef.get(), FloatingTransitionBridge.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L6;
            return false;
        L6:
            return FloatingTransitionBridge.a(r2, r3, r4, r5);
        }

        @Override // android.view.IFloatingTransitionCallback
        public boolean onHideTitleBar(SurfaceControl r3, Bundle r4) {
            FloatingTransitionBridge r2 = (FloatingTransitionBridge) ZeusTransformUtils.preCheckCast(this.bridgeRef.get(), FloatingTransitionBridge.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L6;
            return false;
        L6:
            return FloatingTransitionBridge.a(r2, r3, r4);
        }

        @Override // android.view.IFloatingTransitionCallback
        public void onTransitionCancelled() {
            FloatingTransitionBridge r2 = (FloatingTransitionBridge) ZeusTransformUtils.preCheckCast(this.bridgeRef.get(), FloatingTransitionBridge.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L7;
            FloatingTransitionBridge.a(r2);
            return;
        }

        @Override // android.view.IFloatingTransitionCallback
        public void onTransitionFinished() {
            FloatingTransitionBridge r2 = (FloatingTransitionBridge) ZeusTransformUtils.preCheckCast(this.bridgeRef.get(), FloatingTransitionBridge.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L7;
            FloatingTransitionBridge.b(r2);
            return;
        }
    }

    /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
    private static final class TransitionStateProvider extends IFloatingTransitionStateProvider.Stub {
        private final WeakReference<FloatingTransitionBridge> bridgeRef;

        public TransitionStateProvider(FloatingTransitionBridge r2) {
            o.e(r2, "bridge");
            this.bridgeRef = new WeakReference(r2);
        }

        @Override // android.view.IFloatingTransitionStateProvider
        public Bundle captureFloatingTransitionState() {
            FloatingTransitionBridge r2 = (FloatingTransitionBridge) ZeusTransformUtils.preCheckCast(this.bridgeRef.get(), FloatingTransitionBridge.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L5;
            Bundle r3 = null;
        L6:
            if (r3 == null) goto L8;
            return r3;
        L8:
            return new Bundle();
        L5:
            r3 = FloatingTransitionBridge.p(r2);
            goto L6
        }
    }

    /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ViewGroup f36703a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final OFloatingTitleBarActionHost f36704b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d f36705c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final SurfaceControl f36706d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f36703a, r6.f36703a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f36704b, r6.f36704b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f36705c, r6.f36705c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f36706d, r6.f36706d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f36703a.hashCode() * 31) + this.f36704b.hashCode()) * 31) + this.f36705c.hashCode()) * 31) + this.f36706d.hashCode();
        }

        public String toString() {
            return "ActiveOverlay(decor=" + this.f36703a + ", host=" + this.f36704b + ", renderTarget=" + this.f36705c + ", overlaySurface=" + this.f36706d + ')';
        }

        public a(ViewGroup r2, OFloatingTitleBarActionHost r3, d r4, SurfaceControl r5) {
            o.e(r2, "decor");
            o.e(r3, "host");
            o.e(r4, "renderTarget");
            o.e(r5, "overlaySurface");
            this.f36703a = r2;
            this.f36704b = r3;
            this.f36705c = r4;
            this.f36706d = r5;
        }

        public final ViewGroup a() {
            return this.f36703a;
        }

        public final OFloatingTitleBarActionHost b() {
            return this.f36704b;
        }

        public final d c() {
            return this.f36705c;
        }

        public final SurfaceControl d() {
            return this.f36706d;
        }
    }

    /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public static final /* synthetic */ IFloatingTransitionSession a(b r0) {
            return r0.b();
        }

        private final void a(Activity r4) {
            Activity r5 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
            if (com.obric.oui.titlebar.floating.a.a() == true) goto L5;
            return;
        L5:
            IBinder r6 = b(r5);
            IFloatingTransitionSession r3 = b();
            if (r6 == null) goto L16;
            if (r3 == null) goto L17;
            r3.notifyFloatingTransitionLaunch(r6);     // Catch: Throwable -> L11
            a(FloatingTransitionBridge.TAG, o.a("floating notify launch token=", r6));     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            a(FloatingTransitionBridge.TAG, o.a("floating notify launch failed: ", th.getMessage()));
            return;
        L17:
            return;
        }

        public static /* synthetic */ void a(b r1, Activity r2, OFloatingTitleBar r3, OFloatingTitleBarActionHost r4, int r5, Object r6) {
            Activity r7 = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.aiagent.plugin");
            if ((r5 & 4) == 0) goto L5;
            r4 = null;
        L5:
            r1.a(r7, r3, r4);
        }

        public final void a(Activity r3, OFloatingTitleBar r4, OFloatingTitleBarActionHost r5) {
            Activity r6 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.aiagent.plugin");
            o.e(r6, "activity");
            if (r4 != null) goto L5;
        L7:
            a(r6);
            return;
        L5:
            if (r4.prepareFloatingTransitionLaunch$OUI_standardRelease(r5) == true) goto L7;
        }

        public final void a() {
            if (com.obric.oui.titlebar.floating.a.a() == true) goto L5;
            return;
        L5:
            IFloatingTransitionSession r2 = b();
            if (r2 != null) goto L14;
            return;
        L14:
            r2.notifyFloatingTransitionLaunch(null);     // Catch: Throwable -> L11
            a(FloatingTransitionBridge.TAG, "floating cancel launch");     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            a(FloatingTransitionBridge.TAG, o.a("floating cancel launch failed: ", th.getMessage()));
        }

        private final IFloatingTransitionSession b() {
            if (com.obric.oui.titlebar.floating.a.a() == true) goto L19;
            return null;
        L19:
            Object r0 = ZeusTransformUtils.forName("android.view.WindowManagerGlobal", "com.obric.aiagent.plugin").getMethod("getWindowManagerService", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L16
            Object r1 = r0.getClass().getMethod("getFloatingTransitionService", new Class[0]).invoke(r0, new Object[0]);     // Catch: Throwable -> L16
            if (ZeusTransformUtils.instanceOf(r1, IBinder.class) == false) goto L9;
            IBinder r2 = (IBinder) ZeusTransformUtils.preCheckCast(r1, IBinder.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        L12:
            if (r2 != null) goto L14;
            return null;
        L14:
            return IFloatingTransitionSession.Stub.asInterface(r2);
        L9:
            if (ZeusTransformUtils.instanceOf(r1, IInterface.class) == false) goto L11;
            r2 = ((IInterface) ZeusTransformUtils.preCheckCast(r1, IInterface.class, "com.obric.aiagent.plugin")).asBinder();     // Catch: Throwable -> L16
            goto L12
        L11:
            r2 = null;
        L16:
            th = move-exception;
            a(FloatingTransitionBridge.TAG, o.a("floating service unavailable: ", th.getMessage()));
            return (IFloatingTransitionSession) ZeusTransformUtils.preCheckCast(null, IFloatingTransitionSession.class, "com.obric.aiagent.plugin");
        }

        private final IBinder b(Activity r4) {
            Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
            IBinder r5 = null;
            Field r1 = Activity.class.getDeclaredField("mToken");     // Catch: Throwable -> L8
            r1.setAccessible(true);     // Catch: Throwable -> L8
            Object r2 = r1.get(r3);     // Catch: Throwable -> L8
            if (ZeusTransformUtils.instanceOf(r2, IBinder.class) == false) goto L7;
            IBinder r6 = (IBinder) ZeusTransformUtils.preCheckCast(r2, IBinder.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        L10:
            Window r7 = ZeusTransformUtils.getWindow(r3, "com.obric.aiagent.plugin");
            if (r7 != null) goto L13;
            return r6;
        L13:
            View r0 = r7.getDecorView();
            o.c(r0, "window.decorView");
            if (r6 != null) goto L19;
            WindowManager.LayoutParams r8 = r7.getAttributes();
            if (r8 == null) goto L20;
            r5 = r8.token;
        L20:
            if (r5 != null) goto L27;
            IBinder r9 = r0.getApplicationWindowToken();
            if (r9 == null) goto L24;
            return r9;
        L24:
            return r0.getWindowToken();
        L27:
            return r5;
        L19:
            r5 = r6;
            goto L20
        L7:
            r6 = null;
        L8:
            th = move-exception;
            a(FloatingTransitionBridge.TAG, o.a("floating get activity token failed: ", th.getMessage()));
            r6 = (IBinder) ZeusTransformUtils.preCheckCast(null, IBinder.class, "com.obric.aiagent.plugin");
            goto L10
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }
    }

    /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
    public interface c {
        void a(OFloatingTitleBar r1);
    }

    /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
    private final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatingTransitionBridge f36707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SurfaceControl f36708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SurfaceControl f36709c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Surface f36710d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Object f36711e;
        private final com.obric.oui.titlebar.a f;
        private final com.obric.oui.titlebar.a g;
        private float h;
        private boolean i;
        private boolean j;

        public d(FloatingTransitionBridge r2, SurfaceControl r3, SurfaceControl r4, Surface r5, Object r6, com.obric.oui.titlebar.a r7, com.obric.oui.titlebar.a r8) {
            o.e(r2, "this$0");
            o.e(r3, "parentSurface");
            o.e(r4, "contentSurface");
            o.e(r5, "surface");
            o.e(r6, "blastBufferQueue");
            o.e(r7, "sourceState");
            this.f36707a = r2;
            this.f36708b = r3;
            this.f36709c = r4;
            this.f36710d = r5;
            this.f36711e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r7.a().d();
        }

        public final SurfaceControl a() {
            return this.f36709c;
        }

        public final Surface b() {
            return this.f36710d;
        }

        public final void c() {
            this.i = true;
        }

        public final boolean d() {
            if (this.j == false) goto L5;
        L9:
            return false;
        L5:
            if (this.f36710d.isValid() == false) goto L9;
            if (this.f36709c.isValid() == false) goto L9;
            return true;
        }

        public final float a(OFloatingTitleBarActionHost r9) {
            o.e(r9, "host");
            com.obric.oui.titlebar.a r0 = this.g;
            if (r0 == null) goto L5;
            this.f.b().e();
            float r1 = r0.b().e();
            float r10 = r9.currentFloatingTransitionContentTopOffset$OUI_standardRelease();
            float r2 = FloatingTransitionBridge.a(this.f36707a, this.f);
            float r3 = FloatingTransitionBridge.a(this.f36707a, r0);
            float r4 = r2 - r0.a().d();
            float r5 = 1.0f;
            if (this.i == true) goto L9;
            r5 = 0.0f;
        L12:
            float r6 = (r2 + ((r3 - r2) * r5)) - r10;
            this.h = r6;
            return r6;
        L9:
            float r7 = r1 - r4;
            if (Math.abs(r7) <= 0.5f) goto L12;
            r5 = n.a((r10 - r4) / r7, 0.0f, 1.0f);
            goto L12
        L5:
            return ((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin")).f.a().d();
        }

        public final Long e() {
            Method r1 = FloatingTransitionBridge.t(this.f36707a);     // Catch: Throwable -> L11
            if (r1 != null) goto L6;
            r1 = Surface.class.getDeclaredMethod("getNextFrameNumber", new Class[0]);     // Catch: Throwable -> L11
            FloatingTransitionBridge r3 = this.f36707a;     // Catch: Throwable -> L11
            r1.setAccessible(true);     // Catch: Throwable -> L11
            FloatingTransitionBridge.a(r3, r1);     // Catch: Throwable -> L11
        L6:
            Object r5 = r1.invoke(this.f36710d, new Object[0]);     // Catch: Throwable -> L11
            if (r5 == null) goto L10;
            return Long.valueOf(((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.aiagent.plugin")).longValue());
        L10:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            a(FloatingTransitionBridge.TAG, o.a("getNextFrameNumber failed: ", th.getMessage()));
            return (Long) ZeusTransformUtils.preCheckCast(null, Long.class, "com.obric.aiagent.plugin");
        }

        public final boolean a(SurfaceControl.Transaction r8, long r9) {
            o.e(r8, "transaction");
            Method r2 = FloatingTransitionBridge.u(this.f36707a);     // Catch: Throwable -> L8
            if (r2 != null) goto L6;
            Class<?> r3 = this.f36711e.getClass();     // Catch: Throwable -> L8
            Class<?> r6 = Long.TYPE;     // Catch: Throwable -> L8
            o.a(r6);     // Catch: Throwable -> L8
            r2 = r3.getDeclaredMethod("mergeWithNextTransaction", new Class[]{SurfaceControl.Transaction.class, r6});     // Catch: Throwable -> L8
            FloatingTransitionBridge r4 = this.f36707a;     // Catch: Throwable -> L8
            r2.setAccessible(true);     // Catch: Throwable -> L8
            FloatingTransitionBridge.b(r4, r2);     // Catch: Throwable -> L8
        L6:
            r2.invoke(this.f36711e, new Object[]{r8, Long.valueOf(r9)});     // Catch: Throwable -> L8
            return true;
        L8:
            th = move-exception;
            a(FloatingTransitionBridge.TAG, o.a("mergeWithNextTransaction failed: ", th.getMessage()));
            return false;
        }

        public final void a(boolean r7) {
            if (this.j == false) goto L5;
            return;
        L5:
            this.j = true;
            this.f36710d.release();     // Catch: Throwable -> L8
        L29:
            Method r2 = FloatingTransitionBridge.v(this.f36707a);     // Catch: Throwable -> L15
            if (r2 != null) goto L13;
            r2 = this.f36711e.getClass().getDeclaredMethod("destroy", new Class[0]);     // Catch: Throwable -> L15
            FloatingTransitionBridge r4 = this.f36707a;     // Catch: Throwable -> L15
            r2.setAccessible(true);     // Catch: Throwable -> L15
            FloatingTransitionBridge.c(r4, r2);     // Catch: Throwable -> L15
        L13:
            r2.invoke(this.f36711e, new Object[0]);     // Catch: Throwable -> L15
        L17:
            if (r7 == false) goto L33;
            SurfaceControl.Transaction r8 = new SurfaceControl.Transaction();     // Catch: Throwable -> L20
            FloatingTransitionBridge.b(this.f36707a, r8, a());     // Catch: Throwable -> L20
            r8.apply();     // Catch: Throwable -> L20
            r8.close();     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            a(FloatingTransitionBridge.TAG, o.a("remove render content surface failed: ", th.getMessage()));
        L33:
            this.f36709c.release();     // Catch: Throwable -> L24
            return;
        L24:
            th = move-exception;
            a(FloatingTransitionBridge.TAG, o.a("release render content surface failed: ", th.getMessage()));
            return;
        L15:
            th = move-exception;
            a(FloatingTransitionBridge.TAG, o.a("destroy render bbq failed: ", th.getMessage()));
        L8:
            th = move-exception;
            a(FloatingTransitionBridge.TAG, o.a("release render surface failed: ", th.getMessage()));
            goto L29
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }
    }

    /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
    static final class e extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatingTransitionBridge f36712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f36713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBarActionHost f36714c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f36715d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ SurfaceControl f36716e;

        e(FloatingTransitionBridge r1, ViewGroup r2, OFloatingTitleBarActionHost r3, d r4, SurfaceControl r5) {
            this.f36712a = r1;
            this.f36713b = r2;
            this.f36714c = r3;
            this.f36715d = r4;
            this.f36716e = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            boolean r0 = FloatingTransitionBridge.b(this.f36712a, "finish-committed");
            FloatingTransitionBridge.a(this.f36712a, this.f36713b, this.f36714c, this.f36715d, this.f36716e, true);
            if (r0 == false) goto L6;
            FloatingTransitionBridge.s(this.f36712a);
            return;
        }
    }

    /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
    static final class f extends p implements d.h.a.b<d.h.a.b<? super Boolean, ? extends x>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f36717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ FloatingTransitionBridge f36718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SurfaceControl f36719c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AtomicReference<CountDownLatch> f36720d;

        /* JADX INFO: renamed from: com.obric.oui.titlebar.floating.FloatingTransitionBridge$f$1, reason: invalid class name */
        /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
        static final class AnonymousClass1 extends p implements d.h.a.b<Boolean, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ FloatingTransitionBridge f36721a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AtomicReference<CountDownLatch> f36722b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ViewGroup f36723c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ OFloatingTitleBarActionHost f36724d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ d f36725e;
            final /* synthetic */ d.h.a.b<Boolean, x> f;
            final /* synthetic */ SurfaceControl g;
            final /* synthetic */ SurfaceControl h;

            /* JADX INFO: renamed from: com.obric.oui.titlebar.floating.FloatingTransitionBridge$f$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
            static final class C10011 extends p implements d.h.a.a<x> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ SurfaceControl f36726a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ FloatingTransitionBridge f36727b;

                C10011(SurfaceControl r1, FloatingTransitionBridge r2) {
                    this.f36726a = r1;
                    this.f36727b = r2;
                    super(0);
                }

                @Override // d.h.a.a
                public /* synthetic */ x invoke() {
                    a();
                    return x.f38692a;
                }

                public final void a() {
                    SurfaceControl r0 = this.f36726a;
                    if (r0 == null) goto L6;
                    FloatingTransitionBridge.a(this.f36727b, r0, "sourceHideInterruptedFirstFrame");
                    return;
                }
            }

            AnonymousClass1(FloatingTransitionBridge r3, AtomicReference<CountDownLatch> r4, ViewGroup r5, OFloatingTitleBarActionHost r6, d r7, d.h.a.b<? super Boolean, x> r8, SurfaceControl r9, SurfaceControl r10) {
                d.h.a.b<Boolean, x> r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
                this.f36721a = r3;
                this.f36722b = r4;
                this.f36723c = r5;
                this.f36724d = r6;
                this.f36725e = r7;
                this.f = r11;
                this.g = r9;
                this.h = r10;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(Boolean r3) {
                a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
                return x.f38692a;
            }

            public final void a(boolean r8) {
                if (r8 == false) goto L8;
                FloatingTransitionBridge.d(this.f36721a, true);
                FloatingTransitionBridge.g(this.f36721a);
                CountDownLatch r9 = new CountDownLatch(1);
                this.f36722b.set(r9);
                FloatingTransitionBridge r2 = this.f36721a;
                SurfaceControl.Transaction r3 = new SurfaceControl.Transaction();
                FloatingTransitionBridge r4 = this.f36721a;
                SurfaceControl r5 = this.g;
                SurfaceControl r6 = this.h;
                FloatingTransitionBridge.a(r4, r3, r5);
                if (r6 == null) goto L7;
                FloatingTransitionBridge.b(r4, r3, r6);
            L7:
                FloatingTransitionBridge.a(r2, r3, "sourceHideShowSurface", r9, (d.h.a.a) ZeusTransformUtils.preCheckCast(new C10011(this.h, this.f36721a), d.h.a.a.class, "com.obric.aiagent.plugin"));
                FloatingTransitionBridge.a(this.f36721a, this.f36723c, this.f36724d, this.f36725e, false);
                this.f.invoke(true);
                return;
            L8:
                a(FloatingTransitionBridge.TAG, "floating source hide skip real actions hide");
                FloatingTransitionBridge.a(this.f36721a, this.f36723c, this.f36724d, this.f36725e, true);
                this.f.invoke(false);
            }

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static int a(String r1, String r2) {
                if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
                return 0;
            L5:
                return Log.d(r1, r2);
            }
        }

        f(Bundle r1, FloatingTransitionBridge r2, SurfaceControl r3, AtomicReference<CountDownLatch> r4) {
            this.f36717a = r1;
            this.f36718b = r2;
            this.f36719c = r3;
            this.f36720d = r4;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(d.h.a.b<? super Boolean, ? extends x> r3) {
            a((d.h.a.b) ZeusTransformUtils.preCheckCast(r3, d.h.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(d.h.a.b<? super Boolean, x> r19) {
            d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r19, d.h.a.b.class, "com.obric.aiagent.plugin");
            o.e(r9, "complete");
            com.obric.oui.titlebar.a r1 = com.obric.oui.titlebar.a.f36624a.a(this.f36717a);
            Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(FloatingTransitionBridge.o(this.f36718b).getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r3, "titleBar.context");
            com.obric.oui.titlebar.a r2 = r1.a(r3);
            FloatingTransitionBridge r4 = this.f36718b;
            Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(FloatingTransitionBridge.o(r4).getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            o.c(r5, "titleBar.context");
            Activity r6 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(FloatingTransitionBridge.a(r4, r5), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
            ViewGroup r7 = null;
            if (r6 != null) goto L5;
        L4:
            View r8 = null;
        L10:
            if (ZeusTransformUtils.instanceOf(r8, ViewGroup.class) == false) goto L12;
            r7 = (ViewGroup) ZeusTransformUtils.preCheckCast(r8, ViewGroup.class, "com.obric.aiagent.plugin");
        L12:
            ViewGroup r10 = r7;
            if (r6 == null) goto L26;
            if (r10 == null) goto L26;
            SurfaceControl r17 = r2.f();
            FloatingTransitionBridge r11 = this.f36718b;
            if (r17 != null) goto L19;
            boolean r12 = true;
        L20:
            FloatingTransitionBridge.a(r11, false, r12);
            OFloatingTitleBarActionHost r13 = FloatingTransitionBridge.a(this.f36718b, (Context) ZeusTransformUtils.preCheckCast(r6, Context.class, "com.obric.aiagent.plugin"), r10, r2, null, 8, null);
            d r14 = FloatingTransitionBridge.a(this.f36718b, this.f36719c, r2, "Source", null, 8, null);
            if (r14 != null) goto L24;
            FloatingTransitionBridge.a(this.f36718b, r10, r13, null, false, 8, null);
            r9.invoke(false);
            return;
        L24:
            FloatingTransitionBridge.a(this.f36718b, r13);
            FloatingTransitionBridge.a(this.f36718b, r13, r2, r14, "sourceHideDraw", (d.h.a.b) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f36718b, this.f36720d, r10, r13, r14, r9, this.f36719c, r17), d.h.a.b.class, "com.obric.aiagent.plugin"));
            return;
        L19:
            r12 = false;
        L26:
            r9.invoke(false);
            return;
        L5:
            Window r15 = ZeusTransformUtils.getWindow(r6, "com.obric.aiagent.plugin");
            if (r15 == null) goto L4;
            r8 = r15.getDecorView();
            goto L10
        }
    }

    /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
    static final class g extends p implements d.h.a.b<Boolean, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatingTransitionBridge f36728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f36729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBarActionHost f36730c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f36731d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ SurfaceControl f36732e;
        final /* synthetic */ d.h.a.b<Boolean, x> f;
        final /* synthetic */ AtomicReference<CountDownLatch> g;
        final /* synthetic */ SurfaceControl h;
        final /* synthetic */ SurfaceControl i;
        final /* synthetic */ com.obric.oui.titlebar.a j;
        final /* synthetic */ com.obric.oui.titlebar.a k;

        /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
        static final class a extends p implements d.h.a.a<x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SurfaceControl f36733a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ FloatingTransitionBridge f36734b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SurfaceControl f36735c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ OFloatingTitleBarActionHost f36736d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ d f36737e;
            final /* synthetic */ com.obric.oui.titlebar.a f;
            final /* synthetic */ com.obric.oui.titlebar.a g;
            final /* synthetic */ ViewGroup h;
            final /* synthetic */ SurfaceControl i;

            /* JADX INFO: renamed from: com.obric.oui.titlebar.floating.FloatingTransitionBridge$g$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
            static final class AnonymousClass1 extends p implements d.h.a.a<x> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ z.a f36738a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ z.a f36739b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ FloatingTransitionBridge f36740c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ ViewGroup f36741d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                final /* synthetic */ OFloatingTitleBarActionHost f36742e;
                final /* synthetic */ d f;
                final /* synthetic */ SurfaceControl g;

                AnonymousClass1(z.a r1, z.a r2, FloatingTransitionBridge r3, ViewGroup r4, OFloatingTitleBarActionHost r5, d r6, SurfaceControl r7) {
                    this.f36738a = r1;
                    this.f36739b = r2;
                    this.f36740c = r3;
                    this.f36741d = r4;
                    this.f36742e = r5;
                    this.f = r6;
                    this.g = r7;
                    super(0);
                }

                @Override // d.h.a.a
                public /* synthetic */ x invoke() {
                    a();
                    return x.f38692a;
                }

                public final void a() {
                    a.a(this.f36738a, this.f36739b, this.f36740c, this.f36741d, this.f36742e, this.f, this.g);
                }
            }

            /* JADX INFO: renamed from: com.obric.oui.titlebar.floating.FloatingTransitionBridge$g$a$2, reason: invalid class name */
            /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
            static final class AnonymousClass2 extends p implements d.h.a.a<x> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FloatingTransitionBridge f36743a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ d f36744b;

                AnonymousClass2(FloatingTransitionBridge r1, d r2) {
                    this.f36743a = r1;
                    this.f36744b = r2;
                    super(0);
                }

                @Override // d.h.a.a
                public /* synthetic */ x invoke() {
                    a();
                    return x.f38692a;
                }

                public final void a() {
                    FloatingTransitionBridge.a(this.f36743a, this.f36744b, null, 2, null);
                }
            }

            /* JADX INFO: renamed from: com.obric.oui.titlebar.floating.FloatingTransitionBridge$g$a$3, reason: invalid class name */
            /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
            static final class AnonymousClass3 extends p implements d.h.a.a<x> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ z.a f36745a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ FloatingTransitionBridge f36746b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ d f36747c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ z.a f36748d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                final /* synthetic */ ViewGroup f36749e;
                final /* synthetic */ OFloatingTitleBarActionHost f;
                final /* synthetic */ SurfaceControl g;

                AnonymousClass3(z.a r1, FloatingTransitionBridge r2, d r3, z.a r4, ViewGroup r5, OFloatingTitleBarActionHost r6, SurfaceControl r7) {
                    this.f36745a = r1;
                    this.f36746b = r2;
                    this.f36747c = r3;
                    this.f36748d = r4;
                    this.f36749e = r5;
                    this.f = r6;
                    this.g = r7;
                    super(0);
                }

                @Override // d.h.a.a
                public /* synthetic */ x invoke() {
                    a();
                    return x.f38692a;
                }

                public final void a() {
                    this.f36745a.f38499a = true;
                    FloatingTransitionBridge.a(this.f36746b, this.f36747c, null, 2, null);
                    a.a(this.f36748d, this.f36745a, this.f36746b, this.f36749e, this.f, this.f36747c, this.g);
                    if (this.f36748d.f38499a == false) goto L5;
                    return;
                L5:
                    if (FloatingTransitionBridge.r(this.f36746b) == true) goto L9;
                    FloatingTransitionBridge.a(this.f36746b, "targetAnimationFinished");
                    return;
                }
            }

            a(SurfaceControl r1, FloatingTransitionBridge r2, SurfaceControl r3, OFloatingTitleBarActionHost r4, d r5, com.obric.oui.titlebar.a r6, com.obric.oui.titlebar.a r7, ViewGroup r8, SurfaceControl r9) {
                this.f36733a = r1;
                this.f36734b = r2;
                this.f36735c = r3;
                this.f36736d = r4;
                this.f36737e = r5;
                this.f = r6;
                this.g = r7;
                this.h = r8;
                this.i = r9;
                super(0);
            }

            public static final /* synthetic */ void a(z.a r0, z.a r1, FloatingTransitionBridge r2, ViewGroup r3, OFloatingTitleBarActionHost r4, d r5, SurfaceControl r6) {
                b(r0, r1, r2, r3, r4, r5, r6);
            }

            @Override // d.h.a.a
            public /* synthetic */ x invoke() {
                a();
                return x.f38692a;
            }

            public final void a() {
                SurfaceControl r1 = this.f36733a;
                if (r1 == null) goto L5;
                FloatingTransitionBridge.a(this.f36734b, r1, "targetFirstFrame");
            L5:
                SurfaceControl r2 = this.f36735c;
                if (r2 == null) goto L11;
                if (this.f36733a != null) goto L11;
                FloatingTransitionBridge.a(this.f36734b, r2, "interruptedTargetFirstFrame");
            L11:
                if (FloatingTransitionBridge.q(this.f36734b) == false) goto L13;
                FloatingTransitionBridge.a(this.f36734b, false);
            L13:
                z.a r3 = new z.a();
                z.a r11 = new z.a();
                FloatingTransitionBridge.a(this.f36734b, (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r11, r3, this.f36734b, this.h, this.f36736d, this.f36737e, this.i), d.h.a.a.class, "com.obric.aiagent.plugin"));
                this.f36736d.setFloatingTransitionDrawUpdateListener$OUI_standardRelease((d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f36734b, this.f36737e), d.h.a.a.class, "com.obric.aiagent.plugin"));
                this.f36737e.c();
                int r4 = FloatingTransitionBridge.a(this.f36734b, this.f) - this.g.a().d();
                OFloatingTitleBarActionHost r12 = this.f36736d;
                com.obric.oui.titlebar.a r13 = this.g;
                if (FloatingTransitionBridge.a(this.f36734b, this.f) == FloatingTransitionBridge.a(this.f36734b, this.g)) goto L16;
            L19:
                boolean r16 = true;
            L20:
                r12.applyState$OUI_standardRelease(r13, true, r16, Float.valueOf(r4), (d.h.a.a) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r3, this.f36734b, this.f36737e, r11, this.h, this.f36736d, this.i), d.h.a.a.class, "com.obric.aiagent.plugin"));
                FloatingTransitionBridge.g(this.f36734b, false);
                return;
            L16:
                if (r4 != this.g.b().e()) goto L19;
                r16 = false;
                goto L20
            }

            private static final void b(z.a r1, z.a r2, FloatingTransitionBridge r3, ViewGroup r4, OFloatingTitleBarActionHost r5, d r6, SurfaceControl r7) {
                if (r1.f38499a == false) goto L6;
                return;
            L6:
                if (r2.f38499a == true) goto L8;
                return;
            L8:
                if (FloatingTransitionBridge.r(r3) == false) goto L13;
                r1.f38499a = true;
                FloatingTransitionBridge.a(r3, null);
                FloatingTransitionBridge.a(r3, r4, r5, r6, r7);
                return;
            }
        }

        g(FloatingTransitionBridge r3, ViewGroup r4, OFloatingTitleBarActionHost r5, d r6, SurfaceControl r7, d.h.a.b<? super Boolean, x> r8, AtomicReference<CountDownLatch> r9, SurfaceControl r10, SurfaceControl r11, com.obric.oui.titlebar.a r12, com.obric.oui.titlebar.a r13) {
            d.h.a.b<Boolean, x> r14 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.b.class, "com.obric.aiagent.plugin");
            this.f36728a = r3;
            this.f36729b = r4;
            this.f36730c = r5;
            this.f36731d = r6;
            this.f36732e = r7;
            this.f = r14;
            this.g = r9;
            this.h = r10;
            this.i = r11;
            this.j = r12;
            this.k = r13;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Boolean r3) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            return x.f38692a;
        }

        public final void a(boolean r18) {
            if (r18 == true) goto L6;
            a(FloatingTransitionBridge.TAG, "target first frame draw failed");
            FloatingTransitionBridge.b(this.f36728a, true);
            FloatingTransitionBridge.a(this.f36728a, null);
            FloatingTransitionBridge.c(this.f36728a, false);
            FloatingTransitionBridge.m(this.f36728a);
            FloatingTransitionBridge.a(this.f36728a, this.f36729b, this.f36730c, this.f36731d, this.f36732e, true);
            this.f.invoke(false);
            return;
        L6:
            FloatingTransitionBridge.f(this.f36728a, true);
            FloatingTransitionBridge.a(this.f36728a, false);
            CountDownLatch r4 = new CountDownLatch(1);
            this.g.set(r4);
            SurfaceControl.Transaction r5 = new SurfaceControl.Transaction();
            FloatingTransitionBridge.a(this.f36728a, r5, this.f36732e);
            SurfaceControl r6 = this.h;
            if (r6 == null) goto L9;
            FloatingTransitionBridge.b(this.f36728a, r5, r6);
        L9:
            SurfaceControl r7 = this.i;
            if (r7 != null) goto L12;
        L14:
            boolean r1 = FloatingTransitionBridge.a(this.f36728a, r5, "targetFirstFrame", r4, (d.h.a.a) ZeusTransformUtils.preCheckCast(new a(this.h, this.f36728a, this.i, this.f36730c, this.f36731d, this.j, this.k, this.f36729b, this.f36732e), d.h.a.a.class, "com.obric.aiagent.plugin"));
            if (r1 == true) goto L17;
            FloatingTransitionBridge.b(this.f36728a, true);
            FloatingTransitionBridge.a(this.f36728a, null);
            FloatingTransitionBridge.c(this.f36728a, false);
            FloatingTransitionBridge.m(this.f36728a);
            FloatingTransitionBridge.a(this.f36728a, this.f36729b, this.f36730c, this.f36731d, this.f36732e, true);
        L17:
            this.f.invoke(Boolean.valueOf(r1));
            return;
        L12:
            if (this.h != null) goto L14;
            FloatingTransitionBridge.b(this.f36728a, r5, r7);
            goto L14
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }
    }

    /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
    static final class h extends p implements d.h.a.b<d.h.a.b<? super Boolean, ? extends x>, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatingTransitionBridge f36750a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SurfaceControl f36751b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SurfaceControl f36752c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f36753d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ AtomicReference<CountDownLatch> f36754e;

        h(FloatingTransitionBridge r1, SurfaceControl r2, SurfaceControl r3, Bundle r4, AtomicReference<CountDownLatch> r5) {
            this.f36750a = r1;
            this.f36751b = r2;
            this.f36752c = r3;
            this.f36753d = r4;
            this.f36754e = r5;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(d.h.a.b<? super Boolean, ? extends x> r3) {
            a((d.h.a.b) ZeusTransformUtils.preCheckCast(r3, d.h.a.b.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(d.h.a.b<? super Boolean, x> r7) {
            d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.b.class, "com.obric.aiagent.plugin");
            o.e(r5, "complete");
            FloatingTransitionBridge.a(this.f36750a, this.f36751b, this.f36752c, this.f36753d, this.f36754e, r5);
        }
    }

    /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
    static final class i extends p implements d.h.a.a<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatingTransitionBridge f36755a;

        i(FloatingTransitionBridge r1) {
            this.f36755a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ Boolean invoke() {
            return a();
        }

        public final Boolean a() {
            boolean r1 = false;
            if (FloatingTransitionBridge.c(this.f36755a) == true) goto L5;
        L9:
            boolean r0 = false;
        L11:
            if (FloatingTransitionBridge.c(this.f36755a) == false) goto L16;
            if (FloatingTransitionBridge.d(this.f36755a) == true) goto L16;
            r1 = true;
        L16:
            if (r0 == false) goto L19;
            a(FloatingTransitionBridge.TAG, "onHideTitleBar interrupted source cleanup");
            FloatingTransitionBridge.f(this.f36755a);
            return true;
        L19:
            if (r1 == false) goto L21;
            FloatingTransitionBridge.a(this.f36755a, true);
            a(FloatingTransitionBridge.TAG, "onHideTitleBar pending before first frame");
        L22:
            return true;
        L21:
            a(FloatingTransitionBridge.TAG, "onHideTitleBar hide real actions");
            FloatingTransitionBridge.g(this.f36755a);
            goto L22
        L5:
            if (FloatingTransitionBridge.d(this.f36755a) == false) goto L9;
            if (FloatingTransitionBridge.e(this.f36755a) == false) goto L9;
            r0 = true;
            goto L11
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }
    }

    /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
    static final class j extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatingTransitionBridge f36756a;

        j(FloatingTransitionBridge r1) {
            this.f36756a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            FloatingTransitionBridge.b(this.f36756a, true);
            FloatingTransitionBridge.a(this.f36756a, null);
            FloatingTransitionBridge.c(this.f36756a, false);
            FloatingTransitionBridge.d(this.f36756a, false);
            if (FloatingTransitionBridge.c(this.f36756a) == false) goto L5;
        L8:
            FloatingTransitionBridge.i(this.f36756a);
            return;
        L5:
            if (FloatingTransitionBridge.h(this.f36756a) != null) goto L8;
            FloatingTransitionBridge.e(this.f36756a, false);
            this.f36756a.a("cancelled");
        }
    }

    /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
    static final class k extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FloatingTransitionBridge f36757a;

        k(FloatingTransitionBridge r1) {
            this.f36757a = r1;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            if (FloatingTransitionBridge.e(this.f36757a) == false) goto L7;
            FloatingTransitionBridge.a(this.f36757a, null);
            FloatingTransitionBridge.b(this.f36757a, true);
            a(FloatingTransitionBridge.TAG, "onTransitionFinished ignored after interrupt snapshot");
            return;
        L7:
            if (FloatingTransitionBridge.j(this.f36757a) == true) goto L9;
        L17:
            boolean r0 = false;
        L18:
            if (r0 == false) goto L21;
            FloatingTransitionBridge.b(this.f36757a, true);
            FloatingTransitionBridge.m(this.f36757a);
            this.f36757a.a("sourceTransitionFinished");
            return;
        L21:
            FloatingTransitionBridge.b(this.f36757a, true);
            d.h.a.a r3 = FloatingTransitionBridge.n(this.f36757a);
            if (r3 == null) goto L26;
            r3.invoke();
            return;
        L26:
            return;
        L9:
            if (FloatingTransitionBridge.k(this.f36757a) == false) goto L17;
            if (FloatingTransitionBridge.l(this.f36757a) == true) goto L17;
            if (FloatingTransitionBridge.c(this.f36757a) == true) goto L17;
            if (FloatingTransitionBridge.h(this.f36757a) != null) goto L17;
            r0 = true;
            goto L18
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.d(r1, r2);
        }
    }

    /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
    static final class l extends p implements d.h.a.b<Boolean, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z.a f36758a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ z.a f36759b;

        l(z.a r1, z.a r2) {
            this.f36758a = r1;
            this.f36759b = r2;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Boolean r3) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            return x.f38692a;
        }

        public final void a(boolean r3) {
            this.f36758a.f38499a = true;
            this.f36759b.f38499a = r3;
        }
    }

    /* JADX INFO: compiled from: FloatingTransitionBridge.kt */
    static final class m extends p implements d.h.a.b<Boolean, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference<Boolean> f36760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f36761b;

        m(AtomicReference<Boolean> r1, CountDownLatch r2) {
            this.f36760a = r1;
            this.f36761b = r2;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Boolean r3) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
            return x.f38692a;
        }

        public final void a(boolean r2) {
            this.f36760a.set(Boolean.valueOf(r2));
            this.f36761b.countDown();
        }
    }

    public static /* synthetic */ void lambda$0ZmLwQhjgJX1g_8d3AsveOuDevw(Runnable r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$343-bSk2zYT43CVE-qAMmqigzx8, reason: not valid java name */
    public static /* synthetic */ void m1229lambda$343bSk2zYT43CVEqAMmqigzx8(CountDownLatch r0, d.h.a.a r1, FloatingTransitionBridge r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$6-mhU-7zPp1-ynyilPfJ9nyKdQc, reason: not valid java name */
    public static /* synthetic */ void m1230lambda$6mhU7zPp1ynyilPfJ9nyKdQc(FloatingTransitionBridge r0) {
        w(r0);
    }

    /* JADX INFO: renamed from: lambda$R0-ncc4JEfBkUUPXZDwv4UilcdI, reason: not valid java name */
    public static /* synthetic */ void m1231lambda$R0ncc4JEfBkUUPXZDwv4UilcdI(CountDownLatch r0, d.h.a.a r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$R5R7QnaBwTwnhU1q21_KwFyKvQA(d.h.a.a r0) {
        c(r0);
    }

    public static /* synthetic */ void lambda$Zy_8uB6FBNg6vEybObTMVkv1t7w(FloatingTransitionBridge r0, d r1) {
        a(r0, r1);
    }

    public static /* synthetic */ void lambda$dINEmUeFR46jcizdmnLyJp0FjK0(d.h.a.a r0) {
        a(r0);
    }

    /* JADX INFO: renamed from: lambda$jlpw-eN95u1bTbep7bzGEgTGLdI, reason: not valid java name */
    public static /* synthetic */ void m1232lambda$jlpweN95u1bTbep7bzGEgTGLdI(d.h.a.a r0) {
        d(r0);
    }

    /* JADX INFO: renamed from: lambda$kVLsnMBSYR9g9WACnNM-vPtGWQ8, reason: not valid java name */
    public static /* synthetic */ void m1233lambda$kVLsnMBSYR9g9WACnNMvPtGWQ8(AtomicReference r0, FloatingTransitionBridge r1, CountDownLatch r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$l3owZKKUsobU30d1ZX4fO8G-mK4, reason: not valid java name */
    public static /* synthetic */ void m1234lambda$l3owZKKUsobU30d1ZX4fO8GmK4(d.h.a.a r0) {
        b(r0);
    }

    public static /* synthetic */ void lambda$lIyy7DFzJSMth0USZyv9OduVxbw(FloatingTransitionBridge r0, z.f r1, String r2) {
        a(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$oYC87mhdZSbPAmOWB-V8PxqeCPU, reason: not valid java name */
    public static /* synthetic */ void m1235lambda$oYC87mhdZSbPAmOWBV8PxqeCPU(AtomicBoolean r0, CountDownLatch r1, AtomicReference r2, d.h.a.a r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$pyIiGZGfJUuKnyj2BTJjqoWm1pw(FloatingTransitionBridge r0) {
        x(r0);
    }

    /* JADX INFO: renamed from: lambda$x19nJc0-pL2S9VFbegSg1ZKhy5k, reason: not valid java name */
    public static /* synthetic */ void m1236lambda$x19nJc0pL2S9VFbegSg1ZKhy5k(AtomicBoolean r0, CountDownLatch r1, d.h.a.b r2, String r3, AtomicReference r4) {
        a(r0, r1, r2, r3, r4);
    }

    public FloatingTransitionBridge(OFloatingTitleBar r3) {
        o.e(r3, "titleBar");
        this.f36699b = r3;
        this.f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.z = true;
        this.F = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        this.H = (IFloatingTransitionCallback.Stub) ZeusTransformUtils.preCheckCast(new TransitionCallback(this), IFloatingTransitionCallback.Stub.class, "com.obric.aiagent.plugin");
        this.I = (IFloatingTransitionStateProvider.Stub) ZeusTransformUtils.preCheckCast(new TransitionStateProvider(this), IFloatingTransitionStateProvider.Stub.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ int a(FloatingTransitionBridge r0, com.obric.oui.titlebar.a r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ Activity a(FloatingTransitionBridge r2, Context r3) {
        return (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getActivity((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(FloatingTransitionBridge r0) {
        r0.h();
    }

    public static final /* synthetic */ void a(FloatingTransitionBridge r0, SurfaceControl.Transaction r1, SurfaceControl r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(FloatingTransitionBridge r6, SurfaceControl r7, SurfaceControl r8, Bundle r9, AtomicReference r10, d.h.a.b r11) {
        r6.a(r7, r8, r9, r10, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(FloatingTransitionBridge r0, SurfaceControl r1, String r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void a(FloatingTransitionBridge r0, ViewGroup r1, OFloatingTitleBarActionHost r2, d r3, SurfaceControl r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(FloatingTransitionBridge r0, ViewGroup r1, OFloatingTitleBarActionHost r2, d r3, SurfaceControl r4, boolean r5) {
        r0.a(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ void a(FloatingTransitionBridge r0, ViewGroup r1, OFloatingTitleBarActionHost r2, d r3, boolean r4) {
        r0.a(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void a(FloatingTransitionBridge r0, OFloatingTitleBarActionHost r1) {
        r0.g = r1;
    }

    public static final /* synthetic */ void a(FloatingTransitionBridge r6, OFloatingTitleBarActionHost r7, com.obric.oui.titlebar.a r8, d r9, String r10, d.h.a.b r11) {
        r6.a(r7, r8, r9, r10, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void a(FloatingTransitionBridge r2, d.h.a.a r3) {
        r2.A = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(FloatingTransitionBridge r0, String r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void a(FloatingTransitionBridge r0, Method r1) {
        r0.p = r1;
    }

    public static final /* synthetic */ void a(FloatingTransitionBridge r0, boolean r1) {
        r0.u = r1;
    }

    public static final /* synthetic */ void a(FloatingTransitionBridge r0, boolean r1, boolean r2) {
        r0.b(r1, r2);
    }

    public static final /* synthetic */ void a(z.a r2, d.h.a.b r3, boolean r4) {
        b(r2, (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ boolean a(FloatingTransitionBridge r2, SurfaceControl.Transaction r3, String r4, CountDownLatch r5, d.h.a.a r6) {
        return r2.a(r3, r4, r5, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ boolean a(FloatingTransitionBridge r0, SurfaceControl r1, Bundle r2) {
        return r0.a(r1, r2);
    }

    public static final /* synthetic */ boolean a(FloatingTransitionBridge r0, SurfaceControl r1, SurfaceControl r2, Bundle r3) {
        return r0.a(r1, r2, r3);
    }

    public static final /* synthetic */ boolean a(FloatingTransitionBridge r0, d r1, String r2, OFloatingTitleBarActionHost r3, com.obric.oui.titlebar.a r4, String r5) {
        return b(r0, r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ void b(FloatingTransitionBridge r0) {
        r0.i();
    }

    public static final /* synthetic */ void b(FloatingTransitionBridge r0, SurfaceControl.Transaction r1, SurfaceControl r2) {
        r0.b(r1, r2);
    }

    public static final /* synthetic */ void b(FloatingTransitionBridge r0, Method r1) {
        r0.n = r1;
    }

    public static final /* synthetic */ void b(FloatingTransitionBridge r0, boolean r1) {
        r0.z = r1;
    }

    public static final /* synthetic */ boolean b(FloatingTransitionBridge r0, String r1) {
        return r0.f(r1);
    }

    public static final /* synthetic */ void c(FloatingTransitionBridge r0, Method r1) {
        r0.o = r1;
    }

    public static final /* synthetic */ void c(FloatingTransitionBridge r0, boolean r1) {
        r0.E = r1;
    }

    public static final /* synthetic */ boolean c(FloatingTransitionBridge r0) {
        return r0.s;
    }

    public static final /* synthetic */ void d(FloatingTransitionBridge r0, boolean r1) {
        r0.D = r1;
    }

    public static final /* synthetic */ boolean d(FloatingTransitionBridge r0) {
        return r0.t;
    }

    public static final /* synthetic */ void e(FloatingTransitionBridge r0, boolean r1) {
        r0.x = r1;
    }

    public static final /* synthetic */ boolean e(FloatingTransitionBridge r0) {
        return r0.v;
    }

    public static final /* synthetic */ void f(FloatingTransitionBridge r0) {
        r0.p();
    }

    public static final /* synthetic */ void f(FloatingTransitionBridge r0, boolean r1) {
        r0.t = r1;
    }

    public static final /* synthetic */ void g(FloatingTransitionBridge r0) {
        r0.r();
    }

    public static final /* synthetic */ void g(FloatingTransitionBridge r0, boolean r1) {
        r0.w = r1;
    }

    public static final /* synthetic */ a h(FloatingTransitionBridge r0) {
        return r0.q;
    }

    public static final /* synthetic */ void i(FloatingTransitionBridge r0) {
        r0.q();
    }

    public static final /* synthetic */ boolean j(FloatingTransitionBridge r0) {
        return r0.D;
    }

    public static final /* synthetic */ boolean k(FloatingTransitionBridge r0) {
        return r0.w;
    }

    public static final /* synthetic */ boolean l(FloatingTransitionBridge r0) {
        return r0.E;
    }

    public static final /* synthetic */ void m(FloatingTransitionBridge r0) {
        r0.f();
    }

    public static final /* synthetic */ d.h.a.a n(FloatingTransitionBridge r0) {
        return r0.A;
    }

    public static final /* synthetic */ OFloatingTitleBar o(FloatingTransitionBridge r0) {
        return r0.f36699b;
    }

    public static final /* synthetic */ Bundle p(FloatingTransitionBridge r0) {
        return r0.l();
    }

    public static final /* synthetic */ boolean q(FloatingTransitionBridge r0) {
        return r0.u;
    }

    public static final /* synthetic */ boolean r(FloatingTransitionBridge r0) {
        return r0.z;
    }

    public static final /* synthetic */ void s(FloatingTransitionBridge r0) {
        r0.s();
    }

    public static final /* synthetic */ Method t(FloatingTransitionBridge r0) {
        return r0.p;
    }

    public static final /* synthetic */ Method u(FloatingTransitionBridge r0) {
        return r0.n;
    }

    public static final /* synthetic */ Method v(FloatingTransitionBridge r0) {
        return r0.o;
    }

    static {
        f36698a = new b(null);
        f36697J = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
    }

    private final void f() {
        j();
        this.s = false;
        this.t = false;
        this.u = false;
        this.f.clear();
        this.f36702e = false;
        this.v = false;
        this.D = false;
    }

    public final void a() {
        if (this.E == true) goto L5;
    L13:
        boolean r0 = false;
    L14:
        if (r0 == true) goto L16;
        return;
    L16:
        f36698a.a();
        if (o.a(Looper.myLooper(), Looper.getMainLooper()) == false) goto L19;
        b(true, true);
        return;
    L19:
        this.f36699b.post(new $$Lambda$FloatingTransitionBridge$6mhU7zPp1ynyilPfJ9nyKdQc(this));
        return;
    L5:
        if (this.x == false) goto L7;
    L12:
        r0 = true;
        goto L14
    L7:
        if (this.D == true) goto L12;
        if (this.s == true) goto L12;
        if (this.q == null) goto L13;
        goto L12
    }

    private static final void w(FloatingTransitionBridge r1) {
        o.e(r1, "this$0");
        r1.b(true, true);
    }

    public final void b() {
        if (g() == true) goto L5;
        return;
    L5:
        f36698a.a();
        if (o.a(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
        b(true, true);
        return;
    L8:
        this.f36699b.post(new $$Lambda$FloatingTransitionBridge$pyIiGZGfJUuKnyj2BTJjqoWm1pw(this));
    }

    private static final void x(FloatingTransitionBridge r1) {
        o.e(r1, "this$0");
        r1.b(true, true);
    }

    public final void a(OFloatingTitleBarActionHost r2) {
        o.e(r2, "host");
        if (g() == true) goto L6;
        return;
    L6:
        if (this.F.contains(r2) == true) goto L8;
        this.F.add(r2);
    L8:
        r2.hideFloatingTransitionActions$OUI_standardRelease(true);
    }

    public final void b(OFloatingTitleBarActionHost r1) {
        this.y = r1;
    }

    private final boolean g() {
        if (this.w == false) goto L5;
    L16:
        return true;
    L5:
        if (this.x == true) goto L16;
        if (this.D == true) goto L16;
        if (this.E == true) goto L16;
        if (this.s == true) goto L16;
        if (this.q != null) goto L16;
        return false;
    }

    public final boolean c() {
        if (this.s == false) goto L5;
    L8:
        return true;
    L5:
        if (this.q != null) goto L8;
        return false;
    }

    public final void a(c r3) {
        this.C = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
    }

    private final boolean a(SurfaceControl r5, SurfaceControl r6, Bundle r7) {
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L5;
        return false;
    L5:
        StringBuilder r0 = new StringBuilder().append("onTransitionStart transitionSurface=");
        if (r5 == null) goto L8;
        boolean r3 = true;
    L9:
        StringBuilder r1 = r0.append(r3).append(" sourceSurface=");
        if (r6 == null) goto L12;
        boolean r4 = true;
    L13:
        StringBuilder r2 = r1.append(r4).append(" state=");
        if (r7 != null) goto L16;
        String r8 = null;
    L17:
        a(TAG, r2.append(r8).toString());
        if (r5 == null) goto L23;
        if (r7 == null) goto L23;
        this.E = true;
        this.D = true;
        return b(r5, r6, r7);
    L23:
        return false;
    L16:
        r8 = a(r7);
        goto L17
    L12:
        r4 = false;
        goto L13
    L8:
        r3 = false;
        goto L9
    }

    private final boolean a(SurfaceControl r2, Bundle r3) {
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L6;
        return false;
    L6:
        if (r2 == null) goto L11;
        if (r3 == null) goto L11;
        return b(r2, r3);
    L11:
        return a("hideOnly", (d.h.a.a) ZeusTransformUtils.preCheckCast(new i(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private final void h() {
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L5;
        return;
    L5:
        a(TAG, "onTransitionCancelled");
        final d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new j(this), d.h.a.a.class, "com.obric.aiagent.plugin");
        if (o.a(Looper.myLooper(), Looper.getMainLooper()) == false) goto L9;
        r0.invoke();
        return;
    L9:
        this.f36699b.post(new $$Lambda$FloatingTransitionBridge$dINEmUeFR46jcizdmnLyJp0FjK0(r0));
    }

    private static final void a(d.h.a.a r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "$cleanup");
        r3.invoke();
    }

    private final void i() {
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L5;
        return;
    L5:
        a(TAG, "onTransitionFinished");
        final d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new k(this), d.h.a.a.class, "com.obric.aiagent.plugin");
        if (o.a(Looper.myLooper(), Looper.getMainLooper()) == false) goto L8;
        r0.invoke();
        return;
    L8:
        this.f36699b.post(new $$Lambda$FloatingTransitionBridge$l3owZKKUsobU30d1ZX4fO8GmK4(r0));
    }

    private static final void b(d.h.a.a r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "$tmp0");
        r3.invoke();
    }

    private final boolean b(SurfaceControl r12, Bundle r13) {
        long r0 = SystemClock.uptimeMillis();
        AtomicReference r2 = new AtomicReference();
        boolean r14 = a(this, "sourceHideDraw", 240, false, (d.h.a.b) ZeusTransformUtils.preCheckCast(new f(r13, this, r12, r2), d.h.a.b.class, "com.obric.aiagent.plugin"), 4, null);
        if (r14 == true) goto L5;
    L7:
        boolean r11 = false;
    L8:
        a(TAG, "sourceHideShowSurface ready=" + r11 + " scheduled=" + r14 + " costMs=" + (SystemClock.uptimeMillis() - r0));
        return r11;
    L5:
        if (a((CountDownLatch) ZeusTransformUtils.preCheckCast(r2.get(), CountDownLatch.class, "com.obric.aiagent.plugin"), "sourceHideShowSurface", 240) == false) goto L7;
        r11 = true;
        goto L8
    }

    private final boolean a(String r9, d.h.a.a<Boolean> r10) {
        final d.h.a.a r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (o.a(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        final CountDownLatch r1 = new CountDownLatch(1);
        final AtomicBoolean r4 = new AtomicBoolean(true);
        final AtomicReference r3 = new AtomicReference(false);
        this.f36699b.post(new $$Lambda$FloatingTransitionBridge$oYC87mhdZSbPAmOWBV8PxqeCPU(r4, r1, r3, r11));
    L13:
        r4.set(false);
        Thread.currentThread().interrupt();
        a(TAG, o.a("floating source hide wait interrupted reason=", r9));
        return false;
    L8:
        if (r1.await(240, TimeUnit.MILLISECONDS) == false) goto L10;
        Boolean r8 = (Boolean) ZeusTransformUtils.preCheckCast(r3.get(), Boolean.class, "com.obric.aiagent.plugin");     // Catch: InterruptedException -> L13
    L11:
        o.c(r8, "{\n            if (latch.…e\n            }\n        }");     // Catch: InterruptedException -> L13
        return r8.booleanValue();
    L10:
        r4.set(false);     // Catch: InterruptedException -> L13
        a(TAG, o.a("floating source hide wait timeout reason=", r9));     // Catch: InterruptedException -> L13
        r8 = false;     // Catch: InterruptedException -> L13
        goto L11
    L5:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r11.invoke(), Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    }

    private static final void a(AtomicBoolean r2, CountDownLatch r3, AtomicReference r4, d.h.a.a r5) {
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r2, "$shouldRun");
        o.e(r3, "$latch");
        o.e(r4, "$result");
        o.e(r6, "$action");
        if (r2.get() == true) goto L12;
        r3.countDown();
        return;
    L12:
        r4.set(r6.invoke());     // Catch: Throwable -> L9
        r3.countDown();
        return;
    L9:
        th = move-exception;
        r3.countDown();
        throw th;
    }

    static /* synthetic */ boolean a(FloatingTransitionBridge r6, String r7, long r8, boolean r10, d.h.a.b r11, int r12, Object r13) {
        d.h.a.b<? super d.h.a.b<? super Boolean, x>, x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        if ((r12 & 4) == 0) goto L6;
        r10 = false;
    L6:
        return r6.a(r7, r8, r10, r5);
    }

    private final boolean a(final String r22, long r23, boolean r25, d.h.a.b<? super d.h.a.b<? super Boolean, x>, x> r26) {
        final d.h.a.b r3 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r26, d.h.a.b.class, "com.obric.aiagent.plugin");
        long r11 = SystemClock.uptimeMillis();
        if (o.a(Looper.myLooper(), Looper.getMainLooper()) == false) goto L22;
        z.a r0 = new z.a();
        z.a r2 = new z.a();
        r3.invoke(new l(r0, r2));
        if (r0.f38499a == true) goto L9;
        a(TAG, o.a("async main action not completed synchronously reason=", r22));
        if (r25 == false) goto L9;
        return true;
    L9:
        StringBuilder r4 = new StringBuilder().append("async main action done reason=").append(r22).append(" result=");
        if (r0.f38499a == true) goto L12;
    L14:
        boolean r5 = false;
    L15:
        a(TAG, r4.append(r5).append(" onMain=true costMs=").append(SystemClock.uptimeMillis() - r11).toString());
        if (r0.f38499a == false) goto L21;
        if (r2.f38499a == false) goto L21;
        return true;
    L21:
        return false;
    L12:
        if (r2.f38499a == false) goto L14;
        r5 = true;
        goto L15
    L22:
        final CountDownLatch r6 = new CountDownLatch(1);
        AtomicBoolean r1 = new AtomicBoolean(true);
        final AtomicReference r7 = new AtomicReference(false);
        OFloatingTitleBar r8 = this.f36699b;
        final AtomicBoolean r21 = r1;
        r8.post(new $$Lambda$FloatingTransitionBridge$x19nJc0pL2S9VFbegSg1ZKhy5k(r21, r6, r3, r22, r7));
        if (r6.await(r23, TimeUnit.MILLISECONDS) == true) goto L47;
        r21 = r21;
        String r9 = TAG;
        boolean r10 = false;
        r21.set(false);     // Catch: InterruptedException -> L40
        a(r9, "async main action timeout reason=" + r22 + " timeoutMs=" + r23 + " costMs=" + (SystemClock.uptimeMillis() - r11));     // Catch: InterruptedException -> L40
        Boolean r12 = false;
    L33:
        o.c(r12, "{\n            if (latch.…e\n            }\n        }");     // Catch: InterruptedException -> L40
        return r12.booleanValue();
    L37:
        r21.set(r10);
        Thread.currentThread().interrupt();
        a(r9, "async main action interrupted reason=" + r22 + " costMs=" + (SystemClock.uptimeMillis() - r11));
        return r10;
    L47:
        r12 = (Boolean) ZeusTransformUtils.preCheckCast(r7.get(), Boolean.class, "com.obric.aiagent.plugin");     // Catch: InterruptedException -> L29
        String r13 = "async main action done reason=" + r22 + " result=" + r12 + " costMs=" + (SystemClock.uptimeMillis() - r11);     // Catch: InterruptedException -> L29
        r9 = TAG;
        a(r9, r13);     // Catch: InterruptedException -> L39
        r21 = r21;
        r10 = false;
    L36:
        r10 = false;
    L29:
        r9 = TAG;
    L35:
        r9 = TAG;
        goto L36
    }

    private static final void a(AtomicBoolean r2, CountDownLatch r3, d.h.a.b r4, String r5, AtomicReference r6) {
        d.h.a.b r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r2, "$shouldRun");
        o.e(r3, "$latch");
        o.e(r7, "$action");
        o.e(r5, "$reason");
        o.e(r6, "$result");
        if (r2.get() == true) goto L11;
        r3.countDown();
        return;
    L11:
        r7.invoke(new m(r6, r3));     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        a(TAG, "async main action failed reason=" + r5 + " error=" + th.getMessage());
        r6.set(false);
        r3.countDown();
    }

    private final boolean a(CountDownLatch r7, String r8, long r9) {
        boolean r0 = true;
        boolean r1 = false;
        if (r7 != null) goto L5;
    L16:
        StringBuilder r6 = new StringBuilder().append("transaction commit skip reason=").append(r8).append(" latch=");
        if (r7 == null) goto L19;
        r1 = true;
    L19:
        a(TAG, r6.append(r1).toString());
        return true;
    L5:
        if (o.a(Looper.myLooper(), Looper.getMainLooper()) == true) goto L16;
        long r3 = SystemClock.uptimeMillis();
    L14:
        Thread.currentThread().interrupt();
        a(TAG, "transaction commit interrupted reason=" + r8 + " costMs=" + (SystemClock.uptimeMillis() - r3));
        return false;
    L9:
        if (r7.await(r9, TimeUnit.MILLISECONDS) == false) goto L11;
        a(TAG, "transaction commit done reason=" + r8 + " costMs=" + (SystemClock.uptimeMillis() - r3));     // Catch: InterruptedException -> L14
    L22:
        return r0;
    L11:
        a(TAG, "transaction commit timeout reason=" + r8 + " timeoutMs=" + r9 + " costMs=" + (SystemClock.uptimeMillis() - r3));     // Catch: InterruptedException -> L14
        r0 = false;
        goto L22
    }

    static /* synthetic */ boolean a(FloatingTransitionBridge r1, SurfaceControl.Transaction r2, String r3, CountDownLatch r4, d.h.a.a r5, int r6, Object r7) {
        d.h.a.a<x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L9;
        r8 = null;
    L9:
        return r1.a(r2, r3, r4, r8);
    }

    private final boolean a(SurfaceControl.Transaction r12, String r13, final CountDownLatch r14, d.h.a.a<x> r15) {
        final d.h.a.a<x> r16 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r15, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L30;
        if (r16 != null) goto L30;
    L9:
        boolean r10 = false;
    L32:
        Method r3 = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);     // Catch: Throwable -> L27
        r3.setAccessible(true);     // Catch: Throwable -> L27
        Object r4 = r3.invoke(this.f36699b, new Object[0]);     // Catch: Throwable -> L27
        if (r4 != null) goto L14;
        a(TAG, o.a("applyTransactionOnDraw missing root reason=", r13));     // Catch: Throwable -> L27
        a(r12, r13, r14, r16, r10);     // Catch: Throwable -> L27
        return true;
    L14:
        Object r2 = r4.getClass().getMethod("applyTransactionOnDraw", new Class[]{SurfaceControl.Transaction.class}).invoke(r4, new Object[]{r12});     // Catch: Throwable -> L27
        if (ZeusTransformUtils.instanceOf(r2, Boolean.class) == false) goto L17;
        Boolean r1 = (Boolean) ZeusTransformUtils.preCheckCast(r2, Boolean.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
    L18:
        if (r1 != null) goto L20;
        boolean r5 = true;
    L21:
        if (r5 == true) goto L23;
        a(TAG, o.a("applyTransactionOnDraw returned false reason=", r13));     // Catch: Throwable -> L27
        a(r12, r13, r14, r16, r10);     // Catch: Throwable -> L27
    L29:
        return true;
    L23:
        this.f36699b.invalidate();     // Catch: Throwable -> L27
        if (r10 == true) goto L29;
        this.f36699b.postOnAnimation(new $$Lambda$FloatingTransitionBridge$R0ncc4JEfBkUUPXZDwv4UilcdI(r14, r16));     // Catch: Throwable -> L27
        goto L29
    L20:
        r5 = r1.booleanValue();     // Catch: Throwable -> L27
        goto L21
    L17:
        r1 = null;
    L27:
        th = move-exception;
        a(TAG, "applyTransactionOnDraw failed reason=" + r13 + " error=" + th.getMessage());
        a(r12, r13, r14, r16, r10);
    L30:
        r12.addTransactionCommittedListener($$Lambda$FloatingTransitionBridge$0ZmLwQhjgJX1g_8d3AsveOuDevw.INSTANCE, new $$Lambda$FloatingTransitionBridge$343bSk2zYT43CVEqAMmqigzx8(r14, r16, this));     // Catch: Throwable -> L7
        r10 = true;
    L7:
        th = move-exception;
        a(TAG, "add transaction commit listener failed reason=" + r13 + " error=" + th.getMessage());
        goto L9
    }

    private static final void a(Runnable r2) {
        ((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin")).run();
    }

    private static final void a(CountDownLatch r2, d.h.a.a r3, FloatingTransitionBridge r4) {
        final d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r4, "this$0");
        if (r2 == null) goto L6;
        r2.countDown();
    L6:
        if (r5 == null) goto L10;
        r4.f36699b.post(new $$Lambda$FloatingTransitionBridge$R5R7QnaBwTwnhU1q21_KwFyKvQA(r5));
        return;
    }

    private static final void c(d.h.a.a r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "$tmp0");
        r3.invoke();
    }

    private static final void a(CountDownLatch r2, d.h.a.a r3) {
        d.h.a.a r4 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.countDown();
    L6:
        if (r4 == null) goto L10;
        r4.invoke();
        return;
    }

    private final void a(SurfaceControl.Transaction r3, String r4, CountDownLatch r5, d.h.a.a<x> r6, boolean r7) {
        final d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        r3.apply();     // Catch: Throwable -> L5
        r3.close();     // Catch: Throwable -> L5
    L7:
        if (r7 == true) goto L17;
        if (r5 == null) goto L11;
        r5.countDown();
    L11:
        if (r8 == null) goto L18;
        this.f36699b.post(new $$Lambda$FloatingTransitionBridge$jlpweN95u1bTbep7bzGEgTGLdI(r8));
        return;
    L18:
        return;
    L17:
        return;
    L5:
        th = move-exception;
        a(TAG, "apply transaction immediately failed reason=" + r4 + " error=" + th.getMessage());
        goto L7
    }

    private static final void d(d.h.a.a r2) {
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "$tmp0");
        r3.invoke();
    }

    static /* synthetic */ void a(FloatingTransitionBridge r0, ViewGroup r1, OFloatingTitleBarActionHost r2, d r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = true;
    L5:
        r0.a(r1, r2, r3, r4);
    }

    private final void a(ViewGroup r4, OFloatingTitleBarActionHost r5, d r6, boolean r7) {
        r5.cancelFloatingTransitionState$OUI_standardRelease();     // Catch: Throwable -> L14
        if (r5.getParent() != r4) goto L7;
        r4.removeView((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
    L7:
        if (this.g != r5) goto L9;
        this.g = null;     // Catch: Throwable -> L14
    L9:
        if (r6 == null) goto L12;
        r6.a(r7);     // Catch: Throwable -> L14
    L12:
        a(TAG, "floating source hide cleanup");     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        a(TAG, o.a("floating source hide cleanup failed: ", th.getMessage()));
    }

    public static /* synthetic */ void a(FloatingTransitionBridge r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = false;
    L5:
        r0.a(r1);
    }

    public final void a(boolean r8) {
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L6;
        return;
    L6:
        if (this.f36700c == false) goto L9;
        if (r8 == true) goto L9;
        return;
    L9:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f36699b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "titleBar.context");
        Activity r2 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(r1), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L12;
        return;
    L12:
        IBinder r3 = a(r2);
        if (r3 != null) goto L15;
        return;
    L15:
        IFloatingTransitionSession r4 = u();
        if (r4 != null) goto L25;
        return;
    L25:
        boolean r5 = r4.registerTitleBar(r3, (IFloatingTransitionCallback) ZeusTransformUtils.preCheckCast(this.H, IFloatingTransitionCallback.class, "com.obric.aiagent.plugin"), (IFloatingTransitionStateProvider) ZeusTransformUtils.preCheckCast(this.I, IFloatingTransitionStateProvider.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22
        this.f36701d = r3;     // Catch: Throwable -> L22
        this.f36700c = true;     // Catch: Throwable -> L22
        f36697J.put(r3, this);     // Catch: Throwable -> L22
        a(TAG, "register token=" + r3 + " hideOnRegister=" + r5 + " force=" + r8);     // Catch: Throwable -> L22
        d();     // Catch: Throwable -> L22
        if (r5 == false) goto L27;
        this.E = true;     // Catch: Throwable -> L22
        this.x = true;     // Catch: Throwable -> L22
        r();     // Catch: Throwable -> L22
        this.w = false;     // Catch: Throwable -> L22
        return;
    L27:
        return;
    L22:
        th = move-exception;
        a(TAG, o.a("floating register failed: ", th.getMessage()));
    }

    public static /* synthetic */ void a(FloatingTransitionBridge r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = true;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = true;
    L8:
        r1.a(r2, r3);
    }

    public final void a(boolean r6, boolean r7) {
        j();
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f36699b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r0, "titleBar.context");
        Activity r1 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(r0), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L6;
        this.f36701d = null;
        this.f36700c = false;
        return;
    L6:
        if (r7 == false) goto L8;
        b(r6, true);
    L8:
        IBinder r8 = this.f36701d;
        if (r8 != null) goto L12;
        this.f36700c = false;
        return;
    L12:
        IFloatingTransitionSession r9 = u();
        if (r9 != null) goto L19;
        Map<IBinder, FloatingTransitionBridge> r10 = f36697J;
        if (r10.get(r8) != this) goto L17;
        r10.remove(r8);
    L17:
        this.f36701d = null;
        this.f36700c = false;
        return;
    L19:
        Map<IBinder, FloatingTransitionBridge> r2 = f36697J;
        if (r2.get(r8) == this) goto L42;
        a(TAG, o.a("floating unregister skip nonOwner token=", r8));
        this.f36701d = null;
        this.f36700c = false;
        return;
    L42:
        r9.unregisterTitleBar(r8);     // Catch: Throwable -> L28
        if (r2.get(r8) != this) goto L27;
        r2.remove(r8);
    L27:
        this.f36701d = null;
        this.f36700c = false;
        return;
    L28:
        th = move-exception;
        a(TAG, o.a("floating unregister failed: ", th.getMessage()));     // Catch: Throwable -> L34
        if (f36697J.get(r8) != this) goto L27;
        f36697J.remove(r8);
    L34:
        th = move-exception;
        Map<IBinder, FloatingTransitionBridge> r3 = f36697J;
        if (r3.get(r8) != this) goto L38;
        r3.remove(r8);
    L38:
        this.f36701d = null;
        this.f36700c = false;
        throw th;
    }

    public final void d() {
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L6;
        return;
    L6:
        if (this.f36700c == true) goto L8;
        return;
    L8:
        if (this.f36699b.getWidth() != 0) goto L10;
        return;
    L10:
        if (this.f36699b.getHeight() == 0) goto L27;
        IBinder r0 = this.f36701d;
        if (r0 != null) goto L15;
        return;
    L15:
        IFloatingTransitionSession r1 = u();
        if (r1 != null) goto L23;
        return;
    L23:
        Bundle r2 = k();     // Catch: Throwable -> L20
        this.r = new Bundle(r2);     // Catch: Throwable -> L20
        r1.updateState(r0, r2);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        a(TAG, o.a("floating update state failed: ", th.getMessage()));
        return;
    }

    public final void e() {
        d();
        c("stateChanged");
    }

    public final void a(String r7) {
        o.e(r7, "reason");
        if (com.obric.oui.titlebar.floating.a.a() == true) goto L5;
        return;
    L5:
        boolean r1 = false;
        if (this.E == false) goto L8;
    L13:
        boolean r0 = true;
    L15:
        if (this.D == false) goto L19;
        a(TAG, "restoreHiddenActionsIfIdle skipped reason=" + r7 + " pending=true");
        b(r7);
        return;
    L19:
        if (this.x == false) goto L24;
        if (r0 == false) goto L24;
        a(TAG, "restoreHiddenActionsIfIdle skipped reason=" + r7 + " hiddenByRegister=true");
        b(r7);
        return;
    L24:
        if (this.s == false) goto L26;
    L36:
        StringBuilder r2 = new StringBuilder().append("restoreHiddenActionsIfIdle skipped reason=").append(r7).append(" hidden=").append(this.w).append(" drawing=").append(this.s).append(" overlay=");
        if (this.q == null) goto L39;
        r1 = true;
    L39:
        a(TAG, r2.append(r1).toString());
        b(r7);
        return;
    L26:
        if (this.q != null) goto L36;
        if (this.w == false) goto L31;
    L34:
        j();
        e(r7);
        return;
    L31:
        if (this.x == true) goto L34;
        a(TAG, "restoreHiddenActionsIfIdle skipped reason=" + r7 + " hidden=false");
        return;
    L8:
        if (this.s == true) goto L13;
        if (this.q != null) goto L13;
        r0 = false;
        goto L15
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.obric.oui.titlebar.floating.-$$Lambda$FloatingTransitionBridge$lIyy7DFzJSMth0USZyv9OduVxbw] */
    private final void b(final String r6) {
        j();
        final z.f r0 = new z.f();
        r0.f38504a = new $$Lambda$FloatingTransitionBridge$lIyy7DFzJSMth0USZyv9OduVxbw(this, r0, r6);
        Runnable r1 = null;
        if (r0.f38504a != 0) goto L5;
        o.c("task");
        Runnable r7 = null;
    L6:
        this.G = r7;
        OFloatingTitleBar r5 = this.f36699b;
        if (r0.f38504a != 0) goto L9;
        o.c("task");
    L10:
        r5.postDelayed(r1, 1200);
        return;
    L9:
        r1 = (Runnable) ZeusTransformUtils.preCheckCast(r0.f38504a, Runnable.class, "com.obric.aiagent.plugin");
        goto L10
    L5:
        r7 = (Runnable) ZeusTransformUtils.preCheckCast(r0.f38504a, Runnable.class, "com.obric.aiagent.plugin");
        goto L6
    }

    private static final void a(FloatingTransitionBridge r4, z.f r5, String r6) {
        o.e(r4, "this$0");
        o.e(r5, "$task");
        o.e(r6, "$reason");
        Runnable r0 = r4.G;
        if (r5.f38504a != 0) goto L5;
        o.c("task");
        Runnable r7 = null;
    L6:
        if (r0 == r7) goto L8;
        return;
    L8:
        r4.G = null;
        r4.d(r6);
        return;
    L5:
        r7 = (Runnable) ZeusTransformUtils.preCheckCast(r5.f38504a, Runnable.class, "com.obric.aiagent.plugin");
        goto L6
    }

    private final void c(String r2) {
        if (this.D == false) goto L5;
    L14:
        b(r2);
        return;
    L5:
        if (this.E == true) goto L14;
        if (this.s == true) goto L14;
        if (this.q != null) goto L14;
        if (this.w == true) goto L14;
        if (this.x == true) goto L14;
    }

    private final void d(String r3) {
        if (this.f36699b.isActionContentVisible() == false) goto L7;
        a(TAG, o.a("restoreHiddenActionsIfIdle fallback skip visible reason=", r3));
        return;
    L7:
        if (this.D == false) goto L9;
    L19:
        a(TAG, o.a("restoreHiddenActionsIfIdle fallback reason=", r3));
        b(true, true);
        return;
    L9:
        if (this.E == true) goto L19;
        if (this.s == true) goto L19;
        if (this.q != null) goto L19;
        if (this.w == true) goto L19;
        if (this.x == true) goto L19;
    }

    private final void e(String r2) {
        a(TAG, o.a("restoreHiddenActionsIfIdle reason=", r2));
        this.E = false;
        this.f36699b.onFloatingTransitionEnd$OUI_standardRelease();
        o();
        this.x = false;
        this.w = false;
    }

    private final void j() {
        Runnable r0 = this.G;
        if (r0 == null) goto L6;
        this.f36699b.removeCallbacks(r0);
    L6:
        this.G = null;
    }

    private final Bundle k() {
        return this.f36699b.captureState().g();
    }

    private final Bundle l() {
        if (o.a(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        long r2 = SystemClock.uptimeMillis();
        final AtomicReference r4 = new AtomicReference();
        final CountDownLatch r5 = new CountDownLatch(1);
        this.f36699b.post(new $$Lambda$FloatingTransitionBridge$kVLsnMBSYR9g9WACnNMvPtGWQ8(r4, this, r5));
    L19:
        Thread.currentThread().interrupt();
        Bundle r6 = this.r;
        if (r6 != null) goto L22;
        r6 = new Bundle();
    L22:
        a(TAG, "captureSync interrupted costMs=" + (SystemClock.uptimeMillis() - r2) + " fallback=" + a(r6));
        return r6;
    L8:
        if (r5.await(240, TimeUnit.MILLISECONDS) == false) goto L14;
        Bundle r7 = (Bundle) ZeusTransformUtils.preCheckCast(r4.get(), Bundle.class, "com.obric.aiagent.plugin");     // Catch: InterruptedException -> L19
        if (r7 != null) goto L25;
        Bundle r8 = this.r;     // Catch: InterruptedException -> L19
        if (r8 == null) goto L27;
        return r8;
    L27:
        return new Bundle();
    L25:
        return r7;
    L14:
        Bundle r9 = this.r;     // Catch: InterruptedException -> L19
        if (r9 != null) goto L17;
        r9 = new Bundle();     // Catch: InterruptedException -> L19
    L17:
        a(TAG, "captureSync timeout costMs=" + (SystemClock.uptimeMillis() - r2) + " fallback=" + a(r9));     // Catch: InterruptedException -> L19
        return r9;
    L5:
        return t();
    }

    private static final void a(AtomicReference r1, FloatingTransitionBridge r2, CountDownLatch r3) {
        o.e(r1, "$captured");
        o.e(r2, "this$0");
        o.e(r3, "$latch");
        r1.set(r2.t());
        r3.countDown();
    }

    private final boolean b(SurfaceControl r11, SurfaceControl r12, Bundle r13) {
        long r0 = SystemClock.uptimeMillis();
        AtomicReference r8 = new AtomicReference();
        boolean r14 = a("transitionStart", 240, true, (d.h.a.b) ZeusTransformUtils.preCheckCast(new h(this, r11, r12, r13, r8), d.h.a.b.class, "com.obric.aiagent.plugin"));
        boolean r15 = false;
        if (r14 == true) goto L5;
        this.E = false;
        this.D = false;
    L5:
        if (r14 == true) goto L7;
    L9:
        a(TAG, "targetFirstFrame ready=" + r15 + " scheduled=" + r14 + " costMs=" + (SystemClock.uptimeMillis() - r0));
        return r15;
    L7:
        if (a((CountDownLatch) ZeusTransformUtils.preCheckCast(r8.get(), CountDownLatch.class, "com.obric.aiagent.plugin"), "targetFirstFrame", 240) == false) goto L9;
        r15 = true;
        goto L9
    }

    private final void a(SurfaceControl r18, SurfaceControl r19, Bundle r20, AtomicReference<CountDownLatch> r21, d.h.a.b<? super Boolean, x> r22) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r22, d.h.a.b.class, "com.obric.aiagent.plugin");
        com.obric.oui.titlebar.a r0 = com.obric.oui.titlebar.a.f36624a.a(r20);
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f36699b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "titleBar.context");
        com.obric.oui.titlebar.a r14 = r0.a(r1);
        com.obric.oui.titlebar.a r11 = a(this.f36699b.captureState(), r14);
        this.f36699b.getLocationOnScreen(new int[2]);
        Context r2 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f36699b.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r2, "titleBar.context");
        Activity r3 = (Activity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getActivity(r2), "com.obric.aiagent.plugin"), Activity.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
    L4:
        View r4 = null;
    L10:
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == false) goto L12;
        ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin");
    L14:
        if (r3 == null) goto L30;
        if (r5 != null) goto L17;
        FloatingTransitionBridge r7 = this;
    L31:
        r7.E = false;
        r7.D = false;
        r6.invoke(false);
        return;
    L17:
        SurfaceControl r9 = r14.f();
        if (r9 != null) goto L20;
        boolean r8 = true;
    L21:
        b(false, r8);
        this.E = true;
        this.D = true;
        this.z = false;
        this.A = null;
        OFloatingTitleBarActionHost r15 = a((Context) ZeusTransformUtils.preCheckCast(r3, Context.class, "com.obric.aiagent.plugin"), r5, r14, r11);
        d r10 = a(r18, r14, "Transition", r11);
        if (r10 != null) goto L26;
        this.z = true;
        this.A = null;
        this.E = false;
        this.D = false;
        a(r5, r15, null, r18, true);
        r6.invoke(false);
        return;
    L26:
        if (r14.e() == null) goto L28;
        a(TAG, o.a("restore snapshot source=", a(r14)));
    L28:
        this.g = r15;
        this.q = new a(r5, r15, r10, r18);
        f();
        this.B = false;
        this.s = true;
        a(r15, r14, r10, "targetFirstFrameDraw", (d.h.a.b) ZeusTransformUtils.preCheckCast(new g(this, r5, r15, r10, r18, r6, r21, r19, r9, r14, r11), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return;
    L20:
        r8 = false;
        goto L21
    L30:
        r7 = this;
        goto L31
    L12:
        r5 = null;
        goto L14
    L5:
        Window r12 = ZeusTransformUtils.getWindow(r3, "com.obric.aiagent.plugin");
        if (r12 == null) goto L4;
        r4 = r12.getDecorView();
        goto L10
    }

    private final void a(SurfaceControl r3, String r4) {
        r3.release();     // Catch: Throwable -> L5
        a(TAG, o.a("releaseSurfaceControl done reason=", r4));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        a(TAG, "releaseSurfaceControl failed reason=" + r4 + " error=" + th.getMessage());
    }

    private final void a(SurfaceControl.Transaction r2, SurfaceControl r3) {
        a(r2, VDPlayerEffectProviderImpl.METHOD_SHOW, r3);
    }

    private final void b(SurfaceControl.Transaction r2, SurfaceControl r3) {
        a(r2, "remove", r3);
    }

    private final void a(SurfaceControl.Transaction r5, String r6, SurfaceControl r7) {
        Method r4 = SurfaceControl.Transaction.class.getDeclaredMethod(r6, new Class[]{SurfaceControl.class});     // Catch: Throwable -> L4
        r4.setAccessible(true);     // Catch: Throwable -> L4
        r4.invoke(r5, new Object[]{r7});     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        a(TAG, "transaction " + r6 + " failed: " + th.getMessage());
    }

    static /* synthetic */ OFloatingTitleBarActionHost a(FloatingTransitionBridge r1, Context r2, ViewGroup r3, com.obric.oui.titlebar.a r4, com.obric.oui.titlebar.a r5, int r6, Object r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r5 = null;
    L6:
        return r1.a(r8, r3, r4, r5);
    }

    private final OFloatingTitleBarActionHost a(Context r14, ViewGroup r15, com.obric.oui.titlebar.a r16, com.obric.oui.titlebar.a r17) {
        OFloatingTitleBarActionHost r1 = new OFloatingTitleBarActionHost((Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.aiagent.plugin"), null, 0, 6, null);
        int r3 = 0;
        r1.setClipChildren(false);
        r1.setClipToPadding(false);
        OFloatingTitleBarActionHost.applyState$OUI_standardRelease$default(r1, r16, false, false, null, null, 28, null);
        r1.setVisibility(4);
        Integer r4 = Integer.valueOf(r16.a().a());
        boolean r6 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r5 = true;
    L6:
        Integer r7 = null;
        if (r5 == true) goto L10;
        r4 = null;
    L10:
        if (r4 != null) goto L12;
        int r8 = this.f36699b.getWidth();
    L13:
        if (r17 != null) goto L15;
    L14:
        int r9 = 0;
    L28:
        int r10 = Math.max(r8, r9);
        Integer r11 = Integer.valueOf(r16.a().b());
        if (((Number) ZeusTransformUtils.preCheckCast(r11, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L31;
        boolean r12 = true;
    L32:
        if (r12 == true) goto L35;
        r11 = null;
    L35:
        if (r11 != null) goto L37;
        int r0 = this.f36699b.getHeight();
    L38:
        if (r17 == null) goto L52;
        com.obric.oui.titlebar.a.e r13 = r17.a();
        if (r13 == null) goto L52;
        Integer r18 = Integer.valueOf(r13.b());
        if (((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L47;
        r6 = false;
    L47:
        if (r6 == false) goto L49;
        r7 = r18;
    L49:
        if (r7 == null) goto L52;
        r3 = r7.intValue();
    L52:
        int r2 = Math.max(r0, r3);
        View r19 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
        FrameLayout.LayoutParams r20 = new FrameLayout.LayoutParams(r10, r2);
        r20.topMargin = (-r2) - 1000;
        x r21 = x.f38692a;
        r15.addView(r19, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r20, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r1.useSurfaceBackdropMaterial$OUI_standardRelease();
        return r1;
    L37:
        r0 = r11.intValue();
        goto L38
    L31:
        r12 = false;
        goto L32
    L15:
        com.obric.oui.titlebar.a.e r22 = r17.a();
        if (r22 == null) goto L14;
        Integer r23 = Integer.valueOf(r22.a());
        if (((Number) ZeusTransformUtils.preCheckCast(r23, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L21;
        boolean r24 = true;
    L22:
        if (r24 == true) goto L25;
        r23 = null;
    L25:
        if (r23 == null) goto L14;
        r9 = r23.intValue();
        goto L28
    L21:
        r24 = false;
        goto L22
    L12:
        r8 = r4.intValue();
        goto L13
    L5:
        r5 = false;
        goto L6
    }

    static /* synthetic */ d a(FloatingTransitionBridge r0, SurfaceControl r1, com.obric.oui.titlebar.a r2, String r3, com.obric.oui.titlebar.a r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = null;
    L6:
        return r0.a(r1, r2, r3, r4);
    }

    private final d a(SurfaceControl r19, com.obric.oui.titlebar.a r20, String r21, com.obric.oui.titlebar.a r22) {
        Integer r1 = Integer.valueOf(r20.a().a());
        if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L9;
        r1 = null;
    L9:
        if (r1 != null) goto L11;
        int r3 = this.f36699b.getWidth();
    L12:
        if (r22 != null) goto L14;
    L13:
        int r4 = 0;
    L27:
        int r5 = Math.max(r3, r4);
        Integer r6 = Integer.valueOf(r20.a().b());
        if (((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L30;
        boolean r7 = true;
    L31:
        if (r7 == true) goto L34;
        r6 = null;
    L34:
        if (r6 != null) goto L36;
        int r8 = this.f36699b.getHeight();
    L37:
        if (r22 != null) goto L39;
    L38:
        int r9 = 0;
    L52:
        int r10 = Math.max(r8, r9);
        int r11 = m() + r10;
        if (r5 <= 0) goto L73;
        if (r10 <= 0) goto L73;
        SurfaceControl r12 = new SurfaceControl.Builder().setName(o.a("FloatingTitleBar", r21)).setParent(r19).setBufferSize(r5, r11).setFormat(-3).build();     // Catch: Throwable -> L70
        o.c(r12, "Builder()\n              …\n                .build()");     // Catch: Throwable -> L70
        Class<?> r13 = this.k;     // Catch: Throwable -> L70
        if (r13 != null) goto L59;
        r13 = ZeusTransformUtils.forName("android.graphics.BLASTBufferQueue", "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        this.k = r13;     // Catch: Throwable -> L70
    L59:
        Class<?> r15 = Boolean.TYPE;     // Catch: Throwable -> L70
        o.a(r15);     // Catch: Throwable -> L70
        Object r14 = r13.getDeclaredConstructor(new Class[]{String.class, r15}).newInstance(new Object[]{o.a("FloatingTitleBarBBQ", r21), false});     // Catch: Throwable -> L70
        Method r16 = this.l;     // Catch: Throwable -> L70
        if (r16 != null) goto L62;
        Class<?> r17 = Integer.TYPE;     // Catch: Throwable -> L70
        o.a(r17);     // Catch: Throwable -> L70
        Class<?> r18 = Integer.TYPE;     // Catch: Throwable -> L70
        o.a(r18);     // Catch: Throwable -> L70
        Class<?> r110 = Integer.TYPE;     // Catch: Throwable -> L70
        o.a(r110);     // Catch: Throwable -> L70
        r16 = r13.getDeclaredMethod("update", new Class[]{SurfaceControl.class, r17, r18, r110});     // Catch: Throwable -> L70
        r16.setAccessible(true);     // Catch: Throwable -> L70
        this.l = r16;     // Catch: Throwable -> L70
    L62:
        r16.invoke(r14, new Object[]{r12, Integer.valueOf(r5), Integer.valueOf(r11), -3});     // Catch: Throwable -> L70
        Method r23 = this.m;     // Catch: Throwable -> L70
        if (r23 != null) goto L65;
        r23 = r13.getDeclaredMethod("createSurface", new Class[0]);     // Catch: Throwable -> L70
        r23.setAccessible(true);     // Catch: Throwable -> L70
        this.m = r23;     // Catch: Throwable -> L70
    L65:
        Object r24 = r23.invoke(r14, new Object[0]);     // Catch: Throwable -> L70
        if (r24 == null) goto L69;
        Surface r25 = (Surface) ZeusTransformUtils.preCheckCast(r24, Surface.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L70
        o.c(r14, "bbq");     // Catch: Throwable -> L70
        return new d(this, r19, r12, r25, r14, r20, r22);
    L69:
        throw new NullPointerException("null cannot be cast to non-null type android.view.Surface");     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        a(TAG, "createOverlayRenderTarget failed name=" + r21 + " error=" + th.getMessage());
        return (d) ZeusTransformUtils.preCheckCast(null, d.class, "com.obric.aiagent.plugin");
    L73:
        a(TAG, "createOverlayRenderTarget skipped name=" + r21 + " width=" + r5 + " height=" + r10);
        return null;
    L39:
        com.obric.oui.titlebar.a.e r26 = r22.a();
        if (r26 == null) goto L38;
        Integer r27 = Integer.valueOf(r26.b());
        if (((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L45;
        boolean r28 = true;
    L46:
        if (r28 == true) goto L49;
        r27 = null;
    L49:
        if (r27 == null) goto L38;
        r9 = r27.intValue();
        goto L52
    L45:
        r28 = false;
        goto L46
    L36:
        r8 = r6.intValue();
        goto L37
    L30:
        r7 = false;
        goto L31
    L14:
        com.obric.oui.titlebar.a.e r29 = r22.a();
        if (r29 == null) goto L13;
        Integer r30 = Integer.valueOf(r29.a());
        if (((Number) ZeusTransformUtils.preCheckCast(r30, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L20;
        boolean r31 = true;
    L21:
        if (r31 == true) goto L24;
        r30 = null;
    L24:
        if (r30 == null) goto L13;
        r4 = r30.intValue();
        goto L27
    L20:
        r31 = false;
        goto L21
    L11:
        r3 = r1.intValue();
        goto L12
    L5:
        r2 = false;
        goto L6
    }

    private final int m() {
        return (int) ((32 * ZeusTransformUtils.getResources(this.f36699b, "com.obric.aiagent.plugin").getDisplayMetrics().density) + 0.5f);
    }

    private final void a(OFloatingTitleBarActionHost r7, com.obric.oui.titlebar.a r8) {
        Integer r0 = Integer.valueOf(r8.a().a());
        boolean r3 = true;
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        Integer r5 = null;
        if (r1 == true) goto L10;
        r0 = null;
    L10:
        if (r0 != null) goto L12;
        int r2 = this.f36699b.getWidth();
    L13:
        Integer r9 = Integer.valueOf(r8.a().b());
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).intValue() > 0) goto L17;
        r3 = false;
    L17:
        if (r3 == false) goto L19;
        r5 = r9;
    L19:
        if (r5 != null) goto L21;
        int r6 = this.f36699b.getHeight();
    L22:
        if (r2 <= 0) goto L27;
        if (r6 <= 0) goto L27;
        r7.measure(View.MeasureSpec.makeMeasureSpec(r2, 1073741824), View.MeasureSpec.makeMeasureSpec(r6, 1073741824));
        r7.layout(0, 0, r2, r6);
        return;
    L27:
        a(TAG, "layoutActionHost skipped width=" + r2 + " height=" + r6);
        return;
    L21:
        r6 = r5.intValue();
        goto L22
    L12:
        r2 = r0.intValue();
        goto L13
    L5:
        r1 = false;
        goto L6
    }

    private final void a(final OFloatingTitleBarActionHost r13, final com.obric.oui.titlebar.a r14, final d r15, final String r16, d.h.a.b<? super Boolean, x> r17) {
        final d.h.a.b r10 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r17, d.h.a.b.class, "com.obric.aiagent.plugin");
        final z.a r9 = new z.a();
        a(r13, r14);
        final ViewTreeObserver r0 = r13.getViewTreeObserver();
        if (r0.isAlive() == true) goto L6;
        a(TAG, "overlay draw failed reason=" + r16 + " dead observer");
        b(r9, r10, false);
        return;
    L6:
        r0.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(new FloatingTransitionBridge$drawOverlayWhenHostReady$listener$1(r13, r0, this, r15, r16, r14, r9, r10), ViewTreeObserver.OnPreDrawListener.class, "com.obric.aiagent.plugin"));
        r13.requestLayout();
        r13.invalidate();
    }

    private static final void b(z.a r2, d.h.a.b<? super Boolean, x> r3, boolean r4) {
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r2.f38499a == false) goto L5;
        return;
    L5:
        r2.f38499a = true;
        r5.invoke(Boolean.valueOf(r4));
    }

    private static final boolean b(FloatingTransitionBridge r5, d r6, String r7, OFloatingTitleBarActionHost r8, com.obric.oui.titlebar.a r9, String r10) {
        a r0 = r5.q;
        boolean r1 = false;
        if (r0 == null) goto L7;
        if (r0.c() == r6) goto L7;
    L8:
        a(TAG, "overlay draw skipped reason=" + r7 + " stage=" + r10 + " stale=true");
        return false;
    L7:
        if (r6.d() == false) goto L8;
        r5.a(r8, r9);
        String r11 = a(r5, (View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), 0.0f, 2, null);
        if (r11 == null) goto L15;
        a(TAG, "overlay draw wait reason=" + r7 + " stage=" + r10 + " unready=" + r11);
        return false;
    L15:
        if (r6.b().isValid() == true) goto L17;
    L19:
        if (r1 == true) goto L21;
        a(TAG, "overlay draw failed reason=" + r7 + " stage=" + r10 + " surfaceValid=" + r6.b().isValid());
    L21:
        return r1;
    L17:
        if (r5.a(r6) == false) goto L19;
        r1 = true;
        goto L19
    }

    static /* synthetic */ String a(FloatingTransitionBridge r0, View r1, float r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 1.0f;
    L6:
        return r0.a(r1, r2);
    }

    private final String a(View r7, float r8) {
        if (r7.getVisibility() == 0) goto L5;
        return null;
    L5:
        float r9 = r8 * r7.getAlpha();
        int r3 = 0;
        if (ZeusTransformUtils.instanceOf(r7, TextView.class) == false) goto L29;
        if (r9 < 0.99f) goto L29;
        CharSequence r0 = ((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin")).getText();
        boolean r5 = true;
        if (r0 != null) goto L13;
    L11:
        r5 = false;
    L17:
        if (r5 == false) goto L29;
        if (((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin")).getWidth() <= 0) goto L27;
        if (((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin")).getHeight() <= 0) goto L27;
        if (((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin")).isLayoutRequested() == true) goto L27;
        if (((TextView) ZeusTransformUtils.preCheckCast(r7, TextView.class, "com.obric.aiagent.plugin")).getLayout() != null) goto L29;
    L27:
        return a(r7);
    L13:
        if (r0.length() <= 0) goto L15;
        boolean r1 = true;
    L16:
        if (r1 != true) goto L11;
    L15:
        r1 = false;
    L29:
        if (r7.getTag() == null) goto L41;
        if (r9 < 0.99f) goto L41;
        if (r7.getWidth() <= 0) goto L39;
        if (r7.getHeight() <= 0) goto L39;
        if (r7.isLayoutRequested() == false) goto L41;
    L39:
        return a(r7);
    L41:
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.class) == false) goto L48;
        int r2 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.aiagent.plugin")).getChildCount();
    L43:
        if (r3 >= r2) goto L48;
        int r4 = r3 + 1;
        View r6 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.aiagent.plugin")).getChildAt(r3);
        o.c(r6, "root.getChildAt(i)");
        String r10 = a(r6, r9);
        if (r10 != null) goto L46;
        r3 = r4;
        goto L43
    L46:
        return r10;
    L48:
        return null;
    }

    private final String a(View r4) {
        String r0 = null;
        if (ZeusTransformUtils.instanceOf(r4, TextView.class) == false) goto L5;
        TextView r3 = (TextView) ZeusTransformUtils.preCheckCast(r4, TextView.class, "com.obric.aiagent.plugin");
    L6:
        if (r3 == null) goto L12;
        CharSequence r5 = r3.getText();
        if (r5 == null) goto L12;
        r0 = r5.toString();
    L12:
        if (r0 != null) goto L14;
        r0 = "";
    L14:
        StringBuilder r6 = new StringBuilder();
        r6.append(r4.getClass().getSimpleName()).append('@').append(Integer.toHexString(System.identityHashCode(r4))).append(" tag=").append(r4.getTag()).append(" text=").append(r0).append(" vis=").append(r4.getVisibility()).append(" shown=").append(r4.isShown()).append(" alpha=").append(r4.getAlpha()).append(" size=").append(r4.getWidth()).append('x').append(r4.getHeight()).append(" measured=").append(r4.getMeasuredWidth()).append('x').append(r4.getMeasuredHeight()).append(" requestLayout=").append(r4.isLayoutRequested());
        return r6.toString();
    L5:
        r3 = null;
        goto L6
    }

    private final void n() {
        OFloatingTitleBarActionHost r0 = this.y;
        if (r0 != null) goto L5;
        return;
    L5:
        this.y = null;
        if (r0.getBoundTitleBar() == this.f36699b) goto L9;
        return;
    L9:
        if (this.F.contains(r0) == true) goto L11;
        this.F.add(r0);
    L11:
        r0.hideFloatingTransitionActions$OUI_standardRelease(true);
    }

    private final void o() {
        if (this.F.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(this.F, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((OFloatingTitleBarActionHost) ZeusTransformUtils.preCheckCast(r0.next(), OFloatingTitleBarActionHost.class, "com.obric.aiagent.plugin")).hideFloatingTransitionActions$OUI_standardRelease(false);
        goto L7
    L9:
        this.F.clear();
    }

    private final com.obric.oui.titlebar.a a(com.obric.oui.titlebar.a r14, com.obric.oui.titlebar.a r15) {
        com.obric.oui.titlebar.a.h r13 = r14.d();
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15.c().a(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L5;
    L7:
        int r0 = r14.d().a();
    L9:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15.c().b(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L11;
    L13:
        int r1 = r14.d().b();
    L15:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15.c().c(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L17;
    L19:
        int r3 = r14.d().c();
    L21:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r15.c().d(), Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L23;
    L25:
        int r16 = r14.d().d();
    L27:
        return com.obric.oui.titlebar.a.a(r14, null, null, null, r13.a(r0, r1, r3, r16), null, null, 55, null);
    L23:
        if (r14.c().d().isEmpty() == false) goto L25;
        r16 = r15.d().d();
        goto L27
    L17:
        if (r14.c().c().isEmpty() == false) goto L19;
        r3 = r15.d().c();
        goto L21
    L11:
        if (r14.c().b().isEmpty() == false) goto L13;
        r1 = r15.d().b();
        goto L15
    L5:
        if (r14.c().a().isEmpty() == false) goto L7;
        r0 = r15.d().a();
        goto L9
    }

    static /* synthetic */ void a(FloatingTransitionBridge r1, d r2, d.h.a.a r3, int r4, Object r5) {
        d.h.a.a<x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r6 = null;
    L5:
        r1.a(r2, r6);
    }

    private final void a(final d r3, d.h.a.a<x> r4) {
        d.h.a.a<x> r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        a r0 = this.q;
        if (r0 == null) goto L7;
        if (r0.c() == r3) goto L7;
        return;
    L7:
        if (r3.d() == false) goto L17;
        if (r5 == null) goto L13;
        this.f.add(r5);
    L13:
        if (this.f36702e == false) goto L15;
        return;
    L15:
        this.f36702e = true;
        this.f36699b.post(new $$Lambda$FloatingTransitionBridge$Zy_8uB6FBNg6vEybObTMVkv1t7w(this, r3));
        return;
    }

    private static final void a(FloatingTransitionBridge r3, d r4) {
        o.e(r3, "this$0");
        o.e(r4, "$renderTarget");
        boolean r0 = false;
        r3.f36702e = false;
        a r1 = r3.q;
        if (r1 == null) goto L7;
        if (r1.c() == r4) goto L7;
    L8:
        r3.f.clear();
        return;
    L7:
        if (r4.d() == false) goto L8;
        if (r4.b().isValid() == true) goto L13;
    L15:
        if (r0 == true) goto L17;
        return;
    L17:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r3.f, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L24;
        List r5 = d.a.p.o((Iterable) ZeusTransformUtils.preCheckCast(r3.f, Iterable.class, "com.obric.aiagent.plugin"));
        r3.f.clear();
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L20:
        if (r6.hasNext() == false) goto L25;
        ((d.h.a.a) ZeusTransformUtils.preCheckCast(r6.next(), d.h.a.a.class, "com.obric.aiagent.plugin")).invoke();
        goto L20
    L25:
        return;
    L24:
        return;
    L13:
        if (r3.a(r4) == false) goto L15;
        r0 = true;
        goto L15
    }

    private final boolean a(d r10) {
        OFloatingTitleBarActionHost r1 = this.g;
        if (r1 != null) goto L7;
        FloatingTransitionBridge r9 = (FloatingTransitionBridge) ZeusTransformUtils.preCheckCast(this, FloatingTransitionBridge.class, "com.obric.aiagent.plugin");
        return false;
    L7:
        if (r1.getWidth() > 0) goto L9;
    L35:
        a(TAG, "floating draw surface skipped empty host width=" + r1.getWidth() + " height=" + r1.getHeight());
        return false;
    L9:
        if (r1.getHeight() <= 0) goto L35;
        float r4 = r10.a(r1);
        r1.getLocationOnScreen(new int[2]);
        SurfaceControl.Transaction r6 = new SurfaceControl.Transaction();
        r6.setPosition(r10.a(), 0.0f, r4);
        a(r6, r10.a());
        a(r1, r10.a(), r4, r6);
        Long r5 = r10.e();
        if (r5 != null) goto L16;
        FloatingTransitionBridge r11 = (FloatingTransitionBridge) ZeusTransformUtils.preCheckCast(this, FloatingTransitionBridge.class, "com.obric.aiagent.plugin");
        r6.close();
        return false;
    L16:
        if (r10.a(r6, r5.longValue()) == true) goto L39;
        r6.close();
        return false;
    L39:
        Canvas r12 = r10.b().lockHardwareCanvas();     // Catch: Throwable -> L21
    L23:
        if (r12 != null) goto L37;
        return false;
    L37:
        r12.drawColor(0, PorterDuff.Mode.CLEAR);     // Catch: Throwable -> L28
        r1.draw(r12);     // Catch: Throwable -> L28
        r10.b().unlockCanvasAndPost(r12);
        return true;
    L28:
        th = move-exception;
        a(TAG, o.a("floating draw surface failed: ", th.getMessage()));     // Catch: Throwable -> L32
        r10.b().unlockCanvasAndPost(r12);
        return false;
    L32:
        th = move-exception;
        r10.b().unlockCanvasAndPost(r12);
        throw th;
    L21:
        th = move-exception;
        a(TAG, o.a("floating lock surface failed: ", th.getMessage()));
        r12 = (Canvas) ZeusTransformUtils.preCheckCast(null, Canvas.class, "com.obric.aiagent.plugin");
        goto L23
    }

    private final void a(OFloatingTitleBarActionHost r8, SurfaceControl r9, float r10, SurfaceControl.Transaction r11) {
        if (this.h == false) goto L5;
        return;
    L5:
        if (r9.isValid() == true) goto L22;
        return;
    L22:
        int[] r3 = new int[2];     // Catch: Throwable -> L19
        r8.getLocationOnScreen(r3);     // Catch: Throwable -> L19
        float[][] r12 = a((View) ZeusTransformUtils.preCheckCast(r8, View.class, "com.obric.aiagent.plugin"), new int[]{-r3[0], (-r3[1]) + d.i.a.a(r10)});     // Catch: Throwable -> L19
        if (((Object[]) ZeusTransformUtils.preCheckCast(r12, Object[].class, "com.obric.aiagent.plugin")).length != 0) goto L11;
        boolean r13 = true;
    L12:
        if (r13 == false) goto L14;
        return;
    L14:
        Method r14 = this.i;     // Catch: Throwable -> L19
        if (r14 != null) goto L17;
        r14 = SurfaceControl.Transaction.class.getDeclaredMethod("setBlurRegions", new Class[]{SurfaceControl.class, float[][].class});     // Catch: Throwable -> L19
        r14.setAccessible(true);     // Catch: Throwable -> L19
        this.i = r14;     // Catch: Throwable -> L19
    L17:
        r14.invoke(r11, new Object[]{r9, r12});     // Catch: Throwable -> L19
        return;
    L11:
        r13 = false;
    L19:
        th = move-exception;
        this.h = true;
        a(TAG, o.a("floating set blur regions disabled: ", th.getMessage()));
    }

    private final float[][] a(View r8, int[] r9) {
        Class r0 = ZeusTransformUtils.forName("android.view.IExtEffect", "com.obric.aiagent.plugin");
        Method r2 = this.j;
        if (r2 != null) goto L5;
        r2 = r0.getDeclaredMethod("collectMaterials", new Class[]{View.class, int[].class});
        r2.setAccessible(true);
        this.j = r2;
    L5:
        Object r7 = r2.invoke(null, new Object[]{r8, r9});
        Objects.requireNonNull(r7, "null cannot be cast to non-null type kotlin.Array<kotlin.FloatArray>");
        return (float[][]) ZeusTransformUtils.preCheckCast(r7, float[][].class, "com.obric.aiagent.plugin");
    }

    private final void a(ViewGroup r9, OFloatingTitleBarActionHost r10, d r11, SurfaceControl r12) {
        if (this.v == false) goto L6;
        a(TAG, "finishOverlay ignored after interrupt snapshot");
        p();
        return;
    L6:
        this.A = null;
        this.z = true;
        this.E = false;
        f();
        a(r9, r10, r11, r12, true, true);
    }

    private final void b(boolean r9, boolean r10) {
        a(TAG, "forceCleanup showRealActions=" + r9 + " releaseSurface=" + r10);
        this.A = null;
        this.z = true;
        this.E = false;
        f();
        if (r9 == false) goto L7;
        this.x = false;
        this.w = false;
        if (this.q != null) goto L8;
        this.f36699b.onFloatingTransitionEnd$OUI_standardRelease();
        o();
    L8:
        a r2 = this.q;
        if (r2 == null) goto L16;
        if (r9 == false) goto L13;
        a(r2.a(), r2.b(), r2.c(), r2.d(), r10, true);
        return;
    L13:
        a(r2.a(), r2.b(), r2.c(), r2.d(), r10);
        return;
    L16:
        return;
    L7:
        b(true);
        goto L8
    }

    private final void p() {
        a r0 = this.q;
        if (r0 == null) goto L5;
        boolean r3 = true;
    L6:
        a(TAG, o.a("interruptedSource cleanup hasOverlay=", Boolean.valueOf(r3)));
        this.A = null;
        this.z = true;
        b(true);
        this.w = false;
        if (r0 == null) goto L10;
        a(r0);
    L10:
        f();
        this.x = false;
        a(TAG, "interruptedSource cleanup done");
        return;
    L5:
        r3 = false;
        goto L6
    }

    private final void a(a r6) {
        r6.b().cancelFloatingTransitionState$OUI_standardRelease();     // Catch: Throwable -> L18
        if (r6.b().getParent() != r6.a()) goto L7;
        r6.a().removeView((View) ZeusTransformUtils.preCheckCast(r6.b(), View.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L18
    L7:
        if (this.g != r6.b()) goto L9;
        this.g = null;     // Catch: Throwable -> L18
    L9:
        a r1 = this.q;     // Catch: Throwable -> L18
        if (r1 != null) goto L12;
        OFloatingTitleBarActionHost r2 = null;
    L14:
        if (r2 != r6.b()) goto L16;
        this.q = null;     // Catch: Throwable -> L18
    L16:
        r6.c().a(false);     // Catch: Throwable -> L18
        r6.d().release();     // Catch: Throwable -> L18
        a(TAG, "interruptedSource local overlay removed");     // Catch: Throwable -> L18
        return;
    L12:
        r2 = r1.b();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        a(TAG, o.a("interruptedSource local overlay remove failed: ", th.getMessage()));
    }

    private final void q() {
        a r0 = this.q;
        if (r0 == null) goto L5;
        boolean r3 = true;
    L6:
        a(TAG, o.a("cancelToTarget hasOverlay=", Boolean.valueOf(r3)));
        this.A = null;
        this.z = true;
        if (r0 == null) goto L9;
        a(r0.a(), r0.b(), r0.c(), r0.d(), true, false);
        return;
    L9:
        boolean r1 = f("cancel-no-overlay");
        this.w = false;
        this.f36699b.onFloatingTransitionEnd$OUI_standardRelease();
        o();
        if (r1 == false) goto L14;
        s();
        return;
    L14:
        return;
    L5:
        r3 = false;
        goto L6
    }

    private final void r() {
        j();
        this.x = true;
        this.w = true;
        n();
        this.f36699b.onFloatingTransitionHideActions$OUI_standardRelease(true);
    }

    private final void b(boolean r3) {
        a(TAG, o.a("restoreTargetState keepHidden=", Boolean.valueOf(r3)));
        this.f36699b.onFloatingTransitionRestoreTargetState$OUI_standardRelease(r3);
        if (r3 == true) goto L5;
        o();
    L5:
        this.w = r3;
    }

    private final void a(ViewGroup r12, OFloatingTitleBarActionHost r13, d r14, SurfaceControl r15, boolean r16, boolean r17) {
        a(TAG, "finishOverlay releaseSurface=" + r16 + " deferRemove=" + r17);
        this.E = false;
        this.f36699b.onFloatingTransitionEnd$OUI_standardRelease();
        o();
        this.x = false;
        this.w = false;
        if (r16 == true) goto L8;
        boolean r6 = f("finish-no-release");
        a(r12, r13, r14, r15, false);
        if (r6 == false) goto L20;
        s();
        return;
    L20:
        return;
    L8:
        SurfaceControl.Transaction r7 = new SurfaceControl.Transaction();
        b(r7, r15);
        if (r17 == true) goto L15;
        a(r7, "finishOverlayImmediate", null, null, false);
        boolean r8 = f("finish-immediate");
        a(r12, r13, r14, r15, true);
        if (r8 == false) goto L21;
        s();
        return;
    L21:
        return;
    L15:
        if (a(this, r7, "finishOverlay", null, (d.h.a.a) ZeusTransformUtils.preCheckCast(new e(this, r12, r13, r14, r15), d.h.a.a.class, "com.obric.aiagent.plugin"), 4, null) == true) goto L22;
        boolean r9 = f("finish-unscheduled");
        a(r12, r13, r14, r15, true);
        if (r9 == false) goto L23;
        s();
        return;
    L23:
        return;
    }

    private final boolean f(String r5) {
        IBinder r1 = this.f36701d;
        if (r1 != null) goto L5;
        return false;
    L5:
        IFloatingTransitionSession r4 = u();
        if (r4 != null) goto L14;
        return false;
    L14:
        r4.notifyFloatingTransitionFinished(r1);     // Catch: Throwable -> L11
        a(TAG, "floating notify finished reason=" + r5 + " token=" + r1);     // Catch: Throwable -> L11
        return true;
    L11:
        th = move-exception;
        a(TAG, "floating notify finished failed reason=" + r5 + " error=" + th.getMessage());
        return false;
    }

    private final void s() {
        if (this.B == false) goto L5;
        return;
    L5:
        this.B = true;
        c r0 = this.C;
        if (r0 == null) goto L10;
        r0.a(this.f36699b);
        return;
    }

    private final void a(ViewGroup r5, OFloatingTitleBarActionHost r6, d r7, SurfaceControl r8, boolean r9) {
        a r0 = this.q;
        if (r0 != null) goto L5;
        OFloatingTitleBarActionHost r1 = null;
    L6:
        if (r1 != r6) goto L8;
    L13:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L40;
        a(TAG, "removeOverlay skip unknown host");
        return;
    L40:
        r6.cancelFloatingTransitionState$OUI_standardRelease();     // Catch: Throwable -> L37
        if (r6.getParent() != r5) goto L22;
        r5.removeView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L37
    L22:
        if (this.g != r6) goto L24;
        this.g = null;     // Catch: Throwable -> L37
    L24:
        a r10 = this.q;     // Catch: Throwable -> L37
        if (r10 != null) goto L27;
        OFloatingTitleBarActionHost r11 = null;
    L28:
        if (r11 != r6) goto L30;
        this.q = null;     // Catch: Throwable -> L37
    L30:
        if (r7 == null) goto L33;
        r7.a(r9);     // Catch: Throwable -> L37
    L33:
        if (r9 == false) goto L35;
        SurfaceControl.Transaction r12 = new SurfaceControl.Transaction();     // Catch: Throwable -> L37
        b(r12, r8);     // Catch: Throwable -> L37
        r12.apply();     // Catch: Throwable -> L37
        r12.close();     // Catch: Throwable -> L37
        r8.release();     // Catch: Throwable -> L37
    L35:
        a(TAG, o.a("removeOverlay done releaseSurface=", Boolean.valueOf(r9)));     // Catch: Throwable -> L37
        return;
    L27:
        r11 = r10.b();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        this.f36699b.onFloatingTransitionEnd$OUI_standardRelease();
        a(TAG, o.a("floating cleanup failed: ", th.getMessage()));
        return;
    L8:
        if (this.g == r6) goto L13;
        if (r6.getParent() == r5) goto L13;
        r2 = false;
        goto L15
    L5:
        r1 = r0.b();
        goto L6
    }

    private final Bundle t() {
        OFloatingTitleBarActionHost r1 = this.g;
        if (this.s == false) goto L51;
        if (r1 == null) goto L51;
        boolean r2 = true;
        this.v = true;
        SurfaceControl r3 = null;
        this.A = null;
        this.z = true;
        com.obric.oui.titlebar.a r4 = r1.captureAnimationState$OUI_standardRelease();
        int r11 = d.i.a.a(r1.currentFloatingTransitionContentTopOffset$OUI_standardRelease());
        com.obric.oui.titlebar.a.e r12 = r4.a();
        Integer r5 = Integer.valueOf(r1.getWidth());
        if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L8;
        boolean r6 = true;
    L9:
        if (r6 == true) goto L12;
        r5 = null;
    L12:
        if (r5 != null) goto L14;
        int r7 = this.f36699b.getWidth();
    L15:
        int r13 = r7;
        Integer r8 = Integer.valueOf(r1.getHeight());
        if (((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L18;
        boolean r9 = true;
    L19:
        if (r9 == true) goto L22;
        r8 = null;
    L22:
        if (r8 != null) goto L24;
        int r10 = this.f36699b.getHeight();
    L25:
        int r14 = r10;
        a r15 = this.q;
        if (r15 != null) goto L28;
    L27:
        Integer r16 = null;
    L32:
        if (r16 != null) goto L34;
        int r17 = r4.a().d();
    L35:
        Bundle r18 = com.obric.oui.titlebar.a.a(r4, com.obric.oui.titlebar.a.e.a(r12, r13, r14, 0, r17, 4, null), com.obric.oui.titlebar.a.g.a(r4.b(), 0, 0, 0, 0, r11, 15, null), null, null, null, null, 60, null).g();
        a r19 = this.q;
        if (r19 == null) goto L42;
        SurfaceControl r20 = r19.d();
        if (r20 == null) goto L42;
        r18.putParcelable("interrupted_overlay_surface", (Parcelable) ZeusTransformUtils.preCheckCast(r20, Parcelable.class, "com.obric.aiagent.plugin"));
    L42:
        StringBuilder r21 = new StringBuilder().append("captureOnMain freeze old surface hasInterruptedSurface=");
        a r22 = this.q;
        if (r22 == null) goto L46;
        r3 = r22.d();
    L46:
        if (r3 != null) goto L49;
        r2 = false;
    L49:
        a(TAG, r21.append(r2).append(" snapshot=").append(a(r18)).toString());
        return r18;
    L34:
        r17 = r16.intValue();
        goto L35
    L28:
        d r23 = r15.c();
        if (r23 == null) goto L27;
        r16 = Integer.valueOf(d.i.a.a(r23.a(r1)));
        goto L32
    L24:
        r10 = r8.intValue();
        goto L25
    L18:
        r9 = false;
        goto L19
    L14:
        r7 = r5.intValue();
        goto L15
    L8:
        r6 = false;
    L51:
        return k();
    }

    private final IFloatingTransitionSession u() {
        return b.a(f36698a);
    }

    private final Activity getActivity(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
    L4:
        if (ZeusTransformUtils.instanceOf(r1, ContextWrapper.class) == false) goto L10;
        if (ZeusTransformUtils.instanceOf(r1, Activity.class) == true) goto L8;
        r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r1, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        o.c(r1, "current.baseContext");
        goto L4
    L8:
        return (Activity) ZeusTransformUtils.preCheckCast(r1, Activity.class, "com.obric.aiagent.plugin");
    L10:
        return null;
    }

    private final IBinder a(Activity r4) {
        Activity r3 = (Activity) ZeusTransformUtils.wrapperContextForParams(r4, Activity.class, "com.obric.aiagent.plugin");
        IBinder r5 = null;
        Field r1 = Activity.class.getDeclaredField("mToken");     // Catch: Throwable -> L8
        r1.setAccessible(true);     // Catch: Throwable -> L8
        Object r2 = r1.get(r3);     // Catch: Throwable -> L8
        if (ZeusTransformUtils.instanceOf(r2, IBinder.class) == false) goto L7;
        IBinder r6 = (IBinder) ZeusTransformUtils.preCheckCast(r2, IBinder.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
    L10:
        Window r7 = ZeusTransformUtils.getWindow(r3, "com.obric.aiagent.plugin");
        if (r7 != null) goto L13;
        return r6;
    L13:
        View r0 = r7.getDecorView();
        o.c(r0, "window.decorView");
        if (r6 != null) goto L19;
        WindowManager.LayoutParams r8 = r7.getAttributes();
        if (r8 == null) goto L20;
        r5 = r8.token;
    L20:
        if (r5 != null) goto L27;
        IBinder r9 = r0.getApplicationWindowToken();
        if (r9 == null) goto L24;
        return r9;
    L24:
        return r0.getWindowToken();
    L27:
        return r5;
    L19:
        r5 = r6;
        goto L20
    L7:
        r6 = null;
    L8:
        th = move-exception;
        a(TAG, o.a("floating get activity token failed: ", th.getMessage()));
        r6 = (IBinder) ZeusTransformUtils.preCheckCast(null, IBinder.class, "com.obric.aiagent.plugin");
        goto L10
    }

    private final String a(Bundle r2) {
        return a(com.obric.oui.titlebar.a.f36624a.a(r2));
    L4:
        th = move-exception;
        return o.a("invalidState error=", th.getMessage());
    }

    private final String a(com.obric.oui.titlebar.a r6) {
        StringBuilder r0 = new StringBuilder();
        StringBuilder r5 = r0.append("w=").append(r6.a().a()).append(" h=").append(r6.a().b()).append(" y=").append(r6.a().d()).append(" contentTopInset=").append(r6.b().e()).append(" contentY=").append(b(r6)).append(" start=").append(r6.c().a().size()).append(" center=").append(r6.c().b().size()).append(" sub=").append(r6.c().c().size()).append(" end=").append(r6.c().d().size()).append(" hasAnimationState=");
        boolean r2 = true;
        if (r6.e() == null) goto L5;
        boolean r1 = true;
    L6:
        StringBuilder r7 = r5.append(r1).append(" animStart=");
        com.obric.oui.titlebar.a.d r3 = r6.e();
        int r4 = -1;
        if (r3 != null) goto L9;
    L8:
        int r8 = -1;
    L16:
        r7.append(r8).append(" animCenter=");
        com.obric.oui.titlebar.a.d r9 = r6.e();
        if (r9 != null) goto L19;
    L18:
        int r10 = -1;
    L26:
        StringBuilder r11 = r0.append(r10).append(" animSub=");
        com.obric.oui.titlebar.a.d r12 = r6.e();
        if (r12 != null) goto L29;
    L28:
        int r13 = -1;
    L36:
        StringBuilder r14 = r11.append(r13).append(" animEnd=");
        com.obric.oui.titlebar.a.d r15 = r6.e();
        if (r15 == null) goto L46;
        OButtonGroup.b r16 = r15.d();
        if (r16 == null) goto L46;
        List<OButtonGroup.f> r17 = r16.g();
        if (r17 == null) goto L46;
        r4 = r17.size();
    L46:
        StringBuilder r18 = r14.append(r4).append(" animCenterAlpha=");
        com.obric.oui.titlebar.a.d r19 = r6.e();
        Float r20 = null;
        if (r19 != null) goto L49;
    L48:
        Float r21 = null;
    L53:
        StringBuilder r22 = r18.append(r21).append(" animSubAlpha=");
        com.obric.oui.titlebar.a.d r23 = r6.e();
        if (r23 != null) goto L56;
    L55:
        Float r24 = null;
    L60:
        StringBuilder r25 = r22.append(r24).append(" animEndAlpha=");
        com.obric.oui.titlebar.a.d r26 = r6.e();
        if (r26 == null) goto L67;
        OButtonGroup.b r27 = r26.d();
        if (r27 == null) goto L67;
        r20 = Float.valueOf(r27.b());
    L67:
        StringBuilder r28 = r25.append(r20).append(" hasInterruptedSurface=");
        if (r6.f() != null) goto L71;
        r2 = false;
    L71:
        r28.append(r2);
        return r0.toString();
    L56:
        OButtonGroup.b r29 = r23.c();
        if (r29 == null) goto L55;
        r24 = Float.valueOf(r29.b());
        goto L60
    L49:
        OButtonGroup.b r30 = r19.b();
        if (r30 == null) goto L48;
        r21 = Float.valueOf(r30.b());
        goto L53
    L29:
        OButtonGroup.b r31 = r12.c();
        if (r31 == null) goto L28;
        List<OButtonGroup.f> r32 = r31.g();
        if (r32 == null) goto L28;
        r13 = r32.size();
        goto L36
    L19:
        OButtonGroup.b r33 = r9.b();
        if (r33 == null) goto L18;
        List<OButtonGroup.f> r34 = r33.g();
        if (r34 == null) goto L18;
        r10 = r34.size();
        goto L26
    L9:
        OButtonGroup.b r35 = r3.a();
        if (r35 == null) goto L8;
        List<OButtonGroup.f> r36 = r35.g();
        if (r36 == null) goto L8;
        r8 = r36.size();
        goto L16
    L5:
        r1 = false;
        goto L6
    }

    private final int b(com.obric.oui.titlebar.a r1) {
        return r1.a().d() + r1.b().e();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
