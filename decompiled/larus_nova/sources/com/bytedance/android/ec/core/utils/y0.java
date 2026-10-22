package com.bytedance.android.ec.core.utils;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.sdk.ECSdk;

/* JADX INFO: loaded from: classes43.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f45750a;

    public static boolean a() {
        boolean r100 = true;
        if (f45750a == false) goto L14;
    L12:
        return r100;
    L14:
        int r101 = ECSdk.f48106a;     // Catch: Exception -> L13
        IAdapterService r102 = (IAdapterService) ECSdk.a(IAdapterService.class);     // Catch: Exception -> L13
        if (r102 == null) goto L10;
        if (r102.isLiveServiceReady() != true) goto L10;
    L11:
        f45750a = r100;
    L10:
        r100 = false;
        goto L11
    }

    static {
    }
}
