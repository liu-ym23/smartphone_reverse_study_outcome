package com.bytedance.android.gamecp.base.gamedetail;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class c1 {
    public static final String a(String r100) {
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == true) goto L5;
        return r100;
    L5:
        if (r100.length() == 9) goto L7;
        return r100;
    L7:
        return ("#" + r100.subSequence(7, 9)) + r100.subSequence(1, 7);
    }
}
