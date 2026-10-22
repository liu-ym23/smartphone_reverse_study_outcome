package com.bytedance.android.openlive;

import ry.h;
import ry.j;

/* JADX INFO: loaded from: classes12.dex */
public class LiveInitWrapper {
    public LiveInitWrapper() {
    }

    public static void init(h r100, j r101) {
        Live.INSTANCE.initLivePlugin(r100, r101, null);
    }

    public static void initWithTransform(h r100, j r101, IHostServiceTransformer r102) {
        Live.INSTANCE.initLivePlugin(r100, r101, r102);
    }
}
