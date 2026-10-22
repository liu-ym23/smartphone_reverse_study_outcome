package com.bytedance.android.live.room.api.experience.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.room.api.playopt.topspeed.TopSpeedModeUtils;
import com.bytedance.android.live.strategy.api.IStrategyService;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class PlatformExpUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f98909a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f98910b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f98911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f98912d;

    public static fv1.b c() {
        return (fv1.b) f98909a.getValue();
    }

    static {
        f98909a = LazyKt.lazy(PlatformExpUtils$setting$2.INSTANCE);
        f98910b = LazyKt.lazy(PlatformExpUtils$delayConfig$2.INSTANCE);
        IStrategyService r100 = (IStrategyService) k.f(IStrategyService.class);
        if (r100 == null) goto L7;
        LiveData r101 = r100.getFactor("live_push_consume_advice", Boolean.FALSE, true, true);
        if (r101 == null) goto L7;
        Boolean r102 = (Boolean) r101.getValue();
    L8:
        f98912d = Intrinsics.areEqual(r102, Boolean.TRUE);
        return;
    L7:
        r102 = null;
        goto L8
    }

    @JvmStatic
    public static final boolean a() {
        if (c().l() == false) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L11;
    L14:
        return true;
    L11:
        if (b() == true) goto L14;
        if (TopSpeedModeUtils.a() == true) goto L14;
        return false;
    L5:
        if (a.f98913a.a() == true) goto L8;
        r100 = false;
        goto L9
    }

    @JvmStatic
    public static final boolean b() {
        if (c().k() == true) goto L5;
    L7:
        return false;
    L5:
        if (TopSpeedModeUtils.a() == true) goto L7;
        return true;
    }

    public static long d() {
        return c().h() * ((long) 1000);
    }
}
