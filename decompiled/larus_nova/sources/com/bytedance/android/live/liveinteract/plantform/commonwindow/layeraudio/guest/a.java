package com.bytedance.android.live.liveinteract.plantform.commonwindow.layeraudio.guest;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.base.LayerBackgroundStatus;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f75777a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f75778b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f75779c = null;

    static {
        int[] r100 = new int[LayerBackgroundStatus.values().length];
        f75777a = r100;
        r100[LayerBackgroundStatus.Audio.ordinal()] = 1;
        r100[LayerBackgroundStatus.Leave.ordinal()] = 2;
        int[] r101 = new int[MicSeatScene.values().length];
        f75778b = r101;
        MicSeatScene r102 = MicSeatScene.AUDIO_LINK_LARGE;
        r101[r102.ordinal()] = 1;
        MicSeatScene r103 = MicSeatScene.AUDIO_LINK_C_POSITION;
        r101[r103.ordinal()] = 2;
        MicSeatScene r104 = MicSeatScene.AUDIO_LINK_HAMLET_AVATAR;
        r101[r104.ordinal()] = 3;
        MicSeatScene r105 = MicSeatScene.AUDIO_LINK_STAGE_ENLARGE;
        r101[r105.ordinal()] = 4;
        int[] r106 = new int[MicSeatScene.values().length];
        f75779c = r106;
        r106[r102.ordinal()] = 1;
        r106[r103.ordinal()] = 2;
        r106[r104.ordinal()] = 3;
        r106[r105.ordinal()] = 4;
    }
}
