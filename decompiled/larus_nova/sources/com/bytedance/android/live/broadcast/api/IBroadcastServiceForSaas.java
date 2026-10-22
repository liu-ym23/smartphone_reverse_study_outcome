package com.bytedance.android.live.broadcast.api;

import android.content.Context;
import android.os.Bundle;
import ld1.b;
import ld1.c;

/* JADX INFO: loaded from: classes45.dex */
public interface IBroadcastServiceForSaas {

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcast.api.IBroadcastServiceForSaas$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$createPreviewContainerFragment(IBroadcastServiceForSaas r100, Context r101, Bundle r102, b r103) {
        }

        public static void $default$createStartLiveFragment(IBroadcastServiceForSaas r100, Context r101, c r102) {
        }
    }

    void createPreviewContainerFragment(Context r100, Bundle r101, b r102);

    void createStartLiveFragment(Context r100, c r101);
}
