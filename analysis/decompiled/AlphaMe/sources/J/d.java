package J;

import kotlin.jvm.internal.Intrinsics;
import t.f;

/* loaded from: classes.dex */
public final class d extends f {

    /* renamed from: d, reason: collision with root package name */
    public final Object f850d;

    public d() {
        super(12, 1);
        this.f850d = new Object();
    }

    @Override // t.f, J.c
    public final boolean a(Object instance) {
        boolean zA;
        Intrinsics.checkNotNullParameter(instance, "instance");
        synchronized (this.f850d) {
            zA = super.a(instance);
        }
        return zA;
    }

    @Override // t.f, J.c
    public final Object b() {
        Object objB;
        synchronized (this.f850d) {
            objB = super.b();
        }
        return objB;
    }
}
