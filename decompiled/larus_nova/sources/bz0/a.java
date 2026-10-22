package bz0;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a implements yy0.g {
    public a() {
    }

    @Override // yy0.g
    public final void a(Function1<? super View, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ((j) this).B.a(r100);
    }

    @Override // yy0.g
    public final void b(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ((j) this).E.a(r100);
    }

    @Override // yy0.g
    public final void c(Function3<? super View, ? super String, ? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ((j) this).C.a(r100);
    }

    @Override // yy0.g
    public final void f(Function2<? super View, ? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        ((j) this).f21852z.a(r100);
    }
}
