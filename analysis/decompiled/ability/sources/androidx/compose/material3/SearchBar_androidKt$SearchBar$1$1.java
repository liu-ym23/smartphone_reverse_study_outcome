package androidx.compose.material3;

import C7.r;
import S7.n;
import android.view.BackEventCompat;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "androidx.compose.material3.SearchBar_androidKt$SearchBar$1$1", f = "SearchBar.android.kt", l = {191}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class SearchBar_androidKt$SearchBar$1$1 extends SuspendLambda implements n {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $animationProgress;
    final /* synthetic */ MutableState<BackEventCompat> $currentBackEvent;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ MutableFloatState $finalBackProgress;
    final /* synthetic */ MutableState<BackEventCompat> $firstBackEvent;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchBar_androidKt$SearchBar$1$1(Animatable<Float, AnimationVector1D> animatable, boolean z10, MutableFloatState mutableFloatState, MutableState<BackEventCompat> mutableState, MutableState<BackEventCompat> mutableState2, H7.c<? super SearchBar_androidKt$SearchBar$1$1> cVar) {
        super(2, cVar);
        this.$animationProgress = animatable;
        this.$expanded = z10;
        this.$finalBackProgress = mutableFloatState;
        this.$firstBackEvent = mutableState;
        this.$currentBackEvent = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new SearchBar_androidKt$SearchBar$1$1(this.$animationProgress, this.$expanded, this.$finalBackProgress, this.$firstBackEvent, this.$currentBackEvent, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r12.label
            r2 = 1
            if (r1 == 0) goto L15
            if (r1 != r2) goto Ld
            kotlin.b.b(r13)
            goto L64
        Ld:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L15:
            kotlin.b.b(r13)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r13 = r12.$animationProgress
            java.lang.Object r13 = r13.getValue()
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            r1 = 0
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r13 <= 0) goto L41
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r13 = r12.$animationProgress
            java.lang.Object r13 = r13.getValue()
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            int r13 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r13 >= 0) goto L41
            androidx.compose.animation.core.FiniteAnimationSpec r13 = androidx.compose.material3.SearchBar_androidKt.access$getAnimationPredictiveBackExitFloatSpec$p()
        L3f:
            r6 = r13
            goto L4f
        L41:
            boolean r13 = r12.$expanded
            if (r13 == 0) goto L4a
            androidx.compose.animation.core.FiniteAnimationSpec r13 = androidx.compose.material3.SearchBar_androidKt.access$getAnimationEnterFloatSpec$p()
            goto L3f
        L4a:
            androidx.compose.animation.core.FiniteAnimationSpec r13 = androidx.compose.material3.SearchBar_androidKt.access$getAnimationExitFloatSpec$p()
            goto L3f
        L4f:
            boolean r13 = r12.$expanded
            if (r13 == 0) goto L54
            r1 = r3
        L54:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r13 = r12.$animationProgress
            java.lang.Object r13 = r13.getValue()
            java.lang.Number r13 = (java.lang.Number) r13
            float r13 = r13.floatValue()
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 != 0) goto L66
        L64:
            r9 = r12
            goto L7c
        L66:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r4 = r12.$animationProgress
            java.lang.Float r5 = new java.lang.Float
            r5.<init>(r1)
            r12.label = r2
            r7 = 0
            r8 = 0
            r10 = 12
            r11 = 0
            r9 = r12
            java.lang.Object r12 = androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r12 != r0) goto L7c
            return r0
        L7c:
            boolean r12 = r9.$expanded
            if (r12 != 0) goto L92
            androidx.compose.runtime.MutableFloatState r12 = r9.$finalBackProgress
            r13 = 2143289344(0x7fc00000, float:NaN)
            r12.setFloatValue(r13)
            androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r12 = r9.$firstBackEvent
            r13 = 0
            r12.setValue(r13)
            androidx.compose.runtime.MutableState<androidx.activity.BackEventCompat> r12 = r9.$currentBackEvent
            r12.setValue(r13)
        L92:
            C7.r r12 = C7.r.f317a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBar_androidKt$SearchBar$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((SearchBar_androidKt$SearchBar$1$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
