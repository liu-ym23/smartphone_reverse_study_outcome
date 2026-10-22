package bz0;

import android.view.View;
import com.bytedance.android.annie.api.resource.AnnieResType;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import com.bytedance.android.live.revenue.platform.hybrid.impl.util.CompositeListenerUpTo6Args;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j extends a {
    public final CompositeListenerUpTo6Args<Unit, Function2<Integer, String, Unit>> A;
    public final CompositeListenerUpTo6Args<Unit, Function1<View, Unit>> B;
    public final CompositeListenerUpTo6Args<Unit, Function3<View, String, String, Unit>> C;
    public final CompositeListenerUpTo6Args<Boolean, Function2<Integer, String, Boolean>> D;
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> E;
    public final CompositeListenerUpTo6Args<Unit, Function4<String, AnnieResType, HybridType, Map<String, Object>, Unit>> F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function3<String, String, Boolean, Unit>> f21831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function1<View, Unit>> f21833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function2<View, Set<String>, Unit>> f21834h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21835i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21836j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function1<Boolean, Unit>> f21837k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21838l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21839m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21840n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21841o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21842p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21843q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21844r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21845s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21846t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21847u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function3<View, HybridType, String, Unit>> f21848v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function0<Unit>> f21849w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function2<Boolean, String, Unit>> f21850x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function3<View, Integer, String, Unit>> f21851y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final CompositeListenerUpTo6Args<Unit, Function2<View, Boolean, Unit>> f21852z;

    public j() {
        this.f21827a = new CompositeListenerUpTo6Args();
        this.f21828b = new CompositeListenerUpTo6Args();
        this.f21829c = new CompositeListenerUpTo6Args();
        this.f21830d = new CompositeListenerUpTo6Args();
        this.f21831e = new CompositeListenerUpTo6Args();
        this.f21832f = new CompositeListenerUpTo6Args();
        this.f21833g = new CompositeListenerUpTo6Args();
        this.f21834h = new CompositeListenerUpTo6Args();
        this.f21835i = new CompositeListenerUpTo6Args();
        this.f21836j = new CompositeListenerUpTo6Args();
        this.f21837k = new CompositeListenerUpTo6Args();
        this.f21838l = new CompositeListenerUpTo6Args();
        this.f21839m = new CompositeListenerUpTo6Args();
        this.f21840n = new CompositeListenerUpTo6Args();
        this.f21841o = new CompositeListenerUpTo6Args();
        this.f21842p = new CompositeListenerUpTo6Args();
        this.f21843q = new CompositeListenerUpTo6Args();
        this.f21844r = new CompositeListenerUpTo6Args();
        this.f21845s = new CompositeListenerUpTo6Args();
        this.f21846t = new CompositeListenerUpTo6Args();
        this.f21847u = new CompositeListenerUpTo6Args();
        this.f21848v = new CompositeListenerUpTo6Args();
        this.f21849w = new CompositeListenerUpTo6Args();
        this.f21850x = new CompositeListenerUpTo6Args();
        this.f21851y = new CompositeListenerUpTo6Args();
        this.f21852z = new CompositeListenerUpTo6Args();
        this.A = new CompositeListenerUpTo6Args();
        this.B = new CompositeListenerUpTo6Args();
        this.C = new CompositeListenerUpTo6Args();
        this.D = new CompositeListenerUpTo6Args();
        this.E = new CompositeListenerUpTo6Args();
        this.F = new CompositeListenerUpTo6Args();
    }

    @Override // yy0.g
    public final void d(Function3<? super View, ? super Integer, ? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f21851y.a(r100);
    }

    @Override // yy0.g
    public final void e(Function2<? super Integer, ? super String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.D.a(r100);
    }

    @Override // yy0.g
    public final void g(Function2<? super Integer, ? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.A.a(r100);
    }

    @Override // yy0.g
    public final void h(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f21836j.a(r100);
    }
}
