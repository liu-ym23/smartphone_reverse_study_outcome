package com.bytedance.android.live.revlink.impl.multianchor.service;

import com.bytedance.android.livesdk.link.model.ILinkerKickOutContent;
import com.bytedance.android.livesdk.link.model.b7;
import com.bytedance.android.livesdk.link.model.bridge.f0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes47.dex */
public interface b {
    void finishInternal(Function0<Unit> r100, String r101, boolean r102);

    f31.j getEndingLinkStatus();

    com.bytedance.android.live.revlink.impl.multianchor.ui.i getMuteManager();

    int getWindowCount();

    void kickOut(String r100, String r101, ILinkerKickOutContent.KickOutSource r102);

    void onReceiveSwitchChannelReply(b7 r100);

    void receiveChorusMessage(f0 r100);

    void setAnchorLinkFinisher(boolean r100);

    void setFollowState(String r100, boolean r101, String r102);

    void startSwitchPk(com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g r100);
}
