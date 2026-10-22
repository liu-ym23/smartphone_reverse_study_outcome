package androidx.compose.runtime.snapshots;

import com.byted.cast.common.TeaEventTrack;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\t\b\u0016¢\u0006\u0004\b\u0005\u0010\u0007B\u0011\b\u0017\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0005\u0010\nJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0000H&J\b\u0010\u0017\u001a\u00020\u0000H&J\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\tH\u0017J\u0019\u0010\u0017\u001a\u00020\u00002\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016¢\u0006\u0002\u0010\u0018R \u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Landroidx/compose/runtime/snapshots/StateRecord;", "", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "<init>", "(J)V", "()V", "id", "", "(I)V", "getSnapshotId$runtime", "()J", "setSnapshotId$runtime", "J", TeaEventTrack.ACTION_DRAMA_NEXT, "getNext$runtime", "()Landroidx/compose/runtime/snapshots/StateRecord;", "setNext$runtime", "(Landroidx/compose/runtime/snapshots/StateRecord;)V", "assign", "", "value", "create", "(J)Landroidx/compose/runtime/snapshots/StateRecord;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class StateRecord {
    public static final int $stable = 8;
    private StateRecord next;
    private long snapshotId;

    public abstract void assign(StateRecord r100);

    public abstract StateRecord create();

    public StateRecord() {
        this(SnapshotKt.currentSnapshot().getSnapshotId());
    }

    public final StateRecord getNext$runtime() {
        return this.next;
    }

    public final long getSnapshotId$runtime() {
        return this.snapshotId;
    }

    @Deprecated(message = "Use snapshotId: Long constructor instead")
    public StateRecord(int r100) {
        this(SnapshotId_jvmKt.toSnapshotId(r100));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use snapshotId: Long version instead")
    public /* synthetic */ StateRecord create(int r100) {
        StateRecord r101 = create();
        r101.snapshotId = SnapshotId_jvmKt.toSnapshotId(r100);
        return r101;
    }

    public final void setNext$runtime(StateRecord r100) {
        this.next = r100;
    }

    public final void setSnapshotId$runtime(long r100) {
        this.snapshotId = r100;
    }

    public StateRecord(long r100) {
        this.snapshotId = r100;
    }

    public StateRecord create(long r100) {
        StateRecord r101 = create();
        r101.snapshotId = r100;
        return r101;
    }
}
