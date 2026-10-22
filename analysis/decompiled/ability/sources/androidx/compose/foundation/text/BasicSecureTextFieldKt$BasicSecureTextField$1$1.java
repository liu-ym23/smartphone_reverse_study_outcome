package androidx.compose.foundation.text;

import C7.r;
import J7.c;
import S7.n;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@c(c = "androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$1$1", f = "BasicSecureTextField.kt", l = {136}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class BasicSecureTextFieldKt$BasicSecureTextField$1$1 extends SuspendLambda implements n {
    final /* synthetic */ SecureTextFieldController $secureTextFieldController;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicSecureTextFieldKt$BasicSecureTextField$1$1(SecureTextFieldController secureTextFieldController, H7.c<? super BasicSecureTextFieldKt$BasicSecureTextField$1$1> cVar) {
        super(2, cVar);
        this.$secureTextFieldController = secureTextFieldController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new BasicSecureTextFieldKt$BasicSecureTextField$1$1(this.$secureTextFieldController, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            SecureTextFieldController secureTextFieldController = this.$secureTextFieldController;
            this.label = 1;
            if (secureTextFieldController.observeHideEvents(this) == coroutineSingletons) {
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
        return ((BasicSecureTextFieldKt$BasicSecureTextField$1$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
