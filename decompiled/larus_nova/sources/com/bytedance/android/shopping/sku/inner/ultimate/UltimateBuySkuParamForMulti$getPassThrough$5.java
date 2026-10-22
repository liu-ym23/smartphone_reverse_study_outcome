package com.bytedance.android.shopping.sku.inner.ultimate;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class UltimateBuySkuParamForMulti$getPassThrough$5 extends Lambda implements Function0<Object> {
    final /* synthetic */ i this$0;

    public UltimateBuySkuParamForMulti$getPassThrough$5(i r100) {
        this.this$0 = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        String r100 = this.this$0.f182995a.getLogData();
        if ((r100 instanceof String) == true) goto L6;
        return null;
    L6:
        return r100;
    }
}
