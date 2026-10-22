package com.bytedance.ai.applet.app.foundation.performance;

import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public final class m {
    public static final Long a(Map r100, String r101) {
        Object r102 = r100.get(r101);
        if ((r102 instanceof Number) == false) goto L5;
        Number r103 = (Number) r102;
    L6:
        if (r103 == null) goto L14;
        Long r104 = Long.valueOf(r103.longValue());
        if (r104.longValue() < 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == true) goto L13;
        return null;
    L13:
        return r104;
    L10:
        r105 = false;
        goto L11
    L14:
        return null;
    L5:
        r103 = null;
        goto L6
    }
}
