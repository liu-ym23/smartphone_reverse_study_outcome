package g;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.stepos.stepclaw.R;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class t0 extends ListView {

    /* renamed from: a, reason: collision with root package name */
    public final Rect f2828a;

    /* renamed from: b, reason: collision with root package name */
    public int f2829b;

    /* renamed from: c, reason: collision with root package name */
    public int f2830c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f2831e;

    /* renamed from: f, reason: collision with root package name */
    public int f2832f;

    /* renamed from: g, reason: collision with root package name */
    public r0 f2833g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2834h;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f2835j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f2836k;

    /* renamed from: l, reason: collision with root package name */
    public g0.c f2837l;

    /* renamed from: m, reason: collision with root package name */
    public androidx.fragment.app.b f2838m;

    public t0(Context context, boolean z) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f2828a = new Rect();
        this.f2829b = 0;
        this.f2830c = 0;
        this.d = 0;
        this.f2831e = 0;
        this.f2835j = z;
        setCacheColorHint(0);
    }

    public final int a(int i8, int i9) {
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
        View view = null;
        for (int i11 = 0; i11 < count; i11++) {
            int itemViewType = adapter.getItemViewType(i11);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(i11, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i12 = layoutParams.height;
            view.measure(i8, i12 > 0 ? View.MeasureSpec.makeMeasureSpec(i12, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i11 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i9) {
                return i9;
            }
        }
        return measuredHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(android.view.MotionEvent r18, int r19) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g.t0.b(android.view.MotionEvent, int):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f2828a;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f2838m != null) {
            return;
        }
        super.drawableStateChanged();
        r0 r0Var = this.f2833g;
        if (r0Var != null) {
            r0Var.f2818b = true;
        }
        Drawable selector = getSelector();
        if (selector != null && this.f2836k && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return this.f2835j || super.hasFocus();
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        return this.f2835j || super.hasWindowFocus();
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f2835j || super.isFocused();
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        return (this.f2835j && this.f2834h) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f2838m = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f2838m == null) {
            androidx.fragment.app.b bVar = new androidx.fragment.app.b(2, this);
            this.f2838m = bVar;
            post(bVar);
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
                if (p0.d) {
                    try {
                        p0.f2800a.invoke(this, Integer.valueOf(iPointToPosition), childAt, Boolean.FALSE, -1, -1);
                        p0.f2801b.invoke(this, Integer.valueOf(iPointToPosition));
                        p0.f2802c.invoke(this, Integer.valueOf(iPointToPosition));
                    } catch (IllegalAccessException e9) {
                        e9.printStackTrace();
                    } catch (InvocationTargetException e10) {
                        e10.printStackTrace();
                    }
                } else {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
            }
            Drawable selector = getSelector();
            if (selector != null && this.f2836k && isPressed()) {
                selector.setState(getDrawableState());
            }
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f2832f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        androidx.fragment.app.b bVar = this.f2838m;
        if (bVar != null) {
            t0 t0Var = (t0) bVar.f661b;
            t0Var.f2838m = null;
            t0Var.removeCallbacks(bVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z) {
        this.f2834h = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        r0 r0Var = null;
        if (drawable != null) {
            r0 r0Var2 = new r0();
            Drawable drawable2 = r0Var2.f2817a;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            r0Var2.f2817a = drawable;
            drawable.setCallback(r0Var2);
            r0Var2.f2818b = true;
            r0Var = r0Var2;
        }
        this.f2833g = r0Var;
        super.setSelector(r0Var);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2829b = rect.left;
        this.f2830c = rect.top;
        this.d = rect.right;
        this.f2831e = rect.bottom;
    }
}
