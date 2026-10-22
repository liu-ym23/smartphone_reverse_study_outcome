package com.android.contacts.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* JADX INFO: loaded from: classes2.dex */
public class ZhConverter {
    private static volatile ZhConverter sConverter;
    private Properties charMap;

    public static ZhConverter getInstance(Context r2) {
        if (sConverter != null) goto L15;
        monitor-enter(ZhConverter.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sConverter != null) goto L9;
        sConverter = new ZhConverter(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ZhConverter.class);     // Catch: Throwable -> L11
    L15:
        return sConverter;
    }

    private ZhConverter(Context r3) {
        this.charMap = new Properties();
        InputStream r0 = null;
        r0 = r3.getApplicationContext().getAssets().open("zh2Hans_bytedance.properties");     // Catch: Throwable -> L7 IOException -> L9
        this.charMap.load(r0);     // Catch: Throwable -> L7 IOException -> L9
        if (r0 != null) goto L24;
        return;
    L24:
        r0.close();     // Catch: IOException -> L17
        return;
    L28:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
        if (r0 != null) goto L24;
        return;
    L7:
        th = move-exception;
        if (r0 != null) goto L22;
    L16:
        throw th;
    L22:
        r0.close();     // Catch: IOException -> L18
        goto L16
    }

    public static String convert(Context r0, String r1) {
        return getInstance(r0).convert(r1);
    }

    public String convert(String r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= r6.length()) goto L11;
        String r2 = "" + r6.charAt(r1);
        if (this.charMap.containsKey(r2) == false) goto L8;
        r0.append(this.charMap.get(r2));
    L9:
        r1 = r1 + 1;
        goto L4
    L8:
        r0.append(r2);
        goto L9
    L11:
        return r0.toString();
    }
}
