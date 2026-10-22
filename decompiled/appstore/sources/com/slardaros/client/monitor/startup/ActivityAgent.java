package com.slardaros.client.monitor.startup;

import android.text.TextUtils;
import androidx.annotation.Keep;
import ee.a;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class ActivityAgent {
    private static final String TAG = "ActivityInstrumentation";
    private static boolean sIsFirstWindowFocusChangedActivity = true;

    static {
    }

    public ActivityAgent() {
    }

    @Keep
    public static void onTrace(String r10, String r11, boolean r12) {
        if (sIsFirstWindowFocusChangedActivity == true) goto L6;
        return;
    L6:
        if (TextUtils.equals("onCreate", r11) == false) goto L11;
        if (r12 == false) goto L9;
        a.c(r10);
        return;
    L9:
        a.b();
        return;
    L11:
        if (TextUtils.equals("onResume", r11) == false) goto L16;
        if (r12 == false) goto L14;
        a.e(r10);
        return;
    L14:
        a.d();
        return;
    L16:
        if (TextUtils.equals("onWindowFocusChanged", r11) == false) goto L20;
        if (r12 == false) goto L29;
        a.h(r10);
        sIsFirstWindowFocusChangedActivity = false;
        return;
    L29:
        return;
    L20:
        if (TextUtils.equals("onStart", r11) == false) goto L31;
        if (r12 == false) goto L23;
        a.g(r10);
        return;
    L23:
        a.f(r10);
        return;
    }
}
