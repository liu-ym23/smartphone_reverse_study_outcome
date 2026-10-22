package androidx.compose.material3;

import androidx.camera.video.AudioStats;
import androidx.collection.IntList;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Dp;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0005H\u0002J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u0016H\u0002J\u001c\u0010)\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ.\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00162\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001d2\b\b\u0002\u0010,\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010-J\b\u00105\u001a\u00020\u001bH\u0002J\f\u00109\u001a\u00020\u0016*\u00020\u0016H\u0002J\f\u0010<\u001a\u00020/*\u00020\u0016H\u0002J\f\u0010=\u001a\u00020/*\u00020\u0016H\u0002J\u0010\u0010>\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020(0'X\u0082\u000e¢\u0006\u0002\n\u0000R$\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020/8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00106\u001a\u00020/2\u0006\u0010.\u001a\u00020/8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010?\u001a\u00020\u0005X\u0096\u000f¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0018\u0010C\u001a\u00020DX\u0096\u000f¢\u0006\f\u001a\u0004\bE\u00102\"\u0004\bF\u00104¨\u0006G"}, d2 = {"Landroidx/compose/material3/AnalogTimePickerState;", "Landroidx/compose/material3/TimePickerState;", "state", "userOverride", "Landroidx/compose/ui/node/Ref;", "", "<init>", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/node/Ref;)V", "getState", "()Landroidx/compose/material3/TimePickerState;", "getUserOverride", "()Landroidx/compose/ui/node/Ref;", "<set-?>", "Landroidx/compose/ui/unit/Dp;", "currentDiameter", "getCurrentDiameter-D9Ej5fM", "()F", "setCurrentDiameter-0680j_4", "(F)V", "currentDiameter$delegate", "Landroidx/compose/runtime/MutableState;", "currentAngle", "", "getCurrentAngle", "hourAngle", "minuteAngle", "animateToCurrent", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUpdated", "clockFaceValues", "Landroidx/collection/IntList;", "getClockFaceValues", "()Landroidx/collection/IntList;", "endValueForAnimation", "new", "anim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "onGestureEnd", "rotateTo", "angle", "animate", "(FLandroidx/compose/animation/core/AnimationSpec;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "minute", "getMinute", "()I", "setMinute", "(I)V", "updateBaseStateMinute", "hour", "getHour", "setHour", "normalize", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "toHour", "toMinute", "offsetAngle", "is24hour", "()Z", "set24hour", "(Z)V", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "getSelection-yecRtBI", "setSelection-6_8s6DQ", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AnalogTimePickerState implements TimePickerState {
    public static final int $stable = 8;
    private Animatable<Float, AnimationVector1D> anim;
    private final MutableState currentDiameter$delegate;
    private float hourAngle;
    private float minuteAngle;
    private final MutatorMutex mutex;
    private final TimePickerState state;
    private final Ref<Boolean> userOverride;

    /* JADX INFO: renamed from: androidx.compose.material3.AnalogTimePickerState$animateToCurrent$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationResult;", "", "Landroidx/compose/animation/core/AnimationVector1D;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.AnalogTimePickerState$animateToCurrent$2", f = "TimePicker.kt", i = {}, l = {754}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super AnimationResult<Float, AnimationVector1D>>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $end;
        int label;
        final /* synthetic */ AnalogTimePickerState this$0;

        public AnonymousClass2(AnalogTimePickerState r100, float r101, AnimationSpec<Float> r102, Continuation<? super AnonymousClass2> r103) {
            this.this$0 = r100;
            this.$end = r101;
            this.$animationSpec = r102;
            super(1, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass2(this.this$0, this.$end, this.$animationSpec, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super AnimationResult<Float, AnimationVector1D>> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super AnimationResult<Float, AnimationVector1D>> r100) {
            return ((AnonymousClass2) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L11:
            return r110;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            Animatable r102 = AnalogTimePickerState.access$getAnim$p(this.this$0);
            Float r103 = Boxing.boxFloat(this.$end);
            AnimationSpec<Float> r104 = this.$animationSpec;
            this.label = 1;
            r110 = Animatable.animateTo$default(r102, r103, r104, null, null, this, 12, null);
            if (r110 != r100) goto L11;
            return r100;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.AnalogTimePickerState$onGestureEnd$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationResult;", "", "Landroidx/compose/animation/core/AnimationVector1D;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.AnalogTimePickerState$onGestureEnd$2", f = "TimePicker.kt", i = {}, l = {804}, m = "invokeSuspend", n = {}, s = {})
    public static final class C86852 extends SuspendLambda implements Function1<Continuation<? super AnimationResult<Float, AnimationVector1D>>, Object> {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ float $end;
        int label;
        final /* synthetic */ AnalogTimePickerState this$0;

        public C86852(AnalogTimePickerState r100, float r101, AnimationSpec<Float> r102, Continuation<? super C86852> r103) {
            this.this$0 = r100;
            this.$end = r101;
            this.$animationSpec = r102;
            super(1, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new C86852(this.this$0, this.$end, this.$animationSpec, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super AnimationResult<Float, AnimationVector1D>> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super AnimationResult<Float, AnimationVector1D>> r100) {
            return ((C86852) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L11:
            return r110;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            Animatable r102 = AnalogTimePickerState.access$getAnim$p(this.this$0);
            Float r103 = Boxing.boxFloat(this.$end);
            AnimationSpec<Float> r104 = this.$animationSpec;
            this.label = 1;
            r110 = Animatable.animateTo$default(r102, r103, r104, null, null, this, 12, null);
            if (r110 != r100) goto L11;
            return r100;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.AnalogTimePickerState$rotateTo$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.AnalogTimePickerState$rotateTo$2", f = "TimePicker.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLUSH_SEEK, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_OUTLET_DROPCOUNT_ONCE}, m = "invokeSuspend", n = {}, s = {})
    public static final class C86862 extends SuspendLambda implements Function1<Continuation<? super Object>, Object> {
        final /* synthetic */ float $angle;
        final /* synthetic */ boolean $animate;
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        int label;
        final /* synthetic */ AnalogTimePickerState this$0;

        public C86862(AnalogTimePickerState r100, float r101, boolean r102, AnimationSpec<Float> r103, Continuation<? super C86862> r104) {
            this.this$0 = r100;
            this.$angle = r101;
            this.$animate = r102;
            this.$animationSpec = r103;
            super(1, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new C86862(this.this$0, this.$angle, this.$animate, this.$animationSpec, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Object> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<Object> r100) {
            return ((C86862) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            ResultKt.throwOnFailure(r110);
            return r110;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r110);
        L28:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r110);
            if (TimePickerSelectionMode.m2917equalsimpl0(this.this$0.mo1842getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m2921getHouryecRtBI()) == false) goto L17;
            AnalogTimePickerState r111 = this.this$0;
            int r102 = 12;
            AnalogTimePickerState.access$setHourAngle$p(r111, (AnalogTimePickerState.access$toHour(r111, this.$angle) % 12) * 0.5235988f);
            TimePickerState r112 = this.this$0.getState();
            AnalogTimePickerState r103 = this.this$0;
            int r104 = AnalogTimePickerState.access$toHour(r103, AnalogTimePickerState.access$getHourAngle$p(r103)) % 12;
            if (TimePickerKt.isPm(this.this$0) == true) goto L16;
            r102 = 0;
        L16:
            r112.setHour(r104 + r102);
        L19:
            if (this.$animate == true) goto L24;
            Animatable r113 = AnalogTimePickerState.access$getAnim$p(this.this$0);
            Float r105 = Boxing.boxFloat(AnalogTimePickerState.access$offsetAngle(this.this$0, this.$angle));
            this.label = 1;
            if (r113.snapTo(r105, this) != r100) goto L28;
            return r100;
        L24:
            AnalogTimePickerState r114 = this.this$0;
            float r115 = AnalogTimePickerState.access$endValueForAnimation(r114, AnalogTimePickerState.access$offsetAngle(r114, this.$angle));
            Animatable r106 = AnalogTimePickerState.access$getAnim$p(this.this$0);
            Float r107 = Boxing.boxFloat(r115);
            AnimationSpec<Float> r108 = this.$animationSpec;
            this.label = 2;
            Object r116 = Animatable.animateTo$default(r106, r107, r108, null, null, this, 12, null);
            if (r116 != r100) goto L29;
            return r100;
        L29:
            return r116;
        L17:
            AnalogTimePickerState r117 = this.this$0;
            AnalogTimePickerState.access$setMinuteAngle$p(r117, AnalogTimePickerState.access$toMinute(r117, this.$angle) * 0.10471976f);
            TimePickerState r118 = this.this$0.getState();
            AnalogTimePickerState r109 = this.this$0;
            r118.setMinute(AnalogTimePickerState.access$toMinute(r109, AnalogTimePickerState.access$getMinuteAngle$p(r109)));
            goto L19
        }
    }

    private final float normalize(float r100) {
        double r101 = ((double) r100) % 6.283185307179586d;
        if (r101 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L6;
        r101 = r101 + 6.283185307179586d;
    L6:
        return (float) r101;
    }

    private final float offsetAngle(float r100) {
        float r101 = r100 + 1.5707964f;
        if (r101 < 0.0f) goto L5;
        return r101;
    L5:
        return r101 + 6.2831855f;
    }

    @Override // androidx.compose.material3.TimePickerState
    /* JADX INFO: renamed from: getSelection-yecRtBI, reason: not valid java name */
    public int mo1842getSelectionyecRtBI() {
        return this.state.mo1842getSelectionyecRtBI();
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean is24hour() {
        return this.state.is24hour();
    }

    @Override // androidx.compose.material3.TimePickerState
    public void set24hour(boolean r100) {
        this.state.set24hour(r100);
    }

    @Override // androidx.compose.material3.TimePickerState
    /* JADX INFO: renamed from: setSelection-6_8s6DQ, reason: not valid java name */
    public void mo1844setSelection6_8s6DQ(int r100) {
        this.state.mo1844setSelection6_8s6DQ(r100);
    }

    private final void updateBaseStateMinute() {
        Snapshot.Companion r100 = Snapshot.Companion;
        Snapshot r101 = r100.getCurrentThreadSnapshot();
        if (r101 == null) goto L5;
        Function1<Object, Unit> r102 = r101.getReadObserver();
    L6:
        Snapshot r103 = r100.makeCurrentNonObservable(r101);
        this.state.setMinute(getMinute());     // Catch: Throwable -> L10
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r100.restoreNonObservable(r101, r103, r102);
        return;
    L10:
        th = move-exception;
        r100.restoreNonObservable(r101, r103, r102);
        throw th;
    L5:
        r102 = null;
        goto L6
    }

    public final float getCurrentAngle() {
        return this.anim.getValue().floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getCurrentDiameter-D9Ej5fM, reason: not valid java name */
    public final float m1841getCurrentDiameterD9Ej5fM() {
        return ((Dp) this.currentDiameter$delegate.getValue()).m7558unboximpl();
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getHour() {
        return this.state.getHour();
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getMinute() {
        return this.state.getMinute();
    }

    private final boolean isUpdated() {
        int r100 = mo1842getSelectionyecRtBI();
        TimePickerSelectionMode.Companion r101 = TimePickerSelectionMode.Companion;
        if (TimePickerSelectionMode.m2917equalsimpl0(r100, r101.m2921getHouryecRtBI()) == false) goto L11;
        if (normalize(this.anim.getTargetValue().floatValue()) != normalize(this.hourAngle)) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L11;
        return false;
    L7:
        r102 = false;
    L11:
        if (TimePickerSelectionMode.m2917equalsimpl0(mo1842getSelectionyecRtBI(), r101.m2922getMinuteyecRtBI()) == true) goto L13;
    L18:
        return true;
    L13:
        if (normalize(this.anim.getTargetValue().floatValue()) != normalize(this.minuteAngle)) goto L15;
        boolean r103 = true;
    L16:
        if (r103 == false) goto L18;
        return false;
    L15:
        r103 = false;
        goto L16
    }

    public final IntList getClockFaceValues() {
        if (TimePickerSelectionMode.m2917equalsimpl0(mo1842getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m2922getMinuteyecRtBI()) == false) goto L6;
        return TimePickerKt.access$getMinutes$p();
    L6:
        return TimePickerKt.access$getHours$p();
    }

    public final TimePickerState getState() {
        return this.state;
    }

    public final Ref<Boolean> getUserOverride() {
        return this.userOverride;
    }

    public static final /* synthetic */ Animatable access$getAnim$p(AnalogTimePickerState r100) {
        return r100.anim;
    }

    public static final /* synthetic */ float access$getHourAngle$p(AnalogTimePickerState r100) {
        return r100.hourAngle;
    }

    public static final /* synthetic */ float access$getMinuteAngle$p(AnalogTimePickerState r100) {
        return r100.minuteAngle;
    }

    private final float endValueForAnimation(float r100) {
        float r101 = this.anim.getValue().floatValue() - r100;
    L4:
        if (r101 <= 3.1415927f) goto L7;
        r101 = r101 - 6.2831855f;
    L7:
        if (r101 > (-3.1415927f)) goto L10;
        r101 = r101 + 6.2831855f;
        goto L7
    L10:
        return this.anim.getValue().floatValue() - r101;
    }

    private final int toHour(float r100) {
        return ((int) ((r100 + (((double) 0.2617994f) + 1.5707963267948966d)) / ((double) 0.5235988f))) % 12;
    }

    private final int toMinute(float r100) {
        return ((int) ((r100 + (((double) 0.05235988f) + 1.5707963267948966d)) / ((double) 0.10471976f))) % 60;
    }

    /* JADX INFO: renamed from: setCurrentDiameter-0680j_4, reason: not valid java name */
    public final void m1843setCurrentDiameter0680j_4(float r100) {
        this.currentDiameter$delegate.setValue(Dp.m7542boximpl(r100));
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setHour(int r100) {
        this.hourAngle = ((r100 % 12) * 0.5235988f) - 1.5707964f;
        this.state.setHour(r100);
        if (TimePickerSelectionMode.m2917equalsimpl0(mo1842getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m2921getHouryecRtBI()) == false) goto L6;
        this.anim = AnimatableKt.Animatable$default(this.hourAngle, 0.0f, 2, null);
        return;
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setMinute(int r100) {
        this.minuteAngle = (r100 * 0.10471976f) - 1.5707964f;
        this.state.setMinute(r100);
        if (TimePickerSelectionMode.m2917equalsimpl0(mo1842getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m2922getMinuteyecRtBI()) == false) goto L5;
        this.anim = AnimatableKt.Animatable$default(this.minuteAngle, 0.0f, 2, null);
    L5:
        updateBaseStateMinute();
    }

    public AnalogTimePickerState(TimePickerState r100, Ref<Boolean> r101) {
        this.state = r100;
        this.userOverride = r101;
        this.currentDiameter$delegate = SnapshotStateKt.mutableStateOf$default(Dp.m7542boximpl(Dp.m7544constructorimpl(0)), null, 2, null);
        this.hourAngle = ((r100.getHour() % 12) * 0.5235988f) - 1.5707964f;
        this.minuteAngle = (r100.getMinute() * 0.10471976f) - 1.5707964f;
        this.anim = AnimatableKt.Animatable$default(this.hourAngle, 0.0f, 2, null);
        this.mutex = new MutatorMutex();
    }

    public static final /* synthetic */ float access$endValueForAnimation(AnalogTimePickerState r100, float r101) {
        return r100.endValueForAnimation(r101);
    }

    public static final /* synthetic */ float access$offsetAngle(AnalogTimePickerState r100, float r101) {
        return r100.offsetAngle(r101);
    }

    public static final /* synthetic */ void access$setHourAngle$p(AnalogTimePickerState r100, float r101) {
        r100.hourAngle = r101;
    }

    public static final /* synthetic */ void access$setMinuteAngle$p(AnalogTimePickerState r100, float r101) {
        r100.minuteAngle = r101;
    }

    public static final /* synthetic */ int access$toHour(AnalogTimePickerState r100, float r101) {
        return r100.toHour(r101);
    }

    public static final /* synthetic */ int access$toMinute(AnalogTimePickerState r100, float r101) {
        return r100.toMinute(r101);
    }

    public final Object animateToCurrent(AnimationSpec<Float> r100, Continuation<? super Unit> r101) {
        if (isUpdated() == true) goto L7;
        return Unit.INSTANCE;
    L7:
        if (TimePickerSelectionMode.m2917equalsimpl0(mo1842getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m2921getHouryecRtBI()) == false) goto L9;
        float r102 = endValueForAnimation(this.hourAngle);
    L10:
        Object r103 = this.mutex.mutate(MutatePriority.PreventUserInput, new AnonymousClass2(this, r102, r100, null), r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L14;
        return r103;
    L14:
        return Unit.INSTANCE;
    L9:
        r102 = endValueForAnimation(this.minuteAngle);
        goto L10
    }

    public final Object onGestureEnd(AnimationSpec<Float> r100, Continuation<? super Unit> r101) {
        if (TimePickerSelectionMode.m2917equalsimpl0(mo1842getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m2921getHouryecRtBI()) == false) goto L5;
        float r102 = this.hourAngle;
    L6:
        float r103 = endValueForAnimation(r102);
        Object r104 = this.mutex.mutate(MutatePriority.PreventUserInput, new C86852(this, r103, r100, null), r101);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r104;
    L10:
        return Unit.INSTANCE;
    L5:
        r102 = this.minuteAngle;
        goto L6
    }

    public /* synthetic */ AnalogTimePickerState(TimePickerState r100, Ref r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = new Ref();
    L5:
        this(r100, r101);
    }

    public final Object rotateTo(float r110, AnimationSpec<Float> r111, boolean r112, Continuation<? super Unit> r113) {
        this.userOverride.setValue(Boxing.boxBoolean(false));
        Object r114 = this.mutex.mutate(MutatePriority.UserInput, new C86862(this, r110, r112, r111, null), r113);
        if (r114 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r114;
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object rotateTo$default(AnalogTimePickerState r100, float r101, AnimationSpec r102, boolean r103, Continuation r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L6;
        r103 = false;
    L6:
        return r100.rotateTo(r101, r102, r103, r104);
    }
}
