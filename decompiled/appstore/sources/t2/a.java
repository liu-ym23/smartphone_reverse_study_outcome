package t2;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Process;
import android.util.Log;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.CgroupFetcher;
import com.bytedance.apm6.cpu.config.CpuConfigService;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.watson.assist.api.IAssistStat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f24708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.apm6.cpu.collect.b f24709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.apm6.cpu.collect.a f24710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SharedPreferences f24711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ActivityLifecycleService f24712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ApmCpuManager.ICpuDataListener f24713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IAssistStat f24714g;

    /* JADX INFO: renamed from: t2.a$a, reason: collision with other inner class name */
    public class C0380a extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f24715d;

        public C0380a(a r10, long r11, long r12) {
            this.f24715d = r10;
            super(r11, r12);
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(this.f24715d);
        }
    }

    public class b implements IActivityLifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f24716a;

        public b(a r10) {
            this.f24716a = r10;
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onActivityCreated(Activity r10) {
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onActivityPause(Activity r10) {
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onActivityResume(Activity r10) {
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onActivityStarted(Activity r10) {
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onBackground(Activity r10) {
            a.b(this.f24716a).edit().putString(d3.a.m(), Process.myPid() + ",false").apply();
        }

        @Override // com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public void onFront(Activity r10) {
            a.b(this.f24716a).edit().putString(d3.a.m(), Process.myPid() + ",true").apply();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f24717a = null;

        static {
            f24717a = new a(null);
        }

        public static /* synthetic */ a a() {
            return f24717a;
        }
    }

    public /* synthetic */ a(C0380a r10) {
        this();
    }

    public static /* synthetic */ void a(a r10) {
        r10.c();
    }

    public static /* synthetic */ SharedPreferences b(a r10) {
        return r10.f24711d;
    }

    public static a e() {
        return c.a();
    }

    public final void c() {
        Map<String, ?> r10 = this.f24711d.getAll();
        if (r10 == null) goto L23;
        Iterator<Map.Entry<String, ?>> r11 = r10.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L41;
        Map.Entry<String, ?> r12 = r11.next();
        String r13 = r12.getKey();     // Catch: Throwable -> L24
        File r14 = new File("/proc/" + ((String) r12.getValue()).split(",")[0] + "/stat");     // Catch: Throwable -> L24
        String r15 = "";
        BufferedReader r16 = null;
        BufferedReader r17 = new BufferedReader(new FileReader(r14.getPath()), 100);     // Catch: Throwable -> L25
        r15 = r17.readLine();     // Catch: Throwable -> L13
        r17.close();     // Catch: Throwable -> L24
    L17:
        if (r15.isEmpty() == true) goto L18;
        String r18 = r15.split(" ")[1];     // Catch: Throwable -> L24
        if (r13.endsWith(r18.substring(1, r18.length() - 1)) == true) goto L6;
        this.f24711d.edit().remove(r13).apply();     // Catch: Throwable -> L24
        goto L6
    L18:
        this.f24711d.edit().remove(r13).apply();     // Catch: Throwable -> L24
    L13:
        r16 = r17;
    L14:
        if (r16 == null) goto L17;
        r16.close();     // Catch: Throwable -> L24
        goto L17
    L41:
        return;
    }

    public ApmCpuManager.ICpuDataListener d() {
        return this.f24713f;
    }

    public void f() {
        if (this.f24708a.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.f24712e = (ActivityLifecycleService) o3.a.a(ActivityLifecycleService.class);
        this.f24711d = j1.b.g(r3.a.b(), "apm_cpu_front");
        if (d3.a.A() == false) goto L8;
        c();
        u3.b.a(AsyncTaskManagerType.CPU).c(new C0380a(this, 300000, 300000));
    L8:
        this.f24711d.edit().putString(d3.a.m(), Process.myPid() + "," + this.f24712e.isForeground()).apply();
        this.f24712e.register(new b(this));
        o3.a.a(CpuConfigService.class);
    }

    public boolean g() {
        if (this.f24712e.isForeground() == false) goto L6;
        this.f24711d.edit().putString(d3.a.m(), Process.myPid() + "," + this.f24712e.isForeground()).apply();
        return true;
    L6:
        Map<String, ?> r10 = this.f24711d.getAll();
        if (r10 == null) goto L15;
        Iterator<Map.Entry<String, ?>> r11 = r10.entrySet().iterator();
    L10:
        if (r11.hasNext() == false) goto L15;
        if (((String) r11.next().getValue()).split(",")[1].equals("true") == false) goto L10;
        boolean r12 = true;
    L16:
        CgroupFetcher.CGROUP_LEVEL r13 = CgroupFetcher.a();
        if (r12 == false) goto L19;
        return true;
    L19:
        if (this.f24712e.isForeground() == false) goto L21;
        return true;
    L21:
        if (r13 != CgroupFetcher.CGROUP_LEVEL.TOP_APP) goto L23;
        return true;
    L23:
        if (r13 != CgroupFetcher.CGROUP_LEVEL.FOREGROUND) goto L26;
        return true;
    L26:
        return false;
    L15:
        r12 = false;
        goto L16
    }

    public void h() {
        this.f24709b.n();
        this.f24710c.j();
    }

    public void i() {
        this.f24709b.l();
        this.f24710c.h();
    }

    public void j(u2.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        t2.b.a();
        Log.i("APM-CPU", "config: " + r10);
        if (w0.c.F() == true) goto L10;
        if (r10.f() == true) goto L10;
        return;
    L10:
        if (r10.g() == false) goto L13;
        this.f24709b.m(r10);
        this.f24710c.i(r10);
        return;
    }

    public a() {
        this.f24708a = new AtomicBoolean(false);
        this.f24714g = t6.b.a(w0.c.g());     // Catch: Throwable -> L6
    L4:
        com.bytedance.apm6.cpu.collect.a r10 = new com.bytedance.apm6.cpu.collect.a(this.f24714g);
        this.f24710c = r10;
        this.f24709b = new com.bytedance.apm6.cpu.collect.b(r10, this.f24714g);
    }
}
