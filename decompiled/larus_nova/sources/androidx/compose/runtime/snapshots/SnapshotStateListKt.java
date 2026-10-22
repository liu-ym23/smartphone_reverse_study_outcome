package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000`\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u001aC\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\u0002\b\u0007H\u0080\b¢\u0006\u0002\u0010\b\u001aC\u0010\t\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\u0002\b\u0007H\u0080\b¢\u0006\u0002\u0010\b\u001a2\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0004\u0012\u00020\u000b0\u0005H\u0000\u001a>\u0010\r\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\b¢\u0006\u0002\u0010\b\u001aC\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\u001e\u0010\u0004\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00110\u0005H\u0080\b\u001a\u0019\u0010\u0012\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0080\b\u001aC\u0010\u0013\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\u001e\u0010\u0004\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00110\u0005H\u0080\b\u001a6\u0010\u0014\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000bH\u0000\u001a&\u0010\u0018\u001a\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011H\u0000\u001a=\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\u0006\u0010$\u001a\u00020\u00162!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\b\u0010-\u001a\u00020.H\u0002\u001a\u0018\u0010/\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0016H\u0002\u001a\b\u00100\u001a\u00020.H\u0002\"$\u0010\u001b\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\"0\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038@X\u0080\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0014\u0010)\u001a\u00060*j\u0002`+X\u0082\u0004¢\u0006\u0004\n\u0002\u0010,¨\u00061"}, d2 = {"writable", "R", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/snapshots/StateListStateRecord;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withCurrent", "mutateBoolean", "", "", "mutate", "update", "", "structural", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "clearImpl", "conditionalUpdate", "attemptUpdate", "currentModification", "", "newList", "stateRecordWith", "Landroidx/compose/runtime/snapshots/StateRecord;", "list", "structure", "getStructure", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;)I", "readable", "getReadable$annotations", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;)V", "getReadable", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;)Landroidx/compose/runtime/snapshots/StateListStateRecord;", "SnapshotStateList", "size", "init", "Lkotlin/ParameterName;", "name", "index", DocumentType.DOCX_SYNC_BLOCK_NAME, "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "modificationError", "", "validateRange", "invalidIteratorSet", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SnapshotStateListKt {
    private static final Object sync = null;

    public static /* synthetic */ void getReadable$annotations(SnapshotStateList r100) {
    }

    static {
        sync = new Object();
    }

    private static final Void invalidIteratorSet() {
        throw new IllegalStateException("Cannot call set before the first call to next() or previous() or immediately after a call to add() or remove()".toString());
    }

    private static final Void modificationError() {
        throw new IllegalStateException("Cannot modify a state list through an iterator".toString());
    }

    public static final /* synthetic */ Void access$invalidIteratorSet() {
        return invalidIteratorSet();
    }

    public static final /* synthetic */ Void access$modificationError() {
        return modificationError();
    }

    public static final /* synthetic */ Object access$getSync$p() {
        return sync;
    }

    public static final <T> void clearImpl(SnapshotStateList<T> r100) {
        StateRecord r101 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r102 = (StateListStateRecord) r101;
        Object r103 = SnapshotKt.getLock();
        monitor-enter(r103);
        Snapshot r104 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L20
        StateListStateRecord r105 = (StateListStateRecord) SnapshotKt.writableRecord(r102, r100, r104);     // Catch: Throwable -> L20
        Object r106 = access$getSync$p();     // Catch: Throwable -> L20
        monitor-enter(r106);     // Catch: Throwable -> L20
        r105.setList$runtime(ExtensionsKt.persistentListOf());     // Catch: Throwable -> L15
        r105.setModification$runtime(r105.getModification$runtime() + 1);     // Catch: Throwable -> L15
        r105.setStructuralChange$runtime(r105.getStructuralChange$runtime() + 1);     // Catch: Throwable -> L15
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L20
        monitor-exit(r106);     // Catch: Throwable -> L20
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L20
        InlineMarker.finallyStart(1);
        monitor-exit(r103);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r104, r100);
        return;
    L15:
        th = move-exception;
        InlineMarker.finallyStart(1);     // Catch: Throwable -> L20
        InlineMarker.finallyEnd(1);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <T> StateListStateRecord<T> getReadable(SnapshotStateList<T> r100) {
        StateRecord r101 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.<get-readable>>");
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) r101, r100);
    }

    public static final <T> int getStructure(SnapshotStateList<T> r100) {
        StateRecord r101 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) r101)).getStructuralChange$runtime();
    }

    public static final <T> SnapshotStateList<T> SnapshotStateList(int r100, Function1<? super Integer, ? extends T> r101) {
        if (r100 == 0) goto L4;
        PersistentList.Builder r102 = ExtensionsKt.persistentListOf().builder();
        int r103 = 0;
    L6:
        if (r103 >= r100) goto L9;
        r102.add(r101.invoke(Integer.valueOf(r103)));
        r103 = r103 + 1;
        goto L6
    L9:
        return new SnapshotStateList(r102.build());
    L4:
        return new SnapshotStateList();
    }

    public static final /* synthetic */ void access$validateRange(int r100, int r101) {
        validateRange(r100, r101);
    }

    public static final <R, T> R mutate(SnapshotStateList<T> r100, Function1<? super List<T>, ? extends R> r101) {
    L2:
        Object r102 = access$getSync$p();
        monitor-enter(r102);
        StateRecord r103 = r100.getFirstStateRecord();     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");     // Catch: Throwable -> L24
        StateListStateRecord r104 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r103);     // Catch: Throwable -> L24
        int r105 = r104.getModification$runtime();     // Catch: Throwable -> L24
        PersistentList<T> r106 = r104.getList$runtime();     // Catch: Throwable -> L24
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L24
        InlineMarker.finallyStart(1);
        monitor-exit(r102);
        InlineMarker.finallyEnd(1);
        Intrinsics.checkNotNull(r106);
        PersistentList.Builder<T> r108 = r106.builder();
        R r109 = r101.invoke(r108);
        PersistentList<T> r110 = r108.build();
        if (Intrinsics.areEqual(r110, r106) == true) goto L23;
        StateRecord r111 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r112 = (StateListStateRecord) r111;
        Object r113 = SnapshotKt.getLock();
        monitor-enter(r113);
        Snapshot r114 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L18
        boolean r115 = attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(r112, r100, r114), r105, r110, true);     // Catch: Throwable -> L18
        InlineMarker.finallyStart(1);
        monitor-exit(r113);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r114, r100);
        if (r115 == false) goto L2;
    L18:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    L23:
        return r109;
    L24:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <T> boolean mutateBoolean(SnapshotStateList<T> r100, Function1<? super List<T>, Boolean> r101) {
    L2:
        Object r102 = access$getSync$p();
        monitor-enter(r102);
        StateRecord r103 = r100.getFirstStateRecord();     // Catch: Throwable -> L20
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");     // Catch: Throwable -> L20
        StateListStateRecord r104 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r103);     // Catch: Throwable -> L20
        int r105 = r104.getModification$runtime();     // Catch: Throwable -> L20
        PersistentList<T> r106 = r104.getList$runtime();     // Catch: Throwable -> L20
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(r102);
        Intrinsics.checkNotNull(r106);
        PersistentList.Builder<T> r108 = r106.builder();
        Boolean r109 = r101.invoke(r108);
        PersistentList<T> r110 = r108.build();
        if (Intrinsics.areEqual(r110, r106) == true) goto L19;
        StateRecord r111 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r112 = (StateListStateRecord) r111;
        Object r113 = SnapshotKt.getLock();
        monitor-enter(r113);
        Snapshot r114 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L15
        boolean r115 = attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(r112, r100, r114), r105, r110, true);     // Catch: Throwable -> L15
        monitor-exit(r113);
        SnapshotKt.notifyWrite(r114, r100);
        if (r115 == false) goto L2;
    L15:
        th = move-exception;
        throw th;
    L19:
        return r109.booleanValue();
    L20:
        th = move-exception;
        throw th;
    }

    public static final <T> StateRecord stateRecordWith(SnapshotStateList<T> r100, PersistentList<? extends T> r101) {
        Snapshot r102 = SnapshotKt.currentSnapshot();
        StateListStateRecord r103 = new StateListStateRecord(r102.getSnapshotId(), r101);
        if ((r102 instanceof GlobalSnapshot) == true) goto L5;
        r103.setNext$runtime(new StateListStateRecord(SnapshotId_jvmKt.toSnapshotId(1), r101));
    L5:
        return r103;
    }

    private static final void validateRange(int r100, int r101) {
        boolean r102 = false;
        if (r100 < 0) goto L6;
        if (r100 >= r101) goto L6;
        r102 = true;
    L6:
        if (r102 == false) goto L9;
        return;
    L9:
        throw new IndexOutOfBoundsException("index (" + r100 + ") is out of bound of [0, " + r101 + ')');
    }

    public static final <R, T> R withCurrent(SnapshotStateList<T> r100, Function1<? super StateListStateRecord<T>, ? extends R> r101) {
        StateRecord r102 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");
        return r101.invoke(SnapshotKt.current((StateListStateRecord) r102));
    }

    public static final <R, T> R writable(SnapshotStateList<T> r100, Function1<? super StateListStateRecord<T>, ? extends R> r101) {
        StateRecord r102 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r103 = (StateListStateRecord) r102;
        Object r104 = SnapshotKt.getLock();
        monitor-enter(r104);
        Snapshot r105 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L10
        R r106 = r101.invoke(SnapshotKt.writableRecord(r103, r100, r105));     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(r104);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r105, r100);
        return r106;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <T> boolean conditionalUpdate(SnapshotStateList<T> r100, boolean r101, Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> r102) {
    L2:
        Object r103 = access$getSync$p();
        monitor-enter(r103);
        StateRecord r104 = r100.getFirstStateRecord();     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");     // Catch: Throwable -> L24
        StateListStateRecord r105 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r104);     // Catch: Throwable -> L24
        int r106 = r105.getModification$runtime();     // Catch: Throwable -> L24
        PersistentList<T> r107 = r105.getList$runtime();     // Catch: Throwable -> L24
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L24
        InlineMarker.finallyStart(1);
        monitor-exit(r103);
        InlineMarker.finallyEnd(1);
        Intrinsics.checkNotNull(r107);
        PersistentList<? extends T> r109 = r102.invoke(r107);
        if (Intrinsics.areEqual(r109, r107) == true) goto L10;
        StateRecord r110 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r111 = (StateListStateRecord) r110;
        Object r112 = SnapshotKt.getLock();
        monitor-enter(r112);
        Snapshot r113 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L19
        boolean r114 = attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(r111, r100, r113), r106, r109, r101);     // Catch: Throwable -> L19
        InlineMarker.finallyStart(1);
        monitor-exit(r112);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r113, r100);
        if (r114 == false) goto L2;
        return true;
    L19:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    L10:
        return false;
    L24:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <T> void update(SnapshotStateList<T> r100, boolean r101, Function1<? super PersistentList<? extends T>, ? extends PersistentList<? extends T>> r102) {
    L2:
        Object r103 = access$getSync$p();
        monitor-enter(r103);
        StateRecord r104 = r100.getFirstStateRecord();     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");     // Catch: Throwable -> L24
        StateListStateRecord r105 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r104);     // Catch: Throwable -> L24
        int r106 = r105.getModification$runtime();     // Catch: Throwable -> L24
        PersistentList<T> r107 = r105.getList$runtime();     // Catch: Throwable -> L24
        Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L24
        InlineMarker.finallyStart(1);
        monitor-exit(r103);
        InlineMarker.finallyEnd(1);
        Intrinsics.checkNotNull(r107);
        PersistentList<? extends T> r109 = r102.invoke(r107);
        if (Intrinsics.areEqual(r109, r107) == true) goto L18;
        StateRecord r110 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r111 = (StateListStateRecord) r110;
        Object r112 = SnapshotKt.getLock();
        monitor-enter(r112);
        Snapshot r113 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L19
        boolean r114 = attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(r111, r100, r113), r106, r109, r101);     // Catch: Throwable -> L19
        InlineMarker.finallyStart(1);
        monitor-exit(r112);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r113, r100);
        if (r114 == false) goto L2;
        return;
    L19:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    L18:
        return;
    L24:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <T> boolean attemptUpdate(StateListStateRecord<T> r100, int r101, PersistentList<? extends T> r102, boolean r103) {
        Object r104 = sync;
        monitor-enter(r104);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r100.getModification$runtime() != r101) goto L11;
        r100.setList$runtime(r102);     // Catch: Throwable -> L14
        boolean r105 = true;
        if (r103 == false) goto L9;
        r100.setStructuralChange$runtime(r100.getStructuralChange$runtime() + 1);     // Catch: Throwable -> L14
    L9:
        r100.setModification$runtime(r100.getModification$runtime() + 1);     // Catch: Throwable -> L14
    L12:
        monitor-exit(r104);
        return r105;
    L11:
        r105 = false;
        goto L12
    }

    public static /* synthetic */ boolean conditionalUpdate$default(SnapshotStateList r100, boolean r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = true;
    L5:
        Object r105 = access$getSync$p();
        monitor-enter(r105);
        StateRecord r106 = r100.getFirstStateRecord();     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");     // Catch: Throwable -> L26
        StateListStateRecord r107 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r106);     // Catch: Throwable -> L26
        int r108 = r107.getModification$runtime();     // Catch: Throwable -> L26
        PersistentList r109 = r107.getList$runtime();     // Catch: Throwable -> L26
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L26
        InlineMarker.finallyStart(1);
        monitor-exit(r105);
        InlineMarker.finallyEnd(1);
        Intrinsics.checkNotNull(r109);
        PersistentList r111 = (PersistentList) r102.invoke(r109);
        if (Intrinsics.areEqual(r111, r109) == true) goto L12;
        StateRecord r112 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r113 = (StateListStateRecord) r112;
        Object r114 = SnapshotKt.getLock();
        monitor-enter(r114);
        Snapshot r115 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L21
        boolean r116 = attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(r113, r100, r115), r108, r111, r101);     // Catch: Throwable -> L21
        InlineMarker.finallyStart(1);
        monitor-exit(r114);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r115, r100);
        if (r116 == false) goto L5;
        return true;
    L21:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    L12:
        return false;
    L26:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ void update$default(SnapshotStateList r100, boolean r101, Function1 r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        r101 = true;
    L5:
        Object r105 = access$getSync$p();
        monitor-enter(r105);
        StateRecord r106 = r100.getFirstStateRecord();     // Catch: Throwable -> L26
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.withCurrent>");     // Catch: Throwable -> L26
        StateListStateRecord r107 = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) r106);     // Catch: Throwable -> L26
        int r108 = r107.getModification$runtime();     // Catch: Throwable -> L26
        PersistentList r109 = r107.getList$runtime();     // Catch: Throwable -> L26
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L26
        InlineMarker.finallyStart(1);
        monitor-exit(r105);
        InlineMarker.finallyEnd(1);
        Intrinsics.checkNotNull(r109);
        PersistentList r111 = (PersistentList) r102.invoke(r109);
        if (Intrinsics.areEqual(r111, r109) == true) goto L20;
        StateRecord r112 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateListKt.writable>");
        StateListStateRecord r113 = (StateListStateRecord) r112;
        Object r114 = SnapshotKt.getLock();
        monitor-enter(r114);
        Snapshot r115 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L21
        boolean r116 = attemptUpdate((StateListStateRecord) SnapshotKt.writableRecord(r113, r100, r115), r108, r111, r101);     // Catch: Throwable -> L21
        InlineMarker.finallyStart(1);
        monitor-exit(r114);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r115, r100);
        if (r116 == false) goto L5;
        return;
    L21:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    L20:
        return;
    L26:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
