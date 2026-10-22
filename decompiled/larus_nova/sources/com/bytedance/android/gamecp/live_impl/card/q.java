package com.bytedance.android.gamecp.live_impl.card;

import com.bytedance.android.gamecp.host_api.model.introducecard.s;
import com.bytedance.android.gamecp.live_impl.RoomContext;
import com.bytedance.android.livesdkapi.room.controller.ILiveRoomControllerProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class q {
    public static final void a(s r100, String r101, ILiveRoomControllerProvider.ProviderSource r102) {
        Intrinsics.checkNotNullParameter(r100, "display");
        Intrinsics.checkNotNullParameter(r102, "source");
        yr.b.b(4, "IntroduceCardDataUtils", "定时讲解配置请求结果: 启用定时卡=" + r100.timerCardSwitchOpen + "，讲解时长=" + r100.displayDuration + "，隐藏时长=" + r100.timerSpan + "，循环次数=" + r100.timerLoopCnt + ", 无服务卡，是否开启智能讲解预测=" + r100.isOpenAiIntroduceCard);
        RoomContext.a r103 = RoomContext.Companion;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        RoomContext r104 = RoomContext.a.c(r103, null, r101, r102.name(), 1);
        if (r104 == null) goto L11;
        com.bytedance.live.datacontext.m<s> r105 = r104.getUserIntroCardDisplayConfig();
        if (r105 == null) goto L12;
        r105.setValue(r100);
        return;
    L12:
        return;
    }
}
