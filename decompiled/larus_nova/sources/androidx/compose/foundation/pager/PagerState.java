package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
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
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollScope;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B)\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nJ\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005H\u0002J%\u0010\u0099\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u00032\t\b\u0003\u0010\u009c\u0001\u001a\u00020\u0005H\u0086@¢\u0006\u0003\u0010\u009d\u0001J!\u0010\u009e\u0001\u001a\u00030\u009a\u0001*\u00030\u009f\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u00032\t\b\u0003\u0010\u009c\u0001\u001a\u00020\u0005J\u0015\u0010 \u0001\u001a\u00030\u009a\u0001*\u00030\u009f\u00012\u0006\u0010k\u001a\u00020\u0003J+\u0010¡\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u00032\u0007\u0010¢\u0001\u001a\u00020\u00052\u0007\u0010£\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\b¤\u0001J\u001e\u0010§\u0001\u001a\u00030\u009a\u00012\t\b\u0001\u0010\u009b\u0001\u001a\u00020\u00032\t\b\u0003\u0010\u009c\u0001\u001a\u00020\u0005J7\u0010¨\u0001\u001a\u00030\u009a\u00012\u0007\u0010\u009b\u0001\u001a\u00020\u00032\t\b\u0003\u0010\u009c\u0001\u001a\u00020\u00052\u0010\b\u0002\u0010©\u0001\u001a\t\u0012\u0004\u0012\u00020\u00050ª\u0001H\u0086@¢\u0006\u0003\u0010«\u0001J\u0011\u0010¬\u0001\u001a\u00030\u009a\u0001H\u0082@¢\u0006\u0003\u0010\u00ad\u0001JK\u0010®\u0001\u001a\u00030\u009a\u00012\b\u0010¯\u0001\u001a\u00030°\u00012.\u0010±\u0001\u001a)\b\u0001\u0012\u0005\u0012\u00030\u009f\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u009a\u00010³\u0001\u0012\u0007\u0012\u0005\u0018\u00010´\u00010²\u0001¢\u0006\u0003\bµ\u0001H\u0096@¢\u0006\u0003\u0010¶\u0001J\u0011\u0010·\u0001\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005H\u0016J-\u0010Ç\u0001\u001a\u00030\u009a\u00012\u0007\u0010È\u0001\u001a\u00020\u00102\u0007\u0010É\u0001\u001a\u00020\f2\t\b\u0002\u0010Ê\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\bË\u0001J\u0013\u0010Ì\u0001\u001a\u00030\u009a\u00012\u0007\u0010È\u0001\u001a\u00020\u0010H\u0002J\r\u0010Í\u0001\u001a\u00020\u0003*\u00020\u0003H\u0002J\u0012\u0010Î\u0001\u001a\u00020\f2\u0007\u0010Ï\u0001\u001a\u00020\u0005H\u0002J\u000f\u0010Ð\u0001\u001a\u00020\fH\u0000¢\u0006\u0003\bÑ\u0001J\u001b\u0010Ò\u0001\u001a\u00030\u009a\u00012\u0006\u00101\u001a\u00020\u00052\u0007\u0010Ó\u0001\u001a\u00020BH\u0002J\u0013\u0010Ô\u0001\u001a\u00030\u009a\u00012\u0007\u0010Ó\u0001\u001a\u00020BH\u0002J\u001b\u0010Õ\u0001\u001a\u00020\u00032\u0007\u0010Ö\u0001\u001a\u00020\f2\u0007\u0010Ó\u0001\u001a\u00020BH\u0002J\u0010\u0010×\u0001\u001a\u00020\u00052\u0007\u0010\u009b\u0001\u001a\u00020\u0003J#\u0010Ø\u0001\u001a\u00020\u00032\b\u0010Ù\u0001\u001a\u00030Ú\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0003\bÛ\u0001R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u001e\u0010$\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u001a\u0010&\u001a\u00020'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR\u001a\u0010*\u001a\u00020'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\u000e\u0010-\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u0016R\u001e\u00104\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0016R\u000e\u00106\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u000f\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00100@X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010A\u001a\u00020B8F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bF\u0010\u0016R\u0014\u0010G\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\u0016R\u001a\u0010I\u001a\u00020JX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u0016R\u0014\u0010Q\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010T\u001a\u00020UX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u0011\u0010X\u001a\u00020Y8F¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\\\u0010\u0016R+\u0010]\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\b^\u0010\u0016\"\u0004\b_\u0010`R+\u0010c\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bf\u0010b\u001a\u0004\bd\u0010\u0016\"\u0004\be\u0010`R\u001b\u0010g\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bh\u0010\u0016R\u001b\u0010k\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bm\u0010j\u001a\u0004\bl\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bn\u0010SR\u0014\u0010o\u001a\u00020pX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bq\u0010rR\u0014\u0010s\u001a\u00020tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bu\u0010vR\u0014\u0010w\u001a\u00020xX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010zR1\u0010|\u001a\u0004\u0018\u00010{2\b\u0010\u0017\u001a\u0004\u0018\u00010{8@@BX\u0080\u008e\u0002¢\u0006\u0014\n\u0005\b\u0081\u0001\u0010\u001f\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001R!\u0010\u0086\u0001\u001a\u00030\u0087\u0001X\u0080\u000e¢\u0006\u0013\n\u0003\u0010\u008a\u0001\u001a\u0005\b\u0088\u0001\u0010\u001b\"\u0005\b\u0089\u0001\u0010\u001dR\u0018\u0010\u008b\u0001\u001a\u00030\u008c\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R!\u0010\u008f\u0001\u001a\u00030\u0090\u00018@X\u0080\u0084\u0002¢\u0006\u0010\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001*\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001a\u0010\u0095\u0001\u001a\u00030\u0096\u0001X\u0080\u0004¢\u0006\f\n\u0002\u0010\u001f\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001a\u0010¥\u0001\u001a\u00030\u0096\u0001X\u0080\u0004¢\u0006\f\n\u0002\u0010\u001f\u001a\u0006\b¦\u0001\u0010\u0098\u0001R\u0016\u0010¸\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¸\u0001\u0010\u000fR/\u0010¹\u0001\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f8F@BX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b¼\u0001\u0010\u001f\u001a\u0005\bº\u0001\u0010\u000f\"\u0005\b»\u0001\u0010:R/\u0010½\u0001\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\f8F@BX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\bÀ\u0001\u0010\u001f\u001a\u0005\b¾\u0001\u0010\u000f\"\u0005\b¿\u0001\u0010:R\u0015\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020\f0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010Â\u0001\u001a\b\u0012\u0004\u0012\u00020\f0@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010Ã\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÄ\u0001\u0010\u000fR\u0016\u0010Å\u0001\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÆ\u0001\u0010\u000f¨\u0006Ü\u0001"}, d2 = {"Landroidx/compose/foundation/pager/PagerState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "currentPage", "", "currentPageOffsetFraction", "", "prefetchScheduler", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "<init>", "(IFLandroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "(IF)V", "value", "", "hasLookaheadOccurred", "getHasLookaheadOccurred$foundation_release", "()Z", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "approachLayoutInfo", "getApproachLayoutInfo$foundation_release", "()Landroidx/compose/foundation/pager/PagerMeasureResult;", "pageCount", "getPageCount", "()I", "<set-?>", "Landroidx/compose/ui/geometry/Offset;", "upDownDifference", "getUpDownDifference-F1C5BW0$foundation_release", "()J", "setUpDownDifference-k-4lQ0M$foundation_release", "(J)V", "upDownDifference$delegate", "Landroidx/compose/runtime/MutableState;", "scrollPosition", "Landroidx/compose/foundation/pager/PagerScrollPosition;", "firstVisiblePage", "getFirstVisiblePage$foundation_release", "firstVisiblePageOffset", "getFirstVisiblePageOffset$foundation_release", "maxScrollOffset", "", "getMaxScrollOffset$foundation_release", "setMaxScrollOffset$foundation_release", "minScrollOffset", "getMinScrollOffset$foundation_release", "setMinScrollOffset$foundation_release", "accumulator", "previousPassDelta", "scrollableState", "performScroll", "delta", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "layoutWithMeasurement", "getLayoutWithMeasurement$foundation_release", "layoutWithoutMeasurement", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "(Z)V", "indexToPrefetch", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "wasPrefetchingForward", "pagerLayoutInfoState", "Landroidx/compose/runtime/MutableState;", "layoutInfo", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/pager/PagerLayoutInfo;", "pageSpacing", "getPageSpacing$foundation_release", "pageSize", "getPageSize$foundation_release", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "pageSizeWithSpacing", "getPageSizeWithSpacing$foundation_release", "positionThresholdFraction", "getPositionThresholdFraction$foundation_release", "()F", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "getCurrentPage", "programmaticScrollTargetPage", "getProgrammaticScrollTargetPage", "setProgrammaticScrollTargetPage", "(I)V", "programmaticScrollTargetPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "settledPageState", "getSettledPageState", "setSettledPageState", "settledPageState$delegate", "settledPage", "getSettledPage", "settledPage$delegate", "Landroidx/compose/runtime/State;", "targetPage", "getTargetPage", "targetPage$delegate", "getCurrentPageOffsetFraction", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "setRemeasurement", "(Landroidx/compose/ui/layout/Remeasurement;)V", "remeasurement$delegate", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "premeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "getPremeasureConstraints-msEJaDk$foundation_release", "setPremeasureConstraints-BRTryo0$foundation_release", "J", "pinnedPages", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedPages$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "nearestRange", "Lkotlin/ranges/IntRange;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/pager/PagerState;)Ljava/lang/Object;", "getNearestRange$foundation_release", "()Lkotlin/ranges/IntRange;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "scrollToPage", "", "page", "pageOffsetFraction", "(IFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCurrentPage", "Landroidx/compose/foundation/gestures/ScrollScope;", "updateTargetPage", "snapToItem", "offsetFraction", "forceRemeasure", "snapToItem$foundation_release", "measurementScopeInvalidator", "getMeasurementScopeInvalidator-zYiylxw$foundation_release", "requestScrollToPage", "animateScrollToPage", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(IFLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitScrollDependencies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", GXViewKey.VIEW_TYPE_CONTAINER_SCROLL, "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "isScrollInProgress", "canScrollForward", "getCanScrollForward", "setCanScrollForward", "canScrollForward$delegate", "canScrollBackward", "getCanScrollBackward", "setCanScrollBackward", "canScrollBackward$delegate", "isLastScrollForwardState", "isLastScrollBackwardState", "lastScrolledForward", "getLastScrolledForward", "lastScrolledBackward", "getLastScrolledBackward", "applyMeasureResult", "result", "isLookingAhead", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "tryRunPrefetch", "coerceInPageRange", "isGestureActionMatchesScroll", "scrollDelta", "isNotGestureAction", "isNotGestureAction$foundation_release", "notifyPrefetch", "info", "cancelPrefetchIfVisibleItemsChanged", "calculatePrefetchIndex", "forward", "getOffsetDistanceInPages", "matchScrollPositionWithKey", "itemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "matchScrollPositionWithKey$foundation_release", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class PagerState implements ScrollableState {
    public static final int $stable = 0;
    private float accumulator;
    private PagerMeasureResult approachLayoutInfo;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    private final MutableState canScrollBackward$delegate;
    private final MutableState canScrollForward$delegate;
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    private Density density;
    private int firstVisiblePage;
    private int firstVisiblePageOffset;
    private boolean hasLookaheadOccurred;
    private int indexToPrefetch;
    private final MutableInteractionSource internalInteractionSource;
    private final MutableState<Boolean> isLastScrollBackwardState;
    private final MutableState<Boolean> isLastScrollForwardState;
    private int layoutWithMeasurement;
    private int layoutWithoutMeasurement;
    private long maxScrollOffset;
    private final MutableState<Unit> measurementScopeInvalidator;
    private long minScrollOffset;
    private MutableState<PagerMeasureResult> pagerLayoutInfoState;
    private final LazyLayoutPinnedItemList pinnedPages;
    private final MutableState<Unit> placementScopeInvalidator;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private long premeasureConstraints;
    private float previousPassDelta;
    private final MutableIntState programmaticScrollTargetPage$delegate;
    private final MutableState remeasurement$delegate;
    private final RemeasurementModifier remeasurementModifier;
    private final PagerScrollPosition scrollPosition;
    private final ScrollableState scrollableState;
    private final State settledPage$delegate;
    private final MutableIntState settledPageState$delegate;
    private final State targetPage$delegate;
    private final MutableState upDownDifference$delegate;
    private boolean wasPrefetchingForward;

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$animateScrollToPage$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.pager.PagerState", f = "PagerState.kt", i = {0, 0, 0}, l = {612, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID}, m = "animateScrollToPage", n = {"animationSpec", "page", "pageOffsetFraction"}, s = {"L$0", "I$0", "F$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        int I$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PagerState this$0;

        public AnonymousClass1(PagerState r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.animateScrollToPage(0, 0.0f, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$animateScrollToPage$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.pager.PagerState$animateScrollToPage$3", f = "PagerState.kt", i = {}, l = {621}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ int $targetPage;
        final /* synthetic */ float $targetPageOffsetToSnappedPosition;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ PagerState this$0;

        public AnonymousClass3(PagerState r100, int r101, float r102, AnimationSpec<Float> r103, Continuation<? super AnonymousClass3> r104) {
            this.this$0 = r100;
            this.$targetPage = r101;
            this.$targetPageOffsetToSnappedPosition = r102;
            this.$animationSpec = r103;
            super(2, r104);
        }

        public static /* synthetic */ Unit a(PagerState r100, ScrollScope r101, int r102) {
            return invokeSuspend$lambda$0(r100, r101, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass3 r102 = new AnonymousClass3(this.this$0, this.$targetPage, this.$targetPageOffsetToSnappedPosition, this.$animationSpec, r101);
            r102.L$0 = r100;
            return r102;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(ScrollScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            LazyLayoutScrollScope r102 = PagerScrollScopeKt.LazyLayoutScrollScope(this.this$0, r111);
            int r103 = this.$targetPage;
            float r104 = this.$targetPageOffsetToSnappedPosition;
            AnimationSpec<Float> r105 = this.$animationSpec;
            final PagerState r112 = this.this$0;
            Function2 r106 = new e0(r112);
            this.label = 1;
            if (PagerStateKt.access$animateScrollToPage(r102, r103, r104, r105, r106, this) != r100) goto L12;
            return r100;
        }

        private static final Unit invokeSuspend$lambda$0(PagerState r100, ScrollScope r101, int r102) {
            r100.updateTargetPage(r101, r102);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$requestScrollToPage$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.pager.PagerState$requestScrollToPage$1", f = "PagerState.kt", i = {}, l = {583}, m = "invokeSuspend", n = {}, s = {})
    public static final class C86391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ PagerState this$0;

        public C86391(PagerState r100, Continuation<? super C86391> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C86391(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C86391) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            PagerState r103 = this.this$0;
            this.label = 1;
            if (ScrollExtensionsKt.stopScroll$default(r103, null, this, 1, null) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$scroll$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.pager.PagerState", f = "PagerState.kt", i = {0, 0, 0, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_TYPE}, m = "scroll$suspendImpl", n = {"$this", "scrollPriority", "block", "$this"}, s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class C86401 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ PagerState this$0;

        public C86401(PagerState r100, Continuation<? super C86401> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return PagerState.scroll$suspendImpl(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.pager.PagerState$scrollToPage$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.pager.PagerState$scrollToPage$2", f = "PagerState.kt", i = {}, l = {509}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $page;
        final /* synthetic */ float $pageOffsetFraction;
        int label;
        final /* synthetic */ PagerState this$0;

        public AnonymousClass2(PagerState r100, float r101, int r102, Continuation<? super AnonymousClass2> r103) {
            this.this$0 = r100;
            this.$pageOffsetFraction = r101;
            this.$page = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, this.$pageOffsetFraction, this.$page, r101);
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
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            float r103 = this.$pageOffsetFraction;
            double r104 = r103;
            boolean r105 = false;
            if ((-0.5d) <= r104) goto L14;
        L16:
            if (r105 == true) goto L18;
            InlineClassHelperKt.throwIllegalArgumentException("pageOffsetFraction " + r103 + " is not within the range -0.5 to 0.5");
        L18:
            this.this$0.snapToItem$foundation_release(PagerState.access$coerceInPageRange(this.this$0, this.$page), this.$pageOffsetFraction, true);
            return Unit.INSTANCE;
        L14:
            if (r104 > 0.5d) goto L16;
            r105 = true;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            PagerState r106 = this.this$0;
            this.label = 1;
            if (PagerState.access$awaitScrollDependencies(r106, this) != r101) goto L11;
            return r101;
        }
    }

    public PagerState() {
        this(0, 0.0f, null, 7, null);
    }

    public static /* synthetic */ int a(PagerState r100) {
        return settledPage_delegate$lambda$6(r100);
    }

    public static /* synthetic */ Unit b(PagerState r100, NestedPrefetchScope r101) {
        return prefetchState$lambda$9(r100, r101);
    }

    public static /* synthetic */ int c(PagerState r100) {
        return targetPage_delegate$lambda$7(r100);
    }

    public static /* synthetic */ float d(PagerState r100, float r101) {
        return scrollableState$lambda$1(r100, r101);
    }

    public abstract int getPageCount();

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority r100, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        return scroll$suspendImpl(this, r100, r101, r102);
    }

    private final int getProgrammaticScrollTargetPage() {
        return this.programmaticScrollTargetPage$delegate.getIntValue();
    }

    private final int getSettledPageState() {
        return this.settledPageState$delegate.getIntValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    public final int getCurrentPage() {
        return this.scrollPosition.getCurrentPage();
    }

    public final float getCurrentPageOffsetFraction() {
        return this.scrollPosition.getCurrentPageOffsetFraction();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledBackward() {
        return this.isLastScrollBackwardState.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean getLastScrolledForward() {
        return this.isLastScrollForwardState.getValue().booleanValue();
    }

    public final PagerLayoutInfo getLayoutInfo() {
        return this.pagerLayoutInfoState.getValue();
    }

    public final IntRange getNearestRange$foundation_release() {
        return this.scrollPosition.getNearestRangeState().getValue();
    }

    public final int getNumMeasurePasses$foundation_release() {
        return this.layoutWithMeasurement + this.layoutWithoutMeasurement;
    }

    public final int getPageSize$foundation_release() {
        return this.pagerLayoutInfoState.getValue().getPageSize();
    }

    public final int getPageSpacing$foundation_release() {
        return this.pagerLayoutInfoState.getValue().getPageSpacing();
    }

    public final float getPositionThresholdFraction$foundation_release() {
        return Math.min(this.density.mo371toPx0680j_4(PagerStateKt.getDefaultPositionThreshold()), getPageSize$foundation_release() / 2.0f) / getPageSize$foundation_release();
    }

    public final Remeasurement getRemeasurement$foundation_release() {
        return (Remeasurement) this.remeasurement$delegate.getValue();
    }

    public final int getSettledPage() {
        return ((Number) this.settledPage$delegate.getValue()).intValue();
    }

    public final int getTargetPage() {
        return ((Number) this.targetPage$delegate.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getUpDownDifference-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m984getUpDownDifferenceF1C5BW0$foundation_release() {
        return ((Offset) this.upDownDifference$delegate.getValue()).m4592unboximpl();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public final int getPageSizeWithSpacing$foundation_release() {
        return getPageSize$foundation_release() + getPageSpacing$foundation_release();
    }

    public final boolean isNotGestureAction$foundation_release() {
        if (((int) Float.intBitsToFloat((int) (m984getUpDownDifferenceF1C5BW0$foundation_release() >> 32))) == 0) goto L5;
    L7:
        return false;
    L5:
        if (((int) Float.intBitsToFloat((int) (m984getUpDownDifferenceF1C5BW0$foundation_release() & BodyPartID.bodyIdMax))) != 0) goto L7;
        return true;
    }

    public final PagerMeasureResult getApproachLayoutInfo$foundation_release() {
        return this.approachLayoutInfo;
    }

    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo$foundation_release() {
        return this.beyondBoundsInfo;
    }

    public final Density getDensity$foundation_release() {
        return this.density;
    }

    public final int getFirstVisiblePage$foundation_release() {
        return this.firstVisiblePage;
    }

    public final int getFirstVisiblePageOffset$foundation_release() {
        return this.firstVisiblePageOffset;
    }

    public final boolean getHasLookaheadOccurred$foundation_release() {
        return this.hasLookaheadOccurred;
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    public final int getLayoutWithMeasurement$foundation_release() {
        return this.layoutWithMeasurement;
    }

    public final long getMaxScrollOffset$foundation_release() {
        return this.maxScrollOffset;
    }

    /* JADX INFO: renamed from: getMeasurementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m981getMeasurementScopeInvalidatorzYiylxw$foundation_release() {
        return this.measurementScopeInvalidator;
    }

    public final long getMinScrollOffset$foundation_release() {
        return this.minScrollOffset;
    }

    public final LazyLayoutPinnedItemList getPinnedPages$foundation_release() {
        return this.pinnedPages;
    }

    /* JADX INFO: renamed from: getPlacementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<Unit> m982getPlacementScopeInvalidatorzYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    /* JADX INFO: renamed from: getPremeasureConstraints-msEJaDk$foundation_release, reason: not valid java name */
    public final long m983getPremeasureConstraintsmsEJaDk$foundation_release() {
        return this.premeasureConstraints;
    }

    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    private final Object awaitScrollDependencies(Continuation<? super Unit> r100) {
        Object r101 = this.awaitLayoutModifier.waitForFirstLayout(r100);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Unit.INSTANCE;
    }

    private final void cancelPrefetchIfVisibleItemsChanged(PagerLayoutInfo r100) {
        if (this.indexToPrefetch != (-1)) goto L5;
        return;
    L5:
        if ((!r100.getVisiblePagesInfo().isEmpty()) == true) goto L7;
        return;
    L7:
        if (this.indexToPrefetch == calculatePrefetchIndex(this.wasPrefetchingForward, r100)) goto L15;
        this.indexToPrefetch = -1;
        LazyLayoutPrefetchState.PrefetchHandle r101 = this.currentPrefetchHandle;
        if (r101 == null) goto L11;
        r101.cancel();
    L11:
        this.currentPrefetchHandle = null;
        return;
    }

    private final int coerceInPageRange(int r100) {
        if (getPageCount() > 0) goto L5;
        return 0;
    L5:
        return RangesKt.coerceIn(r100, 0, getPageCount() - 1);
    }

    private static Object getNearestRange$foundation_release$delegate(PagerState r100) {
        return r100.scrollPosition.getNearestRangeState();
    }

    private final boolean isGestureActionMatchesScroll(float r100) {
        if (getLayoutInfo().getOrientation() != Orientation.Vertical) goto L8;
        if (Math.signum(r100) == Math.signum(-Float.intBitsToFloat((int) (m984getUpDownDifferenceF1C5BW0$foundation_release() & BodyPartID.bodyIdMax)))) goto L9;
    L10:
        boolean r101 = false;
    L11:
        if (r101 == false) goto L13;
        return true;
    L13:
        if (isNotGestureAction$foundation_release() == true) goto L18;
        return false;
    L18:
        return true;
    L9:
        r101 = true;
        goto L11
    L8:
        if (Math.signum(r100) != Math.signum(-Float.intBitsToFloat((int) (m984getUpDownDifferenceF1C5BW0$foundation_release() >> 32)))) goto L10;
        goto L9
    }

    private final float performScroll(float r110) {
        long r100 = PagerScrollPositionKt.currentAbsoluteScrollOffset(this);
        float r101 = this.accumulator + r110;
        long r102 = MathKt.roundToLong(r101);
        this.accumulator = r101 - r102;
        if (Math.abs(r110) >= 1.0E-4f) goto L5;
        return r110;
    L5:
        long r103 = r102 + r100;
        long r104 = RangesKt.coerceIn(r103, this.minScrollOffset, this.maxScrollOffset);
        boolean r105 = false;
        if (r103 == r104) goto L8;
        boolean r106 = true;
    L9:
        long r107 = r104 - r100;
        float r108 = r107;
        this.previousPassDelta = r108;
        if (Math.abs(r107) == 0) goto L19;
        MutableState<Boolean> r109 = this.isLastScrollForwardState;
        if (r108 <= 0.0f) goto L14;
        boolean r111 = true;
    L15:
        r109.setValue(Boolean.valueOf(r111));
        MutableState<Boolean> r112 = this.isLastScrollBackwardState;
        if (r108 >= 0.0f) goto L18;
        r105 = true;
    L18:
        r112.setValue(Boolean.valueOf(r105));
        goto L19
    L14:
        r111 = false;
    L19:
        int r113 = (int) r107;
        int r114 = -r113;
        PagerMeasureResult r115 = this.pagerLayoutInfoState.getValue().copyWithScrollDeltaWithoutRemeasure(r114);
        if (r115 == null) goto L30;
        PagerMeasureResult r116 = this.approachLayoutInfo;
        if (r116 == null) goto L30;
        if (r116 == null) goto L26;
        PagerMeasureResult r117 = r116.copyWithScrollDeltaWithoutRemeasure(r114);
    L27:
        if (r117 == null) goto L29;
        this.approachLayoutInfo = r117;
        goto L30
    L29:
        r115 = null;
        goto L30
    L26:
        r117 = null;
    L30:
        if (r115 == null) goto L32;
        applyMeasureResult$foundation_release(r115, this.hasLookaheadOccurred, true);
        ObservableScopeInvalidator.m917invalidateScopeimpl(this.placementScopeInvalidator);
        this.layoutWithoutMeasurement++;
    L36:
        if (r106 == false) goto L38;
        Number r118 = Long.valueOf(r107);
    L40:
        return r118.floatValue();
    L38:
        r118 = Float.valueOf(r110);
        goto L40
    L32:
        this.scrollPosition.applyScrollDelta(r113);
        Remeasurement r119 = getRemeasurement$foundation_release();
        if (r119 == null) goto L35;
        r119.forceRemeasure();
    L35:
        this.layoutWithMeasurement++;
        goto L36
    L8:
        r106 = false;
        goto L9
    }

    private final void setCanScrollBackward(boolean r100) {
        this.canScrollBackward$delegate.setValue(Boolean.valueOf(r100));
    }

    private final void setCanScrollForward(boolean r100) {
        this.canScrollForward$delegate.setValue(Boolean.valueOf(r100));
    }

    private final void setProgrammaticScrollTargetPage(int r100) {
        this.programmaticScrollTargetPage$delegate.setIntValue(r100);
    }

    private final void setRemeasurement(Remeasurement r100) {
        this.remeasurement$delegate.setValue(r100);
    }

    private final void setSettledPageState(int r100) {
        this.settledPageState$delegate.setIntValue(r100);
    }

    private static final int settledPage_delegate$lambda$6(PagerState r100) {
        if (r100.isScrollInProgress() == false) goto L6;
        return r100.getSettledPageState();
    L6:
        return r100.getCurrentPage();
    }

    private static final int targetPage_delegate$lambda$7(PagerState r100) {
        if (r100.isScrollInProgress() == true) goto L6;
        int r101 = r100.getCurrentPage();
    L16:
        return r100.coerceInPageRange(r101);
    L6:
        if (r100.getProgrammaticScrollTargetPage() == (-1)) goto L9;
        r101 = r100.getProgrammaticScrollTargetPage();
        goto L16
    L9:
        if (Math.abs(r100.getCurrentPageOffsetFraction()) >= Math.abs(r100.getPositionThresholdFraction$foundation_release())) goto L11;
        r101 = r100.getCurrentPage();
        goto L16
    L11:
        if (r100.getLastScrolledForward() == false) goto L13;
        r101 = r100.firstVisiblePage + 1;
        goto L16
    L13:
        r101 = r100.firstVisiblePage;
        goto L16
    }

    private final void tryRunPrefetch(PagerMeasureResult r100) {
        Snapshot.Companion r101 = Snapshot.Companion;
        Snapshot r102 = r101.getCurrentThreadSnapshot();
        if (r102 == null) goto L5;
        Function1<Object, Unit> r103 = r102.getReadObserver();
    L6:
        Snapshot r104 = r101.makeCurrentNonObservable(r102);
    L27:
        th = move-exception;
        r101.restoreNonObservable(r102, r104, r103);
        throw th;
    L8:
        if (this.prefetchingEnabled == true) goto L12;
        r101.restoreNonObservable(r102, r104, r103);
        return;
    L12:
        if (r100.getBeyondViewportPageCount() < getPageCount()) goto L17;
        r101.restoreNonObservable(r102, r104, r103);
        return;
    L17:
        if (Math.abs(this.previousPassDelta) > 0.5f) goto L21;
        r101.restoreNonObservable(r102, r104, r103);
        return;
    L21:
        if (isGestureActionMatchesScroll(this.previousPassDelta) == true) goto L24;
        r101.restoreNonObservable(r102, r104, r103);
        return;
    L24:
        notifyPrefetch(this.previousPassDelta, r100);     // Catch: Throwable -> L27
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L27
        r101.restoreNonObservable(r102, r104, r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float r100) {
        return this.scrollableState.dispatchRawDelta(r100);
    }

    public final float getOffsetDistanceInPages(int r100) {
        boolean r101 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r101 == true) goto L10;
        InlineClassHelperKt.throwIllegalArgumentException("page " + r100 + " is not within the range 0 to " + getPageCount());
    L10:
        return (r100 - getCurrentPage()) - getCurrentPageOffsetFraction();
    L5:
        if (r100 > getPageCount()) goto L7;
        r101 = true;
        goto L7
    }

    public final void setDensity$foundation_release(Density r100) {
        this.density = r100;
    }

    public final void setMaxScrollOffset$foundation_release(long r100) {
        this.maxScrollOffset = r100;
    }

    public final void setMinScrollOffset$foundation_release(long r100) {
        this.minScrollOffset = r100;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean r100) {
        this.prefetchingEnabled = r100;
    }

    /* JADX INFO: renamed from: setPremeasureConstraints-BRTryo0$foundation_release, reason: not valid java name */
    public final void m985setPremeasureConstraintsBRTryo0$foundation_release(long r100) {
        this.premeasureConstraints = r100;
    }

    /* JADX INFO: renamed from: setUpDownDifference-k-4lQ0M$foundation_release, reason: not valid java name */
    public final void m986setUpDownDifferencek4lQ0M$foundation_release(long r100) {
        this.upDownDifference$delegate.setValue(Offset.m4571boximpl(r100));
    }

    public PagerState(int r100, float r101) {
        this(r100, r101, null);
    }

    public static final /* synthetic */ Object access$awaitScrollDependencies(PagerState r100, Continuation r101) {
        return r100.awaitScrollDependencies(r101);
    }

    public static final /* synthetic */ int access$coerceInPageRange(PagerState r100, int r101) {
        return r100.coerceInPageRange(r101);
    }

    public static final /* synthetic */ void access$setRemeasurement(PagerState r100, Remeasurement r101) {
        r100.setRemeasurement(r101);
    }

    private final int calculatePrefetchIndex(boolean r100, PagerLayoutInfo r101) {
        if (r100 == false) goto L8;
        int r102 = r101.getBeyondViewportPageCount() + 1;
        if (r102 >= 0) goto L10;
        return Integer.MAX_VALUE;
    L10:
        return r102 + ((PageInfo) CollectionsKt.last(r101.getVisiblePagesInfo())).getIndex();
    L8:
        return (((PageInfo) CollectionsKt.first(r101.getVisiblePagesInfo())).getIndex() - r101.getBeyondViewportPageCount()) - 1;
    }

    private final void notifyPrefetch(float r110, PagerLayoutInfo r111) {
        if (this.prefetchingEnabled == true) goto L5;
        return;
    L5:
        boolean r100 = true;
        if ((!r111.getVisiblePagesInfo().isEmpty()) == true) goto L8;
        return;
    L8:
        if (r110 <= 0.0f) goto L10;
        boolean r101 = true;
    L11:
        int r102 = calculatePrefetchIndex(r101, r111);
        if (r102 >= 0) goto L14;
    L16:
        r100 = false;
    L17:
        if (r100 == true) goto L19;
        return;
    L19:
        if (r102 != this.indexToPrefetch) goto L21;
    L26:
        if (r101 == false) goto L33;
        PageInfo r103 = (PageInfo) CollectionsKt.last(r111.getVisiblePagesInfo());
        if (((r103.getOffset() + (r111.getPageSize() + r111.getPageSpacing())) - r111.getViewportEndOffset()) >= r110) goto L40;
        LazyLayoutPrefetchState.PrefetchHandle r112 = this.currentPrefetchHandle;
        if (r112 == null) goto L41;
        r112.markAsUrgent();
        return;
    L41:
        return;
    L40:
        return;
    L33:
        if ((r111.getViewportStartOffset() - ((PageInfo) CollectionsKt.first(r111.getVisiblePagesInfo())).getOffset()) >= (-r110)) goto L43;
        LazyLayoutPrefetchState.PrefetchHandle r113 = this.currentPrefetchHandle;
        if (r113 == null) goto L44;
        r113.markAsUrgent();
        return;
    L44:
        return;
    L43:
        return;
    L21:
        if (this.wasPrefetchingForward == r101) goto L25;
        LazyLayoutPrefetchState.PrefetchHandle r104 = this.currentPrefetchHandle;
        if (r104 == null) goto L25;
        r104.cancel();
    L25:
        this.wasPrefetchingForward = r101;
        this.indexToPrefetch = r102;
        this.currentPrefetchHandle = LazyLayoutPrefetchState.m902schedulePrecompositionAndPremeasureVKLhPVY$default(this.prefetchState, r102, this.premeasureConstraints, null, 4, null);
        goto L26
    L14:
        if (r102 >= getPageCount()) goto L16;
    L10:
        r101 = false;
        goto L11
    }

    private static final Unit prefetchState$lambda$9(PagerState r100, NestedPrefetchScope r101) {
        Snapshot.Companion r102 = Snapshot.Companion;
        Snapshot r103 = r102.getCurrentThreadSnapshot();
        if (r103 == null) goto L5;
        Function1<Object, Unit> r104 = r103.getReadObserver();
    L6:
        Snapshot r105 = r102.makeCurrentNonObservable(r103);
        r101.schedulePrecomposition(r100.firstVisiblePage);     // Catch: Throwable -> L10
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r102.restoreNonObservable(r103, r105, r104);
        return Unit.INSTANCE;
    L10:
        th = move-exception;
        r102.restoreNonObservable(r103, r105, r104);
        throw th;
    L5:
        r104 = null;
        goto L6
    }

    private static final float scrollableState$lambda$1(PagerState r100, float r101) {
        return r100.performScroll(r101);
    }

    public final int matchScrollPositionWithKey$foundation_release(PagerLazyLayoutItemProvider r100, int r101) {
        return this.scrollPosition.matchPageWithKey(r100, r101);
    }

    public final void requestScrollToPage(int r100, float r101) {
        if (isScrollInProgress() == false) goto L5;
        BuildersKt.launch$default(this.pagerLayoutInfoState.getValue().getCoroutineScope(), null, null, new C86391(this, null), 3, null);
    L5:
        snapToItem$foundation_release(r100, r101, false);
    }

    public final void updateTargetPage(ScrollScope r100, int r101) {
        setProgrammaticScrollTargetPage(coerceInPageRange(r101));
    }

    public PagerState(int r110, float r111, PrefetchScheduler r112) {
        double r100 = r111;
        boolean r101 = false;
        if ((-0.5d) <= r100) goto L5;
    L7:
        if (r101 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("currentPageOffsetFraction " + r111 + " is not within the range -0.5 to 0.5");
    L9:
        this.upDownDifference$delegate = SnapshotStateKt.mutableStateOf$default(Offset.m4571boximpl(Offset.Companion.m4598getZeroF1C5BW0()), null, 2, null);
        PagerScrollPosition r102 = new PagerScrollPosition(r110, r111, this);
        this.scrollPosition = r102;
        this.firstVisiblePage = r110;
        this.maxScrollOffset = Long.MAX_VALUE;
        this.scrollableState = ScrollableStateKt.ScrollableState(new a0(this));
        this.prefetchingEnabled = true;
        this.indexToPrefetch = -1;
        this.pagerLayoutInfoState = SnapshotStateKt.mutableStateOf(PagerStateKt.getEmptyLayoutInfo(), SnapshotStateKt.neverEqualPolicy());
        this.density = PagerStateKt.access$getUnitDensity$p();
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.programmaticScrollTargetPage$delegate = SnapshotIntStateKt.mutableIntStateOf(-1);
        this.settledPageState$delegate = SnapshotIntStateKt.mutableIntStateOf(r110);
        this.settledPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new b0(this));
        this.targetPage$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new c0(this));
        this.prefetchState = new LazyLayoutPrefetchState(r112, new d0(this));
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.remeasurement$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.remeasurementModifier = new PagerState$remeasurementModifier$1(this);
        this.premeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        this.pinnedPages = new LazyLayoutPinnedItemList();
        r102.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.m913constructorimpl$default(null, 1, null);
        this.measurementScopeInvalidator = ObservableScopeInvalidator.m913constructorimpl$default(null, 1, null);
        Boolean r113 = Boolean.FALSE;
        this.canScrollForward$delegate = SnapshotStateKt.mutableStateOf$default(r113, null, 2, null);
        this.canScrollBackward$delegate = SnapshotStateKt.mutableStateOf$default(r113, null, 2, null);
        this.isLastScrollForwardState = SnapshotStateKt.mutableStateOf$default(r113, null, 2, null);
        this.isLastScrollBackwardState = SnapshotStateKt.mutableStateOf$default(r113, null, 2, null);
        return;
    L5:
        if (r100 > 0.5d) goto L7;
        r101 = true;
        goto L7
    }

    public final void applyMeasureResult$foundation_release(PagerMeasureResult r100, boolean r101, boolean r102) {
        this.prefetchState.setIdealNestedPrefetchCount$foundation_release(r100.getVisiblePagesInfo().size());
        if (r101 == false) goto L5;
    L7:
        if (r101 == false) goto L9;
        this.hasLookaheadOccurred = true;
    L9:
        if (r102 == false) goto L11;
        this.scrollPosition.updateCurrentPageOffsetFraction(r100.getCurrentPageOffsetFraction());
    L12:
        this.pagerLayoutInfoState.setValue(r100);
        setCanScrollForward(r100.getCanScrollForward());
        setCanScrollBackward(r100.getCanScrollBackward());
        MeasuredPage r103 = r100.getFirstVisiblePage();
        if (r103 == null) goto L15;
        this.firstVisiblePage = r103.getIndex();
    L15:
        this.firstVisiblePageOffset = r100.getFirstVisiblePageScrollOffset();
        tryRunPrefetch(r100);
        this.maxScrollOffset = PagerStateKt.calculateNewMaxScrollOffset(r100, getPageCount());
        this.minScrollOffset = PagerStateKt.access$calculateNewMinScrollOffset(r100, getPageCount());
        return;
    L11:
        this.scrollPosition.updateFromMeasureResult(r100);
        cancelPrefetchIfVisibleItemsChanged(r100);
        goto L12
    L5:
        if (this.hasLookaheadOccurred == false) goto L7;
        this.approachLayoutInfo = r100;
    }

    public final Object scrollToPage(int r100, float r101, Continuation<? super Unit> r102) {
        Object r103 = ScrollableState.CC.scroll$default(this, null, new AnonymousClass2(this, r101, r100, null), r102, 1, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public final void snapToItem$foundation_release(int r100, float r101, boolean r102) {
        this.scrollPosition.requestPositionAndForgetLastKnownKey(r100, r101);
        if (r102 == false) goto L7;
        Remeasurement r103 = getRemeasurement$foundation_release();
        if (r103 == null) goto L9;
        r103.forceRemeasure();
        return;
    L9:
        return;
    L7:
        ObservableScopeInvalidator.m917invalidateScopeimpl(this.measurementScopeInvalidator);
    }

    public final void updateCurrentPage(ScrollScope r100, int r101, float r102) {
        snapToItem$foundation_release(r101, r102, true);
    }

    public /* synthetic */ PagerState(int r100, float r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0.0f;
    L8:
        this(r100, r101);
    }

    public static /* synthetic */ Object scroll$suspendImpl(PagerState r100, MutatePriority r101, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> r102, Continuation<? super Unit> r103) {
        if ((r103 instanceof C86401) == false) goto L7;
        C86401 r104 = (C86401) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L16;
        if (r108 == 1) goto L15;
        if (r108 != 2) goto L14;
        r100 = (PagerState) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L25:
        r100.setProgrammaticScrollTargetPage(-1);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r102 = (Function2) r104.L$2;
        r101 = (MutatePriority) r104.L$1;
        r100 = (PagerState) r104.L$0;
        ResultKt.throwOnFailure(r106);
    L20:
        if (r100.isScrollInProgress() == true) goto L22;
        r100.setSettledPageState(r100.getCurrentPage());
    L22:
        ScrollableState r109 = r100.scrollableState;
        r104.L$0 = r100;
        r104.L$1 = null;
        r104.L$2 = null;
        r104.label = 2;
        if (r109.scroll(r101, r102, r104) != r107) goto L25;
        return r107;
    L16:
        ResultKt.throwOnFailure(r106);
        r104.L$0 = r100;
        r104.L$1 = r101;
        r104.L$2 = r102;
        r104.label = 1;
        if (r100.awaitScrollDependencies(r104) != r107) goto L20;
        return r107;
    L7:
        r104 = new C86401(r100, r103);
        goto L8
    }

    public final Object animateScrollToPage(int r110, float r111, AnimationSpec<Float> r112, Continuation<? super Unit> r113) {
        int r100 = r110;
        float r101 = r111;
        if ((r113 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r113;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        AnonymousClass1 r104 = r102;
        Object r105 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        boolean r108 = false;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        ResultKt.throwOnFailure(r105);
    L42:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        float r109 = r104.F$0;
        int r114 = r104.I$0;
        AnimationSpec<Float> r115 = (AnimationSpec) r104.L$0;
        ResultKt.throwOnFailure(r105);
        AnimationSpec<Float> r116 = r115;
        r101 = r109;
        r100 = r114;
    L31:
        double r117 = r101;
        if ((-0.5d) <= r117) goto L34;
    L36:
        if (r108 == true) goto L38;
        InlineClassHelperKt.throwIllegalArgumentException("pageOffsetFraction " + r101 + " is not within the range -0.5 to 0.5");
    L38:
        AnonymousClass3 r118 = new AnonymousClass3(this, coerceInPageRange(r100), r101 * getPageSizeWithSpacing$foundation_release(), r116, null);
        r104.L$0 = null;
        r104.label = 2;
        if (ScrollableState.CC.scroll$default(this, null, r118, r104, 1, null) != r106) goto L42;
        return r106;
    L34:
        if (r117 > 0.5d) goto L36;
        r108 = true;
        goto L36
    L16:
        ResultKt.throwOnFailure(r105);
        if (r100 != getCurrentPage()) goto L24;
        if (getCurrentPageOffsetFraction() != r101) goto L21;
        boolean r119 = true;
    L22:
        if (r119 == false) goto L24;
    L26:
        return Unit.INSTANCE;
    L21:
        r119 = false;
    L24:
        if (getPageCount() == 0) goto L26;
        r104.L$0 = r112;
        r104.I$0 = r100;
        r104.F$0 = r101;
        r104.label = 1;
        if (awaitScrollDependencies(r104) != r106) goto L30;
        return r106;
    L30:
        r116 = r112;
    L7:
        r102 = new AnonymousClass1(this, r113);
        goto L8
    }

    public /* synthetic */ PagerState(int r100, float r101, PrefetchScheduler r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0.0f;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }

    public static /* synthetic */ int matchScrollPositionWithKey$foundation_release$default(PagerState r100, PagerLazyLayoutItemProvider r101, int r102, int r103, Object r104) {
        if (r104 != null) goto L18;
        if ((r103 & 2) == 0) goto L16;
        Snapshot.Companion r105 = Snapshot.Companion;
        Snapshot r106 = r105.getCurrentThreadSnapshot();
        if (r106 == null) goto L8;
        Function1<Object, Unit> r107 = r106.getReadObserver();
    L9:
        Snapshot r108 = r105.makeCurrentNonObservable(r106);
        int r109 = r100.scrollPosition.getCurrentPage();     // Catch: Throwable -> L12
        r105.restoreNonObservable(r106, r108, r107);
        r102 = r109;
    L12:
        th = move-exception;
        r105.restoreNonObservable(r106, r108, r107);
        throw th;
    L8:
        r107 = null;
    L16:
        return r100.matchScrollPositionWithKey$foundation_release(r101, r102);
    L18:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: matchScrollPositionWithKey");
    }

    public static /* synthetic */ void requestScrollToPage$default(PagerState r100, int r101, float r102, int r103, Object r104) {
        if (r104 != null) goto L9;
        if ((r103 & 2) == 0) goto L6;
        r102 = 0.0f;
    L6:
        r100.requestScrollToPage(r101, r102);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestScrollToPage");
    }

    public static /* synthetic */ void applyMeasureResult$foundation_release$default(PagerState r100, PagerMeasureResult r101, boolean r102, boolean r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        r100.applyMeasureResult$foundation_release(r101, r102, r103);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyMeasureResult");
    }

    public static /* synthetic */ Object scrollToPage$default(PagerState r100, int r101, float r102, Continuation r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 2) == 0) goto L7;
        r102 = 0.0f;
    L7:
        return r100.scrollToPage(r101, r102, r103);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToPage");
    }

    public static /* synthetic */ void updateCurrentPage$default(PagerState r100, ScrollScope r101, int r102, float r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 2) == 0) goto L6;
        r103 = 0.0f;
    L6:
        r100.updateCurrentPage(r101, r102, r103);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCurrentPage");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateScrollToPage$default(PagerState r100, int r101, float r102, AnimationSpec r103, Continuation r104, int r105, Object r106) {
        if (r106 != null) goto L12;
        if ((r105 & 2) == 0) goto L7;
        r102 = 0.0f;
    L7:
        if ((r105 & 4) == 0) goto L10;
        r103 = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
    L10:
        return r100.animateScrollToPage(r101, r102, r103, r104);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateScrollToPage");
    }
}
