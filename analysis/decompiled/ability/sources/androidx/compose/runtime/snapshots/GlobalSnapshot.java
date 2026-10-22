package androidx.compose.runtime.snapshots;

import C7.r;
import S7.k;
import android.view.p;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.tooling.SnapshotInstanceObservers;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserver;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000e\u001a\u00020\r2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0011\u001a\u00020\u00012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u000bH\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\rH\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\rH\u0010¢\u0006\u0004\b\u001b\u0010\u0019J\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u000bH\u0016¢\u0006\u0004\b \u0010\u0014¨\u0006!"}, d2 = {"Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", AppAgent.CONSTRUCT, "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "Lkotlin/Function1;", "", "LC7/r;", "readObserver", "Landroidx/compose/runtime/snapshots/Snapshot;", "takeNestedSnapshot", "(LS7/k;)Landroidx/compose/runtime/snapshots/Snapshot;", "writeObserver", "takeNestedMutableSnapshot", "(LS7/k;LS7/k;)Landroidx/compose/runtime/snapshots/MutableSnapshot;", "notifyObjectsInitialized$runtime", "()V", "notifyObjectsInitialized", RequestInfo.FUNCTION_SNAPSHOT, "", "nestedDeactivated$runtime", "(Landroidx/compose/runtime/snapshots/Snapshot;)Ljava/lang/Void;", "nestedDeactivated", "nestedActivated$runtime", "nestedActivated", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "apply", "()Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "dispose", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GlobalSnapshot extends MutableSnapshot {
    public static final int $stable = 8;

    public GlobalSnapshot(long j5, SnapshotIdSet snapshotIdSet) {
        super(j5, snapshotIdSet, null, new p(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r _init_$lambda$2(Object obj) {
        synchronized (SnapshotKt.getLock()) {
            List list = SnapshotKt.globalWriteObservers;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((k) list.get(i)).invoke(obj);
            }
        }
        return r.f317a;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public SnapshotApplyResult apply() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot");
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        synchronized (SnapshotKt.getLock()) {
            releasePinnedSnapshotLocked$runtime();
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedActivated$runtime, reason: merged with bridge method [inline-methods] */
    public Void mo3594nestedActivated$runtime(Snapshot snapshot) {
        throw androidx.compose.foundation.b.w();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedDeactivated$runtime, reason: merged with bridge method [inline-methods] */
    public Void mo3595nestedDeactivated$runtime(Snapshot snapshot) {
        throw androidx.compose.foundation.b.w();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime() {
        SnapshotKt.advanceGlobalSnapshot();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public MutableSnapshot takeNestedMutableSnapshot(final k readObserver, k writeObserver) {
        final k kVar;
        Map map;
        PersistentList persistentList = SnapshotObserverKt.observers;
        if (persistentList != null) {
            Pair<SnapshotInstanceObservers, Map<SnapshotObserver, SnapshotInstanceObservers>> pairMergeObservers = SnapshotObserverKt.mergeObservers(persistentList, null, false, readObserver, writeObserver);
            SnapshotInstanceObservers snapshotInstanceObservers = (SnapshotInstanceObservers) pairMergeObservers.f4886a;
            k readObserver2 = snapshotInstanceObservers.getReadObserver();
            k writeObserver2 = snapshotInstanceObservers.getWriteObserver();
            map = (Map) pairMergeObservers.b;
            readObserver = readObserver2;
            kVar = writeObserver2;
        } else {
            kVar = writeObserver;
            map = null;
        }
        MutableSnapshot mutableSnapshot = (MutableSnapshot) SnapshotKt.takeNewSnapshot(new k() { // from class: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedMutableSnapshot$1$1
            @Override // S7.k
            public final MutableSnapshot invoke(SnapshotIdSet snapshotIdSet) {
                long j5;
                synchronized (SnapshotKt.getLock()) {
                    j5 = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId++;
                }
                return new MutableSnapshot(j5, snapshotIdSet, readObserver, kVar);
            }
        });
        if (persistentList != null) {
            SnapshotObserverKt.dispatchCreatedObservers(persistentList, null, mutableSnapshot, map);
        }
        return mutableSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(final k readObserver) {
        Map map;
        PersistentList persistentList = SnapshotObserverKt.observers;
        if (persistentList != null) {
            Pair<SnapshotInstanceObservers, Map<SnapshotObserver, SnapshotInstanceObservers>> pairMergeObservers = SnapshotObserverKt.mergeObservers(persistentList, null, true, readObserver, null);
            SnapshotInstanceObservers snapshotInstanceObservers = (SnapshotInstanceObservers) pairMergeObservers.f4886a;
            k readObserver2 = snapshotInstanceObservers.getReadObserver();
            snapshotInstanceObservers.getWriteObserver();
            map = (Map) pairMergeObservers.b;
            readObserver = readObserver2;
        } else {
            map = null;
        }
        ReadonlySnapshot readonlySnapshot = (ReadonlySnapshot) SnapshotKt.takeNewSnapshot(new k() { // from class: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedSnapshot$1$1
            @Override // S7.k
            public final ReadonlySnapshot invoke(SnapshotIdSet snapshotIdSet) {
                long j5;
                synchronized (SnapshotKt.getLock()) {
                    j5 = SnapshotKt.nextSnapshotId;
                    SnapshotKt.nextSnapshotId++;
                }
                return new ReadonlySnapshot(j5, snapshotIdSet, readObserver);
            }
        });
        if (persistentList != null) {
            SnapshotObserverKt.dispatchCreatedObservers(persistentList, null, readonlySnapshot, map);
        }
        return readonlySnapshot;
    }
}
