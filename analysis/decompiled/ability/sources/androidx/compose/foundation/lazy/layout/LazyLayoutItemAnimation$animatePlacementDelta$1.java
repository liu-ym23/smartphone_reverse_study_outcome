package androidx.compose.foundation.lazy.layout;

import C7.r;
import J7.c;
import S7.n;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1", f = "LazyLayoutItemAnimation.kt", l = {151, 158}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class LazyLayoutItemAnimation$animatePlacementDelta$1 extends SuspendLambda implements n {
    final /* synthetic */ FiniteAnimationSpec<IntOffset> $spec;
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutItemAnimation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutItemAnimation$animatePlacementDelta$1(LazyLayoutItemAnimation lazyLayoutItemAnimation, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, long j5, H7.c<? super LazyLayoutItemAnimation$animatePlacementDelta$1> cVar) {
        super(2, cVar);
        this.this$0 = lazyLayoutItemAnimation;
        this.$spec = finiteAnimationSpec;
        this.$totalDelta = j5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new LazyLayoutItemAnimation$animatePlacementDelta$1(this.this$0, this.$spec, this.$totalDelta, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a7, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r12, r4, r5, null, r7, r8, 4, null) != r0) goto L31;
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
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.b.b(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
            r8 = r11
            goto Laa
        L12:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L1a:
            java.lang.Object r1 = r11.L$0
            androidx.compose.animation.core.FiniteAnimationSpec r1 = (androidx.compose.animation.core.FiniteAnimationSpec) r1
            kotlin.b.b(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
            goto L66
        L22:
            kotlin.b.b(r12)
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r11.this$0     // Catch: java.util.concurrent.CancellationException -> Lb5
            androidx.compose.animation.core.Animatable r12 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.access$getPlacementDeltaAnimation$p(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
            boolean r12 = r12.isRunning()     // Catch: java.util.concurrent.CancellationException -> Lb5
            if (r12 == 0) goto L40
            androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.unit.IntOffset> r12 = r11.$spec     // Catch: java.util.concurrent.CancellationException -> Lb5
            boolean r1 = r12 instanceof androidx.compose.animation.core.SpringSpec     // Catch: java.util.concurrent.CancellationException -> Lb5
            if (r1 == 0) goto L3a
            androidx.compose.animation.core.SpringSpec r12 = (androidx.compose.animation.core.SpringSpec) r12     // Catch: java.util.concurrent.CancellationException -> Lb5
            goto L3e
        L3a:
            androidx.compose.animation.core.SpringSpec r12 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimationKt.access$getInterruptionSpec$p()     // Catch: java.util.concurrent.CancellationException -> Lb5
        L3e:
            r1 = r12
            goto L43
        L40:
            androidx.compose.animation.core.FiniteAnimationSpec<androidx.compose.ui.unit.IntOffset> r12 = r11.$spec     // Catch: java.util.concurrent.CancellationException -> Lb5
            goto L3e
        L43:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r11.this$0     // Catch: java.util.concurrent.CancellationException -> Lb5
            androidx.compose.animation.core.Animatable r12 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.access$getPlacementDeltaAnimation$p(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
            boolean r12 = r12.isRunning()     // Catch: java.util.concurrent.CancellationException -> Lb5
            if (r12 != 0) goto L6f
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r11.this$0     // Catch: java.util.concurrent.CancellationException -> Lb5
            androidx.compose.animation.core.Animatable r12 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.access$getPlacementDeltaAnimation$p(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
            long r4 = r11.$totalDelta     // Catch: java.util.concurrent.CancellationException -> Lb5
            androidx.compose.ui.unit.IntOffset r4 = androidx.compose.ui.unit.IntOffset.m6963boximpl(r4)     // Catch: java.util.concurrent.CancellationException -> Lb5
            r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> Lb5
            r11.label = r3     // Catch: java.util.concurrent.CancellationException -> Lb5
            java.lang.Object r12 = r12.snapTo(r4, r11)     // Catch: java.util.concurrent.CancellationException -> Lb5
            if (r12 != r0) goto L66
            goto La9
        L66:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r11.this$0     // Catch: java.util.concurrent.CancellationException -> Lb5
            S7.a r12 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.access$getOnLayerPropertyChanged$p(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
            r12.invoke()     // Catch: java.util.concurrent.CancellationException -> Lb5
        L6f:
            r5 = r1
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r11.this$0     // Catch: java.util.concurrent.CancellationException -> Lb5
            androidx.compose.animation.core.Animatable r12 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.access$getPlacementDeltaAnimation$p(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
            java.lang.Object r12 = r12.getValue()     // Catch: java.util.concurrent.CancellationException -> Lb5
            androidx.compose.ui.unit.IntOffset r12 = (androidx.compose.ui.unit.IntOffset) r12     // Catch: java.util.concurrent.CancellationException -> Lb5
            long r3 = r12.m6981unboximpl()     // Catch: java.util.concurrent.CancellationException -> Lb5
            long r6 = r11.$totalDelta     // Catch: java.util.concurrent.CancellationException -> Lb5
            long r3 = androidx.compose.ui.unit.IntOffset.m6975minusqkQi6aY(r3, r6)     // Catch: java.util.concurrent.CancellationException -> Lb5
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r11.this$0     // Catch: java.util.concurrent.CancellationException -> Lb5
            androidx.compose.animation.core.Animatable r12 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.access$getPlacementDeltaAnimation$p(r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
            r6 = r3
            androidx.compose.ui.unit.IntOffset r4 = androidx.compose.ui.unit.IntOffset.m6963boximpl(r6)     // Catch: java.util.concurrent.CancellationException -> Lb5
            r8 = r6
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1$1 r7 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1$1     // Catch: java.util.concurrent.CancellationException -> Lb5
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r1 = r11.this$0     // Catch: java.util.concurrent.CancellationException -> Lb5
            r7.<init>()     // Catch: java.util.concurrent.CancellationException -> Lb5
            r1 = 0
            r11.L$0 = r1     // Catch: java.util.concurrent.CancellationException -> Lb5
            r11.label = r2     // Catch: java.util.concurrent.CancellationException -> Lb5
            r6 = 0
            r9 = 4
            r10 = 0
            r8 = r11
            r3 = r12
            java.lang.Object r11 = androidx.compose.animation.core.Animatable.animateTo$default(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> Lb5
            if (r11 != r0) goto Laa
        La9:
            return r0
        Laa:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r11 = r8.this$0     // Catch: java.util.concurrent.CancellationException -> Lb5
            r12 = 0
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.access$setPlacementAnimationInProgress(r11, r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r11 = r8.this$0     // Catch: java.util.concurrent.CancellationException -> Lb5
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.access$setRunningMovingAwayAnimation$p(r11, r12)     // Catch: java.util.concurrent.CancellationException -> Lb5
        Lb5:
            C7.r r11 = C7.r.f317a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((LazyLayoutItemAnimation$animatePlacementDelta$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
