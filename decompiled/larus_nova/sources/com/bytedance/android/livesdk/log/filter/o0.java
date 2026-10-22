package com.bytedance.android.livesdk.log.filter;

import com.bytedance.common.utility.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class o0 extends a<am2.y> {
    public o0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        super.a(r100);
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r100) {
        if (((am2.y) r100) == null) goto L11;
        Map<String, String> r101 = this.f153291b;
        if (StringUtils.equal(null, "pop_card") == false) goto L8;
        r101.put("is_popcard", "1");
        return;
    L8:
        r101.remove("is_popcard");
        return;
    }
}
