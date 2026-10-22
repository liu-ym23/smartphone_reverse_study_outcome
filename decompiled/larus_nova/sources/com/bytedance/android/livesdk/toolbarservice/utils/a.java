package com.bytedance.android.livesdk.toolbarservice.utils;

import com.bytedance.android.live.core.utils.a0;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final boolean a(DataCenter r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (a0.d(r100, false) == false) goto L7;
        return false;
    L7:
        if (a0.l(r100, true) == true) goto L9;
        return false;
    L9:
        if (a0.c(r100) == true) goto L15;
        return true;
    L15:
        return false;
    }
}
