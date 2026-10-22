package com.bytedance.android.shopping.mall.homepage.preload;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.r;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "", "valid", "", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "", "result", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class MallPreDecode$cardDecode$1 extends Lambda implements Function4<Boolean, Throwable, String, byte[], Unit> {
    final /* synthetic */ String $url;
    final /* synthetic */ int $vmCount;
    final /* synthetic */ c this$0;

    public MallPreDecode$cardDecode$1(c r100, String r101, int r102) {
        this.$url = r101;
        this.$vmCount = r102;
        super(4);
    }

    public final void invoke(boolean r100, Throwable r101, String r102, byte[] r103) {
        if (r100 == true) goto L5;
        Lazy r104 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(r.c.f47518b, "decode failed, timestamp = " + System.currentTimeMillis() + ", url = " + this.$url);
        return;
    L5:
        int r105 = com.bytedance.android.ec.hybrid.monitor.g.f47561a;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100, Throwable r101, String r102, byte[] r103) {
        invoke(r100.booleanValue(), r101, r102, r103);
        return Unit.INSTANCE;
    }
}
