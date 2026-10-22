package androidx.compose.runtime.snapshots;

import C7.r;
import S7.k;
import S7.n;
import android.view.p;
import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.internal.AtomicInt;
import androidx.compose.runtime.internal.SnapshotThreadLocal;
import androidx.compose.runtime.internal.WeakReference;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.mdisdk.capability.model.RequestInfo;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0006\u001a\u00020\u00052\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u000f\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a;\u0010\u0015\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001aS\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u00102\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u00102\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001aI\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u00102\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u00102\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a1\u0010!\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001e2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0081\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b!\u0010\"\u001a1\u0010%\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001e2\u0006\u0010$\u001a\u00020#2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0010H\u0002¢\u0006\u0004\b%\u0010&\u001a)\u0010'\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001e2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0010H\u0002¢\u0006\u0004\b'\u0010(\u001a\u000f\u0010'\u001a\u00020\tH\u0002¢\u0006\u0004\b'\u0010)\u001a-\u0010*\u001a\u00028\u0000\"\b\b\u0000\u0010\u001e*\u00020\f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0010H\u0002¢\u0006\u0004\b*\u0010+\u001a\u0017\u0010-\u001a\u00020\t2\u0006\u0010,\u001a\u00020\fH\u0002¢\u0006\u0004\b-\u0010.\u001a/\u00100\u001a\u00020\u00132\n\u0010\r\u001a\u00060\u0000j\u0002`\u00012\n\u0010/\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b0\u00101\u001a+\u00100\u001a\u00020\u00132\u0006\u00103\u001a\u0002022\n\u0010,\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b0\u00104\u001a7\u00107\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u001e*\u0002022\u0006\u00105\u001a\u00028\u00002\n\u00106\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b7\u00108\u001a#\u00107\u001a\u00028\u0000\"\b\b\u0000\u0010\u001e*\u000202*\u00028\u00002\u0006\u0010:\u001a\u000209¢\u0006\u0004\b7\u0010;\u001a+\u00107\u001a\u00028\u0000\"\b\b\u0000\u0010\u001e*\u000202*\u00028\u00002\u0006\u0010:\u001a\u0002092\u0006\u0010,\u001a\u00020\f¢\u0006\u0004\b7\u0010<\u001a\u000f\u0010>\u001a\u00020=H\u0002¢\u0006\u0004\b>\u0010?\u001a\u0019\u0010@\u001a\u0004\u0018\u0001022\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\b@\u0010A\u001a\u0017\u0010B\u001a\u00020\u00132\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\bB\u0010C\u001a(\u0010E\u001a\u000202*\u0002022\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u00130\u0010H\u0082\b¢\u0006\u0004\bE\u0010F\u001a\u000f\u0010G\u001a\u00020\tH\u0002¢\u0006\u0004\bG\u0010)\u001a\u0017\u0010H\u001a\u00020\t2\u0006\u0010:\u001a\u000209H\u0002¢\u0006\u0004\bH\u0010I\u001a-\u0010J\u001a\u00028\u0000\"\b\b\u0000\u0010\u001e*\u000202*\u00028\u00002\u0006\u0010:\u001a\u0002092\u0006\u0010,\u001a\u00020\fH\u0001¢\u0006\u0004\bJ\u0010<\u001a5\u0010L\u001a\u00028\u0000\"\b\b\u0000\u0010\u001e*\u000202*\u00028\u00002\u0006\u0010:\u001a\u0002092\u0006\u0010,\u001a\u00020\f2\u0006\u0010K\u001a\u00028\u0000H\u0000¢\u0006\u0004\bL\u0010M\u001a-\u0010N\u001a\u00028\u0000\"\b\b\u0000\u0010\u001e*\u000202*\u00028\u00002\u0006\u0010:\u001a\u0002092\u0006\u0010,\u001a\u00020\fH\u0000¢\u0006\u0004\bN\u0010<\u001a-\u0010O\u001a\u00028\u0000\"\b\b\u0000\u0010\u001e*\u000202*\u00028\u00002\u0006\u0010:\u001a\u0002092\u0006\u0010,\u001a\u00020\fH\u0002¢\u0006\u0004\bO\u0010<\u001a%\u0010P\u001a\u00028\u0000\"\b\b\u0000\u0010\u001e*\u000202*\u00028\u00002\u0006\u0010:\u001a\u000209H\u0000¢\u0006\u0004\bP\u0010;\u001a\u001f\u0010Q\u001a\u00020\t2\u0006\u0010,\u001a\u00020\f2\u0006\u0010:\u001a\u000209H\u0001¢\u0006\u0004\bQ\u0010R\u001aH\u0010T\u001a\u00028\u0001\"\b\b\u0000\u0010\u001e*\u000202\"\u0004\b\u0001\u0010S*\u00028\u00002\u0006\u0010:\u001a\u0002092\u0006\u0010,\u001a\u00020\f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010H\u0086\b¢\u0006\u0004\bT\u0010U\u001a@\u0010T\u001a\u00028\u0001\"\b\b\u0000\u0010\u001e*\u000202\"\u0004\b\u0001\u0010S*\u00028\u00002\u0006\u0010:\u001a\u0002092\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010H\u0086\b¢\u0006\u0004\bT\u0010V\u001aH\u0010W\u001a\u00028\u0001\"\b\b\u0000\u0010\u001e*\u000202\"\u0004\b\u0001\u0010S*\u00028\u00002\u0006\u0010:\u001a\u0002092\u0006\u0010K\u001a\u00028\u00002\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010H\u0080\b¢\u0006\u0004\bW\u0010X\u001a9\u0010^\u001a\u0010\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000202\u0018\u00010]2\n\u0010Y\u001a\u00060\u0000j\u0002`\u00012\u0006\u0010[\u001a\u00020Z2\u0006\u0010\\\u001a\u00020\u0003H\u0002¢\u0006\u0004\b^\u0010_\u001a\u000f\u0010`\u001a\u00020=H\u0002¢\u0006\u0004\b`\u0010?\u001a)\u0010a\u001a\u00028\u0000\"\b\b\u0000\u0010\u001e*\u0002022\u0006\u00105\u001a\u00028\u00002\u0006\u0010,\u001a\u00020\fH\u0001¢\u0006\u0004\ba\u0010b\u001a!\u0010a\u001a\u00028\u0000\"\b\b\u0000\u0010\u001e*\u0002022\u0006\u00105\u001a\u00028\u0000H\u0001¢\u0006\u0004\ba\u0010c\u001a8\u0010d\u001a\u00028\u0001\"\b\b\u0000\u0010\u001e*\u000202\"\u0004\b\u0001\u0010S*\u00028\u00002\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010H\u0086\b¢\u0006\u0004\bd\u0010e\u001a+\u0010h\u001a\u00020\u0003*\u00020\u00032\n\u0010f\u001a\u00060\u0000j\u0002`\u00012\n\u0010g\u001a\u00060\u0000j\u0002`\u0001H\u0000¢\u0006\u0004\bh\u0010i\" \u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010k\"\u0018\u0010l\u001a\u00060\u0000j\u0002`\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010m\"\u001a\u0010o\u001a\b\u0012\u0004\u0012\u00020\f0n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010p\"$\u0010r\u001a\u00060\u0011j\u0002`q8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\br\u0010s\u0012\u0004\bv\u0010)\u001a\u0004\bt\u0010u\"\u0016\u0010w\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010x\"\u001a\u0010y\u001a\u00060\u0000j\u0002`\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010m\"\u0014\u0010{\u001a\u00020z8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010|\"\u001a\u0010~\u001a\b\u0012\u0004\u0012\u0002090}8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010\u007f\":\u0010\u0083\u0001\u001a#\u0012\u001e\u0012\u001c\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00110\u0082\u0001\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u0081\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001\",\u0010\u0085\u0001\u001a\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u00100\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0084\u0001\"\u0015\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b$\u0010\u0086\u0001\"%\u0010\u0087\u0001\u001a\u00020\f8\u0000X\u0081\u0004¢\u0006\u0016\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u0012\u0005\b\u008a\u0001\u0010)\u001a\u0005\b\u0089\u0001\u0010\u000e\"\u001a\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001¨\u0006\u008e\u0001"}, d2 = {"", "Landroidx/compose/runtime/snapshots/SnapshotId;", "snapshotId", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "", "trackPinning", "(JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)I", "handle", "LC7/r;", "releasePinningLocked", "(I)V", "Landroidx/compose/runtime/snapshots/Snapshot;", "currentSnapshot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "previousSnapshot", "Lkotlin/Function1;", "", "readObserver", "", "ownsPreviousSnapshot", "createTransparentSnapshotWithNoParentReadObserver", "(Landroidx/compose/runtime/snapshots/Snapshot;LS7/k;Z)Landroidx/compose/runtime/snapshots/Snapshot;", "parentObserver", "mergeReadObserver", "mergedReadObserver", "(LS7/k;LS7/k;Z)LS7/k;", "writeObserver", "mergedWriteObserver", "(LS7/k;LS7/k;)LS7/k;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "block", "sync", "(LS7/a;)Ljava/lang/Object;", "Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "globalSnapshot", "resetGlobalSnapshotLocked", "(Landroidx/compose/runtime/snapshots/GlobalSnapshot;LS7/k;)Ljava/lang/Object;", "advanceGlobalSnapshot", "(LS7/k;)Ljava/lang/Object;", "()V", "takeNewSnapshot", "(LS7/k;)Landroidx/compose/runtime/snapshots/Snapshot;", RequestInfo.FUNCTION_SNAPSHOT, "validateOpen", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "candidateSnapshot", "valid", "(JJLandroidx/compose/runtime/snapshots/SnapshotIdSet;)Z", "Landroidx/compose/runtime/snapshots/StateRecord;", SettingsConfig.KEY_DATA, "(Landroidx/compose/runtime/snapshots/StateRecord;JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)Z", "r", "id", "readable", "(Landroidx/compose/runtime/snapshots/StateRecord;JLandroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/snapshots/StateObject;", "state", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "", "readError", "()Ljava/lang/Void;", "usedLocked", "(Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "overwriteUnusedRecordsLocked", "(Landroidx/compose/runtime/snapshots/StateObject;)Z", "predicate", "findYoungestOr", "(Landroidx/compose/runtime/snapshots/StateRecord;LS7/k;)Landroidx/compose/runtime/snapshots/StateRecord;", "checkAndOverwriteUnusedRecordsLocked", "processForUnusedRecordsLocked", "(Landroidx/compose/runtime/snapshots/StateObject;)V", "writableRecord", "candidate", "overwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecord", "newWritableRecordLocked", "newOverwritableRecordLocked", "notifyWrite", "(Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateObject;)V", "R", "writable", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;LS7/k;)Ljava/lang/Object;", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;LS7/k;)Ljava/lang/Object;", "overwritable", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/StateRecord;LS7/k;)Ljava/lang/Object;", "currentSnapshotId", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "applyingSnapshot", "invalidSnapshots", "", "optimisticMerges", "(JLandroidx/compose/runtime/snapshots/MutableSnapshot;Landroidx/compose/runtime/snapshots/SnapshotIdSet;)Ljava/util/Map;", "reportReadonlySnapshotWrite", "current", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "(Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "withCurrent", "(Landroidx/compose/runtime/snapshots/StateRecord;LS7/k;)Ljava/lang/Object;", TypedValues.TransitionType.S_FROM, "until", "addRange", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;JJ)Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "emptyLambda", "LS7/k;", "INVALID_SNAPSHOT", "J", "Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "threadSnapshot", "Landroidx/compose/runtime/internal/SnapshotThreadLocal;", "Landroidx/compose/runtime/platform/SynchronizedObject;", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "getLock$annotations", "openSnapshots", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "nextSnapshotId", "Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "pinningTable", "Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "extraStateObjects", "Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "", "Lkotlin/Function2;", "", "applyObservers", "Ljava/util/List;", "globalWriteObservers", "Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "snapshotInitializer", "Landroidx/compose/runtime/snapshots/Snapshot;", "getSnapshotInitializer", "getSnapshotInitializer$annotations", "Landroidx/compose/runtime/internal/AtomicInt;", "pendingApplyObserverCount", "Landroidx/compose/runtime/internal/AtomicInt;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotKt {
    private static final long INVALID_SNAPSHOT = 0;
    private static List<? extends n> applyObservers;
    private static final SnapshotWeakSet<StateObject> extraStateObjects;
    private static final GlobalSnapshot globalSnapshot;
    private static List<? extends k> globalWriteObservers;
    private static long nextSnapshotId;
    private static SnapshotIdSet openSnapshots;
    private static AtomicInt pendingApplyObserverCount;
    private static final SnapshotDoubleIndexHeap pinningTable;
    private static final Snapshot snapshotInitializer;
    private static final k emptyLambda = new p(4);
    private static final SnapshotThreadLocal<Snapshot> threadSnapshot = new SnapshotThreadLocal<>();
    private static final Object lock = new Object();

    static {
        SnapshotIdSet.Companion companion = SnapshotIdSet.INSTANCE;
        openSnapshots = companion.getEMPTY();
        long j5 = 1;
        nextSnapshotId = SnapshotId_jvmKt.toSnapshotId(1) + j5;
        pinningTable = new SnapshotDoubleIndexHeap();
        extraStateObjects = new SnapshotWeakSet<>();
        EmptyList emptyList = EmptyList.f4893a;
        applyObservers = emptyList;
        globalWriteObservers = emptyList;
        long j6 = nextSnapshotId;
        nextSnapshotId = j5 + j6;
        GlobalSnapshot globalSnapshot2 = new GlobalSnapshot(j6, companion.getEMPTY());
        openSnapshots = openSnapshots.set(globalSnapshot2.getSnapshotId());
        globalSnapshot = globalSnapshot2;
        snapshotInitializer = globalSnapshot2;
        pendingApplyObserverCount = new AtomicInt(0);
    }

    public static final SnapshotIdSet addRange(SnapshotIdSet snapshotIdSet, long j5, long j6) {
        while (kotlin.jvm.internal.k.h(j5, j6) < 0) {
            snapshotIdSet = snapshotIdSet.set(j5);
            j5++;
        }
        return snapshotIdSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> T advanceGlobalSnapshot(S7.k r15) {
        /*
            androidx.compose.runtime.snapshots.GlobalSnapshot r0 = androidx.compose.runtime.snapshots.SnapshotKt.globalSnapshot
            java.lang.Object r1 = getLock()
            monitor-enter(r1)
            androidx.collection.MutableScatterSet r2 = r0.getModified$runtime()     // Catch: java.lang.Throwable -> L14
            if (r2 == 0) goto L17
            androidx.compose.runtime.internal.AtomicInt r3 = androidx.compose.runtime.snapshots.SnapshotKt.pendingApplyObserverCount     // Catch: java.lang.Throwable -> L14
            r4 = 1
            r3.add(r4)     // Catch: java.lang.Throwable -> L14
            goto L17
        L14:
            r15 = move-exception
            goto L9f
        L17:
            java.lang.Object r15 = resetGlobalSnapshotLocked(r0, r15)     // Catch: java.lang.Throwable -> L14
            monitor-exit(r1)
            r1 = 0
            if (r2 == 0) goto L4a
            r3 = -1
            java.util.List<? extends S7.n> r4 = androidx.compose.runtime.snapshots.SnapshotKt.applyObservers     // Catch: java.lang.Throwable -> L3c
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5     // Catch: java.lang.Throwable -> L3c
            int r5 = r5.size()     // Catch: java.lang.Throwable -> L3c
            r6 = r1
        L2a:
            if (r6 >= r5) goto L3e
            java.lang.Object r7 = r4.get(r6)     // Catch: java.lang.Throwable -> L3c
            S7.n r7 = (S7.n) r7     // Catch: java.lang.Throwable -> L3c
            java.util.Set r8 = androidx.compose.runtime.collection.ScatterSetWrapperKt.wrapIntoSet(r2)     // Catch: java.lang.Throwable -> L3c
            r7.invoke(r8, r0)     // Catch: java.lang.Throwable -> L3c
            int r6 = r6 + 1
            goto L2a
        L3c:
            r15 = move-exception
            goto L44
        L3e:
            androidx.compose.runtime.internal.AtomicInt r0 = androidx.compose.runtime.snapshots.SnapshotKt.pendingApplyObserverCount
            r0.add(r3)
            goto L4a
        L44:
            androidx.compose.runtime.internal.AtomicInt r0 = androidx.compose.runtime.snapshots.SnapshotKt.pendingApplyObserverCount
            r0.add(r3)
            throw r15
        L4a:
            java.lang.Object r0 = getLock()
            monitor-enter(r0)
            checkAndOverwriteUnusedRecordsLocked()     // Catch: java.lang.Throwable -> L8e
            if (r2 == 0) goto L9b
            java.lang.Object[] r3 = r2.elements     // Catch: java.lang.Throwable -> L8e
            long[] r2 = r2.metadata     // Catch: java.lang.Throwable -> L8e
            int r4 = r2.length     // Catch: java.lang.Throwable -> L8e
            int r4 = r4 + (-2)
            if (r4 < 0) goto L9b
            r5 = r1
        L5e:
            r6 = r2[r5]     // Catch: java.lang.Throwable -> L8e
            long r8 = ~r6     // Catch: java.lang.Throwable -> L8e
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L96
            int r8 = r5 - r4
            int r8 = ~r8     // Catch: java.lang.Throwable -> L8e
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r1
        L78:
            if (r10 >= r8) goto L94
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L90
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r3[r11]     // Catch: java.lang.Throwable -> L8e
            androidx.compose.runtime.snapshots.StateObject r11 = (androidx.compose.runtime.snapshots.StateObject) r11     // Catch: java.lang.Throwable -> L8e
            processForUnusedRecordsLocked(r11)     // Catch: java.lang.Throwable -> L8e
            goto L90
        L8e:
            r15 = move-exception
            goto L9d
        L90:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L78
        L94:
            if (r8 != r9) goto L9b
        L96:
            if (r5 == r4) goto L9b
            int r5 = r5 + 1
            goto L5e
        L9b:
            monitor-exit(r0)
            return r15
        L9d:
            monitor-exit(r0)
            throw r15
        L9f:
            monitor-exit(r1)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotKt.advanceGlobalSnapshot(S7.k):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkAndOverwriteUnusedRecordsLocked() {
        SnapshotWeakSet<StateObject> snapshotWeakSet = extraStateObjects;
        int size$runtime = snapshotWeakSet.getSize();
        int i = 0;
        int i6 = 0;
        while (true) {
            if (i >= size$runtime) {
                break;
            }
            WeakReference<StateObject> weakReference = snapshotWeakSet.getValues$runtime()[i];
            StateObject stateObject = weakReference != null ? weakReference.get() : null;
            if (stateObject != null && overwriteUnusedRecordsLocked(stateObject)) {
                if (i6 != i) {
                    snapshotWeakSet.getValues$runtime()[i6] = weakReference;
                    snapshotWeakSet.getHashes()[i6] = snapshotWeakSet.getHashes()[i];
                }
                i6++;
            }
            i++;
        }
        for (int i10 = i6; i10 < size$runtime; i10++) {
            snapshotWeakSet.getValues$runtime()[i10] = null;
            snapshotWeakSet.getHashes()[i10] = 0;
        }
        if (i6 != size$runtime) {
            snapshotWeakSet.setSize$runtime(i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot snapshot, k kVar, boolean z10) {
        boolean z11 = snapshot instanceof MutableSnapshot;
        if (z11 || snapshot == null) {
            return new TransparentObserverMutableSnapshot(z11 ? (MutableSnapshot) snapshot : null, kVar, null, false, z10);
        }
        return new TransparentObserverSnapshot(snapshot, kVar, false, z10);
    }

    public static /* synthetic */ Snapshot createTransparentSnapshotWithNoParentReadObserver$default(Snapshot snapshot, k kVar, boolean z10, int i, Object obj) {
        if ((i & 2) != 0) {
            kVar = null;
        }
        if ((i & 4) != 0) {
            z10 = false;
        }
        return createTransparentSnapshotWithNoParentReadObserver(snapshot, kVar, z10);
    }

    public static final <T extends StateRecord> T current(T t9, Snapshot snapshot) {
        T t10;
        T t11 = (T) readable(t9, snapshot.getSnapshotId(), snapshot.getInvalid());
        if (t11 != null) {
            return t11;
        }
        synchronized (getLock()) {
            t10 = (T) readable(t9, snapshot.getSnapshotId(), snapshot.getInvalid());
        }
        if (t10 != null) {
            return t10;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static final Snapshot currentSnapshot() {
        Snapshot snapshot = threadSnapshot.get();
        return snapshot == null ? globalSnapshot : snapshot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r emptyLambda$lambda$1(SnapshotIdSet snapshotIdSet) {
        return r.f317a;
    }

    private static final StateRecord findYoungestOr(StateRecord stateRecord, k kVar) {
        StateRecord stateRecord2 = stateRecord;
        while (stateRecord != null) {
            if (((Boolean) kVar.invoke(stateRecord)).booleanValue()) {
                return stateRecord;
            }
            if (kotlin.jvm.internal.k.h(stateRecord2.getSnapshotId(), stateRecord.getSnapshotId()) < 0) {
                stateRecord2 = stateRecord;
            }
            stateRecord = stateRecord.getNext();
        }
        return stateRecord2;
    }

    public static final Object getLock() {
        return lock;
    }

    public static /* synthetic */ void getLock$annotations() {
    }

    public static final Snapshot getSnapshotInitializer() {
        return snapshotInitializer;
    }

    public static /* synthetic */ void getSnapshotInitializer$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k mergedReadObserver(k kVar, k kVar2, boolean z10) {
        if (!z10) {
            kVar2 = null;
        }
        return (kVar == null || kVar2 == null || kVar == kVar2) ? kVar == null ? kVar2 : kVar : new b(0, kVar, kVar2);
    }

    public static /* synthetic */ k mergedReadObserver$default(k kVar, k kVar2, boolean z10, int i, Object obj) {
        if ((i & 4) != 0) {
            z10 = true;
        }
        return mergedReadObserver(kVar, kVar2, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r mergedReadObserver$lambda$2(k kVar, k kVar2, Object obj) {
        kVar.invoke(obj);
        kVar2.invoke(obj);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k mergedWriteObserver(k kVar, k kVar2) {
        return (kVar == null || kVar2 == null || kVar == kVar2) ? kVar == null ? kVar2 : kVar : new b(1, kVar, kVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r mergedWriteObserver$lambda$3(k kVar, k kVar2, Object obj) {
        kVar.invoke(obj);
        kVar2.invoke(obj);
        return r.f317a;
    }

    public static final <T extends StateRecord> T newOverwritableRecordLocked(T t9, StateObject stateObject) {
        T t10 = (T) usedLocked(stateObject);
        if (t10 != null) {
            t10.setSnapshotId$runtime(Long.MAX_VALUE);
            return t10;
        }
        T t11 = (T) t9.create(Long.MAX_VALUE);
        t11.setNext$runtime(stateObject.getFirstStateRecord());
        stateObject.prependStateRecord(t11);
        return t11;
    }

    public static final <T extends StateRecord> T newWritableRecord(T t9, StateObject stateObject, Snapshot snapshot) {
        T t10;
        synchronized (getLock()) {
            t10 = (T) newWritableRecordLocked(t9, stateObject, snapshot);
        }
        return t10;
    }

    private static final <T extends StateRecord> T newWritableRecordLocked(T t9, StateObject stateObject, Snapshot snapshot) {
        T t10 = (T) newOverwritableRecordLocked(t9, stateObject);
        t10.assign(t9);
        t10.setSnapshotId$runtime(snapshot.getSnapshotId());
        return t10;
    }

    public static final void notifyWrite(Snapshot snapshot, StateObject stateObject) {
        snapshot.setWriteCount$runtime(snapshot.getWriteCount$runtime() + 1);
        k writeObserver$runtime = snapshot.getWriteObserver();
        if (writeObserver$runtime != null) {
            writeObserver$runtime.invoke(stateObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<StateRecord, StateRecord> optimisticMerges(long j5, MutableSnapshot mutableSnapshot, SnapshotIdSet snapshotIdSet) {
        long[] jArr;
        Map<StateRecord, StateRecord> map;
        SnapshotIdSet snapshotIdSet2;
        long[] jArr2;
        Map<StateRecord, StateRecord> map2;
        SnapshotIdSet snapshotIdSet3;
        int i;
        long j6 = j5;
        MutableScatterSet<StateObject> modified$runtime = mutableSnapshot.getModified$runtime();
        Map<StateRecord, StateRecord> map3 = null;
        if (modified$runtime == null) {
            return null;
        }
        SnapshotIdSet snapshotIdSetOr = mutableSnapshot.getInvalid().set(mutableSnapshot.getSnapshotId()).or(mutableSnapshot.getPreviousIds$runtime());
        Object[] objArr = modified$runtime.elements;
        long[] jArr3 = modified$runtime.metadata;
        int length = jArr3.length - 2;
        if (length < 0) {
            return null;
        }
        HashMap map4 = null;
        int i6 = 0;
        while (true) {
            long j10 = jArr3[i6];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8;
                int i11 = 8 - ((~(i6 - length)) >>> 31);
                int i12 = 0;
                while (i12 < i11) {
                    if ((255 & j10) < 128) {
                        StateObject stateObject = (StateObject) objArr[(i6 << 3) + i12];
                        map2 = map3;
                        StateRecord firstStateRecord = stateObject.getFirstStateRecord();
                        i = i10;
                        StateRecord stateRecord = readable(firstStateRecord, j6, snapshotIdSet);
                        if (stateRecord == null) {
                            jArr2 = jArr3;
                        } else {
                            jArr2 = jArr3;
                            StateRecord stateRecord2 = readable(firstStateRecord, j6, snapshotIdSetOr);
                            if (stateRecord2 != null && !stateRecord.equals(stateRecord2)) {
                                snapshotIdSet3 = snapshotIdSetOr;
                                StateRecord stateRecord3 = readable(firstStateRecord, mutableSnapshot.getSnapshotId(), mutableSnapshot.getInvalid());
                                if (stateRecord3 == null) {
                                    readError();
                                    throw new KotlinNothingValueException();
                                }
                                StateRecord stateRecordMergeRecords = stateObject.mergeRecords(stateRecord2, stateRecord, stateRecord3);
                                if (stateRecordMergeRecords == null) {
                                    return map2;
                                }
                                if (map4 == null) {
                                    map4 = new HashMap();
                                }
                                map4.put(stateRecord, stateRecordMergeRecords);
                                map4 = map4;
                            }
                        }
                        snapshotIdSet3 = snapshotIdSetOr;
                    } else {
                        jArr2 = jArr3;
                        map2 = map3;
                        snapshotIdSet3 = snapshotIdSetOr;
                        i = i10;
                    }
                    j10 >>= i;
                    i12++;
                    j6 = j5;
                    map3 = map2;
                    i10 = i;
                    jArr3 = jArr2;
                    snapshotIdSetOr = snapshotIdSet3;
                }
                jArr = jArr3;
                map = map3;
                snapshotIdSet2 = snapshotIdSetOr;
                if (i11 != i10) {
                    return map4;
                }
            } else {
                jArr = jArr3;
                map = map3;
                snapshotIdSet2 = snapshotIdSetOr;
            }
            if (i6 == length) {
                return map4;
            }
            i6++;
            j6 = j5;
            map3 = map;
            jArr3 = jArr;
            snapshotIdSetOr = snapshotIdSet2;
        }
    }

    public static final <T extends StateRecord, R> R overwritable(T t9, StateObject stateObject, T t10, k kVar) {
        Snapshot current;
        R r5;
        synchronized (getLock()) {
            current = Snapshot.INSTANCE.getCurrent();
            r5 = (R) kVar.invoke(overwritableRecord(t9, stateObject, current, t10));
        }
        notifyWrite(current, stateObject);
        return r5;
    }

    public static final <T extends StateRecord> T overwritableRecord(T t9, StateObject stateObject, Snapshot snapshot, T t10) {
        T t11;
        if (snapshot.getReadOnly()) {
            snapshot.mo3596recordModified$runtime(stateObject);
        }
        long snapshotId = snapshot.getSnapshotId();
        if (t10.getSnapshotId() == snapshotId) {
            return t10;
        }
        synchronized (getLock()) {
            t11 = (T) newOverwritableRecordLocked(t9, stateObject);
        }
        t11.setSnapshotId$runtime(snapshotId);
        if (t10.getSnapshotId() != SnapshotId_jvmKt.toSnapshotId(1)) {
            snapshot.mo3596recordModified$runtime(stateObject);
        }
        return t11;
    }

    private static final boolean overwriteUnusedRecordsLocked(StateObject stateObject) {
        StateRecord stateRecord;
        long jLowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId);
        StateRecord stateRecord2 = null;
        StateRecord firstStateRecord = null;
        int i = 0;
        for (StateRecord firstStateRecord2 = stateObject.getFirstStateRecord(); firstStateRecord2 != null; firstStateRecord2 = firstStateRecord2.getNext()) {
            long snapshotId$runtime = firstStateRecord2.getSnapshotId();
            if (snapshotId$runtime != INVALID_SNAPSHOT) {
                if (kotlin.jvm.internal.k.h(snapshotId$runtime, jLowestOrDefault) >= 0) {
                    i++;
                } else if (stateRecord2 == null) {
                    i++;
                    stateRecord2 = firstStateRecord2;
                } else {
                    if (kotlin.jvm.internal.k.h(firstStateRecord2.getSnapshotId(), stateRecord2.getSnapshotId()) < 0) {
                        stateRecord = stateRecord2;
                        stateRecord2 = firstStateRecord2;
                    } else {
                        stateRecord = firstStateRecord2;
                    }
                    if (firstStateRecord == null) {
                        firstStateRecord = stateObject.getFirstStateRecord();
                        StateRecord stateRecord3 = firstStateRecord;
                        while (true) {
                            if (firstStateRecord == null) {
                                firstStateRecord = stateRecord3;
                                break;
                            }
                            if (kotlin.jvm.internal.k.h(firstStateRecord.getSnapshotId(), jLowestOrDefault) >= 0) {
                                break;
                            }
                            if (kotlin.jvm.internal.k.h(stateRecord3.getSnapshotId(), firstStateRecord.getSnapshotId()) < 0) {
                                stateRecord3 = firstStateRecord;
                            }
                            firstStateRecord = firstStateRecord.getNext();
                        }
                    }
                    stateRecord2.setSnapshotId$runtime(INVALID_SNAPSHOT);
                    stateRecord2.assign(firstStateRecord);
                    stateRecord2 = stateRecord;
                }
            }
        }
        return i > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void processForUnusedRecordsLocked(StateObject stateObject) {
        if (overwriteUnusedRecordsLocked(stateObject)) {
            extraStateObjects.add(stateObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends StateRecord> T readable(T t9, long j5, SnapshotIdSet snapshotIdSet) {
        T t10 = null;
        while (t9 != null) {
            if (valid(t9, j5, snapshotIdSet) && (t10 == null || kotlin.jvm.internal.k.h(t10.getSnapshotId(), t9.getSnapshotId()) < 0)) {
                t10 = t9;
            }
            t9 = (T) t9.getNext();
        }
        if (t10 != null) {
            return t10;
        }
        return null;
    }

    public static final void releasePinningLocked(int i) {
        pinningTable.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T resetGlobalSnapshotLocked(GlobalSnapshot globalSnapshot2, k kVar) {
        long snapshotId = globalSnapshot2.getSnapshotId();
        T t9 = (T) kVar.invoke(openSnapshots.clear(snapshotId));
        long j5 = nextSnapshotId;
        nextSnapshotId = 1 + j5;
        openSnapshots = openSnapshots.clear(snapshotId);
        globalSnapshot2.setSnapshotId$runtime(j5);
        globalSnapshot2.setInvalid$runtime(openSnapshots);
        globalSnapshot2.setWriteCount$runtime(0);
        globalSnapshot2.setModified$runtime(null);
        globalSnapshot2.releasePinnedSnapshotLocked$runtime();
        openSnapshots = openSnapshots.set(j5);
        return t9;
    }

    public static final <T> T sync(S7.a aVar) {
        T t9;
        synchronized (getLock()) {
            t9 = (T) aVar.invoke();
        }
        return t9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends Snapshot> T takeNewSnapshot(k kVar) {
        return (T) advanceGlobalSnapshot(new c(kVar, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Snapshot takeNewSnapshot$lambda$12(k kVar, SnapshotIdSet snapshotIdSet) {
        Snapshot snapshot = (Snapshot) kVar.invoke(snapshotIdSet);
        synchronized (getLock()) {
            openSnapshots = openSnapshots.set(snapshot.getSnapshotId());
        }
        return snapshot;
    }

    public static final int trackPinning(long j5, SnapshotIdSet snapshotIdSet) {
        int iAdd;
        long jLowest = snapshotIdSet.lowest(j5);
        synchronized (getLock()) {
            iAdd = pinningTable.add(jLowest);
        }
        return iAdd;
    }

    private static final StateRecord usedLocked(StateObject stateObject) {
        long jLowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId) - 1;
        SnapshotIdSet empty = SnapshotIdSet.INSTANCE.getEMPTY();
        StateRecord stateRecord = null;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext()) {
            if (firstStateRecord.getSnapshotId() != INVALID_SNAPSHOT) {
                if (valid(firstStateRecord, jLowestOrDefault, empty)) {
                    if (stateRecord == null) {
                        stateRecord = firstStateRecord;
                    } else if (kotlin.jvm.internal.k.h(firstStateRecord.getSnapshotId(), stateRecord.getSnapshotId()) >= 0) {
                        return stateRecord;
                    }
                }
            }
            return firstStateRecord;
        }
        return null;
    }

    private static final boolean valid(long j5, long j6, SnapshotIdSet snapshotIdSet) {
        return (j6 == INVALID_SNAPSHOT || kotlin.jvm.internal.k.h(j6, j5) > 0 || snapshotIdSet.get(j6)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateOpen(Snapshot snapshot) {
        long jLowestOrDefault;
        if (openSnapshots.get(snapshot.getSnapshotId())) {
            return;
        }
        StringBuilder sb = new StringBuilder("Snapshot is not open: snapshotId=");
        sb.append(snapshot.getSnapshotId());
        sb.append(", disposed=");
        sb.append(snapshot.getDisposed());
        sb.append(", applied=");
        MutableSnapshot mutableSnapshot = snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null;
        sb.append(mutableSnapshot != null ? Boolean.valueOf(mutableSnapshot.getApplied$runtime()) : "read-only");
        sb.append(", lowestPin=");
        synchronized (getLock()) {
            jLowestOrDefault = pinningTable.lowestOrDefault(-1L);
        }
        sb.append(jLowestOrDefault);
        throw new IllegalStateException(sb.toString().toString());
    }

    public static final <T extends StateRecord, R> R withCurrent(T t9, k kVar) {
        return (R) kVar.invoke(current(t9));
    }

    public static final <T extends StateRecord, R> R writable(T t9, StateObject stateObject, Snapshot snapshot, k kVar) {
        R r5;
        synchronized (getLock()) {
            r5 = (R) kVar.invoke(writableRecord(t9, stateObject, snapshot));
        }
        notifyWrite(snapshot, stateObject);
        return r5;
    }

    public static final <T extends StateRecord> T writableRecord(T t9, StateObject stateObject, Snapshot snapshot) {
        T t10;
        if (snapshot.getReadOnly()) {
            snapshot.mo3596recordModified$runtime(stateObject);
        }
        long snapshotId = snapshot.getSnapshotId();
        T t11 = (T) readable(t9, snapshotId, snapshot.getInvalid());
        if (t11 == null) {
            readError();
            throw new KotlinNothingValueException();
        }
        if (t11.getSnapshotId() == snapshot.getSnapshotId()) {
            return t11;
        }
        synchronized (getLock()) {
            t10 = (T) readable(stateObject.getFirstStateRecord(), snapshotId, snapshot.getInvalid());
            if (t10 == null) {
                readError();
                throw new KotlinNothingValueException();
            }
            if (t10.getSnapshotId() != snapshotId) {
                t10 = (T) newWritableRecordLocked(t10, stateObject, snapshot);
            }
        }
        kotlin.jvm.internal.k.d(t10, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.writableRecord");
        if (t11.getSnapshotId() != SnapshotId_jvmKt.toSnapshotId(1)) {
            snapshot.mo3596recordModified$runtime(stateObject);
        }
        return t10;
    }

    private static final boolean valid(StateRecord stateRecord, long j5, SnapshotIdSet snapshotIdSet) {
        return valid(j5, stateRecord.getSnapshotId(), snapshotIdSet);
    }

    public static final <T extends StateRecord> T readable(T t9, StateObject stateObject) {
        T t10;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot current = companion.getCurrent();
        k readObserver = current.getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(stateObject);
        }
        T t11 = (T) readable(t9, current.getSnapshotId(), current.getInvalid());
        if (t11 != null) {
            return t11;
        }
        synchronized (getLock()) {
            Snapshot current2 = companion.getCurrent();
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            kotlin.jvm.internal.k.d(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable");
            t10 = (T) readable(firstStateRecord, current2.getSnapshotId(), current2.getInvalid());
            if (t10 == null) {
                readError();
                throw new KotlinNothingValueException();
            }
        }
        return t10;
    }

    public static final <T extends StateRecord, R> R writable(T t9, StateObject stateObject, k kVar) {
        Snapshot current;
        R r5;
        synchronized (getLock()) {
            current = Snapshot.INSTANCE.getCurrent();
            r5 = (R) kVar.invoke(writableRecord(t9, stateObject, current));
        }
        notifyWrite(current, stateObject);
        return r5;
    }

    public static final <T extends StateRecord> T current(T t9) {
        T t10;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot current = companion.getCurrent();
        T t11 = (T) readable(t9, current.getSnapshotId(), current.getInvalid());
        if (t11 != null) {
            return t11;
        }
        synchronized (getLock()) {
            Snapshot current2 = companion.getCurrent();
            t10 = (T) readable(t9, current2.getSnapshotId(), current2.getInvalid());
        }
        if (t10 != null) {
            return t10;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static final <T extends StateRecord> T readable(T t9, StateObject stateObject, Snapshot snapshot) {
        T t10;
        k readObserver = snapshot.getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(stateObject);
        }
        T t11 = (T) readable(t9, snapshot.getSnapshotId(), snapshot.getInvalid());
        if (t11 != null) {
            return t11;
        }
        synchronized (getLock()) {
            Snapshot current = Snapshot.INSTANCE.getCurrent();
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            kotlin.jvm.internal.k.d(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable");
            t10 = (T) readable(firstStateRecord, current.getSnapshotId(), current.getInvalid());
            if (t10 == null) {
                readError();
                throw new KotlinNothingValueException();
            }
        }
        return t10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void advanceGlobalSnapshot() {
        advanceGlobalSnapshot(emptyLambda);
    }
}
