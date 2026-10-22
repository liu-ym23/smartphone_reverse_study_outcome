package androidx.lifecycle;

import kotlinx.coroutines.x1;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {
    public static final n a(Lifecycle r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
    L3:
        LifecycleCoroutineScopeImpl r11 = (LifecycleCoroutineScopeImpl) r10.c().get();
        if (r11 != null) goto L5;
        LifecycleCoroutineScopeImpl r12 = new LifecycleCoroutineScopeImpl(r10, x1.b(null, 1, null).plus(kotlinx.coroutines.l0.c().e()));
        if (p.a(r10.c(), null, r12) == false) goto L3;
        r12.b();
        return r12;
    L5:
        return r11;
    }
}
