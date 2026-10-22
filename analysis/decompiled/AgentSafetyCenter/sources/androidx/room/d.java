package androidx.room;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.lifecycle.s0;
import g9.g1;
import g9.t0;
import g9.u0;
import g9.z0;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kc.a1;
import s8.a3;
import s8.d1;
import s8.y2;
import u1.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d extends yb.i implements xb.l {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f1516m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i, Object obj, Class cls, String str, String str2, int i3, int i10, int i11) {
        super(i, obj, cls, str, str2, i3, i10);
        this.f1516m = i11;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        Object objL;
        switch (this.f1516m) {
            case 0:
                ((Set) obj).getClass();
                f fVar = (f) this.f16083f;
                ReentrantLock reentrantLock = fVar.f1527d;
                reentrantLock.lock();
                try {
                    List listL0 = kb.l.L0(fVar.f1526c.values());
                    reentrantLock.unlock();
                    Iterator it = listL0.iterator();
                    if (!it.hasNext()) {
                        return jb.v.f6774a;
                    }
                    ((l) it.next()).getClass();
                    throw null;
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            case 1:
                ((b1.s) this.f16083f).getClass();
                Object obj2 = ((b1.q) obj).f15114c;
                v1 v1Var = obj2 instanceof v1 ? (v1) obj2 : null;
                if (v1Var != null) {
                    u1.f.n(v1Var);
                }
                return jb.v.f6774a;
            case 2:
                jb.v vVar = jb.v.f6774a;
                g1 g1Var = (g1) obj;
                g1Var.getClass();
                Context context = ((g9.u) this.f16083f).f4623a;
                t0 t0Var = g1Var.f4465c;
                if (t0Var.f4616b == u0.f4626g) {
                    Intent intent = new Intent("stepos.intent.action.AGENT_PERMISSION_CHANGED");
                    intent.setPackage(context.getPackageName());
                    intent.putExtra("permission_key", t0Var.f4617c);
                    z0 z0Var = t0Var.f4619e;
                    intent.putExtra("to_option", z0Var != null ? z0Var.name() : null);
                    z0 z0Var2 = t0Var.f4618d;
                    intent.putExtra("from_option", z0Var2 != null ? z0Var2.name() : null);
                    intent.putExtra("report_id", g1Var.f4463a);
                    intent.putExtra("timestamp_ms", t0Var.f4621g);
                    try {
                        context.sendBroadcast(intent);
                        objL = vVar;
                    } catch (Throwable th2) {
                        objL = id.c.l(th2);
                    }
                    Throwable thB = jb.i.b(objL);
                    if (thB != null) {
                        Log.w("PermissionReport", "send permission change broadcast failed: " + thB.getMessage());
                    }
                }
                return vVar;
            case 3:
                return ((m8.k0) this.f16083f).z((nb.c) obj);
            case 4:
                return ((m8.k0) this.f16083f).x((nb.c) obj);
            case 5:
                return ((m8.k0) this.f16083f).m((nb.c) obj);
            case 6:
                d1 d1Var = (d1) obj;
                d1Var.getClass();
                m8.k0 k0Var = (m8.k0) this.f16083f;
                k0Var.getClass();
                if (d1Var != k0Var.v().f8277j) {
                    k0Var.U(m8.a.a(k0Var.v(), false, null, null, null, 0, null, null, false, null, d1Var, -1, null, null, null, null, null, 0, null, false, null, false, null, null, false, 0, null, null, null, 1073740287));
                    k0Var.N();
                    if (d1Var == d1.f11539c) {
                        q8.t tVarU = k0Var.u();
                        LocalDate localDateNow = LocalDate.now(k0Var.f8420d);
                        localDateNow.getClass();
                        long j10 = tVarU.j(localDateNow);
                        if (k0Var.f8428m != 0 && k0Var.f8428m != j10) {
                            kc.w.u(s0.h(k0Var), null, null, new m8.d(7, k0Var, null), 3);
                        }
                    }
                }
                return jb.v.f6774a;
            case 7:
                int iIntValue = ((Number) obj).intValue();
                m8.k0 k0Var2 = (m8.k0) this.f16083f;
                if (iIntValue != k0Var2.v().f8278k) {
                    k0Var2.U(m8.a.a(k0Var2.v(), false, null, null, null, 0, null, null, false, null, null, iIntValue, null, null, null, null, null, 0, null, false, null, false, null, null, false, 0, null, null, null, 1073740799));
                }
                return jb.v.f6774a;
            case 8:
                List list = (List) obj;
                list.getClass();
                m8.k0 k0Var3 = (m8.k0) this.f16083f;
                k0Var3.getClass();
                a3 a3Var = k0Var3.v().f8287t;
                if (a3Var == null) {
                    Log.w("BehaviorAnalysis", "[revoke] confirm ignored: no active revokeDialogRequest");
                } else if (list.isEmpty()) {
                    Log.w("BehaviorAnalysis", "[revoke] confirm ignored: empty selectedKeys");
                } else {
                    List list2 = a3Var.f11452b;
                    int iL = kb.x.L(kb.m.m0(list2, 10));
                    if (iL < 16) {
                        iL = 16;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(iL);
                    for (Object obj3 : list2) {
                        linkedHashMap.put(((y2) obj3).f12124a, obj3);
                    }
                    Log.i("BehaviorAnalysis", "[revoke] confirm start: mode=" + a3Var.f11451a + " selected=" + list.size() + " keys=" + list);
                    kc.w.u(s0.h(k0Var3), null, null, new m8.m(k0Var3, list, a3Var, linkedHashMap, null), 3);
                }
                return jb.v.f6774a;
            default:
                ((a1) this.f16083f).l((Throwable) obj);
                return jb.v.f6774a;
        }
    }
}
