package com.bytedance.android.live.revenue.platform.network.dynamic;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements vlc.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f91515a;

    public b(Function1 r100) {
        this.f91515a = r100;
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        if (r100 == null) goto L5;
        this.f91515a.invoke(r100);
        return;
    }
}
