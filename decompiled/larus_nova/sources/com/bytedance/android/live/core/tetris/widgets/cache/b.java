package com.bytedance.android.live.core.tetris.widgets.cache;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiRoomConfig;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f65961a = 0;

    static {
    }

    public static void c(String... r110) {
        Intrinsics.checkNotNullParameter(r110, "strings");
        ALogger.i("ComponentCacheLog", String.valueOf(ArraysKt.joinToString$default(r110, ", ", null, null, 0, null, null, 62, null)));
    }

    public static void a(String r110, String... r111) {
        Intrinsics.checkNotNullParameter(r110, "logKey");
        Intrinsics.checkNotNullParameter(r111, "strings");
        ALogger.i("ComponentCacheLog", "当前操作的直播间是 ：" + ArraysKt.joinToString$default(r111, ", ", null, null, 0, null, null, 62, null) + "， 当前的路径是" + r110 + ' ');
    }

    public static void b(String r110, String... r111) {
        Intrinsics.checkNotNullParameter(r110, "logKey");
        Intrinsics.checkNotNullParameter(r111, "strings");
        if (MultiRoomConfig.INSTANCE.enableComponentCacheFullLog() == false) goto L6;
        ALogger.i("ComponentCacheLog", "当前操作的直播间是 ：" + ArraysKt.joinToString$default(r111, ", ", null, null, 0, null, null, 62, null) + "， 当前的路径是" + r110 + ' ');
        return;
    }
}
