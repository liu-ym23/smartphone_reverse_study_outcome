package com.bytedance.android.livesdk.revenue.service.user;

import com.bytedance.android.livesdk.revenue.user.RevLiveFollowScene;
import com.bytedance.android.livesdk.revenue.user.RevVcdAuthorizationSource;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f157491a = null;

    static {
        int[] r100 = new int[RevLiveFollowScene.values().length];
        f157491a = r100;
        r100[RevLiveFollowScene.RedPacket.ordinal()] = 1;
        r100[RevLiveFollowScene.UserInfo.ordinal()] = 2;
        r100[RevLiveFollowScene.ProfilePublicScreen.ordinal()] = 3;
        r100[RevLiveFollowScene.MultiAnchor.ordinal()] = 4;
        r100[RevLiveFollowScene.PK.ordinal()] = 5;
        r100[RevLiveFollowScene.PkBanUserPanel.ordinal()] = 6;
        r100[RevLiveFollowScene.MultiAnchorPanel.ordinal()] = 7;
        int[] r101 = new int[RevVcdAuthorizationSource.values().length];
        r101[RevVcdAuthorizationSource.RedPacketSend.ordinal()] = 1;
        r101[RevVcdAuthorizationSource.RedPacketRush.ordinal()] = 2;
        r101[RevVcdAuthorizationSource.LotteryParticipate.ordinal()] = 3;
    }
}
