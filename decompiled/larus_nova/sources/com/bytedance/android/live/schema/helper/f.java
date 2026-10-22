package com.bytedance.android.live.schema.helper;

import com.bytedance.keva.Keva;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f100518a = 0;

    static {
    }

    public static Pair a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Keva r100 = Keva.getRepo("lynx_common_cache");
        long r101 = Keva.getRepo("lynx_cache_valid_time").getLong(r110, 0);
        if (r101 <= (System.currentTimeMillis() / ((long) 1000))) goto L7;
        return TuplesKt.to(Boolean.TRUE, r100.getString(r110, null));
    L7:
        if (r101 != 0) goto L11;
        return TuplesKt.to(Boolean.TRUE, null);
    L11:
        return TuplesKt.to(Boolean.FALSE, null);
    }
}
