package androidx.lifecycle;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class H {

    /* renamed from: a, reason: collision with root package name */
    public EnumC0327y f3867a;

    /* renamed from: b, reason: collision with root package name */
    public E f3868b;

    public final void a(G g4, EnumC0326x event) {
        Intrinsics.checkNotNullParameter(event, "event");
        EnumC0327y enumC0327yA = event.a();
        EnumC0327y state1 = this.f3867a;
        Intrinsics.checkNotNullParameter(state1, "state1");
        if (enumC0327yA.compareTo(state1) < 0) {
            state1 = enumC0327yA;
        }
        this.f3867a = state1;
        Intrinsics.checkNotNull(g4);
        this.f3868b.a(g4, event);
        this.f3867a = enumC0327yA;
    }
}
