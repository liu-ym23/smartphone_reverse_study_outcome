package l;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements x, AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    public Context f7571c;

    /* renamed from: f, reason: collision with root package name */
    public LayoutInflater f7572f;

    /* renamed from: g, reason: collision with root package name */
    public l f7573g;

    /* renamed from: h, reason: collision with root package name */
    public ExpandedMenuView f7574h;
    public w i;

    /* renamed from: j, reason: collision with root package name */
    public g f7575j;

    public h(ContextWrapper contextWrapper) {
        this.f7571c = contextWrapper;
        this.f7572f = LayoutInflater.from(contextWrapper);
    }

    @Override // l.x
    public final boolean a() {
        return false;
    }

    @Override // l.x
    public final void c() {
        g gVar = this.f7575j;
        if (gVar != null) {
            gVar.notifyDataSetChanged();
        }
    }

    @Override // l.x
    public final void d(l lVar, boolean z10) {
        w wVar = this.i;
        if (wVar != null) {
            wVar.d(lVar, z10);
        }
    }

    @Override // l.x
    public final boolean e(n nVar) {
        return false;
    }

    @Override // l.x
    public final void g(w wVar) {
        throw null;
    }

    @Override // l.x
    public final void i(Context context, l lVar) {
        if (this.f7571c != null) {
            this.f7571c = context;
            if (this.f7572f == null) {
                this.f7572f = LayoutInflater.from(context);
            }
        }
        this.f7573g = lVar;
        g gVar = this.f7575j;
        if (gVar != null) {
            gVar.notifyDataSetChanged();
        }
    }

    @Override // l.x
    public final boolean j(d0 d0Var) {
        boolean zHasVisibleItems = d0Var.hasVisibleItems();
        Context context = d0Var.f7583a;
        if (!zHasVisibleItems) {
            return false;
        }
        m mVar = new m(0);
        mVar.f7607f = d0Var;
        wd.a aVar = new wd.a(context);
        h.d dVar = (h.d) aVar.f15390g;
        h hVar = new h(dVar.f4757a);
        mVar.f7609h = hVar;
        hVar.i = mVar;
        d0Var.b(hVar, context);
        h hVar2 = (h) mVar.f7609h;
        if (hVar2.f7575j == null) {
            hVar2.f7575j = new g(hVar2);
        }
        dVar.f4763g = hVar2.f7575j;
        dVar.f4764h = mVar;
        View view = d0Var.f7596o;
        if (view != null) {
            dVar.f4761e = view;
        } else {
            dVar.f4759c = d0Var.f7595n;
            dVar.f4760d = d0Var.f7594m;
        }
        dVar.f4762f = mVar;
        h.h hVarF = aVar.f();
        mVar.f7608g = hVarF;
        hVarF.setOnDismissListener(mVar);
        WindowManager.LayoutParams attributes = ((h.h) mVar.f7608g).getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        ((h.h) mVar.f7608g).show();
        w wVar = this.i;
        if (wVar == null) {
            return true;
        }
        wVar.f(d0Var);
        return true;
    }

    @Override // l.x
    public final boolean k(n nVar) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j10) {
        this.f7573g.q(this.f7575j.b(i), this, 0);
    }
}
