package k2;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.datastore.preferences.protobuf.b1;
import androidx.work.NetworkType;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import h2.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import k2.f;
import mb.y;
import q2.g;
import q2.h;
import q2.k;
import q2.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements i2.b {
    public static final String h = j.f("CommandHandler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f9859a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f9860b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Object f9861c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final b1 f9862d;

    /* renamed from: e, reason: collision with root package name */
    public final androidx.preference.c f9863e;

    public b(Context context, b1 b1Var, androidx.preference.c cVar) {
        this.f9859a = context;
        this.f9862d = b1Var;
        this.f9863e = cVar;
    }

    public static k c(Intent intent) {
        return new k(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    public static void d(Intent intent, k kVar) {
        intent.putExtra("KEY_WORKSPEC_ID", kVar.f11498a);
        intent.putExtra("KEY_WORKSPEC_GENERATION", kVar.f11499b);
    }

    @Override // i2.b
    public final void a(k kVar, boolean z) {
        synchronized (this.f9861c) {
            try {
                d dVar = (d) this.f9860b.remove(kVar);
                this.f9863e.m(kVar);
                if (dVar != null) {
                    dVar.g(z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(int i10, Intent intent, f fVar) {
        List<i2.k> listN;
        String action = intent.getAction();
        int i11 = 0;
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            j.d().a(h, "Handling constraints changed " + intent);
            Context context = this.f9859a;
            c cVar = new c(context, this.f9862d, i10, fVar);
            ArrayList arrayListF = fVar.f9887e.f2879c.w().f();
            String str = ConstraintProxy.f2887a;
            int size = arrayListF.size();
            boolean z = false;
            boolean z3 = false;
            boolean z10 = false;
            boolean z11 = false;
            int i12 = 0;
            while (i12 < size) {
                Object obj = arrayListF.get(i12);
                i12++;
                h2.c cVar2 = ((p) obj).f11513j;
                z |= cVar2.f9260e;
                z3 |= cVar2.f9258c;
                z10 |= cVar2.f9261f;
                z11 |= cVar2.f9256a != NetworkType.f2783a;
                if (z && z3 && z10 && z11) {
                    break;
                }
            }
            String str2 = ConstraintProxyUpdateReceiver.f2888a;
            Intent intent2 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
            intent2.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
            intent2.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z3).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z10).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z11);
            context.sendBroadcast(intent2);
            ArrayList arrayList = new ArrayList(arrayListF.size());
            long jZ = cVar.f9865a.z();
            int size2 = arrayListF.size();
            int i13 = 0;
            while (i13 < size2) {
                Object obj2 = arrayListF.get(i13);
                i13++;
                p pVar = (p) obj2;
                if (jZ >= pVar.a() && (!pVar.b() || cVar.f9867c.a(pVar))) {
                    arrayList.add(pVar);
                }
            }
            int size3 = arrayList.size();
            while (i11 < size3) {
                Object obj3 = arrayList.get(i11);
                i11++;
                p pVar2 = (p) obj3;
                String str3 = pVar2.f11505a;
                k kVarT = y.t(pVar2);
                Intent intent3 = new Intent(context, (Class<?>) SystemAlarmService.class);
                intent3.setAction("ACTION_DELAY_MET");
                d(intent3, kVarT);
                j.d().a(c.f9864d, "Creating a delay_met command for workSpec with id (" + str3 + ")");
                fVar.f9884b.a().execute(new f.b(cVar.f9866b, intent3, fVar));
            }
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            j.d().a(h, "Handling reschedule " + intent + ", " + i10);
            fVar.f9887e.d();
            return;
        }
        Bundle extras = intent.getExtras();
        String[] strArr = {"KEY_WORKSPEC_ID"};
        if (extras == null || extras.isEmpty() || extras.get(strArr[0]) == null) {
            j.d().b(h, "Invalid request for " + action + " , requires KEY_WORKSPEC_ID .");
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            Context context2 = this.f9859a;
            k kVarC = c(intent);
            j jVarD = j.d();
            String str4 = h;
            jVarD.a(str4, "Handling schedule work for " + kVarC);
            WorkDatabase workDatabase = fVar.f9887e.f2879c;
            workDatabase.c();
            try {
                p pVarI = workDatabase.w().i(kVarC.f11498a);
                if (pVarI == null) {
                    j.d().g(str4, "Skipping scheduling " + kVarC + " because it's no longer in the DB");
                    return;
                }
                if (pVarI.f11506b.a()) {
                    j.d().g(str4, "Skipping scheduling " + kVarC + "because it is finished.");
                    return;
                }
                long jA = pVarI.a();
                if (pVarI.b()) {
                    j.d().a(str4, "Opportunistically setting an alarm for " + kVarC + "at " + jA);
                    a.b(context2, workDatabase, kVarC, jA);
                    Intent intent4 = new Intent(context2, (Class<?>) SystemAlarmService.class);
                    intent4.setAction("ACTION_CONSTRAINTS_CHANGED");
                    fVar.f9884b.a().execute(new f.b(i10, intent4, fVar));
                } else {
                    j.d().a(str4, "Setting up Alarms for " + kVarC + "at " + jA);
                    a.b(context2, workDatabase, kVarC, jA);
                }
                workDatabase.p();
                return;
            } finally {
                workDatabase.k();
            }
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            synchronized (this.f9861c) {
                try {
                    k kVarC2 = c(intent);
                    j jVarD2 = j.d();
                    String str5 = h;
                    jVarD2.a(str5, "Handing delay met for " + kVarC2);
                    if (this.f9860b.containsKey(kVarC2)) {
                        j.d().a(str5, "WorkSpec " + kVarC2 + " is is already being handled for ACTION_DELAY_MET");
                    } else {
                        d dVar = new d(this.f9859a, i10, fVar, this.f9863e.p(kVarC2));
                        this.f9860b.put(kVarC2, dVar);
                        dVar.f();
                    }
                } finally {
                }
            }
            return;
        }
        if (!"ACTION_STOP_WORK".equals(action)) {
            if (!"ACTION_EXECUTION_COMPLETED".equals(action)) {
                j.d().g(h, "Ignoring intent " + intent);
                return;
            }
            k kVarC3 = c(intent);
            boolean z12 = intent.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
            j.d().a(h, "Handling onExecutionCompleted " + intent + ", " + i10);
            a(kVarC3, z12);
            return;
        }
        androidx.preference.c cVar3 = this.f9863e;
        Bundle extras2 = intent.getExtras();
        String string = extras2.getString("KEY_WORKSPEC_ID");
        if (extras2.containsKey("KEY_WORKSPEC_GENERATION")) {
            int i14 = extras2.getInt("KEY_WORKSPEC_GENERATION");
            ArrayList arrayList2 = new ArrayList(1);
            i2.k kVarM = cVar3.m(new k(string, i14));
            listN = arrayList2;
            if (kVarM != null) {
                arrayList2.add(kVarM);
                listN = arrayList2;
            }
        } else {
            listN = cVar3.n(string);
        }
        for (i2.k kVar : listN) {
            j.d().a(h, "Handing stopWork work for " + string);
            fVar.f9891m.a(kVar);
            Context context3 = this.f9859a;
            WorkDatabase workDatabase2 = fVar.f9887e.f2879c;
            k kVar2 = kVar.f9470a;
            String str6 = a.f9858a;
            h hVarT = workDatabase2.t();
            g gVarC = hVarT.c(kVar2);
            if (gVarC != null) {
                a.a(context3, kVar2, gVarC.f11495c);
                j.d().a(a.f9858a, "Removing SystemIdInfo for workSpecId (" + kVar2 + ")");
                hVarT.l(kVar2);
            }
            fVar.a(kVar.f9470a, false);
        }
    }
}
