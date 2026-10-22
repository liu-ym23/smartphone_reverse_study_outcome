package com.bytedance.android.live.broadcastgame.opengame.runtime;

/* JADX INFO: loaded from: classes45.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Runnable f60819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f60820b;

    public a0() {
    }

    public final void a(d.b r100) {
        this.f60819a = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f60820b == false) goto L11;
        if (r100 == null) goto L8;
        r100.run();
    L8:
        a(null);
        return;
    }
}
