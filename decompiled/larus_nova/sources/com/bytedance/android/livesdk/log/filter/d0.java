package com.bytedance.android.livesdk.log.filter;

import com.bytedance.common.utility.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class d0 extends a<am2.q> {
    public d0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.q r102 = (am2.q) r101;
        super.u(r100, r102);
        if (r102 != null) goto L6;
        return;
    L6:
        if (StringUtils.isEmpty(r102.f4324a) == true) goto L10;
        if (r100 == null) goto L10;
        String r103 = (String) r100.put("order", r102.f4324a);
    L10:
        if (StringUtils.isEmpty(r102.f4326c) == true) goto L14;
        if (r100 == null) goto L14;
        String r104 = (String) r100.put("first_request_page", r102.f4326c);
    L14:
        if (StringUtils.isEmpty(r102.f4325b) == true) goto L17;
        if (r100 == null) goto L17;
        String r105 = (String) r100.put("is_auto_play", r102.f4325b);
    L17:
        int r106 = am2.q.f4323g;
        am2.q.a.a(r102, r100);
    }
}
