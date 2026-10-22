package com.bytedance.android.shopping.anchorv3.utils;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;

/* JADX INFO: loaded from: classes12.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Object f165311a;

    public static void a() {
        int r100 = ECSdk.f48106a;
        IAdapterService r101 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r101 == null) goto L10;
        com.bytedance.android.ec.adapter.api.j r102 = r101.getLiveWindowService();
        if (r102 == null) goto L11;
        Object r103 = f165311a;
        if (r103 == null) goto L12;
        r102.d(r103);
        f165311a = null;
        return;
    L12:
        return;
    L11:
        return;
    }

    static {
    }
}
