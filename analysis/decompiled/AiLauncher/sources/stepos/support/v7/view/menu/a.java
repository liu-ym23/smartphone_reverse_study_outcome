package stepos.support.v7.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.N;
import java.util.ArrayList;
import stepos.support.v7.view.menu.g;
import stepos.support.v7.view.menu.h;

/* loaded from: classes5.dex */
public abstract class a implements g {

    /* renamed from: a, reason: collision with root package name */
    public Context f40907a;

    /* renamed from: b, reason: collision with root package name */
    public Context f40908b;

    /* renamed from: c, reason: collision with root package name */
    public c f40909c;

    /* renamed from: d, reason: collision with root package name */
    public LayoutInflater f40910d;

    /* renamed from: e, reason: collision with root package name */
    public LayoutInflater f40911e;

    /* renamed from: f, reason: collision with root package name */
    public g.a f40912f;

    /* renamed from: g, reason: collision with root package name */
    public int f40913g;

    /* renamed from: h, reason: collision with root package name */
    public int f40914h;

    /* renamed from: i, reason: collision with root package name */
    public h f40915i;

    /* renamed from: j, reason: collision with root package name */
    public int f40916j;

    public a(Context context, int i10, int i11) {
        this.f40907a = context;
        this.f40910d = LayoutInflater.from(context);
        this.f40913g = i10;
        this.f40914h = i11;
    }

    @Override // stepos.support.v7.view.menu.g
    public void a(c cVar, boolean z10) {
        g.a aVar = this.f40912f;
        if (aVar != null) {
            aVar.a(cVar, z10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // stepos.support.v7.view.menu.g
    public void b(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) this.f40915i;
        if (viewGroup == null) {
            return;
        }
        c cVar = this.f40909c;
        int i10 = 0;
        if (cVar != null) {
            cVar.r();
            ArrayList<e> arrayListE = this.f40909c.E();
            int size = arrayListE.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                e eVar = arrayListE.get(i12);
                if (r(i11, eVar)) {
                    View childAt = viewGroup.getChildAt(i11);
                    e itemData = childAt instanceof h.a ? ((h.a) childAt).getItemData() : null;
                    View viewM = m(eVar, childAt, viewGroup);
                    if (eVar != itemData) {
                        viewM.setPressed(false);
                        N.Q(viewM);
                    }
                    if (viewM != childAt) {
                        h(viewM, i11);
                    }
                    i11++;
                }
            }
            i10 = i11;
        }
        while (i10 < viewGroup.getChildCount()) {
            if (!k(viewGroup, i10)) {
                i10++;
            }
        }
    }

    @Override // stepos.support.v7.view.menu.g
    public boolean d(c cVar, e eVar) {
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public boolean e(i iVar) {
        g.a aVar = this.f40912f;
        if (aVar != null) {
            return aVar.b(iVar);
        }
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public boolean f(c cVar, e eVar) {
        return false;
    }

    @Override // stepos.support.v7.view.menu.g
    public void g(Context context, c cVar) {
        this.f40908b = context;
        this.f40911e = LayoutInflater.from(context);
        this.f40909c = cVar;
    }

    public void h(View view, int i10) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f40915i).addView(view, i10);
    }

    public abstract void i(e eVar, h.a aVar);

    public h.a j(ViewGroup viewGroup) {
        return (h.a) this.f40910d.inflate(this.f40914h, viewGroup, false);
    }

    public boolean k(ViewGroup viewGroup, int i10) {
        viewGroup.removeViewAt(i10);
        return true;
    }

    public g.a l() {
        return this.f40912f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View m(e eVar, View view, ViewGroup viewGroup) {
        h.a aVarJ = view instanceof h.a ? (h.a) view : j(viewGroup);
        i(eVar, aVarJ);
        return (View) aVarJ;
    }

    public h n(ViewGroup viewGroup) {
        if (this.f40915i == null) {
            h hVar = (h) this.f40910d.inflate(this.f40913g, viewGroup, false);
            this.f40915i = hVar;
            hVar.a(this.f40909c);
            b(true);
        }
        return this.f40915i;
    }

    public void o(g.a aVar) {
        this.f40912f = aVar;
    }

    public void p(int i10) {
        this.f40916j = i10;
    }

    public void q(int i10) {
        this.f40914h = i10;
    }

    public abstract boolean r(int i10, e eVar);
}
