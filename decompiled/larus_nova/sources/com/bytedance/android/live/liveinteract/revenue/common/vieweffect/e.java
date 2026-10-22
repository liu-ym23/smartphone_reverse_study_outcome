package com.bytedance.android.live.liveinteract.revenue.common.vieweffect;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f78104a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f78105b = null;

    static {
        int[] r100 = new int[MicSeatScene.values().length];
        f78104a = r100;
        MicSeatScene r101 = MicSeatScene.AUDIO_LINK_ANCHOR;
        r100[r101.ordinal()] = 1;
        MicSeatScene r102 = MicSeatScene.AUDIO_LINK_C_POSITION;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[MicSeatScene.values().length];
        f78105b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
        r103[MicSeatScene.AUDIO_LINK_C_POSITION_V2.ordinal()] = 3;
        r103[MicSeatScene.VIDEO_LINK_EQUAL.ordinal()] = 4;
        r103[MicSeatScene.AUDIO_LINK_LARGE.ordinal()] = 5;
        r103[MicSeatScene.AUDIO_LINK.ordinal()] = 6;
        r103[MicSeatScene.VIDEO_LINK.ordinal()] = 7;
    }
}
