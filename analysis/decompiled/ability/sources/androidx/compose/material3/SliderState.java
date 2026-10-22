package androidx.compose.material3;

import C7.r;
import S7.k;
import S7.n;
import androidx.annotation.IntRange;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.policy.sdk.config.PolicySdkConstants;
import g1.AbstractC1451a;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@StabilityInferred(parameters = 0)
@ExperimentalMaterial3Api
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ<\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000fH\u0096@¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\"\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eH\u0000ø\u0001\u0000¢\u0006\u0004\b \u0010!J'\u0010&\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u0002H\u0002¢\u0006\u0004\b&\u0010'J'\u0010)\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0002¢\u0006\u0004\b)\u0010'R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010*\u001a\u0004\b+\u0010,R*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00102\u001a\u0004\b3\u00104R+\u0010;\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010\u0018R0\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0018\u00010<8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010D\u001a\u00020C8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR+\u0010M\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00048B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010,\"\u0004\bK\u0010LR\"\u0010O\u001a\u00020N8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR+\u0010X\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00028@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bU\u00107\u001a\u0004\bV\u00109\"\u0004\bW\u0010\u0018R+\u0010\\\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00028@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\bY\u00107\u001a\u0004\bZ\u00109\"\u0004\b[\u0010\u0018R+\u0010a\u001a\u00020N2\u0006\u00105\u001a\u00020N8@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010R\"\u0004\b`\u0010TR \u0010b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\bb\u0010-\u001a\u0004\bc\u0010/R+\u0010g\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bd\u00107\u001a\u0004\be\u00109\"\u0004\bf\u0010\u0018R+\u0010k\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u00028B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bh\u00107\u001a\u0004\bi\u00109\"\u0004\bj\u0010\u0018R\u0014\u0010l\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010o\u001a\u00020n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010q\u001a\u00020\u00028F@FX\u0086\u000e¢\u0006\f\u001a\u0004\br\u00109\"\u0004\bs\u0010\u0018R\u0014\u0010u\u001a\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bt\u00109\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006v"}, d2 = {"Landroidx/compose/material3/SliderState;", "Landroidx/compose/foundation/gestures/DraggableState;", "", "value", "", "steps", "Lkotlin/Function0;", "LC7/r;", "onValueChangeFinished", "LY7/b;", "valueRange", AppAgent.CONSTRUCT, "(FILS7/a;LY7/b;)V", "Landroidx/compose/foundation/MutatePriority;", "dragPriority", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragScope;", "LH7/c;", "", "block", "drag", "(Landroidx/compose/foundation/MutatePriority;LS7/n;LH7/c;)Ljava/lang/Object;", "delta", "dispatchRawDelta", "(F)V", "newTrackHeight", "newTotalWidth", "updateDimensions$material3_release", "(FI)V", "updateDimensions", "Landroidx/compose/ui/geometry/Offset;", "pos", "onPress-k-4lQ0M$material3_release", "(J)V", "onPress", "minPx", "maxPx", TypedValues.CycleType.S_WAVE_OFFSET, "scaleToUserValue", "(FFF)F", "userValue", "scaleToOffset", "I", "getSteps", "()I", "LS7/a;", "getOnValueChangeFinished", "()LS7/a;", "setOnValueChangeFinished", "(LS7/a;)V", "LY7/b;", "getValueRange", "()LY7/b;", "<set-?>", "valueState$delegate", "Landroidx/compose/runtime/MutableFloatState;", "getValueState", "()F", "setValueState", "valueState", "Lkotlin/Function1;", "onValueChange", "LS7/k;", "getOnValueChange$material3_release", "()LS7/k;", "setOnValueChange$material3_release", "(LS7/k;)V", "", "tickFractions", "[F", "getTickFractions$material3_release", "()[F", "totalWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "getTotalWidth", "setTotalWidth", "(I)V", "totalWidth", "", "isRtl", "Z", "isRtl$material3_release", "()Z", "setRtl$material3_release", "(Z)V", "trackHeight$delegate", "getTrackHeight$material3_release", "setTrackHeight$material3_release", "trackHeight", "thumbWidth$delegate", "getThumbWidth$material3_release", "setThumbWidth$material3_release", "thumbWidth", "isDragging$delegate", "Landroidx/compose/runtime/MutableState;", "isDragging$material3_release", "setDragging", "isDragging", "gestureEndAction", "getGestureEndAction$material3_release", "rawOffset$delegate", "getRawOffset", "setRawOffset", "rawOffset", "pressOffset$delegate", "getPressOffset", "setPressOffset", "pressOffset", "dragScope", "Landroidx/compose/foundation/gestures/DragScope;", "Landroidx/compose/foundation/MutatorMutex;", "scrollMutex", "Landroidx/compose/foundation/MutatorMutex;", "newVal", "getValue", "setValue", "getCoercedValueAsFraction$material3_release", "coercedValueAsFraction", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SliderState implements DraggableState {
    public static final int $stable = 8;
    private final DragScope dragScope;
    private final S7.a gestureEndAction;

    /* renamed from: isDragging$delegate, reason: from kotlin metadata */
    private final MutableState isDragging;
    private boolean isRtl;
    private k onValueChange;
    private S7.a onValueChangeFinished;

    /* renamed from: pressOffset$delegate, reason: from kotlin metadata */
    private final MutableFloatState pressOffset;

    /* renamed from: rawOffset$delegate, reason: from kotlin metadata */
    private final MutableFloatState rawOffset;
    private final MutatorMutex scrollMutex;
    private final int steps;

    /* renamed from: thumbWidth$delegate, reason: from kotlin metadata */
    private final MutableFloatState thumbWidth;
    private final float[] tickFractions;

    /* renamed from: totalWidth$delegate, reason: from kotlin metadata */
    private final MutableIntState totalWidth;

    /* renamed from: trackHeight$delegate, reason: from kotlin metadata */
    private final MutableFloatState trackHeight;
    private final Y7.b valueRange;

    /* renamed from: valueState$delegate, reason: from kotlin metadata */
    private final MutableFloatState valueState;

    @J7.c(c = "androidx.compose.material3.SliderState$drag$2", f = "Slider.kt", l = {1972}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.material3.SliderState$drag$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ n $block;
        final /* synthetic */ MutatePriority $dragPriority;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MutatePriority mutatePriority, n nVar, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$dragPriority = mutatePriority;
            this.$block = nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return SliderState.this.new AnonymousClass2(this.$dragPriority, this.$block, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                SliderState.this.setDragging(true);
                MutatorMutex mutatorMutex = SliderState.this.scrollMutex;
                DragScope dragScope = SliderState.this.dragScope;
                MutatePriority mutatePriority = this.$dragPriority;
                n nVar = this.$block;
                this.label = 1;
                if (mutatorMutex.mutateWith(dragScope, mutatePriority, nVar, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            SliderState.this.setDragging(false);
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public SliderState() {
        this(0.0f, 0, null, null, 15, null);
    }

    private final float getPressOffset() {
        return this.pressOffset.getFloatValue();
    }

    private final float getRawOffset() {
        return this.rawOffset.getFloatValue();
    }

    private final int getTotalWidth() {
        return this.totalWidth.getIntValue();
    }

    private final float getValueState() {
        return this.valueState.getFloatValue();
    }

    private final float scaleToOffset(float minPx, float maxPx, float userValue) {
        return SliderKt.scale(Float.valueOf(((Y7.a) this.valueRange).f1568a).floatValue(), Float.valueOf(((Y7.a) this.valueRange).b).floatValue(), userValue, minPx, maxPx);
    }

    private final float scaleToUserValue(float minPx, float maxPx, float offset) {
        return SliderKt.scale(minPx, maxPx, offset, Float.valueOf(((Y7.a) this.valueRange).f1568a).floatValue(), Float.valueOf(((Y7.a) this.valueRange).b).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDragging(boolean z10) {
        this.isDragging.setValue(Boolean.valueOf(z10));
    }

    private final void setPressOffset(float f) {
        this.pressOffset.setFloatValue(f);
    }

    private final void setRawOffset(float f) {
        this.rawOffset.setFloatValue(f);
    }

    private final void setTotalWidth(int i) {
        this.totalWidth.setIntValue(i);
    }

    private final void setValueState(float f) {
        this.valueState.setFloatValue(f);
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public void dispatchRawDelta(float delta) {
        float f = 2;
        float fMax = Math.max(getTotalWidth() - (getThumbWidth$material3_release() / f), 0.0f);
        float fMin = Math.min(getThumbWidth$material3_release() / f, fMax);
        setRawOffset(getRawOffset() + delta + getPressOffset());
        setPressOffset(0.0f);
        float fScaleToUserValue = scaleToUserValue(fMin, fMax, SliderKt.snapValueToTick(getRawOffset(), this.tickFractions, fMin, fMax));
        if (fScaleToUserValue == getValue()) {
            return;
        }
        k kVar = this.onValueChange;
        if (kVar == null) {
            setValue(fScaleToUserValue);
        } else if (kVar != null) {
            kVar.invoke(Float.valueOf(fScaleToUserValue));
        }
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public Object drag(MutatePriority mutatePriority, n nVar, H7.c<? super r> cVar) {
        Object objF = AbstractC1683A.f(new AnonymousClass2(mutatePriority, nVar, null), cVar);
        return objF == CoroutineSingletons.f4909a ? objF : r.f317a;
    }

    public final float getCoercedValueAsFraction$material3_release() {
        return SliderKt.calcFraction(Float.valueOf(((Y7.a) this.valueRange).f1568a).floatValue(), Float.valueOf(((Y7.a) this.valueRange).b).floatValue(), AbstractC1451a.t(getValue(), Float.valueOf(((Y7.a) this.valueRange).f1568a).floatValue(), Float.valueOf(((Y7.a) this.valueRange).b).floatValue()));
    }

    /* renamed from: getGestureEndAction$material3_release, reason: from getter */
    public final S7.a getGestureEndAction() {
        return this.gestureEndAction;
    }

    /* renamed from: getOnValueChange$material3_release, reason: from getter */
    public final k getOnValueChange() {
        return this.onValueChange;
    }

    public final S7.a getOnValueChangeFinished() {
        return this.onValueChangeFinished;
    }

    public final int getSteps() {
        return this.steps;
    }

    public final float getThumbWidth$material3_release() {
        return this.thumbWidth.getFloatValue();
    }

    /* renamed from: getTickFractions$material3_release, reason: from getter */
    public final float[] getTickFractions() {
        return this.tickFractions;
    }

    public final float getTrackHeight$material3_release() {
        return this.trackHeight.getFloatValue();
    }

    public final float getValue() {
        return getValueState();
    }

    public final Y7.b getValueRange() {
        return this.valueRange;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isDragging$material3_release() {
        return ((Boolean) this.isDragging.getValue()).booleanValue();
    }

    /* renamed from: isRtl$material3_release, reason: from getter */
    public final boolean getIsRtl() {
        return this.isRtl;
    }

    /* renamed from: onPress-k-4lQ0M$material3_release, reason: not valid java name */
    public final void m2291onPressk4lQ0M$material3_release(long pos) {
        setPressOffset((this.isRtl ? getTotalWidth() - Offset.m3895getXimpl(pos) : Offset.m3895getXimpl(pos)) - getRawOffset());
    }

    public final void setOnValueChange$material3_release(k kVar) {
        this.onValueChange = kVar;
    }

    public final void setOnValueChangeFinished(S7.a aVar) {
        this.onValueChangeFinished = aVar;
    }

    public final void setRtl$material3_release(boolean z10) {
        this.isRtl = z10;
    }

    public final void setThumbWidth$material3_release(float f) {
        this.thumbWidth.setFloatValue(f);
    }

    public final void setTrackHeight$material3_release(float f) {
        this.trackHeight.setFloatValue(f);
    }

    public final void setValue(float f) {
        setValueState(SliderKt.snapValueToTick(AbstractC1451a.t(f, Float.valueOf(((Y7.a) this.valueRange).f1568a).floatValue(), Float.valueOf(((Y7.a) this.valueRange).b).floatValue()), this.tickFractions, Float.valueOf(((Y7.a) this.valueRange).f1568a).floatValue(), Float.valueOf(((Y7.a) this.valueRange).b).floatValue()));
    }

    public final void updateDimensions$material3_release(float newTrackHeight, int newTotalWidth) {
        setTrackHeight$material3_release(newTrackHeight);
        setTotalWidth(newTotalWidth);
    }

    public SliderState(float f, int i, S7.a aVar, Y7.b bVar, int i6, e eVar) {
        this((i6 & 1) != 0 ? 0.0f : f, (i6 & 2) != 0 ? 0 : i, (i6 & 4) != 0 ? null : aVar, (i6 & 8) != 0 ? new Y7.a(0.0f, 1.0f) : bVar);
    }

    public SliderState(float f, @IntRange(from = PolicySdkConstants.POLICY_NEWEST_VERSION_DEFAULT) int i, S7.a aVar, Y7.b bVar) {
        this.steps = i;
        this.onValueChangeFinished = aVar;
        this.valueRange = bVar;
        this.valueState = PrimitiveSnapshotStateKt.mutableFloatStateOf(f);
        this.tickFractions = SliderKt.stepsToTickFractions(i);
        this.totalWidth = SnapshotIntStateKt.mutableIntStateOf(0);
        this.trackHeight = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.thumbWidth = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.isDragging = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.gestureEndAction = new S7.a() { // from class: androidx.compose.material3.SliderState$gestureEndAction$1
            {
                super(0);
            }

            @Override // S7.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m2292invoke();
                return r.f317a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2292invoke() {
                S7.a onValueChangeFinished;
                if (this.this$0.isDragging$material3_release() || (onValueChangeFinished = this.this$0.getOnValueChangeFinished()) == null) {
                    return;
                }
                onValueChangeFinished.invoke();
            }
        };
        this.rawOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(scaleToOffset(0.0f, 0.0f, f));
        this.pressOffset = PrimitiveSnapshotStateKt.mutableFloatStateOf(0.0f);
        this.dragScope = new DragScope() { // from class: androidx.compose.material3.SliderState$dragScope$1
            @Override // androidx.compose.foundation.gestures.DragScope
            public void dragBy(float pixels) {
                this.this$0.dispatchRawDelta(pixels);
            }
        };
        this.scrollMutex = new MutatorMutex();
    }
}
