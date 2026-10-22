package C0;

import androidx.room.A;
import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import s0.B;
import s0.G;
import t0.C0913H;
import t0.C0929o;
import t0.P;

/* loaded from: classes.dex */
public abstract class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final C0929o f292a = new C0929o();

    public static void a(C0913H c0913h, String str) {
        P pB;
        WorkDatabase workDatabase = c0913h.f15327d;
        B0.u uVarG = workDatabase.g();
        B0.c cVarB = workDatabase.b();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            G g4 = uVarG.g(str2);
            if (g4 != G.f14155c && g4 != G.f14156d) {
                A a4 = uVarG.f191a;
                a4.assertNotSuspendingTransaction();
                B0.s sVar = uVarG.f196f;
                k0.j jVarAcquire = sVar.acquire();
                if (str2 == null) {
                    jVarAcquire.bindNull(1);
                } else {
                    jVarAcquire.bindString(1, str2);
                }
                a4.beginTransaction();
                try {
                    jVarAcquire.executeUpdateDelete();
                    a4.setTransactionSuccessful();
                } finally {
                    a4.endTransaction();
                    sVar.release(jVarAcquire);
                }
            }
            linkedList.addAll(cVarB.f(str2));
        }
        t0.r rVar = c0913h.f15330g;
        synchronized (rVar.f15413k) {
            s0.t.d().a(t0.r.f15402l, "Processor cancelling " + str);
            rVar.f15411i.add(str);
            pB = rVar.b(str);
        }
        t0.r.d(str, pB, 1);
        Iterator it = c0913h.f15329f.iterator();
        while (it.hasNext()) {
            ((t0.t) it.next()).a(str);
        }
    }

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        C0929o c0929o = this.f292a;
        try {
            b();
            c0929o.a(B.f14148a);
        } catch (Throwable th) {
            c0929o.a(new s0.y(th));
        }
    }
}
