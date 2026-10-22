package com.bytedance.android.ecom.bcm.track.impl.monitor;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/ecom/bcm/track/impl/monitor/BstInterceptor$request2Json$json$2$1"}, k = 3, mv = {1, 1, 16})
final class BstInterceptor$request2Json$$inlined$run$lambda$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $contentType$inlined;
    final /* synthetic */ l $request$inlined;

    public BstInterceptor$request2Json$$inlined$run$lambda$1(String r100, l r101) {
        this.$contentType$inlined = r100;
        this.$request$inlined = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        return "monitor fail: cannot find content processor, content type = " + this.$contentType$inlined;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
