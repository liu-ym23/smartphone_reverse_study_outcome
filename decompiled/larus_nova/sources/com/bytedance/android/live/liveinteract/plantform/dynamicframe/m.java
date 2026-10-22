package com.bytedance.android.live.liveinteract.plantform.dynamicframe;

import com.bytedance.android.live.liveinteract.plantform.dynamic.DynamicUpdateType;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.LayerIndex;
import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.StageUpdateType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f77067a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f77068b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f77069c = null;

    static {
        int[] r100 = new int[DynamicUpdateType.values().length];
        f77067a = r100;
        r100[DynamicUpdateType.LAYER_ELEMENT.ordinal()] = 1;
        int[] r101 = new int[LayerIndex.values().length];
        f77068b = r101;
        r101[LayerIndex.Background.ordinal()] = 1;
        r101[LayerIndex.Seat.ordinal()] = 2;
        r101[LayerIndex.Biz.ordinal()] = 3;
        int[] r102 = new int[StageUpdateType.values().length];
        f77069c = r102;
        r102[StageUpdateType.INSERT.ordinal()] = 1;
        r102[StageUpdateType.REMOVE.ordinal()] = 2;
        r102[StageUpdateType.UPDATE.ordinal()] = 3;
    }
}
