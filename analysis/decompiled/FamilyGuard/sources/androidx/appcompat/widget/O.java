package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;

/* loaded from: classes.dex */
public class O extends M implements N {

    /* renamed from: G, reason: collision with root package name */
    private N f8228G;

    static class a {
        static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    static class b {
        static void a(PopupWindow popupWindow, boolean z5) {
            popupWindow.setTouchModal(z5);
        }
    }

    public static class c extends J {

        /* renamed from: n, reason: collision with root package name */
        final int f8229n;

        /* renamed from: o, reason: collision with root package name */
        final int f8230o;

        /* renamed from: p, reason: collision with root package name */
        private N f8231p;

        /* renamed from: q, reason: collision with root package name */
        private MenuItem f8232q;

        public c(Context context, boolean z5) {
            super(context, z5);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.f8229n = 21;
                this.f8230o = 22;
            } else {
                this.f8229n = 22;
                this.f8230o = 21;
            }
        }

        @Override // androidx.appcompat.widget.J
        public /* bridge */ /* synthetic */ int d(int i5, int i6, int i7, int i8, int i9) {
            return super.d(i5, i6, i7, i8, i9);
        }

        @Override // androidx.appcompat.widget.J
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i5) {
            return super.e(motionEvent, i5);
        }

        @Override // androidx.appcompat.widget.J, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.J, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.J, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.J, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.J, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            androidx.appcompat.view.menu.d dVar;
            int headersCount;
            int iPointToPosition;
            int i5;
            if (this.f8231p != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    dVar = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
                } else {
                    dVar = (androidx.appcompat.view.menu.d) adapter;
                    headersCount = 0;
                }
                androidx.appcompat.view.menu.g item = (motionEvent.getAction() == 10 || (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i5 = iPointToPosition - headersCount) < 0 || i5 >= dVar.getCount()) ? null : dVar.getItem(i5);
                MenuItem menuItem = this.f8232q;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.e eVarB = dVar.b();
                    if (menuItem != null) {
                        this.f8231p.c(eVarB, menuItem);
                    }
                    this.f8232q = item;
                    if (item != null) {
                        this.f8231p.b(eVarB, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i5, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i5 == this.f8229n) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i5 != this.f8230o) {
                return super.onKeyDown(i5, keyEvent);
            }
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            (adapter instanceof HeaderViewListAdapter ? (androidx.appcompat.view.menu.d) ((HeaderViewListAdapter) adapter).getWrappedAdapter() : (androidx.appcompat.view.menu.d) adapter).b().e(false);
            return true;
        }

        @Override // androidx.appcompat.widget.J, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(N n5) {
            this.f8231p = n5;
        }

        @Override // androidx.appcompat.widget.J, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    public O(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
    }

    public void S(Object obj) {
        a.a(this.f8194F, (Transition) obj);
    }

    public void T(Object obj) {
        a.b(this.f8194F, (Transition) obj);
    }

    public void U(N n5) {
        this.f8228G = n5;
    }

    public void V(boolean z5) {
        b.a(this.f8194F, z5);
    }

    @Override // androidx.appcompat.widget.N
    public void b(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        N n5 = this.f8228G;
        if (n5 != null) {
            n5.b(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.N
    public void c(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        N n5 = this.f8228G;
        if (n5 != null) {
            n5.c(eVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.M
    J f(Context context, boolean z5) {
        c cVar = new c(context, z5);
        cVar.setHoverListener(this);
        return cVar;
    }
}
