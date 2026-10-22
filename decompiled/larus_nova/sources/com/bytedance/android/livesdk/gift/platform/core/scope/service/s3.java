package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.android.livesdk.gift.platform.core.model.ReceiverType;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class s3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f131727a = null;

    static {
        int[] r100 = new int[ReceiverType.values().length];
        f131727a = r100;
        r100[ReceiverType.GroupLive.ordinal()] = 1;
        r100[ReceiverType.AllMic.ordinal()] = 2;
        r100[ReceiverType.Guest.ordinal()] = 3;
        r100[ReceiverType.Anchor.ordinal()] = 4;
        r100[ReceiverType.Audience.ordinal()] = 5;
        r100[ReceiverType.OtherAnchor.ordinal()] = 6;
        r100[ReceiverType.MicTeamAnchor.ordinal()] = 7;
    }
}
