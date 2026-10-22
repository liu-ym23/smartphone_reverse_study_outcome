package com.ttnet.org.chromium.base;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    static {
    }

    public static int a(Context r10, String r11, int r12, int r13) {
        return r10.checkPermission(r11, r12, r13);
    L4:
        return -1;
    }
}
