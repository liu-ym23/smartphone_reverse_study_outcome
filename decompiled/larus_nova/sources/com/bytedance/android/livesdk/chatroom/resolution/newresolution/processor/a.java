package com.bytedance.android.livesdk.chatroom.resolution.newresolution.processor;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Long, PlayerResolution.PickResult> f110493a = null;

    static {
        f110493a = new LinkedHashMap();
    }

    public static void a(long r100, PlayerResolution.PickResult r101) {
        Intrinsics.checkNotNullParameter(r101, "resolutionInfo");
        f110493a.put(Long.valueOf(r100), r101);
    }
}
