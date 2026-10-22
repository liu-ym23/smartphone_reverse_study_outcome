package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class g1 extends kotlinx.coroutines.flow.internal.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21518a = null;

    @Volatile
    @Nullable
    private volatile Object _state;

    static {
        f21518a = AtomicReferenceFieldUpdater.newUpdater(g1.class, Object.class, "_state");
    }

    public g1() {
    }

    public static final /* synthetic */ AtomicReferenceFieldUpdater c() {
        return f21518a;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public /* bridge */ /* synthetic */ boolean a(Object r10) {
        return d((StateFlowImpl) r10);
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public /* bridge */ /* synthetic */ Continuation[] b(Object r10) {
        return f((StateFlowImpl) r10);
    }

    public boolean d(StateFlowImpl r10) {
        AtomicReferenceFieldUpdater r11 = f21518a;
        if (r11.get(this) == null) goto L6;
        return false;
    L6:
        r11.set(this, f1.b());
        return true;
    }

    public final Object e(Continuation r10) {
        kotlinx.coroutines.n r11 = new kotlinx.coroutines.n(IntrinsicsKt__IntrinsicsJvmKt.c(r10), 1);
        r11.initCancellability();
        if (androidx.concurrent.futures.a.a(c(), this, f1.b(), r11) == true) goto L5;
        Result.a r12 = Result.Companion;
        r11.resumeWith(Result.m35constructorimpl(Unit.f21064a));
    L5:
        Object r13 = r11.q();
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L9;
        tf.d.c(r10);
    L9:
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L12;
        return r13;
    L12:
        return Unit.f21064a;
    }

    public Continuation[] f(StateFlowImpl r10) {
        f21518a.set(this, null);
        return kotlinx.coroutines.flow.internal.b.f21545a;
    }

    public final void g() {
        AtomicReferenceFieldUpdater r10 = f21518a;
    L3:
        Object r11 = r10.get(this);
        if (r11 == null) goto L5;
        if (r11 == f1.c()) goto L8;
        if (r11 == f1.b()) goto L12;
        if (androidx.concurrent.futures.a.a(f21518a, this, r11, f1.b()) == false) goto L3;
        Result.a r12 = Result.Companion;
        ((kotlinx.coroutines.n) r11).resumeWith(Result.m35constructorimpl(Unit.f21064a));
        return;
    L12:
        if (androidx.concurrent.futures.a.a(f21518a, this, r11, f1.c()) == false) goto L3;
        return;
    L8:
        return;
    }

    public final boolean h() {
        Object r10 = f21518a.getAndSet(this, f1.b());
        kotlin.jvm.internal.q.d(r10);
        if (r10 != f1.c()) goto L5;
        return true;
    L5:
        return false;
    }
}
