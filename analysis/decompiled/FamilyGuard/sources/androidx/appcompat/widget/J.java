package androidx.appcompat.widget;

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
import g.C0728a;
import i.C0754a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class J extends ListView {

    /* renamed from: a, reason: collision with root package name */
    private final Rect f8144a;

    /* renamed from: b, reason: collision with root package name */
    private int f8145b;

    /* renamed from: c, reason: collision with root package name */
    private int f8146c;

    /* renamed from: d, reason: collision with root package name */
    private int f8147d;

    /* renamed from: e, reason: collision with root package name */
    private int f8148e;

    /* renamed from: f, reason: collision with root package name */
    private int f8149f;

    /* renamed from: g, reason: collision with root package name */
    private d f8150g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8151h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8152i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8153j;

    /* renamed from: k, reason: collision with root package name */
    private androidx.core.view.S f8154k;

    /* renamed from: l, reason: collision with root package name */
    private androidx.core.widget.f f8155l;

    /* renamed from: m, reason: collision with root package name */
    e f8156m;

    static class a {
        static void a(View view, float f5, float f6) {
            view.drawableHotspotChanged(f5, f6);
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        private static Method f8157a;

        /* renamed from: b, reason: collision with root package name */
        private static Method f8158b;

        /* renamed from: c, reason: collision with root package name */
        private static Method f8159c;

        /* renamed from: d, reason: collision with root package name */
        private static boolean f8160d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Boolean.TYPE;
                Class cls3 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
                f8157a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f8158b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f8159c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f8160d = true;
            } catch (NoSuchMethodException e6) {
                e6.printStackTrace();
            }
        }

        static boolean a() {
            return f8160d;
        }

        static void b(J j5, int i5, View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                f8157a.invoke(j5, Integer.valueOf(i5), view, Boolean.FALSE, -1, -1);
                f8158b.invoke(j5, Integer.valueOf(i5));
                f8159c.invoke(j5, Integer.valueOf(i5));
            } catch (IllegalAccessException e6) {
                e6.printStackTrace();
            } catch (InvocationTargetException e7) {
                e7.printStackTrace();
            }
        }
    }

    static class c {
        static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        static void b(AbsListView absListView, boolean z5) {
            absListView.setSelectedChildViewEnabled(z5);
        }
    }

    private static class d extends C0754a {

        /* renamed from: b, reason: collision with root package name */
        private boolean f8161b;

        d(Drawable drawable) {
            super(drawable);
            this.f8161b = true;
        }

        void b(boolean z5) {
            this.f8161b = z5;
        }

        @Override // i.C0754a, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f8161b) {
                super.draw(canvas);
            }
        }

        @Override // i.C0754a, android.graphics.drawable.Drawable
        public void setHotspot(float f5, float f6) {
            if (this.f8161b) {
                super.setHotspot(f5, f6);
            }
        }

        @Override // i.C0754a, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i5, int i6, int i7, int i8) {
            if (this.f8161b) {
                super.setHotspotBounds(i5, i6, i7, i8);
            }
        }

        @Override // i.C0754a, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f8161b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // i.C0754a, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z5, boolean z6) {
            if (this.f8161b) {
                return super.setVisible(z5, z6);
            }
            return false;
        }
    }

    private class e implements Runnable {
        e() {
        }

        public void a() {
            J j5 = J.this;
            j5.f8156m = null;
            j5.removeCallbacks(this);
        }

        public void b() {
            J.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            J j5 = J.this;
            j5.f8156m = null;
            j5.drawableStateChanged();
        }
    }

    J(Context context, boolean z5) {
        super(context, null, C0728a.f16808E);
        this.f8144a = new Rect();
        this.f8145b = 0;
        this.f8146c = 0;
        this.f8147d = 0;
        this.f8148e = 0;
        this.f8152i = z5;
        setCacheColorHint(0);
    }

    private void a() {
        this.f8153j = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f8149f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        androidx.core.view.S s5 = this.f8154k;
        if (s5 != null) {
            s5.c();
            this.f8154k = null;
        }
    }

    private void b(View view, int i5) {
        performItemClick(view, i5, getItemIdAtPosition(i5));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (this.f8144a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f8144a);
        selector.draw(canvas);
    }

    private void f(int i5, View view) {
        Rect rect = this.f8144a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f8145b;
        rect.top -= this.f8146c;
        rect.right += this.f8147d;
        rect.bottom += this.f8148e;
        boolean zJ = j();
        if (view.isEnabled() != zJ) {
            k(!zJ);
            if (i5 != -1) {
                refreshDrawableState();
            }
        }
    }

    private void g(int i5, View view) {
        Drawable selector = getSelector();
        boolean z5 = (selector == null || i5 == -1) ? false : true;
        if (z5) {
            selector.setVisible(false, false);
        }
        f(i5, view);
        if (z5) {
            Rect rect = this.f8144a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            androidx.core.graphics.drawable.a.k(selector, fExactCenterX, fExactCenterY);
        }
    }

    private void h(int i5, View view, float f5, float f6) {
        g(i5, view);
        Drawable selector = getSelector();
        if (selector == null || i5 == -1) {
            return;
        }
        androidx.core.graphics.drawable.a.k(selector, f5, f6);
    }

    private void i(View view, int i5, float f5, float f6) {
        View childAt;
        this.f8153j = true;
        a.a(this, f5, f6);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i6 = this.f8149f;
        if (i6 != -1 && (childAt = getChildAt(i6 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f8149f = i5;
        a.a(view, f5 - view.getLeft(), f6 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i5, view, f5, f6);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private boolean j() {
        return c.a(this);
    }

    private void k(boolean z5) {
        c.b(this, z5);
    }

    private boolean l() {
        return this.f8153j;
    }

    private void m() {
        Drawable selector = getSelector();
        if (selector != null && l() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void setSelectorEnabled(boolean z5) {
        d dVar = this.f8150g;
        if (dVar != null) {
            dVar.b(z5);
        }
    }

    public int d(int i5, int i6, int i7, int i8, int i9) {
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
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        View view = null;
        while (i10 < count) {
            int itemViewType = adapter.getItemViewType(i10);
            if (itemViewType != i11) {
                view = null;
                i11 = itemViewType;
            }
            view = adapter.getView(i10, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i13 = layoutParams.height;
            view.measure(i5, i13 > 0 ? View.MeasureSpec.makeMeasureSpec(i13, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i10 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i8) {
                return (i9 < 0 || i10 <= i9 || i12 <= 0 || measuredHeight == i8) ? i8 : i12;
            }
            if (i9 >= 0 && i10 >= i9) {
                i12 = measuredHeight;
            }
            i10++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f8156m != null) {
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
            androidx.core.widget.f r9 = r7.f8155l
            if (r9 != 0) goto L5a
            androidx.core.widget.f r9 = new androidx.core.widget.f
            r9.<init>(r7)
            r7.f8155l = r9
        L5a:
            androidx.core.widget.f r9 = r7.f8155l
            r9.m(r1)
            androidx.core.widget.f r9 = r7.f8155l
            r9.onTouch(r7, r8)
            return r3
        L65:
            androidx.core.widget.f r7 = r7.f8155l
            if (r7 == 0) goto L6c
            r7.m(r2)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.J.e(android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f8152i || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f8152i || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f8152i || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f8152i && this.f8151h) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f8156m = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f8156m == null) {
            e eVar = new e();
            this.f8156m = eVar;
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
            this.f8149f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        e eVar = this.f8156m;
        if (eVar != null) {
            eVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z5) {
        this.f8151h = z5;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        d dVar = drawable != null ? new d(drawable) : null;
        this.f8150g = dVar;
        super.setSelector(dVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f8145b = rect.left;
        this.f8146c = rect.top;
        this.f8147d = rect.right;
        this.f8148e = rect.bottom;
    }
}
