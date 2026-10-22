package v4;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.lifecycle.s0;
import com.stepos.agentbus.config.AgentBusConfig;
import com.stepos.agentbus.config.CloudBridgeConfig;
import com.stepos.agentbus.config.ConfigManager;
import com.stepos.agentbus.config.EnvProvider;
import com.stepos.agentbus.config.InMemoryConfigProvider;
import com.stepos.agentbus.config.PushConfigKt;
import com.stepos.agentbus.domain.queue.OfflineQueueDatabase;
import d7.a0;
import d7.e0;
import i5.u;
import ia.f1;
import ia.w1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import la.k0;
import la.u0;
import m.x;
import m4.q0;
import o4.t1;
import q5.d0;
import q5.t;
import u5.s;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: o0, reason: collision with root package name */
    public static final Set f10420o0 = d7.n.x0(new String[]{"stepclaw.status.change", "stepclaw.bypass.engaged", "stepclaw.bypass.recovered", "stepclaw.config.update", "stepclaw.metrics.snapshot", "stepclaw.skills.changed", "stepclaw.tools.changed", "stepclaw.config.model.changed", "stepclaw.files.changed", "stepclaw.cronjobs.changed", "stepclaw.channels.changed", "stepclaw.gateway.changed"});
    public final h4.n A;
    public final a4.p B;
    public final na.d C;
    public final s5.e D;
    public i5.l E;
    public final t F;
    public final z5.c G;
    public final b6.a H;
    public final u4.l I;
    public final u4.h J;
    public final p5.q K;
    public final i5.f L;
    public final i5.f M;
    public final q5.q N;
    public final u0 O;
    public final u0 P;
    public w1 Q;
    public final o5.e R;
    public final p5.h S;
    public final p5.h T;
    public final m4.u0 U;
    public final ConfigManager V;
    public final s W;
    public final na.d X;
    public final v5.c Y;
    public final a5.h Z;

    /* renamed from: a, reason: collision with root package name */
    public final Context f10421a;

    /* renamed from: a0, reason: collision with root package name */
    public final i5.f f10422a0;

    /* renamed from: b, reason: collision with root package name */
    public final AgentBusConfig f10423b;

    /* renamed from: b0, reason: collision with root package name */
    public final i5.l f10424b0;

    /* renamed from: c, reason: collision with root package name */
    public final List f10425c;

    /* renamed from: c0, reason: collision with root package name */
    public final q6.b f10426c0;

    /* renamed from: d, reason: collision with root package name */
    public final EnvProvider f10427d;

    /* renamed from: d0, reason: collision with root package name */
    public final p f10428d0;

    /* renamed from: e, reason: collision with root package name */
    public final k5.g f10429e;

    /* renamed from: e0, reason: collision with root package name */
    public y4.a f10430e0;

    /* renamed from: f, reason: collision with root package name */
    public final k5.a f10431f;

    /* renamed from: f0, reason: collision with root package name */
    public volatile t1 f10432f0;

    /* renamed from: g, reason: collision with root package name */
    public final a7.d f10433g;

    /* renamed from: g0, reason: collision with root package name */
    public y4.m f10434g0;

    /* renamed from: h, reason: collision with root package name */
    public final c5.d f10435h;

    /* renamed from: h0, reason: collision with root package name */
    public final nb.f f10436h0;

    /* renamed from: i, reason: collision with root package name */
    public final s9.d f10437i;

    /* renamed from: i0, reason: collision with root package name */
    public w1 f10438i0;

    /* renamed from: j, reason: collision with root package name */
    public final InMemoryConfigProvider f10439j;

    /* renamed from: j0, reason: collision with root package name */
    public y4.h f10440j0;

    /* renamed from: k, reason: collision with root package name */
    public final d5.l f10441k;

    /* renamed from: k0, reason: collision with root package name */
    public volatile CloudBridgeConfig f10442k0;

    /* renamed from: l, reason: collision with root package name */
    public final a3.b f10443l;

    /* renamed from: l0, reason: collision with root package name */
    public final u5.h f10444l0;

    /* renamed from: m, reason: collision with root package name */
    public final h5.g f10445m;

    /* renamed from: m0, reason: collision with root package name */
    public final u5.h f10446m0;

    /* renamed from: n, reason: collision with root package name */
    public final h5.b f10447n;

    /* renamed from: n0, reason: collision with root package name */
    public final i5.f f10448n0;

    /* renamed from: o, reason: collision with root package name */
    public final a7.d f10449o;

    /* renamed from: p, reason: collision with root package name */
    public final OfflineQueueDatabase f10450p;

    /* renamed from: q, reason: collision with root package name */
    public final u f10451q;

    /* renamed from: r, reason: collision with root package name */
    public final f5.f f10452r;

    /* renamed from: s, reason: collision with root package name */
    public final i5.f f10453s;

    /* renamed from: t, reason: collision with root package name */
    public final a7.d f10454t;

    /* renamed from: u, reason: collision with root package name */
    public final u5.h f10455u;

    /* renamed from: v, reason: collision with root package name */
    public final t f10456v;

    /* renamed from: w, reason: collision with root package name */
    public final q6.b f10457w;

    /* renamed from: x, reason: collision with root package name */
    public x4.i f10458x;

    /* renamed from: y, reason: collision with root package name */
    public final q6.b f10459y;

    /* renamed from: z, reason: collision with root package name */
    public final q5.c f10460z;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r48v1 */
    /* JADX WARN: Type inference failed for: r48v2 */
    /* JADX WARN: Type inference failed for: r48v3 */
    public k(Context context, AgentBusConfig agentBusConfig) throws IOException, ClassNotFoundException {
        Object next;
        ?? r48;
        Set setS;
        a6.o q0Var;
        b6.a dVar;
        boolean zContainsKey;
        int i2;
        int i10;
        ArrayList arrayListJ;
        ArrayList arrayListJ2;
        List<PackageInfo> list;
        ArrayList arrayList;
        boolean zEquals;
        ApplicationInfo applicationInfo;
        List listU0 = d7.s.u0(new d0("agent.delegate", null, 100), new d0("skills.*", null, 90), new d0("memory.*", "stepclaw", 90));
        q7.k.e(context, "context");
        this.f10421a = context;
        this.f10423b = agentBusConfig;
        this.f10425c = listU0;
        this.f10427d = u5.f.f10121a;
        k5.g gVar = new k5.g();
        this.f10429e = gVar;
        k5.a aVar = new k5.a();
        this.f10431f = aVar;
        a7.d dVar2 = new a7.d(15);
        this.f10433g = dVar2;
        this.f10435h = new c5.d();
        this.f10437i = new s9.d(12);
        this.f10439j = new InMemoryConfigProvider(agentBusConfig);
        this.f10441k = new d5.l();
        this.f10443l = new a3.b(dVar2);
        agentBusConfig.getInvocationMapper().getTtlMs();
        this.f10445m = new h5.g(agentBusConfig.getInvocationMapper().getMaxEntries(), agentBusConfig.getTimeouts().getInvokeTimeoutMs(), agentBusConfig.getTimeouts().getWatchdogTickMs(), aVar, gVar, dVar2);
        this.f10447n = new h5.b(agentBusConfig.getDedup().getWindowTtlMs(), agentBusConfig.getDedup().getMaxEntries());
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        List<PackageInfo> installedPackages = Build.VERSION.SDK_INT >= 33 ? packageManager.getInstalledPackages(PackageManager.PackageInfoFlags.of(134217728)) : packageManager.getInstalledPackages(134217728);
        q7.k.b(installedPackages);
        Iterator it = installedPackages.iterator();
        while (true) {
            if (it.hasNext()) {
                next = it.next();
                if (q7.k.a(((PackageInfo) next).packageName, packageName)) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        PackageInfo packageInfo = (PackageInfo) next;
        if (packageInfo == null || (arrayListJ = nb.i.J(packageInfo)) == null) {
            r48 = 0;
            Log.w("SignatureTrust", "cannot read own signatures, falling back to myUid only");
            setS = ib.k.S(Integer.valueOf(Process.myUid()));
        } else {
            Integer[] numArr = {Integer.valueOf(Process.myUid())};
            r48 = 0;
            LinkedHashSet linkedHashSet = new LinkedHashSet(e0.S(1));
            d7.n.v0(numArr, linkedHashSet);
            ArrayList arrayList2 = new ArrayList();
            for (PackageInfo packageInfo2 : installedPackages) {
                long j2 = jElapsedRealtime;
                if (q7.k.a(packageInfo2.packageName, packageName) || (arrayListJ2 = nb.i.J(packageInfo2)) == null) {
                    jElapsedRealtime = j2;
                } else {
                    String str = packageName;
                    if (arrayListJ.size() != arrayListJ2.size()) {
                        zEquals = false;
                        list = installedPackages;
                        arrayList = arrayListJ;
                    } else {
                        list = installedPackages;
                        ArrayList arrayList3 = new ArrayList(d7.t.A0(arrayListJ, 10));
                        Iterator it2 = arrayListJ.iterator();
                        while (it2.hasNext()) {
                            arrayList3.add(d7.n.n0((byte[]) it2.next(), "", new s1.u(8), 30));
                            it2 = it2;
                            arrayListJ = arrayListJ;
                        }
                        arrayList = arrayListJ;
                        Set setQ1 = d7.r.q1(arrayList3);
                        ArrayList arrayList4 = new ArrayList(d7.t.A0(arrayListJ2, 10));
                        for (Iterator it3 = arrayListJ2.iterator(); it3.hasNext(); it3 = it3) {
                            arrayList4.add(d7.n.n0((byte[]) it3.next(), "", new s1.u(8), 30));
                        }
                        zEquals = setQ1.equals(d7.r.q1(arrayList4));
                    }
                    if (zEquals && (applicationInfo = packageInfo2.applicationInfo) != null) {
                        int i11 = applicationInfo.uid;
                        linkedHashSet.add(Integer.valueOf(i11));
                        arrayList2.add(packageInfo2.packageName + "#" + i11);
                    }
                    packageName = str;
                    jElapsedRealtime = j2;
                    installedPackages = list;
                    arrayListJ = arrayList;
                }
            }
            Log.i("SignatureTrust", "discovered " + linkedHashSet.size() + " trusted uids in " + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms (scanned " + installedPackages.size() + " packages); matches=" + d7.r.U0(arrayList2, ",", null, null, null, 62));
            setS = linkedHashSet;
        }
        this.f10449o = new a7.d(14, setS);
        this.f10423b.getRateLimit().getThirdparty().getReqPerSec();
        this.f10423b.getRateLimit().getThirdparty().getBurstSize();
        new ConcurrentHashMap();
        Context context2 = this.f10421a;
        q7.k.e(context2, "context");
        if (ga.k.t0("agentbus_offline_queue.db")) {
            throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        }
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        s0 s0Var = new s0(1);
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        i5.n[] nVarArr = {i5.o.f4694a};
        HashSet hashSet = new HashSet();
        nVarArr[r48].getClass();
        hashSet.add(1);
        hashSet.add(2);
        s0Var.a((i5.n[]) Arrays.copyOf(nVarArr, 1));
        Iterator it4 = hashSet.iterator();
        while (it4.hasNext()) {
            int iIntValue = ((Number) it4.next()).intValue();
            if (linkedHashSet2.contains(Integer.valueOf(iIntValue))) {
                throw new IllegalArgumentException(n.f.c(iIntValue, "Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: ").toString());
            }
        }
        h4.n nVar = new h4.n(11, false);
        Object systemService = context2.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        g3.e eVar = new g3.e(context2, nVar, s0Var, arrayList5, (activityManager == null || activityManager.isLowRamDevice()) ? 2 : 3, linkedHashSet2, arrayList6, arrayList7);
        Package r92 = OfflineQueueDatabase.class.getPackage();
        q7.k.b(r92);
        String name = r92.getName();
        String canonicalName = OfflineQueueDatabase.class.getCanonicalName();
        q7.k.b(canonicalName);
        q7.k.d(name, "fullPackage");
        if (name.length() != 0) {
            canonicalName = canonicalName.substring(name.length() + 1);
            q7.k.d(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String strConcat = ga.r.d0(canonicalName, '.', '_').concat("_Impl");
        try {
            Class<?> cls = Class.forName(name.length() == 0 ? strConcat : name + '.' + strConcat, true, OfflineQueueDatabase.class.getClassLoader());
            q7.k.c(cls, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            OfflineQueueDatabase offlineQueueDatabase = (OfflineQueueDatabase) cls.getDeclaredConstructor(null).newInstance(null);
            g3.k kVar = offlineQueueDatabase.f2670e;
            LinkedHashMap linkedHashMap = offlineQueueDatabase.f2672g;
            offlineQueueDatabase.f2669d = offlineQueueDatabase.e(eVar);
            Set setI = offlineQueueDatabase.i();
            BitSet bitSet = new BitSet();
            Iterator it5 = setI.iterator();
            while (true) {
                int i12 = -1;
                if (!it5.hasNext()) {
                    int size = arrayList7.size() - 1;
                    if (size >= 0) {
                        while (true) {
                            int i13 = size - 1;
                            if (!bitSet.get(size)) {
                                throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                            }
                            if (i13 < 0) {
                                break;
                            } else {
                                size = i13;
                            }
                        }
                    }
                    for (i5.n nVar2 : offlineQueueDatabase.g(linkedHashMap)) {
                        nVar2.getClass();
                        LinkedHashMap linkedHashMap2 = s0Var.f1030a;
                        if (linkedHashMap2.containsKey(1)) {
                            Map map = (Map) linkedHashMap2.get(1);
                            zContainsKey = (map == null ? a0.f2944f : map).containsKey(2);
                        } else {
                            zContainsKey = r48;
                        }
                        if (!zContainsKey) {
                            s0Var.a(nVar2);
                        }
                    }
                    offlineQueueDatabase.h().setWriteAheadLoggingEnabled(eVar.f3802b == 3 ? true : r48);
                    offlineQueueDatabase.f2671f = (ArrayList) eVar.f3805e;
                    offlineQueueDatabase.f2667b = i.a.f4388e;
                    offlineQueueDatabase.f2668c = new g3.q();
                    Map mapJ = offlineQueueDatabase.j();
                    BitSet bitSet2 = new BitSet();
                    for (Map.Entry entry : mapJ.entrySet()) {
                        Class cls2 = (Class) entry.getKey();
                        for (Class cls3 : (List) entry.getValue()) {
                            int size2 = arrayList6.size() - 1;
                            if (size2 >= 0) {
                                while (true) {
                                    int i14 = size2 - 1;
                                    if (cls3.isAssignableFrom(arrayList6.get(size2).getClass())) {
                                        bitSet2.set(size2);
                                        break;
                                    } else if (i14 < 0) {
                                        break;
                                    } else {
                                        size2 = i14;
                                    }
                                }
                            } else {
                                size2 = -1;
                            }
                            if (!(size2 >= 0 ? true : r48)) {
                                throw new IllegalArgumentException(("A required type converter (" + cls3 + ") for " + cls2.getCanonicalName() + " is missing in the database configuration.").toString());
                            }
                            offlineQueueDatabase.f2676k.put(cls3, arrayList6.get(size2));
                        }
                    }
                    int size3 = arrayList6.size() - 1;
                    if (size3 >= 0) {
                        while (true) {
                            int i15 = size3 - 1;
                            if (!bitSet2.get(size3)) {
                                throw new IllegalArgumentException("Unexpected type converter " + arrayList6.get(size3) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                            }
                            if (i15 < 0) {
                                break;
                            } else {
                                size3 = i15;
                            }
                        }
                    }
                    this.f10450p = offlineQueueDatabase;
                    u uVar = new u(offlineQueueDatabase, this.f10435h, this.f10423b.getOfflineQueue().getMaxEntries(), this.f10423b.getOfflineQueue().getMaxSizeMb() * 1048576, this.f10431f, this.f10429e, this.f10433g, this.f10423b.getTimeouts().getOfflineFrameTTL());
                    this.f10451q = uVar;
                    int port = this.f10423b.getBlobServer().getPort();
                    File cacheDir = this.f10421a.getCacheDir();
                    q7.k.d(cacheDir, "getCacheDir(...)");
                    f5.f fVar = new f5.f(port, n7.l.O(cacheDir, "blobs"), this.f10423b.getBlobServer().getMaxCacheSizeMb() * 1048576, this.f10429e, this.f10423b.getBlobServer().getMaxPutSizeMb() * 1048576);
                    this.f10452r = fVar;
                    this.f10453s = new i5.f(this.f10421a, this.f10423b, this.f10441k, this.f10445m, uVar, this.f10433g, this.f10431f, this.f10429e);
                    d7.n.x0(new String[]{"chat.send", "chat.stream", "tick"});
                    q7.k.d(Pattern.compile("\"type\"\\s*:\\s*\"([^\"]+)\""), "compile(...)");
                    q7.k.d(Pattern.compile("\"method\"\\s*:\\s*\"([^\"]+)\""), "compile(...)");
                    q7.k.d(Pattern.compile("\"urgent\"\\s*:\\s*true"), "compile(...)");
                    new ConcurrentLinkedDeque();
                    int i16 = r48;
                    new AtomicInteger(i16);
                    new AtomicInteger(i16);
                    this.f10454t = new a7.d(this.f10433g, this.f10431f, this.f10429e);
                    Context context3 = this.f10421a;
                    k5.g gVar2 = this.f10429e;
                    q7.k.e(context3, "context");
                    q7.k.e(gVar2, "logger");
                    u5.h hVar = new u5.h();
                    hVar.f10129a = context3;
                    hVar.f10130b = gVar2;
                    d5.t tVar = null;
                    String string = context3.getSharedPreferences("agentbus_prefs", 0).getString("route_preference", null);
                    if (string != null) {
                        int iHashCode = string.hashCode();
                        if (iHashCode != 3108285) {
                            if (iHashCode == 94756405 && string.equals("cloud")) {
                                tVar = d5.t.CLOUD;
                            }
                        } else if (string.equals("edge")) {
                            tVar = d5.t.EDGE;
                        }
                    }
                    hVar.f10131c = k0.c(tVar);
                    this.f10455u = hVar;
                    t tVar2 = new t(1);
                    this.f10456v = tVar2;
                    this.f10457w = new q6.b(19);
                    this.f10459y = new q6.b(new a(this, 0), this.f10429e);
                    d5.l lVar = this.f10441k;
                    a3.b bVar = this.f10443l;
                    h5.g gVar3 = this.f10445m;
                    h5.b bVar2 = this.f10447n;
                    List list2 = this.f10425c;
                    k5.g gVar4 = this.f10429e;
                    this.f10423b.getGateway().getCloudBridge().getEnabled();
                    this.f10460z = new q5.c(lVar, bVar, gVar3, bVar2, list2, gVar4, new q5.b(), new a(this, 15), tVar2, new s1.u(9));
                    h4.n nVar3 = new h4.n(16, false);
                    this.A = nVar3;
                    AgentBusConfig agentBusConfig2 = this.f10423b;
                    File filesDir = this.f10421a.getFilesDir();
                    q7.k.d(filesDir, "getFilesDir(...)");
                    k5.a aVar2 = this.f10431f;
                    k5.g gVar5 = this.f10429e;
                    a aVar3 = new a(this, 1);
                    a aVar4 = new a(this, 2);
                    q7.k.e(agentBusConfig2, "config");
                    q7.k.e(aVar2, "dispatchers");
                    q7.k.e(gVar5, "logger");
                    String backend = agentBusConfig2.getResource().getBackend();
                    int iHashCode2 = backend.hashCode();
                    if (iHashCode2 != -504196183) {
                        q0Var = iHashCode2 != 0 ? new a6.j() : new a6.j();
                    } else if (backend.equals("openclaw")) {
                        String rootfsBase = agentBusConfig2.getResource().getRootfsBase();
                        q0Var = new q0(new m4.u0(new File(ga.k.t0(rootfsBase) ? n7.l.O(filesDir, "rootfs").getAbsolutePath() : rootfsBase)), fVar, aVar2, gVar5, new o4.d0(13, nVar3), aVar3, aVar4);
                    } else {
                        k5.s.warn$default(gVar5, "ResourceBackendFactory", a1.a.j("unknown resource backend ", agentBusConfig2.getResource().getBackend(), ", fallback to mock"), null, 4, null);
                        q0Var = new a6.j();
                    }
                    a6.u uVar2 = new a6.u(q0Var, this.f10429e);
                    d5.l lVar2 = this.f10441k;
                    a7.d dVar3 = this.f10433g;
                    k5.a aVar5 = this.f10431f;
                    k5.g gVar6 = this.f10429e;
                    q7.k.e(lVar2, "pool");
                    q7.k.e(dVar3, "internalBus");
                    q7.k.e(aVar5, "dispatchers");
                    q7.k.e(gVar6, "logger");
                    a4.p pVar = new a4.p();
                    pVar.f192f = q0Var;
                    pVar.f193g = lVar2;
                    pVar.f194h = dVar3;
                    pVar.f195i = gVar6;
                    pVar.f196j = ia.d0.b(f1.plus(ia.d0.c(), aVar5.f5617b));
                    this.B = pVar;
                    this.C = ia.d0.b(f1.plus(ia.d0.c(), this.f10431f.f5617b));
                    z5.e dVar4 = this.f10423b.getDataReport().getEnabled() ? new s9.d(8) : z5.f.f11814f;
                    t tVar3 = new t(4);
                    this.F = tVar3;
                    z5.c cVar = new z5.c(dVar4, this.f10429e, this.f10423b.getDataReport().getEnabled(), tVar3);
                    this.G = cVar;
                    ArrayList arrayList8 = new ArrayList();
                    arrayList8.add(new l());
                    a3.b bVar3 = this.f10443l;
                    k5.g gVar7 = this.f10429e;
                    arrayList8.add(new s5.e(bVar3, gVar7));
                    AgentBusConfig agentBusConfig3 = this.f10423b;
                    if (agentBusConfig3.getPrivacy().getEnabled()) {
                        i5.l lVar3 = new i5.l(this.f10421a, gVar7, new a(this, 5));
                        this.E = lVar3;
                        arrayList8.add(new t5.f(lVar3, gVar7, agentBusConfig3.getDataReport().getEnabled() ? cVar : null));
                    }
                    if (q7.k.a(agentBusConfig3.getGateway().getVendor(), "openclaw")) {
                        s5.e eVar2 = new s5.e(gVar7);
                        this.D = eVar2;
                        arrayList8.add(eVar2);
                        this.f10436h0 = new nb.f(new a(this, 7), gVar7);
                    }
                    if (agentBusConfig3.getDataReport().getEnabled()) {
                        arrayList8.add(new z5.b(cVar));
                    }
                    if (q7.k.a(this.f10423b.getGateway().getVendor(), "openclaw")) {
                        dVar = new q6.b(new j(this, null));
                    } else {
                        dVar = new s9.d(9);
                        k0.c(new o5.i("task not supported on current backend", System.currentTimeMillis(), o5.j.Permanent));
                    }
                    this.H = dVar;
                    u4.l lVar4 = new u4.l(this.f10441k);
                    this.I = lVar4;
                    i5.l lVar5 = new i5.l(dVar, lVar4, this.f10429e);
                    i5.f fVar2 = new i5.f(this.f10441k, lVar4, this.f10429e);
                    u4.h hVar2 = new u4.h(new File("/sdcard/Documents/clawbench"), this.f10435h, this.f10431f, this.f10429e);
                    this.J = hVar2;
                    p5.q qVar = new p5.q();
                    this.K = qVar;
                    i5.f fVar3 = new i5.f(this.f10421a, qVar, this.f10429e);
                    this.L = fVar3;
                    nb.f fVar4 = new nb.f(this.f10441k, fVar3, this.f10429e);
                    b bVar4 = new b(this);
                    d5.l lVar6 = this.f10441k;
                    k5.g gVar8 = this.f10429e;
                    long invokeTimeoutMs = this.f10423b.getTimeouts().getInvokeTimeoutMs();
                    p5.c cVar2 = new p5.c(lVar6, fVar4, fVar3, bVar4, gVar8, invokeTimeoutMs > 10000 ? 10000L : invokeTimeoutMs);
                    this.M = new i5.f(this.f10441k, this.f10457w, this.f10429e, cVar2);
                    d5.l lVar7 = this.f10441k;
                    q5.c cVar3 = this.f10460z;
                    a3.b bVar5 = this.f10443l;
                    h5.g gVar9 = this.f10445m;
                    h5.b bVar6 = this.f10447n;
                    u uVar3 = this.f10451q;
                    long offlineFrameTTL = this.f10423b.getTimeouts().getOfflineFrameTTL();
                    long invokeTimeoutMs2 = this.f10423b.getTimeouts().getInvokeTimeoutMs();
                    k5.a aVar6 = this.f10431f;
                    k5.g gVar10 = this.f10429e;
                    a7.d dVar5 = this.f10433g;
                    a5.a aVar7 = new a5.a(22, this);
                    t tVar4 = this.f10456v;
                    i5.l lVar8 = this.E;
                    long invokeTimeoutMs3 = this.f10423b.getTimeouts().getInvokeTimeoutMs();
                    this.N = new q5.q(lVar7, cVar3, bVar5, gVar9, bVar6, uVar3, offlineFrameTTL, invokeTimeoutMs2, aVar6, gVar10, lVar4, dVar5, aVar7, uVar2, arrayList8, tVar4, lVar5, fVar2, lVar8, fVar4, cVar2, invokeTimeoutMs3 > 10000 ? 10000L : invokeTimeoutMs3, hVar2, this.f10459y);
                    u0 u0VarC = k0.c(new o5.k());
                    this.O = u0VarC;
                    u0 u0VarC2 = k0.c(new o5.a(false, false, false));
                    this.P = u0VarC2;
                    this.R = new o5.e(this.f10441k, this.f10433g, this.f10423b.getRouter().getOnlineStableWindowMs(), this.f10431f, this.f10429e, u0VarC, u0VarC2);
                    this.S = new p5.h(this.f10441k, this.f10451q, this.f10433g, this.f10431f, this.f10429e, "GATEWAY", d5.m.GATEWAY, d5.t.CLOUD, 4704);
                    this.T = new p5.h(this.f10441k, this.f10451q, this.f10433g, this.f10431f, this.f10429e, "CHANNEL", d5.m.CHANNEL, null, 7264);
                    this.U = new m4.u0(this.f10441k, this.f10431f, this.f10429e);
                    this.V = new ConfigManager(this.f10439j, this.f10441k, null, this.f10431f, this.f10429e, this.f10433g, 4, null);
                    this.W = new s(this.f10423b.getRestApi().getPort(), this, this.f10431f, this.f10429e, this.f10433g);
                    na.d dVarB = ia.d0.b(f1.plus(ia.d0.c(), this.f10431f.f5617b));
                    this.X = dVarB;
                    this.Y = new v5.c(this.f10421a, this.f10429e, this.f10423b.getGateway().getDebugAccount().getEnabled(), this.f10423b.getGateway().getDebugAccount().getDebugAccountToken(), new ia.l(2, this));
                    q6.b bVar7 = new q6.b(this.f10429e);
                    this.Z = new a5.h(this.f10441k, this.f10443l, this.f10445m, bVar7, dVarB, this.f10429e, this.I, this.f10423b.getTimeouts().getInvokeTimeoutMs(), new i5.l(bVar7, new a5.f(PushConfigKt.getHost(this.f10421a), dVarB, this.f10429e, new a(this, 3), this.f10423b.getPush().getCallbackTimeoutMs(), this.G), this.f10429e), this.G);
                    this.f10422a0 = new i5.f(new a(this, 4), this.M, dVarB, this.f10429e);
                    this.f10424b0 = new i5.l(new a(this, 6), this.f10429e);
                    this.f10426c0 = new q6.b(new q6.b(this.f10441k, this.N, this.f10429e), new w4.a(), this.f10429e);
                    AgentBusConfig agentBusConfig4 = this.f10423b;
                    d5.l lVar9 = this.f10441k;
                    a3.b bVar8 = this.f10443l;
                    c5.d dVar6 = this.f10435h;
                    s9.d dVar7 = this.f10437i;
                    k5.a aVar8 = this.f10431f;
                    k5.g gVar11 = this.f10429e;
                    a7.d dVar8 = this.f10433g;
                    i5.f fVar5 = this.L;
                    p5.q qVar2 = this.K;
                    q6.b bVar9 = this.f10457w;
                    a7.d dVar9 = this.f10449o;
                    PackageManager packageManager2 = this.f10421a.getPackageManager();
                    q7.k.d(packageManager2, "getPackageManager(...)");
                    this.f10428d0 = new p(agentBusConfig4, lVar9, bVar8, dVar6, dVar7, aVar8, gVar11, dVar8, dVarB, fVar5, qVar2, bVar9, dVar9, packageManager2);
                    a aVar9 = new a(this, 9);
                    a aVar10 = new a(this, 10);
                    a aVar11 = new a(this, 11);
                    u5.h hVar3 = new u5.h();
                    hVar3.f10129a = aVar9;
                    hVar3.f10130b = aVar10;
                    hVar3.f10131c = aVar11;
                    this.f10444l0 = hVar3;
                    Context context4 = this.f10421a;
                    a aVar12 = new a(this, 12);
                    q7.k.e(context4, "context");
                    u5.h hVar4 = new u5.h();
                    hVar4.f10129a = aVar12;
                    Object systemService2 = context4.getApplicationContext().getSystemService("connectivity");
                    hVar4.f10130b = systemService2 instanceof ConnectivityManager ? (ConnectivityManager) systemService2 : null;
                    this.f10446m0 = hVar4;
                    this.f10448n0 = new i5.f(this.f10421a, new a(this, 13), new a(this, 14));
                    return;
                }
                Class cls4 = (Class) it5.next();
                int size4 = arrayList7.size() - 1;
                if (size4 >= 0) {
                    while (true) {
                        int i17 = size4;
                        size4 = i17 - 1;
                        i2 = i12;
                        if (cls4.isAssignableFrom(arrayList7.get(i17).getClass())) {
                            bitSet.set(i17);
                            i10 = i17;
                            break;
                        } else if (size4 < 0) {
                            break;
                        } else {
                            i12 = i2;
                        }
                    }
                } else {
                    i2 = -1;
                }
                i10 = i2;
                if (i10 < 0) {
                    throw new IllegalArgumentException(("A required auto migration spec (" + cls4.getCanonicalName() + ") is missing in the database configuration.").toString());
                }
                linkedHashMap.put(cls4, arrayList7.get(i10));
            }
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + OfflineQueueDatabase.class.getCanonicalName() + ". " + strConcat + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException(x.j(OfflineQueueDatabase.class, new StringBuilder("Cannot access the constructor ")));
        } catch (InstantiationException unused3) {
            throw new RuntimeException(x.j(OfflineQueueDatabase.class, new StringBuilder("Failed to create an instance of ")));
        }
    }

    public final boolean a() {
        Object objN;
        try {
            Object systemService = this.f10421a.getSystemService("power");
            q7.k.c(systemService, "null cannot be cast to non-null type android.os.PowerManager");
            objN = Boolean.valueOf(((PowerManager) systemService).isInteractive());
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Object obj = Boolean.TRUE;
        if (objN instanceof c7.l) {
            objN = obj;
        }
        return ((Boolean) objN).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0119  */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11, types: [ia.w1, java.lang.Object, x4.i] */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v39, types: [g7.d, g7.l, ia.c0] */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v43 */
    /* JADX WARN: Type inference failed for: r8v10, types: [g7.d, g7.l, ia.c0] */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1723
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.k.b():void");
    }
}
