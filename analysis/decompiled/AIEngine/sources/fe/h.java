package fe;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import fe.b;
import java.util.ArrayList;
import p.o;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@TargetApi(11)
/* loaded from: classes.dex */
public final class h extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8882a;

    /* renamed from: b, reason: collision with root package name */
    public final b f8883b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements b.InterfaceC0082b {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f8884a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f8885b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList<h> f8886c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        public final o<Menu, Menu> f8887d = new o<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f8885b = context;
            this.f8884a = callback;
        }

        @Override // fe.b.InterfaceC0082b
        public final boolean a(b bVar, MenuItem menuItem) {
            return this.f8884a.onActionItemClicked(e(bVar), new ge.i(this.f8885b, (p0.b) menuItem));
        }

        @Override // fe.b.InterfaceC0082b
        public final void b(b bVar) {
            this.f8884a.onDestroyActionMode(e(bVar));
        }

        @Override // fe.b.InterfaceC0082b
        public final boolean c(b bVar, Menu menu) {
            h hVarE = e(bVar);
            o<Menu, Menu> oVar = this.f8887d;
            Menu menu2 = oVar.get(menu);
            if (menu2 == null) {
                ge.j jVar = new ge.j(this.f8885b, (p0.a) menu);
                oVar.put(menu, jVar);
                menu2 = jVar;
            }
            return this.f8884a.onPrepareActionMode(hVarE, menu2);
        }

        @Override // fe.b.InterfaceC0082b
        public final boolean d(b bVar, Menu menu) {
            h hVarE = e(bVar);
            o<Menu, Menu> oVar = this.f8887d;
            Menu menu2 = oVar.get(menu);
            if (menu2 == null) {
                ge.j jVar = new ge.j(this.f8885b, (p0.a) menu);
                oVar.put(menu, jVar);
                menu2 = jVar;
            }
            return this.f8884a.onCreateActionMode(hVarE, menu2);
        }

        public final h e(b bVar) {
            ArrayList<h> arrayList = this.f8886c;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                h hVar = arrayList.get(i10);
                if (hVar != null && hVar.f8883b == bVar) {
                    return hVar;
                }
            }
            h hVar2 = new h(this.f8885b, bVar);
            arrayList.add(hVar2);
            return hVar2;
        }
    }

    public h(Context context, b bVar) {
        this.f8882a = context;
        this.f8883b = bVar;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (TextUtils.equals(stackTraceElement.getClassName(), "android.widget.AbsListView$MultiChoiceModeWrapper")) {
                return;
            }
        }
        this.f8883b.c();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f8883b.d();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new ge.j(this.f8882a, this.f8883b.e());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f8883b.f();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f8883b.g();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f8883b.f8851a;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f8883b.h();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f8883b.f8852b;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f8883b.i();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f8883b.j();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f8883b.k(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f8883b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f8883b.f8851a = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f8883b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z) {
        this.f8883b.p(z);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i10) {
        this.f8883b.l(i10);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i10) {
        this.f8883b.n(i10);
    }
}
