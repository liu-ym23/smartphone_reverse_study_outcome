package androidx.compose.foundation.pager;

import B7.a;
import C7.r;
import D7.v;
import J7.c;
import S7.k;
import S7.n;
import Y7.f;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Stable
@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u00002\u00020\u0001B)\b\u0000\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\nJ\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0003\u0010\f\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0011\u001a\u00020\r*\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0003\u0010\f\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0014\u001a\u00020\r*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001c\u001a\u00020\r2\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0003\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u001c\u0010\nJ2\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0003\u0010\f\u001a\u00020\u00042\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0086@¢\u0006\u0004\b\u001f\u0010 J<\u0010'\u001a\u00020\r2\u0006\u0010\"\u001a\u00020!2\"\u0010&\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0$\u0012\u0006\u0012\u0004\u0018\u00010%0#H\u0096@¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0016¢\u0006\u0004\b*\u0010+J!\u00101\u001a\u00020\r2\u0006\u0010-\u001a\u00020,2\b\b\u0002\u0010.\u001a\u00020\u0017H\u0000¢\u0006\u0004\b/\u00100J\u0015\u00102\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b2\u00103J!\u00108\u001a\u00020\u00022\u0006\u00105\u001a\u0002042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b6\u00107J\u0017\u00109\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u0004H\u0002¢\u0006\u0004\b9\u0010+J\u0010\u0010:\u001a\u00020\rH\u0082@¢\u0006\u0004\b:\u0010;J\u0017\u0010<\u001a\u00020\r2\u0006\u0010-\u001a\u00020,H\u0002¢\u0006\u0004\b<\u0010=J\u0013\u0010>\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u00020\u00172\u0006\u0010@\u001a\u00020\u0004H\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0017H\u0002¢\u0006\u0004\bC\u0010DJ\u001f\u0010G\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bG\u0010HJ\u0017\u0010I\u001a\u00020\r2\u0006\u0010F\u001a\u00020EH\u0002¢\u0006\u0004\bI\u0010JR1\u0010S\u001a\u00020K2\u0006\u0010L\u001a\u00020K8@@@X\u0080\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020T8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020W8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR$\u0010Z\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00028\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]R$\u0010^\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00028\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b^\u0010[\u001a\u0004\b_\u0010]R\u0016\u0010a\u001a\u00020`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010bR\u0016\u0010d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010eR\u0014\u0010g\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010hR$\u0010i\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00028\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\bi\u0010[\u001a\u0004\bj\u0010]R\u0016\u0010k\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010[R\"\u0010l\u001a\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010D\"\u0004\bo\u0010pR\u0016\u0010q\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010[R\u0018\u0010s\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010u\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010mR\u001c\u0010w\u001a\b\u0012\u0004\u0012\u00020,0v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010NR\"\u0010y\u001a\u00020x8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001f\u0010\u0080\u0001\u001a\u00020\u007f8\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R1\u0010\u0089\u0001\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00028B@BX\u0082\u008e\u0002¢\u0006\u0017\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0005\b\u0086\u0001\u0010]\"\u0006\b\u0087\u0001\u0010\u0088\u0001R1\u0010\u008d\u0001\u001a\u00020\u00022\u0006\u0010L\u001a\u00020\u00028B@BX\u0082\u008e\u0002¢\u0006\u0017\n\u0006\b\u008a\u0001\u0010\u0085\u0001\u001a\u0005\b\u008b\u0001\u0010]\"\u0006\b\u008c\u0001\u0010\u0088\u0001R\u001f\u0010\u0091\u0001\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0005\b\u0090\u0001\u0010]R\u001e\u0010\u0013\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\u000f\n\u0006\b\u0092\u0001\u0010\u008f\u0001\u001a\u0005\b\u0093\u0001\u0010]R \u0010\u0095\u0001\u001a\u00030\u0094\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R \u0010\u009a\u0001\u001a\u00030\u0099\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u009a\u0001\u0010\u009b\u0001\u001a\u0006\b\u009c\u0001\u0010\u009d\u0001R \u0010\u009f\u0001\u001a\u00030\u009e\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u009f\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001R7\u0010©\u0001\u001a\u0005\u0018\u00010£\u00012\t\u0010L\u001a\u0005\u0018\u00010£\u00018@@BX\u0080\u008e\u0002¢\u0006\u0017\n\u0005\b¤\u0001\u0010N\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R \u0010«\u0001\u001a\u00030ª\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b«\u0001\u0010¬\u0001\u001a\u0006\b\u00ad\u0001\u0010®\u0001R-\u0010°\u0001\u001a\u00030¯\u00018\u0000@\u0000X\u0080\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0015\n\u0005\b°\u0001\u0010b\u001a\u0005\b±\u0001\u0010P\"\u0005\b²\u0001\u0010RR \u0010´\u0001\u001a\u00030³\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001R%\u0010¹\u0001\u001a\u00030¸\u00018\u0000X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000f\n\u0005\b¹\u0001\u0010N\u001a\u0006\bº\u0001\u0010»\u0001R%\u0010¼\u0001\u001a\u00030¸\u00018\u0000X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u000f\n\u0005\b¼\u0001\u0010N\u001a\u0006\b½\u0001\u0010»\u0001R/\u0010Á\u0001\u001a\u00020\u00172\u0006\u0010L\u001a\u00020\u00178F@BX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\b¾\u0001\u0010N\u001a\u0005\b¿\u0001\u0010D\"\u0005\bÀ\u0001\u0010pR/\u0010Å\u0001\u001a\u00020\u00172\u0006\u0010L\u001a\u00020\u00178F@BX\u0086\u008e\u0002¢\u0006\u0015\n\u0005\bÂ\u0001\u0010N\u001a\u0005\bÃ\u0001\u0010D\"\u0005\bÄ\u0001\u0010pR\u001c\u0010Æ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170v8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bÆ\u0001\u0010NR\u001c\u0010Ç\u0001\u001a\b\u0012\u0004\u0012\u00020\u00170v8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bÇ\u0001\u0010NR\u0016\u0010É\u0001\u001a\u00020\u00028&X¦\u0004¢\u0006\u0007\u001a\u0005\bÈ\u0001\u0010]R\u0016\u0010Ë\u0001\u001a\u00020\u00028@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÊ\u0001\u0010]R\u0014\u0010Î\u0001\u001a\u00020E8F¢\u0006\b\u001a\u0006\bÌ\u0001\u0010Í\u0001R\u0016\u0010Ð\u0001\u001a\u00020\u00028@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÏ\u0001\u0010]R\u0016\u0010Ò\u0001\u001a\u00020\u00028@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÑ\u0001\u0010]R\u0016\u0010Ô\u0001\u001a\u00020\u00028@X\u0080\u0004¢\u0006\u0007\u001a\u0005\bÓ\u0001\u0010]R\u0017\u0010×\u0001\u001a\u00020\u00048@X\u0080\u0004¢\u0006\b\u001a\u0006\bÕ\u0001\u0010Ö\u0001R\u0015\u0010Û\u0001\u001a\u00030Ø\u00018F¢\u0006\b\u001a\u0006\bÙ\u0001\u0010Ú\u0001R\u0012\u0010\u0003\u001a\u00020\u00028F¢\u0006\u0007\u001a\u0005\bÜ\u0001\u0010]R\u0013\u0010\u0005\u001a\u00020\u00048F¢\u0006\b\u001a\u0006\bÝ\u0001\u0010Ö\u0001R!\u0010ã\u0001\u001a\u00030Þ\u00018@X\u0080\u0084\u0002¢\u0006\u0010\u001a\u0006\bß\u0001\u0010à\u0001*\u0006\bá\u0001\u0010â\u0001R\u0016\u0010ä\u0001\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bä\u0001\u0010DR\u0016\u0010æ\u0001\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bå\u0001\u0010DR\u0016\u0010è\u0001\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bç\u0001\u0010D\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006é\u0001"}, d2 = {"Landroidx/compose/foundation/pager/PagerState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "", "currentPage", "", "currentPageOffsetFraction", "Landroidx/compose/foundation/lazy/layout/PrefetchScheduler;", "prefetchScheduler", AppAgent.CONSTRUCT, "(IFLandroidx/compose/foundation/lazy/layout/PrefetchScheduler;)V", "(IF)V", "page", "pageOffsetFraction", "LC7/r;", "scrollToPage", "(IFLH7/c;)Ljava/lang/Object;", "Landroidx/compose/foundation/gestures/ScrollScope;", "updateCurrentPage", "(Landroidx/compose/foundation/gestures/ScrollScope;IF)V", "targetPage", "updateTargetPage", "(Landroidx/compose/foundation/gestures/ScrollScope;I)V", "offsetFraction", "", "forceRemeasure", "snapToItem$foundation_release", "(IFZ)V", "snapToItem", "requestScrollToPage", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "animateScrollToPage", "(IFLandroidx/compose/animation/core/AnimationSpec;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/foundation/MutatePriority;", "scrollPriority", "Lkotlin/Function2;", "LH7/c;", "", "block", "scroll", "(Landroidx/compose/foundation/MutatePriority;LS7/n;LH7/c;)Ljava/lang/Object;", "delta", "dispatchRawDelta", "(F)F", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "result", "visibleItemsStayedTheSame", "applyMeasureResult$foundation_release", "(Landroidx/compose/foundation/pager/PagerMeasureResult;Z)V", "applyMeasureResult", "getOffsetDistanceInPages", "(I)F", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "itemProvider", "matchScrollPositionWithKey$foundation_release", "(Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;I)I", "matchScrollPositionWithKey", "performScroll", "awaitScrollDependencies", "(LH7/c;)Ljava/lang/Object;", "tryRunPrefetch", "(Landroidx/compose/foundation/pager/PagerMeasureResult;)V", "coerceInPageRange", "(I)I", "scrollDelta", "isGestureActionMatchesScroll", "(F)Z", "isNotGestureAction", "()Z", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "info", "notifyPrefetch", "(FLandroidx/compose/foundation/pager/PagerLayoutInfo;)V", "cancelPrefetchIfVisibleItemsChanged", "(Landroidx/compose/foundation/pager/PagerLayoutInfo;)V", "Landroidx/compose/ui/geometry/Offset;", "<set-?>", "upDownDifference$delegate", "Landroidx/compose/runtime/MutableState;", "getUpDownDifference-F1C5BW0$foundation_release", "()J", "setUpDownDifference-k-4lQ0M$foundation_release", "(J)V", "upDownDifference", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "animatedScrollScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "Landroidx/compose/foundation/pager/PagerScrollPosition;", "scrollPosition", "Landroidx/compose/foundation/pager/PagerScrollPosition;", "firstVisiblePage", "I", "getFirstVisiblePage$foundation_release", "()I", "firstVisiblePageOffset", "getFirstVisiblePageOffset$foundation_release", "", "maxScrollOffset", "J", "minScrollOffset", "accumulator", "F", "previousPassDelta", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "layoutWithMeasurement", "getLayoutWithMeasurement$foundation_release", "layoutWithoutMeasurement", "prefetchingEnabled", "Z", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "(Z)V", "indexToPrefetch", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "wasPrefetchingForward", "Landroidx/compose/runtime/MutableState;", "pagerLayoutInfoState", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "programmaticScrollTargetPage$delegate", "Landroidx/compose/runtime/MutableIntState;", "getProgrammaticScrollTargetPage", "setProgrammaticScrollTargetPage", "(I)V", "programmaticScrollTargetPage", "settledPageState$delegate", "getSettledPageState", "setSettledPageState", "settledPageState", "settledPage$delegate", "Landroidx/compose/runtime/State;", "getSettledPage", "settledPage", "targetPage$delegate", "getTargetPage", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "getBeyondBoundsInfo$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutBeyondBoundsInfo;", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/layout/AwaitFirstLayoutModifier;", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement$delegate", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "setRemeasurement", "(Landroidx/compose/ui/layout/Remeasurement;)V", "remeasurement", "Landroidx/compose/ui/layout/RemeasurementModifier;", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "Landroidx/compose/ui/unit/Constraints;", "premeasureConstraints", "getPremeasureConstraints-msEJaDk$foundation_release", "setPremeasureConstraints-BRTryo0$foundation_release", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "pinnedPages", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "getPinnedPages$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "placementScopeInvalidator", "getPlacementScopeInvalidator-zYiylxw$foundation_release", "()Landroidx/compose/runtime/MutableState;", "measurementScopeInvalidator", "getMeasurementScopeInvalidator-zYiylxw$foundation_release", "canScrollForward$delegate", "getCanScrollForward", "setCanScrollForward", "canScrollForward", "canScrollBackward$delegate", "getCanScrollBackward", "setCanScrollBackward", "canScrollBackward", "isLastScrollForwardState", "isLastScrollBackwardState", "getPageCount", "pageCount", "getNumMeasurePasses$foundation_release", "numMeasurePasses", "getLayoutInfo", "()Landroidx/compose/foundation/pager/PagerLayoutInfo;", "layoutInfo", "getPageSpacing$foundation_release", "pageSpacing", "getPageSize$foundation_release", "pageSize", "getPageSizeWithSpacing$foundation_release", "pageSizeWithSpacing", "getPositionThresholdFraction$foundation_release", "()F", "positionThresholdFraction", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "interactionSource", "getCurrentPage", "getCurrentPageOffsetFraction", "LY7/f;", "getNearestRange$foundation_release", "()LY7/f;", "getNearestRange$foundation_release$delegate", "(Landroidx/compose/foundation/pager/PagerState;)Ljava/lang/Object;", "nearestRange", "isScrollInProgress", "getLastScrolledForward", "lastScrolledForward", "getLastScrolledBackward", "lastScrolledBackward", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PagerState implements ScrollableState {
    public static final int $stable = 0;
    private float accumulator;
    private final LazyLayoutAnimateScrollScope animatedScrollScope;
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;

    /* renamed from: canScrollBackward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollBackward;

    /* renamed from: canScrollForward$delegate, reason: from kotlin metadata */
    private final MutableState canScrollForward;
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    private Density density;
    private int firstVisiblePage;
    private int firstVisiblePageOffset;
    private int indexToPrefetch;
    private final MutableInteractionSource internalInteractionSource;
    private final MutableState<Boolean> isLastScrollBackwardState;
    private final MutableState<Boolean> isLastScrollForwardState;
    private int layoutWithMeasurement;
    private int layoutWithoutMeasurement;
    private long maxScrollOffset;
    private final MutableState<r> measurementScopeInvalidator;
    private long minScrollOffset;
    private MutableState<PagerMeasureResult> pagerLayoutInfoState;
    private final LazyLayoutPinnedItemList pinnedPages;
    private final MutableState<r> placementScopeInvalidator;
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    private long premeasureConstraints;
    private float previousPassDelta;

    /* renamed from: programmaticScrollTargetPage$delegate, reason: from kotlin metadata */
    private final MutableIntState programmaticScrollTargetPage;

    /* renamed from: remeasurement$delegate, reason: from kotlin metadata */
    private final MutableState remeasurement;
    private final RemeasurementModifier remeasurementModifier;
    private final PagerScrollPosition scrollPosition;
    private final ScrollableState scrollableState;

    /* renamed from: settledPage$delegate, reason: from kotlin metadata */
    private final State settledPage;

    /* renamed from: settledPageState$delegate, reason: from kotlin metadata */
    private final MutableIntState settledPageState;

    /* renamed from: targetPage$delegate, reason: from kotlin metadata */
    private final State targetPage;

    /* renamed from: upDownDifference$delegate, reason: from kotlin metadata */
    private final MutableState upDownDifference;
    private boolean wasPrefetchingForward;

    @c(c = "androidx.compose.foundation.pager.PagerState", f = "PagerState.kt", l = {TypedValues.MotionType.TYPE_ANIMATE_RELATIVE_TO, 613}, m = "animateScrollToPage")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.pager.PagerState$animateScrollToPage$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PagerState.this.animateScrollToPage(0, 0.0f, null, this);
        }
    }

    @c(c = "androidx.compose.foundation.pager.PagerState$requestScrollToPage$1", f = "PagerState.kt", l = {576}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.pager.PagerState$requestScrollToPage$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04801 extends SuspendLambda implements n {
        int label;

        public C04801(H7.c<? super C04801> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return PagerState.this.new C04801(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                PagerState pagerState = PagerState.this;
                this.label = 1;
                if (ScrollExtensionsKt.stopScroll$default(pagerState, null, this, 1, null) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C04801) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "androidx.compose.foundation.pager.PagerState", f = "PagerState.kt", l = {629, 634}, m = "scroll$suspendImpl")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.pager.PagerState$scroll$1, reason: invalid class name and case insensitive filesystem */
    public static final class C04811 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C04811(H7.c<? super C04811> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PagerState.scroll$suspendImpl(PagerState.this, null, null, this);
        }
    }

    @c(c = "androidx.compose.foundation.pager.PagerState$scrollToPage$2", f = "PagerState.kt", l = {498}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/ScrollScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.pager.PagerState$scrollToPage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ int $page;
        final /* synthetic */ float $pageOffsetFraction;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(float f, int i, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$pageOffsetFraction = f;
            this.$page = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return PagerState.this.new AnonymousClass2(this.$pageOffsetFraction, this.$page, cVar);
        }

        @Override // S7.n
        public final Object invoke(ScrollScope scrollScope, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(scrollScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                PagerState pagerState = PagerState.this;
                this.label = 1;
                if (pagerState.awaitScrollDependencies(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            float f = this.$pageOffsetFraction;
            double d = f;
            boolean z10 = false;
            if (-0.5d <= d && d <= 0.5d) {
                z10 = true;
            }
            if (!z10) {
                throw new IllegalArgumentException(a.l("pageOffsetFraction ", " is not within the range -0.5 to 0.5", f).toString());
            }
            PagerState.this.snapToItem$foundation_release(PagerState.this.coerceInPageRange(this.$page), this.$pageOffsetFraction, true);
            return r.f317a;
        }
    }

    public PagerState() {
        this(0, 0.0f, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateScrollToPage$default(PagerState pagerState, int i, float f, AnimationSpec animationSpec, H7.c cVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateScrollToPage");
        }
        if ((i6 & 2) != 0) {
            f = 0.0f;
        }
        if ((i6 & 4) != 0) {
            animationSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
        }
        return pagerState.animateScrollToPage(i, f, animationSpec, cVar);
    }

    public static /* synthetic */ void applyMeasureResult$foundation_release$default(PagerState pagerState, PagerMeasureResult pagerMeasureResult, boolean z10, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyMeasureResult");
        }
        if ((i & 2) != 0) {
            z10 = false;
        }
        pagerState.applyMeasureResult$foundation_release(pagerMeasureResult, z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitScrollDependencies(H7.c<? super r> cVar) {
        Object objWaitForFirstLayout = this.awaitLayoutModifier.waitForFirstLayout(cVar);
        return objWaitForFirstLayout == CoroutineSingletons.f4909a ? objWaitForFirstLayout : r.f317a;
    }

    private final void cancelPrefetchIfVisibleItemsChanged(PagerLayoutInfo info) {
        int index;
        if (this.indexToPrefetch == -1 || info.getVisiblePagesInfo().isEmpty()) {
            return;
        }
        if (this.wasPrefetchingForward) {
            index = info.getBeyondViewportPageCount() + ((PageInfo) v.K0(info.getVisiblePagesInfo())).getIndex() + 1;
        } else {
            index = (((PageInfo) v.A0(info.getVisiblePagesInfo())).getIndex() - info.getBeyondViewportPageCount()) - 1;
        }
        if (this.indexToPrefetch != index) {
            this.indexToPrefetch = -1;
            LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = this.currentPrefetchHandle;
            if (prefetchHandle != null) {
                prefetchHandle.cancel();
            }
            this.currentPrefetchHandle = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int coerceInPageRange(int i) {
        if (getPageCount() > 0) {
            return AbstractC1451a.u(i, 0, getPageCount() - 1);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getProgrammaticScrollTargetPage() {
        return this.programmaticScrollTargetPage.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSettledPageState() {
        return this.settledPageState.getIntValue();
    }

    private final boolean isGestureActionMatchesScroll(float scrollDelta) {
        if (getLayoutInfo().getOrientation() == Orientation.Vertical) {
            if (Math.signum(scrollDelta) == Math.signum(-Offset.m3896getYimpl(m950getUpDownDifferenceF1C5BW0$foundation_release()))) {
                return true;
            }
        } else if (Math.signum(scrollDelta) == Math.signum(-Offset.m3895getXimpl(m950getUpDownDifferenceF1C5BW0$foundation_release()))) {
            return true;
        }
        return isNotGestureAction();
    }

    private final boolean isNotGestureAction() {
        return ((int) Offset.m3895getXimpl(m950getUpDownDifferenceF1C5BW0$foundation_release())) == 0 && ((int) Offset.m3896getYimpl(m950getUpDownDifferenceF1C5BW0$foundation_release())) == 0;
    }

    public static /* synthetic */ int matchScrollPositionWithKey$foundation_release$default(PagerState pagerState, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: matchScrollPositionWithKey");
        }
        if ((i6 & 2) != 0) {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            k readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                int currentPage = pagerState.scrollPosition.getCurrentPage();
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                i = currentPage;
            } catch (Throwable th) {
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                throw th;
            }
        }
        return pagerState.matchScrollPositionWithKey$foundation_release(pagerLazyLayoutItemProvider, i);
    }

    private final void notifyPrefetch(float delta, PagerLayoutInfo info) {
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle2;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle3;
        if (this.prefetchingEnabled && !info.getVisiblePagesInfo().isEmpty()) {
            boolean z10 = delta > 0.0f;
            int beyondViewportPageCount = z10 ? info.getBeyondViewportPageCount() + ((PageInfo) v.K0(info.getVisiblePagesInfo())).getIndex() + 1 : (((PageInfo) v.A0(info.getVisiblePagesInfo())).getIndex() - info.getBeyondViewportPageCount()) - 1;
            if (beyondViewportPageCount < 0 || beyondViewportPageCount >= getPageCount()) {
                return;
            }
            if (beyondViewportPageCount != this.indexToPrefetch) {
                if (this.wasPrefetchingForward != z10 && (prefetchHandle3 = this.currentPrefetchHandle) != null) {
                    prefetchHandle3.cancel();
                }
                this.wasPrefetchingForward = z10;
                this.indexToPrefetch = beyondViewportPageCount;
                this.currentPrefetchHandle = this.prefetchState.m874schedulePrefetch0kLqBqw(beyondViewportPageCount, this.premeasureConstraints);
            }
            if (z10) {
                if ((((PageInfo) v.K0(info.getVisiblePagesInfo())).getOffset() + (info.getPageSpacing() + info.getPageSize())) - info.getViewportEndOffset() >= delta || (prefetchHandle2 = this.currentPrefetchHandle) == null) {
                    return;
                }
                prefetchHandle2.markAsUrgent();
                return;
            }
            if (info.getViewportStartOffset() - ((PageInfo) v.A0(info.getVisiblePagesInfo())).getOffset() >= (-delta) || (prefetchHandle = this.currentPrefetchHandle) == null) {
                return;
            }
            prefetchHandle.markAsUrgent();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float performScroll(float delta) {
        long jCurrentAbsoluteScrollOffset = PagerScrollPositionKt.currentAbsoluteScrollOffset(this);
        float f = this.accumulator + delta;
        long jV = U7.a.V(f);
        this.accumulator = f - jV;
        if (Math.abs(delta) < 1.0E-4f) {
            return delta;
        }
        long j5 = jCurrentAbsoluteScrollOffset + jV;
        long jV2 = AbstractC1451a.v(j5, this.minScrollOffset, this.maxScrollOffset);
        boolean z10 = j5 != jV2;
        long j6 = jV2 - jCurrentAbsoluteScrollOffset;
        float f7 = j6;
        this.previousPassDelta = f7;
        if (Math.abs(j6) != 0) {
            this.isLastScrollForwardState.setValue(Boolean.valueOf(f7 > 0.0f));
            this.isLastScrollBackwardState.setValue(Boolean.valueOf(f7 < 0.0f));
        }
        PagerMeasureResult value = this.pagerLayoutInfoState.getValue();
        int i = (int) j6;
        if (value.tryToApplyScrollWithoutRemeasure(-i)) {
            applyMeasureResult$foundation_release(value, true);
            ObservableScopeInvalidator.m883invalidateScopeimpl(this.placementScopeInvalidator);
            this.layoutWithoutMeasurement++;
        } else {
            this.scrollPosition.applyScrollDelta(i);
            Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
            if (remeasurement$foundation_release != null) {
                remeasurement$foundation_release.forceRemeasure();
            }
            this.layoutWithMeasurement++;
        }
        return (z10 ? Long.valueOf(j6) : Float.valueOf(delta)).floatValue();
    }

    public static /* synthetic */ void requestScrollToPage$default(PagerState pagerState, int i, float f, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestScrollToPage");
        }
        if ((i6 & 2) != 0) {
            f = 0.0f;
        }
        pagerState.requestScrollToPage(i, f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0076, code lost:
    
        if (r8.scroll(r6, r7, r0) == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object scroll$suspendImpl(androidx.compose.foundation.pager.PagerState r5, androidx.compose.foundation.MutatePriority r6, S7.n r7, H7.c<? super C7.r> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.pager.PagerState.C04811
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.pager.PagerState$scroll$1 r0 = (androidx.compose.foundation.pager.PagerState.C04811) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.pager.PagerState$scroll$1 r0 = new androidx.compose.foundation.pager.PagerState$scroll$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L48
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.pager.PagerState r5 = (androidx.compose.foundation.pager.PagerState) r5
            kotlin.b.b(r8)
            goto L79
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            java.lang.Object r5 = r0.L$2
            r7 = r5
            S7.n r7 = (S7.n) r7
            java.lang.Object r5 = r0.L$1
            r6 = r5
            androidx.compose.foundation.MutatePriority r6 = (androidx.compose.foundation.MutatePriority) r6
            java.lang.Object r5 = r0.L$0
            androidx.compose.foundation.pager.PagerState r5 = (androidx.compose.foundation.pager.PagerState) r5
            kotlin.b.b(r8)
            goto L5a
        L48:
            kotlin.b.b(r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r8 = r5.awaitScrollDependencies(r0)
            if (r8 != r1) goto L5a
            goto L78
        L5a:
            boolean r8 = r5.isScrollInProgress()
            if (r8 != 0) goto L67
            int r8 = r5.getCurrentPage()
            r5.setSettledPageState(r8)
        L67:
            androidx.compose.foundation.gestures.ScrollableState r8 = r5.scrollableState
            r0.L$0 = r5
            r2 = 0
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r6 = r8.scroll(r6, r7, r0)
            if (r6 != r1) goto L79
        L78:
            return r1
        L79:
            r6 = -1
            r5.setProgrammaticScrollTargetPage(r6)
            C7.r r5 = C7.r.f317a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.scroll$suspendImpl(androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.MutatePriority, S7.n, H7.c):java.lang.Object");
    }

    public static /* synthetic */ Object scrollToPage$default(PagerState pagerState, int i, float f, H7.c cVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToPage");
        }
        if ((i6 & 2) != 0) {
            f = 0.0f;
        }
        return pagerState.scrollToPage(i, f, cVar);
    }

    private final void setCanScrollBackward(boolean z10) {
        this.canScrollBackward.setValue(Boolean.valueOf(z10));
    }

    private final void setCanScrollForward(boolean z10) {
        this.canScrollForward.setValue(Boolean.valueOf(z10));
    }

    private final void setProgrammaticScrollTargetPage(int i) {
        this.programmaticScrollTargetPage.setIntValue(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRemeasurement(Remeasurement remeasurement) {
        this.remeasurement.setValue(remeasurement);
    }

    private final void setSettledPageState(int i) {
        this.settledPageState.setIntValue(i);
    }

    private final void tryRunPrefetch(PagerMeasureResult result) {
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        k readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (Math.abs(this.previousPassDelta) > 0.5f && this.prefetchingEnabled && isGestureActionMatchesScroll(this.previousPassDelta)) {
                notifyPrefetch(this.previousPassDelta, result);
            }
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    public static /* synthetic */ void updateCurrentPage$default(PagerState pagerState, ScrollScope scrollScope, int i, float f, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateCurrentPage");
        }
        if ((i6 & 2) != 0) {
            f = 0.0f;
        }
        pagerState.updateCurrentPage(scrollScope, i, f);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateScrollToPage(int r11, @androidx.annotation.FloatRange(from = -0.5d, to = 0.5d) float r12, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r13, H7.c<? super C7.r> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof androidx.compose.foundation.pager.PagerState.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r14
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$1 r0 = (androidx.compose.foundation.pager.PagerState.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$1 r0 = new androidx.compose.foundation.pager.PagerState$animateScrollToPage$1
            r0.<init>(r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r6.label
            C7.r r7 = C7.r.f317a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L49
            if (r1 == r3) goto L37
            if (r1 != r2) goto L2f
            kotlin.b.b(r14)
            goto La1
        L2f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L37:
            float r12 = r6.F$0
            int r11 = r6.I$0
            java.lang.Object r10 = r6.L$1
            r13 = r10
            androidx.compose.animation.core.AnimationSpec r13 = (androidx.compose.animation.core.AnimationSpec) r13
            java.lang.Object r10 = r6.L$0
            androidx.compose.foundation.pager.PagerState r10 = (androidx.compose.foundation.pager.PagerState) r10
            kotlin.b.b(r14)
        L47:
            r4 = r13
            goto L73
        L49:
            kotlin.b.b(r14)
            int r14 = r10.getCurrentPage()
            if (r11 != r14) goto L5b
            float r14 = r10.getCurrentPageOffsetFraction()
            int r14 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r14 != 0) goto L5b
            goto L61
        L5b:
            int r14 = r10.getPageCount()
            if (r14 != 0) goto L62
        L61:
            return r7
        L62:
            r6.L$0 = r10
            r6.L$1 = r13
            r6.I$0 = r11
            r6.F$0 = r12
            r6.label = r3
            java.lang.Object r14 = r10.awaitScrollDependencies(r6)
            if (r14 != r0) goto L47
            goto La0
        L73:
            double r13 = (double) r12
            r8 = -4620693217682128896(0xbfe0000000000000, double:-0.5)
            int r1 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r1 > 0) goto La2
            r8 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r13 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r13 > 0) goto La2
            int r11 = r10.coerceInPageRange(r11)
            int r13 = r10.getPageSizeWithSpacing$foundation_release()
            float r13 = (float) r13
            float r3 = r12 * r13
            androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r1 = r10.animatedScrollScope
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$3 r5 = new androidx.compose.foundation.pager.PagerState$animateScrollToPage$3
            r5.<init>()
            r10 = 0
            r6.L$0 = r10
            r6.L$1 = r10
            r6.label = r2
            r2 = r11
            java.lang.Object r10 = androidx.compose.foundation.pager.PagerStateKt.access$animateScrollToPage(r1, r2, r3, r4, r5, r6)
            if (r10 != r0) goto La1
        La0:
            return r0
        La1:
            return r7
        La2:
            java.lang.String r10 = "pageOffsetFraction "
            java.lang.String r11 = " is not within the range -0.5 to 0.5"
            java.lang.String r10 = B7.a.l(r10, r11, r12)
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r10 = r10.toString()
            r11.<init>(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.animateScrollToPage(int, float, androidx.compose.animation.core.AnimationSpec, H7.c):java.lang.Object");
    }

    public final void applyMeasureResult$foundation_release(PagerMeasureResult result, boolean visibleItemsStayedTheSame) {
        if (visibleItemsStayedTheSame) {
            this.scrollPosition.updateCurrentPageOffsetFraction(result.getCurrentPageOffsetFraction());
        } else {
            this.scrollPosition.updateFromMeasureResult(result);
            cancelPrefetchIfVisibleItemsChanged(result);
        }
        this.pagerLayoutInfoState.setValue(result);
        setCanScrollForward(result.getCanScrollForward());
        setCanScrollBackward(result.getCanScrollBackward());
        MeasuredPage firstVisiblePage = result.getFirstVisiblePage();
        if (firstVisiblePage != null) {
            this.firstVisiblePage = firstVisiblePage.getIndex();
        }
        this.firstVisiblePageOffset = result.getFirstVisiblePageScrollOffset();
        tryRunPrefetch(result);
        this.maxScrollOffset = PagerStateKt.calculateNewMaxScrollOffset(result, getPageCount());
        this.minScrollOffset = PagerStateKt.calculateNewMinScrollOffset(result, getPageCount());
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float delta) {
        return this.scrollableState.dispatchRawDelta(delta);
    }

    /* renamed from: getAwaitLayoutModifier$foundation_release, reason: from getter */
    public final AwaitFirstLayoutModifier getAwaitLayoutModifier() {
        return this.awaitLayoutModifier;
    }

    /* renamed from: getBeyondBoundsInfo$foundation_release, reason: from getter */
    public final LazyLayoutBeyondBoundsInfo getBeyondBoundsInfo() {
        return this.beyondBoundsInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward.getValue()).booleanValue();
    }

    public final int getCurrentPage() {
        return this.scrollPosition.getCurrentPage();
    }

    public final float getCurrentPageOffsetFraction() {
        return this.scrollPosition.getCurrentPageOffsetFraction();
    }

    /* renamed from: getDensity$foundation_release, reason: from getter */
    public final Density getDensity() {
        return this.density;
    }

    /* renamed from: getFirstVisiblePage$foundation_release, reason: from getter */
    public final int getFirstVisiblePage() {
        return this.firstVisiblePage;
    }

    /* renamed from: getFirstVisiblePageOffset$foundation_release, reason: from getter */
    public final int getFirstVisiblePageOffset() {
        return this.firstVisiblePageOffset;
    }

    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    /* renamed from: getInternalInteractionSource$foundation_release, reason: from getter */
    public final MutableInteractionSource getInternalInteractionSource() {
        return this.internalInteractionSource;
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

    /* renamed from: getLayoutWithMeasurement$foundation_release, reason: from getter */
    public final int getLayoutWithMeasurement() {
        return this.layoutWithMeasurement;
    }

    /* renamed from: getMeasurementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<r> m947getMeasurementScopeInvalidatorzYiylxw$foundation_release() {
        return this.measurementScopeInvalidator;
    }

    public final f getNearestRange$foundation_release() {
        return this.scrollPosition.getNearestRangeState().getValue();
    }

    public final int getNumMeasurePasses$foundation_release() {
        return this.layoutWithMeasurement + this.layoutWithoutMeasurement;
    }

    public final float getOffsetDistanceInPages(int page) {
        if (page >= 0 && page <= getPageCount()) {
            return (page - getCurrentPage()) - getCurrentPageOffsetFraction();
        }
        StringBuilder sbU = a.u(page, "page ", " is not within the range 0 to ");
        sbU.append(getPageCount());
        throw new IllegalArgumentException(sbU.toString().toString());
    }

    public abstract int getPageCount();

    public final int getPageSize$foundation_release() {
        return this.pagerLayoutInfoState.getValue().getPageSize();
    }

    public final int getPageSizeWithSpacing$foundation_release() {
        return getPageSpacing$foundation_release() + getPageSize$foundation_release();
    }

    public final int getPageSpacing$foundation_release() {
        return this.pagerLayoutInfoState.getValue().getPageSpacing();
    }

    /* renamed from: getPinnedPages$foundation_release, reason: from getter */
    public final LazyLayoutPinnedItemList getPinnedPages() {
        return this.pinnedPages;
    }

    /* renamed from: getPlacementScopeInvalidator-zYiylxw$foundation_release, reason: not valid java name */
    public final MutableState<r> m948getPlacementScopeInvalidatorzYiylxw$foundation_release() {
        return this.placementScopeInvalidator;
    }

    public final float getPositionThresholdFraction$foundation_release() {
        return Math.min(this.density.mo381toPx0680j_4(PagerStateKt.getDefaultPositionThreshold()), getPageSize$foundation_release() / 2.0f) / getPageSize$foundation_release();
    }

    /* renamed from: getPrefetchState$foundation_release, reason: from getter */
    public final LazyLayoutPrefetchState getPrefetchState() {
        return this.prefetchState;
    }

    /* renamed from: getPrefetchingEnabled$foundation_release, reason: from getter */
    public final boolean getPrefetchingEnabled() {
        return this.prefetchingEnabled;
    }

    /* renamed from: getPremeasureConstraints-msEJaDk$foundation_release, reason: not valid java name and from getter */
    public final long getPremeasureConstraints() {
        return this.premeasureConstraints;
    }

    public final Remeasurement getRemeasurement$foundation_release() {
        return (Remeasurement) this.remeasurement.getValue();
    }

    /* renamed from: getRemeasurementModifier$foundation_release, reason: from getter */
    public final RemeasurementModifier getRemeasurementModifier() {
        return this.remeasurementModifier;
    }

    public final int getSettledPage() {
        return ((Number) this.settledPage.getValue()).intValue();
    }

    public final int getTargetPage() {
        return ((Number) this.targetPage.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getUpDownDifference-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m950getUpDownDifferenceF1C5BW0$foundation_release() {
        return ((Offset) this.upDownDifference.getValue()).m3905unboximpl();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public final int matchScrollPositionWithKey$foundation_release(PagerLazyLayoutItemProvider itemProvider, int currentPage) {
        return this.scrollPosition.matchPageWithKey(itemProvider, currentPage);
    }

    public final void requestScrollToPage(@IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int page, @FloatRange(from = -0.5d, to = 0.5d) float pageOffsetFraction) {
        if (isScrollInProgress()) {
            AbstractC1683A.n(this.pagerLayoutInfoState.getValue().getCoroutineScope(), null, new C04801(null), 3);
        }
        snapToItem$foundation_release(page, pageOffsetFraction, false);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object scroll(MutatePriority mutatePriority, n nVar, H7.c<? super r> cVar) {
        return scroll$suspendImpl(this, mutatePriority, nVar, cVar);
    }

    public final Object scrollToPage(int i, @FloatRange(from = -0.5d, to = 0.5d) float f, H7.c<? super r> cVar) {
        Object objScroll$default = ScrollableState.scroll$default(this, null, new AnonymousClass2(f, i, null), cVar, 1, null);
        return objScroll$default == CoroutineSingletons.f4909a ? objScroll$default : r.f317a;
    }

    public final void setDensity$foundation_release(Density density) {
        this.density = density;
    }

    public final void setPrefetchingEnabled$foundation_release(boolean z10) {
        this.prefetchingEnabled = z10;
    }

    /* renamed from: setPremeasureConstraints-BRTryo0$foundation_release, reason: not valid java name */
    public final void m951setPremeasureConstraintsBRTryo0$foundation_release(long j5) {
        this.premeasureConstraints = j5;
    }

    /* renamed from: setUpDownDifference-k-4lQ0M$foundation_release, reason: not valid java name */
    public final void m952setUpDownDifferencek4lQ0M$foundation_release(long j5) {
        this.upDownDifference.setValue(Offset.m3884boximpl(j5));
    }

    public final void snapToItem$foundation_release(int page, float offsetFraction, boolean forceRemeasure) {
        this.scrollPosition.requestPositionAndForgetLastKnownKey(page, offsetFraction);
        if (!forceRemeasure) {
            ObservableScopeInvalidator.m883invalidateScopeimpl(this.measurementScopeInvalidator);
            return;
        }
        Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
        if (remeasurement$foundation_release != null) {
            remeasurement$foundation_release.forceRemeasure();
        }
    }

    @ExperimentalFoundationApi
    public final void updateCurrentPage(ScrollScope scrollScope, int i, @FloatRange(from = -0.5d, to = 0.5d) float f) {
        snapToItem$foundation_release(i, f, true);
    }

    @ExperimentalFoundationApi
    public final void updateTargetPage(ScrollScope scrollScope, int i) {
        setProgrammaticScrollTargetPage(coerceInPageRange(i));
    }

    public PagerState(int i, @FloatRange(from = -0.5d, to = 0.5d) float f, PrefetchScheduler prefetchScheduler) {
        double d = f;
        if (-0.5d > d || d > 0.5d) {
            throw new IllegalArgumentException(a.l("currentPageOffsetFraction ", " is not within the range -0.5 to 0.5", f).toString());
        }
        this.upDownDifference = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m3884boximpl(Offset.INSTANCE.m3911getZeroF1C5BW0()), null, 2, null);
        this.animatedScrollScope = PagerLazyAnimateScrollScopeKt.PagerLazyAnimateScrollScope(this);
        PagerScrollPosition pagerScrollPosition = new PagerScrollPosition(i, f, this);
        this.scrollPosition = pagerScrollPosition;
        this.firstVisiblePage = i;
        this.maxScrollOffset = Long.MAX_VALUE;
        this.scrollableState = ScrollableStateKt.ScrollableState(new k() { // from class: androidx.compose.foundation.pager.PagerState$scrollableState$1
            {
                super(1);
            }

            public final Float invoke(float f7) {
                return Float.valueOf(this.this$0.performScroll(f7));
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).floatValue());
            }
        });
        this.prefetchingEnabled = true;
        this.indexToPrefetch = -1;
        this.pagerLayoutInfoState = SnapshotStateKt.mutableStateOf(PagerStateKt.getEmptyLayoutInfo(), SnapshotStateKt.neverEqualPolicy());
        this.density = PagerStateKt.UnitDensity;
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.programmaticScrollTargetPage = SnapshotIntStateKt.mutableIntStateOf(-1);
        this.settledPageState = SnapshotIntStateKt.mutableIntStateOf(i);
        this.settledPage = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new S7.a() { // from class: androidx.compose.foundation.pager.PagerState$settledPage$2
            {
                super(0);
            }

            @Override // S7.a
            public final Integer invoke() {
                return Integer.valueOf(this.this$0.isScrollInProgress() ? this.this$0.getSettledPageState() : this.this$0.getCurrentPage());
            }
        });
        this.targetPage = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new S7.a() { // from class: androidx.compose.foundation.pager.PagerState$targetPage$2
            {
                super(0);
            }

            @Override // S7.a
            public final Integer invoke() {
                return Integer.valueOf(this.this$0.coerceInPageRange(!this.this$0.isScrollInProgress() ? this.this$0.getCurrentPage() : this.this$0.getProgrammaticScrollTargetPage() != -1 ? this.this$0.getProgrammaticScrollTargetPage() : Math.abs(this.this$0.getCurrentPageOffsetFraction()) >= Math.abs(this.this$0.getPositionThresholdFraction$foundation_release()) ? this.this$0.getLastScrolledForward() ? this.this$0.getFirstVisiblePage() + 1 : this.this$0.getFirstVisiblePage() : this.this$0.getCurrentPage()));
            }
        });
        this.prefetchState = new LazyLayoutPrefetchState(prefetchScheduler, null, 2, null);
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.remeasurement = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.pager.PagerState$remeasurementModifier$1
            @Override // androidx.compose.ui.layout.RemeasurementModifier
            public void onRemeasurementAvailable(Remeasurement remeasurement) {
                this.this$0.setRemeasurement(remeasurement);
            }
        };
        this.premeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        this.pinnedPages = new LazyLayoutPinnedItemList();
        pagerScrollPosition.getNearestRangeState();
        this.placementScopeInvalidator = ObservableScopeInvalidator.m879constructorimpl$default(null, 1, null);
        this.measurementScopeInvalidator = ObservableScopeInvalidator.m879constructorimpl$default(null, 1, null);
        Boolean bool = Boolean.FALSE;
        this.canScrollForward = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.canScrollBackward = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isLastScrollForwardState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.isLastScrollBackwardState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
    }

    public /* synthetic */ PagerState(int i, float f, PrefetchScheduler prefetchScheduler, int i6, e eVar) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0.0f : f, (i6 & 4) != 0 ? null : prefetchScheduler);
    }

    public /* synthetic */ PagerState(int i, float f, int i6, e eVar) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0.0f : f);
    }

    public PagerState(int i, @FloatRange(from = -0.5d, to = 0.5d) float f) {
        this(i, f, null);
    }
}
