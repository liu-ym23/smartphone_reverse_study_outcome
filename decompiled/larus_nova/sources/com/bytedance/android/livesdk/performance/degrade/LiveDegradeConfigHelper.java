package com.bytedance.android.livesdk.performance.degrade;

import com.bytedance.android.livesdk.utils.z0;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveDegradeConfigHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f154518a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f154519b = false;

    public static com.bytedance.android.livesdk.performance.c a() {
        return (com.bytedance.android.livesdk.performance.c) f154518a.getValue();
    }

    static {
        boolean r100 = false;
        float r101 = z0.b(false);
        f154518a = LazyKt.lazy(LiveDegradeConfigHelper$degradeOpt$2.INSTANCE);
        if (a().enable == true) goto L5;
    L11:
        f154519b = r100;
        return;
    L5:
        if (r101 <= a().downLimitScore) goto L9;
        if (r101 > a().upLimitScore) goto L9;
    L10:
        r100 = true;
    L9:
        if (a().forceEnable == false) goto L11;
        goto L10
    }
}
