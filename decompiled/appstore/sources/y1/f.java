package y1;

import com.bytedance.apm.perf.traffic.ITrafficStatistics;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITrafficStatistics f26030a;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static f f26031a;

        static {
            f26031a = new f(null);
        }

        public static /* synthetic */ f a() {
            return f26031a;
        }
    }

    public /* synthetic */ f(a r10) {
        this();
    }

    public static f e() {
        return b.a();
    }

    public long a() {
        return this.f26030a.getBackBytes();
    }

    public long b() {
        return this.f26030a.getBackPackets();
    }

    public long c() {
        return this.f26030a.getFrontBytes();
    }

    public long d() {
        return this.f26030a.getFrontPackets();
    }

    public long f() {
        return this.f26030a.getMobileBackBytes();
    }

    public long g() {
        return this.f26030a.getMobileFrontBytes();
    }

    public long h() {
        return this.f26030a.getTotalBytes();
    }

    public long i() {
        return this.f26030a.getWifiBackBytes();
    }

    public long j() {
        return this.f26030a.getWifiFrontBytes();
    }

    public void k(boolean r10) {
        this.f26030a.onStatusChange(r10);
    }

    public f() {
        c r10 = new c();
        this.f26030a = r10;
        r10.init();
    }
}
