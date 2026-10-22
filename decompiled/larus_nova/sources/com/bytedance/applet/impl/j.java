package com.bytedance.applet.impl;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class j implements com.bytedance.ai.applet.grantingV2.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WeakReference f191955a;

    public /* synthetic */ j(WeakReference r100) {
        this.f191955a = r100;
    }

    public final boolean a(String r100) {
        WeakReference r101 = this.f191955a;
        int r102 = AppletGrantingWidgetServiceImpl.f191831a;
        Intrinsics.checkNotNullParameter(r100, "msgID");
        com.larus.bmhome.chat.api.k r103 = (com.larus.bmhome.chat.api.k) r101.get();
        if (r103 != null) goto L7;
        return false;
    L7:
        return r103.c(r100);
    }
}
