package com.baidu.platform.core.share;

import com.baidu.mapapi.search.share.RouteShareURLOption;

/* loaded from: classes.dex */
public class d extends com.baidu.platform.base.c {
    public d(RouteShareURLOption routeShareURLOption) {
        a(routeShareURLOption);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.baidu.mapapi.search.share.RouteShareURLOption r12) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.core.share.d.a(com.baidu.mapapi.search.share.RouteShareURLOption):void");
    }

    private int b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.o();
    }
}
