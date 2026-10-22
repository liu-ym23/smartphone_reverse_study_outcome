package com.bytedance.android.ec.common.impl.sku.log;

import dm.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class SkuLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f43090a = null;

    static {
        f43090a = LazyKt.lazy(SkuLog$isDebugOrLocalToast$2.INSTANCE);
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "message");
        a.b r102 = a.f469202a;
        a.a("SkuOnlineLog_".concat(r100)).i(r101);
    }
}
