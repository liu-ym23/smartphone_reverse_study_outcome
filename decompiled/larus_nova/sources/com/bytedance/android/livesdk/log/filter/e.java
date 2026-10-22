package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class e extends a<am2.d> {
    public e() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        super.a(r100);
        r100.put(com.bytedance.android.ec.core.event.a.KEY_PARAM_LIVE_PLATFROM, "live");
    }
}
