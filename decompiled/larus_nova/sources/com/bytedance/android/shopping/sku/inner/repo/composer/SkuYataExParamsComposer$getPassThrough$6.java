package com.bytedance.android.shopping.sku.inner.repo.composer;

import com.bytedance.android.ec.core.hybrid.utils.k;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class SkuYataExParamsComposer$getPassThrough$6 extends Lambda implements Function0<String> {
    final /* synthetic */ Map $eventParams;

    public SkuYataExParamsComposer$getPassThrough$6(Map r100) {
        this.$eventParams = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        int r100 = k.f44314a;
        String r101 = k.b(this.$eventParams).toString();
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
