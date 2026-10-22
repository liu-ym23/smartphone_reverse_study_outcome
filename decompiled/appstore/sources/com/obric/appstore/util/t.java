package com.obric.appstore.util;

import com.obric.appstore.StoreBaseApplication;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t {
    public static final com.obric.appstore.network.g.a a(Throwable r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        int r11 = com.bytedanceos.common.utils.k.b(r10);
        StoreBaseApplication r12 = pa.a.f23414a.a();     // Catch: Exception -> L7
        if (r12 == null) goto L9;
        String r13 = r12.getString(com.bytedanceos.common.toolbox.l.f10067a.get(r11));     // Catch: Exception -> L7
    L11:
        com.bytedanceos.common.toolbox.j.b("parseToCommonLoadState " + kotlin.a.b(r10));
        if (r13 != null) goto L15;
        r13 = "null error msg";
    L15:
        return new com.obric.appstore.network.g.a(r11, r13);
    L9:
        r13 = null;
    L7:
        e = move-exception;
        com.bytedanceos.common.toolbox.j.b(String.valueOf(e));
        r13 = "get errorMsg exception !!!";
        goto L11
    }
}
