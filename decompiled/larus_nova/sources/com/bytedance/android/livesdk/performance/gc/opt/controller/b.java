package com.bytedance.android.livesdk.performance.gc.opt.controller;

import com.bytedance.android.livesdk.t1;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f154641b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f154642a;

    @Override // com.bytedance.android.livesdk.performance.gc.opt.controller.a
    public final void start() {
        this.f154642a.start();
    }

    @Override // com.bytedance.android.livesdk.performance.gc.opt.controller.a
    public final void stop() {
        this.f154642a.stop();
    }

    static {
        f154641b = new b();
    }

    public b() {
        if (t1.f158504a.getValue().getEnable() == false) goto L5;
        a r100 = new DefaultLiveGcController();
    L6:
        this.f154642a = r100;
        return;
    L5:
        r100 = new c();
        goto L6
    }
}
