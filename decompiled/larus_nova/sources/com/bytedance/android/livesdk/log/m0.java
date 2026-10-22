package com.bytedance.android.livesdk.log;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f153381a;

    public m0() {
        this.f153381a = new HashMap();
    }

    public final void c(Map r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L9;
        ((HashMap) this.f153381a).putAll(r100);
        return;
    }

    public final void a(com.bytedance.android.livesdk.log.filter.o r100, String... r101) {
        if (r101.length < 1) goto L8;
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L10;
        String r104 = r101[r103];
        Map<String, String> r105 = this.f153381a;
        HashMap r106 = (HashMap) r105;
        r106.put(r104, l0.a(r104, r100));
        r103 = r103 + 1;
        goto L6
    L10:
        return;
    }

    public final void b(String r100, String r101) {
        ((HashMap) this.f153381a).put(r100, r101);
    }
}
