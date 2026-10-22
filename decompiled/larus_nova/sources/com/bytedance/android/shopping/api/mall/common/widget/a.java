package com.bytedance.android.shopping.api.mall.common.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.shopping.api.mall.common.tools.h;
import yj.s;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f170494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f170495b;

    public a(b r100, Context r101) {
        this.f170494a = r100;
        this.f170495b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Activity r101 = ECHybridExtensionsKt.a(this.f170495b);
        if (r101 == null) goto L9;
        s r102 = h.f170438b.getIHybridHostUserService();
        String r103 = this.f170494a.getEnterFrom();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r102.e(r101, r103, "click_ecom_tab", null, null);
        this.f170494a.getClickListener().invoke();
        return;
    }
}
