package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.PrefetchHandleProvider$HandleAndRequestImpl", f = "LazyLayoutPrefetchState.kt", i = {}, l = {564, 565}, m = "await", n = {}, s = {})
public final class PrefetchHandleProvider$HandleAndRequestImpl$await$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PrefetchHandleProvider.HandleAndRequestImpl this$0;

    public PrefetchHandleProvider$HandleAndRequestImpl$await$1(PrefetchHandleProvider.HandleAndRequestImpl r100, Continuation<? super PrefetchHandleProvider$HandleAndRequestImpl$await$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.await(this);
    }
}
