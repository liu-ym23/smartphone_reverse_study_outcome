package com.bytedance.android.shopping.extensions;

import android.content.Context;
import android.content.res.Resources;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;

/* JADX INFO: loaded from: classes13.dex */
public final class j {
    public static final int a(int r100) {
        Context r101 = ECAppInfoService.f48114e.getApplicationContext();
        if (r101 == null) goto L7;
        Resources r102 = r101.getResources();
        if (r102 == null) goto L7;
        return r102.getDimensionPixelOffset(r100);
    L7:
        return 0;
    }

    public static final int b(int r100) {
        Context r101 = ECAppInfoService.f48114e.getApplicationContext();
        if (r101 == null) goto L7;
        Resources r102 = r101.getResources();
        if (r102 == null) goto L7;
        return r102.getColor(r100);
    L7:
        return 0;
    }

    public static final String c(int r100) {
        Context r101 = ECAppInfoService.f48114e.getApplicationContext();
        if (r101 == null) goto L6;
        String r102 = r101.getString(r100);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    public static final String d(int r100, Object r101) {
        Context r102 = ECAppInfoService.f48114e.getApplicationContext();
        if (r102 == null) goto L6;
        String r103 = r102.getString(r100, new Object[]{r101});
        if (r103 == null) goto L6;
        return r103;
    L6:
        return "";
    }

    public static final String e(int r100, Object r101, Object r102) {
        Context r103 = ECAppInfoService.f48114e.getApplicationContext();
        if (r103 == null) goto L6;
        String r104 = r103.getString(r100, new Object[]{r101, r102});
        if (r104 == null) goto L6;
        return r104;
    L6:
        return "";
    }
}
