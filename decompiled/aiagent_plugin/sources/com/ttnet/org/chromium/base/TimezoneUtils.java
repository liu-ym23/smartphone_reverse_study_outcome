package com.ttnet.org.chromium.base;

import android.os.StrictMode;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes4.dex */
class TimezoneUtils {
    private TimezoneUtils() {
    }

    private static String getDefaultTimeZoneId() {
        StrictMode.ThreadPolicy r0 = StrictMode.allowThreadDiskReads();
        String r1 = TimeZone.getDefault().getID();
        StrictMode.setThreadPolicy(r0);
        return r1;
    }
}
