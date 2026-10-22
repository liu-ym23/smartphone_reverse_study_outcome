package g3;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import c7.r;
import com.stepos.agentbus.platform.AgentBusApp;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import ia.b0;
import ia.d0;
import ia.w1;
import java.io.File;
import java.net.InetAddress;
import java.util.concurrent.Callable;
import m.x;
import m4.q0;
import m4.u0;
import o4.t1;
import w7.e0;

/* loaded from: classes.dex */
public final class b extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3796f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f3797g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Object obj, g7.d dVar, int i2) {
        super(2, dVar);
        this.f3796f = i2;
        this.f3797g = obj;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f3796f) {
            case 0:
                return new b((Callable) this.f3797g, dVar, 0);
            case 1:
                return new b((q0) this.f3797g, dVar, 1);
            case 2:
                return new b((t1) this.f3797g, dVar, 2);
            case 3:
                return new b((o5.e) this.f3797g, dVar, 3);
            case 4:
                return new b((w1) this.f3797g, dVar, 4);
            case 5:
                return new b((AgentBusApp) this.f3797g, dVar, 5);
            default:
                return new b((String) this.f3797g, dVar, 6);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f3796f) {
            case 0:
                return ((b) create((b0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
            case 1:
                return ((b) create((b0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
            case 2:
                return ((b) create((b0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
            case 3:
                b bVar = (b) create((k5.i) obj, (g7.d) obj2);
                r rVar = r.f1986a;
                bVar.invokeSuspend(rVar);
                return rVar;
            case 4:
                b bVar2 = (b) create((la.k) obj, (g7.d) obj2);
                r rVar2 = r.f1986a;
                bVar2.invokeSuspend(rVar2);
                return rVar2;
            case 5:
                b bVar3 = (b) create((b0) obj, (g7.d) obj2);
                r rVar3 = r.f1986a;
                bVar3.invokeSuspend(rVar3);
                return rVar3;
            default:
                return ((b) create((b0) obj, (g7.d) obj2)).invokeSuspend(r.f1986a);
        }
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        byte[] bytes;
        Object objN;
        Object objN2;
        Object objN3;
        switch (this.f3796f) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                e0.N(obj);
                return ((Callable) this.f3797g).call();
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                e0.N(obj);
                q0 q0Var = (q0) this.f3797g;
                u0 u0Var = q0Var.f6312a;
                if (((File) u0Var.f6342b).exists()) {
                    bytes = n7.l.L((File) u0Var.f6342b);
                } else {
                    bytes = "{}".getBytes(ga.a.f4005a);
                    q7.k.d(bytes, "getBytes(...)");
                }
                f5.a aVarC = q0Var.f6313b.c("application/json", bytes);
                return new a6.a(aVarC.f3436b, aVarC.f3438d, aVarC.f3437c);
            case 2:
                h7.a aVar3 = h7.a.f4212f;
                e0.N(obj);
                return ((t1) this.f3797g).f7584l.c();
            case 3:
                h7.a aVar4 = h7.a.f4212f;
                e0.N(obj);
                ((o5.e) this.f3797g).b();
                return r.f1986a;
            case 4:
                h7.a aVar5 = h7.a.f4212f;
                e0.N(obj);
                ((w1) this.f3797g).start();
                return r.f1986a;
            case 5:
                h7.a aVar6 = h7.a.f4212f;
                e0.N(obj);
                AgentBusApp agentBusApp = (AgentBusApp) this.f3797g;
                if (u5.f.f10124d == null) {
                    synchronized (u5.f.f10125e) {
                        if (u5.f.f10124d == null) {
                            u5.f.f10124d = agentBusApp.getApplicationContext();
                        }
                    }
                }
                g7.d dVar = null;
                u5.f.a(null);
                AgentBusApp agentBusApp2 = (AgentBusApp) this.f3797g;
                int i2 = AgentBusApp.f2679h;
                try {
                    AgentCacheSdk agentCacheSdk = AgentCacheSdk.INSTANCE;
                    Context applicationContext = agentBusApp2.getApplicationContext();
                    q7.k.d(applicationContext, "getApplicationContext(...)");
                    AgentCacheSdk.init$default(agentCacheSdk, applicationContext, null, null, 6, null);
                    objN = r.f1986a;
                } catch (Throwable th) {
                    objN = e0.n(th);
                }
                if (!(objN instanceof c7.l)) {
                    Log.i("AgentBusApp", "AgentCacheSdk.init ok");
                }
                Throwable thA = c7.m.a(objN);
                if (thA != null) {
                    x.v("AgentCacheSdk.init failed: ", thA.getMessage(), "AgentBusApp");
                }
                AgentBusApp agentBusApp3 = (AgentBusApp) this.f3797g;
                x5.b bVar = x5.b.f11221a;
                int i10 = 2;
                x5.b.f11224d = new b.b(agentBusApp3, dVar, i10);
                d0.s(agentBusApp3.f2680f, null, null, new b.j(i10, dVar, i10), 3);
                AgentBusApp agentBusApp4 = (AgentBusApp) this.f3797g;
                ConnectivityManager connectivityManager = (ConnectivityManager) agentBusApp4.getSystemService(ConnectivityManager.class);
                int i11 = 0;
                if (connectivityManager == null) {
                    Log.w("AgentBusApp", "ConnectivityManager unavailable, skip network callback");
                } else {
                    u5.a aVar7 = new u5.a(i11, agentBusApp4);
                    try {
                        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), aVar7);
                        objN2 = Integer.valueOf(Log.i("AgentBusApp", "registerNetworkCallback OK (INTERNET cap)"));
                    } catch (Throwable th2) {
                        objN2 = e0.n(th2);
                    }
                    Throwable thA2 = c7.m.a(objN2);
                    if (thA2 != null) {
                        Log.w("AgentBusApp", "registerNetworkCallback failed: " + thA2.getMessage(), thA2);
                    }
                    try {
                        connectivityManager.registerDefaultNetworkCallback(aVar7);
                        objN3 = Integer.valueOf(Log.i("AgentBusApp", "registerDefaultNetworkCallback OK"));
                    } catch (Throwable th3) {
                        objN3 = e0.n(th3);
                    }
                    Throwable thA3 = c7.m.a(objN3);
                    if (thA3 != null) {
                        Log.w("AgentBusApp", "registerDefaultNetworkCallback failed: " + thA3.getMessage(), thA3);
                    }
                }
                AgentBusApp agentBusApp5 = (AgentBusApp) this.f3797g;
                if (j6.a.f5399a.compareAndSet(false, true)) {
                    Process.myPid();
                }
                if ("StepX".equalsIgnoreCase(Build.BRAND)) {
                    ContentResolver contentResolver = agentBusApp5.getContentResolver();
                    boolean z4 = Settings.Secure.getInt(contentResolver, "user_setup_complete", 0) == 1;
                    j6.a.b("5.0.7", "register start, appId: 154941, " + z4);
                    if (z4) {
                        agentBusApp5.getSharedPreferences("com.stepos.push", 0).edit().putString("app_id", "154941").apply();
                        g6.c cVar = (g6.c) f6.a.f3454a.f192f;
                        cVar.f3853c = "154941";
                        cVar.f3854d = "ca4a93c75257460694410f63a178a9e0";
                        cVar.c(agentBusApp5);
                    } else {
                        contentResolver.registerContentObserver(Settings.Secure.getUriFor("user_setup_complete"), false, new e6.a(agentBusApp5));
                    }
                } else {
                    Log.w("[Cloud]Push.SDK", j6.a.d("5.0.7", "please invoke register on device Build-in StepOS"));
                }
                return r.f1986a;
            default:
                h7.a aVar8 = h7.a.f4212f;
                e0.N(obj);
                return InetAddress.getAllByName((String) this.f3797g);
        }
    }
}
