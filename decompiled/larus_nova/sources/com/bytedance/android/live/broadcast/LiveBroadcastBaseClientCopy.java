package com.bytedance.android.live.broadcast;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveBroadcastBaseClientCopy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f58956a = null;

    static {
        f58956a = LazyKt.lazy(LiveBroadcastBaseClientCopy$services$2.INSTANCE);
    }

    @JvmStatic
    public static final <T> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        Lazy r101 = f58956a;
        if (((ConcurrentHashMap) r101.getValue()).contains(r100) == true) goto L6;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101.getValue();
        Object r103 = com.bytedance.android.live.network.c.b().e(r100);
        Intrinsics.checkNotNull(r103);
        r102.putIfAbsent(r100, r103);
    L6:
        return (T) ((ConcurrentHashMap) r101.getValue()).get(r100);
    }
}
