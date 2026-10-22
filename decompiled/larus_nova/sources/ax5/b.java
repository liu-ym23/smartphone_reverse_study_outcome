package ax5;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<qw5.a, jw5.a> f16633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f16634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, jw5.a> f16635c;

    public static final class a {
    }

    static {
    }

    public b(ex5.b r100) {
        Intrinsics.checkNotNullParameter(r100, "sessionFactory");
        this.f16633a = r100;
        this.f16634b = new Object();
        this.f16635c = new LinkedHashMap();
    }

    public final void a(String r100, jw5.a r101) {
        Object r102 = this.f16634b;
        monitor-enter(r102);
        this.f16635c.put(r100, r101);     // Catch: Throwable -> L7
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r102);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
