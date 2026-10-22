package com.bytedance.android.live.broadcastgame.opengame.debug;

import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f60024a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f60025b = null;

    static {
        int[] r100 = new int[PluginType.values().length];
        f60024a = r100;
        PluginType r101 = PluginType.MINI_APP;
        r100[r101.ordinal()] = 1;
        int[] r102 = new int[PluginType.values().length];
        f60025b = r102;
        r102[r101.ordinal()] = 1;
    }
}
