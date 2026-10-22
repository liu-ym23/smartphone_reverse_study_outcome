package d3;

import Z2.F0;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class B {

    /* renamed from: a, reason: collision with root package name */
    public static final X.r f12433a = new X.r("NO_THREAD_ELEMENTS", 4);

    /* renamed from: b, reason: collision with root package name */
    public static final y f12434b = y.f12484a;

    /* renamed from: c, reason: collision with root package name */
    public static final z f12435c = z.f12485a;

    /* renamed from: d, reason: collision with root package name */
    public static final C0538A f12436d = C0538A.f12432a;

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj == f12433a) {
            return;
        }
        if (!(obj instanceof D)) {
            Object objFold = coroutineContext.fold(null, f12435c);
            Intrinsics.checkNotNull(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
            B0.g.y(objFold);
            throw null;
        }
        D d4 = (D) obj;
        F0[] f0Arr = d4.f12441c;
        int length = f0Arr.length - 1;
        if (length < 0) {
            return;
        }
        F0 f02 = f0Arr[length];
        Intrinsics.checkNotNull(null);
        Object obj2 = d4.f12440b[length];
        throw null;
    }

    public static final Object b(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = coroutineContext.fold(0, f12434b);
            Intrinsics.checkNotNull(obj);
        }
        if (obj == 0) {
            return f12433a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new D(coroutineContext, ((Number) obj).intValue()), f12436d);
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        B0.g.y(obj);
        throw null;
    }
}
