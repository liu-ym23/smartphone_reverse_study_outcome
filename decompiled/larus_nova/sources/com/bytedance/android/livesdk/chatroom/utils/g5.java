package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes8.dex */
public final class g5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f114483a = null;

    public static final class a {
    }

    static {
        f114483a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("uhd_high", PlayerResolution.SDKKEY.UHD), TuplesKt.to(PlayerResolution.SDKKEY.UHD, PlayerResolution.SDKKEY.UHD), TuplesKt.to("hd_high", PlayerResolution.SDKKEY.HD), TuplesKt.to(PlayerResolution.SDKKEY.HD, PlayerResolution.SDKKEY.HD), TuplesKt.to("sd_high", PlayerResolution.SDKKEY.SD), TuplesKt.to(PlayerResolution.SDKKEY.SD, PlayerResolution.SDKKEY.SD), TuplesKt.to("ld_high", PlayerResolution.SDKKEY.LD), TuplesKt.to(PlayerResolution.SDKKEY.LD, PlayerResolution.SDKKEY.LD)});
    }
}
