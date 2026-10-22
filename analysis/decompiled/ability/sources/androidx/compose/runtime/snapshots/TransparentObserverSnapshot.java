package androidx.compose.runtime.snapshots;

import S7.k;
import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.internal.Thread_jvmKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0001\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0010¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0016\u001a\u00020\u00012\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0005H\u0010¢\u0006\u0004\b\u0018\u0010\rJ\u0017\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u001f\u0010\u001dR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010!R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\"R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\"R0\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0010@\u0010X\u0090\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0010X\u0090\u0004¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010%R\u001a\u0010+\u001a\u00020*8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u0010!\u001a\u0004\b0\u00101R\u0014\u00103\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u00101R,\u00109\u001a\u00060*j\u0002`42\n\u00105\u001a\u00060*j\u0002`48V@PX\u0096\u000e¢\u0006\f\u001a\u0004\b6\u0010.\"\u0004\b7\u00108R$\u0010?\u001a\u00020:2\u0006\u00105\u001a\u00020:8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R4\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010@2\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010@8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0014\u0010G\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u000f¨\u0006H"}, d2 = {"Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "parentSnapshot", "Lkotlin/Function1;", "", "LC7/r;", "specifiedReadObserver", "", "mergeParentObservers", "ownsParentSnapshot", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/snapshots/Snapshot;LS7/k;ZZ)V", "dispose", "()V", "hasPendingChanges", "()Z", "Landroidx/compose/runtime/snapshots/StateObject;", "state", "recordModified$runtime", "(Landroidx/compose/runtime/snapshots/StateObject;)V", "recordModified", "readObserver", "takeNestedSnapshot", "(LS7/k;)Landroidx/compose/runtime/snapshots/Snapshot;", "notifyObjectsInitialized$runtime", "notifyObjectsInitialized", RequestInfo.FUNCTION_SNAPSHOT, "", "nestedActivated$runtime", "(Landroidx/compose/runtime/snapshots/Snapshot;)Ljava/lang/Void;", "nestedActivated", "nestedDeactivated$runtime", "nestedDeactivated", "Landroidx/compose/runtime/snapshots/Snapshot;", "Z", "LS7/k;", "getReadObserver$runtime", "()LS7/k;", "setReadObserver$runtime", "(LS7/k;)V", "writeObserver", "getWriteObserver$runtime", "", "threadId", "J", "getThreadId$runtime", "()J", "root", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "getCurrentSnapshot", "currentSnapshot", "Landroidx/compose/runtime/snapshots/SnapshotId;", "value", "getSnapshotId", "setSnapshotId$runtime", "(J)V", "snapshotId", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getInvalid$runtime", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "invalid", "Landroidx/collection/MutableScatterSet;", "getModified$runtime", "()Landroidx/collection/MutableScatterSet;", "setModified$runtime", "(Landroidx/collection/MutableScatterSet;)V", "modified", "getReadOnly", "readOnly", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransparentObserverSnapshot extends Snapshot {
    public static final int $stable = 8;
    private final boolean mergeParentObservers;
    private final boolean ownsParentSnapshot;
    private final Snapshot parentSnapshot;
    private k readObserver;
    private final Snapshot root;
    private final long threadId;
    private final k writeObserver;

    public TransparentObserverSnapshot(Snapshot snapshot, k kVar, boolean z10, boolean z11) {
        k readObserver;
        super(SnapshotKt.INVALID_SNAPSHOT, SnapshotIdSet.INSTANCE.getEMPTY(), (kotlin.jvm.internal.e) null);
        this.parentSnapshot = snapshot;
        this.mergeParentObservers = z10;
        this.ownsParentSnapshot = z11;
        this.readObserver = SnapshotKt.mergedReadObserver(kVar, (snapshot == null || (readObserver = snapshot.getReadObserver()) == null) ? SnapshotKt.globalSnapshot.getReadObserver() : readObserver, z10);
        this.threadId = Thread_jvmKt.currentThreadId();
        this.root = this;
    }

    private final Snapshot getCurrentSnapshot() {
        Snapshot snapshot = this.parentSnapshot;
        return snapshot == null ? SnapshotKt.globalSnapshot : snapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        Snapshot snapshot;
        setDisposed$runtime(true);
        if (!this.ownsParentSnapshot || (snapshot = this.parentSnapshot) == null) {
            return;
        }
        snapshot.dispose();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getInvalid$runtime */
    public SnapshotIdSet getInvalid() {
        return getCurrentSnapshot().getInvalid();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public MutableScatterSet<StateObject> getModified$runtime() {
        return getCurrentSnapshot().getModified$runtime();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getReadObserver$runtime, reason: from getter */
    public k getReadObserver() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return getCurrentSnapshot().getReadOnly();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this.root;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public long getSnapshotId() {
        return getCurrentSnapshot().getSnapshotId();
    }

    /* renamed from: getThreadId$runtime, reason: from getter */
    public final long getThreadId() {
        return this.threadId;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getWriteObserver$runtime, reason: from getter */
    public k getWriteObserver() {
        return this.writeObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        return getCurrentSnapshot().hasPendingChanges();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedActivated$runtime, reason: merged with bridge method [inline-methods] */
    public Void mo3594nestedActivated$runtime(Snapshot snapshot) {
        throw androidx.compose.foundation.b.w();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedDeactivated$runtime, reason: merged with bridge method [inline-methods] */
    public Void mo3595nestedDeactivated$runtime(Snapshot snapshot) {
        throw androidx.compose.foundation.b.w();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime() {
        getCurrentSnapshot().notifyObjectsInitialized$runtime();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime */
    public void mo3596recordModified$runtime(StateObject state) {
        getCurrentSnapshot().mo3596recordModified$runtime(state);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setInvalid$runtime(SnapshotIdSet snapshotIdSet) {
        throw androidx.compose.foundation.b.w();
    }

    public void setModified$runtime(MutableScatterSet<StateObject> mutableScatterSet) {
        throw androidx.compose.foundation.b.w();
    }

    public void setReadObserver$runtime(k kVar) {
        this.readObserver = kVar;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setSnapshotId$runtime(long j5) {
        throw androidx.compose.foundation.b.w();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(k readObserver) {
        k kVarMergedReadObserver$default = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver(), false, 4, null);
        return !this.mergeParentObservers ? SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(getCurrentSnapshot().takeNestedSnapshot(null), kVarMergedReadObserver$default, true) : getCurrentSnapshot().takeNestedSnapshot(kVarMergedReadObserver$default);
    }
}
