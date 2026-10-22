package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import g.c;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class a extends ActionMode implements MenuBuilder.Callback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionBarContextView f433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ActionMode.Callback f434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference f435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MenuBuilder f438i;

    public a(Context r10, ActionBarContextView r11, ActionMode.Callback r12, boolean r13) {
        this.f432c = r10;
        this.f433d = r11;
        this.f434e = r12;
        MenuBuilder r14 = new MenuBuilder(r11.getContext()).setDefaultShowAsAction(1);
        this.f438i = r14;
        r14.setCallback(this);
        this.f437h = r13;
    }

    @Override // androidx.appcompat.view.ActionMode
    public void a() {
        if (this.f436g == false) goto L5;
        return;
    L5:
        this.f436g = true;
        this.f434e.onDestroyActionMode(this);
    }

    @Override // androidx.appcompat.view.ActionMode
    public View b() {
        WeakReference r10 = this.f435f;
        if (r10 != null) goto L7;
        return null;
    L7:
        return (View) r10.get();
    }

    @Override // androidx.appcompat.view.ActionMode
    public Menu c() {
        return this.f438i;
    }

    @Override // androidx.appcompat.view.ActionMode
    public MenuInflater d() {
        return new c(this.f433d.getContext());
    }

    @Override // androidx.appcompat.view.ActionMode
    public CharSequence e() {
        return this.f433d.getSubtitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public CharSequence g() {
        return this.f433d.getTitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public void i() {
        this.f434e.onPrepareActionMode(this, this.f438i);
    }

    @Override // androidx.appcompat.view.ActionMode
    public boolean j() {
        return this.f433d.j();
    }

    @Override // androidx.appcompat.view.ActionMode
    public void k(View r10) {
        this.f433d.setCustomView(r10);
        if (r10 == null) goto L5;
        WeakReference r11 = new WeakReference(r10);
    L6:
        this.f435f = r11;
        return;
    L5:
        r11 = null;
        goto L6
    }

    @Override // androidx.appcompat.view.ActionMode
    public void l(int r10) {
        m(this.f432c.getString(r10));
    }

    @Override // androidx.appcompat.view.ActionMode
    public void m(CharSequence r10) {
        this.f433d.setSubtitle(r10);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void o(int r10) {
        p(this.f432c.getString(r10));
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder r10, MenuItem r11) {
        return this.f434e.onActionItemClicked(this, r11);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder r10) {
        i();
        this.f433d.l();
    }

    @Override // androidx.appcompat.view.ActionMode
    public void p(CharSequence r10) {
        this.f433d.setTitle(r10);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void q(boolean r10) {
        super.q(r10);
        this.f433d.setTitleOptional(r10);
    }
}
