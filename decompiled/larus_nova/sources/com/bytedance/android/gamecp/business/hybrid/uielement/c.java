package com.bytedance.android.gamecp.business.hybrid.uielement;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GameDetailLynxCard f56000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f56001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f56002c;

    @Override // b7.a, b7.b
    public final void onJsbRegistered() {
        yr.c.e("GameDetailLynxCard", "onJsbRegistered");
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        yr.c.e("GameDetailLynxCard", "onLoadFail url: " + this.f56001b);
        this.f56000a.f55983c.put(this.f56002c, 2000);
        a r101 = this.f56000a.f55984d;
        if (r101 == null) goto L5;
        r101.onLoadSuccess();
    L5:
        GameDetailLynxCard.a(this.f56000a);
        GameDetailLynxCard r102 = this.f56000a;
        Map<String, ? extends Object> r103 = r102.f55985e;
        if (r103 != null) goto L8;
        return;
    L8:
        if ((!r103.isEmpty()) == true) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L15;
        r102.c(r103, "gamecpCardUpdateData");
        return;
    }

    public c(GameDetailLynxCard r100, String r101, String r102) {
        this.f56000a = r100;
        this.f56001b = r101;
        this.f56002c = r102;
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        yr.c.g("GameDetailLynxCard", "onLoadFail url: " + r101 + " reason: " + r102);
        a r103 = this.f56000a.f55984d;
        if (r103 == null) goto L5;
        r103.a(r102);
    L5:
        this.f56000a.d();
    }
}
