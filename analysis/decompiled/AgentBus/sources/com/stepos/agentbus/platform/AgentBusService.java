package com.stepos.agentbus.platform;

import a1.a;
import a4.p;
import android.accounts.AccountManager;
import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.IBinder;
import android.os.Process;
import android.os.UserManager;
import android.provider.Settings;
import android.util.Log;
import com.stepos.agentbus.config.AgentBusConfig;
import d5.e;
import d5.l;
import d7.n;
import h5.g;
import ia.d0;
import ia.f1;
import ia.g1;
import ia.n0;
import ia.n1;
import ia.o1;
import ia.s;
import ia.v;
import ia.w1;
import java.io.BufferedWriter;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import k5.t;
import ka.y;
import kotlin.Metadata;
import la.f0;
import la.k0;
import la.u0;
import m5.j;
import s1.u;
import u4.c;
import u4.h;
import u5.d;
import u5.f;
import u5.r;
import v4.k;
import w7.e0;
import x4.i;
import y4.m;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/stepos/agentbus/platform/AgentBusService;", "Landroid/app/Service;", "<init>", "()V", "u5/d", "n7/m", "app_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AgentBusService extends Service {

    /* renamed from: m, reason: collision with root package name */
    public static volatile u f2682m;

    /* renamed from: f, reason: collision with root package name */
    public final d f2683f = new d(this);

    /* renamed from: g, reason: collision with root package name */
    public final na.d f2684g = d0.b(d0.c());

    /* renamed from: h, reason: collision with root package name */
    public k f2685h;

    /* renamed from: i, reason: collision with root package name */
    public final u0 f2686i;

    /* renamed from: j, reason: collision with root package name */
    public final u0 f2687j;

    /* renamed from: k, reason: collision with root package name */
    public final AtomicBoolean f2688k;

    /* renamed from: l, reason: collision with root package name */
    public long f2689l;

    public AgentBusService() {
        u0 u0VarC = k0.c(Boolean.FALSE);
        this.f2686i = u0VarC;
        this.f2687j = u0VarC;
        this.f2688k = new AtomicBoolean(false);
    }

    public final void a(PrintWriter printWriter) {
        k kVar = this.f2685h;
        if (kVar == null) {
            printWriter.println("Container: not initialized");
            return;
        }
        printWriter.println("Container: ready");
        List<e> list = (List) kVar.f10441k.f2891e.f5918f.getValue();
        printWriter.println("  connections: " + list.size());
        for (e eVar : list) {
            printWriter.println("    [" + eVar.f() + "] " + eVar.e() + " state=" + eVar.h().getValue());
        }
        printWriter.println("  inflight invocations: " + kVar.f10445m.f4206f.size());
        Iterator it = ((Map) ((f0) kVar.f10443l.f166j).f5918f.getValue()).values().iterator();
        boolean z4 = false;
        int size = 0;
        while (it.hasNext()) {
            size += ((Set) it.next()).size();
        }
        printWriter.println("  capabilities: " + size);
        s sVar = kVar.f10428d0.f10502p;
        if (sVar.V()) {
            Object obj = o1.f4991f.get(sVar);
            if (!(obj instanceof v) && (!(obj instanceof n1) || !((n1) obj).e())) {
                z4 = true;
            }
        }
        printWriter.println("  ls server ready: " + z4);
    }

    @Override // android.app.Service
    public final void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        if (printWriter == null) {
            return;
        }
        String str = strArr != null ? (String) n.h0(strArr) : null;
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -892481550) {
                if (iHashCode != 3732) {
                    if (iHashCode != 100589) {
                        if (iHashCode == 93622832 && str.equals("bench")) {
                            k kVar = this.f2685h;
                            h hVar = kVar != null ? kVar.J : null;
                            if (hVar == null) {
                                printWriter.println("benchmark: container not ready");
                                return;
                            }
                            String str2 = strArr != null ? (String) n.k0(1, strArr) : null;
                            if (str2 != null) {
                                int iHashCode2 = str2.hashCode();
                                if (iHashCode2 != -892481550) {
                                    if (iHashCode2 != 3551) {
                                        if (iHashCode2 == 109935 && str2.equals("off")) {
                                            if (hVar.f10077i) {
                                                hVar.f10077i = false;
                                                hVar.f10073e.u(c.f10057a);
                                            }
                                            printWriter.println("benchmark: DISABLED (flushed & closed)");
                                            return;
                                        }
                                    } else if (str2.equals("on")) {
                                        if (!hVar.f10077i) {
                                            hVar.f10077i = true;
                                        }
                                        printWriter.println("benchmark: ENABLED → /sdcard/Documents/clawbench/<sessionKey>/agentbus.txt");
                                        return;
                                    }
                                } else if (str2.equals("status")) {
                                    printWriter.println("BenchmarkRecorder(enabled=" + hVar.f10077i + ", openWriters=" + hVar.f10075g.get() + ", writtenLines=" + hVar.f10078j.get() + ")");
                                    return;
                                }
                            }
                            printWriter.println("usage: bench on|off|status");
                            return;
                        }
                    } else if (str.equals("env")) {
                        printWriter.println("Environment: ".concat(f.a(null)));
                        printWriter.println("  isTestEnv: " + f.a(null).equals("test"));
                        k kVar2 = this.f2685h;
                        if (kVar2 != null) {
                            AgentBusConfig agentBusConfig = kVar2.f10423b;
                            printWriter.println("  gateway vendor: " + agentBusConfig.getGateway().getVendor());
                            printWriter.println("  cloud bridge enabled: " + agentBusConfig.getGateway().getCloudBridge().getEnabled());
                            if (agentBusConfig.getGateway().getCloudBridge().getEnabled()) {
                                printWriter.println("  cloud endpoint: " + agentBusConfig.getGateway().getCloudBridge().getOpenclaw().getEndpoint());
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } else if (str.equals("ui")) {
                    Intent intentAddFlags = new Intent(this, (Class<?>) StartupActivity.class).addFlags(268435456);
                    q7.k.d(intentAddFlags, "addFlags(...)");
                    startActivity(intentAddFlags);
                    printWriter.println("StartupActivity launched");
                    return;
                }
            } else if (str.equals("status")) {
                a(printWriter);
                return;
            }
        }
        long jCurrentTimeMillis = this.f2689l > 0 ? (System.currentTimeMillis() - this.f2689l) / 1000 : 0L;
        printWriter.println("=== AgentBusService ===");
        printWriter.println("  pid=" + Process.myPid() + " uid=" + Process.myUid());
        printWriter.println("  uptime=" + jCurrentTimeMillis + "s containerReady=" + this.f2686i.getValue());
        printWriter.println();
        printWriter.println("Commands:");
        printWriter.println("  ui       — launch debug UI (StartupActivity)");
        printWriter.println("  status   — connection pool / inflight / offline queue");
        printWriter.println("  env      — current environment and endpoints");
        printWriter.println("  bench on|off|status — benchmark frame recorder (writes /sdcard/Documents/clawbench)");
        printWriter.println();
        a(printWriter);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.f2683f;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.f2689l = System.currentTimeMillis();
        Log.i("AgentBusService", "onCreate uid=" + Process.myUid() + " pid=" + Process.myPid());
    }

    @Override // android.app.Service
    public final void onDestroy() throws Throwable {
        Log.i("AgentBusService", "onDestroy uid=" + Process.myUid());
        k kVar = this.f2685h;
        g7.d dVar = null;
        if (kVar != null) {
            g gVar = kVar.f10445m;
            w1 w1Var = gVar.f4210j;
            if (w1Var != null) {
                f1.cancel$default((g1) w1Var, (CancellationException) null, 1, (Object) null);
            }
            d0.e(gVar.f4209i, null);
            v5.c cVar = kVar.Y;
            if (cVar.f10518h.compareAndSet(true, false)) {
                try {
                    AccountManager.get(cVar.f10515e).removeOnAccountsUpdatedListener(cVar.f10521k);
                    k5.s.info$default(cVar.f10511a, "MzAccountToken", "Account listener unregistered", null, 4, null);
                } catch (Exception e10) {
                    k5.s.warn$default(cVar.f10511a, "MzAccountToken", a.w("Failed to unregister account listener: ", e10.getMessage()), null, 4, null);
                }
            }
            u5.h hVar = kVar.f10446m0;
            u5.a aVar = (u5.a) hVar.f10131c;
            if (aVar != null) {
                hVar.f10131c = null;
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) hVar.f10130b;
                    if (connectivityManager != null) {
                        connectivityManager.unregisterNetworkCallback(aVar);
                    }
                } catch (Throwable th) {
                    Log.w("NetworkRecoveryMonitor", "unregisterNetworkCallback failed: " + th.getMessage(), th);
                }
            }
            kVar.f10448n0.T();
            y4.a aVar2 = kVar.f10430e0;
            if (aVar2 != null) {
                aVar2.a();
            }
            m mVar = kVar.f10434g0;
            if (mVar != null) {
                mVar.f();
            }
            i iVar = kVar.f10458x;
            if (iVar != null) {
                iVar.j();
            }
            a5.h hVar2 = kVar.Z;
            hVar2.getClass();
            nb.i.f6978a = null;
            l lVar = hVar2.f240a;
            hVar2.f250k.getClass();
            lVar.h("push-virtual");
            k5.s.info$default(hVar2.f245f, "PushBridge", "stopped", null, 4, null);
            i5.f fVar = kVar.f10422a0;
            fVar.getClass();
            nb.i.f6979b = null;
            k5.s.info$default((t) fVar.f4656j, "BffPushBridge", "stopped", null, 4, null);
            i5.l lVar2 = kVar.f10424b0;
            lVar2.getClass();
            nb.i.f6980c = null;
            k5.s.info$default((t) lVar2.f4688h, "CloudWakePushBridge", "stopped", null, 4, null);
            f5.e eVar = kVar.f10452r.f3451g;
            if (eVar.isAlive()) {
                eVar.stop();
            }
            d0.s(kVar.X, null, null, new v4.i(kVar, dVar, 2), 3);
            d0.e(kVar.N.f8770x, null);
            i5.f fVar2 = kVar.f10453s;
            h4.a aVar3 = (h4.a) fVar2.f4655i;
            w1 w1Var2 = (w1) aVar3.f4106h;
            if (w1Var2 != null) {
                f1.cancel$default((g1) w1Var2, (CancellationException) null, 1, (Object) null);
            }
            d0.e((na.d) aVar3.f4105g, null);
            j jVar = (j) fVar2.f4653g;
            jVar.getClass();
            try {
                BufferedWriter bufferedWriter = jVar.f6419h;
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                }
                BufferedWriter bufferedWriter2 = jVar.f6419h;
                if (bufferedWriter2 != null) {
                    bufferedWriter2.close();
                }
            } catch (Throwable th2) {
                e0.n(th2);
            }
            d0.e(jVar.f6416e, null);
            y.close$default(jVar.f6417f, null, 1, null);
            m5.h hVar3 = (m5.h) fVar2.f4654h;
            hVar3.getClass();
            try {
                BufferedWriter bufferedWriter3 = hVar3.f6406g;
                if (bufferedWriter3 != null) {
                    bufferedWriter3.flush();
                }
                BufferedWriter bufferedWriter4 = hVar3.f6406g;
                if (bufferedWriter4 != null) {
                    bufferedWriter4.close();
                }
            } catch (Throwable th3) {
                e0.n(th3);
            }
            d0.e(hVar3.f6404e, null);
            y.close$default(hVar3.f6405f, null, 1, null);
            h hVar4 = kVar.J;
            hVar4.f10077i = false;
            hVar4.f10073e.u(c.f10057a);
            y.close$default(hVar4.f10073e, null, 1, null);
            hVar4.f10080l.t(new a5.a(20, hVar4));
            d0.e(kVar.S.f8466m, null);
            d0.e(kVar.T.f8466m, null);
            d0.e(kVar.R.f7750i, null);
            m4.u0 u0Var = kVar.U;
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) u0Var.f6345e;
            w1 w1Var3 = (w1) u0Var.f6344d;
            if (w1Var3 != null) {
                f1.cancel$default((g1) w1Var3, (CancellationException) null, 1, (Object) null);
            }
            u0Var.f6344d = null;
            Collection collectionValues = concurrentHashMap.values();
            q7.k.d(collectionValues, "<get-values>(...)");
            Iterator it = collectionValues.iterator();
            while (it.hasNext()) {
                f1.cancel$default((g1) it.next(), (CancellationException) null, 1, (Object) null);
            }
            concurrentHashMap.clear();
            d0.e((na.d) u0Var.f6343c, null);
            kVar.V.stop();
            d0.e((na.d) kVar.f10454t.f411g, null);
            if (kVar.f10423b.getRestApi().getEnabled()) {
                u5.s sVar = kVar.W;
                ConcurrentHashMap concurrentHashMap2 = sVar.f10176h;
                u5.m mVar2 = sVar.f10173e;
                if (mVar2.isAlive()) {
                    mVar2.stop();
                }
                Collection collectionValues2 = concurrentHashMap2.values();
                q7.k.d(collectionValues2, "<get-values>(...)");
                Iterator it2 = collectionValues2.iterator();
                while (it2.hasNext()) {
                    d0.w(g7.m.f3866f, new r((u5.t) it2.next(), dVar, 0));
                }
                concurrentHashMap2.clear();
                d0.e(sVar.f10177i, null);
            }
            p pVar = kVar.B;
            w1 w1Var4 = (w1) pVar.f197k;
            if (w1Var4 != null) {
                f1.cancel$default((g1) w1Var4, (CancellationException) null, 1, (Object) null);
            }
            d0.e((na.d) pVar.f196j, null);
            d0.s(kVar.X, null, null, new v4.i(kVar, dVar, 3), 3);
            v4.p pVar2 = kVar.f10428d0;
            d0.s(pVar2.f10495i, null, null, new a6.r(pVar2, dVar, 14), 3);
            kVar.E = null;
            d0.e(kVar.C, null);
            d0.e(kVar.X, null);
            try {
                kVar.f10450p.c();
            } catch (Throwable th4) {
                e0.n(th4);
            }
        }
        this.f2685h = null;
        d0.e(this.f2684g, null);
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i10) {
        UserManager userManager = (UserManager) getSystemService(UserManager.class);
        if (userManager == null || !userManager.isUserUnlocked()) {
            Log.w("AgentBusService", "onStartCommand before user unlock — skipping container init");
            return 1;
        }
        if (Settings.Secure.getInt(getContentResolver(), "user_setup_complete", 0) != 1) {
            Log.w("AgentBusService", "onStartCommand before user setup complete — skipping container init");
            return 1;
        }
        if (this.f2685h == null && this.f2688k.compareAndSet(false, true)) {
            u uVar = f2682m;
            if (uVar == null) {
                Log.w("AgentBusService", "containerFactoryOverride not set — skipping container init (waiting for AgentBusApp)");
                this.f2688k.set(false);
                return 1;
            }
            Log.i("AgentBusService", "container init dispatched to IO");
            na.d dVar = this.f2684g;
            pa.e eVar = n0.f4982a;
            d0.s(dVar, pa.d.f8556h, null, new g3.c(uVar, this, null, 5), 2);
        }
        return 1;
    }
}
