package com.bytedance.android.livesdk;

import android.graphics.Point;
import android.os.Build;
import android.os.Process;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import com.bytedance.android.livesdk.config.xt0;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.plugin.hook.flipped.Flipped;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.aweme.live.alphaplayer.AlphaVideoSurfaceView;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes7.dex */
public final class SurfaceViewHacker {
    private static final String TAG = "SurfaceViewHacker";

    public static class ProxyPoint extends Point {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<SurfaceView> f102958a;

        public ProxyPoint(SurfaceView r100) {
            this.f102958a = new WeakReference(r100);
        }

        @Override // android.graphics.Point
        public final void set(int r110, int r111) {
            super.set(r110, r111);
            if (r110 != (-1)) goto L50;
            if (r111 == (-1)) goto L6;
            return;
        L6:
            if ("RenderThread".equals(ThreadMethodProxy.currentThread().getName()) == true) goto L8;
            return;
        L8:
            if (Process.is64Bit() == false) goto L62;
            StackTraceElement[] r112 = ThreadMethodProxy.currentThread().getStackTrace();
            if (r112 == null) goto L63;
            boolean r100 = true;
            int r113 = r112.length - 1;
        L12:
            if (r113 < 0) goto L68;
            StackTraceElement r101 = r112[r113];
            if (r101 == null) goto L49;
            if ("android.view.SurfaceView$SurfaceViewPositionUpdateListener".equals(r101.getClassName()) == false) goto L49;
            if ("positionLost".equals(r101.getMethodName()) == false) goto L49;
            SurfaceView r114 = this.f102958a.get();
            if (r114 != null) goto L22;
            b.a("surfaceview null, ignore hack");
            return;
        L22:
            Field r102 = d.f102965c;
            Object r103 = d.c(r114, r102);
            if (r103 != null) goto L25;
            b.a("mSurfaceControl null, ignore hack");
            return;
        L25:
            Object r104 = d.c(r114, d.f102966d);
            if (r104 != null) goto L28;
            b.a("mSurfaceControlLock null, ignore hack");
            return;
        L28:
            monitor-enter(r104);
            Field r105 = d.f102974l;     // Catch: Throwable -> L47
            long r106 = ((Long) d.c(r103, r105)).longValue();     // Catch: Throwable -> L47
            if (r106 != 0) goto L33;
        L36:
            if (r100 == false) goto L42;
            d.d(r114, r102, null);     // Catch: Throwable -> L47
            Field r107 = d.f102968f;     // Catch: Throwable -> L47
            Boolean r108 = Boolean.FALSE;     // Catch: Throwable -> L47
            d.d(r114, r107, r108);     // Catch: Throwable -> L47
            d.d(r114, d.f102969g, r108);     // Catch: Throwable -> L47
            d.f102977o.invoke(d.c(r114, d.f102971i), new Object[0]);     // Catch: Throwable -> L40
        L40:
            th = move-exception;
            b.a(Log.getStackTraceString(th));     // Catch: Throwable -> L47
        L42:
            b.a("hacked: " + r100);     // Catch: Throwable -> L47
            monitor-exit(r104);     // Catch: Throwable -> L47
            return;
        L33:
            if (d.b(r106 + 8) != 0) goto L35;
            d.d(r103, r105, 0L);     // Catch: Throwable -> L47
            goto L36
        L35:
            r100 = false;
        L47:
            th = move-exception;
            throw th;
        L49:
            r113 = r113 - 1;
            goto L12
        L68:
            return;
        L63:
            return;
        L62:
            return;
        }
    }

    public class a implements AlphaVideoSurfaceView.NewInstanceCallback {
        public a() {
        }

