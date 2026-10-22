package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0013H\u0086\b¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\nJ\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0004\u001a\u00060\u0001j\u0002`\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/Latch;", "", "<init>", "()V", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "awaiters", "", "Lkotlin/coroutines/Continuation;", "", "spareList", "_isOpen", "", "isOpen", "()Z", "withClosed", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "closeLatch", "openLatch", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Latch {
    public static final int $stable = 8;
    private boolean _isOpen;
    private List<Continuation<Unit>> awaiters;
    private final Object lock;
    private List<Continuation<Unit>> spareList;

    public final void closeLatch() {
        Object r100 = this.lock;
        monitor-enter(r100);
        this._isOpen = false;     // Catch: Throwable -> L8
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r100);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final boolean isOpen() {
        Object r100 = this.lock;
        monitor-enter(r100);
        boolean r101 = this._isOpen;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final void openLatch() {
        Object r100 = this.lock;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isOpen() == false) goto L8;
        monitor-exit(r100);
        return;
    L8:
        List<Continuation<Unit>> r101 = this.awaiters;     // Catch: Throwable -> L14
        this.awaiters = this.spareList;     // Catch: Throwable -> L14
        this.spareList = r101;     // Catch: Throwable -> L14
        this._isOpen = true;     // Catch: Throwable -> L14
        int r102 = r101.size();     // Catch: Throwable -> L14
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L11;
        Continuation<Unit> r104 = r101.get(r103);     // Catch: Throwable -> L14
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L14
        r104.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));     // Catch: Throwable -> L14
        r103 = r103 + 1;     // Catch: Throwable -> L14
        goto L9
    L11:
        r101.clear();     // Catch: Throwable -> L14
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L14
        monitor-exit(r100);
    }

    public Latch() {
        this.lock = new Object();
        this.awaiters = new ArrayList();
        this.spareList = new ArrayList();
        this._isOpen = true;
    }

    public static final /* synthetic */ List access$getAwaiters$p(Latch r100) {
        return r100.awaiters;
    }

    public static final /* synthetic */ Object access$getLock$p(Latch r100) {
        return r100.lock;
    }

    public final Object await(Continuation<? super Unit> r100) {
        if (isOpen() == true) goto L5;
        final kotlinx.coroutines.j r101 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r101.C();
        Object r102 = access$getLock$p(this);
        monitor-enter(r102);
        access$getAwaiters$p(this).add(r101);     // Catch: Throwable -> L18
        monitor-exit(r102);
        r101.i(new Latch$await$2$2(this, r101));
        Object r103 = r101.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L14:
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r103;
    L17:
        return Unit.INSTANCE;
    L18:
        th = move-exception;
        throw th;
    L5:
        return Unit.INSTANCE;
    }

    public final <R> R withClosed(Function0<? extends R> r100) {
        closeLatch();
        R r101 = r100.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        openLatch();
        InlineMarker.finallyEnd(1);
        return r101;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        openLatch();
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
