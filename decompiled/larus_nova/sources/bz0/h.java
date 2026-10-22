package bz0;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h implements yy0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cq2.b f21825a;

    public h(cq2.b r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        this.f21825a = r100;
    }

    @Override // yy0.e
    public final void a(Function1<? super yy0.f, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        r100.invoke(new i(this.f21825a));
    }
}
