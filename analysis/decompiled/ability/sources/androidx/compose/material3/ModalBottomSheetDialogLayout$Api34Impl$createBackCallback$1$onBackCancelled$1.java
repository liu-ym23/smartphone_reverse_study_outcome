package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import com.stepos.ability.mcpserver.model.McpErrorCode;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "androidx.compose.material3.ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackCancelled$1", f = "ModalBottomSheet.android.kt", l = {McpErrorCode.TOKEN_EXPIRED}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackCancelled$1 extends SuspendLambda implements n {
    final /* synthetic */ Animatable<Float, AnimationVector1D> $predictiveBackProgress;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackCancelled$1(Animatable<Float, AnimationVector1D> animatable, H7.c<? super ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackCancelled$1> cVar) {
        super(2, cVar);
        this.$predictiveBackProgress = animatable;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackCancelled$1(this.$predictiveBackProgress, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            Animatable<Float, AnimationVector1D> animatable = this.$predictiveBackProgress;
            Float f = new Float(0.0f);
            this.label = 1;
            if (Animatable.animateTo$default(animatable, f, null, null, null, this, 14, null) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((ModalBottomSheetDialogLayout$Api34Impl$createBackCallback$1$onBackCancelled$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
