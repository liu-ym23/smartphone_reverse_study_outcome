package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f77007a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f77008b = null;

    static {
        int[] r100 = new int[DynamicUpdateType.values().length];
        f77007a = r100;
        r100[DynamicUpdateType.SEAT.ordinal()] = 1;
        r100[DynamicUpdateType.ICON_MOVE.ordinal()] = 2;
        r100[DynamicUpdateType.UPDATE_LAYOUT_CONFIG.ordinal()] = 3;
        r100[DynamicUpdateType.RELOAD_LAYOUT.ordinal()] = 4;
        r100[DynamicUpdateType.SET_DYNAMIC_UI_FEATURES.ordinal()] = 5;
        r100[DynamicUpdateType.SEAT_CLICK.ordinal()] = 6;
        r100[DynamicUpdateType.ITEM_LOAD_DURATION.ordinal()] = 7;
        int[] r101 = new int[DynamicGetType.values().length];
        f77008b = r101;
        r101[DynamicGetType.LINKMIC.ordinal()] = 1;
        r101[DynamicGetType.SEAT.ordinal()] = 2;
        r101[DynamicGetType.FRAME_INFO.ordinal()] = 3;
    }
}
