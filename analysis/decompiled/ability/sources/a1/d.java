package a1;

import H.h;
import H4.o;
import android.util.Log;
import b1.C0820a;
import cc.dd.ee.ee.cc.a$a;
import g1.AbstractC1451a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import m1.AbstractC1673a;
import org.json.JSONObject;
import w0.C2086g;
import x0.C2112a;

/* loaded from: classes2.dex */
public final class d extends AbstractC1673a {

    /* renamed from: a, reason: collision with root package name */
    public AtomicBoolean f1630a;
    public C0820a b;
    public K1.a c;
    public HashMap d;
    public HashMap e;
    public HashMap f;

    public static C0297a a(a$a a_a, C0297a c0297a, double d, double d6) {
        if (c0297a == null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            c0297a = new C0297a();
            c0297a.f1627a = a_a;
            c0297a.g = jCurrentTimeMillis;
            c0297a.h = 0;
            C2086g.b().getClass();
            c0297a.f = C2086g.c();
        }
        if (d >= 0.0d || d6 >= 0.0d) {
            c0297a.h++;
        }
        if (d6 >= 0.0d) {
            c0297a.d += d6;
        }
        if (d >= 0.0d) {
            c0297a.b += d;
        }
        if (c0297a.c < d) {
            c0297a.c = d;
        }
        if (c0297a.e < d6) {
            c0297a.e = d6;
        }
        return c0297a;
    }

    public final C0297a d(a$a a_a, String str) {
        int iOrdinal = a_a.ordinal();
        if (iOrdinal == 0) {
            return (C0297a) this.d.get(str);
        }
        if (iOrdinal == 1) {
            return (C0297a) this.e.get(str);
        }
        if (iOrdinal != 2) {
            return null;
        }
        return (C0297a) this.f.get(str);
    }

    public final void e(a$a a_a, J1.b bVar) {
        long j5;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iOrdinal = a_a.ordinal();
        Iterator it = iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 2 ? null : this.f.entrySet().iterator() : this.e.entrySet().iterator() : this.d.entrySet().iterator();
        if (it == null) {
            return;
        }
        while (it.hasNext()) {
            C0297a c0297a = (C0297a) ((Map.Entry) it.next()).getValue();
            if (jCurrentTimeMillis - c0297a.g > this.b.c * 1000) {
                it.remove();
                double d = c0297a.b;
                double d6 = c0297a.h;
                double d10 = d / d6;
                double d11 = c0297a.c;
                double d12 = c0297a.d / d6;
                double d13 = c0297a.e;
                if (AbstractC1451a.f4467a) {
                    o.f("APM-CPU", "cpu cache item: " + c0297a);
                    j5 = jCurrentTimeMillis;
                    o.f("APM-CPU", "assemble cpu data, type: " + a_a + " rate: " + d10 + " maxRate: " + d11 + " speed: " + d12 + " maxSpeed: " + d13);
                } else {
                    j5 = jCurrentTimeMillis;
                }
                String str = c0297a.f;
                f fVar = new f();
                fVar.i = true;
                fVar.f1634j = "cpu";
                fVar.b = a_a;
                fVar.d = str;
                fVar.e = d10;
                fVar.f = d11;
                fVar.g = d12;
                fVar.h = d13;
                fVar.c = bVar;
                try {
                    fVar.i = ((L1.a) this.c.d).a();
                } catch (Throwable unused) {
                }
                if (h.b) {
                    Log.d("ApmInsight", U7.a.e(new String[]{"Receive:ProcessCpuData"}));
                }
                N0.a.a(fVar);
                try {
                    JSONObject jSONObjectB = fVar.b();
                    if (jSONObjectB != null) {
                        C2112a.c.a(jSONObjectB.toString());
                    }
                } catch (Throwable unused2) {
                }
                jCurrentTimeMillis = j5;
            }
        }
    }

    public final void f(a$a a_a, String str, C0297a c0297a) {
        int iOrdinal = a_a.ordinal();
        if (iOrdinal == 0) {
            this.d.put(str, c0297a);
        } else if (iOrdinal == 1) {
            this.e.put(str, c0297a);
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.f.put(str, c0297a);
        }
    }
}
