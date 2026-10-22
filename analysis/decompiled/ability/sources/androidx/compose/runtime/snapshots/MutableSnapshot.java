package androidx.compose.runtime.snapshots;

import D7.v;
import S7.k;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.snapshots.tooling.SnapshotInstanceObservers;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserver;
import androidx.compose.runtime.snapshots.tooling.SnapshotObserverKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u001e\n\u0002\u0010 \n\u0002\b\u001c\b\u0017\u0018\u0000 y2\u00020\u0001:\u0001yBI\b\u0000\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J?\u0010\u0011\u001a\u00020\u00002\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0018\u001a\u00020\u00012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010!\u001a\u00020\tH\u0010¢\u0006\u0004\b \u0010\u0017J\u000f\u0010#\u001a\u00020\tH\u0010¢\u0006\u0004\b\"\u0010\u0017J\u000f\u0010%\u001a\u00020\tH\u0010¢\u0006\u0004\b$\u0010\u0017JG\u00100\u001a\u00020\u00132\n\u0010&\u001a\u00060\u0002j\u0002`\u00032\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+\u0018\u00010*2\u0006\u0010-\u001a\u00020\u0005H\u0000¢\u0006\u0004\b.\u0010/J$\u00106\u001a\u00028\u0000\"\u0004\b\u0000\u001012\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u000002H\u0080\b¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\tH\u0000¢\u0006\u0004\b4\u0010\u0017J\u001b\u0010:\u001a\u00020\t2\n\u00107\u001a\u00060\u0002j\u0002`\u0003H\u0000¢\u0006\u0004\b8\u00109J\u0017\u0010>\u001a\u00020\t2\u0006\u00107\u001a\u00020;H\u0000¢\u0006\u0004\b<\u0010=J\u0017\u0010C\u001a\u00020\t2\u0006\u0010@\u001a\u00020?H\u0000¢\u0006\u0004\bA\u0010BJ\u0017\u0010G\u001a\u00020\t2\u0006\u0010D\u001a\u00020\u0005H\u0000¢\u0006\u0004\bE\u0010FJ\u0017\u0010K\u001a\u00020\t2\u0006\u0010H\u001a\u00020(H\u0010¢\u0006\u0004\bI\u0010JJ\u000f\u0010L\u001a\u00020\tH\u0002¢\u0006\u0004\bL\u0010\u0017J\u000f\u0010M\u001a\u00020\tH\u0002¢\u0006\u0004\bM\u0010\u0017J\u000f\u0010N\u001a\u00020\tH\u0002¢\u0006\u0004\bN\u0010\u0017J\u000f\u0010O\u001a\u00020\tH\u0002¢\u0006\u0004\bO\u0010\u0017R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\n\u0010P\u001a\u0004\bQ\u0010RR(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\u000b\u0010P\u001a\u0004\bS\u0010RR\"\u0010T\u001a\u00020;8\u0010@\u0010X\u0090\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010=R*\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0010@\u0010X\u0090\u000e¢\u0006\u0012\n\u0004\b)\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R*\u0010_\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010^8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\"\u0010e\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010FR\"\u0010j\u001a\u00020?8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010BR\u0016\u0010D\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010UR\"\u0010o\u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010\u0010\"\u0004\br\u0010sR\u0014\u0010u\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u0010\u0010R\u0014\u0010x\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bv\u0010w¨\u0006z"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "Lkotlin/Function1;", "", "LC7/r;", "readObserver", "writeObserver", AppAgent.CONSTRUCT, "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;LS7/k;LS7/k;)V", "", "hasPendingChanges", "()Z", "takeNestedMutableSnapshot", "(LS7/k;LS7/k;)Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "apply", "()Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "dispose", "()V", "takeNestedSnapshot", "(LS7/k;)Landroidx/compose/runtime/snapshots/Snapshot;", RequestInfo.FUNCTION_SNAPSHOT, "nestedActivated$runtime", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "nestedActivated", "nestedDeactivated$runtime", "nestedDeactivated", "notifyObjectsInitialized$runtime", "notifyObjectsInitialized", "closeLocked$runtime", "closeLocked", "releasePinnedSnapshotsForCloseLocked$runtime", "releasePinnedSnapshotsForCloseLocked", "nextId", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "modified", "", "Landroidx/compose/runtime/snapshots/StateRecord;", "optimisticMerges", "invalidSnapshots", "innerApplyLocked$runtime", "(JLandroidx/collection/MutableScatterSet;Ljava/util/Map;Landroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "innerApplyLocked", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "block", "advance$runtime", "(LS7/a;)Ljava/lang/Object;", "advance", "id", "recordPrevious$runtime", "(J)V", "recordPrevious", "", "recordPreviousPinnedSnapshot$runtime", "(I)V", "recordPreviousPinnedSnapshot", "", "handles", "recordPreviousPinnedSnapshots$runtime", "([I)V", "recordPreviousPinnedSnapshots", "snapshots", "recordPreviousList$runtime", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "recordPreviousList", "state", "recordModified$runtime", "(Landroidx/compose/runtime/snapshots/StateObject;)V", "recordModified", "validateNotApplied", "validateNotAppliedOrPinned", "abandon", "releasePreviouslyPinnedSnapshotsLocked", "LS7/k;", "getReadObserver$runtime", "()LS7/k;", "getWriteObserver$runtime", "writeCount", "I", "getWriteCount$runtime", "()I", "setWriteCount$runtime", "Landroidx/collection/MutableScatterSet;", "getModified$runtime", "()Landroidx/collection/MutableScatterSet;", "setModified$runtime", "(Landroidx/collection/MutableScatterSet;)V", "", "merged", "Ljava/util/List;", "getMerged$runtime", "()Ljava/util/List;", "setMerged$runtime", "(Ljava/util/List;)V", "previousIds", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getPreviousIds$runtime", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime", "previousPinnedSnapshots", "[I", "getPreviousPinnedSnapshots$runtime", "()[I", "setPreviousPinnedSnapshots$runtime", "applied", "Z", "getApplied$runtime", "setApplied$runtime", "(Z)V", "getReadOnly", "readOnly", "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "root", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public class MutableSnapshot extends Snapshot {
    private boolean applied;
    private List<? extends StateObject> merged;
    private MutableScatterSet<StateObject> modified;
    private SnapshotIdSet previousIds;
    private int[] previousPinnedSnapshots;
    private final k readObserver;
    private int snapshots;
    private int writeCount;
    private final k writeObserver;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final int[] EmptyIntArray = new int[0];

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot$Companion;", "", AppAgent.CONSTRUCT, "()V", "EmptyIntArray", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private Companion() {
        }
    }

    public MutableSnapshot(long j5, SnapshotIdSet snapshotIdSet, k kVar, k kVar2) {
        super(j5, snapshotIdSet, (kotlin.jvm.internal.e) null);
        this.readObserver = kVar;
        this.writeObserver = kVar2;
        this.previousIds = SnapshotIdSet.INSTANCE.getEMPTY();
        this.previousPinnedSnapshots = EmptyIntArray;
        this.snapshots = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void abandon() {
        /*
            r17 = this;
            r0 = r17
            androidx.collection.MutableScatterSet r1 = r0.getModified$runtime()
            if (r1 == 0) goto L7f
            r0.validateNotApplied()
            r2 = 0
            r0.setModified$runtime(r2)
            long r2 = r0.getSnapshotId()
            java.lang.Object[] r4 = r1.elements
            long[] r1 = r1.metadata
            int r5 = r1.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L7f
            r6 = 0
            r7 = r6
        L1e:
            r8 = r1[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L7a
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L38:
            if (r12 >= r10) goto L78
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L74
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r4[r13]
            androidx.compose.runtime.snapshots.StateObject r13 = (androidx.compose.runtime.snapshots.StateObject) r13
            androidx.compose.runtime.snapshots.StateRecord r13 = r13.getFirstStateRecord()
        L4e:
            if (r13 == 0) goto L74
            long r14 = r13.getSnapshotId()
            int r14 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r14 == 0) goto L68
            androidx.compose.runtime.snapshots.SnapshotIdSet r14 = r0.previousIds
            long r15 = r13.getSnapshotId()
            java.lang.Long r15 = java.lang.Long.valueOf(r15)
            boolean r14 = D7.v.u0(r14, r15)
            if (r14 == 0) goto L6f
        L68:
            long r14 = androidx.compose.runtime.snapshots.SnapshotKt.access$getINVALID_SNAPSHOT$p()
            r13.setSnapshotId$runtime(r14)
        L6f:
            androidx.compose.runtime.snapshots.StateRecord r13 = r13.getNext()
            goto L4e
        L74:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L38
        L78:
            if (r10 != r11) goto L7f
        L7a:
            if (r7 == r5) goto L7f
            int r7 = r7 + 1
            goto L1e
        L7f:
            r0.closeAndReleasePinning$runtime()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.abandon():void");
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        int length = this.previousPinnedSnapshots.length;
        for (int i = 0; i < length; i++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[i]);
        }
    }

    public static /* synthetic */ MutableSnapshot takeNestedMutableSnapshot$default(MutableSnapshot mutableSnapshot, k kVar, k kVar2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedMutableSnapshot");
        }
        if ((i & 1) != 0) {
            kVar = null;
        }
        if ((i & 2) != 0) {
            kVar2 = null;
        }
        return mutableSnapshot.takeNestedMutableSnapshot(kVar, kVar2);
    }

    private final void validateNotApplied() {
        if (this.applied) {
            PreconditionsKt.throwIllegalStateException("Unsupported operation on a snapshot that has been applied");
        }
    }

    private final void validateNotAppliedOrPinned() {
        if (!this.applied || ((Snapshot) this).pinningTrackingHandle >= 0) {
            return;
        }
        PreconditionsKt.throwIllegalStateException("Unsupported operation on a disposed or applied snapshot");
    }

    public final <T> T advance$runtime(S7.a block) {
        long j5;
        recordPrevious$runtime(getSnapshotId());
        T t9 = (T) block.invoke();
        if (getApplied() || getDisposed()) {
            return t9;
        }
        long snapshotId = getSnapshotId();
        synchronized (SnapshotKt.getLock()) {
            long j6 = SnapshotKt.nextSnapshotId;
            j5 = 1;
            SnapshotKt.nextSnapshotId += j5;
            setSnapshotId$runtime(j6);
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getSnapshotId());
        }
        setInvalid$runtime(SnapshotKt.addRange(getInvalid(), snapshotId + j5, getSnapshotId()));
        return t9;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.runtime.snapshots.SnapshotApplyResult apply() {
        /*
            Method dump skipped, instructions count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.MutableSnapshot.apply():androidx.compose.runtime.snapshots.SnapshotApplyResult");
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getSnapshotId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed()) {
            return;
        }
        super.dispose();
        mo3595nestedDeactivated$runtime(this);
        SnapshotObserverKt.dispatchObserverOnPreDispose(this);
    }

    /* renamed from: getApplied$runtime, reason: from getter */
    public final boolean getApplied() {
        return this.applied;
    }

    public final List<StateObject> getMerged$runtime() {
        return this.merged;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public MutableScatterSet<StateObject> getModified$runtime() {
        return this.modified;
    }

    /* renamed from: getPreviousIds$runtime, reason: from getter */
    public final SnapshotIdSet getPreviousIds() {
        return this.previousIds;
    }

    /* renamed from: getPreviousPinnedSnapshots$runtime, reason: from getter */
    public final int[] getPreviousPinnedSnapshots() {
        return this.previousPinnedSnapshots;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getReadObserver$runtime, reason: from getter */
    public k getReadObserver() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot getRoot() {
        return this;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getWriteCount$runtime, reason: from getter */
    public int getWriteCount() {
        return this.writeCount;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getWriteObserver$runtime, reason: from getter */
    public k getWriteObserver() {
        return this.writeObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean hasPendingChanges() {
        MutableScatterSet<StateObject> modified$runtime = getModified$runtime();
        return modified$runtime != null && modified$runtime.isNotEmpty();
    }

    public final SnapshotApplyResult innerApplyLocked$runtime(long nextId, MutableScatterSet<StateObject> modified, Map<StateRecord, ? extends StateRecord> optimisticMerges, SnapshotIdSet invalidSnapshots) {
        SnapshotIdSet snapshotIdSet;
        Object[] objArr;
        long[] jArr;
        SnapshotIdSet snapshotIdSet2;
        Object[] objArr2;
        long[] jArr2;
        int i;
        long j5;
        int i6;
        StateRecord stateRecordMergeRecords;
        SnapshotIdSet snapshotIdSetOr = getInvalid().set(getSnapshotId()).or(this.previousIds);
        Object[] objArr3 = modified.elements;
        long[] jArr3 = modified.metadata;
        int length = jArr3.length - 2;
        ArrayList arrayList = null;
        ArrayList arrayListQ0 = null;
        if (length >= 0) {
            int i10 = 0;
            while (true) {
                long j6 = jArr3[i10];
                ArrayList arrayList2 = arrayListQ0;
                if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8;
                    int i12 = 8 - ((~(i10 - length)) >>> 31);
                    int i13 = 0;
                    while (i13 < i12) {
                        if ((j6 & 255) < 128) {
                            i = i11;
                            StateObject stateObject = (StateObject) objArr3[(i10 << 3) + i13];
                            objArr2 = objArr3;
                            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
                            jArr2 = jArr3;
                            ArrayList arrayList3 = arrayList;
                            StateRecord stateRecord = SnapshotKt.readable(firstStateRecord, nextId, invalidSnapshots);
                            if (stateRecord == null) {
                                j5 = j6;
                            } else {
                                j5 = j6;
                                StateRecord stateRecord2 = SnapshotKt.readable(firstStateRecord, getSnapshotId(), snapshotIdSetOr);
                                if (stateRecord2 != null && stateRecord2.getSnapshotId() != SnapshotId_jvmKt.toSnapshotId(1) && !stateRecord.equals(stateRecord2)) {
                                    i6 = i13;
                                    snapshotIdSet2 = snapshotIdSetOr;
                                    StateRecord stateRecord3 = SnapshotKt.readable(firstStateRecord, getSnapshotId(), getInvalid());
                                    if (stateRecord3 == null) {
                                        SnapshotKt.readError();
                                        throw new KotlinNothingValueException();
                                    }
                                    if (optimisticMerges == null || (stateRecordMergeRecords = optimisticMerges.get(stateRecord)) == null) {
                                        stateRecordMergeRecords = stateObject.mergeRecords(stateRecord2, stateRecord, stateRecord3);
                                    }
                                    if (stateRecordMergeRecords == null) {
                                        return new SnapshotApplyResult.Failure(this);
                                    }
                                    if (!stateRecordMergeRecords.equals(stateRecord3)) {
                                        if (stateRecordMergeRecords.equals(stateRecord)) {
                                            ArrayList arrayList4 = arrayList3 == null ? new ArrayList() : arrayList3;
                                            arrayList4.add(new Pair(stateObject, stateRecord.create(getSnapshotId())));
                                            if (arrayList2 == null) {
                                                arrayList2 = new ArrayList();
                                            }
                                            ArrayList arrayList5 = arrayList2;
                                            arrayList5.add(stateObject);
                                            arrayList = arrayList4;
                                            arrayList2 = arrayList5;
                                        } else {
                                            arrayList = arrayList3 == null ? new ArrayList() : arrayList3;
                                            arrayList.add(!stateRecordMergeRecords.equals(stateRecord2) ? new Pair(stateObject, stateRecordMergeRecords) : new Pair(stateObject, stateRecord2.create(getSnapshotId())));
                                        }
                                    }
                                }
                                arrayList = arrayList3;
                            }
                            snapshotIdSet2 = snapshotIdSetOr;
                            i6 = i13;
                            arrayList = arrayList3;
                        } else {
                            snapshotIdSet2 = snapshotIdSetOr;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            i = i11;
                            j5 = j6;
                            i6 = i13;
                        }
                        j6 = j5 >> i;
                        i13 = i6 + 1;
                        objArr3 = objArr2;
                        i11 = i;
                        jArr3 = jArr2;
                        snapshotIdSetOr = snapshotIdSet2;
                    }
                    snapshotIdSet = snapshotIdSetOr;
                    objArr = objArr3;
                    jArr = jArr3;
                    ArrayList arrayList6 = arrayList;
                    if (i12 != i11) {
                        arrayListQ0 = arrayList2;
                        arrayList = arrayList6;
                        break;
                    }
                    arrayList = arrayList6;
                } else {
                    snapshotIdSet = snapshotIdSetOr;
                    objArr = objArr3;
                    jArr = jArr3;
                }
                arrayListQ0 = arrayList2;
                if (i10 == length) {
                    break;
                }
                i10++;
                objArr3 = objArr;
                jArr3 = jArr;
                snapshotIdSetOr = snapshotIdSet;
            }
        }
        if (arrayList != null) {
            advance$runtime();
            int size = arrayList.size();
            for (int i14 = 0; i14 < size; i14++) {
                Pair pair = (Pair) arrayList.get(i14);
                StateObject stateObject2 = (StateObject) pair.f4886a;
                StateRecord stateRecord4 = (StateRecord) pair.b;
                stateRecord4.setSnapshotId$runtime(nextId);
                synchronized (SnapshotKt.getLock()) {
                    stateRecord4.setNext$runtime(stateObject2.getFirstStateRecord());
                    stateObject2.prependStateRecord(stateRecord4);
                }
            }
        }
        if (arrayListQ0 != null) {
            int size2 = arrayListQ0.size();
            for (int i15 = 0; i15 < size2; i15++) {
                modified.remove((StateObject) arrayListQ0.get(i15));
            }
            List<? extends StateObject> list = this.merged;
            if (list != null) {
                arrayListQ0 = v.Q0(arrayListQ0, list);
            }
            this.merged = arrayListQ0;
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedActivated$runtime */
    public void mo3594nestedActivated$runtime(Snapshot snapshot) {
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedDeactivated$runtime */
    public void mo3595nestedDeactivated$runtime(Snapshot snapshot) {
        if (!(this.snapshots > 0)) {
            PreconditionsKt.throwIllegalArgumentException("no pending nested snapshots");
        }
        int i = this.snapshots - 1;
        this.snapshots = i;
        if (i != 0 || this.applied) {
            return;
        }
        abandon();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime() {
        if (this.applied || getDisposed()) {
            return;
        }
        advance$runtime();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime */
    public void mo3596recordModified$runtime(StateObject state) {
        MutableScatterSet<StateObject> modified$runtime = getModified$runtime();
        if (modified$runtime == null) {
            modified$runtime = ScatterSetKt.mutableScatterSetOf();
            setModified$runtime(modified$runtime);
        }
        modified$runtime.add(state);
    }

    public final void recordPrevious$runtime(long id) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.set(id);
        }
    }

    public final void recordPreviousList$runtime(SnapshotIdSet snapshots) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.or(snapshots);
        }
    }

    public final void recordPreviousPinnedSnapshot$runtime(int id) {
        if (id >= 0) {
            int[] iArr = this.previousPinnedSnapshots;
            kotlin.jvm.internal.k.f(iArr, "<this>");
            int length = iArr.length;
            int[] iArrCopyOf = Arrays.copyOf(iArr, length + 1);
            iArrCopyOf[length] = id;
            this.previousPinnedSnapshots = iArrCopyOf;
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime(int[] handles) {
        if (handles.length == 0) {
            return;
        }
        int[] iArr = this.previousPinnedSnapshots;
        if (iArr.length != 0) {
            int length = iArr.length;
            int length2 = handles.length;
            int[] iArrCopyOf = Arrays.copyOf(iArr, length + length2);
            System.arraycopy(handles, 0, iArrCopyOf, length, length2);
            kotlin.jvm.internal.k.c(iArrCopyOf);
            handles = iArrCopyOf;
        }
        this.previousPinnedSnapshots = handles;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime() {
        releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime();
    }

    public final void setApplied$runtime(boolean z10) {
        this.applied = z10;
    }

    public final void setMerged$runtime(List<? extends StateObject> list) {
        this.merged = list;
    }

    public void setModified$runtime(MutableScatterSet<StateObject> mutableScatterSet) {
        this.modified = mutableScatterSet;
    }

    public final void setPreviousIds$runtime(SnapshotIdSet snapshotIdSet) {
        this.previousIds = snapshotIdSet;
    }

    public final void setPreviousPinnedSnapshots$runtime(int[] iArr) {
        this.previousPinnedSnapshots = iArr;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime(int i) {
        this.writeCount = i;
    }

    public MutableSnapshot takeNestedMutableSnapshot(k readObserver, k writeObserver) {
        Map map;
        long j5;
        NestedMutableSnapshot nestedMutableSnapshot;
        validateNotDisposed$runtime();
        validateNotAppliedOrPinned();
        PersistentList persistentList = SnapshotObserverKt.observers;
        k kVar = readObserver;
        k writeObserver2 = writeObserver;
        if (persistentList != null) {
            Pair<SnapshotInstanceObservers, Map<SnapshotObserver, SnapshotInstanceObservers>> pairMergeObservers = SnapshotObserverKt.mergeObservers(persistentList, this, false, kVar, writeObserver2);
            SnapshotInstanceObservers snapshotInstanceObservers = (SnapshotInstanceObservers) pairMergeObservers.f4886a;
            k readObserver2 = snapshotInstanceObservers.getReadObserver();
            writeObserver2 = snapshotInstanceObservers.getWriteObserver();
            map = (Map) pairMergeObservers.b;
            kVar = readObserver2;
        } else {
            map = null;
        }
        recordPrevious$runtime(getSnapshotId());
        synchronized (SnapshotKt.getLock()) {
            long j6 = SnapshotKt.nextSnapshotId;
            j5 = 1;
            SnapshotKt.nextSnapshotId += j5;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(j6);
            SnapshotIdSet invalid = getInvalid();
            setInvalid$runtime(invalid.set(j6));
            nestedMutableSnapshot = new NestedMutableSnapshot(j6, SnapshotKt.addRange(invalid, getSnapshotId() + j5, j6), SnapshotKt.mergedReadObserver$default(kVar, getReadObserver(), false, 4, null), SnapshotKt.mergedWriteObserver(writeObserver2, getWriteObserver()), this);
        }
        if (!getApplied() && !getDisposed()) {
            long snapshotId = getSnapshotId();
            synchronized (SnapshotKt.getLock()) {
                long j10 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId += j5;
                setSnapshotId$runtime(j10);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getSnapshotId());
            }
            setInvalid$runtime(SnapshotKt.addRange(getInvalid(), snapshotId + j5, getSnapshotId()));
        }
        if (persistentList != null) {
            SnapshotObserverKt.dispatchCreatedObservers(persistentList, this, nestedMutableSnapshot, map);
        }
        return nestedMutableSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(k readObserver) {
        Map map;
        long j5;
        NestedReadonlySnapshot nestedReadonlySnapshot;
        validateNotDisposed$runtime();
        validateNotAppliedOrPinned();
        long snapshotId = getSnapshotId();
        MutableSnapshot mutableSnapshot = this instanceof GlobalSnapshot ? null : this;
        PersistentList persistentList = SnapshotObserverKt.observers;
        k kVar = readObserver;
        if (persistentList != null) {
            Pair<SnapshotInstanceObservers, Map<SnapshotObserver, SnapshotInstanceObservers>> pairMergeObservers = SnapshotObserverKt.mergeObservers(persistentList, mutableSnapshot, true, kVar, null);
            SnapshotInstanceObservers snapshotInstanceObservers = (SnapshotInstanceObservers) pairMergeObservers.f4886a;
            k readObserver2 = snapshotInstanceObservers.getReadObserver();
            snapshotInstanceObservers.getWriteObserver();
            map = (Map) pairMergeObservers.b;
            kVar = readObserver2;
        } else {
            map = null;
        }
        recordPrevious$runtime(getSnapshotId());
        synchronized (SnapshotKt.getLock()) {
            long j6 = SnapshotKt.nextSnapshotId;
            j5 = 1;
            SnapshotKt.nextSnapshotId += j5;
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(j6);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(j6, SnapshotKt.addRange(getInvalid(), snapshotId + j5, j6), SnapshotKt.mergedReadObserver$default(kVar, getReadObserver(), false, 4, null), this);
        }
        if (!getApplied() && !getDisposed()) {
            long snapshotId2 = getSnapshotId();
            synchronized (SnapshotKt.getLock()) {
                long j10 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId += j5;
                setSnapshotId$runtime(j10);
                SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getSnapshotId());
            }
            setInvalid$runtime(SnapshotKt.addRange(getInvalid(), snapshotId2 + j5, getSnapshotId()));
        }
        if (persistentList != null) {
            SnapshotObserverKt.dispatchCreatedObservers(persistentList, mutableSnapshot, nestedReadonlySnapshot, map);
        }
        return nestedReadonlySnapshot;
    }

    public final void advance$runtime() {
        long j5;
        recordPrevious$runtime(getSnapshotId());
        if (getApplied() || getDisposed()) {
            return;
        }
        long snapshotId = getSnapshotId();
        synchronized (SnapshotKt.getLock()) {
            long j6 = SnapshotKt.nextSnapshotId;
            j5 = 1;
            SnapshotKt.nextSnapshotId += j5;
            setSnapshotId$runtime(j6);
            SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.set(getSnapshotId());
        }
        setInvalid$runtime(SnapshotKt.addRange(getInvalid(), snapshotId + j5, getSnapshotId()));
    }
}
