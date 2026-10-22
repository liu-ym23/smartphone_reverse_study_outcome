package L2;

import L2.j;
import V3.m;
import V3.v;
import W3.C0403n;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.util.Log;
import android.view.Display;
import android.view.View;
import i4.InterfaceC0761a;
import i4.InterfaceC0772l;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import stepos.view.effects.StepOSGlassMaterial;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f3840a;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f3841b;

    /* renamed from: c, reason: collision with root package name */
    private static final Class<?> f3842c;

    /* renamed from: d, reason: collision with root package name */
    private static final Class<?> f3843d;

    /* renamed from: e, reason: collision with root package name */
    private static final Method f3844e;

    /* renamed from: f, reason: collision with root package name */
    private static final Method f3845f;

    /* renamed from: g, reason: collision with root package name */
    private static final WeakHashMap<View, b> f3846g;

    /* renamed from: h, reason: collision with root package name */
    private static int f3847h;

    /* renamed from: i, reason: collision with root package name */
    private static final Set<b> f3848i;

    /* renamed from: j, reason: collision with root package name */
    private static final HashMap<String, Method> f3849j;

    /* renamed from: k, reason: collision with root package name */
    private static final Class<?> f3850k;

    /* renamed from: l, reason: collision with root package name */
    private static final Class<?> f3851l;

    /* renamed from: m, reason: collision with root package name */
    private static final Class<?> f3852m;

    /* renamed from: n, reason: collision with root package name */
    private static final Class<?> f3853n;

    public static final class a {

        /* renamed from: A, reason: collision with root package name */
        private float f3854A;

        /* renamed from: B, reason: collision with root package name */
        private boolean f3855B;

        /* renamed from: G, reason: collision with root package name */
        private boolean f3860G;

        /* renamed from: J, reason: collision with root package name */
        private float f3863J;

        /* renamed from: K, reason: collision with root package name */
        private float f3864K;

        /* renamed from: M, reason: collision with root package name */
        private boolean f3866M;

        /* renamed from: P, reason: collision with root package name */
        private float f3869P;

        /* renamed from: a, reason: collision with root package name */
        private float f3871a;

        /* renamed from: b, reason: collision with root package name */
        private float f3872b;

        /* renamed from: c, reason: collision with root package name */
        private float f3873c;

        /* renamed from: g, reason: collision with root package name */
        private float f3877g;

        /* renamed from: i, reason: collision with root package name */
        private int f3879i;

        /* renamed from: j, reason: collision with root package name */
        private float f3880j;

        /* renamed from: k, reason: collision with root package name */
        private int f3881k;

        /* renamed from: l, reason: collision with root package name */
        private int f3882l;

        /* renamed from: m, reason: collision with root package name */
        private int f3883m;

        /* renamed from: o, reason: collision with root package name */
        private int f3885o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f3886p;

        /* renamed from: q, reason: collision with root package name */
        private boolean f3887q;

        /* renamed from: w, reason: collision with root package name */
        private float f3893w;

        /* renamed from: y, reason: collision with root package name */
        private float f3895y;

        /* renamed from: d, reason: collision with root package name */
        private int f3874d = 16777215;

        /* renamed from: e, reason: collision with root package name */
        private int f3875e = 2;

        /* renamed from: f, reason: collision with root package name */
        private float f3876f = 0.1f;

        /* renamed from: h, reason: collision with root package name */
        private List<m<Integer, Integer>> f3878h = C0403n.h();

        /* renamed from: n, reason: collision with root package name */
        private float f3884n = 0.5f;

        /* renamed from: r, reason: collision with root package name */
        private float f3888r = 2.0f;

        /* renamed from: s, reason: collision with root package name */
        private float f3889s = 2.0f;

        /* renamed from: t, reason: collision with root package name */
        private float f3890t = 1.0f;

        /* renamed from: u, reason: collision with root package name */
        private float f3891u = 2.0f;

        /* renamed from: v, reason: collision with root package name */
        private int f3892v = -1;

        /* renamed from: x, reason: collision with root package name */
        private float f3894x = -1.0f;

        /* renamed from: z, reason: collision with root package name */
        private float f3896z = 1.0f;

        /* renamed from: C, reason: collision with root package name */
        private int f3856C = -3355444;

        /* renamed from: D, reason: collision with root package name */
        private int f3857D = -3092272;

        /* renamed from: E, reason: collision with root package name */
        private float f3858E = 1.0f;

        /* renamed from: F, reason: collision with root package name */
        private float f3859F = 1.0f;

        /* renamed from: H, reason: collision with root package name */
        private int f3861H = 1711276032;

        /* renamed from: I, reason: collision with root package name */
        private float f3862I = 14.0f;

        /* renamed from: L, reason: collision with root package name */
        private float f3865L = 1.0f;

        /* renamed from: N, reason: collision with root package name */
        private float f3867N = 20.0f;

        /* renamed from: O, reason: collision with root package name */
        private float f3868O = 40.0f;

        /* renamed from: Q, reason: collision with root package name */
        private float f3870Q = 0.4f;

        public final float A() {
            return this.f3864K;
        }

        public final void A0(float f5) {
            this.f3868O = f5;
        }

        public final float B() {
            return this.f3862I;
        }

        public final void B0(int i5) {
            this.f3892v = i5;
        }

        public final float C() {
            return this.f3893w;
        }

        public final void C0(boolean z5) {
            this.f3887q = z5;
        }

        public final float D() {
            return this.f3894x;
        }

        public final void D0(float f5) {
            this.f3890t = f5;
        }

        public final float E() {
            return this.f3895y;
        }

        public final void E0(float f5) {
            this.f3889s = f5;
        }

        public final float F() {
            return this.f3896z;
        }

        public final void F0(float f5) {
            this.f3891u = f5;
        }

        public final float G() {
            return this.f3871a;
        }

        public final void G0(float f5) {
            this.f3888r = f5;
        }

        public final boolean H() {
            return this.f3866M;
        }

        public final void H0(int i5) {
            this.f3874d = i5;
        }

        public final float I() {
            return this.f3867N;
        }

        public final void I0(boolean z5) {
            this.f3886p = z5;
        }

        public final float J() {
            return this.f3868O;
        }

        public final int K() {
            return this.f3892v;
        }

        public final boolean L() {
            return this.f3887q;
        }

        public final float M() {
            return this.f3890t;
        }

        public final float N() {
            return this.f3889s;
        }

        public final float O() {
            return this.f3891u;
        }

        public final float P() {
            return this.f3888r;
        }

        public final int Q() {
            return this.f3874d;
        }

        public final boolean R() {
            return this.f3886p;
        }

        public final void S(float f5) {
            this.f3854A = f5;
        }

        public final void T(boolean z5) {
            this.f3855B = z5;
        }

        public final void U(float f5) {
            this.f3876f = f5;
        }

        public final void V(int i5) {
            this.f3875e = i5;
        }

        public final void W(List<m<Integer, Integer>> list) {
            j4.k.g(list, "<set-?>");
            this.f3878h = list;
        }

        public final void X(int i5) {
            this.f3879i = i5;
        }

        public final void Y(float f5) {
            this.f3880j = f5;
        }

        public final void Z(int i5) {
            this.f3883m = i5;
        }

        public final float a() {
            return this.f3854A;
        }

        public final void a0(int i5) {
            this.f3882l = i5;
        }

        public final boolean b() {
            return this.f3855B;
        }

        public final void b0(float f5) {
            this.f3884n = f5;
        }

        public final boolean c() {
            return this.f3887q || this.f3860G || this.f3866M || this.f3869P > 0.0f || this.f3885o != 0;
        }

        public final void c0(int i5) {
            this.f3885o = i5;
        }

        public final float d() {
            return this.f3876f;
        }

        public final void d0(int i5) {
            this.f3881k = i5;
        }

        public final int e() {
            return this.f3875e;
        }

        public final void e0(float f5) {
            this.f3872b = f5;
        }

        public final List<m<Integer, Integer>> f() {
            return this.f3878h;
        }

        public final void f0(float f5) {
            this.f3873c = f5;
        }

        public final int g() {
            return this.f3879i;
        }

        public final void g0(int i5) {
            this.f3857D = i5;
        }

        public final float h() {
            return this.f3880j;
        }

        public final void h0(float f5) {
            this.f3858E = f5;
        }

        public final int i() {
            return this.f3883m;
        }

        public final void i0(float f5) {
            this.f3870Q = f5;
        }

        public final int j() {
            return this.f3882l;
        }

        public final void j0(float f5) {
            this.f3869P = f5;
        }

        public final float k() {
            return this.f3884n;
        }

        public final void k0(int i5) {
            this.f3856C = i5;
        }

        public final int l() {
            return this.f3885o;
        }

        public final void l0(float f5) {
            this.f3859F = f5;
        }

        public final int m() {
            return this.f3881k;
        }

        public final void m0(float f5) {
            this.f3877g = f5;
        }

        public final float n() {
            return this.f3872b;
        }

        public final void n0(int i5) {
            this.f3861H = i5;
        }

        public final float o() {
            return this.f3873c;
        }

        public final void o0(boolean z5) {
            this.f3860G = z5;
        }

        public final int p() {
            return this.f3857D;
        }

        public final void p0(float f5) {
            this.f3865L = f5;
        }

        public final float q() {
            return this.f3858E;
        }

        public final void q0(float f5) {
            this.f3863J = f5;
        }

        public final float r() {
            return this.f3870Q;
        }

        public final void r0(float f5) {
            this.f3864K = f5;
        }

        public final float s() {
            return this.f3869P;
        }

        public final void s0(float f5) {
            this.f3862I = f5;
        }

        public final int t() {
            return this.f3856C;
        }

        public final void t0(float f5) {
            this.f3893w = f5;
        }

        public final float u() {
            return this.f3859F;
        }

        public final void u0(float f5) {
            this.f3894x = f5;
        }

        public final float v() {
            return this.f3877g;
        }

        public final void v0(float f5) {
            this.f3895y = f5;
        }

        public final int w() {
            return this.f3861H;
        }

        public final void w0(float f5) {
            this.f3896z = f5;
        }

        public final boolean x() {
            return this.f3860G;
        }

        public final void x0(float f5) {
            this.f3871a = f5;
        }

        public final float y() {
            return this.f3865L;
        }

        public final void y0(boolean z5) {
            this.f3866M = z5;
        }

        public final float z() {
            return this.f3863J;
        }

        public final void z0(float f5) {
            this.f3867N = f5;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<View> f3897a;

        /* renamed from: b, reason: collision with root package name */
        private int f3898b;

        /* renamed from: c, reason: collision with root package name */
        private final a f3899c;

        public b(View view) {
            j4.k.g(view, "view");
            this.f3897a = new WeakReference<>(view);
            this.f3899c = new a();
        }

        private final void a(View view, RenderEffect renderEffect) {
            L2.a.f3809a.b(view, renderEffect);
            Object parent = view.getParent();
            View view2 = parent instanceof View ? (View) parent : null;
            if (view2 != null) {
                view2.invalidate();
            }
        }

        public final void b() {
            View view = this.f3897a.get();
            if (view == null) {
                return;
            }
            L2.a.f3809a.b(view, null);
        }

        public final void c(InterfaceC0772l<? super a, v> interfaceC0772l) {
            j4.k.g(interfaceC0772l, "action");
            interfaceC0772l.invoke(this.f3899c);
            if (j.f3847h > 0) {
                j.f3848i.add(this);
            } else {
                e();
            }
        }

        public final int d() {
            return this.f3898b;
        }

        public final void e() {
            RenderEffect renderEffectCreateStepOSBlurEffect;
            RenderEffect renderEffectCreateBlurEffect;
            View view = this.f3897a.get();
            if (view == null) {
                return;
            }
            try {
                if (this.f3899c.G() <= 0.0f && !this.f3899c.c()) {
                    Log.d("MotionKitInWindowMaterial", "rebuild: radius<=0 且无玻璃 → clear effect");
                    a(view, null);
                    return;
                }
                float fG = this.f3899c.G() > 0.0f ? this.f3899c.G() : 0.1f;
                boolean z5 = true;
                boolean z6 = j.f3841b || j.f3845f != null;
                if ((this.f3899c.g() != 0 || !this.f3899c.R()) && z6) {
                    z5 = false;
                }
                Display display = view.getDisplay();
                int rotation = display != null ? display.getRotation() : 0;
                if (z5) {
                    renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(fG, fG, Shader.TileMode.CLAMP);
                    j4.k.d(renderEffectCreateBlurEffect);
                } else {
                    int iZ = j.f3840a.z(this.f3899c.g(), rotation);
                    if (j.f3841b) {
                        renderEffectCreateStepOSBlurEffect = StepOSGlassMaterial.createStepOSBlurEffect(fG, iZ, this.f3899c.h());
                    } else {
                        Method method = j.f3845f;
                        j4.k.d(method);
                        Object objInvoke = method.invoke(null, Float.valueOf(fG), Integer.valueOf(iZ), Float.valueOf(this.f3899c.h()));
                        renderEffectCreateStepOSBlurEffect = objInvoke instanceof RenderEffect ? (RenderEffect) objInvoke : null;
                    }
                    if (renderEffectCreateStepOSBlurEffect == null) {
                        renderEffectCreateBlurEffect = RenderEffect.createBlurEffect(fG, fG, Shader.TileMode.CLAMP);
                        j4.k.f(renderEffectCreateBlurEffect, "createBlurEffect(...)");
                    } else {
                        renderEffectCreateBlurEffect = renderEffectCreateStepOSBlurEffect;
                    }
                }
                j jVar = j.f3840a;
                int iZ2 = jVar.z(this.f3899c.l(), rotation);
                if (this.f3899c.c()) {
                    if (j.f3841b) {
                        renderEffectCreateBlurEffect = jVar.q(this.f3899c, renderEffectCreateBlurEffect, iZ2);
                    } else {
                        Object objR = jVar.r(this.f3899c, iZ2);
                        if (objR != null) {
                            Method method2 = j.f3844e;
                            j4.k.d(method2);
                            Object objInvoke2 = method2.invoke(null, objR, Integer.valueOf(this.f3899c.Q()), renderEffectCreateBlurEffect);
                            j4.k.e(objInvoke2, "null cannot be cast to non-null type android.graphics.RenderEffect");
                            renderEffectCreateBlurEffect = (RenderEffect) objInvoke2;
                        }
                    }
                }
                Log.d("MotionKitInWindowMaterial", "rebuild: r=" + this.f3899c.G() + " anyGlass=" + this.f3899c.c() + " stroke=" + this.f3899c.L() + " inner=" + this.f3899c.x() + " refract=" + this.f3899c.H() + " effect=" + System.identityHashCode(renderEffectCreateBlurEffect) + " view=" + System.identityHashCode(view));
                a(view, renderEffectCreateBlurEffect);
            } catch (Throwable th) {
                th = th;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                Log.e("MotionKitInWindowMaterial", "rebuild failed: " + th.getClass().getSimpleName() + ": " + th.getMessage(), th);
            }
        }

        public final void f(int i5) {
            this.f3898b = i5;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final b f3900a;

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference<View> f3901b;

        public c(View view, b bVar) {
            j4.k.g(view, "view");
            j4.k.g(bVar, "h");
            this.f3900a = bVar;
            this.f3901b = new WeakReference<>(view);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void d(c cVar, InterfaceC0772l interfaceC0772l, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                interfaceC0772l = new InterfaceC0772l() { // from class: L2.k
                    @Override // i4.InterfaceC0772l
                    public final Object invoke(Object obj2) {
                        return j.c.e((j.a) obj2);
                    }
                };
            }
            cVar.c(interfaceC0772l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final v e(a aVar) {
            j4.k.g(aVar, "it");
            return v.f5542a;
        }

        public final void b(InterfaceC0772l<? super a, v> interfaceC0772l) {
            j4.k.g(interfaceC0772l, "action");
            this.f3900a.c(interfaceC0772l);
        }

        public final void c(InterfaceC0772l<? super a, v> interfaceC0772l) {
            j4.k.g(interfaceC0772l, "reset");
            this.f3900a.c(interfaceC0772l);
            View view = this.f3901b.get();
            if (view == null) {
                return;
            }
            j.f3840a.x(view, this.f3900a);
        }
    }

    static {
        boolean z5;
        Class<?> cls;
        Class<?> cls2;
        Method method;
        Class<?> cls3 = Float.TYPE;
        f3840a = new j();
        try {
            Class.forName("stepos.view.effects.StepOSGlassMaterial");
            z5 = true;
        } catch (Throwable th) {
            Log.i("MotionKitInWindowMaterial", "StepOSGlassMaterial 不可用，将尝试反射 BackdropMaterialParams/createGlassMaterialEffect: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            z5 = false;
        }
        f3841b = z5;
        Method method2 = null;
        try {
            cls = Class.forName("android.graphics.BackdropMaterialParams$Builder");
        } catch (Throwable th2) {
            Log.e("MotionKitInWindowMaterial", "BackdropMaterialParams.Builder unavailable: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
            cls = null;
        }
        f3842c = cls;
        try {
            cls2 = Class.forName("android.graphics.BackdropMaterialParams");
        } catch (Throwable unused) {
            cls2 = null;
        }
        f3843d = cls2;
        Class<?> cls4 = Integer.TYPE;
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
        f3844e = method;
        try {
            Method method3 = RenderEffect.class.getMethod("createStepOSBlurEffect", cls3, cls4, cls3);
            method3.setAccessible(true);
            method2 = method3;
        } catch (Throwable th4) {
            Log.w("MotionKitInWindowMaterial", "createStepOSBlurEffect(3-arg) unavailable: " + th4.getClass().getSimpleName() + ": " + th4.getMessage());
        }
        f3845f = method2;
        f3846g = new WeakHashMap<>();
        f3848i = new LinkedHashSet();
        f3849j = new HashMap<>();
        j4.k.d(cls4);
        f3850k = cls4;
        j4.k.d(cls3);
        f3851l = cls3;
        Class<?> cls5 = Boolean.TYPE;
        j4.k.d(cls5);
        f3852m = cls5;
        f3853n = int[].class;
    }

    private j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v B(float f5, a aVar) {
        j4.k.g(aVar, "it");
        aVar.e0(f5);
        return v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v D(float f5, a aVar) {
        j4.k.g(aVar, "it");
        aVar.f0(f5);
        return v.f5542a;
    }

    private final float n(int i5) {
        return ((i5 >>> 24) & 255) / 255.0f;
    }

    private final float p(int i5) {
        return (i5 & 255) / 255.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RenderEffect q(a aVar, RenderEffect renderEffect, int i5) {
        Object objNewGlassMaterialBuilder = StepOSGlassMaterial.newGlassMaterialBuilder();
        if (objNewGlassMaterialBuilder == null) {
            return renderEffect;
        }
        StepOSGlassMaterial.gmSetGeometry(objNewGlassMaterialBuilder, 0.0f, 0.0f, aVar.n(), aVar.n(), aVar.n(), aVar.n());
        StepOSGlassMaterial.gmSetCornerSmoothness(objNewGlassMaterialBuilder, aVar.o());
        StepOSGlassMaterial.gmSetBlend(objNewGlassMaterialBuilder, aVar.e(), aVar.d(), n(aVar.Q()));
        List listR = C0403n.R(aVar.f(), 4);
        if (!listR.isEmpty()) {
            int size = listR.size();
            int[] iArr = new int[size];
            for (int i6 = 0; i6 < size; i6++) {
                iArr[i6] = ((Number) ((m) listR.get(i6)).c()).intValue();
            }
            int size2 = listR.size();
            int[] iArr2 = new int[size2];
            for (int i7 = 0; i7 < size2; i7++) {
                iArr2[i7] = ((Number) ((m) listR.get(i7)).d()).intValue();
            }
            StepOSGlassMaterial.gmSetBlendArray(objNewGlassMaterialBuilder, iArr, iArr2);
        }
        StepOSGlassMaterial.gmSetFrost(objNewGlassMaterialBuilder, aVar.v());
        StepOSGlassMaterial.gmSetStroke(objNewGlassMaterialBuilder, aVar.L(), aVar.P(), aVar.N(), aVar.M(), w(aVar.K()), u(aVar.K()), p(aVar.K()), n(aVar.K()));
        StepOSGlassMaterial.gmSetStrokeSpread(objNewGlassMaterialBuilder, aVar.O());
        StepOSGlassMaterial.gmSetLightDirs(objNewGlassMaterialBuilder, aVar.C(), aVar.D(), aVar.E(), aVar.F());
        StepOSGlassMaterial.gmSetAmbient(objNewGlassMaterialBuilder, aVar.a());
        StepOSGlassMaterial.gmSetAnisoRim(objNewGlassMaterialBuilder, aVar.b());
        StepOSGlassMaterial.gmSetEdgeColor(objNewGlassMaterialBuilder, aVar.t());
        StepOSGlassMaterial.gmSetDarkColor(objNewGlassMaterialBuilder, aVar.p());
        StepOSGlassMaterial.gmSetDarkWidth(objNewGlassMaterialBuilder, aVar.q());
        StepOSGlassMaterial.gmSetEdgeWidth(objNewGlassMaterialBuilder, aVar.u());
        StepOSGlassMaterial.gmSetInnerShadow(objNewGlassMaterialBuilder, aVar.x(), w(aVar.w()), u(aVar.w()), p(aVar.w()), n(aVar.w()), aVar.B(), aVar.z(), aVar.A(), aVar.y());
        StepOSGlassMaterial.gmSetRefraction(objNewGlassMaterialBuilder, aVar.H(), aVar.I(), aVar.J());
        StepOSGlassMaterial.gmSetDepthEffect(objNewGlassMaterialBuilder, aVar.r());
        StepOSGlassMaterial.gmSetDispersion(objNewGlassMaterialBuilder, aVar.s());
        StepOSGlassMaterial.gmSetUseShapeAlpha(objNewGlassMaterialBuilder, aVar.L() || aVar.x());
        StepOSGlassMaterial.gmSetColorGradient(objNewGlassMaterialBuilder, aVar.m(), aVar.j(), aVar.i(), aVar.k(), i5);
        RenderEffect renderEffectBuildGlassMaterialEffect = StepOSGlassMaterial.buildGlassMaterialEffect(objNewGlassMaterialBuilder, aVar.Q(), renderEffect);
        j4.k.f(renderEffectBuildGlassMaterialEffect, "buildGlassMaterialEffect(...)");
        return renderEffectBuildGlassMaterialEffect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object r(a aVar, int i5) {
        Float fValueOf = Float.valueOf(0.0f);
        Class<?> cls = f3842c;
        if (cls == null) {
            return null;
        }
        try {
            Object objNewInstance = cls.getConstructor(null).newInstance(null);
            j4.k.d(objNewInstance);
            Class<?> cls2 = f3851l;
            s(cls, objNewInstance, "setGeometry", new Class[]{cls2, cls2, cls2, cls2, cls2, cls2}, fValueOf, fValueOf, Float.valueOf(aVar.n()), Float.valueOf(aVar.n()), Float.valueOf(aVar.n()), Float.valueOf(aVar.n()));
            s(cls, objNewInstance, "setCornerSmoothness", new Class[]{cls2}, Float.valueOf(aVar.o()));
            s(cls, objNewInstance, "setBlend", new Class[]{f3850k, cls2, cls2}, Integer.valueOf(aVar.e()), Float.valueOf(aVar.d()), Float.valueOf(n(aVar.Q())));
            List listR = C0403n.R(aVar.f(), 4);
            if (!listR.isEmpty()) {
                int size = listR.size();
                int[] iArr = new int[size];
                for (int i6 = 0; i6 < size; i6++) {
                    iArr[i6] = ((Number) ((m) listR.get(i6)).c()).intValue();
                }
                int size2 = listR.size();
                int[] iArr2 = new int[size2];
                for (int i7 = 0; i7 < size2; i7++) {
                    iArr2[i7] = ((Number) ((m) listR.get(i7)).d()).intValue();
                }
                Class<?> cls3 = f3853n;
                s(cls, objNewInstance, "setBlendArray", new Class[]{cls3, cls3}, iArr, iArr2);
            }
            Class<?> cls4 = f3851l;
            s(cls, objNewInstance, "setFrost", new Class[]{cls4}, Float.valueOf(aVar.v()));
            Class<?> cls5 = f3852m;
            s(cls, objNewInstance, "setStroke", new Class[]{cls5, cls4, cls4, cls4, cls4, cls4, cls4, cls4}, Boolean.valueOf(aVar.L()), Float.valueOf(aVar.P()), Float.valueOf(aVar.N()), Float.valueOf(aVar.M()), Float.valueOf(w(aVar.K())), Float.valueOf(u(aVar.K())), Float.valueOf(p(aVar.K())), Float.valueOf(n(aVar.K())));
            s(cls, objNewInstance, "setStrokeSpread", new Class[]{cls4}, Float.valueOf(aVar.O()));
            s(cls, objNewInstance, "setLightDirs", new Class[]{cls4, cls4, cls4, cls4}, Float.valueOf(aVar.C()), Float.valueOf(aVar.D()), Float.valueOf(aVar.E()), Float.valueOf(aVar.F()));
            s(cls, objNewInstance, "setAmbient", new Class[]{cls4}, Float.valueOf(aVar.a()));
            s(cls, objNewInstance, "setAnisoRim", new Class[]{cls5}, Boolean.valueOf(aVar.b()));
            Class<?> cls6 = f3850k;
            s(cls, objNewInstance, "setEdgeColor", new Class[]{cls6}, Integer.valueOf(aVar.t()));
            s(cls, objNewInstance, "setDarkColor", new Class[]{cls6}, Integer.valueOf(aVar.p()));
            s(cls, objNewInstance, "setDarkWidth", new Class[]{cls4}, Float.valueOf(aVar.q()));
            s(cls, objNewInstance, "setEdgeWidth", new Class[]{cls4}, Float.valueOf(aVar.u()));
            s(cls, objNewInstance, "setInnerShadow", new Class[]{cls5, cls4, cls4, cls4, cls4, cls4, cls4, cls4, cls4}, Boolean.valueOf(aVar.x()), Float.valueOf(w(aVar.w())), Float.valueOf(u(aVar.w())), Float.valueOf(p(aVar.w())), Float.valueOf(n(aVar.w())), Float.valueOf(aVar.B()), Float.valueOf(aVar.z()), Float.valueOf(aVar.A()), Float.valueOf(aVar.y()));
            s(cls, objNewInstance, "setRefraction", new Class[]{cls5, cls4, cls4}, Boolean.valueOf(aVar.H()), Float.valueOf(aVar.I()), Float.valueOf(aVar.J()));
            s(cls, objNewInstance, "setDepthEffect", new Class[]{cls4}, Float.valueOf(aVar.r()));
            s(cls, objNewInstance, "setDispersion", new Class[]{cls4}, Float.valueOf(aVar.s()));
            s(cls, objNewInstance, "setUseShapeAlpha", new Class[]{cls5}, Boolean.valueOf(aVar.L() || aVar.x()));
            s(cls, objNewInstance, "setColorGradient", new Class[]{cls6, cls6, cls6, cls4, cls6}, Integer.valueOf(aVar.m()), Integer.valueOf(aVar.j()), Integer.valueOf(aVar.i()), Float.valueOf(aVar.k()), Integer.valueOf(i5));
            return cls.getMethod("build", null).invoke(objNewInstance, null);
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

    private final void s(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object... objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method;
        String str2 = str + clsArr.length;
        HashMap<String, Method> map = f3849j;
        Method method2 = map.get(str2);
        if (method2 == null) {
            try {
                method = cls.getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            } catch (Throwable th) {
                Log.e("MotionKitInWindowMaterial", str + " reflection failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
                method = null;
            }
            method2 = method;
            map.put(str2, method2);
        }
        Method method3 = method2;
        if (method3 == null) {
            return;
        }
        method3.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    private final boolean t() {
        return (f3842c == null || f3843d == null || f3844e == null) ? false : true;
    }

    private final float u(int i5) {
        return ((i5 >>> 8) & 255) / 255.0f;
    }

    private final float w(int i5) {
        return ((i5 >>> 16) & 255) / 255.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void x(final View view, final b bVar) {
        try {
            bVar.f(bVar.d() - 1);
            if (bVar.d() <= 0) {
                if (view.isAttachedToWindow()) {
                    view.post(new Runnable() { // from class: L2.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            j.y(bVar, view);
                        }
                    });
                } else {
                    bVar.b();
                    f3846g.remove(view);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(b bVar, View view) {
        synchronized (f3840a) {
            try {
                if (bVar.d() <= 0) {
                    bVar.b();
                    f3846g.remove(view);
                }
                v vVar = v.f5542a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int z(int i5, int i6) {
        int i7 = 0;
        if (i5 == 0) {
            return 0;
        }
        int i8 = i5 != 3 ? i5 != 4 ? 0 : -1 : 1;
        int i9 = i5 != 1 ? i5 != 2 ? 0 : -1 : 1;
        while (i7 < ((i6 % 4) + 4) % 4) {
            int i10 = -i9;
            i7++;
            i9 = i8;
            i8 = i10;
        }
        if (i8 == 0 && i9 == 1) {
            return 1;
        }
        if (i8 == 0 && i9 == -1) {
            return 2;
        }
        if (i8 == 1 && i9 == 0) {
            return 3;
        }
        if (i8 == -1 && i9 == 0) {
            return 4;
        }
        return i5;
    }

    public final synchronized void A(View view, final float f5) {
        j4.k.g(view, "view");
        b bVar = f3846g.get(view);
        if (bVar == null) {
            return;
        }
        bVar.c(new InterfaceC0772l() { // from class: L2.g
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return j.B(f5, (j.a) obj);
            }
        });
    }

    public final synchronized void C(View view, final float f5) {
        j4.k.g(view, "view");
        b bVar = f3846g.get(view);
        if (bVar == null) {
            return;
        }
        bVar.c(new InterfaceC0772l() { // from class: L2.h
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return j.D(f5, (j.a) obj);
            }
        });
    }

    public final synchronized c m(View view) {
        j4.k.g(view, "view");
        boolean z5 = true;
        if (!v()) {
            boolean z6 = f3842c != null;
            boolean z7 = f3843d != null;
            if (f3844e == null) {
                z5 = false;
            }
            Log.w("MotionKitInWindowMaterial", "acquire: isAvailable=false (builder=" + z6 + " mp=" + z7 + " glassFx=" + z5 + " setBackdrop=" + L2.a.f3809a.a() + ")");
            return null;
        }
        WeakHashMap<View, b> weakHashMap = f3846g;
        b bVar = weakHashMap.get(view);
        if (bVar == null) {
            bVar = new b(view);
            weakHashMap.put(view, bVar);
        }
        b bVar2 = bVar;
        bVar2.f(bVar2.d() + 1);
        Log.d("MotionKitInWindowMaterial", "acquire: holder=" + System.identityHashCode(bVar2) + " refCount=" + bVar2.d() + " view=" + System.identityHashCode(view));
        return new c(view, bVar2);
    }

    public final synchronized <T> T o(InterfaceC0761a<? extends T> interfaceC0761a) {
        T tInvoke;
        j4.k.g(interfaceC0761a, "body");
        f3847h++;
        try {
            tInvoke = interfaceC0761a.invoke();
            int i5 = f3847h - 1;
            f3847h = i5;
            if (i5 == 0) {
                Set<b> set = f3848i;
                List listU = C0403n.U(set);
                set.clear();
                Iterator<T> it = listU.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).e();
                }
            }
        } catch (Throwable th) {
            f3847h--;
            if (f3847h == 0) {
                Set<b> set2 = f3848i;
                List listU2 = C0403n.U(set2);
                set2.clear();
                Iterator<T> it2 = listU2.iterator();
                while (it2.hasNext()) {
                    ((b) it2.next()).e();
                }
            }
            throw th;
        }
        return tInvoke;
    }

    public final boolean v() {
        return (f3841b || t()) && L2.a.f3809a.a();
    }
}
