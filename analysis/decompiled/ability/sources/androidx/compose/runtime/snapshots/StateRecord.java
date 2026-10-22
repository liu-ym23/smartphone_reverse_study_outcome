package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\b'\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007B\u0011\b\u0017\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0000H&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0000H&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\bH\u0017¢\u0006\u0004\b\u000f\u0010\u0011J\u001b\u0010\u000f\u001a\u00020\u00002\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\u0012R&\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0006R$\u0010\u0017\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Landroidx/compose/runtime/snapshots/StateRecord;", "", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", AppAgent.CONSTRUCT, "(J)V", "()V", "", "id", "(I)V", "value", "LC7/r;", "assign", "(Landroidx/compose/runtime/snapshots/StateRecord;)V", "create", "()Landroidx/compose/runtime/snapshots/StateRecord;", "(I)Landroidx/compose/runtime/snapshots/StateRecord;", "(J)Landroidx/compose/runtime/snapshots/StateRecord;", "J", "getSnapshotId$runtime", "()J", "setSnapshotId$runtime", "next", "Landroidx/compose/runtime/snapshots/StateRecord;", "getNext$runtime", "setNext$runtime", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class StateRecord {
    public static final int $stable = 8;
    private StateRecord next;
    private long snapshotId;

    public StateRecord(long j5) {
        this.snapshotId = j5;
    }

    public abstract void assign(StateRecord value);

    public abstract StateRecord create();

    @C7.c
    public /* synthetic */ StateRecord create(int snapshotId) {
        StateRecord stateRecordCreate = create();
        stateRecordCreate.snapshotId = SnapshotId_jvmKt.toSnapshotId(snapshotId);
        return stateRecordCreate;
    }

    /* renamed from: getNext$runtime, reason: from getter */
    public final StateRecord getNext() {
        return this.next;
    }

    /* renamed from: getSnapshotId$runtime, reason: from getter */
    public final long getSnapshotId() {
        return this.snapshotId;
    }

    public final void setNext$runtime(StateRecord stateRecord) {
        this.next = stateRecord;
    }

    public final void setSnapshotId$runtime(long j5) {
        this.snapshotId = j5;
    }

    public StateRecord create(long snapshotId) {
        StateRecord stateRecordCreate = create();
        stateRecordCreate.snapshotId = snapshotId;
        return stateRecordCreate;
    }

    public StateRecord() {
        this(SnapshotKt.currentSnapshot().getSnapshotId());
    }

    @C7.c
    public StateRecord(int i) {
        this(SnapshotId_jvmKt.toSnapshotId(i));
    }
}
