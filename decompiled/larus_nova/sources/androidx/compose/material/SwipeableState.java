package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0017\u0018\u0000 w*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001wBD\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012#\b\u0002\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b¢\u0006\u0004\b\r\u0010\u000eJ!\u0010=\u001a\u00020>2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000,H\u0000¢\u0006\u0002\b@J8\u0010A\u001a\u00020>2\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000,2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000,H\u0080@¢\u0006\u0004\bC\u0010DJ\u0016\u0010\\\u001a\u00020>2\u0006\u0010]\u001a\u00020\u0006H\u0082@¢\u0006\u0002\u0010^J$\u0010_\u001a\u00020>2\u0006\u0010]\u001a\u00020\u00062\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082@¢\u0006\u0002\u0010aJ\u0016\u0010n\u001a\u00020>2\u0006\u0010b\u001a\u00028\u0000H\u0087@¢\u0006\u0002\u0010oJ&\u0010p\u001a\u00020>2\u0006\u0010b\u001a\u00028\u00002\u000e\b\u0002\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0087@¢\u0006\u0002\u0010rJ\u0016\u0010s\u001a\u00020>2\u0006\u0010t\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010^J\u000e\u0010u\u001a\u00020\u00062\u0006\u0010v\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R/\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R+\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00008F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R+\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060!8F¢\u0006\u0006\u001a\u0004\b%\u0010#R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060+X\u0082\u0004¢\u0006\u0002\n\u0000RC\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000,2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000,8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b2\u0010\u001a\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R \u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00028\u00000,04X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u00107\"\u0004\b<\u00109RO\u0010F\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060E2\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060E8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010\u001a\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR+\u0010L\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bM\u00107\"\u0004\bN\u00109R/\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010\u0013\u001a\u0004\u0018\u00010Q8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bW\u0010\u001a\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020YX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u001a\u0010b\u001a\u00028\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\bc\u0010d\u001a\u0004\be\u0010\u0016R \u0010f\u001a\b\u0012\u0004\u0012\u00028\u00000g8FX\u0087\u0004¢\u0006\f\u0012\u0004\bh\u0010d\u001a\u0004\bi\u0010jR\u001a\u0010k\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\bl\u0010d\u001a\u0004\bm\u00107¨\u0006x"}, d2 = {"Landroidx/compose/material/SwipeableState;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "newValue", "", "<init>", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;)V", "getAnimationSpec$material", "()Landroidx/compose/animation/core/AnimationSpec;", "getConfirmStateChange$material", "()Lkotlin/jvm/functions/Function1;", "<set-?>", "currentValue", "getCurrentValue", "()Ljava/lang/Object;", "setCurrentValue", "(Ljava/lang/Object;)V", "currentValue$delegate", "Landroidx/compose/runtime/MutableState;", "isAnimationRunning", "()Z", "setAnimationRunning", "(Z)V", "isAnimationRunning$delegate", "offset", "Landroidx/compose/runtime/State;", "getOffset", "()Landroidx/compose/runtime/State;", "overflow", "getOverflow", "offsetState", "Landroidx/compose/runtime/MutableFloatState;", "overflowState", "absoluteOffset", "animationTarget", "Landroidx/compose/runtime/MutableState;", "", "anchors", "getAnchors$material", "()Ljava/util/Map;", "setAnchors$material", "(Ljava/util/Map;)V", "anchors$delegate", "latestNonEmptyAnchorsFlow", "Lkotlinx/coroutines/flow/Flow;", "minBound", "getMinBound$material", "()F", "setMinBound$material", "(F)V", "maxBound", "getMaxBound$material", "setMaxBound$material", "ensureInit", "", "newAnchors", "ensureInit$material", "processNewAnchors", "oldAnchors", "processNewAnchors$material", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function2;", "thresholds", "getThresholds$material", "()Lkotlin/jvm/functions/Function2;", "setThresholds$material", "(Lkotlin/jvm/functions/Function2;)V", "thresholds$delegate", "velocityThreshold", "getVelocityThreshold$material", "setVelocityThreshold$material", "velocityThreshold$delegate", "Landroidx/compose/runtime/MutableFloatState;", "Landroidx/compose/material/ResistanceConfig;", "resistance", "getResistance$material", "()Landroidx/compose/material/ResistanceConfig;", "setResistance$material", "(Landroidx/compose/material/ResistanceConfig;)V", "resistance$delegate", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "getDraggableState$material", "()Landroidx/compose/foundation/gestures/DraggableState;", "snapInternalToOffset", PickerReporterConstants.KEY.TARGET, "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateInternalToOffset", "spec", "(FLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "targetValue", "getTargetValue$annotations", "()V", "getTargetValue", "progress", "Landroidx/compose/material/SwipeProgress;", "getProgress$annotations", "getProgress", "()Landroidx/compose/material/SwipeProgress;", "direction", "getDirection$annotations", "getDirection", "snapTo", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateTo", "anim", "(Ljava/lang/Object;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performFling", "velocity", "performDrag", "delta", "Companion", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class SwipeableState<T> {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final MutableFloatState absoluteOffset;
    private final MutableState anchors$delegate;
    private final AnimationSpec<Float> animationSpec;
    private final MutableState<Float> animationTarget;
    private final Function1<T, Boolean> confirmStateChange;
    private final MutableState currentValue$delegate;
    private final DraggableState draggableState;
    private final MutableState isAnimationRunning$delegate;
    private final Flow<Map<Float, T>> latestNonEmptyAnchorsFlow;
    private float maxBound;
    private float minBound;
    private final MutableFloatState offsetState;
    private final MutableFloatState overflowState;
    private final MutableState resistance$delegate;
    private final MutableState thresholds$delegate;
    private final MutableFloatState velocityThreshold$delegate;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JD\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0006\u0012\u0004\u0012\u0002H\u00070\u0005\"\b\b\u0001\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u00020\r0\f¨\u0006\u000e"}, d2 = {"Landroidx/compose/material/SwipeableState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/SwipeableState;", ExifInterface.GPS_DIRECTION_TRUE, "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "confirmStateChange", "Lkotlin/Function1;", "", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ SwipeableState a(AnimationSpec r100, Function1 r101, Object r102) {
            return Saver$lambda$1(r100, r101, r102);
        }

        public static /* synthetic */ Object b(SaverScope r100, SwipeableState r101) {
            return Saver$lambda$0(r100, r101);
        }

        private static final Object Saver$lambda$0(SaverScope r100, SwipeableState r101) {
            return r101.getCurrentValue();
        }

        public final <T> Saver<SwipeableState<T>, T> Saver(final AnimationSpec<Float> r100, final Function1<? super T, Boolean> r101) {
            return SaverKt.Saver(new pb(), new qb(r100, r101));
        }

        private static final SwipeableState Saver$lambda$1(AnimationSpec r100, Function1 r101, Object r102) {
            return new SwipeableState(r102, r100, r101);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$animateInternalToOffset$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SwipeableState$animateInternalToOffset$2", f = "Swipeable.kt", i = {}, l = {217}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AnimationSpec<Float> $spec;
        final /* synthetic */ float $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SwipeableState<T> this$0;

        public AnonymousClass2(SwipeableState<T> r100, float r101, AnimationSpec<Float> r102, Continuation<? super AnonymousClass2> r103) {
            this.this$0 = r100;
            this.$target = r101;
            this.$spec = r102;
            super(2, r103);
        }

        public static /* synthetic */ Unit a(DragScope r100, Ref.FloatRef r101, Animatable r102) {
            return invokeSuspend$lambda$0(r100, r101, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass2 r102 = new AnonymousClass2(this.this$0, this.$target, this.$spec, r101);
            r102.L$0 = r100;
            return r102;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(DragScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(DragScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L11;
            if (r101 != 1) goto L10;
            ResultKt.throwOnFailure(r110);     // Catch: Throwable -> L7
            Object r102 = r110;
        L15:
            AnimationResult r103 = (AnimationResult) r102;     // Catch: Throwable -> L7
            SwipeableState.access$getAnimationTarget$p(this.this$0).setValue(null);
            SwipeableState.access$setAnimationRunning(this.this$0, false);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r110);
            final DragScope r104 = (DragScope) this.L$0;
            final Ref.FloatRef r105 = new Ref.FloatRef();
            r105.element = SwipeableState.access$getAbsoluteOffset$p(this.this$0).getFloatValue();
            SwipeableState.access$getAnimationTarget$p(this.this$0).setValue(Boxing.boxFloat(this.$target));
            SwipeableState.access$setAnimationRunning(this.this$0, true);
            Animatable r106 = AnimatableKt.Animatable$default(r105.element, 0.0f, 2, null);     // Catch: Throwable -> L7
            Float r107 = Boxing.boxFloat(this.$target);     // Catch: Throwable -> L7
            AnimationSpec<Float> r108 = this.$spec;     // Catch: Throwable -> L7
            Function1 r109 = new rb(r104, r105);     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            r102 = Animatable.animateTo$default(r106, r107, r108, null, r109, this, 4, null);     // Catch: Throwable -> L7
            if (r102 != r100) goto L15;
            return r100;
        L7:
            th = move-exception;
            SwipeableState.access$getAnimationTarget$p(this.this$0).setValue(null);
            SwipeableState.access$setAnimationRunning(this.this$0, false);
            throw th;
        }

        private static final Unit invokeSuspend$lambda$0(DragScope r100, Ref.FloatRef r101, Animatable r102) {
            r100.dragBy(((Number) r102.getValue()).floatValue() - r101.element);
            r101.element = ((Number) r102.getValue()).floatValue();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$animateTo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C86802<T> implements FlowCollector {
        final /* synthetic */ AnimationSpec<Float> $anim;
        final /* synthetic */ T $targetValue;
        final /* synthetic */ SwipeableState<T> this$0;

        public C86802(T r100, SwipeableState<T> r101, AnimationSpec<Float> r102) {
            this.$targetValue = r100;
            this.this$0 = r101;
            this.$anim = r102;
        }

        public final Object emit(Map<Float, ? extends T> r100, Continuation<? super Unit> r101) {
            if ((r101 instanceof SwipeableState$animateTo$2$emit$1) == false) goto L7;
            SwipeableState$animateTo$2$emit$1 r102 = (SwipeableState$animateTo$2$emit$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L16;
            if (r106 != 1) goto L15;
            r100 = (Map) r102.L$0;
            ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L38
        L22:
            float r107 = SwipeableState.access$getAbsoluteOffset$p(this.this$0).getFloatValue();
            LinkedHashMap r108 = new LinkedHashMap();
            Iterator<Map.Entry<Float, ? extends T>> r109 = r100.entrySet().iterator();
        L24:
            if (r109.hasNext() == false) goto L31;
            Map.Entry<Float, ? extends T> r110 = r109.next();
            if (Math.abs(r110.getKey().floatValue() - r107) >= 0.5f) goto L28;
            boolean r111 = true;
        L29:
            if (r111 == false) goto L24;
            r108.put(r110.getKey(), r110.getValue());
            goto L24
        L28:
            r111 = false;
            goto L29
        L31:
            Object r112 = CollectionsKt.firstOrNull(r108.values());
            if (r112 != null) goto L34;
            r112 = this.this$0.getCurrentValue();
        L34:
            SwipeableState.access$setCurrentValue(this.this$0, r112);
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            ResultKt.throwOnFailure(r104);
            Float r113 = SwipeableKt.access$getOffset(r100, this.$targetValue);     // Catch: Throwable -> L38
            if (r113 == null) goto L37;
            SwipeableState<T> r114 = this.this$0;     // Catch: Throwable -> L38
            float r115 = r113.floatValue();     // Catch: Throwable -> L38
            AnimationSpec<Float> r116 = this.$anim;     // Catch: Throwable -> L38
            r102.L$0 = r100;     // Catch: Throwable -> L38
            r102.label = 1;     // Catch: Throwable -> L38
            if (SwipeableState.access$animateInternalToOffset(r114, r115, r116, r102) != r105) goto L22;
            return r105;
        L37:
            throw new IllegalArgumentException("The target value must have an associated anchor.".toString());     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            float r117 = SwipeableState.access$getAbsoluteOffset$p(this.this$0).getFloatValue();
            LinkedHashMap r118 = new LinkedHashMap();
            Iterator<Map.Entry<Float, ? extends T>> r119 = r100.entrySet().iterator();
        L41:
            if (r119.hasNext() == false) goto L48;
            Map.Entry<Float, ? extends T> r120 = r119.next();
            if (Math.abs(r120.getKey().floatValue() - r117) >= 0.5f) goto L45;
            boolean r121 = true;
        L46:
            if (r121 == false) goto L41;
            r118.put(r120.getKey(), r120.getValue());
            goto L41
        L45:
            r121 = false;
            goto L46
        L48:
            Object r122 = CollectionsKt.firstOrNull(r118.values());
            if (r122 != null) goto L51;
            r122 = this.this$0.getCurrentValue();
        L51:
            SwipeableState.access$setCurrentValue(this.this$0, r122);
            throw th;
        L7:
            r102 = new SwipeableState$animateTo$2$emit$1(this, r101);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return emit((Map) r100, r101);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$snapInternalToOffset$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SwipeableState$snapInternalToOffset$2", f = "Swipeable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C86822 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ float $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SwipeableState<T> this$0;

        public C86822(float r100, SwipeableState<T> r101, Continuation<? super C86822> r102) {
            this.$target = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C86822 r102 = new C86822(this.$target, this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(DragScope r100, Continuation<? super Unit> r101) {
            return ((C86822) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(DragScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            ((DragScope) this.L$0).dragBy(this.$target - SwipeableState.access$getAbsoluteOffset$p(this.this$0).getFloatValue());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$snapTo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C86832<T> implements FlowCollector {
        final /* synthetic */ T $targetValue;
        final /* synthetic */ SwipeableState<T> this$0;

        public C86832(T r100, SwipeableState<T> r101) {
            this.$targetValue = r100;
            this.this$0 = r101;
        }

        public final Object emit(Map<Float, ? extends T> r100, Continuation<? super Unit> r101) {
            if ((r101 instanceof SwipeableState$snapTo$2$emit$1) == false) goto L7;
            SwipeableState$snapTo$2$emit$1 r102 = (SwipeableState$snapTo$2$emit$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L14;
            if (r106 != 1) goto L13;
            ResultKt.throwOnFailure(r104);
        L19:
            SwipeableState.access$setCurrentValue(this.this$0, this.$targetValue);
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r104);
            Float r107 = SwipeableKt.access$getOffset(r100, this.$targetValue);
            if (r107 == null) goto L22;
            SwipeableState<T> r108 = this.this$0;
            float r109 = r107.floatValue();
            r102.label = 1;
            if (SwipeableState.access$snapInternalToOffset(r108, r109, r102) != r105) goto L19;
            return r105;
        L22:
            throw new IllegalArgumentException("The target value must have an associated anchor.".toString());
        L7:
            r102 = new SwipeableState$snapTo$2$emit$1(this, r101);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return emit((Map) r100, r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private static final boolean _init_$lambda$0(Object r100) {
        return true;
    }

    public static /* synthetic */ Map a(SwipeableState r100) {
        return latestNonEmptyAnchorsFlow$lambda$1(r100);
    }

    public static /* synthetic */ Unit b(SwipeableState r100, float r101) {
        return draggableState$lambda$8(r100, r101);
    }

    public static /* synthetic */ float c(float r100, float r101) {
        return thresholds_delegate$lambda$7(r100, r101);
    }

    public static /* synthetic */ boolean d(Object r100) {
        return _init_$lambda$0(r100);
    }

    public static /* synthetic */ void getDirection$annotations() {
    }

    public static /* synthetic */ void getProgress$annotations() {
    }

    public static /* synthetic */ void getTargetValue$annotations() {
    }

    private static final float thresholds_delegate$lambda$7(float r100, float r101) {
        return 0.0f;
    }

    public final Map<Float, T> getAnchors$material() {
        return (Map) this.anchors$delegate.getValue();
    }

    public final T getCurrentValue() {
        return this.currentValue$delegate.getValue();
    }

    public final ResistanceConfig getResistance$material() {
        return (ResistanceConfig) this.resistance$delegate.getValue();
    }

    public final T getTargetValue() {
        Float r100 = this.animationTarget.getValue();
        if (r100 == null) goto L5;
        float r101 = r100.floatValue();
    L10:
        T r102 = getAnchors$material().get(Float.valueOf(r101));
        if (r102 == null) goto L13;
        return r102;
    L13:
        return getCurrentValue();
    L5:
        float r103 = getOffset().getValue().floatValue();
        Float r104 = SwipeableKt.access$getOffset(getAnchors$material(), getCurrentValue());
        if (r104 == null) goto L8;
        float r105 = r104.floatValue();
    L9:
        r101 = SwipeableKt.access$computeTarget(r103, r105, getAnchors$material().keySet(), getThresholds$material(), 0.0f, Float.POSITIVE_INFINITY);
        goto L10
    L8:
        r105 = getOffset().getValue().floatValue();
        goto L9
    }

    public final Function2<Float, Float, Float> getThresholds$material() {
        return (Function2) this.thresholds$delegate.getValue();
    }

    public final float getVelocityThreshold$material() {
        return this.velocityThreshold$delegate.getFloatValue();
    }

    public final boolean isAnimationRunning() {
        return ((Boolean) this.isAnimationRunning$delegate.getValue()).booleanValue();
    }

    public final float getDirection() {
        Float r100 = SwipeableKt.access$getOffset(getAnchors$material(), getCurrentValue());
        if (r100 == null) goto L5;
        float r101 = r100.floatValue();
        return Math.signum(getOffset().getValue().floatValue() - r101);
    L5:
        return 0.0f;
    }

    public final SwipeProgress<T> getProgress() {
        List r100 = SwipeableKt.access$findBounds(getOffset().getValue().floatValue(), getAnchors$material().keySet());
        int r101 = r100.size();
        if (r101 != 0) goto L5;
        T r102 = getCurrentValue();
        Object r103 = getCurrentValue();
        Object r104 = r102;
    L13:
        float r105 = 1.0f;
    L15:
        return new SwipeProgress(r104, r103, r105);
    L5:
        if (r101 != 1) goto L7;
        Object r106 = MapsKt.getValue(getAnchors$material(), ListProtector.get(r100, 0));
        r103 = MapsKt.getValue(getAnchors$material(), ListProtector.get(r100, 0));
        r104 = r106;
        goto L13
    L7:
        if (getDirection() <= 0.0f) goto L9;
        Pair r107 = TuplesKt.to(ListProtector.get(r100, 0), ListProtector.get(r100, 1));
    L10:
        float r108 = ((Number) r107.component1()).floatValue();
        float r109 = ((Number) r107.component2()).floatValue();
        r104 = MapsKt.getValue(getAnchors$material(), Float.valueOf(r108));
        r103 = MapsKt.getValue(getAnchors$material(), Float.valueOf(r109));
        r105 = (getOffset().getValue().floatValue() - r108) / (r109 - r108);
        goto L15
    L9:
        r107 = TuplesKt.to(ListProtector.get(r100, 1), ListProtector.get(r100, 0));
        goto L10
    }

    public final AnimationSpec<Float> getAnimationSpec$material() {
        return this.animationSpec;
    }

    public final Function1<T, Boolean> getConfirmStateChange$material() {
        return this.confirmStateChange;
    }

    public final DraggableState getDraggableState$material() {
        return this.draggableState;
    }

    public final float getMaxBound$material() {
        return this.maxBound;
    }

    public final float getMinBound$material() {
        return this.minBound;
    }

    public final State<Float> getOffset() {
        return this.offsetState;
    }

    public final State<Float> getOverflow() {
        return this.overflowState;
    }

    public static final /* synthetic */ MutableFloatState access$getAbsoluteOffset$p(SwipeableState r100) {
        return r100.absoluteOffset;
    }

    public static final /* synthetic */ MutableState access$getAnimationTarget$p(SwipeableState r100) {
        return r100.animationTarget;
    }

    private static final Map latestNonEmptyAnchorsFlow$lambda$1(SwipeableState r100) {
        return r100.getAnchors$material();
    }

    private final void setAnimationRunning(boolean r100) {
        this.isAnimationRunning$delegate.setValue(Boolean.valueOf(r100));
    }

    private final void setCurrentValue(T r100) {
        this.currentValue$delegate.setValue(r100);
    }

    public final void ensureInit$material(Map<Float, ? extends T> r100) {
        if (getAnchors$material().isEmpty() == false) goto L9;
        Float r101 = SwipeableKt.access$getOffset(r100, getCurrentValue());
        if (r101 == null) goto L8;
        this.offsetState.setFloatValue(r101.floatValue());
        this.absoluteOffset.setFloatValue(r101.floatValue());
        return;
    L8:
        throw new IllegalArgumentException("The initial value must have an associated anchor.".toString());
    }

    public final float performDrag(float r100) {
        float r101 = RangesKt.coerceIn(this.absoluteOffset.getFloatValue() + r100, this.minBound, this.maxBound) - this.absoluteOffset.getFloatValue();
        if (Math.abs(r101) <= 0.0f) goto L5;
        this.draggableState.dispatchRawDelta(r101);
    L5:
        return r101;
    }

    public final void setAnchors$material(Map<Float, ? extends T> r100) {
        this.anchors$delegate.setValue(r100);
    }

    public final void setMaxBound$material(float r100) {
        this.maxBound = r100;
    }

    public final void setMinBound$material(float r100) {
        this.minBound = r100;
    }

    public final void setResistance$material(ResistanceConfig r100) {
        this.resistance$delegate.setValue(r100);
    }

    public final void setThresholds$material(Function2<? super Float, ? super Float, Float> r100) {
        this.thresholds$delegate.setValue(r100);
    }

    public final void setVelocityThreshold$material(float r100) {
        this.velocityThreshold$delegate.setFloatValue(r100);
    }

    public static final /* synthetic */ void access$setAnimationRunning(SwipeableState r100, boolean r101) {
        r100.setAnimationRunning(r101);
    }

    public static final /* synthetic */ void access$setCurrentValue(SwipeableState r100, Object r101) {
        r100.setCurrentValue(r101);
    }

    private static final Unit draggableState$lambda$8(SwipeableState r100, float r101) {
        float r102 = r100.absoluteOffset.getFloatValue() + r101;
        float r103 = RangesKt.coerceIn(r102, r100.minBound, r100.maxBound);
        float r104 = r102 - r103;
        ResistanceConfig r105 = r100.getResistance$material();
        if (r105 == null) goto L5;
        float r106 = r105.computeResistance(r104);
    L6:
        r100.offsetState.setFloatValue(r103 + r106);
        r100.overflowState.setFloatValue(r104);
        r100.absoluteOffset.setFloatValue(r102);
        return Unit.INSTANCE;
    L5:
        r106 = 0.0f;
        goto L6
    }

    private final Object snapInternalToOffset(float r100, Continuation<? super Unit> r101) {
        Object r102 = DraggableState.CC.drag$default(this.draggableState, null, new C86822(r100, this, null), r101, 1, null);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public final Object performFling(final float r100, Continuation<? super Unit> r101) {
        Object r102 = this.latestNonEmptyAnchorsFlow.collect(new C86812(this, r100), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public final Object snapTo(T r100, Continuation<? super Unit> r101) {
        Object r102 = this.latestNonEmptyAnchorsFlow.collect(new C86832(r100, this), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SwipeableState(T r100, AnimationSpec<Float> r101, Function1<? super T, Boolean> r102) {
        this.animationSpec = r101;
        this.confirmStateChange = r102;
        this.currentValue$delegate = SnapshotStateKt.mutableStateOf$default(r100, null, 2, null);
        this.isAnimationRunning$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.offsetState = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.overflowState = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.absoluteOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.animationTarget = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.anchors$delegate = SnapshotStateKt.mutableStateOf$default(MapsKt.emptyMap(), null, 2, null);
        final Flow r103 = SnapshotStateKt.snapshotFlow(new lb(this));
        this.latestNonEmptyAnchorsFlow = new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(new SwipeableState$special$$inlined$filter$1(r103));
        this.minBound = Float.NEGATIVE_INFINITY;
        this.maxBound = Float.POSITIVE_INFINITY;
        this.thresholds$delegate = SnapshotStateKt.mutableStateOf$default(new mb(), null, 2, null);
        this.velocityThreshold$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.resistance$delegate = SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggableState = DraggableKt.DraggableState(new nb(this));
    }

    public static final /* synthetic */ Object access$snapInternalToOffset(SwipeableState r100, float r101, Continuation r102) {
        return r100.snapInternalToOffset(r101, r102);
    }

    private final Object animateInternalToOffset(float r100, AnimationSpec<Float> r101, Continuation<? super Unit> r102) {
        Object r103 = DraggableState.CC.drag$default(this.draggableState, null, new AnonymousClass2(this, r100, r101, null), r102, 1, null);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public final Object animateTo(T r100, AnimationSpec<Float> r101, Continuation<? super Unit> r102) {
        Object r103 = this.latestNonEmptyAnchorsFlow.collect(new C86802(r100, this, r101), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v24, types: [float] */
    /* JADX WARN: Type inference failed for: r10v65 */
    /* JADX WARN: Type inference failed for: r10v68, types: [float] */
    /* JADX WARN: Type inference failed for: r10v72 */
    /* JADX WARN: Type inference failed for: r10v73 */
    public final Object processNewAnchors$material(float r110, Map<Float, ? extends T> r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof SwipeableState$processNewAnchors$1) == false) goto L7;
        SwipeableState$processNewAnchors$1 r100 = (SwipeableState$processNewAnchors$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L24;
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L18;
        if (r103 != 3) goto L17;
        r110 = (Map<Float, ? extends T>) r100.F$0;
        r111 = (Map) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L21
    L77:
        setCurrentValue(MapsKt.getValue(r111, Boxing.boxFloat(r110)));
        Float r114 = CollectionsKt.m9879minOrNull(r111.keySet());
        Intrinsics.checkNotNull(r114);
        this.minBound = r114.floatValue();
        Float r115 = CollectionsKt.m9877maxOrNull(r111.keySet());
        Intrinsics.checkNotNull(r115);
        r110 = (Map<Float, ? extends T>) r115.floatValue();
        this.maxBound = r110;
    L84:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        boolean r116 = (Map<Float, ? extends T>) r100.F$0;
        r111 = (Map) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L21 CancellationException -> L78
        r110 = r116;
    L85:
    L23:
        ResultKt.throwOnFailure(r113);
    L32:
        return Unit.INSTANCE;
    L24:
        ResultKt.throwOnFailure(r113);
        if (r110.isEmpty() == false) goto L36;
        Float r117 = CollectionsKt.m9879minOrNull(r111.keySet());
        Intrinsics.checkNotNull(r117);
        this.minBound = r117.floatValue();
        Float r118 = CollectionsKt.m9877maxOrNull(r111.keySet());
        Intrinsics.checkNotNull(r118);
        this.maxBound = r118.floatValue();
        Float r119 = SwipeableKt.access$getOffset(r111, getCurrentValue());
        if (r119 == null) goto L34;
        float r120 = r119.floatValue();
        r100.label = 1;
        if (snapInternalToOffset(r120, r100) != r102) goto L32;
        return r102;
    L34:
        throw new IllegalArgumentException("The initial value must have an associated anchor.".toString());
    L36:
        if (Intrinsics.areEqual(r111, r110) == true) goto L84;
        this.minBound = Float.NEGATIVE_INFINITY;
        this.maxBound = Float.POSITIVE_INFINITY;
        Float r121 = this.animationTarget.getValue();
        Object r104 = null;
        if (r121 == null) goto L55;
        Float r122 = SwipeableKt.access$getOffset(r111, r110.get(r121));
        if (r122 == null) goto L42;
        float r123 = r122.floatValue();
    L74:
        AnimationSpec<Float> r124 = this.animationSpec;     // Catch: Throwable -> L21 CancellationException -> L78
        r100.L$0 = r111;     // Catch: Throwable -> L21 CancellationException -> L78
        r100.F$0 = r123;     // Catch: Throwable -> L21 CancellationException -> L78
        r100.label = 2;     // Catch: Throwable -> L21 CancellationException -> L78
        Object r125 = animateInternalToOffset(r123, r124, r100);     // Catch: Throwable -> L21 CancellationException -> L78
        r110 = r123;
        if (r125 != r102) goto L85;
        return r102;
    L42:
        Iterator<T> r105 = r111.keySet().iterator();
        if (r105.hasNext() == false) goto L54;
        r104 = r105.next();
        if (r105.hasNext() == false) goto L54;
        float r126 = Math.abs(((Number) r104).floatValue() - r121.floatValue());
    L49:
        Object r106 = r105.next();
        float r107 = Math.abs(((Number) r106).floatValue() - r121.floatValue());
        if (Float.compare(r126, r107) <= 0) goto L53;
        r104 = r106;
        r126 = r107;
    L53:
        if (r105.hasNext() == true) goto L49;
    L54:
        Intrinsics.checkNotNull(r104);
        r123 = ((Number) r104).floatValue();
        goto L74
    L55:
        Object r127 = r110.get(getOffset().getValue());
        if (Intrinsics.areEqual(r127, getCurrentValue()) == false) goto L58;
        r127 = getCurrentValue();
    L58:
        Float r128 = SwipeableKt.access$getOffset(r111, r127);
        if (r128 == null) goto L61;
        r123 = r128.floatValue();
        goto L74
    L61:
        Iterator<T> r129 = r111.keySet().iterator();
        if (r129.hasNext() == false) goto L73;
        r104 = r129.next();
        if (r129.hasNext() == false) goto L73;
        float r130 = Math.abs(((Number) r104).floatValue() - getOffset().getValue().floatValue());
    L68:
        Object r108 = r129.next();
        float r109 = Math.abs(((Number) r108).floatValue() - getOffset().getValue().floatValue());
        if (Float.compare(r130, r109) <= 0) goto L72;
        r104 = r108;
        r130 = r109;
    L72:
        if (r129.hasNext() == true) goto L68;
    L73:
        Intrinsics.checkNotNull(r104);
        r123 = ((Number) r104).floatValue();
    L78:
        r100.L$0 = r111;     // Catch: Throwable -> L21
        r100.F$0 = r110;     // Catch: Throwable -> L21
        r100.label = 3;     // Catch: Throwable -> L21
        if (snapInternalToOffset(r110, r100) != r102) goto L77;
        return r102;
    L21:
        th = move-exception;
        setCurrentValue(MapsKt.getValue(r111, Boxing.boxFloat(r110)));
        Float r131 = CollectionsKt.m9879minOrNull(r111.keySet());
        Intrinsics.checkNotNull(r131);
        this.minBound = r131.floatValue();
        Float r132 = CollectionsKt.m9877maxOrNull(r111.keySet());
        Intrinsics.checkNotNull(r132);
        this.maxBound = r132.floatValue();
        throw th;
    L7:
        r100 = new SwipeableState$processNewAnchors$1(this, r112);
        goto L8
    }

    public static final /* synthetic */ Object access$animateInternalToOffset(SwipeableState r100, float r101, AnimationSpec r102, Continuation r103) {
        return r100.animateInternalToOffset(r101, r102, r103);
    }

    public /* synthetic */ SwipeableState(Object r100, AnimationSpec r101, Function1 r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = SwipeableDefaults.INSTANCE.getAnimationSpec();
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = new ob();
    L8:
        this(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object animateTo$default(SwipeableState r100, Object r101, AnimationSpec r102, Continuation r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 2) == 0) goto L7;
        r102 = r100.animationSpec;
    L7:
        return r100.animateTo(r101, r102, r103);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
    }
}
