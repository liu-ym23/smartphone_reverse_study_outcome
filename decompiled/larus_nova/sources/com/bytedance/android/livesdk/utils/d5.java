package com.bytedance.android.livesdk.utils;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;

/* JADX INFO: loaded from: classes11.dex */
public final class d5 {
    public static int b(String r100) {
        if (r100 != null) goto L8;
        return 0;
    L8:
        return CastIntegerProtector.parseInt(r100);
    L7:
        return 0;
    }

    public static long c(String r100) {
        return CastLongProtector.parseLong(r100);
    L4:
        return 0;
    }

    public static Boolean a(String r100, boolean r101) {
        if (r100 == null) goto L4;
        return Boolean.valueOf(Boolean.parseBoolean(r100));
    L8:
        return Boolean.valueOf(r101);
    L4:
        return Boolean.valueOf(r101);
    }
}
