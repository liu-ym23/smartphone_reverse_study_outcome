package j1;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class i2 implements androidx.lifecycle.t {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ na.d f5201f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b0.q1 f5202g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b0.j2 f5203h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ q7.v f5204i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ View f5205j;

    public i2(na.d dVar, b0.q1 q1Var, b0.j2 j2Var, q7.v vVar, View view) {
        this.f5201f = dVar;
        this.f5202g = q1Var;
        this.f5203h = j2Var;
        this.f5204i = vVar;
        this.f5205j = view;
    }

    @Override // androidx.lifecycle.t
    public final void b(androidx.lifecycle.v vVar, androidx.lifecycle.p pVar) {
        boolean z4;
        ia.k kVarE = null;
        switch (g2.$EnumSwitchMapping$0[pVar.ordinal()]) {
            case 1:
                ia.d0.s(this.f5201f, null, ia.c0.f4929i, new h2(this.f5204i, this.f5203h, vVar, this, this.f5205j, null, 0), 1);
                return;
            case 2:
                b0.q1 q1Var = this.f5202g;
                if (q1Var != null) {
                    b0.x0 x0Var = (b0.x0) q1Var.f1321h;
                    synchronized (x0Var.f1416c) {
                        try {
                            synchronized (x0Var.f1416c) {
                                z4 = x0Var.f1415b;
                            }
                            if (!z4) {
                                ArrayList arrayList = (ArrayList) x0Var.f1414a;
                                x0Var.f1414a = (ArrayList) x0Var.f1417d;
                                x0Var.f1417d = arrayList;
                                x0Var.f1415b = true;
                                int size = arrayList.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    ((g7.d) arrayList.get(i2)).resumeWith(c7.r.f1986a);
                                }
                                arrayList.clear();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                b0.j2 j2Var = this.f5203h;
                synchronized (j2Var.f1207b) {
                    if (j2Var.f1224s) {
                        j2Var.f1224s = false;
                        kVarE = j2Var.e();
                    }
                }
                if (kVarE != null) {
                    ((ia.m) kVarE).resumeWith(c7.r.f1986a);
                    return;
                }
                return;
            case 3:
                b0.j2 j2Var2 = this.f5203h;
                synchronized (j2Var2.f1207b) {
                    j2Var2.f1224s = true;
                }
                return;
            case 4:
                this.f5203h.d();
                return;
            case 5:
            case 6:
            case 7:
                return;
            default:
                throw new a4.u();
        }
    }
}
