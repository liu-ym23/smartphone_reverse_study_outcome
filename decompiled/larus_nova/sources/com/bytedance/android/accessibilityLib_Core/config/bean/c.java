package com.bytedance.android.accessibilityLib_Core.config.bean;

/* JADX INFO: loaded from: classes43.dex */
public final class c {
    public static final boolean a(Integer r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.intValue() == (-1)) goto L8;
        if (r100.intValue() == 0) goto L8;
        return true;
    }
}
