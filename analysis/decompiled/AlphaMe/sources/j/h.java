package j;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import k.MenuC0643D;

/* loaded from: classes.dex */
public final class h extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13064a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC0624c f13065b;

    public h(Context context, AbstractC0624c abstractC0624c) {
        this.f13064a = context;
        this.f13065b = abstractC0624c;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f13065b.a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f13065b.b();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new MenuC0643D(this.f13064a, (F.a) this.f13065b.c());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f13065b.d();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f13065b.e();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f13065b.f13047a;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f13065b.f();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f13065b.f13048b;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f13065b.g();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f13065b.h();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f13065b.j(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f13065b.l(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f13065b.f13047a = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f13065b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z4) {
        this.f13065b.p(z4);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i4) {
        this.f13065b.k(i4);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i4) {
        this.f13065b.m(i4);
    }
}
