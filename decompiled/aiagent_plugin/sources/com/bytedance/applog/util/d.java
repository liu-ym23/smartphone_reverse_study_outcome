package com.bytedance.applog.util;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: DateUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static SimpleDateFormat a() {
        return a("yyyy-MM-dd");
    }

    public static SimpleDateFormat b() {
        return a("yyyy-MM-dd HH:mm:ss");
    }

    public static SimpleDateFormat a(String r2) {
        SimpleDateFormat r0 = new SimpleDateFormat(r2, Locale.US);
        r0.setTimeZone(TimeZone.getTimeZone("UTC+8"));
        return r0;
    }
}
