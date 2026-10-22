package androidx.lifecycle;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class S {

    /* renamed from: a, reason: collision with root package name */
    public final C0314k f3902a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext f3903b;

    public S(C0314k target, CoroutineContext context) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f3902a = target;
        f3.d dVar = Z2.Q.f2189a;
        this.f3903b = context.plus(d3.q.f12477a.getImmediate());
    }
}
