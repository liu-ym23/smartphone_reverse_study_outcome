package a1a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import m0a.f;

/* JADX INFO: loaded from: classes31.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateFlowImpl f1401a;

    public a() {
        this.f1401a = j1.a(new f(0));
    }

    public final void update(Function1<? super f, f> r100) {
        Intrinsics.checkNotNullParameter(r100, "transform");
        StateFlowImpl r101 = this.f1401a;
    L3:
        Object r102 = r101.getValue();
        if (r101.compareAndSet(r102, r100.invoke((f) r102)) == false) goto L3;
    }
}
