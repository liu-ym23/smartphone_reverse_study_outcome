package com.bytedance.android.ecom.bcm.track.impl.monitor;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f51112a = 0;

    public d() {
    }

    static {
    }

    public static void a(final int r110, final String r111, final int r112, final String r113, final String r114, final JSONObject r115, final JSONObject r116, final PageFinder r210) {
        final boolean r117 = false;
        final EcomBcmTrackMonitor$monitorSearchParams$1 r100 = EcomBcmTrackMonitor$monitorSearchParams$1.INSTANCE;
        final Throwable r101 = null;
        Runnable r118 = new EcomBcmTrackMonitor$monitorSearchParams$runnable$1(r112, r110, r115, r116, r113, r114, r111, r100, r101, r210, r117);
        BtmSDK.INSTANCE.getThreadExecutor().a(r118, true);
    }
}
