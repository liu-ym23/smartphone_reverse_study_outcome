package com.bytedance.android.live.liveinteract.hamlet;

import com.bytedance.android.live.xplay.basic.api.XplayBasicState;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f73492a = null;

    static {
        int[] r100 = new int[XplayBasicState.values().length];
        f73492a = r100;
        r100[XplayBasicState.Loading.ordinal()] = 1;
        r100[XplayBasicState.Loaded.ordinal()] = 2;
        r100[XplayBasicState.Running.ordinal()] = 3;
        r100[XplayBasicState.Stopped.ordinal()] = 4;
    }
}
