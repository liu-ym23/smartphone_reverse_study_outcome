package k;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* renamed from: k.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0669w implements InterfaceC0644E, InterfaceC0640A, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Rect f13305a;

    public static int m(C0658l c0658l, Context context, int i4) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = c0658l.getCount();
        int i5 = 0;
        int i6 = 0;
        FrameLayout frameLayout = null;
        View view = null;
        for (int i7 = 0; i7 < count; i7++) {
            int itemViewType = c0658l.getItemViewType(i7);
            if (itemViewType != i6) {
                view = null;
                i6 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = c0658l.getView(i7, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i4) {
                return i4;
            }
            if (measuredWidth > i5) {
                i5 = measuredWidth;
            }
        }
        return i5;
    }

    public static boolean u(C0661o c0661o) {
        int size = c0661o.f13243f.size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = c0661o.getItem(i4);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // k.InterfaceC0640A
    public final boolean d(C0663q c0663q) {
        return false;
    }

    @Override // k.InterfaceC0640A
    public final boolean h(C0663q c0663q) {
        return false;
    }

    @Override // k.InterfaceC0640A
    public final void k(Context context, C0661o c0661o) {
    }

    public abstract void l(C0661o c0661o);

    public abstract void n(View view);

    public abstract void o(boolean z4);

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        (listAdapter instanceof HeaderViewListAdapter ? (C0658l) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (C0658l) listAdapter).f13231a.q((MenuItem) listAdapter.getItem(i4), this, (this instanceof ViewOnKeyListenerC0655i) ^ true ? 0 : 4);
    }

    public abstract void p(int i4);

    public abstract void q(int i4);

    public abstract void r(PopupWindow.OnDismissListener onDismissListener);

    public abstract void s(boolean z4);

    public abstract void t(int i4);
}
