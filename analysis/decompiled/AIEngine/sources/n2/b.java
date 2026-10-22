package n2;

import androidx.work.impl.constraints.controllers.BaseConstraintController;
import q2.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends BaseConstraintController<Boolean> {

    /* renamed from: b, reason: collision with root package name */
    public final int f10601b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(o2.c tracker) {
        super(tracker);
        kotlin.jvm.internal.g.f(tracker, "tracker");
        this.f10601b = 5;
    }

    @Override // n2.c
    public final boolean b(p workSpec) {
        kotlin.jvm.internal.g.f(workSpec, "workSpec");
        return workSpec.f11513j.f9260e;
    }

    @Override // androidx.work.impl.constraints.controllers.BaseConstraintController
    public final int d() {
        return this.f10601b;
    }

    @Override // androidx.work.impl.constraints.controllers.BaseConstraintController
    public final boolean e(Boolean bool) {
        return !bool.booleanValue();
    }
}
