package com.bytedance.android.ec.hybrid.monitor;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ECHybridLogUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f47525a = null;

    static {
        f47525a = LazyKt.lazy(ECHybridLogUtil$logService$2.INSTANCE);
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        yj.h r103 = (yj.h) f47525a.getValue();
        if (r103 == null) goto L14;
        r103.log("ec_hybrid", r101);
        return;
    L14:
        return;
    L10:
        yj.h r104 = (yj.h) f47525a.getValue();
        if (r104 == null) goto L16;
        r104.log(r100, r101);
        return;
    L16:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
