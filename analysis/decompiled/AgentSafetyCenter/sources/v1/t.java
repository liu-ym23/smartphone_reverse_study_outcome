package v1;

import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
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
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.translation.TranslationRequestValue;
import android.view.translation.ViewTranslationRequest;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t extends ViewGroup implements u1.n1, u1.u1, androidx.lifecycle.f, u1.l1 {
    public static Class J0;
    public static Method K0;
    public static final p.a0 L0 = new p.a0();
    public static e3.j M0;
    public x0.h A;
    public androidx.fragment.app.r A0;
    public ArrayList B;
    public a4.t B0;
    public ArrayList C;
    public boolean C0;
    public boolean D;
    public s D0;
    public boolean E;
    public u0 E0;
    public o1.g F;
    public boolean F0;
    public ed.e G;
    public k1 G0;
    public xb.l H;
    public View H0;
    public p5.i I;
    public q I0;
    public x0.b J;
    public boolean K;
    public i L;
    public h M;
    public u1.p1 N;
    public q0 O;
    public o2.a P;
    public boolean Q;
    public u1.v0 R;
    public long S;
    public int[] T;
    public float[] U;
    public float[] V;
    public long W;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f14534a0;

    /* renamed from: b0, reason: collision with root package name */
    public long f14535b0;

    /* renamed from: c, reason: collision with root package name */
    public long f14536c;

    /* renamed from: c0, reason: collision with root package name */
    public k0.k1 f14537c0;

    /* renamed from: d0, reason: collision with root package name */
    public k0.i0 f14538d0;
    public xb.l e0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14539f;
    public j f0;

    /* renamed from: g, reason: collision with root package name */
    public u1.i0 f14540g;

    /* renamed from: g0, reason: collision with root package name */
    public k f14541g0;

    /* renamed from: h, reason: collision with root package name */
    public k0.k1 f14542h;

    /* renamed from: h0, reason: collision with root package name */
    public l f14543h0;
    public View i;

    /* renamed from: i0, reason: collision with root package name */
    public n6.a f14544i0;

    /* renamed from: j, reason: collision with root package name */
    public boolean f14545j;

    /* renamed from: j0, reason: collision with root package name */
    public h2.d f14546j0;

    /* renamed from: k, reason: collision with root package name */
    public b1.i f14547k;

    /* renamed from: k0, reason: collision with root package name */
    public AtomicReference f14548k0;

    /* renamed from: l, reason: collision with root package name */
    public nb.g f14549l;

    /* renamed from: l0, reason: collision with root package name */
    public i1 f14550l0;

    /* renamed from: m, reason: collision with root package name */
    public z0.a f14551m;

    /* renamed from: m0, reason: collision with root package name */
    public i1 f14552m0;

    /* renamed from: n, reason: collision with root package name */
    public k1 f14553n;

    /* renamed from: n0, reason: collision with root package name */
    public k0.k1 f14554n0;

    /* renamed from: o, reason: collision with root package name */
    public a1.g f14555o;

    /* renamed from: o0, reason: collision with root package name */
    public int f14556o0;

    /* renamed from: p, reason: collision with root package name */
    public p0 f14557p;

    /* renamed from: p0, reason: collision with root package name */
    public k0.k1 f14558p0;

    /* renamed from: q, reason: collision with root package name */
    public s1.p f14559q;

    /* renamed from: q0, reason: collision with root package name */
    public k1.b f14560q0;

    /* renamed from: r, reason: collision with root package name */
    public u1.g0 f14561r;

    /* renamed from: r0, reason: collision with root package name */
    public l1.c f14562r0;

    /* renamed from: s, reason: collision with root package name */
    public p.u f14563s;

    /* renamed from: s0, reason: collision with root package name */
    public t1.d f14564s0;

    /* renamed from: t, reason: collision with root package name */
    public b2.b f14565t;

    /* renamed from: t0, reason: collision with root package name */
    public i1 f14566t0;

    /* renamed from: u, reason: collision with root package name */
    public t f14567u;

    /* renamed from: u0, reason: collision with root package name */
    public MotionEvent f14568u0;

    /* renamed from: v, reason: collision with root package name */
    public a2.r f14569v;

    /* renamed from: v0, reason: collision with root package name */
    public long f14570v0;

    /* renamed from: w, reason: collision with root package name */
    public a0 f14571w;

    /* renamed from: w0, reason: collision with root package name */
    public p5.l f14572w0;

    /* renamed from: x, reason: collision with root package name */
    public y0.d f14573x;

    /* renamed from: x0, reason: collision with root package name */
    public p.a0 f14574x0;

    /* renamed from: y, reason: collision with root package name */
    public g f14575y;

    /* renamed from: y0, reason: collision with root package name */
    public float f14576y0;

    /* renamed from: z, reason: collision with root package name */
    public d1.d f14577z;

    /* renamed from: z0, reason: collision with root package name */
    public float f14578z0;

    public static final void a(t tVar, int i, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        int iD;
        a0 a0Var = tVar.f14571w;
        if (yb.k.a(str, a0Var.D)) {
            int iD2 = a0Var.B.d(i);
            if (iD2 != -1) {
                accessibilityNodeInfo.getExtras().putInt(str, iD2);
                return;
            }
            return;
        }
        if (!yb.k.a(str, a0Var.E) || (iD = a0Var.C.d(i)) == -1) {
            return;
        }
        accessibilityNodeInfo.getExtras().putInt(str, iD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final m get_viewTreeOwners() {
        return (m) this.f14537c0.getValue();
    }

    public static void h(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof t) {
                ((t) childAt).v();
            } else if (childAt instanceof ViewGroup) {
                h((ViewGroup) childAt);
            }
        }
    }

    public static long j(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            return (0 << 32) | size;
        }
        if (mode == 0) {
            return (0 << 32) | Reader.READ_DONE;
        }
        if (mode != 1073741824) {
            throw new IllegalStateException();
        }
        long j10 = size;
        return j10 | (j10 << 32);
    }

    public static void m(u1.g0 g0Var) {
        g0Var.B();
        m0.e eVarX = g0Var.x();
        Object[] objArr = eVarX.f8158c;
        int i = eVarX.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            m((u1.g0) objArr[i3]);
        }
    }

    public static boolean p(MotionEvent motionEvent) {
        boolean z10 = (Float.floatToRawIntBits(motionEvent.getX()) & Reader.READ_DONE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getY()) & Reader.READ_DONE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getRawX()) & Reader.READ_DONE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getRawY()) & Reader.READ_DONE) >= 2139095040;
        if (!z10) {
            int pointerCount = motionEvent.getPointerCount();
            for (int i = 1; i < pointerCount; i++) {
                z10 = (Float.floatToRawIntBits(motionEvent.getX(i)) & Reader.READ_DONE) >= 2139095040 || (Float.floatToRawIntBits(motionEvent.getY(i)) & Reader.READ_DONE) >= 2139095040 || !m1.f14503a.a(motionEvent, i);
                if (z10) {
                    break;
                }
            }
        }
        return z10;
    }

    private void setDensity(o2.c cVar) {
        this.f14542h.setValue(cVar);
    }

    private void setFontFamilyResolver(g2.d dVar) {
        this.f14554n0.setValue(dVar);
    }

    private void setLayoutDirection(o2.l lVar) {
        this.f14558p0.setValue(lVar);
    }

    private final void set_viewTreeOwners(m mVar) {
        this.f14537c0.setValue(mVar);
    }

    public final void A() {
        int[] iArr = this.T;
        if (this.f14534a0) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (jCurrentAnimationTimeMillis != this.W) {
            this.W = jCurrentAnimationTimeMillis;
            u0 u0Var = this.E0;
            float[] fArr = this.U;
            u0Var.a(this, fArr);
            g0.s(fArr, this.V);
            ViewParent parent = getParent();
            View view = this;
            while (parent instanceof ViewGroup) {
                view = (View) parent;
                parent = ((ViewGroup) view).getParent();
            }
            view.getLocationOnScreen(iArr);
            float f5 = iArr[0];
            float f10 = iArr[1];
            view.getLocationInWindow(iArr);
            float f11 = iArr[0];
            float f12 = f10 - iArr[1];
            this.f14535b0 = (Float.floatToRawIntBits(f5 - f11) << 32) | (Float.floatToRawIntBits(f12) & 4294967295L);
        }
    }

    public final void B(MotionEvent motionEvent) {
        this.W = AnimationUtils.currentAnimationTimeMillis();
        u0 u0Var = this.E0;
        float[] fArr = this.U;
        u0Var.a(this, fArr);
        g0.s(fArr, this.V);
        float x6 = motionEvent.getX();
        float y10 = motionEvent.getY();
        long jL = d1.f0.l(fArr, (Float.floatToRawIntBits(x6) << 32) | (Float.floatToRawIntBits(y10) & 4294967295L));
        float rawX = motionEvent.getRawX() - Float.intBitsToFloat((int) (jL >> 32));
        float rawY = motionEvent.getRawY() - Float.intBitsToFloat((int) (jL & 4294967295L));
        this.f14535b0 = (Float.floatToRawIntBits(rawX) << 32) | (Float.floatToRawIntBits(rawY) & 4294967295L);
    }

    public final boolean C() {
        if (isFocused() || hasFocus()) {
            return true;
        }
        return super.requestFocus(130, null);
    }

    public final void D(u1.g0 g0Var) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (g0Var != null) {
            while (g0Var != null && g0Var.r() == u1.e0.f13765c) {
                if (!this.Q) {
                    u1.g0 g0VarT = g0Var.t();
                    if (g0VarT == null) {
                        break;
                    }
                    long j10 = g0VarT.H.f13743c.f11280h;
                    if (o2.a.g(j10) && o2.a.f(j10)) {
                        break;
                    }
                }
                g0Var = g0Var.t();
            }
            if (g0Var == getRoot()) {
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

    public final long E(long j10) {
        A();
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j10 >> 32)) - Float.intBitsToFloat((int) (this.f14535b0 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j10 & 4294967295L)) - Float.intBitsToFloat((int) (this.f14535b0 & 4294967295L));
        return d1.f0.l(this.V, (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    public final int F(MotionEvent motionEvent) {
        Object obj;
        ed.e eVar = this.G;
        o1.g gVar = this.F;
        if (this.F0) {
            this.F0 = false;
            k1 k1Var = this.f14553n;
            int metaState = motionEvent.getMetaState();
            k1Var.getClass();
            k0.k1 k1Var2 = x1.f14592a;
            o1.b0 b0Var = new o1.b0();
            b0Var.f9003a = metaState;
            VarHandle.storeStoreFence();
            k1Var2.setValue(b0Var);
        }
        n6.a aVarA = gVar.a(motionEvent, this);
        if (aVarA == null) {
            if (!eVar.f3783a) {
                ((p.n) ((a2.i) eVar.f3786d).f49f).a();
                ((o1.d) eVar.f3785c).c();
            }
            return 0;
        }
        ArrayList arrayList = (ArrayList) aVarA.f8776c;
        int size = arrayList.size() - 1;
        if (size >= 0) {
            while (true) {
                int i = size - 1;
                obj = arrayList.get(size);
                if (((o1.u) obj).f9092e) {
                    break;
                }
                if (i < 0) {
                    break;
                }
                size = i;
            }
            obj = null;
        } else {
            obj = null;
        }
        o1.u uVar = (o1.u) obj;
        if (uVar != null) {
            this.f14536c = uVar.f9091d;
        }
        int iE = eVar.e(aVarA, this, q(motionEvent));
        aVarA.f8777f = null;
        int actionMasked = motionEvent.getActionMasked();
        if ((actionMasked != 0 && actionMasked != 5) || (iE & 1) != 0) {
            return iE;
        }
        int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
        gVar.f9027c.delete(pointerId);
        gVar.f9026b.delete(pointerId);
        return iE;
    }

    public final void G(MotionEvent motionEvent, int i, long j10, boolean z10) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                actionIndex = motionEvent.getActionIndex();
            }
        } else if (i != 9 && i != 10) {
            actionIndex = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (actionIndex >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i3 = 0; i3 < pointerCount; i3++) {
            pointerPropertiesArr[i3] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i10 = 0; i10 < pointerCount; i10++) {
            pointerCoordsArr[i10] = new MotionEvent.PointerCoords();
        }
        int i11 = 0;
        while (i11 < pointerCount) {
            int i12 = ((actionIndex < 0 || i11 < actionIndex) ? 0 : 1) + i11;
            motionEvent.getPointerProperties(i12, pointerPropertiesArr[i11]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i11];
            motionEvent.getPointerCoords(i12, pointerCoords);
            float f5 = pointerCoords.x;
            long jS = s((Float.floatToRawIntBits(pointerCoords.y) & 4294967295L) | (Float.floatToRawIntBits(f5) << 32));
            pointerCoords.x = Float.intBitsToFloat((int) (jS >> 32));
            pointerCoords.y = Float.intBitsToFloat((int) (jS & 4294967295L));
            i11++;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? j10 : motionEvent.getDownTime(), j10, i, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), z10 ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        n6.a aVarA = this.F.a(motionEventObtain, this);
        aVarA.getClass();
        this.G.e(aVarA, this, true);
        motionEventObtain.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H() {
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
            u1.g0 r1 = r0.getRoot()
            u1.k0 r1 = r1.I
            u1.x0 r1 = r1.f13857p
            r1.d0()
            r1 = r9
            goto L45
        L44:
            r1 = r3
        L45:
            r0.A()
            android.view.View r2 = r0.H0
            if (r2 != 0) goto L52
            android.view.View r2 = r0.getRootView()
            r0.H0 = r2
        L52:
            b2.b r5 = r0.getRectManager()
            long r10 = r0.S
            long r12 = r0.f14535b0
            long r12 = td.h.H(r12)
            float[] r8 = r0.U
            int r14 = r2.getWidth()
            int r2 = r2.getHeight()
            r5.getClass()
            int r15 = h5.t.g(r8)
            b2.c r3 = r5.f1864b
            r15 = r15 & 2
            if (r15 != 0) goto L78
        L75:
            r16 = r6
            goto L7a
        L78:
            r8 = 0
            goto L75
        L7a:
            long r6 = r3.f1873b
            boolean r6 = o2.i.b(r12, r6)
            if (r6 != 0) goto L86
            r3.f1873b = r12
            r6 = r9
            goto L87
        L86:
            r6 = 0
        L87:
            long r12 = r3.f1874c
            boolean r7 = o2.i.b(r10, r12)
            if (r7 != 0) goto L92
            r3.f1874c = r10
            r6 = r9
        L92:
            if (r8 == 0) goto L95
            r6 = r9
        L95:
            long r7 = (long) r14
            long r7 = r7 << r4
            long r10 = (long) r2
            long r10 = r10 & r16
            long r7 = r7 | r10
            long r10 = r3.f1875d
            int r2 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r2 == 0) goto La4
            r3.f1875d = r7
            r6 = r9
        La4:
            if (r6 != 0) goto Lad
            boolean r2 = r5.f1867e
            if (r2 == 0) goto Lab
            goto Lad
        Lab:
            r3 = 0
            goto Lae
        Lad:
            r3 = r9
        Lae:
            r5.f1867e = r3
            u1.v0 r2 = r0.R
            r2.a(r1)
            b2.b r0 = r0.getRectManager()
            r0.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.t.H():void");
    }

    public final void I(float f5) {
        if (this.f14545j) {
            if (f5 > 0.0f) {
                if (Float.isNaN(this.f14576y0) || f5 > this.f14576y0) {
                    this.f14576y0 = f5;
                    return;
                }
                return;
            }
            if (f5 < 0.0f) {
                if (Float.isNaN(this.f14578z0) || f5 < this.f14578z0) {
                    this.f14578z0 = f5;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i) {
        view.getClass();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = generateDefaultLayoutParams();
        }
        addViewInLayout(view, i, layoutParams, true);
    }

    @Override // android.view.View
    public final void autofill(SparseArray sparseArray) {
        a2.k kVarV;
        xb.l lVar;
        x0.b bVar = this.J;
        int i = 0;
        if (bVar != null) {
            int size = sparseArray.size();
            for (int i3 = 0; i3 < size; i3++) {
                int iKeyAt = sparseArray.keyAt(i3);
                AutofillValue autofillValue = (AutofillValue) sparseArray.get(iKeyAt);
                if (autofillValue.isText()) {
                    u1.g0 g0Var = (u1.g0) bVar.f15506b.f96c.b(iKeyAt);
                    if (g0Var != null && (kVarV = g0Var.v()) != null) {
                        Object objG = kVarV.f75c.g(a2.j.f56g);
                        if (objG == null) {
                            objG = null;
                        }
                        a2.a aVar = (a2.a) objG;
                        if (aVar != null && (lVar = (xb.l) aVar.f30b) != null) {
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
        p5.i iVar = this.I;
        if (iVar != null) {
            x0.h hVar = (x0.h) iVar.f9731f;
            if (hVar.f15516a.isEmpty()) {
                return;
            }
            int size2 = sparseArray.size();
            while (i < size2) {
                int iKeyAt2 = sparseArray.keyAt(i);
                AutofillValue autofillValue2 = (AutofillValue) sparseArray.get(iKeyAt2);
                if (autofillValue2.isText()) {
                    autofillValue2.getTextValue().toString();
                    if (hVar.f15516a.get(Integer.valueOf(iKeyAt2)) != null) {
                        od.f.j();
                        return;
                    }
                } else {
                    if (autofillValue2.isDate()) {
                        throw new jb.f("An operation is not implemented: b/138604541: Add onFill() callback for date");
                    }
                    if (autofillValue2.isList()) {
                        throw new jb.f("An operation is not implemented: b/138604541: Add onFill() callback for list");
                    }
                    if (autofillValue2.isToggle()) {
                        throw new jb.f("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
                    }
                }
                i++;
            }
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        return this.f14571w.d(i, false, this.f14536c);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i) {
        return this.f14571w.d(i, true, this.f14536c);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        View view = this.i;
        ArrayList arrayList = this.B;
        if (!isAttachedToWindow()) {
            m(getRoot());
        }
        t(true);
        u0.m.k().m();
        this.D = true;
        a1.g gVar = this.f14555o;
        d1.a aVar = (d1.a) gVar.f19f;
        Canvas canvas2 = aVar.f2954a;
        aVar.f2954a = canvas;
        getRoot().i(aVar, null);
        ((d1.a) gVar.f19f).f2954a = canvas2;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((h1) ((u1.m1) arrayList.get(i))).g();
            }
        }
        int i3 = v1.f14583c;
        arrayList.clear();
        this.D = false;
        ArrayList arrayList2 = this.C;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
            arrayList2.clear();
        }
        if (this.f14545j) {
            s0.a(this, this.f14576y0);
            if (view == null) {
                yb.k.f("frameRateCategoryView");
                throw null;
            }
            s0.a(view, this.f14578z0);
            if (!Float.isNaN(this.f14578z0)) {
                view.invalidate();
                drawChild(canvas, view, getDrawingTime());
            }
            this.f14576y0 = Float.NaN;
            this.f14578z0 = Float.NaN;
        }
        getRectManager().a();
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        u1.c1 c1Var;
        q1.a aVar;
        int size;
        u1.c1 c1Var2;
        w0.l lVarE;
        u1.c1 c1Var3;
        a4.t tVar = this.B0;
        if (this.C0) {
            removeCallbacks(tVar);
            if (motionEvent.getActionMasked() == 8) {
                this.C0 = false;
            } else {
                tVar.run();
            }
        }
        if (p(motionEvent) || !isAttachedToWindow()) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() != 8) {
            if (!motionEvent.isFromSource(2)) {
                float x6 = motionEvent.getX();
                float y10 = motionEvent.getY();
                Float.floatToRawIntBits(x6);
                Float.floatToRawIntBits(y10);
                motionEvent.getEventTime();
                motionEvent.getActionMasked();
                b1.i iVar = (b1.i) getFocusOwner();
                if (iVar.f1821d.f1816e) {
                    System.out.println((Object) "FocusRelatedWarning: Dispatching indirect touch event while the focus system is invalidated.");
                } else {
                    b1.q qVarG = b1.e.g(iVar.f1820c);
                    if (qVarG != null) {
                        if (!qVarG.f15114c.f15126r) {
                            r1.a.b("visitAncestors called on an unattached node");
                        }
                        w0.l lVar = qVarG.f15114c;
                        u1.g0 g0VarU = u1.f.u(qVarG);
                        while (g0VarU != null) {
                            if ((g0VarU.H.f13746f.f15117h & 2097152) != 0) {
                                while (lVar != null) {
                                    if ((lVar.f15116g & 2097152) != 0) {
                                        m0.e eVar = null;
                                        w0.l lVarE2 = lVar;
                                        while (lVarE2 != null) {
                                            if ((lVarE2.f15116g & 2097152) != 0 && (lVarE2 instanceof u1.m)) {
                                                int i = 0;
                                                for (w0.l lVar2 = ((u1.m) lVarE2).f13866t; lVar2 != null; lVar2 = lVar2.f15118j) {
                                                    if ((lVar2.f15116g & 2097152) != 0) {
                                                        i++;
                                                        if (i == 1) {
                                                            lVarE2 = lVar2;
                                                        } else {
                                                            if (eVar == null) {
                                                                eVar = new m0.e(new w0.l[16]);
                                                            }
                                                            if (lVarE2 != null) {
                                                                eVar.b(lVarE2);
                                                                lVarE2 = null;
                                                            }
                                                            eVar.b(lVar2);
                                                        }
                                                    }
                                                }
                                                if (i == 1) {
                                                }
                                            }
                                            lVarE2 = u1.f.e(eVar);
                                        }
                                    }
                                    lVar = lVar.i;
                                }
                            }
                            g0VarU = g0VarU.t();
                            lVar = (g0VarU == null || (c1Var = g0VarU.H) == null) ? null : c1Var.f13745e;
                        }
                    }
                }
            }
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        if (!motionEvent.isFromSource(4194304)) {
            return (l(motionEvent) & 1) != 0;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        motionEvent.getAxisValue(26);
        getContext();
        viewConfiguration.getScaledVerticalScrollFactor();
        getContext();
        viewConfiguration.getScaledHorizontalScrollFactor();
        motionEvent.getEventTime();
        motionEvent.getDeviceId();
        b1.h focusOwner = getFocusOwner();
        a1.b bVar = new a1.b(14, this, motionEvent);
        b1.i iVar2 = (b1.i) focusOwner;
        if (iVar2.f1821d.f1816e) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching rotary event while the focus system is invalidated.");
            return false;
        }
        b1.q qVarG2 = b1.e.g(iVar2.f1820c);
        if (qVarG2 != null) {
            if (!qVarG2.f15114c.f15126r) {
                r1.a.b("visitAncestors called on an unattached node");
            }
            w0.l lVar3 = qVarG2.f15114c;
            u1.g0 g0VarU2 = u1.f.u(qVarG2);
            loop0: while (true) {
                if (g0VarU2 == null) {
                    lVarE = null;
                    break;
                }
                if ((g0VarU2.H.f13746f.f15117h & 16384) != 0) {
                    while (lVar3 != null) {
                        if ((lVar3.f15116g & 16384) != 0) {
                            lVarE = lVar3;
                            m0.e eVar2 = null;
                            while (lVarE != null) {
                                if (lVarE instanceof q1.a) {
                                    break loop0;
                                }
                                if ((lVarE.f15116g & 16384) != 0 && (lVarE instanceof u1.m)) {
                                    int i3 = 0;
                                    for (w0.l lVar4 = ((u1.m) lVarE).f13866t; lVar4 != null; lVar4 = lVar4.f15118j) {
                                        if ((lVar4.f15116g & 16384) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                lVarE = lVar4;
                                            } else {
                                                if (eVar2 == null) {
                                                    eVar2 = new m0.e(new w0.l[16]);
                                                }
                                                if (lVarE != null) {
                                                    eVar2.b(lVarE);
                                                    lVarE = null;
                                                }
                                                eVar2.b(lVar4);
                                            }
                                        }
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                                lVarE = u1.f.e(eVar2);
                            }
                        }
                        lVar3 = lVar3.i;
                    }
                }
                g0VarU2 = g0VarU2.t();
                lVar3 = (g0VarU2 == null || (c1Var3 = g0VarU2.H) == null) ? null : c1Var3.f13745e;
            }
            aVar = (q1.a) lVarE;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            if (!aVar.f15114c.f15126r) {
                r1.a.b("visitAncestors called on an unattached node");
            }
            w0.l lVar5 = aVar.f15114c.i;
            u1.g0 g0VarU3 = u1.f.u(aVar);
            ArrayList arrayList = null;
            while (g0VarU3 != null) {
                if ((g0VarU3.H.f13746f.f15117h & 16384) != 0) {
                    while (lVar5 != null) {
                        if ((lVar5.f15116g & 16384) != 0) {
                            w0.l lVarE3 = lVar5;
                            m0.e eVar3 = null;
                            while (lVarE3 != null) {
                                if (lVarE3 instanceof q1.a) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(lVarE3);
                                } else if ((lVarE3.f15116g & 16384) != 0 && (lVarE3 instanceof u1.m)) {
                                    int i10 = 0;
                                    for (w0.l lVar6 = ((u1.m) lVarE3).f13866t; lVar6 != null; lVar6 = lVar6.f15118j) {
                                        if ((lVar6.f15116g & 16384) != 0) {
                                            i10++;
                                            if (i10 == 1) {
                                                lVarE3 = lVar6;
                                            } else {
                                                if (eVar3 == null) {
                                                    eVar3 = new m0.e(new w0.l[16]);
                                                }
                                                if (lVarE3 != null) {
                                                    eVar3.b(lVarE3);
                                                    lVarE3 = null;
                                                }
                                                eVar3.b(lVar6);
                                            }
                                        }
                                    }
                                    if (i10 == 1) {
                                    }
                                }
                                lVarE3 = u1.f.e(eVar3);
                            }
                        }
                        lVar5 = lVar5.i;
                    }
                }
                g0VarU3 = g0VarU3.t();
                lVar5 = (g0VarU3 == null || (c1Var2 = g0VarU3.H) == null) ? null : c1Var2.f13745e;
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i11 = size - 1;
                    ((q1.a) arrayList.get(size)).getClass();
                    if (i11 < 0) {
                        break;
                    }
                    size = i11;
                }
            }
            w0.l lVarE4 = aVar.f15114c;
            m0.e eVar4 = null;
            while (lVarE4 != null) {
                if (lVarE4 instanceof q1.a) {
                } else if ((lVarE4.f15116g & 16384) != 0 && (lVarE4 instanceof u1.m)) {
                    int i12 = 0;
                    for (w0.l lVar7 = ((u1.m) lVarE4).f13866t; lVar7 != null; lVar7 = lVar7.f15118j) {
                        if ((lVar7.f15116g & 16384) != 0) {
                            i12++;
                            if (i12 == 1) {
                                lVarE4 = lVar7;
                            } else {
                                if (eVar4 == null) {
                                    eVar4 = new m0.e(new w0.l[16]);
                                }
                                if (lVarE4 != null) {
                                    eVar4.b(lVarE4);
                                    lVarE4 = null;
                                }
                                eVar4.b(lVar7);
                            }
                        }
                    }
                    if (i12 == 1) {
                    }
                }
                lVarE4 = u1.f.e(eVar4);
            }
            if (!((Boolean) bVar.invoke()).booleanValue()) {
                w0.l lVarE5 = aVar.f15114c;
                m0.e eVar5 = null;
                while (lVarE5 != null) {
                    if (lVarE5 instanceof q1.a) {
                    } else if ((lVarE5.f15116g & 16384) != 0 && (lVarE5 instanceof u1.m)) {
                        int i13 = 0;
                        for (w0.l lVar8 = ((u1.m) lVarE5).f13866t; lVar8 != null; lVar8 = lVar8.f15118j) {
                            if ((lVar8.f15116g & 16384) != 0) {
                                i13++;
                                if (i13 == 1) {
                                    lVarE5 = lVar8;
                                } else {
                                    if (eVar5 == null) {
                                        eVar5 = new m0.e(new w0.l[16]);
                                    }
                                    if (lVarE5 != null) {
                                        eVar5.b(lVarE5);
                                        lVarE5 = null;
                                    }
                                    eVar5.b(lVar8);
                                }
                            }
                        }
                        if (i13 == 1) {
                        }
                    }
                    lVarE5 = u1.f.e(eVar5);
                }
                if (arrayList != null) {
                    int size2 = arrayList.size();
                    for (int i14 = 0; i14 < size2; i14++) {
                        n nVar = ((q1.a) arrayList.get(i14)).f10072s;
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0155  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchHoverEvent(android.view.MotionEvent r24) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.t.dispatchHoverEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isFocused()) {
            return ((b1.i) getFocusOwner()).d(keyEvent, new a1.b(13, this, keyEvent));
        }
        k1 k1Var = this.f14553n;
        int metaState = keyEvent.getMetaState();
        k1Var.getClass();
        k0.k1 k1Var2 = x1.f14592a;
        o1.b0 b0Var = new o1.b0();
        b0Var.f9003a = metaState;
        VarHandle.storeStoreFence();
        k1Var2.setValue(b0Var);
        return ((b1.i) getFocusOwner()).d(keyEvent, b1.g.f1817c) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
        u1.c1 c1Var;
        if (isFocused()) {
            b1.i iVar = (b1.i) getFocusOwner();
            if (iVar.f1821d.f1816e) {
                System.out.println((Object) "FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            } else {
                b1.q qVarG = b1.e.g(iVar.f1820c);
                if (qVarG != null) {
                    if (!qVarG.f15114c.f15126r) {
                        r1.a.b("visitAncestors called on an unattached node");
                    }
                    w0.l lVar = qVarG.f15114c;
                    u1.g0 g0VarU = u1.f.u(qVarG);
                    while (g0VarU != null) {
                        if ((g0VarU.H.f13746f.f15117h & 131072) != 0) {
                            while (lVar != null) {
                                if ((lVar.f15116g & 131072) != 0) {
                                    w0.l lVarE = lVar;
                                    m0.e eVar = null;
                                    while (lVarE != null) {
                                        if ((lVarE.f15116g & 131072) != 0 && (lVarE instanceof u1.m)) {
                                            int i = 0;
                                            for (w0.l lVar2 = ((u1.m) lVarE).f13866t; lVar2 != null; lVar2 = lVar2.f15118j) {
                                                if ((lVar2.f15116g & 131072) != 0) {
                                                    i++;
                                                    if (i == 1) {
                                                        lVarE = lVar2;
                                                    } else {
                                                        if (eVar == null) {
                                                            eVar = new m0.e(new w0.l[16]);
                                                        }
                                                        if (lVarE != null) {
                                                            eVar.b(lVarE);
                                                            lVarE = null;
                                                        }
                                                        eVar.b(lVar2);
                                                    }
                                                }
                                            }
                                            if (i == 1) {
                                            }
                                        }
                                        lVarE = u1.f.e(eVar);
                                    }
                                }
                                lVar = lVar.i;
                            }
                        }
                        g0VarU = g0VarU.t();
                        lVar = (g0VarU == null || (c1Var = g0VarU.H) == null) ? null : c1Var.f13745e;
                    }
                }
            }
        }
        return super.dispatchKeyEventPreIme(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a4.t tVar = this.B0;
        if (this.C0) {
            removeCallbacks(tVar);
            MotionEvent motionEvent2 = this.f14568u0;
            motionEvent2.getClass();
            if (motionEvent.getActionMasked() == 0 && motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) {
                this.C0 = false;
            } else {
                tVar.run();
            }
        }
        if (!p(motionEvent) && isAttachedToWindow() && (motionEvent.getActionMasked() != 2 || r(motionEvent))) {
            int iL = l(motionEvent);
            if ((iL & 2) != 0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            if ((iL & 1) != 0) {
                return true;
            }
        }
        return false;
    }

    public final View findViewByAccessibilityIdTraversal(int i) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(this, Integer.valueOf(i));
            if (objInvoke instanceof View) {
                return (View) objInvoke;
            }
        } catch (NoSuchMethodException unused) {
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final View focusSearch(View view, int i) {
        c1.c cVarD;
        if (view == null || this.R.f13947c) {
            return super.focusSearch(view, i);
        }
        Object obj = f1.f14416f.get();
        obj.getClass();
        View viewB = ((f1) obj).b(i, view, this);
        if (view == this) {
            b1.q qVarG = b1.e.g(((b1.i) getFocusOwner()).f1820c);
            cVarD = qVarG != null ? b1.e.j(qVarG) : null;
            if (cVarD == null) {
                cVarD = b1.e.d(view, this);
            }
        } else {
            cVarD = b1.e.d(view, this);
        }
        b1.c cVarD2 = b1.e.D(i);
        int i3 = cVarD2 != null ? cVarD2.f1810a : 6;
        yb.u uVar = new yb.u();
        if (((b1.i) getFocusOwner()).e(i3, cVarD, new n1.h(uVar, 2)) != null) {
            Object obj2 = uVar.f16098c;
            if (obj2 != null) {
                if (viewB != null) {
                    if (i3 == 1 || i3 == 2) {
                        return super.focusSearch(view, i);
                    }
                    if (b1.e.o(b1.e.j((b1.q) obj2), b1.e.d(viewB, this), cVarD, i3)) {
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

    public final q0 getAndroidViewsHandler$ui_release() {
        if (this.O == null) {
            q0 q0Var = new q0(getContext());
            q0Var.setClipChildren(false);
            q0Var.f14525c = new HashMap();
            q0Var.f14526f = new HashMap();
            VarHandle.storeStoreFence();
            this.O = q0Var;
            addView(q0Var, -1);
            requestLayout();
        }
        q0 q0Var2 = this.O;
        q0Var2.getClass();
        return q0Var2;
    }

    public x0.e getAutofill() {
        return this.I;
    }

    public x0.g getAutofillManager() {
        return this.J;
    }

    public x0.h getAutofillTree() {
        return this.A;
    }

    public final xb.l getConfigurationChangeObserver() {
        return this.H;
    }

    public final y0.d getContentCaptureManager$ui_release() {
        return this.f14573x;
    }

    public nb.g getCoroutineContext() {
        return this.f14549l;
    }

    public o2.c getDensity() {
        return (o2.c) this.f14542h.getValue();
    }

    public c1.c getEmbeddedViewFocusRect() {
        if (isFocused()) {
            b1.q qVarG = b1.e.g(((b1.i) getFocusOwner()).f1820c);
            if (qVarG != null) {
                return b1.e.j(qVarG);
            }
            return null;
        }
        View viewFindFocus = findFocus();
        if (viewFindFocus != null) {
            return b1.e.d(viewFindFocus, this);
        }
        return null;
    }

    public b1.h getFocusOwner() {
        return this.f14547k;
    }

    @Override // android.view.View
    public final void getFocusedRect(Rect rect) {
        c1.c embeddedViewFocusRect = getEmbeddedViewFocusRect();
        if (embeddedViewFocusRect != null) {
            rect.left = Math.round(embeddedViewFocusRect.f2167a);
            rect.top = Math.round(embeddedViewFocusRect.f2168b);
            rect.right = Math.round(embeddedViewFocusRect.f2169c);
            rect.bottom = Math.round(embeddedViewFocusRect.f2170d);
            return;
        }
        if (yb.k.a(((b1.i) getFocusOwner()).e(6, null, n.f14505g), Boolean.TRUE)) {
            super.getFocusedRect(rect);
        } else {
            rect.set(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
    }

    public g2.d getFontFamilyResolver() {
        return (g2.d) this.f14554n0.getValue();
    }

    public g2.c getFontLoader() {
        return this.f14552m0;
    }

    public d1.u getGraphicsContext() {
        return this.f14577z;
    }

    public k1.a getHapticFeedBack() {
        return this.f14560q0;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return this.R.f13946b.G();
    }

    @Override // android.view.View
    public int getImportantForAutofill() {
        return 1;
    }

    public l1.b getInputModeManager() {
        return this.f14562r0;
    }

    public final s1.p getInsetsListener() {
        return this.f14559q;
    }

    public final long getLastMatrixRecalculationAnimationTime$ui_release() {
        return this.W;
    }

    @Override // android.view.View, android.view.ViewParent
    public o2.l getLayoutDirection() {
        return (o2.l) this.f14558p0.getValue();
    }

    public long getMeasureIteration() {
        u1.v0 v0Var = this.R;
        if (!v0Var.f13947c) {
            r1.a.a("measureIteration should be only used during the measure/layout pass");
        }
        return v0Var.f13951g;
    }

    public t1.d getModifierLocalManager() {
        return this.f14564s0;
    }

    public t getOutOfFrameExecutor() {
        if (isAttachedToWindow()) {
            return this;
        }
        return null;
    }

    public s1.n0 getPlacementScope() {
        int i = s1.q0.f11291b;
        s1.c0 c0Var = new s1.c0(1);
        c0Var.f11222g = this;
        VarHandle.storeStoreFence();
        return c0Var;
    }

    public o1.p getPointerIconService() {
        return this.I0;
    }

    public b2.b getRectManager() {
        return this.f14565t;
    }

    public u1.g0 getRoot() {
        return this.f14561r;
    }

    public u1.u1 getRootForTest() {
        return this.f14567u;
    }

    public final boolean getScrollCaptureInProgress$ui_release() {
        k1 k1Var = this.G0;
        if (k1Var != null) {
            return ((Boolean) k1Var.f14486a.getValue()).booleanValue();
        }
        return false;
    }

    public a2.r getSemanticsOwner() {
        return this.f14569v;
    }

    public u1.i0 getSharedDrawScope() {
        return this.f14540g;
    }

    public boolean getShowLayoutBounds() {
        return r0.f14529a.a(this);
    }

    public u1.p1 getSnapshotObserver() {
        return this.N;
    }

    public p1 getSoftwareKeyboardController() {
        return this.f14550l0;
    }

    public h2.d getTextInputService() {
        return this.f14546j0;
    }

    public q1 getTextToolbar() {
        return this.f14566t0;
    }

    public final u1.t1 getUncaughtExceptionHandler$ui_release() {
        return null;
    }

    public u1 getViewConfiguration() {
        return this.f14557p;
    }

    public final m getViewTreeOwners() {
        return (m) this.f14538d0.getValue();
    }

    public w1 getWindowInfo() {
        return this.f14553n;
    }

    public final x0.b get_autofillManager$ui_release() {
        return this.J;
    }

    public final void k(u1.g0 g0Var, boolean z10) {
        this.R.f(g0Var, z10);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.t.l(android.view.MotionEvent):int");
    }

    public final void n(u1.g0 g0Var) {
        this.R.p(g0Var, false);
        m0.e eVarX = g0Var.x();
        Object[] objArr = eVarX.f8158c;
        int i = eVarX.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            n((u1.g0) objArr[i3]);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        androidx.lifecycle.q lifecycle;
        androidx.lifecycle.x xVar;
        super.onAttachedToWindow();
        this.f14559q.onViewAttachedToWindow(this);
        if (M0 == null) {
            e3.j jVar = new e3.j(3);
            M0 = jVar;
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
                    method.invoke(null, jVar);
                }
            } catch (Throwable unused) {
            }
            StrictMode.setVmPolicy(vmPolicy);
        }
        p.a0 a0Var = L0;
        synchronized (a0Var) {
            a0Var.a(this);
        }
        this.f14553n.f14486a.setValue(Boolean.valueOf(hasWindowFocus()));
        this.f14553n.getClass();
        this.f14553n.getClass();
        n(getRoot());
        m(getRoot());
        getSnapshotObserver().f13895a.c();
        p5.i iVar = this.I;
        if (iVar != null) {
            x0.f fVar = x0.f.f15515a;
            fVar.getClass();
            ((AutofillManager) iVar.f9732g).registerCallback(fVar);
        }
        androidx.lifecycle.x xVarD = androidx.lifecycle.s0.d(this);
        t4.f fVarI = t.m0.i(this);
        m viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners == null || (xVarD != null && fVarI != null && (xVarD != (xVar = viewTreeOwners.f14490a) || fVarI != xVar))) {
            if (xVarD == null) {
                od.f.e("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
                return;
            }
            if (fVarI == null) {
                od.f.e("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
                return;
            }
            if (viewTreeOwners != null && (lifecycle = viewTreeOwners.f14490a.getLifecycle()) != null) {
                lifecycle.c(this);
            }
            xVarD.getLifecycle().a(this);
            m mVar = new m();
            mVar.f14490a = xVarD;
            mVar.f14491b = fVarI;
            VarHandle.storeStoreFence();
            set_viewTreeOwners(mVar);
            xb.l lVar = this.e0;
            if (lVar != null) {
                lVar.invoke(mVar);
            }
            this.e0 = null;
        }
        l1.c cVar = this.f14562r0;
        int i = isInTouchMode() ? 1 : 2;
        k0.k1 k1Var = cVar.f7714a;
        l1.a aVar = new l1.a();
        aVar.f7713a = i;
        VarHandle.storeStoreFence();
        k1Var.setValue(aVar);
        m viewTreeOwners2 = getViewTreeOwners();
        androidx.lifecycle.q lifecycle2 = viewTreeOwners2 != null ? viewTreeOwners2.f14490a.getLifecycle() : null;
        if (lifecycle2 == null) {
            throw w2.c.a("No lifecycle owner exists");
        }
        lifecycle2.a(this);
        lifecycle2.a(this.f14573x);
        getViewTreeObserver().addOnGlobalLayoutListener(this.f0);
        getViewTreeObserver().addOnScrollChangedListener(this.f14541g0);
        getViewTreeObserver().addOnTouchModeChangeListener(this.f14543h0);
        d0.f14401a.b(this);
        x0.b bVar = this.J;
        if (bVar != null) {
            ((b1.i) getFocusOwner()).f1824g.a(bVar);
            getSemanticsOwner().f97d.a(bVar);
        }
    }

    @Override // android.view.View
    public final boolean onCheckIsTextEditor() {
        if (this.f14548k0.get() == null) {
            this.f14544i0.getClass();
            return false;
        }
        od.f.j();
        return false;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setDensity(id.c.a(getContext()));
        this.f14553n.getClass();
        int i = configuration.fontWeightAdjustment;
        if (i != this.f14556o0) {
            this.f14556o0 = i;
            setFontFamilyResolver(p5.f.t(getContext()));
        }
        this.H.invoke(configuration);
    }

    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        if (this.f14548k0.get() == null) {
            this.f14544i0.getClass();
            return null;
        }
        od.f.j();
        return null;
    }

    @Override // android.view.View
    public final void onCreateVirtualViewTranslationRequests(long[] jArr, int[] iArr, Consumer consumer) {
        a2.p pVar;
        y0.d dVar = this.f14573x;
        dVar.getClass();
        int i = 0;
        for (long j10 : jArr) {
            a2.q qVar = (a2.q) dVar.f().b((int) j10);
            if (qVar != null && (pVar = qVar.f92a) != null) {
                ViewTranslationRequest.Builder builder = new ViewTranslationRequest.Builder(dVar.f15854c.getAutofillId(), pVar.f91g);
                Object objG = pVar.f88d.f75c.g(a2.u.f141z);
                if (objG == null) {
                    objG = null;
                }
                List list = (List) objG;
                if (list != null) {
                    builder.setValue("android:text", TranslationRequestValue.forText(new d2.g(q2.a.a(list, "\n", null, 62), i)));
                    consumer.accept(builder.build());
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f14559q.onViewDetachedFromWindow(this);
        if (this.f14545j) {
            View view = this.i;
            if (view == null) {
                yb.k.f("frameRateCategoryView");
                throw null;
            }
            removeView(view);
        }
        p.a0 a0Var = L0;
        synchronized (a0Var) {
            a0Var.i(this);
        }
        u1.p1 snapshotObserver = getSnapshotObserver();
        b.b bVar = snapshotObserver.f13895a.f13707h;
        if (bVar != null) {
            bVar.c();
        }
        u0.t tVar = snapshotObserver.f13895a;
        synchronized (tVar.f13706g) {
            m0.e eVar = tVar.f13705f;
            Object[] objArr = eVar.f8158c;
            int i = eVar.f8160g;
            for (int i3 = 0; i3 < i; i3++) {
                u0.s sVar = (u0.s) objArr[i3];
                sVar.f13693e.a();
                sVar.f13694f.a();
                sVar.f13698k.a();
                sVar.f13699l.clear();
            }
        }
        this.f14553n.getClass();
        m viewTreeOwners = getViewTreeOwners();
        androidx.lifecycle.q lifecycle = viewTreeOwners != null ? viewTreeOwners.f14490a.getLifecycle() : null;
        if (lifecycle == null) {
            throw w2.c.a("No lifecycle owner exists");
        }
        lifecycle.c(this.f14573x);
        lifecycle.c(this);
        p5.i iVar = this.I;
        if (iVar != null) {
            x0.f fVar = x0.f.f15515a;
            fVar.getClass();
            ((AutofillManager) iVar.f9732g).unregisterCallback(fVar);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f0);
        getViewTreeObserver().removeOnScrollChangedListener(this.f14541g0);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.f14543h0);
        d0.f14401a.a(this);
        x0.b bVar2 = this.J;
        if (bVar2 != null) {
            getSemanticsOwner().f97d.i(bVar2);
            ((b1.i) getFocusOwner()).f1824g.i(bVar2);
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z10, int i, Rect rect) {
        super.onFocusChanged(z10, i, rect);
        if (z10 || hasFocus()) {
            return;
        }
        b1.e.e(((b1.i) getFocusOwner()).f1820c, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        this.W = 0L;
        this.R.j(this.D0);
        this.P = null;
        H();
        if (this.O != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, i10 - i, i11 - i3);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        u1.v0 v0Var = this.R;
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                n(getRoot());
            }
            long j10 = j(i);
            long j11 = j(i3);
            long jP = id.k.p((int) (j10 >>> 32), (int) (j10 & 4294967295L), (int) (j11 >>> 32), (int) (4294967295L & j11));
            o2.a aVar = this.P;
            if (aVar == null) {
                this.P = o2.a.a(jP);
                this.Q = false;
            } else if (!o2.a.c(aVar.f9108a, jP)) {
                this.Q = true;
            }
            v0Var.q(jP);
            v0Var.l();
            setMeasuredDimension(getRoot().I.f13857p.f11277c, getRoot().I.f13857p.f11278f);
            if (this.O != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().I.f13857p.f11277c, 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().I.f13857p.f11278f, 1073741824));
            }
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0096  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onProvideAutofillVirtualStructure(android.view.ViewStructure r12, int r13) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.t.onProvideAutofillVirtualStructure(android.view.ViewStructure, int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        int toolType = motionEvent.getToolType(i);
        if (!motionEvent.isFromSource(8194) && motionEvent.isFromSource(16386) && (toolType == 2 || toolType == 4)) {
            getPointerIconService().getClass();
        }
        return super.onResolvePointerIcon(motionEvent, i);
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        if (this.f14539f) {
            o2.l lVar = i != 0 ? i != 1 ? null : o2.l.f9124f : o2.l.f9123c;
            if (lVar == null) {
                lVar = o2.l.f9123c;
            }
            setLayoutDirection(lVar);
        }
    }

    @Override // android.view.View
    public final void onScrollCaptureSearch(Rect rect, Point point, Consumer consumer) {
        k1 k1Var = this.G0;
        if (k1Var != null) {
            a2.r semanticsOwner = getSemanticsOwner();
            nb.g coroutineContext = getCoroutineContext();
            m0.e eVar = new m0.e(new z1.j[16]);
            t.m0.k(semanticsOwner.a(), 0, new z1.i(1, 8, m0.e.class, eVar, "add", "add(Ljava/lang/Object;)Z"));
            xb.l[] lVarArr = {z1.b.f16153g, z1.b.f16154h};
            a2.y yVar = new a2.y(4);
            yVar.f149f = lVarArr;
            VarHandle.storeStoreFence();
            Arrays.sort(eVar.f8158c, 0, eVar.f8160g, yVar);
            int i = eVar.f8160g;
            z1.j jVar = (z1.j) (i == 0 ? null : eVar.f8158c[i - 1]);
            if (jVar == null) {
                return;
            }
            o2.j jVar2 = jVar.f16175c;
            int i3 = jVar2.f9119b;
            pc.c cVarA = kc.w.a(coroutineContext);
            a2.p pVar = jVar.f16173a;
            z1.d dVar = new z1.d();
            dVar.f16159a = pVar;
            dVar.f16160b = jVar2;
            dVar.f16161c = k1Var;
            dVar.f16162d = this;
            dVar.f16163e = new pc.c(cVarA.f9952c.plus(z1.f.f16166c));
            int i10 = jVar2.f9121d - i3;
            z1.c cVar = new z1.c(dVar, null);
            z1.h hVar = new z1.h();
            hVar.f16170a = i10;
            hVar.f16171b = cVar;
            VarHandle.storeStoreFence();
            dVar.f16164f = hVar;
            VarHandle.storeStoreFence();
            u1.g1 g1Var = jVar.f16176d;
            long j10 = (jVar2.f9118a << 32) | (i3 & 4294967295L);
            ScrollCaptureTarget scrollCaptureTarget = new ScrollCaptureTarget(this, d1.f0.q(a.a.U(s1.v0.i(g1Var).g(g1Var, true))), new Point((int) (j10 >> 32), (int) (j10 & 4294967295L)), dVar);
            scrollCaptureTarget.setScrollBounds(d1.f0.q(jVar2));
            consumer.accept(scrollCaptureTarget);
        }
    }

    @Override // android.view.View
    public final void onVirtualViewTranslationResponses(LongSparseArray longSparseArray) {
        y0.d dVar = this.f14573x;
        dVar.getClass();
        if (yb.k.a(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            t0.a.c(dVar, longSparseArray);
            return;
        }
        t tVar = dVar.f15854c;
        androidx.room.a0 a0Var = new androidx.room.a0(10);
        a0Var.f1506f = dVar;
        a0Var.f1507g = longSparseArray;
        VarHandle.storeStoreFence();
        tVar.post(a0Var);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z10) {
        this.f14553n.f14486a.setValue(Boolean.valueOf(z10));
        this.F0 = true;
        super.onWindowFocusChanged(z10);
    }

    public final boolean q(MotionEvent motionEvent) {
        float x6 = motionEvent.getX();
        float y10 = motionEvent.getY();
        return 0.0f <= x6 && x6 <= ((float) getWidth()) && 0.0f <= y10 && y10 <= ((float) getHeight());
    }

    public final boolean r(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        return (motionEvent.getPointerCount() == 1 && (motionEvent2 = this.f14568u0) != null && motionEvent2.getPointerCount() == motionEvent.getPointerCount() && motionEvent.getRawX() == motionEvent2.getRawX() && motionEvent.getRawY() == motionEvent2.getRawY()) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i, Rect rect) {
        if (isFocused()) {
            return true;
        }
        int iOrdinal = ((b1.i) getFocusOwner()).f1820c.D0().ordinal();
        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
            return super.requestFocus(i, rect);
        }
        if (iOrdinal != 3) {
            g5.f.a();
            return false;
        }
        b1.c cVarD = b1.e.D(i);
        int i3 = cVarD != null ? cVarD.f1810a : 7;
        return yb.k.a(((b1.i) getFocusOwner()).e(i3, rect != null ? d1.f0.t(rect) : null, new r(i3, 0)), Boolean.TRUE);
    }

    public final long s(long j10) {
        A();
        long jL = d1.f0.l(this.U, j10);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (this.f14535b0 >> 32)) + Float.intBitsToFloat((int) (jL >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (this.f14535b0 & 4294967295L)) + Float.intBitsToFloat((int) (jL & 4294967295L));
        return (Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L);
    }

    public void setAccessibilityEventBatchIntervalMillis(long j10) {
        this.f14571w.f14335e = j10;
    }

    public final void setConfigurationChangeObserver(xb.l lVar) {
        this.H = lVar;
    }

    public final void setContentCaptureManager$ui_release(y0.d dVar) {
        this.f14573x = dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public void setCoroutineContext(nb.g gVar) {
        this.f14549l = gVar;
        w0.l lVar = getRoot().H.f13746f;
        if (lVar instanceof o1.i0) {
            ((o1.i0) lVar).C0();
        }
        if (!lVar.f15114c.f15126r) {
            r1.a.b("visitSubtreeIf called on an unattached node");
        }
        m0.e eVar = new m0.e(new w0.l[16]);
        w0.l lVar2 = lVar.f15114c;
        w0.l lVar3 = lVar2.f15118j;
        if (lVar3 == null) {
            u1.f.b(eVar, lVar2);
        } else {
            eVar.b(lVar3);
        }
        while (true) {
            int i = eVar.f8160g;
            if (i == 0) {
                return;
            }
            w0.l lVar4 = (w0.l) eVar.k(i - 1);
            if ((lVar4.f15117h & 16) != 0) {
                for (w0.l lVar5 = lVar4; lVar5 != null; lVar5 = lVar5.f15118j) {
                    if ((lVar5.f15116g & 16) != 0) {
                        u1.m mVarE = lVar5;
                        ?? eVar2 = 0;
                        while (mVarE != 0) {
                            if (mVarE instanceof u1.s1) {
                                u1.s1 s1Var = (u1.s1) mVarE;
                                if (s1Var instanceof o1.i0) {
                                    ((o1.i0) s1Var).C0();
                                }
                            } else if ((mVarE.f15116g & 16) != 0 && (mVarE instanceof u1.m)) {
                                w0.l lVar6 = mVarE.f13866t;
                                int i3 = 0;
                                mVarE = mVarE;
                                eVar2 = eVar2;
                                while (lVar6 != null) {
                                    if ((lVar6.f15116g & 16) != 0) {
                                        i3++;
                                        eVar2 = eVar2;
                                        if (i3 == 1) {
                                            mVarE = lVar6;
                                        } else {
                                            if (eVar2 == 0) {
                                                eVar2 = new m0.e(new w0.l[16]);
                                            }
                                            if (mVarE != 0) {
                                                eVar2.b(mVarE);
                                                mVarE = 0;
                                            }
                                            eVar2.b(lVar6);
                                        }
                                    }
                                    lVar6 = lVar6.f15118j;
                                    mVarE = mVarE;
                                    eVar2 = eVar2;
                                }
                                if (i3 == 1) {
                                }
                            }
                            mVarE = u1.f.e(eVar2);
                        }
                    }
                }
            }
            u1.f.b(eVar, lVar4);
        }
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j10) {
        this.W = j10;
    }

    public final void setOnViewTreeOwnersAvailable(xb.l lVar) {
        m viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            lVar.invoke(viewTreeOwners);
        }
        if (isAttachedToWindow()) {
            return;
        }
        this.e0 = lVar;
    }

    public void setUncaughtExceptionHandler(u1.t1 t1Var) {
        this.R.getClass();
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void t(boolean z10) {
        s sVar;
        u1.v0 v0Var = this.R;
        if (v0Var.f13946b.G() || ((m0.e) v0Var.f13949e.f9717f).f8160g != 0) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (z10) {
                try {
                    sVar = this.D0;
                } finally {
                    Trace.endSection();
                }
            } else {
                sVar = null;
            }
            if (v0Var.j(sVar)) {
                requestLayout();
            }
            v0Var.a(false);
            if (this.E) {
                getViewTreeObserver().dispatchOnGlobalLayout();
                this.E = false;
            }
        }
    }

    public final void u(u1.g0 g0Var, long j10) {
        u1.v0 v0Var = this.R;
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            v0Var.k(g0Var, j10);
            if (!v0Var.f13946b.G()) {
                v0Var.a(false);
                if (this.E) {
                    getViewTreeObserver().dispatchOnGlobalLayout();
                    this.E = false;
                }
            }
            getRectManager().a();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a8, code lost:
    
        r4.k(0, r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v() {
        /*
            r10 = this;
            boolean r0 = r10.K
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L48
            u1.p1 r0 = r10.getSnapshotObserver()
            u0.t r0 = r0.f13895a
            java.lang.Object r3 = r0.f13706g
            monitor-enter(r3)
            m0.e r0 = r0.f13705f     // Catch: java.lang.Throwable -> L36
            int r4 = r0.f8160g     // Catch: java.lang.Throwable -> L36
            r5 = r2
            r6 = r5
        L15:
            java.lang.Object[] r7 = r0.f8158c
            if (r5 >= r4) goto L3b
            r7 = r7[r5]     // Catch: java.lang.Throwable -> L36
            u0.s r7 = (u0.s) r7     // Catch: java.lang.Throwable -> L36
            r7.e()     // Catch: java.lang.Throwable -> L36
            p.f0 r7 = r7.f13694f     // Catch: java.lang.Throwable -> L36
            boolean r7 = r7.j()     // Catch: java.lang.Throwable -> L36
            if (r7 != 0) goto L2b
            int r6 = r6 + 1
            goto L38
        L2b:
            if (r6 <= 0) goto L38
            java.lang.Object[] r7 = r0.f8158c     // Catch: java.lang.Throwable -> L36
            int r8 = r5 - r6
            r9 = r7[r5]     // Catch: java.lang.Throwable -> L36
            r7[r8] = r9     // Catch: java.lang.Throwable -> L36
            goto L38
        L36:
            r10 = move-exception
            goto L46
        L38:
            int r5 = r5 + 1
            goto L15
        L3b:
            int r5 = r4 - r6
            java.util.Arrays.fill(r7, r5, r4, r1)     // Catch: java.lang.Throwable -> L36
            r0.f8160g = r5     // Catch: java.lang.Throwable -> L36
            monitor-exit(r3)
            r10.K = r2
            goto L48
        L46:
            monitor-exit(r3)
            throw r10
        L48:
            v1.q0 r0 = r10.O
            if (r0 == 0) goto L4f
            h(r0)
        L4f:
            x0.b r0 = r10.J
            if (r0 == 0) goto L6f
            p.v r3 = r0.f15511g
            int r4 = r3.f9635d
            if (r4 != 0) goto L68
            boolean r4 = r0.f15512h
            if (r4 == 0) goto L68
            stepos.support.v7.app.f r4 = r0.f15505a
            java.lang.Object r4 = r4.f12315f
            android.view.autofill.AutofillManager r4 = (android.view.autofill.AutofillManager) r4
            r4.commit()
            r0.f15512h = r2
        L68:
            int r3 = r3.f9635d
            if (r3 == 0) goto L6f
            r3 = 1
            r0.f15512h = r3
        L6f:
            p.a0 r0 = r10.f14574x0
            boolean r0 = r0.h()
            if (r0 == 0) goto Lac
            p.a0 r0 = r10.f14574x0
            java.lang.Object r0 = r0.e(r2)
            if (r0 == 0) goto Lac
            p.a0 r0 = r10.f14574x0
            int r0 = r0.f9517b
            r3 = r2
        L84:
            p.a0 r4 = r10.f14574x0
            if (r3 >= r0) goto La8
            java.lang.Object r4 = r4.e(r3)
            xb.a r4 = (xb.a) r4
            p.a0 r5 = r10.f14574x0
            if (r3 < 0) goto La4
            int r6 = r5.f9517b
            if (r3 >= r6) goto La4
            java.lang.Object[] r5 = r5.f9516a
            r6 = r5[r3]
            r5[r3] = r1
            if (r4 == 0) goto La1
            r4.invoke()
        La1:
            int r3 = r3 + 1
            goto L84
        La4:
            r5.m(r3)
            throw r1
        La8:
            r4.k(r2, r0)
            goto L6f
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: v1.t.v():void");
    }

    public final void w(u1.g0 g0Var) {
        a0 a0Var = this.f14571w;
        a0Var.f14353x = true;
        if (a0Var.m()) {
            a0Var.n(g0Var);
        }
        y0.d dVar = this.f14573x;
        dVar.f15859k = true;
        if (dVar.h()) {
            dVar.f15860l.h(jb.v.f6774a);
        }
    }

    public final void x(u1.g0 g0Var, boolean z10, boolean z11, boolean z12) {
        u1.g0 g0VarT;
        u1.g0 g0VarT2;
        u1.v0 v0Var = this.R;
        if (!z10) {
            if (v0Var.p(g0Var, z11) && z12) {
                D(g0Var);
                return;
            }
            return;
        }
        p5.m mVar = v0Var.f13946b;
        u1.g0 g0Var2 = g0Var.f13794k;
        u1.k0 k0Var = g0Var.I;
        if (g0Var2 == null) {
            r1.a.b("Error: requestLookaheadRemeasure cannot be called on a node outside LookaheadScope");
        }
        int iOrdinal = k0Var.f13846d.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return;
            }
            if (iOrdinal != 2 && iOrdinal != 3) {
                if (iOrdinal != 4) {
                    g5.f.a();
                    return;
                }
                if (!k0Var.f13847e || z11) {
                    k0Var.f13847e = true;
                    k0Var.f13857p.f13971y = true;
                    if (g0Var.S) {
                        return;
                    }
                    if ((yb.k.a(g0Var.I(), Boolean.TRUE) || u1.v0.h(g0Var)) && ((g0VarT = g0Var.t()) == null || !g0VarT.I.f13847e)) {
                        mVar.p(g0Var, u1.t.f13917c);
                    } else if ((g0Var.H() || u1.v0.i(g0Var)) && ((g0VarT2 = g0Var.t()) == null || !g0VarT2.q())) {
                        mVar.p(g0Var, u1.t.f13919g);
                    }
                    if (v0Var.f13948d || !z12) {
                        return;
                    }
                    D(g0Var);
                    return;
                }
                return;
            }
        }
        v0Var.f13952h.b(new u1.u0(g0Var, true, z11));
    }

    public final void y(u1.g0 g0Var, boolean z10, boolean z11) {
        u1.k0 k0Var = g0Var.I;
        u1.v0 v0Var = this.R;
        if (!z10) {
            v0Var.getClass();
            int iOrdinal = k0Var.f13846d.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
                return;
            }
            if (iOrdinal != 4) {
                g5.f.a();
                return;
            }
            u1.g0 g0VarT = g0Var.t();
            boolean z12 = g0VarT == null || g0VarT.H();
            if (!z11) {
                if (g0Var.q()) {
                    return;
                }
                if (g0Var.p() && g0Var.H() == z12 && g0Var.H() == k0Var.f13857p.f13970x) {
                    return;
                }
            }
            u1.x0 x0Var = k0Var.f13857p;
            x0Var.f13972z = true;
            x0Var.A = true;
            if (!g0Var.S && x0Var.f13970x && z12) {
                if ((g0VarT == null || !g0VarT.p()) && (g0VarT == null || !g0VarT.q())) {
                    v0Var.f13946b.p(g0Var, u1.t.f13920h);
                }
                if (v0Var.f13948d) {
                    return;
                }
                D(null);
                return;
            }
            return;
        }
        p5.m mVar = v0Var.f13946b;
        int iOrdinal2 = k0Var.f13846d.ordinal();
        if (iOrdinal2 != 0) {
            if (iOrdinal2 == 1) {
                return;
            }
            if (iOrdinal2 != 2) {
                if (iOrdinal2 == 3) {
                    return;
                }
                if (iOrdinal2 != 4) {
                    g5.f.a();
                    return;
                }
            }
        }
        if ((k0Var.f13847e || k0Var.f13848f) && !z11) {
            return;
        }
        k0Var.f13848f = true;
        k0Var.f13849g = true;
        u1.x0 x0Var2 = k0Var.f13857p;
        x0Var2.f13972z = true;
        x0Var2.A = true;
        if (g0Var.S) {
            return;
        }
        u1.g0 g0VarT2 = g0Var.t();
        if (yb.k.a(g0Var.I(), Boolean.TRUE) && ((g0VarT2 == null || !g0VarT2.I.f13847e) && (g0VarT2 == null || !g0VarT2.I.f13848f))) {
            mVar.p(g0Var, u1.t.f13918f);
        } else if (g0Var.H() && ((g0VarT2 == null || !g0VarT2.p()) && (g0VarT2 == null || !g0VarT2.q()))) {
            mVar.p(g0Var, u1.t.f13920h);
        }
        if (v0Var.f13948d) {
            return;
        }
        D(null);
    }

    public final void z() {
        a0 a0Var = this.f14571w;
        a0Var.f14353x = true;
        if (a0Var.m() && !a0Var.I) {
            a0Var.I = true;
            a0Var.i.post(a0Var.K);
        }
        y0.d dVar = this.f14573x;
        dVar.f15859k = true;
        if (!dVar.h() || dVar.f15866r) {
            return;
        }
        dVar.f15866r = true;
        dVar.f15861m.post(dVar.f15867s);
    }

    public g getAccessibilityManager() {
        return this.f14575y;
    }

    /* renamed from: getClipboard, reason: merged with bridge method [inline-methods] */
    public h m6getClipboard() {
        return this.M;
    }

    /* renamed from: getClipboardManager, reason: merged with bridge method [inline-methods] */
    public i m7getClipboardManager() {
        return this.L;
    }

    /* renamed from: getDragAndDropManager, reason: merged with bridge method [inline-methods] */
    public z0.a m8getDragAndDropManager() {
        return this.f14551m;
    }

    public p.u getLayoutNodes() {
        return this.f14563s;
    }

    @jb.a
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getRoot$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    @jb.a
    public static /* synthetic */ void getTextInputService$annotations() {
    }

    @Override // android.view.ViewGroup
    public final void addView(View view) {
        addView(view, -1);
    }

    public View getView() {
        return this;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, int i3) {
        ViewGroup.LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.width = i;
        layoutParamsGenerateDefaultLayoutParams.height = i3;
        addViewInLayout(view, -1, layoutParamsGenerateDefaultLayoutParams, true);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInLayout(view, i, layoutParams, true);
    }

    @Override // androidx.lifecycle.f
    public final void d(androidx.lifecycle.x xVar) {
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
    }

    public void setShowLayoutBounds(boolean z10) {
    }

    public final void setUncaughtExceptionHandler$ui_release(u1.t1 t1Var) {
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInLayout(view, -1, layoutParams, true);
    }
}
