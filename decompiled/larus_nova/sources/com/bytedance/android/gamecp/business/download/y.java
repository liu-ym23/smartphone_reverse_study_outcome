package com.bytedance.android.gamecp.business.download;

import com.bytedance.android.livesdk.gamecp.impl.LiveHostGameCP;

/* JADX INFO: loaded from: classes44.dex */
public final class y implements wr.b<p> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wr.b f52962a;

    public y(LiveHostGameCP.C100311 r100) {
        this.f52962a = r100;
    }

    @Override // wr.b
    public final void onResult(p r100) {
        p r101 = r100;
        wr.b r102 = this.f52962a;
        if (r101 == null) goto L5;
        boolean r103 = true;
    L6:
        r102.onResult(Boolean.valueOf(r103));
        return;
    L5:
        r103 = false;
        goto L6
    }
}
