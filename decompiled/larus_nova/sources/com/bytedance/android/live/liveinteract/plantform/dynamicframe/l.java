package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f77064a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f77065b = null;

    static {
        int[] r100 = new int[DynamicUpdateType.values().length];
        f77064a = r100;
        r100[DynamicUpdateType.LOAD.ordinal()] = 1;
        r100[DynamicUpdateType.UNLOAD.ordinal()] = 2;
        r100[DynamicUpdateType.LAYER_ELEMENT.ordinal()] = 3;
        r100[DynamicUpdateType.SEAT_ANIMATE.ordinal()] = 4;
        r100[DynamicUpdateType.AUDIOCHAT_STAGE.ordinal()] = 5;
        r100[DynamicUpdateType.RELOAD_LAYOUT.ordinal()] = 6;
        r100[DynamicUpdateType.SET_DYNAMIC_UI_FEATURES.ordinal()] = 7;
        r100[DynamicUpdateType.ITEM_LOAD_DURATION.ordinal()] = 8;
        r100[DynamicUpdateType.KARAOKE.ordinal()] = 9;
        r100[DynamicUpdateType.INTERACTIVE_ORDER_SONG.ordinal()] = 10;
        r100[DynamicUpdateType.UPDATE_STAGE_LYRIC_FONT_STYLE.ordinal()] = 11;
        int[] r101 = new int[DynamicGetType.values().length];
        f77065b = r101;
        r101[DynamicGetType.LINKMIC.ordinal()] = 1;
        r101[DynamicGetType.SEAT.ordinal()] = 2;
        r101[DynamicGetType.FRAME_INFO.ordinal()] = 3;
        r101[DynamicGetType.ROOM.ordinal()] = 4;
        r101[DynamicGetType.SUBTITLE.ordinal()] = 5;
        r101[DynamicGetType.AVATAR.ordinal()] = 6;
        r101[DynamicGetType.KARAOKE.ordinal()] = 7;
        r101[DynamicGetType.INTERACTIVE_ORDER_SONG.ordinal()] = 8;
    }
}
