package com.bytedance.android.live.anchormodelink.handlers;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterGetType;
import com.bytedance.android.live.anchormodelink.model.DynamicCenterUpdateType;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f58674a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f58675b = null;

    static {
        int[] r100 = new int[DynamicCenterUpdateType.values().length];
        f58674a = r100;
        r100[DynamicCenterUpdateType.sendSEI.ordinal()] = 1;
        r100[DynamicCenterUpdateType.liveLinkCall.ordinal()] = 2;
        r100[DynamicCenterUpdateType.linkmicBeautyPanel.ordinal()] = 3;
        r100[DynamicCenterUpdateType.closeVideoChorus.ordinal()] = 4;
        int[] r101 = new int[DynamicCenterGetType.values().length];
        f58675b = r101;
        r101[DynamicCenterGetType.linkmic.ordinal()] = 1;
    }
}
