package j5;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import g5.j;
import g5.u;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kb.l;
import l5.k;
import p5.i;
import p5.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements h5.a {

    /* renamed from: j, reason: collision with root package name */
    public static final String f6559j = u.f("CommandHandler");

    /* renamed from: c, reason: collision with root package name */
    public Context f6560c;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f6561f;

    /* renamed from: g, reason: collision with root package name */
    public Object f6562g;

    /* renamed from: h, reason: collision with root package name */
    public j f6563h;
    public p5.c i;

    public static p5.j b(Intent intent) {
        return new p5.j(intent.getStringExtra("KEY_WORKSPEC_ID"), intent.getIntExtra("KEY_WORKSPEC_GENERATION", 0));
    }

    public static void c(Intent intent, p5.j jVar) {
        intent.putExtra("KEY_WORKSPEC_ID", jVar.f9734a);
        intent.putExtra("KEY_WORKSPEC_GENERATION", jVar.f9735b);
    }

    public final void a(int i, Intent intent, h hVar) {
        List<h5.j> listQ;
        ArrayList arrayList;
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            u.d().a(f6559j, "Handling constraints changed " + intent);
            Context context = this.f6560c;
            j jVar = this.f6563h;
            d dVar = new d();
            dVar.f6566a = jVar;
            dVar.f6567b = i;
            dVar.f6568c = new ne.b(hVar.i.f5378j);
            VarHandle.storeStoreFence();
            ArrayList arrayListH = hVar.i.f5372c.C().h();
            String str = c.f6564a;
            int size = arrayListH.size();
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            boolean z13 = false;
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayListH.get(i3);
                i3++;
                g5.d dVar2 = ((p) obj).f9772j;
                z10 |= dVar2.f4291e;
                z11 |= dVar2.f4289c;
                z12 |= dVar2.f4292f;
                z13 |= dVar2.f4287a != 1;
                if (z10 && z11 && z12 && z13) {
                    break;
                }
            }
            String str2 = ConstraintProxyUpdateReceiver.f1669a;
            Intent intent2 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
            intent2.setComponent(new ComponentName(context, (Class<?>) ConstraintProxyUpdateReceiver.class));
            intent2.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z10).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z11).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z12).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z13);
            context.sendBroadcast(intent2);
            ArrayList arrayList2 = new ArrayList(arrayListH.size());
            dVar.f6566a.getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            int size2 = arrayListH.size();
            int i10 = 0;
            while (i10 < size2) {
                Object obj2 = arrayListH.get(i10);
                i10++;
                p pVar = (p) obj2;
                if (jCurrentTimeMillis >= pVar.a()) {
                    if (pVar.b()) {
                        ne.b bVar = dVar.f6568c;
                        bVar.getClass();
                        ArrayList arrayList3 = bVar.f8958c;
                        ArrayList arrayList4 = new ArrayList();
                        int size3 = arrayList3.size();
                        int i11 = 0;
                        while (i11 < size3) {
                            Object obj3 = arrayList3.get(i11);
                            i11++;
                            if (((m5.d) obj3).a(pVar)) {
                                arrayList4.add(obj3);
                            }
                        }
                        if (arrayList4.isEmpty()) {
                            arrayList = arrayListH;
                        } else {
                            u uVarD = u.d();
                            String str3 = k.f7750a;
                            StringBuilder sb2 = new StringBuilder("Work ");
                            sb2.append(pVar.f9764a);
                            sb2.append(" constrained by ");
                            arrayList = arrayListH;
                            sb2.append(l.B0(arrayList4, null, null, null, l5.h.f7744c, 31));
                            uVarD.a(str3, sb2.toString());
                        }
                        if (arrayList4.isEmpty()) {
                        }
                    } else {
                        arrayList = arrayListH;
                    }
                    arrayList2.add(pVar);
                } else {
                    arrayList = arrayListH;
                }
                arrayListH = arrayList;
            }
            int size4 = arrayList2.size();
            int i12 = 0;
            while (i12 < size4) {
                Object obj4 = arrayList2.get(i12);
                i12++;
                p pVar2 = (p) obj4;
                String str4 = pVar2.f9764a;
                p5.j jVarR = td.h.r(pVar2);
                Intent intent3 = new Intent(context, (Class<?>) SystemAlarmService.class);
                intent3.setAction("ACTION_DELAY_MET");
                c(intent3, jVarR);
                u.d().a(d.f6565d, "Creating a delay_met command for workSpec with id (" + str4 + ")");
                ((r5.a) hVar.f6589f.f9733h).execute(new androidx.activity.h(dVar.f6567b, intent3, hVar));
            }
            return;
        }
        boolean z14 = false;
        if ("ACTION_RESCHEDULE".equals(action)) {
            u.d().a(f6559j, "Handling reschedule " + intent + ", " + i);
            hVar.i.e();
            return;
        }
        Bundle extras = intent.getExtras();
        String[] strArr = {"KEY_WORKSPEC_ID"};
        if (extras == null || extras.isEmpty() || extras.get(strArr[0]) == null) {
            u.d().b(f6559j, "Invalid request for " + action + " , requires KEY_WORKSPEC_ID .");
            return;
        }
        if ("ACTION_SCHEDULE_WORK".equals(action)) {
            Context context2 = this.f6560c;
            p5.j jVarB = b(intent);
            u uVarD2 = u.d();
            String str5 = f6559j;
            uVarD2.a(str5, "Handling schedule work for " + jVarB);
            WorkDatabase workDatabase = hVar.i.f5372c;
            workDatabase.c();
            try {
                p pVarJ = workDatabase.C().j(jVarB.f9734a);
                if (pVarJ == null) {
                    u.d().g(str5, "Skipping scheduling " + jVarB + " because it's no longer in the DB");
                    return;
                }
                if (androidx.activity.b.a(pVarJ.f9765b)) {
                    u.d().g(str5, "Skipping scheduling " + jVarB + "because it is finished.");
                    return;
                }
                long jA = pVarJ.a();
                if (pVarJ.b()) {
                    u.d().a(str5, "Opportunistically setting an alarm for " + jVarB + "at " + jA);
                    a.b(context2, workDatabase, jVarB, jA);
                    Intent intent4 = new Intent(context2, (Class<?>) SystemAlarmService.class);
                    intent4.setAction("ACTION_CONSTRAINTS_CHANGED");
                    ((r5.a) hVar.f6589f.f9733h).execute(new androidx.activity.h(i, intent4, hVar));
                } else {
                    u.d().a(str5, "Setting up Alarms for " + jVarB + "at " + jA);
                    a.b(context2, workDatabase, jVarB, jA);
                }
                workDatabase.v();
                return;
            } finally {
                workDatabase.q();
            }
        }
        if ("ACTION_DELAY_MET".equals(action)) {
            synchronized (this.f6562g) {
                try {
                    p5.j jVarB2 = b(intent);
                    u uVarD3 = u.d();
                    String str6 = f6559j;
                    uVarD3.a(str6, "Handing delay met for " + jVarB2);
                    if (this.f6561f.containsKey(jVarB2)) {
                        u.d().a(str6, "WorkSpec " + jVarB2 + " is is already being handled for ACTION_DELAY_MET");
                    } else {
                        f fVar = new f(this.f6560c, i, hVar, this.i.r(jVarB2));
                        this.f6561f.put(jVarB2, fVar);
                        fVar.e();
                    }
                } finally {
                }
            }
            return;
        }
        if (!"ACTION_STOP_WORK".equals(action)) {
            if (!"ACTION_EXECUTION_COMPLETED".equals(action)) {
                u.d().g(f6559j, "Ignoring intent " + intent);
                return;
            }
            p5.j jVarB3 = b(intent);
            boolean z15 = intent.getExtras().getBoolean("KEY_NEEDS_RESCHEDULE");
            u.d().a(f6559j, "Handling onExecutionCompleted " + intent + ", " + i);
            e(jVarB3, z15);
            return;
        }
        p5.c cVar = this.i;
        Bundle extras2 = intent.getExtras();
        String string = extras2.getString("KEY_WORKSPEC_ID");
        if (extras2.containsKey("KEY_WORKSPEC_GENERATION")) {
            int i13 = extras2.getInt("KEY_WORKSPEC_GENERATION");
            ArrayList arrayList5 = new ArrayList(1);
            h5.j jVarO = cVar.o(new p5.j(string, i13));
            listQ = arrayList5;
            if (jVarO != null) {
                arrayList5.add(jVarO);
                listQ = arrayList5;
            }
        } else {
            listQ = cVar.q(string);
        }
        for (h5.j jVar2 : listQ) {
            u.d().a(f6559j, "Handing stopWork work for " + string);
            p5.e eVar = hVar.f6596n;
            eVar.getClass();
            jVar2.getClass();
            eVar.y(jVar2, -512);
            p5.j jVar3 = jVar2.f5348a;
            Context context3 = this.f6560c;
            WorkDatabase workDatabase2 = hVar.i.f5372c;
            String str7 = a.f6558a;
            i iVarZ = workDatabase2.z();
            p5.g gVarW = iVarZ.w(jVar3);
            if (gVarW != null) {
                a.a(context3, jVar3, gVarW.f9728c);
                u.d().a(a.f6558a, "Removing SystemIdInfo for workSpecId (" + jVar3 + ")");
                String str8 = jVar3.f9734a;
                int i14 = jVar3.f9735b;
                WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) iVarZ.f9730c;
                workDatabase_Impl.b();
                p5.h hVar2 = (p5.h) iVarZ.f9732g;
                z4.j jVarA = hVar2.a();
                jVarA.h(1, str8);
                jVarA.c(2, i14);
                try {
                    workDatabase_Impl.c();
                    try {
                        jVarA.d();
                        workDatabase_Impl.v();
                        workDatabase_Impl.q();
                    } catch (Throwable th) {
                        workDatabase_Impl.q();
                        throw th;
                    }
                } finally {
                    hVar2.c(jVarA);
                }
            }
            boolean z16 = z14;
            hVar.e(jVar3, z16);
            z14 = z16;
        }
    }

    @Override // h5.a
    public final void e(p5.j jVar, boolean z10) {
        synchronized (this.f6562g) {
            try {
                f fVar = (f) this.f6561f.remove(jVar);
                this.i.o(jVar);
                if (fVar != null) {
                    fVar.f(z10);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
