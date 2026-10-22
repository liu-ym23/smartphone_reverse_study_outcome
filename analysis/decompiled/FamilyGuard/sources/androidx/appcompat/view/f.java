package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.b;
import java.util.ArrayList;
import l.MenuC0819d;
import l.MenuItemC0818c;

/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    final Context f7722a;

    /* renamed from: b, reason: collision with root package name */
    final b f7723b;

    public static class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f7724a;

        /* renamed from: b, reason: collision with root package name */
        final Context f7725b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList<f> f7726c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        final q.i<Menu, Menu> f7727d = new q.i<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f7725b = context;
            this.f7724a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f7727d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            MenuC0819d menuC0819d = new MenuC0819d(this.f7725b, (A.a) menu);
            this.f7727d.put(menu, menuC0819d);
            return menuC0819d;
        }

        @Override // androidx.appcompat.view.b.a
        public void a(b bVar) {
            this.f7724a.onDestroyActionMode(e(bVar));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(b bVar, Menu menu) {
            return this.f7724a.onCreateActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(b bVar, Menu menu) {
            return this.f7724a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // androidx.appcompat.view.b.a
        public boolean d(b bVar, MenuItem menuItem) {
            return this.f7724a.onActionItemClicked(e(bVar), new MenuItemC0818c(this.f7725b, (A.b) menuItem));
        }

        public ActionMode e(b bVar) {
            int size = this.f7726c.size();
            for (int i5 = 0; i5 < size; i5++) {
                f fVar = this.f7726c.get(i5);
                if (fVar != null && fVar.f7723b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f7725b, bVar);
            this.f7726c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f7722a = context;
        this.f7723b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f7723b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f7723b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuC0819d(this.f7722a, (A.a) this.f7723b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f7723b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f7723b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f7723b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f7723b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f7723b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f7723b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f7723b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f7723b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f7723b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f7723b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f7723b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z5) {
        this.f7723b.s(z5);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i5) {
        this.f7723b.n(i5);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i5) {
        this.f7723b.q(i5);
    }
}
