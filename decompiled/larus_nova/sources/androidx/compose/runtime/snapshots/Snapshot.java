package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 ]2\u00020\u0001:\u0001]B\u001d\b\u0004\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0015\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\u000bJ\b\u0010%\u001a\u00020&H\u0016J \u0010'\u001a\u00020\u00002\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020&\u0018\u00010)H&J\b\u0010*\u001a\u00020\"H&J\"\u0010+\u001a\u0002H,\"\u0004\b\u0000\u0010,2\f\u0010-\u001a\b\u0012\u0004\u0012\u0002H,0.H\u0086\b¢\u0006\u0002\u0010/J\n\u00100\u001a\u0004\u0018\u00010\u0000H\u0011J\u0012\u00101\u001a\u00020&2\b\u00102\u001a\u0004\u0018\u00010\u0000H\u0011J\b\u00103\u001a\u0004\u0018\u00010\u0000J\u0010\u00104\u001a\u00020&2\b\u00105\u001a\u0004\u0018\u00010\u0000J\u0015\u0010C\u001a\u00020&2\u0006\u00102\u001a\u00020\u0000H ¢\u0006\u0002\bDJ\u0015\u0010E\u001a\u00020&2\u0006\u00102\u001a\u00020\u0000H ¢\u0006\u0002\bFJ\u0015\u0010G\u001a\u00020&2\u0006\u0010H\u001a\u00020IH ¢\u0006\u0002\bJJ\r\u0010O\u001a\u00020&H ¢\u0006\u0002\bPJ\r\u0010Q\u001a\u00020&H\u0000¢\u0006\u0002\bRJ\r\u0010S\u001a\u00020&H\u0010¢\u0006\u0002\bTJ\r\u0010U\u001a\u00020&H\u0010¢\u0006\u0002\bVJ\r\u0010W\u001a\u00020&H\u0000¢\u0006\u0002\bXJ\r\u0010Y\u001a\u00020&H\u0000¢\u0006\u0002\bZJ\r\u0010[\u001a\u00020\nH\u0000¢\u0006\u0002\b\\R\u001a\u0010\u0005\u001a\u00020\u0006X\u0090\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\n8VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R.\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0014\u001a\u00060\u0003j\u0002`\u0004@PX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\"X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u00106\u001a\u00020\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010$\"\u0004\b8\u00109R\u0014\u0010:\u001a\u00020\nX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b;\u0010\u0011R\u0015\u0010<\u001a\u00020\"8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b=\u0010$R(\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020&\u0018\u00010)8 X¡\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0011\u001a\u0004\b?\u0010@R \u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020&\u0018\u00010)X \u0004¢\u0006\u0006\u001a\u0004\bB\u0010@R\u001a\u0010K\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010LX \u0004¢\u0006\u0006\u001a\u0004\bM\u0010N\u0082\u0001\u0004^_`a¨\u0006b"}, d2 = {"Landroidx/compose/runtime/snapshots/Snapshot;", "", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "<init>", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "id", "", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "getInvalid$runtime", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "getId$annotations", "()V", "getId", "()I", "value", "getSnapshotId", "()J", "setSnapshotId$runtime", "(J)V", "J", "writeCount", "getWriteCount$runtime", "setWriteCount$runtime", "(I)V", RootDescription.ROOT_ELEMENT, "getRoot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "readOnly", "", "getReadOnly", "()Z", "dispose", "", "takeNestedSnapshot", "readObserver", "Lkotlin/Function1;", "hasPendingChanges", "enter", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "makeCurrent", "restoreCurrent", "snapshot", "unsafeEnter", "unsafeLeave", "oldSnapshot", "disposed", "getDisposed$runtime", "setDisposed$runtime", "(Z)V", "pinningTrackingHandle", "getPinningTrackingHandle$annotations", "isPinned", "isPinned$runtime", "getReadObserver$annotations", "getReadObserver", "()Lkotlin/jvm/functions/Function1;", "writeObserver", "getWriteObserver$runtime", "nestedActivated", "nestedActivated$runtime", "nestedDeactivated", "nestedDeactivated$runtime", "recordModified", "state", "Landroidx/compose/runtime/snapshots/StateObject;", "recordModified$runtime", "modified", "Landroidx/collection/MutableScatterSet;", "getModified$runtime", "()Landroidx/collection/MutableScatterSet;", "notifyObjectsInitialized", "notifyObjectsInitialized$runtime", "closeAndReleasePinning", "closeAndReleasePinning$runtime", "closeLocked", "closeLocked$runtime", "releasePinnedSnapshotsForCloseLocked", "releasePinnedSnapshotsForCloseLocked$runtime", "validateNotDisposed", "validateNotDisposed$runtime", "releasePinnedSnapshotLocked", "releasePinnedSnapshotLocked$runtime", "takeoverPinnedSnapshot", "takeoverPinnedSnapshot$runtime", "Companion", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/NestedReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Snapshot {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    public static final int PreexistingSnapshotId = 1;
    private boolean disposed;
    private SnapshotIdSet invalid;
    private int pinningTrackingHandle;
    private long snapshotId;

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u000f\u001a\u00020\u00052\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J6\u0010\u0013\u001a\u00020\u00142\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011J\"\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019H\u0086\b¢\u0006\u0002\u0010\u001aJ\"\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0019H\u0086\b¢\u0006\u0002\u0010\u001aJO\u0010\u001d\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0005H\u0001J\u0012\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0001J0\u0010+\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010\u00052\u0006\u0010,\u001a\u00020\u00052\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0001J4\u0010.\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u0002H\u00170\u0019¢\u0006\u0002\b/H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001aJ&\u00100\u001a\u0002012\u001e\u0010-\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000103\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001202J\u001a\u00104\u001a\u0002012\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00120\u0011J\u0006\u00105\u001a\u00020\u0012J\u0006\u00106\u001a\u00020\u0012J\b\u00107\u001a\u00020\rH\u0007J\n\u00108\u001a\u0004\u0018\u00010\u0005H\u0001J\u0012\u00109\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010\u0005H\u0001R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\rX\u0086T¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003R\u001c\u0010 \u001a\u0004\u0018\u00010\u00058@X\u0081\u0004¢\u0006\f\u0012\u0004\b!\u0010\u0003\u001a\u0004\b\"\u0010\u0007R\u0019\u0010#\u001a\u00020\t*\u00020$8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0019\u0010#\u001a\u00020\t*\u00020'8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010(¨\u0006:"}, d2 = {"Landroidx/compose/runtime/snapshots/Snapshot$Companion;", "", "<init>", "()V", "current", "Landroidx/compose/runtime/snapshots/Snapshot;", "getCurrent", "()Landroidx/compose/runtime/snapshots/Snapshot;", "isInSnapshot", "", "()Z", "isApplyObserverNotificationPending", "PreexistingSnapshotId", "", "getPreexistingSnapshotId$annotations", "takeSnapshot", "readObserver", "Lkotlin/Function1;", "", "takeMutableSnapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "writeObserver", "global", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withMutableSnapshot", "R", "observe", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "createNonObservableSnapshot", "currentThreadSnapshot", "getCurrentThreadSnapshot$annotations", "getCurrentThreadSnapshot", "canBeReused", "Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;", "getCanBeReused", "(Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;)Z", "Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "(Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;)Z", "makeCurrentNonObservable", "previous", "restoreNonObservable", "nonObservable", "observer", "withoutReadObservation", "Landroidx/compose/runtime/DisallowComposableCalls;", "registerApplyObserver", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "Lkotlin/Function2;", "", "registerGlobalWriteObserver", "notifyObjectsInitialized", "sendApplyNotifications", "openSnapshotCount", "removeCurrent", "restoreCurrent", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void a(Function1 r100) {
            registerGlobalWriteObserver$lambda$6(r100);
        }

        public static /* synthetic */ void b(Function2 r100) {
            registerApplyObserver$lambda$3(r100);
        }

        public static /* synthetic */ void getCurrentThreadSnapshot$annotations() {
        }

        public static /* synthetic */ void getPreexistingSnapshotId$annotations() {
        }

        public final Snapshot createNonObservableSnapshot() {
            return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default((Snapshot) SnapshotKt.access$getThreadSnapshot$p().get(), null, false, 6, null);
        }

        public final Snapshot getCurrent() {
            return SnapshotKt.currentSnapshot();
        }

        public final Snapshot getCurrentThreadSnapshot() {
            return (Snapshot) SnapshotKt.access$getThreadSnapshot$p().get();
        }

        public final boolean isApplyObserverNotificationPending() {
            if (SnapshotKt.access$getPendingApplyObserverCount$p().get() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isInSnapshot() {
            if (SnapshotKt.access$getThreadSnapshot$p().get() == null) goto L5;
            return true;
        L5:
            return false;
        }

        public final void notifyObjectsInitialized() {
            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime();
        }

        public final int openSnapshotCount() {
            return CollectionsKt.toList(SnapshotKt.access$getOpenSnapshots$p()).size();
        }

        public final Snapshot removeCurrent() {
            Snapshot r100 = (Snapshot) SnapshotKt.access$getThreadSnapshot$p().get();
            if (r100 == null) goto L5;
            SnapshotKt.access$getThreadSnapshot$p().set(null);
        L5:
            return r100;
        }

        public final void sendApplyNotifications() {
            Object r100 = SnapshotKt.getLock();
            monitor-enter(r100);
            boolean r101 = SnapshotKt.access$getGlobalSnapshot$p().hasPendingChanges();     // Catch: Throwable -> L9
            monitor-exit(r100);
            if (r101 == false) goto L14;
            SnapshotKt.access$advanceGlobalSnapshot();
            return;
        L14:
            return;
        L9:
            th = move-exception;
            throw th;
        }

        private final boolean getCanBeReused(TransparentObserverMutableSnapshot r100) {
            if (r100.getThreadId$runtime() != Thread_jvmKt.currentThreadId()) goto L5;
            return true;
        L5:
            return false;
        }

        private static final void registerApplyObserver$lambda$3(Function2 r100) {
            Object r101 = SnapshotKt.getLock();
            monitor-enter(r101);
            SnapshotKt.access$setApplyObservers$p(CollectionsKt.minus(SnapshotKt.access$getApplyObservers$p(), r100));     // Catch: Throwable -> L7
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r101);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static final void registerGlobalWriteObserver$lambda$6(Function1 r100) {
            Object r101 = SnapshotKt.getLock();
            monitor-enter(r101);
            SnapshotKt.access$setGlobalWriteObservers$p(CollectionsKt.minus(SnapshotKt.access$getGlobalWriteObservers$p(), r100));     // Catch: Throwable -> L8
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r101);
            SnapshotKt.access$advanceGlobalSnapshot();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public final <T> T global(Function0<? extends T> r100) {
            Snapshot r101 = removeCurrent();
            T r102 = r100.invoke();     // Catch: Throwable -> L6
            InlineMarker.finallyStart(1);
            restoreCurrent(r101);
            InlineMarker.finallyEnd(1);
            return r102;
        L6:
            th = move-exception;
            InlineMarker.finallyStart(1);
            restoreCurrent(r101);
            InlineMarker.finallyEnd(1);
            throw th;
        }

        public final Snapshot makeCurrentNonObservable(Snapshot r110) {
            boolean r100 = true;
            if ((r110 instanceof TransparentObserverMutableSnapshot) == false) goto L11;
            TransparentObserverMutableSnapshot r101 = (TransparentObserverMutableSnapshot) r110;
            if (r101.getThreadId$runtime() != Thread_jvmKt.currentThreadId()) goto L7;
            boolean r102 = true;
        L8:
            if (r102 == false) goto L11;
            r101.setReadObserver$runtime(null);
            return r110;
        L7:
            r102 = false;
        L11:
            if ((r110 instanceof TransparentObserverSnapshot) == false) goto L18;
            TransparentObserverSnapshot r103 = (TransparentObserverSnapshot) r110;
            if (r103.getThreadId$runtime() == Thread_jvmKt.currentThreadId()) goto L16;
            r100 = false;
        L16:
            if (r100 == false) goto L18;
            r103.setReadObserver$runtime(null);
            return r110;
        L18:
            Snapshot r111 = SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default(r110, null, false, 6, null);
            r111.makeCurrent();
            return r111;
        }

        public final ObserverHandle registerApplyObserver(final Function2<? super Set<? extends Object>, ? super Snapshot, Unit> r100) {
            SnapshotKt.access$advanceGlobalSnapshot(SnapshotKt.access$getEmptyLambda$p());
            Object r101 = SnapshotKt.getLock();
            monitor-enter(r101);
            SnapshotKt.access$setApplyObservers$p(CollectionsKt.plus(SnapshotKt.access$getApplyObservers$p(), r100));     // Catch: Throwable -> L8
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r101);
            return new b(r100);
        L8:
            th = move-exception;
            throw th;
        }

        public final ObserverHandle registerGlobalWriteObserver(final Function1<Object, Unit> r100) {
            Object r101 = SnapshotKt.getLock();
            monitor-enter(r101);
            SnapshotKt.access$setGlobalWriteObservers$p(CollectionsKt.plus(SnapshotKt.access$getGlobalWriteObservers$p(), r100));     // Catch: Throwable -> L8
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
            monitor-exit(r101);
            SnapshotKt.access$advanceGlobalSnapshot();
            return new c(r100);
        L8:
            th = move-exception;
            throw th;
        }

        public final void restoreCurrent(Snapshot r100) {
            if (r100 == null) goto L5;
            SnapshotKt.access$getThreadSnapshot$p().set(r100);
            return;
        }

        public final Snapshot takeSnapshot(Function1<Object, Unit> r100) {
            return SnapshotKt.currentSnapshot().takeNestedSnapshot(r100);
        }

        public final <R> R withMutableSnapshot(Function0<? extends R> r100) {
            MutableSnapshot r101 = takeMutableSnapshot$default(this, null, null, 3, null);
            Snapshot r102 = r101.makeCurrent();     // Catch: Throwable -> L11
            R r103 = r100.invoke();     // Catch: Throwable -> L8
            InlineMarker.finallyStart(1);     // Catch: Throwable -> L11
            r101.restoreCurrent(r102);     // Catch: Throwable -> L11
            InlineMarker.finallyEnd(1);     // Catch: Throwable -> L11
            InlineMarker.finallyStart(1);
            r101.apply().check();
            r101.dispose();
            InlineMarker.finallyEnd(1);
            return r103;
        L8:
            th = move-exception;
            InlineMarker.finallyStart(1);     // Catch: Throwable -> L11
            r101.restoreCurrent(r102);     // Catch: Throwable -> L11
            InlineMarker.finallyEnd(1);     // Catch: Throwable -> L11
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            InlineMarker.finallyStart(1);
            r101.dispose();
            InlineMarker.finallyEnd(1);
            throw th;
        }

        public final <T> T withoutReadObservation(Function0<? extends T> r100) {
            Snapshot r101 = getCurrentThreadSnapshot();
            if (r101 == null) goto L5;
            Function1<Object, Unit> r102 = r101.getReadObserver();
        L6:
            Snapshot r103 = makeCurrentNonObservable(r101);
            T r104 = r100.invoke();     // Catch: Throwable -> L10
            InlineMarker.finallyStart(1);
            restoreNonObservable(r101, r103, r102);
            InlineMarker.finallyEnd(1);
            return r104;
        L10:
            th = move-exception;
            InlineMarker.finallyStart(1);
            restoreNonObservable(r101, r103, r102);
            InlineMarker.finallyEnd(1);
            throw th;
        L5:
            r102 = null;
            goto L6
        }

        private final boolean getCanBeReused(TransparentObserverSnapshot r100) {
            if (r100.getThreadId$runtime() != Thread_jvmKt.currentThreadId()) goto L5;
            return true;
        L5:
            return false;
        }

        public final MutableSnapshot takeMutableSnapshot(Function1<Object, Unit> r100, Function1<Object, Unit> r101) {
            Snapshot r102 = SnapshotKt.currentSnapshot();
            if ((r102 instanceof MutableSnapshot) == false) goto L5;
            MutableSnapshot r103 = (MutableSnapshot) r102;
        L6:
            if (r103 == null) goto L11;
            MutableSnapshot r104 = r103.takeNestedMutableSnapshot(r100, r101);
            if (r104 == null) goto L11;
            return r104;
        L11:
            throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot".toString());
        L5:
            r103 = null;
            goto L6
        }

        public final <T> T observe(Function1<Object, Unit> r110, Function1<Object, Unit> r111, Function0<? extends T> r112) {
            if (r110 != null) goto L6;
            if (r111 != null) goto L6;
            return r112.invoke();
        L6:
            Snapshot r100 = (Snapshot) SnapshotKt.access$getThreadSnapshot$p().get();
            MutableSnapshot r101 = null;
            if ((r100 instanceof TransparentObserverMutableSnapshot) == false) goto L20;
            TransparentObserverMutableSnapshot r102 = (TransparentObserverMutableSnapshot) r100;
            if (r102.getThreadId$runtime() != Thread_jvmKt.currentThreadId()) goto L11;
            boolean r103 = true;
        L12:
            if (r103 == false) goto L20;
            Function1<Object, Unit> r104 = r102.getReadObserver$runtime();
            Function1<Object, Unit> r105 = r102.getWriteObserver$runtime();
            ((TransparentObserverMutableSnapshot) r100).setReadObserver$runtime(SnapshotKt.mergedReadObserver$default(r110, r104, false, 4, null));     // Catch: Throwable -> L17
            ((TransparentObserverMutableSnapshot) r100).setWriteObserver$runtime(SnapshotKt.access$mergedWriteObserver(r111, r105));     // Catch: Throwable -> L17
            T r113 = r112.invoke();     // Catch: Throwable -> L17
            r102.setReadObserver$runtime(r104);
            r102.setWriteObserver$runtime(r105);
            return r113;
        L17:
            th = move-exception;
            r102.setReadObserver$runtime(r104);
            r102.setWriteObserver$runtime(r105);
            throw th;
        L11:
            r103 = false;
        L20:
            if (r100 == null) goto L29;
            if ((r100 instanceof MutableSnapshot) == true) goto L29;
            if (r110 == null) goto L26;
            Snapshot r114 = r100.takeNestedSnapshot(r110);
        L47:
            Snapshot r115 = r114.makeCurrent();     // Catch: Throwable -> L40
            T r116 = r112.invoke();     // Catch: Throwable -> L37
            r114.restoreCurrent(r115);     // Catch: Throwable -> L40
            r114.dispose();
            return r116;
        L37:
            th = move-exception;
            r114.restoreCurrent(r115);     // Catch: Throwable -> L40
            throw th;     // Catch: Throwable -> L40
        L40:
            th = move-exception;
            r114.dispose();
            throw th;
        L26:
            return r112.invoke();
        L29:
            if ((r100 instanceof MutableSnapshot) == false) goto L31;
            r101 = (MutableSnapshot) r100;
        L31:
            r114 = new TransparentObserverMutableSnapshot(r101, r110, r111, true, false);
            goto L47
        }

        public final void restoreNonObservable(Snapshot r100, Snapshot r101, Function1<Object, Unit> r102) {
            if (r100 == r101) goto L4;
            r101.restoreCurrent(r100);
            r101.dispose();
            return;
        L4:
            if ((r100 instanceof TransparentObserverMutableSnapshot) == false) goto L7;
            ((TransparentObserverMutableSnapshot) r100).setReadObserver$runtime(r102);
            return;
        L7:
            if ((r100 instanceof TransparentObserverSnapshot) == false) goto L10;
            ((TransparentObserverSnapshot) r100).setReadObserver$runtime(r102);
            return;
        L10:
            throw new IllegalStateException(("Non-transparent snapshot was reused: " + r100).toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Snapshot takeSnapshot$default(Companion r100, Function1 r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            return r100.takeSnapshot(r101);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MutableSnapshot takeMutableSnapshot$default(Companion r100, Function1 r101, Function1 r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = null;
        L9:
            return r100.takeMutableSnapshot(r101, r102);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object observe$default(Companion r100, Function1 r101, Function1 r102, Function0 r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = null;
        L9:
            return r100.observe(r101, r102, r103);
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public /* synthetic */ Snapshot(int r100, SnapshotIdSet r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public /* synthetic */ Snapshot(long r100, SnapshotIdSet r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    @Deprecated(message = "Use snapshotId instead", replaceWith = @ReplaceWith(expression = "snapshotId", imports = {}))
    public static /* synthetic */ void getId$annotations() {
    }

    private static /* synthetic */ void getPinningTrackingHandle$annotations() {
    }

    public static /* synthetic */ void getReadObserver$annotations() {
    }

    public void dispose() {
        this.disposed = true;
        Object r100 = SnapshotKt.getLock();
        monitor-enter(r100);
        releasePinnedSnapshotLocked$runtime();     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public abstract MutableScatterSet<StateObject> getModified$runtime();

    public abstract Function1<Object, Unit> getReadObserver();

    public abstract boolean getReadOnly();

    public abstract Snapshot getRoot();

    public int getWriteCount$runtime() {
        return 0;
    }

    public abstract Function1<Object, Unit> getWriteObserver$runtime();

    public abstract boolean hasPendingChanges();

    /* JADX INFO: renamed from: nestedActivated$runtime */
    public abstract void mo4287nestedActivated$runtime(Snapshot r100);

    /* JADX INFO: renamed from: nestedDeactivated$runtime */
    public abstract void mo4288nestedDeactivated$runtime(Snapshot r100);

    public abstract void notifyObjectsInitialized$runtime();

    /* JADX INFO: renamed from: recordModified$runtime */
    public abstract void mo4289recordModified$runtime(StateObject r100);

    public abstract Snapshot takeNestedSnapshot(Function1<Object, Unit> r100);

    public final void releasePinnedSnapshotLocked$runtime() {
        int r100 = this.pinningTrackingHandle;
        if (r100 < 0) goto L6;
        SnapshotKt.releasePinningLocked(r100);
        this.pinningTrackingHandle = -1;
        return;
    }

    public final int takeoverPinnedSnapshot$runtime() {
        int r100 = this.pinningTrackingHandle;
        this.pinningTrackingHandle = -1;
        return r100;
    }

    public final void validateNotDisposed$runtime() {
        if ((!this.disposed) == true) goto L6;
        PreconditionsKt.throwIllegalArgumentException("Cannot use a disposed snapshot");
        return;
    }

    public final void closeAndReleasePinning$runtime() {
        Object r100 = SnapshotKt.getLock();
        monitor-enter(r100);
        closeLocked$runtime();     // Catch: Throwable -> L7
        releasePinnedSnapshotsForCloseLocked$runtime();     // Catch: Throwable -> L7
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void closeLocked$runtime() {
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().clear(getSnapshotId()));
    }

    public int getId() {
        return (int) getSnapshotId();
    }

    public final boolean isPinned$runtime() {
        if (access$getPinningTrackingHandle$p(this) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Snapshot makeCurrent() {
        Snapshot r100 = (Snapshot) SnapshotKt.access$getThreadSnapshot$p().get();
        SnapshotKt.access$getThreadSnapshot$p().set(this);
        return r100;
    }

    public final Snapshot unsafeEnter() {
        return makeCurrent();
    }

    public final boolean getDisposed$runtime() {
        return this.disposed;
    }

    public SnapshotIdSet getInvalid$runtime() {
        return this.invalid;
    }

    public long getSnapshotId() {
        return this.snapshotId;
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime() {
        releasePinnedSnapshotLocked$runtime();
    }

    public static final /* synthetic */ int access$getPinningTrackingHandle$p(Snapshot r100) {
        return r100.pinningTrackingHandle;
    }

    public final <T> T enter(Function0<? extends T> r100) {
        Snapshot r101 = makeCurrent();
        T r102 = r100.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        restoreCurrent(r101);
        InlineMarker.finallyEnd(1);
        return r102;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        restoreCurrent(r101);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public void restoreCurrent(Snapshot r100) {
        SnapshotKt.access$getThreadSnapshot$p().set(r100);
    }

    public final void setDisposed$runtime(boolean r100) {
        this.disposed = r100;
    }

    public void setInvalid$runtime(SnapshotIdSet r100) {
        this.invalid = r100;
    }

    public void setSnapshotId$runtime(long r100) {
        this.snapshotId = r100;
    }

    public void setWriteCount$runtime(int r100) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot".toString());
    }

    public final void unsafeLeave(Snapshot r100) {
        if (SnapshotKt.access$getThreadSnapshot$p().get() != this) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        PreconditionsKt.throwIllegalStateException("Cannot leave snapshot; " + this + " is not the current snapshot");
    L8:
        restoreCurrent(r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    private Snapshot(long r100, SnapshotIdSet r101) {
        this.invalid = r101;
        this.snapshotId = r100;
        if (r100 == SnapshotKt.access$getINVALID_SNAPSHOT$p()) goto L5;
        int r102 = SnapshotKt.trackPinning(r100, getInvalid$runtime());
    L6:
        this.pinningTrackingHandle = r102;
        return;
    L5:
        r102 = -1;
        goto L6
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use id: Long constructor instead")
    private /* synthetic */ Snapshot(int r100, SnapshotIdSet r101) {
        this(SnapshotId_jvmKt.toSnapshotId(r100), r101, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Snapshot takeNestedSnapshot$default(Snapshot r100, Function1 r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = null;
    L7:
        return r100.takeNestedSnapshot(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedSnapshot");
    }
}
