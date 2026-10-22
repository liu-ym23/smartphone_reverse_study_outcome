package v0;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f5829a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f5830b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f5831c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f5832e;

    /* renamed from: f, reason: collision with root package name */
    public g0 f5833f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f5834g;

    public h0(RecyclerView recyclerView) {
        this.f5834g = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f5829a = arrayList;
        this.f5830b = null;
        this.f5831c = new ArrayList();
        Collections.unmodifiableList(arrayList);
        this.d = 2;
        this.f5832e = 2;
    }

    public final void a(n0 n0Var, boolean z) {
        RecyclerView.e(n0Var);
        n0Var.getClass();
        RecyclerView recyclerView = this.f5834g;
        p0 p0Var = recyclerView.f766e0;
        if (p0Var != null) {
            o0 o0Var = p0Var.f5907e;
            e0.a0.e(null, o0Var != null ? (e0.b) o0Var.f5903e.remove(null) : null);
        }
        if (z) {
            ArrayList arrayList = recyclerView.f777l;
            if (arrayList.size() > 0) {
                arrayList.get(0).getClass();
                throw new ClassCastException();
            }
            if (recyclerView.f759a0 != null) {
                androidx.emoji2.text.p pVar = recyclerView.f765e;
                j.g gVar = (j.g) pVar.f624c;
                int iE = gVar.e() - 1;
                while (true) {
                    if (iE < 0) {
                        break;
                    }
                    if (n0Var == gVar.f(iE)) {
                        Object[] objArr = gVar.f3295c;
                        Object obj = objArr[iE];
                        Object obj2 = j.h.f3296a;
                        if (obj != obj2) {
                            objArr[iE] = obj2;
                            gVar.f3293a = true;
                        }
                    } else {
                        iE--;
                    }
                }
                u0 u0Var = (u0) ((j.j) pVar.f623b).remove(n0Var);
                if (u0Var != null) {
                    u0Var.f5942a = 0;
                    u0.f5941b.c(u0Var);
                }
            }
        }
        n0Var.f5898g = null;
        g0 g0VarC = c();
        g0VarC.getClass();
        ArrayList arrayList2 = g0VarC.a(0).f5812a;
        if (((f0) g0VarC.f5827a.get(0)).f5813b <= arrayList2.size()) {
            return;
        }
        n0Var.l();
        arrayList2.add(n0Var);
    }

    public final int b(int i8) {
        RecyclerView recyclerView = this.f5834g;
        if (i8 >= 0 && i8 < recyclerView.f759a0.a()) {
            return !recyclerView.f759a0.f5868e ? i8 : recyclerView.f762c.o(i8, 0);
        }
        StringBuilder sbS = a8.b.s(i8, "invalid position ", ". State item count is ");
        sbS.append(recyclerView.f759a0.a());
        sbS.append(recyclerView.p());
        throw new IndexOutOfBoundsException(sbS.toString());
    }

    public final g0 c() {
        if (this.f5833f == null) {
            g0 g0Var = new g0();
            g0Var.f5827a = new SparseArray();
            g0Var.f5828b = 0;
            this.f5833f = g0Var;
        }
        return this.f5833f;
    }

    public final View d(int i8) {
        i(i8, Util.VLI_MAX).getClass();
        return null;
    }

    public final void e() {
        ArrayList arrayList = this.f5831c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            f(size);
        }
        arrayList.clear();
        int[] iArr = RecyclerView.f755l0;
        p1.m mVar = this.f5834g.W;
        mVar.getClass();
        mVar.f4726c = 0;
    }

    public final void f(int i8) {
        ArrayList arrayList = this.f5831c;
        a((n0) arrayList.get(i8), true);
        arrayList.remove(i8);
    }

    public final void g(View view) {
        n0 n0VarS = RecyclerView.s(view);
        boolean zJ = n0VarS.j();
        RecyclerView recyclerView = this.f5834g;
        if (zJ) {
            recyclerView.removeDetachedView(view, false);
        }
        if (n0VarS.i()) {
            n0VarS.f5895c.j(n0VarS);
        } else if (n0VarS.o()) {
            n0VarS.f5894b &= -33;
        }
        h(n0VarS);
        if (recyclerView.G == null || n0VarS.g()) {
            return;
        }
        recyclerView.G.b(n0VarS);
    }

    public final void h(n0 n0Var) {
        if (!n0Var.i()) {
            throw null;
        }
        StringBuilder sb = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
        sb.append(n0Var.i());
        sb.append(" isAttached:");
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final v0.n0 i(int r9, long r10) {
        /*
            Method dump skipped, instructions count: 518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v0.h0.i(int, long):v0.n0");
    }

    public final void j(n0 n0Var) {
        if (n0Var.d) {
            this.f5830b.remove(n0Var);
        } else {
            this.f5829a.remove(n0Var);
        }
        n0Var.f5895c = null;
        n0Var.d = false;
        n0Var.f5894b &= -33;
    }

    public final void k() {
        this.f5832e = this.d + 0;
        ArrayList arrayList = this.f5831c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f5832e; size--) {
            f(size);
        }
    }
}
