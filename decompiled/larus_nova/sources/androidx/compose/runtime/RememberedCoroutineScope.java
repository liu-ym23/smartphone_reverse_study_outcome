package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionErrorContextImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00060\tj\u0002`\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/RememberedCoroutineScope;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/RememberObserver;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "overlayContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;)V", "lock", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "_coroutineContext", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "cancelIfCreated", "", "onRemembered", "onForgotten", "onAbandoned", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RememberedCoroutineScope implements CoroutineScope, RememberObserver {
    public static final int $stable = 0;
    public static final CoroutineContext CancelledCoroutineContext = null;
    public static final Companion Companion = null;
    private volatile CoroutineContext _coroutineContext;
    private final Object lock;
    private final CoroutineContext overlayContext;
    private final CoroutineContext parentContext;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/RememberedCoroutineScope$Companion;", "", "<init>", "()V", "CancelledCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        CancelledCoroutineContext = new CancelledCoroutineContext();
    }

    public final void cancelIfCreated() {
        Object r100 = this.lock;
        monitor-enter(r100);
        CoroutineContext r101 = this._coroutineContext;     // Catch: Throwable -> L11
        if (r101 != null) goto L7;
        this._coroutineContext = CancelledCoroutineContext;     // Catch: Throwable -> L11
    L8:
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r100);
        return;
    L7:
        JobKt.cancel(r101, new ForgottenCoroutineScopeException());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        CoroutineContext r100 = this._coroutineContext;
        if (r100 != null) goto L5;
    L6:
        CompositionErrorContextImpl r101 = (CompositionErrorContextImpl) this.parentContext.get(CompositionErrorContextImpl.Key);
        if (r101 == null) goto L9;
        CoroutineContext r102 = new RememberedCoroutineScope$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, r101, this);
    L10:
        Object r103 = this.lock;
        monitor-enter(r103);
        CoroutineContext r104 = this._coroutineContext;     // Catch: Throwable -> L23
        if (r104 != null) goto L16;
        CoroutineContext r105 = this.parentContext;     // Catch: Throwable -> L23
        r104 = r105.plus(JobKt.Job((Job) r105.get(Job.Key))).plus(this.overlayContext).plus(r102);     // Catch: Throwable -> L23
    L18:
        this._coroutineContext = r104;     // Catch: Throwable -> L23
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r103);
        r100 = r104;
    L21:
        Intrinsics.checkNotNull(r100);
        return r100;
    L16:
        if (r104 != CancelledCoroutineContext) goto L18;
        CoroutineContext r107 = this.parentContext;     // Catch: Throwable -> L23
        CompletableJob r108 = JobKt.Job((Job) r107.get(Job.Key));     // Catch: Throwable -> L23
        r108.cancel(new ForgottenCoroutineScopeException());     // Catch: Throwable -> L23
        r104 = r107.plus(r108).plus(this.overlayContext).plus(r102);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    L9:
        r102 = EmptyCoroutineContext.INSTANCE;
        goto L10
    L5:
        if (r100 != CancelledCoroutineContext) goto L21;
        goto L6
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        cancelIfCreated();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        cancelIfCreated();
    }

    public static final /* synthetic */ CoroutineContext access$getOverlayContext$p(RememberedCoroutineScope r100) {
        return r100.overlayContext;
    }

    public static final /* synthetic */ CoroutineContext access$getParentContext$p(RememberedCoroutineScope r100) {
        return r100.parentContext;
    }

    public RememberedCoroutineScope(CoroutineContext r100, CoroutineContext r101) {
        this.parentContext = r100;
        this.overlayContext = r101;
        this.lock = this;
    }
}
