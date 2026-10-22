package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.util.AndroidTrace_androidKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.TimeSource;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001:\u0001,B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJH\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\t2\u0019\u0010 \u001a\u0015\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001c\u0018\u00010!¢\u0006\u0002\b#¢\u0006\u0004\b$\u0010%J\u001a\u0010&\u001a\u00020\u001c*\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\tJ%\u0010)\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u001a¢\u0006\u0004\b*\u0010+J\u0016\u0010)\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\t8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006-"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeLayoutState", "Landroidx/compose/ui/layout/SubcomposeLayoutState;", "executor", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "isPausableCompositionInPrefetchEnabled", "", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeLayoutState;Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;Z)V", "isStateActive", "shouldPauseBetweenPrecompositionAndPremeasure", "getShouldPauseBetweenPrecompositionAndPremeasure$foundation_release$annotations", "()V", "getShouldPauseBetweenPrecompositionAndPremeasure$foundation_release", "()Z", "setShouldPauseBetweenPrecompositionAndPremeasure$foundation_release", "(Z)V", "schedulePrecomposition", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "index", "", "isHighPriority", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "onDisposed", "", "schedulePremeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "onItemPremeasured", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "Lkotlin/ExtensionFunctionType;", "schedulePremeasure-m8Kt_7k", "(IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;ZLkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "executeWithPriority", "request", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "createNestedPrefetchRequest", "createNestedPrefetchRequest-VKLhPVY", "(IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;)Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "HandleAndRequestImpl", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PrefetchHandleProvider {
    public static final int $stable = 8;
    private final PrefetchScheduler executor;
    private final boolean isPausableCompositionInPrefetchEnabled;
    private boolean isStateActive;
    private final LazyLayoutItemContentFactory itemContentFactory;
    private boolean shouldPauseBetweenPrecompositionAndPremeasure;
    private final SubcomposeLayoutState subcomposeLayoutState;

    @Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0083\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001QB<\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0019\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0004\b\u000e\u0010\u000fBF\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0019\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\r¢\u0006\u0004\b\u000e\u0010\u0012J\u000e\u0010)\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010*J\b\u0010+\u001a\u00020\fH\u0016J\b\u0010,\u001a\u00020\fH\u0016J\u0017\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0005H\u0016¢\u0006\u0004\b2\u00103J\u0018\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000206H\u0002J\u0010\u0010=\u001a\u00020\f2\u0006\u00108\u001a\u000206H\u0002J\b\u0010>\u001a\u00020\fH\u0002J\f\u0010?\u001a\u00020\u001b*\u00020@H\u0016J\b\u0010A\u001a\u00020\fH\u0002J\f\u0010B\u001a\u00020\u001b*\u00020@H\u0002J&\u0010D\u001a\u00020\f*\u00020@2\u0006\u0010E\u001a\u00020\u001f2\b\u0010F\u001a\u0004\u0018\u00010\u001f2\u0006\u0010G\u001a\u00020HH\u0002J\u001a\u0010I\u001a\u00020\f2\u0006\u0010E\u001a\u00020\u001f2\b\u0010F\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010J\u001a\u00020\fH\u0002J\u0017\u0010K\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¢\u0006\u0004\bL\u0010MJ\u0012\u0010N\u001a\f\u0018\u00010\"R\u00060\u0000R\u00020#H\u0002J\b\u0010O\u001a\u00020PH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\n\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0002\b\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010!\u001a\f\u0018\u00010\"R\u00060\u0000R\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010'\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0014R\u000e\u00108\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0004\n\u0002\u0010<R\u000e\u0010C\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchResultScope;", "index", "", "prefetchMetrics", "Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "priorityPrefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PriorityPrefetchScheduler;", "onItemPremeasured", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;ILandroidx/compose/foundation/lazy/layout/PrefetchMetrics;Landroidx/compose/foundation/lazy/layout/PriorityPrefetchScheduler;Lkotlin/jvm/functions/Function1;)V", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;IJLandroidx/compose/foundation/lazy/layout/PrefetchMetrics;Landroidx/compose/foundation/lazy/layout/PriorityPrefetchScheduler;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "premeasureConstraints", "precomposeHandle", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "pausedPrecomposition", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "isMeasured", "", "isCanceled", "isApplied", "keyUsedForComposition", "", "hasResolvedNestedPrefetches", "nestedPrefetchController", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl$NestedPrefetchController;", "Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider;", "isUrgent", "isComposed", "()Z", "continuation", "Lkotlin/coroutines/Continuation;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancel", "markAsUrgent", "placeablesCount", "getPlaceablesCount", "getSize", "Landroidx/compose/ui/unit/IntSize;", "placeableIndex", "getSize-YEO4UFw", "(I)J", "shouldExecute", "available", "", "average", "availableTimeNanos", "elapsedTimeNanos", DyPayConstant.KEY_START_TIME, "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "J", "resetAvailableTimeTo", "updateElapsedAndAvailableTime", "execute", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "cleanUp", "executeRequest", "pauseRequested", "performPausableComposition", "key", "contentType", "averages", "Landroidx/compose/foundation/lazy/layout/Averages;", "performFullComposition", "performApply", "performMeasure", "performMeasure-BRTryo0", "(J)V", "resolveNestedPrefetchStates", "toString", "", "NestedPrefetchController", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class HandleAndRequestImpl implements LazyLayoutPrefetchState.PrefetchHandle, PrefetchRequest, LazyLayoutPrefetchState.PrefetchResultScope {
        private long availableTimeNanos;
        private Continuation<? super Unit> continuation;
        private long elapsedTimeNanos;
        private boolean hasResolvedNestedPrefetches;
        private final int index;
        private boolean isApplied;
        private boolean isCanceled;
        private boolean isMeasured;
        private boolean isUrgent;
        private Object keyUsedForComposition;
        private NestedPrefetchController nestedPrefetchController;
        private final Function1<LazyLayoutPrefetchState.PrefetchResultScope, Unit> onItemPremeasured;
        private boolean pauseRequested;
        private SubcomposeLayoutState.PausedPrecomposition pausedPrecomposition;
        private SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle;
        private final PrefetchMetrics prefetchMetrics;
        private Constraints premeasureConstraints;
        private final PriorityPrefetchScheduler priorityPrefetchScheduler;
        private long startTime;
        final /* synthetic */ PrefetchHandleProvider this$0;

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u0014\u001a\u00020\u000f*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000fJ\u0006\u0010\u0018\u001a\u00020\fJ\u0006\u0010\u0019\u001a\u00020\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00030\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl$NestedPrefetchController;", "", "states", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "<init>", "(Landroidx/compose/foundation/lazy/layout/PrefetchHandleProvider$HandleAndRequestImpl;Ljava/util/List;)V", "requestsByState", "", "Landroidx/compose/foundation/lazy/layout/PrefetchRequest;", "[Ljava/util/List;", "stateIndex", "", "requestIndex", "executedNestedPrefetch", "", "getExecutedNestedPrefetch", "()Z", "setExecutedNestedPrefetch", "(Z)V", "executeNestedPrefetches", "Landroidx/compose/foundation/lazy/layout/PrefetchRequestScope;", "nestedPrefetchCount", "isUrgent", "collectIdealNestedPrefetchCount", "collectNestedPrefetchedItemsCount", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public final class NestedPrefetchController {
            private boolean executedNestedPrefetch;
            private int requestIndex;
            private final List<PrefetchRequest>[] requestsByState;
            private int stateIndex;
            private final List<LazyLayoutPrefetchState> states;
            final /* synthetic */ HandleAndRequestImpl this$0;

            public final int collectIdealNestedPrefetchCount() {
                List<LazyLayoutPrefetchState> r100 = this.states;
                int r101 = r100.size();
                int r102 = 0;
                int r103 = Integer.MAX_VALUE;
            L3:
                if (r102 >= r101) goto L5;
                r103 = Math.min(r103, ((LazyLayoutPrefetchState) ListProtector.get(r100, r102)).getIdealNestedPrefetchCount$foundation_release());
                r102 = r102 + 1;
                goto L3
            L5:
                if (r103 != Integer.MAX_VALUE) goto L8;
                return 0;
            L8:
                return r103;
            }

            public final int collectNestedPrefetchedItemsCount() {
                List<LazyLayoutPrefetchState> r100 = this.states;
                int r101 = r100.size();
                int r102 = 0;
                int r103 = Integer.MAX_VALUE;
            L3:
                if (r102 >= r101) goto L5;
                r103 = Math.min(r103, ((LazyLayoutPrefetchState) ListProtector.get(r100, r102)).getLastNumberOfNestedPrefetchItems$foundation_release());
                r102 = r102 + 1;
                goto L3
            L5:
                if (r103 != Integer.MAX_VALUE) goto L8;
                return 0;
            L8:
                return r103;
            }

            public final boolean getExecutedNestedPrefetch() {
                return this.executedNestedPrefetch;
            }

            public final void setExecutedNestedPrefetch(boolean r100) {
                this.executedNestedPrefetch = r100;
            }

            public NestedPrefetchController(HandleAndRequestImpl r100, List<LazyLayoutPrefetchState> r101) {
                this.this$0 = r100;
                this.states = r101;
                this.requestsByState = new List[r101.size()];
                if ((!r101.isEmpty()) == true) goto L6;
                InlineClassHelperKt.throwIllegalArgumentException("NestedPrefetchController shouldn't be created with no states");
                return;
            }

            public final boolean executeNestedPrefetches(PrefetchRequestScope r100, int r101, boolean r110) {
                if (this.stateIndex < this.states.size()) goto L6;
                return false;
            L6:
                if ((!HandleAndRequestImpl.access$isCanceled$p(this.this$0)) == true) goto L9;
                InlineClassHelperKt.throwIllegalStateException("Should not execute nested prefetch on canceled request");
            L9:
                if (ComposeFoundationFlags.isAutomaticNestedPrefetchEnabled == false) goto L19;
                Trace.beginSection("compose:lazy:prefetch:update_nested_prefetch_count");
                List<LazyLayoutPrefetchState> r102 = this.states;     // Catch: Throwable -> L16
                int r103 = r102.size();     // Catch: Throwable -> L16
                int r104 = 0;
            L12:
                if (r104 >= r103) goto L14;
                r102.get(r104).setRealizedNestedPrefetchCount$foundation_release(r101);     // Catch: Throwable -> L16
                r104 = r104 + 1;     // Catch: Throwable -> L16
                goto L12
            L14:
                Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L16
                Trace.endSection();
            L16:
                th = move-exception;
                Trace.endSection();
                throw th;
            L19:
                Trace.beginSection("compose:lazy:prefetch:nested");
            L55:
            L50:
                th = move-exception;
                Trace.endSection();
                throw th;
            L21:
                if (this.stateIndex >= this.states.size()) goto L47;
                if (this.requestsByState[this.stateIndex] == null) goto L26;
            L30:
                List<PrefetchRequest> r106 = this.requestsByState[this.stateIndex];     // Catch: Throwable -> L50
                Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L50
            L32:
                if (this.requestIndex >= r106.size()) goto L46;
                PrefetchRequest r107 = r106.get(this.requestIndex);     // Catch: Throwable -> L50
                if (r110 == true) goto L36;
            L41:
                this.executedNestedPrefetch = true;     // Catch: Throwable -> L50
                if (r107.execute(r100) == true) goto L43;
                this.requestIndex++;     // Catch: Throwable -> L50
                goto L32
            L43:
                Trace.endSection();
                return true;
            L36:
                if ((r107 instanceof HandleAndRequestImpl) == false) goto L38;
                HandleAndRequestImpl r108 = (HandleAndRequestImpl) r107;     // Catch: Throwable -> L50
            L39:
                if (r108 == null) goto L41;
                r108.markAsUrgent();     // Catch: Throwable -> L50
                goto L41
            L38:
                r108 = null;
                goto L39
            L46:
                this.requestIndex = 0;     // Catch: Throwable -> L50
                this.stateIndex++;     // Catch: Throwable -> L50
                goto L55
            L26:
                if (r100.availableTimeNanos() <= 0) goto L27;
                List<PrefetchRequest>[] r109 = this.requestsByState;     // Catch: Throwable -> L50
                int r111 = this.stateIndex;     // Catch: Throwable -> L50
                r109[r111] = this.states.get(r111).collectNestedPrefetchRequests$foundation_release();     // Catch: Throwable -> L50
                goto L30
            L27:
                Trace.endSection();
                return true;
            L47:
                Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L50
                Trace.endSection();
                return false;
            }
        }

        public /* synthetic */ HandleAndRequestImpl(PrefetchHandleProvider r100, int r101, long r102, PrefetchMetrics r103, PriorityPrefetchScheduler r104, Function1 r105, DefaultConstructorMarker r106) {
            this(r100, r101, r102, r103, r104, r105);
        }

        public static /* synthetic */ TraversableNode.Companion.TraverseDescendantsAction a(Ref.ObjectRef r100, TraversableNode r101) {
            return resolveNestedPrefetchStates$lambda$20(r100, r101);
        }

        public static /* synthetic */ boolean b(HandleAndRequestImpl r100, Averages r101) {
            return performPausableComposition$lambda$11(r100, r101);
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
        public void markAsUrgent() {
            this.isUrgent = true;
        }

        private final void cleanUp() {
            SubcomposeLayoutState.PausedPrecomposition r100 = this.pausedPrecomposition;
            if (r100 == null) goto L5;
            r100.cancel();
        L5:
            this.pausedPrecomposition = null;
            SubcomposeLayoutState.PrecomposedSlotHandle r101 = this.precomposeHandle;
            if (r101 == null) goto L8;
            r101.dispose();
        L8:
            this.precomposeHandle = null;
            this.nestedPrefetchController = null;
            Continuation<? super Unit> r102 = this.continuation;
            if (r102 == null) goto L11;
            Result.Companion r103 = Result.Companion;
            r102.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
        L11:
            this.continuation = null;
        }

        private final boolean isComposed() {
            if (this.isApplied == true) goto L14;
            SubcomposeLayoutState.PausedPrecomposition r100 = this.pausedPrecomposition;
            if (r100 != null) goto L7;
        L9:
            boolean r101 = false;
        L10:
            if (r101 == true) goto L15;
            return false;
        L15:
            return true;
        L7:
            if (r100.isComplete() != true) goto L9;
            r101 = true;
            goto L10
        L14:
            return true;
        }

        private final void performApply() {
            SubcomposeLayoutState.PausedPrecomposition r100 = this.pausedPrecomposition;
            if (r100 == null) goto L10;
            this.precomposeHandle = r100.apply();
            this.pausedPrecomposition = null;
            this.isApplied = true;
            Continuation<? super Unit> r101 = this.continuation;
            if (r101 == null) goto L7;
            Result.Companion r102 = Result.Companion;
            r101.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
        L7:
            this.continuation = null;
            return;
        L10:
            throw new IllegalArgumentException("Nothing to apply!".toString());
        }

        private final NestedPrefetchController resolveNestedPrefetchStates() {
            SubcomposeLayoutState.PrecomposedSlotHandle r100 = this.precomposeHandle;
            if (r100 == null) goto L9;
            final Ref.ObjectRef r101 = new Ref.ObjectRef();
            r100.traverseDescendants("androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode", new m0(r101));
            List r102 = (List) r101.element;
            if (r102 != null) goto L11;
            return null;
        L11:
            return new NestedPrefetchController(this, r102);
        L9:
            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("Should precompose before resolving nested prefetch states");
            throw new KotlinNothingValueException();
        }

        private final void updateElapsedAndAvailableTime() {
            long r100 = TimeSource.Monotonic.INSTANCE.m10932markNowz9LOYto();
            long r101 = Duration.m10813getInWholeNanosecondsimpl(TimeSource.Monotonic.ValueTimeMark.m10943minus6eNON_k(r100, this.startTime));
            this.elapsedTimeNanos = r101;
            long r102 = this.availableTimeNanos - r101;
            this.availableTimeNanos = r102;
            this.startTime = r100;
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", r102);
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
        public void cancel() {
            if (this.isCanceled == true) goto L5;
            this.isCanceled = true;
            cleanUp();
        L5:
            Continuation<? super Unit> r100 = this.continuation;
            if (r100 == null) goto L8;
            Result.Companion r101 = Result.Companion;
            r100.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
        L8:
            this.continuation = null;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchResultScope
        public int getPlaceablesCount() {
            SubcomposeLayoutState.PrecomposedSlotHandle r100 = this.precomposeHandle;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.getPlaceablesCount();
        }

        public String toString() {
            return "HandleAndRequestImpl { index = " + getIndex() + ", constraints = " + this.premeasureConstraints + ", isComposed = " + isComposed() + ", isMeasured = " + this.isMeasured + ", isCanceled = " + this.isCanceled + " }";
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchResultScope
        public int getIndex() {
            return this.index;
        }

        public static final /* synthetic */ boolean access$isCanceled$p(HandleAndRequestImpl r100) {
            return r100.isCanceled;
        }

        private final boolean executeRequest(PrefetchRequestScope r110) {
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:execute:item", getIndex());
            LazyLayoutItemProvider r100 = PrefetchHandleProvider.access$getItemContentFactory$p(this.this$0).getItemProvider().invoke();
            if (this.isCanceled == true) goto L11;
            int r101 = r100.getItemCount();
            int r102 = getIndex();
            if (r102 < 0) goto L8;
            if (r102 >= r101) goto L8;
            boolean r103 = true;
        L9:
            if (r103 == false) goto L11;
            boolean r104 = true;
        L12:
            if (r104 == true) goto L15;
            cleanUp();
            return false;
        L15:
            Object r105 = r100.getKey(getIndex());
            Object r106 = this.keyUsedForComposition;
            if (r106 != null) goto L18;
        L21:
            Object r107 = r100.getContentType(getIndex());
            Averages r108 = this.prefetchMetrics.getAverage(r107);
            boolean r109 = isComposed();
            resetAvailableTimeTo(r110.availableTimeNanos());
            if (isComposed() == true) goto L45;
            if (PrefetchHandleProvider.access$isPausableCompositionInPrefetchEnabled$p(this.this$0) == false) goto L34;
            if (shouldExecute(this.availableTimeNanos, r108.getResumeTimeNanos() + r108.getPauseTimeNanos()) == false) goto L42;
            Trace.beginSection("compose:lazy:prefetch:compose");
            performPausableComposition(r110, r105, r107, r108);     // Catch: Throwable -> L30
            Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L30
            Trace.endSection();
        L30:
            th = move-exception;
            Trace.endSection();
            throw th;
        L42:
            if (isComposed() == true) goto L45;
            return true;
        L34:
            if (shouldExecute(this.availableTimeNanos, r108.getCompositionTimeNanos()) == false) goto L42;
            Trace.beginSection("compose:lazy:prefetch:compose");
            performFullComposition(r105, r107);     // Catch: Throwable -> L38
            Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L38
            Trace.endSection();
            updateElapsedAndAvailableTime();
            r108.saveCompositionTimeNanos(this.elapsedTimeNanos);
        L38:
            th = move-exception;
            Trace.endSection();
            throw th;
        L45:
            if (this.pausedPrecomposition == null) goto L56;
            if (shouldExecute(this.availableTimeNanos, r108.getApplyTimeNanos()) == false) goto L54;
            Trace.beginSection("compose:lazy:prefetch:apply");
            performApply();     // Catch: Throwable -> L51
            Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L51
            Trace.endSection();
            updateElapsedAndAvailableTime();
            r108.saveApplyTimeNanos(this.elapsedTimeNanos);
        L51:
            th = move-exception;
            Trace.endSection();
            throw th;
        L54:
            return true;
        L56:
            if (this.hasResolvedNestedPrefetches == false) goto L58;
        L66:
            NestedPrefetchController r114 = this.nestedPrefetchController;
            if (r114 == null) goto L69;
            boolean r115 = r114.executeNestedPrefetches(r110, r108.getNestedPrefetchCount(), this.isUrgent);
        L70:
            if (r115 == false) goto L72;
            return true;
        L72:
            NestedPrefetchController r116 = this.nestedPrefetchController;
            if (r116 != null) goto L75;
        L77:
            boolean r117 = false;
        L78:
            if (r117 == false) goto L82;
            updateElapsedAndAvailableTime();
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:execute:item", getIndex());
            NestedPrefetchController r118 = this.nestedPrefetchController;
            if (r118 == null) goto L82;
            r118.setExecutedNestedPrefetch(false);
        L82:
            Constraints r119 = this.premeasureConstraints;
            if (this.isMeasured == true) goto L100;
            if (r119 == null) goto L100;
            if (this.this$0.getShouldPauseBetweenPrecompositionAndPremeasure$foundation_release() == false) goto L90;
            if (r109 == true) goto L90;
            return true;
        L90:
            if (shouldExecute(this.availableTimeNanos, r108.getMeasureTimeNanos()) == false) goto L99;
            Trace.beginSection("compose:lazy:prefetch:measure");
            m922performMeasureBRTryo0(r119.m7493unboximpl());     // Catch: Throwable -> L96
            Unit r120 = Unit.INSTANCE;     // Catch: Throwable -> L96
            Trace.endSection();
            updateElapsedAndAvailableTime();
            r108.saveMeasureTimeNanos(this.elapsedTimeNanos);
            Function1<LazyLayoutPrefetchState.PrefetchResultScope, Unit> r121 = this.onItemPremeasured;
            if (r121 == null) goto L100;
            r121.invoke(this);
        L96:
            th = move-exception;
            Trace.endSection();
            throw th;
        L99:
            return true;
        L100:
            NestedPrefetchController r122 = this.nestedPrefetchController;
            if (ComposeFoundationFlags.isAutomaticNestedPrefetchEnabled == true) goto L103;
        L110:
            return false;
        L103:
            if (this.isMeasured == false) goto L110;
            if (this.hasResolvedNestedPrefetches == false) goto L110;
            if (r122 == null) goto L110;
            int r123 = r122.collectIdealNestedPrefetchCount();
            r108.saveNestedPrefetchCount(r123);
            if (r122.collectNestedPrefetchedItemsCount() >= r123) goto L110;
            r108.clearMeasureTime();
            goto L110
        L75:
            if (r116.getExecutedNestedPrefetch() != true) goto L77;
            r117 = true;
            goto L78
        L69:
            r115 = false;
            goto L70
        L58:
            if (this.availableTimeNanos <= 0) goto L65;
            Trace.beginSection("compose:lazy:prefetch:resolve-nested");
            this.nestedPrefetchController = resolveNestedPrefetchStates();     // Catch: Throwable -> L62
            this.hasResolvedNestedPrefetches = true;     // Catch: Throwable -> L62
            Unit r124 = Unit.INSTANCE;     // Catch: Throwable -> L62
            Trace.endSection();
        L62:
            th = move-exception;
            Trace.endSection();
            throw th;
        L65:
            return true;
        L18:
            if (Intrinsics.areEqual(r105, r106) == true) goto L21;
            cleanUp();
            return false;
        L8:
            r103 = false;
        L11:
            r104 = false;
            goto L12
        }

        /* JADX INFO: renamed from: performMeasure-BRTryo0, reason: not valid java name */
        private final void m922performMeasureBRTryo0(long r100) {
            if ((!this.isCanceled) == true) goto L6;
            InlineClassHelperKt.throwIllegalArgumentException("Callers should check whether the request is still valid before calling performMeasure()");
        L6:
            if ((!this.isMeasured) == true) goto L8;
            InlineClassHelperKt.throwIllegalArgumentException("Request was already measured!");
        L8:
            this.isMeasured = true;
            SubcomposeLayoutState.PrecomposedSlotHandle r101 = this.precomposeHandle;
            if (r101 == null) goto L14;
            int r102 = r101.getPlaceablesCount();
            int r103 = 0;
        L11:
            if (r103 >= r102) goto L13;
            r101.mo6288premeasure0kLqBqw(r103, r100);
            r103 = r103 + 1;
            goto L11
        L13:
            return;
        L14:
            InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("performComposition() must be called before performMeasure()");
            throw new KotlinNothingValueException();
        }

        private final void resetAvailableTimeTo(long r100) {
            this.availableTimeNanos = r100;
            this.startTime = TimeSource.Monotonic.INSTANCE.m10932markNowz9LOYto();
            this.elapsedTimeNanos = 0;
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:available_time_nanos", r100);
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
        public Object await(Continuation<? super Unit> r100) {
            if ((r100 instanceof PrefetchHandleProvider$HandleAndRequestImpl$await$1) == false) goto L7;
            PrefetchHandleProvider$HandleAndRequestImpl$await$1 r101 = (PrefetchHandleProvider$HandleAndRequestImpl$await$1) r100;
            int r102 = r101.label;
            if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
            r101.label = r102 - Integer.MIN_VALUE;
        L8:
            Object r103 = r101.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r101.label;
            if (r105 == 0) goto L16;
            if (r105 == 1) goto L15;
            if (r105 != 2) goto L14;
            ResultKt.throwOnFailure(r103);
        L25:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r103);
        L19:
            r101.label = 2;
            SafeContinuation r106 = new SafeContinuation(IntrinsicsKt.intercepted(r101));
            this.continuation = r106;
            Object r107 = r106.getOrThrow();
            if (r107 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
            DebugProbesKt.probeCoroutineSuspended(r101);
        L22:
            if (r107 != r104) goto L25;
            return r104;
        L16:
            ResultKt.throwOnFailure(r103);
            r101.label = 1;
            if (LazyLayoutPrefetchState.PrefetchHandle.CC.$default$await(this, r101) != r104) goto L19;
            return r104;
        L7:
            r101 = new PrefetchHandleProvider$HandleAndRequestImpl$await$1(this, r100);
            goto L8
        }

        @Override // androidx.compose.foundation.lazy.layout.PrefetchRequest
        public boolean execute(PrefetchRequestScope r100) {
            if (PrefetchHandleProvider.access$isStateActive$p(this.this$0) == true) goto L7;
            return false;
        L7:
            if (this.isUrgent == false) goto L14;
            Trace.beginSection("compose:lazy:prefetch:execute:urgent");
            boolean r101 = executeRequest(r100);     // Catch: Throwable -> L11
            Trace.endSection();
        L15:
            AndroidTrace_androidKt.traceValue("compose:lazy:prefetch:execute:item", -1);
            return r101;
        L11:
            th = move-exception;
            Trace.endSection();
            throw th;
        L14:
            r101 = executeRequest(r100);
            goto L15
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchResultScope
        /* JADX INFO: renamed from: getSize-YEO4UFw */
        public long mo908getSizeYEO4UFw(int r100) {
            SubcomposeLayoutState.PrecomposedSlotHandle r101 = this.precomposeHandle;
            if (r101 == null) goto L6;
            return r101.mo6287getSizeYEO4UFw(r100);
        L6:
            return IntSize.Companion.m7724getZeroYbymL2g();
        }

        private final void performFullComposition(Object r100, Object r101) {
            if (this.precomposeHandle != null) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == true) goto L8;
            InlineClassHelperKt.throwIllegalArgumentException("Request was already composed!");
        L8:
            Function2<Composer, Integer, Unit> r103 = PrefetchHandleProvider.access$getItemContentFactory$p(this.this$0).getContent(getIndex(), r100, r101);
            this.keyUsedForComposition = r100;
            this.precomposeHandle = PrefetchHandleProvider.access$getSubcomposeLayoutState$p(this.this$0).precompose(r100, r103);
            this.isApplied = true;
            return;
        L5:
            r102 = false;
            goto L6
        }

        private static final boolean performPausableComposition$lambda$11(HandleAndRequestImpl r100, Averages r101) {
            if (r100.pauseRequested == true) goto L6;
            r100.updateElapsedAndAvailableTime();
            r101.saveResumeTimeNanos(r100.elapsedTimeNanos);
            r100.pauseRequested = !r100.shouldExecute(r100.availableTimeNanos, r101.getResumeTimeNanos() + r101.getPauseTimeNanos());
        L6:
            return r100.pauseRequested;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static final TraversableNode.Companion.TraverseDescendantsAction resolveNestedPrefetchStates$lambda$20(Ref.ObjectRef r100, TraversableNode r101) {
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode");
            LazyLayoutPrefetchState r102 = ((TraversablePrefetchStateNode) r101).getPrefetchState();
            List r103 = (List) r100.element;
            if (r103 == null) goto L5;
            r103.add(r102);
            T r104 = r103;
        L6:
            r100.element = r104;
            return TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
        L5:
            r104 = CollectionsKt.mutableListOf(new LazyLayoutPrefetchState[]{r102});
            goto L6
        }

        private final boolean shouldExecute(long r100, long r101) {
            if (this.isUrgent == false) goto L6;
            r101 = 0;
        L6:
            if (r100 <= r101) goto L8;
            return true;
        L8:
            return false;
        }

        private final void performPausableComposition(PrefetchRequestScope r100, Object r101, Object r102, final Averages r103) {
            SubcomposeLayoutState.PausedPrecomposition r104 = this.pausedPrecomposition;
            if (r104 != null) goto L5;
            PrefetchHandleProvider r105 = this.this$0;
            Function2<Composer, Integer, Unit> r106 = PrefetchHandleProvider.access$getItemContentFactory$p(r105).getContent(getIndex(), r101, r102);
            r104 = PrefetchHandleProvider.access$getSubcomposeLayoutState$p(r105).createPausedPrecomposition(r101, r106);
            this.pausedPrecomposition = r104;
            this.keyUsedForComposition = r101;
        L5:
            this.pauseRequested = false;
        L7:
            if (r104.isComplete() == true) goto L11;
            if (this.pauseRequested == true) goto L11;
            r104.resume(new l0(this, r103));
        L11:
            updateElapsedAndAvailableTime();
            if (this.pauseRequested == false) goto L14;
            r103.savePauseTimeNanos(this.elapsedTimeNanos);
            return;
        L14:
            r103.saveResumeTimeNanos(this.elapsedTimeNanos);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public HandleAndRequestImpl(PrefetchHandleProvider r100, int r101, PrefetchMetrics r102, PriorityPrefetchScheduler r103, Function1<? super LazyLayoutPrefetchState.PrefetchResultScope, Unit> r104) {
            this.this$0 = r100;
            this.index = r101;
            this.prefetchMetrics = r102;
            this.priorityPrefetchScheduler = r103;
            this.onItemPremeasured = r104;
            this.startTime = TimeSource.Monotonic.INSTANCE.m10932markNowz9LOYto();
        }

        private HandleAndRequestImpl(PrefetchHandleProvider r100, int r101, long r102, PrefetchMetrics r110, PriorityPrefetchScheduler r111, Function1<? super LazyLayoutPrefetchState.PrefetchResultScope, Unit> r112) {
            this(r100, r101, r110, r111, r112);
            this.premeasureConstraints = Constraints.m7474boximpl(r102);
        }
    }

    public static /* synthetic */ void getShouldPauseBetweenPrecompositionAndPremeasure$foundation_release$annotations() {
    }

    public final void onDisposed() {
        this.isStateActive = false;
    }

    public final boolean getShouldPauseBetweenPrecompositionAndPremeasure$foundation_release() {
        return this.shouldPauseBetweenPrecompositionAndPremeasure;
    }

    public static final /* synthetic */ LazyLayoutItemContentFactory access$getItemContentFactory$p(PrefetchHandleProvider r100) {
        return r100.itemContentFactory;
    }

    public static final /* synthetic */ SubcomposeLayoutState access$getSubcomposeLayoutState$p(PrefetchHandleProvider r100) {
        return r100.subcomposeLayoutState;
    }

    public static final /* synthetic */ boolean access$isPausableCompositionInPrefetchEnabled$p(PrefetchHandleProvider r100) {
        return r100.isPausableCompositionInPrefetchEnabled;
    }

    public static final /* synthetic */ boolean access$isStateActive$p(PrefetchHandleProvider r100) {
        return r100.isStateActive;
    }

    public final void setShouldPauseBetweenPrecompositionAndPremeasure$foundation_release(boolean r100) {
        this.shouldPauseBetweenPrecompositionAndPremeasure = r100;
    }

    public final PrefetchRequest createNestedPrefetchRequest(int r100, PrefetchMetrics r101) {
        PrefetchScheduler r102 = this.executor;
        if ((r102 instanceof PriorityPrefetchScheduler) == false) goto L5;
        PriorityPrefetchScheduler r103 = (PriorityPrefetchScheduler) r102;
    L7:
        return new HandleAndRequestImpl(this, r100, r101, r103, null);
    L5:
        r103 = null;
        goto L7
    }

    /* JADX INFO: renamed from: createNestedPrefetchRequest-VKLhPVY, reason: not valid java name */
    public final PrefetchRequest m920createNestedPrefetchRequestVKLhPVY(int r110, long r111, PrefetchMetrics r112) {
        PrefetchScheduler r100 = this.executor;
        if ((r100 instanceof PriorityPrefetchScheduler) == false) goto L5;
        PriorityPrefetchScheduler r101 = (PriorityPrefetchScheduler) r100;
    L7:
        return new HandleAndRequestImpl(this, r110, r111, r112, r101, null, null);
    L5:
        r101 = null;
        goto L7
    }

    public final void executeWithPriority(PrefetchScheduler r100, PrefetchRequest r101, boolean r102) {
        if ((r100 instanceof PriorityPrefetchScheduler) == false) goto L7;
        if (r102 == false) goto L6;
        ((PriorityPrefetchScheduler) r100).scheduleHighPriorityPrefetch(r101);
        return;
    L6:
        ((PriorityPrefetchScheduler) r100).scheduleLowPriorityPrefetch(r101);
        return;
    L7:
        r100.schedulePrefetch(r101);
    }

    public final LazyLayoutPrefetchState.PrefetchHandle schedulePrecomposition(int r100, boolean r101, PrefetchMetrics r110) {
        PrefetchScheduler r102 = this.executor;
        if ((r102 instanceof PriorityPrefetchScheduler) == false) goto L5;
        PriorityPrefetchScheduler r103 = (PriorityPrefetchScheduler) r102;
    L6:
        HandleAndRequestImpl r104 = new HandleAndRequestImpl(this, r100, r110, r103, null);
        executeWithPriority(this.executor, r104, r101);
        AndroidTrace_androidKt.traceValue("compose:lazy:schedule_prefetch:index", r100);
        return r104;
    L5:
        r103 = null;
        goto L6
    }

    public PrefetchHandleProvider(LazyLayoutItemContentFactory r100, SubcomposeLayoutState r101, PrefetchScheduler r102, boolean r103) {
        this.itemContentFactory = r100;
        this.subcomposeLayoutState = r101;
        this.executor = r102;
        this.isPausableCompositionInPrefetchEnabled = r103;
        this.isStateActive = true;
    }

    /* JADX INFO: renamed from: schedulePremeasure-m8Kt_7k, reason: not valid java name */
    public final LazyLayoutPrefetchState.PrefetchHandle m921schedulePremeasurem8Kt_7k(int r110, long r111, PrefetchMetrics r112, boolean r113, Function1<? super LazyLayoutPrefetchState.PrefetchResultScope, Unit> r114) {
        PrefetchScheduler r100 = this.executor;
        if ((r100 instanceof PriorityPrefetchScheduler) == false) goto L5;
        PriorityPrefetchScheduler r101 = (PriorityPrefetchScheduler) r100;
    L6:
        HandleAndRequestImpl r115 = new HandleAndRequestImpl(this, r110, r111, r112, r101, r114, null);
        executeWithPriority(this.executor, r115, r113);
        AndroidTrace_androidKt.traceValue("compose:lazy:schedule_prefetch:index", r110);
        return r115;
    L5:
        r101 = null;
        goto L6
    }
}
