package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aC\u0010\f\u001a\u0002H\r\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001d\u0010\u000e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u0002H\r0\u000f¢\u0006\u0002\b\u0010H\u0080\b¢\u0006\u0002\u0010\u0011\u001aC\u0010\u0012\u001a\u0002H\r\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001d\u0010\u000e\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0007\u0012\u0004\u0012\u0002H\r0\u000f¢\u0006\u0002\b\u0010H\u0080\b¢\u0006\u0002\u0010\u0011\u001a2\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\u0004\u0012\u00020\u00140\u000fH\u0000\u001a>\u0010\u0016\u001a\u0002H\r\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u000e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\u0004\u0012\u0002H\r0\u000fH\u0080\b¢\u0006\u0002\u0010\u0011\u001a9\u0010\u0017\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001e\u0010\u000e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00180\u000fH\u0080\b\u001a\u0019\u0010\u0019\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0080\b\u001a.\u0010\u001b\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018H\u0000\u001a&\u0010\u001e\u001a\u00020\u001f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00020\u0018H\u0000\"$\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"0\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038@X\u0080\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0014\u0010!\u001a\u00060\"j\u0002`#X\u0082\u0004¢\u0006\u0004\n\u0002\u0010$¨\u0006%"}, d2 = {"modification", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "getModification", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;)I", "readable", "Landroidx/compose/runtime/snapshots/StateSetStateRecord;", "getReadable$annotations", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;)V", "getReadable", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;)Landroidx/compose/runtime/snapshots/StateSetStateRecord;", "writable", "R", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "withCurrent", "mutateBoolean", "", "", "mutate", "conditionalUpdate", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "clearImpl", "", "attemptUpdate", "currentModification", "newSet", "stateRecordWith", "Landroidx/compose/runtime/snapshots/StateRecord;", "set", DocumentType.DOCX_SYNC_BLOCK_NAME, "", "Landroidx/compose/runtime/platform/SynchronizedObject;", "Ljava/lang/Object;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SnapshotStateSetKt {
    private static final Object sync = null;

    public static /* synthetic */ void getReadable$annotations(SnapshotStateSet r100) {
    }

    static {
        sync = new Object();
    }

    public static final /* synthetic */ Object access$getSync$p() {
        return sync;
    }

    public static final <T> void clearImpl(SnapshotStateSet<T> r100) {
        StateRecord r101 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        StateSetStateRecord r102 = (StateSetStateRecord) r101;
        Object r103 = SnapshotKt.getLock();
        monitor-enter(r103);
        Snapshot r104 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L20
        StateSetStateRecord r105 = (StateSetStateRecord) SnapshotKt.writableRecord(r102, r100, r104);     // Catch: Throwable -> L20
        Object r106 = access$getSync$p();     // Catch: Throwable -> L20
        monitor-enter(r106);     // Catch: Throwable -> L20
        r105.setSet$runtime(ExtensionsKt.persistentSetOf());     // Catch: Throwable -> L15
        r105.setModification$runtime(r105.getModification$runtime() + 1);     // Catch: Throwable -> L15
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

    public static final <T> int getModification(SnapshotStateSet<T> r100) {
        StateRecord r101 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
        return ((StateSetStateRecord) SnapshotKt.current((StateSetStateRecord) r101)).getModification$runtime();
    }

    public static final <T> StateSetStateRecord<T> getReadable(SnapshotStateSet<T> r100) {
        StateRecord r101 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.<get-readable>>");
        return (StateSetStateRecord) SnapshotKt.readable((StateSetStateRecord) r101, r100);
    }

    public static final <T> boolean conditionalUpdate(SnapshotStateSet<T> r100, Function1<? super PersistentSet<? extends T>, ? extends PersistentSet<? extends T>> r101) {
    L2:
        Object r102 = access$getSync$p();
        monitor-enter(r102);
        StateRecord r103 = r100.getFirstStateRecord();     // Catch: Throwable -> L24
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");     // Catch: Throwable -> L24
        StateSetStateRecord r104 = (StateSetStateRecord) SnapshotKt.current((StateSetStateRecord) r103);     // Catch: Throwable -> L24
        int r105 = r104.getModification$runtime();     // Catch: Throwable -> L24
        PersistentSet<T> r106 = r104.getSet$runtime();     // Catch: Throwable -> L24
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L24
        InlineMarker.finallyStart(1);
        monitor-exit(r102);
        InlineMarker.finallyEnd(1);
        Intrinsics.checkNotNull(r106);
        PersistentSet<? extends T> r108 = r101.invoke(r106);
        if (Intrinsics.areEqual(r108, r106) == true) goto L10;
        StateRecord r109 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        StateSetStateRecord r110 = (StateSetStateRecord) r109;
        Object r111 = SnapshotKt.getLock();
        monitor-enter(r111);
        Snapshot r112 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L19
        boolean r113 = attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(r110, r100, r112), r105, r108);     // Catch: Throwable -> L19
        InlineMarker.finallyStart(1);
        monitor-exit(r111);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r112, r100);
        if (r113 == false) goto L2;
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

    public static final <R, T> R mutate(SnapshotStateSet<T> r100, Function1<? super Set<T>, ? extends R> r101) {
    L2:
        Object r102 = access$getSync$p();
        monitor-enter(r102);
        StateRecord r103 = r100.getFirstStateRecord();     // Catch: Throwable -> L30
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");     // Catch: Throwable -> L30
        StateSetStateRecord r104 = (StateSetStateRecord) SnapshotKt.current((StateSetStateRecord) r103);     // Catch: Throwable -> L30
        int r105 = r104.getModification$runtime();     // Catch: Throwable -> L30
        PersistentSet<T> r106 = r104.getSet$runtime();     // Catch: Throwable -> L30
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L30
        InlineMarker.finallyStart(1);
        monitor-exit(r102);
        InlineMarker.finallyEnd(1);
        if (r106 == null) goto L29;
        PersistentSet.Builder<T> r108 = r106.builder();
        if (r108 == null) goto L29;
        R r109 = r101.invoke(r108);
        PersistentSet<T> r110 = r108.build();
        if (Intrinsics.areEqual(r110, r106) == true) goto L27;
        StateRecord r111 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        StateSetStateRecord r112 = (StateSetStateRecord) r111;
        Object r113 = SnapshotKt.getLock();
        monitor-enter(r113);
        Snapshot r114 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L22
        boolean r115 = attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(r112, r100, r114), r105, r110);     // Catch: Throwable -> L22
        InlineMarker.finallyStart(1);
        monitor-exit(r113);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r114, r100);
        if (r115 == false) goto L2;
    L22:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        return r109;
    L29:
        throw new IllegalStateException("No set to mutate".toString());
    L30:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <T> boolean mutateBoolean(SnapshotStateSet<T> r100, Function1<? super Set<T>, Boolean> r101) {
    L2:
        Object r102 = access$getSync$p();
        monitor-enter(r102);
        StateRecord r103 = r100.getFirstStateRecord();     // Catch: Throwable -> L25
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");     // Catch: Throwable -> L25
        StateSetStateRecord r104 = (StateSetStateRecord) SnapshotKt.current((StateSetStateRecord) r103);     // Catch: Throwable -> L25
        int r105 = r104.getModification$runtime();     // Catch: Throwable -> L25
        PersistentSet<T> r106 = r104.getSet$runtime();     // Catch: Throwable -> L25
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L25
        monitor-exit(r102);
        if (r106 == null) goto L24;
        PersistentSet.Builder<T> r108 = r106.builder();
        if (r108 == null) goto L24;
        Boolean r109 = r101.invoke(r108);
        PersistentSet<T> r110 = r108.build();
        if (Intrinsics.areEqual(r110, r106) == true) goto L22;
        StateRecord r111 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        StateSetStateRecord r112 = (StateSetStateRecord) r111;
        Object r113 = SnapshotKt.getLock();
        monitor-enter(r113);
        Snapshot r114 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L18
        boolean r115 = attemptUpdate((StateSetStateRecord) SnapshotKt.writableRecord(r112, r100, r114), r105, r110);     // Catch: Throwable -> L18
        monitor-exit(r113);
        SnapshotKt.notifyWrite(r114, r100);
        if (r115 == false) goto L2;
    L18:
        th = move-exception;
        throw th;
    L22:
        return r109.booleanValue();
    L24:
        throw new IllegalStateException("No set to mutate".toString());
    L25:
        th = move-exception;
        throw th;
    }

    public static final <T> StateRecord stateRecordWith(SnapshotStateSet<T> r100, PersistentSet<? extends T> r101) {
        StateSetStateRecord r102 = new StateSetStateRecord(SnapshotKt.currentSnapshot().getSnapshotId(), r101);
        if (Snapshot.Companion.isInSnapshot() == false) goto L5;
        r102.setNext$runtime(new StateSetStateRecord(SnapshotId_jvmKt.toSnapshotId(1), r101));
    L5:
        return r102;
    }

    public static final <R, T> R withCurrent(SnapshotStateSet<T> r100, Function1<? super StateSetStateRecord<T>, ? extends R> r101) {
        StateRecord r102 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.withCurrent>");
        return r101.invoke(SnapshotKt.current((StateSetStateRecord) r102));
    }

    public static final <R, T> R writable(SnapshotStateSet<T> r100, Function1<? super StateSetStateRecord<T>, ? extends R> r101) {
        StateRecord r102 = r100.getFirstStateRecord();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.StateSetStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateSetKt.writable>");
        StateSetStateRecord r103 = (StateSetStateRecord) r102;
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

    public static final <T> boolean attemptUpdate(StateSetStateRecord<T> r100, int r101, PersistentSet<? extends T> r102) {
        Object r103 = sync;
        monitor-enter(r103);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r100.getModification$runtime() != r101) goto L8;
        r100.setSet$runtime(r102);     // Catch: Throwable -> L11
        boolean r104 = true;
        r100.setModification$runtime(r100.getModification$runtime() + 1);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r103);
        return r104;
    L8:
        r104 = false;
        goto L9
    }
}
