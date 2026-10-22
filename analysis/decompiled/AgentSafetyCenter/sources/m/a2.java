package m;

import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a2 extends j1 {

    /* renamed from: q, reason: collision with root package name */
    public int f7874q;

    /* renamed from: r, reason: collision with root package name */
    public int f7875r;

    /* renamed from: s, reason: collision with root package name */
    public x1 f7876s;

    /* renamed from: t, reason: collision with root package name */
    public l.n f7877t;

    @Override // m.j1, android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        l.i iVar;
        int headersCount;
        int iPointToPosition;
        int i;
        if (this.f7876s != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                headersCount = headerViewListAdapter.getHeadersCount();
                iVar = (l.i) headerViewListAdapter.getWrappedAdapter();
            } else {
                iVar = (l.i) adapter;
                headersCount = 0;
            }
            l.n nVarB = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i = iPointToPosition - headersCount) < 0 || i >= iVar.getCount()) ? null : iVar.getItem(i);
            l.n nVar = this.f7877t;
            if (nVar != nVarB) {
                l.l lVar = iVar.f7576a;
                if (nVar != null) {
                    this.f7876s.g(lVar, nVar);
                }
                this.f7877t = nVarB;
                if (nVarB != null) {
                    this.f7876s.n(lVar, nVarB);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i == this.f7874q) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        }
        if (listMenuItemView == null || i != this.f7875r) {
            return super.onKeyDown(i, keyEvent);
        }
        setSelection(-1);
        ListAdapter adapter = getAdapter();
        (adapter instanceof HeaderViewListAdapter ? (l.i) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (l.i) adapter).f7576a.c(false);
        return true;
    }

    public void setHoverListener(x1 x1Var) {
        this.f7876s = x1Var;
    }

    @Override // m.j1, android.widget.AbsListView
    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
