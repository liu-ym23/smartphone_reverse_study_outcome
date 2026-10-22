package androidx.compose.foundation.text.selection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.PlatformSelectionBehaviorsImpl", f = "PlatformSelectionBehaviors.android.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {351, 361}, m = "classifyText-M8tDOmk", n = {"text", "textClassifier", "$this$withLock_u24default$iv", "selection", "text", "textClassification", "$this$withLock_u24default$iv", "selection"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0"})
public final class PlatformSelectionBehaviorsImpl$classifyText$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PlatformSelectionBehaviorsImpl this$0;

    public PlatformSelectionBehaviorsImpl$classifyText$1(PlatformSelectionBehaviorsImpl r100, Continuation<? super PlatformSelectionBehaviorsImpl$classifyText$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return PlatformSelectionBehaviorsImpl.m1448access$classifyTextM8tDOmk(this.this$0, null, 0, null, this);
    }
}
