package com.bytedance.android.livesdk.log.filter;

import com.bytedance.common.utility.StringUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class f extends a<am2.e> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f153294c;

    public f() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        super.a(r100);
        if (StringUtils.isEmpty(null) == true) goto L6;
        r100.put("task_id", null);
    L6:
        if (StringUtils.isEmpty(null) == true) goto L9;
        r100.put("activity_id", null);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r100) {
        if (((am2.e) r100) == null) goto L7;
        this.f153294c = "1".equals(null);
        return;
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void u(Map r100, Object r101) {
        am2.e r102 = (am2.e) r101;
        super.u(r100, r102);
        if (r102 != null) goto L6;
        return;
    L6:
        if (StringUtils.isEmpty(null) == true) goto L9;
        r100.put("task_id", null);
    L9:
        if (StringUtils.isEmpty(null) == true) goto L12;
        r100.put("activity_id", null);
        return;
    }
}
