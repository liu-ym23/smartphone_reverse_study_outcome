package g3;

import android.os.CancellationSignal;
import com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl;
import g1.y;
import ia.a1;
import ia.d0;
import ia.x;
import ia.z0;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public abstract class d {
    public static final Object a(OfflineQueueDatabase_Impl offlineQueueDatabase_Impl, CancellationSignal cancellationSignal, Callable callable, i7.i iVar) {
        if (offlineQueueDatabase_Impl.l() && offlineQueueDatabase_Impl.h().N().i()) {
            return callable.call();
        }
        if (iVar.getContext().o(p.f3834f) != null) {
            throw new ClassCastException();
        }
        Map map = offlineQueueDatabase_Impl.f2675j;
        Object z0Var = map.get("QueryDispatcher");
        g7.d dVar = null;
        if (z0Var == null) {
            f3.d dVar2 = offlineQueueDatabase_Impl.f2667b;
            if (dVar2 == null) {
                q7.k.j("internalQueryExecutor");
                throw null;
            }
            z0Var = new z0(dVar2);
            map.put("QueryDispatcher", z0Var);
        }
        ia.m mVar = new ia.m(1, ib.k.C(iVar));
        mVar.s();
        c cVar = new c(callable, mVar, dVar, 0);
        mVar.u(new y(1, cancellationSignal, d0.s(a1.f4917f, (x) z0Var, null, cVar, 2)));
        Object objR = mVar.r();
        h7.a aVar = h7.a.f4212f;
        return objR;
    }

    public static final Object b(OfflineQueueDatabase_Impl offlineQueueDatabase_Impl, Callable callable, i7.i iVar) {
        if (offlineQueueDatabase_Impl.l() && offlineQueueDatabase_Impl.h().N().i()) {
            return callable.call();
        }
        if (iVar.getContext().o(p.f3834f) != null) {
            throw new ClassCastException();
        }
        Map map = offlineQueueDatabase_Impl.f2675j;
        Object z0Var = map.get("TransactionDispatcher");
        if (z0Var == null) {
            q qVar = offlineQueueDatabase_Impl.f2668c;
            if (qVar == null) {
                q7.k.j("internalTransactionExecutor");
                throw null;
            }
            z0Var = new z0(qVar);
            map.put("TransactionDispatcher", z0Var);
        }
        return d0.B((x) z0Var, new b(callable, null, 0), iVar);
    }

    public static String c(String str, String str2) {
        q7.k.e(str, "tableName");
        q7.k.e(str2, "triggerType");
        return "`room_table_modification_trigger_" + str + '_' + str2 + '`';
    }
}
