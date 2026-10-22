package com.bytedance.apm6.hub;

import com.bytedance.apm.config.FluencyConfigService;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm6.commonevent.config.CommonEventConfigService;
import com.bytedance.apm6.consumer.slardar.SlardarResponseService;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutListener;
import com.bytedance.apm6.cpu.config.CpuConfigService;
import com.bytedance.apm6.disk.config.DiskConfigService;
import com.bytedance.apm6.fd.config.IFdConfigService;
import com.bytedance.apm6.java_alloc.JavaAllocConfigService;
import com.bytedance.apm6.memory.IMapsCollectService;
import com.bytedance.apm6.memory.MemoryCollector;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.service.ServiceCreator;
import com.bytedance.apm6.service.device.IDeviceInfoService;
import com.bytedance.apm6.service.encrypt.EncryptService;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.perf.ICpuDataService;
import com.bytedance.apm6.service.perf.IPerfFilterManager;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.services.apm.api.IActivityLifeManager;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMonitorLogManager;
import com.bytedance.services.apm.api.IZstdCompress;
import com.bytedance.services.apm.api.IZstdDict;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class Apm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f6790a = false;

    public static class a implements ServiceCreator {
        public a() {
        }

        public IPerfFilterManager a() {
            return m3.c.a();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class b implements ServiceCreator {
        public b() {
        }

        public IZstdCompress a() {
            return new w0.i();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class c implements ServiceCreator {
        public c() {
        }

        public IZstdDict a() {
            return new w0.j();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class d implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm6.hub.a f6791a;

        public d(com.bytedance.apm6.hub.a r10) {
            this.f6791a = r10;
        }

        public MemoryConfigService a() {
            return this.f6791a.j();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class e implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm6.hub.a f6792a;

        public e(com.bytedance.apm6.hub.a r10) {
            this.f6792a = r10;
        }

        public JavaAllocConfigService a() {
            return this.f6792a.h();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class f implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm6.hub.a f6793a;

        public f(com.bytedance.apm6.hub.a r10) {
            this.f6793a = r10;
        }

        public IMapsCollectService a() {
            return this.f6793a.i();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class g implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm6.hub.a f6794a;

        public g(com.bytedance.apm6.hub.a r10) {
            this.f6794a = r10;
        }

        public IDeviceInfoService a() {
            return this.f6794a.c();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class h implements ServiceCreator {
        public h() {
        }

        public DiskConfigService a() {
            return new f3.c();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class i implements ServiceCreator {
        public i() {
        }

        public ICpuDataService a() {
            return x2.a.a();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class j implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm6.hub.a f6795a;

        public j(com.bytedance.apm6.hub.a r10) {
            this.f6795a = r10;
        }

        public SlardarResponseService a() {
            return this.f6795a.l();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm6.hub.a f6796a;

        public k(com.bytedance.apm6.hub.a r10) {
            this.f6796a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Apm.a(this.f6796a);
        }
    }

    public static class l implements ServiceCreator {
        public l() {
        }

        public IFdConfigService a() {
            return new f3.d();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class m implements com.bytedance.news.common.service.manager.ServiceCreator {
        public m() {
        }

        public IActivityLifeManager a() {
            return ActivityLifeObserver.getInstance();
        }

        @Override // com.bytedance.news.common.service.manager.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class n extends u3.a {
        public n(long r10) {
            super(r10);
        }

        @Override // java.lang.Runnable
        public void run() {
            l3.a.e(n2.e.c());
            MemoryCollector.getInstance().init();
            com.bytedance.apm6.java_alloc.a.b().c();
            if (d3.a.A() == false) goto L5;
            y2.a.d().e();
        L5:
            t2.a.e().f();
            w0.g.a().b();
            if (d3.a.A() == false) goto L9;
            r1.d.h();
            w0.c.K(com.bytedance.apm.trace.a.e());
        L9:
            if (d3.a.A() == false) goto L12;
            a3.a.i().j();
            return;
        }
    }

    public static class o implements WeedOutListener {
        public o() {
        }

        @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutListener
        public void onWeedOut(List r10) {
            if (ListUtils.b(r10) == false) goto L5;
            return;
        L5:
            JSONObject r11 = new JSONObject();
            JSONObject r12 = new JSONObject();
            Iterator r13 = r10.iterator();
        L7:
            if (r13.hasNext() == false) goto L13;
            s2.a r14 = (s2.a) r13.next();
            r12.put("before_size_" + r14.c(), r14.b());     // Catch: Exception -> L15
            r12.put("after_size_" + r14.c(), r14.a());     // Catch: Exception -> L15
            r11.put("strategy", r14.c());     // Catch: Exception -> L15
            if (r14.d() == false) goto L7;
            r11.put("reach_top_today", r14.d());     // Catch: Exception -> L15
            goto L7
        L13:
            k2.a.g("apm_db_size", r11, r12, null);
        }
    }

    public static class p implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm6.hub.a f6797a;

        public p(com.bytedance.apm6.hub.a r10) {
            this.f6797a = r10;
        }

        public IHttpService a() {
            return this.f6797a.g();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class q implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm6.hub.a f6798a;

        public q(com.bytedance.apm6.hub.a r10) {
            this.f6798a = r10;
        }

        public SlardarHandlerConfigService a() {
            return this.f6798a.k();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class r implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm6.hub.a f6799a;

        public r(com.bytedance.apm6.hub.a r10) {
            this.f6799a = r10;
        }

        public CommonEventConfigService a() {
            return this.f6799a.a();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class s implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm6.hub.a f6800a;

        public s(com.bytedance.apm6.hub.a r10) {
            this.f6800a = r10;
        }

        public CpuConfigService a() {
            return this.f6800a.b();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class t implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm6.hub.a f6801a;

        public t(com.bytedance.apm6.hub.a r10) {
            this.f6801a = r10;
        }

        public FluencyConfigService a() {
            return this.f6801a.f();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class u implements ServiceCreator {
        public u() {
        }

        public ActivityLifecycleService a() {
            return new c3.a();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class v implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm6.hub.a f6802a;

        public v(com.bytedance.apm6.hub.a r10) {
            this.f6802a = r10;
        }

        public IEncrypt a() {
            return this.f6802a.e();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    public static class w implements ServiceCreator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.apm6.hub.a f6803a;

        public w(com.bytedance.apm6.hub.a r10) {
            this.f6803a = r10;
        }

        public EncryptService a() {
            return this.f6803a.d();
        }

        @Override // com.bytedance.apm6.service.ServiceCreator
        public /* bridge */ /* synthetic */ Object create() {
            return a();
        }
    }

    static {
    }

    public static /* synthetic */ void a(com.bytedance.apm6.hub.a r10) {
        e(r10);
    }

    public static void b() {
        s2.b.g().i(new o());
    }

    public static synchronized Runnable c(com.bytedance.apm6.hub.a r10) {
        monitor-enter(Apm.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f6790a == false) goto L10;
        monitor-exit(Apm.class);
        return null;
    L10:
        f6790a = true;     // Catch: Throwable -> L13
        d(r10);     // Catch: Throwable -> L13
        k r11 = new k(r10);     // Catch: Throwable -> L13
        monitor-exit(Apm.class);
        return r11;
    }

    public static void d(com.bytedance.apm6.hub.a r10) {
        d3.a.B(r10);
        d3.a.F(System.currentTimeMillis());
        d3.a.D(System.currentTimeMillis());
        if (r3.a.c() == false) goto L5;
        s3.a.a("APM-Hub", "APM init start in process " + r10.getProcessName());
    L5:
        s3.a.e(new e3.b());
        o3.a.d(ActivityLifecycleService.class, new c3.a());
    }

    public static void e(com.bytedance.apm6.hub.a r10) {
        o3.a.c(IHttpService.class, new p(r10));
        o3.a.c(SlardarHandlerConfigService.class, new q(r10));
        o3.a.c(CommonEventConfigService.class, new r(r10));
        o3.a.c(CpuConfigService.class, new s(r10));
        o3.a.c(FluencyConfigService.class, new t(r10));
        o3.a.c(ActivityLifecycleService.class, new u());
        o3.a.c(IEncrypt.class, new v(r10));
        o3.a.c(EncryptService.class, new w(r10));
        o3.a.c(IPerfFilterManager.class, new a());
        o3.a.c(IZstdCompress.class, new b());
        o3.a.c(IZstdDict.class, new c());
        new c3.a();
        o3.a.c(MemoryConfigService.class, new d(r10));
        o3.a.c(JavaAllocConfigService.class, new e(r10));
        o3.a.c(IMapsCollectService.class, new f(r10));
        o3.a.c(IDeviceInfoService.class, new g(r10));
        o3.a.c(DiskConfigService.class, new h());
        o3.a.c(ICpuDataService.class, new i());
        o3.a.c(SlardarResponseService.class, new j(r10));
        o3.a.c(IFdConfigService.class, new l());
        n5.b.c(IActivityLifeManager.class, new m());
        n5.b.c(IMonitorLogManager.class, new AnonymousClass22());
        g3.a.g().h();
        u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(new n(r10.m()));
        b();
    }

    public static void f() {
        n2.e.c().d();
        t2.a.e().h();
        MemoryCollector.getInstance().pause();
    }

    public static void g() {
        n2.e.c().e();
        t2.a.e().i();
        MemoryCollector.getInstance().resume();
    }
}
