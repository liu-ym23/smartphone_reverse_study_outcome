package com.bytedance.android.ec.sdk.helper;

import android.content.Context;
import com.bytedance.android.ec.base.service.ECServiceManager;

/* JADX INFO: loaded from: classes44.dex */
public final class m implements aj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f48127a = null;

    public m() {
    }

    static {
        f48127a = new m();
    }

    @Override // aj.a
    public final boolean a(Context r100, String r101) {
        Object r102 = d.f48119b.getIECHostMiniAppService();
        if (r102 != null) goto L6;
        boolean r103 = ECServiceManager.f42805a;
        r102 = ECServiceManager.c(aj.a.class);
    L6:
        return ((aj.a) r102).a(r100, r101);
    }
}
