package com.bytedance.applog;

import android.content.Context;
import com.bytedance.bdtracker.y5;

/* loaded from: classes.dex */
public class OaidHelper {
    public static int oadiTimeout = 100;

    public static void initOaidEarly(Context context) {
        y5.b(context);
    }
}
