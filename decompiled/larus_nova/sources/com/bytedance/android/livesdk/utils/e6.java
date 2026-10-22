package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.ui.VideoViewParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class e6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f158941a = 0;

    static {
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        ALogger.i("ShadowPlayerPosition", r100);
    }

    public static void b(String r100, VideoViewParams r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "videoViewParams");
        ALogger.i("ShadowPlayerPosition", "[" + r100 + "] put VideoViewParams: " + r101);
    }
}
