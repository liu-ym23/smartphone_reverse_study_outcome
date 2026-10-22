package com.bytedance.android.ec.sdk.helper;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class DLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f48109a = null;

    public static cl.c b() {
        return (cl.c) f48109a.getValue();
    }

    static {
        f48109a = LazyKt.lazy(DLog$printer$2.INSTANCE);
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        cl.c r102 = b();
        if (r102 == null) goto L6;
        r102.log();
        return;
    }
}
