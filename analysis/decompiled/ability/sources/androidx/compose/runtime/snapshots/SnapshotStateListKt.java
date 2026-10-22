package androidx.compose.runtime.snapshots;

import S7.k;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000P\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a@\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0080\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a@\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0004\u0012\u00028\u00000\u0003H\u0080\b¢\u0006\u0004\b\b\u0010\u0007\u001a9\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0004\u0012\u00020\n0\u0003H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a@\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\t\u0012\u0004\u0012\u00028\u00000\u0003H\u0080\b¢\u0006\u0004\b\r\u0010\u0007\u001aJ\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u000e\u001a\u00020\n2\u001e\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u0003H\u0080\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a \u0010\u0013\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0080\b¢\u0006\u0004\b\u0013\u0010\u0014\u001aJ\u0010\u0015\u001a\u00020\n\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\b\u0002\u0010\u000e\u001a\u00020\n2\u001e\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u0003H\u0080\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a=\u0010\u001a\u001a\u00020\n\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u000e\u001a\u00020\nH\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a-\u0010\u001e\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a5\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00012\u0006\u0010 \u001a\u00020\u00172\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\"\u0010#\u001a\u000f\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b%\u0010&\u001a\u001f\u0010(\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0017H\u0002¢\u0006\u0004\b(\u0010)\u001a\u000f\u0010*\u001a\u00020$H\u0002¢\u0006\u0004\b*\u0010&\"\u0018\u0010-\u001a\u00060+j\u0002`,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.\"$\u00101\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\"0\u00105\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00028@X\u0080\u0004¢\u0006\f\u0012\u0004\b4\u0010\u0014\u001a\u0004\b2\u00103¨\u00066"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lkotlin/Function1;", "Landroidx/compose/runtime/snapshots/StateListStateRecord;", "block", "writable", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;LS7/k;)Ljava/lang/Object;", "withCurrent", "", "", "mutateBoolean", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;LS7/k;)Z", "mutate", "structural", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "LC7/r;", "update", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;ZLS7/k;)V", "clearImpl", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;)V", "conditionalUpdate", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;ZLS7/k;)Z", "", "currentModification", "newList", "attemptUpdate", "(Landroidx/compose/runtime/snapshots/StateListStateRecord;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;Z)Z", "list", "Landroidx/compose/runtime/snapshots/StateRecord;", "stateRecordWith", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)Landroidx/compose/runtime/snapshots/StateRecord;", "size", "init", "SnapshotStateList", "(ILS7/k;)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "", "modificationError", "()Ljava/lang/Void;", "index", "validateRange", "(II)V", "invalidIteratorSet", "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "sync", "Ljava/lang/Object;", "getStructure", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;)I", "structure", "getReadable", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;)Landroidx/compose/runtime/snapshots/StateListStateRecord;", "getReadable$annotations", "readable", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotStateListKt {
    private static final Object sync = new Object();

    public static final <T> SnapshotStateList<T> SnapshotStateList(int i, k kVar) {
        if (i == 0) {
            return new SnapshotStateList<>();
        }
        PersistentList.Builder builder = ExtensionsKt.persistentListOf().builder();
        for (int i6 = 0; i6 < i; i6++) {
            builder.add(kVar.invoke(Integer.valueOf(i6)));
        }
        return new SnapshotStateList<>(builder.build());
    }

    public static final <T> boolean attemptUpdate(StateListStateRecord<T> stateListStateRecord, int i, PersistentList<? extends T> persistentList, boolean z10) {
        boolean z11;
        synchronized (sync) {
            try {
                if (stateListStateRecord.getModification() == i) {
                    stateListStateRecord.setList$runtime(persistentList);
                    z11 = true;
                    if (z10) {
                        stateListStateRecord.setStructuralChange$runtime(stateListStateRecord.getStructuralChange() + 1);
                    }
                    stateListStateRecord.setModification$runtime(stateListStateRecord.getModification() + 1);
                } else {
                    z11 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z11;
    }

    public static final <T> void clearImpl(SnapshotStateList<T> snapshotStateList) {
        Snapshot current;
        StateRecord firstStateRecord = snapshotStateList.getFirstStateRecord();
        kotlin.jvm.internal.k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord stateListStateRecord = (StateListStateRecord) firstStateRecord;
        synchronized (SnapshotKt.getLock()) {
            current = Snapshot.INSTANCE.getCurrent();
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord, snapshotStateList, current);
            synchronized (sync) {
                stateListStateRecord2.setList$runtime(ExtensionsKt.persistentListOf());
                stateListStateRecord2.setModification$runtime(stateListStateRecord2.getModification() + 1);
                stateListStateRecord2.setStructuralChange$runtime(stateListStateRecord2.getStructuralChange() + 1);
            }
        }
        SnapshotKt.notifyWrite(current, snapshotStateList);
    }

    public static final <T> boolean conditionalUpdate(SnapshotStateList<T> snapshotStateList, boolean z10, k kVar) {
        int modification$runtime;
        PersistentList<T> list$runtime;
        Snapshot current;
        boolean zAttemptUpdate;
        do {
            synchronized (sync) {
                StateRecord firstStateRecord = snapshotStateList.getFirstStateRecord();
                kotlin.jvm.internal.k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification$runtime = stateListStateRecord.getModification();
                list$runtime = stateListStateRecord.getList$runtime();
            }
            kotlin.jvm.internal.k.c(list$runtime);
            PersistentList persistentList = (PersistentList) kVar.invoke(list$runtime);
            if (kotlin.jvm.internal.k.b(persistentList, list$runtime)) {
                return false;
            }
            StateRecord firstStateRecord2 = snapshotStateList.getFirstStateRecord();
            kotlin.jvm.internal.k.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                zAttemptUpdate = attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, snapshotStateList, current), modification$runtime, persistentList, z10);
            }
            SnapshotKt.notifyWrite(current, snapshotStateList);
        } while (!zAttemptUpdate);
        return true;
    }

    public static /* synthetic */ boolean conditionalUpdate$default(SnapshotStateList snapshotStateList, boolean z10, k kVar, int i, Object obj) {
        int modification$runtime;
        PersistentList list$runtime;
        Snapshot current;
        boolean zAttemptUpdate;
        if ((i & 1) != 0) {
            z10 = true;
        }
        do {
            synchronized (sync) {
                StateRecord firstStateRecord = snapshotStateList.getFirstStateRecord();
                kotlin.jvm.internal.k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification$runtime = stateListStateRecord.getModification();
                list$runtime = stateListStateRecord.getList$runtime();
            }
            kotlin.jvm.internal.k.c(list$runtime);
            PersistentList persistentList = (PersistentList) kVar.invoke(list$runtime);
            if (kotlin.jvm.internal.k.b(persistentList, list$runtime)) {
                return false;
            }
            StateRecord firstStateRecord2 = snapshotStateList.getFirstStateRecord();
            kotlin.jvm.internal.k.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                zAttemptUpdate = attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, snapshotStateList, current), modification$runtime, persistentList, z10);
            }
            SnapshotKt.notifyWrite(current, snapshotStateList);
        } while (!zAttemptUpdate);
        return true;
    }

    public static final <T> StateListStateRecord<T> getReadable(SnapshotStateList<T> snapshotStateList) {
        StateRecord firstStateRecord = snapshotStateList.getFirstStateRecord();
        kotlin.jvm.internal.k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.<get-readable>>");
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) firstStateRecord, snapshotStateList);
    }

    public static /* synthetic */ void getReadable$annotations(SnapshotStateList snapshotStateList) {
    }

    public static final <T> int getStructure(SnapshotStateList<T> snapshotStateList) {
        StateRecord firstStateRecord = snapshotStateList.getFirstStateRecord();
        kotlin.jvm.internal.k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord)).getStructuralChange();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void invalidIteratorSet() {
        throw new IllegalStateException("Cannot call set before the first call to next() or previous() or immediately after a call to add() or remove()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void modificationError() {
        throw new IllegalStateException("Cannot modify a state list through an iterator");
    }

    public static final <R, T> R mutate(SnapshotStateList<T> snapshotStateList, k kVar) {
        int modification$runtime;
        PersistentList<T> list$runtime;
        R r5;
        Snapshot current;
        boolean zAttemptUpdate;
        do {
            synchronized (sync) {
                StateRecord firstStateRecord = snapshotStateList.getFirstStateRecord();
                kotlin.jvm.internal.k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification$runtime = stateListStateRecord.getModification();
                list$runtime = stateListStateRecord.getList$runtime();
            }
            kotlin.jvm.internal.k.c(list$runtime);
            PersistentList.Builder<T> builder = list$runtime.builder();
            r5 = (R) kVar.invoke(builder);
            PersistentList<T> persistentListBuild = builder.build();
            if (kotlin.jvm.internal.k.b(persistentListBuild, list$runtime)) {
                break;
            }
            StateRecord firstStateRecord2 = snapshotStateList.getFirstStateRecord();
            kotlin.jvm.internal.k.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                zAttemptUpdate = attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, snapshotStateList, current), modification$runtime, persistentListBuild, true);
            }
            SnapshotKt.notifyWrite(current, snapshotStateList);
        } while (!zAttemptUpdate);
        return r5;
    }

    public static final <T> boolean mutateBoolean(SnapshotStateList<T> snapshotStateList, k kVar) {
        int modification$runtime;
        PersistentList<T> list$runtime;
        Object objInvoke;
        Snapshot current;
        boolean zAttemptUpdate;
        do {
            synchronized (sync) {
                StateRecord firstStateRecord = snapshotStateList.getFirstStateRecord();
                kotlin.jvm.internal.k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification$runtime = stateListStateRecord.getModification();
                list$runtime = stateListStateRecord.getList$runtime();
            }
            kotlin.jvm.internal.k.c(list$runtime);
            PersistentList.Builder<T> builder = list$runtime.builder();
            objInvoke = kVar.invoke(builder);
            PersistentList<T> persistentListBuild = builder.build();
            if (kotlin.jvm.internal.k.b(persistentListBuild, list$runtime)) {
                break;
            }
            StateRecord firstStateRecord2 = snapshotStateList.getFirstStateRecord();
            kotlin.jvm.internal.k.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                zAttemptUpdate = attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, snapshotStateList, current), modification$runtime, persistentListBuild, true);
            }
            SnapshotKt.notifyWrite(current, snapshotStateList);
        } while (!zAttemptUpdate);
        return ((Boolean) objInvoke).booleanValue();
    }

    public static final <T> StateRecord stateRecordWith(SnapshotStateList<T> snapshotStateList, PersistentList<? extends T> persistentList) {
        Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
        StateListStateRecord stateListStateRecord = new StateListStateRecord(snapshotCurrentSnapshot.getSnapshotId(), persistentList);
        if (!(snapshotCurrentSnapshot instanceof GlobalSnapshot)) {
            stateListStateRecord.setNext$runtime(new StateListStateRecord(SnapshotId_jvmKt.toSnapshotId(1), persistentList));
        }
        return stateListStateRecord;
    }

    public static final <T> void update(SnapshotStateList<T> snapshotStateList, boolean z10, k kVar) {
        int modification$runtime;
        PersistentList<T> list$runtime;
        Snapshot current;
        boolean zAttemptUpdate;
        do {
            synchronized (sync) {
                StateRecord firstStateRecord = snapshotStateList.getFirstStateRecord();
                kotlin.jvm.internal.k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification$runtime = stateListStateRecord.getModification();
                list$runtime = stateListStateRecord.getList$runtime();
            }
            kotlin.jvm.internal.k.c(list$runtime);
            PersistentList persistentList = (PersistentList) kVar.invoke(list$runtime);
            if (kotlin.jvm.internal.k.b(persistentList, list$runtime)) {
                return;
            }
            StateRecord firstStateRecord2 = snapshotStateList.getFirstStateRecord();
            kotlin.jvm.internal.k.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                zAttemptUpdate = attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, snapshotStateList, current), modification$runtime, persistentList, z10);
            }
            SnapshotKt.notifyWrite(current, snapshotStateList);
        } while (!zAttemptUpdate);
    }

    public static /* synthetic */ void update$default(SnapshotStateList snapshotStateList, boolean z10, k kVar, int i, Object obj) {
        int modification$runtime;
        PersistentList list$runtime;
        Snapshot current;
        boolean zAttemptUpdate;
        if ((i & 1) != 0) {
            z10 = true;
        }
        do {
            synchronized (sync) {
                StateRecord firstStateRecord = snapshotStateList.getFirstStateRecord();
                kotlin.jvm.internal.k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification$runtime = stateListStateRecord.getModification();
                list$runtime = stateListStateRecord.getList$runtime();
            }
            kotlin.jvm.internal.k.c(list$runtime);
            PersistentList persistentList = (PersistentList) kVar.invoke(list$runtime);
            if (kotlin.jvm.internal.k.b(persistentList, list$runtime)) {
                return;
            }
            StateRecord firstStateRecord2 = snapshotStateList.getFirstStateRecord();
            kotlin.jvm.internal.k.d(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                zAttemptUpdate = attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, snapshotStateList, current), modification$runtime, persistentList, z10);
            }
            SnapshotKt.notifyWrite(current, snapshotStateList);
        } while (!zAttemptUpdate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateRange(int i, int i6) {
        if (i < 0 || i >= i6) {
            throw new IndexOutOfBoundsException("index (" + i + ") is out of bound of [0, " + i6 + ')');
        }
    }

    public static final <R, T> R withCurrent(SnapshotStateList<T> snapshotStateList, k kVar) {
        StateRecord firstStateRecord = snapshotStateList.getFirstStateRecord();
        kotlin.jvm.internal.k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
        return (R) kVar.invoke(SnapshotKt.current((StateListStateRecord) firstStateRecord));
    }

    public static final <R, T> R writable(SnapshotStateList<T> snapshotStateList, k kVar) {
        Snapshot current;
        R r5;
        StateRecord firstStateRecord = snapshotStateList.getFirstStateRecord();
        kotlin.jvm.internal.k.d(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord stateListStateRecord = (StateListStateRecord) firstStateRecord;
        synchronized (SnapshotKt.getLock()) {
            current = Snapshot.INSTANCE.getCurrent();
            r5 = (R) kVar.invoke(SnapshotKt.writableRecord(stateListStateRecord, snapshotStateList, current));
        }
        SnapshotKt.notifyWrite(current, snapshotStateList);
        return r5;
    }
}
