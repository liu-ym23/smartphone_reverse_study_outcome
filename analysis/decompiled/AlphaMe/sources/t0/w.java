package t0;

import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s0.C0844b;

/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final String f15424a = s0.t.f("Schedulers");

    public static void a(B0.u uVar, y1.f fVar, ArrayList arrayList) {
        if (arrayList.size() > 0) {
            fVar.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                uVar.k(((B0.r) it.next()).f167a, jCurrentTimeMillis);
            }
        }
    }

    public static void b(C0844b c0844b, WorkDatabase workDatabase, List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        B0.u uVarG = workDatabase.g();
        workDatabase.beginTransaction();
        try {
            ArrayList arrayListD = uVarG.d();
            a(uVarG, c0844b.f14172c, arrayListD);
            ArrayList arrayListC = uVarG.c(c0844b.f14179j);
            a(uVarG, c0844b.f14172c, arrayListC);
            arrayListC.addAll(arrayListD);
            ArrayList arrayListB = uVarG.b();
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            if (arrayListC.size() > 0) {
                B0.r[] rVarArr = (B0.r[]) arrayListC.toArray(new B0.r[arrayListC.size()]);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    t tVar = (t) it.next();
                    if (tVar.d()) {
                        tVar.e(rVarArr);
                    }
                }
            }
            if (arrayListB.size() > 0) {
                B0.r[] rVarArr2 = (B0.r[]) arrayListB.toArray(new B0.r[arrayListB.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    t tVar2 = (t) it2.next();
                    if (!tVar2.d()) {
                        tVar2.e(rVarArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
