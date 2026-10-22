package androidx.compose.material3;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 |2\u00020\u0001:\u0001|B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002J?\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#2'\u0010$\u001a#\b\u0001\u0012\u0004\u0012\u00020&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0'\u0012\u0006\u0012\u0004\u0018\u00010(0%¢\u0006\u0002\b)H\u0096@¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u0003H\u0016J\u001d\u0010`\u001a\u00020\b2\u0006\u0010a\u001a\u00020\u00052\u0006\u0010b\u001a\u00020\u0005H\u0000¢\u0006\u0002\bcJ\u0017\u0010f\u001a\u00020\b2\u0006\u0010g\u001a\u00020hH\u0000¢\u0006\u0004\bi\u0010jJ \u0010v\u001a\u00020\u00032\u0006\u0010w\u001a\u00020\u00032\u0006\u0010x\u001a\u00020\u00032\u0006\u0010y\u001a\u00020\u0003H\u0002J \u0010z\u001a\u00020\u00032\u0006\u0010w\u001a\u00020\u00032\u0006\u0010x\u001a\u00020\u00032\u0006\u0010{\u001a\u00020\u0003H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R+\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR(\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0002048GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00105\"\u0004\b6\u00107R\u0014\u00108\u001a\u000209X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R+\u0010<\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\b=\u0010\u000e\"\u0004\b>\u0010?R+\u0010B\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bE\u0010A\u001a\u0004\bC\u0010\u000e\"\u0004\bD\u0010?R\u001a\u0010F\u001a\u000204X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u00105\"\u0004\bH\u00107R+\u0010I\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00058@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010A\u001a\u0004\bJ\u0010\u000e\"\u0004\bK\u0010?R+\u0010M\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00058@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bP\u0010A\u001a\u0004\bN\u0010\u000e\"\u0004\bO\u0010?R\u001a\u0010Q\u001a\u00020RX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001a\u0010W\u001a\u000204X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00105\"\u0004\bY\u00107R\u0011\u0010Z\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b[\u0010\u0018R+\u0010\\\u001a\u0002042\u0006\u0010\u0015\u001a\u0002048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b\\\u00105\"\u0004\b]\u00107R\u001a\u0010d\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\be\u0010\u0010R+\u0010k\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bn\u0010\u001c\u001a\u0004\bl\u0010\u0018\"\u0004\bm\u0010\u001aR+\u0010o\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\br\u0010\u001c\u001a\u0004\bp\u0010\u0018\"\u0004\bq\u0010\u001aR\u000e\u0010s\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010t\u001a\u00020uX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Landroidx/compose/material3/SliderState;", "Landroidx/compose/foundation/gestures/DraggableState;", "value", "", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "<init>", "(FILkotlin/jvm/functions/Function0;Lkotlin/ranges/ClosedFloatingPointRange;)V", "getSteps", "()I", "getOnValueChangeFinished", "()Lkotlin/jvm/functions/Function0;", "setOnValueChangeFinished", "(Lkotlin/jvm/functions/Function0;)V", "getValueRange", "()Lkotlin/ranges/ClosedFloatingPointRange;", "<set-?>", "valueState", "getValueState", "()F", "setValueState", "(F)V", "valueState$delegate", "Landroidx/compose/runtime/MutableFloatState;", "newVal", "getValue", "setValue", "calculateSnappedValue", BitableAnalytic.ProgressInputType.DRAG, "dragPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchRawDelta", "delta", "onValueChange", "Lkotlin/Function1;", "getOnValueChange", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange", "(Lkotlin/jvm/functions/Function1;)V", "shouldAutoSnap", "", "()Z", "setShouldAutoSnap", "(Z)V", "tickFractions", "", "getTickFractions$material3", "()[F", "totalWidth", "getTotalWidth", "setTotalWidth", "(I)V", "totalWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "totalHeight", "getTotalHeight", "setTotalHeight", "totalHeight$delegate", "isRtl", "isRtl$material3", "setRtl$material3", "thumbWidth", "getThumbWidth$material3", "setThumbWidth$material3", "thumbWidth$delegate", "thumbHeight", "getThumbHeight$material3", "setThumbHeight$material3", "thumbHeight$delegate", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation$material3", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation$material3", "(Landroidx/compose/foundation/gestures/Orientation;)V", "reverseVerticalDirection", "getReverseVerticalDirection$material3", "setReverseVerticalDirection$material3", "coercedValueAsFraction", "getCoercedValueAsFraction", "isDragging", "setDragging", "isDragging$delegate", "Landroidx/compose/runtime/MutableState;", "updateDimensions", "newTotalWidth", "newTotalHeight", "updateDimensions$material3", "gestureEndAction", "getGestureEndAction$material3", "onPress", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "Landroidx/compose/ui/geometry/Offset;", "onPress-k-4lQ0M$material3", "(J)V", "rawOffset", "getRawOffset", "setRawOffset", "rawOffset$delegate", "pressOffset", "getPressOffset", "setPressOffset", "pressOffset$delegate", "dragScope", "scrollMutex", "Landroidx/compose/foundation/MutatorMutex;", "scaleToUserValue", "minPx", "maxPx", "offset", "scaleToOffset", "userValue", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SliderState implements DraggableState {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final DragScope dragScope;
    private final Function0<Unit> gestureEndAction;
    private final MutableState isDragging$delegate;
    private boolean isRtl;
    private Function1<? super Float, Unit> onValueChange;
    private Function0<Unit> onValueChangeFinished;
    private Orientation orientation;
    private final MutableFloatState pressOffset$delegate;
    private final MutableFloatState rawOffset$delegate;
    private boolean reverseVerticalDirection;
    private final MutatorMutex scrollMutex;
    private boolean shouldAutoSnap;
    private final int steps;
    private final MutableIntState thumbHeight$delegate;
    private final MutableIntState thumbWidth$delegate;
    private final float[] tickFractions;
    private final MutableIntState totalHeight$delegate;
    private final MutableIntState totalWidth$delegate;
    private final ClosedFloatingPointRange<Float> valueRange;
    private final MutableFloatState valueState$delegate;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u00052\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¨\u0006\r"}, d2 = {"Landroidx/compose/material3/SliderState$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SliderState;", "onValueChangeFinished", "Lkotlin/Function0;", "", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ List a(SaverScope r100, SliderState r101) {
            return Saver$lambda$0(r100, r101);
        }

        public static /* synthetic */ SliderState b(Function0 r100, ClosedFloatingPointRange r101, List r102) {
            return Saver$lambda$1(r100, r101, r102);
        }

        private static final List Saver$lambda$0(SaverScope r100, SliderState r101) {
            return CollectionsKt.listOf(new Object[]{Float.valueOf(r101.getValue()), Integer.valueOf(r101.getSteps())});
        }

        public final Saver<SliderState, ?> Saver(final Function0<Unit> r100, final ClosedFloatingPointRange<Float> r101) {
            return ListSaverKt.listSaver(new oq(), new pq(r100, r101));
        }

        private static final SliderState Saver$lambda$1(Function0 r100, ClosedFloatingPointRange r101, List r102) {
            Object r103 = ListProtector.get(r102, 0);
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Float");
            float r104 = ((Float) r103).floatValue();
            Object r105 = ListProtector.get(r102, 1);
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.Int");
            return new SliderState(r104, ((Integer) r105).intValue(), r100, r101);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.SliderState$drag$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SliderState$drag$2", f = "Slider.kt", i = {}, l = {2766}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<DragScope, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ MutatePriority $dragPriority;
        int label;
        final /* synthetic */ SliderState this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(SliderState r100, MutatePriority r101, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> r102, Continuation<? super AnonymousClass2> r103) {
            this.this$0 = r100;
            this.$dragPriority = r101;
            this.$block = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, this.$dragPriority, this.$block, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            SliderState.access$setDragging(this.this$0, false);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            SliderState.access$setDragging(this.this$0, true);
            MutatorMutex r103 = SliderState.access$getScrollMutex$p(this.this$0);
            DragScope r104 = SliderState.access$getDragScope$p(this.this$0);
            MutatePriority r105 = this.$dragPriority;
            Function2<DragScope, Continuation<? super Unit>, Object> r106 = this.$block;
            this.label = 1;
            if (r103.mutateWith(r104, r105, r106, this) != r101) goto L11;
            return r101;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public SliderState() {
        this(0.0f, 0, null, null, 15, null);
    }

    public static /* synthetic */ Unit a(SliderState r100) {
        return gestureEndAction$lambda$1(r100);
    }

    private final float getPressOffset() {
        return this.pressOffset$delegate.getFloatValue();
    }

    private final float getRawOffset() {
        return this.rawOffset$delegate.getFloatValue();
    }

    private final int getTotalHeight() {
        return this.totalHeight$delegate.getIntValue();
    }

    private final int getTotalWidth() {
        return this.totalWidth$delegate.getIntValue();
    }

    private final float getValueState() {
        return this.valueState$delegate.getFloatValue();
    }

    public final float getCoercedValueAsFraction() {
        return SliderKt.access$calcFraction(this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue(), RangesKt.coerceIn(getValue(), this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue()));
    }

    public final int getThumbHeight$material3() {
        return this.thumbHeight$delegate.getIntValue();
    }

    public final int getThumbWidth$material3() {
        return this.thumbWidth$delegate.getIntValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isDragging() {
        return ((Boolean) this.isDragging$delegate.getValue()).booleanValue();
    }

    public final float getValue() {
        return getValueState();
    }

    public final Function0<Unit> getGestureEndAction$material3() {
        return this.gestureEndAction;
    }

    public final Function1<Float, Unit> getOnValueChange() {
        return this.onValueChange;
    }

    public final Function0<Unit> getOnValueChangeFinished() {
        return this.onValueChangeFinished;
    }

    public final Orientation getOrientation$material3() {
        return this.orientation;
    }

    public final boolean getReverseVerticalDirection$material3() {
        return this.reverseVerticalDirection;
    }

    public final int getSteps() {
        return this.steps;
    }

    public final float[] getTickFractions$material3() {
        return this.tickFractions;
    }

    public final ClosedFloatingPointRange<Float> getValueRange() {
        return this.valueRange;
    }

    public final boolean isRtl$material3() {
        return this.isRtl;
    }

    public final boolean shouldAutoSnap() {
        return this.shouldAutoSnap;
    }

    public static final /* synthetic */ DragScope access$getDragScope$p(SliderState r100) {
        return r100.dragScope;
    }

    public static final /* synthetic */ MutatorMutex access$getScrollMutex$p(SliderState r100) {
        return r100.scrollMutex;
    }

    private final float calculateSnappedValue(float r100) {
        return SliderKt.access$snapValueToTick(RangesKt.coerceIn(r100, this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue()), this.tickFractions, this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue());
    }

    private static final Unit gestureEndAction$lambda$1(SliderState r100) {
        if (r100.isDragging() == true) goto L8;
        Function0<Unit> r101 = r100.onValueChangeFinished;
        if (r101 == null) goto L8;
        r101.invoke();
    L8:
        return Unit.INSTANCE;
    }

    private final void setDragging(boolean r100) {
        this.isDragging$delegate.setValue(Boolean.valueOf(r100));
    }

    private final void setPressOffset(float r100) {
        this.pressOffset$delegate.setFloatValue(r100);
    }

    private final void setRawOffset(float r100) {
        this.rawOffset$delegate.setFloatValue(r100);
    }

    private final void setTotalHeight(int r100) {
        this.totalHeight$delegate.setIntValue(r100);
    }

    private final void setTotalWidth(int r100) {
        this.totalWidth$delegate.setIntValue(r100);
    }

    private final void setValueState(float r100) {
        this.valueState$delegate.setFloatValue(r100);
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public void dispatchRawDelta(float r100) {
        if (this.orientation != Orientation.Vertical) goto L5;
        float r101 = Math.max(getTotalHeight() - (getThumbHeight$material3() / 2.0f), 0.0f);
        float r102 = Math.min(getThumbHeight$material3() / 2.0f, r101);
    L6:
        setRawOffset((getRawOffset() + r100) + getPressOffset());
        setPressOffset(0.0f);
        float r103 = scaleToUserValue(r102, r101, SliderKt.access$snapValueToTick(getRawOffset(), this.tickFractions, r102, r101));
        if (r103 != getValue()) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L17;
        Function1<? super Float, Unit> r105 = this.onValueChange;
        if (r105 == null) goto L15;
        if (r105 == null) goto L18;
        r105.invoke(Float.valueOf(r103));
        return;
    L18:
        return;
    L15:
        setValue(r103);
        return;
    L17:
        return;
    L9:
        r104 = false;
        goto L10
    L5:
        r101 = Math.max(getTotalWidth() - (getThumbWidth$material3() / 2.0f), 0.0f);
        r102 = Math.min(getThumbWidth$material3() / 2.0f, r101);
        goto L6
    }

    /* JADX INFO: renamed from: onPress-k-4lQ0M$material3, reason: not valid java name */
    public final void m2690onPressk4lQ0M$material3(long r100) {
        if (this.orientation != Orientation.Vertical) goto L9;
        if (this.reverseVerticalDirection == false) goto L7;
        float r101 = getTotalHeight();
        float r102 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
    L11:
        float r103 = r101 - r102;
    L13:
        setPressOffset(r103 - getRawOffset());
        return;
    L7:
        r103 = Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax));
        goto L13
    L9:
        if (this.isRtl == false) goto L12;
        r101 = getTotalWidth();
        r102 = Float.intBitsToFloat((int) (r100 >> 32));
        goto L11
    L12:
        r103 = Float.intBitsToFloat((int) (r100 >> 32));
        goto L13
    }

    public final void setOnValueChange(Function1<? super Float, Unit> r100) {
        this.onValueChange = r100;
    }

    public final void setOnValueChangeFinished(Function0<Unit> r100) {
        this.onValueChangeFinished = r100;
    }

    public final void setOrientation$material3(Orientation r100) {
        this.orientation = r100;
    }

    public final void setReverseVerticalDirection$material3(boolean r100) {
        this.reverseVerticalDirection = r100;
    }

    public final void setRtl$material3(boolean r100) {
        this.isRtl = r100;
    }

    public final void setShouldAutoSnap(boolean r100) {
        this.shouldAutoSnap = r100;
    }

    public final void setThumbHeight$material3(int r100) {
        this.thumbHeight$delegate.setIntValue(r100);
    }

    public final void setThumbWidth$material3(int r100) {
        this.thumbWidth$delegate.setIntValue(r100);
    }

    public final void setValue(float r100) {
        if (this.shouldAutoSnap == false) goto L5;
        r100 = calculateSnappedValue(r100);
    L5:
        setValueState(r100);
    }

    public static final /* synthetic */ void access$setDragging(SliderState r100, boolean r101) {
        r100.setDragging(r101);
    }

    public final void updateDimensions$material3(int r100, int r101) {
        setTotalWidth(r100);
        setTotalHeight(r101);
    }

    private final float scaleToOffset(float r100, float r101, float r102) {
        return SliderKt.access$scale(this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue(), r102, r100, r101);
    }

    private final float scaleToUserValue(float r100, float r101, float r102) {
        return SliderKt.access$scale(r100, r101, r102, this.valueRange.getStart().floatValue(), this.valueRange.getEndInclusive().floatValue());
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public Object drag(MutatePriority r100, Function2<? super DragScope, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        Object r103 = CoroutineScopeKt.coroutineScope(new AnonymousClass2(this, r100, r101, null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    public SliderState(float r100, int r101, Function0<Unit> r102, ClosedFloatingPointRange<Float> r103) {
        this.steps = r101;
        this.onValueChangeFinished = r102;
        this.valueRange = r103;
        this.valueState$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(r100);
        this.shouldAutoSnap = true;
        this.tickFractions = SliderKt.access$stepsToTickFractions(r101);
        this.totalWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.totalHeight$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.thumbWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.thumbHeight$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        this.orientation = Orientation.Horizontal;
        this.isDragging$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.gestureEndAction = new nq(this);
        this.rawOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(scaleToOffset(0.0f, 0.0f, r100));
        this.pressOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.dragScope = new SliderState$dragScope$1(this);
        this.scrollMutex = new MutatorMutex();
    }

    public /* synthetic */ SliderState(float r100, int r101, Function0 r102, ClosedFloatingPointRange r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0.0f;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = RangesKt.rangeTo(0.0f, 1.0f);
    L14:
        this(r100, r101, r102, r103);
    }
}
