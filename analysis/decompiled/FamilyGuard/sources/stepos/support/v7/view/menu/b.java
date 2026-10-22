package stepos.support.v7.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.H;
import java.util.ArrayList;
import stepos.support.v7.view.menu.h;
import stepos.support.v7.view.menu.i;

/* loaded from: classes.dex */
public abstract class b implements h {

    /* renamed from: a, reason: collision with root package name */
    protected Context f21249a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f21250b;

    /* renamed from: c, reason: collision with root package name */
    protected d f21251c;

    /* renamed from: d, reason: collision with root package name */
    protected LayoutInflater f21252d;

    /* renamed from: e, reason: collision with root package name */
    protected LayoutInflater f21253e;

    /* renamed from: f, reason: collision with root package name */
    private h.a f21254f;

    /* renamed from: g, reason: collision with root package name */
    private int f21255g;

    /* renamed from: h, reason: collision with root package name */
    private int f21256h;

    /* renamed from: i, reason: collision with root package name */
    protected i f21257i;

    /* renamed from: j, reason: collision with root package name */
    private int f21258j;

    public b(Context context, int i5, int i6) {
        this.f21249a = context;
        this.f21252d = LayoutInflater.from(context);
        this.f21255g = i5;
        this.f21256h = i6;
    }

    @Override // stepos.support.v7.view.menu.h
    public void a(d dVar, boolean z5) {
        h.a aVar = this.f21254f;
        if (aVar != null) {
            aVar.a(dVar, z5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // stepos.support.v7.view.menu.h
    public void b(boolean z5) {
        ViewGroup viewGroup = (ViewGroup) this.f21257i;
        if (viewGroup == null) {
            return;
        }
        d dVar = this.f21251c;
        int i5 = 0;
        if (dVar != null) {
            dVar.r();
            ArrayList<f> arrayListE = this.f21251c.E();
            int size = arrayListE.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                f fVar = arrayListE.get(i7);
                if (r(i6, fVar)) {
                    View childAt = viewGroup.getChildAt(i6);
                    f itemData = childAt instanceof i.a ? ((i.a) childAt).getItemData() : null;
                    View viewM = m(fVar, childAt, viewGroup);
                    if (fVar != itemData) {
                        viewM.setPressed(false);
                        H.S(viewM);
                    }
                    if (viewM != childAt) {
                        h(viewM, i6);
                    }
                    i6++;
                }
            }
            i5 = i6;
        }
        while (i5 < viewGroup.getChildCount()) {
            if (!k(viewGroup, i5)) {
                i5++;
            }
        }
    }

    @Override // stepos.support.v7.view.menu.h
    public boolean d(d dVar, f fVar) {
        return false;
    }

    @Override // stepos.support.v7.view.menu.h
    public boolean e(j jVar) {
        h.a aVar = this.f21254f;
        if (aVar != null) {
            return aVar.b(jVar);
        }
        return false;
    }

    @Override // stepos.support.v7.view.menu.h
    public void f(Context context, d dVar) {
        this.f21250b = context;
        this.f21253e = LayoutInflater.from(context);
        this.f21251c = dVar;
    }

    @Override // stepos.support.v7.view.menu.h
    public boolean g(d dVar, f fVar) {
        return false;
    }

    protected void h(View view, int i5) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f21257i).addView(view, i5);
    }

    public abstract void i(f fVar, i.a aVar);

    public i.a j(ViewGroup viewGroup) {
        return (i.a) this.f21252d.inflate(this.f21256h, viewGroup, false);
    }

    protected boolean k(ViewGroup viewGroup, int i5) {
        viewGroup.removeViewAt(i5);
        return true;
    }

    public h.a l() {
        return this.f21254f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View m(f fVar, View view, ViewGroup viewGroup) {
        i.a aVarJ = view instanceof i.a ? (i.a) view : j(viewGroup);
        i(fVar, aVarJ);
        return (View) aVarJ;
    }

    public i n(ViewGroup viewGroup) {
        if (this.f21257i == null) {
            i iVar = (i) this.f21252d.inflate(this.f21255g, viewGroup, false);
            this.f21257i = iVar;
            iVar.b(this.f21251c);
            b(true);
        }
        return this.f21257i;
    }

    public void o(h.a aVar) {
        this.f21254f = aVar;
    }

    public void p(int i5) {
        this.f21258j = i5;
    }

    protected void q(int i5) {
        this.f21256h = i5;
    }

    public abstract boolean r(int i5, f fVar);
}
