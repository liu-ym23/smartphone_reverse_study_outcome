package androidx.compose.foundation.text.selection;

import android.view.textclassifier.TextClassifier;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/view/textclassifier/TextClassifier;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$textClassificationSession$1$1", f = "PlatformSelectionBehaviors.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$textClassificationSession$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TextClassifier>, Object> {
    int label;
    final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    public PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$textClassificationSession$1$1(PlatformSelectionBehaviorsImpl r100, Continuation<? super PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$textClassificationSession$1$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$textClassificationSession$1$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super TextClassifier> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super TextClassifier> r101) {
        return ((PlatformSelectionBehaviorsImpl$requireTextClassificationSession$2$textClassificationSession$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        TextClassifier r101 = TextClassifierHelperMethods.INSTANCE.createTextClassificationSession(PlatformSelectionBehaviorsImpl.access$getContext$p(this.this$0), PlatformSelectionBehaviorsImpl.access$getSelectedTextType$p(this.this$0));
        PlatformSelectionBehaviorsImpl.access$setTextClassificationSession$p(this.this$0, r101);
        return r101;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
