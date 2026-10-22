package com.bytedanceos.common.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {
    public static final String a(Context r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        TelephonyManager r12 = (TelephonyManager) r10.getSystemService("phone");
        if (r12 != null) goto L10;
        return null;
    L10:
        return r12.getImei(r11);
    L7:
        e = move-exception;
        com.bytedanceos.common.toolbox.j.b(e.toString());
        return null;
    }
}
