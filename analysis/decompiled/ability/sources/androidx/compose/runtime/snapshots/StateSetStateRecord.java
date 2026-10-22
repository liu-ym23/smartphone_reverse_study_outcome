package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\b\u0000\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u000e\u001a\u00020\u00022\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u0010R(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Landroidx/compose/runtime/snapshots/StateSetStateRecord;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/snapshots/StateRecord;", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "set", AppAgent.CONSTRUCT, "(JLandroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;)V", "value", "LC7/r;", "assign", "(Landroidx/compose/runtime/snapshots/StateRecord;)V", "create", "()Landroidx/compose/runtime/snapshots/StateRecord;", "(J)Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "getSet$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "setSet$runtime", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;)V", "", "modification", "I", "getModification$runtime", "()I", "setModification$runtime", "(I)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StateSetStateRecord<T> extends StateRecord {
    public static final int $stable = 8;
    private int modification;
    private PersistentSet<? extends T> set;

    public StateSetStateRecord(long j5, PersistentSet<? extends T> persistentSet) {
        super(j5);
        this.set = persistentSet;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public void assign(StateRecord value) {
        synchronized (SnapshotStateSetKt.sync) {
            k.d(value, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.StateSetStateRecord>");
            this.set = ((StateSetStateRecord) value).set;
            this.modification = ((StateSetStateRecord) value).modification;
        }
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public StateRecord create() {
        return new StateSetStateRecord(SnapshotKt.currentSnapshot().getSnapshotId(), this.set);
    }

    /* renamed from: getModification$runtime, reason: from getter */
    public final int getModification() {
        return this.modification;
    }

    public final PersistentSet<T> getSet$runtime() {
        return this.set;
    }

    public final void setModification$runtime(int i) {
        this.modification = i;
    }

    public final void setSet$runtime(PersistentSet<? extends T> persistentSet) {
        this.set = persistentSet;
    }

    @Override // androidx.compose.runtime.snapshots.StateRecord
    public StateRecord create(long snapshotId) {
        return new StateSetStateRecord(snapshotId, this.set);
    }
}
