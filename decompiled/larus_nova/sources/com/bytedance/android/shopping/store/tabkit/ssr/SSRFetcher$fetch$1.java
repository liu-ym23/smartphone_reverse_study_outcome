package com.bytedance.android.shopping.store.tabkit.ssr;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "data", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class SSRFetcher$fetch$1 extends Lambda implements Function1<byte[], Unit> {
    final /* synthetic */ b this$0;

    public SSRFetcher$fetch$1(b r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(byte[] r100) {
        b r101 = this.this$0;
        int r102 = b.f186847b;
        r101.c("t_tab_ssr_rcv_anchor_url_res", null);
        b.a(this.this$0, r100, false);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(byte[] r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
