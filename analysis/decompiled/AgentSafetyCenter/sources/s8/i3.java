package s8;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class i3 {

    /* renamed from: a, reason: collision with root package name */
    public static final long f11667a = d1.f0.c(4278913804L);

    /* renamed from: b, reason: collision with root package name */
    public static final long f11668b = d1.f0.c(4280032286L);

    /* renamed from: c, reason: collision with root package name */
    public static final long f11669c = d1.f0.c(4294309367L);

    /* renamed from: d, reason: collision with root package name */
    public static final long f11670d = d1.f0.c(4287532691L);

    /* renamed from: e, reason: collision with root package name */
    public static final long f11671e = d1.f0.c(4287532691L);

    /* renamed from: f, reason: collision with root package name */
    public static final long f11672f = d1.f0.c(4281084974L);

    /* renamed from: g, reason: collision with root package name */
    public static final long f11673g = d1.f0.c(4294924890L);

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f11674h = 0;

    public static final void a(String str, long j10, k0.s sVar, int i) {
        int i3;
        k0.s sVar2 = sVar;
        sVar2.Z(1349476458);
        int i10 = i | (sVar2.f(str) ? 4 : 2);
        if (sVar2.P(i10 & 1, (i10 & 19) != 18)) {
            w0.j jVar = w0.j.f15113c;
            w0.m mVarB = androidx.compose.foundation.layout.c.b(jVar, 1.0f);
            w.r0 r0VarA = w.p0.a(w.k.e(8), w0.b.f15097n, sVar2, 54);
            int iHashCode = Long.hashCode(sVar2.T);
            s0.g gVarL = sVar2.l();
            w0.m mVarM = t.o.m(sVar2, mVarB);
            u1.j.f13840e.getClass();
            u1.z zVar = u1.i.f13833b;
            sVar2.b0();
            if (sVar2.S) {
                sVar2.k(zVar);
            } else {
                sVar2.l0();
            }
            k0.z.B(r0VarA, sVar2, u1.i.f13836e);
            k0.z.B(gVarL, sVar2, u1.i.f13835d);
            u1.h hVar = u1.i.f13837f;
            if (sVar2.S || !yb.k.a(sVar2.M(), Integer.valueOf(iHashCode))) {
                k0.a.y(iHashCode, sVar2, iHashCode, hVar);
            }
            k0.z.B(mVarM, sVar2, u1.i.f13834c);
            i1.f fVarD = com.stepos.statsrpk.h.f2864b;
            if (fVarD == null) {
                i1.e eVar = new i1.e("Filled.Info", 24.0f, 24.0f, 24.0f, 24.0f, 0L, 0, false, 96);
                int i11 = i1.h0.f5700a;
                d1.l0 l0Var = new d1.l0(d1.p.f3019b);
                ha.c cVar = new ha.c();
                ArrayList arrayList = cVar.f5430a;
                cVar.f(12.0f, 2.0f);
                arrayList.add(new i1.k(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f));
                arrayList.add(new i1.x(4.48f, 10.0f, 10.0f, 10.0f));
                arrayList.add(new i1.x(10.0f, -4.48f, 10.0f, -10.0f));
                arrayList.add(new i1.p(17.52f, 2.0f, 12.0f, 2.0f));
                cVar.b();
                cVar.f(13.0f, 17.0f);
                cVar.d(-2.0f);
                cVar.g(-6.0f);
                cVar.d(2.0f);
                cVar.g(6.0f);
                cVar.b();
                cVar.f(13.0f, 9.0f);
                cVar.d(-2.0f);
                cVar.e(11.0f, 7.0f);
                cVar.d(2.0f);
                cVar.g(2.0f);
                cVar.b();
                eVar.a(arrayList, 0, "", l0Var, 1.0f, null, 1.0f, 1.0f, 0, 2, 1.0f, 0.0f, 1.0f, 0.0f);
                fVarD = eVar.d();
                com.stepos.statsrpk.h.f2864b = fVarD;
            }
            h0.o0.b(fVarD, androidx.compose.foundation.layout.c.f(jVar, 18), j10, sVar2, 3504);
            h0.t1.b(str, w.s0.a(), j10, 0L, null, 0L, null, 0L, 0, false, 0, 0, ((h0.v1) sVar2.j(h0.w1.f5235a)).f5222l, sVar, (i10 & 14) | 384, 0, 65528);
            sVar2 = sVar;
            i3 = 1;
            sVar2.q(true);
        } else {
            i3 = 1;
            sVar2.S();
        }
        k0.v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            o8.c cVar2 = new o8.c(i3);
            cVar2.f9301f = str;
            cVar2.f9302g = j10;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = cVar2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(s8.j3 r19, s8.t r20, java.util.Set r21, xb.a r22, xb.l r23, xb.l r24, w0.m r25, k0.s r26, int r27) {
        /*
            Method dump skipped, instructions count: 571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s8.i3.b(s8.j3, s8.t, java.util.Set, xb.a, xb.l, xb.l, w0.m, k0.s, int):void");
    }

    public static final void c(j3 j3Var, String str, k0.s sVar, int i) {
        k0.v1 v1VarS;
        f3 f3Var;
        String string;
        Object obj;
        sVar.Z(-1862701509);
        int i3 = i | (sVar.h(j3Var) ? 4 : 2) | (sVar.f(str) ? 32 : 16);
        if (sVar.P(i3 & 1, (i3 & 19) != 18)) {
            Object objM = sVar.M();
            Object obj2 = k0.m.f6974a;
            if (objM == obj2) {
                objM = ZoneId.systemDefault();
                sVar.i0(objM);
            }
            ZoneId zoneId = (ZoneId) objM;
            String strO = t2.a.o(R.string.task_detail_undo_banner_countdown, sVar);
            Resources resources = ((Context) sVar.j(AndroidCompositionLocals_androidKt.f982b)).getResources();
            Object objM2 = sVar.M();
            if (objM2 == obj2) {
                objM2 = k0.z.v(Instant.now());
                sVar.i0(objM2);
            }
            k0.c1 c1Var = (k0.c1) objM2;
            Object objM3 = sVar.M();
            Object obj3 = null;
            if (objM3 == obj2) {
                objM3 = new androidx.room.e(c1Var, null, 10);
                sVar.i0(objM3);
            }
            k0.z.h(j3Var, sVar, (xb.p) objM3);
            boolean zF = sVar.f((Instant) c1Var.getValue()) | sVar.f(j3Var);
            Object objM4 = sVar.M();
            if (zF || objM4 == obj2) {
                objM4 = x0.u(j3Var);
                sVar.i0(objM4);
            }
            List<p3> list = (List) objM4;
            if (list.isEmpty()) {
                v1VarS = sVar.s();
                if (v1VarS != null) {
                    f3Var = new f3(1);
                    f3Var.f11605f = j3Var;
                    f3Var.f11606g = str;
                    VarHandle.storeStoreFence();
                    v1VarS.f7091d = f3Var;
                }
                return;
            }
            boolean zF2 = ((i3 & 112) == 32) | sVar.f((Instant) c1Var.getValue()) | sVar.f(j3Var) | sVar.f(list) | sVar.f(strO) | sVar.f(resources);
            Object objM5 = sVar.M();
            if (zF2 || objM5 == obj2) {
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str2 = ((p3) it.next()).f11884k;
                    if (str2 == null || hc.h.g0(str2)) {
                        str2 = null;
                    }
                    if (str2 != null) {
                        obj3 = str2;
                        break;
                    }
                }
                if (obj3 == null) {
                    ArrayList arrayList = new ArrayList();
                    for (p3 p3Var : list) {
                        Instant instant = (Instant) c1Var.getValue();
                        instant.getClass();
                        zoneId.getClass();
                        Duration durationV = x0.v(p3Var, instant, zoneId);
                        if (durationV != null) {
                            arrayList.add(durationV);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    int i10 = 0;
                    while (i10 < size) {
                        Object obj4 = arrayList.get(i10);
                        i10++;
                        if (((Duration) obj4).compareTo(Duration.ZERO) > 0) {
                            arrayList2.add(obj4);
                        }
                    }
                    Duration duration = (Duration) kb.l.E0(arrayList2);
                    if (duration == null) {
                        obj = str;
                    } else {
                        resources.getClass();
                        DateTimeFormatter dateTimeFormatter = x0.f12068a;
                        if (duration.compareTo(Duration.ZERO) <= 0) {
                            string = resources.getString(R.string.undo_remaining_zero_minutes);
                            string.getClass();
                        } else {
                            long days = duration.toDays();
                            long hours = duration.toHours() % 24;
                            if (days > 0) {
                                string = resources.getString(R.string.undo_remaining_days_hours, Long.valueOf(days), Long.valueOf(hours));
                                string.getClass();
                            } else if (hours > 0) {
                                string = resources.getString(R.string.undo_remaining_hours, Long.valueOf(hours));
                                string.getClass();
                            } else {
                                long minutes = duration.toMinutes();
                                if (minutes < 1) {
                                    minutes = 1;
                                }
                                string = resources.getString(R.string.undo_remaining_minutes, Long.valueOf(minutes));
                                string.getClass();
                            }
                        }
                        obj = String.format(strO, Arrays.copyOf(new Object[]{string}, 1));
                    }
                    objM5 = obj;
                } else {
                    objM5 = obj3;
                }
                sVar.i0(objM5);
            }
            a((String) objM5, f11673g, sVar, 48);
        } else {
            sVar.S();
        }
        v1VarS = sVar.s();
        if (v1VarS != null) {
            f3Var = new f3(0);
            f3Var.f11605f = j3Var;
            f3Var.f11606g = str;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = f3Var;
        }
    }
}
