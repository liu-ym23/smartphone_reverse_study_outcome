package K3;

import L3.z;
import android.content.Context;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

/* loaded from: classes2.dex */
public final class h extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1090a;

    /* renamed from: b, reason: collision with root package name */
    public final c f1091b;

    public h(Context context, c cVar) {
        this.f1090a = context;
        this.f1091b = cVar;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (TextUtils.equals(stackTraceElement.getClassName(), "android.widget.AbsListView$MultiChoiceModeWrapper")) {
                return;
            }
        }
        this.f1091b.a();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f1091b.d();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new z(this.f1090a, (F.a) this.f1091b.e());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f1091b.f();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f1091b.g();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f1091b.f1049a;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f1091b.h();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f1091b.f1050b;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f1091b.i();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f1091b.j();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f1091b.k(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f1091b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f1091b.f1049a = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f1091b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z4) {
        this.f1091b.p(z4);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i4) {
        this.f1091b.l(i4);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i4) {
        this.f1091b.n(i4);
    }
}
