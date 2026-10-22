package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f150300a = 0;

    @JvmStatic
    public static final long a() {
        int r100 = com.bytedance.android.ec.core.opt.ab.o.f45242a;     // Catch: Exception -> L9
        Object r101 = 5L;     // Catch: Exception -> L9
        boolean r102 = ECServiceManager.f42805a;     // Catch: Exception -> L9
        Object r103 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getLiveSettingsValue("flicker_icon_duration", r101);     // Catch: Exception -> L9
        if (r103 == null) goto L7;
        r101 = r103;
    L7:
        return ((Number) r101).longValue();
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return 5;
    }

    @JvmStatic
    public static final boolean b() {
        int r100 = com.bytedance.android.ec.core.opt.ab.o.f45242a;     // Catch: Exception -> L8
        Object r101 = Boolean.TRUE;     // Catch: Exception -> L8
        boolean r102 = ECServiceManager.f42805a;     // Catch: Exception -> L8
        Object r103 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getLiveSettingsValue("ec_live_limit_quantity_or_time_enable", r101);     // Catch: Exception -> L8
        if (r103 == null) goto L6;
        r101 = r103;
    L6:
        return ((Boolean) r101).booleanValue();
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return true;
    }

    static {
    }
}
