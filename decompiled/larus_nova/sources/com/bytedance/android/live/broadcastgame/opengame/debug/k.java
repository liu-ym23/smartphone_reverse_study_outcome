package com.bytedance.android.live.broadcastgame.opengame.debug;

import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f60022a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f60023b = null;

    static {
        int[] r100 = new int[PluginType.values().length];
        f60022a = r100;
        PluginType r101 = PluginType.LYNX;
        r100[r101.ordinal()] = 1;
        PluginType r102 = PluginType.SONIC_GAME;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[PluginType.values().length];
        f60023b = r103;
        r103[r101.ordinal()] = 1;
        r103[r102.ordinal()] = 2;
        r103[PluginType.MINI_APP.ordinal()] = 3;
    }
}
