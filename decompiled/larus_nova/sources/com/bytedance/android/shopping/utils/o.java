package com.bytedance.android.shopping.utils;

import com.bytedance.android.ec.sdk.helper.ECAppInfoService;

/* JADX INFO: loaded from: classes14.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f187155a = 0;

    public static float a() {
        ECAppInfoService r100 = ECAppInfoService.f48114e;
        if (r100.f() == false) goto L17;
        Float r101 = r100.getCurrentFontScale();
        if (r101 == null) goto L7;
        float r102 = r101.floatValue();
    L9:
        if (r102 <= 1.0f) goto L14;
        if (r102 > 1.15f) goto L14;
        return 1.15f;
    L14:
        if (r102 <= 1.15d) goto L17;
        return 1.3f;
    L7:
        r102 = 1.0f;
    L17:
        return 1.0f;
    }

    static {
    }
}
