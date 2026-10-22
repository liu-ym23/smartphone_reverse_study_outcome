package androidx.coordinatorlayout.widget;

import A.b;
import A.c;
import A.e;
import A.f;
import A.g;
import J.d;
import K.H;
import K.InterfaceC0086s;
import K.InterfaceC0087t;
import K.J;
import K.S;
import K.z0;
import a.C0152a;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.customview.view.AbsSavedState;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import d.C0527a;
import e.EnumC0546d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;
import q.l;
import z.AbstractC0992a;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements InterfaceC0086s, InterfaceC0087t {

    /* renamed from: u, reason: collision with root package name */
    public static final String f3246u;

    /* renamed from: v, reason: collision with root package name */
    public static final Class[] f3247v;

    /* renamed from: w, reason: collision with root package name */
    public static final ThreadLocal f3248w;

    /* renamed from: x, reason: collision with root package name */
    public static final f f3249x;

    /* renamed from: y, reason: collision with root package name */
    public static final d f3250y;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3251a;

    /* renamed from: b, reason: collision with root package name */
    public final t.d f3252b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f3253c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f3254d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f3255e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f3256f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f3257g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3258h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3259i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f3260j;

    /* renamed from: k, reason: collision with root package name */
    public View f3261k;

    /* renamed from: l, reason: collision with root package name */
    public View f3262l;

    /* renamed from: m, reason: collision with root package name */
    public e f3263m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3264n;

    /* renamed from: o, reason: collision with root package name */
    public z0 f3265o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3266p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f3267q;

    /* renamed from: r, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f3268r;

    /* renamed from: s, reason: collision with root package name */
    public C0527a f3269s;

    /* renamed from: t, reason: collision with root package name */
    public final C0152a f3270t;

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface DefaultBehavior {
        Class<? extends b> value();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12494c})
    public @interface DispatchChangeEvent {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public SparseArray f3271a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i4 = parcel.readInt();
            int[] iArr = new int[i4];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f3271a = new SparseArray(i4);
            for (int i5 = 0; i5 < i4; i5++) {
                this.f3271a.append(iArr[i5], parcelableArray[i5]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            SparseArray sparseArray = this.f3271a;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i5 = 0; i5 < size; i5++) {
                iArr[i5] = this.f3271a.keyAt(i5);
                parcelableArr[i5] = (Parcelable) this.f3271a.valueAt(i5);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i4);
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f3246u = r02 != null ? r02.getName() : null;
        f3249x = new f(0);
        f3247v = new Class[]{Context.class, AttributeSet.class};
        f3248w = new ThreadLocal();
        f3250y = new d();
    }

    public CoordinatorLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    public static void F(Rect rect) {
        rect.setEmpty();
        f3250y.a(rect);
    }

    public static void H(int i4, View view) {
        A.d dVar = (A.d) view.getLayoutParams();
        int i5 = dVar.f13i;
        if (i5 != i4) {
            WeakHashMap weakHashMap = S.f939a;
            view.offsetLeftAndRight(i4 - i5);
            dVar.f13i = i4;
        }
    }

    public static void I(int i4, View view) {
        A.d dVar = (A.d) view.getLayoutParams();
        int i5 = dVar.f14j;
        if (i5 != i4) {
            WeakHashMap weakHashMap = S.f939a;
            view.offsetTopAndBottom(i4 - i5);
            dVar.f14j = i4;
        }
    }

    public static Rect s() {
        Rect rect = (Rect) f3250y.b();
        return rect == null ? new Rect() : rect;
    }

    public static void w(int i4, Rect rect, Rect rect2, A.d dVar, int i5, int i6) {
        int i7 = dVar.f7c;
        if (i7 == 0) {
            i7 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i7, i4);
        int i8 = dVar.f8d;
        if ((i8 & 7) == 0) {
            i8 |= 8388611;
        }
        if ((i8 & 112) == 0) {
            i8 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i8, i4);
        int i9 = absoluteGravity & 7;
        int i10 = absoluteGravity & 112;
        int i11 = absoluteGravity2 & 7;
        int i12 = absoluteGravity2 & 112;
        int iWidth = i11 != 1 ? i11 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i12 != 16 ? i12 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i9 == 1) {
            iWidth -= i5 / 2;
        } else if (i9 != 5) {
            iWidth -= i5;
        }
        if (i10 == 16) {
            iHeight -= i6 / 2;
        } else if (i10 != 80) {
            iHeight -= i6;
        }
        rect2.set(iWidth, iHeight, i5 + iWidth, i6 + iHeight);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static A.d y(View view) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        A.d dVar = (A.d) view.getLayoutParams();
        if (!dVar.f6b) {
            if (view instanceof A.a) {
                b behavior = ((A.a) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                b bVar = dVar.f5a;
                if (bVar != behavior) {
                    if (bVar != null) {
                        bVar.onDetachedFromLayoutParams();
                    }
                    dVar.f5a = behavior;
                    dVar.f22r = null;
                    dVar.f6b = true;
                    if (behavior != null) {
                        behavior.onAttachedToLayoutParams(dVar);
                    }
                }
                dVar.f6b = true;
            } else {
                DefaultBehavior defaultBehavior = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    defaultBehavior = (DefaultBehavior) superclass.getAnnotation(DefaultBehavior.class);
                    if (defaultBehavior != null) {
                        break;
                    }
                }
                if (defaultBehavior != null) {
                    try {
                        b bVarNewInstance = defaultBehavior.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                        b bVar2 = dVar.f5a;
                        if (bVar2 != bVarNewInstance) {
                            if (bVar2 != null) {
                                bVar2.onDetachedFromLayoutParams();
                            }
                            dVar.f5a = bVarNewInstance;
                            dVar.f22r = null;
                            dVar.f6b = true;
                            if (bVarNewInstance != null) {
                                bVarNewInstance.onAttachedToLayoutParams(dVar);
                            }
                        }
                    } catch (Exception e4) {
                        Log.e("CoordinatorLayout", "Default behavior class " + defaultBehavior.value().getName() + " could not be instantiated. Did you forget a default constructor?", e4);
                    }
                }
                dVar.f6b = true;
            }
        }
        return dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ea  */
    /* JADX WARN: Type inference failed for: r13v10, types: [J.d] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(int r26) {
        /*
            Method dump skipped, instructions count: 776
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.A(int):void");
    }

    public final void B(int i4, View view) {
        Rect rectS;
        Rect rectS2;
        A.d dVar = (A.d) view.getLayoutParams();
        View view2 = dVar.f15k;
        if (view2 == null && dVar.f10f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        d dVar2 = f3250y;
        if (view2 != null) {
            rectS = s();
            rectS2 = s();
            try {
                g.a(this, view2, rectS);
                A.d dVar3 = (A.d) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                w(i4, rectS, rectS2, dVar3, measuredWidth, measuredHeight);
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
        int i5 = dVar.f9e;
        if (i5 < 0) {
            A.d dVar4 = (A.d) view.getLayoutParams();
            rectS = s();
            rectS.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar4).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar4).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) dVar4).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) dVar4).bottomMargin);
            if (this.f3265o != null) {
                WeakHashMap weakHashMap = S.f939a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    rectS.left = this.f3265o.b() + rectS.left;
                    rectS.top = this.f3265o.d() + rectS.top;
                    rectS.right -= this.f3265o.c();
                    rectS.bottom -= this.f3265o.a();
                }
            }
            rectS2 = s();
            int i6 = dVar4.f7c;
            if ((i6 & 7) == 0) {
                i6 |= 8388611;
            }
            if ((i6 & 112) == 0) {
                i6 |= 48;
            }
            Gravity.apply(i6, view.getMeasuredWidth(), view.getMeasuredHeight(), rectS, rectS2, i4);
            view.layout(rectS2.left, rectS2.top, rectS2.right, rectS2.bottom);
            return;
        }
        A.d dVar5 = (A.d) view.getLayoutParams();
        int i7 = dVar5.f7c;
        if (i7 == 0) {
            i7 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i7, i4);
        int i8 = absoluteGravity & 7;
        int i9 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i4 == 1) {
            i5 = width - i5;
        }
        int iX = x(i5) - measuredWidth2;
        if (i8 == 1) {
            iX += measuredWidth2 / 2;
        } else if (i8 == 5) {
            iX += measuredWidth2;
        }
        int i10 = i9 != 16 ? i9 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar5).leftMargin, Math.min(iX, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) dVar5).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar5).topMargin, Math.min(i10, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) dVar5).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
    }

    public final void C(View view, int i4, int i5, int i6, int i7) {
        measureChildWithMargins(view, i4, i5, i6, i7);
    }

    public final boolean D(MotionEvent motionEvent, int i4) {
        boolean zBlocksInteractionBelow;
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f3253c;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i5 = childCount - 1; i5 >= 0; i5--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i5) : i5));
        }
        f fVar = f3249x;
        if (fVar != null) {
            Collections.sort(arrayList, fVar);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zOnInterceptTouchEvent = false;
        boolean z4 = false;
        for (int i6 = 0; i6 < size; i6++) {
            View view = (View) arrayList.get(i6);
            A.d dVar = (A.d) view.getLayoutParams();
            b bVar = dVar.f5a;
            if (!(zOnInterceptTouchEvent || z4) || actionMasked == 0) {
                if (!zOnInterceptTouchEvent && bVar != null) {
                    if (i4 == 0) {
                        zOnInterceptTouchEvent = bVar.onInterceptTouchEvent(this, view, motionEvent);
                    } else if (i4 == 1) {
                        zOnInterceptTouchEvent = bVar.onTouchEvent(this, view, motionEvent);
                    }
                    if (zOnInterceptTouchEvent) {
                        this.f3261k = view;
                    }
                }
                b bVar2 = dVar.f5a;
                if (bVar2 == null) {
                    dVar.f17m = false;
                }
                boolean z5 = dVar.f17m;
                if (z5) {
                    zBlocksInteractionBelow = true;
                } else {
                    zBlocksInteractionBelow = (bVar2 != null ? bVar2.blocksInteractionBelow(this, view) : false) | z5;
                    dVar.f17m = zBlocksInteractionBelow;
                }
                boolean z6 = zBlocksInteractionBelow && !z5;
                if (zBlocksInteractionBelow && !z6) {
                    break;
                }
                z4 = z6;
            } else if (bVar != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 0);
                }
                if (i4 == 0) {
                    bVar.onInterceptTouchEvent(this, view, motionEventObtain);
                } else if (i4 == 1) {
                    bVar.onTouchEvent(this, view, motionEventObtain);
                }
            }
        }
        arrayList.clear();
        return zOnInterceptTouchEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E() throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.E():void");
    }

    public final void G(boolean z4) {
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            b bVar = ((A.d) childAt.getLayoutParams()).f5a;
            if (bVar != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE, 0);
                if (z4) {
                    bVar.onInterceptTouchEvent(this, childAt, motionEventObtain);
                } else {
                    bVar.onTouchEvent(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            ((A.d) getChildAt(i5).getLayoutParams()).f17m = false;
        }
        this.f3261k = null;
        this.f3258h = false;
    }

    public final void J() {
        WeakHashMap weakHashMap = S.f939a;
        if (!getFitsSystemWindows()) {
            J.u(this, null);
            return;
        }
        if (this.f3269s == null) {
            this.f3269s = new C0527a(9, this);
        }
        J.u(this, this.f3269s);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof A.d) && super.checkLayoutParams(layoutParams);
    }

    @Override // K.InterfaceC0086s
    public final void d(View view, View view2, int i4, int i5) {
        b bVar;
        C0152a c0152a = this.f3270t;
        if (i5 == 1) {
            c0152a.f2262b = i4;
        } else {
            c0152a.f2261a = i4;
        }
        this.f3262l = view2;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            A.d dVar = (A.d) childAt.getLayoutParams();
            if (dVar.a(i5) && (bVar = dVar.f5a) != null) {
                bVar.onNestedScrollAccepted(this, childAt, view, view2, i4, i5);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        A.d dVar = (A.d) view.getLayoutParams();
        b bVar = dVar.f5a;
        if (bVar != null) {
            float scrimOpacity = bVar.getScrimOpacity(this, view);
            if (scrimOpacity > Property.DEFAULT_FLOAT_VALUE) {
                if (this.f3255e == null) {
                    this.f3255e = new Paint();
                }
                this.f3255e.setColor(dVar.f5a.getScrimColor(this, view));
                Paint paint = this.f3255e;
                int iRound = Math.round(scrimOpacity * 255.0f);
                if (iRound < 0) {
                    iRound = 0;
                } else if (iRound > 255) {
                    iRound = 255;
                }
                paint.setAlpha(iRound);
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f3255e);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f3267q;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new A.d();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new A.d(getContext(), attributeSet);
    }

    @VisibleForTesting
    public final List<View> getDependencySortedChildren() throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        E();
        return Collections.unmodifiableList(this.f3251a);
    }

    @RestrictTo({EnumC0546d.f12494c})
    public final z0 getLastWindowInsets() {
        return this.f3265o;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C0152a c0152a = this.f3270t;
        return c0152a.f2262b | c0152a.f2261a;
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.f3267q;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    @Override // K.InterfaceC0086s
    public void i(View view, int i4, int i5, int[] iArr, int i6) {
        b bVar;
        int childCount = getChildCount();
        boolean z4 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                A.d dVar = (A.d) childAt.getLayoutParams();
                if (dVar.a(i6) && (bVar = dVar.f5a) != null) {
                    int[] iArr2 = this.f3256f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    bVar.onNestedPreScroll(this, childAt, view, i4, i5, iArr2, i6);
                    int[] iArr3 = this.f3256f;
                    iMax = i4 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    iMax2 = i5 > 0 ? Math.max(iMax2, iArr3[1]) : Math.min(iMax2, iArr3[1]);
                    z4 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z4) {
            A(1);
        }
    }

    @Override // K.InterfaceC0086s
    public final void n(int i4, View view) {
        C0152a c0152a = this.f3270t;
        if (i4 == 1) {
            c0152a.f2262b = 0;
        } else {
            c0152a.f2261a = 0;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            A.d dVar = (A.d) childAt.getLayoutParams();
            if (dVar.a(i4)) {
                b bVar = dVar.f5a;
                if (bVar != null) {
                    bVar.onStopNestedScroll(this, childAt, view, i4);
                }
                if (i4 == 0) {
                    dVar.f18n = false;
                } else if (i4 == 1) {
                    dVar.f19o = false;
                }
                dVar.f20p = false;
            }
        }
        this.f3262l = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i4 = 0;
        G(false);
        if (this.f3264n) {
            if (this.f3263m == null) {
                this.f3263m = new e(i4, this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f3263m);
        }
        if (this.f3265o == null) {
            WeakHashMap weakHashMap = S.f939a;
            if (getFitsSystemWindows()) {
                H.c(this);
            }
        }
        this.f3259i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        G(false);
        if (this.f3264n && this.f3263m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f3263m);
        }
        View view = this.f3262l;
        if (view != null) {
            n(0, view);
        }
        this.f3259i = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f3266p || this.f3267q == null) {
            return;
        }
        z0 z0Var = this.f3265o;
        int iD = z0Var != null ? z0Var.d() : 0;
        if (iD > 0) {
            this.f3267q.setBounds(0, 0, getWidth(), iD);
            this.f3267q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            G(true);
        }
        boolean zD = D(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            G(true);
        }
        return zD;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        b bVar;
        WeakHashMap weakHashMap = S.f939a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.f3251a;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            View view = (View) arrayList.get(i8);
            if (view.getVisibility() != 8 && ((bVar = ((A.d) view.getLayoutParams()).f5a) == null || !bVar.onLayoutChild(this, view, layoutDirection))) {
                B(layoutDirection, view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0189  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r33, int r34) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 502
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f4, float f5, boolean z4) {
        b bVar;
        int childCount = getChildCount();
        boolean zOnNestedFling = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                A.d dVar = (A.d) childAt.getLayoutParams();
                if (dVar.a(0) && (bVar = dVar.f5a) != null) {
                    zOnNestedFling |= bVar.onNestedFling(this, childAt, view, f4, f5, z4);
                }
            }
        }
        if (zOnNestedFling) {
            A(1);
        }
        return zOnNestedFling;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f4, float f5) {
        b bVar;
        int childCount = getChildCount();
        boolean zOnNestedPreFling = false;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                A.d dVar = (A.d) childAt.getLayoutParams();
                if (dVar.a(0) && (bVar = dVar.f5a) != null) {
                    zOnNestedPreFling |= bVar.onNestedPreFling(this, childAt, view, f4, f5);
                }
            }
        }
        return zOnNestedPreFling;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i4, int i5, int[] iArr) {
        i(view, i4, i5, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i4, int i5, int i6, int i7) {
        q(view, i4, i5, i6, i7, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i4) {
        d(view, view2, i4, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray sparseArray = savedState.f3271a;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            int id = childAt.getId();
            b bVar = y(childAt).f5a;
            if (id != -1 && bVar != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                bVar.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            int id = childAt.getId();
            b bVar = ((A.d) childAt.getLayoutParams()).f5a;
            if (id != -1 && bVar != null && (parcelableOnSaveInstanceState = bVar.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id, parcelableOnSaveInstanceState);
            }
        }
        savedState.f3271a = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i4) {
        return r(view, view2, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        n(0, view);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            android.view.View r3 = r0.f3261k
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.D(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2a
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.f3261k
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            A.d r6 = (A.d) r6
            A.b r6 = r6.f5a
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f3261k
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
        L2a:
            android.view.View r7 = r0.f3261k
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r11 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r9 = r11
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L52
            r1 = 3
            if (r2 != r1) goto L55
        L52:
            r0.G(r5)
        L55:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // K.InterfaceC0087t
    public final void p(View view, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        b bVar;
        int childCount = getChildCount();
        boolean z4 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                A.d dVar = (A.d) childAt.getLayoutParams();
                if (dVar.a(i8) && (bVar = dVar.f5a) != null) {
                    int[] iArr2 = this.f3256f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    bVar.onNestedScroll(this, childAt, view, i4, i5, i6, i7, i8, iArr2);
                    int[] iArr3 = this.f3256f;
                    iMax = i6 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    iMax2 = i7 > 0 ? Math.max(iMax2, iArr3[1]) : Math.min(iMax2, iArr3[1]);
                    z4 = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z4) {
            A(1);
        }
    }

    @Override // K.InterfaceC0086s
    public final void q(View view, int i4, int i5, int i6, int i7, int i8) {
        p(view, i4, i5, i6, i7, 0, this.f3257g);
    }

    @Override // K.InterfaceC0086s
    public final boolean r(View view, View view2, int i4, int i5) {
        int childCount = getChildCount();
        boolean z4 = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                A.d dVar = (A.d) childAt.getLayoutParams();
                b bVar = dVar.f5a;
                if (bVar != null) {
                    boolean zOnStartNestedScroll = bVar.onStartNestedScroll(this, childAt, view, view2, i4, i5);
                    z4 |= zOnStartNestedScroll;
                    if (i5 == 0) {
                        dVar.f18n = zOnStartNestedScroll;
                    } else if (i5 == 1) {
                        dVar.f19o = zOnStartNestedScroll;
                    }
                } else if (i5 == 0) {
                    dVar.f18n = false;
                } else if (i5 == 1) {
                    dVar.f19o = false;
                }
            }
        }
        return z4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z4) {
        b bVar = ((A.d) view.getLayoutParams()).f5a;
        if (bVar == null || !bVar.onRequestChildRectangleOnScreen(this, view, rect, z4)) {
            return super.requestChildRectangleOnScreen(view, rect, z4);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z4) {
        super.requestDisallowInterceptTouchEvent(z4);
        if (!z4 || this.f3258h) {
            return;
        }
        G(false);
        this.f3258h = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z4) {
        super.setFitsSystemWindows(z4);
        J();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f3268r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.f3267q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f3267q = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f3267q.setState(getDrawableState());
                }
                Drawable drawable3 = this.f3267q;
                WeakHashMap weakHashMap = S.f939a;
                E.b.b(drawable3, getLayoutDirection());
                this.f3267q.setVisible(getVisibility() == 0, false);
                this.f3267q.setCallback(this);
            }
            WeakHashMap weakHashMap2 = S.f939a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(@ColorInt int i4) {
        setStatusBarBackground(new ColorDrawable(i4));
    }

    public void setStatusBarBackgroundResource(@DrawableRes int i4) {
        setStatusBarBackground(i4 != 0 ? androidx.core.content.a.b(getContext(), i4) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        super.setVisibility(i4);
        boolean z4 = i4 == 0;
        Drawable drawable = this.f3267q;
        if (drawable == null || drawable.isVisible() == z4) {
            return;
        }
        this.f3267q.setVisible(z4, false);
    }

    public final void t(A.d dVar, Rect rect, int i4, int i5) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i4) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i5) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin));
        rect.set(iMax, iMax2, i4 + iMax, i5 + iMax2);
    }

    public final void u(View view, boolean z4, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z4) {
            g.a(this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList v(View view) {
        t.d dVar = this.f3252b;
        int i4 = ((l) dVar.f15274b).f13970c;
        ArrayList arrayList = null;
        for (int i5 = 0; i5 < i4; i5++) {
            ArrayList arrayList2 = (ArrayList) ((l) dVar.f15274b).i(i5);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(((l) dVar.f15274b).f(i5));
            }
        }
        ArrayList arrayList3 = this.f3254d;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f3267q;
    }

    public final int x(int i4) {
        int[] iArr = this.f3260j;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i4);
            return 0;
        }
        if (i4 >= 0 && i4 < iArr.length) {
            return iArr[i4];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i4 + " out of range for " + this);
        return 0;
    }

    public final boolean z(View view, int i4, int i5) {
        Rect rectS = s();
        g.a(this, view, rectS);
        try {
            return rectS.contains(i4, i5);
        } finally {
            F(rectS);
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i4) throws Resources.NotFoundException {
        super(context, attributeSet, i4);
        this.f3251a = new ArrayList();
        this.f3252b = new t.d(1);
        this.f3253c = new ArrayList();
        this.f3254d = new ArrayList();
        this.f3256f = new int[2];
        this.f3257g = new int[2];
        this.f3270t = new C0152a();
        int[] iArr = AbstractC0992a.f16390a;
        TypedArray typedArrayObtainStyledAttributes = i4 == 0 ? context.obtainStyledAttributes(attributeSet, iArr, 0, R.style.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, iArr, i4, 0);
        if (i4 == 0) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, i4, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.f3260j = intArray;
            float f4 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i5 = 0; i5 < length; i5++) {
                this.f3260j[i5] = (int) (r13[i5] * f4);
            }
        }
        this.f3267q = typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.recycle();
        J();
        super.setOnHierarchyChangeListener(new c(this));
        WeakHashMap weakHashMap = S.f939a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof A.d ? new A.d((A.d) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new A.d((ViewGroup.MarginLayoutParams) layoutParams) : new A.d(layoutParams);
    }
}
