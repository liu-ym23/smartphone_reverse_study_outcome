package v0;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public u f5943a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f5944b;

    /* renamed from: c, reason: collision with root package name */
    public long f5945c;
    public long d;

    /* renamed from: e, reason: collision with root package name */
    public long f5946e;

    /* renamed from: f, reason: collision with root package name */
    public long f5947f;

    public final void a(n0 n0Var) {
        u uVar = this.f5943a;
        if (uVar != null) {
            RecyclerView recyclerView = uVar.f5940a;
            boolean z = true;
            n0Var.m(true);
            if ((n0Var.f5894b & 16) != 0) {
                return;
            }
            h0 h0Var = recyclerView.f758a;
            recyclerView.F();
            a4.d dVar = recyclerView.d;
            t6.a aVar = (t6.a) dVar.f97c;
            u uVar2 = (u) dVar.f96b;
            int iIndexOfChild = uVar2.f5940a.indexOfChild(null);
            if (iIndexOfChild == -1) {
                dVar.L(null);
            } else if (aVar.d(iIndexOfChild)) {
                aVar.g(iIndexOfChild);
                dVar.L(null);
                uVar2.a(iIndexOfChild);
            } else {
                z = false;
            }
            if (z) {
                n0 n0VarS = RecyclerView.s(null);
                h0Var.j(n0VarS);
                h0Var.h(n0VarS);
            }
            recyclerView.G(!z);
            if (z || !n0Var.j()) {
                return;
            }
            recyclerView.removeDetachedView(null, false);
        }
    }

    public abstract void b(n0 n0Var);

    public abstract void c();

    public abstract boolean d();
}
