package androidx.viewpager.widget;

import B0.c;
import K.J;
import K.S;
import Q.d;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.view.AbsSavedState;
import com.stepos.alphame.utils.Property;
import h.RunnableC0583a;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.WeakHashMap;
import r0.b;
import r0.e;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* renamed from: F, reason: collision with root package name */
    public static final int[] f4272F = {R.attr.layout_gravity};

    /* renamed from: G, reason: collision with root package name */
    public static final d f4273G = new d(1);

    /* renamed from: A, reason: collision with root package name */
    public boolean f4274A;

    /* renamed from: B, reason: collision with root package name */
    public boolean f4275B;

    /* renamed from: C, reason: collision with root package name */
    public int f4276C;

    /* renamed from: D, reason: collision with root package name */
    public final RunnableC0583a f4277D;

    /* renamed from: E, reason: collision with root package name */
    public int f4278E;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4279a;

    /* renamed from: b, reason: collision with root package name */
    public final b f4280b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f4281c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f4282d;

    /* renamed from: e, reason: collision with root package name */
    public final Scroller f4283e;

    /* renamed from: f, reason: collision with root package name */
    public int f4284f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f4285g;

    /* renamed from: h, reason: collision with root package name */
    public final float f4286h;

    /* renamed from: i, reason: collision with root package name */
    public final float f4287i;

    /* renamed from: j, reason: collision with root package name */
    public int f4288j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f4289k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4290l;

    /* renamed from: m, reason: collision with root package name */
    public int f4291m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4292n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f4293o;

    /* renamed from: p, reason: collision with root package name */
    public final int f4294p;

    /* renamed from: q, reason: collision with root package name */
    public int f4295q;

    /* renamed from: r, reason: collision with root package name */
    public final int f4296r;

    /* renamed from: s, reason: collision with root package name */
    public float f4297s;

    /* renamed from: t, reason: collision with root package name */
    public float f4298t;

    /* renamed from: u, reason: collision with root package name */
    public float f4299u;

    /* renamed from: v, reason: collision with root package name */
    public int f4300v;

    /* renamed from: w, reason: collision with root package name */
    public VelocityTracker f4301w;

    /* renamed from: x, reason: collision with root package name */
    public final int f4302x;

    /* renamed from: y, reason: collision with root package name */
    public final EdgeEffect f4303y;

    /* renamed from: z, reason: collision with root package name */
    public final EdgeEffect f4304z;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f4305a;

        /* renamed from: b, reason: collision with root package name */
        public final Parcelable f4306b;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f4305a = parcel.readInt();
            this.f4306b = parcel.readParcelable(classLoader);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("FragmentPager.SavedState{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" position=");
            return AbstractC0831a.d(sb, this.f4305a, "}");
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f4305a);
            parcel.writeParcelable(this.f4306b, i4);
        }
    }

    public ViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4279a = new ArrayList();
        this.f4280b = new b();
        this.f4281c = new Rect();
        this.f4286h = -3.4028235E38f;
        this.f4287i = Float.MAX_VALUE;
        this.f4291m = 1;
        this.f4300v = -1;
        this.f4274A = true;
        this.f4277D = new RunnableC0583a(7, this);
        this.f4278E = 0;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.f4283e = new Scroller(context2, f4273G);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f4 = context2.getResources().getDisplayMetrics().density;
        this.f4296r = viewConfiguration.getScaledPagingTouchSlop();
        viewConfiguration.getScaledMaximumFlingVelocity();
        this.f4303y = new EdgeEffect(context2);
        this.f4304z = new EdgeEffect(context2);
        this.f4302x = (int) (2.0f * f4);
        this.f4294p = (int) (f4 * 16.0f);
        S.h(this, new r0.d(0, this));
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        c cVar = new c();
        cVar.f137b = this;
        cVar.f136a = new Rect();
        J.u(this, cVar);
    }

    public static boolean b(int i4, int i5, int i6, View view, boolean z4) {
        int i7;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i8 = i5 + scrollX;
                if (i8 >= childAt.getLeft() && i8 < childAt.getRight() && (i7 = i6 + scrollY) >= childAt.getTop() && i7 < childAt.getBottom() && b(i4, i8 - childAt.getLeft(), i7 - childAt.getTop(), childAt, true)) {
                    return true;
                }
            }
        }
        return z4 && view.canScrollHorizontally(-i4);
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z4) {
        if (this.f4290l != z4) {
            this.f4290l = z4;
        }
    }

    public final boolean a(int i4) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            for (ViewParent parent = viewFindFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                if (parent == this) {
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(viewFindFocus.getClass().getSimpleName());
            for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                sb.append(" => ");
                sb.append(parent2.getClass().getSimpleName());
            }
            Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i4);
        boolean zRequestFocus = false;
        if (viewFindNextFocus != null && viewFindNextFocus != viewFindFocus) {
            Rect rect = this.f4281c;
            if (i4 == 17) {
                int i5 = d(viewFindNextFocus, rect).left;
                int i6 = d(viewFindFocus, rect).left;
                if (viewFindFocus == null || i5 < i6) {
                    zRequestFocus = viewFindNextFocus.requestFocus();
                }
            } else if (i4 == 66) {
                int i7 = d(viewFindNextFocus, rect).left;
                int i8 = d(viewFindFocus, rect).left;
                if (viewFindFocus == null || i7 > i8) {
                    zRequestFocus = viewFindNextFocus.requestFocus();
                }
            }
        }
        if (zRequestFocus) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i4));
        }
        return zRequestFocus;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i4, int i5) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                if (getChildAt(i6).getVisibility() == 0) {
                    e();
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i5 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList arrayList) {
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4).getVisibility() == 0) {
                e();
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i4, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateDefaultLayoutParams();
        }
        r0.c cVar = (r0.c) layoutParams;
        boolean z4 = cVar.f14002a | (view.getClass().getAnnotation(DecorView.class) != null);
        cVar.f14002a = z4;
        if (!this.f4289k) {
            super.addView(view, i4, layoutParams);
        } else {
            if (z4) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            addViewInLayout(view, i4, layoutParams);
        }
    }

    public final void c(boolean z4) throws ClassNotFoundException {
        int i4 = 0;
        boolean z5 = this.f4278E == 2;
        if (z5) {
            setScrollingCacheEnabled(false);
            if (!this.f4283e.isFinished()) {
                this.f4283e.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f4283e.getCurrX();
                int currY = this.f4283e.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        h(currX);
                    }
                }
            }
        }
        while (true) {
            ArrayList arrayList = this.f4279a;
            if (i4 >= arrayList.size()) {
                break;
            }
            ((b) arrayList.get(i4)).getClass();
            i4++;
        }
        if (z5) {
            RunnableC0583a runnableC0583a = this.f4277D;
            if (!z4) {
                runnableC0583a.run();
            } else {
                WeakHashMap weakHashMap = S.f939a;
                postOnAnimation(runnableC0583a);
            }
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i4) {
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof r0.c) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() throws ClassNotFoundException {
        if (this.f4283e.isFinished() || !this.f4283e.computeScrollOffset()) {
            c(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f4283e.getCurrX();
        int currY = this.f4283e.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!h(currX)) {
                this.f4283e.abortAnimation();
                scrollTo(0, currY);
            }
        }
        WeakHashMap weakHashMap = S.f939a;
        postInvalidateOnAnimation();
    }

    public final Rect d(View view, Rect rect) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            boolean r0 = super.dispatchKeyEvent(r6)
            r1 = 1
            if (r0 != 0) goto L55
            int r0 = r6.getAction()
            r2 = 0
            if (r0 != 0) goto L54
            int r0 = r6.getKeyCode()
            r3 = 21
            r4 = 2
            if (r0 == r3) goto L44
            r3 = 22
            if (r0 == r3) goto L36
            r3 = 61
            if (r0 == r3) goto L20
            goto L54
        L20:
            boolean r0 = r6.hasNoModifiers()
            if (r0 == 0) goto L2b
            boolean r5 = r5.a(r4)
            goto L51
        L2b:
            boolean r6 = r6.hasModifiers(r1)
            if (r6 == 0) goto L54
            boolean r5 = r5.a(r1)
            goto L51
        L36:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L3d
            goto L54
        L3d:
            r6 = 66
            boolean r5 = r5.a(r6)
            goto L51
        L44:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L4b
            goto L54
        L4b:
            r6 = 17
            boolean r5 = r5.a(r6)
        L51:
            if (r5 == 0) goto L54
            goto L55
        L54:
            r1 = r2
        L55:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            if (getChildAt(i4).getVisibility() == 0) {
                e();
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean zDraw;
        super.draw(canvas);
        if (getOverScrollMode() != 0) {
            this.f4303y.finish();
            this.f4304z.finish();
            return;
        }
        if (this.f4303y.isFinished()) {
            zDraw = false;
        } else {
            int iSave = canvas.save();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int width = getWidth();
            canvas.rotate(270.0f);
            canvas.translate(getPaddingTop() + (-height), this.f4286h * width);
            this.f4303y.setSize(height, width);
            zDraw = this.f4303y.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        if (!this.f4304z.isFinished()) {
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(90.0f);
            canvas.translate(-getPaddingTop(), (-(this.f4287i + 1.0f)) * width2);
            this.f4304z.setSize(height2, width2);
            zDraw |= this.f4304z.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        if (zDraw) {
            WeakHashMap weakHashMap = S.f939a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f4285g;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final void e() {
        ArrayList arrayList = this.f4279a;
        if (arrayList.size() <= 0) {
            return;
        }
        ((b) arrayList.get(0)).getClass();
        throw null;
    }

    public final b f(int i4) {
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f4279a;
            if (i5 >= arrayList.size()) {
                return null;
            }
            b bVar = (b) arrayList.get(i5);
            if (bVar.f14000a == i4) {
                return bVar;
            }
            i5++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            r11 = this;
            int r0 = r11.f4276C
            r1 = 1
            if (r0 <= 0) goto L6b
            int r0 = r11.getScrollX()
            int r2 = r11.getPaddingLeft()
            int r3 = r11.getPaddingRight()
            int r4 = r11.getWidth()
            int r5 = r11.getChildCount()
            r6 = 0
        L1a:
            if (r6 >= r5) goto L6b
            android.view.View r7 = r11.getChildAt(r6)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            r0.c r8 = (r0.c) r8
            boolean r9 = r8.f14002a
            if (r9 != 0) goto L2b
            goto L68
        L2b:
            int r8 = r8.f14003b
            r8 = r8 & 7
            if (r8 == r1) goto L4f
            r9 = 3
            if (r8 == r9) goto L49
            r9 = 5
            if (r8 == r9) goto L39
            r8 = r2
            goto L5c
        L39:
            int r8 = r4 - r3
            int r9 = r7.getMeasuredWidth()
            int r8 = r8 - r9
            int r9 = r7.getMeasuredWidth()
            int r3 = r3 + r9
        L45:
            r10 = r8
            r8 = r2
            r2 = r10
            goto L5c
        L49:
            int r8 = r7.getWidth()
            int r8 = r8 + r2
            goto L5c
        L4f:
            int r8 = r7.getMeasuredWidth()
            int r8 = r4 - r8
            int r8 = r8 / 2
            int r8 = java.lang.Math.max(r8, r2)
            goto L45
        L5c:
            int r2 = r2 + r0
            int r9 = r7.getLeft()
            int r2 = r2 - r9
            if (r2 == 0) goto L67
            r7.offsetLeftAndRight(r2)
        L67:
            r2 = r8
        L68:
            int r6 = r6 + 1
            goto L1a
        L6b:
            r11.f4275B = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.g():void");
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new r0.c(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Nullable
    public r0.a getAdapter() {
        return null;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i4, int i5) {
        throw null;
    }

    public int getCurrentItem() {
        return 0;
    }

    public int getOffscreenPageLimit() {
        return this.f4291m;
    }

    public int getPageMargin() {
        return this.f4284f;
    }

    public final boolean h(int i4) {
        int i5;
        ArrayList arrayList = this.f4279a;
        if (arrayList.size() == 0) {
            if (this.f4274A) {
                return false;
            }
            this.f4275B = false;
            g();
            if (this.f4275B) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f4 = clientWidth > 0 ? this.f4284f / clientWidth : 0.0f;
        int i6 = -1;
        boolean z4 = true;
        int i7 = 0;
        float f5 = 0.0f;
        b bVar = null;
        while (i7 < arrayList.size()) {
            b bVar2 = (b) arrayList.get(i7);
            if (!z4 && bVar2.f14000a != (i5 = i6 + 1)) {
                float f6 = f5 + Property.DEFAULT_FLOAT_VALUE + f4;
                b bVar3 = this.f4280b;
                bVar3.f14001b = f6;
                bVar3.f14000a = i5;
                throw null;
            }
            f5 = bVar2.f14001b;
            float f7 = f5 + Property.DEFAULT_FLOAT_VALUE + f4;
            if (!z4 && scrollX < f5) {
                break;
            }
            if (scrollX < f7 || i7 == arrayList.size() - 1) {
                bVar = bVar2;
                break;
            }
            i6 = bVar2.f14000a;
            i7++;
            z4 = false;
            bVar = bVar2;
        }
        getClientWidth();
        int i8 = bVar.f14000a;
        this.f4275B = false;
        g();
        if (this.f4275B) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final void i(int i4, int i5, int i6, int i7) throws ClassNotFoundException {
        if (i5 > 0 && !this.f4279a.isEmpty()) {
            if (!this.f4283e.isFinished()) {
                this.f4283e.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i5 - getPaddingLeft()) - getPaddingRight()) + i7)) * (((i4 - getPaddingLeft()) - getPaddingRight()) + i6)), getScrollY());
                return;
            }
        }
        b bVarF = f(0);
        int iMin = (int) ((bVarF != null ? Math.min(bVarF.f14001b, this.f4287i) : Property.DEFAULT_FLOAT_VALUE) * ((i4 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            c(false);
            scrollTo(iMin, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f4274A = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f4277D);
        Scroller scroller = this.f4283e;
        if (scroller != null && !scroller.isFinished()) {
            this.f4283e.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4284f <= 0 || this.f4285g == null) {
            return;
        }
        this.f4279a.size();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) throws ClassNotFoundException {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f4300v = -1;
            this.f4292n = false;
            this.f4293o = false;
            VelocityTracker velocityTracker = this.f4301w;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f4301w = null;
            }
            this.f4303y.onRelease();
            this.f4304z.onRelease();
            if (!this.f4303y.isFinished()) {
                this.f4304z.isFinished();
            }
            return false;
        }
        if (action != 0) {
            if (this.f4292n) {
                return true;
            }
            if (this.f4293o) {
                return false;
            }
        }
        if (action == 0) {
            float x4 = motionEvent.getX();
            this.f4298t = x4;
            this.f4297s = x4;
            this.f4299u = motionEvent.getY();
            this.f4300v = motionEvent.getPointerId(0);
            this.f4293o = false;
            this.f4283e.computeScrollOffset();
            if (this.f4278E != 2 || Math.abs(this.f4283e.getFinalX() - this.f4283e.getCurrX()) <= this.f4302x) {
                c(false);
                this.f4292n = false;
            } else {
                this.f4283e.abortAnimation();
                this.f4292n = true;
                ViewParent parent = getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                setScrollState(1);
            }
        } else if (action == 2) {
            int i4 = this.f4300v;
            if (i4 != -1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(i4);
                float x5 = motionEvent.getX(iFindPointerIndex);
                float f4 = x5 - this.f4297s;
                float fAbs = Math.abs(f4);
                float y4 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y4 - this.f4299u);
                if (f4 != Property.DEFAULT_FLOAT_VALUE) {
                    float f5 = this.f4297s;
                    if ((f5 >= this.f4295q || f4 <= Property.DEFAULT_FLOAT_VALUE) && ((f5 <= getWidth() - this.f4295q || f4 >= Property.DEFAULT_FLOAT_VALUE) && b((int) f4, (int) x5, (int) y4, this, false))) {
                        this.f4297s = x5;
                        this.f4293o = true;
                        return false;
                    }
                }
                float f6 = this.f4296r;
                if (fAbs > f6 && fAbs * 0.5f > fAbs2) {
                    this.f4292n = true;
                    ViewParent parent2 = getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(true);
                    }
                    setScrollState(1);
                    float f7 = this.f4298t;
                    float f8 = this.f4296r;
                    this.f4297s = f4 > Property.DEFAULT_FLOAT_VALUE ? f7 + f8 : f7 - f8;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > f6) {
                    this.f4293o = true;
                }
                if (this.f4292n) {
                    this.f4297s = x5;
                    getScrollX();
                    getClientWidth();
                    ArrayList arrayList = this.f4279a;
                    b bVar = (b) arrayList.get(0);
                    b bVar2 = (b) arrayList.get(arrayList.size() - 1);
                    int i5 = bVar.f14000a;
                    int i6 = bVar2.f14000a;
                    throw null;
                }
            }
        } else if (action == 6) {
            int actionIndex = motionEvent.getActionIndex();
            if (motionEvent.getPointerId(actionIndex) == this.f4300v) {
                int i7 = actionIndex == 0 ? 1 : 0;
                this.f4297s = motionEvent.getX(i7);
                this.f4300v = motionEvent.getPointerId(i7);
                VelocityTracker velocityTracker2 = this.f4301w;
                if (velocityTracker2 != null) {
                    velocityTracker2.clear();
                }
            }
        }
        if (this.f4301w == null) {
            this.f4301w = VelocityTracker.obtain();
        }
        this.f4301w.addMovement(motionEvent);
        return this.f4292n;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) throws java.lang.ClassNotFoundException {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        r0.c cVar;
        r0.c cVar2;
        int i6;
        setMeasuredDimension(View.getDefaultSize(0, i4), View.getDefaultSize(0, i5));
        int measuredWidth = getMeasuredWidth();
        this.f4295q = Math.min(measuredWidth / 10, this.f4294p);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i7 = 0;
        while (true) {
            int i8 = 1073741824;
            if (i7 >= childCount) {
                break;
            }
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8 && (cVar2 = (r0.c) childAt.getLayoutParams()) != null && cVar2.f14002a) {
                int i9 = cVar2.f14003b;
                int i10 = i9 & 7;
                int i11 = i9 & 112;
                boolean z4 = true;
                boolean z5 = i11 == 48 || i11 == 80;
                if (i10 != 3 && i10 != 5) {
                    z4 = false;
                }
                int i12 = Integer.MIN_VALUE;
                if (z5) {
                    i6 = Integer.MIN_VALUE;
                    i12 = 1073741824;
                } else {
                    i6 = z4 ? 1073741824 : Integer.MIN_VALUE;
                }
                int i13 = ((ViewGroup.LayoutParams) cVar2).width;
                if (i13 != -2) {
                    if (i13 == -1) {
                        i13 = paddingLeft;
                    }
                    i12 = 1073741824;
                } else {
                    i13 = paddingLeft;
                }
                int i14 = ((ViewGroup.LayoutParams) cVar2).height;
                if (i14 == -2) {
                    i14 = measuredHeight;
                    i8 = i6;
                } else if (i14 == -1) {
                    i14 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i13, i12), View.MeasureSpec.makeMeasureSpec(i14, i8));
                if (z5) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z4) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i7++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f4288j = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f4289k = false;
        int childCount2 = getChildCount();
        for (int i15 = 0; i15 < childCount2; i15++) {
            View childAt2 = getChildAt(i15);
            if (childAt2.getVisibility() != 8 && ((cVar = (r0.c) childAt2.getLayoutParams()) == null || !cVar.f14002a)) {
                cVar.getClass();
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * Property.DEFAULT_FLOAT_VALUE), 1073741824), this.f4288j);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i4, Rect rect) {
        int i5;
        int i6;
        int i7;
        int childCount = getChildCount();
        if ((i4 & 2) != 0) {
            i6 = 1;
            i7 = childCount;
            i5 = 0;
        } else {
            i5 = childCount - 1;
            i6 = -1;
            i7 = -1;
        }
        while (i5 != i7) {
            if (getChildAt(i5).getVisibility() == 0) {
                e();
            }
            i5 += i6;
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f4282d = savedState.f4306b;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f4305a = 0;
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i4, int i5, int i6, int i7) throws ClassNotFoundException {
        super.onSizeChanged(i4, i5, i6, i7);
        if (i4 != i6) {
            int i8 = this.f4284f;
            i(i4, i6, i8, i8);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            motionEvent.getEdgeFlags();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.f4289k) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(@Nullable r0.a aVar) {
    }

    public void setCurrentItem(int i4) {
        setScrollingCacheEnabled(false);
    }

    public void setOffscreenPageLimit(int i4) {
        if (i4 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i4 + " too small; defaulting to 1");
            i4 = 1;
        }
        if (i4 != this.f4291m) {
            this.f4291m = i4;
        }
    }

    @Deprecated
    public void setOnPageChangeListener(e eVar) {
    }

    public void setPageMargin(int i4) throws ClassNotFoundException {
        int i5 = this.f4284f;
        this.f4284f = i4;
        int width = getWidth();
        i(width, width, i4, i5);
        requestLayout();
    }

    public void setPageMarginDrawable(@Nullable Drawable drawable) {
        this.f4285g = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i4) {
        if (this.f4278E == i4) {
            return;
        }
        this.f4278E = i4;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4285g;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        r0.c cVar = new r0.c(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4272F);
        cVar.f14003b = typedArrayObtainStyledAttributes.getInteger(0, 48);
        typedArrayObtainStyledAttributes.recycle();
        return cVar;
    }

    public void setPageMarginDrawable(@DrawableRes int i4) {
        setPageMarginDrawable(androidx.core.content.a.b(getContext(), i4));
    }
}
