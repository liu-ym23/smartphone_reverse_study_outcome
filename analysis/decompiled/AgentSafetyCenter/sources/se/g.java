package se;

import android.content.Context;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import te.y;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class g extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public Context f12227a;

    /* renamed from: b, reason: collision with root package name */
    public b f12228b;

    @Override // android.view.ActionMode
    public final void finish() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (TextUtils.equals(stackTraceElement.getClassName(), "android.widget.AbsListView$MultiChoiceModeWrapper")) {
                return;
            }
        }
        this.f12228b.a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f12228b.b();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new y(this.f12227a, this.f12228b.e());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f12228b.f();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f12228b.g();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f12228b.f12198c;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f12228b.h();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f12228b.f12199f;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f12228b.i();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f12228b.j();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f12228b.k(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f12228b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f12228b.f12198c = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f12228b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z10) {
        this.f12228b.p(z10);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i) {
        this.f12228b.l(i);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i) {
        this.f12228b.n(i);
    }
}
