package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41;

import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.hybrid.card.event.d;
import com.bytedance.android.ec.hybrid.card.event.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ChannelCardViewNew41$disableChannelSwiper$1 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChannelCardViewNew41 f177660a;

    public ChannelCardViewNew41$disableChannelSwiper$1(ChannelCardViewNew41 r100) {
        this.f177660a = r100;
    }

    @Override // com.bytedance.android.ec.hybrid.card.event.e
    public final void a(final d r100) {
        Intrinsics.checkNotNullParameter(r100, "jsEvent");
        ECHybridExtensionsKt.f(new ChannelCardViewNew41$disableChannelSwiper$1$onReceiveJsEvent$1(this, r100));
    }
}
