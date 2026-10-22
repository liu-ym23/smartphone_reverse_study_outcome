package i;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.collection.t;
import i.AbstractC4156b;
import j.MenuC4740e;
import j.MenuItemC4738c;
import java.util.ArrayList;
import v0.InterfaceMenuC5650a;
import v0.InterfaceMenuItemC5651b;

/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f33003a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC4156b f33004b;

    public static class a implements AbstractC4156b.a {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f33005a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f33006b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList<f> f33007c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        public final t<Menu, Menu> f33008d = new t<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f33006b = context;
            this.f33005a = callback;
        }

        @Override // i.AbstractC4156b.a
        public boolean a(AbstractC4156b abstractC4156b, MenuItem menuItem) {
            return this.f33005a.onActionItemClicked(e(abstractC4156b), new MenuItemC4738c(this.f33006b, (InterfaceMenuItemC5651b) menuItem));
        }

        @Override // i.AbstractC4156b.a
        public void b(AbstractC4156b abstractC4156b) {
            this.f33005a.onDestroyActionMode(e(abstractC4156b));
        }

        @Override // i.AbstractC4156b.a
        public boolean c(AbstractC4156b abstractC4156b, Menu menu) {
            return this.f33005a.onPrepareActionMode(e(abstractC4156b), f(menu));
        }

        @Override // i.AbstractC4156b.a
        public boolean d(AbstractC4156b abstractC4156b, Menu menu) {
            return this.f33005a.onCreateActionMode(e(abstractC4156b), f(menu));
        }

        public ActionMode e(AbstractC4156b abstractC4156b) {
            int size = this.f33007c.size();
            for (int i10 = 0; i10 < size; i10++) {
                f fVar = this.f33007c.get(i10);
                if (fVar != null && fVar.f33004b == abstractC4156b) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f33006b, abstractC4156b);
            this.f33007c.add(fVar2);
            return fVar2;
        }

        public final Menu f(Menu menu) {
            Menu menu2 = this.f33008d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            MenuC4740e menuC4740e = new MenuC4740e(this.f33006b, (InterfaceMenuC5650a) menu);
            this.f33008d.put(menu, menuC4740e);
            return menuC4740e;
        }
    }

    public f(Context context, AbstractC4156b abstractC4156b) {
        this.f33003a = context;
        this.f33004b = abstractC4156b;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f33004b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f33004b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuC4740e(this.f33003a, (InterfaceMenuC5650a) this.f33004b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f33004b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f33004b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f33004b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f33004b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f33004b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f33004b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f33004b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f33004b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f33004b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f33004b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f33004b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z10) {
        this.f33004b.s(z10);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i10) {
        this.f33004b.n(i10);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i10) {
        this.f33004b.q(i10);
    }
}
