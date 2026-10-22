package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CascadingMenuPopup extends i implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int B = 0;
    public boolean A;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f461f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f462g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List f463h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f464i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f465j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f466k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MenuItemHoverListener f467l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f468m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f469n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f470o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f471p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f472q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f473r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f474s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f475t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f476u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f477v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f478w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public MenuPresenter.Callback f479x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ViewTreeObserver f480y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PopupWindow.OnDismissListener f481z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CascadingMenuPopup f482a;

        public a(CascadingMenuPopup r10) {
            this.f482a = r10;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f482a.isShowing() == true) goto L5;
            return;
        L5:
            if (this.f482a.f464i.size() > 0) goto L7;
            return;
        L7:
            if (((d) this.f482a.f464i.get(0)).f489a.l() == true) goto L22;
            View r10 = this.f482a.f471p;
            if (r10 != null) goto L11;
        L17:
            this.f482a.dismiss();
            return;
        L11:
            if (r10.isShown() == false) goto L17;
            Iterator r11 = this.f482a.f464i.iterator();
        L15:
            if (r11.hasNext() == false) goto L23;
            ((d) r11.next()).f489a.show();
            goto L15
        L23:
            return;
        }
    }

    public class b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CascadingMenuPopup f483a;

        public b(CascadingMenuPopup r10) {
            this.f483a = r10;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
            ViewTreeObserver r11 = this.f483a.f480y;
            if (r11 != null) goto L5;
        L8:
            r10.removeOnAttachStateChangeListener(this);
            return;
        L5:
            if (r11.isAlive() == true) goto L7;
            CascadingMenuPopup r12 = this.f483a;
            r12.f480y = r10.getViewTreeObserver();
        L7:
            CascadingMenuPopup r13 = this.f483a;
            r13.f480y.removeGlobalOnLayoutListener(r13.f465j);
            goto L8
        }
    }

    public class c implements MenuItemHoverListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CascadingMenuPopup f484a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f485a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MenuItem f486b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ MenuBuilder f487c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ c f488d;

            public a(c r10, d r11, MenuItem r12, MenuBuilder r13) {
                this.f488d = r10;
                this.f485a = r11;
                this.f486b = r12;
                this.f487c = r13;
            }

            @Override // java.lang.Runnable
            public void run() {
                d r10 = this.f485a;
                if (r10 == null) goto L6;
                this.f488d.f484a.A = true;
                r10.f490b.close(false);
                this.f488d.f484a.A = false;
            L6:
                if (this.f486b.isEnabled() == true) goto L8;
                return;
            L8:
                if (this.f486b.hasSubMenu() == false) goto L12;
                this.f487c.performItemAction(this.f486b, 4);
                return;
            }
        }

        public c(CascadingMenuPopup r10) {
            this.f484a = r10;
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverEnter(MenuBuilder r10, MenuItem r11) {
            d r12 = null;
            this.f484a.f462g.removeCallbacksAndMessages(null);
            int r13 = this.f484a.f464i.size();
            int r14 = 0;
        L4:
            if (r14 >= r13) goto L9;
            if (r10 == ((d) this.f484a.f464i.get(r14)).f490b) goto L10;
            r14 = r14 + 1;
        L10:
            if (r14 != (-1)) goto L12;
            return;
        L12:
            int r15 = r14 + 1;
            if (r15 >= this.f484a.f464i.size()) goto L15;
            r12 = (d) this.f484a.f464i.get(r15);
        L15:
            this.f484a.f462g.postAtTime(new a(this, r12, r11, r10), r10, SystemClock.uptimeMillis() + 200);
            return;
        L9:
            r14 = -1;
            goto L10
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverExit(MenuBuilder r10, MenuItem r11) {
            this.f484a.f462g.removeCallbacksAndMessages(r10);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MenuPopupWindow f489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MenuBuilder f490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f491c;

        public d(MenuPopupWindow r10, MenuBuilder r11, int r12) {
            this.f489a = r10;
            this.f490b = r11;
            this.f491c = r12;
        }

        public ListView a() {
            return this.f489a.getListView();
        }
    }

    static {
        B = R$layout.abc_cascading_menu_item_layout;
    }

    public CascadingMenuPopup(Context r10, View r11, int r12, int r13, boolean r14) {
        this.f463h = new ArrayList();
        this.f464i = new ArrayList();
        this.f465j = new a(this);
        this.f466k = new b(this);
        this.f467l = new c(this);
        this.f468m = 0;
        this.f469n = 0;
        this.f457b = r10;
        this.f470o = r11;
        this.f459d = r12;
        this.f460e = r13;
        this.f461f = r14;
        this.f477v = false;
        this.f472q = r();
        Resources r15 = r10.getResources();
        this.f458c = Math.max(r15.getDisplayMetrics().widthPixels / 2, r15.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f462g = new Handler();
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(MenuBuilder r10) {
        r10.addMenuPresenter(this, this.f457b);
        if (isShowing() == false) goto L5;
        t(r10);
        return;
    L5:
        this.f463h.add(r10);
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        int r10 = this.f464i.size();
        if (r10 <= 0) goto L10;
        d[] r11 = (d[]) this.f464i.toArray(new d[r10]);
        int r12 = r10 - 1;
    L5:
        if (r12 < 0) goto L14;
        d r13 = r11[r12];
        if (r13.f489a.isShowing() == false) goto L9;
        r13.f489a.dismiss();
    L9:
        r12 = r12 - 1;
        goto L5
    L14:
        return;
    }

    @Override // androidx.appcompat.view.menu.i
    public void e(View r10) {
        if (this.f470o == r10) goto L6;
        this.f470o = r10;
        this.f469n = androidx.core.view.c.b(this.f468m, ViewCompat.A(r10));
        return;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public void g(boolean r10) {
        this.f477v = r10;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        if (this.f464i.isEmpty() == false) goto L5;
        return null;
    L5:
        List r10 = this.f464i;
        return ((d) r10.get(r10.size() - 1)).a();
    }

    @Override // androidx.appcompat.view.menu.i
    public void h(int r10) {
        if (this.f468m == r10) goto L6;
        this.f468m = r10;
        this.f469n = androidx.core.view.c.b(r10, ViewCompat.A(this.f470o));
        return;
    }

    @Override // androidx.appcompat.view.menu.i
    public void i(int r10) {
        this.f473r = true;
        this.f475t = r10;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        if (this.f464i.size() > 0) goto L5;
        return false;
    L5:
        if (((d) this.f464i.get(0)).f489a.isShowing() == false) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public void j(boolean r10) {
        this.f478w = r10;
    }

    @Override // androidx.appcompat.view.menu.i
    public void k(int r10) {
        this.f474s = true;
        this.f476u = r10;
    }

    public final MenuPopupWindow n() {
        MenuPopupWindow r10 = new MenuPopupWindow(this.f457b, null, this.f459d, this.f460e);
        r10.B(this.f467l);
        r10.setOnItemClickListener(this);
        r10.setOnDismissListener(this);
        r10.n(this.f470o);
        r10.q(this.f469n);
        r10.t(true);
        r10.s(2);
        return r10;
    }

    public final int o(MenuBuilder r10) {
        int r11 = this.f464i.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (r10 == ((d) this.f464i.get(r12)).f490b) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return r12;
    L8:
        return -1;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r10, boolean r11) {
        int r12 = o(r10);
        if (r12 >= 0) goto L5;
        return;
    L5:
        int r13 = r12 + 1;
        if (r13 >= this.f464i.size()) goto L8;
        ((d) this.f464i.get(r13)).f490b.close(false);
    L8:
        d r14 = (d) this.f464i.remove(r12);
        r14.f490b.removeMenuPresenter(this);
        if (this.A == false) goto L11;
        r14.f489a.A(null);
        r14.f489a.o(0);
    L11:
        r14.f489a.dismiss();
        int r15 = this.f464i.size();
        if (r15 <= 0) goto L14;
        this.f472q = ((d) this.f464i.get(r15 - 1)).f491c;
    L15:
        if (r15 != 0) goto L26;
        dismiss();
        MenuPresenter.Callback r16 = this.f479x;
        if (r16 == null) goto L19;
        r16.onCloseMenu(r10, true);
    L19:
        ViewTreeObserver r17 = this.f480y;
        if (r17 != null) goto L22;
    L25:
        this.f471p.removeOnAttachStateChangeListener(this.f466k);
        this.f481z.onDismiss();
        return;
    L22:
        if (r17.isAlive() == false) goto L24;
        this.f480y.removeGlobalOnLayoutListener(this.f465j);
    L24:
        this.f480y = null;
        goto L25
    L26:
        if (r11 == false) goto L30;
        ((d) this.f464i.get(0)).f490b.close(false);
        return;
    L30:
        return;
    L14:
        this.f472q = r();
        goto L15
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        int r10 = this.f464i.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        d r12 = (d) this.f464i.get(r11);
        if (r12.f489a.isShowing() == false) goto L9;
        r11 = r11 + 1;
    L9:
        if (r12 == null) goto L14;
        r12.f490b.close(false);
        return;
    L14:
        return;
    L8:
        r12 = null;
        goto L9
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View r10, int r11, KeyEvent r12) {
        if (r12.getAction() == 1) goto L5;
        return false;
    L5:
        if (r11 != 82) goto L10;
        dismiss();
        return true;
    L10:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable r10) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(m r10) {
        Iterator r11 = this.f464i.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        d r12 = (d) r11.next();
        if (r10 != r12.f490b) goto L4;
        r12.a().requestFocus();
        return true;
    L10:
        if (r10.hasVisibleItems() == false) goto L15;
        a(r10);
        MenuPresenter.Callback r13 = this.f479x;
        if (r13 == null) goto L14;
        r13.onOpenSubMenu(r10);
    L14:
        return true;
    L15:
        return false;
    }

    public final MenuItem p(MenuBuilder r10, MenuBuilder r11) {
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L10;
        MenuItem r14 = r10.getItem(r13);
        if (r14.hasSubMenu() == false) goto L9;
        if (r11 != r14.getSubMenu()) goto L9;
        return r14;
    L9:
        r13 = r13 + 1;
        goto L3
    L10:
        return null;
    }

    public final View q(d r10, MenuBuilder r11) {
        MenuItem r12 = p(r10.f490b, r11);
        if (r12 != null) goto L5;
        return null;
    L5:
        ListView r13 = r10.a();
        ListAdapter r14 = r13.getAdapter();
        int r15 = 0;
        if ((r14 instanceof HeaderViewListAdapter) == false) goto L8;
        HeaderViewListAdapter r16 = (HeaderViewListAdapter) r14;
        int r17 = r16.getHeadersCount();
        e r18 = (e) r16.getWrappedAdapter();
    L9:
        int r19 = r18.getCount();
    L11:
        if (r15 >= r19) goto L16;
        if (r12 == r18.c(r15)) goto L17;
        r15 = r15 + 1;
    L17:
        if (r15 != (-1)) goto L19;
        return null;
    L19:
        int r20 = (r15 + r17) - r13.getFirstVisiblePosition();
        if (r20 >= 0) goto L22;
    L26:
        return null;
    L22:
        if (r20 >= r13.getChildCount()) goto L26;
        return r13.getChildAt(r20);
    L16:
        r15 = -1;
        goto L17
    L8:
        r18 = (e) r14;
        r17 = 0;
        goto L9
    }

    public final int r() {
        if (ViewCompat.A(this.f470o) != 1) goto L6;
        return 0;
    L6:
        return 1;
    }

    public final int s(int r10) {
        List r11 = this.f464i;
        ListView r12 = ((d) r11.get(r11.size() - 1)).a();
        int[] r13 = new int[2];
        r12.getLocationOnScreen(r13);
        Rect r14 = new Rect();
        this.f471p.getWindowVisibleDisplayFrame(r14);
        if (this.f472q != 1) goto L9;
        if (((r13[0] + r12.getWidth()) + r10) <= r14.right) goto L7;
        return 0;
    L7:
        return 1;
    L9:
        if ((r13[0] - r10) >= 0) goto L11;
        return 1;
    L11:
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r10) {
        this.f479x = r10;
    }

    @Override // androidx.appcompat.view.menu.i
    public void setOnDismissListener(PopupWindow.OnDismissListener r10) {
        this.f481z = r10;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (isShowing() == false) goto L5;
        return;
    L5:
        Iterator r10 = this.f463h.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        t((MenuBuilder) r10.next());
        goto L7
    L9:
        this.f463h.clear();
        View r11 = this.f470o;
        this.f471p = r11;
        if (r11 != null) goto L12;
        return;
    L12:
        if (this.f480y != null) goto L14;
        boolean r12 = true;
    L15:
        ViewTreeObserver r13 = r11.getViewTreeObserver();
        this.f480y = r13;
        if (r12 == false) goto L18;
        r13.addOnGlobalLayoutListener(this.f465j);
    L18:
        this.f471p.addOnAttachStateChangeListener(this.f466k);
        return;
    L14:
        r12 = false;
        goto L15
    }

    public final void t(MenuBuilder r12) {
        LayoutInflater r10 = LayoutInflater.from(this.f457b);
        e r11 = new e(r12, r10, this.f461f, B);
        if (isShowing() == true) goto L8;
        if (this.f477v == false) goto L8;
        r11.d(true);
    L10:
        int r13 = i.d(r11, null, this.f457b, this.f458c);
        MenuPopupWindow r14 = n();
        r14.setAdapter(r11);
        r14.p(r13);
        r14.q(this.f469n);
        if (this.f464i.size() <= 0) goto L13;
        List r15 = this.f464i;
        d r16 = (d) r15.get(r15.size() - 1);
        View r17 = q(r16, r12);
    L15:
        if (r17 == null) goto L30;
        r14.C(false);
        r14.z(null);
        int r18 = s(r13);
        if (r18 != 1) goto L19;
        boolean r19 = true;
    L20:
        this.f472q = r18;
        r14.n(r17);
        if ((this.f469n & 5) != 5) goto L25;
        if (r19 == true) goto L28;
        r13 = 0 - r17.getWidth();
    L28:
        r14.setHorizontalOffset(r13);
        r14.u(true);
        r14.setVerticalOffset(0);
    L36:
        this.f464i.add(new d(r14, r12, this.f472q));
        r14.show();
        ListView r20 = r14.getListView();
        r20.setOnKeyListener(this);
        if (r16 == null) goto L39;
        return;
    L39:
        if (this.f478w == true) goto L41;
        return;
    L41:
        if (r12.getHeaderTitle() == null) goto L46;
        FrameLayout r110 = (FrameLayout) r10.inflate(R$layout.abc_popup_menu_header_item_layout, r20, false);
        TextView r21 = (TextView) r110.findViewById(R.id.title);
        r110.setEnabled(false);
        r21.setText(r12.getHeaderTitle());
        r20.addHeaderView(r110, null, false);
        r14.show();
        return;
    L46:
        return;
    L25:
        if (r19 == false) goto L27;
        r13 = r17.getWidth();
        goto L28
    L27:
        r13 = 0 - r13;
        goto L28
    L19:
        r19 = false;
        goto L20
    L30:
        if (this.f473r == false) goto L33;
        r14.setHorizontalOffset(this.f475t);
    L33:
        if (this.f474s == false) goto L35;
        r14.setVerticalOffset(this.f476u);
    L35:
        r14.r(c());
        goto L36
    L13:
        r16 = null;
        r17 = null;
    L8:
        if (isShowing() == false) goto L10;
        r11.d(i.l(r12));
        goto L10
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r10) {
        Iterator r11 = this.f464i.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        i.m(((d) r11.next()).a().getAdapter()).notifyDataSetChanged();
        goto L4
    }
}
