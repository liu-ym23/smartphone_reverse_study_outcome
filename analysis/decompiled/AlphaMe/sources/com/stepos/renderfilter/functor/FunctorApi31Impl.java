package com.stepos.renderfilter.functor;

import C2.f;
import android.graphics.Canvas;
import androidx.activity.d;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.renderfilter.annotation.Keep;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class FunctorApi31Impl extends Functor {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f12307f = 0;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
    static {
        /*
            java.lang.String r0 = "RenderFilter"
            r1 = 0
            r3 = 0
            r4 = 0
            java.lang.Class<android.graphics.HardwareRenderer> r5 = android.graphics.HardwareRenderer.class
            androidx.room.z r6 = C2.f.f346c     // Catch: java.lang.Throwable -> L35
            r6.getClass()     // Catch: java.lang.Throwable -> L35
            java.lang.ClassLoader r7 = r5.getClassLoader()     // Catch: java.lang.Throwable -> L35
            java.lang.String r5 = r5.getName()     // Catch: java.lang.Throwable -> L35
            C2.d r5 = r6.b(r7, r5)     // Catch: java.lang.Throwable -> L35
            java.lang.String r6 = "getDrawFnFunctionTable"
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> L35
            C2.e r5 = r5.a(r6, r7)     // Catch: java.lang.Throwable -> L35
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L35
            java.lang.reflect.Method r5 = r5.f343a     // Catch: java.lang.Throwable -> L35
            java.lang.Object r5 = r5.invoke(r3, r6)     // Catch: java.lang.Throwable -> L35
            java.lang.Long r5 = (java.lang.Long) r5     // Catch: java.lang.Throwable -> L35
            long r5 = r5.longValue()     // Catch: java.lang.Throwable -> L35
            java.lang.String r7 = "load function table from HardwareRenderer!"
            android.util.Log.d(r0, r7)     // Catch: java.lang.Throwable -> L35
            goto L60
        L35:
            java.lang.ClassLoader r5 = android.webkit.WebView.getWebViewClassLoader()     // Catch: java.lang.Throwable -> L5f
            if (r5 == 0) goto L5f
            java.lang.String r6 = "load function table from WebView.apk"
            android.util.Log.d(r0, r6)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r6 = "com.android.webview.chromium.DrawFunctor"
            androidx.room.z r7 = C2.f.f346c     // Catch: java.lang.Throwable -> L5f
            C2.d r5 = r7.b(r5, r6)     // Catch: java.lang.Throwable -> L5f
            java.lang.String r6 = "nativeGetFunctionTable"
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch: java.lang.Throwable -> L5f
            C2.e r5 = r5.a(r6, r7)     // Catch: java.lang.Throwable -> L5f
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L5f
            java.lang.reflect.Method r5 = r5.f343a     // Catch: java.lang.Throwable -> L5f
            java.lang.Object r3 = r5.invoke(r3, r4)     // Catch: java.lang.Throwable -> L5f
            java.lang.Long r3 = (java.lang.Long) r3     // Catch: java.lang.Throwable -> L5f
            long r5 = r3.longValue()     // Catch: java.lang.Throwable -> L5f
            goto L60
        L5f:
            r5 = r1
        L60:
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 == 0) goto L7d
            native_set_function_table(r5)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "DrawFn query_render_mode="
            r1.<init>(r2)
            int r2 = native_query_render_mode()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            goto L82
        L7d:
            java.lang.String r1 = "getDrawFnFunctionTable failed, functionTable=0"
            android.util.Log.e(r0, r1)
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.renderfilter.functor.FunctorApi31Impl.<clinit>():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    @com.stepos.renderfilter.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isVulkanMode() {
        /*
            int r0 = native_query_render_mode()
            r1 = 1
            if (r0 != r1) goto L8
            return r1
        L8:
            r2 = 0
            if (r0 != 0) goto Lc
            return r2
        Lc:
            java.lang.String r0 = "debug.hwui.renderer"
            java.lang.String r0 = t0.J.v(r0)
            boolean r3 = r0.isEmpty()
            java.lang.String r4 = "RenderFilter"
            if (r3 != 0) goto L4d
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r3 = r0.toLowerCase(r3)
            java.lang.String r5 = "vulkan"
            boolean r5 = r3.contains(r5)
            if (r5 == 0) goto L32
            java.lang.String r2 = "HWUI: Vulkan from debug.hwui.renderer="
            java.lang.String r0 = r2.concat(r0)
            android.util.Log.d(r4, r0)
            goto L86
        L32:
            java.lang.String r5 = "opengl"
            boolean r5 = r3.contains(r5)
            if (r5 != 0) goto L42
            java.lang.String r5 = "skiagl"
            boolean r3 = r3.contains(r5)
            if (r3 == 0) goto L4d
        L42:
            java.lang.String r1 = "HWUI: OpenGL from debug.hwui.renderer="
            java.lang.String r0 = r1.concat(r0)
            android.util.Log.d(r4, r0)
        L4b:
            r1 = r2
            goto L86
        L4d:
            java.lang.String r0 = "ro.hwui.use_vulkan"
            java.lang.String r0 = t0.J.v(r0)
            java.lang.String r3 = "1"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L81
            java.lang.String r3 = "true"
            boolean r3 = r3.equalsIgnoreCase(r0)
            if (r3 == 0) goto L64
            goto L81
        L64:
            java.lang.String r3 = "0"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L7b
            java.lang.String r3 = "false"
            boolean r0 = r3.equalsIgnoreCase(r0)
            if (r0 == 0) goto L75
            goto L7b
        L75:
            java.lang.String r0 = "HWUI: query_render_mode unknown; assume Vulkan — use platform blur fallback"
            android.util.Log.w(r4, r0)
            goto L86
        L7b:
            java.lang.String r0 = "HWUI: OpenGL from ro.hwui.use_vulkan"
            android.util.Log.d(r4, r0)
            goto L4b
        L81:
            java.lang.String r0 = "HWUI: Vulkan from ro.hwui.use_vulkan"
            android.util.Log.d(r4, r0)
        L86:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.renderfilter.functor.FunctorApi31Impl.isVulkanMode():boolean");
    }

    @Keep
    private native int native_create_functor(WeakReference<Functor> weakReference);

    @Keep
    private native void native_destroy_functor(int i4);

    @Keep
    private static native int native_query_render_mode();

    @Keep
    private static native void native_set_function_table(long j4);

    @Keep
    public static int queryRenderMode() {
        return native_query_render_mode();
    }

    @Override // com.stepos.renderfilter.functor.Functor
    public final Long a() {
        return Long.valueOf(native_create_functor(new WeakReference<>(this)));
    }

    @Override // com.stepos.renderfilter.functor.Functor
    public final void b() {
        native_destroy_functor(this.f12305a.intValue());
    }

    public final Method e() {
        return f.a("android.graphics.RecordingCanvas").a("drawWebViewFunctor", Integer.TYPE).f343a;
    }

    public final void f(Method method, Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        method.invoke(canvas, Integer.valueOf(this.f12305a.intValue()));
    }

    public final void finalize() throws Throwable {
        try {
            if (d()) {
                synchronized (Functor.class) {
                    Functor.f12302c.put(this.f12305a, this);
                }
                b();
                this.f12305a = null;
                Functor.f12303d.postDelayed(new d(22, this), VehicleBluetoothManager.MIN_CONNECT_DISTANCE);
            }
        } finally {
            super.finalize();
        }
    }
}
