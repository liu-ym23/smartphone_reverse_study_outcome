package n2;

import androidx.work.impl.constraints.controllers.BaseConstraintController;
import q2.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends BaseConstraintController {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10599b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10600c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(o2.g tracker, int i10) {
        super(tracker);
        this.f10599b = i10;
        switch (i10) {
            case 1:
                kotlin.jvm.internal.g.f(tracker, "tracker");
                super(tracker);
                this.f10600c = 9;
                break;
            default:
                kotlin.jvm.internal.g.f(tracker, "tracker");
                this.f10600c = 6;
                break;
        }
    }

    @Override // n2.c
    public final boolean b(p workSpec) {
        switch (this.f10599b) {
            case 0:
                kotlin.jvm.internal.g.f(workSpec, "workSpec");
                return workSpec.f11513j.f9258c;
            default:
                kotlin.jvm.internal.g.f(workSpec, "workSpec");
                return workSpec.f11513j.f9261f;
        }
    }

    @Override // androidx.work.impl.constraints.controllers.BaseConstraintController
    public final int d() {
        switch (this.f10599b) {
        }
        return this.f10600c;
    }

    @Override // androidx.work.impl.constraints.controllers.BaseConstraintController
    public final boolean e(Object obj) {
        boolean zBooleanValue;
        switch (this.f10599b) {
            case 0:
                zBooleanValue = ((Boolean) obj).booleanValue();
                break;
            default:
                zBooleanValue = ((Boolean) obj).booleanValue();
                break;
        }
        return !zBooleanValue;
    }
}
