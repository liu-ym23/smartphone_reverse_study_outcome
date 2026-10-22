package b5;

import android.content.Context;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import b5.b;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class j extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    final Context f11887a;

    /* renamed from: b, reason: collision with root package name */
    final b f11888b;

    public static class a implements b.InterfaceC0154b {

        /* renamed from: a, reason: collision with root package name */
        final ActionMode.Callback f11889a;

        /* renamed from: b, reason: collision with root package name */
        final Context f11890b;

        /* renamed from: c, reason: collision with root package name */
        final ArrayList<j> f11891c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        final q.i<Menu, Menu> f11892d = new q.i<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f11890b = context;
            this.f11889a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f11892d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu menuA = c5.i.a(this.f11890b, (A.a) menu);
            this.f11892d.put(menu, menuA);
            return menuA;
        }

        @Override // b5.b.InterfaceC0154b
        public boolean a(b bVar, MenuItem menuItem) {
            return this.f11889a.onActionItemClicked(e(bVar), c5.i.b(this.f11890b, (A.b) menuItem));
        }

        @Override // b5.b.InterfaceC0154b
        public boolean b(b bVar, Menu menu) {
            return this.f11889a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // b5.b.InterfaceC0154b
        public void c(b bVar) {
            this.f11889a.onDestroyActionMode(e(bVar));
        }

        @Override // b5.b.InterfaceC0154b
        public boolean d(b bVar, Menu menu) {
            return this.f11889a.onCreateActionMode(e(bVar), f(menu));
        }

        public ActionMode e(b bVar) {
            int size = this.f11891c.size();
            for (int i5 = 0; i5 < size; i5++) {
                j jVar = this.f11891c.get(i5);
                if (jVar != null && jVar.f11888b == bVar) {
                    return jVar;
                }
            }
            j jVar2 = new j(this.f11890b, bVar);
            this.f11891c.add(jVar2);
            return jVar2;
        }
    }

    public j(Context context, b bVar) {
        this.f11887a = context;
        this.f11888b = bVar;
    }

    private boolean a() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (TextUtils.equals(stackTraceElement.getClassName(), "android.widget.AbsListView$MultiChoiceModeWrapper")) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ActionMode
    public void finish() {
        if (a()) {
            return;
        }
        this.f11888b.a();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f11888b.e();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return c5.i.a(this.f11887a, (A.a) this.f11888b.f());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f11888b.g();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f11888b.h();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f11888b.i();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f11888b.j();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f11888b.k();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f11888b.l();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f11888b.n();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f11888b.p(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f11888b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f11888b.s(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f11888b.u(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z5) {
        this.f11888b.v(z5);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i5) {
        this.f11888b.q(i5);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i5) {
        this.f11888b.t(i5);
    }
}
