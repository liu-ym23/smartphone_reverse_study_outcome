package v1;

import android.view.View;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c2 implements androidx.lifecycle.v {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ pc.c f14392c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ k0.m1 f14393f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ k0.z1 f14394g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ yb.u f14395h;
    public /* synthetic */ View i;

    @Override // androidx.lifecycle.v
    public final void e(androidx.lifecycle.x xVar, androidx.lifecycle.o oVar) {
        boolean z10;
        kc.f fVarT = null;
        switch (b2.f14384a[oVar.ordinal()]) {
            case 1:
                kc.w.u(this.f14392c, null, kc.u.f7484h, new s.k0(this.f14395h, this.f14394g, xVar, this, this.i, (nb.c) null), 1);
                return;
            case 2:
                k0.m1 m1Var = this.f14393f;
                if (m1Var != null) {
                    ab.c cVar = (ab.c) m1Var.f6978g;
                    synchronized (cVar.f383b) {
                        try {
                            synchronized (cVar.f383b) {
                                z10 = cVar.f382a;
                            }
                            if (!z10) {
                                ArrayList arrayList = (ArrayList) cVar.f384c;
                                cVar.f384c = (ArrayList) cVar.f385d;
                                cVar.f385d = arrayList;
                                cVar.f382a = true;
                                int size = arrayList.size();
                                for (int i = 0; i < size; i++) {
                                    ((nb.c) arrayList.get(i)).resumeWith(jb.v.f6774a);
                                }
                                arrayList.clear();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                k0.z1 z1Var = this.f14394g;
                synchronized (z1Var.f7156b) {
                    if (z1Var.f7172s) {
                        z1Var.f7172s = false;
                        fVarT = z1Var.t();
                    }
                }
                if (fVarT != null) {
                    ((kc.g) fVarT).resumeWith(jb.v.f6774a);
                    return;
                }
                return;
            case 3:
                k0.z1 z1Var2 = this.f14394g;
                synchronized (z1Var2.f7156b) {
                    z1Var2.f7172s = true;
                }
                return;
            case 4:
                this.f14394g.s();
                return;
            case 5:
            case 6:
            case 7:
                return;
            default:
                g5.f.a();
                return;
        }
    }
}
