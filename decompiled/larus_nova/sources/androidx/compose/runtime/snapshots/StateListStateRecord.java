package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\b\u0000\u0012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\u0019\u0010\u001a\u001a\u00020\u00022\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\u0016¢\u0006\u0002\u0010\u001bR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u001c"}, d2 = {"Landroidx/compose/runtime/snapshots/StateListStateRecord;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/snapshots/StateRecord;", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "list", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "<init>", "(JLandroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "getList$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "setList$runtime", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "modification", "", "getModification$runtime", "()I", "setModification$runtime", "(I)V", "structuralChange", "getStructuralChange$runtime", "setStructuralChange$runtime", "assign", "", "value", "create", "(J)Landroidx/compose/runtime/snapshots/StateRecord;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class StateListStateRecord<T> extends StateRecord {
    public static final int $stable = 8;
    private PersistentList<? extends T> list;
    private int modification;
    private int structuralChange;

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public StateRecord create() {
        return create(SnapshotKt.currentSnapshot().getSnapshotId());
    }

    public final PersistentList<T> getList$runtime() {
        return this.list;
    }

    public final int getModification$runtime() {
        return this.modification;
    }

    public final int getStructuralChange$runtime() {
        return this.structuralChange;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public void assign(StateRecord r100) {
        Object r101 = SnapshotStateListKt.access$getSync$p();
        monitor-enter(r101);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.StateListStateRecord>");     // Catch: Throwable -> L7
        this.list = ((StateListStateRecord) r100).list;     // Catch: Throwable -> L7
        this.modification = ((StateListStateRecord) r100).modification;     // Catch: Throwable -> L7
        this.structuralChange = ((StateListStateRecord) r100).structuralChange;     // Catch: Throwable -> L7
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public StateRecord create(long r100) {
        return new StateListStateRecord(r100, this.list);
    }

    public final void setList$runtime(PersistentList<? extends T> r100) {
        this.list = r100;
    }

    public final void setModification$runtime(int r100) {
        this.modification = r100;
    }

    public final void setStructuralChange$runtime(int r100) {
        this.structuralChange = r100;
    }

    public StateListStateRecord(long r100, PersistentList<? extends T> r101) {
        super(r100);
        this.list = r101;
    }
}
