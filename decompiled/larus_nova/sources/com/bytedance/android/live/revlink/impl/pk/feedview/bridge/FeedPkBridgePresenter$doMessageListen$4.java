package com.bytedance.android.live.revlink.impl.pk.feedview.bridge;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\n\u0010\u0002\u001a\u00060\u0000j\u0002`\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lyh6/c;", "Lcom/bytedance/android/livesdk/message/model/RevenueImMessage;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lyh6/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final /* synthetic */ class FeedPkBridgePresenter$doMessageListen$4 extends FunctionReferenceImpl implements Function1<yh6.c, Unit> {
    public FeedPkBridgePresenter$doMessageListen$4(FeedPkBridgePresenter r100) {
        super(1, r100, FeedPkBridgePresenter.class, "onMessage", "onMessage(Lcom/bytedance/live/kmp/message/KmpImMessage;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(yh6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        FeedPkBridgePresenter.a((FeedPkBridgePresenter) this.receiver, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(yh6.c r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
