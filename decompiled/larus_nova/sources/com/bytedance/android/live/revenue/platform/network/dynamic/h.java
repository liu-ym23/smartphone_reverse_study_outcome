package com.bytedance.android.live.revenue.platform.network.dynamic;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h implements vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f91524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f91525b;

    public h(String r100, Function1 r101) {
        this.f91524a = r100;
        this.f91525b = r101;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        int r101 = com.bytedance.ies.bullet.kit.resourceloader.loader.b.f246865a;
        if (com.bytedance.ies.bullet.kit.resourceloader.loader.b.d(this.f91524a) == true) goto L5;
        if (r100 == null) goto L18;
        this.f91525b.invoke(r100);
        return;
    L18:
        return;
    L5:
        if ((r100 instanceof xlc.b) == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(((xlc.b) r100).getWRDSSubKey(), this.f91524a) == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L16;
        this.f91525b.invoke(r100);
        return;
    }
}
