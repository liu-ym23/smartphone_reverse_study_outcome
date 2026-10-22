package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.annotation.DoNotInline;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;

/* JADX INFO: loaded from: classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
    public MenuItemHoverListener G;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class MenuDropDownListView extends s {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f859n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f860o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public MenuItemHoverListener f861p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public MenuItem f862q;

        public static class a {
            @DoNotInline
            public static int a(Configuration r10) {
                return r10.getLayoutDirection();
            }
        }

        public MenuDropDownListView(Context r10, boolean r11) {
            super(r10, r11);
            if (1 != a.a(r10.getResources().getConfiguration())) goto L5;
            this.f859n = 21;
            this.f860o = 22;
            return;
        L5:
            this.f859n = 22;
            this.f860o = 21;
        }

        @Override // androidx.appcompat.widget.s
        public /* bridge */ /* synthetic */ int d(int r10, int r11, int r12, int r13, int r14) {
            return super.d(r10, r11, r12, r13, r14);
        }

        @Override // androidx.appcompat.widget.s
        public /* bridge */ /* synthetic */ boolean e(MotionEvent r10, int r11) {
            return super.e(r10, r11);
        }

        @Override // androidx.appcompat.widget.s, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.s, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.s, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.s, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.s, android.view.View
        public boolean onHoverEvent(MotionEvent r10) {
            if (this.f861p == null) goto L27;
            ListAdapter r11 = getAdapter();
            if ((r11 instanceof HeaderViewListAdapter) == false) goto L7;
            HeaderViewListAdapter r12 = (HeaderViewListAdapter) r11;
            int r13 = r12.getHeadersCount();
            androidx.appcompat.view.menu.e r14 = (androidx.appcompat.view.menu.e) r12.getWrappedAdapter();
        L9:
            if (r10.getAction() == 10) goto L17;
            int r15 = pointToPosition((int) r10.getX(), (int) r10.getY());
            if (r15 == (-1)) goto L17;
            int r16 = r15 - r13;
            if (r16 < 0) goto L17;
            if (r16 >= r14.getCount()) goto L17;
            androidx.appcompat.view.menu.g r17 = r14.c(r16);
        L18:
            MenuItem r18 = this.f862q;
            if (r18 == r17) goto L27;
            MenuBuilder r19 = r14.b();
            if (r18 == null) goto L23;
            this.f861p.onItemHoverExit(r19, r18);
        L23:
            this.f862q = r17;
            if (r17 == null) goto L27;
            this.f861p.onItemHoverEnter(r19, r17);
        L17:
            r17 = null;
            goto L18
        L7:
            r14 = (androidx.appcompat.view.menu.e) r11;
            r13 = 0;
        L27:
            return super.onHoverEvent(r10);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int r10, KeyEvent r11) {
            ListMenuItemView r12 = (ListMenuItemView) getSelectedView();
            if (r12 != null) goto L5;
        L12:
            if (r12 == null) goto L22;
            if (r10 != this.f860o) goto L22;
            setSelection(-1);
            ListAdapter r13 = getAdapter();
            if ((r13 instanceof HeaderViewListAdapter) == false) goto L18;
            androidx.appcompat.view.menu.e r14 = (androidx.appcompat.view.menu.e) ((HeaderViewListAdapter) r13).getWrappedAdapter();
        L19:
            r14.b().close(false);
            return true;
        L18:
            r14 = (androidx.appcompat.view.menu.e) r13;
        L22:
            return super.onKeyDown(r10, r11);
        L5:
            if (r10 != this.f859n) goto L12;
            if (r12.isEnabled() == true) goto L9;
        L11:
            return true;
        L9:
            if (r12.getItemData().hasSubMenu() == false) goto L11;
            performItemClick(r12, getSelectedItemPosition(), getSelectedItemId());
            goto L11
        }

        @Override // androidx.appcompat.widget.s, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent r10) {
            return super.onTouchEvent(r10);
        }

        public void setHoverListener(MenuItemHoverListener r10) {
            this.f861p = r10;
        }

        @Override // androidx.appcompat.widget.s, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable r10) {
            super.setSelector(r10);
        }
    }

    public static class a {
        @DoNotInline
        public static void a(PopupWindow r10, Transition r11) {
            r10.setEnterTransition(r11);
        }

        @DoNotInline
        public static void b(PopupWindow r10, Transition r11) {
            r10.setExitTransition(r11);
        }
    }

    public static class b {
        @DoNotInline
        public static void a(PopupWindow r10, boolean r11) {
            r10.setTouchModal(r11);
        }
    }

    static {
    }

    public MenuPopupWindow(Context r10, AttributeSet r11, int r12, int r13) {
        super(r10, r11, r12, r13);
    }

    public void A(Object r10) {
        a.b(this.F, (Transition) r10);
    }

    public void B(MenuItemHoverListener r10) {
        this.G = r10;
    }

    public void C(boolean r10) {
        b.a(this.F, r10);
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    public s c(Context r10, boolean r11) {
        MenuDropDownListView r12 = new MenuDropDownListView(r10, r11);
        r12.setHoverListener(this);
        return r12;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverEnter(MenuBuilder r10, MenuItem r11) {
        MenuItemHoverListener r12 = this.G;
        if (r12 == null) goto L6;
        r12.onItemHoverEnter(r10, r11);
        return;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverExit(MenuBuilder r10, MenuItem r11) {
        MenuItemHoverListener r12 = this.G;
        if (r12 == null) goto L6;
        r12.onItemHoverExit(r10, r11);
        return;
    }

    public void z(Object r10) {
        a.a(this.F, (Transition) r10);
    }
}
