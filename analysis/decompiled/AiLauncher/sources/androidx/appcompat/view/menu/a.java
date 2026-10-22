package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class a implements i {

    /* renamed from: a, reason: collision with root package name */
    public Context f8550a;

    /* renamed from: b, reason: collision with root package name */
    public Context f8551b;

    /* renamed from: c, reason: collision with root package name */
    public e f8552c;

    /* renamed from: d, reason: collision with root package name */
    public LayoutInflater f8553d;

    /* renamed from: e, reason: collision with root package name */
    public LayoutInflater f8554e;

    /* renamed from: f, reason: collision with root package name */
    public i.a f8555f;

    /* renamed from: g, reason: collision with root package name */
    public int f8556g;

    /* renamed from: h, reason: collision with root package name */
    public int f8557h;

    /* renamed from: i, reason: collision with root package name */
    public j f8558i;

    /* renamed from: j, reason: collision with root package name */
    public int f8559j;

    public a(Context context, int i10, int i11) {
        this.f8550a = context;
        this.f8553d = LayoutInflater.from(context);
        this.f8556g = i10;
        this.f8557h = i11;
    }

    @Override // androidx.appcompat.view.menu.i
    public void a(e eVar, boolean z10) {
        i.a aVar = this.f8555f;
        if (aVar != null) {
            aVar.a(eVar, z10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.i
    public void b(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) this.f8558i;
        if (viewGroup == null) {
            return;
        }
        e eVar = this.f8552c;
        int i10 = 0;
        if (eVar != null) {
            eVar.t();
            ArrayList<g> arrayListG = this.f8552c.G();
            int size = arrayListG.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                g gVar = arrayListG.get(i12);
                if (s(i11, gVar)) {
                    View childAt = viewGroup.getChildAt(i11);
                    g itemData = childAt instanceof j.a ? ((j.a) childAt).getItemData() : null;
                    View viewP = p(gVar, childAt, viewGroup);
                    if (gVar != itemData) {
                        viewP.setPressed(false);
                        viewP.jumpDrawablesToCurrentState();
                    }
                    if (viewP != childAt) {
                        k(viewP, i11);
                    }
                    i11++;
                }
            }
            i10 = i11;
        }
        while (i10 < viewGroup.getChildCount()) {
            if (!n(viewGroup, i10)) {
                i10++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean d(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public void e(i.a aVar) {
        this.f8555f = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.appcompat.view.menu.e] */
    @Override // androidx.appcompat.view.menu.i
    public boolean g(l lVar) {
        i.a aVar = this.f8555f;
        l lVar2 = lVar;
        if (aVar == null) {
            return false;
        }
        if (lVar == null) {
            lVar2 = this.f8552c;
        }
        return aVar.b(lVar2);
    }

    @Override // androidx.appcompat.view.menu.i
    public int getId() {
        return this.f8559j;
    }

    @Override // androidx.appcompat.view.menu.i
    public boolean i(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.i
    public void j(Context context, e eVar) {
        this.f8551b = context;
        this.f8554e = LayoutInflater.from(context);
        this.f8552c = eVar;
    }

    public void k(View view, int i10) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f8558i).addView(view, i10);
    }

    public abstract void l(g gVar, j.a aVar);

    public j.a m(ViewGroup viewGroup) {
        return (j.a) this.f8553d.inflate(this.f8557h, viewGroup, false);
    }

    public boolean n(ViewGroup viewGroup, int i10) {
        viewGroup.removeViewAt(i10);
        return true;
    }

    public i.a o() {
        return this.f8555f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View p(g gVar, View view, ViewGroup viewGroup) {
        j.a aVarM = view instanceof j.a ? (j.a) view : m(viewGroup);
        l(gVar, aVarM);
        return (View) aVarM;
    }

    public j q(ViewGroup viewGroup) {
        if (this.f8558i == null) {
            j jVar = (j) this.f8553d.inflate(this.f8556g, viewGroup, false);
            this.f8558i = jVar;
            jVar.d(this.f8552c);
            b(true);
        }
        return this.f8558i;
    }

    public void r(int i10) {
        this.f8559j = i10;
    }

    public abstract boolean s(int i10, g gVar);
}
