package com.bytedance.applet.impl;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class i implements com.bytedance.ai.applet.grantingV2.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f191946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppletGrantingWidgetServiceImpl f191947b;

    public /* synthetic */ i(WeakReference r100, AppletGrantingWidgetServiceImpl r101) {
        this.f191946a = r100;
        this.f191947b = r101;
    }

    public final void a(String r110, u2.a r111) {
        WeakReference r100 = this.f191946a;
        AppletGrantingWidgetServiceImpl r101 = this.f191947b;
        int r102 = AppletGrantingWidgetServiceImpl.f191831a;
        Intrinsics.checkNotNullParameter(r110, "msgID");
        Intrinsics.checkNotNullParameter(r111, "cardData");
        com.larus.bmhome.chat.api.k r103 = (com.larus.bmhome.chat.api.k) r100.get();
        if (r103 == null) goto L6;
        r101.getClass();
        u2.b r104 = r111.f548368a;
        r103.d(r110, new com.larus.bmhome.chat.api.f(new com.larus.bmhome.chat.api.r0(r104.f548379a, r104.f548380b, r104.f548381c, r104.f548382d, r104.f548383e, r104.f548384f, r104.f548385g), new k(), r111.f548370c, r111.f548371d, r111.f548372e, r111.f548373f, r111.f548374g, r111.f548375h, r111.f548376i, r111.f548377j, r111.f548378k));
        return;
    }
}
