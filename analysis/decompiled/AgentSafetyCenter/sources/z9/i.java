package z9;

import android.graphics.RenderEffect;
import android.util.Log;
import android.view.View;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.WeakHashMap;
import kb.l;
import stepos.view.effects.StepOSGlassMaterial;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f16559a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f16560b;

    /* renamed from: c, reason: collision with root package name */
    public static final Class f16561c;

    /* renamed from: d, reason: collision with root package name */
    public static final Class f16562d;

    /* renamed from: e, reason: collision with root package name */
    public static final Method f16563e;

    /* renamed from: f, reason: collision with root package name */
    public static final Method f16564f;

    /* renamed from: g, reason: collision with root package name */
    public static final WeakHashMap f16565g;

    /* renamed from: h, reason: collision with root package name */
    public static int f16566h;
    public static final LinkedHashSet i;

    /* renamed from: j, reason: collision with root package name */
    public static final HashMap f16567j;

    /* renamed from: k, reason: collision with root package name */
    public static final Class f16568k;

    /* renamed from: l, reason: collision with root package name */
    public static final Class f16569l;

    /* renamed from: m, reason: collision with root package name */
    public static final Class f16570m;

    /* renamed from: n, reason: collision with root package name */
    public static final Class f16571n;

    static {
        boolean z10;
        Class<?> cls;
        Class<?> cls2;
        Method method;
        Class cls3 = Float.TYPE;
        f16559a = new i();
        try {
            Class.forName("stepos.view.effects.StepOSGlassMaterial");
            z10 = true;
        } catch (Throwable th) {
            Log.i("MotionKitInWindowMaterial", "StepOSGlassMaterial 不可用，将尝试反射 BackdropMaterialParams/createGlassMaterialEffect: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            z10 = false;
        }
        f16560b = z10;
        Method method2 = null;
        try {
            cls = Class.forName("android.graphics.BackdropMaterialParams$Builder");
        } catch (Throwable th2) {
            Log.e("MotionKitInWindowMaterial", "BackdropMaterialParams.Builder unavailable: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
            cls = null;
        }
        f16561c = cls;
        try {
            cls2 = Class.forName("android.graphics.BackdropMaterialParams");
        } catch (Throwable unused) {
            cls2 = null;
        }
        f16562d = cls2;
        Class cls4 = Integer.TYPE;
        if (cls2 != null) {
            try {
                method = RenderEffect.class.getMethod("createGlassMaterialEffect", cls2, cls4, RenderEffect.class);
                method.setAccessible(true);
            } catch (Throwable th3) {
                Log.e("MotionKitInWindowMaterial", "createGlassMaterialEffect unavailable: " + th3.getClass().getSimpleName() + ": " + th3.getMessage());
            }
        } else {
            method = null;
        }
        f16563e = method;
        try {
            Method method3 = RenderEffect.class.getMethod("createStepOSBlurEffect", cls3, cls4, cls3);
            method3.setAccessible(true);
            method2 = method3;
        } catch (Throwable th4) {
            Log.w("MotionKitInWindowMaterial", "createStepOSBlurEffect(3-arg) unavailable: " + th4.getClass().getSimpleName() + ": " + th4.getMessage());
        }
        f16564f = method2;
        f16565g = new WeakHashMap();
        i = new LinkedHashSet();
        f16567j = new HashMap();
        cls4.getClass();
        f16568k = cls4;
        cls3.getClass();
        f16569l = cls3;
        Class cls5 = Boolean.TYPE;
        cls5.getClass();
        f16570m = cls5;
        f16571n = int[].class;
    }

    public static final Object a(g gVar, int i3) {
        Class cls = f16568k;
        Float fValueOf = Float.valueOf(0.0f);
        Class cls2 = f16561c;
        if (cls2 == null) {
            return null;
        }
        try {
            Object objNewInstance = cls2.getConstructor(null).newInstance(null);
            objNewInstance.getClass();
            Class cls3 = f16569l;
            g(cls2, objNewInstance, "setGeometry", new Class[]{cls3, cls3, cls3, cls3, cls3, cls3}, fValueOf, fValueOf, Float.valueOf(gVar.f16532b), Float.valueOf(gVar.f16532b), Float.valueOf(gVar.f16532b), Float.valueOf(gVar.f16532b));
            g(cls2, objNewInstance, "setCornerSmoothness", new Class[]{cls3}, fValueOf);
            g(cls2, objNewInstance, "setBlend", new Class[]{cls, cls3, cls3}, Integer.valueOf(gVar.f16533c), Float.valueOf(gVar.f16534d), Float.valueOf(d(16777215)));
            List listJ0 = l.J0(gVar.f16536f, 4);
            if (!listJ0.isEmpty()) {
                int size = listJ0.size();
                int[] iArr = new int[size];
                for (int i10 = 0; i10 < size; i10++) {
                    iArr[i10] = ((Number) ((jb.g) listJ0.get(i10)).f6759c).intValue();
                }
                int size2 = listJ0.size();
                int[] iArr2 = new int[size2];
                for (int i11 = 0; i11 < size2; i11++) {
                    iArr2[i11] = ((Number) ((jb.g) listJ0.get(i11)).f6760f).intValue();
                }
                Class cls4 = f16571n;
                g(cls2, objNewInstance, "setBlendArray", new Class[]{cls4, cls4}, iArr, iArr2);
            }
            Class cls5 = f16569l;
            g(cls2, objNewInstance, "setFrost", new Class[]{cls5}, Float.valueOf(gVar.f16535e));
            Class cls6 = f16570m;
            g(cls2, objNewInstance, "setStroke", new Class[]{cls6, cls5, cls5, cls5, cls5, cls5, cls5, cls5}, Boolean.valueOf(gVar.f16543n), Float.valueOf(gVar.f16544o), Float.valueOf(gVar.f16545p), Float.valueOf(gVar.f16546q), Float.valueOf(j(gVar.f16548s)), Float.valueOf(h(gVar.f16548s)), Float.valueOf((gVar.f16548s & 255) / 255.0f), Float.valueOf(d(gVar.f16548s)));
            g(cls2, objNewInstance, "setStrokeSpread", new Class[]{cls5}, Float.valueOf(gVar.f16547r));
            g(cls2, objNewInstance, "setLightDirs", new Class[]{cls5, cls5, cls5, cls5}, Float.valueOf(gVar.f16549t), Float.valueOf(gVar.f16550u), Float.valueOf(gVar.f16551v), Float.valueOf(gVar.f16552w));
            g(cls2, objNewInstance, "setAmbient", new Class[]{cls5}, Float.valueOf(gVar.f16553x));
            g(cls2, objNewInstance, "setAnisoRim", new Class[]{cls6}, Boolean.valueOf(gVar.f16554y));
            g(cls2, objNewInstance, "setEdgeColor", new Class[]{cls}, Integer.valueOf(gVar.f16555z));
            g(cls2, objNewInstance, "setDarkColor", new Class[]{cls}, Integer.valueOf(gVar.A));
            g(cls2, objNewInstance, "setDarkWidth", new Class[]{cls5}, Float.valueOf(gVar.B));
            g(cls2, objNewInstance, "setEdgeWidth", new Class[]{cls5}, Float.valueOf(gVar.C));
            g(cls2, objNewInstance, "setInnerShadow", new Class[]{cls6, cls5, cls5, cls5, cls5, cls5, cls5, cls5, cls5}, Boolean.valueOf(gVar.D), Float.valueOf(j(gVar.E)), Float.valueOf(h(gVar.E)), Float.valueOf((gVar.E & 255) / 255.0f), Float.valueOf(d(gVar.E)), Float.valueOf(gVar.F), fValueOf, fValueOf, Float.valueOf(gVar.G));
            g(cls2, objNewInstance, "setRefraction", new Class[]{cls6, cls5, cls5}, Boolean.valueOf(gVar.H), Float.valueOf(gVar.I), Float.valueOf(gVar.J));
            g(cls2, objNewInstance, "setDepthEffect", new Class[]{cls5}, Float.valueOf(gVar.L));
            g(cls2, objNewInstance, "setDispersion", new Class[]{cls5}, Float.valueOf(gVar.K));
            g(cls2, objNewInstance, "setUseShapeAlpha", new Class[]{cls6}, Boolean.valueOf(gVar.f16543n || gVar.D));
            g(cls2, objNewInstance, "setColorGradient", new Class[]{cls, cls, cls, cls5, cls}, Integer.valueOf(gVar.i), Integer.valueOf(gVar.f16539j), Integer.valueOf(gVar.f16540k), Float.valueOf(gVar.f16541l), Integer.valueOf(i3));
            return cls2.getMethod(JsonPOJOBuilder.DEFAULT_BUILD_METHOD, null).invoke(objNewInstance, null);
        } catch (Throwable th) {
            th = th;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.e("MotionKitInWindowMaterial", "buildMaterial failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            return null;
        }
    }

    public static final int b(int i3, int i10) {
        int i11 = 0;
        if (i3 == 0) {
            return 0;
        }
        int i12 = i3 != 3 ? i3 != 4 ? 0 : -1 : 1;
        int i13 = i3 != 1 ? i3 != 2 ? 0 : -1 : 1;
        while (i11 < ((i10 % 4) + 4) % 4) {
            int i14 = -i13;
            i11++;
            i13 = i12;
            i12 = i14;
        }
        if (i12 == 0 && i13 == 1) {
            return 1;
        }
        if (i12 == 0 && i13 == -1) {
            return 2;
        }
        if (i12 == 1 && i13 == 0) {
            return 3;
        }
        if (i12 == -1 && i13 == 0) {
            return 4;
        }
        return i3;
    }

    public static float d(int i3) {
        return ((i3 >>> 24) & 255) / 255.0f;
    }

    public static RenderEffect f(g gVar, RenderEffect renderEffect, int i3) {
        Object objNewGlassMaterialBuilder = StepOSGlassMaterial.newGlassMaterialBuilder();
        if (objNewGlassMaterialBuilder == null) {
            return renderEffect;
        }
        float f5 = gVar.f16532b;
        StepOSGlassMaterial.gmSetGeometry(objNewGlassMaterialBuilder, 0.0f, 0.0f, f5, f5, f5, f5);
        StepOSGlassMaterial.gmSetCornerSmoothness(objNewGlassMaterialBuilder, 0.0f);
        StepOSGlassMaterial.gmSetBlend(objNewGlassMaterialBuilder, gVar.f16533c, gVar.f16534d, d(16777215));
        List listJ0 = l.J0(gVar.f16536f, 4);
        if (!listJ0.isEmpty()) {
            int size = listJ0.size();
            int[] iArr = new int[size];
            for (int i10 = 0; i10 < size; i10++) {
                iArr[i10] = ((Number) ((jb.g) listJ0.get(i10)).f6759c).intValue();
            }
            int size2 = listJ0.size();
            int[] iArr2 = new int[size2];
            for (int i11 = 0; i11 < size2; i11++) {
                iArr2[i11] = ((Number) ((jb.g) listJ0.get(i11)).f6760f).intValue();
            }
            StepOSGlassMaterial.gmSetBlendArray(objNewGlassMaterialBuilder, iArr, iArr2);
        }
        StepOSGlassMaterial.gmSetFrost(objNewGlassMaterialBuilder, gVar.f16535e);
        StepOSGlassMaterial.gmSetStroke(objNewGlassMaterialBuilder, gVar.f16543n, gVar.f16544o, gVar.f16545p, gVar.f16546q, j(gVar.f16548s), h(gVar.f16548s), (r7 & 255) / 255.0f, d(gVar.f16548s));
        StepOSGlassMaterial.gmSetStrokeSpread(objNewGlassMaterialBuilder, gVar.f16547r);
        StepOSGlassMaterial.gmSetLightDirs(objNewGlassMaterialBuilder, gVar.f16549t, gVar.f16550u, gVar.f16551v, gVar.f16552w);
        StepOSGlassMaterial.gmSetAmbient(objNewGlassMaterialBuilder, gVar.f16553x);
        StepOSGlassMaterial.gmSetAnisoRim(objNewGlassMaterialBuilder, gVar.f16554y);
        StepOSGlassMaterial.gmSetEdgeColor(objNewGlassMaterialBuilder, gVar.f16555z);
        StepOSGlassMaterial.gmSetDarkColor(objNewGlassMaterialBuilder, gVar.A);
        StepOSGlassMaterial.gmSetDarkWidth(objNewGlassMaterialBuilder, gVar.B);
        StepOSGlassMaterial.gmSetEdgeWidth(objNewGlassMaterialBuilder, gVar.C);
        StepOSGlassMaterial.gmSetInnerShadow(objNewGlassMaterialBuilder, gVar.D, j(gVar.E), h(gVar.E), (r4 & 255) / 255.0f, d(gVar.E), gVar.F, 0.0f, 0.0f, gVar.G);
        StepOSGlassMaterial.gmSetRefraction(objNewGlassMaterialBuilder, gVar.H, gVar.I, gVar.J);
        StepOSGlassMaterial.gmSetDepthEffect(objNewGlassMaterialBuilder, gVar.L);
        StepOSGlassMaterial.gmSetDispersion(objNewGlassMaterialBuilder, gVar.K);
        StepOSGlassMaterial.gmSetUseShapeAlpha(objNewGlassMaterialBuilder, gVar.f16543n || gVar.D);
        StepOSGlassMaterial.gmSetColorGradient(objNewGlassMaterialBuilder, gVar.i, gVar.f16539j, gVar.f16540k, gVar.f16541l, i3);
        RenderEffect renderEffectBuildGlassMaterialEffect = StepOSGlassMaterial.buildGlassMaterialEffect(objNewGlassMaterialBuilder, 16777215, renderEffect);
        renderEffectBuildGlassMaterialEffect.getClass();
        return renderEffectBuildGlassMaterialEffect;
    }

    public static void g(Class cls, Object obj, String str, Class[] clsArr, Object... objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method;
        String str2 = str + clsArr.length;
        HashMap map = f16567j;
        Object obj2 = map.get(str2);
        if (obj2 == null) {
            try {
                method = cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            } catch (Throwable th) {
                Log.e("MotionKitInWindowMaterial", str + " reflection failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
                method = null;
            }
            obj2 = method;
            map.put(str2, obj2);
        }
        Method method2 = (Method) obj2;
        if (method2 == null) {
            return;
        }
        method2.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    public static float h(int i3) {
        return ((i3 >>> 8) & 255) / 255.0f;
    }

    public static boolean i() {
        if (f16560b || !(f16561c == null || f16562d == null || f16563e == null)) {
            return b.f16514a || b.f16515b != null;
        }
        return false;
    }

    public static float j(int i3) {
        return ((i3 >>> 16) & 255) / 255.0f;
    }

    public final synchronized p5.e c(View view) {
        view.getClass();
        boolean z10 = true;
        if (!i()) {
            boolean z11 = f16561c != null;
            boolean z12 = f16562d != null;
            boolean z13 = f16563e != null;
            if (!b.f16514a && b.f16515b == null) {
                z10 = false;
            }
            Log.w("MotionKitInWindowMaterial", "acquire: isAvailable=false (builder=" + z11 + " mp=" + z12 + " glassFx=" + z13 + " setBackdrop=" + z10 + ")");
            return null;
        }
        WeakHashMap weakHashMap = f16565g;
        Object hVar = weakHashMap.get(view);
        if (hVar == null) {
            hVar = new h(view);
            weakHashMap.put(view, hVar);
        }
        h hVar2 = (h) hVar;
        hVar2.f16557b++;
        Log.d("MotionKitInWindowMaterial", "acquire: holder=" + System.identityHashCode(hVar2) + " refCount=" + hVar2.f16557b + " view=" + System.identityHashCode(view));
        p5.e eVar = new p5.e(13);
        eVar.f9722f = hVar2;
        eVar.f9723g = new WeakReference(view);
        VarHandle.storeStoreFence();
        return eVar;
    }

    public final synchronized Object e(xb.a aVar) {
        Object objInvoke;
        f16566h++;
        try {
            objInvoke = aVar.invoke();
            int i3 = f16566h - 1;
            f16566h = i3;
            if (i3 == 0) {
                LinkedHashSet linkedHashSet = i;
                List listL0 = l.L0(linkedHashSet);
                linkedHashSet.clear();
                Iterator it = listL0.iterator();
                while (it.hasNext()) {
                    ((h) it.next()).b();
                }
            }
        } catch (Throwable th) {
            f16566h--;
            if (f16566h == 0) {
                LinkedHashSet linkedHashSet2 = i;
                List listL02 = l.L0(linkedHashSet2);
                linkedHashSet2.clear();
                Iterator it2 = listL02.iterator();
                while (it2.hasNext()) {
                    ((h) it2.next()).b();
                }
            }
            throw th;
        }
        return objInvoke;
    }
}
