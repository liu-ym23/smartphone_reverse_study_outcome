package androidx.compose.foundation.text;

import C7.r;
import J7.c;
import S7.n;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@c(c = "androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$2$1", f = "BasicTextField.kt", l = {459}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/PointerInputScope;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class BasicTextFieldKt$TextFieldSelectionHandles$2$1 extends SuspendLambda implements n {
    final /* synthetic */ TextFieldSelectionState $selectionState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasicTextFieldKt$TextFieldSelectionHandles$2$1(TextFieldSelectionState textFieldSelectionState, H7.c<? super BasicTextFieldKt$TextFieldSelectionHandles$2$1> cVar) {
        super(2, cVar);
        this.$selectionState = textFieldSelectionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        BasicTextFieldKt$TextFieldSelectionHandles$2$1 basicTextFieldKt$TextFieldSelectionHandles$2$1 = new BasicTextFieldKt$TextFieldSelectionHandles$2$1(this.$selectionState, cVar);
        basicTextFieldKt$TextFieldSelectionHandles$2$1.L$0 = obj;
        return basicTextFieldKt$TextFieldSelectionHandles$2$1;
    }

    @Override // S7.n
    public final Object invoke(PointerInputScope pointerInputScope, H7.c<? super r> cVar) {
        return ((BasicTextFieldKt$TextFieldSelectionHandles$2$1) create(pointerInputScope, cVar)).invokeSuspend(r.f317a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            TextFieldSelectionState textFieldSelectionState = this.$selectionState;
            this.label = 1;
            if (textFieldSelectionState.selectionHandleGestures(pointerInputScope, true, this) == coroutineSingletons) {
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
}
