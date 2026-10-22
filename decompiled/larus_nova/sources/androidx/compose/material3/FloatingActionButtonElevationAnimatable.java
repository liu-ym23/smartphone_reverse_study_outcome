package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.material3.internal.ElevationKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0010\u001a\u00020\u0003*\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0086@¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0018J\u0018\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eH\u0086@¢\u0006\u0002\u0010\u001bJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001dR\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/FloatingActionButtonElevationAnimatable;", "", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "hoveredElevation", "focusedElevation", "<init>", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", FaceService.girlLabel, "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "lastTargetInteraction", "Landroidx/compose/foundation/interaction/Interaction;", "targetInteraction", "calculateTarget", "calculateTarget-u2uoSUM", "(Landroidx/compose/foundation/interaction/Interaction;)F", "updateElevation", "", "updateElevation-lDy3nrA", "(FFFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapElevation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateElevation", RemoteMessageConst.TO, "(Landroidx/compose/foundation/interaction/Interaction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "asState", "Landroidx/compose/runtime/State;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class FloatingActionButtonElevationAnimatable {
    private final Animatable<Dp, AnimationVector1D> animatable;
    private float defaultElevation;
    private float focusedElevation;
    private float hoveredElevation;
    private Interaction lastTargetInteraction;
    private float pressedElevation;
    private Interaction targetInteraction;

    /* JADX INFO: renamed from: androidx.compose.material3.FloatingActionButtonElevationAnimatable$animateElevation$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.FloatingActionButtonElevationAnimatable", f = "FloatingActionButton.kt", i = {0}, l = {753}, m = "animateElevation", n = {RemoteMessageConst.TO}, s = {"L$0"})
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FloatingActionButtonElevationAnimatable this$0;

        public AnonymousClass1(FloatingActionButtonElevationAnimatable r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.animateElevation(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.FloatingActionButtonElevationAnimatable$snapElevation$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.FloatingActionButtonElevationAnimatable", f = "FloatingActionButton.kt", i = {}, l = {TTVideoEngineInterface.NETWORK_PREDICTOR_DEFAULT_INITIAL_SPEED}, m = "snapElevation", n = {}, s = {})
    public static final class C86961 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ FloatingActionButtonElevationAnimatable this$0;

        public C86961(FloatingActionButtonElevationAnimatable r100, Continuation<? super C86961> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return FloatingActionButtonElevationAnimatable.access$snapElevation(this.this$0, this);
        }
    }

    public /* synthetic */ FloatingActionButtonElevationAnimatable(float r100, float r101, float r102, float r103, DefaultConstructorMarker r104) {
        this(r100, r101, r102, r103);
    }

    public final State<Dp> asState() {
        return this.animatable.asState();
    }

    /* JADX INFO: renamed from: calculateTarget-u2uoSUM, reason: not valid java name */
    private final float m2248calculateTargetu2uoSUM(Interaction r100) {
        if ((r100 instanceof PressInteraction.Press) == false) goto L6;
        return this.pressedElevation;
    L6:
        if ((r100 instanceof HoverInteraction.Enter) == false) goto L9;
        return this.hoveredElevation;
    L9:
        if ((r100 instanceof FocusInteraction.Focus) == false) goto L12;
        return this.focusedElevation;
    L12:
        return this.defaultElevation;
    }

    private final Object snapElevation(Continuation<? super Unit> r100) {
        if ((r100 instanceof C86961) == false) goto L7;
        C86961 r101 = (C86961) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L17;
        if (r105 != 1) goto L16;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L13
    L22:
        this.lastTargetInteraction = this.targetInteraction;
    L26:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r103);
        float r106 = m2248calculateTargetu2uoSUM(this.targetInteraction);
        if (Dp.m7549equalsimpl0(this.animatable.getTargetValue().m7558unboximpl(), r106) == true) goto L26;
        Animatable<Dp, AnimationVector1D> r107 = this.animatable;     // Catch: Throwable -> L13
        Dp r108 = Dp.m7542boximpl(r106);     // Catch: Throwable -> L13
        r101.label = 1;     // Catch: Throwable -> L13
        if (r107.snapTo(r108, r101) != r104) goto L22;
        return r104;
    L13:
        th = move-exception;
        this.lastTargetInteraction = this.targetInteraction;
        throw th;
    L7:
        r101 = new C86961(this, r100);
        goto L8
    }

    public static final /* synthetic */ Object access$snapElevation(FloatingActionButtonElevationAnimatable r100, Continuation r101) {
        return r100.snapElevation(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [androidx.compose.foundation.interaction.Interaction, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v1, types: [androidx.compose.foundation.interaction.Interaction] */
    /* JADX WARN: Type inference failed for: r6v2, types: [androidx.compose.foundation.interaction.Interaction] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, kotlin.Unit] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    public final Object animateElevation(Interaction r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r102 = (AnonymousClass1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L16;
        if (r106 != 1) goto L15;
        Interaction r107 = (Interaction) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L24
        ?? r108 = r107;
    L22:
        this.lastTargetInteraction = r108;
        r100 = Unit.INSTANCE;
        return r100;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r104);
        float r109 = m2248calculateTargetu2uoSUM(r100);
        this.targetInteraction = r100;
        r108 = r100;
        if (Dp.m7549equalsimpl0(this.animatable.getTargetValue().m7558unboximpl(), r109) == true) goto L22;
        Animatable<Dp, AnimationVector1D> r110 = this.animatable;     // Catch: Throwable -> L24
        Interaction r111 = this.lastTargetInteraction;     // Catch: Throwable -> L24
        r102.L$0 = r100;     // Catch: Throwable -> L24
        r102.label = 1;     // Catch: Throwable -> L24
        Object r112 = ElevationKt.m3142animateElevationrAjV9yQ(r110, r109, r111, r100, r102);     // Catch: Throwable -> L24
        r108 = r100;
        if (r112 != r105) goto L22;
        return r105;
    L24:
        th = move-exception;
        this.lastTargetInteraction = r100;
        throw th;
    L7:
        r102 = new AnonymousClass1(this, r101);
        goto L8
    }

    private FloatingActionButtonElevationAnimatable(float r100, float r101, float r110, float r111) {
        this.defaultElevation = r100;
        this.pressedElevation = r101;
        this.hoveredElevation = r110;
        this.focusedElevation = r111;
        this.animatable = new Animatable(Dp.m7542boximpl(r100), VectorConvertersKt.getVectorConverter(Dp.Companion), null, null, 12, null);
    }

    /* JADX INFO: renamed from: updateElevation-lDy3nrA, reason: not valid java name */
    public final Object m2249updateElevationlDy3nrA(float r100, float r101, float r102, float r103, Continuation<? super Unit> r104) {
        this.defaultElevation = r100;
        this.pressedElevation = r101;
        this.hoveredElevation = r102;
        this.focusedElevation = r103;
        Object r105 = snapElevation(r104);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r105;
    L6:
        return Unit.INSTANCE;
    }
}
