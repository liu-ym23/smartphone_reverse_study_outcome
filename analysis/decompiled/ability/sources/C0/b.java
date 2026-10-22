package C0;

import H.h;
import H4.o;
import W0.j;
import a1.C0297a;
import a1.f;
import android.os.Process;
import android.util.Log;
import android.util.Pair;
import cc.dd.ee.ee.cc.a$a;
import com.stepos.taskrobot.llmapi.stepfun.TaskTimeouts;
import d1.AbstractC1374a;
import d1.i;
import e1.AbstractC1402a;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import n1.C1738a;
import s1.AbstractRunnableC1911a;
import w0.C2086g;

/* loaded from: classes2.dex */
public final class b extends AbstractRunnableC1911a {
    public final /* synthetic */ int d = 0;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar) {
        super(0L, 600000L);
        this.e = dVar;
    }

    private final void a() throws InterruptedException {
        boolean z10;
        J1.b bVarA;
        HashMap map;
        c1.c cVar;
        if (h.b) {
            o.f("APM-CPU", "run: " + ((a1.e) this.e).d);
        }
        a1.e eVar = (a1.e) this.e;
        eVar.d = (a1.c.f1629a.b() ? eVar.h.f2012a : eVar.h.b) * 1000;
        eVar.f = eVar.h.c * 1000;
        long jCurrentTimeMillis = System.currentTimeMillis();
        a1.e eVar2 = (a1.e) this.e;
        if (jCurrentTimeMillis - eVar2.e > eVar2.d) {
            eVar2.e = jCurrentTimeMillis;
            if (!eVar2.f1632j) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                long jA = M.a.a();
                long jH = M.a.H();
                HashMap map2 = new HashMap();
                HashMap map3 = new HashMap();
                if (jCurrentTimeMillis2 - eVar2.g > eVar2.f) {
                    eVar2.g = jCurrentTimeMillis2;
                    S0.b.S(map2, Process.myPid());
                    z10 = true;
                } else {
                    z10 = false;
                }
                try {
                    Thread.sleep(360L);
                } catch (InterruptedException unused) {
                }
                if (z10) {
                    S0.b.S(map3, Process.myPid());
                }
                long jA2 = M.a.a();
                double d = M.a.H() - jH > 0 ? (jA2 - jA) / r9 : -1.0d;
                double d6 = (jA2 - jA) * 1000.0d;
                double dCurrentTimeMillis = (d6 / (System.currentTimeMillis() - jCurrentTimeMillis2)) / M.a.v();
                if (h.b) {
                    o.f("APM-CPU", String.valueOf(d6) + " " + (System.currentTimeMillis() - jCurrentTimeMillis2) + " " + M.a.v());
                }
                if (h.b) {
                    o.f("APM-CPU", "collect cpu data, rate: " + d + " speed: " + dCurrentTimeMillis);
                }
                try {
                    N1.a aVar = (N1.a) eVar2.i.c;
                    K1.a aVar2 = (K1.a) aVar.b;
                    if (aVar.c) {
                        System.currentTimeMillis();
                        ((J1.a) aVar2.e).getClass();
                        ((J1.a) aVar2.e).getClass();
                    }
                } catch (Throwable unused2) {
                }
                try {
                    bVarA = eVar2.i.a();
                } catch (Throwable unused3) {
                    bVarA = null;
                }
                if (eVar2.f1631a.f1630a.get()) {
                    a1.d dVar = eVar2.f1631a;
                    map = map2;
                    if (dVar.f1630a.get()) {
                        StringBuilder sb = new StringBuilder();
                        C2086g.b().getClass();
                        double d10 = d;
                        sb.append(C2086g.c());
                        String string = sb.toString();
                        if (AbstractC1451a.f4467a) {
                            o.f("APM-CPU", string);
                        }
                        synchronized (a1.d.class) {
                            try {
                                a$a a_a = a1.c.f1629a.b() ? a$a.b : a$a.c;
                                a$a a_a2 = a_a;
                                C0297a c0297aA = a1.d.a(a_a2, dVar.d(a_a, string), d10, dCurrentTimeMillis);
                                dVar.f(a_a2, string, c0297aA);
                                if (AbstractC1451a.f4467a) {
                                    o.f("APM-CPU", "after add cache data: " + c0297aA);
                                }
                                a$a a_a3 = a$a.f2138a;
                                dVar.f(a_a3, string, a1.d.a(a_a3, dVar.d(a_a3, string), d10, dCurrentTimeMillis));
                            } finally {
                            }
                        }
                    }
                    a1.d dVar2 = eVar2.f1631a;
                    if (dVar2.f1630a.get()) {
                        synchronized (a1.d.class) {
                            dVar2.e(a$a.b, bVarA);
                            dVar2.e(a$a.c, bVarA);
                            dVar2.e(a$a.f2138a, bVarA);
                        }
                    }
                } else {
                    map = map2;
                }
                AbstractC1402a.f4331a.getClass();
                if (z10) {
                    float f = jA2 - jA;
                    if (!map.isEmpty() && !map3.isEmpty() && f > 0.0f) {
                        LinkedList linkedList = new LinkedList();
                        LinkedList linkedList2 = new LinkedList();
                        for (Map.Entry entry : map.entrySet()) {
                            c1.c cVar2 = (c1.c) entry.getValue();
                            if (cVar2 != null && (cVar = (c1.c) map3.get(entry.getKey())) != null && cVar.b.equals(cVar2.b)) {
                                double d11 = (cVar.c - cVar2.c) / f;
                                if (d11 != 0.0d) {
                                    linkedList.add(new M.c(cVar.b, Double.valueOf(String.format("%.4f", Double.valueOf(d11)))));
                                    linkedList2.add(new C1738a(Double.valueOf(String.format("%.4f", Double.valueOf(d11))).doubleValue()));
                                }
                            }
                        }
                        if (!linkedList.isEmpty()) {
                            Collections.sort(linkedList2, new M.d(9));
                            synchronized (AbstractC1402a.f4331a) {
                                new Pair(Long.valueOf(System.currentTimeMillis()), linkedList2);
                            }
                            if (eVar2.h.d) {
                                a$a a_a4 = a1.c.f1629a.b() ? a$a.b : a$a.c;
                                C2086g.b().getClass();
                                String strC = C2086g.c();
                                f fVar = new f();
                                fVar.e = -1.0d;
                                fVar.f = -1.0d;
                                fVar.g = -1.0d;
                                fVar.h = -1.0d;
                                fVar.i = true;
                                fVar.f1634j = "cpu";
                                fVar.k = new ArrayList(linkedList);
                                fVar.b = a_a4;
                                fVar.d = strC;
                                fVar.c = bVarA;
                                try {
                                    fVar.f1634j = "cpu_thread";
                                    fVar.i = ((L1.a) eVar2.i.d).a();
                                } catch (Throwable unused4) {
                                }
                                if (h.b) {
                                    Log.d("ApmInsight", U7.a.e(new String[]{"Receive:ThreadCpuData"}));
                                }
                                N0.a.a(fVar);
                            }
                        }
                    }
                }
                a1.c.f1629a.getClass();
            }
            ((a1.e) this.e).f1632j = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0697  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x07a3  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x07ce  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0817  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0822  */
    /* JADX WARN: Removed duplicated region for block: B:367:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 2104
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: C0.b.run():void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(M9.f fVar) {
        super(TaskTimeouts.TAKEOVER_IDLE_MS, TaskTimeouts.TAKEOVER_IDLE_MS);
        this.e = fVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(j jVar) {
        super(0L, 30000L);
        this.e = jVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Y0.b bVar) {
        super(0L, 14400000L);
        this.e = bVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a1.e eVar) {
        super(30000L, 30000L);
        this.e = eVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AbstractC1374a abstractC1374a, long j5, long j6) {
        super(j5, j6);
        this.e = abstractC1374a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(i iVar) {
        super(0L, 1000L);
        this.e = iVar;
    }
}
