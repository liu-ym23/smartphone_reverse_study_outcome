package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\b\u0086\u0001\u0087\u0001\u0088\u0001\u0089\u0001B1\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB#\b\u0011\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\nB\u001b\b\u0010\u0012\u0006\u0010\u000b\u001a\u00028\u0000\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\fB#\b\u0011\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\u000eJ\b\u0010T\u001a\u00020'H\u0002J\u001d\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020'2\u0006\u0010X\u001a\u00020YH\u0000¢\u0006\u0002\bZJ\u001d\u0010U\u001a\u00020V2\u0006\u0010[\u001a\u00020'2\u0006\u0010\\\u001a\u00020%H\u0000¢\u0006\u0002\bZJ\u0015\u0010]\u001a\u00020V2\u0006\u0010W\u001a\u00020'H\u0000¢\u0006\u0002\b^J\r\u0010_\u001a\u00020VH\u0000¢\u0006\u0002\b`J\r\u0010a\u001a\u00020VH\u0000¢\u0006\u0002\bbJ'\u0010c\u001a\u00020V2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u00100\u001a\u00020'H\u0007¢\u0006\u0004\bd\u0010eJ\u0019\u0010f\u001a\u00020%2\n\u0010g\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bhJ\u0019\u0010i\u001a\u00020%2\n\u0010g\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0000¢\u0006\u0002\bjJ'\u0010k\u001a\u00020%2\u0018\u0010l\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030>R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\bmJ'\u0010n\u001a\u00020V2\u0018\u0010l\u001a\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030>R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\boJ\u0017\u0010p\u001a\u00020V2\u0006\u0010\u0017\u001a\u00028\u0000H\u0000¢\u0006\u0004\bq\u0010\u001aJ\u0017\u0010r\u001a\u00020V2\u0006\u0010\u0017\u001a\u00028\u0000H\u0001¢\u0006\u0004\bs\u0010tJ\u0015\u0010u\u001a\u00020V2\u0006\u00100\u001a\u00020'H\u0000¢\u0006\u0002\bvJ\u0015\u0010w\u001a\u00020V2\u0006\u0010x\u001a\u00020yH\u0000¢\u0006\u0002\bzJ\u0015\u0010{\u001a\u00020V2\u0006\u0010|\u001a\u00020YH\u0000¢\u0006\u0002\b}J\r\u0010~\u001a\u00020VH\u0000¢\u0006\u0002\b\u007fJ\u000f\u0010\u0080\u0001\u001a\u00020VH\u0000¢\u0006\u0003\b\u0081\u0001J\t\u0010\u0082\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0083\u0001\u001a\u00020VH\u0002J)\u0010n\u001a\u00020V2\u001a\u0010\u0084\u0001\u001a\u0015\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0085\u0001R\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\boR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00008G¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R+\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00028\u00008F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u001aR7\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001c\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010$\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b$\u0010&R+\u0010(\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020'8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00100\u001a\u00020'2\u0006\u0010/\u001a\u00020'8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R+\u00103\u001a\u00020'2\u0006\u0010\u0016\u001a\u00020'8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010.\u001a\u0004\b4\u0010*\"\u0004\b5\u0010,R+\u00107\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020%8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b;\u0010\u001c\u001a\u0004\b8\u0010&\"\u0004\b9\u0010:R&\u0010<\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030>R\b\u0012\u0004\u0012\u00028\u00000\u00000=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010?\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000=X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010@\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000A8F¢\u0006\u0006\u001a\u0004\bB\u0010CR)\u0010D\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0002\b\u0003\u0012\u0002\b\u00030>R\b\u0012\u0004\u0012\u00028\u00000\u00000A8F¢\u0006\u0006\u001a\u0004\bE\u0010CR+\u0010F\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020%8G@AX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010\u001c\u001a\u0004\bF\u0010&\"\u0004\bG\u0010:R\u001a\u0010I\u001a\u00020'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010*\"\u0004\bK\u0010,R\u001a\u0010L\u001a\u00020%8FX\u0087\u0004¢\u0006\f\u0012\u0004\bM\u0010N\u001a\u0004\bO\u0010&R\u001b\u0010P\u001a\u00020'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bR\u0010S\u001a\u0004\bQ\u0010*¨\u0006\u008a\u0001²\u0006\u000b\u0010\u008b\u0001\u001a\u00020%X\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/animation/core/Transition;", ExifInterface.LATITUDE_SOUTH, "", "transitionState", "Landroidx/compose/animation/core/TransitionState;", "parentTransition", "label", "", "<init>", "(Landroidx/compose/animation/core/TransitionState;Landroidx/compose/animation/core/Transition;Ljava/lang/String;)V", "(Landroidx/compose/animation/core/TransitionState;Ljava/lang/String;)V", "initialState", "(Ljava/lang/Object;Ljava/lang/String;)V", "Landroidx/compose/animation/core/MutableTransitionState;", "(Landroidx/compose/animation/core/MutableTransitionState;Ljava/lang/String;)V", "getParentTransition", "()Landroidx/compose/animation/core/Transition;", "getLabel", "()Ljava/lang/String;", "currentState", "getCurrentState", "()Ljava/lang/Object;", "<set-?>", "targetState", "getTargetState", "setTargetState$animation_core", "(Ljava/lang/Object;)V", "targetState$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/animation/core/Transition$Segment;", MonitorConstants.SEGMENT, "getSegment", "()Landroidx/compose/animation/core/Transition$Segment;", "setSegment", "(Landroidx/compose/animation/core/Transition$Segment;)V", "segment$delegate", "isRunning", "", "()Z", "", "_playTimeNanos", "get_playTimeNanos", "()J", "set_playTimeNanos", "(J)V", "_playTimeNanos$delegate", "Landroidx/compose/runtime/MutableLongState;", "value", "playTimeNanos", "getPlayTimeNanos", "setPlayTimeNanos", "startTimeNanos", "getStartTimeNanos$animation_core", "setStartTimeNanos$animation_core", "startTimeNanos$delegate", "updateChildrenNeeded", "getUpdateChildrenNeeded", "setUpdateChildrenNeeded", "(Z)V", "updateChildrenNeeded$delegate", "_animations", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "_transitions", "transitions", "", "getTransitions", "()Ljava/util/List;", "animations", "getAnimations", "isSeeking", "setSeeking$animation_core", "isSeeking$delegate", "lastSeekedTimeNanos", "getLastSeekedTimeNanos$animation_core", "setLastSeekedTimeNanos$animation_core", "hasInitialValueAnimations", "getHasInitialValueAnimations$annotations", "()V", "getHasInitialValueAnimations", "totalDurationNanos", "getTotalDurationNanos", "totalDurationNanos$delegate", "Landroidx/compose/runtime/State;", "calculateTotalDurationNanos", "onFrame", "", "frameTimeNanos", "durationScale", "", "onFrame$animation_core", "scaledPlayTimeNanos", "scaleToEnd", "onTransitionStart", "onTransitionStart$animation_core", "onDisposed", "onDisposed$animation_core", "onTransitionEnd", "onTransitionEnd$animation_core", "setPlaytimeAfterInitialAndTargetStateEstablished", "seek", "(Ljava/lang/Object;Ljava/lang/Object;J)V", "addTransition", "transition", "addTransition$animation_core", "removeTransition", "removeTransition$animation_core", "addAnimation", GXTemplateKey.GAIAX_ANIMATION, "addAnimation$animation_core", "removeAnimation", "removeAnimation$animation_core", "updateTarget", "updateTarget$animation_core", "animateTo", "animateTo$animation_core", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)V", "seekAnimations", "seekAnimations$animation_core", "setInitialAnimations", "animationState", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "setInitialAnimations$animation_core", "resetAnimationFraction", "fraction", "resetAnimationFraction$animation_core", "clearInitialAnimations", "clearInitialAnimations$animation_core", "updateInitialValues", "updateInitialValues$animation_core", "toString", "onChildAnimationUpdated", "deferredAnimation", "Landroidx/compose/animation/core/Transition$DeferredAnimation;", "TransitionAnimationState", "SegmentImpl", "Segment", "DeferredAnimation", "animation-core", "runFrameLoop"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Transition<S> {
    public static final int $stable = 0;
    private final SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> _animations;
    private final MutableLongState _playTimeNanos$delegate;
    private final SnapshotStateList<Transition<?>> _transitions;
    private final MutableState isSeeking$delegate;
    private final String label;
    private long lastSeekedTimeNanos;
    private final Transition<?> parentTransition;
    private final MutableState segment$delegate;
    private final MutableLongState startTimeNanos$delegate;
    private final MutableState targetState$delegate;
    private final State totalDurationNanos$delegate;
    private final TransitionState<S> transitionState;
    private final MutableState updateChildrenNeeded$delegate;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\u00020\u0004:\u0001'B%\b\u0000\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJT\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u001a2#\u0010\u001b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u001e0\u001c¢\u0006\u0002\b\u001f2!\u0010 \u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00028\u00010\u001cJ\r\u0010$\u001a\u00020%H\u0000¢\u0006\u0002\b&R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR{\u0010\u0012\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0010R\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\u00112.\u0010\u000f\u001a*\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0010R\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0000R\b\u0012\u0004\u0012\u00028\u00000\u00118@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006("}, d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation;", ExifInterface.GPS_DIRECTION_TRUE, "V", "Landroidx/compose/animation/core/AnimationVector;", "", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "<init>", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getLabel", "()Ljava/lang/String;", "<set-?>", "Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "Landroidx/compose/animation/core/Transition;", "data", "getData$animation_core", "()Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", "setData$animation_core", "(Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;)V", "data$delegate", "Landroidx/compose/runtime/MutableState;", "animate", "Landroidx/compose/runtime/State;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "setupSeeking", "", "setupSeeking$animation_core", "DeferredAnimationData", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class DeferredAnimation<T, V extends AnimationVector> {
        private final MutableState data$delegate;
        private final String label;
        final /* synthetic */ Transition<S> this$0;
        private final TwoWayConverter<T, V> typeConverter;

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u0000*\u0004\b\u0003\u0010\u0001*\b\b\u0004\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004Bm\u0012\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012#\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000b0\t¢\u0006\u0002\b\f\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\nR'\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u0006R\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R7\u0010\b\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00030\u000b0\t¢\u0006\u0002\b\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R5\u0010\r\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00028\u00030\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001e\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Landroidx/compose/animation/core/Transition$DeferredAnimation$DeferredAnimationData;", ExifInterface.GPS_DIRECTION_TRUE, "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", GXTemplateKey.GAIAX_ANIMATION, "Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "Landroidx/compose/animation/core/Transition;", "transitionSpec", "Lkotlin/Function1;", "Landroidx/compose/animation/core/Transition$Segment;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Lkotlin/ExtensionFunctionType;", "targetValueByState", "Lkotlin/ParameterName;", "name", "state", "<init>", "(Landroidx/compose/animation/core/Transition$DeferredAnimation;Landroidx/compose/animation/core/Transition$TransitionAnimationState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getAnimation", "()Landroidx/compose/animation/core/Transition$TransitionAnimationState;", "getTransitionSpec", "()Lkotlin/jvm/functions/Function1;", "setTransitionSpec", "(Lkotlin/jvm/functions/Function1;)V", "getTargetValueByState", "setTargetValueByState", "updateAnimationStates", "", MonitorConstants.SEGMENT, "value", "getValue", "()Ljava/lang/Object;", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public final class DeferredAnimationData<T, V extends AnimationVector> implements State<T> {
            private final Transition<S>.TransitionAnimationState<T, V> animation;
            private Function1<? super S, ? extends T> targetValueByState;
            final /* synthetic */ Transition<S>.DeferredAnimation<T, V> this$0;
            private Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec;

            @Override // androidx.compose.runtime.State
            public T getValue() {
                updateAnimationStates(this.this$0.this$0.getSegment());
                return this.animation.getValue();
            }

            public final Transition<S>.TransitionAnimationState<T, V> getAnimation() {
                return this.animation;
            }

            public final Function1<S, T> getTargetValueByState() {
                return this.targetValueByState;
            }

            public final Function1<Segment<S>, FiniteAnimationSpec<T>> getTransitionSpec() {
                return this.transitionSpec;
            }

            public final void setTargetValueByState(Function1<? super S, ? extends T> r100) {
                this.targetValueByState = r100;
            }

            public final void setTransitionSpec(Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> r100) {
                this.transitionSpec = r100;
            }

            public final void updateAnimationStates(Segment<S> r100) {
                T r101 = this.targetValueByState.invoke(r100.getTargetState());
                if (this.this$0.this$0.isSeeking() == false) goto L5;
                T r102 = this.targetValueByState.invoke(r100.getInitialState());
                this.animation.updateInitialAndTargetValue$animation_core(r102, r101, this.transitionSpec.invoke(r100));
                return;
            L5:
                this.animation.updateTargetValue$animation_core(r101, this.transitionSpec.invoke(r100));
            }

            public DeferredAnimationData(DeferredAnimation r100, Transition<S>.TransitionAnimationState<T, V> r101, Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> r102, Function1<? super S, ? extends T> r103) {
                this.this$0 = r100;
                this.animation = r101;
                this.transitionSpec = r102;
                this.targetValueByState = r103;
            }
        }

        public final Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> getData$animation_core() {
            return (DeferredAnimationData) this.data$delegate.getValue();
        }

        public final void setupSeeking$animation_core() {
            Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> r100 = getData$animation_core();
            if (r100 == null) goto L6;
            Transition<S> r101 = this.this$0;
            r100.getAnimation().updateInitialAndTargetValue$animation_core(r100.getTargetValueByState().invoke(r101.getSegment().getInitialState()), r100.getTargetValueByState().invoke(r101.getSegment().getTargetState()), r100.getTransitionSpec().invoke(r101.getSegment()));
            return;
        }

        public final String getLabel() {
            return this.label;
        }

        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        public final void setData$animation_core(Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> r100) {
            this.data$delegate.setValue(r100);
        }

        public final State<T> animate(Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> r100, Function1<? super S, ? extends T> r110) {
            Transition<S>.DeferredAnimationData<T, V>.DeferredAnimationData<T, V> r101 = getData$animation_core();
            if (r101 != null) goto L5;
            Transition<S> r102 = this.this$0;
            r101 = new DeferredAnimationData(this, new TransitionAnimationState(r102, r110.invoke(r102.getCurrentState()), AnimationStateKt.createZeroVectorFrom(this.typeConverter, r110.invoke(this.this$0.getCurrentState())), this.typeConverter, this.label), r100, r110);
            Transition<S> r103 = this.this$0;
            setData$animation_core(r101);
            r103.addAnimation$animation_core(r101.getAnimation());
        L5:
            Transition<S> r104 = this.this$0;
            r101.setTargetValueByState(r110);
            r101.setTransitionSpec(r100);
            r101.updateAnimationStates(r104.getSegment());
            return r101;
        }

        public DeferredAnimation(Transition r100, TwoWayConverter<T, V> r101, String r102) {
            this.this$0 = r100;
            this.typeConverter = r101;
            this.label = r102;
            this.data$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002J\u001a\u0010\b\u001a\u00020\t*\u00028\u00012\u0006\u0010\u0006\u001a\u00028\u0001H\u0096\u0004¢\u0006\u0002\u0010\nR\u0012\u0010\u0003\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00028\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Landroidx/compose/animation/core/Transition$Segment;", ExifInterface.LATITUDE_SOUTH, "", "initialState", ProfileEditRelaxPage.METHOD_GET_INITIAL_STATE, "()Ljava/lang/Object;", "targetState", "getTargetState", "isTransitioningTo", "", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Segment<S> {

        /* JADX INFO: renamed from: androidx.compose.animation.core.Transition$Segment$-CC, reason: invalid class name */
        public final /* synthetic */ class CC<S> {
            public static boolean $default$isTransitioningTo(Segment r100, Object r101, Object r102) {
                if (Intrinsics.areEqual(r101, r100.getInitialState()) == true) goto L5;
            L7:
                return false;
            L5:
                if (Intrinsics.areEqual(r102, r100.getTargetState()) == false) goto L7;
                return true;
            }

            public static /* synthetic */ boolean access$isTransitioningTo$jd(Segment r100, Object r101, Object r102) {
                return $default$isTransitioningTo(r100, r101, r102);
            }
        }

        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public static final class DefaultImpls {
            public static <S> boolean isTransitioningTo(Segment<S> r100, S r101, S r102) {
                return CC.access$isTransitioningTo$jd(r100, r101, r102);
            }
        }

        S getInitialState();

        S getTargetState();

        boolean isTransitioningTo(S r100, S r101);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0016\u0010\u0003\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u0011"}, d2 = {"Landroidx/compose/animation/core/Transition$SegmentImpl;", ExifInterface.LATITUDE_SOUTH, "Landroidx/compose/animation/core/Transition$Segment;", "initialState", "targetState", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;)V", ProfileEditRelaxPage.METHOD_GET_INITIAL_STATE, "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTargetState", "equals", "", "other", "", "hashCode", "", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SegmentImpl<S> implements Segment<S> {
        private final S initialState;
        private final S targetState;

        @Override // androidx.compose.animation.core.Transition.Segment
        public final /* synthetic */ boolean isTransitioningTo(Object r100, Object r101) {
            return Segment.CC.$default$isTransitioningTo(this, r100, r101);
        }

        public int hashCode() {
            S r100 = getInitialState();
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            S r104 = getTargetState();
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public S getInitialState() {
            return this.initialState;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public S getTargetState() {
            return this.targetState;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof Segment) == false) goto L9;
            Segment r101 = (Segment) r100;
            if (Intrinsics.areEqual(getInitialState(), r101.getInitialState()) == false) goto L9;
            if (Intrinsics.areEqual(getTargetState(), r101.getTargetState()) == false) goto L9;
            return true;
        L9:
            return false;
        }

        public SegmentImpl(S r100, S r101) {
            this.initialState = r100;
            this.targetState = r101;
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u001d\b\u0087\u0004\u0018\u0000*\u0004\b\u0001\u0010\u0001*\b\b\u0002\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B5\b\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0006\u001a\u00028\u0002\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020F2\u0006\u0010R\u001a\u000200H\u0000¢\u0006\u0002\bSJ\u0015\u0010T\u001a\u00020P2\u0006\u0010Q\u001a\u00020FH\u0000¢\u0006\u0002\bUJ\r\u0010V\u001a\u00020PH\u0000¢\u0006\u0002\bWJ!\u0010Y\u001a\u00020P2\b\b\u0002\u0010\u0005\u001a\u00028\u00012\b\b\u0002\u0010Z\u001a\u000200H\u0002¢\u0006\u0002\u0010[J\r\u0010\\\u001a\u00020PH\u0000¢\u0006\u0002\b]J\u0015\u0010^\u001a\u00020P2\u0006\u0010_\u001a\u000207H\u0000¢\u0006\u0002\b`J\u0015\u0010a\u001a\u00020P2\u0006\u0010b\u001a\u00020*H\u0000¢\u0006\u0002\bcJ\r\u0010d\u001a\u00020PH\u0000¢\u0006\u0002\beJ\b\u0010f\u001a\u00020\nH\u0016J%\u0010g\u001a\u00020P2\u0006\u0010\u0012\u001a\u00028\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001bH\u0000¢\u0006\u0004\bh\u0010iJ-\u0010j\u001a\u00020P2\u0006\u0010\u0005\u001a\u00028\u00012\u0006\u0010\u0012\u001a\u00028\u00012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001bH\u0000¢\u0006\u0004\bk\u0010lR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R+\u0010\u0012\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00028\u00018B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u001b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\u0018\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 RC\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\"2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\"8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\u0018\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R+\u00101\u001a\u0002002\u0006\u0010\u0011\u001a\u0002008@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010\u0018\u001a\u0004\b2\u00103\"\u0004\b4\u00105R+\u00108\u001a\u0002072\u0006\u0010\u0011\u001a\u0002078@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u000e\u0010?\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010@\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00028\u00018V@PX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010\u0018\u001a\u0004\bA\u0010\u0014\"\u0004\bB\u0010\u0016R\u0010\u0010D\u001a\u00028\u0002X\u0082\u000e¢\u0006\u0004\n\u0002\u0010ER+\u0010G\u001a\u00020F2\u0006\u0010\u0011\u001a\u00020F8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u000e\u0010N\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00010\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Landroidx/compose/animation/core/Transition$TransitionAnimationState;", ExifInterface.GPS_DIRECTION_TRUE, "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/runtime/State;", "initialValue", "initialVelocityVector", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "label", "", "<init>", "(Landroidx/compose/animation/core/Transition;Ljava/lang/Object;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/String;)V", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getLabel", "()Ljava/lang/String;", "<set-?>", "targetValue", "getTargetValue", "()Ljava/lang/Object;", "setTargetValue", "(Ljava/lang/Object;)V", "targetValue$delegate", "Landroidx/compose/runtime/MutableState;", "defaultSpring", "Landroidx/compose/animation/core/SpringSpec;", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "animationSpec", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animationSpec$delegate", "Landroidx/compose/animation/core/TargetBasedAnimation;", GXTemplateKey.GAIAX_ANIMATION, "getAnimation", "()Landroidx/compose/animation/core/TargetBasedAnimation;", "setAnimation", "(Landroidx/compose/animation/core/TargetBasedAnimation;)V", "animation$delegate", "initialValueState", "Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "getInitialValueState$animation_core", "()Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;", "setInitialValueState$animation_core", "(Landroidx/compose/animation/core/SeekableTransitionState$SeekingAnimationState;)V", "initialValueAnimation", "", "isFinished", "isFinished$animation_core", "()Z", "setFinished$animation_core", "(Z)V", "isFinished$delegate", "", "resetSnapValue", "getResetSnapValue$animation_core", "()F", "setResetSnapValue$animation_core", "(F)V", "resetSnapValue$delegate", "Landroidx/compose/runtime/MutableFloatState;", "useOnlyInitialValue", "value", "getValue", "setValue$animation_core", "value$delegate", "velocityVector", "Landroidx/compose/animation/core/AnimationVector;", "", "durationNanos", "getDurationNanos$animation_core", "()J", "setDurationNanos$animation_core", "(J)V", "durationNanos$delegate", "Landroidx/compose/runtime/MutableLongState;", "isSeeking", "onPlayTimeChanged", "", "playTimeNanos", "scaleToEnd", "onPlayTimeChanged$animation_core", "seekTo", "seekTo$animation_core", "updateInitialValue", "updateInitialValue$animation_core", "interruptionSpec", "updateAnimation", "isInterrupted", "(Ljava/lang/Object;Z)V", "resetAnimation", "resetAnimation$animation_core", "resetAnimationValue", "fraction", "resetAnimationValue$animation_core", "setInitialValueAnimation", "animationState", "setInitialValueAnimation$animation_core", "clearInitialAnimation", "clearInitialAnimation$animation_core", "toString", "updateTargetValue", "updateTargetValue$animation_core", "(Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "updateInitialAndTargetValue", "updateInitialAndTargetValue$animation_core", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "animation-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class TransitionAnimationState<T, V extends AnimationVector> implements State<T> {
        private final MutableState animation$delegate;
        private final MutableState animationSpec$delegate;
        private final SpringSpec<T> defaultSpring;
        private final MutableLongState durationNanos$delegate;
        private TargetBasedAnimation<T, V> initialValueAnimation;
        private SeekableTransitionState.SeekingAnimationState initialValueState;
        private final FiniteAnimationSpec<T> interruptionSpec;
        private final MutableState isFinished$delegate;
        private boolean isSeeking;
        private final String label;
        private final MutableFloatState resetSnapValue$delegate;
        private final MutableState targetValue$delegate;
        final /* synthetic */ Transition<S> this$0;
        private final TwoWayConverter<T, V> typeConverter;
        private boolean useOnlyInitialValue;
        private final MutableState value$delegate;
        private V velocityVector;

        public final void clearInitialAnimation$animation_core() {
            this.initialValueAnimation = null;
            this.initialValueState = null;
            this.useOnlyInitialValue = false;
        }

        private final T getTargetValue() {
            return this.targetValue$delegate.getValue();
        }

        public final TargetBasedAnimation<T, V> getAnimation() {
            return (TargetBasedAnimation) this.animation$delegate.getValue();
        }

        public final FiniteAnimationSpec<T> getAnimationSpec() {
            return (FiniteAnimationSpec) this.animationSpec$delegate.getValue();
        }

        public final long getDurationNanos$animation_core() {
            return this.durationNanos$delegate.getLongValue();
        }

        public final float getResetSnapValue$animation_core() {
            return this.resetSnapValue$delegate.getFloatValue();
        }

        @Override // androidx.compose.runtime.State
        public T getValue() {
            return this.value$delegate.getValue();
        }

        public final boolean isFinished$animation_core() {
            return ((Boolean) this.isFinished$delegate.getValue()).booleanValue();
        }

        public final void resetAnimation$animation_core() {
            setResetSnapValue$animation_core(-2.0f);
        }

        public String toString() {
            return "current value: " + getValue() + ", target: " + getTargetValue() + ", spec: " + getAnimationSpec();
        }

        public final void updateInitialValue$animation_core() {
            SeekableTransitionState.SeekingAnimationState r100 = this.initialValueState;
            if (r100 != null) goto L5;
            return;
        L5:
            TargetBasedAnimation<T, V> r101 = this.initialValueAnimation;
            if (r101 != null) goto L8;
            return;
        L8:
            long r102 = MathKt.roundToLong(r100.getDurationNanos() * ((double) r100.getValue()));
            T r103 = r101.getValueFromNanos(r102);
            if (this.useOnlyInitialValue == false) goto L11;
            getAnimation().setMutableTargetValue$animation_core(r103);
        L11:
            getAnimation().setMutableInitialValue$animation_core(r103);
            setDurationNanos$animation_core(getAnimation().getDurationNanos());
            if (getResetSnapValue$animation_core() != (-2.0f)) goto L14;
            boolean r104 = true;
        L15:
            if (r104 == false) goto L17;
        L20:
            setValue$animation_core(r103);
        L22:
            if (r102 < r100.getDurationNanos()) goto L24;
            this.initialValueState = null;
            this.initialValueAnimation = null;
            return;
        L24:
            r100.setComplete(false);
            return;
        L17:
            if (this.useOnlyInitialValue == true) goto L20;
            seekTo$animation_core(this.this$0.getPlayTimeNanos());
            goto L22
        L14:
            r104 = false;
            goto L15
        }

        public final SeekableTransitionState.SeekingAnimationState getInitialValueState$animation_core() {
            return this.initialValueState;
        }

        public final String getLabel() {
            return this.label;
        }

        public final TwoWayConverter<T, V> getTypeConverter() {
            return this.typeConverter;
        }

        private final void setAnimation(TargetBasedAnimation<T, V> r100) {
            this.animation$delegate.setValue(r100);
        }

        private final void setAnimationSpec(FiniteAnimationSpec<T> r100) {
            this.animationSpec$delegate.setValue(r100);
        }

        private final void setTargetValue(T r100) {
            this.targetValue$delegate.setValue(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void resetAnimationValue$animation_core(float r100) {
            boolean r101 = true;
            if (r100 != (-4.0f)) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L8;
        L14:
            TargetBasedAnimation<T, V> r103 = this.initialValueAnimation;
            if (r103 == null) goto L17;
            getAnimation().setMutableInitialValue$animation_core(r103.getTargetValue());
            this.initialValueState = null;
            this.initialValueAnimation = null;
        L17:
            if (r100 == (-4.0f)) goto L20;
            r101 = false;
        L20:
            if (r101 == false) goto L22;
            Object r104 = getAnimation().getInitialValue();
        L23:
            getAnimation().setMutableInitialValue$animation_core(r104);
            getAnimation().setMutableTargetValue$animation_core(r104);
            setValue$animation_core(r104);
            setDurationNanos$animation_core(getAnimation().getDurationNanos());
            return;
        L22:
            r104 = getAnimation().getTargetValue();
            goto L23
        L8:
            if (r100 != (-5.0f)) goto L10;
            boolean r105 = true;
        L11:
            if (r105 == true) goto L14;
            setResetSnapValue$animation_core(r100);
            return;
        L10:
            r105 = false;
            goto L11
        L5:
            r102 = false;
            goto L6
        }

        public final void seekTo$animation_core(long r100) {
            if (getResetSnapValue$animation_core() != (-1.0f)) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == true) goto L8;
            return;
        L8:
            this.isSeeking = true;
            if (Intrinsics.areEqual(getAnimation().getTargetValue(), getAnimation().getInitialValue()) == false) goto L11;
            setValue$animation_core(getAnimation().getTargetValue());
            return;
        L11:
            setValue$animation_core(getAnimation().getValueFromNanos(r100));
            this.velocityVector = (V) getAnimation().getVelocityVectorFromNanos(r100);
            return;
        L5:
            r101 = false;
            goto L6
        }

        public final void setDurationNanos$animation_core(long r100) {
            this.durationNanos$delegate.setLongValue(r100);
        }

        public final void setFinished$animation_core(boolean r100) {
            this.isFinished$delegate.setValue(Boolean.valueOf(r100));
        }

        public final void setInitialValueAnimation$animation_core(SeekableTransitionState.SeekingAnimationState r100) {
            if (Intrinsics.areEqual(getAnimation().getTargetValue(), getAnimation().getInitialValue()) == true) goto L5;
            this.initialValueAnimation = getAnimation();
            this.initialValueState = r100;
        L5:
            setAnimation(new TargetBasedAnimation(this.interruptionSpec, this.typeConverter, getValue(), getValue(), AnimationVectorsKt.newInstance(this.velocityVector)));
            setDurationNanos$animation_core(getAnimation().getDurationNanos());
            this.useOnlyInitialValue = true;
        }

        public final void setInitialValueState$animation_core(SeekableTransitionState.SeekingAnimationState r100) {
            this.initialValueState = r100;
        }

        public final void setResetSnapValue$animation_core(float r100) {
            this.resetSnapValue$delegate.setFloatValue(r100);
        }

        public void setValue$animation_core(T r100) {
            this.value$delegate.setValue(r100);
        }

        private final void updateAnimation(T r100, boolean r101) {
            TargetBasedAnimation<T, V> r102 = this.initialValueAnimation;
            if (r102 == null) goto L5;
            T r103 = r102.getTargetValue();
        L7:
            if (Intrinsics.areEqual(r103, getTargetValue()) == false) goto L10;
            setAnimation(new TargetBasedAnimation(this.interruptionSpec, this.typeConverter, r100, r100, AnimationVectorsKt.newInstance(this.velocityVector)));
            this.useOnlyInitialValue = true;
            setDurationNanos$animation_core(getAnimation().getDurationNanos());
            return;
        L10:
            if (r101 == true) goto L12;
        L17:
            AnimationSpec r104 = getAnimationSpec();
        L19:
            if (this.this$0.getPlayTimeNanos() <= 0) goto L22;
            r104 = AnimationSpecKt.delayed(r104, this.this$0.getPlayTimeNanos());
        L22:
            setAnimation(new TargetBasedAnimation(r104, this.typeConverter, r100, getTargetValue(), this.velocityVector));
            setDurationNanos$animation_core(getAnimation().getDurationNanos());
            this.useOnlyInitialValue = false;
            Transition.access$onChildAnimationUpdated(this.this$0);
            return;
        L12:
            if (this.isSeeking == true) goto L17;
            if ((getAnimationSpec() instanceof SpringSpec) == false) goto L16;
            r104 = getAnimationSpec();
            goto L19
        L16:
            r104 = this.interruptionSpec;
            goto L19
        L5:
            r103 = null;
            goto L7
        }

        public final void onPlayTimeChanged$animation_core(long r100, boolean r101) {
            if (r101 == false) goto L4;
            r100 = getAnimation().getDurationNanos();
        L4:
            setValue$animation_core(getAnimation().getValueFromNanos(r100));
            this.velocityVector = (V) getAnimation().getVelocityVectorFromNanos(r100);
            TargetBasedAnimation<T, V> r102 = getAnimation();
            r102.getClass();
            if (Animation.CC.$default$isFinishedFromNanos(r102, r100) == false) goto L8;
            setFinished$animation_core(true);
            return;
        }

        public final void updateTargetValue$animation_core(T r100, FiniteAnimationSpec<T> r101) {
            if (this.useOnlyInitialValue == false) goto L11;
            TargetBasedAnimation<T, V> r102 = this.initialValueAnimation;
            if (r102 == null) goto L7;
            T r103 = r102.getTargetValue();
        L9:
            if (Intrinsics.areEqual(r100, r103) == false) goto L11;
            return;
        L7:
            r103 = null;
        L11:
            boolean r104 = true;
            if (Intrinsics.areEqual(getTargetValue(), r100) == true) goto L14;
        L19:
            setTargetValue(r100);
            setAnimationSpec(r101);
            if (getResetSnapValue$animation_core() != (-3.0f)) goto L22;
            boolean r105 = true;
        L23:
            if (r105 == false) goto L25;
            T r106 = r100;
        L26:
            updateAnimation(r106, !isFinished$animation_core());
            if (getResetSnapValue$animation_core() != (-3.0f)) goto L29;
            boolean r107 = true;
        L30:
            setFinished$animation_core(r107);
            if (getResetSnapValue$animation_core() < 0.0f) goto L34;
            setValue$animation_core(getAnimation().getValueFromNanos((long) (getAnimation().getDurationNanos() * getResetSnapValue$animation_core())));
        L39:
            this.useOnlyInitialValue = false;
            setResetSnapValue$animation_core(-1.0f);
            return;
        L34:
            if (getResetSnapValue$animation_core() == (-3.0f)) goto L37;
            r104 = false;
        L37:
            if (r104 == false) goto L39;
            setValue$animation_core(r100);
            goto L39
        L29:
            r107 = false;
            goto L30
        L25:
            r106 = getValue();
            goto L26
        L22:
            r105 = false;
            goto L23
        L14:
            if (getResetSnapValue$animation_core() != (-1.0f)) goto L16;
            boolean r108 = true;
        L17:
            if (r108 == false) goto L19;
            return;
        L16:
            r108 = false;
            goto L17
        }

        public final void updateInitialAndTargetValue$animation_core(T r100, T r101, FiniteAnimationSpec<T> r102) {
            setTargetValue(r101);
            setAnimationSpec(r102);
            if (Intrinsics.areEqual(getAnimation().getInitialValue(), r100) == true) goto L5;
        L7:
            updateAnimation$default(this, r100, false, 2, null);
            return;
        L5:
            if (Intrinsics.areEqual(getAnimation().getTargetValue(), r101) == false) goto L7;
        }

        public TransitionAnimationState(Transition r100, T r110, V r111, TwoWayConverter<T, V> r112, String r113) {
            this.this$0 = r100;
            this.typeConverter = r112;
            this.label = r113;
            this.targetValue$delegate = SnapshotStateKt.mutableStateOf$default(r110, null, 2, null);
            SpringSpec<T> r101 = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            this.defaultSpring = r101;
            this.animationSpec$delegate = SnapshotStateKt.mutableStateOf$default(r101, null, 2, null);
            this.animation$delegate = SnapshotStateKt.mutableStateOf$default(new TargetBasedAnimation(getAnimationSpec(), r112, r110, getTargetValue(), r111), null, 2, null);
            this.isFinished$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
            this.resetSnapValue$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(-1.0f);
            this.value$delegate = SnapshotStateKt.mutableStateOf$default(r110, null, 2, null);
            this.velocityVector = r111;
            this.durationNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(getAnimation().getDurationNanos());
            Float r114 = VisibilityThresholdsKt.getVisibilityThresholdMap().get(r112);
            if (r114 == null) goto L8;
            float r115 = r114.floatValue();
            V r116 = r112.getConvertToVector().invoke(r110);
            int r117 = r116.getSize$animation_core();
            int r118 = 0;
        L5:
            if (r118 >= r117) goto L7;
            r116.set$animation_core(r118, r115);
            r118 = r118 + 1;
            goto L5
        L7:
            T r119 = this.typeConverter.getConvertFromVector().invoke(r116);
        L9:
            this.interruptionSpec = AnimationSpecKt.spring$default(0.0f, 0.0f, r119, 3, null);
            return;
        L8:
            r119 = null;
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void updateAnimation$default(TransitionAnimationState r100, Object r101, boolean r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.getValue();
        L6:
            if ((r103 & 2) == 0) goto L8;
            r102 = false;
        L8:
            r100.updateAnimation(r101, r102);
        }
    }

    public static /* synthetic */ boolean a(Transition r100) {
        return animateTo$lambda$13$lambda$12(r100);
    }

    private static final Unit animateTo$lambda$18(Transition r100, Object r101, int r102, Composer r103, int r104) {
        r100.animateTo$animation_core(r101, r103, RecomposeScopeImplKt.updateChangedFlags(r102 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ long b(Transition r100) {
        return totalDurationNanos_delegate$lambda$2(r100);
    }

    public static /* synthetic */ DisposableEffectResult c(CoroutineScope r100, Transition r101, DisposableEffectScope r102) {
        return animateTo$lambda$17$lambda$16(r100, r101, r102);
    }

    public static /* synthetic */ Unit d(Transition r100, Object r101, int r102, Composer r103, int r104) {
        return animateTo$lambda$18(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ void getHasInitialValueAnimations$annotations() {
    }

    private final void onChildAnimationUpdated() {
        setUpdateChildrenNeeded(true);
        if (isSeeking() == false) goto L10;
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r100 = this._animations;
        int r101 = r100.size();
        long r102 = 0;
        int r103 = 0;
    L5:
        if (r103 >= r101) goto L7;
        TransitionAnimationState r104 = (TransitionAnimationState) ListProtector.get(r100, r103);
        r102 = Math.max(r102, r104.getDurationNanos$animation_core());
        r104.seekTo$animation_core(this.lastSeekedTimeNanos);
        r103 = r103 + 1;
        goto L5
    L7:
        setUpdateChildrenNeeded(false);
        return;
    }

    private final long calculateTotalDurationNanos() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r100 = this._animations;
        int r101 = r100.size();
        long r102 = 0;
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r101) goto L5;
        r102 = Math.max(r102, ((TransitionAnimationState) ListProtector.get(r100, r104)).getDurationNanos$animation_core());
        r104 = r104 + 1;
        goto L3
    L5:
        SnapshotStateList<Transition<?>> r105 = this._transitions;
        int r106 = r105.size();
    L6:
        if (r103 >= r106) goto L8;
        r102 = Math.max(r102, ((Transition) ListProtector.get(r105, r103)).calculateTotalDurationNanos());
        r103 = r103 + 1;
        goto L6
    L8:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getUpdateChildrenNeeded() {
        return ((Boolean) this.updateChildrenNeeded$delegate.getValue()).booleanValue();
    }

    private final long get_playTimeNanos() {
        return this._playTimeNanos$delegate.getLongValue();
    }

    public final void clearInitialAnimations$animation_core() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r100 = this._animations;
        int r101 = r100.size();
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        ((TransitionAnimationState) ListProtector.get(r100, r103)).clearInitialAnimation$animation_core();
        r103 = r103 + 1;
        goto L3
    L5:
        SnapshotStateList<Transition<?>> r104 = this._transitions;
        int r105 = r104.size();
    L6:
        if (r102 >= r105) goto L8;
        ((Transition) ListProtector.get(r104, r102)).clearInitialAnimations$animation_core();
        r102 = r102 + 1;
        goto L6
    }

    public final S getCurrentState() {
        return this.transitionState.getCurrentState();
    }

    public final boolean getHasInitialValueAnimations() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r100 = this._animations;
        int r101 = r100.size();
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L12;
        if (((TransitionAnimationState) ListProtector.get(r100, r102)).getInitialValueState$animation_core() == null) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L10;
        r102 = r102 + 1;
        goto L4
    L10:
        boolean r104 = true;
    L13:
        if (r104 == true) goto L22;
        SnapshotStateList<Transition<?>> r105 = this._transitions;
        int r106 = r105.size();
        int r107 = 0;
    L15:
        if (r107 >= r106) goto L20;
        if (((Transition) ListProtector.get(r105, r107)).getHasInitialValueAnimations() == true) goto L18;
        r107 = r107 + 1;
        goto L15
    L18:
        boolean r108 = true;
    L21:
        if (r108 == true) goto L22;
        return false;
    L20:
        r108 = false;
    L22:
        return true;
    L8:
        r103 = false;
        goto L9
    L12:
        r104 = false;
        goto L13
    }

    public final long getPlayTimeNanos() {
        Transition<?> r100 = this.parentTransition;
        if (r100 == null) goto L6;
        return r100.getPlayTimeNanos();
    L6:
        return get_playTimeNanos();
    }

    public final Segment<S> getSegment() {
        return (Segment) this.segment$delegate.getValue();
    }

    public final long getStartTimeNanos$animation_core() {
        return this.startTimeNanos$delegate.getLongValue();
    }

    public final S getTargetState() {
        return (S) this.targetState$delegate.getValue();
    }

    public final long getTotalDurationNanos() {
        return ((Number) this.totalDurationNanos$delegate.getValue()).longValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isSeeking() {
        return ((Boolean) this.isSeeking$delegate.getValue()).booleanValue();
    }

    public final void onTransitionEnd$animation_core() {
        setStartTimeNanos$animation_core(Long.MIN_VALUE);
        TransitionState<S> r100 = this.transitionState;
        if ((r100 instanceof MutableTransitionState) == false) goto L5;
        ((MutableTransitionState) r100).setCurrentState$animation_core(getTargetState());
    L5:
        setPlayTimeNanos(0);
        int r101 = 0;
        this.transitionState.setRunning$animation_core(false);
        SnapshotStateList<Transition<?>> r102 = this._transitions;
        int r103 = r102.size();
    L6:
        if (r101 >= r103) goto L8;
        ((Transition) ListProtector.get(r102, r101)).onTransitionEnd$animation_core();
        r101 = r101 + 1;
        goto L6
    }

    public final void updateInitialValues$animation_core() {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r100 = this._animations;
        int r101 = r100.size();
        int r102 = 0;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        ((TransitionAnimationState) ListProtector.get(r100, r103)).updateInitialValue$animation_core();
        r103 = r103 + 1;
        goto L3
    L5:
        SnapshotStateList<Transition<?>> r104 = this._transitions;
        int r105 = r104.size();
    L6:
        if (r102 >= r105) goto L8;
        ((Transition) ListProtector.get(r104, r102)).updateInitialValues$animation_core();
        r102 = r102 + 1;
        goto L6
    }

    public final boolean isRunning() {
        if (getStartTimeNanos$animation_core() == Long.MIN_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    public final void onDisposed$animation_core() {
        onTransitionEnd$animation_core();
        this.transitionState.transitionRemoved$animation_core();
    }

    public String toString() {
        List<Transition<S>.TransitionAnimationState<?, ?>> r100 = getAnimations();
        int r101 = r100.size();
        String r102 = "Transition animation values: ";
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102 = r102 + ((TransitionAnimationState) ListProtector.get(r100, r103)) + ", ";
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public final List<Transition<S>.TransitionAnimationState<?, ?>> getAnimations() {
        return this._animations;
    }

    public final String getLabel() {
        return this.label;
    }

    public final long getLastSeekedTimeNanos$animation_core() {
        return this.lastSeekedTimeNanos;
    }

    public final Transition<?> getParentTransition() {
        return this.parentTransition;
    }

    public final List<Transition<?>> getTransitions() {
        return this._transitions;
    }

    public static final /* synthetic */ void access$onChildAnimationUpdated(Transition r100) {
        r100.onChildAnimationUpdated();
    }

    private static final boolean animateTo$lambda$13$lambda$12(Transition r100) {
        if (Intrinsics.areEqual(r100.getTargetState(), r100.getCurrentState()) == true) goto L5;
    L10:
        return true;
    L5:
        if (r100.isRunning() == true) goto L10;
        if (r100.getUpdateChildrenNeeded() == true) goto L10;
        return false;
    }

    private static final boolean animateTo$lambda$14(State<Boolean> r100) {
        return r100.getValue().booleanValue();
    }

    private final void setSegment(Segment<S> r100) {
        this.segment$delegate.setValue(r100);
    }

    private final void setUpdateChildrenNeeded(boolean r100) {
        this.updateChildrenNeeded$delegate.setValue(Boolean.valueOf(r100));
    }

    private final void set_playTimeNanos(long r100) {
        this._playTimeNanos$delegate.setLongValue(r100);
    }

    private static final long totalDurationNanos_delegate$lambda$2(Transition r100) {
        return r100.calculateTotalDurationNanos();
    }

    public final boolean addAnimation$animation_core(Transition<S>.TransitionAnimationState<?, ?> r100) {
        return this._animations.add(r100);
    }

    public final boolean addTransition$animation_core(Transition<?> r100) {
        return this._transitions.add(r100);
    }

    public final void onTransitionStart$animation_core(long r100) {
        setStartTimeNanos$animation_core(r100);
        this.transitionState.setRunning$animation_core(true);
    }

    public final void removeAnimation$animation_core(Transition<S>.DeferredAnimation<?, ?> r100) {
        Transition<S>.DeferredAnimationData<?, ?>.DeferredAnimationData<?, V> r101 = r100.getData$animation_core();
        if (r101 == 0) goto L8;
        Transition<S>.TransitionAnimationState<?, ?> r102 = r101.getAnimation();
        if (r102 == null) goto L9;
        removeAnimation$animation_core(r102);
        return;
    L9:
        return;
    }

    public final boolean removeTransition$animation_core(Transition<?> r100) {
        return this._transitions.remove(r100);
    }

    public final void resetAnimationFraction$animation_core(float r100) {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r101 = this._animations;
        int r102 = r101.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        ((TransitionAnimationState) ListProtector.get(r101, r104)).resetAnimationValue$animation_core(r100);
        r104 = r104 + 1;
        goto L3
    L5:
        SnapshotStateList<Transition<?>> r105 = this._transitions;
        int r106 = r105.size();
    L6:
        if (r103 >= r106) goto L8;
        ((Transition) ListProtector.get(r105, r103)).resetAnimationFraction$animation_core(r100);
        r103 = r103 + 1;
        goto L6
    }

    public final void seekAnimations$animation_core(long r100) {
        if (getStartTimeNanos$animation_core() != Long.MIN_VALUE) goto L5;
        setStartTimeNanos$animation_core(r100);
    L5:
        setPlayTimeNanos(r100);
        int r101 = 0;
        setUpdateChildrenNeeded(false);
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r102 = this._animations;
        int r103 = r102.size();
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L8;
        ((TransitionAnimationState) ListProtector.get(r102, r104)).seekTo$animation_core(r100);
        r104 = r104 + 1;
        goto L6
    L8:
        SnapshotStateList<Transition<?>> r105 = this._transitions;
        int r106 = r105.size();
    L9:
        if (r101 >= r106) goto L14;
        Transition r107 = (Transition) ListProtector.get(r105, r101);
        if (Intrinsics.areEqual(r107.getTargetState(), r107.getCurrentState()) == true) goto L13;
        r107.seekAnimations$animation_core(r100);
    L13:
        r101 = r101 + 1;
        goto L9
    }

    public final void setInitialAnimations$animation_core(SeekableTransitionState.SeekingAnimationState r100) {
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r101 = this._animations;
        int r102 = r101.size();
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        ((TransitionAnimationState) ListProtector.get(r101, r104)).setInitialValueAnimation$animation_core(r100);
        r104 = r104 + 1;
        goto L3
    L5:
        SnapshotStateList<Transition<?>> r105 = this._transitions;
        int r106 = r105.size();
    L6:
        if (r103 >= r106) goto L8;
        ((Transition) ListProtector.get(r105, r103)).setInitialAnimations$animation_core(r100);
        r103 = r103 + 1;
        goto L6
    }

    public final void setLastSeekedTimeNanos$animation_core(long r100) {
        this.lastSeekedTimeNanos = r100;
    }

    public final void setPlayTimeNanos(long r100) {
        if (this.parentTransition != null) goto L6;
        set_playTimeNanos(r100);
        return;
    }

    public final void setSeeking$animation_core(boolean r100) {
        this.isSeeking$delegate.setValue(Boolean.valueOf(r100));
    }

    public final void setStartTimeNanos$animation_core(long r100) {
        this.startTimeNanos$delegate.setLongValue(r100);
    }

    public final void setTargetState$animation_core(S r100) {
        this.targetState$delegate.setValue(r100);
    }

    public final void updateTarget$animation_core(S r100) {
        if (Intrinsics.areEqual(getTargetState(), r100) == true) goto L13;
        setSegment(new SegmentImpl(getTargetState(), r100));
        if (Intrinsics.areEqual(getCurrentState(), getTargetState()) == true) goto L7;
        this.transitionState.setCurrentState$animation_core(getTargetState());
    L7:
        setTargetState$animation_core(r100);
        if (isRunning() == true) goto L10;
        setUpdateChildrenNeeded(true);
    L10:
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r101 = this._animations;
        int r102 = r101.size();
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L15;
        ((TransitionAnimationState) ListProtector.get(r101, r103)).resetAnimation$animation_core();
        r103 = r103 + 1;
        goto L11
    L15:
        return;
    }

    public final void removeAnimation$animation_core(Transition<S>.TransitionAnimationState<?, ?> r100) {
        this._animations.remove(r100);
    }

    public Transition(MutableTransitionState<S> r100, String r101) {
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.animation.core.TransitionState<S of androidx.compose.animation.core.Transition>");
        this(r100, null, r101);
    }

    public final void onFrame$animation_core(long r100, boolean r110) {
        boolean r101 = true;
        if (getStartTimeNanos$animation_core() != Long.MIN_VALUE) goto L6;
        onTransitionStart$animation_core(r100);
    L8:
        setUpdateChildrenNeeded(false);
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r102 = this._animations;
        int r103 = r102.size();
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L17;
        TransitionAnimationState r105 = (TransitionAnimationState) ListProtector.get(r102, r104);
        if (r105.isFinished$animation_core() == true) goto L14;
        r105.onPlayTimeChanged$animation_core(r100, r110);
    L14:
        if (r105.isFinished$animation_core() == true) goto L16;
        r101 = false;
    L16:
        r104 = r104 + 1;
        goto L9
    L17:
        SnapshotStateList<Transition<?>> r106 = this._transitions;
        int r107 = r106.size();
        int r108 = 0;
    L18:
        if (r108 >= r107) goto L26;
        Transition r109 = (Transition) ListProtector.get(r106, r108);
        if (Intrinsics.areEqual(r109.getTargetState(), r109.getCurrentState()) == true) goto L23;
        r109.onFrame$animation_core(r100, r110);
    L23:
        if (Intrinsics.areEqual(r109.getTargetState(), r109.getCurrentState()) == true) goto L25;
        r101 = false;
    L25:
        r108 = r108 + 1;
        goto L18
    L26:
        if (r101 == false) goto L35;
        onTransitionEnd$animation_core();
        return;
    L35:
        return;
    L6:
        if (this.transitionState.isRunning$animation_core() == true) goto L8;
        this.transitionState.setRunning$animation_core(true);
        goto L8
    }

    public Transition(S r100, String r101) {
        this(new MutableTransitionState(r100), null, r101);
    }

    public final void onFrame$animation_core(long r100, float r101) {
        if (getStartTimeNanos$animation_core() != Long.MIN_VALUE) goto L5;
        onTransitionStart$animation_core(r100);
    L5:
        long r102 = r100 - getStartTimeNanos$animation_core();
        boolean r103 = true;
        if (r101 != 0.0f) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L12;
        r102 = MathKt.roundToLong(r102 / ((double) r101));
    L12:
        setPlayTimeNanos(r102);
        if (r101 == 0.0f) goto L16;
        r103 = false;
    L16:
        onFrame$animation_core(r102, r103);
        return;
    L8:
        r104 = false;
        goto L9
    }

    public Transition(TransitionState<S> r100, String r101) {
        this(r100, null, r101);
    }

    public Transition(TransitionState<S> r100, Transition<?> r101, String r102) {
        this.transitionState = r100;
        this.parentTransition = r101;
        this.label = r102;
        this.targetState$delegate = SnapshotStateKt.mutableStateOf$default(getCurrentState(), null, 2, null);
        this.segment$delegate = SnapshotStateKt.mutableStateOf$default(new SegmentImpl(getCurrentState(), getCurrentState()), null, 2, null);
        this._playTimeNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(0);
        this.startTimeNanos$delegate = SnapshotLongStateKt.mutableLongStateOf(Long.MIN_VALUE);
        Boolean r103 = Boolean.FALSE;
        this.updateChildrenNeeded$delegate = SnapshotStateKt.mutableStateOf$default(r103, null, 2, null);
        this._animations = SnapshotStateKt.mutableStateListOf();
        this._transitions = SnapshotStateKt.mutableStateListOf();
        this.isSeeking$delegate = SnapshotStateKt.mutableStateOf$default(r103, null, 2, null);
        this.totalDurationNanos$delegate = SnapshotStateKt.derivedStateOf(new g0(this));
        r100.transitionConfigured$animation_core(this);
    }

    private static final DisposableEffectResult animateTo$lambda$17$lambda$16(CoroutineScope r100, Transition r101, DisposableEffectScope r102) {
        BuildersKt.launch$default(r100, null, CoroutineStart.UNDISPATCHED, new Transition$animateTo$1$1$1(r101, null), 1, null);
        return new Transition$animateTo$lambda$17$lambda$16$$inlined$onDispose$1();
    }

    public final void animateTo$animation_core(final S r100, Composer r101, final int r110) {
        Composer r102 = r101.startRestartGroup(-1493585151);
        if ((r110 & 6) == 0) goto L5;
        int r103 = r110;
    L14:
        if ((r110 & 48) == 0) goto L16;
    L20:
        boolean r104 = false;
        if ((r103 & 19) == 18) goto L23;
        boolean r105 = true;
    L25:
        if (r102.shouldExecute(r105, r103 & 1) == true) goto L27;
        r102.skipToGroupEnd();
    L61:
        ScopeUpdateScope r106 = r102.endRestartGroup();
        if (r106 == null) goto L65;
        r106.updateScope(new f0(this, r100, r110));
        return;
    L65:
        return;
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L30;
        ComposerKt.traceEventStart(-1493585151, r103, -1, "androidx.compose.animation.core.Transition.animateTo (Transition.kt:1180)");
    L30:
        if (isSeeking() == true) goto L56;
        r102.startReplaceGroup(466120769);
        updateTarget$animation_core(r100);
        int r107 = r103 & 112;
        if (r107 != 32) goto L34;
        boolean r108 = true;
    L35:
        Object r109 = r102.rememberedValue();
        if (r108 == false) goto L38;
    L39:
        r109 = SnapshotStateKt.derivedStateOf(new d0(this));
        r102.updateRememberedValue(r109);
    L41:
        if (animateTo$lambda$14((State) r109) == false) goto L54;
        r102.startReplaceGroup(466528884);
        Object r111 = r102.rememberedValue();
        Composer.Companion r112 = Composer.Companion;
        if (r111 != r112.getEmpty()) goto L45;
        r111 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r102);
        r102.updateRememberedValue(r111);
    L45:
        final CoroutineScope r113 = (CoroutineScope) r111;
        boolean r114 = r102.changedInstance(r113);
        if (r107 != 32) goto L48;
        r104 = true;
    L48:
        boolean r115 = r114 | r104;
        Object r116 = r102.rememberedValue();
        if (r115 == false) goto L51;
    L52:
        r116 = new e0(r113, this);
        r102.updateRememberedValue(r116);
    L53:
        EffectsKt.DisposableEffect(r113, this, (Function1) r116, r102, r107);
        r102.endReplaceGroup();
    L55:
        r102.endReplaceGroup();
    L58:
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventEnd();
        goto L61
    L51:
        if (r116 != r112.getEmpty()) goto L53;
    L54:
        r102.startReplaceGroup(467771457);
        r102.endReplaceGroup();
        goto L55
    L38:
        if (r109 != Composer.Companion.getEmpty()) goto L41;
    L34:
        r108 = false;
        goto L35
    L56:
        r102.startReplaceGroup(467781377);
        r102.endReplaceGroup();
        goto L58
    L23:
        r105 = false;
        goto L25
    L16:
        if (r102.changed(this) == false) goto L18;
        int r117 = 32;
    L19:
        r103 = r103 | r117;
        goto L20
    L18:
        r117 = 16;
        goto L19
    L5:
        if ((r110 & 8) != 0) goto L7;
        boolean r118 = r102.changed(r100);
    L8:
        if (r118 == false) goto L10;
        int r119 = 4;
    L11:
        r103 = r119 | r110;
        goto L14
    L10:
        r119 = 2;
        goto L11
    L7:
        r118 = r102.changedInstance(r100);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void seek(S r100, S r101, long r102) {
        setStartTimeNanos$animation_core(Long.MIN_VALUE);
        int r103 = 0;
        this.transitionState.setRunning$animation_core(false);
        if (isSeeking() == false) goto L9;
        if (Intrinsics.areEqual(getCurrentState(), r100) == false) goto L9;
        if (Intrinsics.areEqual(getTargetState(), r101) == false) goto L9;
    L14:
        SnapshotStateList<Transition<?>> r104 = this._transitions;
        int r105 = r104.size();
        int r106 = 0;
    L15:
        if (r106 >= r105) goto L20;
        Transition r107 = (Transition) ListProtector.get(r104, r106);
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Any>");
        if (r107.isSeeking() == false) goto L19;
        r107.seek(r107.getCurrentState(), r107.getTargetState(), r102);
    L19:
        r106 = r106 + 1;
        goto L15
    L20:
        SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> r108 = this._animations;
        int r109 = r108.size();
    L21:
        if (r103 >= r109) goto L23;
        ((TransitionAnimationState) ListProtector.get(r108, r103)).seekTo$animation_core(r102);
        r103 = r103 + 1;
        goto L21
    L23:
        this.lastSeekedTimeNanos = r102;
        return;
    L9:
        if (Intrinsics.areEqual(getCurrentState(), r100) == true) goto L13;
        TransitionState<S> r110 = this.transitionState;
        if ((r110 instanceof MutableTransitionState) == false) goto L13;
        ((MutableTransitionState) r110).setCurrentState$animation_core(r100);
    L13:
        setTargetState$animation_core(r101);
        setSeeking$animation_core(true);
        setSegment(new SegmentImpl(r100, r101));
        goto L14
    }

    public /* synthetic */ Transition(MutableTransitionState r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }

    public /* synthetic */ Transition(TransitionState r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }

    public /* synthetic */ Transition(TransitionState r100, Transition r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
