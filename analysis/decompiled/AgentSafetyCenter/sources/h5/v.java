package h5;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import java.lang.invoke.VarHandle;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class v implements Callable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5385c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5386f;

    public /* synthetic */ v(int i) {
        this.f5385c = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.f5385c;
        boolean z10 = false;
        Object obj = this.f5386f;
        switch (i) {
            case 0:
                d0 d0Var = (d0) obj;
                p5.p pVar = d0Var.f5325a;
                int i3 = pVar.f9765b;
                String str = pVar.f9766c;
                if (i3 != 1) {
                    String str2 = e0.f5338a;
                    g5.u.d().a(str2, str + " is not in ENQUEUED state. Nothing more to do");
                    return Boolean.TRUE;
                }
                if (pVar.c() || (pVar.f9765b == 1 && pVar.f9773k > 0)) {
                    d0Var.f5330f.getClass();
                    if (System.currentTimeMillis() < pVar.a()) {
                        g5.u.d().a(e0.f5338a, "Delaying execution for " + str + " because it is being executed before schedule.");
                        return Boolean.TRUE;
                    }
                }
                return Boolean.FALSE;
            case 1:
                d0 d0Var2 = (d0) obj;
                p5.s sVar = d0Var2.f5332h;
                String str3 = d0Var2.f5327c;
                if (sVar.i(str3) == 1) {
                    sVar.p(2, str3);
                    WorkDatabase_Impl workDatabase_Impl = sVar.f9791a;
                    workDatabase_Impl.b();
                    p5.h hVar = sVar.i;
                    z4.j jVarA = hVar.a();
                    jVarA.h(1, str3);
                    try {
                        workDatabase_Impl.c();
                        try {
                            jVarA.d();
                            workDatabase_Impl.v();
                            hVar.c(jVarA);
                            sVar.q(-256, str3);
                            z10 = true;
                        } finally {
                            workDatabase_Impl.q();
                        }
                    } catch (Throwable th) {
                        hVar.c(jVarA);
                        throw th;
                    }
                }
                return Boolean.valueOf(z10);
            default:
                WorkDatabase workDatabase = (WorkDatabase) ((a1.g) obj).f19f;
                Long lI = workDatabase.y().i("next_alarm_manager_id");
                int iLongValue = lI != null ? (int) lI.longValue() : 0;
                int i10 = iLongValue != Integer.MAX_VALUE ? iLongValue + 1 : 0;
                p5.e eVarY = workDatabase.y();
                Long lValueOf = Long.valueOf(i10);
                p5.d dVar = new p5.d();
                dVar.f9719a = "next_alarm_manager_id";
                dVar.f9720b = lValueOf;
                VarHandle.storeStoreFence();
                eVarY.j(dVar);
                return Integer.valueOf(iLongValue);
        }
    }
}
