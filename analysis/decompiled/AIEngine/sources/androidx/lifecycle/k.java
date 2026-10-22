package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k implements o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Lifecycle f2278a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w1.b f2279b;

    public k(Lifecycle lifecycle, w1.b bVar) {
        this.f2278a = lifecycle;
        this.f2279b = bVar;
    }

    @Override // androidx.lifecycle.o
    public final void a(q qVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_START) {
            this.f2278a.c(this);
            this.f2279b.d();
        }
    }
}
