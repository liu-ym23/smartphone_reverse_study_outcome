package j1;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.Looper;
import android.os.StrictMode;
import android.os.Trace;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.ScrollCaptureTarget;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.TranslationRequestValue;
import android.view.translation.ViewTranslationRequest;
import androidx.compose.ui.focus.FocusOwnerImpl$modifier$1;
import androidx.compose.ui.semantics.EmptySemanticsElement;
import com.stepos.agentbus.R;
import j1.z0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import n0.l;

/* loaded from: classes.dex */
public final class y extends ViewGroup implements i1.k1, i1.r1, androidx.lifecycle.f, i1.i1 {
    public static Class J0;
    public static Method K0;
    public static final k.z L0 = new k.z();
    public static p M0;
    public final b0.x0 A;
    public final db.d A0;
    public final o0.h B;
    public final androidx.lifecycle.a0 B0;
    public final ArrayList C;
    public boolean C0;
    public ArrayList D;
    public final w D0;
    public boolean E;
    public final a1 E0;
    public final c1.c F;
    public boolean F0;
    public final c1.o G;
    public final p1 G0;
    public p7.k H;
    public View H0;
    public final i5.f I;
    public final o1 I0;
    public final o0.b J;
    public boolean K;
    public final k L;
    public final j M;
    public final i1.m1 N;
    public w0 O;
    public d2.a P;
    public boolean Q;
    public final i1.t0 R;
    public long S;
    public final int[] T;
    public final float[] U;
    public final float[] V;
    public long W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f5349a0;

    /* renamed from: b0, reason: collision with root package name */
    public long f5350b0;

    /* renamed from: c0, reason: collision with root package name */
    public final b0.o1 f5351c0;

    /* renamed from: d0, reason: collision with root package name */
    public final b0.i0 f5352d0;

    /* renamed from: e0, reason: collision with root package name */
    public p7.k f5353e0;

    /* renamed from: f, reason: collision with root package name */
    public long f5354f;

    /* renamed from: f0, reason: collision with root package name */
    public final m f5355f0;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f5356g;

    /* renamed from: g0, reason: collision with root package name */
    public final n f5357g0;

    /* renamed from: h, reason: collision with root package name */
    public final i1.h0 f5358h;

    /* renamed from: h0, reason: collision with root package name */
    public final o f5359h0;

    /* renamed from: i, reason: collision with root package name */
    public final b0.o1 f5360i;

    /* renamed from: i0, reason: collision with root package name */
    public final w1.c f5361i0;

    /* renamed from: j, reason: collision with root package name */
    public final View f5362j;

    /* renamed from: j0, reason: collision with root package name */
    public final w1.d f5363j0;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f5364k;

    /* renamed from: k0, reason: collision with root package name */
    public final AtomicReference f5365k0;

    /* renamed from: l, reason: collision with root package name */
    public final m4.u0 f5366l;

    /* renamed from: l0, reason: collision with root package name */
    public final o1 f5367l0;

    /* renamed from: m, reason: collision with root package name */
    public g7.l f5368m;

    /* renamed from: m0, reason: collision with root package name */
    public final o1 f5369m0;

    /* renamed from: n, reason: collision with root package name */
    public final q0.a f5370n;

    /* renamed from: n0, reason: collision with root package name */
    public final b0.o1 f5371n0;

    /* renamed from: o, reason: collision with root package name */
    public final p1 f5372o;

    /* renamed from: o0, reason: collision with root package name */
    public int f5373o0;

    /* renamed from: p, reason: collision with root package name */
    public final o4.d0 f5374p;

    /* renamed from: p0, reason: collision with root package name */
    public final b0.o1 f5375p0;

    /* renamed from: q, reason: collision with root package name */
    public final v0 f5376q;

    /* renamed from: q0, reason: collision with root package name */
    public final y0.b f5377q0;

    /* renamed from: r, reason: collision with root package name */
    public final g1.j f5378r;

    /* renamed from: r0, reason: collision with root package name */
    public final z0.c f5379r0;

    /* renamed from: s, reason: collision with root package name */
    public final i1.f0 f5380s;

    /* renamed from: s0, reason: collision with root package name */
    public final h1.c f5381s0;

    /* renamed from: t, reason: collision with root package name */
    public final k.t f5382t;

    /* renamed from: t0, reason: collision with root package name */
    public final o1 f5383t0;

    /* renamed from: u, reason: collision with root package name */
    public final q1.a f5384u;

    /* renamed from: u0, reason: collision with root package name */
    public MotionEvent f5385u0;

    /* renamed from: v, reason: collision with root package name */
    public final y f5386v;

    /* renamed from: v0, reason: collision with root package name */
    public long f5387v0;

    /* renamed from: w, reason: collision with root package name */
    public final p1.p f5388w;

    /* renamed from: w0, reason: collision with root package name */
    public final q6.b f5389w0;

    /* renamed from: x, reason: collision with root package name */
    public final f0 f5390x;

    /* renamed from: x0, reason: collision with root package name */
    public final k.z f5391x0;

    /* renamed from: y, reason: collision with root package name */
    public p0.c f5392y;

    /* renamed from: y0, reason: collision with root package name */
    public float f5393y0;

    /* renamed from: z, reason: collision with root package name */
    public final i f5394z;

    /* renamed from: z0, reason: collision with root package name */
    public float f5395z0;

