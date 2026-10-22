package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import k.C0658l;
import k.C0661o;
import k.C0663q;

/* loaded from: classes.dex */
public final class K0 extends C0229u0 {

    /* renamed from: m, reason: collision with root package name */
    public final int f2858m;

    /* renamed from: n, reason: collision with root package name */
    public final int f2859n;

    /* renamed from: o, reason: collision with root package name */
    public H0 f2860o;

    /* renamed from: p, reason: collision with root package name */
    public C0663q f2861p;

    public K0(Context context, boolean z4) {
        super(context, z4);
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.f2858m = 21;
            this.f2859n = 22;
        } else {
            this.f2858m = 22;
            this.f2859n = 21;
        }
    }

    @Override // androidx.appcompat.widget.C0229u0, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        C0658l c0658l;
        int headersCount;
        int iPointToPosition;
        int i4;
        if (this.f2860o != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                c0658l = (C0658l) headerViewListAdapter.getWrappedAdapter();
            } else {
                c0658l = (C0658l) adapter;
                headersCount = 0;
            }
            C0663q c0663qB = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i4 = iPointToPosition - headersCount) < 0 || i4 >= c0658l.getCount()) ? null : c0658l.getItem(i4);
            C0663q c0663q = this.f2861p;
            if (c0663q != c0663qB) {
                C0661o c0661o = c0658l.f13231a;
                if (c0663q != null) {
                    this.f2860o.c(c0661o, c0663q);
                }
                this.f2861p = c0663qB;
                if (c0663qB != null) {
                    this.f2860o.a(c0661o, c0663qB);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i4, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i4 == this.f2858m) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i4 != this.f2859n) {
            return super.onKeyDown(i4, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (C0658l) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (C0658l) adapter).f13231a.c(false);
        return true;
    }

    public void setHoverListener(H0 h02) {
        this.f2860o = h02;
    }

    @Override // androidx.appcompat.widget.C0229u0, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
