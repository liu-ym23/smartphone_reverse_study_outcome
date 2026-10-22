package h2;

import D9.n;
import H4.o;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Menu;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.apm.insight.Npth;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import j4.C1597b;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;
import q2.C1797b;
import s1.AbstractRunnableC1911a;
import stepos.support.v7.app.AbstractC1975y;
import stepos.support.v7.app.C1970t;
import stepos.support.v7.app.a0;
import stepos.support.v7.app.b0;
import x.i;
import x.j;
import y0.C2125a;
import y0.C2126b;
import z0.C2153a;
import z2.k;
import z2.l;
import z2.q;
import z2.r;

/* renamed from: h2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1484b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4553a;
    public Object b;

    public /* synthetic */ RunnableC1484b() {
        this.f4553a = 2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        String str;
        Boolean boolValueOf;
        F1.b bVar;
        int iIntValue;
        String string;
        n nVarC;
        int i = 1;
        int i6 = 0;
        switch (this.f4553a) {
            case 0:
                B0.f fVar = (B0.f) this.b;
                if (fVar.b) {
                    return;
                }
                C1483a c1483a = (C1483a) fVar.f177a;
                synchronized (c1483a.f4548t) {
                }
                c1483a.f4551x.run();
                B0.f.d = SystemClock.uptimeMillis();
                o.h();
                l.i().b((RunnableC1484b) ((B0.f) this.b).c, 500L);
                long j5 = B0.f.d;
                if (j5 - l.k < 30000) {
                    return;
                }
                l.k = j5;
                try {
                    M.a.t(String.valueOf(System.currentTimeMillis()), l.h(), false);
                    return;
                } catch (IOException unused) {
                    return;
                }
            case 1:
                S0.b.N("Recheck uncaught exception handler.");
                if (((C1797b) this.b).f5574j < 3) {
                    ((C1797b) this.b).f5574j++;
                    ((C1797b) this.b).f();
                    l.i().b(((C1797b) this.b).k, 30000L);
                    return;
                }
                return;
            case 2:
                try {
                    ((AbstractRunnableC1911a) this.b).run();
                    return;
                } catch (Throwable th) {
                    o.g("APM-AsyncTask", "thread " + Thread.currentThread().getName() + " exception", th);
                    return;
                }
            case 3:
                AbstractC1975y abstractC1975y = (AbstractC1975y) this.b;
                abstractC1975y.f6366v.showAtLocation(abstractC1975y.u, 55, 0, 0);
                abstractC1975y.t();
                ViewCompat.setAlpha(abstractC1975y.u, 0.0f);
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompatAlpha = ViewCompat.animate(abstractC1975y.u).alpha(1.0f);
                abstractC1975y.f6368x = viewPropertyAnimatorCompatAlpha;
                viewPropertyAnimatorCompatAlpha.setListener(new C1970t(this, i6));
                return;
            case 4:
                b0 b0Var = (b0) this.b;
                a0 a0Var = b0Var.c;
                Menu menuV = b0Var.v();
                Va.n nVar = menuV instanceof Va.n ? (Va.n) menuV : null;
                if (nVar != null) {
                    nVar.v();
                }
                try {
                    menuV.clear();
                    if (!a0Var.f6290a.onCreatePanelMenu(0, menuV) || !a0Var.onPreparePanel(0, null, menuV)) {
                        menuV.clear();
                    }
                    if (nVar != null) {
                        nVar.u();
                        return;
                    }
                    return;
                } finally {
                }
            case 5:
                try {
                    if (J2.c.f865a.e) {
                        LinkedList linkedList = new LinkedList();
                        synchronized (((LinkedList) ((A0.f) this.b).b)) {
                            linkedList.addAll((LinkedList) ((A0.f) this.b).b);
                            ((LinkedList) ((A0.f) this.b).b).clear();
                        }
                        while (!linkedList.isEmpty()) {
                            t1.b bVar2 = (t1.b) linkedList.poll();
                            if (bVar2 != null) {
                                t1.a.a().b(bVar2.f6653a, null, false);
                            }
                        }
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            case 6:
                try {
                    LinkedList linkedList2 = new LinkedList();
                    synchronized (t1.a.i) {
                        linkedList2.addAll(((t1.a) this.b).f);
                        ((t1.a) this.b).f.clear();
                        ((t1.a) this.b).b = 0;
                    }
                    if (linkedList2.isEmpty()) {
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    while (!linkedList2.isEmpty()) {
                        t1.b bVar3 = (t1.b) linkedList2.poll();
                        if (bVar3 != null) {
                            jSONArray.put(new JSONObject(bVar3.f6653a));
                        }
                    }
                    jSONObject.put(SettingsConfig.KEY_DATA, jSONArray);
                    if (((t1.a) this.b).e == null) {
                        ((t1.a) this.b).e = H.h.d();
                    }
                    jSONObject.put("header", ((t1.a) this.b).e);
                    t1.a aVar = (t1.a) this.b;
                    String str2 = t1.a.h;
                    String string2 = jSONObject.toString();
                    try {
                        if (J2.c.f865a.e) {
                            S0.b.P(S0.b.p(str2, H.h.e()), string2.getBytes());
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        int i10 = th3 instanceof cc.dd.ff.cc.cc.cc.e ? th3.f2143a : -1;
                        if (i10 < 500 || i10 > 600) {
                            return;
                        }
                        aVar.d = System.currentTimeMillis();
                        aVar.c = true;
                        return;
                    }
                } catch (Throwable th4) {
                    th4.printStackTrace();
                    return;
                }
            case 7:
                C1597b c1597b = (C1597b) this.b;
                for (int i11 = 0; i11 < c1597b.f4773a.size(); i11++) {
                    try {
                        String[] strArr = {"openudid", "clientudid", "serial_number", "sim_serial_number", "udid", "device_id"};
                        for (int i12 = 0; i12 < 6; i12++) {
                            String str3 = strArr[i12];
                            try {
                                String str4 = (String) c1597b.f4773a.get(i11);
                                c1597b.getClass();
                                if (!TextUtils.isEmpty(str4)) {
                                    StringBuilder sbF = M.a.f(str4);
                                    sbF.append(File.separator);
                                    sbF.append(str3);
                                    sbF.append(".dat");
                                    File file = new File(sbF.toString());
                                    if (file.exists()) {
                                        file.delete();
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (Exception unused2) {
                        return;
                    }
                }
                return;
            case 8:
                w2.l lVar = (w2.l) this.b;
                if (Npth.isStopUpload()) {
                    return;
                }
                if (!w2.l.e.isEmpty() && k.f6933a) {
                    w2.l.e();
                }
                lVar.d();
                lVar.f6839a.b(lVar.c, 30000L);
                return;
            case 9:
                try {
                    ((RunnableC1484b) this.b).run();
                    return;
                } catch (Exception e6) {
                    e6.printStackTrace();
                    return;
                }
            case 10:
                i iVar = (i) this.b;
                d dVar = iVar.d;
                ReentrantLock reentrantLock = iVar.f6864a;
                try {
                    reentrantLock.lock();
                    F1.b bVarL = dVar.l();
                    Objects.toString(bVarL);
                    if (bVarL != null) {
                        String str5 = i.i;
                        iVar.g = bVarL.a();
                    }
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    Context context = iVar.e;
                    j jVar = iVar.b;
                    if (jVar == null || (nVarC = jVar.c(context)) == null) {
                        str = null;
                        boolValueOf = null;
                    } else {
                        str = nVarC.f443a;
                        boolValueOf = Boolean.valueOf(nVarC.b);
                        if (nVarC instanceof x.g) {
                            iVar.h = Long.valueOf(((x.g) nVarC).c);
                        }
                    }
                    Pair pair = new Pair(str, boolValueOf);
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                    if (pair.first != null) {
                        if (bVarL != null) {
                            string = (String) bVarL.b;
                            iIntValue = ((Integer) bVarL.f).intValue() + 1;
                        } else {
                            iIntValue = -1;
                            string = null;
                        }
                        if (TextUtils.isEmpty(string)) {
                            string = UUID.randomUUID().toString();
                        }
                        if (iIntValue > 0) {
                            i = iIntValue;
                        }
                        bVar = new F1.b((String) pair.first, string, (Boolean) pair.second, Long.valueOf(jElapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i), iVar.h);
                        ((SharedPreferences) dVar.f4555a).edit().putString("oaid", bVar.c().toString()).apply();
                    } else {
                        bVar = null;
                    }
                    if (bVar != null) {
                        String str6 = i.i;
                        iVar.g = bVar.a();
                    }
                    Objects.toString(bVar);
                    reentrantLock.unlock();
                    Object[] objArrC = i.c();
                    if (objArrC == null || objArrC.length <= 0) {
                        return;
                    }
                    com.stepos.statsrpk.service.c.m(objArrC[0]);
                    throw null;
                } catch (Throwable th5) {
                    reentrantLock.unlock();
                    Object[] objArrC2 = i.c();
                    if (objArrC2 == null || objArrC2.length <= 0) {
                        throw th5;
                    }
                    com.stepos.statsrpk.service.c.m(objArrC2[0]);
                    throw null;
                }
            case 11:
                C2126b c2126b = C2126b.g;
                Looper.myQueue().addIdleHandler(new C2125a((C2153a) this.b));
                return;
        }
        while (!((r) this.b).c.isEmpty()) {
            if (((r) this.b).d != null) {
                try {
                    ((r) this.b).d.sendMessageAtFrontOfQueue((Message) ((r) this.b).c.poll());
                } catch (Throwable unused3) {
                }
            }
        }
        while (!((r) this.b).b.isEmpty()) {
            q qVar = (q) ((r) this.b).b.poll();
            if (((r) this.b).d != null) {
                try {
                    ((r) this.b).d.sendMessageAtTime(qVar.f6939a, qVar.b);
                } catch (Throwable unused4) {
                }
            }
        }
    }

    public /* synthetic */ RunnableC1484b(Object obj, int i) {
        this.f4553a = i;
        this.b = obj;
    }

    public RunnableC1484b(C2153a c2153a) {
        this.f4553a = 11;
        C2126b c2126b = C2126b.g;
        this.b = c2153a;
    }
}
