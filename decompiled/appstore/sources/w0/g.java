package w0;

import com.bytedance.apm.config.FluencyConfigService;

/* JADX INFO: loaded from: classes.dex */
public class g {

    public static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f25284a = null;

        static {
            f25284a = new g(null);
        }

        public static /* synthetic */ g a() {
            return f25284a;
        }
    }

    public /* synthetic */ g(a r10) {
        this();
    }

    public static g a() {
        return b.a();
    }

    public void b() {
        o3.a.a(FluencyConfigService.class);
    }

    public void c(h1.e r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        com.bytedance.apm.block.j.M(r10.d());
        com.bytedance.apm.block.f.a().e();
        com.bytedance.apm.block.f.a().f(r10.a(), false);
        h.b(r10);
        com.bytedance.apm.block.e.b(r10.g(), r10.d());
    }

    public g() {
        o3.a.a(FluencyConfigService.class);
    }
}
