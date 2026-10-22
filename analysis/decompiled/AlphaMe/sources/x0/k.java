package x0;

import B0.r;
import Z2.C0125f0;
import Z2.G;
import Z2.I;
import Z2.r0;
import kotlin.jvm.internal.Intrinsics;
import s0.t;
import t0.J;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f15888a;

    static {
        String strF = t.f("WorkConstraintsTracker");
        Intrinsics.checkNotNullExpressionValue(strF, "tagWithPrefix(\"WorkConstraintsTracker\")");
        f15888a = strF;
    }

    public static final r0 a(stepos.support.v7.app.palette.b bVar, r spec, C0125f0 dispatcher, e listener) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(listener, "listener");
        r0 r0VarA = I.a();
        J.y(G.a(dispatcher.plus(r0VarA)), null, new j(bVar, spec, listener, null), 3);
        return r0VarA;
    }
}
