package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.live.revenue.common.message.CommonMessageTypeKt;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f128457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final yz0.f f128458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x f128459c;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
        yz0.f r100 = this.f128458b;
        com.bytedance.android.live.revenue.common.message.a r101 = com.bytedance.android.live.revenue.common.message.a.f90883g;
        Lazy r102 = CommonMessageTypeKt.f90851a;
        Intrinsics.checkNotNullParameter(r101, "$this$GROUP_LIVE_GIFT_RECIPIENT_RECOMMEND_MESSAGE");
        Observable r103 = yz0.h.a.a(r100, (yh6.b) CommonMessageTypeKt.X.getValue(), false, 6);
        final GiftGroupLiveRecommendService$receiveRecommendMessage$1 r104 = new GiftGroupLiveRecommendService$receiveRecommendMessage$1(this);
        com.bytedance.revenue.platform.api.core.rx.f.a(r103.subscribe(new c(r104)), this.f128457a);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f128457a.clear();
    }

    public d(yz0.f r100, x r101) {
        Intrinsics.checkNotNullParameter(r100, "roomMessageService");
        Intrinsics.checkNotNullParameter(r101, "recommendReceiverService");
        this.f128458b = r100;
        this.f128459c = r101;
        this.f128457a = new CompositeDisposable();
    }
}
