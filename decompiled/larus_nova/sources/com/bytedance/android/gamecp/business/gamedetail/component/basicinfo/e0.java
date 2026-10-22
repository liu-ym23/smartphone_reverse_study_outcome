package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes44.dex */
public final class e0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceGameDetailInfoWidgetV4 f53703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f f53704b;

    public e0(AudienceGameDetailInfoWidgetV4 r100, com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.f r101) {
        this.f53703a = r100;
        this.f53704b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        int r101 = yt.n.f569020a;
        Context r102 = this.f53703a.context;
        String r103 = this.f53704b.h();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        String r105 = this.f53704b.h();
        if (r105 == null) goto L9;
        r104 = r105;
    L9:
        yt.n.a(r102, r103, com.bytedance.android.gamecp.business.gamedetail.component.officialaccount.c.a(r104));
    }
}
