package com.bytedance.android.live.liveinteract.plantform.utils;

import androidx.camera.video.AudioStats;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.s1;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class n0 {
    public static final JsonObject a(dg2.e r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toDynamicInfoJsonObject");
        NetworkUtils.NetworkType r101 = NetworkUtils.b(s1.getContext(), NetworkUtils.f66071a);
        boolean r102 = NetworkUtils.e(s1.getContext());
        JsonObject r103 = new JsonObject();
        r103.addProperty("uid", null);
        r103.addProperty("loss_ratio", Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
        int r104 = 0;
        r103.addProperty("rtt", 0);
        r103.addProperty("total_band_width", 0);
        r103.addProperty("tx_quality", 0);
        r103.addProperty("rx_quality", 0);
        r103.addProperty("wwan_available", Boolean.valueOf(r102));
        if (r101 != NetworkUtils.NetworkType.WIFI) goto L6;
        r104 = 1;
    L9:
        r103.addProperty("network_status", Integer.valueOf(r104));
        return r103;
    L6:
        if (r101 == NetworkUtils.NetworkType.NONE) goto L9;
        r104 = 2;
        goto L9
    }
}
