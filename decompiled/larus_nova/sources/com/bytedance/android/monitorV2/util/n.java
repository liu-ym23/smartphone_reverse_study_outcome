package com.bytedance.android.monitorV2.util;

import java.util.UUID;

/* JADX INFO: loaded from: classes12.dex */
public final class n {
    public static String a() {
        return System.currentTimeMillis() + "-" + UUID.randomUUID().toString();
    }
}
