package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\\\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001ah\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001aT\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u001a`\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007\u001aQ\u0010\u0014\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u001626\u0010\u0017\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00150\u0018H\u0086\b\u001a5\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0016\"\b\b\u0000\u0010\u0002*\u00020\u001f2\u001d\u0010 \u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020!\u0012\u0004\u0012\u00020\u00150\u0012¢\u0006\u0002\b\"\u001a\u0093\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\u0006\u0010$\u001a\u0002H\u00022!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0,2#\b\u0002\u0010-\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0002\u0010/\u001a¡\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\u0006\u0010$\u001a\u0002H\u00022\f\u00100\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00162!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0,2#\b\u0002\u0010-\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00060\u0012H\u0007¢\u0006\u0002\u00101\u001a&\u00102\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00103\u001a\u0002H\u0002H\u0086@¢\u0006\u0002\u00104\u001aR\u00105\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u0002082\f\u00100\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u00109\u001a\u0002H\u00022\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*H\u0082@¢\u0006\u0002\u0010:\u001a6\u00105\u001a\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00103\u001a\u0002H\u00022\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001c0*H\u0086@¢\u0006\u0002\u0010<\u001aN\u0010=\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u00103\u001a\u0002H\u00022\u0006\u00106\u001a\u00020\u001c2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*2\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0,H\u0086@¢\u0006\u0002\u0010>\u001a^\u0010?\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00162\u0006\u0010@\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u001c2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(H\u0002¢\u0006\u0002\u0010A\u001a\u0014\u0010B\u001a\u00020\u001c*\u00020\u001c2\u0006\u0010C\u001a\u00020\u001cH\u0002\u001aF\u0010D\u001a\u00020\u0015\"\u0004\b\u0000\u0010E2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002HE0(2\"\u0010\u0017\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002HE\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150G\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u0018H\u0082@¢\u0006\u0002\u0010H\u001a\u0014\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020J\"\u0004\b\u0000\u0010\u0002H\u0002\u001aU\u0010W\u001a\u00020X\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010Y\u001a\u00020Z2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001c0*H\u0000\u001aM\u0010[\u001a\u00020\\\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u001c0\u00122\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0(H\u0002\u001a\u0017\u0010_\u001a\u00020\u00152\f\u0010`\u001a\b\u0012\u0004\u0012\u00020S0(H\u0082\b\"\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00060\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010K\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u001c0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u0010M\u001a\u00020NX\u0080\u0004¢\u0006\n\n\u0002\u0010Q\u001a\u0004\bO\u0010P\"\u000e\u0010R\u001a\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010T\u001a\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010U\u001a\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010V\u001a\u00020SX\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001c0,X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010^\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"anchoredDraggable", "Landroidx/compose/ui/Modifier;", ExifInterface.GPS_DIRECTION_TRUE, "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "reverseDirection", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "startDragImmediately", "AlwaysDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "forEach", "", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "", "position", "DraggableAnchors", "", "builder", "Landroidx/compose/foundation/gestures/DraggableAnchorsConfig;", "Lkotlin/ExtensionFunctionType;", "AnchoredDraggableState", "initialValue", "positionalThreshold", "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "confirmValueChange", "newValue", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "anchors", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/jvm/functions/Function1;)Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "snapTo", "targetValue", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "velocity", "anchoredDragScope", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "latestTarget", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;FLandroidx/compose/foundation/gestures/AnchoredDragScope;Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animationSpec", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToWithDecay", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Ljava/lang/Object;FLandroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "computeTarget", "currentOffset", "(Landroidx/compose/foundation/gestures/DraggableAnchors;FFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "coerceToTarget", PickerReporterConstants.KEY.TARGET, "restartable", "I", "inputs", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emptyDraggableAnchors", "Landroidx/compose/foundation/gestures/DefaultDraggableAnchors;", "GetOrNan", "", "AnchoredDraggableMinFlingVelocity", "Landroidx/compose/ui/unit/Dp;", "getAnchoredDraggableMinFlingVelocity", "()F", FaceService.girlLabel, "ConfigurationMovedToModifier", "", "SettleWithVelocityDeprecated", "StartDragImmediatelyDeprecated", "ConfirmValueChangeDeprecated", "anchoredDraggableFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "density", "Landroidx/compose/ui/unit/Density;", "AnchoredDraggableLayoutInfoProvider", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "NoOpDecayAnimationSpec", "DEBUG", "debugLog", "generateMsg", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AnchoredDraggableKt {
    private static final Function1<PointerInputChange, Boolean> AlwaysDrag = null;
    private static final float AnchoredDraggableMinFlingVelocity = 0.0f;
    private static final String ConfigurationMovedToModifier = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.";
    private static final String ConfirmValueChangeDeprecated = "confirmValueChange is deprecated without replacement. Rather than relying on a callback to veto state changes, the anchor set should not include disallowed anchors. See androidx.compose.foundation.samples.AnchoredDraggableDynamicAnchorsSample for an example of using dynamic anchors over confirmValueChange.";
    private static final boolean DEBUG = false;
    private static final Function1<Integer, Float> GetOrNan = null;
    private static final DecayAnimationSpec<Float> NoOpDecayAnimationSpec = null;
    private static final String SettleWithVelocityDeprecated = "settle does not accept a velocity anymore. Please use FlingBehavior#performFling instead. See AnchoredDraggableSample.kt for example usages.";
    private static final String StartDragImmediatelyDeprecated = "startDragImmediately has been removed without replacement. Modifier.anchoredDraggable sets startDragImmediately to true by default when animations are running.";

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestTarget"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$4", f = "AnchoredDraggable.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GS_AUDIOTRACK_POOL_SAMPLES_CHECK}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ AnchoredDraggableState<T> $this_animateTo;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        public AnonymousClass4(AnchoredDraggableState<T> r100, AnimationSpec<Float> r101, Continuation<? super AnonymousClass4> r102) {
            this.$this_animateTo = r100;
            this.$animationSpec = r101;
            super(4, r102);
        }

        public final Object invoke(AnchoredDragScope r100, DraggableAnchors<T> r101, T r102, Continuation<? super Unit> r103) {
            AnonymousClass4 r104 = new AnonymousClass4(this.$this_animateTo, this.$animationSpec, r103);
            r104.L$0 = r100;
            r104.L$1 = r101;
            r104.L$2 = r102;
            return r104.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(AnchoredDragScope r100, Object r101, Object r102, Continuation<? super Unit> r103) {
            return invoke(r100, (DraggableAnchors) r101, r102, r103);
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
            AnchoredDragScope r102 = (AnchoredDragScope) this.L$0;
            DraggableAnchors r103 = (DraggableAnchors) this.L$1;
            Object r104 = this.L$2;
            AnchoredDraggableState<T> r105 = this.$this_animateTo;
            float r106 = r105.getLastVelocity();
            AnimationSpec<Float> r107 = this.$animationSpec;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 1;
            if (AnchoredDraggableKt.access$animateTo(r105, r106, r102, r103, r104, r107, this) != r100) goto L12;
            return r100;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt", f = "AnchoredDraggable.kt", i = {0, 0}, l = {1397}, m = "animateToWithDecay", n = {"remainingVelocity", "velocity"}, s = {"L$0", "F$0"})
    public static final class C85621<T> extends ContinuationImpl {
        float F$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C85621(Continuation<? super C85621> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return AnchoredDraggableKt.animateToWithDecay(null, null, 0.0f, null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestTarget"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2", f = "AnchoredDraggable.kt", i = {}, l = {SpeechEngineDefines.MESSAGE_TYPE_TTS_LENGTH_PREDICATED, 1426, 1450}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        final /* synthetic */ DecayAnimationSpec<Float> $decayAnimationSpec;
        final /* synthetic */ Ref.FloatRef $remainingVelocity;
        final /* synthetic */ AnimationSpec<Float> $snapAnimationSpec;
        final /* synthetic */ AnchoredDraggableState<T> $this_animateToWithDecay;
        final /* synthetic */ float $velocity;
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        public AnonymousClass2(AnchoredDraggableState<T> r100, float r101, AnimationSpec<Float> r102, Ref.FloatRef r103, DecayAnimationSpec<Float> r104, Continuation<? super AnonymousClass2> r105) {
            this.$this_animateToWithDecay = r100;
            this.$velocity = r101;
            this.$snapAnimationSpec = r102;
            this.$remainingVelocity = r103;
            this.$decayAnimationSpec = r104;
            super(4, r105);
        }

        public static /* synthetic */ Unit a(float r100, Ref.FloatRef r101, AnchoredDragScope r102, Ref.FloatRef r103, AnimationScope r104) {
            return invokeSuspend$lambda$2(r100, r101, r102, r103, r104);
        }

        public final Object invoke(AnchoredDragScope r100, DraggableAnchors<T> r110, T r111, Continuation<? super Unit> r112) {
            AnonymousClass2 r101 = new AnonymousClass2(this.$this_animateToWithDecay, this.$velocity, this.$snapAnimationSpec, this.$remainingVelocity, this.$decayAnimationSpec, r112);
            r101.L$0 = r100;
            r101.L$1 = r110;
            r101.L$2 = r111;
            return r101.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(AnchoredDragScope r100, Object r101, Object r102, Continuation<? super Unit> r103) {
            return invoke(r100, (DraggableAnchors) r101, r102, r103);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            boolean r102 = true;
            if (r101 == 0) goto L12;
            if (r101 == 1) goto L11;
            if (r101 == 2) goto L10;
            if (r101 != 3) goto L9;
            ResultKt.throwOnFailure(r210);
        L47:
            this.$remainingVelocity.element = 0.0f;
        L53:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r210);
            goto L53
        L11:
            ResultKt.throwOnFailure(r210);
        L51:
            this.$remainingVelocity.element = 0.0f;
            goto L53
        L12:
            ResultKt.throwOnFailure(r210);
            final AnchoredDragScope r103 = (AnchoredDragScope) this.L$0;
            DraggableAnchors r104 = (DraggableAnchors) this.L$1;
            Object r105 = this.L$2;
            final float r106 = r104.positionOf(r105);
            if (Float.isNaN(r106) == true) goto L53;
            final Ref.FloatRef r110 = new Ref.FloatRef();
            if (Float.isNaN(this.$this_animateToWithDecay.getOffset()) == false) goto L17;
            float r111 = 0.0f;
        L18:
            r110.element = r111;
            if (r111 != r106) goto L21;
            boolean r112 = true;
        L22:
            if (r112 == true) goto L53;
            float r113 = this.$velocity;
            if (((r106 - r111) * r113) >= 0.0f) goto L26;
        L48:
            AnchoredDraggableState<T> r107 = this.$this_animateToWithDecay;
            AnimationSpec<Float> r114 = this.$snapAnimationSpec;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 1;
            if (AnchoredDraggableKt.access$animateTo(r107, r113, r103, r104, r105, r114, this) != r100) goto L51;
            return r100;
        L26:
            if (r113 != 0.0f) goto L28;
            boolean r115 = true;
        L29:
            if (r115 == true) goto L48;
            float r116 = DecayAnimationSpecKt.calculateTargetValue(this.$decayAnimationSpec, r111, r113);
            float r117 = this.$velocity;
            if (r117 <= 0.0f) goto L37;
            if (r116 >= r106) goto L40;
        L39:
            r102 = false;
        L40:
            if (r102 == false) goto L44;
            AnimationState r108 = AnimationStateKt.AnimationState$default(r110.element, r117, 0, 0, false, 28, null);
            DecayAnimationSpec<Float> r109 = this.$decayAnimationSpec;
            final Ref.FloatRef r118 = this.$remainingVelocity;
            Function1 r119 = new h(r106, r110, r103, r118);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (SuspendAnimationKt.animateDecay$default(r108, r109, false, r119, this, 2, null) != r100) goto L53;
            return r100;
        L44:
            AnchoredDraggableState<T> r120 = this.$this_animateToWithDecay;
            AnimationSpec<Float> r121 = this.$snapAnimationSpec;
            this.L$0 = null;
            this.L$1 = null;
            this.label = 3;
            if (AnchoredDraggableKt.access$animateTo(r120, r117, r103, r104, r105, r121, this) != r100) goto L47;
            return r100;
        L37:
            if (r116 > r106) goto L39;
        L28:
            r115 = false;
            goto L29
        L21:
            r112 = false;
            goto L22
        L17:
            r111 = this.$this_animateToWithDecay.getOffset();
            goto L18
        }

        private static final Unit invokeSuspend$lambda$2(float r100, Ref.FloatRef r101, AnchoredDragScope r102, Ref.FloatRef r103, AnimationScope r104) {
            if (((Number) r104.getValue()).floatValue() >= r100) goto L7;
            if (r101.element <= r100) goto L7;
        L10:
            float r105 = AnchoredDraggableKt.access$coerceToTarget(((Number) r104.getValue()).floatValue(), r100);
            r102.dragTo(r105, ((Number) r104.getVelocity()).floatValue());
            if (Float.isNaN(((Number) r104.getVelocity()).floatValue()) == false) goto L13;
            float r106 = 0.0f;
        L14:
            r103.element = r106;
            r101.element = r105;
            r104.cancelAnimation();
        L17:
            return Unit.INSTANCE;
        L13:
            r106 = ((Number) r104.getVelocity()).floatValue();
        L7:
            if (((Number) r104.getValue()).floatValue() > r100) goto L9;
        L15:
            r102.dragTo(((Number) r104.getValue()).floatValue(), ((Number) r104.getVelocity()).floatValue());
            r103.element = ((Number) r104.getVelocity()).floatValue();
            r101.element = ((Number) r104.getValue()).floatValue();
            goto L17
        L9:
            if (r101.element >= r100) goto L15;
            goto L10
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt", f = "AnchoredDraggable.kt", i = {}, l = {1561}, m = "restartable", n = {}, s = {})
    public static final class C85631<I> extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C85631(Continuation<? super C85631> r100) {
            super(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return AnchoredDraggableKt.access$restartable(null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2", f = "AnchoredDraggable.kt", i = {}, l = {1563}, m = "invokeSuspend", n = {}, s = {})
    public static final class C85642 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Function0<I> $inputs;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ CoroutineScope $$this$coroutineScope;
            final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
            final /* synthetic */ Ref.ObjectRef<Job> $previousDrag;

            /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2, reason: invalid class name and collision with other inner class name */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2$1$2", f = "AnchoredDraggable.kt", i = {}, l = {1570}, m = "invokeSuspend", n = {}, s = {})
            public static final class C01092 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ CoroutineScope $$this$coroutineScope;
                final /* synthetic */ Function2<I, Continuation<? super Unit>, Object> $block;
                final /* synthetic */ I $latestInputs;
                int label;

                /* JADX WARN: Multi-variable type inference failed */
                public C01092(Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r100, I r101, CoroutineScope r102, Continuation<? super C01092> r103) {
                    this.$block = r100;
                    this.$latestInputs = r101;
                    this.$$this$coroutineScope = r102;
                    super(2, r103);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                    return new C01092(this.$block, this.$latestInputs, this.$$this$coroutineScope, r101);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return invoke2(r100, r101);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                    return ((C01092) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object r100) {
                    Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int r102 = this.label;
                    if (r102 == 0) goto L8;
                    if (r102 != 1) goto L7;
                    ResultKt.throwOnFailure(r100);
                L11:
                    CoroutineScopeKt.cancel(this.$$this$coroutineScope, new AnchoredDragFinishedSignal());
                    return Unit.INSTANCE;
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L8:
                    ResultKt.throwOnFailure(r100);
                    Function2<I, Continuation<? super Unit>, Object> r103 = this.$block;
                    I r104 = this.$latestInputs;
                    this.label = 1;
                    if (r103.invoke(r104, this) != r101) goto L11;
                    return r101;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Ref.ObjectRef<Job> r100, CoroutineScope r101, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r102) {
                this.$previousDrag = r100;
                this.$$this$coroutineScope = r101;
                this.$block = r102;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(I r100, Continuation<? super Unit> r101) {
                if ((r101 instanceof AnchoredDraggableKt$restartable$2$1$emit$1) == false) goto L7;
                AnchoredDraggableKt$restartable$2$1$emit$1 r102 = (AnchoredDraggableKt$restartable$2$1$emit$1) r101;
                int r103 = r102.label;
                if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
                r102.label = r103 - Integer.MIN_VALUE;
            L8:
                Object r104 = r102.result;
                Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r106 = r102.label;
                if (r106 == 0) goto L14;
                if (r106 != 1) goto L13;
                Job r107 = (Job) r102.L$1;
                Object r108 = r102.L$0;
                ResultKt.throwOnFailure(r104);
                Object r109 = r108;
            L19:
                Ref.ObjectRef<Job> r110 = this.$previousDrag;
                CoroutineScope r111 = this.$$this$coroutineScope;
                r110.element = (T) BuildersKt.launch$default(r111, null, CoroutineStart.UNDISPATCHED, new C01092(this.$block, r109, r111, null), 1, null);
                return Unit.INSTANCE;
            L13:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L14:
                ResultKt.throwOnFailure(r104);
                Job r112 = this.$previousDrag.element;
                r109 = r100;
                if (r112 == null) goto L19;
                r112.cancel(new AnchoredDragFinishedSignal());
                r102.L$0 = r100;
                r102.L$1 = r112;
                r102.label = 1;
                r109 = r100;
                if (r112.join(r102) != r105) goto L19;
                return r105;
            L7:
                r102 = new AnchoredDraggableKt$restartable$2$1$emit$1(this, r101);
                goto L8
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C85642(Function0<? extends I> r100, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super C85642> r102) {
            this.$inputs = r100;
            this.$block = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C85642 r102 = new C85642(this.$inputs, this.$block, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C85642) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            CoroutineScope r103 = (CoroutineScope) this.L$0;
            Ref.ObjectRef r104 = new Ref.ObjectRef();
            Flow r105 = SnapshotStateKt.snapshotFlow(this.$inputs);
            AnonymousClass1 r106 = new AnonymousClass1(r104, r103, this.$block);
            this.label = 1;
            if (r105.collect(r106, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableKt$snapTo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "latestTarget"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$snapTo$2", f = "AnchoredDraggable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C85652<T> extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        /* synthetic */ Object L$2;
        int label;

        public C85652(Continuation<? super C85652> r100) {
            super(4, r100);
        }

        public final Object invoke(AnchoredDragScope r100, DraggableAnchors<T> r101, T r102, Continuation<? super Unit> r103) {
            C85652 r104 = new C85652(r103);
            r104.L$0 = r100;
            r104.L$1 = r101;
            r104.L$2 = r102;
            return r104.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Object invoke(AnchoredDragScope r100, Object r101, Object r102, Continuation<? super Unit> r103) {
            return invoke(r100, (DraggableAnchors) r101, r102, r103);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r100);
            AnchoredDragScope r101 = (AnchoredDragScope) this.L$0;
            float r102 = ((DraggableAnchors) this.L$1).positionOf(this.L$2);
            if (Float.isNaN(r102) == true) goto L8;
            AnchoredDragScope.CC.dragTo$default(r101, r102, 0.0f, 2, null);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private static final boolean AlwaysDrag$lambda$0(PointerInputChange r100) {
        return true;
    }

    private static final boolean AnchoredDraggableState$lambda$2(Object r100) {
        return true;
    }

    private static final boolean AnchoredDraggableState$lambda$4(Object r100) {
        return true;
    }

    private static final float GetOrNan$lambda$10(int r100) {
        return Float.NaN;
    }

    public static /* synthetic */ boolean a(Object r100) {
        return AnchoredDraggableState$lambda$2(r100);
    }

    public static /* synthetic */ boolean b(PointerInputChange r100) {
        return AlwaysDrag$lambda$0(r100);
    }

    public static /* synthetic */ float c(int r100) {
        return GetOrNan$lambda$10(r100);
    }

    public static /* synthetic */ boolean d(Object r100) {
        return AnchoredDraggableState$lambda$4(r100);
    }

    private static final void debugLog(Function0<String> r100) {
    }

    public static /* synthetic */ Unit e(AnchoredDragScope r100, Ref.FloatRef r101, float r102, float r103) {
        return animateTo$lambda$8$lambda$7(r100, r101, r102, r103);
    }

    public static /* synthetic */ float f(Density r100) {
        return anchoredDraggableFlingBehavior$lambda$12(r100);
    }

    static {
        AlwaysDrag = new e();
        GetOrNan = new f();
        AnchoredDraggableMinFlingVelocity = Dp.m7544constructorimpl(125);
        NoOpDecayAnimationSpec = DecayAnimationSpecKt.generateDecayAnimationSpec(new AnchoredDraggableKt$NoOpDecayAnimationSpec$1());
    }

    private static final <T> DefaultDraggableAnchors<T> emptyDraggableAnchors() {
        return new DefaultDraggableAnchors(CollectionsKt.emptyList(), new float[0]);
    }

    public static final /* synthetic */ DefaultDraggableAnchors access$emptyDraggableAnchors() {
        return emptyDraggableAnchors();
    }

    public static final /* synthetic */ Function1 access$getAlwaysDrag$p() {
        return AlwaysDrag;
    }

    public static final /* synthetic */ Function1 access$getGetOrNan$p() {
        return GetOrNan;
    }

    public static final /* synthetic */ DecayAnimationSpec access$getNoOpDecayAnimationSpec$p() {
        return NoOpDecayAnimationSpec;
    }

    public static final float getAnchoredDraggableMinFlingVelocity() {
        return AnchoredDraggableMinFlingVelocity;
    }

    public static final <T> DraggableAnchors<T> DraggableAnchors(Function1<? super DraggableAnchorsConfig<T>, Unit> r100) {
        DraggableAnchorsConfig r101 = new DraggableAnchorsConfig();
        r100.invoke(r101);
        return new DefaultDraggableAnchors(r101.buildKeys$foundation_release(), r101.buildPositions$foundation_release());
    }

    private static final float anchoredDraggableFlingBehavior$lambda$12(Density r100) {
        return r100.mo371toPx0680j_4(Dp.m7544constructorimpl(125));
    }

    public static final /* synthetic */ float access$coerceToTarget(float r100, float r101) {
        return coerceToTarget(r100, r101);
    }

    private static final float coerceToTarget(float r100, float r101) {
        if (r101 != 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return 0.0f;
    L9:
        if (r101 <= 0.0f) goto L12;
        return RangesKt.coerceAtMost(r100, r101);
    L12:
        return RangesKt.coerceAtLeast(r100, r101);
    L5:
        r102 = false;
        goto L6
    }

    public static final <T> void forEach(DraggableAnchors<T> r100, Function2<? super T, ? super Float, Unit> r101) {
        int r102 = r100.getSize();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        T r104 = r100.anchorAt(r103);
        if (r104 == null) goto L8;
        r101.invoke(r104, Float.valueOf(r100.positionAt(r103)));
        r103 = r103 + 1;
        goto L3
    L8:
        throw new IllegalArgumentException(("There was no key at index " + r103 + ". Please report a bug.").toString());
    }

    private static final <T> SnapLayoutInfoProvider AnchoredDraggableLayoutInfoProvider(final AnchoredDraggableState<T> r100, final Function1<? super Float, Float> r101, final Function0<Float> r102) {
        return new AnonymousClass1(r100, r101, r102);
    }

    public static final /* synthetic */ Object access$restartable(Function0 r100, Function2 r101, Continuation r102) {
        return restartable(r100, r101, r102);
    }

    private static final <I> Object restartable(Function0<? extends I> r100, Function2<? super I, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof C85631) == false) goto L7;
        C85631 r103 = (C85631) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r105);     // Catch: AnchoredDragFinishedSignal -> L21
    L22:
        goto L20
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        C85642 r108 = new C85642(r100, r101, null);     // Catch: AnchoredDragFinishedSignal -> L21
        r103.label = 1;     // Catch: AnchoredDragFinishedSignal -> L21
        if (CoroutineScopeKt.coroutineScope(r108, r103) != r106) goto L22;
        return r106;
    L20:
        return Unit.INSTANCE;
    L7:
        r103 = new C85631(r102);
        goto L8
    }

    public static final <T> Object snapTo(AnchoredDraggableState<T> r100, T r101, Continuation<? super Unit> r102) {
        Object r103 = AnchoredDraggableState.anchoredDrag$default(r100, r101, null, new C85652(null), r102, 2, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public static final <T> TargetedFlingBehavior anchoredDraggableFlingBehavior(AnchoredDraggableState<T> r100, final Density r101, Function1<? super Float, Float> r102, AnimationSpec<Float> r103) {
        DecayAnimationSpec<Float> r104 = NoOpDecayAnimationSpec;
        return SnapFlingBehaviorKt.snapFlingBehavior(AnchoredDraggableLayoutInfoProvider(r100, r102, new d(r101)), r104, r103);
    }

    public static final <T> Object animateTo(AnchoredDraggableState<T> r100, T r101, AnimationSpec<Float> r102, Continuation<? super Unit> r110) {
        Object r103 = AnchoredDraggableState.anchoredDrag$default(r100, r101, null, new AnonymousClass4(r100, r102, null), r110, 2, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit animateTo$lambda$8$lambda$7(AnchoredDragScope r100, Ref.FloatRef r101, float r102, float r103) {
        r100.dragTo(r102, r103);
        r101.element = r102;
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ Object access$computeTarget(DraggableAnchors r100, float r101, float r102, Function1 r103, Function0 r104) {
        return computeTarget(r100, r101, r102, r103, r104);
    }

    private static final <T> T computeTarget(DraggableAnchors<T> r100, float r101, float r102, Function1<? super Float, Float> r103, Function0<Float> r104) {
        if ((!Float.isNaN(r101)) == false) goto L36;
        boolean r105 = false;
        if (Math.abs(r102) <= 0.0f) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L10;
    L12:
        boolean r107 = false;
    L13:
        if (r106 == true) goto L16;
        T r108 = r100.closestAnchor(r101);
        Intrinsics.checkNotNull(r108);
        return r108;
    L16:
        if (Math.abs(r102) < Math.abs(r104.invoke().floatValue())) goto L18;
        T r109 = r100.closestAnchor(r101, r107);
        Intrinsics.checkNotNull(r109);
        return r109;
    L18:
        T r110 = r100.closestAnchor(r101, false);
        Intrinsics.checkNotNull(r110);
        float r111 = r100.positionOf(r110);
        T r112 = r100.closestAnchor(r101, true);
        Intrinsics.checkNotNull(r112);
        float r113 = r100.positionOf(r112);
        float r114 = Math.abs(r103.invoke(Float.valueOf(Math.abs(r111 - r113))).floatValue());
        if (r107 == true) goto L23;
        r111 = r113;
    L23:
        if (Math.abs(r111 - r101) < r114) goto L25;
        r105 = true;
    L25:
        if (r105 != true) goto L28;
        if (r107 == true) goto L32;
    L39:
        return r110;
    L32:
        return r112;
    L28:
        if (r105 == true) goto L34;
        if (r107 == false) goto L32;
    L34:
        throw new NoWhenBranchMatchedException();
    L10:
        if (r102 <= 0.0f) goto L12;
        r107 = true;
        goto L13
    L7:
        r106 = false;
        goto L8
    L36:
        throw new IllegalArgumentException("The offset provided to computeTarget must not be NaN.".toString());
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = ConfigurationMovedToModifier)
    public static final <T> AnchoredDraggableState<T> AnchoredDraggableState(T r100, Function1<? super Float, Float> r101, Function0<Float> r102, AnimationSpec<Float> r103, DecayAnimationSpec<Float> r104, Function1<? super T, Boolean> r105) {
        AnchoredDraggableState<T> r106 = new AnchoredDraggableState(r100, r105);
        r106.setPositionalThreshold$foundation_release(r101);
        r106.setVelocityThreshold$foundation_release(r102);
        r106.setSnapAnimationSpec$foundation_release(r103);
        r106.setDecayAnimationSpec$foundation_release(r104);
        return r106;
    }

    public static /* synthetic */ Object animateTo$default(AnchoredDraggableState r100, Object r101, AnimationSpec r102, Continuation r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L9;
        if (r100.getUsePreModifierChangeBehavior$foundation_release() == false) goto L7;
        r102 = r100.getSnapAnimationSpec();
        goto L9
    L7:
        r102 = AnchoredDraggableDefaults.INSTANCE.getSnapAnimationSpec();
    L9:
        return animateTo(r100, r101, r102, r103);
    }

    public static final <T> Object animateToWithDecay(AnchoredDraggableState<T> r110, T r111, float r112, AnimationSpec<Float> r113, DecayAnimationSpec<Float> r210, Continuation<? super Float> r211) {
        if ((r211 instanceof C85621) == false) goto L7;
        C85621 r100 = (C85621) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        C85621 r114 = r100;
        Object r102 = r114.result;
        Object r115 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r114.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        float r104 = r114.F$0;
        Ref.FloatRef r105 = (Ref.FloatRef) r114.L$0;
        ResultKt.throwOnFailure(r102);
    L19:
        return Boxing.boxFloat(r104 - r105.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        Ref.FloatRef r116 = new Ref.FloatRef();
        r116.element = r112;
        AnonymousClass2 r117 = new AnonymousClass2(r110, r112, r113, r116, r210, null);
        r114.L$0 = r116;
        r114.F$0 = r112;
        r114.label = 1;
        if (AnchoredDraggableState.anchoredDrag$default(r110, r111, null, r117, r114, 2, null) != r115) goto L17;
        return r115;
    L17:
        r105 = r116;
        r104 = r112;
    L7:
        r100 = new C85621(r211);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = ConfigurationMovedToModifier)
    public static final <T> AnchoredDraggableState<T> AnchoredDraggableState(T r100, DraggableAnchors<T> r101, Function1<? super Float, Float> r102, Function0<Float> r103, AnimationSpec<Float> r104, DecayAnimationSpec<Float> r105, Function1<? super T, Boolean> r106) {
        AnchoredDraggableState<T> r107 = new AnchoredDraggableState(r100, r101, r106);
        r107.setPositionalThreshold$foundation_release(r102);
        r107.setVelocityThreshold$foundation_release(r103);
        r107.setSnapAnimationSpec$foundation_release(r104);
        r107.setDecayAnimationSpec$foundation_release(r105);
        return r107;
    }

    public static final /* synthetic */ Object access$animateTo(AnchoredDraggableState r100, float r101, AnchoredDragScope r102, DraggableAnchors r103, Object r104, AnimationSpec r105, Continuation r106) {
        return animateTo(r100, r101, r102, r103, r104, r105, r106);
    }

    public static final <T> Modifier anchoredDraggable(Modifier r110, AnchoredDraggableState<T> r111, Orientation r112, boolean r113, MutableInteractionSource r114, OverscrollEffect r115, FlingBehavior r116) {
        return r110.then(new AnchoredDraggableElement(r111, r112, r113, null, r114, null, r115, r116, 32, null));
    }

    private static final <T> Object animateTo(AnchoredDraggableState<T> r100, float r101, final AnchoredDragScope r102, DraggableAnchors<T> r103, T r110, AnimationSpec<Float> r111, Continuation<? super Unit> r112) {
        float r104 = r103.positionOf(r110);
        final Ref.FloatRef r105 = new Ref.FloatRef();
        if (Float.isNaN(r100.getOffset()) == false) goto L5;
        float r106 = 0.0f;
    L6:
        r105.element = r106;
        if (Float.isNaN(r104) == true) goto L17;
        float r107 = r105.element;
        if (r107 != r104) goto L11;
        boolean r108 = true;
    L12:
        if (r108 == true) goto L17;
        Object r109 = SuspendAnimationKt.animate(r107, r104, r101, r111, new b(r102, r105), r112);
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        return r109;
    L11:
        r108 = false;
    L17:
        return Unit.INSTANCE;
    L5:
        r106 = r100.getOffset();
        goto L6
    }

    public static /* synthetic */ AnchoredDraggableState AnchoredDraggableState$default(Object r100, Function1 r101, Function0 r102, AnimationSpec r103, DecayAnimationSpec r110, Function1 r111, int r112, Object r113) {
        if ((r112 & 32) == 0) goto L6;
        r111 = new g();
    L6:
        return AnchoredDraggableState(r100, r101, r102, r103, r110, r111);
    }

    public static final <T> Modifier anchoredDraggable(Modifier r110, AnchoredDraggableState<T> r111, boolean r112, Orientation r113, boolean r114, MutableInteractionSource r115, OverscrollEffect r116, FlingBehavior r117) {
        return r110.then(new AnchoredDraggableElement(r111, r113, r114, Boolean.valueOf(r112), r115, null, r116, r117, 32, null));
    }

    public static /* synthetic */ Object animateToWithDecay$default(AnchoredDraggableState r100, Object r101, float r102, AnimationSpec r103, DecayAnimationSpec r110, Continuation r111, int r112, Object r113) {
        if ((r112 & 4) != 0) goto L5;
    L8:
        AnimationSpec r104 = r103;
        if ((r112 & 8) == 0) goto L16;
        if (r100.getUsePreModifierChangeBehavior$foundation_release() == false) goto L13;
        DecayAnimationSpec<Float> r105 = r100.getDecayAnimationSpec();
    L14:
        r110 = r105;
        goto L16
    L13:
        r105 = AnchoredDraggableDefaults.INSTANCE.getDecayAnimationSpec();
    L16:
        return animateToWithDecay(r100, r101, r102, r104, r110, r111);
    L5:
        if (r100.getUsePreModifierChangeBehavior$foundation_release() == false) goto L7;
        r103 = r100.getSnapAnimationSpec();
        goto L8
    L7:
        r103 = AnchoredDraggableDefaults.INSTANCE.getSnapAnimationSpec();
        goto L8
    }

    @Deprecated(message = StartDragImmediatelyDeprecated)
    public static final <T> Modifier anchoredDraggable(Modifier r110, AnchoredDraggableState<T> r111, Orientation r112, boolean r113, MutableInteractionSource r114, OverscrollEffect r115, boolean r116, FlingBehavior r117) {
        return r110.then(new AnchoredDraggableElement(r111, r112, r113, null, r114, Boolean.valueOf(r116), r115, r117));
    }

    public static /* synthetic */ AnchoredDraggableState AnchoredDraggableState$default(Object r100, DraggableAnchors r101, Function1 r102, Function0 r110, AnimationSpec r111, DecayAnimationSpec r112, Function1 r113, int r114, Object r115) {
        if ((r114 & 64) == 0) goto L6;
        r113 = new c();
    L6:
        return AnchoredDraggableState(r100, r101, r102, r110, r111, r112, r113);
    }

    @Deprecated(message = StartDragImmediatelyDeprecated)
    public static final <T> Modifier anchoredDraggable(Modifier r110, AnchoredDraggableState<T> r111, boolean r112, Orientation r113, boolean r114, MutableInteractionSource r115, OverscrollEffect r116, boolean r117, FlingBehavior r118) {
        return r110.then(new AnchoredDraggableElement(r111, r113, r114, Boolean.valueOf(r112), r115, Boolean.valueOf(r117), r116, r118));
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier r100, AnchoredDraggableState r101, Orientation r102, boolean r110, MutableInteractionSource r111, OverscrollEffect r112, FlingBehavior r113, int r114, Object r115) {
        if ((r114 & 4) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r114 & 8) == 0) goto L9;
        MutableInteractionSource r104 = null;
    L11:
        if ((r114 & 16) == 0) goto L13;
        OverscrollEffect r105 = null;
    L15:
        if ((r114 & 32) == 0) goto L17;
        FlingBehavior r106 = null;
    L19:
        return anchoredDraggable(r100, r101, r102, r103, r104, r105, r106);
    L17:
        r106 = r113;
        goto L19
    L13:
        r105 = r112;
        goto L15
    L9:
        r104 = r111;
        goto L11
    L5:
        r103 = r110;
        goto L7
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier r100, AnchoredDraggableState r110, Orientation r111, boolean r112, MutableInteractionSource r113, OverscrollEffect r114, boolean r115, FlingBehavior r116, int r117, Object r118) {
        if ((r117 & 4) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r117 & 8) == 0) goto L9;
        MutableInteractionSource r102 = null;
    L11:
        if ((r117 & 16) == 0) goto L13;
        OverscrollEffect r103 = null;
    L15:
        if ((r117 & 32) == 0) goto L17;
        boolean r104 = r110.isAnimationRunning();
    L19:
        if ((r117 & 64) == 0) goto L21;
        FlingBehavior r105 = null;
    L23:
        return anchoredDraggable(r100, r110, r111, r101, r102, r103, r104, r105);
    L21:
        r105 = r116;
        goto L23
    L17:
        r104 = r115;
        goto L19
    L13:
        r103 = r114;
        goto L15
    L9:
        r102 = r113;
        goto L11
    L5:
        r101 = r112;
        goto L7
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier r100, AnchoredDraggableState r110, boolean r111, Orientation r112, boolean r113, MutableInteractionSource r114, OverscrollEffect r115, FlingBehavior r116, int r117, Object r118) {
        if ((r117 & 8) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r117 & 16) == 0) goto L9;
        MutableInteractionSource r102 = null;
    L11:
        if ((r117 & 32) == 0) goto L13;
        OverscrollEffect r103 = null;
    L15:
        if ((r117 & 64) == 0) goto L17;
        FlingBehavior r104 = null;
    L19:
        return anchoredDraggable(r100, r110, r111, r112, r101, r102, r103, r104);
    L17:
        r104 = r116;
        goto L19
    L13:
        r103 = r115;
        goto L15
    L9:
        r102 = r114;
        goto L11
    L5:
        r101 = r113;
        goto L7
    }

    public static /* synthetic */ Modifier anchoredDraggable$default(Modifier r110, AnchoredDraggableState r111, boolean r112, Orientation r113, boolean r114, MutableInteractionSource r115, OverscrollEffect r116, boolean r117, FlingBehavior r118, int r210, Object r211) {
        if ((r210 & 8) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r210 & 16) == 0) goto L9;
        MutableInteractionSource r101 = null;
    L11:
        if ((r210 & 32) == 0) goto L13;
        OverscrollEffect r102 = null;
    L15:
        if ((r210 & 64) == 0) goto L17;
        boolean r103 = r111.isAnimationRunning();
    L19:
        if ((r210 & 128) == 0) goto L21;
        FlingBehavior r119 = null;
    L23:
        return anchoredDraggable(r110, r111, r112, r113, r100, r101, r102, r103, r119);
    L21:
        r119 = r118;
        goto L23
    L17:
        r103 = r117;
        goto L19
    L13:
        r102 = r116;
        goto L15
    L9:
        r101 = r115;
        goto L11
    L5:
        r100 = r114;
        goto L7
    }
}
