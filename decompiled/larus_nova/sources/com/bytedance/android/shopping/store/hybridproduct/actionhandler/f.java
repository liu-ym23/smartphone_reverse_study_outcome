package com.bytedance.android.shopping.store.hybridproduct.actionhandler;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class f implements ej.b {
    public f() {
    }

    @Override // ej.b
    public final void onResult(boolean r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "msg");
        if (r100 == false) goto L5;
        dm.a.a("productsubscribe").i("addCalendar success");
        return;
    L5:
        dm.a.a("productsubscribe").i("addCalendar failed,errorCode:" + r101 + ",msg:" + r102);
    }
}
