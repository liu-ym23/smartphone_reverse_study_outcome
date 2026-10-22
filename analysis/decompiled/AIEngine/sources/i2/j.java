package i2;

import androidx.datastore.preferences.protobuf.b1;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9469a = h2.j.f("Schedulers");

    public static void a(q2.q qVar, b1 b1Var, List list) {
        if (list.size() > 0) {
            b1Var.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                qVar.c(jCurrentTimeMillis, ((q2.p) it.next()).f11505a);
            }
        }
    }

    public static void b(androidx.work.a aVar, WorkDatabase workDatabase, List<h> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        q2.q qVarW = workDatabase.w();
        workDatabase.c();
        try {
            ArrayList arrayListW = qVarW.w();
            a(qVarW, aVar.f2817d, arrayListW);
            ArrayList arrayListQ = qVarW.q(aVar.f2823k);
            a(qVarW, aVar.f2817d, arrayListQ);
            arrayListQ.addAll(arrayListW);
            ArrayList arrayListM = qVarW.m();
            workDatabase.p();
            workDatabase.k();
            if (arrayListQ.size() > 0) {
                q2.p[] pVarArr = (q2.p[]) arrayListQ.toArray(new q2.p[arrayListQ.size()]);
                for (h hVar : list) {
                    if (hVar.d()) {
                        hVar.c(pVarArr);
                    }
                }
            }
            if (arrayListM.size() > 0) {
                q2.p[] pVarArr2 = (q2.p[]) arrayListM.toArray(new q2.p[arrayListM.size()]);
                for (h hVar2 : list) {
                    if (!hVar2.d()) {
                        hVar2.c(pVarArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.k();
            throw th;
        }
    }
}
