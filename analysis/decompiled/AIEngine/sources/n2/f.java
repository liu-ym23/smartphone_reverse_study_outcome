package n2;

import androidx.work.NetworkType;
import androidx.work.impl.constraints.controllers.BaseConstraintController;
import h2.j;
import q2.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends BaseConstraintController<m2.b> {

    /* renamed from: b, reason: collision with root package name */
    public final int f10604b;

    static {
        kotlin.jvm.internal.g.e(j.f("NetworkNotRoamingCtrlr"), "tagWithPrefix(\"NetworkNotRoamingCtrlr\")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(o2.g<m2.b> tracker) {
        super(tracker);
        kotlin.jvm.internal.g.f(tracker, "tracker");
        this.f10604b = 7;
    }

    @Override // n2.c
    public final boolean b(p workSpec) {
        kotlin.jvm.internal.g.f(workSpec, "workSpec");
        return workSpec.f11513j.f9256a == NetworkType.f2786d;
    }

    @Override // androidx.work.impl.constraints.controllers.BaseConstraintController
    public final int d() {
        return this.f10604b;
    }

    @Override // androidx.work.impl.constraints.controllers.BaseConstraintController
    public final boolean e(m2.b bVar) {
        m2.b value = bVar;
        kotlin.jvm.internal.g.f(value, "value");
        return (value.f10480a && value.f10483d) ? false : true;
    }
}
