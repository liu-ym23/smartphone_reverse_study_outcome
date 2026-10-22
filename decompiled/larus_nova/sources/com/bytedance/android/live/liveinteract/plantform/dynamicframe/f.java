package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicGetType;
import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.AnimUpdateType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.LayerIndex;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.PlayModeUpdateType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.StageUpdateType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f76936a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f76937b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f76938c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f76939d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int[] f76940e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int[] f76941f = null;

    static {
        int[] r100 = new int[DynamicUpdateType.values().length];
        f76936a = r100;
        r100[DynamicUpdateType.LAYER_ELEMENT.ordinal()] = 1;
        r100[DynamicUpdateType.ANIM.ordinal()] = 2;
        int[] r101 = new int[DynamicGetType.values().length];
        f76937b = r101;
        r101[DynamicGetType.PLAYMODE.ordinal()] = 1;
        int[] r102 = new int[LayerIndex.values().length];
        f76938c = r102;
        r102[LayerIndex.Background.ordinal()] = 1;
        r102[LayerIndex.Seat.ordinal()] = 2;
        r102[LayerIndex.Biz.ordinal()] = 3;
        int[] r103 = new int[StageUpdateType.values().length];
        f76939d = r103;
        r103[StageUpdateType.INSERT.ordinal()] = 1;
        r103[StageUpdateType.UPDATE.ordinal()] = 2;
        r103[StageUpdateType.REMOVE.ordinal()] = 3;
        int[] r104 = new int[AnimUpdateType.values().length];
        f76940e = r104;
        r104[AnimUpdateType.START_WEBP_ANIM.ordinal()] = 1;
        r104[AnimUpdateType.SEAT.ordinal()] = 2;
        int[] r105 = new int[PlayModeUpdateType.values().length];
        f76941f = r105;
        r105[PlayModeUpdateType.ADD_PLAYMODE.ordinal()] = 1;
        r105[PlayModeUpdateType.REMOVE_PLAYMODE.ordinal()] = 2;
    }
}
