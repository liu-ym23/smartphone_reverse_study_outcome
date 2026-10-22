package com.bytedance.android.gamecp.common.utils;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class LiveBroadcastBaseClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f57176a = null;

    static {
        f57176a = LazyKt.lazy(LiveBroadcastBaseClient$services$2.INSTANCE);
    }

    public static Object a(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        Lazy r101 = f57176a;
        if (((ConcurrentHashMap) r101.getValue()).contains(r100) == true) goto L6;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101.getValue();
        Object r103 = bs.e.a().b(r100);
        Intrinsics.checkNotNull(r103);
        r102.putIfAbsent(r100, r103);
    L6:
        return ((ConcurrentHashMap) r101.getValue()).get(r100);
    }
}
