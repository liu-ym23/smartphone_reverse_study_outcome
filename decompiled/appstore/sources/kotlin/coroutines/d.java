package kotlin.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements Continuation, CoroutineStackFrame {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f21118b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f21119c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Continuation f21120a;

    @Nullable
    private volatile Object result;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        f21118b = new a(null);
        f21119c = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "result");
    }

    public d(Continuation r10, Object r11) {
        q.g(r10, "delegate");
        this.f21120a = r10;
        this.result = r11;
    }

    public final Object a() {
        Object r10 = this.result;
        CoroutineSingletons r11 = CoroutineSingletons.UNDECIDED;
        if (r10 != r11) goto L10;
        if (androidx.concurrent.futures.a.a(f21119c, this, r11, kotlin.coroutines.intrinsics.a.d()) == true) goto L7;
        r10 = this.result;
        goto L10
    L7:
        return kotlin.coroutines.intrinsics.a.d();
    L10:
        if (r10 != CoroutineSingletons.RESUMED) goto L13;
        return kotlin.coroutines.intrinsics.a.d();
    L13:
        if ((r10 instanceof Result.Failure) == true) goto L16;
        return r10;
    L16:
        throw ((Result.Failure) r10).exception;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation r10 = this.f21120a;
        if ((r10 instanceof CoroutineStackFrame) == true) goto L7;
        return null;
    L7:
        return (CoroutineStackFrame) r10;
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.f21120a.getContext();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object r10) {
    L2:
        Object r11 = this.result;
        CoroutineSingletons r12 = CoroutineSingletons.UNDECIDED;
        if (r11 == r12) goto L5;
        if (r11 != kotlin.coroutines.intrinsics.a.d()) goto L14;
        if (androidx.concurrent.futures.a.a(f21119c, this, kotlin.coroutines.intrinsics.a.d(), CoroutineSingletons.RESUMED) == false) goto L2;
        this.f21120a.resumeWith(r10);
        return;
    L14:
        throw new IllegalStateException("Already resumed");
    L5:
        if (androidx.concurrent.futures.a.a(f21119c, this, r12, r10) == false) goto L2;
    }

    public String toString() {
        return "SafeContinuation for " + this.f21120a;
    }

    public d(Continuation r10) {
        q.g(r10, "delegate");
        this(r10, CoroutineSingletons.UNDECIDED);
    }
}
