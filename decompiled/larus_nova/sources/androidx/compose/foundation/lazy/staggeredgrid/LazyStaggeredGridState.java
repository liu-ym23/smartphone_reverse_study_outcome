package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollDeltaBetweenPasses;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScopeKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 ª\u00012\u00020\u0001:\u0002ª\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u001d\b\u0016\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0007\u0010\fJ\u0015\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u000eH\u0000¢\u0006\u0002\bSJC\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020|2*\u0010}\u001a&\b\u0001\u0012\u0004\u0012\u00020\u007f\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020z0\u0080\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u0081\u00010~¢\u0006\u0003\b\u0082\u0001H\u0096@¢\u0006\u0003\u0010\u0083\u0001J\u0012\u0010\u0085\u0001\u001a\u00020Q2\u0007\u0010\u0086\u0001\u001a\u00020QH\u0002J$\u0010\u0087\u0001\u001a\u00020z2\u0007\u0010\u0088\u0001\u001a\u00020\n2\t\b\u0002\u0010\u0089\u0001\u001a\u00020\nH\u0086@¢\u0006\u0003\u0010\u008a\u0001J$\u0010\u008b\u0001\u001a\u00020z2\u0007\u0010\u0088\u0001\u001a\u00020\n2\t\b\u0002\u0010\u0089\u0001\u001a\u00020\nH\u0086@¢\u0006\u0003\u0010\u008a\u0001J\u001d\u0010\u008e\u0001\u001a\u00020z2\t\b\u0001\u0010\u0088\u0001\u001a\u00020\n2\t\b\u0002\u0010\u0089\u0001\u001a\u00020\nJ*\u0010\u008f\u0001\u001a\u00020z2\u0007\u0010\u0088\u0001\u001a\u00020\n2\u0007\u0010\u0089\u0001\u001a\u00020\n2\u0007\u0010\u0090\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0003\b\u0091\u0001J\"\u0010\u0092\u0001\u001a\u00020\u00032\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u0003H\u0000¢\u0006\u0003\b\u0096\u0001J\u0012\u0010\u0097\u0001\u001a\u00020Q2\u0007\u0010\u0098\u0001\u001a\u00020QH\u0016J\u001d\u0010\u0099\u0001\u001a\u00020z2\u0007\u0010\u0098\u0001\u001a\u00020Q2\t\b\u0002\u0010\u009a\u0001\u001a\u00020\u0012H\u0002J\u0019\u0010\u009b\u0001\u001a\u00020z2\u000e\u0010\u009c\u0001\u001a\t\u0012\u0004\u0012\u00020\n0\u009d\u0001H\u0002J\u0012\u0010\u009e\u0001\u001a\u00020z2\u0007\u0010\u009a\u0001\u001a\u00020 H\u0002J+\u0010\u009f\u0001\u001a\u00020z2\u0007\u0010 \u0001\u001a\u00020\u00122\u0006\u0010R\u001a\u00020\u000e2\t\b\u0002\u0010¡\u0001\u001a\u00020\u000eH\u0000¢\u0006\u0003\b¢\u0001J\u001a\u0010¨\u0001\u001a\u00020\u00032\u0007\u0010©\u0001\u001a\u00020\n2\u0006\u0010\\\u001a\u00020\nH\u0002R\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0012@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001cX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R+\u0010*\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000e8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b+\u0010\u0011\"\u0004\b,\u0010-R+\u00100\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u000e8V@RX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b3\u0010/\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010-R\u0014\u00104\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0011R\u0014\u00106\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0011R\"\u00109\u001a\u0004\u0018\u0001082\b\u0010\r\u001a\u0004\u0018\u000108@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020AX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020EX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u0011\"\u0004\bJ\u0010-R\u0014\u0010K\u001a\u00020LX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u000e\u0010O\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020QX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010T\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0018\"\u0004\bV\u0010WR\u000e\u0010X\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020[0ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\\\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b]\u0010\u0018R\u0011\u0010^\u001a\u00020_8F¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0014\u0010b\u001a\u00020cX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bd\u0010eR\u0014\u0010f\u001a\u00020gX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010iR\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020l0kX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010nR\u001b\u0010o\u001a\u00020p8@X\u0080\u0084\u0002¢\u0006\f\u001a\u0004\bs\u0010t*\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020vX\u0080\u0004¢\u0006\n\n\u0002\u0010/\u001a\u0004\bw\u0010xR\u0016\u0010\u0084\u0001\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0084\u0001\u0010\u0011R\u0018\u0010\u008c\u0001\u001a\u00020vX\u0080\u0004¢\u0006\u000b\n\u0002\u0010/\u001a\u0005\b\u008d\u0001\u0010xR\u0017\u0010£\u0001\u001a\u00020Q8@X\u0080\u0004¢\u0006\b\u001a\u0006\b¤\u0001\u0010¥\u0001R\u0010\u0010¦\u0001\u001a\u00030§\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006«\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "initialFirstVisibleItems", "", "initialFirstVisibleOffsets", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "<init>", "([I[ILandroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "initialFirstVisibleItemIndex", "", "initialFirstVisibleItemOffset", "(II)V", "value", "", "hasLookaheadOccurred", "getHasLookaheadOccurred$foundation_release", "()Z", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "approachLayoutInfo", "getApproachLayoutInfo$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "firstVisibleItemIndex", "getFirstVisibleItemIndex", "()I", "firstVisibleItemScrollOffset", "getFirstVisibleItemScrollOffset", "scrollPosition", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "getScrollPosition$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "layoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "laneInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getLaneInfo$foundation_release", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "<set-?>", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "(Z)V", "canScrollForward$delegate", "Landroidx/compose/runtime/MutableState;", "canScrollBackward", "getCanScrollBackward", "setCanScrollBackward", "canScrollBackward$delegate", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "scrollableState", "scrollToBeConsumed", "", "isLookingAhead", "scrollToBeConsumed$foundation_release", "measurePassCount", "getMeasurePassCount$foundation_release", "setMeasurePassCount$foundation_release", "(I)V", "prefetchBaseIndex", "currentItemPrefetchHandles", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "laneCount", "getLaneCount$foundation_release", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "mutableInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getMutableInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "pinnedItems", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedItems$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "getItemAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", GXViewKey.VIEW_TYPE_CONTAINER_SCROLL, "", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isScrollInProgress", "onScroll", "distance", "scrollToItem", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateScrollToItem", "measurementScopeInvalidator", "getMeasurementScopeInvalidator-zYiylxw$foundation_release", "requestScrollToItem", "snapToItemInternal", "forceRemeasure", "snapToItemInternal$foundation_release", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "firstItemIndex", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "dispatchRawDelta", "delta", "notifyPrefetch", "info", "clearLeftoverPrefetchHandles", "prefetchHandlesUsed", "", "cancelPrefetchIfVisibleItemsChanged", "applyMeasureResult", "result", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "scrollDeltaBetweenPasses", "getScrollDeltaBetweenPasses$foundation_release", "()F", "_lazyLayoutScrollDeltaBetweenPasses", "Landroidx/compose/foundation/lazy/layout/LazyLayoutScrollDeltaBetweenPasses;", "fillNearestIndices", "itemIndex", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridState implements ScrollableState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Saver<LazyStaggeredGridState, Object> Saver = null;
    private final LazyLayoutScrollDeltaBetweenPasses _lazyLayoutScrollDeltaBetweenPasses;
    private LazyStaggeredGridMeasureResult approachLayoutInfo;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private final Map<Integer, LazyLayoutPrefetchState.PrefetchHandle> currentItemPrefetchHandles;
    private boolean hasLookaheadOccurred;
    private final LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> itemAnimator;
    private final LazyStaggeredGridLaneInfo laneInfo;
    private final MutableState<LazyStaggeredGridMeasureResult> layoutInfoState;
    private int measurePassCount;
    private final MutableState<Unit> measurementScopeInvalidator;
    private final MutableInteractionSource mutableInteractionSource;
    private final LazyLayoutPinnedItemList pinnedItems;
    private final MutableState<Unit> placementScopeInvalidator;
    private int prefetchBaseIndex;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private Remeasurement remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final LazyStaggeredGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    private final ScrollableState scrollableState;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Saver<LazyStaggeredGridState, Object> getSaver() {
            return LazyStaggeredGridState.access$getSaver$cp();
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$animateScrollToItem$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$animateScrollToItem$2", f = "LazyStaggeredGridState.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ LazyStaggeredGridMeasureResult $layoutInfo;
        final /* synthetic */ int $numOfItemsToTeleport;
        final /* synthetic */ int $scrollOffset;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ LazyStaggeredGridState this$0;

        public AnonymousClass2(LazyStaggeredGridState r100, int r101, int r102, int r103, LazyStaggeredGridMeasureResult r104, Continuation<? super AnonymousClass2> r105) {
            this.this$0 = r100;
            this.$index = r101;
            this.$scrollOffset = r102;
            this.$numOfItemsToTeleport = r103;
            this.$layoutInfo = r104;
            super(2, r105);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
            AnonymousClass2 r101 = new AnonymousClass2(this.this$0, this.$index, this.$scrollOffset, this.$numOfItemsToTeleport, this.$layoutInfo, r110);
            r101.L$0 = r100;
            return r101;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ScrollScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ScrollScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            ScrollScope r111 = (ScrollScope) this.L$0;
            LazyLayoutScrollScope r102 = LazyStaggeredGridScrollScopeKt.LazyLayoutScrollScope(this.this$0, r111);
            int r103 = this.$index;
            int r104 = this.$scrollOffset;
            int r105 = this.$numOfItemsToTeleport;
            Density r106 = this.$layoutInfo.getDensity();
            this.label = 1;
            if (LazyLayoutScrollScopeKt.animateScrollToItem(r102, r103, r104, r105, r106, this) != r100) goto L12;
            return r100;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$requestScrollToItem$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$requestScrollToItem$1", f = "LazyStaggeredGridState.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LazyStaggeredGridState this$0;

        public AnonymousClass1(LazyStaggeredGridState r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            LazyStaggeredGridState r103 = this.this$0;
            this.label = 1;
            if (ScrollExtensionsKt.stopScroll$default(r103, null, this, 1, null) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState", f = "LazyStaggeredGridState.kt", i = {0, 0}, l = {253, 254}, m = GXViewKey.VIEW_TYPE_CONTAINER_SCROLL, n = {"scrollPriority", "block"}, s = {"L$0", "L$1"})
    public static final class C86371 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ LazyStaggeredGridState this$0;

        public C86371(LazyStaggeredGridState r100, Continuation<? super C86371> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.scroll(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scrollToItem$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scrollToItem$2", f = "LazyStaggeredGridState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C86382 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ int $scrollOffset;
        int label;
        final /* synthetic */ LazyStaggeredGridState this$0;

        public C86382(LazyStaggeredGridState r100, int r101, int r102, Continuation<? super C86382> r103) {
            this.this$0 = r100;
            this.$index = r101;
            this.$scrollOffset = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C86382(this.this$0, this.$index, this.$scrollOffset, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ScrollScope r100, Continuation<? super Unit> r101) {
            return ((C86382) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ScrollScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            this.this$0.snapToItemInternal$foundation_release(this.$index, this.$scrollOffset, true);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ LazyStaggeredGridState a(List r100) {
        return Saver$lambda$5(r100);
    }

    public static /* synthetic */ List b(SaverScope r100, LazyStaggeredGridState r101) {
        return Saver$lambda$4(r100, r101);
    }

    public static /* synthetic */ float c(LazyStaggeredGridState r100, float r101) {
        return scrollableState$lambda$0(r100, r101);
    }

    static {
        Companion = new Companion(null);
        Saver = ListSaverKt.listSaver(new s(), new t());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.getIndex();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    public final int getLaneCount$foundation_release() {
        return this.layoutInfoState.getValue().getSlots().getSizes().length;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledBackward() {
        return this.scrollableState.getLastScrolledBackward();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledForward() {
        return this.scrollableState.getLastScrolledForward();
    }

    public final LazyStaggeredGridLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final IntRange getNearestRange$foundation_release() {
        return this.scrollPosition.getNearestRangeState().getValue();
    }

    public final float getScrollDeltaBetweenPasses$foundation_release() {
        return this._lazyLayoutScrollDeltaBetweenPasses.getScrollDeltaBetweenPasses$foundation_release();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public static final /* synthetic */ Saver access$getSaver$cp() {
        return Saver;
    }

    public final LazyStaggeredGridMeasureResult getApproachLayoutInfo$foundation_release() {
        return this.approachLayoutInfo;
    }

    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo$foundation_release() {
        return this.beyondBoundsInfo;
    }

    public final boolean getHasLookaheadOccurred$foundation_release() {
        return this.hasLookaheadOccurred;
    }

    public final InteractionSource getInteractionSource() {
        return this.mutableInteractionSource;
    }

    public final LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> getItemAnimator$foundation_release() {
        return this.itemAnimator;
    }

    public final LazyStaggeredGridLaneInfo getLaneInfo$foundation_release() {
        return this.laneInfo;
    }

    public final int getMeasurePassCount$foundation_release() {
        return this.measurePassCount;
    }

    /* JADX INFO: renamed from: getMeasurementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m953getMeasurementScopeInvalidatorzYiylxw$foundation_release() {
        return this.measurementScopeInvalidator;
    }

    public final MutableInteractionSource getMutableInteractionSource$foundation_release() {
        return this.mutableInteractionSource;
    }

    public final LazyLayoutPinnedItemList getPinnedItems$foundation_release() {
        return this.pinnedItems;
    }

    /* JADX INFO: renamed from: getPlacementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m954getPlacementScopeInvalidatorzYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    public final Remeasurement getRemeasurement$foundation_release() {
        return this.remeasurement;
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    public final LazyStaggeredGridScrollPosition getScrollPosition$foundation_release() {
        return this.scrollPosition;
    }

    private static final LazyStaggeredGridState Saver$lambda$5(List r100) {
        return new LazyStaggeredGridState((int[]) ListProtector.get(r100, 0), (int[]) ListProtector.get(r100, 1), null);
    }

    private final void cancelPrefetchIfVisibleItemsChanged(LazyStaggeredGridLayoutInfo r100) {
        List<LazyStaggeredGridItemInfo> r101 = r100.getVisibleItemsInfo();
        if (this.prefetchBaseIndex == (-1)) goto L19;
        boolean r102 = true;
        if ((!r101.isEmpty()) == false) goto L20;
        int r103 = ((LazyStaggeredGridItemInfo) CollectionsKt.first(r101)).getIndex();
        int r104 = ((LazyStaggeredGridItemInfo) CollectionsKt.last(r101)).getIndex();
        int r105 = this.prefetchBaseIndex;
        if (r103 > r105) goto L10;
        if (r105 > r104) goto L10;
    L11:
        if (r102 == true) goto L21;
        this.prefetchBaseIndex = -1;
        Iterator<T> r106 = this.currentItemPrefetchHandles.values().iterator();
    L14:
        if (r106.hasNext() == false) goto L16;
        ((LazyLayoutPrefetchState.PrefetchHandle) r106.next()).cancel();
        goto L14
    L16:
        this.currentItemPrefetchHandles.clear();
        return;
    L21:
        return;
    L10:
        r102 = false;
        goto L11
    L20:
        return;
    }

    private final void clearLeftoverPrefetchHandles(Set<Integer> r100) {
        Iterator<Map.Entry<Integer, LazyLayoutPrefetchState.PrefetchHandle>> r101 = this.currentItemPrefetchHandles.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Map.Entry<Integer, LazyLayoutPrefetchState.PrefetchHandle> r102 = r101.next();
        if (r100.contains(r102.getKey()) == true) goto L4;
        r102.getValue().cancel();
        r101.remove();
        goto L4
    }

    private static Object getNearestRange$foundation_release$delegate(LazyStaggeredGridState r100) {
        return r100.scrollPosition.getNearestRangeState();
    }

    private final float onScroll(float r100) {
        if (r100 >= 0.0f) goto L7;
        if (getCanScrollForward() == true) goto L7;
    L10:
        return 0.0f;
    L7:
        if (r100 <= 0.0f) goto L12;
        if (getCanScrollBackward() == false) goto L10;
    L12:
        if (Math.abs(this.scrollToBeConsumed) > 0.5f) goto L14;
        boolean r101 = true;
    L15:
        if (r101 == true) goto L17;
        InlineClassHelperKt.throwIllegalStateException("entered drag with non-zero pending scroll");
    L17:
        float r102 = this.scrollToBeConsumed + r100;
        this.scrollToBeConsumed = r102;
        if (Math.abs(r102) <= 0.5f) goto L36;
        float r103 = this.scrollToBeConsumed;
        int r104 = MathKt.roundToInt(r103);
        LazyStaggeredGridMeasureResult r105 = this.layoutInfoState.getValue().copyWithScrollDeltaWithoutRemeasure(r104, !this.hasLookaheadOccurred);
        if (r105 == null) goto L29;
        LazyStaggeredGridMeasureResult r106 = this.approachLayoutInfo;
        if (r106 == null) goto L29;
        if (r106 == null) goto L25;
        LazyStaggeredGridMeasureResult r107 = r106.copyWithScrollDeltaWithoutRemeasure(r104, true);
    L26:
        if (r107 == null) goto L28;
        this.approachLayoutInfo = r107;
        goto L29
    L28:
        r105 = null;
        goto L29
    L25:
        r107 = null;
    L29:
        if (r105 == null) goto L31;
        applyMeasureResult$foundation_release(r105, this.hasLookaheadOccurred, true);
        ObservableScopeInvalidator.m917invalidateScopeimpl(this.placementScopeInvalidator);
        notifyPrefetch(r103 - this.scrollToBeConsumed, r105);
        goto L36
    L31:
        Remeasurement r108 = this.remeasurement;
        if (r108 == null) goto L34;
        r108.forceRemeasure();
    L34:
        notifyPrefetch$default(this, r103 - this.scrollToBeConsumed, null, 2, null);
    L36:
        if (Math.abs(this.scrollToBeConsumed) > 0.5f) goto L38;
        return r100;
    L38:
        float r109 = r100 - this.scrollToBeConsumed;
        this.scrollToBeConsumed = 0.0f;
        return r109;
    L14:
        r101 = false;
        goto L15
    }

    private void setCanScrollBackward(boolean r100) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(r100));
    }

    private void setCanScrollForward(boolean r100) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(r100));
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float r100) {
        return this.scrollableState.dispatchRawDelta(r100);
    }

    public final float scrollToBeConsumed$foundation_release(boolean r100) {
        if (r100 == true) goto L8;
        if (this.hasLookaheadOccurred == false) goto L8;
        return getScrollDeltaBetweenPasses$foundation_release();
    L8:
        return this.scrollToBeConsumed;
    }

    public final void setMeasurePassCount$foundation_release(int r100) {
        this.measurePassCount = r100;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean r100) {
        this.prefetchingEnabled = r100;
    }

    public LazyStaggeredGridState(int r100, int r101) {
        this(new int[]{r100}, new int[]{r101}, null);
    }

    private static final List Saver$lambda$4(SaverScope r100, LazyStaggeredGridState r101) {
        return CollectionsKt.listOf(new int[][]{r101.scrollPosition.getIndices(), r101.scrollPosition.getScrollOffsets()});
    }

    public static final /* synthetic */ void access$setRemeasurement$p(LazyStaggeredGridState r100, Remeasurement r101) {
        r100.remeasurement = r101;
    }

    private final int[] fillNearestIndices(int r110, int r111) {
        int[] r100 = new int[r111];
        if (this.layoutInfoState.getValue().getSpanProvider().isFullSpan(r110) == false) goto L6;
        ArraysKt.fill$default(r100, r110, 0, 0, 6, null);
        return r100;
    L6:
        this.laneInfo.ensureValidIndex(r110 + r111);
        int r101 = this.laneInfo.getLane(r110);
        boolean r102 = false;
        if (r101 == (-2)) goto L14;
        if (r101 == (-1)) goto L14;
        if (r101 < 0) goto L11;
        r102 = true;
    L11:
        if (r102 == true) goto L13;
        InlineClassHelperKt.throwIllegalArgumentException("Expected positive lane number, got " + r101 + " instead.");
    L13:
        int r103 = Math.min(r101, r111);
    L15:
        int r104 = r103 - 1;
        int r105 = r110;
    L16:
        if ((-1) >= r104) goto L21;
        r105 = this.laneInfo.findPreviousItemIndex(r105, r104);
        r100[r104] = r105;
        if (r105 == (-1)) goto L19;
        r104 = r104 - 1;
        goto L16
    L19:
        ArraysKt.fill$default(r100, -1, 0, r104, 2, null);
    L21:
        r100[r103] = r110;
        int r106 = r103 + 1;
    L22:
        if (r106 >= r111) goto L24;
        r110 = this.laneInfo.findNextItemIndex(r110, r106);
        r100[r106] = r110;
        r106 = r106 + 1;
        goto L22
    L24:
        return r100;
    L14:
        r103 = 0;
        goto L15
    }

    private final void notifyPrefetch(float r110, LazyStaggeredGridMeasureResult r210) {
        if (this.prefetchingEnabled == false) goto L56;
        int r100 = 1;
        if ((!r210.getVisibleItemsInfo().isEmpty()) == true) goto L7;
        return;
    L7:
        if (r110 >= 0.0f) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == false) goto L12;
        int r102 = ((LazyStaggeredGridMeasuredItem) CollectionsKt.last(r210.getVisibleItemsInfo())).getIndex();
    L14:
        if (r102 != this.prefetchBaseIndex) goto L16;
        return;
    L16:
        this.prefetchBaseIndex = r102;
        LinkedHashSet r103 = new LinkedHashSet();
        LazyStaggeredGridSlots r104 = r210.getSlots();
        int r105 = r104.getSizes().length;
        int r106 = 0;
    L17:
        if (r106 >= r105) goto L49;
        if (r101 == false) goto L20;
        r102 = this.laneInfo.findNextItemIndex(r102, r106);
    L21:
        if (r102 >= 0) goto L23;
    L25:
        boolean r107 = false;
    L26:
        if (r107 == false) goto L49;
        if (r103.contains(Integer.valueOf(r102)) == true) goto L49;
        r103.add(Integer.valueOf(r102));
        if (this.currentItemPrefetchHandles.containsKey(Integer.valueOf(r102)) == true) goto L48;
        boolean r108 = r210.getSpanProvider().isFullSpan(r102);
        if (r108 == false) goto L36;
        int r111 = 0;
    L37:
        if (r108 == false) goto L39;
        int r109 = r105;
    L40:
        if (r109 != r100) goto L42;
        int r112 = r104.getSizes()[r111];
    L44:
        if (r210.getOrientation() != Orientation.Vertical) goto L46;
        long r113 = Constraints.Companion.m7499fixedWidthOenEA2s(r112);
    L47:
        Integer r114 = Integer.valueOf(r102);
        this.currentItemPrefetchHandles.put(r114, LazyLayoutPrefetchState.m902schedulePrecompositionAndPremeasureVKLhPVY$default(this.prefetchState, r102, r113, null, 4, null));
        goto L48
    L46:
        r113 = Constraints.Companion.m7498fixedHeightOenEA2s(r112);
        goto L47
    L42:
        int r115 = r104.getPositions()[r111];
        int r116 = (r111 + r109) - r100;
        r112 = (r104.getPositions()[r116] + r104.getSizes()[r116]) - r115;
        goto L44
    L39:
        r109 = 1;
        goto L40
    L36:
        r111 = r106;
    L48:
        r106 = r106 + 1;
        r100 = 1;
        goto L17
    L23:
        if (r102 >= r210.getTotalItemsCount()) goto L25;
        r107 = true;
        goto L26
    L20:
        r102 = this.laneInfo.findPreviousItemIndex(r102, r106);
    L49:
        clearLeftoverPrefetchHandles(r103);
        return;
    L12:
        r102 = ((LazyStaggeredGridMeasuredItem) CollectionsKt.first(r210.getVisibleItemsInfo())).getIndex();
        goto L14
    L9:
        r101 = false;
        goto L10
    }

    private static final float scrollableState$lambda$0(LazyStaggeredGridState r100, float r101) {
        return -r100.onScroll(-r101);
    }

    public final void requestScrollToItem(int r100, int r101) {
        if (isScrollInProgress() == false) goto L5;
        BuildersKt.launch$default(this.layoutInfoState.getValue().getCoroutineScope(), null, null, new AnonymousClass1(this, null), 3, null);
    L5:
        snapToItemInternal$foundation_release(r100, r101, false);
    }

    public final int[] updateScrollPositionIfTheFirstItemWasMoved$foundation_release(LazyLayoutItemProvider r100, int[] r101) {
        return this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(r100, r101);
    }

    public LazyStaggeredGridState(int[] r100, int[] r101, PrefetchScheduler r102) {
        LazyStaggeredGridScrollPosition r103 = new LazyStaggeredGridScrollPosition(r100, r101, new LazyStaggeredGridState$scrollPosition$1(this));
        this.scrollPosition = r103;
        this.layoutInfoState = SnapshotStateKt.mutableStateOf(LazyStaggeredGridMeasureResultKt.getEmptyLazyStaggeredGridLayoutInfo(), SnapshotStateKt.neverEqualPolicy());
        this.laneInfo = new LazyStaggeredGridLaneInfo();
        Boolean r104 = Boolean.FALSE;
        this.canScrollForward$delegate = SnapshotStateKt.mutableStateOf$default(r104, null, 2, null);
        this.canScrollBackward$delegate = SnapshotStateKt.mutableStateOf$default(r104, null, 2, null);
        this.remeasurementModifier = new LazyStaggeredGridState$remeasurementModifier$1(this);
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.prefetchingEnabled = true;
        this.prefetchState = new LazyLayoutPrefetchState(r102, null, 2, null);
        this.scrollableState = ScrollableStateKt.ScrollableState(new r(this));
        this.prefetchBaseIndex = -1;
        this.currentItemPrefetchHandles = new LinkedHashMap();
        this.mutableInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.pinnedItems = new LazyLayoutPinnedItemList();
        this.itemAnimator = new LazyLayoutItemAnimator();
        r103.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.m913constructorimpl$default(null, 1, null);
        this.measurementScopeInvalidator = ObservableScopeInvalidator.m913constructorimpl$default(null, 1, null);
        this._lazyLayoutScrollDeltaBetweenPasses = new LazyLayoutScrollDeltaBetweenPasses();
    }

    public static final /* synthetic */ int[] access$fillNearestIndices(LazyStaggeredGridState r100, int r101, int r102) {
        return r100.fillNearestIndices(r101, r102);
    }

    public final Object animateScrollToItem(int r110, int r111, Continuation<? super Unit> r112) {
        LazyStaggeredGridMeasureResult r100 = this.layoutInfoState.getValue();
        Object r101 = ScrollableState.CC.scroll$default(this, null, new AnonymousClass2(this, r110, r111, r100.getSlots().getSizes().length * 100, r100, null), r112, 1, null);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    public final void applyMeasureResult$foundation_release(LazyStaggeredGridMeasureResult r100, boolean r101, boolean r102) {
        if (r101 == true) goto L7;
        if (this.hasLookaheadOccurred == false) goto L7;
        this.approachLayoutInfo = r100;
        return;
    L7:
        if (r101 == false) goto L9;
        this.hasLookaheadOccurred = true;
    L9:
        this.scrollToBeConsumed -= r100.getConsumedScroll();
        this.layoutInfoState.setValue(r100);
        if (r102 == false) goto L12;
        this.scrollPosition.updateScrollOffset(r100.getFirstVisibleItemScrollOffsets());
    L13:
        setCanScrollBackward(r100.getCanScrollBackward());
        setCanScrollForward(r100.getCanScrollForward());
        if (r101 == false) goto L16;
        this._lazyLayoutScrollDeltaBetweenPasses.updateScrollDeltaForApproach$foundation_release(r100.getScrollBackAmount(), r100.getDensity(), r100.getCoroutineScope());
    L16:
        this.measurePassCount++;
        return;
    L12:
        this.scrollPosition.updateFromMeasureResult(r100);
        cancelPrefetchIfVisibleItemsChanged(r100);
        goto L13
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority r100, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof C86371) == false) goto L7;
        C86371 r103 = (C86371) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r105);
    L23:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (Function2) r103.L$1;
        r100 = (MutatePriority) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L19:
        ScrollableState r108 = this.scrollableState;
        r103.L$0 = null;
        r103.L$1 = null;
        r103.label = 2;
        if (r108.scroll(r100, r101, r103) != r106) goto L23;
        return r106;
    L16:
        ResultKt.throwOnFailure(r105);
        AwaitFirstLayoutModifier r109 = this.awaitLayoutModifier;
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        if (r109.waitForFirstLayout(r103) != r106) goto L19;
        return r106;
    L7:
        r103 = new C86371(this, r102);
        goto L8
    }

    public final Object scrollToItem(int r100, int r101, Continuation<? super Unit> r102) {
        Object r103 = ScrollableState.CC.scroll$default(this, null, new C86382(this, r100, r101, null), r102, 1, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public final void snapToItemInternal$foundation_release(int r100, int r101, boolean r102) {
        int r103 = 0;
        if (this.scrollPosition.getIndex() == r100) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        this.itemAnimator.reset();
    L11:
        LazyStaggeredGridMeasureResult r105 = this.layoutInfoState.getValue();
        LazyStaggeredGridItemInfo r106 = LazyStaggeredGridMeasureResultKt.findVisibleItem(r105, r100);
        if (r106 == null) goto L22;
        if (r104 == false) goto L22;
        if (r105.getOrientation() != Orientation.Vertical) goto L17;
        int r107 = IntOffset.m7677getYimpl(r106.mo935getOffsetnOccac());
    L18:
        int r108 = r107 + r101;
        int r109 = r105.getFirstVisibleItemScrollOffsets().length;
        int[] r110 = new int[r109];
    L19:
        if (r103 >= r109) goto L21;
        r110[r103] = r105.getFirstVisibleItemScrollOffsets()[r103] + r108;
        r103 = r103 + 1;
        goto L19
    L21:
        this.scrollPosition.updateScrollOffset(r110);
    L23:
        if (r102 == false) goto L27;
        Remeasurement r111 = this.remeasurement;
        if (r111 == null) goto L30;
        r111.forceRemeasure();
        return;
    L30:
        return;
    L27:
        ObservableScopeInvalidator.m917invalidateScopeimpl(this.measurementScopeInvalidator);
        return;
    L17:
        r107 = IntOffset.m7676getXimpl(r106.mo935getOffsetnOccac());
    L22:
        this.scrollPosition.requestPositionAndForgetLastKnownKey(r100, r101);
        goto L23
    L5:
        if (this.scrollPosition.getScrollOffset() != r101) goto L8;
        r104 = false;
        goto L9
    }

    public /* synthetic */ LazyStaggeredGridState(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }

    public static /* synthetic */ void notifyPrefetch$default(LazyStaggeredGridState r100, float r101, LazyStaggeredGridMeasureResult r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = r100.layoutInfoState.getValue();
    L5:
        r100.notifyPrefetch(r101, r102);
    }

    public static /* synthetic */ void requestScrollToItem$default(LazyStaggeredGridState r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = 0;
    L5:
        r100.requestScrollToItem(r101, r102);
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyStaggeredGridState r100, int r101, int r102, Continuation r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.animateScrollToItem(r101, r102, r103);
    }

    public static /* synthetic */ void applyMeasureResult$foundation_release$default(LazyStaggeredGridState r100, LazyStaggeredGridMeasureResult r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L5;
        r103 = false;
    L5:
        r100.applyMeasureResult$foundation_release(r101, r102, r103);
    }

    public static /* synthetic */ Object scrollToItem$default(LazyStaggeredGridState r100, int r101, int r102, Continuation r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.scrollToItem(r101, r102, r103);
    }
}
