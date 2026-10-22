package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f76979a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f76980b = null;

    static {
        int[] r100 = new int[DynamicUpdateType.values().length];
        f76979a = r100;
        r100[DynamicUpdateType.LOAD.ordinal()] = 1;
        r100[DynamicUpdateType.UNLOAD.ordinal()] = 2;
        r100[DynamicUpdateType.LAYER_ELEMENT.ordinal()] = 3;
        r100[DynamicUpdateType.ANIM.ordinal()] = 4;
        r100[DynamicUpdateType.SET_DATA.ordinal()] = 5;
        r100[DynamicUpdateType.COMMON_SET_DATA.ordinal()] = 6;
        r100[DynamicUpdateType.EFFECT.ordinal()] = 7;
        r100[DynamicUpdateType.PLAYMODE.ordinal()] = 8;
        r100[DynamicUpdateType.LOG.ordinal()] = 9;
        r100[DynamicUpdateType.CHECK_PERMISSION.ordinal()] = 10;
        r100[DynamicUpdateType.UPDATE_TRACKER.ordinal()] = 11;
        int[] r101 = new int[DynamicGetType.values().length];
        f76980b = r101;
        r101[DynamicGetType.PLAYMODE.ordinal()] = 1;
        r101[DynamicGetType.GET_DATA.ordinal()] = 2;
        r101[DynamicGetType.COMMON_GET_DATA.ordinal()] = 3;
        r101[DynamicGetType.DRESS.ordinal()] = 4;
        r101[DynamicGetType.ENTER_INFO.ordinal()] = 5;
        r101[DynamicGetType.ROOM.ordinal()] = 6;
        r101[DynamicGetType.LIVE_STREAM_DELAY_TIME.ordinal()] = 7;
        r101[DynamicGetType.CHANNEL_INFO.ordinal()] = 8;
    }
}
