package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.model.PublicScreenHeatState;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f123178a = null;

    static {
        int[] r100 = new int[PublicScreenHeatState.values().length];
        f123178a = r100;
        r100[PublicScreenHeatState.COLD.ordinal()] = 1;
        r100[PublicScreenHeatState.HOT.ordinal()] = 2;
        r100[PublicScreenHeatState.DEFAULT.ordinal()] = 3;
    }
}
