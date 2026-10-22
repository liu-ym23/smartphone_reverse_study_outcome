package k;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
import p.o;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9784a;

    /* renamed from: b, reason: collision with root package name */
    public final k.a f9785b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f9786a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f9787b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList<e> f9788c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        public final o<Menu, Menu> f9789d = new o<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f9787b = context;
            this.f9786a = callback;
        }

        public final e a(k.a aVar) {
            ArrayList<e> arrayList = this.f9788c;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                e eVar = arrayList.get(i10);
                if (eVar != null && eVar.f9785b == aVar) {
                    return eVar;
                }
            }
            e eVar2 = new e(this.f9787b, aVar);
            arrayList.add(eVar2);
            return eVar2;
        }

        public final boolean b(k.a aVar, MenuItem menuItem) {
            return this.f9786a.onActionItemClicked(a(aVar), new l.c(this.f9787b, (p0.b) menuItem));
        }

        public final boolean c(k.a aVar, Menu menu) {
            e eVarA = a(aVar);
            o<Menu, Menu> oVar = this.f9789d;
            Menu eVar = oVar.get(menu);
            if (eVar == null) {
                eVar = new l.e(this.f9787b, (p0.a) menu);
                oVar.put(menu, eVar);
            }
            return this.f9786a.onCreateActionMode(eVarA, eVar);
        }
    }

    public e(Context context, k.a aVar) {
        this.f9784a = context;
        this.f9785b = aVar;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f9785b.c();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f9785b.d();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new l.e(this.f9784a, this.f9785b.e());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f9785b.f();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f9785b.g();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f9785b.f9771a;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f9785b.h();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f9785b.f9772b;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f9785b.i();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f9785b.j();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f9785b.k(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f9785b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f9785b.f9771a = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f9785b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z) {
        this.f9785b.p(z);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i10) {
        this.f9785b.l(i10);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i10) {
        this.f9785b.n(i10);
    }
}
