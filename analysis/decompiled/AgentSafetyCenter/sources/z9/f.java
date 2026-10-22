package z9;

import android.util.Log;
import android.view.View;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.WeakHashMap;
import kb.j;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f16523a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f16524b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f16525c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f16526d;

    /* renamed from: e, reason: collision with root package name */
    public static final WeakHashMap f16527e;

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap f16528f;

    /* renamed from: g, reason: collision with root package name */
    public static final Class f16529g;

    /* renamed from: h, reason: collision with root package name */
    public static final Class f16530h;
    public static final Class i;

    static {
        boolean z10;
        Method method;
        try {
            Class.forName("stepos.view.effects.StepOSBackdropLayer");
            z10 = true;
        } catch (Throwable th) {
            Log.i("MotionKitCrossWindowMaterial", "StepOSBackdropLayer 不可用，将尝试反射 createBackdropLayerDrawable: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            z10 = false;
        }
        f16524b = z10;
        Method method2 = null;
        try {
            method = View.class.getMethod("getViewRootImpl", null);
            method.setAccessible(true);
        } catch (Throwable unused) {
            method = null;
        }
        f16525c = method;
        try {
            Method method3 = Class.forName("android.view.ViewRootImpl").getMethod("createBackdropLayerDrawable", null);
            method3.setAccessible(true);
            method2 = method3;
        } catch (Throwable th2) {
            Log.e("MotionKitCrossWindowMaterial", "createBackdropLayerDrawable unavailable: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
        }
        f16526d = method2;
        f16527e = new WeakHashMap();
        f16528f = new HashMap();
        Class cls = Integer.TYPE;
        cls.getClass();
        f16529g = cls;
        Class cls2 = Float.TYPE;
        cls2.getClass();
        f16530h = cls2;
        Class cls3 = Boolean.TYPE;
        cls3.getClass();
        i = cls3;
    }

    public static void b(Object obj, String str, Class[] clsArr, Object... objArr) {
        Method method;
        obj.getClass();
        if (f16524b && d.b(obj, str, objArr)) {
            return;
        }
        String str2 = str + clsArr.length;
        HashMap map = f16528f;
        Object obj2 = map.get(str2);
        if (obj2 == null) {
            try {
                method = obj.getClass().getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            } catch (Throwable th) {
                Log.e("MotionKitCrossWindowMaterial", str + " reflection failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
                method = null;
            }
            obj2 = method;
            map.put(str2, obj2);
        }
        Method method2 = (Method) obj2;
        if (method2 == null) {
            return;
        }
        try {
            method2.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (Throwable th2) {
            th = th2;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.e("MotionKitCrossWindowMaterial", str + " invocation failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
        }
    }

    public static boolean c() {
        if (f16524b) {
            return true;
        }
        return (f16525c == null || f16526d == null) ? false : true;
    }

    public final synchronized p5.c a(View view) {
        try {
            view.getClass();
            if (!c()) {
                return null;
            }
            WeakHashMap weakHashMap = f16527e;
            Object obj = weakHashMap.get(view);
            Object obj2 = obj;
            if (obj == null) {
                e eVar = new e();
                eVar.f16517a = new WeakReference(view);
                eVar.f16521e = new j();
                VarHandle.storeStoreFence();
                weakHashMap.put(view, eVar);
                obj2 = eVar;
            }
            e eVar2 = (e) obj2;
            eVar2.f16518b++;
            eVar2.b();
            if (view.isAttachedToWindow() && eVar2.f16519c == null) {
                int i3 = eVar2.f16518b - 1;
                eVar2.f16518b = i3;
                if (i3 <= 0) {
                    eVar2.d();
                    weakHashMap.remove(view);
                }
                return null;
            }
            p5.c cVar = new p5.c(13);
            cVar.f9717f = eVar2;
            cVar.f9718g = new WeakReference(view);
            VarHandle.storeStoreFence();
            return cVar;
        } catch (Throwable th) {
            throw th;
        }
    }
}
