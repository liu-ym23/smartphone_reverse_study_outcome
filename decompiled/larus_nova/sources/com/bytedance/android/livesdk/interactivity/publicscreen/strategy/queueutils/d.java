package com.bytedance.android.livesdk.interactivity.publicscreen.strategy.queueutils;

import com.bytedance.android.livesdk.interactivity.api.entity.PSMessageHeatState;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f139563a = null;

    static {
        int[] r100 = new int[PSMessageHeatState.values().length];
        f139563a = r100;
        r100[PSMessageHeatState.HOT.ordinal()] = 1;
        r100[PSMessageHeatState.NORMAL.ordinal()] = 2;
        r100[PSMessageHeatState.COLD.ordinal()] = 3;
    }
}
