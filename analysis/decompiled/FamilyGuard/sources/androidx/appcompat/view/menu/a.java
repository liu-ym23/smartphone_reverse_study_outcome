package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a implements j {

    /* renamed from: a, reason: collision with root package name */
    protected Context f7811a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f7812b;

    /* renamed from: c, reason: collision with root package name */
    protected e f7813c;

    /* renamed from: d, reason: collision with root package name */
    protected LayoutInflater f7814d;

    /* renamed from: e, reason: collision with root package name */
    protected LayoutInflater f7815e;

    /* renamed from: f, reason: collision with root package name */
    private j.a f7816f;

    /* renamed from: g, reason: collision with root package name */
    private int f7817g;

    /* renamed from: h, reason: collision with root package name */
    private int f7818h;

    /* renamed from: i, reason: collision with root package name */
    protected k f7819i;

    /* renamed from: j, reason: collision with root package name */
    private int f7820j;

    public a(Context context, int i5, int i6) {
        this.f7811a = context;
        this.f7814d = LayoutInflater.from(context);
        this.f7817g = i5;
        this.f7818h = i6;
    }

    protected void a(View view, int i5) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f7819i).addView(view, i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.j
    public void b(boolean z5) {
        ViewGroup viewGroup = (ViewGroup) this.f7819i;
        if (viewGroup == null) {
            return;
        }
        e eVar = this.f7813c;
        int i5 = 0;
        if (eVar != null) {
            eVar.r();
            ArrayList<g> arrayListE = this.f7813c.E();
            int size = arrayListE.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                g gVar = arrayListE.get(i7);
                if (q(i6, gVar)) {
                    View childAt = viewGroup.getChildAt(i6);
                    g itemData = childAt instanceof k.a ? ((k.a) childAt).getItemData() : null;
                    View viewN = n(gVar, childAt, viewGroup);
                    if (gVar != itemData) {
                        viewN.setPressed(false);
                        viewN.jumpDrawablesToCurrentState();
                    }
                    if (viewN != childAt) {
                        a(viewN, i6);
                    }
                    i6++;
                }
            }
            i5 = i6;
        }
        while (i5 < viewGroup.getChildCount()) {
            if (!l(viewGroup, i5)) {
                i5++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(e eVar, boolean z5) {
        j.a aVar = this.f7816f;
        if (aVar != null) {
            aVar.d(eVar, z5);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean f(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void g(j.a aVar) {
        this.f7816f = aVar;
    }

    public abstract void h(g gVar, k.a aVar);

    @Override // androidx.appcompat.view.menu.j
    public void i(Context context, e eVar) {
        this.f7812b = context;
        this.f7815e = LayoutInflater.from(context);
        this.f7813c = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.appcompat.view.menu.e] */
    @Override // androidx.appcompat.view.menu.j
    public boolean j(m mVar) {
        j.a aVar = this.f7816f;
        m mVar2 = mVar;
        if (aVar == null) {
            return false;
        }
        if (mVar == null) {
            mVar2 = this.f7813c;
        }
        return aVar.e(mVar2);
    }

    public k.a k(ViewGroup viewGroup) {
        return (k.a) this.f7814d.inflate(this.f7818h, viewGroup, false);
    }

    protected boolean l(ViewGroup viewGroup, int i5) {
        viewGroup.removeViewAt(i5);
        return true;
    }

    public j.a m() {
        return this.f7816f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View n(g gVar, View view, ViewGroup viewGroup) {
        k.a aVarK = view instanceof k.a ? (k.a) view : k(viewGroup);
        h(gVar, aVarK);
        return (View) aVarK;
    }

    public k o(ViewGroup viewGroup) {
        if (this.f7819i == null) {
            k kVar = (k) this.f7814d.inflate(this.f7817g, viewGroup, false);
            this.f7819i = kVar;
            kVar.e(this.f7813c);
            b(true);
        }
        return this.f7819i;
    }

    public void p(int i5) {
        this.f7820j = i5;
    }

    public abstract boolean q(int i5, g gVar);
}
