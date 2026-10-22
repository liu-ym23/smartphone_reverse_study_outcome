package androidx.compose.material3;

import C7.r;
import S7.k;
import androidx.collection.IntList;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.TimePickerSelectionMode;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.runtime.snapshots.Snapshot;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005H\u0086@¢\u0006\u0004\b\b\u0010\u0007J\"\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\t*\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u0013\u0010\u0018\u001a\u00020\u0017*\u00020\tH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u0017*\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001b\u0010\u0013R\u0017\u0010\u0002\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\"\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010)\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u00020\u000b8\u0016@\u0016X\u0096\u000f¢\u0006\f\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010+R\"\u00103\u001a\u00020.8\u0016@\u0016X\u0096\u000fø\u0001\u0000ø\u0001\u0001¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0011\u00106\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b4\u00105R\u0011\u0010:\u001a\u0002078F¢\u0006\u0006\u001a\u0004\b8\u00109R$\u0010>\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b<\u00100\"\u0004\b=\u00102R$\u0010A\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u00178V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b?\u00100\"\u0004\b@\u00102\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/compose/material3/AnalogTimePickerState;", "Landroidx/compose/material3/TimePickerState;", "state", AppAgent.CONSTRUCT, "(Landroidx/compose/material3/TimePickerState;)V", "LC7/r;", "animateToCurrent", "(LH7/c;)Ljava/lang/Object;", "onGestureEnd", "", "angle", "", "animate", "rotateTo", "(FZLH7/c;)Ljava/lang/Object;", "isUpdated", "()Z", "new", "endValueForAnimation", "(F)F", "updateBaseStateMinute", "()V", "normalize", "", "toHour", "(F)I", "toMinute", "offsetAngle", "Landroidx/compose/material3/TimePickerState;", "getState", "()Landroidx/compose/material3/TimePickerState;", "hourAngle", "F", "minuteAngle", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "anim", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/foundation/MutatorMutex;", "mutex", "Landroidx/compose/foundation/MutatorMutex;", "is24hour", "set24hour", "(Z)V", "isAfternoon", "setAfternoon", "Landroidx/compose/material3/TimePickerSelectionMode;", "getSelection-yecRtBI", "()I", "setSelection-6_8s6DQ", "(I)V", "selection", "getCurrentAngle", "()F", "currentAngle", "Landroidx/collection/IntList;", "getClockFaceValues", "()Landroidx/collection/IntList;", "clockFaceValues", "value", "getMinute", "setMinute", "minute", "getHour", "setHour", "hour", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnalogTimePickerState implements TimePickerState {
    public static final int $stable = 8;
    private Animatable<Float, AnimationVector1D> anim;
    private float hourAngle;
    private float minuteAngle;
    private final MutatorMutex mutex = new MutatorMutex();
    private final TimePickerState state;

    @J7.c(c = "androidx.compose.material3.AnalogTimePickerState$animateToCurrent$2", f = "TimePicker.kt", l = {738}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationResult;", "", "Landroidx/compose/animation/core/AnimationVector1D;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material3.AnalogTimePickerState$animateToCurrent$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements k {
        final /* synthetic */ float $end;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(float f, H7.c<? super AnonymousClass2> cVar) {
            super(1, cVar);
            this.$end = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(H7.c<?> cVar) {
            return AnalogTimePickerState.this.new AnonymousClass2(this.$end, cVar);
        }

        @Override // S7.k
        public final Object invoke(H7.c<? super AnimationResult<Float, AnimationVector1D>> cVar) {
            return ((AnonymousClass2) create(cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            Animatable animatable = AnalogTimePickerState.this.anim;
            Float f = new Float(this.$end);
            SpringSpec springSpecSpring$default = AnimationSpecKt.spring$default(1.0f, 700.0f, null, 4, null);
            this.label = 1;
            Object objAnimateTo$default = Animatable.animateTo$default(animatable, f, springSpecSpring$default, null, null, this, 12, null);
            return objAnimateTo$default == coroutineSingletons ? coroutineSingletons : objAnimateTo$default;
        }
    }

    @J7.c(c = "androidx.compose.material3.AnalogTimePickerState$onGestureEnd$2", f = "TimePicker.kt", l = {789}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/animation/core/AnimationResult;", "", "Landroidx/compose/animation/core/AnimationVector1D;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material3.AnalogTimePickerState$onGestureEnd$2, reason: invalid class name and case insensitive filesystem */
    public static final class C05422 extends SuspendLambda implements k {
        final /* synthetic */ float $end;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C05422(float f, H7.c<? super C05422> cVar) {
            super(1, cVar);
            this.$end = f;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(H7.c<?> cVar) {
            return AnalogTimePickerState.this.new C05422(this.$end, cVar);
        }

        @Override // S7.k
        public final Object invoke(H7.c<? super AnimationResult<Float, AnimationVector1D>> cVar) {
            return ((C05422) create(cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            Animatable animatable = AnalogTimePickerState.this.anim;
            Float f = new Float(this.$end);
            SpringSpec springSpecSpring$default = AnimationSpecKt.spring$default(0.0f, 0.0f, null, 7, null);
            this.label = 1;
            Object objAnimateTo$default = Animatable.animateTo$default(animatable, f, springSpecSpring$default, null, null, this, 12, null);
            return objAnimateTo$default == coroutineSingletons ? coroutineSingletons : objAnimateTo$default;
        }
    }

    @J7.c(c = "androidx.compose.material3.AnalogTimePickerState$rotateTo$2", f = "TimePicker.kt", l = {803, 806}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material3.AnalogTimePickerState$rotateTo$2, reason: invalid class name and case insensitive filesystem */
    public static final class C05432 extends SuspendLambda implements k {
        final /* synthetic */ float $angle;
        final /* synthetic */ boolean $animate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C05432(float f, boolean z10, H7.c<? super C05432> cVar) {
            super(1, cVar);
            this.$angle = f;
            this.$animate = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(H7.c<?> cVar) {
            return AnalogTimePickerState.this.new C05432(this.$angle, this.$animate, cVar);
        }

        @Override // S7.k
        public final Object invoke(H7.c<Object> cVar) {
            return ((C05432) create(cVar)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x00a5, code lost:
        
            if (r12.snapTo(r2, r11) == r0) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r11.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1d
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.b.b(r12)
                return r12
            L10:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L18:
                kotlin.b.b(r12)
                goto La8
            L1d:
                kotlin.b.b(r12)
                androidx.compose.material3.AnalogTimePickerState r12 = androidx.compose.material3.AnalogTimePickerState.this
                int r12 = r12.mo1501getSelectionyecRtBI()
                androidx.compose.material3.TimePickerSelectionMode$Companion r1 = androidx.compose.material3.TimePickerSelectionMode.INSTANCE
                int r1 = r1.m2525getHouryecRtBI()
                boolean r12 = androidx.compose.material3.TimePickerSelectionMode.m2521equalsimpl0(r12, r1)
                if (r12 == 0) goto L65
                androidx.compose.material3.AnalogTimePickerState r12 = androidx.compose.material3.AnalogTimePickerState.this
                float r1 = r11.$angle
                int r1 = androidx.compose.material3.AnalogTimePickerState.access$toHour(r12, r1)
                r4 = 12
                int r1 = r1 % r4
                float r1 = (float) r1
                r5 = 1057360530(0x3f060a92, float:0.5235988)
                float r1 = r1 * r5
                androidx.compose.material3.AnalogTimePickerState.access$setHourAngle$p(r12, r1)
                androidx.compose.material3.AnalogTimePickerState r12 = androidx.compose.material3.AnalogTimePickerState.this
                androidx.compose.material3.TimePickerState r12 = r12.getState()
                androidx.compose.material3.AnalogTimePickerState r1 = androidx.compose.material3.AnalogTimePickerState.this
                float r5 = androidx.compose.material3.AnalogTimePickerState.access$getHourAngle$p(r1)
                int r1 = androidx.compose.material3.AnalogTimePickerState.access$toHour(r1, r5)
                int r1 = r1 % r4
                androidx.compose.material3.AnalogTimePickerState r5 = androidx.compose.material3.AnalogTimePickerState.this
                boolean r5 = r5.isAfternoon()
                if (r5 == 0) goto L5f
                goto L60
            L5f:
                r4 = 0
            L60:
                int r1 = r1 + r4
                r12.setHour(r1)
                goto L88
            L65:
                androidx.compose.material3.AnalogTimePickerState r12 = androidx.compose.material3.AnalogTimePickerState.this
                float r1 = r11.$angle
                int r1 = androidx.compose.material3.AnalogTimePickerState.access$toMinute(r12, r1)
                float r1 = (float) r1
                r4 = 1037465424(0x3dd67750, float:0.10471976)
                float r1 = r1 * r4
                androidx.compose.material3.AnalogTimePickerState.access$setMinuteAngle$p(r12, r1)
                androidx.compose.material3.AnalogTimePickerState r12 = androidx.compose.material3.AnalogTimePickerState.this
                androidx.compose.material3.TimePickerState r12 = r12.getState()
                androidx.compose.material3.AnalogTimePickerState r1 = androidx.compose.material3.AnalogTimePickerState.this
                float r4 = androidx.compose.material3.AnalogTimePickerState.access$getMinuteAngle$p(r1)
                int r1 = androidx.compose.material3.AnalogTimePickerState.access$toMinute(r1, r4)
                r12.setMinute(r1)
            L88:
                boolean r12 = r11.$animate
                if (r12 != 0) goto Lab
                androidx.compose.material3.AnalogTimePickerState r12 = androidx.compose.material3.AnalogTimePickerState.this
                androidx.compose.animation.core.Animatable r12 = androidx.compose.material3.AnalogTimePickerState.access$getAnim$p(r12)
                androidx.compose.material3.AnalogTimePickerState r1 = androidx.compose.material3.AnalogTimePickerState.this
                float r2 = r11.$angle
                float r1 = androidx.compose.material3.AnalogTimePickerState.access$offsetAngle(r1, r2)
                java.lang.Float r2 = new java.lang.Float
                r2.<init>(r1)
                r11.label = r3
                java.lang.Object r11 = r12.snapTo(r2, r11)
                if (r11 != r0) goto La8
                goto Ld9
            La8:
                C7.r r11 = C7.r.f317a
                return r11
            Lab:
                androidx.compose.material3.AnalogTimePickerState r12 = androidx.compose.material3.AnalogTimePickerState.this
                float r1 = r11.$angle
                float r1 = androidx.compose.material3.AnalogTimePickerState.access$offsetAngle(r12, r1)
                float r12 = androidx.compose.material3.AnalogTimePickerState.access$endValueForAnimation(r12, r1)
                androidx.compose.material3.AnalogTimePickerState r1 = androidx.compose.material3.AnalogTimePickerState.this
                androidx.compose.animation.core.Animatable r3 = androidx.compose.material3.AnalogTimePickerState.access$getAnim$p(r1)
                java.lang.Float r4 = new java.lang.Float
                r4.<init>(r12)
                r12 = 1143930880(0x442f0000, float:700.0)
                r1 = 4
                r5 = 1065353216(0x3f800000, float:1.0)
                r6 = 0
                androidx.compose.animation.core.SpringSpec r5 = androidx.compose.animation.core.AnimationSpecKt.spring$default(r5, r12, r6, r1, r6)
                r11.label = r2
                r7 = 0
                r9 = 12
                r10 = 0
                r8 = r11
                java.lang.Object r11 = androidx.compose.animation.core.Animatable.animateTo$default(r3, r4, r5, r6, r7, r8, r9, r10)
                if (r11 != r0) goto Lda
            Ld9:
                return r0
            Lda:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AnalogTimePickerState.C05432.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public AnalogTimePickerState(TimePickerState timePickerState) {
        this.state = timePickerState;
        this.hourAngle = ((timePickerState.getHour() % 12) * 0.5235988f) - 1.5707964f;
        this.minuteAngle = (timePickerState.getMinute() * 0.10471976f) - 1.5707964f;
        this.anim = AnimatableKt.Animatable$default(this.hourAngle, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float endValueForAnimation(float f) {
        float fFloatValue = this.anim.getValue().floatValue() - f;
        while (fFloatValue > 3.1415927f) {
            fFloatValue -= 6.2831855f;
        }
        while (fFloatValue <= -3.1415927f) {
            fFloatValue += 6.2831855f;
        }
        return this.anim.getValue().floatValue() - fFloatValue;
    }

    private final boolean isUpdated() {
        int iMo1501getSelectionyecRtBI = mo1501getSelectionyecRtBI();
        TimePickerSelectionMode.Companion companion = TimePickerSelectionMode.INSTANCE;
        if (TimePickerSelectionMode.m2521equalsimpl0(iMo1501getSelectionyecRtBI, companion.m2525getHouryecRtBI()) && normalize(this.anim.getTargetValue().floatValue()) == normalize(this.hourAngle)) {
            return false;
        }
        return (TimePickerSelectionMode.m2521equalsimpl0(mo1501getSelectionyecRtBI(), companion.m2526getMinuteyecRtBI()) && normalize(this.anim.getTargetValue().floatValue()) == normalize(this.minuteAngle)) ? false : true;
    }

    private final float normalize(float f) {
        double d = f % 6.283185307179586d;
        if (d < 0.0d) {
            d += 6.283185307179586d;
        }
        return (float) d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float offsetAngle(float angle) {
        float f = angle + 1.5707964f;
        return f < 0.0f ? f + 6.2831855f : f;
    }

    public static /* synthetic */ Object rotateTo$default(AnalogTimePickerState analogTimePickerState, float f, boolean z10, H7.c cVar, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = false;
        }
        return analogTimePickerState.rotateTo(f, z10, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toHour(float f) {
        return ((int) ((f + (0.2617994f + 1.5707963267948966d)) / 0.5235988f)) % 12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int toMinute(float f) {
        return ((int) ((f + (0.05235988f + 1.5707963267948966d)) / 0.10471976f)) % 60;
    }

    private final void updateBaseStateMinute() {
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        k readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            this.state.setMinute(getMinute());
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    public final Object animateToCurrent(H7.c<? super r> cVar) {
        boolean zIsUpdated = isUpdated();
        r rVar = r.f317a;
        if (!zIsUpdated) {
            return rVar;
        }
        Object objMutate = this.mutex.mutate(MutatePriority.PreventUserInput, new AnonymousClass2(TimePickerSelectionMode.m2521equalsimpl0(mo1501getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m2525getHouryecRtBI()) ? endValueForAnimation(this.hourAngle) : endValueForAnimation(this.minuteAngle), null), cVar);
        return objMutate == CoroutineSingletons.f4909a ? objMutate : rVar;
    }

    public final IntList getClockFaceValues() {
        return TimePickerSelectionMode.m2521equalsimpl0(mo1501getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m2526getMinuteyecRtBI()) ? TimePickerKt.Minutes : TimePickerKt.Hours;
    }

    public final float getCurrentAngle() {
        return this.anim.getValue().floatValue();
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getHour() {
        return this.state.getHour();
    }

    @Override // androidx.compose.material3.TimePickerState
    public int getMinute() {
        return this.state.getMinute();
    }

    @Override // androidx.compose.material3.TimePickerState
    /* renamed from: getSelection-yecRtBI, reason: not valid java name */
    public int mo1501getSelectionyecRtBI() {
        return this.state.mo1501getSelectionyecRtBI();
    }

    public final TimePickerState getState() {
        return this.state;
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean is24hour() {
        return this.state.is24hour();
    }

    @Override // androidx.compose.material3.TimePickerState
    public boolean isAfternoon() {
        return this.state.isAfternoon();
    }

    public final Object onGestureEnd(H7.c<? super r> cVar) {
        Object objMutate = this.mutex.mutate(MutatePriority.PreventUserInput, new C05422(endValueForAnimation(TimePickerSelectionMode.m2521equalsimpl0(mo1501getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m2525getHouryecRtBI()) ? this.hourAngle : this.minuteAngle), null), cVar);
        return objMutate == CoroutineSingletons.f4909a ? objMutate : r.f317a;
    }

    public final Object rotateTo(float f, boolean z10, H7.c<? super r> cVar) {
        Object objMutate = this.mutex.mutate(MutatePriority.UserInput, new C05432(f, z10, null), cVar);
        return objMutate == CoroutineSingletons.f4909a ? objMutate : r.f317a;
    }

    @Override // androidx.compose.material3.TimePickerState
    public void set24hour(boolean z10) {
        this.state.set24hour(z10);
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setAfternoon(boolean z10) {
        this.state.setAfternoon(z10);
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setHour(int i) {
        this.hourAngle = ((i % 12) * 0.5235988f) - 1.5707964f;
        this.state.setHour(i);
        if (TimePickerSelectionMode.m2521equalsimpl0(mo1501getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m2525getHouryecRtBI())) {
            this.anim = AnimatableKt.Animatable$default(this.hourAngle, 0.0f, 2, null);
        }
    }

    @Override // androidx.compose.material3.TimePickerState
    public void setMinute(int i) {
        this.minuteAngle = (i * 0.10471976f) - 1.5707964f;
        this.state.setMinute(i);
        if (TimePickerSelectionMode.m2521equalsimpl0(mo1501getSelectionyecRtBI(), TimePickerSelectionMode.INSTANCE.m2526getMinuteyecRtBI())) {
            this.anim = AnimatableKt.Animatable$default(this.minuteAngle, 0.0f, 2, null);
        }
        updateBaseStateMinute();
    }

    @Override // androidx.compose.material3.TimePickerState
    /* renamed from: setSelection-6_8s6DQ, reason: not valid java name */
    public void mo1502setSelection6_8s6DQ(int i) {
        this.state.mo1502setSelection6_8s6DQ(i);
    }
}
