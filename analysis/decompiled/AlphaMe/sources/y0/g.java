package y0;

import B0.r;
import kotlin.jvm.internal.Intrinsics;
import s0.t;
import s0.u;
import z0.AbstractC0998f;

/* loaded from: classes.dex */
public final class g extends d {

    /* renamed from: b, reason: collision with root package name */
    public final int f16173b;

    static {
        Intrinsics.checkNotNullExpressionValue(t.f("NetworkNotRoamingCtrlr"), "tagWithPrefix(\"NetworkNotRoamingCtrlr\")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(AbstractC0998f tracker) {
        super(tracker);
        Intrinsics.checkNotNullParameter(tracker, "tracker");
        this.f16173b = 7;
    }

    @Override // y0.d
    public final int a() {
        return this.f16173b;
    }

    @Override // y0.d
    public final boolean b(r workSpec) {
        Intrinsics.checkNotNullParameter(workSpec, "workSpec");
        return workSpec.f176j.f14185a == u.f14217d;
    }

    @Override // y0.d
    public final boolean c(Object obj) {
        x0.d value = (x0.d) obj;
        Intrinsics.checkNotNullParameter(value, "value");
        return (value.f15871a && value.f15874d) ? false : true;
    }
}
