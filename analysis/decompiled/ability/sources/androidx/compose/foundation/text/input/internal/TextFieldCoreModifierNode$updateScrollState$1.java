package androidx.compose.foundation.text.input.internal;

import C7.r;
import S7.n;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.InterfaceC1733z;

@J7.c(c = "androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$updateScrollState$1", f = "TextFieldCoreModifier.kt", l = {448, 451}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
/* loaded from: classes.dex */
public final class TextFieldCoreModifierNode$updateScrollState$1 extends SuspendLambda implements n {
    final /* synthetic */ float $offsetDifference;
    final /* synthetic */ Rect $rawCursorRect;
    int label;
    final /* synthetic */ TextFieldCoreModifierNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFieldCoreModifierNode$updateScrollState$1(TextFieldCoreModifierNode textFieldCoreModifierNode, float f, Rect rect, H7.c<? super TextFieldCoreModifierNode$updateScrollState$1> cVar) {
        super(2, cVar);
        this.this$0 = textFieldCoreModifierNode;
        this.$offsetDifference = f;
        this.$rawCursorRect = rect;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new TextFieldCoreModifierNode$updateScrollState$1(this.this$0, this.$offsetDifference, this.$rawCursorRect, cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
    
        if (r5.bringIntoView(r1, r4) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1c
            if (r1 == r3) goto L18
            if (r1 != r2) goto L10
            kotlin.b.b(r5)
            goto L49
        L10:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L18:
            kotlin.b.b(r5)
            goto L34
        L1c:
            kotlin.b.b(r5)
            androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode r5 = r4.this$0
            androidx.compose.foundation.ScrollState r5 = androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.access$getScrollState$p(r5)
            float r1 = r4.$offsetDifference
            float r1 = androidx.compose.foundation.text.input.internal.TextFieldCoreModifierKt.access$roundToNext(r1)
            r4.label = r3
            java.lang.Object r5 = androidx.compose.foundation.gestures.ScrollExtensionsKt.scrollBy(r5, r1, r4)
            if (r5 != r0) goto L34
            goto L48
        L34:
            androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode r5 = r4.this$0
            androidx.compose.foundation.text.input.internal.TextLayoutState r5 = androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode.access$getTextLayoutState$p(r5)
            androidx.compose.foundation.relocation.BringIntoViewRequester r5 = r5.getBringIntoViewRequester()
            androidx.compose.ui.geometry.Rect r1 = r4.$rawCursorRect
            r4.label = r2
            java.lang.Object r4 = r5.bringIntoView(r1, r4)
            if (r4 != r0) goto L49
        L48:
            return r0
        L49:
            C7.r r4 = C7.r.f317a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldCoreModifierNode$updateScrollState$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((TextFieldCoreModifierNode$updateScrollState$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }
}
