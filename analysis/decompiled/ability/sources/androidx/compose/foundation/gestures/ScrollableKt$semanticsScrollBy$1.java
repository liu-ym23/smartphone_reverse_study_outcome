package androidx.compose.foundation.gestures;

import J7.c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "androidx.compose.foundation.gestures.ScrollableKt", f = "Scrollable.kt", l = {966}, m = "semanticsScrollBy-d-4ec7I")
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollableKt$semanticsScrollBy$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public ScrollableKt$semanticsScrollBy$1(H7.c<? super ScrollableKt$semanticsScrollBy$1> cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ScrollableKt.m499semanticsScrollByd4ec7I(null, 0L, this);
    }
}
