package com.bytedance.android.live.browser.service;

import android.view.View;
import com.bytedance.android.annie.param.ReadonlyJSONObjectMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class u implements r9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.live.browser.w f64292a;

    public u(com.bytedance.android.live.browser.w r100) {
        this.f64292a = r100;
    }

    @Override // r9.d
    public final Object L(ReadonlyJSONObjectMap r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        com.bytedance.android.live.browser.w r102 = this.f64292a;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.map2TemplateData(r100, r101);
    }

    @Override // r9.d
    public final void updateData(View r100, Object r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r101, "data");
        com.bytedance.android.live.browser.w r103 = this.f64292a;
        if (r103 == null) goto L6;
        r103.updateData(r100, r101, r102);
        return;
    }
}
