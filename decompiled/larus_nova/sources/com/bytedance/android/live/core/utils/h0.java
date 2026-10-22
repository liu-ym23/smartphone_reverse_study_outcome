package com.bytedance.android.live.core.utils;

import android.view.Display;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;

/* JADX INFO: loaded from: classes45.dex */
public final class h0 {
    public static float a() {
        if (b() > 0.0f) goto L5;
        return 16.666668f;
    L5:
        return 1000 / b();
    }

    public static float b() {
        WindowManager r100 = (WindowManager) s1.getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r100 == null) goto L8;
        Display r101 = r100.getDefaultDisplay();
        if (r101 == null) goto L8;
        return r101.getRefreshRate();
    L8:
        return 60;
    }
}
