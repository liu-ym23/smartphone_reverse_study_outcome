package com.bytedance.android.live.room.api.playopt.base;

import fv1.e;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes47.dex */
public final class LivePlayOptUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f99053a = null;

    static {
        f99053a = LazyKt.lazy(LivePlayOptUtils$pushConfig$2.INSTANCE);
    }

    public static long a() {
        return ((e) f99053a.getValue()).b() * ((long) 1000);
    }
}
