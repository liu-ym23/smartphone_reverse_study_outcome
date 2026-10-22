package com.bytedance.android.gamecp.business.gamedetail.page.root;

import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class GameDetailPreRequestUtil$fetchCacheData$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ a0 $callback;

    public GameDetailPreRequestUtil$fetchCacheData$1(String r100, a0 r101) {
        this.$cacheKey = r100;
        this.$callback = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        boolean r100 = GameDetailPreRequestUtil.f55453a;
        final z r101 = GameDetailPreRequestUtil.d(this.$cacheKey);
        if (r101 == null) goto L5;
        GameDetailPreRequestUtil.f("命中磁盘缓存");
        GameDetailPreRequestUtil.k(this.$cacheKey, r101);
    L5:
        UtilityKotlinExtentionsKt.g(0, false, false, new AnonymousClass1(this, r101), 7);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
