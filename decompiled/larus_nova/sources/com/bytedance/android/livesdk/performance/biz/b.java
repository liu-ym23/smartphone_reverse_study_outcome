package com.bytedance.android.livesdk.performance.biz;

import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import jc1.k;
import l61.c;
import l61.d;

/* JADX INFO: loaded from: classes11.dex */
public final class b extends g61.a.C5987a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveMessageWithPerf f154477a;

    @Override // g61.a.C5987a, g61.a
    public final boolean a() {
        ILiveExpOptService r100 = (ILiveExpOptService) k.f(ILiveExpOptService.class);
        if (r100 == null) goto L9;
        c r101 = r100.getSceneState(null, d.a.d1.f507608e);
        if (r101 == null) goto L9;
        if (r101.a() != true) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L12;
        LiveMessageWithPerf.a(this.f154477a, "2");
    L13:
        return true;
    L12:
        LiveMessageWithPerf.a(this.f154477a, "1");
    L9:
        r102 = false;
        goto L10
    }

    @Override // g61.a.C5987a, g61.a
    public final boolean b() {
        LiveMessageWithPerf.a(this.f154477a, "3");
        return true;
    }

    public b(LiveMessageWithPerf r100) {
        this.f154477a = r100;
    }
}
