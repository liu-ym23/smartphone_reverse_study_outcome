package Ic;

import Ic.b;
import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.collection.t;
import java.util.ArrayList;
import v0.InterfaceMenuC5650a;
import v0.InterfaceMenuItemC5651b;

@TargetApi(11)
/* loaded from: classes5.dex */
public class j extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3484a;

    /* renamed from: b, reason: collision with root package name */
    public final b f3485b;

    public static class a implements b.InterfaceC0060b {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f3486a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f3487b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList<j> f3488c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        public final t<Menu, Menu> f3489d = new t<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f3487b = context;
            this.f3486a = callback;
        }

        @Override // Ic.b.InterfaceC0060b
        public void a(b bVar) {
            this.f3486a.onDestroyActionMode(e(bVar));
        }

        @Override // Ic.b.InterfaceC0060b
        public boolean b(b bVar, Menu menu) {
            return this.f3486a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // Ic.b.InterfaceC0060b
        public boolean c(b bVar, MenuItem menuItem) {
            return this.f3486a.onActionItemClicked(e(bVar), Jc.j.b(this.f3487b, (InterfaceMenuItemC5651b) menuItem));
        }

        @Override // Ic.b.InterfaceC0060b
        public boolean d(b bVar, Menu menu) {
            return this.f3486a.onCreateActionMode(e(bVar), f(menu));
        }

        public ActionMode e(b bVar) {
            int size = this.f3488c.size();
            for (int i10 = 0; i10 < size; i10++) {
                j jVar = this.f3488c.get(i10);
                if (jVar != null && jVar.f3485b == bVar) {
                    return jVar;
                }
            }
            j jVar2 = new j(this.f3487b, bVar);
            this.f3488c.add(jVar2);
            return jVar2;
        }

        public final Menu f(Menu menu) {
            Menu menu2 = this.f3489d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu menuA = Jc.j.a(this.f3487b, (InterfaceMenuC5650a) menu);
            this.f3489d.put(menu, menuA);
            return menuA;
        }
    }

    public j(Context context, b bVar) {
        this.f3484a = context;
        this.f3485b = bVar;
    }

    public final boolean a() {
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
        this.f3485b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f3485b.e();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return Jc.j.a(this.f3484a, (InterfaceMenuC5650a) this.f3485b.f());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f3485b.g();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f3485b.h();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f3485b.i();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f3485b.j();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f3485b.k();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f3485b.l();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f3485b.n();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f3485b.p(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f3485b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f3485b.s(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f3485b.u(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z10) {
        this.f3485b.v(z10);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i10) {
        this.f3485b.q(i10);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i10) {
        this.f3485b.t(i10);
    }
}
