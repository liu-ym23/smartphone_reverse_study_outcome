package com.bytedance.android.annie.monitor.common.performance;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f extends b7.a {
    public f() {
    }

    @Override // b7.a, b7.b
    public final void onInit(c7.a r100) {
        Intrinsics.checkNotNullParameter(r100, "annieContext");
        super.onInit(r100);
        a r101 = a.f39609b;
        String r102 = r100.getUrl();
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        String r104 = r100.getType();
        if (r104 == null) goto L9;
        r103 = r104;
    L9:
        r101.d(r102, r103, r100.getBizKey());
        r101.e();
    }
}
