package com.bytedance.android.live.base.model.user;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class t0 implements am3.c<PublicAreaBadgeInfo.DslRule> {
    public t0() {
    }

    public static PublicAreaBadgeInfo.DslRule a(am3.g r110) throws Exception {
        PublicAreaBadgeInfo.DslRule r100 = new PublicAreaBadgeInfo.DslRule();
        r100.versionCode = new ArrayList();
        r100.abParams = new HashMap();
        r100.appId = new ArrayList();
        long r101 = r110.c();
    L3:
        int r102 = r110.f();
        if (r102 == (-1)) goto L30;
        if (r102 != 1) goto L8;
        r100.appId.add(Long.valueOf(r110.j()));
        goto L3
    L8:
        if (r102 != 2) goto L10;
        r100.versionCode.add(Long.valueOf(r110.j()));
        goto L3
    L10:
        if (r102 != 3) goto L11;
        long r103 = r110.c();
        String r104 = null;
        String r105 = null;
    L13:
        int r111 = r110.f();
        if (r111 == (-1)) goto L20;
        if (r111 != 1) goto L16;
        r104 = am3.h.c(r110);
        goto L13
    L16:
        if (r111 != 2) goto L13;
        r105 = am3.h.c(r110);
        goto L13
    L20:
        r110.d(r103);
        if (r104 == null) goto L27;
        if (r105 == null) goto L25;
        r100.abParams.put(r104, r105);
        goto L3
    L25:
        throw new IllegalStateException("Map value must not be null!");
    L27:
        throw new IllegalStateException("Map key must not be null!");
    L11:
        am3.h.e(r110);
        goto L3
    L30:
        r110.d(r101);
        return r100;
    }

    @Override // am3.c
    public final PublicAreaBadgeInfo.DslRule decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
