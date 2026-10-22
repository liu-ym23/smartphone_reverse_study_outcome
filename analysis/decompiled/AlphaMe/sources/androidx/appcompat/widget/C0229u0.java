package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.stepos.alphame.R;
import h.RunnableC0583a;
import java.lang.reflect.InvocationTargetException;

/* renamed from: androidx.appcompat.widget.u0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0229u0 extends ListView {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f3171a;

    /* renamed from: b, reason: collision with root package name */
    public int f3172b;

    /* renamed from: c, reason: collision with root package name */
    public int f3173c;

    /* renamed from: d, reason: collision with root package name */
    public int f3174d;

    /* renamed from: e, reason: collision with root package name */
    public int f3175e;

    /* renamed from: f, reason: collision with root package name */
    public int f3176f;

    /* renamed from: g, reason: collision with root package name */
    public C0227t0 f3177g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3178h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f3179i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3180j;

    /* renamed from: k, reason: collision with root package name */
    public androidx.core.widget.f f3181k;

    /* renamed from: l, reason: collision with root package name */
    public RunnableC0583a f3182l;

    public C0229u0(Context context, boolean z4) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f3171a = new Rect();
        this.f3172b = 0;
        this.f3173c = 0;
        this.f3174d = 0;
        this.f3175e = 0;
        this.f3179i = z4;
        setCacheColorHint(0);
    }

    public final int a(int i4, int i5) {
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
        int i6 = 0;
        View view = null;
        for (int i7 = 0; i7 < count; i7++) {
            int itemViewType = adapter.getItemViewType(i7);
            if (itemViewType != i6) {
                view = null;
                i6 = itemViewType;
            }
            view = adapter.getView(i7, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i8 = layoutParams.height;
            view.measure(i4, i8 > 0 ? View.MeasureSpec.makeMeasureSpec(i8, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i7 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i5) {
                return i5;
            }
        }
        return measuredHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(android.view.MotionEvent r17, int r18) throws java.lang.ClassNotFoundException {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0229u0.b(android.view.MotionEvent, int):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f3171a;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f3182l != null) {
            return;
        }
        super.drawableStateChanged();
        C0227t0 c0227t0 = this.f3177g;
        if (c0227t0 != null) {
            c0227t0.f3164b = true;
        }
        Drawable selector = getSelector();
        if (selector != null && this.f3180j && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return this.f3179i || super.hasFocus();
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        return this.f3179i || super.hasWindowFocus();
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f3179i || super.isFocused();
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        return (this.f3179i && this.f3178h) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f3182l = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int actionMasked = motionEvent.getActionMasked();
        int i4 = 1;
        if (actionMasked == 10 && this.f3182l == null) {
            RunnableC0583a runnableC0583a = new RunnableC0583a(i4, this);
            this.f3182l = runnableC0583a;
            post(runnableC0583a);
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (AbstractC0223r0.f3159d) {
                        try {
                            AbstractC0223r0.f3156a.invoke(this, Integer.valueOf(iPointToPosition), childAt, Boolean.FALSE, -1, -1);
                            AbstractC0223r0.f3157b.invoke(this, Integer.valueOf(iPointToPosition));
                            AbstractC0223r0.f3158c.invoke(this, Integer.valueOf(iPointToPosition));
                        } catch (IllegalAccessException e4) {
                            e4.printStackTrace();
                        } catch (InvocationTargetException e5) {
                            e5.printStackTrace();
                        }
                    } else {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    }
                }
                Drawable selector = getSelector();
                if (selector != null && this.f3180j && isPressed()) {
                    selector.setState(getDrawableState());
                }
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f3176f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        RunnableC0583a runnableC0583a = this.f3182l;
        if (runnableC0583a != null) {
            C0229u0 c0229u0 = (C0229u0) runnableC0583a.f12686b;
            c0229u0.f3182l = null;
            c0229u0.removeCallbacks(runnableC0583a);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z4) {
        this.f3178h = z4;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        C0227t0 c0227t0;
        if (drawable != null) {
            c0227t0 = new C0227t0(drawable);
            c0227t0.f3164b = true;
        } else {
            c0227t0 = null;
        }
        this.f3177g = c0227t0;
        super.setSelector(c0227t0);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f3172b = rect.left;
        this.f3173c = rect.top;
        this.f3174d = rect.right;
        this.f3175e = rect.bottom;
    }
}
