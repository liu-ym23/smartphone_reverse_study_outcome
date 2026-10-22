package androidx.compose.runtime.snapshots;

import S7.k;
import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.internal.Thread_jvmKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0010¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u001b\u001a\u00020\u001a2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ;\u0010\u001e\u001a\u00020\u00012\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020\u0005H\u0010¢\u0006\u0004\b \u0010\u000eJ\u0017\u0010&\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u001aH\u0010¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u001aH\u0010¢\u0006\u0004\b'\u0010%R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010)R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010*R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010*R0\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0010@\u0010X\u0090\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R0\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0010@\u0010X\u0090\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010+\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R\u001a\u00103\u001a\u0002028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0014\u00109\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R,\u0010?\u001a\u000602j\u0002`:2\n\u0010;\u001a\u000602j\u0002`:8V@PX\u0096\u000e¢\u0006\f\u001a\u0004\b<\u00106\"\u0004\b=\u0010>R$\u0010E\u001a\u00020@2\u0006\u0010;\u001a\u00020@8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR4\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010F2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010F8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010Q\u001a\u00020L2\u0006\u0010;\u001a\u00020L8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u0014\u0010S\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010\u0010¨\u0006T"}, d2 = {"Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "parentSnapshot", "Lkotlin/Function1;", "", "LC7/r;", "specifiedReadObserver", "specifiedWriteObserver", "", "mergeParentObservers", "ownsParentSnapshot", AppAgent.CONSTRUCT, "(Landroidx/compose/runtime/snapshots/MutableSnapshot;LS7/k;LS7/k;ZZ)V", "dispose", "()V", "hasPendingChanges", "()Z", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "apply", "()Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "Landroidx/compose/runtime/snapshots/StateObject;", "state", "recordModified$runtime", "(Landroidx/compose/runtime/snapshots/StateObject;)V", "recordModified", "readObserver", "Landroidx/compose/runtime/snapshots/Snapshot;", "takeNestedSnapshot", "(LS7/k;)Landroidx/compose/runtime/snapshots/Snapshot;", "writeObserver", "takeNestedMutableSnapshot", "(LS7/k;LS7/k;)Landroidx/compose/runtime/snapshots/MutableSnapshot;", "notifyObjectsInitialized$runtime", "notifyObjectsInitialized", RequestInfo.FUNCTION_SNAPSHOT, "", "nestedActivated$runtime", "(Landroidx/compose/runtime/snapshots/Snapshot;)Ljava/lang/Void;", "nestedActivated", "nestedDeactivated$runtime", "nestedDeactivated", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Z", "LS7/k;", "getReadObserver$runtime", "()LS7/k;", "setReadObserver$runtime", "(LS7/k;)V", "getWriteObserver$runtime", "setWriteObserver$runtime", "", "threadId", "J", "getThreadId$runtime", "()J", "getCurrentSnapshot", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", "currentSnapshot", "Landroidx/compose/runtime/snapshots/SnapshotId;", "value", "getSnapshotId", "setSnapshotId$runtime", "(J)V", "snapshotId", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getInvalid$runtime", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "invalid", "Landroidx/collection/MutableScatterSet;", "getModified$runtime", "()Landroidx/collection/MutableScatterSet;", "setModified$runtime", "(Landroidx/collection/MutableScatterSet;)V", "modified", "", "getWriteCount$runtime", "()I", "setWriteCount$runtime", "(I)V", "writeCount", "getReadOnly", "readOnly", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransparentObserverMutableSnapshot extends MutableSnapshot {
    public static final int $stable = 8;
    private final boolean mergeParentObservers;
    private final boolean ownsParentSnapshot;
    private final MutableSnapshot parentSnapshot;
    private k readObserver;
    private final long threadId;
    private k writeObserver;

    public TransparentObserverMutableSnapshot(MutableSnapshot mutableSnapshot, k kVar, k kVar2, boolean z10, boolean z11) {
        k writeObserver;
        k readObserver;
        super(SnapshotKt.INVALID_SNAPSHOT, SnapshotIdSet.INSTANCE.getEMPTY(), SnapshotKt.mergedReadObserver(kVar, (mutableSnapshot == null || (readObserver = mutableSnapshot.getReadObserver()) == null) ? SnapshotKt.globalSnapshot.getReadObserver() : readObserver, z10), SnapshotKt.mergedWriteObserver(kVar2, (mutableSnapshot == null || (writeObserver = mutableSnapshot.getWriteObserver()) == null) ? SnapshotKt.globalSnapshot.getWriteObserver() : writeObserver));
        this.parentSnapshot = mutableSnapshot;
        this.mergeParentObservers = z10;
        this.ownsParentSnapshot = z11;
        this.readObserver = super.getReadObserver();
        this.writeObserver = super.getWriteObserver();
        this.threadId = Thread_jvmKt.currentThreadId();
    }

    private final MutableSnapshot getCurrentSnapshot() {
        MutableSnapshot mutableSnapshot = this.parentSnapshot;
        return mutableSnapshot == null ? SnapshotKt.globalSnapshot : mutableSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public SnapshotApplyResult apply() {
        return getCurrentSnapshot().apply();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        MutableSnapshot mutableSnapshot;
        setDisposed$runtime(true);
        if (!this.ownsParentSnapshot || (mutableSnapshot = this.parentSnapshot) == null) {
            return;
        }
        mutableSnapshot.dispose();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getInvalid$runtime */
    public SnapshotIdSet getInvalid() {
        return getCurrentSnapshot().getInvalid();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public MutableScatterSet<StateObject> getModified$runtime() {
        return getCurrentSnapshot().getModified$runtime();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getReadObserver$runtime, reason: from getter */
    public k getReadObserver() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return getCurrentSnapshot().getReadOnly();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public long getSnapshotId() {
        return getCurrentSnapshot().getSnapshotId();
    }

    /* renamed from: getThreadId$runtime, reason: from getter */
    public final long getThreadId() {
        return this.threadId;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getWriteCount$runtime */
    public int getWriteCount() {
        return getCurrentSnapshot().getWriteCount();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getWriteObserver$runtime, reason: from getter */
    public k getWriteObserver() {
        return this.writeObserver;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        return getCurrentSnapshot().hasPendingChanges();
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
        getCurrentSnapshot().notifyObjectsInitialized$runtime();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime */
    public void mo3596recordModified$runtime(StateObject state) {
        getCurrentSnapshot().mo3596recordModified$runtime(state);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setInvalid$runtime(SnapshotIdSet snapshotIdSet) {
        throw androidx.compose.foundation.b.w();
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
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

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime(int i) {
        getCurrentSnapshot().setWriteCount$runtime(i);
    }

    public void setWriteObserver$runtime(k kVar) {
        this.writeObserver = kVar;
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    public MutableSnapshot takeNestedMutableSnapshot(k readObserver, k writeObserver) {
        k kVarMergedReadObserver$default = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver(), false, 4, null);
        k kVarMergedWriteObserver = SnapshotKt.mergedWriteObserver(writeObserver, getWriteObserver());
        return !this.mergeParentObservers ? new TransparentObserverMutableSnapshot(getCurrentSnapshot().takeNestedMutableSnapshot(null, kVarMergedWriteObserver), kVarMergedReadObserver$default, kVarMergedWriteObserver, false, true) : getCurrentSnapshot().takeNestedMutableSnapshot(kVarMergedReadObserver$default, kVarMergedWriteObserver);
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(k readObserver) {
        k kVarMergedReadObserver$default = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver(), false, 4, null);
        return !this.mergeParentObservers ? SnapshotKt.createTransparentSnapshotWithNoParentReadObserver(getCurrentSnapshot().takeNestedSnapshot(null), kVarMergedReadObserver$default, true) : getCurrentSnapshot().takeNestedSnapshot(kVarMergedReadObserver$default);
    }
}
