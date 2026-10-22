package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.a;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import n2.c;
import o2.g;
import q2.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class BaseConstraintController<T> implements c {

    /* renamed from: a, reason: collision with root package name */
    public final g<T> f2933a;

    public BaseConstraintController(g<T> tracker) {
        kotlin.jvm.internal.g.f(tracker, "tracker");
        this.f2933a = tracker;
    }

    @Override // n2.c
    public final boolean a(p pVar) {
        return b(pVar) && e(this.f2933a.a());
    }

    @Override // n2.c
    public final Flow<a> c(h2.c constraints) {
        kotlin.jvm.internal.g.f(constraints, "constraints");
        return FlowKt.callbackFlow(new BaseConstraintController$track$1(this, null));
    }

    public abstract int d();

    public abstract boolean e(T t8);
}
