package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public final class l extends i implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, MenuPresenter, View.OnKeyListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f620v = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MenuBuilder f622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f623d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f624e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f625f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f626g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f627h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MenuPopupWindow f628i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f629j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f630k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PopupWindow.OnDismissListener f631l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f632m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f633n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public MenuPresenter.Callback f634o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewTreeObserver f635p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f636q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f637r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f638s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f639t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f640u;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f641a;

        public a(l r10) {
            this.f641a = r10;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f641a.isShowing() == true) goto L5;
            return;
        L5:
            if (this.f641a.f628i.l() == true) goto L15;
            View r10 = this.f641a.f633n;
            if (r10 != null) goto L9;
        L12:
            this.f641a.dismiss();
            return;
        L9:
            if (r10.isShown() == false) goto L12;
            this.f641a.f628i.show();
            return;
        }
    }

    public class b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f642a;

        public b(l r10) {
            this.f642a = r10;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View r10) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View r10) {
            ViewTreeObserver r11 = this.f642a.f635p;
            if (r11 != null) goto L5;
        L8:
            r10.removeOnAttachStateChangeListener(this);
            return;
        L5:
            if (r11.isAlive() == true) goto L7;
            l r12 = this.f642a;
            r12.f635p = r10.getViewTreeObserver();
        L7:
            l r13 = this.f642a;
            r13.f635p.removeGlobalOnLayoutListener(r13.f629j);
            goto L8
        }
    }

    static {
        f620v = R$layout.abc_popup_menu_item_layout;
    }

    public l(Context r10, MenuBuilder r11, View r12, int r13, int r14, boolean r15) {
        this.f629j = new a(this);
        this.f630k = new b(this);
        this.f639t = 0;
        this.f621b = r10;
        this.f622c = r11;
        this.f624e = r15;
        this.f623d = new e(r11, LayoutInflater.from(r10), r15, f620v);
        this.f626g = r13;
        this.f627h = r14;
        Resources r16 = r10.getResources();
        this.f625f = Math.max(r16.getDisplayMetrics().widthPixels / 2, r16.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f632m = r12;
        this.f628i = new MenuPopupWindow(r10, null, r13, r14);
        r11.addMenuPresenter(this, r10);
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(MenuBuilder r10) {
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        if (isShowing() == false) goto L6;
        this.f628i.dismiss();
        return;
    }

    @Override // androidx.appcompat.view.menu.i
    public void e(View r10) {
        this.f632m = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public void g(boolean r10) {
        this.f623d.d(r10);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.f628i.getListView();
    }

    @Override // androidx.appcompat.view.menu.i
    public void h(int r10) {
        this.f639t = r10;
    }

    @Override // androidx.appcompat.view.menu.i
    public void i(int r10) {
        this.f628i.setHorizontalOffset(r10);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        if (this.f636q == false) goto L5;
    L7:
        return false;
    L5:
        if (this.f628i.isShowing() == false) goto L7;
        return true;
    }

    @Override // androidx.appcompat.view.menu.i
    public void j(boolean r10) {
        this.f640u = r10;
    }

    @Override // androidx.appcompat.view.menu.i
    public void k(int r10) {
        this.f628i.setVerticalOffset(r10);
    }

    public final boolean n() {
        if (isShowing() == false) goto L6;
        return true;
    L6:
        if (this.f636q == true) goto L30;
        View r10 = this.f632m;
        if (r10 == null) goto L30;
        this.f633n = r10;
        this.f628i.setOnDismissListener(this);
        this.f628i.setOnItemClickListener(this);
        this.f628i.t(true);
        View r11 = this.f633n;
        if (this.f635p != null) goto L13;
        boolean r12 = true;
    L14:
        ViewTreeObserver r13 = r11.getViewTreeObserver();
        this.f635p = r13;
        if (r12 == false) goto L17;
        r13.addOnGlobalLayoutListener(this.f629j);
    L17:
        r11.addOnAttachStateChangeListener(this.f630k);
        this.f628i.n(r11);
        this.f628i.q(this.f639t);
        if (this.f637r == true) goto L20;
        this.f638s = i.d(this.f623d, null, this.f621b, this.f625f);
        this.f637r = true;
    L20:
        this.f628i.p(this.f638s);
        this.f628i.s(2);
        this.f628i.r(c());
        this.f628i.show();
        ListView r14 = this.f628i.getListView();
        r14.setOnKeyListener(this);
        if (this.f640u == true) goto L23;
    L28:
        this.f628i.setAdapter(this.f623d);
        this.f628i.show();
        return true;
    L23:
        if (this.f622c.getHeaderTitle() == null) goto L28;
        FrameLayout r15 = (FrameLayout) LayoutInflater.from(this.f621b).inflate(R$layout.abc_popup_menu_header_item_layout, r14, false);
        TextView r16 = (TextView) r15.findViewById(R.id.title);
        if (r16 == null) goto L27;
        r16.setText(this.f622c.getHeaderTitle());
    L27:
        r15.setEnabled(false);
        r14.addHeaderView(r15, null, false);
        goto L28
    L13:
        r12 = false;
    L30:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder r10, boolean r11) {
        if (r10 == this.f622c) goto L5;
        return;
    L5:
        dismiss();
        MenuPresenter.Callback r12 = this.f634o;
        if (r12 == null) goto L9;
        r12.onCloseMenu(r10, r11);
        return;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f636q = true;
        this.f622c.close();
        ViewTreeObserver r10 = this.f635p;
        if (r10 != null) goto L5;
    L8:
        this.f633n.removeOnAttachStateChangeListener(this.f630k);
        PopupWindow.OnDismissListener r11 = this.f631l;
        if (r11 == null) goto L12;
        r11.onDismiss();
        return;
    L12:
        return;
    L5:
        if (r10.isAlive() == true) goto L7;
        this.f635p = this.f633n.getViewTreeObserver();
    L7:
        this.f635p.removeGlobalOnLayoutListener(this.f629j);
        this.f635p = null;
        goto L8
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
        if (r10.hasVisibleItems() == false) goto L14;
        j r11 = new j(this.f621b, r10, this.f633n, this.f624e, this.f626g, this.f627h);
        r11.setPresenterCallback(this.f634o);
        r11.f(i.l(r10));
        r11.setOnDismissListener(this.f631l);
        this.f631l = null;
        this.f622c.close(false);
        int r12 = this.f628i.getHorizontalOffset();
        int r13 = this.f628i.getVerticalOffset();
        if ((Gravity.getAbsoluteGravity(this.f639t, ViewCompat.A(this.f632m)) & 7) != 5) goto L8;
        r12 = r12 + this.f632m.getWidth();
    L8:
        if (r11.k(r12, r13) == false) goto L14;
        MenuPresenter.Callback r14 = this.f634o;
        if (r14 == null) goto L15;
        r14.onOpenSubMenu(r10);
        return true;
    L15:
        return true;
    L14:
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback r10) {
        this.f634o = r10;
    }

    @Override // androidx.appcompat.view.menu.i
    public void setOnDismissListener(PopupWindow.OnDismissListener r10) {
        this.f631l = r10;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (n() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean r10) {
        this.f637r = false;
        e r11 = this.f623d;
        if (r11 == null) goto L6;
        r11.notifyDataSetChanged();
        return;
    }
}
