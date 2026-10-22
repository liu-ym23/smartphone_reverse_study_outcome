package L2;

import L2.e;
import V3.v;
import W3.C0395f;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import com.stepos.minor.Minor;
import i4.InterfaceC0772l;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.WeakHashMap;
import stepos.view.effects.StepOSBackdropLayer;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f3817a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f3818b;

    /* renamed from: c, reason: collision with root package name */
    private static final Method f3819c;

    /* renamed from: d, reason: collision with root package name */
    private static final Method f3820d;

    /* renamed from: e, reason: collision with root package name */
    private static final WeakHashMap<View, b> f3821e;

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap<String, Method> f3822f;

    /* renamed from: g, reason: collision with root package name */
    private static final Class<?> f3823g;

    /* renamed from: h, reason: collision with root package name */
    private static final Class<?> f3824h;

    /* renamed from: i, reason: collision with root package name */
    private static final Class<?> f3825i;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3826a = new a();

        private a() {
        }

        public final Object a(View view) {
            j4.k.g(view, "view");
            return StepOSBackdropLayer.createBackdropLayerDrawable(view);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final boolean b(Object obj, String str, Object[] objArr) {
            j4.k.g(obj, "drawable");
            j4.k.g(str, Minor.COLUMN_NAME);
            j4.k.g(objArr, "args");
            Drawable drawable = obj instanceof Drawable ? (Drawable) obj : null;
            if (drawable == null) {
                return false;
            }
            try {
                switch (str.hashCode()) {
                    case -2070385286:
                        if (str.equals("setLightDirs")) {
                            Object obj2 = objArr[0];
                            j4.k.e(obj2, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue = ((Float) obj2).floatValue();
                            Object obj3 = objArr[1];
                            j4.k.e(obj3, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue2 = ((Float) obj3).floatValue();
                            Object obj4 = objArr[2];
                            j4.k.e(obj4, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue3 = ((Float) obj4).floatValue();
                            Object obj5 = objArr[3];
                            j4.k.e(obj5, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setLightDirs(drawable, fFloatValue, fFloatValue2, fFloatValue3, ((Float) obj5).floatValue());
                            break;
                        }
                        break;
                    case -1960043633:
                        if (!str.equals("setEdgeColors")) {
                            break;
                        } else {
                            Object obj6 = objArr[0];
                            j4.k.e(obj6, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue = ((Integer) obj6).intValue();
                            Object obj7 = objArr[1];
                            j4.k.e(obj7, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setEdgeColors(drawable, iIntValue, ((Integer) obj7).intValue());
                            break;
                        }
                    case -1835830646:
                        if (!str.equals("setBlendArray")) {
                            break;
                        } else {
                            Object obj8 = objArr[0];
                            j4.k.e(obj8, "null cannot be cast to non-null type kotlin.IntArray");
                            Object obj9 = objArr[1];
                            j4.k.e(obj9, "null cannot be cast to non-null type kotlin.IntArray");
                            StepOSBackdropLayer.setBlendArray(drawable, (int[]) obj8, (int[]) obj9);
                            break;
                        }
                    case -1762158830:
                        if (!str.equals("setGlassStroke")) {
                            break;
                        } else {
                            Object obj10 = objArr[0];
                            j4.k.e(obj10, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj10).booleanValue();
                            Object obj11 = objArr[1];
                            j4.k.e(obj11, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue4 = ((Float) obj11).floatValue();
                            Object obj12 = objArr[2];
                            j4.k.e(obj12, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue5 = ((Float) obj12).floatValue();
                            Object obj13 = objArr[3];
                            j4.k.e(obj13, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue6 = ((Float) obj13).floatValue();
                            Object obj14 = objArr[4];
                            j4.k.e(obj14, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setGlassStroke(drawable, zBooleanValue, fFloatValue4, fFloatValue5, fFloatValue6, ((Integer) obj14).intValue());
                            break;
                        }
                    case -1405168505:
                        if (!str.equals("setGlassText")) {
                            break;
                        } else {
                            Object obj15 = objArr[0];
                            j4.k.e(obj15, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue2 = ((Boolean) obj15).booleanValue();
                            Object obj16 = objArr[1];
                            j4.k.e(obj16, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue7 = ((Float) obj16).floatValue();
                            Object obj17 = objArr[2];
                            j4.k.e(obj17, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setGlassText(drawable, zBooleanValue2, fFloatValue7, ((Float) obj17).floatValue());
                            break;
                        }
                    case -1360553359:
                        if (!str.equals("setColorGradient")) {
                            break;
                        } else {
                            Object obj18 = objArr[0];
                            j4.k.e(obj18, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue2 = ((Integer) obj18).intValue();
                            Object obj19 = objArr[1];
                            j4.k.e(obj19, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue3 = ((Integer) obj19).intValue();
                            Object obj20 = objArr[2];
                            j4.k.e(obj20, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue4 = ((Integer) obj20).intValue();
                            Object obj21 = objArr[3];
                            j4.k.e(obj21, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue8 = ((Float) obj21).floatValue();
                            Object obj22 = objArr[4];
                            j4.k.e(obj22, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setColorGradient(drawable, iIntValue2, iIntValue3, iIntValue4, fFloatValue8, ((Integer) obj22).intValue());
                            break;
                        }
                    case -1174108983:
                        if (!str.equals("setCornerRadius")) {
                            break;
                        } else if (objArr.length != 1) {
                            Object obj23 = objArr[0];
                            j4.k.e(obj23, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue9 = ((Float) obj23).floatValue();
                            Object obj24 = objArr[1];
                            j4.k.e(obj24, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue10 = ((Float) obj24).floatValue();
                            Object obj25 = objArr[2];
                            j4.k.e(obj25, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue11 = ((Float) obj25).floatValue();
                            Object obj26 = objArr[3];
                            j4.k.e(obj26, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setCornerRadius(drawable, fFloatValue9, fFloatValue10, fFloatValue11, ((Float) obj26).floatValue());
                            break;
                        } else {
                            Object obj27 = objArr[0];
                            j4.k.e(obj27, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setCornerRadius(drawable, ((Float) obj27).floatValue());
                            break;
                        }
                    case -951818789:
                        if (str.equals("setBlurRadius")) {
                            Object obj28 = objArr[0];
                            j4.k.e(obj28, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setBlurRadius(drawable, ((Integer) obj28).intValue());
                            break;
                        }
                        break;
                    case -623010042:
                        if (!str.equals("setDispersion")) {
                            break;
                        } else {
                            Object obj29 = objArr[0];
                            j4.k.e(obj29, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setDispersion(drawable, ((Float) obj29).floatValue());
                            break;
                        }
                    case -320423506:
                        if (!str.equals("setDarkWidth")) {
                            break;
                        } else {
                            Object obj30 = objArr[0];
                            j4.k.e(obj30, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setDarkWidth(drawable, ((Float) obj30).floatValue());
                            break;
                        }
                    case 10984892:
                        if (!str.equals("setCornerSmoothness")) {
                            break;
                        } else {
                            Object obj31 = objArr[0];
                            j4.k.e(obj31, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setCornerSmoothness(drawable, ((Float) obj31).floatValue());
                            break;
                        }
                    case 25621303:
                        if (!str.equals("setRefraction")) {
                            break;
                        } else {
                            Object obj32 = objArr[0];
                            j4.k.e(obj32, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue3 = ((Boolean) obj32).booleanValue();
                            Object obj33 = objArr[1];
                            j4.k.e(obj33, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue12 = ((Float) obj33).floatValue();
                            Object obj34 = objArr[2];
                            j4.k.e(obj34, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setRefraction(drawable, zBooleanValue3, fFloatValue12, ((Float) obj34).floatValue());
                            break;
                        }
                    case 228676044:
                        if (!str.equals("setRefractionDepth")) {
                            break;
                        } else {
                            Object obj35 = objArr[0];
                            j4.k.e(obj35, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setRefractionDepth(drawable, ((Float) obj35).floatValue());
                            break;
                        }
                    case 250921529:
                        if (!str.equals("setBlurGradient")) {
                            break;
                        } else {
                            Object obj36 = objArr[0];
                            j4.k.e(obj36, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue5 = ((Integer) obj36).intValue();
                            Object obj37 = objArr[1];
                            j4.k.e(obj37, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setBlurGradient(drawable, iIntValue5, ((Integer) obj37).intValue());
                            break;
                        }
                    case 1200042816:
                        if (!str.equals("setAnisoRim")) {
                            break;
                        } else {
                            Object obj38 = objArr[0];
                            j4.k.e(obj38, "null cannot be cast to non-null type kotlin.Boolean");
                            StepOSBackdropLayer.setAnisoRim(drawable, ((Boolean) obj38).booleanValue());
                            break;
                        }
                    case 1290130772:
                        if (!str.equals("setInnerShadow")) {
                            break;
                        } else {
                            Object obj39 = objArr[0];
                            j4.k.e(obj39, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue4 = ((Boolean) obj39).booleanValue();
                            Object obj40 = objArr[1];
                            j4.k.e(obj40, "null cannot be cast to non-null type kotlin.Int");
                            int iIntValue6 = ((Integer) obj40).intValue();
                            Object obj41 = objArr[2];
                            j4.k.e(obj41, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue13 = ((Float) obj41).floatValue();
                            Object obj42 = objArr[3];
                            j4.k.e(obj42, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue14 = ((Float) obj42).floatValue();
                            Object obj43 = objArr[4];
                            j4.k.e(obj43, "null cannot be cast to non-null type kotlin.Float");
                            float fFloatValue15 = ((Float) obj43).floatValue();
                            Object obj44 = objArr[5];
                            j4.k.e(obj44, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setInnerShadow(drawable, zBooleanValue4, iIntValue6, fFloatValue13, fFloatValue14, fFloatValue15, ((Float) obj44).floatValue());
                            break;
                        }
                    case 1389555745:
                        if (!str.equals("setColor")) {
                            break;
                        } else {
                            Object obj45 = objArr[0];
                            j4.k.e(obj45, "null cannot be cast to non-null type kotlin.Int");
                            StepOSBackdropLayer.setColor(drawable, ((Integer) obj45).intValue());
                            break;
                        }
                    case 1390471317:
                        if (!str.equals("setDodge")) {
                            break;
                        } else {
                            Object obj46 = objArr[0];
                            j4.k.e(obj46, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setDodge(drawable, ((Float) obj46).floatValue());
                            break;
                        }
                    case 1392418690:
                        if (!str.equals("setFrost")) {
                            break;
                        } else {
                            Object obj47 = objArr[0];
                            j4.k.e(obj47, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setFrost(drawable, ((Float) obj47).floatValue());
                            break;
                        }
                    case 1756172231:
                        if (!str.equals("setEdgeWidth")) {
                            break;
                        } else {
                            Object obj48 = objArr[0];
                            j4.k.e(obj48, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setEdgeWidth(drawable, ((Float) obj48).floatValue());
                            break;
                        }
                    case 1882377614:
                        if (!str.equals("setOverlay")) {
                            break;
                        } else {
                            Object obj49 = objArr[0];
                            j4.k.e(obj49, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setOverlay(drawable, ((Float) obj49).floatValue());
                            break;
                        }
                    case 1946113869:
                        if (!str.equals("setStrokeSpread")) {
                            break;
                        } else {
                            Object obj50 = objArr[0];
                            j4.k.e(obj50, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setStrokeSpread(drawable, ((Float) obj50).floatValue());
                            break;
                        }
                    case 2081520598:
                        if (!str.equals("setAmbient")) {
                            break;
                        } else {
                            Object obj51 = objArr[0];
                            j4.k.e(obj51, "null cannot be cast to non-null type kotlin.Float");
                            StepOSBackdropLayer.setAmbient(drawable, ((Float) obj51).floatValue());
                            break;
                        }
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                Throwable cause = th2.getCause();
                if (cause != null) {
                    th2 = cause;
                }
                Log.w("MotionKitCrossWindowMaterial", "StepOSBackdropLayer." + str + " 失败，回退反射: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
                return false;
            }
            return false;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<View> f3827a;

        /* renamed from: b, reason: collision with root package name */
        private int f3828b;

        /* renamed from: c, reason: collision with root package name */
        private Object f3829c;

        /* renamed from: d, reason: collision with root package name */
        private Drawable f3830d;

        /* renamed from: e, reason: collision with root package name */
        private final C0395f<InterfaceC0772l<Object, v>> f3831e;

        /* renamed from: f, reason: collision with root package name */
        private View.OnAttachStateChangeListener f3832f;

        public static final class a implements View.OnAttachStateChangeListener {
            a() {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                j4.k.g(view, "v");
                view.removeOnAttachStateChangeListener(this);
                b.this.f3832f = null;
                b.this.i();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                j4.k.g(view, "v");
            }
        }

        public b(View view) {
            j4.k.g(view, "view");
            this.f3827a = new WeakReference<>(view);
            this.f3831e = new C0395f<>();
        }

        private final void d() {
            View view;
            if (this.f3832f == null && (view = this.f3827a.get()) != null) {
                a aVar = new a();
                this.f3832f = aVar;
                view.addOnAttachStateChangeListener(aVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i() {
            Object objH;
            View view = this.f3827a.get();
            if (view == null || (objH = e.f3817a.h(view)) == null) {
                return;
            }
            this.f3829c = objH;
            this.f3830d = view.getBackground();
            view.setBackground((Drawable) objH);
            while (!this.f3831e.isEmpty()) {
                this.f3831e.removeFirst().invoke(objH);
            }
        }

        public final void c(InterfaceC0772l<Object, v> interfaceC0772l) {
            j4.k.g(interfaceC0772l, "action");
            Object obj = this.f3829c;
            if (obj != null) {
                interfaceC0772l.invoke(obj);
            } else {
                this.f3831e.addLast(interfaceC0772l);
            }
        }

        public final void e() {
            View view;
            if (this.f3829c == null && (view = this.f3827a.get()) != null) {
                if (view.isAttachedToWindow()) {
                    i();
                } else {
                    d();
                }
            }
        }

        public final boolean f() {
            return this.f3829c != null;
        }

        public final int g() {
            return this.f3828b;
        }

        public final void h(int i5) {
            this.f3828b = i5;
        }

        public final void j() {
            View view = this.f3827a.get();
            View.OnAttachStateChangeListener onAttachStateChangeListener = this.f3832f;
            if (onAttachStateChangeListener != null && view != null) {
                view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            }
            this.f3832f = null;
            Object obj = this.f3829c;
            if (obj != null && view != null && view.getBackground() == obj) {
                view.setBackground(this.f3830d);
            }
            this.f3829c = null;
            this.f3830d = null;
            this.f3831e.clear();
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private final b f3834a;

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference<View> f3835b;

        public c(View view, b bVar) {
            j4.k.g(view, "view");
            j4.k.g(bVar, "h");
            this.f3834a = bVar;
            this.f3835b = new WeakReference<>(view);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void d(c cVar, InterfaceC0772l interfaceC0772l, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                interfaceC0772l = new InterfaceC0772l() { // from class: L2.f
                    @Override // i4.InterfaceC0772l
                    public final Object invoke(Object obj2) {
                        return e.c.e(obj2);
                    }
                };
            }
            cVar.c(interfaceC0772l);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final v e(Object obj) {
            j4.k.g(obj, "it");
            return v.f5542a;
        }

        public final void b(InterfaceC0772l<Object, v> interfaceC0772l) {
            j4.k.g(interfaceC0772l, "action");
            this.f3834a.c(interfaceC0772l);
        }

        public final void c(InterfaceC0772l<Object, v> interfaceC0772l) {
            j4.k.g(interfaceC0772l, "reset");
            this.f3834a.c(interfaceC0772l);
            View view = this.f3835b.get();
            if (view == null) {
                return;
            }
            e.f3817a.o(view, this.f3834a);
        }
    }

    static {
        boolean z5;
        Method method;
        try {
            Class.forName("stepos.view.effects.StepOSBackdropLayer");
            z5 = true;
        } catch (Throwable th) {
            Log.i("MotionKitCrossWindowMaterial", "StepOSBackdropLayer 不可用，将尝试反射 createBackdropLayerDrawable: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            z5 = false;
        }
        f3818b = z5;
        Method method2 = null;
        try {
            method = View.class.getMethod("getViewRootImpl", null);
            method.setAccessible(true);
        } catch (Throwable unused) {
            method = null;
        }
        f3819c = method;
        try {
            Method method3 = Class.forName("android.view.ViewRootImpl").getMethod("createBackdropLayerDrawable", null);
            method3.setAccessible(true);
            method2 = method3;
        } catch (Throwable th2) {
            Log.e("MotionKitCrossWindowMaterial", "createBackdropLayerDrawable unavailable: " + th2.getClass().getSimpleName() + ": " + th2.getMessage());
        }
        f3820d = method2;
        f3821e = new WeakHashMap<>();
        f3822f = new HashMap<>();
        Class<?> cls = Integer.TYPE;
        j4.k.d(cls);
        f3823g = cls;
        Class<?> cls2 = Float.TYPE;
        j4.k.d(cls2);
        f3824h = cls2;
        Class<?> cls3 = Boolean.TYPE;
        j4.k.d(cls3);
        f3825i = cls3;
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object h(View view) {
        if (f3818b) {
            try {
                return a.f3826a.a(view);
            } catch (Throwable th) {
                th = th;
                Throwable cause = th.getCause();
                if (cause != null) {
                    th = cause;
                }
                Log.w("MotionKitCrossWindowMaterial", "StepOSBackdropLayer.create 失败，回退反射: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            }
        }
        return this.i(view);
    }

    private final Object i(View view) {
        Method method;
        Method method2 = f3819c;
        if (method2 == null || (method = f3820d) == null) {
            return null;
        }
        try {
            Object objInvoke = method2.invoke(view, null);
            if (objInvoke != null) {
                return method.invoke(objInvoke, null);
            }
            Log.e("MotionKitCrossWindowMaterial", "ViewRootImpl is null (View not attached)");
            return null;
        } catch (Throwable th) {
            th = th;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.e("MotionKitCrossWindowMaterial", "createBackdropLayerDrawable failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
            return null;
        }
    }

    private final boolean m() {
        return (f3819c == null || f3820d == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void o(final View view, final b bVar) {
        try {
            bVar.h(bVar.g() - 1);
            if (bVar.g() <= 0) {
                if (view.isAttachedToWindow()) {
                    view.post(new Runnable() { // from class: L2.d
                        @Override // java.lang.Runnable
                        public final void run() {
                            e.p(bVar, view);
                        }
                    });
                } else {
                    bVar.j();
                    f3821e.remove(view);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(b bVar, View view) {
        synchronized (f3817a) {
            try {
                if (bVar.g() <= 0) {
                    bVar.j();
                    f3821e.remove(view);
                }
                v vVar = v.f5542a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v r(float f5, Object obj) {
        j4.k.g(obj, "d");
        f3817a.g(obj, "setCornerRadius", new Class[]{f3824h}, Float.valueOf(f5));
        return v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v t(float f5, Object obj) {
        j4.k.g(obj, "d");
        f3817a.g(obj, "setCornerSmoothness", new Class[]{f3824h}, Float.valueOf(f5));
        return v.f5542a;
    }

    public final synchronized c f(View view) {
        try {
            j4.k.g(view, "view");
            if (!n()) {
                return null;
            }
            WeakHashMap<View, b> weakHashMap = f3821e;
            b bVar = weakHashMap.get(view);
            if (bVar == null) {
                bVar = new b(view);
                weakHashMap.put(view, bVar);
            }
            b bVar2 = bVar;
            bVar2.h(bVar2.g() + 1);
            bVar2.e();
            if (!view.isAttachedToWindow() || bVar2.f()) {
                return new c(view, bVar2);
            }
            bVar2.h(bVar2.g() - 1);
            if (bVar2.g() <= 0) {
                bVar2.j();
                weakHashMap.remove(view);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void g(Object obj, String str, Class<?>[] clsArr, Object... objArr) {
        Method method;
        j4.k.g(obj, "drawable");
        j4.k.g(str, Minor.COLUMN_NAME);
        j4.k.g(clsArr, "types");
        j4.k.g(objArr, "args");
        if (f3818b && a.f3826a.b(obj, str, objArr)) {
            return;
        }
        String str2 = str + clsArr.length;
        HashMap<String, Method> map = f3822f;
        Method method2 = map.get(str2);
        if (method2 == null) {
            try {
                method = obj.getClass().getMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            } catch (Throwable th) {
                Log.e("MotionKitCrossWindowMaterial", str + " reflection failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
                method = null;
            }
            method2 = method;
            map.put(str2, method2);
        }
        Method method3 = method2;
        if (method3 == null) {
            return;
        }
        try {
            method3.invoke(obj, Arrays.copyOf(objArr, objArr.length));
        } catch (Throwable th2) {
            th = th2;
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            Log.e("MotionKitCrossWindowMaterial", str + " invocation failed: " + th.getClass().getSimpleName() + ": " + th.getMessage());
        }
    }

    public final Class<?> j() {
        return f3825i;
    }

    public final Class<?> k() {
        return f3824h;
    }

    public final Class<?> l() {
        return f3823g;
    }

    public final boolean n() {
        return f3818b || m();
    }

    public final synchronized void q(View view, final float f5) {
        j4.k.g(view, "view");
        b bVar = f3821e.get(view);
        if (bVar == null) {
            return;
        }
        bVar.c(new InterfaceC0772l() { // from class: L2.b
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return e.r(f5, obj);
            }
        });
    }

    public final synchronized void s(View view, final float f5) {
        j4.k.g(view, "view");
        b bVar = f3821e.get(view);
        if (bVar == null) {
            return;
        }
        bVar.c(new InterfaceC0772l() { // from class: L2.c
            @Override // i4.InterfaceC0772l
            public final Object invoke(Object obj) {
                return e.t(f5, obj);
            }
        });
    }
}
