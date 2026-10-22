package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.DurationKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.NonDisposableHandle;

/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J\u001c\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010!\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100#H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "cancelOnRejection", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HandlerContext extends HandlerDispatcher implements Delay {
    private volatile HandlerContext _immediate;
    private final Handler handler;
    private final HandlerContext immediate;
    private final boolean invokeImmediately;
    private final String name;

    /* JADX INFO: renamed from: $r8$lambda$uWNO1FUkgOtv52K5-E4QlFYJYR0, reason: not valid java name */
    public static /* synthetic */ void m2319$r8$lambda$uWNO1FUkgOtv52K5E4QlFYJYR0(HandlerContext r0, Runnable r1) {
        invokeOnTimeout$lambda$3(r0, r1);
    }

    public static final /* synthetic */ Handler access$getHandler$p(HandlerContext r0) {
        return r0.handler;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public /* bridge */ /* synthetic */ MainCoroutineDispatcher getImmediate() {
        return getImmediate();
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.MainCoroutineDispatcher
    public /* bridge */ /* synthetic */ HandlerDispatcher getImmediate() {
        return getImmediate();
    }

    private HandlerContext(Handler r2, String r3, boolean r4) {
        HandlerContext r0 = null;
        super(null);
        this.handler = r2;
        this.name = r3;
        this.invokeImmediately = r4;
        if (r4 == false) goto L5;
        r0 = this;
    L5:
        this._immediate = r0;
        HandlerContext r5 = this._immediate;
        if (r5 != null) goto L8;
        r5 = new HandlerContext(r2, r3, true);
        this._immediate = r5;
    L8:
        this.immediate = r5;
    }

    public /* synthetic */ HandlerContext(Handler r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public HandlerContext(Handler r2, String r3) {
        this(r2, r3, false);
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.MainCoroutineDispatcher
    public HandlerContext getImmediate() {
        return this.immediate;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext r1) {
        if (this.invokeImmediately == true) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), this.handler.getLooper()) == false) goto L8;
        return false;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: dispatch */
    public void mo2376dispatch(CoroutineContext r2, Runnable r3) {
        if (this.handler.post(r3) == true) goto L6;
        cancelOnRejection(r2, r3);
        return;
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.Delay
    public DisposableHandle invokeOnTimeout(long r4, final Runnable r6, CoroutineContext r7) {
        if (this.handler.postDelayed(r6, RangesKt.coerceAtMost(r4, DurationKt.MAX_MILLIS)) == true) goto L5;
        cancelOnRejection(r7, r6);
        return NonDisposableHandle.INSTANCE;
    L5:
        return new HandlerContext$$ExternalSyntheticLambda0(this, r6);
    }

    private static final void invokeOnTimeout$lambda$3(HandlerContext r0, Runnable r1) {
        r0.handler.removeCallbacks(r1);
    }

    private final void cancelOnRejection(CoroutineContext r4, Runnable r5) {
        JobKt.cancel(r4, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Dispatchers.getIO().mo2376dispatch(r4, r5);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String r0 = toStringInternalImpl();
        if (r0 != null) goto L11;
        String r1 = this.name;
        if (r1 != null) goto L8;
        r1 = this.handler.toString();
    L8:
        if (this.invokeImmediately == true) goto L10;
        return r1;
    L10:
        return r1 + ".immediate";
    L11:
        return r0;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof HandlerContext) == true) goto L5;
    L7:
        return false;
    L5:
        if (((HandlerContext) r2).handler != this.handler) goto L7;
        return true;
    }

    public int hashCode() {
        return System.identityHashCode(this.handler);
    }

    @Override // kotlinx.coroutines.Delay
    /* JADX INFO: renamed from: scheduleResumeAfterDelay */
    public void mo2377scheduleResumeAfterDelay(long r5, final CancellableContinuation<? super Unit> r7) {
        final Runnable r0 = new HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1(r7, this);
        if (this.handler.postDelayed(r0, RangesKt.coerceAtMost(r5, DurationKt.MAX_MILLIS)) == false) goto L5;
        r7.invokeOnCancellation(new AnonymousClass1(this, r0));
        return;
    L5:
        cancelOnRejection(r7.getContext(), r0);
    }
}
