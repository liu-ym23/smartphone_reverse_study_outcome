package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.fk0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f141754a = 0;

    public static boolean a() {
        return fk0.f120211a.getValue().booleanValue();
    }

    static {
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.e("SimpleZDanmakuUtil", r100);
    }

    public static void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("SimpleZDanmakuUtil", r100);
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ALogger.i("SimpleZDanmakuSetting", r100);
    }
}
