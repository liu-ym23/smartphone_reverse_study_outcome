package com.zyql.ai.selector.tools;

import android.content.Context;
import android.widget.Toast;

/* loaded from: classes4.dex */
public final class ToastUtils {
    private static final long TIME = 1500;
    private static long lastToastTime;

    public static boolean isShowToast() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - lastToastTime < 1500) {
            return true;
        }
        lastToastTime = jCurrentTimeMillis;
        return false;
    }

    public static void s(Context context, String str) {
        if (isShowToast()) {
            return;
        }
        Toast.makeText(context.getApplicationContext(), str, 0).show();
    }
}
