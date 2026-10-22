package com.bytedance.android.livesdk.interactivity.api.like.utils;

import com.bytedance.android.livesdk.config.mn;
import kotlin.Lazy;
import r52.z0;
import ss1.c;

/* JADX INFO: loaded from: classes9.dex */
public final class DiggABHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f133280a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f133281b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f133282c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f133283d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f133284e = 0;

    public static c a() {
        return (c) f133281b.getValue();
    }

    static {
        f133280a = mn.f120769a.getValue().booleanValue();
        f133281b = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(DiggABHelper$diggAnimOptConfig$2.INSTANCE);
        f133282c = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(DiggABHelper$diggHideConfig$2.INSTANCE);
        f133283d = com.bytedance.android.livesdk.interactivity.api.base.utils.a.a(DiggABHelper$performanceOpt$2.INSTANCE);
        f133284e = z0.f536292a.getValue().intValue();
    }
}
