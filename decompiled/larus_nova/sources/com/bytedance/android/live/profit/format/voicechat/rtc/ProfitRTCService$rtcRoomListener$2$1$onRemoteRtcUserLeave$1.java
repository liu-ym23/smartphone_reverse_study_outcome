package com.bytedance.android.live.profit.format.voicechat.rtc;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ProfitRTCService$rtcRoomListener$2$1$onRemoteRtcUserLeave$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $rtcUserId;
    final /* synthetic */ ProfitRTCService$rtcRoomListener$2.a this$0;

    public ProfitRTCService$rtcRoomListener$2$1$onRemoteRtcUserLeave$1(ProfitRTCService$rtcRoomListener$2.a r100, String r101) {
        this.this$0 = r100;
        this.$rtcUserId = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String r100 = this.$rtcUserId;
        if (r100 == null) goto L11;
        ALogger.i("ProfitRTCService", this.$rtcUserId + " onRemoteRtcUserLeave");
        Iterator<a> r101 = this.this$0.f87687a.this$0.f87679b.iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().t(r100);
        goto L6
    L8:
        this.this$0.f87687a.this$0.f87681d.remove(r100);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
