package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.preonline;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f75823a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f75824b = null;

    static {
        int[] r100 = new int[MicSeatScene.values().length];
        f75823a = r100;
        MicSeatScene r101 = MicSeatScene.AUDIO_LINK;
        r100[r101.ordinal()] = 1;
        MicSeatScene r102 = MicSeatScene.AUDIO_LINK_LARGE;
        r100[r102.ordinal()] = 2;
        r100[MicSeatScene.AUDIO_LINK_STAGE_ENLARGE.ordinal()] = 3;
        int[] r103 = new int[MicSeatScene.values().length];
        f75824b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
    }
}
