package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000J\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a@\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0080\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a@\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0080\b¢\u0006\u0004\b\b\u0010\u0007\u001a9\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\u0003H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a@\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0004\u0012\u00028\u00000\u0003H\u0080\b¢\u0006\u0004\b\r\u0010\u0007\u001a@\u0010\u000f\u001a\u00020\n\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u001e\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\u0003H\u0080\b¢\u0006\u0004\b\u000f\u0010\f\u001a \u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0080\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a5\u0010\u0016\u001a\u00020\n\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a-\u0010\u001a\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0000¢\u0006\u0004\b\u001a\u0010\u001b\"\u0018\u0010\u001e\u001a\u00060\u001cj\u0002`\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f\"$\u0010\"\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b \u0010!\"0\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00028@X\u0080\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0012\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "Lkotlin/Function1;", "Landroidx/compose/runtime/snapshots/StateSetStateRecord;", "block", "writable", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;LS7/k;)Ljava/lang/Object;", "withCurrent", "", "", "mutateBoolean", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;LS7/k;)Z", "mutate", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "conditionalUpdate", "LC7/r;", "clearImpl", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;)V", "", "currentModification", "newSet", "attemptUpdate", "(Landroidx/compose/runtime/snapshots/StateSetStateRecord;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;)Z", "set", "Landroidx/compose/runtime/snapshots/StateRecord;", "stateRecordWith", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;)Landroidx/compose/runtime/snapshots/StateRecord;", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "sync", "Ljava/lang/Object;", "getModification", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;)I", "modification", "getReadable", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;)Landroidx/compose/runtime/snapshots/StateSetStateRecord;", "getReadable$annotations", "readable", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotStateSetKt {
    private static final Object sync = new Object();

    public static final <T> boolean attemptUpdate(StateSetStateRecord<T> stateSetStateRecord, int i, PersistentSet<? extends T> persistentSet) {
        boolean z10;
        synchronized (sync) {
            if (stateSetStateRecord.getModification$runtime() == i) {
                stateSetStateRecord.setSet$runtime(persistentSet);
                z10 = true;
                stateSetStateRecord.setModification$runtime(stateSetStateRecord.getModification$runtime() + 1);
            } else {
                z10 = false;
            }
        }
        return z10;
    }

    public static final <T> void clearImpl(SnapshotStateSet<T> snapshotStateSet) {
        Snapshot current;
        StateRecord firstStateRecord = snapshotStateSet.getFirstStateRecord();
        k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) firstStateRecord;
        synchronized (SnapshotKt.getLock()) {
            current = Snapshot.INSTANCE.getCurrent();
            StateSetStateRecord stateSetStateRecord2 = (StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord, snapshotStateSet, current);
            synchronized (sync) {
                stateSetStateRecord2.setSet$runtime(ExtensionsKt.persistentSetOf());
                stateSetStateRecord2.setModification$runtime(stateSetStateRecord2.getModification$runtime() + 1);
            }
        }
        SnapshotKt.notifyWrite(current, snapshotStateSet);
    }

    public static final <T> boolean conditionalUpdate(SnapshotStateSet<T> snapshotStateSet, S7.k kVar) {
        int modification$runtime;
        PersistentSet<T> set$runtime;
        Snapshot current;
        boolean zAttemptUpdate;
        do {
            synchronized (sync) {
                StateRecord firstStateRecord = snapshotStateSet.getFirstStateRecord();
                k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.current((StateSetStateRecord) firstStateRecord);
                modification$runtime = stateSetStateRecord.getModification$runtime();
                set$runtime = stateSetStateRecord.getSet$runtime();
            }
            k.c(set$runtime);
            PersistentSet persistentSet = (PersistentSet) kVar.invoke(set$runtime);
            if (k.b(persistentSet, set$runtime)) {
                return false;
            }
            StateRecord firstStateRecord2 = snapshotStateSet.getFirstStateRecord();
            k.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
            StateSetStateRecord stateSetStateRecord2 = (StateSetStateRecord) firstStateRecord2;
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                zAttemptUpdate = attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord2, snapshotStateSet, current), modification$runtime, persistentSet);
            }
            SnapshotKt.notifyWrite(current, snapshotStateSet);
        } while (!zAttemptUpdate);
        return true;
    }

    public static final <T> int getModification(SnapshotStateSet<T> snapshotStateSet) {
        StateRecord firstStateRecord = snapshotStateSet.getFirstStateRecord();
        k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
        return ((StateSetStateRecord) SnapshotKt.current((StateSetStateRecord) firstStateRecord)).getModification$runtime();
    }

    public static final <T> StateSetStateRecord<T> getReadable(SnapshotStateSet<T> snapshotStateSet) {
        StateRecord firstStateRecord = snapshotStateSet.getFirstStateRecord();
        k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.<get-readable>>");
        return (StateSetStateRecord) SnapshotKt.readable((StateSetStateRecord) firstStateRecord, snapshotStateSet);
    }

    public static /* synthetic */ void getReadable$annotations(SnapshotStateSet snapshotStateSet) {
    }

    public static final <R, T> R mutate(SnapshotStateSet<T> snapshotStateSet, S7.k kVar) {
        int modification$runtime;
        PersistentSet<T> set$runtime;
        PersistentSet.Builder<T> builder;
        R r5;
        Snapshot current;
        boolean zAttemptUpdate;
        do {
            synchronized (sync) {
                StateRecord firstStateRecord = snapshotStateSet.getFirstStateRecord();
                k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.current((StateSetStateRecord) firstStateRecord);
                modification$runtime = stateSetStateRecord.getModification$runtime();
                set$runtime = stateSetStateRecord.getSet$runtime();
            }
            if (set$runtime != null && (builder = set$runtime.builder()) != null) {
                r5 = (R) kVar.invoke(builder);
                PersistentSet<T> persistentSetBuild = builder.build();
                if (k.b(persistentSetBuild, set$runtime)) {
                    break;
                }
                StateRecord firstStateRecord2 = snapshotStateSet.getFirstStateRecord();
                k.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
                StateSetStateRecord stateSetStateRecord2 = (StateSetStateRecord) firstStateRecord2;
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.INSTANCE.getCurrent();
                    zAttemptUpdate = attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord2, snapshotStateSet, current), modification$runtime, persistentSetBuild);
                }
                SnapshotKt.notifyWrite(current, snapshotStateSet);
            } else {
                throw new IllegalStateException("No set to mutate");
            }
        } while (!zAttemptUpdate);
        return r5;
    }

    public static final <T> boolean mutateBoolean(SnapshotStateSet<T> snapshotStateSet, S7.k kVar) {
        int modification$runtime;
        PersistentSet<T> set$runtime;
        PersistentSet.Builder<T> builder;
        Object objInvoke;
        Snapshot current;
        boolean zAttemptUpdate;
        do {
            synchronized (sync) {
                StateRecord firstStateRecord = snapshotStateSet.getFirstStateRecord();
                k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
                StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) SnapshotKt.current((StateSetStateRecord) firstStateRecord);
                modification$runtime = stateSetStateRecord.getModification$runtime();
                set$runtime = stateSetStateRecord.getSet$runtime();
            }
            if (set$runtime != null && (builder = set$runtime.builder()) != null) {
                objInvoke = kVar.invoke(builder);
                PersistentSet<T> persistentSetBuild = builder.build();
                if (k.b(persistentSetBuild, set$runtime)) {
                    break;
                }
                StateRecord firstStateRecord2 = snapshotStateSet.getFirstStateRecord();
                k.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
                StateSetStateRecord stateSetStateRecord2 = (StateSetStateRecord) firstStateRecord2;
                synchronized (SnapshotKt.getLock()) {
                    current = Snapshot.INSTANCE.getCurrent();
                    zAttemptUpdate = attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(stateSetStateRecord2, snapshotStateSet, current), modification$runtime, persistentSetBuild);
                }
                SnapshotKt.notifyWrite(current, snapshotStateSet);
            } else {
                throw new IllegalStateException("No set to mutate");
            }
        } while (!zAttemptUpdate);
        return ((Boolean) objInvoke).booleanValue();
    }

    public static final <T> StateRecord stateRecordWith(SnapshotStateSet<T> snapshotStateSet, PersistentSet<? extends T> persistentSet) {
        StateSetStateRecord stateSetStateRecord = new StateSetStateRecord(SnapshotKt.currentSnapshot().getSnapshotId(), persistentSet);
        if (Snapshot.INSTANCE.isInSnapshot()) {
            stateSetStateRecord.setNext$runtime(new StateSetStateRecord(SnapshotId_jvmKt.toSnapshotId(1), persistentSet));
        }
        return stateSetStateRecord;
    }

    public static final <R, T> R withCurrent(SnapshotStateSet<T> snapshotStateSet, S7.k kVar) {
        StateRecord firstStateRecord = snapshotStateSet.getFirstStateRecord();
        k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
        return (R) kVar.invoke(SnapshotKt.current((StateSetStateRecord) firstStateRecord));
    }

    public static final <R, T> R writable(SnapshotStateSet<T> snapshotStateSet, S7.k kVar) {
        Snapshot current;
        R r5;
        StateRecord firstStateRecord = snapshotStateSet.getFirstStateRecord();
        k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        StateSetStateRecord stateSetStateRecord = (StateSetStateRecord) firstStateRecord;
        synchronized (SnapshotKt.getLock()) {
            current = Snapshot.INSTANCE.getCurrent();
            r5 = (R) kVar.invoke(SnapshotKt.writableRecord(stateSetStateRecord, snapshotStateSet, current));
        }
        SnapshotKt.notifyWrite(current, snapshotStateSet);
        return r5;
    }
}