        public final void a(AlphaVideoSurfaceView r100) {
            int r101 = xt0.f121631a.getValue().intValue();     // Catch: Throwable -> L22
            if (r101 != 0) goto L6;
            b.a("ignore install proxy, settings disabled");     // Catch: Throwable -> L22
            return;
        L6:
            if (Build.VERSION.SDK_INT != 30) goto L18;
            Object r102 = d.c(r100, d.f102964b);     // Catch: Throwable -> L22
            Object r103 = d.c(r100, d.f102963a);     // Catch: Throwable -> L22
            Object r104 = Proxy.newProxyInstance(r103.getClass().getClassLoader(), r103.getClass().getInterfaces(), new c(r103, r100, r101));     // Catch: Throwable -> L22
            d.f102973k.invoke(r102, new Object[]{r103});     // Catch: Throwable -> L11
        L13:
            d.d(r100, d.f102963a, r104);     // Catch: Throwable -> L22
            d.f102972j.invoke(r102, new Object[]{r104});     // Catch: Throwable -> L16
        L19:
            b.a("install proxy for: " + r100);     // Catch: Throwable -> L22
            return;
        L16:
            th = move-exception;
            b.a(Log.getStackTraceString(th));     // Catch: Throwable -> L22
            goto L19
        L11:
            th = move-exception;
            b.a(Log.getStackTraceString(th));     // Catch: Throwable -> L22
            goto L13
        L18:
            d.d(r100, d.f102970h, new ProxyPoint(r100));     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            b.a(Log.getStackTraceString(th));
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Method f102959a = null;

        static {
            Method r100 = Log.class.getDeclaredMethod("e", new Class[]{String.class, String.class});     // Catch: Throwable -> L4
            r100.setAccessible(true);     // Catch: Throwable -> L4
        L5:
            f102959a = r100;
            return;
        L4:
            r100 = null;
            goto L5
        }

        public static void a(String r100) {
            Method r101 = f102959a;
            if (r101 != null) goto L8;
            return;
        L8:
            r101.invoke(null, new Object[]{SurfaceViewHacker.TAG, r100});     // Catch: Throwable -> L7
            return;
        }
    }

    public static class c implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f102960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<SurfaceView> f102961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f102962c;

