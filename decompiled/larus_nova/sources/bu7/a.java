package bu7;

import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import eu7.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, b> f20745a = null;

    public a() {
    }

    static {
        f20745a = new LinkedHashMap();
    }

    public static void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "extra");
        FLogger.f375446a.i("Performance-infra", a(r100, -1, r101).toString());
    }

    public static eu7.a a(String r110, long r111, String r112) {
        String r100 = ThreadMethodProxy.currentThread().getName();
        com.flow.performance.perflog.scenario.b.f274159a.getClass();
        return new eu7.a(r110, r111, r100, com.flow.performance.perflog.scenario.b.f274164f, com.flow.performance.perflog.scenario.b.f274162d, com.flow.performance.perflog.scenario.b.f274161c, com.flow.performance.perflog.scenario.b.f274165g, r112);
    }
}
