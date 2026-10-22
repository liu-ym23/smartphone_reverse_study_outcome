package com.bytedance.android.live.revlink.impl.pk.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final String a(AutoMatchSource r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLogParam");
        switch(a.f97089a[r100.ordinal()]) {
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L6;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "invited_interrupt";
    L6:
        return "fail_connection";
    L7:
        return "failed_request";
    L8:
        return "overtime";
    }
}
