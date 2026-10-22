package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m extends l implements o {

    /* renamed from: a, reason: collision with root package name */
    public final Lifecycle f2285a;

    /* renamed from: b, reason: collision with root package name */
    public final kotlin.coroutines.d f2286b;

    public m(Lifecycle lifecycle, kotlin.coroutines.d coroutineContext) {
        kotlin.jvm.internal.g.f(coroutineContext, "coroutineContext");
        this.f2285a = lifecycle;
        this.f2286b = coroutineContext;
        if (lifecycle.b() == Lifecycle.State.f2214a) {
            JobKt__JobKt.cancel$default(coroutineContext, null, 1, null);
        }
    }

    @Override // androidx.lifecycle.o
    public final void a(q qVar, Lifecycle.Event event) {
        Lifecycle lifecycle = this.f2285a;
        if (lifecycle.b().compareTo(Lifecycle.State.f2214a) <= 0) {
            lifecycle.c(this);
            JobKt__JobKt.cancel$default(this.f2286b, null, 1, null);
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final kotlin.coroutines.d getCoroutineContext() {
        return this.f2286b;
    }
}
