package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.c;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b;
import h2.j;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.g;
import q2.h;
import q2.m;
import q2.q;
import q2.u;
import t2.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class DiagnosticsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(Context context, WorkerParameters parameters) {
        super(context, parameters);
        g.f(context, "context");
        g.f(parameters, "parameters");
    }

    @Override // androidx.work.Worker
    public final c.a.C0023c b() {
        b bVarA = b.a(getApplicationContext());
        g.e(bVarA, "getInstance(applicationContext)");
        WorkDatabase workDatabase = bVarA.f2879c;
        g.e(workDatabase, "workManager.workDatabase");
        q qVarW = workDatabase.w();
        m mVarU = workDatabase.u();
        u uVarX = workDatabase.x();
        h hVarT = workDatabase.t();
        bVarA.f2878b.f2817d.getClass();
        ArrayList arrayListD = qVarW.d(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        ArrayList arrayListU = qVarW.u();
        ArrayList arrayListM = qVarW.m();
        if (!arrayListD.isEmpty()) {
            j jVarD = j.d();
            String str = a.f12935a;
            jVarD.e(str, "Recently completed work:\n\n");
            j.d().e(str, a.a(mVarU, uVarX, hVarT, arrayListD));
        }
        if (!arrayListU.isEmpty()) {
            j jVarD2 = j.d();
            String str2 = a.f12935a;
            jVarD2.e(str2, "Running work:\n\n");
            j.d().e(str2, a.a(mVarU, uVarX, hVarT, arrayListU));
        }
        if (!arrayListM.isEmpty()) {
            j jVarD3 = j.d();
            String str3 = a.f12935a;
            jVarD3.e(str3, "Enqueued work:\n\n");
            j.d().e(str3, a.a(mVarU, uVarX, hVarT, arrayListM));
        }
        return new c.a.C0023c();
    }
}
