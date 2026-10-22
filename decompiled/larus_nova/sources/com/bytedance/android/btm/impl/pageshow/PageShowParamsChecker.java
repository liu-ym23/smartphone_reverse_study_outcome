package com.bytedance.android.btm.impl.pageshow;

import com.bytedance.android.btm.impl.monitor.BtmMonitor;
import com.bytedance.android.btm.impl.page.model.PageInfo;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes43.dex */
public final class PageShowParamsChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f42414a = null;

    static {
        f42414a = LazyKt.lazy(PageShowParamsChecker$btmFormatRegex$2.INSTANCE);
    }

    public static void a(int r110, String r111, PageInfo r112, Object r113) {
        BtmMonitor.k(BtmMonitor.f42161c, r110, r111, r113, r112, true, false, null, false, null, null, 992);
    }
}
