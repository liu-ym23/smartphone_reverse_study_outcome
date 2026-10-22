package o1;

import android.database.Cursor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f9020c = 1;

    public f(yb.u uVar) {
        super(1);
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        ArrayList arrayList;
        long j10;
        g5.c0 c0Var;
        int i;
        int i3;
        g5.d dVar;
        long j11;
        long jG;
        int i10;
        boolean z10;
        switch (this.f9020c) {
            case 0:
                ((m) obj).getClass();
                return Boolean.TRUE;
            default:
                WorkDatabase workDatabase = (WorkDatabase) obj;
                workDatabase.getClass();
                od.f fVar = p5.p.f9763z;
                p5.s sVarC = workDatabase.C();
                sVarC.getClass();
                androidx.room.x xVarD = androidx.room.x.d(1, "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)");
                xVarD.h(1, "agent_safety_eod_log_sync");
                WorkDatabase_Impl workDatabase_Impl = sVarC.f9791a;
                workDatabase_Impl.b();
                workDatabase_Impl.c();
                try {
                    Cursor cursorD = td.h.D(workDatabase_Impl, xVarD, true);
                    try {
                        HashMap map = new HashMap();
                        HashMap map2 = new HashMap();
                        while (true) {
                            int i11 = 0;
                            if (!cursorD.moveToNext()) {
                                cursorD.moveToPosition(-1);
                                sVarC.b(map);
                                sVarC.a(map2);
                                ArrayList arrayList2 = new ArrayList(cursorD.getCount());
                                while (cursorD.moveToNext()) {
                                    arrayList2.add(new p5.o(cursorD.getString(0), a.a.L(cursorD.getInt(1)), g5.h.a(cursorD.getBlob(2)), cursorD.getLong(14), cursorD.getLong(15), cursorD.getLong(16), new g5.d(a.a.a0(cursorD.getBlob(6)), a.a.J(cursorD.getInt(5)), cursorD.getInt(7) != 0, cursorD.getInt(8) != 0, cursorD.getInt(9) != 0, cursorD.getInt(10) != 0, cursorD.getLong(11), cursorD.getLong(12), a.a.l(cursorD.getBlob(13))), cursorD.getInt(3), a.a.I(cursorD.getInt(17)), cursorD.getLong(18), cursorD.getLong(19), cursorD.getInt(20), cursorD.getInt(4), cursorD.getLong(21), cursorD.getInt(22), (ArrayList) map.get(cursorD.getString(0)), (ArrayList) map2.get(cursorD.getString(0))));
                                }
                                workDatabase_Impl.v();
                                cursorD.close();
                                xVarD.e();
                                workDatabase_Impl.q();
                                fVar.getClass();
                                ArrayList arrayList3 = new ArrayList(kb.m.m0(arrayList2, 10));
                                int size = arrayList2.size();
                                int i12 = 0;
                                while (i12 < size) {
                                    Object obj2 = arrayList2.get(i12);
                                    int i13 = i12 + 1;
                                    p5.o oVar = (p5.o) obj2;
                                    int i14 = oVar.f9747b;
                                    List list = oVar.f9761q;
                                    g5.h hVar = !list.isEmpty() ? (g5.h) list.get(i11) : g5.h.f4318b;
                                    UUID uuidFromString = UUID.fromString(oVar.f9746a);
                                    uuidFromString.getClass();
                                    HashSet hashSet = new HashSet(oVar.f9760p);
                                    g5.h hVar2 = oVar.f9748c;
                                    int i15 = oVar.f9753h;
                                    int i16 = oVar.f9757m;
                                    g5.d dVar2 = oVar.f9752g;
                                    long j12 = oVar.f9749d;
                                    int i17 = size;
                                    long j13 = oVar.f9750e;
                                    if (j13 != 0) {
                                        arrayList = arrayList2;
                                        j10 = j12;
                                        long j14 = oVar.f9751f;
                                        c0Var = new g5.c0();
                                        c0Var.f4284a = j13;
                                        c0Var.f4285b = j14;
                                        VarHandle.storeStoreFence();
                                    } else {
                                        arrayList = arrayList2;
                                        j10 = j12;
                                        c0Var = null;
                                    }
                                    if (i14 == 1) {
                                        String str = p5.p.f9762y;
                                        if (i14 != 1 || i15 <= 0) {
                                            i10 = i16;
                                            z10 = false;
                                        } else {
                                            i10 = i16;
                                            z10 = true;
                                        }
                                        int i18 = oVar.i;
                                        int i19 = i10;
                                        long j15 = oVar.f9754j;
                                        long j16 = oVar.f9755k;
                                        int i20 = oVar.f9756l;
                                        boolean z11 = j13 != 0;
                                        dVar = dVar2;
                                        i3 = i19;
                                        jG = p5.f.g(z10, i15, i18, j15, j16, i20, z11, j10, oVar.f9751f, j13, oVar.f9758n);
                                        i = i13;
                                        j11 = j10;
                                    } else {
                                        i = i13;
                                        i3 = i16;
                                        dVar = dVar2;
                                        j11 = j10;
                                        jG = Long.MAX_VALUE;
                                    }
                                    long j17 = jG;
                                    int i21 = oVar.f9759o;
                                    if (i14 == 0) {
                                        throw null;
                                    }
                                    hVar2.getClass();
                                    hVar.getClass();
                                    g5.d0 d0Var = new g5.d0();
                                    d0Var.f4295a = uuidFromString;
                                    d0Var.f4305l = i14;
                                    d0Var.f4296b = hashSet;
                                    d0Var.f4297c = hVar2;
                                    d0Var.f4298d = hVar;
                                    d0Var.f4299e = i15;
                                    d0Var.f4300f = i3;
                                    d0Var.f4301g = dVar;
                                    d0Var.f4302h = j11;
                                    d0Var.i = c0Var;
                                    d0Var.f4303j = j17;
                                    d0Var.f4304k = i21;
                                    VarHandle.storeStoreFence();
                                    arrayList3.add(d0Var);
                                    i12 = i;
                                    size = i17;
                                    arrayList2 = arrayList;
                                    i11 = 0;
                                }
                                return arrayList3;
                            }
                            String string = cursorD.getString(0);
                            if (!map.containsKey(string)) {
                                map.put(string, new ArrayList());
                            }
                            String string2 = cursorD.getString(0);
                            if (!map2.containsKey(string2)) {
                                map2.put(string2, new ArrayList());
                            }
                        }
                    } catch (Throwable th) {
                        cursorD.close();
                        xVarD.e();
                        throw th;
                    }
                } catch (Throwable th2) {
                    workDatabase_Impl.q();
                    throw th2;
                }
        }
    }

    public /* synthetic */ f(int i) {
        super(i);
    }
}
