package stepos.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.view.ViewPropertyAnimatorCompat;
import stepos.support.v7.app.C1973w;

/* loaded from: classes4.dex */
public final class E implements I {

    /* renamed from: a, reason: collision with root package name */
    public StepOSCollapsingToolbarLayout f6455a;
    public I b;
    public int c;

    @Override // stepos.support.v7.widget.I
    public final void a(Menu menu, Va.A a3) {
        this.b.a(menu, a3);
    }

    @Override // stepos.support.v7.widget.I
    public final boolean b() {
        return this.b.b();
    }

    @Override // stepos.support.v7.widget.I
    public final void c(boolean z10) {
        this.b.c(z10);
    }

    @Override // stepos.support.v7.widget.I
    public final boolean canShowOverflowMenu() {
        return this.b.canShowOverflowMenu();
    }

    @Override // stepos.support.v7.widget.I
    public final void collapseActionView() {
        this.b.collapseActionView();
    }

    @Override // stepos.support.v7.widget.I
    public final void d(boolean z10) {
        this.b.d(z10);
    }

    @Override // stepos.support.v7.widget.I
    public final void dismissPopupMenus() {
        this.b.dismissPopupMenus();
    }

    @Override // stepos.support.v7.widget.I
    public final boolean e() {
        return this.b.e();
    }

    @Override // stepos.support.v7.widget.I
    public final void f(ViewGroup viewGroup) {
    }

    @Override // stepos.support.v7.widget.I
    public final void g(Menu menu, Va.A a3) {
        this.b.g(menu, a3);
    }

    @Override // stepos.support.v7.widget.I
    public final Context getContext() {
        return this.b.getContext();
    }

    @Override // stepos.support.v7.widget.I
    public final int getDisplayOptions() {
        return this.c;
    }

    @Override // stepos.support.v7.widget.I
    public final CharSequence getTitle() {
        return this.b.getTitle();
    }

    @Override // stepos.support.v7.widget.I
    public final ViewGroup getViewGroup() {
        return this.b.getViewGroup();
    }

    @Override // stepos.support.v7.widget.I
    public final void h(ViewGroup viewGroup) {
        this.b.h(viewGroup);
    }

    @Override // stepos.support.v7.widget.I
    public final boolean hasExpandedActionView() {
        return this.b.hasExpandedActionView();
    }

    @Override // stepos.support.v7.widget.I
    public final boolean hideOverflowMenu() {
        return this.b.hideOverflowMenu();
    }

    @Override // stepos.support.v7.widget.I
    public final void i() {
    }

    @Override // stepos.support.v7.widget.I
    public final void initIndeterminateProgress() {
        this.b.initIndeterminateProgress();
    }

    @Override // stepos.support.v7.widget.I
    public final void initProgress() {
        this.b.initProgress();
    }

    @Override // stepos.support.v7.widget.I
    public final boolean isOverflowMenuShowPending() {
        return this.b.isOverflowMenuShowPending();
    }

    @Override // stepos.support.v7.widget.I
    public final boolean isOverflowMenuShowing() {
        return this.b.isOverflowMenuShowing();
    }

    @Override // stepos.support.v7.widget.I
    public final boolean j() {
        return this.b.j();
    }

    @Override // stepos.support.v7.widget.I
    public final void k(C1973w c1973w) {
        this.b.k(c1973w);
    }

    @Override // stepos.support.v7.widget.I
    public final boolean l() {
        return this.b.l();
    }

    @Override // stepos.support.v7.widget.I
    public final void m(boolean z10) {
        this.b.m(z10);
    }

    @Override // stepos.support.v7.widget.I
    public final void setCollapsible(boolean z10) {
        this.b.setCollapsible(z10);
    }

    @Override // stepos.support.v7.widget.I
    public final void setDisplayOptions(int i) {
        StepOSCollapsingToolbarLayout stepOSCollapsingToolbarLayout = this.f6455a;
        I i6 = this.b;
        int i10 = this.c ^ i;
        this.c = i;
        if (i10 != 0) {
            i6.setDisplayOptions(i);
            if ((i & 8) != 0) {
                stepOSCollapsingToolbarLayout.setTitle(i6.getTitle());
            } else {
                stepOSCollapsingToolbarLayout.setTitle(null);
            }
        }
    }

    @Override // stepos.support.v7.widget.I
    public final void setHomeButtonEnabled(boolean z10) {
        this.b.setHomeButtonEnabled(z10);
    }

    @Override // stepos.support.v7.widget.I
    public final void setIcon(int i) {
        this.b.setIcon(i);
    }

    @Override // stepos.support.v7.widget.I
    public final void setLogo(int i) {
        this.b.setLogo(i);
    }

    @Override // stepos.support.v7.widget.I
    public final void setMenuPrepared() {
        this.b.setMenuPrepared();
    }

    @Override // stepos.support.v7.widget.I
    public final void setNavigationContentDescription(int i) {
        this.b.setNavigationContentDescription(i);
    }

    @Override // stepos.support.v7.widget.I
    public final void setNavigationIcon(Drawable drawable) {
        this.b.setNavigationIcon(drawable);
    }

    @Override // stepos.support.v7.widget.I
    public final void setTitle(CharSequence charSequence) {
        this.b.setTitle(charSequence);
        if ((this.c & 8) != 0) {
            this.f6455a.setTitle(charSequence);
        }
    }

    @Override // stepos.support.v7.widget.I
    public final void setWindowCallback(Window.Callback callback) {
        this.b.setWindowCallback(callback);
    }

    @Override // stepos.support.v7.widget.I
    public final void setWindowTitle(CharSequence charSequence) {
        this.b.setWindowTitle(charSequence);
    }

    @Override // stepos.support.v7.widget.I
    public final ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j5) {
        return this.b.setupAnimatorToVisibility(i, j5);
    }

    @Override // stepos.support.v7.widget.I
    public final boolean showOverflowMenu() {
        return this.b.showOverflowMenu();
    }

    @Override // stepos.support.v7.widget.I
    public final void setIcon(Drawable drawable) {
        this.b.setIcon(drawable);
    }
}
