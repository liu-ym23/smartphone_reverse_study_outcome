package i5;

import android.database.Cursor;
import android.database.SQLException;
import com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class b implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4644a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f4645b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4646c;

    public /* synthetic */ b(int i2, Object obj, Object obj2) {
        this.f4644a = i2;
        this.f4645b = obj;
        this.f4646c = obj2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() throws SQLException {
        OfflineQueueDatabase_Impl offlineQueueDatabase_Impl;
        c cVar;
        n3.j jVarA;
        switch (this.f4644a) {
            case 0:
                f fVar = (f) this.f4645b;
                StringBuilder sb2 = new StringBuilder("DELETE FROM offline_frame WHERE id IN (");
                List list = (List) this.f4646c;
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    sb2.append("?");
                    if (i2 < size - 1) {
                        sb2.append(",");
                    }
                }
                sb2.append(")");
                String string = sb2.toString();
                offlineQueueDatabase_Impl = (OfflineQueueDatabase_Impl) fVar.f4653g;
                q7.k.e(string, "sql");
                offlineQueueDatabase_Impl.a();
                if (!offlineQueueDatabase_Impl.h().N().i() && offlineQueueDatabase_Impl.f2674i.get() != null) {
                    throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
                }
                n3.j jVarD = offlineQueueDatabase_Impl.h().N().d(string);
                Iterator it = list.iterator();
                int i10 = 1;
                while (it.hasNext()) {
                    jVarD.G(i10, ((Long) it.next()).longValue());
                    i10++;
                }
                offlineQueueDatabase_Impl.b();
                try {
                    jVarD.b();
                    offlineQueueDatabase_Impl.n();
                    offlineQueueDatabase_Impl.k();
                    return c7.r.f1986a;
                } finally {
                }
            case 1:
                f fVar2 = (f) this.f4645b;
                offlineQueueDatabase_Impl = (OfflineQueueDatabase_Impl) fVar2.f4653g;
                offlineQueueDatabase_Impl.b();
                try {
                    cVar = (c) fVar2.f4654h;
                    g gVar = (g) this.f4646c;
                    jVarA = cVar.a();
                    try {
                        cVar.l(jVarA, gVar);
                        long jA = jVarA.a();
                        cVar.j(jVarA);
                        Long lValueOf = Long.valueOf(jA);
                        offlineQueueDatabase_Impl.n();
                        return lValueOf;
                    } finally {
                    }
                } finally {
                }
            case 2:
                l lVar = (l) this.f4645b;
                offlineQueueDatabase_Impl = (OfflineQueueDatabase_Impl) lVar.f4687g;
                offlineQueueDatabase_Impl.b();
                try {
                    cVar = (c) lVar.f4688h;
                    m mVar = (m) this.f4646c;
                    jVarA = cVar.a();
                    try {
                        cVar.l(jVarA, mVar);
                        jVarA.a();
                        cVar.j(jVarA);
                        offlineQueueDatabase_Impl.n();
                        offlineQueueDatabase_Impl.k();
                        return c7.r.f1986a;
                    } finally {
                    }
                } finally {
                }
            default:
                OfflineQueueDatabase_Impl offlineQueueDatabase_Impl2 = (OfflineQueueDatabase_Impl) ((l) this.f4645b).f4687g;
                g3.n nVar = (g3.n) this.f4646c;
                Cursor cursorB0 = a.a.b0(offlineQueueDatabase_Impl2, nVar);
                try {
                    Boolean boolValueOf = cursorB0.moveToFirst() ? Boolean.valueOf(cursorB0.getInt(0) != 0) : Boolean.FALSE;
                    cursorB0.close();
                    nVar.e();
                    return boolValueOf;
                } catch (Throwable th) {
                    cursorB0.close();
                    nVar.e();
                    throw th;
                }
        }
    }
}