        public c(Object r100, SurfaceView r101, int r102) {
            this.f102960a = r100;
            this.f102961b = new WeakReference(r101);
            this.f102962c = r102;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r310, Method r311, Object[] r312) throws Throwable {
            String r100 = r311.getName();
            if (Build.VERSION.SDK_INT == 30) goto L6;
        L23:
            r100 = r100;
            boolean r110 = false;
        L67:
            if (r110 == false) goto L70;
            return null;
        L70:
            StringBuilder r101 = new StringBuilder("PositionListenerProxy, start invoke proxy: ");
            String r102 = r100;
            r101.append(r102);
            b.a(r101.toString());
            Object r103 = r311.invoke(this.f102960a, r312);
            b.a("PositionListenerProxy, after invoke proxy: " + r102);
            return r103;
        L6:
            if ("positionLost".equals(r311.getName()) == false) goto L23;
            if ("RenderThread".equals(ThreadMethodProxy.currentThread().getName()) == false) goto L23;
            if (Process.is64Bit() == false) goto L23;
            SurfaceView r104 = this.f102961b.get();
            if (r104 != null) goto L17;
            b.a("what? SurfaceView should not be null!");
            goto L23
        L17:
            Object r105 = d.c(r104, d.f102966d);
            if (r105 != null) goto L20;
            b.a("what? mSurfaceControlLock should not be null!");
            goto L23
        L20:
            Field r111 = d.f102965c;
            Object r112 = d.c(r104, r111);
            if (r112 != null) goto L24;
            b.a("mSurfaceControl is null, ignore intercept");
            goto L23
        L24:
            Field r113 = d.f102967e;
            Object r114 = d.c(r104, r113);
            monitor-enter(r105);
            Field r115 = d.f102974l;     // Catch: Throwable -> L49
            long r106 = ((Long) d.c(r112, r115)).longValue();     // Catch: Throwable -> L49
            if (r106 != 0) goto L29;
            long r210 = 0;
        L31:
            long r107 = r210;
            boolean r116 = true;
        L33:
            Field r117 = d.f102968f;     // Catch: Throwable -> L49
            boolean r118 = ((Boolean) d.c(r104, r117)).booleanValue();     // Catch: Throwable -> L49
            if (r114 == null) goto L51;
            if (r118 == true) goto L39;
            SurfaceView r211 = r104;
            Object r212 = r112;
            if (this.f102962c == 2) goto L40;
        L52:
            long r119 = 0;
            long r213 = 0;
            boolean r108 = false;
        L53:
            String r109 = "resetmSurfaceControl: " + r116 + ", resetmBackgroundControl: " + r108 + ", mSurfaceControlNativeObject: " + r106 + ", mSurfaceControlNativeObjectRefs: " + r107 + ", mRtReleaseSurfaces: " + r118 + ", mode: " + this.f102962c + ", mBackgroundControlNativeObject: " + r119 + ", mBackgroundControlNativeObjectRefs: " + r213;     // Catch: Throwable -> L49
            if (r116 == true) goto L58;
            if (r108 == true) goto L58;
            b.a("invoke positionLost normal, " + r109);     // Catch: Throwable -> L49
            r311.invoke(this.f102960a, r312);     // Catch: Throwable -> L49
        L65:
            monitor-exit(r105);     // Catch: Throwable -> L49
            r110 = true;
        L58:
            if (r116 == false) goto L60;
            Field r120 = r115;
            d.d(r212, r120, 0L);     // Catch: Throwable -> L49
        L61:
            SurfaceView r121 = r211;
            d.d(r121, r111, null);     // Catch: Throwable -> L49
            if (r108 == false) goto L64;
            d.d(r114, r120, 0L);     // Catch: Throwable -> L49
        L64:
            d.d(r121, r113, null);     // Catch: Throwable -> L49
            Boolean r122 = Boolean.FALSE;     // Catch: Throwable -> L49
            d.d(r121, r117, r122);     // Catch: Throwable -> L49
            d.d(r121, d.f102969g, r122);     // Catch: Throwable -> L49
            b.a("intercept positionLost invoke, " + r109);     // Catch: Throwable -> L49
            goto L65
        L60:
            r120 = r115;
        L40:
            long r214 = ((Long) d.c(r114, r115)).longValue();     // Catch: Throwable -> L49
            if (r214 != 0) goto L44;
            r213 = 0;
        L43:
            boolean r123 = true;
        L48:
            r108 = r123;
            r119 = r214;
            goto L53
        L44:
            r213 = d.b(r214 + 8);     // Catch: Throwable -> L49
            if (r213 == 0) goto L43;
            r123 = false;
            goto L48
        L39:
            r211 = r104;
            r212 = r112;
            goto L40
        L51:
            r211 = r104;
            r212 = r112;
            goto L52
        L29:
            r210 = d.b(r106 + 8);     // Catch: Throwable -> L49
            if (r210 == 0) goto L31;
            r107 = r210;
            r116 = false;
        L49:
            th = move-exception;
            throw th;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Field f102963a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Field f102964b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Field f102965c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Field f102966d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Field f102967e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Field f102968f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Field f102969g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Field f102970h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final Field f102971i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Method f102972j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final Method f102973k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final Field f102974l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final Method f102975m = null;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final Object f102976n = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final Method f102977o = null;

        static {
            Flipped.invokeHiddenApiRestrictions();
            Field[] r100 = SurfaceView.class.getDeclaredFields();     // Catch: Throwable -> L48
            int r101 = r100.length;     // Catch: Throwable -> L48
            int r102 = 0;
            Field r103 = null;
            Field r104 = null;
            Field r105 = null;
            Field r110 = null;
            Field r111 = null;
            Field r112 = null;
            Field r113 = null;
            Field r114 = null;
        L5:
            if (r102 >= r101) goto L51;
            Field r115 = r100[r102];     // Catch: Throwable -> L46
            String r106 = r115.getName();     // Catch: Throwable -> L46
            switch(r106.hashCode()) {
                case -1778916610: goto L31;
                case -1710337142: goto L28;
                case -1684693150: goto L25;
                case -1115492931: goto L22;
                case -252684337: goto L19;
                case 395060013: goto L16;
                case 1120927880: goto L13;
                case 2092698774: goto L10;
                default: goto L33;
            };     // Catch: Throwable -> L46
        L33:
            byte r107 = -1;
        L34:
            switch(r107) {
                case 0: goto L43;
                case 1: goto L42;
                case 2: goto L41;
                case 3: goto L40;
                case 4: goto L39;
                case 5: goto L38;
                case 6: goto L37;
                case 7: goto L36;
                default: goto L45;
            };     // Catch: Throwable -> L46
        L36:
            r115.setAccessible(true);     // Catch: Throwable -> L46
            r114 = r115;
            goto L45
        L37:
            r115.setAccessible(true);     // Catch: Throwable -> L46
            r113 = r115;
            goto L45
        L38:
            r115.setAccessible(true);     // Catch: Throwable -> L46
            r112 = r115;
            goto L45
        L39:
            r115.setAccessible(true);     // Catch: Throwable -> L46
            r111 = r115;
            goto L45
        L40:
            r115.setAccessible(true);     // Catch: Throwable -> L46
            r110 = r115;
            goto L45
        L41:
            r115.setAccessible(true);     // Catch: Throwable -> L46
            r105 = r115;
            goto L45
        L42:
            r115.setAccessible(true);     // Catch: Throwable -> L46
            r104 = r115;
            goto L45
        L43:
            r115.setAccessible(true);     // Catch: Throwable -> L46
            r103 = r115;
        L45:
            r102 = r102 + 1;
            goto L5
        L10:
            if (r106.equals("mRTLastReportedSurfaceSize") == false) goto L33;
            r107 = 6;
            goto L34
        L13:
            if (r106.equals("mSurfaceControlLock") == false) goto L33;
            r107 = 2;
            goto L34
        L16:
            if (r106.equals("mRtHandlingPositionUpdates") == false) goto L33;
            r107 = 5;
            goto L34
        L19:
            if (r106.equals("mRtTransaction") == false) goto L33;
            r107 = 7;
            goto L34
        L22:
            if (r106.equals("mSurfaceControl") == false) goto L33;
            r107 = 1;
            goto L34
        L25:
            if (r106.equals("mBackgroundControl") == false) goto L33;
            r107 = 3;
            goto L34
        L28:
            if (r106.equals("mPositionListener") == false) goto L33;
            r107 = 0;
            goto L34
        L31:
            if (r106.equals("mRtReleaseSurfaces") == false) goto L33;
            r107 = 4;
        L46:
            th = th;
        L50:
            b.a(Log.getStackTraceString(th));
        L51:
            f102963a = r103;
            f102965c = r104;
            f102966d = r105;
            f102967e = r110;
            f102968f = r111;
            f102969g = r112;
            f102970h = r113;
            f102971i = r114;
            if (Build.VERSION.SDK_INT == 30) goto L114;
        L57:
            Field r108 = null;
        L58:
            f102964b = r108;
            if (Build.VERSION.SDK_INT == 30) goto L120;
            Method r109 = null;
            Method r116 = null;
        L77:
            f102972j = r109;
            f102973k = r116;
            Field r117 = a("android.view.SurfaceControl").getDeclaredField("mNativeObject");     // Catch: Throwable -> L80
            r117.setAccessible(true);     // Catch: Throwable -> L80
        L82:
            f102974l = r117;
            Method r118 = a("sun.misc.Unsafe").getDeclaredMethod("getLong", new Class[]{Long.TYPE});     // Catch: Throwable -> L85
            r118.setAccessible(true);     // Catch: Throwable -> L85
        L87:
            f102975m = r118;
            Field r119 = a("sun.misc.Unsafe").getDeclaredField("THE_ONE");     // Catch: Throwable -> L94
            r119.setAccessible(true);     // Catch: Throwable -> L94
            Method r120 = null;
            Object r121 = r119.get(null);     // Catch: Throwable -> L92
        L97:
            f102976n = r121;
            int r122 = Build.VERSION.SDK_INT;
            if (r122 != 31) goto L100;
        L110:
            Method r123 = a("android.view.SurfaceControl$Transaction").getDeclaredMethod("clear", new Class[0]);     // Catch: Throwable -> L103
            r123.setAccessible(true);     // Catch: Throwable -> L103
            Method r124 = r123;
        L106:
            f102977o = r124;
            return;
        L103:
            th = move-exception;
            b.a(Log.getStackTraceString(th));
        L105:
            r124 = r120;
            goto L106
        L100:
            if (r122 != 32) goto L105;
        L92:
            th = th;
        L96:
            b.a(Log.getStackTraceString(th));
            r121 = r120;
        L94:
            th = th;
            r120 = null;
        L85:
            th = move-exception;
            b.a(Log.getStackTraceString(th));
            r118 = null;
        L80:
            th = move-exception;
            b.a(Log.getStackTraceString(th));
            r117 = null;
            goto L82
        L120:
            Method[] r125 = a("android.graphics.RenderNode").getDeclaredMethods();     // Catch: Throwable -> L73
            int r126 = r125.length;     // Catch: Throwable -> L73
            int r127 = 0;
            r109 = null;
            r116 = null;
        L62:
            if (r127 >= r126) goto L77;
            Method r128 = r125[r127];     // Catch: Throwable -> L71
            String r129 = r128.getName();     // Catch: Throwable -> L71
            if ("addPositionUpdateListener".equals(r129) == false) goto L67;
            r128.setAccessible(true);     // Catch: Throwable -> L71
            r109 = r128;
        L70:
            r127 = r127 + 1;
            goto L62
        L67:
            if ("removePositionUpdateListener".equals(r129) == false) goto L70;
            r128.setAccessible(true);     // Catch: Throwable -> L71
            r116 = r128;
        L71:
            th = th;
        L75:
            b.a(Log.getStackTraceString(th));
        L73:
            th = th;
            r109 = null;
            r116 = null;
            goto L75
        L114:
            r108 = View.class.getDeclaredField("mRenderNode");     // Catch: Throwable -> L55
            r108.setAccessible(true);     // Catch: Throwable -> L55
        L55:
            th = move-exception;
            b.a(Log.getStackTraceString(th));
        L48:
            th = th;
            r103 = null;
            r104 = null;
            r105 = null;
            r110 = null;
            r111 = null;
            r112 = null;
            r113 = null;
            r114 = null;
            goto L50
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        public static long b(long r100) {
            Method r101 = f102975m;
            if (r101 == null) goto L12;
            Object r102 = f102976n;
            if (r102 == null) goto L12;
            return ((Long) r101.invoke(r102, new Object[]{Long.valueOf(r100)})).longValue();
        L10:
            th = move-exception;
            b.a(Log.getStackTraceString(th));
        L12:
            return -1;
        }

        public static Object c(Object r100, Field r101) {
            return r101.get(r100);
        L4:
            th = move-exception;
            b.a(Log.getStackTraceString(th));
            return null;
        }

        public static void d(Object r100, Field r101, Object r102) {
            r101.set(r100, r102);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            b.a(Log.getStackTraceString(th));
        }
    }

    public SurfaceViewHacker() {
    }

    public static void initHook() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 30) goto L5;
        return;
    L5:
        if (r100 > 32) goto L10;
        AlphaVideoSurfaceView.setNewInstanceCallback(new a());
        b.a("init hook for AlphaVideoSurfaceView");
        return;
    }
}
