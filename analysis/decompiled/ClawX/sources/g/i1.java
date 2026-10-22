package g;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i1 extends t0 {

    /* renamed from: n, reason: collision with root package name */
    public final int f2733n;

    /* renamed from: o, reason: collision with root package name */
    public final int f2734o;

    /* renamed from: p, reason: collision with root package name */
    public f1 f2735p;

    /* renamed from: q, reason: collision with root package name */
    public f.k f2736q;

    public i1(Context context, boolean z) {
        super(context, z);
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            this.f2733n = 21;
            this.f2734o = 22;
        } else {
            this.f2733n = 22;
            this.f2734o = 21;
        }
    }

    @Override // g.t0, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        f.h hVar;
        int headersCount;
        int iPointToPosition;
        int i8;
        if (this.f2735p != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                hVar = (f.h) headerViewListAdapter.getWrappedAdapter();
            } else {
                hVar = (f.h) adapter;
                headersCount = 0;
            }
            f.k item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i8 = iPointToPosition - headersCount) < 0 || i8 >= hVar.getCount()) ? null : hVar.getItem(i8);
            f.k kVar = this.f2736q;
            if (kVar != item) {
                f.j jVar = hVar.f2448a;
                if (kVar != null) {
                    this.f2735p.h(jVar, kVar);
                }
                this.f2736q = item;
                if (item != null) {
                    this.f2735p.i(jVar, item);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i8, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i8 == this.f2733n) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i8 != this.f2734o) {
            return super.onKeyDown(i8, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (f.h) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (f.h) adapter).f2448a.c(false);
        return true;
    }

    public void setHoverListener(f1 f1Var) {
        this.f2735p = f1Var;
    }

    @Override // g.t0, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
