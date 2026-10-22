package com.bytedance.android.livesdk.gift.platform.core.keva_store;

import iz0.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final iz0.a f130726a = null;

    static {
        f130726a = c.a("live_asset_download_repo", 0);
    }

    public static String a(AssetKevaKey r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return f130726a.d(r100.getKey(), "");
    }

    public static long c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "md5");
        return f130726a.e("last_use_time_".concat(r100), 0);
    }

    public static void b(AssetKevaKey r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        f130726a.a(r100.getKey(), r101);
    }

    public static void d(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "md5");
        f130726a.b("last_use_time_" + r100, r101);
    }
}
