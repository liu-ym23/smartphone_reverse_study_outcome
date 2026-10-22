package androidx.compose.runtime.snapshots;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.u1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotContextElementImpl;", "Landroidx/compose/runtime/snapshots/SnapshotContextElement;", "Lkotlinx/coroutines/ThreadContextElement;", "Landroidx/compose/runtime/snapshots/Snapshot;", "snapshot", "<init>", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "updateThreadContext", PerfLog.PARAM_KEY_CONTEXT_ID, "Lkotlin/coroutines/CoroutineContext;", "restoreThreadContext", "", "oldState", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SnapshotContextElementImpl implements SnapshotContextElement, u1<Snapshot> {
    public static final int $stable = 8;
    private final Snapshot snapshot;

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key<?> getKey() {
        return SnapshotContextElement.Key;
    }

    public SnapshotContextElementImpl(Snapshot r100) {
        this.snapshot = r100;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r100) {
        return (E) SnapshotContextElement.DefaultImpls.get(this, r100);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> r100) {
        return SnapshotContextElement.DefaultImpls.minusKey(this, r100);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r100) {
        return SnapshotContextElement.DefaultImpls.plus(this, r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.coroutines.u1
    public Snapshot updateThreadContext(CoroutineContext r100) {
        return this.snapshot.unsafeEnter();
    }

    @Override // kotlinx.coroutines.u1
    public /* bridge */ /* synthetic */ Snapshot updateThreadContext(CoroutineContext r100) {
        return updateThreadContext(r100);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r100, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r101) {
        return (R) SnapshotContextElement.DefaultImpls.fold(this, r100, r101);
    }

    /* JADX INFO: renamed from: restoreThreadContext, reason: avoid collision after fix types in other method */
    public void restoreThreadContext2(CoroutineContext r100, Snapshot r101) {
        this.snapshot.unsafeLeave(r101);
    }

    @Override // kotlinx.coroutines.u1
    public /* bridge */ /* synthetic */ void restoreThreadContext(CoroutineContext r100, Snapshot r101) {
        restoreThreadContext2(r100, r101);
    }
}
