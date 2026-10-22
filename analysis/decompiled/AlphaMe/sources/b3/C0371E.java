package b3;

import Z2.C0128h;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import org.jetbrains.annotations.Nullable;

/* renamed from: b3.E, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0371E extends c3.c {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f4385a = AtomicReferenceFieldUpdater.newUpdater(C0371E.class, Object.class, "_state");

    @Volatile
    @Nullable
    private volatile Object _state;

    public final Object a(C0368B c0368b) {
        C0128h c0128h = new C0128h(1, IntrinsicsKt.intercepted(c0368b));
        c0128h.u();
        if (!f4385a.compareAndSet(this, AbstractC0370D.f4383a, c0128h)) {
            Result.Companion companion = Result.INSTANCE;
            c0128h.resumeWith(Result.m22constructorimpl(Unit.INSTANCE));
        }
        Object objT = c0128h.t();
        if (objT == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(c0368b);
        }
        return objT == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objT : Unit.INSTANCE;
    }
}
