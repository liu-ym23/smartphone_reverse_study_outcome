package com.bytedance.android.live.virtuallive.impl.anchor;

import com.bytedance.android.live.virtuallive.jsb.VirtualLiveJsbGetType;
import com.bytedance.android.live.virtuallive.jsb.VirtualLiveJsbUpdateType;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f102633a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f102634b = null;

    static {
        int[] r100 = new int[VirtualLiveJsbUpdateType.values().length];
        f102633a = r100;
        r100[VirtualLiveJsbUpdateType.AVATAR.ordinal()] = 1;
        r100[VirtualLiveJsbUpdateType.SCENE.ordinal()] = 2;
        r100[VirtualLiveJsbUpdateType.SCENE_AREA.ordinal()] = 3;
        r100[VirtualLiveJsbUpdateType.SCENE_EFFECT.ordinal()] = 4;
        r100[VirtualLiveJsbUpdateType.LENS_SET.ordinal()] = 5;
        r100[VirtualLiveJsbUpdateType.PITCH_ANGLE.ordinal()] = 6;
        r100[VirtualLiveJsbUpdateType.DEBUG.ordinal()] = 7;
        r100[VirtualLiveJsbUpdateType.SETTING.ordinal()] = 8;
        r100[VirtualLiveJsbUpdateType.VIDEO_PREVIEW.ordinal()] = 9;
        r100[VirtualLiveJsbUpdateType.SET_DATA.ordinal()] = 10;
        int[] r101 = new int[VirtualLiveJsbGetType.values().length];
        f102634b = r101;
        r101[VirtualLiveJsbGetType.UE_INIT_INFO.ordinal()] = 1;
        r101[VirtualLiveJsbGetType.ANCHOR_LIVE_STATUS.ordinal()] = 2;
    }
}
