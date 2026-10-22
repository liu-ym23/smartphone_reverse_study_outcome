package com.bytedance.android.shopping.anchorv3.matchpurchase.view;

import android.view.View;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.j;
import com.bytedance.android.ec.sdk.ECSdk;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FloatingTagLayout f165244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p63.d f165245b;

    public c(FloatingTagLayout r100, p63.d r101) {
        this.f165244a = r100;
        this.f165245b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        o63.a r101 = this.f165244a.f165185a;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        int r102 = ECSdk.f48106a;
        IAdapterService r103 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r103 == null) goto L10;
        j r104 = r103.getLiveWindowService();
        if (r104 == null) goto L10;
        r104.stopShowFloatInNextLifecycle();
    L10:
        Map<String, String> r105 = t63.a.f544661a;
        t63.a.a(this.f165244a.getContext(), this.f165245b.f527887a);
    }
}
