package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.liveinteract.plantform.dynamicframe.model.SeatUpdateType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f76430a = null;

    static {
        int[] r100 = new int[SeatUpdateType.values().length];
        f76430a = r100;
        r100[SeatUpdateType.UPDATE_BY_UID.ordinal()] = 1;
        r100[SeatUpdateType.UPDATE_BY_POS.ordinal()] = 2;
        r100[SeatUpdateType.UPDATE_ALL.ordinal()] = 3;
        r100[SeatUpdateType.RESET.ordinal()] = 4;
    }
}
