package com.bytedance.android.ec.core.sku;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.slice.ext.template.gecko.SlcGeckoTemplateMgr;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f45326a = null;

    static {
        f45326a = new c();
    }

    public c() {
    }

    public static void a() {
        Map r100 = SkuPerformanceOpt.b();
        if (r100 == null) goto L5;
        Object r101 = r100.get("ec_sku_load_on_boot_finish");
    L6:
        Intrinsics.areEqual(r101, 1);
        qh.a.a();
        Context r102 = ECAppInfoService.f48114e.getApplicationContext();
        if (r102 == null) goto L10;
        SlcGeckoTemplateMgr.f(SlcGeckoTemplateMgr.f51232l, "yata_sku", "ecom_sku_pannel_template", wh.a.b(r102), SkuPerformanceOpt$preloadTemplate$1.INSTANCE);
    L10:
        dm.a.a("SkuPerformanceOpt").i("preloadTemplate on bootFinish");
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
