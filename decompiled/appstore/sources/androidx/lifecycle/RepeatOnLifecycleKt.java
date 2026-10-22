package androidx.lifecycle;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
public abstract class RepeatOnLifecycleKt {
    public static final Object a(Lifecycle r10, Lifecycle.State r11, Function2 r12, Continuation r13) {
        if (r11 == Lifecycle.State.INITIALIZED) goto L14;
        if (r10.b() == Lifecycle.State.DESTROYED) goto L7;
        Object r14 = kotlinx.coroutines.d0.e(new RepeatOnLifecycleKt$repeatOnLifecycle$3(r10, r11, r12, null), r13);
        if (r14 != kotlin.coroutines.intrinsics.a.d()) goto L12;
        return r14;
    L12:
        return Unit.f21064a;
    L7:
        return Unit.f21064a;
    L14:
        throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.");
    }

    public static final Object b(LifecycleOwner r10, Lifecycle.State r11, Function2 r12, Continuation r13) {
        Object r14 = a(r10.getLifecycle(), r11, r12, r13);
        if (r14 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r14;
    L6:
        return Unit.f21064a;
    }
}
