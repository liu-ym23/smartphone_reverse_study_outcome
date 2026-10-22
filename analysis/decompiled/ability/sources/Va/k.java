package Va;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.stepos.ability.R;
import stepos.support.v7.app.C1956e;
import stepos.support.v7.app.C1960i;
import stepos.support.v7.app.DialogInterfaceC1961j;
import stepos.support.v7.view.menu.ExpandedMenuView;

/* loaded from: classes4.dex */
public final class k implements B, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f1440a;
    public LayoutInflater b;
    public n c;
    public ExpandedMenuView d;
    public A e;
    public j f;

    public k(ContextWrapper contextWrapper) {
        this.f1440a = contextWrapper;
        this.b = LayoutInflater.from(contextWrapper);
    }

    @Override // Va.B
    public final boolean a(q qVar) {
        return false;
    }

    @Override // Va.B
    public final void b(Context context, n nVar) {
        if (this.f1440a != null) {
            this.f1440a = context;
            if (this.b == null) {
                this.b = LayoutInflater.from(context);
            }
        }
        this.c = nVar;
        j jVar = this.f;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
    }

    @Override // Va.B
    public final boolean c(F f) {
        boolean zHasVisibleItems = f.hasVisibleItems();
        Context context = f.f1442a;
        if (!zHasVisibleItems) {
            return false;
        }
        o oVar = new o();
        oVar.f1448a = f;
        C1960i c1960i = new C1960i(context, DialogInterfaceC1961j.resolveDialogTheme(context, 0));
        C1956e c1956e = c1960i.f6314a;
        k kVar = new k(c1956e.f6295a);
        oVar.c = kVar;
        kVar.e = oVar;
        f.b(kVar, context);
        c1956e.m = (j) oVar.c.e();
        c1956e.n = oVar;
        View view = f.n;
        if (view != null) {
            c1956e.e = view;
        } else {
            c1956e.c = f.m;
            c1956e.d = f.l;
        }
        c1956e.l = oVar;
        DialogInterfaceC1961j dialogInterfaceC1961jA = c1960i.a(new h2.d(c1960i));
        oVar.b = dialogInterfaceC1961jA;
        dialogInterfaceC1961jA.setOnDismissListener(oVar);
        WindowManager.LayoutParams attributes = oVar.b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        oVar.b.show();
        A a3 = this.e;
        if (a3 == null) {
            return true;
        }
        a3.n(f);
        return true;
    }

    @Override // Va.B
    public final boolean d(q qVar) {
        return false;
    }

    public final ListAdapter e() {
        if (this.f == null) {
            this.f = new j(this);
        }
        return this.f;
    }

    @Override // Va.B
    public final void f(n nVar, boolean z10) {
        A a3 = this.e;
        if (a3 != null) {
            a3.f(nVar, z10);
        }
    }

    @Override // Va.B
    public final boolean flagActionItems() {
        return false;
    }

    public final D g(ViewGroup viewGroup) {
        if (this.d == null) {
            this.d = (ExpandedMenuView) this.b.inflate(R.layout.stepos_expanded_menu_layout, viewGroup, false);
            if (this.f == null) {
                this.f = new j(this);
            }
            this.d.setAdapter((ListAdapter) this.f);
            this.d.setOnItemClickListener(this);
        }
        return this.d;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j5) {
        this.c.p(this.f.getItem(i), this, 0);
    }

    @Override // Va.B
    public final void updateMenuView(boolean z10) {
        j jVar = this.f;
        if (jVar != null) {
            jVar.notifyDataSetChanged();
        }
    }
}
