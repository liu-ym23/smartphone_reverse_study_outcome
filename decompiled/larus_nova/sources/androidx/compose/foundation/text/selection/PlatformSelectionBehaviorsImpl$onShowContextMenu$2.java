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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroid/view/textclassifier/TextClassifier;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl$onShowContextMenu$2", f = "PlatformSelectionBehaviors.android.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
public final class PlatformSelectionBehaviorsImpl$onShowContextMenu$2 extends SuspendLambda implements Function2<TextClassifier, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $selection;
    final /* synthetic */ CharSequence $text;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    public PlatformSelectionBehaviorsImpl$onShowContextMenu$2(PlatformSelectionBehaviorsImpl r100, CharSequence r101, long r102, Continuation<? super PlatformSelectionBehaviorsImpl$onShowContextMenu$2> r103) {
        this.this$0 = r100;
        this.$text = r101;
        this.$selection = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        PlatformSelectionBehaviorsImpl$onShowContextMenu$2 r102 = new PlatformSelectionBehaviorsImpl$onShowContextMenu$2(this.this$0, this.$text, this.$selection, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(TextClassifier r100, Continuation<? super Unit> r101) {
        return ((PlatformSelectionBehaviorsImpl$onShowContextMenu$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(TextClassifier r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        TextClassifier r102 = (TextClassifier) this.L$0;
        PlatformSelectionBehaviorsImpl r103 = this.this$0;
        CharSequence r104 = this.$text;
        long r105 = this.$selection;
        this.label = 1;
        if (PlatformSelectionBehaviorsImpl.m1448access$classifyTextM8tDOmk(r103, r104, r105, r102, this) != r100) goto L12;
        return r100;
    }
}
