package com.bytedance.apm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    public static String a() {
        Date r10 = new Date(System.currentTimeMillis());
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(r10);
    }
}
