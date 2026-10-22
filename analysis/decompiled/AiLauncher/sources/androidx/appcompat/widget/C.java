package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import g.C4086a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import u0.C5566a;

/* loaded from: classes.dex */
public class C extends ListView {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f8869a;

    /* renamed from: b, reason: collision with root package name */
    public int f8870b;

    /* renamed from: c, reason: collision with root package name */
    public int f8871c;

    /* renamed from: d, reason: collision with root package name */
    public int f8872d;

    /* renamed from: e, reason: collision with root package name */
    public int f8873e;

    /* renamed from: f, reason: collision with root package name */
    public int f8874f;

    /* renamed from: g, reason: collision with root package name */
    public d f8875g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8876h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8877i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f8878j;

    /* renamed from: k, reason: collision with root package name */
    public androidx.core.view.U f8879k;

    /* renamed from: l, reason: collision with root package name */
    public androidx.core.widget.f f8880l;

    /* renamed from: m, reason: collision with root package name */
    public e f8881m;

    public static class a {
        public static void a(View view, float f10, float f11) {
            view.drawableHotspotChanged(f10, f11);
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public static Method f8882a;

        /* renamed from: b, reason: collision with root package name */
        public static Method f8883b;

        /* renamed from: c, reason: collision with root package name */
        public static Method f8884c;

        /* renamed from: d, reason: collision with root package name */
        public static boolean f8885d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Boolean.TYPE;
                Class cls3 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
                f8882a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f8883b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f8884c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f8885d = true;
            } catch (NoSuchMethodException e10) {
                e10.printStackTrace();
            }
        }

        public static boolean a() {
            return f8885d;
        }

