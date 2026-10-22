package com.bytedance.platform.godzilla.b;

import android.os.Build;

/* JADX INFO: compiled from: OSUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static boolean a() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT == 27) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }
}
