package android.view.compose;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "androidx.activity.compose.PredictiveBackHandlerKt$PredictiveBackHandler$2$1", f = "PredictiveBackHandler.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 0, 0})
/* loaded from: classes.dex */
public final class PredictiveBackHandlerKt$PredictiveBackHandler$2$1 extends SuspendLambda implements n {
    final /* synthetic */ PredictiveBackHandlerCallback $backCallBack;
    final /* synthetic */ boolean $enabled;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PredictiveBackHandlerKt$PredictiveBackHandler$2$1(PredictiveBackHandlerCallback predictiveBackHandlerCallback, boolean z10, H7.c<? super PredictiveBackHandlerKt$PredictiveBackHandler$2$1> cVar) {
        super(2, cVar);
        this.$backCallBack = predictiveBackHandlerCallback;
        this.$enabled = z10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new PredictiveBackHandlerKt$PredictiveBackHandler$2$1(this.$backCallBack, this.$enabled, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        b.b(obj);
        this.$backCallBack.setIsEnabled(this.$enabled);
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((PredictiveBackHandlerKt$PredictiveBackHandler$2$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
