package h5;

import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final String f5347a = g5.u.f("Schedulers");

    public static void a(p5.s sVar, g5.j jVar, ArrayList arrayList) {
        if (arrayList.size() > 0) {
            jVar.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                sVar.l(((p5.p) obj).f9764a, jCurrentTimeMillis);
            }
        }
    }

    public static void b(g5.a aVar, WorkDatabase workDatabase, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        p5.s sVarC = workDatabase.C();
        workDatabase.c();
        try {
            ArrayList arrayListF = sVarC.f();
            a(sVarC, aVar.f4271d, arrayListF);
            ArrayList arrayListE = sVarC.e(aVar.f4277k);
            a(sVarC, aVar.f4271d, arrayListE);
            arrayListE.addAll(arrayListF);
            ArrayList arrayListD = sVarC.d();
            workDatabase.v();
            workDatabase.q();
            if (arrayListE.size() > 0) {
                p5.p[] pVarArr = (p5.p[]) arrayListE.toArray(new p5.p[arrayListE.size()]);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (fVar.b()) {
                        fVar.d(pVarArr);
                    }
                }
            }
            if (arrayListD.size() > 0) {
                p5.p[] pVarArr2 = (p5.p[]) arrayListD.toArray(new p5.p[arrayListD.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    f fVar2 = (f) it2.next();
                    if (!fVar2.b()) {
                        fVar2.d(pVarArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.q();
            throw th;
        }
    }
}
