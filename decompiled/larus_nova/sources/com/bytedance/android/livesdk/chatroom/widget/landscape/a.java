package com.bytedance.android.livesdk.chatroom.widget.landscape;

import com.bytedance.android.live.core.utils.NetworkUtils;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f119066a = null;

    static {
        int[] r100 = new int[NetworkUtils.NetworkType.values().length];
        f119066a = r100;
        r100[NetworkUtils.NetworkType.MOBILE_2G.ordinal()] = 1;
        r100[NetworkUtils.NetworkType.MOBILE_3G.ordinal()] = 2;
        r100[NetworkUtils.NetworkType.MOBILE_4G.ordinal()] = 3;
        r100[NetworkUtils.NetworkType.MOBILE_5G.ordinal()] = 4;
        r100[NetworkUtils.NetworkType.MOBILE.ordinal()] = 5;
    }
}
