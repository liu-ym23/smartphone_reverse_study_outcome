package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.utils;

import com.bytedance.android.livesdk.config.p11;
import com.bytedance.android.livesdk.config.q11;
import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes8.dex */
public final class LiveBgPlayUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f116788a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f116789b;

    static {
        Lazy r100 = LazyKt.lazy(LiveBgPlayUtil$keva$2.INSTANCE);
        f116788a = r100;
        f116789b = ((Keva) r100.getValue()).getBoolean("key_keep_playing_switch_config", true);
    }

    public static q11 a() {
        return p11.f120949a.getValue();
    }
}
