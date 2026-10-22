package kotlinx.coroutines.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* JADX INFO: loaded from: classes4.dex */
public class x extends kotlinx.coroutines.a implements CoroutineStackFrame {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Continuation f21628d;

    public x(CoroutineContext r10, Continuation r11) {
        super(r10, true, true);
        this.f21628d = r11;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean I() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation r10 = this.f21628d;
        if ((r10 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r10;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void h(Object r10) {
        j.c(IntrinsicsKt__IntrinsicsJvmKt.c(this.f21628d), kotlinx.coroutines.z.a(r10, this.f21628d), null, 2, null);
    }

    @Override // kotlinx.coroutines.a
    public void n0(Object r10) {
        Continuation r11 = this.f21628d;
        r11.resumeWith(kotlinx.coroutines.z.a(r10, r11));
    }
}
