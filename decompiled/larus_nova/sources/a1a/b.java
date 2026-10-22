package a1a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateFlowImpl f1402a;

    public final n0a.a a() {
        return (n0a.a) this.f1402a.getValue();
    }

    public b() {
        this.f1402a = j1.a(new n0a.a(0));
    }

    public final void b(Function1<? super n0a.a, n0a.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "transform");
        StateFlowImpl r101 = this.f1402a;
    L3:
        Object r102 = r101.getValue();
        if (r101.compareAndSet(r102, r100.invoke((n0a.a) r102)) == false) goto L3;
    }

    public final void update(Function1<? super n0a.a, n0a.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "transform");
        StateFlowImpl r101 = this.f1402a;
    L3:
        Object r102 = r101.getValue();
        if (r101.compareAndSet(r102, r100.invoke((n0a.a) r102)) == false) goto L3;
    }
}
