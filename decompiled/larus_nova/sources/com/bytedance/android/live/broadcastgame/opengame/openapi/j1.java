package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.cloud.CloudResultType$ClientResultType;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f60501a = null;

    static {
        int[] r100 = new int[CloudResultType$ClientResultType.values().length];
        f60501a = r100;
        r100[CloudResultType$ClientResultType.NetworkTimeOut.ordinal()] = 1;
        r100[CloudResultType$ClientResultType.NetworkError.ordinal()] = 2;
        r100[CloudResultType$ClientResultType.NetworkUnavailable.ordinal()] = 3;
        r100[CloudResultType$ClientResultType.ServerError.ordinal()] = 4;
    }
}
