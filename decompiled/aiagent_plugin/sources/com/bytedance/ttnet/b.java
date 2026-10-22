package com.bytedance.ttnet;

import android.text.TextUtils;

/* JADX INFO: compiled from: AppConsts.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static String a() {
        String r0 = TTNetInit.getTTNetDepend().c();
        if (r0 == null) goto L8;
        if (TextUtils.isEmpty(r0) == true) goto L8;
        return r0;
    L8:
        throw new IllegalArgumentException("hostSuffix is not init !!!");
    }
}
