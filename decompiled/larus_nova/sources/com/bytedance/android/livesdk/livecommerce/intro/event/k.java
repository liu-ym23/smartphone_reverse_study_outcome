package com.bytedance.android.livesdk.livecommerce.intro.event;

import com.bytedance.android.ec.opt.asynctask.r;
import com.bytedance.android.ec.opt.asynctask.w;

/* JADX INFO: loaded from: classes10.dex */
public final class k implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f148277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f148278b;

    @Override // com.bytedance.android.ec.opt.asynctask.w
    public final com.bytedance.android.ec.opt.asynctask.k r() {
        r r100 = new r();
        r100.f48048c = true;
        return r100.f48052g.b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f148277a.run();
        int r100 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.f148548a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.a("Django: Task: event async: " + this.f148278b);
    }

    public k(Runnable r100, String r101) {
        this.f148277a = r100;
        this.f148278b = r101;
    }
}
