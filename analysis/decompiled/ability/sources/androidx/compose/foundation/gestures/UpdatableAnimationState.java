package androidx.compose.foundation.gestures;

import J7.c;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.f;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J=\u0010\f\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0086@\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState;", "", "Landroidx/compose/animation/core/AnimationSpec;", "", "animationSpec", AppAgent.CONSTRUCT, "(Landroidx/compose/animation/core/AnimationSpec;)V", "Lkotlin/Function1;", "LC7/r;", "beforeFrame", "Lkotlin/Function0;", "afterFrame", "animateToZero", "(LS7/k;LS7/a;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "Landroidx/compose/animation/core/AnimationVector1D;", "vectorizedSpec", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "", "lastFrameTime", "J", "lastVelocity", "Landroidx/compose/animation/core/AnimationVector1D;", "", "isRunning", "Z", "value", "F", "getValue", "()F", "setValue", "(F)V", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UpdatableAnimationState {

    @Deprecated
    public static final float VisibilityThreshold = 0.01f;
    private boolean isRunning;
    private long lastFrameTime = Long.MIN_VALUE;
    private AnimationVector1D lastVelocity = ZeroVector;
    private float value;
    private final VectorizedAnimationSpec<AnimationVector1D> vectorizedSpec;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final AnimationVector1D ZeroVector = new AnimationVector1D(0.0f);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\t\u001a\u00020\n*\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/gestures/UpdatableAnimationState$Companion;", "", "()V", "VisibilityThreshold", "", "ZeroVector", "Landroidx/compose/animation/core/AnimationVector1D;", "getZeroVector", "()Landroidx/compose/animation/core/AnimationVector1D;", "isZeroish", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final AnimationVector1D getZeroVector() {
            return UpdatableAnimationState.ZeroVector;
        }

        public final boolean isZeroish(float f) {
            return Math.abs(f) < 0.01f;
        }

        private Companion() {
        }
    }

    @c(c = "androidx.compose.foundation.gestures.UpdatableAnimationState", f = "UpdatableAnimationState.kt", l = {101, 147}, m = "animateToZero")
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UpdatableAnimationState.this.animateToZero(null, null, this);
        }
    }

    public UpdatableAnimationState(AnimationSpec<Float> animationSpec) {
        this.vectorizedSpec = animationSpec.vectorize(VectorConvertersKt.getVectorConverter(f.f4924a));
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c9, code lost:
    
        if (androidx.compose.runtime.MonotonicFrameClockKt.withFrameNanos(r14, r0) == r1) goto L47;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007b A[Catch: all -> 0x00a7, PHI: r11 r12 r13 r14
      0x007b: PHI (r11v6 'this' androidx.compose.foundation.gestures.UpdatableAnimationState) = 
      (r11v0 'this' androidx.compose.foundation.gestures.UpdatableAnimationState A[IMMUTABLE_TYPE, THIS])
      (r11v7 'this' androidx.compose.foundation.gestures.UpdatableAnimationState)
     binds: [B:30:0x0079, B:38:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x007b: PHI (r12v6 S7.k) = (r12v24 S7.k), (r12v25 S7.k) binds: [B:30:0x0079, B:38:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x007b: PHI (r13v6 S7.a) = (r13v0 S7.a), (r13v7 S7.a) binds: [B:30:0x0079, B:38:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x007b: PHI (r14v13 float) = (r14v7 float), (r14v14 float) binds: [B:30:0x0079, B:38:0x00a0] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x00a7, blocks: (B:36:0x009b, B:31:0x007b, B:33:0x0085), top: B:55:0x009b }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085 A[Catch: all -> 0x00a7, TryCatch #0 {all -> 0x00a7, blocks: (B:36:0x009b, B:31:0x007b, B:33:0x0085), top: B:55:0x009b }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2 A[PHI: r11 r12 r13
      0x00a2: PHI (r11v4 'this' androidx.compose.foundation.gestures.UpdatableAnimationState) = 
      (r11v6 'this' androidx.compose.foundation.gestures.UpdatableAnimationState)
      (r11v7 'this' androidx.compose.foundation.gestures.UpdatableAnimationState)
     binds: [B:32:0x0083, B:38:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r12v4 S7.k) = (r12v26 S7.k), (r12v27 S7.k) binds: [B:32:0x0083, B:38:0x00a0] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r13v2 S7.a) = (r13v6 S7.a), (r13v7 S7.a) binds: [B:32:0x0083, B:38:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v19 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0098 -> B:55:0x009b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object animateToZero(S7.k r12, S7.a r13, H7.c<? super C7.r> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.UpdatableAnimationState.animateToZero(S7.k, S7.a, H7.c):java.lang.Object");
    }

    public final float getValue() {
        return this.value;
    }

    public final void setValue(float f) {
        this.value = f;
    }
}
