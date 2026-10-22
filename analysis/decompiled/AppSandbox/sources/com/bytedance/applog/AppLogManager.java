package com.bytedance.applog;

import com.bytedance.bdtracker.b;
import com.bytedance.bdtracker.r;

/* loaded from: classes.dex */
public final class AppLogManager {
    public static IAppLogInstance getInstance(String str) {
        if (r.c(str)) {
            return null;
        }
        return b.a(str);
    }
}
