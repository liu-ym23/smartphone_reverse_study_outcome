package com.bytedance.android.shopping.prepurchase.business.pdp.util;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@"}, d2 = {"", "fullscreenMode", "", "schema", "", "delay", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "showCartEntranceVideo"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.prepurchase.business.pdp.util.BottomNavigationToaster", f = "BottomNavigationToaster.kt", i = {0, 0, 0}, l = {64}, m = "showCartEntranceVideo", n = {"this", "schema", "fullscreenMode"}, s = {"L$0", "L$1", "Z$0"})
public final class BottomNavigationToaster$showCartEntranceVideo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BottomNavigationToaster this$0;

    public BottomNavigationToaster$showCartEntranceVideo$1(BottomNavigationToaster r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(false, null, 0, this);
    }
}
