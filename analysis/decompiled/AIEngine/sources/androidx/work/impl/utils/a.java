package androidx.work.impl.utils;

import androidx.datastore.preferences.protobuf.b1;
import androidx.room.o;
import androidx.work.WorkInfo$State;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.d;
import com.stepos.core.model.manager.i;
import h2.j;
import h2.n;
import h2.p;
import i2.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import kotlin.jvm.internal.g;
import mb.m;
import q2.q;
import r2.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {
    public static final void a(androidx.work.impl.b bVar, String str) {
        d dVarB;
        WorkDatabase workDatabase = bVar.f2879c;
        g.e(workDatabase, "workManagerImpl.workDatabase");
        q qVarW = workDatabase.w();
        q2.b bVarR = workDatabase.r();
        ArrayList arrayListC0 = m.c0(str);
        while (!arrayListC0.isEmpty()) {
            String str2 = (String) mb.q.j0(arrayListC0);
            WorkInfo$State workInfo$StateH = qVarW.h(str2);
            if (workInfo$StateH != WorkInfo$State.f2794c && workInfo$StateH != WorkInfo$State.f2795d) {
                qVarW.j(str2);
            }
            arrayListC0.addAll(bVarR.d(str2));
        }
        androidx.work.impl.a aVar = bVar.f2882f;
        g.e(aVar, "workManagerImpl.processor");
        synchronized (aVar.f2873k) {
            j.d().a(androidx.work.impl.a.f2863l, "Processor cancelling " + str);
            aVar.f2871i.add(str);
            dVarB = aVar.b(str);
        }
        androidx.work.impl.a.d(str, dVarB, 1);
        Iterator<h> it = bVar.f2881e.iterator();
        while (it.hasNext()) {
            it.next().cancel(str);
        }
    }

    public static final n b(final androidx.work.impl.b workManagerImpl, final UUID id2) {
        g.f(id2, "id");
        g.f(workManagerImpl, "workManagerImpl");
        b1 b1Var = workManagerImpl.f2878b.f2825m;
        k kVarC = workManagerImpl.f2880d.c();
        g.e(kVarC, "workManagerImpl.workTask…ecutor.serialTaskExecutor");
        return p.a(b1Var, "CancelWorkById", kVarC, new zb.a<lb.n>() { // from class: androidx.work.impl.utils.CancelWorkRunnable$forId$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // zb.a
            public final lb.n invoke() {
                androidx.work.impl.b bVar = workManagerImpl;
                WorkDatabase workDatabase = bVar.f2879c;
                g.e(workDatabase, "workManagerImpl.workDatabase");
                workDatabase.o(new o(18, bVar, id2));
                i2.j.b(bVar.f2878b, bVar.f2879c, bVar.f2881e);
                return lb.n.f10413a;
            }
        });
    }

    public static final n c(final androidx.work.impl.b bVar, final String str) {
        b1 b1Var = bVar.f2878b.f2825m;
        String strConcat = "CancelWorkByName_".concat(str);
        k kVarC = bVar.f2880d.c();
        g.e(kVarC, "workManagerImpl.workTask…ecutor.serialTaskExecutor");
        return p.a(b1Var, strConcat, kVarC, new zb.a<lb.n>() { // from class: androidx.work.impl.utils.CancelWorkRunnable$forName$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // zb.a
            public final lb.n invoke() {
                androidx.work.impl.b bVar2 = bVar;
                WorkDatabase workDatabase = bVar2.f2879c;
                g.e(workDatabase, "workManagerImpl.workDatabase");
                workDatabase.o(new i((Object) workDatabase, str, (Object) bVar2, 8));
                i2.j.b(bVar2.f2878b, workDatabase, bVar2.f2881e);
                return lb.n.f10413a;
            }
        });
    }
}
