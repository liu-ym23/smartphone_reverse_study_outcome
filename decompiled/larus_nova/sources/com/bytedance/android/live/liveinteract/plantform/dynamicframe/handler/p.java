package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f76998a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f76999b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f77000c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f77001d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int[] f77002e = null;

    static {
        int[] r100 = new int[DynamicUpdateType.values().length];
        f76998a = r100;
        DynamicUpdateType r101 = DynamicUpdateType.GET_CLIENT_SETTINGS;
        r100[r101.ordinal()] = 1;
        DynamicUpdateType r102 = DynamicUpdateType.SWITCH_LAYOUT;
        r100[r102.ordinal()] = 2;
        DynamicUpdateType r103 = DynamicUpdateType.SETTING_PANEL_CLICK;
        r100[r103.ordinal()] = 3;
        DynamicUpdateType r104 = DynamicUpdateType.LINKMIC_SETTING_UPDATE;
        r100[r104.ordinal()] = 4;
        int[] r105 = new int[DynamicUpdateType.values().length];
        f76999b = r105;
        DynamicUpdateType r106 = DynamicUpdateType.EDIT_MIC_POSITION;
        r105[r106.ordinal()] = 1;
        DynamicUpdateType r110 = DynamicUpdateType.FAST_MATCH;
        r105[r110.ordinal()] = 2;
        DynamicUpdateType r111 = DynamicUpdateType.OPEN_BEAUTY_PANEL;
        r105[r111.ordinal()] = 3;
        DynamicUpdateType r112 = DynamicUpdateType.UPDATE_ENLARGE_STATUS;
        r105[r112.ordinal()] = 4;
        DynamicUpdateType r113 = DynamicUpdateType.OPEN_CONTRIBUTION_LIST_PANEL;
        r105[r113.ordinal()] = 5;
        DynamicUpdateType r114 = DynamicUpdateType.INTERACT_PANEL_CLICK;
        r105[r114.ordinal()] = 6;
        int[] r107 = new int[DynamicUpdateType.values().length];
        f77000c = r107;
        r107[DynamicUpdateType.APPLY.ordinal()] = 1;
        r107[DynamicUpdateType.APPLY_FAST_MATCH.ordinal()] = 2;
        r107[DynamicUpdateType.APPLY_PAID_PRIORITY.ordinal()] = 3;
        r107[DynamicUpdateType.FAST_MATCH_JUMP.ordinal()] = 4;
        r107[DynamicUpdateType.OPEN_SETTING_DIALOG.ordinal()] = 5;
        r107[DynamicUpdateType.UPDATE_WAITING_LIST_DATA.ordinal()] = 6;
        r107[DynamicUpdateType.AUDIENCE_APPLY_PANEL_LIFE_CYCLE.ordinal()] = 7;
        r107[DynamicUpdateType.MULTI_LINK_PANEL_LIFE_CYCLE.ordinal()] = 8;
        r107[DynamicUpdateType.LINK_SERVICE.ordinal()] = 9;
        r107[r101.ordinal()] = 10;
        r107[r102.ordinal()] = 11;
        r107[r104.ordinal()] = 12;
        r107[r103.ordinal()] = 13;
        r107[r106.ordinal()] = 14;
        r107[r110.ordinal()] = 15;
        r107[r111.ordinal()] = 16;
        r107[r112.ordinal()] = 17;
        r107[r113.ordinal()] = 18;
        r107[r114.ordinal()] = 19;
        int[] r108 = new int[DynamicGetType.values().length];
        f77001d = r108;
        DynamicGetType r109 = DynamicGetType.INTERACT_PANEL_CONFIG;
        r108[r109.ordinal()] = 1;
        DynamicGetType r115 = DynamicGetType.KTV_ORDER_INFO;
        r108[r115.ordinal()] = 2;
        int[] r116 = new int[DynamicGetType.values().length];
        f77002e = r116;
        r116[DynamicGetType.LINK_SERVICE.ordinal()] = 1;
        r116[DynamicGetType.SETTING_PANEL_CONFIG.ordinal()] = 2;
        r116[r109.ordinal()] = 3;
        r116[r115.ordinal()] = 4;
    }
}
