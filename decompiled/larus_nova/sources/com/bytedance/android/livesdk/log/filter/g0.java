package com.bytedance.android.livesdk.log.filter;

import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class g0 extends a<y> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f153297c;

    public g0() {
        this.f153297c = "";
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        super.a(r100);
        if (r100 == null) goto L6;
        String r101 = r100.put("function_type", this.f153297c);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r100) {
        y r101 = (y) r100;
        if (r101 == null) goto L12;
        int r102 = r101.f153349a;
        if (r102 != 5) goto L7;
        this.f153297c = "fm";
        return;
    L7:
        if (r102 != 9) goto L14;
        this.f153297c = "multi_ktv";
        return;
    L14:
        return;
    }
}
