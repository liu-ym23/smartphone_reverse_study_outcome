package k;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import l.a0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public Context f6814a;

    /* renamed from: b, reason: collision with root package name */
    public a f6815b;

    @Override // android.view.ActionMode
    public final void finish() {
        this.f6815b.a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f6815b.b();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new a0(this.f6814a, this.f6815b.c());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f6815b.d();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f6815b.e();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f6815b.f6797c;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f6815b.g();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f6815b.f6798f;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f6815b.h();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f6815b.i();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f6815b.k(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f6815b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f6815b.f6797c = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f6815b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z10) {
        this.f6815b.p(z10);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i) {
        this.f6815b.l(i);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i) {
        this.f6815b.n(i);
    }
}
