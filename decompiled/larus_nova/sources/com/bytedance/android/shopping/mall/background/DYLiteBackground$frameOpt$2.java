package com.bytedance.android.shopping.mall.background;

import com.bytedance.android.shopping.mall.opt.MallOptUtil;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class DYLiteBackground$frameOpt$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ c this$0;

    public DYLiteBackground$frameOpt$2(c r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        Lazy r100 = MallOptUtil.f178553a;
        this.this$0.getClass();
        return MallOptUtil.c(null);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }
}
