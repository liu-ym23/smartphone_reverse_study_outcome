package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ThreadContextKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f21572a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function2 f21573b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Function2 f21574c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Function2 f21575d = null;

    static {
        f21572a = new b0("NO_THREAD_ELEMENTS");
        f21573b = ThreadContextKt$countAll$1.INSTANCE;
        f21574c = ThreadContextKt$findOne$1.INSTANCE;
        f21575d = ThreadContextKt$updateState$1.INSTANCE;
    }

    public static final void a(CoroutineContext r10, Object r11) {
        if (r11 != f21572a) goto L6;
        return;
    L6:
        if ((r11 instanceof j0) == false) goto L8;
        ((j0) r11).b(r10);
        return;
    L8:
        Object r12 = r10.fold(null, f21574c);
        kotlin.jvm.internal.q.e(r12, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((ThreadContextElement) r12).restoreThreadContext(r10, r11);
    }

    public static final Object b(CoroutineContext r10) {
        Object r11 = r10.fold(0, f21573b);
        kotlin.jvm.internal.q.d(r11);
        return r11;
    }

    public static final Object c(CoroutineContext r10, Object r11) {
        if (r11 != null) goto L5;
        r11 = b(r10);
    L5:
        if (r11 != 0) goto L8;
        return f21572a;
    L8:
        if ((r11 instanceof Integer) == true) goto L13;
        kotlin.jvm.internal.q.e(r11, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((ThreadContextElement) r11).updateThreadContext(r10);
    L13:
        return r10.fold(new j0(r10, ((Number) r11).intValue()), f21575d);
    }
}
