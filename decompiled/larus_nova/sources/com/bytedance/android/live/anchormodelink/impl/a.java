package com.bytedance.android.live.anchormodelink.impl;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterUpdateType;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f58718a = null;

    static {
        int[] r100 = new int[DynamicCenterUpdateType.values().length];
        f58718a = r100;
        r100[DynamicCenterUpdateType.videoLinkmicAction.ordinal()] = 1;
        r100[DynamicCenterUpdateType.effect.ordinal()] = 2;
        r100[DynamicCenterUpdateType.nativeCallChannel.ordinal()] = 3;
        r100[DynamicCenterUpdateType.inviteMore.ordinal()] = 4;
        r100[DynamicCenterUpdateType.check_media_permission.ordinal()] = 5;
        r100[DynamicCenterUpdateType.send_private_invite.ordinal()] = 6;
        r100[DynamicCenterUpdateType.updatePublicScreenAvoidOffset.ordinal()] = 7;
        r100[DynamicCenterUpdateType.switchRoom.ordinal()] = 8;
        r100[DynamicCenterUpdateType.fullScreenDoubleTap.ordinal()] = 9;
        r100[DynamicCenterUpdateType.updateGlobalTracker.ordinal()] = 10;
    }
}
