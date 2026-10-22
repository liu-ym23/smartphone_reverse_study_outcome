package com.bytedance.android.live.xplay.basic.engine;

import com.bytedance.android.live.xplay.basic.api.XplayBasicState;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f102798a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f102799b = null;

    static {
        int[] r100 = new int[XplayBasicState.values().length];
        f102798a = r100;
        XplayBasicState r101 = XplayBasicState.Running;
        r100[r101.ordinal()] = 1;
        XplayBasicState r102 = XplayBasicState.Loaded;
        r100[r102.ordinal()] = 2;
        r100[XplayBasicState.Loading.ordinal()] = 3;
        r100[XplayBasicState.Stopped.ordinal()] = 4;
        int[] r103 = new int[XplayBasicState.values().length];
        f102799b = r103;
        r103[r102.ordinal()] = 1;
        r103[r101.ordinal()] = 2;
    }
}
