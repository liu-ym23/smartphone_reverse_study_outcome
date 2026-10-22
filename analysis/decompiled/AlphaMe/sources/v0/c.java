package v0;

import B0.k;
import B0.p;
import B0.r;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.room.A;
import androidx.room.G;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import s0.C0847e;
import s0.t;
import s0.u;
import t0.C0911F;
import t0.InterfaceC0918d;
import t0.x;

/* loaded from: classes.dex */
public final class c implements InterfaceC0918d {

    /* renamed from: f, reason: collision with root package name */
    public static final String f15676f = t.f("CommandHandler");

    /* renamed from: a, reason: collision with root package name */
    public final Context f15677a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f15678b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Object f15679c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final y1.f f15680d;

    /* renamed from: e, reason: collision with root package name */
    public final B0.e f15681e;

    public c(Context context, y1.f fVar, B0.e eVar) {
        this.f15677a = context;
        this.f15680d = fVar;
        this.f15681e = eVar;
    }

    public static k b(Intent intent) {
        return new k(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    public static void d(Intent intent, k kVar) {
        intent.putExtra("KEY_WORKSPEC_ID", kVar.f150a);
        intent.putExtra("KEY_WORKSPEC_GENERATION", kVar.f151b);
    }

    public final void a(Intent intent, int i4, j jVar) {
        List<x> listL;
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            t.d().a(f15676f, "Handling constraints changed " + intent);
            e eVar = new e(this.f15677a, this.f15680d, i4, jVar);
            ArrayList arrayListF = jVar.f15712e.f15327d.g().f();
            String str = d.f15682a;
            Iterator it = arrayListF.iterator();
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            while (it.hasNext()) {
                C0847e c0847e = ((r) it.next()).f176j;
                z4 |= c0847e.f14188d;
                z5 |= c0847e.f14186b;
                z6 |= c0847e.f14189e;
                z7 |= c0847e.f14185a != u.f14214a;
                if (z4 && z5 && z6 && z7) {
                    break;
                }
            }
            String str2 = ConstraintProxyUpdateReceiver.f4329a;
            Intent intent2 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
            Context context = eVar.f15684a;
            intent2.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
            intent2.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z4).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z5).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z6).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z7);
            context.sendBroadcast(intent2);
            ArrayList arrayList = new ArrayList(arrayListF.size());
            eVar.f15685b.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Iterator it2 = arrayListF.iterator();
            while (it2.hasNext()) {
                r rVar = (r) it2.next();
                if (jCurrentTimeMillis >= rVar.a() && (!rVar.c() || eVar.f15687d.b(rVar))) {
                    arrayList.add(rVar);
                }
            }
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                r rVar2 = (r) it3.next();
                String str3 = rVar2.f167a;
                k kVarV = B0.f.v(rVar2);
                Intent intent3 = new Intent(context, (Class<?>) SystemAlarmService.class);
                intent3.setAction("ACTION_DELAY_MET");
                d(intent3, kVarV);
                t.d().a(e.f15683e, B0.g.n("Creating a delay_met command for workSpec with id (", str3, ")"));
                ((E0.c) jVar.f15709b).f403d.execute(new android.support.v4.os.a(jVar, intent3, eVar.f15686c));
            }
            return;
        }
        if ("ACTION_RESCHEDULE".equals(action)) {
            t.d().a(f15676f, "Handling reschedule " + intent + ", " + i4);
            jVar.f15712e.g0();
            return;
        }
        Bundle extras = intent.getExtras();
        String[] strArr = {"KEY_WORKSPEC_ID"};
        if (extras == null || extras.isEmpty() || extras.get(strArr[0]) == null) {
            t.d().b(f15676f, "Invalid request for " + action + " , requires KEY_WORKSPEC_ID .");
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            k kVarB = b(intent);
            String str4 = f15676f;
            t.d().a(str4, "Handling schedule work for " + kVarB);
            WorkDatabase workDatabase = jVar.f15712e.f15327d;
            workDatabase.beginTransaction();
            try {
                r rVarI = workDatabase.g().i(kVarB.f150a);
                if (rVarI == null) {
                    t.d().g(str4, "Skipping scheduling " + kVarB + " because it's no longer in the DB");
                } else if (rVarI.f168b.a()) {
                    t.d().g(str4, "Skipping scheduling " + kVarB + "because it is finished.");
                } else {
                    long jA = rVarI.a();
                    boolean zC = rVarI.c();
                    Context context2 = this.f15677a;
                    if (zC) {
                        t.d().a(str4, "Opportunistically setting an alarm for " + kVarB + "at " + jA);
                        b.b(context2, workDatabase, kVarB, jA);
                        Intent intent4 = new Intent(context2, (Class<?>) SystemAlarmService.class);
                        intent4.setAction("ACTION_CONSTRAINTS_CHANGED");
                        ((E0.c) jVar.f15709b).f403d.execute(new android.support.v4.os.a(jVar, intent4, i4));
                    } else {
                        t.d().a(str4, "Setting up Alarms for " + kVarB + "at " + jA);
                        b.b(context2, workDatabase, kVarB, jA);
                    }
                    workDatabase.setTransactionSuccessful();
                }
                workDatabase.endTransaction();
                return;
            } catch (Throwable th) {
                workDatabase.endTransaction();
                throw th;
            }
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            synchronized (this.f15679c) {
                try {
                    k kVarB2 = b(intent);
                    t tVarD = t.d();
                    String str5 = f15676f;
                    tVarD.a(str5, "Handing delay met for " + kVarB2);
                    if (this.f15678b.containsKey(kVarB2)) {
                        t.d().a(str5, "WorkSpec " + kVarB2 + " is is already being handled for ACTION_DELAY_MET");
                    } else {
                        g gVar = new g(this.f15677a, i4, jVar, this.f15681e.n(kVarB2));
                        this.f15678b.put(kVarB2, gVar);
                        gVar.e();
                    }
                } finally {
                }
            }
            return;
        }
        if (!"ACTION_STOP_WORK".equals(action)) {
            if (!"ACTION_EXECUTION_COMPLETED".equals(action)) {
                t.d().g(f15676f, "Ignoring intent " + intent);
                return;
            }
            k kVarB3 = b(intent);
            boolean z8 = intent.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
            t.d().a(f15676f, "Handling onExecutionCompleted " + intent + ", " + i4);
            c(kVarB3, z8);
            return;
        }
        Bundle extras2 = intent.getExtras();
        String string = extras2.getString("KEY_WORKSPEC_ID");
        boolean zContainsKey = extras2.containsKey("KEY_WORKSPEC_GENERATION");
        B0.e eVar2 = this.f15681e;
        if (zContainsKey) {
            int i5 = extras2.getInt("KEY_WORKSPEC_GENERATION");
            ArrayList arrayList2 = new ArrayList(1);
            x xVarM = eVar2.m(new k(string, i5));
            listL = arrayList2;
            if (xVarM != null) {
                arrayList2.add(xVarM);
                listL = arrayList2;
            }
        } else {
            listL = eVar2.l(string);
        }
        for (x workSpecId : listL) {
            t.d().a(f15676f, B0.g.m("Handing stopWork work for ", string));
            C0911F c0911f = jVar.f15717j;
            c0911f.getClass();
            Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
            c0911f.a(workSpecId, -512);
            WorkDatabase workDatabase2 = jVar.f15712e.f15327d;
            String str6 = b.f15675a;
            p pVar = (p) workDatabase2.d();
            k id = workSpecId.f15425a;
            B0.h hVarB = pVar.b(id);
            if (hVarB != null) {
                b.a(this.f15677a, id, hVarB.f147c);
                t.d().a(b.f15675a, "Removing SystemIdInfo for workSpecId (" + id + ")");
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(id, "id");
                A a4 = pVar.f160a;
                a4.assertNotSuspendingTransaction();
                G g4 = pVar.f162c;
                k0.j jVarAcquire = g4.acquire();
                String str7 = id.f150a;
                if (str7 == null) {
                    jVarAcquire.bindNull(1);
                } else {
                    jVarAcquire.bindString(1, str7);
                }
                jVarAcquire.bindLong(2, id.f151b);
                a4.beginTransaction();
                try {
                    jVarAcquire.executeUpdateDelete();
                    a4.setTransactionSuccessful();
                } finally {
                    a4.endTransaction();
                    g4.release(jVarAcquire);
                }
            }
            jVar.c(id, false);
        }
    }

    @Override // t0.InterfaceC0918d
    public final void c(k kVar, boolean z4) {
        synchronized (this.f15679c) {
            try {
                g gVar = (g) this.f15678b.remove(kVar);
                this.f15681e.m(kVar);
                if (gVar != null) {
                    gVar.f(z4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
