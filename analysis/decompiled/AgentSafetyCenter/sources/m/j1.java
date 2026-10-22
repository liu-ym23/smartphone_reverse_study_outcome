package m;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class j1 extends ListView {

    /* renamed from: c, reason: collision with root package name */
    public final Rect f7932c;

    /* renamed from: f, reason: collision with root package name */
    public int f7933f;

    /* renamed from: g, reason: collision with root package name */
    public int f7934g;

    /* renamed from: h, reason: collision with root package name */
    public int f7935h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f7936j;

    /* renamed from: k, reason: collision with root package name */
    public i1 f7937k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f7938l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f7939m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f7940n;

    /* renamed from: o, reason: collision with root package name */
    public r3.c f7941o;

    /* renamed from: p, reason: collision with root package name */
    public androidx.fragment.app.r f7942p;

    public j1(Context context, boolean z10) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f7932c = new Rect();
        this.f7933f = 0;
        this.f7934g = 0;
        this.f7935h = 0;
        this.i = 0;
        this.f7939m = z10;
        setCacheColorHint(0);
    }

    public final int a(int i, int i3) {
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
            view.measure(i, i12 > 0 ? View.MeasureSpec.makeMeasureSpec(i12, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i11 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i3) {
                return i3;
            }
        }
        return measuredHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(android.view.MotionEvent r18, int r19) {
        /*
            Method dump skipped, instructions count: 530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.j1.b(android.view.MotionEvent, int):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f7932c;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.f7942p != null) {
            return;
        }
        super.drawableStateChanged();
        i1 i1Var = this.f7937k;
        if (i1Var != null) {
            i1Var.f7928f = true;
        }
        Drawable selector = getSelector();
        if (selector != null && this.f7940n && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return this.f7939m || super.hasFocus();
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        return this.f7939m || super.hasWindowFocus();
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f7939m || super.isFocused();
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        return (this.f7939m && this.f7938l) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f7942p = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f7942p == null) {
            androidx.fragment.app.r rVar = new androidx.fragment.app.r(6);
            rVar.f1301f = this;
            VarHandle.storeStoreFence();
            this.f7942p = rVar;
            post(rVar);
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
                if (g1.f7917d) {
                    try {
                        g1.f7914a.invoke(this, Integer.valueOf(iPointToPosition), childAt, Boolean.FALSE, -1, -1);
                        g1.f7915b.invoke(this, Integer.valueOf(iPointToPosition));
                        g1.f7916c.invoke(this, Integer.valueOf(iPointToPosition));
                    } catch (IllegalAccessException e10) {
                        e10.printStackTrace();
                    } catch (InvocationTargetException e11) {
                        e11.printStackTrace();
                    }
                } else {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
            }
            Drawable selector = getSelector();
            if (selector != null && this.f7940n && isPressed()) {
                selector.setState(getDrawableState());
            }
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f7936j = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        androidx.fragment.app.r rVar = this.f7942p;
        if (rVar != null) {
            j1 j1Var = (j1) rVar.f1301f;
            j1Var.f7942p = null;
            j1Var.removeCallbacks(rVar);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z10) {
        this.f7938l = z10;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        i1 i1Var = null;
        if (drawable != null) {
            i1 i1Var2 = new i1();
            Drawable drawable2 = i1Var2.f7927c;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            i1Var2.f7927c = drawable;
            drawable.setCallback(i1Var2);
            i1Var2.f7928f = true;
            i1Var = i1Var2;
        }
        this.f7937k = i1Var;
        super.setSelector(i1Var);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f7933f = rect.left;
        this.f7934g = rect.top;
        this.f7935h = rect.right;
        this.i = rect.bottom;
    }
}
