package com.bytedance.android.shopping.deepfeed.routers;

import com.bytedance.android.shopping.deepfeed.event.g;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import uc3.f;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "success", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class DeepFeedProductRouter$requestFirstPack$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ g $enterInnerViewEvent;
    final /* synthetic */ f $monitor;
    final /* synthetic */ DeepFeedProductRouter this$0;

    public DeepFeedProductRouter$requestFirstPack$1(DeepFeedProductRouter r100, f r101, g r102) {
        this.$monitor = r101;
        super(1);
    }

    public final void invoke(boolean r100) {
        this.$monitor.j(System.currentTimeMillis());
        Lazy r101 = DeepFeedProductRouter.f173371a;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean r100) {
        invoke(r100.booleanValue());
        return Unit.INSTANCE;
    }
}
