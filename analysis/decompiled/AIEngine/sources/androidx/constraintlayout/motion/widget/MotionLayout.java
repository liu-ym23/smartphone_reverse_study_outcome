package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.a;
import androidx.constraintlayout.widget.ConstraintLayout;
import j0.a;
import java.util.ArrayList;
import v0.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MotionLayout extends ConstraintLayout implements p {
    public static final /* synthetic */ int I = 0;
    public i0.b A;
    public boolean B;
    public int C;
    public float D;
    public boolean E;
    public b F;
    public boolean G;
    public TransitionState H;

    /* renamed from: t, reason: collision with root package name */
    public float f1236t;

    /* renamed from: u, reason: collision with root package name */
    public int f1237u;

    /* renamed from: v, reason: collision with root package name */
    public int f1238v;

    /* renamed from: w, reason: collision with root package name */
    public float f1239w;

    /* renamed from: x, reason: collision with root package name */
    public float f1240x;

    /* renamed from: y, reason: collision with root package name */
    public long f1241y;
    public c z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class TransitionState {

        /* renamed from: a, reason: collision with root package name */
        public static final TransitionState f1242a;

        /* renamed from: b, reason: collision with root package name */
        public static final TransitionState f1243b;

        /* renamed from: c, reason: collision with root package name */
        public static final TransitionState f1244c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ TransitionState[] f1245d;

        /* JADX INFO: Fake field, exist only in values array */
        TransitionState EF0;

        static {
            TransitionState transitionState = new TransitionState("UNDEFINED", 0);
            TransitionState transitionState2 = new TransitionState("SETUP", 1);
            f1242a = transitionState2;
            TransitionState transitionState3 = new TransitionState("MOVING", 2);
            f1243b = transitionState3;
            TransitionState transitionState4 = new TransitionState("FINISHED", 3);
            f1244c = transitionState4;
            f1245d = new TransitionState[]{transitionState, transitionState2, transitionState3, transitionState4};
        }

        public TransitionState() {
            throw null;
        }

        public static TransitionState valueOf(String str) {
            return (TransitionState) Enum.valueOf(TransitionState.class, str);
        }

        public static TransitionState[] values() {
            return (TransitionState[]) f1245d.clone();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MotionLayout.this.F.a();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public float f1247a = Float.NaN;

        /* renamed from: b, reason: collision with root package name */
        public float f1248b = Float.NaN;

        /* renamed from: c, reason: collision with root package name */
        public int f1249c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f1250d = -1;

        public b() {
        }

        public final void a() {
            int i10 = this.f1249c;
            MotionLayout motionLayout = MotionLayout.this;
            if (i10 != -1 || this.f1250d != -1) {
                TransitionState transitionState = TransitionState.f1242a;
                if (i10 == -1) {
                    int i11 = this.f1250d;
                    if (motionLayout.isAttachedToWindow()) {
                        int i12 = motionLayout.f1237u;
                        if (i12 != i11 && -1 != i11 && motionLayout.f1238v != i11) {
                            motionLayout.f1238v = i11;
                            if (i12 == -1) {
                                motionLayout.f1239w = 0.0f;
                                motionLayout.f1240x = 0.0f;
                                motionLayout.f1241y = motionLayout.getNanoTime();
                                motionLayout.getNanoTime();
                                throw null;
                            }
                            if (!motionLayout.isAttachedToWindow()) {
                                b bVar = motionLayout.F;
                                bVar.f1249c = i12;
                                bVar.f1250d = i11;
                            }
                            motionLayout.f1240x = 0.0f;
                        }
                    } else {
                        motionLayout.F.f1250d = i11;
                    }
                } else {
                    int i13 = this.f1250d;
                    if (i13 == -1) {
                        motionLayout.setState(transitionState);
                        motionLayout.f1237u = i10;
                        motionLayout.f1238v = -1;
                        j0.a aVar = motionLayout.f1277n;
                        if (aVar != null) {
                            float f8 = -1;
                            ConstraintLayout constraintLayout = aVar.f9624a;
                            SparseArray<a.C0094a> sparseArray = aVar.f9627d;
                            int i14 = aVar.f9625b;
                            int i15 = 0;
                            if (i14 == i10) {
                                a.C0094a c0094aValueAt = i10 == -1 ? sparseArray.valueAt(0) : sparseArray.get(i14);
                                int i16 = aVar.f9626c;
                                if (i16 == -1 || !c0094aValueAt.f9630b.get(i16).a(f8, f8)) {
                                    ArrayList<a.b> arrayList = c0094aValueAt.f9630b;
                                    while (true) {
                                        if (i15 >= arrayList.size()) {
                                            i15 = -1;
                                            break;
                                        } else if (arrayList.get(i15).a(f8, f8)) {
                                            break;
                                        } else {
                                            i15++;
                                        }
                                    }
                                    ArrayList<a.b> arrayList2 = c0094aValueAt.f9630b;
                                    if (aVar.f9626c != i15) {
                                        androidx.constraintlayout.widget.c cVar = i15 == -1 ? null : arrayList2.get(i15).f9638f;
                                        if (i15 != -1) {
                                            int i17 = arrayList2.get(i15).f9637e;
                                        }
                                        if (cVar != null) {
                                            aVar.f9626c = i15;
                                            cVar.a(constraintLayout);
                                            constraintLayout.setConstraintSet(null);
                                            constraintLayout.requestLayout();
                                        }
                                    }
                                }
                            } else {
                                aVar.f9625b = i10;
                                a.C0094a c0094a = sparseArray.get(i10);
                                ArrayList<a.b> arrayList3 = c0094a.f9630b;
                                while (true) {
                                    if (i15 >= arrayList3.size()) {
                                        i15 = -1;
                                        break;
                                    } else if (arrayList3.get(i15).a(f8, f8)) {
                                        break;
                                    } else {
                                        i15++;
                                    }
                                }
                                ArrayList<a.b> arrayList4 = c0094a.f9630b;
                                androidx.constraintlayout.widget.c cVar2 = i15 == -1 ? c0094a.f9632d : arrayList4.get(i15).f9638f;
                                if (i15 != -1) {
                                    int i18 = arrayList4.get(i15).f9637e;
                                }
                                if (cVar2 == null) {
                                    Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i10 + ", dim =-1.0, -1.0");
                                } else {
                                    aVar.f9626c = i15;
                                    cVar2.a(constraintLayout);
                                    constraintLayout.setConstraintSet(null);
                                    constraintLayout.requestLayout();
                                }
                            }
                        }
                    } else if (!motionLayout.isAttachedToWindow()) {
                        b bVar2 = motionLayout.F;
                        bVar2.f1249c = i10;
                        bVar2.f1250d = i13;
                    }
                }
                motionLayout.setState(transitionState);
            }
            if (Float.isNaN(this.f1248b)) {
                if (Float.isNaN(this.f1247a)) {
                    return;
                }
                motionLayout.setProgress(this.f1247a);
                return;
            }
            float f9 = this.f1247a;
            float f10 = this.f1248b;
            if (motionLayout.isAttachedToWindow()) {
                motionLayout.setProgress(f9);
                motionLayout.setState(TransitionState.f1243b);
                motionLayout.f1236t = f10;
            } else {
                b bVar3 = motionLayout.F;
                bVar3.f1247a = f9;
                bVar3.f1248b = f10;
            }
            this.f1247a = Float.NaN;
            this.f1248b = Float.NaN;
            this.f1249c = -1;
            this.f1250d = -1;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface c {
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) throws NumberFormatException {
        boolean z;
        if (this.f1241y == -1) {
            this.f1241y = getNanoTime();
        }
        float f8 = this.f1240x;
        if (f8 > 0.0f && f8 < 1.0f) {
            this.f1237u = -1;
        }
        boolean z3 = false;
        if (this.B) {
            float fSignum = Math.signum(1.0f - f8);
            long nanoTime = getNanoTime();
            float f9 = (((nanoTime - this.f1241y) * fSignum) * 1.0E-9f) / 0.0f;
            float f10 = this.f1240x + f9;
            if ((fSignum > 0.0f && f10 >= 1.0f) || (fSignum <= 0.0f && f10 <= 1.0f)) {
                f10 = 1.0f;
            }
            this.f1240x = f10;
            this.f1239w = f10;
            this.f1241y = nanoTime;
            this.f1236t = f9;
            if (Math.abs(f9) > 1.0E-5f) {
                setState(TransitionState.f1243b);
            }
            if ((fSignum > 0.0f && f10 >= 1.0f) || (fSignum <= 0.0f && f10 <= 1.0f)) {
                f10 = 1.0f;
            }
            TransitionState transitionState = TransitionState.f1244c;
            if (f10 >= 1.0f || f10 <= 0.0f) {
                setState(transitionState);
            }
            int childCount = getChildCount();
            this.B = false;
            getNanoTime();
            if (childCount > 0) {
                getChildAt(0);
                throw null;
            }
            boolean z10 = (fSignum > 0.0f && f10 >= 1.0f) || (fSignum <= 0.0f && f10 <= 1.0f);
            if (!this.B && z10) {
                setState(transitionState);
            }
            boolean z11 = (!z10) | this.B;
            this.B = z11;
            if (f10 >= 1.0d) {
                int i10 = this.f1237u;
                int i11 = this.f1238v;
                if (i10 != i11) {
                    this.f1237u = i11;
                    throw null;
                }
            }
            if (z11) {
                invalidate();
            } else if ((fSignum > 0.0f && f10 == 1.0f) || (fSignum < 0.0f && f10 == 0.0f)) {
                setState(transitionState);
            }
            if (!this.B && ((fSignum <= 0.0f || f10 != 1.0f) && fSignum < 0.0f)) {
                int i12 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
            }
        }
        float f11 = this.f1240x;
        if (f11 < 1.0f) {
            if (f11 <= 0.0f) {
                z = this.f1237u != -1;
                this.f1237u = -1;
            }
            if (z3 && !this.E) {
                super.requestLayout();
            }
            this.f1239w = this.f1240x;
            super.dispatchDraw(canvas);
        }
        int i13 = this.f1237u;
        int i14 = this.f1238v;
        z = i13 != i14;
        this.f1237u = i14;
        z3 = z;
        if (z3) {
            super.requestLayout();
        }
        this.f1239w = this.f1240x;
        super.dispatchDraw(canvas);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public final void e(int i10) {
        this.f1277n = null;
    }

    public int[] getConstraintSetIds() {
        return null;
    }

    public int getCurrentState() {
        return this.f1237u;
    }

    public ArrayList<a.C0004a> getDefinedTransitions() {
        return null;
    }

    public i0.b getDesignTool() {
        if (this.A == null) {
            this.A = new i0.b();
        }
        return this.A;
    }

    public int getEndState() {
        return this.f1238v;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.f1240x;
    }

    public androidx.constraintlayout.motion.widget.a getScene() {
        return null;
    }

    public int getStartState() {
        return -1;
    }

    public float getTargetPosition() {
        return 1.0f;
    }

    public Bundle getTransitionState() {
        b bVar = this.F;
        MotionLayout motionLayout = MotionLayout.this;
        bVar.f1250d = motionLayout.f1238v;
        bVar.f1249c = -1;
        bVar.f1248b = motionLayout.getVelocity();
        bVar.f1247a = motionLayout.getProgress();
        b bVar2 = this.F;
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", bVar2.f1247a);
        bundle.putFloat("motion.velocity", bVar2.f1248b);
        bundle.putInt("motion.StartState", bVar2.f1249c);
        bundle.putInt("motion.EndState", bVar2.f1250d);
        return bundle;
    }

    public long getTransitionTimeMs() {
        return (long) 0.0f;
    }

    public float getVelocity() {
        return this.f1236t;
    }

    @Override // v0.o
    public final void i(View view, View view2, int i10, int i11) {
        getNanoTime();
    }

    @Override // v0.p
    public final void k(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (i10 == 0 && i11 == 0) {
            return;
        }
        iArr[0] = iArr[0] + i12;
        iArr[1] = iArr[1] + i13;
    }

    public final void m() {
        this.z.getClass();
        if (this.D != this.f1239w) {
            if (this.C != -1) {
                throw null;
            }
            this.C = -1;
            this.D = this.f1239w;
            throw null;
        }
    }

    public final void n() {
        this.z.getClass();
        if (this.C != -1) {
            this.z.getClass();
            throw null;
        }
        this.C = this.f1237u;
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            display.getRotation();
        }
        b bVar = this.F;
        if (this.G) {
            post(new a());
        } else {
            bVar.a();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        this.E = true;
        try {
            super.onLayout(z, i10, i11, i12, i13);
        } finally {
            this.E = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f8, float f9, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f8, float f9) {
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof i0.c) {
            throw null;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
    }

    @Override // v0.o
    public final boolean p(View view, View view2, int i10, int i11) {
        return false;
    }

    public void setDebugMode(int i10) {
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z) {
        this.G = z;
    }

    public void setInterpolatedProgress(float f8) {
        setProgress(f8);
    }

    public void setProgress(float f8) {
        if (f8 < 0.0f || f8 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            this.F.f1247a = f8;
            return;
        }
        TransitionState transitionState = TransitionState.f1244c;
        TransitionState transitionState2 = TransitionState.f1243b;
        if (f8 <= 0.0f) {
            if (this.f1240x == 1.0f && this.f1237u == this.f1238v) {
                setState(transitionState2);
            }
            this.f1237u = -1;
            if (this.f1240x == 0.0f) {
                setState(transitionState);
                return;
            }
            return;
        }
        if (f8 < 1.0f) {
            this.f1237u = -1;
            setState(transitionState2);
            return;
        }
        if (this.f1240x == 0.0f && this.f1237u == -1) {
            setState(transitionState2);
        }
        this.f1237u = this.f1238v;
        if (this.f1240x == 1.0f) {
            setState(transitionState);
        }
    }

    public void setScene(androidx.constraintlayout.motion.widget.a aVar) {
        d();
        throw null;
    }

    public void setStartState(int i10) {
        if (isAttachedToWindow()) {
            this.f1237u = i10;
            return;
        }
        if (this.F == null) {
            this.F = new b();
        }
        b bVar = this.F;
        bVar.f1249c = i10;
        bVar.f1250d = i10;
    }

    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.f1244c;
        if (transitionState == transitionState2 && this.f1237u == -1) {
            return;
        }
        TransitionState transitionState3 = this.H;
        this.H = transitionState;
        TransitionState transitionState4 = TransitionState.f1243b;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            m();
        }
        int iOrdinal = transitionState3.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal == 2 && transitionState == transitionState2) {
                n();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            m();
        }
        if (transitionState == transitionState2) {
            n();
        }
    }

    public void setTransition(int i10) {
    }

    public void setTransitionDuration(int i10) {
        Log.e("MotionLayout", "MotionScene not defined");
    }

    public void setTransitionListener(c cVar) {
        this.z = cVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.F == null) {
            this.F = new b();
        }
        b bVar = this.F;
        bVar.getClass();
        bVar.f1247a = bundle.getFloat("motion.progress");
        bVar.f1248b = bundle.getFloat("motion.velocity");
        bVar.f1249c = bundle.getInt("motion.StartState");
        bVar.f1250d = bundle.getInt("motion.EndState");
        if (isAttachedToWindow()) {
            this.F.a();
        }
    }

    @Override // android.view.View
    public final String toString() {
        Context context = getContext();
        return i0.a.a(-1, context) + "->" + i0.a.a(this.f1238v, context) + " (pos:" + this.f1240x + " Dpos/Dt:" + this.f1236t;
    }

    public void setTransition(a.C0004a c0004a) {
        throw null;
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i10) {
    }

    public void setInteractionEnabled(boolean z) {
    }

    public void setOnHide(float f8) {
    }

    public void setOnShow(float f8) {
    }

    @Override // v0.o
    public final void h(int i10, View view) {
    }

    @Override // v0.o
    public final void j(View view, int i10, int i11, int[] iArr, int i12) {
    }

    @Override // v0.o
    public final void l(View view, int i10, int i11, int i12, int i13, int i14) {
    }
}
