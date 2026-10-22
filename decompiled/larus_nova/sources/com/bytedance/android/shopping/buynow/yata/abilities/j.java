package com.bytedance.android.shopping.buynow.yata.abilities;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f171296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f171297b;

    public j(k r100, b r101) {
        this.f171296a = r100;
        this.f171297b = r101;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        b r101 = this.f171297b;
        int r102 = r101.f171285a + 1;
        r101.f171285a = r102;
        if (r102 < r101.f171286b) goto L5;
        r101.f171287c.run();
        return;
    L5:
        k r103 = this.f171296a;
        r103.getClass();
        Choreographer.getInstance().postFrameCallback(new j(r103, r101));
    }
}
