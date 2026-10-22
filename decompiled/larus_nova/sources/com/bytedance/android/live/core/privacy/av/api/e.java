package com.bytedance.android.live.core.privacy.av.api;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public interface e {

    public static final class a {
        public static void a(String r100, String r101, b r102, com.bytedance.android.live.core.privacy.av.api.a r103, int r110) {
            q60.a r104 = q60.a.f531757d;
            if ((r110 & 4) == 0) goto L5;
            Map<String, String> r105 = Collections.emptyMap();
        L6:
            Map<String, String> r106 = r105;
            if ((r110 & 8) == 0) goto L9;
            b.f65134a.getClass();
            r102 = b.a.f65135a;
        L9:
            b r107 = r102;
            if ((r110 & 16) == 0) goto L12;
            r103 = com.bytedance.android.live.core.privacy.av.api.a.f65132b;
        L12:
            r104.d(r100, r101, r106, r107, r103);
            return;
        L5:
            r105 = null;
            goto L6
        }
    }

    int c(String r100, String r101, Map<String, String> r102, b r103, com.bytedance.android.live.core.privacy.av.api.a r104);

    int d(String r100, String r101, Map<String, String> r102, b r103, com.bytedance.android.live.core.privacy.av.api.a r104);

    int e(String r100, String r101, Map<String, String> r102, b r103, com.bytedance.android.live.core.privacy.av.api.a r104);

    void g();
}
