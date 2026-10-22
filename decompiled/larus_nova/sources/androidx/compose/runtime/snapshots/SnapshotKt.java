package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.internal.SnapshotThreadLocal;
import androidx.compose.runtime.internal.WeakReference;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0001\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a!\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\u0010\u0007\u001a\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0000\u001a\b\u0010\u000b\u001a\u00020\fH\u0000\u001a4\u0010\u0011\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0002\u001aL\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u0016H\u0002\u001aB\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t\u0018\u00010\u000eH\u0002\u001a/\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010(2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H(0*H\u0081\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010+\u001a>\u0010>\u001a\u0002H(\"\u0004\b\u0000\u0010(2\u0006\u00108\u001a\u0002092!\u0010)\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u0002H(0\u000eH\u0002¢\u0006\u0002\u0010?\u001a6\u0010B\u001a\u0002H(\"\u0004\b\u0000\u0010(2!\u0010)\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u0002H(0\u000eH\u0002¢\u0006\u0002\u0010C\u001a\b\u0010B\u001a\u00020\tH\u0002\u001a:\u0010D\u001a\u0002H(\"\b\b\u0000\u0010(*\u00020\f2!\u0010)\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u0002H(0\u000eH\u0002¢\u0006\u0002\u0010E\u001a\u0010\u0010F\u001a\u00020\t2\u0006\u0010G\u001a\u00020\fH\u0002\u001a-\u0010H\u001a\u00020\u00162\n\u0010\u000b\u001a\u00060\u0003j\u0002`\u00042\n\u0010I\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010J\u001a)\u0010H\u001a\u00020\u00162\u0006\u0010K\u001a\u00020L2\n\u0010G\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010M\u001a5\u0010N\u001a\u0004\u0018\u0001H(\"\b\b\u0000\u0010(*\u00020L2\u0006\u0010O\u001a\u0002H(2\n\u0010P\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010Q\u001a!\u0010N\u001a\u0002H(\"\b\b\u0000\u0010(*\u00020L*\u0002H(2\u0006\u0010R\u001a\u000202¢\u0006\u0002\u0010S\u001a)\u0010N\u001a\u0002H(\"\b\b\u0000\u0010(*\u00020L*\u0002H(2\u0006\u0010R\u001a\u0002022\u0006\u0010G\u001a\u00020\f¢\u0006\u0002\u0010T\u001a\b\u0010U\u001a\u00020VH\u0002\u001a\u0012\u0010W\u001a\u0004\u0018\u00010L2\u0006\u0010R\u001a\u000202H\u0002\u001a\u0010\u0010X\u001a\u00020\u00162\u0006\u0010R\u001a\u000202H\u0002\u001a!\u0010Y\u001a\u00020L*\u00020L2\u0012\u0010Z\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u00160\u000eH\u0082\b\u001a\b\u0010[\u001a\u00020\tH\u0002\u001a\u0010\u0010\\\u001a\u00020\t2\u0006\u0010R\u001a\u000202H\u0002\u001a+\u0010]\u001a\u0002H(\"\b\b\u0000\u0010(*\u00020L*\u0002H(2\u0006\u0010R\u001a\u0002022\u0006\u0010G\u001a\u00020\fH\u0001¢\u0006\u0002\u0010T\u001a3\u0010^\u001a\u0002H(\"\b\b\u0000\u0010(*\u00020L*\u0002H(2\u0006\u0010R\u001a\u0002022\u0006\u0010G\u001a\u00020\f2\u0006\u0010_\u001a\u0002H(H\u0000¢\u0006\u0002\u0010`\u001a+\u0010a\u001a\u0002H(\"\b\b\u0000\u0010(*\u00020L*\u0002H(2\u0006\u0010R\u001a\u0002022\u0006\u0010G\u001a\u00020\fH\u0000¢\u0006\u0002\u0010T\u001a+\u0010b\u001a\u0002H(\"\b\b\u0000\u0010(*\u00020L*\u0002H(2\u0006\u0010R\u001a\u0002022\u0006\u0010G\u001a\u00020\fH\u0002¢\u0006\u0002\u0010T\u001a#\u0010c\u001a\u0002H(\"\b\b\u0000\u0010(*\u00020L*\u0002H(2\u0006\u0010R\u001a\u000202H\u0000¢\u0006\u0002\u0010S\u001a\u0018\u0010d\u001a\u00020\t2\u0006\u0010G\u001a\u00020\f2\u0006\u0010R\u001a\u000202H\u0001\u001aK\u0010e\u001a\u0002Hf\"\b\b\u0000\u0010(*\u00020L\"\u0004\b\u0001\u0010f*\u0002H(2\u0006\u0010R\u001a\u0002022\u0006\u0010G\u001a\u00020\f2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002Hf0\u000e¢\u0006\u0002\bgH\u0086\b¢\u0006\u0002\u0010h\u001aC\u0010e\u001a\u0002Hf\"\b\b\u0000\u0010(*\u00020L\"\u0004\b\u0001\u0010f*\u0002H(2\u0006\u0010R\u001a\u0002022\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002Hf0\u000e¢\u0006\u0002\bgH\u0086\b¢\u0006\u0002\u0010i\u001aK\u0010j\u001a\u0002Hf\"\b\b\u0000\u0010(*\u00020L\"\u0004\b\u0001\u0010f*\u0002H(2\u0006\u0010R\u001a\u0002022\u0006\u0010_\u001a\u0002H(2\u0017\u0010)\u001a\u0013\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002Hf0\u000e¢\u0006\u0002\bgH\u0080\b¢\u0006\u0002\u0010k\u001a7\u0010l\u001a\u0010\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020L\u0018\u00010m2\n\u0010n\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010r\u001a\b\u0010s\u001a\u00020VH\u0002\u001a'\u0010t\u001a\u0002H(\"\b\b\u0000\u0010(*\u00020L2\u0006\u0010O\u001a\u0002H(2\u0006\u0010G\u001a\u00020\fH\u0001¢\u0006\u0002\u0010u\u001a\u001f\u0010t\u001a\u0002H(\"\b\b\u0000\u0010(*\u00020L2\u0006\u0010O\u001a\u0002H(H\u0001¢\u0006\u0002\u0010v\u001aE\u0010w\u001a\u0002Hf\"\b\b\u0000\u0010(*\u00020L\"\u0004\b\u0001\u0010f*\u0002H(2!\u0010)\u001a\u001d\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(O\u0012\u0004\u0012\u0002Hf0\u000eH\u0086\b¢\u0006\u0002\u0010x\u001a)\u0010y\u001a\u00020\u0006*\u00020\u00062\n\u0010z\u001a\u00060\u0003j\u0002`\u00042\n\u0010{\u001a\u00060\u0003j\u0002`\u0004H\u0000¢\u0006\u0002\u0010|\")\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\t0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u001c\u001a\u00060\u0003j\u0002`\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d\"\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000\"\"\u0010 \u001a\u00060\u0014j\u0002`!8\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010&\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u000e\u0010,\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0014\u0010-\u001a\u00060\u0003j\u0002`\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001d\"\u000e\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020201X\u0082\u0004¢\u0006\u0002\n\u0000\",\u00103\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001406\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0504X\u0082\u000e¢\u0006\u0002\n\u0000\" \u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u000e04X\u0082\u000e¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010:\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b;\u0010#\u001a\u0004\b<\u0010=\"\u000e\u0010@\u001a\u00020AX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"trackPinning", "", "snapshotId", "", "Landroidx/compose/runtime/snapshots/SnapshotId;", "invalid", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)I", "releasePinningLocked", "", "handle", "currentSnapshot", "Landroidx/compose/runtime/snapshots/Snapshot;", "emptyLambda", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "createTransparentSnapshotWithNoParentReadObserver", "previousSnapshot", "readObserver", "", "ownsPreviousSnapshot", "", "mergedReadObserver", "parentObserver", "mergeReadObserver", "mergedWriteObserver", "writeObserver", "INVALID_SNAPSHOT", "J", "threadSnapshot", "Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "lock", "Landroidx/compose/runtime/platform/SynchronizedObject;", "getLock$annotations", "()V", "getLock", "()Ljava/lang/Object;", "Ljava/lang/Object;", DocumentType.DOCX_SYNC_BLOCK_NAME, ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "openSnapshots", "nextSnapshotId", "pinningTable", "Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "extraStateObjects", "Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "Landroidx/compose/runtime/snapshots/StateObject;", "applyObservers", "", "Lkotlin/Function2;", "", "globalWriteObservers", "globalSnapshot", "Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "snapshotInitializer", "getSnapshotInitializer$annotations", "getSnapshotInitializer", "()Landroidx/compose/runtime/snapshots/Snapshot;", "resetGlobalSnapshotLocked", "(Landroidx/compose/runtime/snapshots/GlobalSnapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "pendingApplyObserverCount", "Landroidx/compose/runtime/internal/AtomicInt;", "advanceGlobalSnapshot", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "takeNewSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "validateOpen", "snapshot", "valid", "candidateSnapshot", "(JJLandroidx/compose/runtime/snapshots/SnapshotIdSet;)Z", "data", "Landroidx/compose/runtime/snapshots/StateRecord;", "(Landroidx/compose/runtime/snapshots/StateRecord;JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)Z", "readable", "r", "id", "(Landroidx/compose/runtime/snapshots/StateRecord;JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/StateRecord;", "state", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "readError", "", "usedLocked", "overwriteUnusedRecordsLocked", "findYoungestOr", "predicate", "checkAndOverwriteUnusedRecordsLocked", "processForUnusedRecordsLocked", "writableRecord", "overwritableRecord", "candidate", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecord", "newWritableRecordLocked", "newOverwritableRecordLocked", "notifyWrite", "writable", "R", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "overwritable", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "optimisticMerges", "", "currentSnapshotId", "applyingSnapshot", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "invalidSnapshots", "(JLandroidx/compose/runtime/snapshots/MutableSnapshot;Landroidx/compose/runtime/snapshots/SnapshotIdSet;)Ljava/util/Map;", "reportReadonlySnapshotWrite", "current", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "(Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "withCurrent", "(Landroidx/compose/runtime/snapshots/StateRecord;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "addRange", "from", "until", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;JJ)Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SnapshotKt {
    private static final long INVALID_SNAPSHOT = 0;
    private static List<? extends Function2<? super Set<? extends Object>, ? super Snapshot, Unit>> applyObservers;
    private static final Function1<SnapshotIdSet, Unit> emptyLambda = null;
    private static final SnapshotWeakSet<StateObject> extraStateObjects = null;
    private static final GlobalSnapshot globalSnapshot = null;
    private static List<? extends Function1<Object, Unit>> globalWriteObservers;
    private static final Object lock = null;
    private static long nextSnapshotId;
    private static SnapshotIdSet openSnapshots;
    private static AtomicInt pendingApplyObserverCount;
    private static final SnapshotDoubleIndexHeap pinningTable = null;
    private static final Snapshot snapshotInitializer = null;
    private static final SnapshotThreadLocal<Snapshot> threadSnapshot = null;

    public static /* synthetic */ Unit a(SnapshotIdSet r100) {
        return emptyLambda$lambda$1(r100);
    }

    public static /* synthetic */ Unit b(Function1 r100, Function1 r101, Object r102) {
        return mergedWriteObserver$lambda$3(r100, r101, r102);
    }

    public static /* synthetic */ Unit c(Function1 r100, Function1 r101, Object r102) {
        return mergedReadObserver$lambda$2(r100, r101, r102);
    }

    public static /* synthetic */ Snapshot d(Function1 r100, SnapshotIdSet r101) {
        return takeNewSnapshot$lambda$12(r100, r101);
    }

    public static /* synthetic */ void getLock$annotations() {
    }

    public static /* synthetic */ void getSnapshotInitializer$annotations() {
    }

    static {
        emptyLambda = new e();
        threadSnapshot = new SnapshotThreadLocal();
        lock = new Object();
        SnapshotIdSet.Companion r100 = SnapshotIdSet.Companion;
        openSnapshots = r100.getEMPTY();
        long r101 = 1;
        nextSnapshotId = SnapshotId_jvmKt.toSnapshotId(1) + r101;
        pinningTable = new SnapshotDoubleIndexHeap();
        extraStateObjects = new SnapshotWeakSet();
        applyObservers = CollectionsKt.emptyList();
        globalWriteObservers = CollectionsKt.emptyList();
        long r102 = nextSnapshotId;
        nextSnapshotId = r101 + r102;
        GlobalSnapshot r103 = new GlobalSnapshot(r102, r100.getEMPTY());
        openSnapshots = openSnapshots.set(r103.getSnapshotId());
        globalSnapshot = r103;
        snapshotInitializer = r103;
        pendingApplyObserverCount = new AtomicInt(0);
    }

    private static final void advanceGlobalSnapshot() {
        advanceGlobalSnapshot(emptyLambda);
    }

    private static final void checkAndOverwriteUnusedRecordsLocked() {
        SnapshotWeakSet<StateObject> r100 = extraStateObjects;
        int r101 = r100.getSize$runtime();
        int r102 = 0;
        int r103 = 0;
    L3:
        StateObject r104 = null;
        if (r102 >= r101) goto L15;
        WeakReference<StateObject> r105 = r100.getValues$runtime()[r102];
        if (r105 == null) goto L8;
        r104 = r105.get();
    L8:
        if (r104 == null) goto L14;
        if ((!overwriteUnusedRecordsLocked(r104)) == true) goto L14;
        if (r103 == r102) goto L13;
        r100.getValues$runtime()[r103] = r105;
        r100.getHashes$runtime()[r103] = r100.getHashes$runtime()[r102];
    L13:
        r103 = r103 + 1;
    L14:
        r102 = r102 + 1;
        goto L3
    L15:
        int r106 = r103;
    L16:
        if (r106 >= r101) goto L18;
        r100.getValues$runtime()[r106] = null;
        r100.getHashes$runtime()[r106] = 0;
        r106 = r106 + 1;
        goto L16
    L18:
        if (r103 == r101) goto L26;
        r100.setSize$runtime(r103);
        return;
    }

    public static final Snapshot currentSnapshot() {
        Snapshot r100 = threadSnapshot.get();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return globalSnapshot;
    }

    private static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied".toString());
    }

    private static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot".toString());
    }

    public static final /* synthetic */ Void access$readError() {
        return readError();
    }

    public static final /* synthetic */ Void access$reportReadonlySnapshotWrite() {
        return reportReadonlySnapshotWrite();
    }

    public static final /* synthetic */ void access$advanceGlobalSnapshot() {
        advanceGlobalSnapshot();
    }

    public static final /* synthetic */ void access$checkAndOverwriteUnusedRecordsLocked() {
        checkAndOverwriteUnusedRecordsLocked();
    }

    public static final /* synthetic */ List access$getApplyObservers$p() {
        return applyObservers;
    }

    public static final /* synthetic */ Function1 access$getEmptyLambda$p() {
        return emptyLambda;
    }

    public static final /* synthetic */ GlobalSnapshot access$getGlobalSnapshot$p() {
        return globalSnapshot;
    }

    public static final /* synthetic */ List access$getGlobalWriteObservers$p() {
        return globalWriteObservers;
    }

    public static final /* synthetic */ long access$getINVALID_SNAPSHOT$p() {
        return INVALID_SNAPSHOT;
    }

    public static final /* synthetic */ long access$getNextSnapshotId$p() {
        return nextSnapshotId;
    }

    public static final /* synthetic */ SnapshotIdSet access$getOpenSnapshots$p() {
        return openSnapshots;
    }

    public static final /* synthetic */ AtomicInt access$getPendingApplyObserverCount$p() {
        return pendingApplyObserverCount;
    }

    public static final /* synthetic */ SnapshotThreadLocal access$getThreadSnapshot$p() {
        return threadSnapshot;
    }

    public static final Object getLock() {
        return lock;
    }

    public static final Snapshot getSnapshotInitializer() {
        return snapshotInitializer;
    }

    public static final /* synthetic */ Object access$advanceGlobalSnapshot(Function1 r100) {
        return advanceGlobalSnapshot(r100);
    }

    public static final /* synthetic */ void access$processForUnusedRecordsLocked(StateObject r100) {
        processForUnusedRecordsLocked(r100);
    }

    public static final /* synthetic */ void access$setApplyObservers$p(List r100) {
        applyObservers = r100;
    }

    public static final /* synthetic */ void access$setGlobalWriteObservers$p(List r100) {
        globalWriteObservers = r100;
    }

    public static final /* synthetic */ void access$setNextSnapshotId$p(long r100) {
        nextSnapshotId = r100;
    }

    public static final /* synthetic */ void access$setOpenSnapshots$p(SnapshotIdSet r100) {
        openSnapshots = r100;
    }

    public static final /* synthetic */ Snapshot access$takeNewSnapshot(Function1 r100) {
        return takeNewSnapshot(r100);
    }

    public static final /* synthetic */ void access$validateOpen(Snapshot r100) {
        validateOpen(r100);
    }

    private static final <T> T advanceGlobalSnapshot(Function1<? super SnapshotIdSet, ? extends T> r110) {
        GlobalSnapshot r100 = globalSnapshot;
        Object r101 = getLock();
        monitor-enter(r101);
        MutableScatterSet<StateObject> r102 = r100.getModified$runtime();     // Catch: Throwable -> L47
        if (r102 == null) goto L7;
        pendingApplyObserverCount.add(1);     // Catch: Throwable -> L47
    L7:
        T r103 = (T) resetGlobalSnapshotLocked(r100, r110);
        monitor-exit(r101);
        if (r102 != null) goto L50;
    L20:
        Object r104 = getLock();
        monitor-enter(r104);
        checkAndOverwriteUnusedRecordsLocked();     // Catch: Throwable -> L44
        if (r102 == null) goto L42;
        Object[] r105 = r102.elements;     // Catch: Throwable -> L44
        long[] r106 = r102.metadata;     // Catch: Throwable -> L44
        int r107 = r106.length - 2;     // Catch: Throwable -> L44
        if (r107 < 0) goto L41;
        int r108 = 0;
    L27:
        long r109 = r106[r108];     // Catch: Throwable -> L44
        if (((((~r109) << 7) & r109) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L39;
        int r111 = 8 - ((~(r108 - r107)) >>> 31);     // Catch: Throwable -> L44
        int r112 = 0;
    L30:
        if (r112 >= r111) goto L38;
        if ((255 & r109) >= 128) goto L34;
        boolean r113 = true;
    L35:
        if (r113 == false) goto L37;
        processForUnusedRecordsLocked((StateObject) r105[(r108 << 3) + r112]);     // Catch: Throwable -> L44
    L37:
        r109 = r109 >> 8;     // Catch: Throwable -> L44
        r112 = r112 + 1;     // Catch: Throwable -> L44
        goto L30
    L34:
        r113 = false;
        goto L35
    L38:
        if (r111 != 8) goto L41;
    L39:
        if (r108 == r107) goto L41;
        r108 = r108 + 1;     // Catch: Throwable -> L44
    L41:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L44
    L42:
        monitor-exit(r104);
        return r103;
    L44:
        th = move-exception;
        throw th;
    L50:
        List<? extends Function2<? super Set<? extends Object>, ? super Snapshot, Unit>> r115 = applyObservers;     // Catch: Throwable -> L17
        int r116 = r115.size();     // Catch: Throwable -> L17
        int r117 = 0;
    L13:
        if (r117 >= r116) goto L16;
        r115.get(r117).invoke(ScatterSetWrapperKt.wrapIntoSet(r102), r100);     // Catch: Throwable -> L17
        r117 = r117 + 1;
        goto L13
    L16:
        pendingApplyObserverCount.add(-1);
    L17:
        th = move-exception;
        pendingApplyObserverCount.add(-1);
        throw th;
    L47:
        th = move-exception;
        throw th;
    }

    public static final <T extends StateRecord> T current(T r100) {
        Snapshot.Companion r101 = Snapshot.Companion;
        Snapshot r102 = r101.getCurrent();
        T r103 = (T) readable(r100, r102.getSnapshotId(), r102.getInvalid$runtime());
        if (r103 != null) goto L15;
        Object r104 = getLock();
        monitor-enter(r104);
        Snapshot r105 = r101.getCurrent();     // Catch: Throwable -> L12
        T r106 = (T) readable(r100, r105.getSnapshotId(), r105.getInvalid$runtime());
        monitor-exit(r104);
        if (r106 != null) goto L18;
        readError();
        throw new KotlinNothingValueException();
    L18:
        return r106;
    L12:
        th = move-exception;
        throw th;
    L15:
        return r103;
    }

    private static final Unit emptyLambda$lambda$1(SnapshotIdSet r100) {
        return Unit.INSTANCE;
    }

    private static final boolean overwriteUnusedRecordsLocked(StateObject r110) {
        StateRecord r100 = r110.getFirstStateRecord();
        long r101 = pinningTable.lowestOrDefault(nextSnapshotId);
        StateRecord r102 = null;
        StateRecord r103 = null;
        int r104 = 0;
    L4:
        if (r100 == null) goto L32;
        long r105 = r100.getSnapshotId$runtime();
        if (r105 == INVALID_SNAPSHOT) goto L31;
        if (Intrinsics.compare(r105, r101) >= 0) goto L30;
        if (r102 != null) goto L12;
        r104 = r104 + 1;
        r102 = r100;
        goto L31
    L12:
        if (Intrinsics.compare(r100.getSnapshotId$runtime(), r102.getSnapshotId$runtime()) >= 0) goto L14;
        StateRecord r106 = r102;
        r102 = r100;
    L15:
        if (r103 != null) goto L29;
        r103 = r110.getFirstStateRecord();
        StateRecord r107 = r103;
    L17:
        if (r103 == null) goto L28;
        if (Intrinsics.compare(r103.getSnapshotId$runtime(), r101) < 0) goto L21;
        boolean r111 = true;
    L22:
        if (r111 == true) goto L29;
        if (Intrinsics.compare(r107.getSnapshotId$runtime(), r103.getSnapshotId$runtime()) >= 0) goto L27;
        r107 = r103;
    L27:
        r103 = r103.getNext$runtime();
        goto L17
    L21:
        r111 = false;
        goto L22
    L28:
        r103 = r107;
    L29:
        r102.setSnapshotId$runtime(INVALID_SNAPSHOT);
        r102.assign(r103);
        r102 = r106;
        goto L31
    L14:
        r106 = r100;
        goto L15
    L30:
        r104 = r104 + 1;
    L31:
        r100 = r100.getNext$runtime();
        goto L4
    L32:
        if (r104 <= 1) goto L44;
        return true;
    L44:
        return false;
    }

    private static final void processForUnusedRecordsLocked(StateObject r100) {
        if (overwriteUnusedRecordsLocked(r100) == false) goto L6;
        extraStateObjects.add(r100);
        return;
    }

    public static final void releasePinningLocked(int r100) {
        pinningTable.remove(r100);
    }

    public static final <T> T sync(Function0<? extends T> r100) {
        Object r101 = getLock();
        monitor-enter(r101);
        T r102 = r100.invoke();     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(r101);
        InlineMarker.finallyEnd(1);
        return r102;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    private static final <T extends Snapshot> T takeNewSnapshot(final Function1<? super SnapshotIdSet, ? extends T> r100) {
        return (T) advanceGlobalSnapshot(new f(r100));
    }

    private static final StateRecord usedLocked(StateObject r110) {
        StateRecord r111 = r110.getFirstStateRecord();
        long r100 = pinningTable.lowestOrDefault(nextSnapshotId) - ((long) 1);
        SnapshotIdSet r101 = SnapshotIdSet.Companion.getEMPTY();
        StateRecord r102 = null;
    L3:
        if (r111 == null) goto L17;
        if (r111.getSnapshotId$runtime() == INVALID_SNAPSHOT) goto L6;
        if (valid(r111, r100, r101) == false) goto L16;
        if (r102 != null) goto L12;
        r102 = r111;
        goto L16
    L12:
        if (Intrinsics.compare(r111.getSnapshotId$runtime(), r102.getSnapshotId$runtime()) >= 0) goto L15;
        return r111;
    L15:
        return r102;
    L16:
        r111 = r111.getNext$runtime();
        goto L3
    L6:
        return r111;
    L17:
        return null;
    }

    private static final void validateOpen(Snapshot r100) {
        if (openSnapshots.get(r100.getSnapshotId()) == true) goto L20;
        StringBuilder r101 = new StringBuilder("Snapshot is not open: snapshotId=");
        r101.append(r100.getSnapshotId());
        r101.append(", disposed=");
        r101.append(r100.getDisposed$runtime());
        r101.append(", applied=");
        if ((r100 instanceof MutableSnapshot) == false) goto L7;
        MutableSnapshot r102 = (MutableSnapshot) r100;
    L8:
        if (r102 == null) goto L10;
        Object r103 = Boolean.valueOf(r102.getApplied$runtime());
    L11:
        r101.append(r103);
        r101.append(", lowestPin=");
        Object r104 = getLock();
        monitor-enter(r104);
        long r105 = pinningTable.lowestOrDefault(-1);     // Catch: Throwable -> L17
        monitor-exit(r104);
        r101.append(r105);
        throw new IllegalStateException(r101.toString().toString());
    L17:
        th = move-exception;
        throw th;
    L10:
        r103 = "read-only";
        goto L11
    L7:
        r102 = null;
        goto L8
    }

    public static final /* synthetic */ Function1 access$mergedWriteObserver(Function1 r100, Function1 r101) {
        return mergedWriteObserver(r100, r101);
    }

    public static final /* synthetic */ Object access$resetGlobalSnapshotLocked(GlobalSnapshot r100, Function1 r101) {
        return resetGlobalSnapshotLocked(r100, r101);
    }

    public static final <T extends StateRecord> T current(T r100, Snapshot r101) {
        T r102 = (T) readable(r100, r101.getSnapshotId(), r101.getInvalid$runtime());
        if (r102 != null) goto L15;
        Object r103 = getLock();
        monitor-enter(r103);
        T r104 = (T) readable(r100, r101.getSnapshotId(), r101.getInvalid$runtime());
        monitor-exit(r103);
        if (r104 != null) goto L18;
        readError();
        throw new KotlinNothingValueException();
    L18:
        return r104;
    L12:
        th = move-exception;
        throw th;
    L15:
        return r102;
    }

    private static final StateRecord findYoungestOr(StateRecord r100, Function1<? super StateRecord, Boolean> r101) {
        StateRecord r102 = r100;
    L3:
        if (r100 == null) goto L11;
        if (r101.invoke(r100).booleanValue() == true) goto L6;
        if (Intrinsics.compare(r102.getSnapshotId$runtime(), r100.getSnapshotId$runtime()) >= 0) goto L10;
        r102 = r100;
    L10:
        r100 = r100.getNext$runtime();
        goto L3
    L6:
        return r100;
    L11:
        return r102;
    }

    private static final Function1<Object, Unit> mergedWriteObserver(final Function1<Object, Unit> r100, final Function1<Object, Unit> r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        if (r100 == r101) goto L6;
        return new g(r100, r101);
    L6:
        if (r100 == null) goto L8;
        return r100;
    L8:
        return r101;
    }

    public static final <T extends StateRecord> T newOverwritableRecordLocked(T r100, StateObject r101) {
        T r102 = (T) usedLocked(r101);
        if (r102 == null) goto L5;
        r102.setSnapshotId$runtime(Long.MAX_VALUE);
        return r102;
    L5:
        T r103 = (T) r100.create(Long.MAX_VALUE);
        r103.setNext$runtime(r101.getFirstStateRecord());
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        r101.prependStateRecord(r103);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return r103;
    }

    public static final void notifyWrite(Snapshot r100, StateObject r101) {
        r100.setWriteCount$runtime(r100.getWriteCount$runtime() + 1);
        Function1<Object, Unit> r102 = r100.getWriteObserver$runtime();
        if (r102 == null) goto L6;
        r102.invoke(r101);
        return;
    }

    public static final <T extends StateRecord> T readable(T r100, StateObject r101) {
        Snapshot.Companion r102 = Snapshot.Companion;
        Snapshot r103 = r102.getCurrent();
        Function1<Object, Unit> r104 = r103.getReadObserver();
        if (r104 == null) goto L5;
        r104.invoke(r101);
    L5:
        T r105 = (T) readable(r100, r103.getSnapshotId(), r103.getInvalid$runtime());
        if (r105 != null) goto L18;
        Object r106 = getLock();
        monitor-enter(r106);
        Snapshot r107 = r102.getCurrent();     // Catch: Throwable -> L15
        StateRecord r108 = r101.getFirstStateRecord();     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable");     // Catch: Throwable -> L15
        T r109 = (T) readable(r108, r107.getSnapshotId(), r107.getInvalid$runtime());
        if (r109 == null) goto L13;
        monitor-exit(r106);
        return r109;
    L13:
        readError();     // Catch: Throwable -> L15
        throw new KotlinNothingValueException();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L18:
        return r105;
    }

    private static final <T> T resetGlobalSnapshotLocked(GlobalSnapshot r100, Function1<? super SnapshotIdSet, ? extends T> r101) {
        long r102 = r100.getSnapshotId();
        T r103 = r101.invoke(openSnapshots.clear(r102));
        long r104 = nextSnapshotId;
        nextSnapshotId = ((long) 1) + r104;
        openSnapshots = openSnapshots.clear(r102);
        r100.setSnapshotId$runtime(r104);
        r100.setInvalid$runtime(openSnapshots);
        r100.setWriteCount$runtime(0);
        r100.setModified$runtime(null);
        r100.releasePinnedSnapshotLocked$runtime();
        openSnapshots = openSnapshots.set(r104);
        return r103;
    }

    private static final Snapshot takeNewSnapshot$lambda$12(Function1 r100, SnapshotIdSet r101) {
        Snapshot r102 = (Snapshot) r100.invoke(r101);
        Object r103 = getLock();
        monitor-enter(r103);
        openSnapshots = openSnapshots.set(r102.getSnapshotId());     // Catch: Throwable -> L7
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r103);
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static final int trackPinning(long r100, SnapshotIdSet r101) {
        long r102 = r101.lowest(r100);
        Object r103 = getLock();
        monitor-enter(r103);
        int r104 = pinningTable.add(r102);     // Catch: Throwable -> L7
        monitor-exit(r103);
        return r104;
    L7:
        th = move-exception;
        throw th;
    }

    public static final <T extends StateRecord, R> R withCurrent(T r100, Function1<? super T, ? extends R> r101) {
        return r101.invoke(current(r100));
    }

    public static final /* synthetic */ Snapshot access$createTransparentSnapshotWithNoParentReadObserver(Snapshot r100, Function1 r101, boolean r102) {
        return createTransparentSnapshotWithNoParentReadObserver(r100, r101, r102);
    }

    public static final /* synthetic */ Function1 access$mergedReadObserver(Function1 r100, Function1 r101, boolean r102) {
        return mergedReadObserver(r100, r101, r102);
    }

    public static final /* synthetic */ Map access$optimisticMerges(long r100, MutableSnapshot r101, SnapshotIdSet r102) {
        return optimisticMerges(r100, r101, r102);
    }

    public static final /* synthetic */ StateRecord access$readable(StateRecord r100, long r101, SnapshotIdSet r102) {
        return readable(r100, r101, r102);
    }

    public static final SnapshotIdSet addRange(SnapshotIdSet r100, long r101, long r102) {
    L3:
        if (Intrinsics.compare(r101, r102) >= 0) goto L5;
        r100 = r100.set(r101);
        r101 = r101 + ((long) 1);
        goto L3
    L5:
        return r100;
    }

    private static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot r100, Function1<Object, Unit> r101, boolean r110) {
        boolean r102 = r100 instanceof MutableSnapshot;
        if (r102 == true) goto L8;
        if (r100 == null) goto L8;
        return new TransparentObserverSnapshot(r100, r101, false, r110);
    L8:
        if (r102 == false) goto L10;
        MutableSnapshot r103 = (MutableSnapshot) r100;
    L12:
        return new TransparentObserverMutableSnapshot(r103, r101, null, false, r110);
    L10:
        r103 = null;
        goto L12
    }

    private static final Function1<Object, Unit> mergedReadObserver(final Function1<Object, Unit> r100, final Function1<Object, Unit> r101, boolean r102) {
        if (r102 == true) goto L5;
        r101 = null;
    L5:
        if (r100 == null) goto L9;
        if (r101 == null) goto L9;
        if (r100 == r101) goto L9;
        return new d(r100, r101);
    L9:
        if (r100 == null) goto L11;
        return r100;
    L11:
        return r101;
    }

    private static final Unit mergedReadObserver$lambda$2(Function1 r100, Function1 r101, Object r102) {
        r100.invoke(r102);
        r101.invoke(r102);
        return Unit.INSTANCE;
    }

    private static final Unit mergedWriteObserver$lambda$3(Function1 r100, Function1 r101, Object r102) {
        r100.invoke(r102);
        r101.invoke(r102);
        return Unit.INSTANCE;
    }

    public static final <T extends StateRecord> T newWritableRecord(T r100, StateObject r101, Snapshot r102) {
        Object r103 = getLock();
        monitor-enter(r103);
        T r104 = (T) newWritableRecordLocked(r100, r101, r102);
        monitor-exit(r103);
        return r104;
    L7:
        th = move-exception;
        throw th;
    }

    private static final <T extends StateRecord> T newWritableRecordLocked(T r100, StateObject r101, Snapshot r102) {
        T r103 = (T) newOverwritableRecordLocked(r100, r101);
        r103.assign(r100);
        r103.setSnapshotId$runtime(r102.getSnapshotId());
        return r103;
    }

    private static final Map<StateRecord, StateRecord> optimisticMerges(long r210, MutableSnapshot r211, SnapshotIdSet r212) {
        MutableScatterSet<StateObject> r100 = r211.getModified$runtime();
        HashMap r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        SnapshotIdSet r102 = r211.getInvalid$runtime().set(r211.getSnapshotId()).or(r211.getPreviousIds$runtime());
        Object[] r103 = r100.elements;
        long[] r104 = r100.metadata;
        int r105 = r104.length - 2;
        if (r105 < 0) goto L48;
        HashMap r106 = null;
        int r107 = 0;
    L8:
        long r110 = r104[r107];
        if (((((~r110) << 7) & r110) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L42;
        int r111 = 8 - ((~(r107 - r105)) >>> 31);
        int r112 = 0;
    L11:
        if (r112 >= r111) goto L39;
        if ((255 & r110) >= 128) goto L15;
        boolean r113 = true;
    L16:
        if (r113 == false) goto L37;
        StateObject r114 = (StateObject) r103[(r107 << 3) + r112];
        StateRecord r108 = r114.getFirstStateRecord();
        StateRecord r109 = readable(r108, r210, r212);
        if (r109 != null) goto L20;
        long[] r115 = r104;
    L23:
        HashMap r116 = null;
    L38:
        r110 = r110 >> 8;
        r112 = r112 + 1;
        r101 = r116;
        r104 = r115;
        r102 = r102;
        r210 = r210;
        goto L11
    L20:
        r115 = r104;
        StateRecord r117 = readable(r108, r210, r102);
        if (r117 == null) goto L23;
        if (Intrinsics.areEqual(r109, r117) == true) goto L23;
        StateRecord r118 = readable(r108, r211.getSnapshotId(), r211.getInvalid$runtime());
        if (r118 == null) goto L35;
        StateRecord r119 = r114.mergeRecords(r117, r109, r118);
        if (r119 == null) goto L33;
        if (r106 != null) goto L32;
        r106 = new HashMap();
    L32:
        r106.put(r109, r119);
        r106 = r106;
        goto L23
    L33:
        return null;
    L35:
        readError();
        throw new KotlinNothingValueException();
    L37:
        r115 = r104;
        r116 = r101;
        r102 = r102;
        goto L38
    L15:
        r113 = false;
        goto L16
    L39:
        long[] r120 = r104;
        HashMap r121 = r101;
        SnapshotIdSet r213 = r102;
        if (r111 != 8) goto L56;
    L43:
        if (r107 == r105) goto L45;
        r107 = r107 + 1;
        r101 = r121;
        r104 = r120;
        r102 = r213;
        goto L8
    L45:
        r101 = r106;
        goto L48
    L56:
        return r106;
    L42:
        r120 = r104;
        r121 = r101;
        r213 = r102;
    L48:
        return r101;
    }

    public static final <T extends StateRecord> T readable(T r100, StateObject r101, Snapshot r102) {
        Function1<Object, Unit> r103 = r102.getReadObserver();
        if (r103 == null) goto L5;
        r103.invoke(r101);
    L5:
        T r104 = (T) readable(r100, r102.getSnapshotId(), r102.getInvalid$runtime());
        if (r104 != null) goto L18;
        Object r105 = getLock();
        monitor-enter(r105);
        Snapshot r106 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L15
        StateRecord r107 = r101.getFirstStateRecord();     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable");     // Catch: Throwable -> L15
        T r108 = (T) readable(r107, r106.getSnapshotId(), r106.getInvalid$runtime());
        if (r108 == null) goto L13;
        monitor-exit(r105);
        return r108;
    L13:
        readError();     // Catch: Throwable -> L15
        throw new KotlinNothingValueException();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L18:
        return r104;
    }

    private static final boolean valid(long r100, long r101, SnapshotIdSet r102) {
        if (r101 != INVALID_SNAPSHOT) goto L5;
    L9:
        return false;
    L5:
        if (Intrinsics.compare(r101, r100) > 0) goto L9;
        if (r102.get(r101) == true) goto L9;
        return true;
    }

    public static final <T extends StateRecord, R> R writable(T r100, StateObject r101, Function1<? super T, ? extends R> r102) {
        Object r103 = getLock();
        monitor-enter(r103);
        Snapshot r104 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L10
        R r105 = r102.invoke(writableRecord(r100, r101, r104));     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(r103);
        InlineMarker.finallyEnd(1);
        notifyWrite(r104, r101);
        return r105;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <T extends StateRecord> T writableRecord(T r100, StateObject r101, Snapshot r102) {
        if (r102.getReadOnly() == false) goto L5;
        r102.mo4289recordModified$runtime(r101);
    L5:
        long r103 = r102.getSnapshotId();
        T r104 = (T) readable(r100, r103, r102.getInvalid$runtime());
        if (r104 != null) goto L8;
        readError();
        throw new KotlinNothingValueException();
    L8:
        if (r104.getSnapshotId$runtime() != r102.getSnapshotId()) goto L10;
        return r104;
    L10:
        Object r105 = getLock();
        monitor-enter(r105);
        T r106 = (T) readable(r101.getFirstStateRecord(), r103, r102.getInvalid$runtime());
        if (r106 != null) goto L15;
        readError();     // Catch: Throwable -> L25
        throw new KotlinNothingValueException();     // Catch: Throwable -> L25
    L15:
        if (r106.getSnapshotId$runtime() == r103) goto L18;
        r106 = (T) newWritableRecordLocked(r106, r101, r102);
    L18:
        monitor-exit(r105);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.writableRecord");
        if (r104.getSnapshotId$runtime() == SnapshotId_jvmKt.toSnapshotId(1)) goto L22;
        r102.mo4289recordModified$runtime(r101);
    L22:
        return r106;
    L25:
        th = move-exception;
        throw th;
    }

    private static final <T extends StateRecord> T readable(T r100, long r101, SnapshotIdSet r102) {
        T r103 = null;
    L3:
        if (r100 == null) goto L12;
        if (valid(r100, r101, r102) == false) goto L11;
        if (r103 != null) goto L9;
    L10:
        r103 = r100;
        goto L11
    L9:
        if (Intrinsics.compare(r103.getSnapshotId$runtime(), r100.getSnapshotId$runtime()) < 0) goto L10;
    L11:
        r100 = (T) r100.getNext$runtime();
        goto L3
    L12:
        if (r103 == null) goto L14;
        return r103;
    L14:
        return null;
    }

    private static final boolean valid(StateRecord r100, long r101, SnapshotIdSet r102) {
        return valid(r101, r100.getSnapshotId$runtime(), r102);
    }

    public static final <T extends StateRecord, R> R overwritable(T r100, StateObject r101, T r102, Function1<? super T, ? extends R> r103) {
        Object r104 = getLock();
        monitor-enter(r104);
        Snapshot r105 = Snapshot.Companion.getCurrent();     // Catch: Throwable -> L10
        R r106 = r103.invoke(overwritableRecord(r100, r101, r105, r102));     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(r104);
        InlineMarker.finallyEnd(1);
        notifyWrite(r105, r101);
        return r106;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <T extends StateRecord> T overwritableRecord(T r100, StateObject r101, Snapshot r102, T r103) {
        if (r102.getReadOnly() == false) goto L5;
        r102.mo4289recordModified$runtime(r101);
    L5:
        long r104 = r102.getSnapshotId();
        if (r103.getSnapshotId$runtime() != r104) goto L8;
        return r103;
    L8:
        Object r105 = getLock();
        monitor-enter(r105);
        T r106 = (T) newOverwritableRecordLocked(r100, r101);
        monitor-exit(r105);
        r106.setSnapshotId$runtime(r104);
        if (r103.getSnapshotId$runtime() == SnapshotId_jvmKt.toSnapshotId(1)) goto L15;
        r102.mo4289recordModified$runtime(r101);
    L15:
        return r106;
    L16:
        th = move-exception;
        throw th;
    }

    public static final <T extends StateRecord, R> R writable(T r100, StateObject r101, Snapshot r102, Function1<? super T, ? extends R> r103) {
        Object r104 = getLock();
        monitor-enter(r104);
        R r105 = r103.invoke(writableRecord(r100, r101, r102));     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        monitor-exit(r104);
        InlineMarker.finallyEnd(1);
        notifyWrite(r102, r101);
        return r105;
    L10:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ Snapshot createTransparentSnapshotWithNoParentReadObserver$default(Snapshot r100, Function1 r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = false;
    L9:
        return createTransparentSnapshotWithNoParentReadObserver(r100, r101, r102);
    }

    public static /* synthetic */ Function1 mergedReadObserver$default(Function1 r100, Function1 r101, boolean r102, int r103, Object r104) {
        if ((r103 & 4) == 0) goto L6;
        r102 = true;
    L6:
        return mergedReadObserver(r100, r101, r102);
    }
}
