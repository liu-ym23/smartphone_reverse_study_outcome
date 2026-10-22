package com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.livesdk.config.rc0;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class b {
    @JvmStatic
    public static final boolean a() {
        Integer r100 = rc0.f121121a.getValue();
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
