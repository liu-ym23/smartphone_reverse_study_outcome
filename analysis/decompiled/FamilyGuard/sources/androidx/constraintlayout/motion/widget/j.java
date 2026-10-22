package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.l;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InterfaceC0477w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class j extends ConstraintLayout implements InterfaceC0477w {

    /* renamed from: x0, reason: collision with root package name */
    public static boolean f8691x0;

    /* renamed from: A, reason: collision with root package name */
    float f8692A;

    /* renamed from: B, reason: collision with root package name */
    private int f8693B;

    /* renamed from: C, reason: collision with root package name */
    int f8694C;

    /* renamed from: D, reason: collision with root package name */
    private int f8695D;

    /* renamed from: E, reason: collision with root package name */
    private boolean f8696E;

    /* renamed from: F, reason: collision with root package name */
    HashMap<View, g> f8697F;

    /* renamed from: G, reason: collision with root package name */
    private long f8698G;

    /* renamed from: H, reason: collision with root package name */
    private float f8699H;

    /* renamed from: I, reason: collision with root package name */
    float f8700I;

    /* renamed from: J, reason: collision with root package name */
    float f8701J;

    /* renamed from: K, reason: collision with root package name */
    private long f8702K;

    /* renamed from: L, reason: collision with root package name */
    float f8703L;

    /* renamed from: M, reason: collision with root package name */
    private boolean f8704M;

    /* renamed from: Q, reason: collision with root package name */
    boolean f8705Q;

    /* renamed from: R, reason: collision with root package name */
    private d f8706R;

    /* renamed from: S, reason: collision with root package name */
    int f8707S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f8708T;

    /* renamed from: U, reason: collision with root package name */
    private androidx.constraintlayout.motion.widget.b f8709U;

    /* renamed from: V, reason: collision with root package name */
    boolean f8710V;

    /* renamed from: W, reason: collision with root package name */
    float f8711W;

    /* renamed from: a0, reason: collision with root package name */
    float f8712a0;

    /* renamed from: b0, reason: collision with root package name */
    long f8713b0;

    /* renamed from: c0, reason: collision with root package name */
    float f8714c0;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f8715d0;

    /* renamed from: e0, reason: collision with root package name */
    private ArrayList<h> f8716e0;

    /* renamed from: f0, reason: collision with root package name */
    private ArrayList<h> f8717f0;

    /* renamed from: g0, reason: collision with root package name */
    private ArrayList<h> f8718g0;

    /* renamed from: h0, reason: collision with root package name */
    private CopyOnWriteArrayList<d> f8719h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f8720i0;

    /* renamed from: j0, reason: collision with root package name */
    private float f8721j0;

    /* renamed from: k0, reason: collision with root package name */
    boolean f8722k0;

    /* renamed from: l0, reason: collision with root package name */
    protected boolean f8723l0;

    /* renamed from: m0, reason: collision with root package name */
    float f8724m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f8725n0;

    /* renamed from: o0, reason: collision with root package name */
    private c f8726o0;

    /* renamed from: p0, reason: collision with root package name */
    private Runnable f8727p0;

    /* renamed from: q0, reason: collision with root package name */
    private int[] f8728q0;

    /* renamed from: r0, reason: collision with root package name */
    int f8729r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f8730s0;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f8731t0;

    /* renamed from: u0, reason: collision with root package name */
    e f8732u0;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f8733v0;

    /* renamed from: w0, reason: collision with root package name */
    ArrayList<Integer> f8734w0;

    /* renamed from: y, reason: collision with root package name */
    Interpolator f8735y;

    /* renamed from: z, reason: collision with root package name */
    Interpolator f8736z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.f8726o0.a();
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8738a;

        static {
            int[] iArr = new int[e.values().length];
            f8738a = iArr;
            try {
                iArr[e.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8738a[e.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8738a[e.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8738a[e.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    class c {

        /* renamed from: a, reason: collision with root package name */
        float f8739a = Float.NaN;

        /* renamed from: b, reason: collision with root package name */
        float f8740b = Float.NaN;

        /* renamed from: c, reason: collision with root package name */
        int f8741c = -1;

        /* renamed from: d, reason: collision with root package name */
        int f8742d = -1;

        /* renamed from: e, reason: collision with root package name */
        final String f8743e = "motion.progress";

        /* renamed from: f, reason: collision with root package name */
        final String f8744f = "motion.velocity";

        /* renamed from: g, reason: collision with root package name */
        final String f8745g = "motion.StartState";

        /* renamed from: h, reason: collision with root package name */
        final String f8746h = "motion.EndState";

        c() {
        }

        void a() {
            int i5 = this.f8741c;
            if (i5 != -1 || this.f8742d != -1) {
                if (i5 == -1) {
                    j.this.O(this.f8742d);
                } else {
                    int i6 = this.f8742d;
                    if (i6 == -1) {
                        j.this.L(i5, -1, -1);
                    } else {
                        j.this.M(i5, i6);
                    }
                }
                j.this.setState(e.SETUP);
            }
            if (Float.isNaN(this.f8740b)) {
                if (Float.isNaN(this.f8739a)) {
                    return;
                }
                j.this.setProgress(this.f8739a);
            } else {
                j.this.K(this.f8739a, this.f8740b);
                this.f8739a = Float.NaN;
                this.f8740b = Float.NaN;
                this.f8741c = -1;
                this.f8742d = -1;
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f8739a);
            bundle.putFloat("motion.velocity", this.f8740b);
            bundle.putInt("motion.StartState", this.f8741c);
            bundle.putInt("motion.EndState", this.f8742d);
            return bundle;
        }

        public void c() {
            this.f8742d = j.this.f8695D;
            this.f8741c = j.this.f8693B;
            this.f8740b = j.this.getVelocity();
            this.f8739a = j.this.getProgress();
        }

        public void d(int i5) {
            this.f8742d = i5;
        }

        public void e(float f5) {
            this.f8739a = f5;
        }

        public void f(int i5) {
            this.f8741c = i5;
        }

        public void g(Bundle bundle) {
            this.f8739a = bundle.getFloat("motion.progress");
            this.f8740b = bundle.getFloat("motion.velocity");
            this.f8741c = bundle.getInt("motion.StartState");
            this.f8742d = bundle.getInt("motion.EndState");
        }

        public void h(float f5) {
            this.f8740b = f5;
        }
    }

    public interface d {
        void a(j jVar, int i5, int i6, float f5);

        void b(j jVar, int i5, int i6);

        void c(j jVar, int i5);
    }

    enum e {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    private void G() {
        CopyOnWriteArrayList<d> copyOnWriteArrayList;
        if ((this.f8706R == null && ((copyOnWriteArrayList = this.f8719h0) == null || copyOnWriteArrayList.isEmpty())) || this.f8721j0 == this.f8700I) {
            return;
        }
        if (this.f8720i0 != -1) {
            d dVar = this.f8706R;
            if (dVar != null) {
                dVar.b(this, this.f8693B, this.f8695D);
            }
            CopyOnWriteArrayList<d> copyOnWriteArrayList2 = this.f8719h0;
            if (copyOnWriteArrayList2 != null) {
                Iterator<d> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().b(this, this.f8693B, this.f8695D);
                }
            }
            this.f8722k0 = true;
        }
        this.f8720i0 = -1;
        float f5 = this.f8700I;
        this.f8721j0 = f5;
        d dVar2 = this.f8706R;
        if (dVar2 != null) {
            dVar2.a(this, this.f8693B, this.f8695D, f5);
        }
        CopyOnWriteArrayList<d> copyOnWriteArrayList3 = this.f8719h0;
        if (copyOnWriteArrayList3 != null) {
            Iterator<d> it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                it2.next().a(this, this.f8693B, this.f8695D, this.f8700I);
            }
        }
        this.f8722k0 = true;
    }

    private void J() {
        CopyOnWriteArrayList<d> copyOnWriteArrayList;
        if (this.f8706R == null && ((copyOnWriteArrayList = this.f8719h0) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        int i5 = 0;
        this.f8722k0 = false;
        ArrayList<Integer> arrayList = this.f8734w0;
        int size = arrayList.size();
        while (i5 < size) {
            Integer num = arrayList.get(i5);
            i5++;
            Integer num2 = num;
            d dVar = this.f8706R;
            if (dVar != null) {
                dVar.c(this, num2.intValue());
            }
            CopyOnWriteArrayList<d> copyOnWriteArrayList2 = this.f8719h0;
            if (copyOnWriteArrayList2 != null) {
                Iterator<d> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().c(this, num2.intValue());
                }
            }
        }
        this.f8734w0.clear();
    }

    void E(float f5) {
    }

    void F(boolean z5) {
        boolean z6;
        int i5;
        float interpolation;
        boolean z7;
        if (this.f8702K == -1) {
            this.f8702K = getNanoTime();
        }
        float f5 = this.f8701J;
        if (f5 > 0.0f && f5 < 1.0f) {
            this.f8694C = -1;
        }
        boolean z8 = false;
        if (this.f8715d0 || (this.f8705Q && (z5 || this.f8703L != f5))) {
            float fSignum = Math.signum(this.f8703L - f5);
            long nanoTime = getNanoTime();
            Interpolator interpolator = this.f8735y;
            float f6 = !(interpolator instanceof i) ? (((nanoTime - this.f8702K) * fSignum) * 1.0E-9f) / this.f8699H : 0.0f;
            float f7 = this.f8701J + f6;
            if (this.f8704M) {
                f7 = this.f8703L;
            }
            if ((fSignum <= 0.0f || f7 < this.f8703L) && (fSignum > 0.0f || f7 > this.f8703L)) {
                z6 = false;
            } else {
                f7 = this.f8703L;
                this.f8705Q = false;
                z6 = true;
            }
            this.f8701J = f7;
            this.f8700I = f7;
            this.f8702K = nanoTime;
            if (interpolator == null || z6) {
                this.f8692A = f6;
            } else {
                if (this.f8708T) {
                    interpolation = interpolator.getInterpolation((nanoTime - this.f8698G) * 1.0E-9f);
                    Interpolator interpolator2 = this.f8735y;
                    if (interpolator2 == null) {
                        throw null;
                    }
                    this.f8701J = interpolation;
                    this.f8702K = nanoTime;
                    if (interpolator2 instanceof i) {
                        float fA = ((i) interpolator2).a();
                        this.f8692A = fA;
                        Math.abs(fA);
                        if (fA > 0.0f && interpolation >= 1.0f) {
                            this.f8701J = 1.0f;
                            this.f8705Q = false;
                            interpolation = 1.0f;
                        }
                        if (fA < 0.0f && interpolation <= 0.0f) {
                            this.f8701J = 0.0f;
                            this.f8705Q = false;
                            f7 = 0.0f;
                        }
                    }
                } else {
                    interpolation = interpolator.getInterpolation(f7);
                    Interpolator interpolator3 = this.f8735y;
                    if (interpolator3 instanceof i) {
                        this.f8692A = ((i) interpolator3).a();
                    } else {
                        this.f8692A = ((interpolator3.getInterpolation(f7 + f6) - interpolation) * fSignum) / f6;
                    }
                }
                f7 = interpolation;
            }
            if (Math.abs(this.f8692A) > 1.0E-5f) {
                setState(e.MOVING);
            }
            if ((fSignum > 0.0f && f7 >= this.f8703L) || (fSignum <= 0.0f && f7 <= this.f8703L)) {
                f7 = this.f8703L;
                this.f8705Q = false;
            }
            if (f7 >= 1.0f || f7 <= 0.0f) {
                this.f8705Q = false;
                setState(e.FINISHED);
            }
            int childCount = getChildCount();
            this.f8715d0 = false;
            long nanoTime2 = getNanoTime();
            this.f8724m0 = f7;
            Interpolator interpolator4 = this.f8736z;
            float interpolation2 = interpolator4 == null ? f7 : interpolator4.getInterpolation(f7);
            Interpolator interpolator5 = this.f8736z;
            if (interpolator5 != null) {
                float interpolation3 = interpolator5.getInterpolation((fSignum / this.f8699H) + f7);
                this.f8692A = interpolation3;
                this.f8692A = interpolation3 - this.f8736z.getInterpolation(f7);
            }
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                g gVar = this.f8697F.get(childAt);
                if (gVar != null) {
                    this.f8715d0 = gVar.c(childAt, interpolation2, nanoTime2, null) | this.f8715d0;
                }
            }
            boolean z9 = (fSignum > 0.0f && f7 >= this.f8703L) || (fSignum <= 0.0f && f7 <= this.f8703L);
            if (!this.f8715d0 && !this.f8705Q && z9) {
                setState(e.FINISHED);
            }
            if (this.f8723l0) {
                requestLayout();
            }
            boolean z10 = (!z9) | this.f8715d0;
            this.f8715d0 = z10;
            if (f7 <= 0.0f && (i5 = this.f8693B) != -1 && this.f8694C != i5) {
                this.f8694C = i5;
                throw null;
            }
            if (f7 >= 1.0d) {
                int i7 = this.f8694C;
                int i8 = this.f8695D;
                if (i7 != i8) {
                    this.f8694C = i8;
                    throw null;
                }
            }
            if (z10 || this.f8705Q) {
                invalidate();
            } else if ((fSignum > 0.0f && f7 == 1.0f) || (fSignum < 0.0f && f7 == 0.0f)) {
                setState(e.FINISHED);
            }
            if (!this.f8715d0 && !this.f8705Q && ((fSignum > 0.0f && f7 == 1.0f) || (fSignum < 0.0f && f7 == 0.0f))) {
                I();
            }
        }
        float f8 = this.f8701J;
        if (f8 < 1.0f) {
            if (f8 <= 0.0f) {
                int i9 = this.f8694C;
                int i10 = this.f8693B;
                z7 = i9 != i10;
                this.f8694C = i10;
            }
            this.f8733v0 |= z8;
            if (z8 && !this.f8725n0) {
                requestLayout();
            }
            this.f8700I = this.f8701J;
        }
        int i11 = this.f8694C;
        int i12 = this.f8695D;
        z7 = i11 != i12;
        this.f8694C = i12;
        z8 = z7;
        this.f8733v0 |= z8;
        if (z8) {
            requestLayout();
        }
        this.f8700I = this.f8701J;
    }

    protected void H() {
        int iIntValue;
        CopyOnWriteArrayList<d> copyOnWriteArrayList;
        if ((this.f8706R != null || ((copyOnWriteArrayList = this.f8719h0) != null && !copyOnWriteArrayList.isEmpty())) && this.f8720i0 == -1) {
            this.f8720i0 = this.f8694C;
            if (this.f8734w0.isEmpty()) {
                iIntValue = -1;
            } else {
                ArrayList<Integer> arrayList = this.f8734w0;
                iIntValue = arrayList.get(arrayList.size() - 1).intValue();
            }
            int i5 = this.f8694C;
            if (iIntValue != i5 && i5 != -1) {
                this.f8734w0.add(Integer.valueOf(i5));
            }
        }
        J();
        Runnable runnable = this.f8727p0;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.f8728q0;
        if (iArr == null || this.f8729r0 <= 0) {
            return;
        }
        O(iArr[0]);
        int[] iArr2 = this.f8728q0;
        System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
        this.f8729r0--;
    }

    void I() {
    }

    public void K(float f5, float f6) {
        if (!isAttachedToWindow()) {
            if (this.f8726o0 == null) {
                this.f8726o0 = new c();
            }
            this.f8726o0.e(f5);
            this.f8726o0.h(f6);
            return;
        }
        setProgress(f5);
        setState(e.MOVING);
        this.f8692A = f6;
        if (f6 != 0.0f) {
            E(f6 > 0.0f ? 1.0f : 0.0f);
        } else {
            if (f5 == 0.0f || f5 == 1.0f) {
                return;
            }
            E(f5 > 0.5f ? 1.0f : 0.0f);
        }
    }

    public void L(int i5, int i6, int i7) {
        setState(e.SETUP);
        this.f8694C = i5;
        this.f8693B = -1;
        this.f8695D = -1;
        androidx.constraintlayout.widget.c cVar = this.f8786k;
        if (cVar != null) {
            cVar.d(i5, i6, i7);
        }
    }

    public void M(int i5, int i6) {
        if (isAttachedToWindow()) {
            return;
        }
        if (this.f8726o0 == null) {
            this.f8726o0 = new c();
        }
        this.f8726o0.f(i5);
        this.f8726o0.d(i6);
    }

    public void N() {
        E(1.0f);
        this.f8727p0 = null;
    }

    public void O(int i5) {
        if (isAttachedToWindow()) {
            P(i5, -1, -1);
            return;
        }
        if (this.f8726o0 == null) {
            this.f8726o0 = new c();
        }
        this.f8726o0.d(i5);
    }

    public void P(int i5, int i6, int i7) {
        Q(i5, i6, i7, -1);
    }

    public void Q(int i5, int i6, int i7, int i8) {
        int i9 = this.f8694C;
        if (i9 == i5) {
            return;
        }
        if (this.f8693B == i5) {
            E(0.0f);
            if (i8 > 0) {
                this.f8699H = i8 / 1000.0f;
                return;
            }
            return;
        }
        if (this.f8695D == i5) {
            E(1.0f);
            if (i8 > 0) {
                this.f8699H = i8 / 1000.0f;
                return;
            }
            return;
        }
        this.f8695D = i5;
        if (i9 != -1) {
            M(i9, i5);
            E(1.0f);
            this.f8701J = 0.0f;
            N();
            if (i8 > 0) {
                this.f8699H = i8 / 1000.0f;
                return;
            }
            return;
        }
        this.f8708T = false;
        this.f8703L = 1.0f;
        this.f8700I = 0.0f;
        this.f8701J = 0.0f;
        this.f8702K = getNanoTime();
        this.f8698G = getNanoTime();
        this.f8704M = false;
        this.f8735y = null;
        if (i8 == -1) {
            throw null;
        }
        this.f8693B = -1;
        throw null;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) throws NumberFormatException {
        ArrayList<h> arrayList = this.f8718g0;
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                h hVar = arrayList.get(i5);
                i5++;
                hVar.w(canvas);
            }
        }
        F(false);
        super.dispatchDraw(canvas);
    }

    public int[] getConstraintSetIds() {
        return null;
    }

    public int getCurrentState() {
        return this.f8694C;
    }

    public ArrayList<l.a> getDefinedTransitions() {
        return null;
    }

    public androidx.constraintlayout.motion.widget.b getDesignTool() {
        if (this.f8709U == null) {
            this.f8709U = new androidx.constraintlayout.motion.widget.b(this);
        }
        return this.f8709U;
    }

    public int getEndState() {
        return this.f8695D;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.f8701J;
    }

    public l getScene() {
        return null;
    }

    public int getStartState() {
        return this.f8693B;
    }

    public float getTargetPosition() {
        return this.f8703L;
    }

    public Bundle getTransitionState() {
        if (this.f8726o0 == null) {
            this.f8726o0 = new c();
        }
        this.f8726o0.c();
        return this.f8726o0.b();
    }

    public long getTransitionTimeMs() {
        return (long) (this.f8699H * 1000.0f);
    }

    public float getVelocity() {
        return this.f8692A;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    @Override // androidx.core.view.InterfaceC0477w
    public void j(View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        if (this.f8710V || i5 != 0 || i6 != 0) {
            iArr[0] = iArr[0] + i7;
            iArr[1] = iArr[1] + i8;
        }
        this.f8710V = false;
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void k(View view, int i5, int i6, int i7, int i8, int i9) {
    }

    @Override // androidx.core.view.InterfaceC0476v
    public boolean l(View view, View view2, int i5, int i6) {
        return false;
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void m(View view, View view2, int i5, int i6) {
        this.f8713b0 = getNanoTime();
        this.f8714c0 = 0.0f;
        this.f8711W = 0.0f;
        this.f8712a0 = 0.0f;
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void n(View view, int i5) {
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void o(View view, int i5, int i6, int[] iArr, int i7) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.f8730s0 = display.getRotation();
        }
        I();
        c cVar = this.f8726o0;
        if (cVar != null) {
            if (this.f8731t0) {
                post(new a());
            } else {
                cVar.a();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        this.f8725n0 = true;
        try {
            super.onLayout(z5, i5, i6, i7, i8);
        } finally {
            this.f8725n0 = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f5, float f6, boolean z5) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f5, float f6) {
        return false;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i5) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof h) {
            h hVar = (h) view;
            if (this.f8719h0 == null) {
                this.f8719h0 = new CopyOnWriteArrayList<>();
            }
            this.f8719h0.add(hVar);
            if (hVar.v()) {
                if (this.f8716e0 == null) {
                    this.f8716e0 = new ArrayList<>();
                }
                this.f8716e0.add(hVar);
            }
            if (hVar.u()) {
                if (this.f8717f0 == null) {
                    this.f8717f0 = new ArrayList<>();
                }
                this.f8717f0.add(hVar);
            }
            if (hVar.t()) {
                if (this.f8718g0 == null) {
                    this.f8718g0 = new ArrayList<>();
                }
                this.f8718g0.add(hVar);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<h> arrayList = this.f8716e0;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<h> arrayList2 = this.f8717f0;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
    }

    public void setDebugMode(int i5) {
        this.f8707S = i5;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z5) {
        this.f8731t0 = z5;
    }

    public void setInteractionEnabled(boolean z5) {
        this.f8696E = z5;
    }

    public void setInterpolatedProgress(float f5) {
        setProgress(f5);
    }

    public void setOnHide(float f5) {
        ArrayList<h> arrayList = this.f8717f0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.f8717f0.get(i5).setProgress(f5);
            }
        }
    }

    public void setOnShow(float f5) {
        ArrayList<h> arrayList = this.f8716e0;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.f8716e0.get(i5).setProgress(f5);
            }
        }
    }

    public void setProgress(float f5) {
        if (f5 < 0.0f || f5 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.f8726o0 == null) {
                this.f8726o0 = new c();
            }
            this.f8726o0.e(f5);
            return;
        }
        if (f5 <= 0.0f) {
            if (this.f8701J == 1.0f && this.f8694C == this.f8695D) {
                setState(e.MOVING);
            }
            this.f8694C = this.f8693B;
            if (this.f8701J == 0.0f) {
                setState(e.FINISHED);
                return;
            }
            return;
        }
        if (f5 < 1.0f) {
            this.f8694C = -1;
            setState(e.MOVING);
            return;
        }
        if (this.f8701J == 0.0f && this.f8694C == this.f8693B) {
            setState(e.MOVING);
        }
        this.f8694C = this.f8695D;
        if (this.f8701J == 1.0f) {
            setState(e.FINISHED);
        }
    }

    public void setScene(l lVar) {
        r();
        throw null;
    }

    void setStartState(int i5) {
        if (isAttachedToWindow()) {
            this.f8694C = i5;
            return;
        }
        if (this.f8726o0 == null) {
            this.f8726o0 = new c();
        }
        this.f8726o0.f(i5);
        this.f8726o0.d(i5);
    }

    void setState(e eVar) {
        e eVar2 = e.FINISHED;
        if (eVar == eVar2 && this.f8694C == -1) {
            return;
        }
        e eVar3 = this.f8732u0;
        this.f8732u0 = eVar;
        e eVar4 = e.MOVING;
        if (eVar3 == eVar4 && eVar == eVar4) {
            G();
        }
        int i5 = b.f8738a[eVar3.ordinal()];
        if (i5 != 1 && i5 != 2) {
            if (i5 == 3 && eVar == eVar2) {
                H();
                return;
            }
            return;
        }
        if (eVar == eVar4) {
            G();
        }
        if (eVar == eVar2) {
            H();
        }
    }

    public void setTransition(int i5) {
    }

    public void setTransitionDuration(int i5) {
        Log.e("MotionLayout", "MotionScene not defined");
    }

    public void setTransitionListener(d dVar) {
        this.f8706R = dVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f8726o0 == null) {
            this.f8726o0 = new c();
        }
        this.f8726o0.g(bundle);
        if (isAttachedToWindow()) {
            this.f8726o0.a();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void t(int i5) {
        this.f8786k = null;
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return androidx.constraintlayout.motion.widget.a.a(context, this.f8693B) + "->" + androidx.constraintlayout.motion.widget.a.a(context, this.f8695D) + " (pos:" + this.f8701J + " Dpos/Dt:" + this.f8692A;
    }

    protected void setTransition(l.a aVar) {
        throw null;
    }
}
