package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "androidx.compose.material3.SelectableChipElevation$animateElevation$2$1", f = "Chip.kt", l = {2380, 2382}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class SelectableChipElevation$animateElevation$2$1 extends SuspendLambda implements n {
    final /* synthetic */ Animatable<Dp, AnimationVector1D> $animatable;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Interaction $interaction;
    final /* synthetic */ MutableState<Interaction> $lastInteraction$delegate;
    final /* synthetic */ float $target;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectableChipElevation$animateElevation$2$1(Animatable<Dp, AnimationVector1D> animatable, float f, boolean z10, Interaction interaction, MutableState<Interaction> mutableState, H7.c<? super SelectableChipElevation$animateElevation$2$1> cVar) {
        super(2, cVar);
        this.$animatable = animatable;
        this.$target = f;
        this.$enabled = z10;
        this.$interaction = interaction;
        this.$lastInteraction$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new SelectableChipElevation$animateElevation$2$1(this.$animatable, this.$target, this.$enabled, this.$interaction, this.$lastInteraction$delegate, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0042, code lost:
    
        if (r6.snapTo(r1, r5) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        if (androidx.compose.material3.internal.ElevationKt.m2678animateElevationrAjV9yQ(r1, r3, r6, r4, r5) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0059, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r5.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L19
            if (r1 == r3) goto L15
            if (r1 != r2) goto Ld
            goto L15
        Ld:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L15:
            kotlin.b.b(r6)
            goto L5a
        L19:
            kotlin.b.b(r6)
            androidx.compose.animation.core.Animatable<androidx.compose.ui.unit.Dp, androidx.compose.animation.core.AnimationVector1D> r6 = r5.$animatable
            java.lang.Object r6 = r6.getTargetValue()
            androidx.compose.ui.unit.Dp r6 = (androidx.compose.ui.unit.Dp) r6
            float r6 = r6.m6858unboximpl()
            float r1 = r5.$target
            boolean r6 = androidx.compose.ui.unit.Dp.m6849equalsimpl0(r6, r1)
            if (r6 != 0) goto L61
            boolean r6 = r5.$enabled
            if (r6 != 0) goto L45
            androidx.compose.animation.core.Animatable<androidx.compose.ui.unit.Dp, androidx.compose.animation.core.AnimationVector1D> r6 = r5.$animatable
            float r1 = r5.$target
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.m6842boximpl(r1)
            r5.label = r3
            java.lang.Object r6 = r6.snapTo(r1, r5)
            if (r6 != r0) goto L5a
            goto L59
        L45:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.Interaction> r6 = r5.$lastInteraction$delegate
            androidx.compose.foundation.interaction.Interaction r6 = androidx.compose.material3.SelectableChipElevation.access$animateElevation$lambda$2(r6)
            androidx.compose.animation.core.Animatable<androidx.compose.ui.unit.Dp, androidx.compose.animation.core.AnimationVector1D> r1 = r5.$animatable
            float r3 = r5.$target
            androidx.compose.foundation.interaction.Interaction r4 = r5.$interaction
            r5.label = r2
            java.lang.Object r6 = androidx.compose.material3.internal.ElevationKt.m2678animateElevationrAjV9yQ(r1, r3, r6, r4, r5)
            if (r6 != r0) goto L5a
        L59:
            return r0
        L5a:
            androidx.compose.runtime.MutableState<androidx.compose.foundation.interaction.Interaction> r6 = r5.$lastInteraction$delegate
            androidx.compose.foundation.interaction.Interaction r5 = r5.$interaction
            androidx.compose.material3.SelectableChipElevation.access$animateElevation$lambda$3(r6, r5)
        L61:
            C7.r r5 = C7.r.f317a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SelectableChipElevation$animateElevation$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((SelectableChipElevation$animateElevation$2$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