        @SuppressLint({"BanUncheckedReflection"})
        public static void b(C c10, int i10, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                f8882a.invoke(c10, Integer.valueOf(i10), view, Boolean.FALSE, -1, -1);
                f8883b.invoke(c10, Integer.valueOf(i10));
                f8884c.invoke(c10, Integer.valueOf(i10));
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        }
    }

    public static class c {
        public static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        public static void b(AbsListView absListView, boolean z10) {
            absListView.setSelectedChildViewEnabled(z10);
        }
    }

    public static class d extends C4086a {

        /* renamed from: b, reason: collision with root package name */
        public boolean f8886b;

        public d(Drawable drawable) {
            super(drawable);
            this.f8886b = true;
        }

        public void b(boolean z10) {
            this.f8886b = z10;
        }

        @Override // g.C4086a, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f8886b) {
                super.draw(canvas);
            }
        }

        @Override // g.C4086a, android.graphics.drawable.Drawable
        public void setHotspot(float f10, float f11) {
            if (this.f8886b) {
                super.setHotspot(f10, f11);
            }
        }

        @Override // g.C4086a, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i10, int i11, int i12, int i13) {
            if (this.f8886b) {
                super.setHotspotBounds(i10, i11, i12, i13);
            }
        }

        @Override // g.C4086a, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f8886b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // g.C4086a, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z10, boolean z11) {
            if (this.f8886b) {
                return super.setVisible(z10, z11);
            }
            return false;
        }
    }

    public class e implements Runnable {
        public e() {
        }

        public void a() {
            C c10 = C.this;
            c10.f8881m = null;
            c10.removeCallbacks(this);
        }

        public void b() {
            C.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            C c10 = C.this;
            c10.f8881m = null;
            c10.drawableStateChanged();
        }
    }

    public C(Context context, boolean z10) {
        super(context, null, R$attr.dropDownListViewStyle);
        this.f8869a = new Rect();
        this.f8870b = 0;
        this.f8871c = 0;
        this.f8872d = 0;
        this.f8873e = 0;
        this.f8877i = z10;
        setCacheColorHint(0);
    }

    private void setSelectorEnabled(boolean z10) {
        d dVar = this.f8875g;
        if (dVar != null) {
            dVar.b(z10);
        }
    }

    public final void a() {
        this.f8878j = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f8874f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        androidx.core.view.U u10 = this.f8879k;
        if (u10 != null) {
            u10.c();
            this.f8879k = null;
        }
    }

    public final void b(View view, int i10) {
        performItemClick(view, i10, getItemIdAtPosition(i10));
    }

    public final void c(Canvas canvas) {
        Drawable selector;
        if (this.f8869a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f8869a);
        selector.draw(canvas);
    }

    public int d(int i10, int i11, int i12, int i13, int i14) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        View view = null;
        while (i15 < count) {
            int itemViewType = adapter.getItemViewType(i15);
            if (itemViewType != i16) {
                view = null;
                i16 = itemViewType;
            }
            view = adapter.getView(i15, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i18 = layoutParams.height;
            view.measure(i10, i18 > 0 ? View.MeasureSpec.makeMeasureSpec(i18, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i15 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i13) {
                return (i14 < 0 || i15 <= i14 || i17 <= 0 || measuredHeight == i13) ? i13 : i17;
            }
            if (i14 >= 0 && i15 >= i14) {
                i17 = measuredHeight;
            }
            i15++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f8881m != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r3 = r1
            r9 = r2
            goto L46
        L11:
            r9 = r2
            r3 = r9
            goto L46
        L14:
            r3 = r1
            goto L17
        L16:
            r3 = r2
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = r1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r1) goto Le
            r7.b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            androidx.core.widget.f r9 = r7.f8880l
            if (r9 != 0) goto L5a
            androidx.core.widget.f r9 = new androidx.core.widget.f
            r9.<init>(r7)
            r7.f8880l = r9
        L5a:
            androidx.core.widget.f r9 = r7.f8880l
            r9.m(r1)
            androidx.core.widget.f r9 = r7.f8880l
            r9.onTouch(r7, r8)
            return r3
        L65:
            androidx.core.widget.f r7 = r7.f8880l
            if (r7 == 0) goto L6c
            r7.m(r2)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C.e(android.view.MotionEvent, int):boolean");
    }

    public final void f(int i10, View view) {
        Rect rect = this.f8869a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f8870b;
        rect.top -= this.f8871c;
        rect.right += this.f8872d;
        rect.bottom += this.f8873e;
        boolean zJ = j();
        if (view.isEnabled() != zJ) {
            k(!zJ);
            if (i10 != -1) {
                refreshDrawableState();
            }
        }
    }

    public final void g(int i10, View view) {
        Drawable selector = getSelector();
        boolean z10 = (selector == null || i10 == -1) ? false : true;
        if (z10) {
            selector.setVisible(false, false);
        }
        f(i10, view);
        if (z10) {
            Rect rect = this.f8869a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            C5566a.k(selector, fExactCenterX, fExactCenterY);
        }
    }

    public final void h(int i10, View view, float f10, float f11) {
        g(i10, view);
        Drawable selector = getSelector();
        if (selector == null || i10 == -1) {
            return;
        }
        C5566a.k(selector, f10, f11);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f8877i || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f8877i || super.hasWindowFocus();
    }

    public final void i(View view, int i10, float f10, float f11) {
        View childAt;
        this.f8878j = true;
        a.a(this, f10, f11);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i11 = this.f8874f;
        if (i11 != -1 && (childAt = getChildAt(i11 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f8874f = i10;
        a.a(view, f10 - view.getLeft(), f11 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i10, view, f10, f11);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f8877i || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f8877i && this.f8876h) || super.isInTouchMode();
    }

    public final boolean j() {
        return c.a(this);
    }

    public final void k(boolean z10) {
        c.b(this, z10);
    }

    public final boolean l() {
        return this.f8878j;
    }

    public final void m() {
        Drawable selector = getSelector();
        if (selector != null && l() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f8881m = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f8881m == null) {
            e eVar = new e();
            this.f8881m = eVar;
            eVar.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
            return zOnHoverEvent;
        }
        int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
            View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
            if (childAt.isEnabled()) {
                requestFocus();
                if (b.a()) {
                    b.b(this, iPointToPosition, childAt);
                } else {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
            }
            m();
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f8874f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        e eVar = this.f8881m;
        if (eVar != null) {
            eVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z10) {
        this.f8876h = z10;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar = drawable != null ? new d(drawable) : null;
        this.f8875g = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f8870b = rect.left;
        this.f8871c = rect.top;
        this.f8872d = rect.right;
        this.f8873e = rect.bottom;
    }
}
