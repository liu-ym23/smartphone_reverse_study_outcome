package com.bytedance.android.shopping.deepfeed.slice.view.viewpage;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"finishScroll", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class AutoScrollViewPager2$scrollToNext$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ a this$0;

    public AutoScrollViewPager2$scrollToNext$1(a r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        a r100 = this.this$0;
        if (r100.f173680h.isFakeDragging() == true) goto L8;
    L5:
        a r101 = this.this$0;
        r101.f173674b = false;
        r101.a();
        return;
    L8:
        r100.f173680h.endFakeDrag();     // Catch: IllegalStateException -> L7
        goto L5
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
