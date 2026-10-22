package com.bytedance.android.livesdk.dislike;

import com.bytedance.android.livesdk.config.k70;

/* JADX INFO: loaded from: classes8.dex */
public final class t {
    public static boolean a() {
        Integer r100 = k70.f120580a.getValue();
        if (r100 != null) goto L6;
    L7:
        if (r100 != null) goto L10;
    L12:
        return false;
    L10:
        if (r100.intValue() != 2) goto L12;
        return true;
    L6:
        if (r100.intValue() != 1) goto L7;
        return true;
    }

    public static boolean b() {
        Integer r100 = k70.f120580a.getValue();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 1) goto L8;
        return true;
    }

    public static boolean c() {
        Integer r100 = k70.f120580a.getValue();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 2) goto L8;
        return true;
    }

    static {
    }
}