    /* JADX WARN: Type inference failed for: r1v31, types: [j1.m] */
    /* JADX WARN: Type inference failed for: r1v32, types: [j1.n] */
    /* JADX WARN: Type inference failed for: r1v33, types: [j1.o] */
    public y(Context context, g7.l lVar) {
        super(context);
        this.f5354f = 9205357640488583168L;
        int i2 = 1;
        this.f5356g = true;
        this.f5358h = new i1.h0();
        d2.e eVarA = s7.a.a(context);
        b0.b1 b1Var = b0.b1.f1109i;
        this.f5360i = new b0.o1(eVarA, b1Var);
        int i10 = Build.VERSION.SDK_INT;
        int i11 = 0;
        boolean z4 = i10 >= 35;
        this.f5364k = z4;
        p1.c cVar = new p1.c();
        EmptySemanticsElement emptySemanticsElement = new EmptySemanticsElement(cVar);
        i1.w0 w0Var = new i1.w0() { // from class: androidx.compose.ui.platform.AndroidComposeView$bringIntoViewNode$1
            @Override // i1.w0
            public final l d() {
                return new z0();
            }

            public final boolean equals(Object obj) {
                return obj == this;
            }

            @Override // i1.w0
            public final void f(l lVar2) {
                ((z0) lVar2).getClass();
            }

            public final int hashCode() {
                return this.f773a.hashCode();
            }
        };
        this.f5366l = new m4.u0(this, this);
        this.f5368m = lVar;
        this.f5370n = new q0.a();
        this.f5372o = new p1(0);
        n0.m mVarA = androidx.compose.ui.input.key.a.a(new u(this, i11));
        n0.m mVarA2 = androidx.compose.ui.input.rotary.a.a();
        this.f5374p = new o4.d0(10);
        this.f5376q = new v0(ViewConfiguration.get(context));
        g1.j jVar = new g1.j();
        this.f5378r = jVar;
        i1.f0 f0Var = new i1.f0(3);
        g1.p pVar = f0Var.f4472z;
        g1.x xVar = g1.x.f3770a;
        if (!q7.k.a(pVar, xVar)) {
            f0Var.f4472z = xVar;
            f0Var.x();
        }
        f0Var.Q(getDensity());
        f0Var.U(getViewConfiguration());
        f0Var.T(androidx.compose.ui.layout.b.b(jVar).c(emptySemanticsElement).c(mVarA2).c(mVarA).c((FocusOwnerImpl$modifier$1) ((m4.u0) getFocusOwner()).f6345e).c(m19getDragAndDropManager().f8620c).c(w0Var));
        this.f5380s = f0Var;
        k.t tVar = k.k.f5504a;
        this.f5382t = new k.t();
        getLayoutNodes();
        this.f5384u = new q1.a();
        this.f5386v = this;
        this.f5388w = new p1.p(getRoot(), cVar, getLayoutNodes());
        f0 f0Var2 = new f0(this);
        this.f5390x = f0Var2;
        this.f5392y = new p0.c(this, new s(0, this, k0.class, "getContentCaptureSessionCompat", "getContentCaptureSessionCompat(Landroid/view/View;)Landroidx/compose/ui/platform/coreshims/ContentCaptureSessionCompat;", 1, 0));
        i iVar = new i();
        Object systemService = context.getSystemService("accessibility");
        q7.k.c(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.f5394z = iVar;
        this.A = new b0.x0(this);
        this.B = new o0.h();
        this.C = new ArrayList();
        this.F = new c1.c();
        i1.f0 root = getRoot();
        c1.o oVar = new c1.o();
        oVar.f1834b = root;
        oVar.f1835c = new c1.b((i1.r) root.H.f4401g);
        oVar.f1836d = new a7.d(3);
        oVar.f1837e = new i1.p();
        this.G = oVar;
        this.H = r.f5305h;
        this.I = new i5.f(this, getAutofillTree());
        AutofillManager autofillManager = (AutofillManager) context.getSystemService(AutofillManager.class);
        if (autofillManager == null) {
            throw m.x.i("Autofill service could not be located.");
        }
        this.J = new o0.b(new a7.d(27, autofillManager), getSemanticsOwner(), this, getRectManager(), context.getPackageName());
        this.L = new k(context);
        getClipboardManager();
        this.M = new j();
        this.N = new i1.m1(new u(this, i2));
        this.R = new i1.t0(getRoot());
        long j2 = Integer.MAX_VALUE;
        this.S = (j2 & 4294967295L) | (j2 << 32);
        this.T = new int[]{0, 0};
        this.U = u0.z.g();
        this.V = u0.z.g();
        this.W = -1L;
        this.f5350b0 = 9187343241974906880L;
        this.f5351c0 = b0.b.n(null);
        this.f5352d0 = b0.b.j(new w(this, i2));
        this.f5355f0 = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: j1.m
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f5249a.E();
            }
        };
        this.f5357g0 = new ViewTreeObserver.OnScrollChangedListener() { // from class: j1.n
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                this.f5257a.E();
            }
        };
        this.f5359h0 = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: j1.o
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public final void onTouchModeChanged(boolean z10) {
                this.f5288a.f5379r0.f11755a.setValue(new z0.a(z10 ? 1 : 2));
            }
        };
        this.f5361i0 = new w1.c(getView(), this);
        w1.d dVar = new w1.d();
        new AtomicReference(null);
        this.f5363j0 = dVar;
        this.f5365k0 = new AtomicReference(null);
        getTextInputService();
        this.f5367l0 = new o1();
        this.f5369m0 = new o1();
        this.f5371n0 = new b0.o1(n7.m.l(context), b1Var);
        this.f5373o0 = i10 >= 31 ? context.getResources().getConfiguration().fontWeightAdjustment : 0;
        int layoutDirection = context.getResources().getConfiguration().getLayoutDirection();
        d2.l lVar2 = layoutDirection != 0 ? layoutDirection != 1 ? null : d2.l.f2794g : d2.l.f2793f;
        this.f5375p0 = b0.b.n(lVar2 == null ? d2.l.f2793f : lVar2);
        this.f5377q0 = new y0.b();
        int i12 = 2;
        this.f5379r0 = new z0.c(isInTouchMode() ? 1 : 2);
        this.f5381s0 = new h1.c(this);
        o1 o1Var = new o1();
        w1[] w1VarArr = w1.f5345f;
        this.f5383t0 = o1Var;
        this.f5389w0 = new q6.b(16);
        this.f5391x0 = new k.z();
        this.A0 = new db.d(i12, this);
        this.B0 = new androidx.lifecycle.a0(4, this);
        this.D0 = new w(this, 0);
        this.E0 = new a1();
        addOnAttachStateChangeListener(this.f5392y);
        setWillNotDraw(false);
        setFocusable(true);
        j0.f5206a.a(this, 1, false);
        setFocusableInTouchMode(true);
        setClipChildren(false);
        int i13 = o2.m.f7237a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        setAccessibilityDelegate(f0Var2.f7222b);
        setOnDragListener(m19getDragAndDropManager());
        getRoot().b(this);
        g0.f5166a.a(this);
        if (z4) {
            View view = new View(context);
            view.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
            view.setTag(R.id.hide_in_inspector_tag, Boolean.TRUE);
            this.f5362j = view;
            addView(view, -1);
        }
        this.G0 = i10 >= 31 ? new p1(1) : null;
        o1 o1Var2 = new o1();
        c1.i.f1802a.getClass();
        this.I0 = o1Var2;
    }

    public static void g(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof y) {
                ((y) childAt).s();
            } else if (childAt instanceof ViewGroup) {
                g((ViewGroup) childAt);
            }
        }
    }

    @c7.a
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getRoot$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    @c7.a
    public static /* synthetic */ void getTextInputService$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final q get_viewTreeOwners() {
        return (q) this.f5351c0.getValue();
    }

    public static long h(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return (0 << 32) | size;
        }
        if (mode == 0) {
            return (0 << 32) | Integer.MAX_VALUE;
        }
        if (mode != 1073741824) {
            throw new IllegalStateException();
        }
        long j2 = size;
        return j2 | (j2 << 32);
    }

    public static void k(i1.f0 f0Var) {
        f0Var.w();
        d0.e eVarS = f0Var.s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            k((i1.f0) objArr[i10]);
        }
    }

    public static boolean m(MotionEvent motionEvent) {
        boolean z4 = (Float.floatToRawIntBits(motionEvent.getX()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getY()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getRawX()) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getRawY()) & Integer.MAX_VALUE) >= 2139095040;
        if (!z4) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i2 = 1; i2 < pointerCount; i2++) {
                z4 = (Float.floatToRawIntBits(motionEvent.getX(i2)) & Integer.MAX_VALUE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getY(i2)) & Integer.MAX_VALUE) >= 2139095040 || !r1.f5310a.a(motionEvent, i2);
                if (z4) {
                    break;
                }
            }
        }
        return z4;
    }

    private void setDensity(d2.c cVar) {
        this.f5360i.setValue(cVar);
    }

    private void setFontFamilyResolver(v1.d dVar) {
        this.f5371n0.setValue(dVar);
    }

    private void setLayoutDirection(d2.l lVar) {
        this.f5375p0.setValue(lVar);
    }

    private final void set_viewTreeOwners(q qVar) {
        this.f5351c0.setValue(qVar);
    }

    public final void A(i1.f0 f0Var) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (f0Var != null) {
            while (f0Var != null && f0Var.l() == i1.d0.f4433f) {
                if (!this.Q) {
                    i1.f0 f0VarN = f0Var.n();
                    if (f0VarN == null) {
                        break;
                    }
                    long j2 = ((i1.r) f0VarN.H.f4401g).f3759i;
                    if (d2.a.f(j2) && d2.a.e(j2)) {
                        break;
                    }
                }
                f0Var = f0Var.n();
            }
            if (f0Var == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    public final long B(long j2) {
        x();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) - Float.intBitsToFloat((int) (this.f5350b0 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L)) - Float.intBitsToFloat((int) (this.f5350b0 & 4294967295L));
        return u0.z.j(this.V, (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    public final int C(MotionEvent motionEvent) {
        Object obj;
        if (this.F0) {
            this.F0 = false;
            int metaState = motionEvent.getMetaState();
            this.f5372o.getClass();
            c2.f5114a.setValue(new c1.r(metaState));
        }
        c1.c cVar = this.F;
        q6.b bVarA = cVar.a(motionEvent, this);
        c1.o oVar = this.G;
        if (bVarA == null) {
            if (!oVar.f1833a) {
                k.n nVar = (k.n) ((a7.d) oVar.f1836d).f411g;
                int i2 = nVar.f5510i;
                Object[] objArr = nVar.f5509h;
                for (int i10 = 0; i10 < i2; i10++) {
                    objArr[i10] = null;
                }
                nVar.f5510i = 0;
                nVar.f5507f = false;
                ((c1.b) oVar.f1835c).c();
            }
            return 0;
        }
        List list = (List) bVarA.f8788h;
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i11 = size - 1;
                obj = list.get(size);
                if (((c1.n) obj).f1826e) {
                    break;
                }
                if (i11 < 0) {
                    break;
                }
                size = i11;
            }
            obj = null;
        } else {
            obj = null;
        }
        c1.n nVar2 = (c1.n) obj;
        if (nVar2 != null) {
            this.f5354f = nVar2.f1825d;
        }
        int iE = oVar.e(bVarA, this, n(motionEvent));
        bVarA.f8787g = null;
        int actionMasked = motionEvent.getActionMasked();
        if ((actionMasked != 0 && actionMasked != 5) || (iE & 1) != 0) {
            return iE;
        }
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        cVar.f1781c.delete(pointerId);
        cVar.f1780b.delete(pointerId);
        return iE;
    }

    public final void D(MotionEvent motionEvent, int i2, long j2, boolean z4) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                actionIndex = motionEvent.getActionIndex();
            }
        } else if (i2 != 9 && i2 != 10) {
            actionIndex = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (actionIndex >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i10 = 0; i10 < pointerCount; i10++) {
            pointerPropertiesArr[i10] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i11 = 0; i11 < pointerCount; i11++) {
            pointerCoordsArr[i11] = new MotionEvent.PointerCoords();
        }
        int i12 = 0;
        while (i12 < pointerCount) {
            int i13 = ((actionIndex < 0 || i12 < actionIndex) ? 0 : 1) + i12;
            motionEvent.getPointerProperties(i13, pointerPropertiesArr[i12]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i12];
            motionEvent.getPointerCoords(i13, pointerCoords);
            float f10 = pointerCoords.x;
            long jP = p((Float.floatToRawIntBits(pointerCoords.y) & 4294967295L) | (Float.floatToRawIntBits(f10) << 32));
            pointerCoords.x = Float.intBitsToFloat((int) (jP >> 32));
            pointerCoords.y = Float.intBitsToFloat((int) (jP & 4294967295L));
            i12++;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? j2 : motionEvent.getDownTime(), j2, i2, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), z4 ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        q6.b bVarA = this.F.a(motionEventObtain, this);
        q7.k.b(bVarA);
        this.G.e(bVarA, this, true);
        motionEventObtain.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E() {
        /*
            r18 = this;
            r0 = r18
            int[] r1 = r0.T
            r0.getLocationOnScreen(r1)
            long r2 = r0.S
            r4 = 32
            long r5 = r2 >> r4
            int r5 = (int) r5
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r2 = r2 & r6
            int r2 = (int) r2
            r3 = 0
            r8 = r1[r3]
            r9 = 1
            if (r5 != r8) goto L27
            r10 = r1[r9]
            if (r2 != r10) goto L27
            long r10 = r0.W
            r12 = 0
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L44
        L27:
            r1 = r1[r9]
            long r10 = (long) r8
            long r10 = r10 << r4
            long r12 = (long) r1
            long r12 = r12 & r6
            long r10 = r10 | r12
            r0.S = r10
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r5 == r1) goto L44
            if (r2 == r1) goto L44
            i1.f0 r1 = r0.getRoot()
            i1.i0 r1 = r1.I
            i1.v0 r1 = r1.f4507o
            r1.T()
            r1 = r9
            goto L45
        L44:
            r1 = r3
        L45:
            r0.x()
            android.view.View r2 = r0.H0
            if (r2 != 0) goto L52
            android.view.View r2 = r0.getRootView()
            r0.H0 = r2
        L52:
            q1.a r5 = r0.getRectManager()
            long r10 = r0.S
            long r12 = r0.f5350b0
            long r12 = a.a.i0(r12)
            int r8 = r2.getWidth()
            int r2 = r2.getHeight()
            r5.getClass()
            float[] r14 = r0.U
            int r15 = n7.m.c(r14)
            q1.b r3 = r5.f8626b
            r15 = r15 & 2
            if (r15 != 0) goto L78
        L75:
            r16 = r6
            goto L7a
        L78:
            r14 = 0
            goto L75
        L7a:
            long r6 = r3.f8637c
            boolean r6 = d2.i.a(r12, r6)
            if (r6 != 0) goto L86
            r3.f8637c = r12
            r6 = r9
            goto L87
        L86:
            r6 = 0
        L87:
            long r12 = r3.f8638d
            boolean r7 = d2.i.a(r10, r12)
            if (r7 != 0) goto L92
            r3.f8638d = r10
            r6 = r9
        L92:
            if (r14 == 0) goto L95
            r6 = r9
        L95:
            long r7 = (long) r8
            long r7 = r7 << r4
            long r10 = (long) r2
            long r10 = r10 & r16
            long r7 = r7 | r10
            long r10 = r3.f8639e
            int r2 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r2 == 0) goto La4
            r3.f8639e = r7
            r6 = r9
        La4:
            if (r6 != 0) goto Lad
            boolean r2 = r5.f8629e
            if (r2 == 0) goto Lab
            goto Lad
        Lab:
            r3 = 0
            goto Lae
        Lad:
            r3 = r9
        Lae:
            r5.f8629e = r3
            i1.t0 r2 = r0.R
            r2.a(r1)
            q1.a r0 = r0.getRectManager()
            r0.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.y.E():void");
    }

    public final void F(float f10) {
        if (this.f5364k) {
            if (f10 > 0.0f) {
                if (Float.isNaN(this.f5393y0) || f10 > this.f5393y0) {
                    this.f5393y0 = f10;
                    return;
                }
                return;
            }
            if (f10 < 0.0f) {
                if (Float.isNaN(this.f5395z0) || f10 < this.f5395z0) {
                    this.f5395z0 = f10;
                }
            }
        }
    }

    @Override // androidx.lifecycle.f
    public final void a(androidx.lifecycle.v vVar) {
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        addView(view, -1);
    }

    @Override // android.view.View
    public final void autofill(SparseArray sparseArray) {
        p1.i iVarQ;
        p7.k kVar;
        int i2 = 0;
        o0.b bVar = this.J;
        if (bVar != null) {
            int size = sparseArray.size();
            for (int i10 = 0; i10 < size; i10++) {
                int iKeyAt = sparseArray.keyAt(i10);
                AutofillValue autofillValue = (AutofillValue) sparseArray.get(iKeyAt);
                if (autofillValue.isText()) {
                    i1.f0 f0Var = (i1.f0) bVar.f7173b.f8323c.b(iKeyAt);
                    if (f0Var != null && (iVarQ = f0Var.q()) != null) {
                        Object objG = iVarQ.f8304f.g(p1.h.f8283f);
                        if (objG == null) {
                            objG = null;
                        }
                        p1.a aVar = (p1.a) objG;
                        if (aVar != null && (kVar = (p7.k) aVar.f8267b) != null) {
                        }
                    }
                } else if (autofillValue.isDate()) {
                    Log.w("ComposeAutofillManager", "Auto filling Date fields is not yet supported.");
                } else if (autofillValue.isList()) {
                    Log.w("ComposeAutofillManager", "Auto filling dropdown lists is not yet supported.");
                } else if (autofillValue.isToggle()) {
                    Log.w("ComposeAutofillManager", "Auto filling toggle fields are not yet supported.");
                }
            }
        }
        i5.f fVar = this.I;
        if (fVar != null) {
            o0.h hVar = (o0.h) fVar.f4654h;
            if (hVar.f7182a.isEmpty()) {
                return;
            }
            int size2 = sparseArray.size();
            while (i2 < size2) {
                int iKeyAt2 = sparseArray.keyAt(i2);
                AutofillValue autofillValue2 = (AutofillValue) sparseArray.get(iKeyAt2);
                if (autofillValue2.isText()) {
                    autofillValue2.getTextValue().toString();
                    if (hVar.f7182a.get(Integer.valueOf(iKeyAt2)) != null) {
                        throw new ClassCastException();
                    }
                } else {
                    if (autofillValue2.isDate()) {
                        throw new c7.i("An operation is not implemented: b/138604541: Add onFill() callback for date");
                    }
                    if (autofillValue2.isList()) {
                        throw new c7.i("An operation is not implemented: b/138604541: Add onFill() callback for list");
                    }
                    if (autofillValue2.isToggle()) {
                        throw new c7.i("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
                    }
                }
                i2++;
            }
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i2) {
        return this.f5390x.e(false, i2, this.f5354f);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i2) {
        return this.f5390x.e(true, i2, this.f5354f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (!isAttachedToWindow()) {
            k(getRoot());
        }
        q(true);
        l0.m.k().m();
        this.E = true;
        o4.d0 d0Var = this.f5374p;
        u0.a aVar = (u0.a) d0Var.f7326g;
        Canvas canvas2 = aVar.f9869a;
        aVar.f9869a = canvas;
        getRoot().g(aVar, null);
        ((u0.a) d0Var.f7326g).f9869a = canvas2;
        ArrayList arrayList = this.C;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((n1) ((i1.j1) arrayList.get(i2))).f();
            }
        }
        int i10 = a2.f5095f;
        arrayList.clear();
        this.E = false;
        ArrayList arrayList2 = this.D;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
            arrayList2.clear();
        }
        if (this.f5364k) {
            y0.a(this, this.f5393y0);
            View view = this.f5362j;
            if (view == null) {
                q7.k.j("frameRateCategoryView");
                throw null;
            }
            y0.a(view, this.f5395z0);
            if (!Float.isNaN(this.f5395z0)) {
                view.invalidate();
                drawChild(canvas, view, getDrawingTime());
            }
            this.f5393y0 = Float.NaN;
            this.f5395z0 = Float.NaN;
        }
        getRectManager().b();
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        i1.a1 a1Var;
        e1.a aVar;
        int size;
        i1.a1 a1Var2;
        n0.l lVarE;
        i1.a1 a1Var3;
        if (this.C0) {
            androidx.lifecycle.a0 a0Var = this.B0;
            removeCallbacks(a0Var);
            if (motionEvent.getActionMasked() == 8) {
                this.C0 = false;
            } else {
                a0Var.run();
            }
        }
        if (m(motionEvent) || !isAttachedToWindow()) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() != 8) {
            if (!motionEvent.isFromSource(2)) {
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                Float.floatToRawIntBits(x10);
                Float.floatToRawIntBits(y10);
                motionEvent.getEventTime();
                motionEvent.getActionMasked();
                m4.u0 u0Var = (m4.u0) getFocusOwner();
                if (((s0.f) u0Var.f6344d).f9172e) {
                    System.out.println((Object) "FocusRelatedWarning: Dispatching indirect touch event while the focus system is invalidated.");
                } else {
                    s0.q qVarG = s0.e.g((s0.q) u0Var.f6343c);
                    if (qVarG != null) {
                        if (!qVarG.f6797f.f6810s) {
                            f1.a.b("visitAncestors called on an unattached node");
                        }
                        n0.l lVar = qVarG.f6797f;
                        i1.f0 f0VarU = i1.l.u(qVarG);
                        while (f0VarU != null) {
                            if ((((n0.l) f0VarU.H.f4404j).f6800i & 2097152) != 0) {
                                while (lVar != null) {
                                    if ((lVar.f6799h & 2097152) != 0) {
                                        n0.l lVarE2 = lVar;
                                        d0.e eVar = null;
                                        while (lVarE2 != null) {
                                            if ((lVarE2.f6799h & 2097152) != 0 && (lVarE2 instanceof i1.k)) {
                                                int i2 = 0;
                                                for (n0.l lVar2 = ((i1.k) lVarE2).f4514u; lVar2 != null; lVar2 = lVar2.f6802k) {
                                                    if ((lVar2.f6799h & 2097152) != 0) {
                                                        i2++;
                                                        if (i2 == 1) {
                                                            lVarE2 = lVar2;
                                                        } else {
                                                            if (eVar == null) {
                                                                eVar = new d0.e(new n0.l[16]);
                                                            }
                                                            if (lVarE2 != null) {
                                                                eVar.b(lVarE2);
                                                                lVarE2 = null;
                                                            }
                                                            eVar.b(lVar2);
                                                        }
                                                    }
                                                }
                                                if (i2 == 1) {
                                                }
                                            }
                                            lVarE2 = i1.l.e(eVar);
                                        }
                                    }
                                    lVar = lVar.f6801j;
                                }
                            }
                            f0VarU = f0VarU.n();
                            lVar = (f0VarU == null || (a1Var = f0VarU.H) == null) ? null : (i1.u1) a1Var.f4403i;
                        }
                    }
                }
            }
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        if (!motionEvent.isFromSource(4194304)) {
            return (j(motionEvent) & 1) != 0;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        motionEvent.getAxisValue(26);
        getContext();
        viewConfiguration.getScaledVerticalScrollFactor();
        getContext();
        viewConfiguration.getScaledHorizontalScrollFactor();
        motionEvent.getEventTime();
        motionEvent.getDeviceId();
        m4.u0 u0Var2 = (m4.u0) getFocusOwner();
        if (((s0.f) u0Var2.f6344d).f9172e) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching rotary event while the focus system is invalidated.");
            return false;
        }
        s0.q qVarG2 = s0.e.g((s0.q) u0Var2.f6343c);
        if (qVarG2 != null) {
            if (!qVarG2.f6797f.f6810s) {
                f1.a.b("visitAncestors called on an unattached node");
            }
            n0.l lVar3 = qVarG2.f6797f;
            i1.f0 f0VarU2 = i1.l.u(qVarG2);
            loop0: while (true) {
                if (f0VarU2 == null) {
                    lVarE = null;
                    break;
                }
                if ((((n0.l) f0VarU2.H.f4404j).f6800i & 16384) != 0) {
                    while (lVar3 != null) {
                        if ((lVar3.f6799h & 16384) != 0) {
                            lVarE = lVar3;
                            d0.e eVar2 = null;
                            while (lVarE != null) {
                                if (lVarE instanceof e1.a) {
                                    break loop0;
                                }
                                if ((lVarE.f6799h & 16384) != 0 && (lVarE instanceof i1.k)) {
                                    int i10 = 0;
                                    for (n0.l lVar4 = ((i1.k) lVarE).f4514u; lVar4 != null; lVar4 = lVar4.f6802k) {
                                        if ((lVar4.f6799h & 16384) != 0) {
                                            i10++;
                                            if (i10 == 1) {
                                                lVarE = lVar4;
                                            } else {
                                                if (eVar2 == null) {
                                                    eVar2 = new d0.e(new n0.l[16]);
                                                }
                                                if (lVarE != null) {
                                                    eVar2.b(lVarE);
                                                    lVarE = null;
                                                }
                                                eVar2.b(lVar4);
                                            }
                                        }
                                    }
                                    if (i10 == 1) {
                                    }
                                }
                                lVarE = i1.l.e(eVar2);
                            }
                        }
                        lVar3 = lVar3.f6801j;
                    }
                }
                f0VarU2 = f0VarU2.n();
                lVar3 = (f0VarU2 == null || (a1Var3 = f0VarU2.H) == null) ? null : (i1.u1) a1Var3.f4403i;
            }
            aVar = (e1.a) lVarE;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            e1.a aVar2 = aVar;
            if (!aVar2.f6797f.f6810s) {
                f1.a.b("visitAncestors called on an unattached node");
            }
            n0.l lVar5 = aVar2.f6797f.f6801j;
            i1.f0 f0VarU3 = i1.l.u(aVar);
            ArrayList arrayList = null;
            while (f0VarU3 != null) {
                if ((((n0.l) f0VarU3.H.f4404j).f6800i & 16384) != 0) {
                    while (lVar5 != null) {
                        if ((lVar5.f6799h & 16384) != 0) {
                            n0.l lVarE3 = lVar5;
                            d0.e eVar3 = null;
                            while (lVarE3 != null) {
                                if (lVarE3 instanceof e1.a) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(lVarE3);
                                } else if ((lVarE3.f6799h & 16384) != 0 && (lVarE3 instanceof i1.k)) {
                                    int i11 = 0;
                                    for (n0.l lVar6 = ((i1.k) lVarE3).f4514u; lVar6 != null; lVar6 = lVar6.f6802k) {
                                        if ((lVar6.f6799h & 16384) != 0) {
                                            i11++;
                                            if (i11 == 1) {
                                                lVarE3 = lVar6;
                                            } else {
                                                if (eVar3 == null) {
                                                    eVar3 = new d0.e(new n0.l[16]);
                                                }
                                                if (lVarE3 != null) {
                                                    eVar3.b(lVarE3);
                                                    lVarE3 = null;
                                                }
                                                eVar3.b(lVar6);
                                            }
                                        }
                                    }
                                    if (i11 == 1) {
                                    }
                                }
                                lVarE3 = i1.l.e(eVar3);
                            }
                        }
                        lVar5 = lVar5.f6801j;
                    }
                }
                f0VarU3 = f0VarU3.n();
                lVar5 = (f0VarU3 == null || (a1Var2 = f0VarU3.H) == null) ? null : (i1.u1) a1Var2.f4403i;
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i12 = size - 1;
                    ((e1.a) arrayList.get(size)).getClass();
                    if (i12 < 0) {
                        break;
                    }
                    size = i12;
                }
            }
            n0.l lVarE4 = aVar2.f6797f;
            d0.e eVar4 = null;
            while (lVarE4 != null) {
                if (lVarE4 instanceof e1.a) {
                } else if ((lVarE4.f6799h & 16384) != 0 && (lVarE4 instanceof i1.k)) {
                    int i13 = 0;
                    for (n0.l lVar7 = ((i1.k) lVarE4).f4514u; lVar7 != null; lVar7 = lVar7.f6802k) {
                        if ((lVar7.f6799h & 16384) != 0) {
                            i13++;
                            if (i13 == 1) {
                                lVarE4 = lVar7;
                            } else {
                                if (eVar4 == null) {
                                    eVar4 = new d0.e(new n0.l[16]);
                                }
                                if (lVarE4 != null) {
                                    eVar4.b(lVarE4);
                                    lVarE4 = null;
                                }
                                eVar4.b(lVar7);
                            }
                        }
                    }
                    if (i13 == 1) {
                    }
                }
                lVarE4 = i1.l.e(eVar4);
            }
            if (!super.dispatchGenericMotionEvent(motionEvent)) {
                n0.l lVarE5 = aVar2.f6797f;
                d0.e eVar5 = null;
                while (lVarE5 != null) {
                    if (lVarE5 instanceof e1.a) {
                    } else if ((lVarE5.f6799h & 16384) != 0 && (lVarE5 instanceof i1.k)) {
                        int i14 = 0;
                        for (n0.l lVar8 = ((i1.k) lVarE5).f4514u; lVar8 != null; lVar8 = lVar8.f6802k) {
                            if ((lVar8.f6799h & 16384) != 0) {
                                i14++;
                                if (i14 == 1) {
                                    lVarE5 = lVar8;
                                } else {
                                    if (eVar5 == null) {
                                        eVar5 = new d0.e(new n0.l[16]);
                                    }
                                    if (lVarE5 != null) {
                                        eVar5.b(lVarE5);
                                        lVarE5 = null;
                                    }
                                    eVar5.b(lVar8);
                                }
                            }
                        }
                        if (i14 == 1) {
                        }
                    }
                    lVarE5 = i1.l.e(eVar5);
                }
                if (arrayList != null) {
                    int size2 = arrayList.size();
                    for (int i15 = 0; i15 < size2; i15++) {
                        r rVar = ((e1.a) arrayList.get(i15)).f3045t;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x010e, code lost:
    
        r5.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(r24);
        r5 = r2.f5139e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0117, code lost:
    
        if (r5 != r14) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x011a, code lost:
    
        r2.f5139e = r14;
        j1.f0.w(r2, r14, 128, null, 12);
        j1.f0.w(r2, r5, 256, null, 12);
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0160  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchHoverEvent(android.view.MotionEvent r24) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.y.dispatchHoverEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isFocused()) {
            return ((m4.u0) getFocusOwner()).i(keyEvent, new a8.e(9, this, keyEvent));
        }
        int metaState = keyEvent.getMetaState();
        this.f5372o.getClass();
        c2.f5114a.setValue(new c1.r(metaState));
        return ((m4.u0) getFocusOwner()).i(keyEvent, s0.g.f9173g) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        i1.a1 a1Var;
        if (isFocused()) {
            m4.u0 u0Var = (m4.u0) getFocusOwner();
            if (((s0.f) u0Var.f6344d).f9172e) {
                System.out.println((Object) "FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            } else {
                s0.q qVarG = s0.e.g((s0.q) u0Var.f6343c);
                if (qVarG != null) {
                    if (!qVarG.f6797f.f6810s) {
                        f1.a.b("visitAncestors called on an unattached node");
                    }
                    n0.l lVar = qVarG.f6797f;
                    i1.f0 f0VarU = i1.l.u(qVarG);
                    while (f0VarU != null) {
                        if ((((n0.l) f0VarU.H.f4404j).f6800i & 131072) != 0) {
                            while (lVar != null) {
                                if ((lVar.f6799h & 131072) != 0) {
                                    n0.l lVarE = lVar;
                                    d0.e eVar = null;
                                    while (lVarE != null) {
                                        if ((lVarE.f6799h & 131072) != 0 && (lVarE instanceof i1.k)) {
                                            int i2 = 0;
                                            for (n0.l lVar2 = ((i1.k) lVarE).f4514u; lVar2 != null; lVar2 = lVar2.f6802k) {
                                                if ((lVar2.f6799h & 131072) != 0) {
                                                    i2++;
                                                    if (i2 == 1) {
                                                        lVarE = lVar2;
                                                    } else {
                                                        if (eVar == null) {
                                                            eVar = new d0.e(new n0.l[16]);
                                                        }
                                                        if (lVarE != null) {
                                                            eVar.b(lVarE);
                                                            lVarE = null;
                                                        }
                                                        eVar.b(lVar2);
                                                    }
                                                }
                                            }
                                            if (i2 == 1) {
                                            }
                                        }
                                        lVarE = i1.l.e(eVar);
                                    }
                                }
                                lVar = lVar.f6801j;
                            }
                        }
                        f0VarU = f0VarU.n();
                        lVar = (f0VarU == null || (a1Var = f0VarU.H) == null) ? null : (i1.u1) a1Var.f4403i;
                    }
                }
            }
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.C0) {
            androidx.lifecycle.a0 a0Var = this.B0;
            removeCallbacks(a0Var);
            MotionEvent motionEvent2 = this.f5385u0;
            q7.k.b(motionEvent2);
            if (motionEvent.getActionMasked() == 0 && motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) {
                this.C0 = false;
            } else {
                a0Var.run();
            }
        }
        if (!m(motionEvent) && isAttachedToWindow() && (motionEvent.getActionMasked() != 2 || o(motionEvent))) {
            int iJ = j(motionEvent);
            if ((iJ & 2) != 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            if ((iJ & 1) != 0) {
                return true;
            }
        }
        return false;
    }

    public final View findViewByAccessibilityIdTraversal(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(this, Integer.valueOf(i2));
            if (objInvoke instanceof View) {
                return (View) objInvoke;
            }
        } catch (NoSuchMethodException unused) {
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View view, int i2) {
        t0.c cVarD;
        if (view == null || this.R.f4597c) {
            return super.focusSearch(view, i2);
        }
        Object obj = l1.f5240f.get();
        q7.k.b(obj);
        View viewB = ((l1) obj).b(this, view, i2);
        if (view == this) {
            s0.q qVarG = s0.e.g((s0.q) ((m4.u0) getFocusOwner()).f6343c);
            cVarD = qVarG != null ? s0.e.j(qVarG) : null;
            if (cVarD == null) {
                cVarD = s0.e.d(view, this);
            }
        } else {
            cVarD = s0.e.d(view, this);
        }
        s0.b bVarA = s0.e.A(i2);
        int i10 = bVarA != null ? bVarA.f9166a : 6;
        q7.v vVar = new q7.v();
        if (((m4.u0) getFocusOwner()).j(i10, cVarD, new b1.f(vVar, 1)) != null) {
            Object obj2 = vVar.f8820f;
            if (obj2 != null) {
                if (viewB != null) {
                    if (i10 == 1 || i10 == 2) {
                        return super.focusSearch(view, i2);
                    }
                    if (s0.e.o(s0.e.j((s0.q) obj2), s0.e.d(viewB, this), cVarD, i10)) {
                    }
                }
                return this;
            }
            if (viewB == null) {
            }
            return viewB;
        }
        return view;
    }

    public final w0 getAndroidViewsHandler$ui_release() {
        if (this.O == null) {
            w0 w0Var = new w0(getContext());
            this.O = w0Var;
            addView(w0Var, -1);
            requestLayout();
        }
        w0 w0Var2 = this.O;
        q7.k.b(w0Var2);
        return w0Var2;
    }

    public o0.e getAutofill() {
        return this.I;
    }

    public o0.g getAutofillManager() {
        return this.J;
    }

    public o0.h getAutofillTree() {
        return this.B;
    }

    public final p7.k getConfigurationChangeObserver() {
        return this.H;
    }

    public final p0.c getContentCaptureManager$ui_release() {
        return this.f5392y;
    }

    public g7.l getCoroutineContext() {
        return this.f5368m;
    }

    public d2.c getDensity() {
        return (d2.c) this.f5360i.getValue();
    }

    public t0.c getEmbeddedViewFocusRect() {
        if (isFocused()) {
            s0.q qVarG = s0.e.g((s0.q) ((m4.u0) getFocusOwner()).f6343c);
            if (qVarG != null) {
                return s0.e.j(qVarG);
            }
            return null;
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus != null) {
            return s0.e.d(viewFindFocus, this);
        }
        return null;
    }

    public s0.h getFocusOwner() {
        return this.f5366l;
    }

    @Override // android.view.View
    public final void getFocusedRect(Rect rect) {
        t0.c embeddedViewFocusRect = getEmbeddedViewFocusRect();
        if (embeddedViewFocusRect != null) {
            rect.left = Math.round(embeddedViewFocusRect.f9656a);
            rect.top = Math.round(embeddedViewFocusRect.f9657b);
            rect.right = Math.round(embeddedViewFocusRect.f9658c);
            rect.bottom = Math.round(embeddedViewFocusRect.f9659d);
            return;
        }
        if (q7.k.a(((m4.u0) getFocusOwner()).j(6, null, r.f5306i), Boolean.TRUE)) {
            super.getFocusedRect(rect);
        } else {
            rect.set(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
    }

    public v1.d getFontFamilyResolver() {
        return (v1.d) this.f5371n0.getValue();
    }

    public v1.c getFontLoader() {
        return this.f5369m0;
    }

    public u0.p getGraphicsContext() {
        return this.A;
    }

    public y0.a getHapticFeedBack() {
        return this.f5377q0;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return this.R.f4596b.F();
    }

    @Override // android.view.View
    public int getImportantForAutofill() {
        return 1;
    }

    public z0.b getInputModeManager() {
        return this.f5379r0;
    }

    public final g1.j getInsetsListener() {
        return this.f5378r;
    }

    public final long getLastMatrixRecalculationAnimationTime$ui_release() {
        return this.W;
    }

    @Override // android.view.View, android.view.ViewParent
    public d2.l getLayoutDirection() {
        return (d2.l) this.f5375p0.getValue();
    }

    public long getMeasureIteration() {
        i1.t0 t0Var = this.R;
        if (!t0Var.f4597c) {
            f1.a.a("measureIteration should be only used during the measure/layout pass");
        }
        return t0Var.f4601g;
    }

    public h1.c getModifierLocalManager() {
        return this.f5381s0;
    }

    public g1.r getPlacementScope() {
        int i2 = g1.u.f3765b;
        return new g1.m(1, this);
    }

    public c1.j getPointerIconService() {
        return this.I0;
    }

    public q1.a getRectManager() {
        return this.f5384u;
    }

    public i1.f0 getRoot() {
        return this.f5380s;
    }

    public i1.r1 getRootForTest() {
        return this.f5386v;
    }

    public final boolean getScrollCaptureInProgress$ui_release() {
        p1 p1Var;
        if (Build.VERSION.SDK_INT < 31 || (p1Var = this.G0) == null) {
            return false;
        }
        return ((Boolean) p1Var.f5296a.getValue()).booleanValue();
    }

    public p1.p getSemanticsOwner() {
        return this.f5388w;
    }

    public i1.h0 getSharedDrawScope() {
        return this.f5358h;
    }

    public boolean getShowLayoutBounds() {
        return x0.f5348a.a(this);
    }

    public i1.m1 getSnapshotObserver() {
        return this.N;
    }

    public u1 getSoftwareKeyboardController() {
        return this.f5367l0;
    }

    public w1.d getTextInputService() {
        return this.f5363j0;
    }

    public v1 getTextToolbar() {
        return this.f5383t0;
    }

    public final i1.q1 getUncaughtExceptionHandler$ui_release() {
        return null;
    }

    public View getView() {
        return this;
    }

    public y1 getViewConfiguration() {
        return this.f5376q;
    }

    public final q getViewTreeOwners() {
        return (q) this.f5352d0.getValue();
    }

    public b2 getWindowInfo() {
        return this.f5372o;
    }

    public final o0.b get_autofillManager$ui_release() {
        return this.J;
    }

    public final void i(i1.f0 f0Var, boolean z4) {
        this.R.d(f0Var, z4);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int j(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.y.j(android.view.MotionEvent):int");
    }

    public final void l(i1.f0 f0Var) {
        this.R.m(f0Var, false);
        d0.e eVarS = f0Var.s();
        Object[] objArr = eVarS.f2749f;
        int i2 = eVarS.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            l((i1.f0) objArr[i10]);
        }
    }

    public final boolean n(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        return 0.0f <= x10 && x10 <= ((float) getWidth()) && 0.0f <= y10 && y10 <= ((float) getHeight());
    }

    public final boolean o(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        return (motionEvent.getPointerCount() == 1 && (motionEvent2 = this.f5385u0) != null && motionEvent2.getPointerCount() == motionEvent.getPointerCount() && motionEvent.getRawX() == motionEvent2.getRawX() && motionEvent.getRawY() == motionEvent2.getRawY()) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        androidx.lifecycle.x xVarA;
        androidx.lifecycle.v vVar;
        super.onAttachedToWindow();
        this.f5378r.onViewAttachedToWindow(this);
        if (M0 == null) {
            p pVar = new p(0);
            M0 = pVar;
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            try {
                if (J0 == null) {
                    J0 = Class.forName("android.os.SystemProperties");
                }
                if (K0 == null) {
                    StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
                    Class cls = J0;
                    K0 = cls != null ? cls.getDeclaredMethod("addChangeCallback", Runnable.class) : null;
                }
                Method method = K0;
                if (method != null) {
                    method.invoke(null, pVar);
                }
            } catch (Throwable unused) {
            }
            StrictMode.setVmPolicy(vmPolicy);
        }
        k.z zVar = L0;
        synchronized (zVar) {
            zVar.a(this);
        }
        this.f5372o.f5296a.setValue(Boolean.valueOf(hasWindowFocus()));
        this.f5372o.getClass();
        this.f5372o.getClass();
        l(getRoot());
        k(getRoot());
        getSnapshotObserver().f4536a.b();
        i5.f fVar = this.I;
        if (fVar != null) {
            o0.f fVar2 = o0.f.f7181a;
            fVar2.getClass();
            ((AutofillManager) fVar.f4655i).registerCallback(fVar2);
        }
        androidx.lifecycle.v vVarC = androidx.lifecycle.j0.c(this);
        i3.e eVarY = w7.e0.y(this);
        q viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners == null || (vVarC != null && eVarY != null && (vVarC != (vVar = viewTreeOwners.f5297a) || eVarY != vVar))) {
            if (vVarC == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
            if (eVarY == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
            if (viewTreeOwners != null && (xVarA = viewTreeOwners.f5297a.a()) != null) {
                xVarA.f(this);
            }
            vVarC.a().a(this);
            q qVar = new q(vVarC, eVarY);
            set_viewTreeOwners(qVar);
            p7.k kVar = this.f5353e0;
            if (kVar != null) {
                kVar.invoke(qVar);
            }
            this.f5353e0 = null;
        }
        this.f5379r0.f11755a.setValue(new z0.a(isInTouchMode() ? 1 : 2));
        q viewTreeOwners2 = getViewTreeOwners();
        androidx.lifecycle.x xVarA2 = viewTreeOwners2 != null ? viewTreeOwners2.f5297a.a() : null;
        if (xVarA2 == null) {
            throw m.x.i("No lifecycle owner exists");
        }
        xVarA2.a(this);
        xVarA2.a(this.f5392y);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f5355f0);
        getViewTreeObserver().addOnScrollChangedListener(this.f5357g0);
        getViewTreeObserver().addOnTouchModeChangeListener(this.f5359h0);
        if (Build.VERSION.SDK_INT >= 31) {
            i0.f5198a.b(this);
        }
        o0.b bVar = this.J;
        if (bVar != null) {
            ((k.z) ((m4.u0) getFocusOwner()).f6347g).a(bVar);
            getSemanticsOwner().f8324d.a(bVar);
        }
    }

    @Override // android.view.View
    public final boolean onCheckIsTextEditor() {
        if (this.f5365k0.get() != null) {
            throw new ClassCastException();
        }
        this.f5361i0.getClass();
        return false;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setDensity(s7.a.a(getContext()));
        this.f5372o.getClass();
        int i2 = Build.VERSION.SDK_INT;
        if ((i2 >= 31 ? configuration.fontWeightAdjustment : 0) != this.f5373o0) {
            this.f5373o0 = i2 >= 31 ? configuration.fontWeightAdjustment : 0;
            setFontFamilyResolver(n7.m.l(getContext()));
        }
        this.H.invoke(configuration);
    }

    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (this.f5365k0.get() != null) {
            throw new ClassCastException();
        }
        this.f5361i0.getClass();
        return null;
    }

    @Override // android.view.View
    public final void onCreateVirtualViewTranslationRequests(long[] jArr, int[] iArr, Consumer consumer) {
        p1.n nVar;
        String strA;
        p0.c cVar = this.f5392y;
        cVar.getClass();
        int i2 = 0;
        for (long j2 : jArr) {
            p1.o oVar = (p1.o) cVar.g().b((int) j2);
            if (oVar != null && (nVar = oVar.f8319a) != null) {
                l.q();
                ViewTranslationRequest.Builder builderM = l.m(cVar.f8244f.getAutofillId(), nVar.f8318g);
                Object objG = nVar.f8315d.f8304f.g(p1.s.f8368y);
                if (objG == null) {
                    objG = null;
                }
                List list = (List) objG;
                if (list != null && (strA = f2.a.a(list, "\n", null, 62)) != null) {
                    builderM.setValue("android:text", TranslationRequestValue.forText(new s1.e(strA, i2)));
                    consumer.accept(builderM.build());
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f5378r.onViewDetachedFromWindow(this);
        if (this.f5364k) {
            View view = this.f5362j;
            if (view == null) {
                q7.k.j("frameRateCategoryView");
                throw null;
            }
            removeView(view);
        }
        k.z zVar = L0;
        synchronized (zVar) {
            zVar.i(this);
        }
        i1.m1 snapshotObserver = getSnapshotObserver();
        c.m mVar = snapshotObserver.f4536a.f5806h;
        if (mVar != null) {
            mVar.a();
        }
        l0.t tVar = snapshotObserver.f4536a;
        synchronized (tVar.f5805g) {
            d0.e eVar = tVar.f5804f;
            Object[] objArr = eVar.f2749f;
            int i2 = eVar.f2751h;
            for (int i10 = 0; i10 < i2; i10++) {
                l0.s sVar = (l0.s) objArr[i10];
                sVar.f5791e.a();
                sVar.f5792f.a();
                sVar.f5797k.a();
                sVar.f5798l.clear();
            }
        }
        this.f5372o.getClass();
        q viewTreeOwners = getViewTreeOwners();
        androidx.lifecycle.x xVarA = viewTreeOwners != null ? viewTreeOwners.f5297a.a() : null;
        if (xVarA == null) {
            throw m.x.i("No lifecycle owner exists");
        }
        xVarA.f(this.f5392y);
        xVarA.f(this);
        i5.f fVar = this.I;
        if (fVar != null) {
            o0.f fVar2 = o0.f.f7181a;
            fVar2.getClass();
            ((AutofillManager) fVar.f4655i).unregisterCallback(fVar2);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f5355f0);
        getViewTreeObserver().removeOnScrollChangedListener(this.f5357g0);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.f5359h0);
        if (Build.VERSION.SDK_INT >= 31) {
            i0.f5198a.a(this);
        }
        o0.b bVar = this.J;
        if (bVar != null) {
            getSemanticsOwner().f8324d.i(bVar);
            ((k.z) ((m4.u0) getFocusOwner()).f6347g).i(bVar);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z4, int i2, Rect rect) {
        super.onFocusChanged(z4, i2, rect);
        if (z4 || hasFocus()) {
            return;
        }
        s0.e.e((s0.q) ((m4.u0) getFocusOwner()).f6343c, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i2, int i10, int i11, int i12) {
        this.W = 0L;
        this.R.h(this.D0);
        this.P = null;
        E();
        if (this.O != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, i11 - i2, i12 - i10);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i10) {
        i1.t0 t0Var = this.R;
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                l(getRoot());
            }
            long jH = h(i2);
            long jH2 = h(i10);
            long jT = w7.e0.t((int) (jH >>> 32), (int) (jH & 4294967295L), (int) (jH2 >>> 32), (int) (4294967295L & jH2));
            d2.a aVar = this.P;
            if (aVar == null) {
                this.P = new d2.a(jT);
                this.Q = false;
            } else if (!d2.a.b(aVar.f2778a, jT)) {
                this.Q = true;
            }
            t0Var.n(jT);
            t0Var.i();
            setMeasuredDimension(getRoot().I.f4507o.f3756f, getRoot().I.f4507o.f3757g);
            if (this.O != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().I.f4507o.f3756f, 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().I.f4507o.f3757g, 1073741824));
            }
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onProvideAutofillVirtualStructure(android.view.ViewStructure r12, int r13) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j1.y.onProvideAutofillVirtualStructure(android.view.ViewStructure, int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        int toolType = motionEvent.getToolType(i2);
        if (!motionEvent.isFromSource(8194) && motionEvent.isFromSource(16386) && (toolType == 2 || toolType == 4)) {
            getPointerIconService().getClass();
        }
        return super.onResolvePointerIcon(motionEvent, i2);
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i2) {
        if (this.f5356g) {
            d2.l lVar = i2 != 0 ? i2 != 1 ? null : d2.l.f2794g : d2.l.f2793f;
            if (lVar == null) {
                lVar = d2.l.f2793f;
            }
            setLayoutDirection(lVar);
        }
    }

    @Override // android.view.View
    public final void onScrollCaptureSearch(Rect rect, Point point, Consumer consumer) {
        p1 p1Var;
        if (Build.VERSION.SDK_INT < 31 || (p1Var = this.G0) == null) {
            return;
        }
        p1.p semanticsOwner = getSemanticsOwner();
        g7.l coroutineContext = getCoroutineContext();
        d0.e eVar = new d0.e(new o1.j[16]);
        n7.a.E(semanticsOwner.a(), 0, new o1.i(1, d0.e.class, eVar, "add", "add(Ljava/lang/Object;)Z"));
        d7.n.t0(eVar.f2749f, new f7.a(0, new p7.k[]{o1.b.f7195i, o1.b.f7196j}), 0, eVar.f2751h);
        int i2 = eVar.f2751h;
        o1.j jVar = (o1.j) (i2 == 0 ? null : eVar.f2749f[i2 - 1]);
        if (jVar == null) {
            return;
        }
        d2.j jVar2 = jVar.f7217c;
        o1.d dVar = new o1.d(jVar.f7215a, jVar2, ia.d0.b(coroutineContext), p1Var, this);
        i1.d1 d1Var = jVar.f7218d;
        long j2 = (jVar2.f2788a << 32) | (jVar2.f2789b & 4294967295L);
        ScrollCaptureTarget scrollCaptureTargetI = l.i(this, u0.z.n(ib.c.M(ib.k.w(d1Var).B(d1Var, true))), new Point((int) (j2 >> 32), (int) (j2 & 4294967295L)), dVar);
        scrollCaptureTargetI.setScrollBounds(u0.z.n(jVar2));
        consumer.accept(scrollCaptureTargetI);
    }

    @Override // android.view.View
    public final void onVirtualViewTranslationResponses(LongSparseArray longSparseArray) {
        p0.c cVar = this.f5392y;
        cVar.getClass();
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        if (q7.k.a(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            n7.b.g(cVar, longSparseArray);
        } else {
            cVar.f8244f.post(new c.b(4, cVar, longSparseArray));
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z4) {
        this.f5372o.f5296a.setValue(Boolean.valueOf(z4));
        this.F0 = true;
        super.onWindowFocusChanged(z4);
    }

    public final long p(long j2) {
        x();
        long j4 = u0.z.j(this.U, j2);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (this.f5350b0 >> 32)) + Float.intBitsToFloat((int) (j4 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (this.f5350b0 & 4294967295L)) + Float.intBitsToFloat((int) (j4 & 4294967295L));
        return (Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L);
    }

    public final void q(boolean z4) {
        w wVar;
        i1.t0 t0Var = this.R;
        if (t0Var.f4596b.F() || ((d0.e) t0Var.f4599e.f8788h).f2751h != 0) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (z4) {
                try {
                    wVar = this.D0;
                } finally {
                    Trace.endSection();
                }
            } else {
                wVar = null;
            }
            if (t0Var.h(wVar)) {
                requestLayout();
            }
            t0Var.a(false);
        }
    }

    public final void r(i1.j1 j1Var, boolean z4) {
        ArrayList arrayList = this.C;
        if (!z4) {
            if (this.E) {
                return;
            }
            arrayList.remove(j1Var);
            ArrayList arrayList2 = this.D;
            if (arrayList2 != null) {
                arrayList2.remove(j1Var);
                return;
            }
            return;
        }
        if (!this.E) {
            arrayList.add(j1Var);
            return;
        }
        ArrayList arrayList3 = this.D;
        if (arrayList3 == null) {
            arrayList3 = new ArrayList();
            this.D = arrayList3;
        }
        arrayList3.add(j1Var);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i2, Rect rect) {
        if (isFocused()) {
            return true;
        }
        int i10 = s0.o.$EnumSwitchMapping$0[((s0.q) ((m4.u0) getFocusOwner()).f6343c).n0().ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return super.requestFocus(i2, rect);
        }
        if (i10 != 4) {
            throw new a4.u();
        }
        s0.b bVarA = s0.e.A(i2);
        int i11 = bVarA != null ? bVarA.f9166a : 7;
        return q7.k.a(((m4.u0) getFocusOwner()).j(i11, rect != null ? u0.z.q(rect) : null, new v(i11, 0)), Boolean.TRUE);
    }

    public final void s() {
        if (this.K) {
            l0.t tVar = getSnapshotObserver().f4536a;
            synchronized (tVar.f5805g) {
                try {
                    d0.e eVar = tVar.f5804f;
                    int i2 = eVar.f2751h;
                    int i10 = 0;
                    for (int i11 = 0; i11 < i2; i11++) {
                        l0.s sVar = (l0.s) eVar.f2749f[i11];
                        sVar.d();
                        if (!(sVar.f5792f.f5450e != 0)) {
                            i10++;
                        } else if (i10 > 0) {
                            Object[] objArr = eVar.f2749f;
                            objArr[i11 - i10] = objArr[i11];
                        }
                    }
                    int i12 = i2 - i10;
                    d7.n.d0(eVar.f2749f, i12, i2);
                    eVar.f2751h = i12;
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.K = false;
        }
        w0 w0Var = this.O;
        if (w0Var != null) {
            g(w0Var);
        }
        o0.b bVar = this.J;
        if (bVar != null) {
            k.u uVar = bVar.f7178g;
            if (uVar.f5535d == 0 && bVar.f7179h) {
                ((AutofillManager) bVar.f7172a.f411g).commit();
                bVar.f7179h = false;
            }
            if (uVar.f5535d != 0) {
                bVar.f7179h = true;
            }
        }
        while (this.f5391x0.h() && this.f5391x0.e(0) != null) {
            int i13 = this.f5391x0.f5557b;
            for (int i14 = 0; i14 < i13; i14++) {
                p7.a aVar = (p7.a) this.f5391x0.e(i14);
                k.z zVar = this.f5391x0;
                if (i14 < 0 || i14 >= zVar.f5557b) {
                    zVar.m(i14);
                    throw null;
                }
                Object[] objArr2 = zVar.f5556a;
                Object obj = objArr2[i14];
                objArr2[i14] = null;
                if (aVar != null) {
                    aVar.c();
                }
            }
            this.f5391x0.k(0, i13);
        }
    }

    public void setAccessibilityEventBatchIntervalMillis(long j2) {
        this.f5390x.f5142h = j2;
    }

    public final void setConfigurationChangeObserver(p7.k kVar) {
        this.H = kVar;
    }

    public final void setContentCaptureManager$ui_release(p0.c cVar) {
        this.f5392y = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public void setCoroutineContext(g7.l lVar) {
        this.f5368m = lVar;
        n0.l lVar2 = (n0.l) getRoot().H.f4404j;
        if (lVar2 instanceof c1.x) {
            ((c1.x) lVar2).m0();
        }
        if (!lVar2.f6797f.f6810s) {
            f1.a.b("visitSubtreeIf called on an unattached node");
        }
        d0.e eVar = new d0.e(new n0.l[16]);
        n0.l lVar3 = lVar2.f6797f;
        n0.l lVar4 = lVar3.f6802k;
        if (lVar4 == null) {
            i1.l.b(eVar, lVar3);
        } else {
            eVar.b(lVar4);
        }
        while (true) {
            int i2 = eVar.f2751h;
            if (i2 == 0) {
                return;
            }
            n0.l lVar5 = (n0.l) eVar.j(i2 - 1);
            if ((lVar5.f6800i & 16) != 0) {
                for (n0.l lVar6 = lVar5; lVar6 != null; lVar6 = lVar6.f6802k) {
                    if ((lVar6.f6799h & 16) != 0) {
                        i1.k kVarE = lVar6;
                        ?? eVar2 = 0;
                        while (kVarE != 0) {
                            if (kVarE instanceof i1.p1) {
                                i1.p1 p1Var = (i1.p1) kVarE;
                                if (p1Var instanceof c1.x) {
                                    ((c1.x) p1Var).m0();
                                }
                            } else if ((kVarE.f6799h & 16) != 0 && (kVarE instanceof i1.k)) {
                                n0.l lVar7 = kVarE.f4514u;
                                int i10 = 0;
                                kVarE = kVarE;
                                eVar2 = eVar2;
                                while (lVar7 != null) {
                                    if ((lVar7.f6799h & 16) != 0) {
                                        i10++;
                                        eVar2 = eVar2;
                                        if (i10 == 1) {
                                            kVarE = lVar7;
                                        } else {
                                            if (eVar2 == 0) {
                                                eVar2 = new d0.e(new n0.l[16]);
                                            }
                                            if (kVarE != 0) {
                                                eVar2.b(kVarE);
                                                kVarE = 0;
                                            }
                                            eVar2.b(lVar7);
                                        }
                                    }
                                    lVar7 = lVar7.f6802k;
                                    kVarE = kVarE;
                                    eVar2 = eVar2;
                                }
                                if (i10 == 1) {
                                }
                            }
                            kVarE = i1.l.e(eVar2);
                        }
                    }
                }
            }
            i1.l.b(eVar, lVar5);
        }
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j2) {
        this.W = j2;
    }

    public final void setOnViewTreeOwnersAvailable(p7.k kVar) {
        q viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            kVar.invoke(viewTreeOwners);
        }
        if (isAttachedToWindow()) {
            return;
        }
        this.f5353e0 = kVar;
    }

    public void setShowLayoutBounds(boolean z4) {
    }

    public void setUncaughtExceptionHandler(i1.q1 q1Var) {
        this.R.getClass();
    }

    public final void setUncaughtExceptionHandler$ui_release(i1.q1 q1Var) {
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void t(i1.f0 f0Var) {
        f0 f0Var2 = this.f5390x;
        f0Var2.A = true;
        if (f0Var2.n()) {
            f0Var2.o(f0Var);
        }
        p0.c cVar = this.f5392y;
        cVar.f8250l = true;
        if (cVar.h()) {
            cVar.f8251m.u(c7.r.f1986a);
        }
    }

    public final void u(i1.f0 f0Var, boolean z4, boolean z10) {
        i1.f0 f0VarN;
        i1.f0 f0VarN2;
        i1.t0 t0Var = this.R;
        if (!z4) {
            if (t0Var.m(f0Var, z10)) {
                A(f0Var);
                return;
            }
            return;
        }
        i5.l lVar = t0Var.f4596b;
        i1.f0 f0Var2 = f0Var.f4458l;
        i1.i0 i0Var = f0Var.I;
        if (f0Var2 == null) {
            f1.a.b("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadScope");
        }
        int iOrdinal = i0Var.f4495c.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return;
            }
            if (iOrdinal != 2 && iOrdinal != 3) {
                if (iOrdinal != 4) {
                    throw new a4.u();
                }
                if (!i0Var.f4496d || z10) {
                    i0Var.f4496d = true;
                    i0Var.f4507o.f4620x = true;
                    if (f0Var.P) {
                        return;
                    }
                    if ((q7.k.a(f0Var.D(), Boolean.TRUE) || i1.t0.f(f0Var)) && ((f0VarN = f0Var.n()) == null || !f0VarN.I.f4496d)) {
                        lVar.k(f0Var, i1.s.f4583f);
                    } else if ((f0Var.C() || i1.t0.g(f0Var)) && ((f0VarN2 = f0Var.n()) == null || !f0VarN2.k())) {
                        lVar.k(f0Var, i1.s.f4585h);
                    }
                    if (t0Var.f4598d) {
                        return;
                    }
                    A(f0Var);
                    return;
                }
                return;
            }
        }
        t0Var.f4602h.b(new i1.s0(f0Var, true, z10));
    }

    public final void v(i1.f0 f0Var, boolean z4, boolean z10) {
        i1.i0 i0Var = f0Var.I;
        i1.t0 t0Var = this.R;
        if (!z4) {
            t0Var.getClass();
            int iOrdinal = i0Var.f4495c.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
                return;
            }
            if (iOrdinal != 4) {
                throw new a4.u();
            }
            i1.f0 f0VarN = f0Var.n();
            boolean z11 = f0VarN == null || f0VarN.C();
            if (!z10) {
                if (f0Var.k()) {
                    return;
                }
                if (f0Var.j() && f0Var.C() == z11 && f0Var.C() == i0Var.f4507o.f4619w) {
                    return;
                }
            }
            i1.v0 v0Var = i0Var.f4507o;
            v0Var.f4621y = true;
            v0Var.f4622z = true;
            if (!f0Var.P && v0Var.f4619w && z11) {
                if ((f0VarN == null || !f0VarN.j()) && (f0VarN == null || !f0VarN.k())) {
                    t0Var.f4596b.k(f0Var, i1.s.f4586i);
                }
                if (t0Var.f4598d) {
                    return;
                }
                A(null);
                return;
            }
            return;
        }
        i5.l lVar = t0Var.f4596b;
        int iOrdinal2 = i0Var.f4495c.ordinal();
        if (iOrdinal2 != 0) {
            if (iOrdinal2 == 1) {
                return;
            }
            if (iOrdinal2 != 2) {
                if (iOrdinal2 == 3) {
                    return;
                }
                if (iOrdinal2 != 4) {
                    throw new a4.u();
                }
            }
        }
        if ((i0Var.f4496d || i0Var.f4497e) && !z10) {
            return;
        }
        i0Var.f4497e = true;
        i0Var.f4498f = true;
        i1.v0 v0Var2 = i0Var.f4507o;
        v0Var2.f4621y = true;
        v0Var2.f4622z = true;
        if (f0Var.P) {
            return;
        }
        i1.f0 f0VarN2 = f0Var.n();
        if (q7.k.a(f0Var.D(), Boolean.TRUE) && ((f0VarN2 == null || !f0VarN2.I.f4496d) && (f0VarN2 == null || !f0VarN2.I.f4497e))) {
            lVar.k(f0Var, i1.s.f4584g);
        } else if (f0Var.C() && ((f0VarN2 == null || !f0VarN2.j()) && (f0VarN2 == null || !f0VarN2.k()))) {
            lVar.k(f0Var, i1.s.f4586i);
        }
        if (t0Var.f4598d) {
            return;
        }
        A(null);
    }

    public final void w() {
        f0 f0Var = this.f5390x;
        f0Var.A = true;
        if (f0Var.n() && !f0Var.L) {
            f0Var.L = true;
            f0Var.f5146l.post(f0Var.N);
        }
        p0.c cVar = this.f5392y;
        cVar.f8250l = true;
        if (!cVar.h() || cVar.f8257s) {
            return;
        }
        cVar.f8257s = true;
        cVar.f8252n.post(cVar.f8258t);
    }

    public final void x() {
        if (this.f5349a0) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (jCurrentAnimationTimeMillis != this.W) {
            this.W = jCurrentAnimationTimeMillis;
            a1 a1Var = this.E0;
            float[] fArr = this.U;
            a1Var.a(this, fArr);
            k0.o(fArr, this.V);
            ViewParent parent = getParent();
            View view = this;
            while (parent instanceof ViewGroup) {
                view = (View) parent;
                parent = ((ViewGroup) view).getParent();
            }
            int[] iArr = this.T;
            view.getLocationOnScreen(iArr);
            float f10 = iArr[0];
            float f11 = iArr[1];
            view.getLocationInWindow(iArr);
            float f12 = iArr[0];
            float f13 = f11 - iArr[1];
            this.f5350b0 = (Float.floatToRawIntBits(f10 - f12) << 32) | (Float.floatToRawIntBits(f13) & 4294967295L);
        }
    }

    public final void y(MotionEvent motionEvent) {
        this.W = AnimationUtils.currentAnimationTimeMillis();
        a1 a1Var = this.E0;
        float[] fArr = this.U;
        a1Var.a(this, fArr);
        k0.o(fArr, this.V);
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        long j2 = u0.z.j(fArr, (Float.floatToRawIntBits(x10) << 32) | (Float.floatToRawIntBits(y10) & 4294967295L));
        float rawX = motionEvent.getRawX() - Float.intBitsToFloat((int) (j2 >> 32));
        float rawY = motionEvent.getRawY() - Float.intBitsToFloat((int) (j2 & 4294967295L));
        this.f5350b0 = (Float.floatToRawIntBits(rawX) << 32) | (Float.floatToRawIntBits(rawY) & 4294967295L);
    }

    public final boolean z() {
        if (isFocused() || hasFocus()) {
            return true;
        }
        return super.requestFocus(130, null);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2) {
        q7.k.b(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addViewInLayout(view, i2, layoutParams, true);
    }

    public i getAccessibilityManager() {
        return this.f5394z;
    }

    public j getClipboard() {
        return this.M;
    }

    public k getClipboardManager() {
        return this.L;
    }

    /* renamed from: getDragAndDropManager, reason: merged with bridge method [inline-methods] */
    public q0.a m19getDragAndDropManager() {
        return this.f5370n;
    }

    public k.t getLayoutNodes() {
        return this.f5382t;
    }

    public y getOutOfFrameExecutor() {
        if (isAttachedToWindow()) {
            return this;
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, int i10) {
        ViewGroup.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.width = i2;
        layoutParamsGenerateDefaultLayoutParams.height = i10;
        addViewInLayout(view, -1, layoutParamsGenerateDefaultLayoutParams, true);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        addViewInLayout(view, i2, layoutParams, true);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInLayout(view, -1, layoutParams, true);
    }
}
