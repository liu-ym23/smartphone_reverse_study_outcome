package com.bytedance.android.livesdk.interactivity.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class j implements kf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f141392a = null;

    public j() {
    }

    @Override // kf6.a
    public final void debug(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
    }

    @Override // kf6.a
    public final void error(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter("CoreEngine", "tag");
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    static {
        f141392a = new j();
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        ALogger.i("LiveDanmaku", r100);
    }
}
