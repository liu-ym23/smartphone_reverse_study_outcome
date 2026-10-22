package t0;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class N extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final N f15353a = new N(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        B0.r spec = (B0.r) obj;
        Intrinsics.checkNotNullParameter(spec, "spec");
        return spec.d() ? "Periodic" : "OneTime";
    }
}
