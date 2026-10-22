package androidx.coordinatorlayout.widget;

import a1.g;
import a9.n;
import aa.l;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import b3.b;
import b3.e;
import com.stepos.agentsafetycenter.R;
import h0.l0;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import m3.c;
import m3.d;
import n3.e0;
import n3.i0;
import n3.k0;
import n3.m1;
import n3.q;
import n3.r;
import od.f;
import p.p0;
import p5.i;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a extends ViewGroup implements q, r {
    public static final n A;
    public static final d B;

    /* renamed from: x, reason: collision with root package name */
    public static final String f1012x;

    /* renamed from: y, reason: collision with root package name */
    public static final Class[] f1013y;

    /* renamed from: z, reason: collision with root package name */
    public static final ThreadLocal f1014z;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1015c;

    /* renamed from: f, reason: collision with root package name */
    public final i f1016f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f1017g;

    /* renamed from: h, reason: collision with root package name */
    public Paint f1018h;
    public final int[] i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f1019j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1020k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1021l;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f1022m;

    /* renamed from: n, reason: collision with root package name */
    public View f1023n;

    /* renamed from: o, reason: collision with root package name */
    public View f1024o;

    /* renamed from: p, reason: collision with root package name */
    public l f1025p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1026q;

    /* renamed from: r, reason: collision with root package name */
    public m1 f1027r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1028s;

    /* renamed from: t, reason: collision with root package name */
    public Drawable f1029t;

    /* renamed from: u, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f1030u;

    /* renamed from: v, reason: collision with root package name */
    public g f1031v;

    /* renamed from: w, reason: collision with root package name */
    public final l0 f1032w;

    static {
        Package r02 = a.class.getPackage();
        f1012x = r02 != null ? r02.getName() : null;
        A = new n(2);
        f1013y = new Class[]{Context.class, AttributeSet.class};
        f1014z = new ThreadLocal();
        d dVar = new d(12);
        dVar.f8196c = new Object();
        VarHandle.storeStoreFence();
        B = dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, android.view.ViewGroup, androidx.coordinatorlayout.widget.a] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public a(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        Context context2;
        ActionBarCoordinatorLayout actionBarCoordinatorLayout;
        super(context, attributeSet, i);
        this.f1015c = new ArrayList();
        i iVar = new i();
        iVar.f9730c = new c(10);
        iVar.f9731f = new p0(0);
        iVar.f9732g = new ArrayList();
        iVar.f9733h = new HashSet();
        VarHandle.storeStoreFence();
        this.f1016f = iVar;
        this.f1017g = new ArrayList();
        this.i = new int[2];
        this.f1019j = new int[2];
        this.f1032w = new l0();
        int[] iArr = a3.a.f152a;
        TypedArray typedArrayObtainStyledAttributes = i == 0 ? context.obtainStyledAttributes(attributeSet, iArr, 0, R.style.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        if (i == 0) {
            WeakHashMap weakHashMap = k0.f8724a;
            a aVar = this;
            context2 = context;
            i0.b(aVar, context2, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, R.style.Widget_Support_CoordinatorLayout);
            actionBarCoordinatorLayout = aVar;
        } else {
            a aVar2 = this;
            context2 = context;
            WeakHashMap weakHashMap2 = k0.f8724a;
            i0.b(aVar2, context2, iArr, attributeSet, typedArrayObtainStyledAttributes, i, 0);
            actionBarCoordinatorLayout = aVar2;
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context2.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            actionBarCoordinatorLayout.f1022m = intArray;
            float f5 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i3 = 0; i3 < length; i3++) {
                actionBarCoordinatorLayout.f1022m[i3] = (int) (r12[i3] * f5);
            }
        }
        actionBarCoordinatorLayout.f1029t = typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.recycle();
        actionBarCoordinatorLayout.K();
        b3.c cVar = new b3.c();
        cVar.f1876c = actionBarCoordinatorLayout;
        VarHandle.storeStoreFence();
        super.setOnHierarchyChangeListener(cVar);
        WeakHashMap weakHashMap3 = k0.f8724a;
        if (actionBarCoordinatorLayout.getImportantForAccessibility() == 0) {
            actionBarCoordinatorLayout.setImportantForAccessibility(1);
        }
    }

    public static void G(Rect rect) {
        rect.setEmpty();
        B.a(rect);
    }

    public static void I(int i, View view) {
        b3.d dVar = (b3.d) view.getLayoutParams();
        int i3 = dVar.i;
        if (i3 != i) {
            WeakHashMap weakHashMap = k0.f8724a;
            view.offsetLeftAndRight(i - i3);
            dVar.i = i;
        }
    }

    public static void J(int i, View view) {
        b3.d dVar = (b3.d) view.getLayoutParams();
        int i3 = dVar.f1885j;
        if (i3 != i) {
            WeakHashMap weakHashMap = k0.f8724a;
            view.offsetTopAndBottom(i - i3);
            dVar.f1885j = i;
        }
    }

    public static Rect s() {
        Rect rect = (Rect) B.b();
        return rect == null ? new Rect() : rect;
    }

    public static void w(int i, Rect rect, Rect rect2, b3.d dVar, int i3, int i10) {
        int i11 = dVar.f1879c;
        if (i11 == 0) {
            i11 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i11, i);
        int i12 = dVar.f1880d;
        if ((i12 & 7) == 0) {
            i12 |= 8388611;
        }
        if ((i12 & 112) == 0) {
            i12 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i12, i);
        int i13 = absoluteGravity & 7;
        int i14 = absoluteGravity & 112;
        int i15 = absoluteGravity2 & 7;
        int i16 = absoluteGravity2 & 112;
        int iWidth = i15 != 1 ? i15 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i16 != 16 ? i16 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i13 == 1) {
            iWidth -= i3 / 2;
        } else if (i13 != 5) {
            iWidth -= i3;
        }
        if (i14 == 16) {
            iHeight -= i10 / 2;
        } else if (i14 != 80) {
            iHeight -= i10;
        }
        rect2.set(iWidth, iHeight, i3 + iWidth, i10 + iHeight);
    }

    public static b3.d y(View view) {
        b3.d dVar = (b3.d) view.getLayoutParams();
        if (!dVar.f1878b) {
            if (view instanceof com.google.android.material.appbar.g) {
                b3.a behavior = ((com.google.android.material.appbar.g) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                b3.a aVar = dVar.f1877a;
                if (aVar != behavior) {
                    if (aVar != null) {
                        aVar.onDetachedFromLayoutParams();
                    }
                    dVar.f1877a = behavior;
                    dVar.f1893r = null;
                    dVar.f1878b = true;
                    if (behavior != null) {
                        behavior.onAttachedToLayoutParams(dVar);
                    }
                }
                dVar.f1878b = true;
                return dVar;
            }
            b bVar = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                bVar = (b) superclass.getAnnotation(b.class);
                if (bVar != null) {
                    break;
                }
            }
            if (bVar != null) {
                try {
                    b3.a aVar2 = (b3.a) bVar.value().getDeclaredConstructor(null).newInstance(null);
                    b3.a aVar3 = dVar.f1877a;
                    if (aVar3 != aVar2) {
                        if (aVar3 != null) {
                            aVar3.onDetachedFromLayoutParams();
                        }
                        dVar.f1877a = aVar2;
                        dVar.f1893r = null;
                        dVar.f1878b = true;
                        if (aVar2 != null) {
                            aVar2.onAttachedToLayoutParams(dVar);
                        }
                    }
                } catch (Exception e10) {
                    Log.e("CoordinatorLayout", "Default behavior class " + bVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e10);
                }
            }
            dVar.f1878b = true;
        }
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(int r23) {
        /*
            Method dump skipped, instructions count: 735
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.a.A(int):void");
    }

    public final void B(int i, View view) {
        Rect rectS;
        Rect rectS2;
        b3.d dVar = (b3.d) view.getLayoutParams();
        View view2 = dVar.f1886k;
        if (view2 == null && dVar.f1882f != -1) {
            f.e("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
            return;
        }
        d dVar2 = B;
        if (view2 != null) {
            rectS = s();
            rectS2 = s();
            try {
                b3.f.a(this, view2, rectS);
                b3.d dVar3 = (b3.d) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                w(i, rectS, rectS2, dVar3, measuredWidth, measuredHeight);
                t(dVar3, rectS2, measuredWidth, measuredHeight);
                view.layout(rectS2.left, rectS2.top, rectS2.right, rectS2.bottom);
                return;
            } finally {
                rectS.setEmpty();
                dVar2.a(rectS);
                rectS2.setEmpty();
                dVar2.a(rectS2);
            }
        }
        int i3 = dVar.f1881e;
        if (i3 < 0) {
            b3.d dVar4 = (b3.d) view.getLayoutParams();
            rectS = s();
            rectS.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar4).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar4).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) dVar4).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) dVar4).bottomMargin);
            if (this.f1027r != null) {
                WeakHashMap weakHashMap = k0.f8724a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    rectS.left = this.f1027r.b() + rectS.left;
                    rectS.top = this.f1027r.d() + rectS.top;
                    rectS.right -= this.f1027r.c();
                    rectS.bottom -= this.f1027r.a();
                }
            }
            rectS2 = s();
            int i10 = dVar4.f1879c;
            if ((i10 & 7) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            Gravity.apply(i10, view.getMeasuredWidth(), view.getMeasuredHeight(), rectS, rectS2, i);
            view.layout(rectS2.left, rectS2.top, rectS2.right, rectS2.bottom);
            return;
        }
        b3.d dVar5 = (b3.d) view.getLayoutParams();
        int i11 = dVar5.f1879c;
        if (i11 == 0) {
            i11 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i11, i);
        int i12 = absoluteGravity & 7;
        int i13 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i == 1) {
            i3 = width - i3;
        }
        int iX = x(i3) - measuredWidth2;
        if (i12 == 1) {
            iX += measuredWidth2 / 2;
        } else if (i12 == 5) {
            iX += measuredWidth2;
        }
        int i14 = i13 != 16 ? i13 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar5).leftMargin, Math.min(iX, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) dVar5).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar5).topMargin, Math.min(i14, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) dVar5).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
    }

    public final void C(View view, int i, int i3, int i10, int i11) {
        measureChildWithMargins(view, i, i3, i10, i11);
    }

    public final boolean D(b3.a aVar, View view, MotionEvent motionEvent, int i) {
        if (i == 0) {
            return aVar.onInterceptTouchEvent(this, view, motionEvent);
        }
        if (i == 1) {
            return aVar.onTouchEvent(this, view, motionEvent);
        }
        f.b();
        return false;
    }

    public final boolean E(MotionEvent motionEvent, int i) {
        boolean z10;
        boolean zBlocksInteractionBelow;
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f1017g;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i3) : i3));
        }
        n nVar = A;
        if (nVar != null) {
            Collections.sort(arrayList, nVar);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        int i10 = 0;
        boolean zD = false;
        boolean z11 = false;
        while (i10 < size) {
            View view = (View) arrayList.get(i10);
            b3.d dVar = (b3.d) view.getLayoutParams();
            b3.a aVar = dVar.f1877a;
            if (!(zD || z11) || actionMasked == 0) {
                if (!z11 && !zD && aVar != null) {
                    zD = D(aVar, view, motionEvent, i);
                    if (zD) {
                        this.f1023n = view;
                        if (actionMasked != 3 && actionMasked != 1) {
                            for (int i11 = 0; i11 < i10; i11++) {
                                View view2 = (View) arrayList.get(i11);
                                b3.a aVar2 = ((b3.d) view2.getLayoutParams()).f1877a;
                                if (aVar2 != null) {
                                    if (motionEventObtain == null) {
                                        motionEventObtain = MotionEvent.obtain(motionEvent);
                                        motionEventObtain.setAction(3);
                                    }
                                    D(aVar2, view2, motionEventObtain, i);
                                }
                            }
                        }
                    }
                }
                b3.a aVar3 = dVar.f1877a;
                if (aVar3 == null) {
                    dVar.f1888m = false;
                }
                boolean z12 = dVar.f1888m;
                if (z12) {
                    zBlocksInteractionBelow = true;
                } else {
                    zBlocksInteractionBelow = (aVar3 != null ? aVar3.blocksInteractionBelow(this, view) : false) | z12;
                    dVar.f1888m = zBlocksInteractionBelow;
                }
                z10 = zBlocksInteractionBelow && !z12;
                if (zBlocksInteractionBelow && !z10) {
                    break;
                }
            } else {
                if (aVar != null) {
                    if (motionEventObtain == null) {
                        motionEventObtain = MotionEvent.obtain(motionEvent);
                        motionEventObtain.setAction(3);
                    }
                    D(aVar, view, motionEventObtain, i);
                }
                z10 = z11;
            }
            i10++;
            z11 = z10;
        }
        arrayList.clear();
        if (motionEventObtain != null) {
            motionEventObtain.recycle();
        }
        return zD;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F() {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.a.F():void");
    }

    public final void H() {
        View view = this.f1023n;
        if (view != null) {
            b3.a aVar = ((b3.d) view.getLayoutParams()).f1877a;
            if (aVar != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                aVar.onTouchEvent(this, this.f1023n, motionEventObtain);
                motionEventObtain.recycle();
            }
            this.f1023n = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((b3.d) getChildAt(i).getLayoutParams()).f1888m = false;
        }
        this.f1020k = false;
    }

    public final void K() {
        WeakHashMap weakHashMap = k0.f8724a;
        if (!getFitsSystemWindows()) {
            e0.b(this, null);
            return;
        }
        if (this.f1031v == null) {
            g gVar = new g(3, false);
            gVar.f19f = this;
            VarHandle.storeStoreFence();
            this.f1031v = gVar;
        }
        e0.b(this, this.f1031v);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof b3.d) && super.checkLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0091  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean drawChild(android.graphics.Canvas r17, android.view.View r18, long r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            b3.d r2 = (b3.d) r2
            b3.a r3 = r2.f1877a
            if (r3 == 0) goto L91
            float r3 = r3.getScrimOpacity(r0, r1)
            r4 = 0
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L91
            android.graphics.Paint r4 = r0.f1018h
            if (r4 != 0) goto L22
            android.graphics.Paint r4 = new android.graphics.Paint
            r4.<init>()
            r0.f1018h = r4
        L22:
            android.graphics.Paint r4 = r0.f1018h
            b3.a r2 = r2.f1877a
            int r2 = r2.getScrimColor(r0, r1)
            r4.setColor(r2)
            android.graphics.Paint r2 = r0.f1018h
            r4 = 1132396544(0x437f0000, float:255.0)
            float r3 = r3 * r4
            int r3 = java.lang.Math.round(r3)
            if (r3 >= 0) goto L3a
            r3 = 0
            goto L3f
        L3a:
            r4 = 255(0xff, float:3.57E-43)
            if (r3 <= r4) goto L3f
            r3 = r4
        L3f:
            r2.setAlpha(r3)
            int r2 = r17.save()
            boolean r3 = r1.isOpaque()
            if (r3 == 0) goto L67
            int r3 = r1.getLeft()
            float r5 = (float) r3
            int r3 = r1.getTop()
            float r6 = (float) r3
            int r3 = r1.getRight()
            float r7 = (float) r3
            int r3 = r1.getBottom()
            float r8 = (float) r3
            android.graphics.Region$Op r9 = android.graphics.Region.Op.DIFFERENCE
            r4 = r17
            r4.clipRect(r5, r6, r7, r8, r9)
        L67:
            int r3 = r0.getPaddingLeft()
            float r11 = (float) r3
            int r3 = r0.getPaddingTop()
            float r12 = (float) r3
            int r3 = r0.getWidth()
            int r4 = r0.getPaddingRight()
            int r3 = r3 - r4
            float r13 = (float) r3
            int r3 = r0.getHeight()
            int r4 = r0.getPaddingBottom()
            int r3 = r3 - r4
            float r14 = (float) r3
            android.graphics.Paint r15 = r0.f1018h
            r10 = r17
            r10.drawRect(r11, r12, r13, r14, r15)
            r4 = r10
            r4.restoreToCount(r2)
            goto L93
        L91:
            r4 = r17
        L93:
            boolean r0 = super.drawChild(r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.a.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1029t;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        b3.d dVar = new b3.d(-2, -2);
        dVar.f1878b = false;
        dVar.f1879c = 0;
        dVar.f1880d = 0;
        dVar.f1881e = -1;
        dVar.f1882f = -1;
        dVar.f1883g = 0;
        dVar.f1884h = 0;
        dVar.f1892q = new Rect();
        VarHandle.storeStoreFence();
        return dVar;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) throws NoSuchMethodException, SecurityException {
        Context context = getContext();
        b3.d dVar = new b3.d(context, attributeSet);
        dVar.f1878b = false;
        dVar.f1879c = 0;
        dVar.f1880d = 0;
        dVar.f1881e = -1;
        dVar.f1882f = -1;
        dVar.f1883g = 0;
        dVar.f1884h = 0;
        dVar.f1892q = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a3.a.f153b);
        dVar.f1879c = typedArrayObtainStyledAttributes.getInteger(0, 0);
        dVar.f1882f = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        dVar.f1880d = typedArrayObtainStyledAttributes.getInteger(2, 0);
        dVar.f1881e = typedArrayObtainStyledAttributes.getInteger(6, -1);
        dVar.f1883g = typedArrayObtainStyledAttributes.getInt(5, 0);
        dVar.f1884h = typedArrayObtainStyledAttributes.getInt(4, 0);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(3);
        dVar.f1878b = zHasValue;
        if (zHasValue) {
            String string = typedArrayObtainStyledAttributes.getString(3);
            b3.a aVar = null;
            if (!TextUtils.isEmpty(string)) {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str = f1012x;
                    if (!TextUtils.isEmpty(str)) {
                        string = str + '.' + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = f1014z;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(f1013y);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    aVar = (b3.a) constructor.newInstance(context, attributeSet);
                } catch (Exception e10) {
                    f.g("Could not inflate Behavior subclass ".concat(string), e10);
                    return null;
                }
            }
            dVar.f1877a = aVar;
        }
        typedArrayObtainStyledAttributes.recycle();
        b3.a aVar2 = dVar.f1877a;
        if (aVar2 != null) {
            aVar2.onAttachedToLayoutParams(dVar);
        }
        return dVar;
    }

    public final List<View> getDependencySortedChildren() {
        F();
        return Collections.unmodifiableList(this.f1015c);
    }

    public final m1 getLastWindowInsets() {
        return this.f1027r;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        l0 l0Var = this.f1032w;
        return l0Var.f5053b | l0Var.f5052a;
    }

    public Drawable getStatusBarBackground() {
        return this.f1029t;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    @Override // n3.q
    public final void j(int i, View view) {
        l0 l0Var = this.f1032w;
        if (i == 1) {
            l0Var.f5053b = 0;
        } else {
            l0Var.f5052a = 0;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            b3.d dVar = (b3.d) childAt.getLayoutParams();
            if (dVar.a(i)) {
                b3.a aVar = dVar.f1877a;
                if (aVar != null) {
                    aVar.onStopNestedScroll(this, childAt, view, i);
                }
                if (i == 0) {
                    dVar.f1889n = false;
                } else if (i == 1) {
                    dVar.f1890o = false;
                }
                dVar.f1891p = false;
            }
        }
        this.f1024o = null;
    }

    @Override // n3.r
    public final void k(View view, int i, int i3, int i10, int i11, int i12, int[] iArr) {
        b3.a aVar;
        int childCount = getChildCount();
        boolean z10 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                b3.d dVar = (b3.d) childAt.getLayoutParams();
                if (dVar.a(i12) && (aVar = dVar.f1877a) != null) {
                    int[] iArr2 = this.i;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    aVar.onNestedScroll(this, childAt, view, i, i3, i10, i11, i12, iArr2);
                    int[] iArr3 = this.i;
                    iMax = i10 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    iMax2 = i11 > 0 ? Math.max(iMax2, iArr3[1]) : Math.min(iMax2, iArr3[1]);
                    z10 = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z10) {
            A(1);
        }
    }

    @Override // n3.q
    public final void l(View view, int i, int i3, int i10, int i11, int i12) {
        k(view, i, i3, i10, i11, 0, this.f1019j);
    }

    @Override // n3.q
    public final boolean m(View view, View view2, int i, int i3) {
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                b3.d dVar = (b3.d) childAt.getLayoutParams();
                b3.a aVar = dVar.f1877a;
                if (aVar != null) {
                    boolean zOnStartNestedScroll = aVar.onStartNestedScroll(this, childAt, view, view2, i, i3);
                    z10 |= zOnStartNestedScroll;
                    if (i3 == 0) {
                        dVar.f1889n = zOnStartNestedScroll;
                    } else if (i3 == 1) {
                        dVar.f1890o = zOnStartNestedScroll;
                    }
                } else if (i3 == 0) {
                    dVar.f1889n = false;
                } else if (i3 == 1) {
                    dVar.f1890o = false;
                }
            }
        }
        return z10;
    }

    @Override // n3.q
    public final void n(View view, View view2, int i, int i3) {
        b3.a aVar;
        a aVar2;
        View view3;
        View view4;
        int i10;
        int i11;
        l0 l0Var = this.f1032w;
        if (i3 == 1) {
            l0Var.f5053b = i;
        } else {
            l0Var.f5052a = i;
        }
        this.f1024o = view2;
        int childCount = getChildCount();
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = this.getChildAt(i12);
            b3.d dVar = (b3.d) childAt.getLayoutParams();
            if (dVar.a(i3) && (aVar = dVar.f1877a) != null) {
                aVar2 = this;
                view3 = view;
                view4 = view2;
                i10 = i;
                i11 = i3;
                aVar.onNestedScrollAccepted(aVar2, childAt, view3, view4, i10, i11);
            } else {
                aVar2 = this;
                view3 = view;
                view4 = view2;
                i10 = i;
                i11 = i3;
            }
            i12++;
            this = aVar2;
            view = view3;
            view2 = view4;
            i = i10;
            i3 = i11;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        H();
        if (this.f1026q) {
            if (this.f1025p == null) {
                this.f1025p = new l(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1025p);
        }
        if (this.f1027r == null) {
            WeakHashMap weakHashMap = k0.f8724a;
            if (getFitsSystemWindows()) {
                requestApplyInsets();
            }
        }
        this.f1021l = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        H();
        if (this.f1026q && this.f1025p != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1025p);
        }
        View view = this.f1024o;
        if (view != null) {
            j(0, view);
        }
        this.f1021l = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f1028s || this.f1029t == null) {
            return;
        }
        m1 m1Var = this.f1027r;
        int iD = m1Var != null ? m1Var.d() : 0;
        if (iD > 0) {
            this.f1029t.setBounds(0, 0, getWidth(), iD);
            this.f1029t.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            H();
        }
        boolean zE = E(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zE;
        }
        this.f1023n = null;
        H();
        return zE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i, int i3, int i10, int i11) {
        b3.a aVar;
        WeakHashMap weakHashMap = k0.f8724a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.f1015c;
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            View view = (View) arrayList.get(i12);
            if (view.getVisibility() != 8 && ((aVar = ((b3.d) view.getLayoutParams()).f1877a) == null || !aVar.onLayoutChild(this, view, layoutDirection))) {
                B(layoutDirection, view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0193  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r28, int r29) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.a.onMeasure(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0015  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onNestedFling(android.view.View r12, float r13, float r14, boolean r15) {
        /*
            r11 = this;
            int r0 = r11.getChildCount()
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            if (r2 >= r0) goto L3e
            android.view.View r6 = r11.getChildAt(r2)
            int r4 = r6.getVisibility()
            r5 = 8
            if (r4 != r5) goto L1b
        L15:
            r5 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r10 = r15
            goto L36
        L1b:
            android.view.ViewGroup$LayoutParams r4 = r6.getLayoutParams()
            b3.d r4 = (b3.d) r4
            boolean r5 = r4.a(r1)
            if (r5 != 0) goto L28
            goto L15
        L28:
            b3.a r4 = r4.f1877a
            if (r4 == 0) goto L15
            r5 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r10 = r15
            boolean r11 = r4.onNestedFling(r5, r6, r7, r8, r9, r10)
            r3 = r3 | r11
        L36:
            int r2 = r2 + 1
            r11 = r5
            r12 = r7
            r13 = r8
            r14 = r9
            r15 = r10
            goto L7
        L3e:
            r5 = r11
            if (r3 == 0) goto L45
            r11 = 1
            r5.A(r11)
        L45:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.a.onNestedFling(android.view.View, float, float, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0015  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onNestedPreFling(android.view.View r11, float r12, float r13) {
        /*
            r10 = this;
            int r0 = r10.getChildCount()
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            if (r2 >= r0) goto L3b
            android.view.View r6 = r10.getChildAt(r2)
            int r4 = r6.getVisibility()
            r5 = 8
            if (r4 != r5) goto L1a
        L15:
            r5 = r10
            r7 = r11
            r8 = r12
            r9 = r13
            goto L34
        L1a:
            android.view.ViewGroup$LayoutParams r4 = r6.getLayoutParams()
            b3.d r4 = (b3.d) r4
            boolean r5 = r4.a(r1)
            if (r5 != 0) goto L27
            goto L15
        L27:
            b3.a r4 = r4.f1877a
            if (r4 == 0) goto L15
            r5 = r10
            r7 = r11
            r8 = r12
            r9 = r13
            boolean r10 = r4.onNestedPreFling(r5, r6, r7, r8, r9)
            r3 = r3 | r10
        L34:
            int r2 = r2 + 1
            r10 = r5
            r11 = r7
            r12 = r8
            r13 = r9
            goto L7
        L3b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.a.onNestedPreFling(android.view.View, float, float):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i3, int[] iArr) {
        q(view, i, i3, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i3, int i10, int i11) {
        l(view, i, i3, i10, i11, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        n(view, view2, i, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        SparseArray sparseArray = eVar.f1894c;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id2 = childAt.getId();
            b3.a aVar = y(childAt).f1877a;
            if (id2 != -1 && aVar != null && (parcelable2 = (Parcelable) sparseArray.get(id2)) != null) {
                aVar.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState;
        e eVar = new e(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id2 = childAt.getId();
            b3.a aVar = ((b3.d) childAt.getLayoutParams()).f1877a;
            if (id2 != -1 && aVar != null && (parcelableOnSaveInstanceState = aVar.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id2, parcelableOnSaveInstanceState);
            }
        }
        eVar.f1894c = sparseArray;
        return eVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return m(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        j(0, view);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zE;
        int actionMasked = motionEvent.getActionMasked();
        View view = this.f1023n;
        boolean z10 = false;
        if (view != null) {
            b3.a aVar = ((b3.d) view.getLayoutParams()).f1877a;
            zE = aVar != null ? aVar.onTouchEvent(this, this.f1023n, motionEvent) : false;
        } else {
            zE = E(motionEvent, 1);
            if (actionMasked != 0 && zE) {
                z10 = true;
            }
        }
        if (this.f1023n == null || actionMasked == 3) {
            zE |= super.onTouchEvent(motionEvent);
        } else if (z10) {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            motionEventObtain.setAction(3);
            super.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return zE;
        }
        this.f1023n = null;
        H();
        return zE;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        b3.a aVar = ((b3.d) view.getLayoutParams()).f1877a;
        if (aVar == null || !aVar.onRequestChildRectangleOnScreen(this, view, rect, z10)) {
            return super.requestChildRectangleOnScreen(view, rect, z10);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (!z10 || this.f1020k) {
            return;
        }
        if (this.f1023n == null) {
            int childCount = getChildCount();
            MotionEvent motionEventObtain = null;
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                b3.a aVar = ((b3.d) childAt.getLayoutParams()).f1877a;
                if (aVar != null) {
                    if (motionEventObtain == null) {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    aVar.onInterceptTouchEvent(this, childAt, motionEventObtain);
                }
            }
            if (motionEventObtain != null) {
                motionEventObtain.recycle();
            }
        }
        H();
        this.f1020k = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z10) {
        super.setFitsSystemWindows(z10);
        K();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f1030u = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f1029t;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f1029t = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f1029t.setState(getDrawableState());
                }
                Drawable drawable3 = this.f1029t;
                WeakHashMap weakHashMap = k0.f8724a;
                drawable3.setLayoutDirection(getLayoutDirection());
                this.f1029t.setVisible(getVisibility() == 0, false);
                this.f1029t.setCallback(this);
            }
            WeakHashMap weakHashMap2 = k0.f8724a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? getContext().getDrawable(i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z10 = i == 0;
        Drawable drawable = this.f1029t;
        if (drawable == null || drawable.isVisible() == z10) {
            return;
        }
        this.f1029t.setVisible(z10, false);
    }

    public final void t(b3.d dVar, Rect rect, int i, int i3) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i3) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin));
        rect.set(iMax, iMax2, i + iMax, i3 + iMax2);
    }

    public final void u(View view, Rect rect, boolean z10) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z10) {
            b3.f.a(this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final List v(View view) {
        p0 p0Var = (p0) this.f1016f.f9731f;
        int i = p0Var.f9610g;
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < i; i3++) {
            ArrayList arrayList2 = (ArrayList) p0Var.h(i3);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(p0Var.e(i3));
            }
        }
        return arrayList == null ? Collections.EMPTY_LIST : arrayList;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1029t;
    }

    public final int x(int i) {
        int[] iArr = this.f1022m;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i >= 0 && i < iArr.length) {
            return iArr[i];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
        return 0;
    }

    public final boolean z(View view, int i, int i3) {
        Rect rectS = s();
        b3.f.a(this, view, rectS);
        try {
            return rectS.contains(i, i3);
        } finally {
            G(rectS);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof b3.d) {
            b3.d dVar = new b3.d((b3.d) layoutParams);
            dVar.f1878b = false;
            dVar.f1879c = 0;
            dVar.f1880d = 0;
            dVar.f1881e = -1;
            dVar.f1882f = -1;
            dVar.f1883g = 0;
            dVar.f1884h = 0;
            dVar.f1892q = new Rect();
            VarHandle.storeStoreFence();
            return dVar;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            b3.d dVar2 = new b3.d((ViewGroup.MarginLayoutParams) layoutParams);
            dVar2.f1878b = false;
            dVar2.f1879c = 0;
            dVar2.f1880d = 0;
            dVar2.f1881e = -1;
            dVar2.f1882f = -1;
            dVar2.f1883g = 0;
            dVar2.f1884h = 0;
            dVar2.f1892q = new Rect();
            VarHandle.storeStoreFence();
            return dVar2;
        }
        b3.d dVar3 = new b3.d(layoutParams);
        dVar3.f1878b = false;
        dVar3.f1879c = 0;
        dVar3.f1880d = 0;
        dVar3.f1881e = -1;
        dVar3.f1882f = -1;
        dVar3.f1883g = 0;
        dVar3.f1884h = 0;
        dVar3.f1892q = new Rect();
        VarHandle.storeStoreFence();
        return dVar3;
    }
}
