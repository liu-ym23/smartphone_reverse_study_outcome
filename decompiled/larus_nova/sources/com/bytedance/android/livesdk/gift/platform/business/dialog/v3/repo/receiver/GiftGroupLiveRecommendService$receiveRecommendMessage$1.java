package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver;

import com.bytedance.android.livesdk.message.model.u7;
import com.bytedance.android.livesdk.message.model.v7;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/u7;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/message/model/u7;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class GiftGroupLiveRecommendService$receiveRecommendMessage$1 extends FunctionReferenceImpl implements Function1<u7, Unit> {
    public GiftGroupLiveRecommendService$receiveRecommendMessage$1(d r100) {
        super(1, r100, d.class, "onReceiveMessage", "onReceiveMessage(Lcom/bytedance/android/livesdk/message/model/IGroupLiveGiftRecipientRecommendMessage;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(u7 r100) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        d r101 = (d) this.receiver;
        r101.getClass();
        LinkedHashMap r102 = new LinkedHashMap();
        Map<String, String> r103 = r100.getExtra();
        if (r103 == null) goto L5;
        r102.putAll(r103);
    L5:
        r102.put("group_live_to_user_st", "rec");
        jy0.b.d("GiftReceiver", "GiftGroupLiveRecommendService onReceiveMessage ".concat(v7.a(r100)));
        r101.f128459c.c(v7.a(r100), String.valueOf(r100.getReason()), r100.getExtra(), r102);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(u7 r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
