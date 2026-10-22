package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "androidx.compose.material3.ButtonElevation$animateElevation$2$1", f = "Button.kt", l = {989, 998}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class ButtonElevation$animateElevation$2$1 extends SuspendLambda implements n {
    final /* synthetic */ Animatable<Dp, AnimationVector1D> $animatable;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Interaction $interaction;
    final /* synthetic */ float $target;
    int label;
    final /* synthetic */ ButtonElevation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ButtonElevation$animateElevation$2$1(Animatable<Dp, AnimationVector1D> animatable, float f, boolean z10, ButtonElevation buttonElevation, Interaction interaction, H7.c<? super ButtonElevation$animateElevation$2$1> cVar) {
        super(2, cVar);
        this.$animatable = animatable;
        this.$target = f;
        this.$enabled = z10;
        this.this$0 = buttonElevation;
        this.$interaction = interaction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new ButtonElevation$animateElevation$2$1(this.$animatable, this.$target, this.$enabled, this.this$0, this.$interaction, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        if (r7.snapTo(r1, r6) == r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009b, code lost:
    
        if (androidx.compose.material3.internal.ElevationKt.m2678animateElevationrAjV9yQ(r7, r1, r3, r4, r6) == r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009d, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1a
            if (r1 == r3) goto L15
            if (r1 != r2) goto Ld
            goto L15
        Ld:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L15:
            kotlin.b.b(r7)
            goto L9e
        L1a:
            kotlin.b.b(r7)
            androidx.compose.animation.core.Animatable<androidx.compose.ui.unit.Dp, androidx.compose.animation.core.AnimationVector1D> r7 = r6.$animatable
            java.lang.Object r7 = r7.getTargetValue()
            androidx.compose.ui.unit.Dp r7 = (androidx.compose.ui.unit.Dp) r7
            float r7 = r7.m6858unboximpl()
            float r1 = r6.$target
            boolean r7 = androidx.compose.ui.unit.Dp.m6849equalsimpl0(r7, r1)
            if (r7 != 0) goto L9e
            boolean r7 = r6.$enabled
            if (r7 != 0) goto L46
            androidx.compose.animation.core.Animatable<androidx.compose.ui.unit.Dp, androidx.compose.animation.core.AnimationVector1D> r7 = r6.$animatable
            float r1 = r6.$target
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.m6842boximpl(r1)
            r6.label = r3
            java.lang.Object r6 = r7.snapTo(r1, r6)
            if (r6 != r0) goto L9e
            goto L9d
        L46:
            androidx.compose.animation.core.Animatable<androidx.compose.ui.unit.Dp, androidx.compose.animation.core.AnimationVector1D> r7 = r6.$animatable
            java.lang.Object r7 = r7.getTargetValue()
            androidx.compose.ui.unit.Dp r7 = (androidx.compose.ui.unit.Dp) r7
            float r7 = r7.m6858unboximpl()
            androidx.compose.material3.ButtonElevation r1 = r6.this$0
            float r1 = androidx.compose.material3.ButtonElevation.access$getPressedElevation$p(r1)
            boolean r1 = androidx.compose.ui.unit.Dp.m6849equalsimpl0(r7, r1)
            r3 = 0
            if (r1 == 0) goto L6c
            androidx.compose.foundation.interaction.PressInteraction$Press r7 = new androidx.compose.foundation.interaction.PressInteraction$Press
            androidx.compose.ui.geometry.Offset$Companion r1 = androidx.compose.ui.geometry.Offset.INSTANCE
            long r4 = r1.m3911getZeroF1C5BW0()
            r7.<init>(r4, r3)
            r3 = r7
            goto L8f
        L6c:
            androidx.compose.material3.ButtonElevation r1 = r6.this$0
            float r1 = androidx.compose.material3.ButtonElevation.access$getHoveredElevation$p(r1)
            boolean r1 = androidx.compose.ui.unit.Dp.m6849equalsimpl0(r7, r1)
            if (r1 == 0) goto L7e
            androidx.compose.foundation.interaction.HoverInteraction$Enter r3 = new androidx.compose.foundation.interaction.HoverInteraction$Enter
            r3.<init>()
            goto L8f
        L7e:
            androidx.compose.material3.ButtonElevation r1 = r6.this$0
            float r1 = androidx.compose.material3.ButtonElevation.access$getFocusedElevation$p(r1)
            boolean r7 = androidx.compose.ui.unit.Dp.m6849equalsimpl0(r7, r1)
            if (r7 == 0) goto L8f
            androidx.compose.foundation.interaction.FocusInteraction$Focus r3 = new androidx.compose.foundation.interaction.FocusInteraction$Focus
            r3.<init>()
        L8f:
            androidx.compose.animation.core.Animatable<androidx.compose.ui.unit.Dp, androidx.compose.animation.core.AnimationVector1D> r7 = r6.$animatable
            float r1 = r6.$target
            androidx.compose.foundation.interaction.Interaction r4 = r6.$interaction
            r6.label = r2
            java.lang.Object r6 = androidx.compose.material3.internal.ElevationKt.m2678animateElevationrAjV9yQ(r7, r1, r3, r4, r6)
            if (r6 != r0) goto L9e
        L9d:
            return r0
        L9e:
            C7.r r6 = C7.r.f317a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ButtonElevation$animateElevation$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((ButtonElevation$animateElevation$2$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
