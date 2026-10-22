package androidx.compose.ui.precompose;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.precompose.PausableSubPreComposeController", f = "PausableSubPreComposeController.kt", i = {}, l = {34}, m = "triggerSubPreCompose$ui_release", n = {}, s = {})
public final class PausableSubPreComposeController$triggerSubPreCompose$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PausableSubPreComposeController this$0;

    public PausableSubPreComposeController$triggerSubPreCompose$1(PausableSubPreComposeController r100, Continuation<? super PausableSubPreComposeController$triggerSubPreCompose$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.triggerSubPreCompose$ui_release(this);
    }
}
