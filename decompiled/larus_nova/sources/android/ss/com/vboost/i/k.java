package android.ss.com.vboost.i;

import android.ss.com.vboost.CapabilityType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<CapabilityType, Object> f4718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<CapabilityType, Object> f4719b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final k f4720a = null;

        static {
            f4720a = new k();
        }

        public static /* synthetic */ k a() {
            return f4720a;
        }
    }

    public k() {
        this.f4718a = new HashMap();
        this.f4719b = new HashMap();
    }

    public static k a() {
        return a.a();
    }

    public <T extends Map> T a(g r100, CapabilityType r101) {
        if (g.f4705a != r100) goto L7;
        Map<CapabilityType, Object> r102 = this.f4718a;
    L6:
        return (T) r102.get(r101);
    L7:
        r102 = this.f4719b;
        goto L6
    }

    public <T extends Map> void a(g r100, CapabilityType r101, T r102) {
        if (g.f4705a != r100) goto L5;
        Map<CapabilityType, Object> r103 = this.f4718a;
    L6:
        r103.put(r101, r102);
        return;
    L5:
        r103 = this.f4719b;
        goto L6
    }
}
