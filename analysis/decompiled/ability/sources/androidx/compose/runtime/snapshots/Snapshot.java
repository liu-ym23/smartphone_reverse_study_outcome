package androidx.compose.runtime.snapshots;

import D7.v;
import S7.k;
import S7.n;
import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.InternalComposeApi;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.internal.Thread_jvmKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.RequestInfo;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 c2\u00020\u0001:\u0001cB\u001d\b\u0004\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\u0019\b\u0015\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0011\u001a\u00020\u00002\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\b¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u0000H\u0011¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0000H\u0011¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b \u0010\u001cJ\u0017\u0010\"\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\"\u0010\u001fJ\u0017\u0010$\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0000H ¢\u0006\u0004\b#\u0010\u001fJ\u0017\u0010&\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0000H ¢\u0006\u0004\b%\u0010\u001fJ\u0017\u0010+\u001a\u00020\f2\u0006\u0010(\u001a\u00020'H ¢\u0006\u0004\b)\u0010*J\u000f\u0010-\u001a\u00020\fH ¢\u0006\u0004\b,\u0010\u000eJ\u000f\u0010/\u001a\u00020\fH\u0000¢\u0006\u0004\b.\u0010\u000eJ\u000f\u00101\u001a\u00020\fH\u0010¢\u0006\u0004\b0\u0010\u000eJ\u000f\u00103\u001a\u00020\fH\u0010¢\u0006\u0004\b2\u0010\u000eJ\u000f\u00105\u001a\u00020\fH\u0000¢\u0006\u0004\b4\u0010\u000eJ\u000f\u00107\u001a\u00020\fH\u0000¢\u0006\u0004\b6\u0010\u000eJ\u000f\u0010:\u001a\u00020\tH\u0000¢\u0006\u0004\b8\u00109R\"\u0010\u0006\u001a\u00020\u00058\u0010@\u0010X\u0090\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R2\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\n\u0010@\u001a\u00060\u0002j\u0002`\u00038\u0016@PX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010F\u001a\u00020\u00138\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010\u0015\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\bK\u0010L\u0012\u0004\bM\u0010\u000eR\u001a\u0010\n\u001a\u00020\t8VX\u0097\u0004¢\u0006\f\u0012\u0004\bO\u0010\u000e\u001a\u0004\bN\u00109R$\u0010S\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\bP\u00109\"\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\u001cR\u0014\u0010W\u001a\u00020\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u0015R\u0015\u0010Y\u001a\u00020\u00138À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\u0015R(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000f8 X¡\u0004¢\u0006\f\u0012\u0004\b\\\u0010\u000e\u001a\u0004\bZ\u0010[R\"\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000f8 X \u0004¢\u0006\u0006\u001a\u0004\b]\u0010[R\u001c\u0010b\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010_8 X \u0004¢\u0006\u0006\u001a\u0004\b`\u0010a\u0082\u0001\u0004defg¨\u0006h"}, d2 = {"Landroidx/compose/runtime/snapshots/Snapshot;", "", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", AppAgent.CONSTRUCT, "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "", "id", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "LC7/r;", "dispose", "()V", "Lkotlin/Function1;", "readObserver", "takeNestedSnapshot", "(LS7/k;)Landroidx/compose/runtime/snapshots/Snapshot;", "", "hasPendingChanges", "()Z", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "block", "enter", "(LS7/a;)Ljava/lang/Object;", "makeCurrent", "()Landroidx/compose/runtime/snapshots/Snapshot;", RequestInfo.FUNCTION_SNAPSHOT, "restoreCurrent", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "unsafeEnter", "oldSnapshot", "unsafeLeave", "nestedActivated$runtime", "nestedActivated", "nestedDeactivated$runtime", "nestedDeactivated", "Landroidx/compose/runtime/snapshots/StateObject;", "state", "recordModified$runtime", "(Landroidx/compose/runtime/snapshots/StateObject;)V", "recordModified", "notifyObjectsInitialized$runtime", "notifyObjectsInitialized", "closeAndReleasePinning$runtime", "closeAndReleasePinning", "closeLocked$runtime", "closeLocked", "releasePinnedSnapshotsForCloseLocked$runtime", "releasePinnedSnapshotsForCloseLocked", "validateNotDisposed$runtime", "validateNotDisposed", "releasePinnedSnapshotLocked$runtime", "releasePinnedSnapshotLocked", "takeoverPinnedSnapshot$runtime", "()I", "takeoverPinnedSnapshot", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getInvalid$runtime", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "value", "J", "getSnapshotId", "()J", "setSnapshotId$runtime", "(J)V", "disposed", "Z", "getDisposed$runtime", "setDisposed$runtime", "(Z)V", "pinningTrackingHandle", "I", "getPinningTrackingHandle$annotations", "getId", "getId$annotations", "getWriteCount$runtime", "setWriteCount$runtime", "(I)V", "writeCount", "getRoot", "root", "getReadOnly", "readOnly", "isPinned$runtime", "isPinned", "getReadObserver", "()LS7/k;", "getReadObserver$annotations", "getWriteObserver$runtime", "writeObserver", "Landroidx/collection/MutableScatterSet;", "getModified$runtime", "()Landroidx/collection/MutableScatterSet;", "modified", "Companion", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/NestedReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Snapshot {
    public static final int PreexistingSnapshotId = 1;
    private boolean disposed;
    private SnapshotIdSet invalid;
    private int pinningTrackingHandle;
    private long snapshotId;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\u00072\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ=\u0010\f\u001a\u00020\u000b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ$\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0086\b¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0086\b¢\u0006\u0004\b\u0014\u0010\u0012JQ\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010\u001e\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ6\u0010!\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0002\b H\u0086\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b!\u0010\u0012J-\u0010%\u001a\u00020$2\u001e\u0010\u001d\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010#\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\"¢\u0006\u0004\b%\u0010&J!\u0010'\u001a\u00020$2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0005¢\u0006\u0004\b)\u0010\u0003J\r\u0010*\u001a\u00020\u0005¢\u0006\u0004\b*\u0010\u0003J\u000f\u0010,\u001a\u00020+H\u0007¢\u0006\u0004\b,\u0010-J\u0011\u0010.\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b.\u0010\u0018J\u0019\u0010/\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b/\u00100R\u0011\u00102\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b1\u0010\u0018R\u0011\u00104\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0011\u00106\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b6\u00105R\u001c\u00109\u001a\u0004\u0018\u00010\u00078@X\u0081\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0003\u001a\u0004\b7\u0010\u0018R\u001a\u0010:\u001a\u00020+8\u0006X\u0086T¢\u0006\f\n\u0004\b:\u0010;\u0012\u0004\b<\u0010\u0003R\u0019\u0010@\u001a\u000203*\u00020=8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0019\u0010@\u001a\u000203*\u00020A8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010B¨\u0006C"}, d2 = {"Landroidx/compose/runtime/snapshots/Snapshot$Companion;", "", AppAgent.CONSTRUCT, "()V", "Lkotlin/Function1;", "LC7/r;", "readObserver", "Landroidx/compose/runtime/snapshots/Snapshot;", "takeSnapshot", "(LS7/k;)Landroidx/compose/runtime/snapshots/Snapshot;", "writeObserver", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "takeMutableSnapshot", "(LS7/k;LS7/k;)Landroidx/compose/runtime/snapshots/MutableSnapshot;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "block", "global", "(LS7/a;)Ljava/lang/Object;", "R", "withMutableSnapshot", "observe", "(LS7/k;LS7/k;LS7/a;)Ljava/lang/Object;", "createNonObservableSnapshot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "previous", "makeCurrentNonObservable", "(Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/Snapshot;", "nonObservable", "observer", "restoreNonObservable", "(Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/Snapshot;LS7/k;)V", "Landroidx/compose/runtime/DisallowComposableCalls;", "withoutReadObservation", "Lkotlin/Function2;", "", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "registerApplyObserver", "(LS7/n;)Landroidx/compose/runtime/snapshots/ObserverHandle;", "registerGlobalWriteObserver", "(LS7/k;)Landroidx/compose/runtime/snapshots/ObserverHandle;", "notifyObjectsInitialized", "sendApplyNotifications", "", "openSnapshotCount", "()I", "removeCurrent", "restoreCurrent", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "getCurrent", "current", "", "isInSnapshot", "()Z", "isApplyObserverNotificationPending", "getCurrentThreadSnapshot", "getCurrentThreadSnapshot$annotations", "currentThreadSnapshot", "PreexistingSnapshotId", "I", "getPreexistingSnapshotId$annotations", "Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;", "getCanBeReused", "(Landroidx/compose/runtime/snapshots/TransparentObserverMutableSnapshot;)Z", "canBeReused", "Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "(Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;)Z", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }

        private final boolean getCanBeReused(TransparentObserverMutableSnapshot transparentObserverMutableSnapshot) {
            return transparentObserverMutableSnapshot.getThreadId() == Thread_jvmKt.currentThreadId();
        }

        public static /* synthetic */ void getCurrentThreadSnapshot$annotations() {
        }

        public static /* synthetic */ void getPreexistingSnapshotId$annotations() {
        }

        public static /* synthetic */ Object observe$default(Companion companion, k kVar, k kVar2, S7.a aVar, int i, Object obj) {
            if ((i & 1) != 0) {
                kVar = null;
            }
            if ((i & 2) != 0) {
                kVar2 = null;
            }
            return companion.observe(kVar, kVar2, aVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void registerApplyObserver$lambda$3(n nVar) {
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.applyObservers = v.N0(SnapshotKt.applyObservers, nVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void registerGlobalWriteObserver$lambda$6(k kVar) {
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.globalWriteObservers = v.N0(SnapshotKt.globalWriteObservers, kVar);
            }
            SnapshotKt.advanceGlobalSnapshot();
        }

        public static /* synthetic */ MutableSnapshot takeMutableSnapshot$default(Companion companion, k kVar, k kVar2, int i, Object obj) {
            if ((i & 1) != 0) {
                kVar = null;
            }
            if ((i & 2) != 0) {
                kVar2 = null;
            }
            return companion.takeMutableSnapshot(kVar, kVar2);
        }

        public static /* synthetic */ Snapshot takeSnapshot$default(Companion companion, k kVar, int i, Object obj) {
            if ((i & 1) != 0) {
                kVar = null;
            }
            return companion.takeSnapshot(kVar);
        }

        public final Snapshot createNonObservableSnapshot() {
            return SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default((Snapshot) SnapshotKt.threadSnapshot.get(), null, false, 6, null);
        }

        public final Snapshot getCurrent() {
            return SnapshotKt.currentSnapshot();
        }

        public final Snapshot getCurrentThreadSnapshot() {
            return (Snapshot) SnapshotKt.threadSnapshot.get();
        }

        public final <T> T global(S7.a block) {
            Snapshot snapshotRemoveCurrent = removeCurrent();
            try {
                return (T) block.invoke();
            } finally {
                restoreCurrent(snapshotRemoveCurrent);
            }
        }

        public final boolean isApplyObserverNotificationPending() {
            return SnapshotKt.pendingApplyObserverCount.get() > 0;
        }

        public final boolean isInSnapshot() {
            return SnapshotKt.threadSnapshot.get() != null;
        }

        public final Snapshot makeCurrentNonObservable(Snapshot previous) {
            if (previous instanceof TransparentObserverMutableSnapshot) {
                TransparentObserverMutableSnapshot transparentObserverMutableSnapshot = (TransparentObserverMutableSnapshot) previous;
                if (transparentObserverMutableSnapshot.getThreadId() == Thread_jvmKt.currentThreadId()) {
                    transparentObserverMutableSnapshot.setReadObserver$runtime(null);
                    return previous;
                }
            }
            if (previous instanceof TransparentObserverSnapshot) {
                TransparentObserverSnapshot transparentObserverSnapshot = (TransparentObserverSnapshot) previous;
                if (transparentObserverSnapshot.getThreadId$runtime() == Thread_jvmKt.currentThreadId()) {
                    transparentObserverSnapshot.setReadObserver$runtime(null);
                    return previous;
                }
            }
            Snapshot snapshotCreateTransparentSnapshotWithNoParentReadObserver$default = SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default(previous, null, false, 6, null);
            snapshotCreateTransparentSnapshotWithNoParentReadObserver$default.makeCurrent();
            return snapshotCreateTransparentSnapshotWithNoParentReadObserver$default;
        }

        public final void notifyObjectsInitialized() {
            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime();
        }

        public final <T> T observe(k readObserver, k writeObserver, S7.a block) {
            Snapshot transparentObserverMutableSnapshot;
            if (readObserver == null && writeObserver == null) {
                return (T) block.invoke();
            }
            Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
            if (snapshot instanceof TransparentObserverMutableSnapshot) {
                TransparentObserverMutableSnapshot transparentObserverMutableSnapshot2 = (TransparentObserverMutableSnapshot) snapshot;
                if (transparentObserverMutableSnapshot2.getThreadId() == Thread_jvmKt.currentThreadId()) {
                    k readObserver$runtime = transparentObserverMutableSnapshot2.getReadObserver();
                    k writeObserver$runtime = transparentObserverMutableSnapshot2.getWriteObserver();
                    try {
                        ((TransparentObserverMutableSnapshot) snapshot).setReadObserver$runtime(SnapshotKt.mergedReadObserver$default(readObserver, readObserver$runtime, false, 4, null));
                        ((TransparentObserverMutableSnapshot) snapshot).setWriteObserver$runtime(SnapshotKt.mergedWriteObserver(writeObserver, writeObserver$runtime));
                        return (T) block.invoke();
                    } finally {
                        transparentObserverMutableSnapshot2.setReadObserver$runtime(readObserver$runtime);
                        transparentObserverMutableSnapshot2.setWriteObserver$runtime(writeObserver$runtime);
                    }
                }
            }
            if (snapshot == null || (snapshot instanceof MutableSnapshot)) {
                transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, readObserver, writeObserver, true, false);
            } else {
                if (readObserver == null) {
                    return (T) block.invoke();
                }
                transparentObserverMutableSnapshot = snapshot.takeNestedSnapshot(readObserver);
            }
            try {
                Snapshot snapshotMakeCurrent = transparentObserverMutableSnapshot.makeCurrent();
                try {
                    T t9 = (T) block.invoke();
                    transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    transparentObserverMutableSnapshot.dispose();
                    return t9;
                } catch (Throwable th) {
                    transparentObserverMutableSnapshot.restoreCurrent(snapshotMakeCurrent);
                    throw th;
                }
            } catch (Throwable th2) {
                transparentObserverMutableSnapshot.dispose();
                throw th2;
            }
        }

        @InternalComposeApi
        public final int openSnapshotCount() {
            return v.f1(SnapshotKt.openSnapshots).size();
        }

        public final ObserverHandle registerApplyObserver(n observer) {
            SnapshotKt.advanceGlobalSnapshot(SnapshotKt.emptyLambda);
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.applyObservers = v.R0(SnapshotKt.applyObservers, observer);
            }
            return new a(observer, 0);
        }

        public final ObserverHandle registerGlobalWriteObserver(k observer) {
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.globalWriteObservers = v.R0(SnapshotKt.globalWriteObservers, observer);
            }
            SnapshotKt.advanceGlobalSnapshot();
            return new a(observer, 1);
        }

        public final Snapshot removeCurrent() {
            Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
            if (snapshot != null) {
                SnapshotKt.threadSnapshot.set(null);
            }
            return snapshot;
        }

        public final void restoreCurrent(Snapshot previous) {
            if (previous != null) {
                SnapshotKt.threadSnapshot.set(previous);
            }
        }

        public final void restoreNonObservable(Snapshot previous, Snapshot nonObservable, k observer) {
            if (previous != nonObservable) {
                nonObservable.restoreCurrent(previous);
                nonObservable.dispose();
            } else if (previous instanceof TransparentObserverMutableSnapshot) {
                ((TransparentObserverMutableSnapshot) previous).setReadObserver$runtime(observer);
            } else if (previous instanceof TransparentObserverSnapshot) {
                ((TransparentObserverSnapshot) previous).setReadObserver$runtime(observer);
            } else {
                throw new IllegalStateException(("Non-transparent snapshot was reused: " + previous).toString());
            }
        }

        public final void sendApplyNotifications() {
            boolean zHasPendingChanges;
            synchronized (SnapshotKt.getLock()) {
                zHasPendingChanges = SnapshotKt.globalSnapshot.hasPendingChanges();
            }
            if (zHasPendingChanges) {
                SnapshotKt.advanceGlobalSnapshot();
            }
        }

        public final MutableSnapshot takeMutableSnapshot(k readObserver, k writeObserver) {
            MutableSnapshot mutableSnapshotTakeNestedMutableSnapshot;
            Snapshot snapshotCurrentSnapshot = SnapshotKt.currentSnapshot();
            MutableSnapshot mutableSnapshot = snapshotCurrentSnapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshotCurrentSnapshot : null;
            if (mutableSnapshot == null || (mutableSnapshotTakeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(readObserver, writeObserver)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            return mutableSnapshotTakeNestedMutableSnapshot;
        }

        public final Snapshot takeSnapshot(k readObserver) {
            return SnapshotKt.currentSnapshot().takeNestedSnapshot(readObserver);
        }

        public final <R> R withMutableSnapshot(S7.a block) {
            MutableSnapshot mutableSnapshotTakeMutableSnapshot$default = takeMutableSnapshot$default(this, null, null, 3, null);
            try {
                Snapshot snapshotMakeCurrent = mutableSnapshotTakeMutableSnapshot$default.makeCurrent();
                try {
                    R r5 = (R) block.invoke();
                    mutableSnapshotTakeMutableSnapshot$default.apply().check();
                    return r5;
                } finally {
                    mutableSnapshotTakeMutableSnapshot$default.restoreCurrent(snapshotMakeCurrent);
                }
            } finally {
            }
        }

        public final <T> T withoutReadObservation(S7.a block) {
            Snapshot currentThreadSnapshot = getCurrentThreadSnapshot();
            k readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = makeCurrentNonObservable(currentThreadSnapshot);
            try {
                return (T) block.invoke();
            } finally {
                restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            }
        }

        private Companion() {
        }

        private final boolean getCanBeReused(TransparentObserverSnapshot transparentObserverSnapshot) {
            return transparentObserverSnapshot.getThreadId$runtime() == Thread_jvmKt.currentThreadId();
        }
    }

    public /* synthetic */ Snapshot(int i, SnapshotIdSet snapshotIdSet, kotlin.jvm.internal.e eVar) {
        this(i, snapshotIdSet);
    }

    @C7.c
    public static /* synthetic */ void getId$annotations() {
    }

    private static /* synthetic */ void getPinningTrackingHandle$annotations() {
    }

    public static /* synthetic */ void getReadObserver$annotations() {
    }

    public static /* synthetic */ Snapshot takeNestedSnapshot$default(Snapshot snapshot, k kVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: takeNestedSnapshot");
        }
        if ((i & 1) != 0) {
            kVar = null;
        }
        return snapshot.takeNestedSnapshot(kVar);
    }

    public final void closeAndReleasePinning$runtime() {
        synchronized (SnapshotKt.getLock()) {
            closeLocked$runtime();
            releasePinnedSnapshotsForCloseLocked$runtime();
        }
    }

    public void closeLocked$runtime() {
        SnapshotKt.openSnapshots = SnapshotKt.openSnapshots.clear(getSnapshotId());
    }

    public void dispose() {
        this.disposed = true;
        synchronized (SnapshotKt.getLock()) {
            releasePinnedSnapshotLocked$runtime();
        }
    }

    public final <T> T enter(S7.a block) {
        Snapshot snapshotMakeCurrent = makeCurrent();
        try {
            return (T) block.invoke();
        } finally {
            restoreCurrent(snapshotMakeCurrent);
        }
    }

    /* renamed from: getDisposed$runtime, reason: from getter */
    public final boolean getDisposed() {
        return this.disposed;
    }

    public int getId() {
        return (int) getSnapshotId();
    }

    /* renamed from: getInvalid$runtime, reason: from getter */
    public SnapshotIdSet getInvalid() {
        return this.invalid;
    }

    public abstract MutableScatterSet<StateObject> getModified$runtime();

    public abstract k getReadObserver();

    public abstract boolean getReadOnly();

    public abstract Snapshot getRoot();

    public long getSnapshotId() {
        return this.snapshotId;
    }

    public int getWriteCount$runtime() {
        return 0;
    }

    /* renamed from: getWriteObserver$runtime */
    public abstract k getWriteObserver();

    public abstract boolean hasPendingChanges();

    public final boolean isPinned$runtime() {
        return this.pinningTrackingHandle >= 0;
    }

    public Snapshot makeCurrent() {
        Snapshot snapshot = (Snapshot) SnapshotKt.threadSnapshot.get();
        SnapshotKt.threadSnapshot.set(this);
        return snapshot;
    }

    /* renamed from: nestedActivated$runtime */
    public abstract void mo3594nestedActivated$runtime(Snapshot snapshot);

    /* renamed from: nestedDeactivated$runtime */
    public abstract void mo3595nestedDeactivated$runtime(Snapshot snapshot);

    public abstract void notifyObjectsInitialized$runtime();

    /* renamed from: recordModified$runtime */
    public abstract void mo3596recordModified$runtime(StateObject state);

    public final void releasePinnedSnapshotLocked$runtime() {
        int i = this.pinningTrackingHandle;
        if (i >= 0) {
            SnapshotKt.releasePinningLocked(i);
            this.pinningTrackingHandle = -1;
        }
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime() {
        releasePinnedSnapshotLocked$runtime();
    }

    public void restoreCurrent(Snapshot snapshot) {
        SnapshotKt.threadSnapshot.set(snapshot);
    }

    public final void setDisposed$runtime(boolean z10) {
        this.disposed = z10;
    }

    public void setInvalid$runtime(SnapshotIdSet snapshotIdSet) {
        this.invalid = snapshotIdSet;
    }

    public void setSnapshotId$runtime(long j5) {
        this.snapshotId = j5;
    }

    public void setWriteCount$runtime(int i) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot");
    }

    public abstract Snapshot takeNestedSnapshot(k readObserver);

    public final int takeoverPinnedSnapshot$runtime() {
        int i = this.pinningTrackingHandle;
        this.pinningTrackingHandle = -1;
        return i;
    }

    public final Snapshot unsafeEnter() {
        return makeCurrent();
    }

    public final void unsafeLeave(Snapshot oldSnapshot) {
        if (!(SnapshotKt.threadSnapshot.get() == this)) {
            PreconditionsKt.throwIllegalStateException("Cannot leave snapshot; " + this + " is not the current snapshot");
        }
        restoreCurrent(oldSnapshot);
    }

    public final void validateNotDisposed$runtime() {
        if (this.disposed) {
            PreconditionsKt.throwIllegalArgumentException("Cannot use a disposed snapshot");
        }
    }

    public /* synthetic */ Snapshot(long j5, SnapshotIdSet snapshotIdSet, kotlin.jvm.internal.e eVar) {
        this(j5, snapshotIdSet);
    }

    private Snapshot(long j5, SnapshotIdSet snapshotIdSet) {
        this.invalid = snapshotIdSet;
        this.snapshotId = j5;
        this.pinningTrackingHandle = j5 != SnapshotKt.INVALID_SNAPSHOT ? SnapshotKt.trackPinning(j5, getInvalid()) : -1;
    }

    @C7.c
    private /* synthetic */ Snapshot(int i, SnapshotIdSet snapshotIdSet) {
        this(SnapshotId_jvmKt.toSnapshotId(i), snapshotIdSet, (kotlin.jvm.internal.e) null);
    }
}
