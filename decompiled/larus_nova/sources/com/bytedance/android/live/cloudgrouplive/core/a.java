package com.bytedance.android.live.cloudgrouplive.core;

import com.bytedance.android.live.cloudgrouplive.rtc.AnchorGroupLiveStatus;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f64446a = null;

    static {
        int[] r100 = new int[AnchorGroupLiveStatus.values().length];
        f64446a = r100;
        r100[AnchorGroupLiveStatus.WAITING.ordinal()] = 1;
        r100[AnchorGroupLiveStatus.READY.ordinal()] = 2;
        r100[AnchorGroupLiveStatus.PERFORMING.ordinal()] = 3;
    }
}
