package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.recharge.platform.service.z;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes47.dex */
public final class RechargeFacadeUtilsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f90453a = null;

    public static final z a() {
        return (z) f90453a.getValue();
    }

    static {
        f90453a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, RechargeFacadeUtilsKt$rechargeFacade$2.INSTANCE);
    }
}
