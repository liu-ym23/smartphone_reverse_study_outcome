package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.livesdk.config.tr0;

/* JADX INFO: loaded from: classes8.dex */
public final class o {
    public static boolean b() {
        return tr0.f121321a.getValue().a();
    }

    public static boolean a() {
        if (b() == true) goto L5;
    L7:
        return false;
    L5:
        if (tr0.f121321a.getValue().b() != 1) goto L7;
        return true;
    }

    static {
    }
}
