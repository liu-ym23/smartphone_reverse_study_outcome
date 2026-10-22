package androidx.compose.foundation.text.input.internal;

import C7.r;
import S7.n;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2", f = "TextFieldDecoratorModifier.kt", l = {211}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2 extends SuspendLambda implements n {
    final /* synthetic */ PointerInputScope $$this$SuspendingPointerInputModifierNode;
    final /* synthetic */ S7.a $requestFocus;
    final /* synthetic */ TextFieldSelectionState $this_with;
    int label;
    final /* synthetic */ TextFieldDecoratorModifierNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, TextFieldSelectionState textFieldSelectionState, PointerInputScope pointerInputScope, S7.a aVar, H7.c<? super TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2> cVar) {
        super(2, cVar);
        this.this$0 = textFieldDecoratorModifierNode;
        this.$this_with = textFieldSelectionState;
        this.$$this$SuspendingPointerInputModifierNode = pointerInputScope;
        this.$requestFocus = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2(this.this$0, this.$this_with, this.$$this$SuspendingPointerInputModifierNode, this.$requestFocus, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            MutableInteractionSource interactionSource = this.this$0.getInteractionSource();
            TextFieldSelectionState textFieldSelectionState = this.$this_with;
            PointerInputScope pointerInputScope = this.$$this$SuspendingPointerInputModifierNode;
            S7.a aVar = this.$requestFocus;
            final TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.this$0;
            S7.a aVar2 = new S7.a() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2.1
                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1236invoke();
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1236invoke() {
                    if (textFieldDecoratorModifierNode.inputSessionJob != null) {
                        textFieldDecoratorModifierNode.requireKeyboardController().show();
                    } else {
                        textFieldDecoratorModifierNode.startInputSession(true);
                    }
                }
            };
            this.label = 1;
            if (textFieldSelectionState.detectTextFieldTapGestures(pointerInputScope, interactionSource, aVar, aVar2, this) == coroutineSingletons) {
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
        return ((TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
