package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.material3.internal.DraggableAnchorsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n*\u0001n\b\u0007\u0018\u0000 \u0082\u0001*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0082\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\u0004\u0010\bB\u0083\u0001\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\n\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012\u0012#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0004\b\u0004\u0010\u0016B4\b\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012!\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0004\b\u0004\u0010\u0017BD\b\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\n¢\u0006\u0004\b\u0004\u0010\u0018J\u0006\u0010N\u001a\u00020\u000bJ\u001d\u0010P\u001a\u00020\u000b2\u0006\u0010Q\u001a\u00028\u00002\u0006\u0010R\u001a\u00028\u0000H\u0007¢\u0006\u0002\u0010SJ#\u0010d\u001a\u00020e2\f\u0010f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\b\b\u0002\u0010g\u001a\u00028\u0000¢\u0006\u0002\u0010hJ\u001c\u0010i\u001a\u00020e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0086@¢\u0006\u0002\u0010jJ\u0016\u0010i\u001a\u00020\u000b2\u0006\u0010k\u001a\u00020\u000bH\u0087@¢\u0006\u0002\u0010lJ\\\u0010p\u001a\u00020e2\b\b\u0002\u0010q\u001a\u00020r2B\u0010s\u001a>\b\u0001\u0012\u0004\u0012\u00020u\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0v\u0012\u0006\u0012\u0004\u0018\u00010\u00020t¢\u0006\u0002\bwH\u0086@¢\u0006\u0002\u0010xJy\u0010p\u001a\u00020e2\u0006\u0010C\u001a\u00028\u00002\b\b\u0002\u0010q\u001a\u00020r2W\u0010s\u001aS\b\u0001\u0012\u0004\u0012\u00020u\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(z\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(C\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0v\u0012\u0006\u0012\u0004\u0018\u00010\u00020y¢\u0006\u0002\bwH\u0086@¢\u0006\u0002\u0010{J\u0015\u0010|\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u000bH\u0000¢\u0006\u0002\b~J\u000e\u0010\u007f\u001a\u00020\u000b2\u0006\u0010}\u001a\u00020\u000bJ\u0017\u0010\u0080\u0001\u001a\u00020\u00152\u0006\u0010C\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010\u0081\u0001R5\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR5\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000b0\nX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R8\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00122\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00128\u0006@@X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R8\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0+2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0+8\u0006@@X\u0087.¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010&\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u00158@X\u0080\u0004¢\u0006\f\u0012\u0004\b3\u0010&\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R+\u00109\u001a\u00028\u00002\u0006\u00108\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010\u0005R+\u0010?\u001a\u00028\u00002\u0006\u00108\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bB\u0010>\u001a\u0004\b@\u0010;\"\u0004\bA\u0010\u0005R\u001b\u0010C\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bD\u0010;R+\u0010G\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0011\u0010O\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\bO\u00105R!\u0010P\u001a\u00020\u000b8GX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\bV\u0010F\u0012\u0004\bT\u0010&\u001a\u0004\bU\u0010IR+\u0010W\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bZ\u0010M\u001a\u0004\bX\u0010I\"\u0004\bY\u0010KR/\u0010[\u001a\u0004\u0018\u00018\u00002\b\u00108\u001a\u0004\u0018\u00018\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b^\u0010>\u001a\u0004\b\\\u0010;\"\u0004\b]\u0010\u0005R7\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bc\u0010>\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0010\u0010m\u001a\u00020nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010o¨\u0006\u0083\u0001"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialValue", "<init>", "(Ljava/lang/Object;)V", "anchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;)V", "positionalThreshold", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "totalDistance", "velocityThreshold", "Lkotlin/Function0;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmValueChange", "newValue", "", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "(Ljava/lang/Object;Landroidx/compose/foundation/gestures/DraggableAnchors;Lkotlin/jvm/functions/Function1;)V", "getConfirmValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setConfirmValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "getPositionalThreshold$foundation_release", "setPositionalThreshold$foundation_release", "getVelocityThreshold$foundation_release", "()Lkotlin/jvm/functions/Function0;", "setVelocityThreshold$foundation_release", "(Lkotlin/jvm/functions/Function0;)V", "value", "snapAnimationSpec", "getSnapAnimationSpec$annotations", "()V", "getSnapAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "setSnapAnimationSpec$foundation_release", "(Landroidx/compose/animation/core/AnimationSpec;)V", "Landroidx/compose/animation/core/DecayAnimationSpec;", "decayAnimationSpec", "getDecayAnimationSpec$annotations", "getDecayAnimationSpec", "()Landroidx/compose/animation/core/DecayAnimationSpec;", "setDecayAnimationSpec$foundation_release", "(Landroidx/compose/animation/core/DecayAnimationSpec;)V", "usePreModifierChangeBehavior", "getUsePreModifierChangeBehavior$foundation_release$annotations", "getUsePreModifierChangeBehavior$foundation_release", "()Z", "dragMutex", "Landroidx/compose/foundation/MutatorMutex;", "<set-?>", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "currentValue$delegate", "Landroidx/compose/runtime/MutableState;", "settledValue", "getSettledValue", "setSettledValue", "settledValue$delegate", "targetValue", "getTargetValue", "targetValue$delegate", "Landroidx/compose/runtime/State;", "offset", "getOffset", "()F", "setOffset", "(F)V", "offset$delegate", "Landroidx/compose/runtime/MutableFloatState;", "requireOffset", "isAnimationRunning", "progress", "from", RemoteMessageConst.TO, "(Ljava/lang/Object;Ljava/lang/Object;)F", "getProgress$annotations", "getProgress", "progress$delegate", "lastVelocity", "getLastVelocity", "setLastVelocity", "lastVelocity$delegate", "dragTarget", "getDragTarget", "setDragTarget", "dragTarget$delegate", "getAnchors", "()Landroidx/compose/foundation/gestures/DraggableAnchors;", "setAnchors", "(Landroidx/compose/foundation/gestures/DraggableAnchors;)V", "anchors$delegate", "updateAnchors", "", "newAnchors", "newTarget", "(Landroidx/compose/foundation/gestures/DraggableAnchors;Ljava/lang/Object;)V", "settle", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "velocity", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchoredDragScope", "androidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1", "Landroidx/compose/foundation/gestures/AnchoredDraggableState$anchoredDragScope$1;", "anchoredDrag", "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function3;", "Landroidx/compose/foundation/gestures/AnchoredDragScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function4;", "anchor", "(Ljava/lang/Object;Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newOffsetForDelta", "delta", "newOffsetForDelta$foundation_release", "dispatchRawDelta", "trySnapTo", "(Ljava/lang/Object;)Z", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnchoredDraggableState<T> {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final AnchoredDraggableState$anchoredDragScope$1 anchoredDragScope;
    private final MutableState anchors$delegate;
    private Function1<? super T, Boolean> confirmValueChange;
    private final MutableState currentValue$delegate;
    public DecayAnimationSpec<Float> decayAnimationSpec;
    private final MutatorMutex dragMutex;
    private final MutableState dragTarget$delegate;
    private final MutableFloatState lastVelocity$delegate;
    private final MutableFloatState offset$delegate;
    public Function1<? super Float, Float> positionalThreshold;
    private final State progress$delegate;
    private final MutableState settledValue$delegate;
    public AnimationSpec<Float> snapAnimationSpec;
    private final State targetValue$delegate;
    public Function0<Float> velocityThreshold;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u0001J:\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u00012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\n0\tH\u0007J\u0087\u0001\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\n0\tH\u0007¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", ExifInterface.GPS_DIRECTION_TRUE, "confirmValueChange", "Lkotlin/Function1;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "positionalThreshold", "Lkotlin/ParameterName;", "name", "distance", "velocityThreshold", "Lkotlin/Function0;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private static final boolean Saver$lambda$2(Object r100) {
            return true;
        }

        private static final boolean Saver$lambda$5(Object r100) {
            return true;
        }

        public static /* synthetic */ Object a(SaverScope r100, AnchoredDraggableState r101) {
            return Saver$lambda$0(r100, r101);
        }

        public static /* synthetic */ AnchoredDraggableState b(Function1 r100, Object r101) {
            return Saver$lambda$4(r100, r101);
        }

        public static /* synthetic */ boolean c(Object r100) {
            return Saver$lambda$2(r100);
        }

        public static /* synthetic */ boolean d(Object r100) {
            return Saver$lambda$5(r100);
        }

        public static /* synthetic */ AnchoredDraggableState e(Function1 r100, Function0 r101, AnimationSpec r102, DecayAnimationSpec r103, Function1 r104, Object r105) {
            return Saver$lambda$7(r100, r101, r102, r103, r104, r105);
        }

        public static /* synthetic */ Object f(SaverScope r100, AnchoredDraggableState r101) {
            return Saver$lambda$3(r100, r101);
        }

        public static /* synthetic */ AnchoredDraggableState g(Object r100) {
            return Saver$lambda$1(r100);
        }

        public static /* synthetic */ Object h(SaverScope r100, AnchoredDraggableState r101) {
            return Saver$lambda$6(r100, r101);
        }

        public final <T> Saver<AnchoredDraggableState<T>, T> Saver() {
            return SaverKt.Saver(new r(), new s());
        }

        private static final AnchoredDraggableState Saver$lambda$1(Object r100) {
            return new AnchoredDraggableState(r100);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = DraggableAnchorsKt.ConfirmValueChangeDeprecated)
        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(final Function1<? super T, Boolean> r100) {
            return SaverKt.Saver(new p(), new q(r100));
        }

        private static final Object Saver$lambda$0(SaverScope r100, AnchoredDraggableState r101) {
            return r101.getCurrentValue();
        }

        private static final Object Saver$lambda$3(SaverScope r100, AnchoredDraggableState r101) {
            return r101.getCurrentValue();
        }

        private static final AnchoredDraggableState Saver$lambda$4(Function1 r100, Object r101) {
            return new AnchoredDraggableState(r101, r100);
        }

        private static final Object Saver$lambda$6(SaverScope r100, AnchoredDraggableState r101) {
            return r101.getCurrentValue();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Saver Saver$default(Companion r100, Function1 r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = new t();
        L6:
            return r100.Saver(r101);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.")
        public final <T> Saver<AnchoredDraggableState<T>, T> Saver(final AnimationSpec<Float> r100, final DecayAnimationSpec<Float> r110, final Function1<? super Float, Float> r111, final Function0<Float> r112, final Function1<? super T, Boolean> r113) {
            return SaverKt.Saver(new u(), new v(r111, r112, r100, r110, r113));
        }

        private static final AnchoredDraggableState Saver$lambda$7(Function1 r100, Function0 r101, AnimationSpec r102, DecayAnimationSpec r103, Function1 r110, Object r111) {
            return AnchoredDraggableKt.AnchoredDraggableState(r111, r100, r101, r102, r103, r110);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Saver Saver$default(Companion r100, AnimationSpec r101, DecayAnimationSpec r102, Function1 r103, Function0 r110, Function1 r111, int r112, Object r113) {
            if ((r112 & 16) == 0) goto L6;
            r111 = new w();
        L6:
            return r100.Saver(r101, r102, r103, r110, r111);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2", f = "AnchoredDraggable.kt", i = {}, l = {1142}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> $block;
        int label;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "latestAnchors", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$2$2", f = "AnchoredDraggable.kt", i = {}, l = {1143}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01102 extends SuspendLambda implements Function2<DraggableAnchors<T>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> $block;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public C01102(Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> r100, AnchoredDraggableState<T> r101, Continuation<? super C01102> r102) {
                this.$block = r100;
                this.this$0 = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                C01102 r102 = new C01102(this.$block, this.this$0, r101);
                r102.L$0 = r100;
                return r102;
            }

            public final Object invoke(DraggableAnchors<T> r100, Continuation<? super Unit> r101) {
                return ((C01102) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
                return invoke((DraggableAnchors) r100, r101);
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
                DraggableAnchors<T> r103 = (DraggableAnchors) this.L$0;
                Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> r104 = this.$block;
                AnchoredDraggableState$anchoredDragScope$1 r105 = AnchoredDraggableState.access$getAnchoredDragScope$p(this.this$0);
                this.label = 1;
                if (r104.invoke(r105, r103, this) != r101) goto L12;
                return r101;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(AnchoredDraggableState<T> r100, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super AnonymousClass2> r102) {
            this.this$0 = r100;
            this.$block = r101;
            super(1, r102);
        }

        public static /* synthetic */ DraggableAnchors a(AnchoredDraggableState r100) {
            return invokeSuspend$lambda$0(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass2(this.this$0, this.$block, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((AnonymousClass2) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        private static final DraggableAnchors invokeSuspend$lambda$0(AnchoredDraggableState r100) {
            return r100.getAnchors();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            boolean r103 = true;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            T r104 = this.this$0.getAnchors().closestAnchor(this.this$0.getOffset());
            if (r104 == null) goto L22;
            float r105 = this.this$0.getAnchors().positionOf(r104);
            if (Math.abs(this.this$0.getOffset() - r105) < 0.5f) goto L17;
            r103 = false;
        L17:
            if (r103 == false) goto L22;
            if (this.this$0.getConfirmValueChange$foundation_release().invoke(r104).booleanValue() == false) goto L22;
            AnchoredDraggableState.access$setSettledValue(this.this$0, r104);
            AnchoredDraggableState.access$setCurrentValue(this.this$0, r104);
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            final AnchoredDraggableState<T> r106 = this.this$0;
            Function0 r107 = new x(r106);
            C01102 r108 = new C01102(this.$block, r106, null);
            this.label = 1;
            if (AnchoredDraggableKt.access$restartable(r107, r108, this) != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState", f = "AnchoredDraggable.kt", i = {}, l = {1187}, m = "anchoredDrag", n = {}, s = {})
    public static final class AnonymousClass3 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        public AnonymousClass3(AnchoredDraggableState<T> r100, Continuation<? super AnonymousClass3> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.anchoredDrag(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4", f = "AnchoredDraggable.kt", i = {}, l = {1189}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ T $targetValue;
        int label;
        final /* synthetic */ AnchoredDraggableState<T> this$0;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0018\u0010\u0003\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0004\u0012\u0002H\u00020\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "<destruct>", "Lkotlin/Pair;", "Landroidx/compose/foundation/gestures/DraggableAnchors;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4$2", f = "AnchoredDraggable.kt", i = {}, l = {1191}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<Pair<? extends DraggableAnchors<T>, ? extends T>, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function4<AnchoredDragScope, DraggableAnchors<T>, T, Continuation<? super Unit>, Object> $block;
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnchoredDraggableState<T> this$0;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r100, AnchoredDraggableState<T> r101, Continuation<? super AnonymousClass2> r102) {
                this.$block = r100;
                this.this$0 = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                AnonymousClass2 r102 = new AnonymousClass2(this.$block, this.this$0, r101);
                r102.L$0 = r100;
                return r102;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Unit> r101) {
                return invoke((Pair) r100, r101);
            }

            public final Object invoke(Pair<? extends DraggableAnchors<T>, ? extends T> r100, Continuation<? super Unit> r101) {
                return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDrag$4$2 for r5v1 'this'  java.lang.Object
                	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
                	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
                	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
                	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
                	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
                */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = r5.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                kotlin.ResultKt.throwOnFailure(r6);
            L11:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE;
                return r6;
            L6:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw r6;
            L8:
                kotlin.ResultKt.throwOnFailure(r6);
                java.lang.Object r6 = r5.L$0;
                kotlin.Pair r6 = (kotlin.Pair) r6;
                java.lang.Object r1 = r6.component1();
                androidx.compose.foundation.gestures.DraggableAnchors<T> r1 = (androidx.compose.foundation.gestures.DraggableAnchors) r1;
                java.lang.Object r6 = r6.component2();
                kotlin.jvm.functions.Function4<androidx.compose.foundation.gestures.AnchoredDragScope, androidx.compose.foundation.gestures.DraggableAnchors<T>, T, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r3 = r5.$block;
                androidx.compose.foundation.gestures.AnchoredDraggableState<T> r4 = r5.this$0;
                androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1 r4 = androidx.compose.foundation.gestures.AnchoredDraggableState.access$getAnchoredDragScope$p(r4);
                r5.label = 1;
                androidx.compose.foundation.gestures.AnchoredDraggableState$anchoredDragScope$1 r4 = r4;
                androidx.compose.foundation.gestures.DraggableAnchors<T> r1 = r1;
                T r6 = (T) r6;
                java.lang.Object r5 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r5;
                java.lang.Object r6 = r3.invoke(r4, r1, r6, r5);
                if (r6 != r0) goto L11;
                return r0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(AnchoredDraggableState<T> r100, T r101, Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r102, Continuation<? super AnonymousClass4> r103) {
            this.this$0 = r100;
            this.$targetValue = r101;
            this.$block = r102;
            super(1, r103);
        }

        public static /* synthetic */ Pair a(AnchoredDraggableState r100) {
            return invokeSuspend$lambda$0(r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass4(this.this$0, this.$targetValue, this.$block, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((AnonymousClass4) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        private static final Pair invokeSuspend$lambda$0(AnchoredDraggableState r100) {
            return TuplesKt.to(r100.getAnchors(), r100.getTargetValue());
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            if (this.this$0.getConfirmValueChange$foundation_release().invoke(this.$targetValue).booleanValue() == false) goto L15;
            float r103 = this.this$0.getAnchors().positionOf(this.$targetValue);
            AnchoredDraggableState.access$getAnchoredDragScope$p(this.this$0).dragTo(r103, this.this$0.getLastVelocity());
            AnchoredDraggableState.access$setSettledValue(this.this$0, this.$targetValue);
            AnchoredDraggableState.access$setCurrentValue(this.this$0, this.$targetValue);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            AnchoredDraggableState.access$setDragTarget(this.this$0, this.$targetValue);
            final AnchoredDraggableState<T> r104 = this.this$0;
            Function0 r105 = new y(r104);
            AnonymousClass2 r106 = new AnonymousClass2(this.$block, r104, null);
            this.label = 1;
            if (AnchoredDraggableKt.access$restartable(r105, r106, this) != r101) goto L12;
            return r101;
        }
    }

    static {
        Companion = new Companion(null);
    }

    private static final boolean _init_$lambda$0(Object r100) {
        return true;
    }

    private static final boolean _init_$lambda$1(Object r100) {
        return true;
    }

    public static /* synthetic */ boolean a(Object r100) {
        return _init_$lambda$1(r100);
    }

    public static /* synthetic */ Object b(AnchoredDraggableState r100) {
        return targetValue_delegate$lambda$4(r100);
    }

    public static /* synthetic */ float c(AnchoredDraggableState r100) {
        return progress_delegate$lambda$6(r100);
    }

    private static final boolean confirmValueChange$lambda$2(Object r100) {
        return true;
    }

    public static /* synthetic */ boolean d(Object r100) {
        return _init_$lambda$0(r100);
    }

    public static /* synthetic */ boolean e(Object r100) {
        return confirmValueChange$lambda$2(r100);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.")
    public static /* synthetic */ void getDecayAnimationSpec$annotations() {
    }

    @Deprecated(message = "Use the progress function to query the progress between two specified anchors.", replaceWith = @ReplaceWith(expression = "progress(state.settledValue, state.targetValue)", imports = {}))
    public static /* synthetic */ void getProgress$annotations() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "This constructor of AnchoredDraggableState has been deprecated. Please pass thresholds and animation specs to AnchoredDraggableDefaults.flingBehavior(..) instead, which can be passed to Modifier.anchoredDraggable.")
    public static /* synthetic */ void getSnapAnimationSpec$annotations() {
    }

    public static /* synthetic */ void getUsePreModifierChangeBehavior$foundation_release$annotations() {
    }

    private final T getDragTarget() {
        return this.dragTarget$delegate.getValue();
    }

    public final DraggableAnchors<T> getAnchors() {
        return (DraggableAnchors) this.anchors$delegate.getValue();
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final DecayAnimationSpec<Float> getDecayAnimationSpec() {
        DecayAnimationSpec<Float> r100 = this.decayAnimationSpec;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("decayAnimationSpec");
        return null;
    }

    public final float getLastVelocity() {
        return this.lastVelocity$delegate.getFloatValue();
    }

    public final float getOffset() {
        return this.offset$delegate.getFloatValue();
    }

    public final Function1<Float, Float> getPositionalThreshold$foundation_release() {
        Function1 r100 = this.positionalThreshold;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("positionalThreshold");
        return null;
    }

    public final float getProgress() {
        return ((Number) this.progress$delegate.getValue()).floatValue();
    }

    public final T getSettledValue() {
        return this.settledValue$delegate.getValue();
    }

    public final AnimationSpec<Float> getSnapAnimationSpec() {
        AnimationSpec<Float> r100 = this.snapAnimationSpec;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("snapAnimationSpec");
        return null;
    }

    public final T getTargetValue() {
        return (T) this.targetValue$delegate.getValue();
    }

    public final boolean getUsePreModifierChangeBehavior$foundation_release() {
        if (this.positionalThreshold != null) goto L5;
    L11:
        return false;
    L5:
        if (this.velocityThreshold == null) goto L11;
        if (this.snapAnimationSpec == null) goto L11;
        if (this.decayAnimationSpec == null) goto L11;
        return true;
    }

    public final Function0<Float> getVelocityThreshold$foundation_release() {
        Function0<Float> r100 = this.velocityThreshold;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("velocityThreshold");
        return null;
    }

    public final boolean isAnimationRunning() {
        if (getDragTarget() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final float requireOffset() {
        if ((!Float.isNaN(getOffset())) == true) goto L6;
        InlineClassHelperKt.throwIllegalStateException("The offset was read before being initialized. Did you access the offset in a phase before layout, like effects or composition?");
    L6:
        return getOffset();
    }

    public final Function1<T, Boolean> getConfirmValueChange$foundation_release() {
        return this.confirmValueChange;
    }

    public AnchoredDraggableState(T r100) {
        this.confirmValueChange = new k();
        this.dragMutex = new MutatorMutex();
        this.currentValue$delegate = SnapshotStateKt.mutableStateOf$default(r100, null, 2, null);
        this.settledValue$delegate = SnapshotStateKt.mutableStateOf$default(r100, null, 2, null);
        this.targetValue$delegate = SnapshotStateKt.derivedStateOf(new l(this));
        this.offset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(Float.NaN);
        this.progress$delegate = SnapshotStateKt.derivedStateOf(SnapshotStateKt.structuralEqualityPolicy(), new m(this));
        this.lastVelocity$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.dragTarget$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors$delegate = SnapshotStateKt.mutableStateOf$default(AnchoredDraggableKt.access$emptyDraggableAnchors(), null, 2, null);
        this.anchoredDragScope = new AnchoredDraggableState$anchoredDragScope$1(this);
    }

    public static final /* synthetic */ AnchoredDraggableState$anchoredDragScope$1 access$getAnchoredDragScope$p(AnchoredDraggableState r100) {
        return r100.anchoredDragScope;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final float progress_delegate$lambda$6(AnchoredDraggableState r100) {
        float r101 = r100.getAnchors().positionOf(r100.getSettledValue());
        float r102 = r100.getAnchors().positionOf(r100.getTargetValue()) - r101;
        float r103 = Math.abs(r102);
        if (Float.isNaN(r103) == false) goto L5;
        return 1.0f;
    L5:
        if (r103 <= 1.0E-6f) goto L15;
        float r104 = (r100.requireOffset() - r101) / r102;
        if (r104 >= 1.0E-6f) goto L10;
        return 0.0f;
    L10:
        if (r104 <= 0.999999f) goto L13;
        return 1.0f;
    L13:
        return r104;
    L15:
        return 1.0f;
    }

    private final void setAnchors(DraggableAnchors<T> r100) {
        this.anchors$delegate.setValue(r100);
    }

    private final void setCurrentValue(T r100) {
        this.currentValue$delegate.setValue(r100);
    }

    private final void setDragTarget(T r100) {
        this.dragTarget$delegate.setValue(r100);
    }

    private final void setLastVelocity(float r100) {
        this.lastVelocity$delegate.setFloatValue(r100);
    }

    private final void setOffset(float r100) {
        this.offset$delegate.setFloatValue(r100);
    }

    private final void setSettledValue(T r100) {
        this.settledValue$delegate.setValue(r100);
    }

    private static final Object targetValue_delegate$lambda$4(AnchoredDraggableState r100) {
        Object r101 = r100.getDragTarget();
        if (r101 == null) goto L5;
        return r101;
    L5:
        if (Float.isNaN(r100.getOffset()) == true) goto L9;
        T r102 = r100.getAnchors().closestAnchor(r100.getOffset());
        if (r102 != null) goto L13;
        Object r103 = r100.getCurrentValue();
    L11:
        return r103;
    L13:
        return r102;
    L9:
        r103 = r100.getCurrentValue();
        goto L11
    }

    private final boolean trySnapTo(T r100) {
        MutatorMutex r101 = this.dragMutex;
        boolean r102 = r101.tryLock();
        if (r102 == true) goto L13;
    L12:
        return r102;
    L13:
        AnchoredDraggableState$anchoredDragScope$1 r103 = this.anchoredDragScope;     // Catch: Throwable -> L9
        float r104 = getAnchors().positionOf(r100);     // Catch: Throwable -> L9
        if (Float.isNaN(r104) == true) goto L7;
        AnchoredDragScope.CC.dragTo$default(r103, r104, 0.0f, 2, null);     // Catch: Throwable -> L9
        setDragTarget(null);     // Catch: Throwable -> L9
    L7:
        setCurrentValue(r100);     // Catch: Throwable -> L9
        setSettledValue(r100);     // Catch: Throwable -> L9
        r101.unlock();
    L9:
        th = move-exception;
        r101.unlock();
        throw th;
    }

    public final float dispatchRawDelta(float r100) {
        float r101 = newOffsetForDelta$foundation_release(r100);
        float r102 = r101 - requireOffset();
        AnchoredDragScope.CC.dragTo$default(this.anchoredDragScope, r101, 0.0f, 2, null);
        return r102;
    }

    public final float newOffsetForDelta$foundation_release(float r100) {
        if (Float.isNaN(getOffset()) == false) goto L5;
        float r101 = 0.0f;
    L7:
        return RangesKt.coerceIn(r101 + r100, getAnchors().minPosition(), getAnchors().maxPosition());
    L5:
        r101 = getOffset();
        goto L7
    }

    public final void setConfirmValueChange$foundation_release(Function1<? super T, Boolean> r100) {
        this.confirmValueChange = r100;
    }

    public final void setDecayAnimationSpec$foundation_release(DecayAnimationSpec<Float> r100) {
        this.decayAnimationSpec = r100;
    }

    public final void setPositionalThreshold$foundation_release(Function1<? super Float, Float> r100) {
        this.positionalThreshold = r100;
    }

    public final void setSnapAnimationSpec$foundation_release(AnimationSpec<Float> r100) {
        this.snapAnimationSpec = r100;
    }

    public final void setVelocityThreshold$foundation_release(Function0<Float> r100) {
        this.velocityThreshold = r100;
    }

    public AnchoredDraggableState(T r100, DraggableAnchors<T> r101) {
        this(r100);
        setAnchors(r101);
        trySnapTo(r100);
    }

    public static final /* synthetic */ void access$setCurrentValue(AnchoredDraggableState r100, Object r101) {
        r100.setCurrentValue(r101);
    }

    public static final /* synthetic */ void access$setDragTarget(AnchoredDraggableState r100, Object r101) {
        r100.setDragTarget(r101);
    }

    public static final /* synthetic */ void access$setLastVelocity(AnchoredDraggableState r100, float r101) {
        r100.setLastVelocity(r101);
    }

    public static final /* synthetic */ void access$setOffset(AnchoredDraggableState r100, float r101) {
        r100.setOffset(r101);
    }

    public static final /* synthetic */ void access$setSettledValue(AnchoredDraggableState r100, Object r101) {
        r100.setSettledValue(r101);
    }

    public final float progress(T r100, T r101) {
        float r102 = getAnchors().positionOf(r100);
        float r103 = getAnchors().positionOf(r101);
        float r104 = (RangesKt.coerceIn(getOffset(), Math.min(r102, r103), Math.max(r102, r103)) - r102) / (r103 - r102);
        if (Float.isNaN(r104) == false) goto L5;
        return 1.0f;
    L5:
        if (r104 >= 1.0E-6f) goto L8;
        return 0.0f;
    L8:
        if (r104 <= 0.999999f) goto L11;
        return 1.0f;
    L11:
        return Math.abs(r104);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "settle does not accept a velocity anymore. Please use FlingBehavior#performFling instead. See AnchoredDraggableSample.kt for example usages.")
    public final Object settle(float r110, Continuation<? super Float> r111) {
        if (getUsePreModifierChangeBehavior$foundation_release() == true) goto L5;
        InlineClassHelperKt.throwIllegalArgumentException("AnchoredDraggableState was configured through a constructor without providing positional and velocity threshold. This overload of settle has been deprecated. Please refer to AnchoredDraggableState#settle(animationSpec) for more information.");
    L5:
        T r100 = getCurrentValue();
        Object r101 = AnchoredDraggableKt.access$computeTarget(getAnchors(), requireOffset(), r110, getPositionalThreshold$foundation_release(), getVelocityThreshold$foundation_release());
        if (this.confirmValueChange.invoke(r101).booleanValue() == false) goto L10;
        return AnchoredDraggableKt.animateToWithDecay$default(this, r101, r110, null, null, r111, 12, null);
    L10:
        return AnchoredDraggableKt.animateToWithDecay$default(this, r100, r110, null, null, r111, 12, null);
    }

    public final void updateAnchors(DraggableAnchors<T> r100, T r101) {
        if (Intrinsics.areEqual(getAnchors(), r100) == true) goto L8;
        setAnchors(r100);
        if (trySnapTo(r101) == true) goto L9;
        setDragTarget(r101);
        return;
    L9:
        return;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = DraggableAnchorsKt.ConfirmValueChangeDeprecated)
    public AnchoredDraggableState(T r100, Function1<? super T, Boolean> r101) {
        this(r100);
        this.confirmValueChange = r101;
    }

    public final Object settle(AnimationSpec<Float> r100, Continuation<? super Unit> r101) {
        T r102 = getCurrentValue();
        T r103 = getAnchors().closestAnchor(requireOffset());
        if (r103 != null) goto L5;
    L11:
        Object r104 = AnchoredDraggableKt.animateTo(this, r102, r100, r101);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r104;
    L15:
        return Unit.INSTANCE;
    L5:
        if (this.confirmValueChange.invoke(r103).booleanValue() == false) goto L11;
        Object r105 = AnchoredDraggableKt.animateTo(this, r103, r100, r101);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r105;
    L10:
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = DraggableAnchorsKt.ConfirmValueChangeDeprecated)
    public AnchoredDraggableState(T r100, DraggableAnchors<T> r101, Function1<? super T, Boolean> r102) {
        this(r100, r102);
        setAnchors(r101);
        trySnapTo(r100);
    }

    public final Object anchoredDrag(MutatePriority r100, Function3<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        Object r103 = this.dragMutex.mutate(r100, new AnonymousClass2(this, r101, null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public final Object anchoredDrag(T r100, MutatePriority r101, Function4<? super AnchoredDragScope, ? super DraggableAnchors<T>, ? super T, ? super Continuation<? super Unit>, ? extends Object> r102, Continuation<? super Unit> r103) {
        if ((r103 instanceof AnonymousClass3) == false) goto L7;
        AnonymousClass3 r104 = (AnonymousClass3) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L17;
        if (r108 != 1) goto L16;
        ResultKt.throwOnFailure(r106);     // Catch: Throwable -> L13
    L22:
        setDragTarget(null);
    L29:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r106);
        if (getAnchors().hasPositionFor(r100) == false) goto L26;
        MutatorMutex r109 = this.dragMutex;     // Catch: Throwable -> L13
        AnonymousClass4 r110 = new AnonymousClass4(this, r100, r102, null);     // Catch: Throwable -> L13
        r104.label = 1;     // Catch: Throwable -> L13
        if (r109.mutate(r101, r110, r104) != r107) goto L22;
        return r107;
    L26:
        if (this.confirmValueChange.invoke(r100).booleanValue() == false) goto L29;
        setSettledValue(r100);
        setCurrentValue(r100);
    L13:
        th = move-exception;
        setDragTarget(null);
        throw th;
    L7:
        r104 = new AnonymousClass3(this, r103);
        goto L8
    }

    public /* synthetic */ AnchoredDraggableState(Object r100, DraggableAnchors r101, Function1 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = new o();
    L5:
        this(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateAnchors$default(AnchoredDraggableState r100, DraggableAnchors r101, Object r102, int r103, Object r104) {
        if ((r103 & 2) != 0) goto L5;
    L10:
        r100.updateAnchors(r101, r102);
        return;
    L5:
        if (Float.isNaN(r100.getOffset()) == true) goto L9;
        r102 = r101.closestAnchor(r100.getOffset());
        if (r102 != null) goto L10;
        r102 = r100.getTargetValue();
        goto L10
    L9:
        r102 = r100.getTargetValue();
        goto L10
    }

    public AnchoredDraggableState(T r100, DraggableAnchors<T> r101, Function1<? super Float, Float> r102, Function0<Float> r103, AnimationSpec<Float> r104, Function1<? super T, Boolean> r105) {
        this(r100, r105);
        setAnchors(r101);
        setPositionalThreshold$foundation_release(r102);
        setVelocityThreshold$foundation_release(r103);
        setSnapAnimationSpec$foundation_release(r104);
        setDecayAnimationSpec$foundation_release(AnchoredDraggableKt.access$getNoOpDecayAnimationSpec$p());
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState r100, MutatePriority r101, Function3 r102, Continuation r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = MutatePriority.Default;
    L6:
        return r100.anchoredDrag(r101, r102, r103);
    }

    public static /* synthetic */ Object anchoredDrag$default(AnchoredDraggableState r100, Object r101, MutatePriority r102, Function4 r103, Continuation r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = MutatePriority.Default;
    L6:
        return r100.anchoredDrag(r101, r102, r103, r104);
    }

    public /* synthetic */ AnchoredDraggableState(Object r100, DraggableAnchors r101, Function1 r110, Function0 r111, AnimationSpec r112, Function1 r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 32) == 0) goto L5;
        r113 = new n();
    L5:
        this(r100, r101, r110, r111, r112, r113);
    }
}
