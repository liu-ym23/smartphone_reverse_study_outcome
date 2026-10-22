package com.bytedance.android.livesdk.revenue.experience;

import com.bytedance.android.live.room.api.experience.service.ILiveExpOptService;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class i implements o, c {
    public i() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public static l61.d.a a(RevExpBizScene r100) {
        int r101 = g.f157151a[r100.ordinal()];
        if (r101 == 1) goto L15;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 == 4) goto L17;
        return null;
    L17:
        return l61.d.a.t.f507644e;
    L18:
        return l61.d.a.t0.f507645e;
    L19:
        return l61.d.a.v.f507648e;
    L15:
        return l61.e.a(l61.d.a.a0.f507598e);
    }

    @Override // com.bytedance.android.livesdk.revenue.experience.c
    public final f Mg(DataCenter r100, RevExpBizScene r101) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        ILiveExpOptService r102 = (ILiveExpOptService) k.f(ILiveExpOptService.class);
        l61.d.a r103 = a(r101);
        if (r103 == null) goto L6;
        if (r102 == null) goto L6;
        l61.c r104 = r102.getSceneState(r100, r103);
    L7:
        f r105 = new f();
        if (r104 == null) goto L10;
        r105.f157150a = r104.a();
    L10:
        return r105;
    L6:
        r104 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.revenue.experience.c
    public final Disposable Vi(RevExpBizScene r100, b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "listener");
        ILiveExpOptService r102 = (ILiveExpOptService) k.f(ILiveExpOptService.class);
        l61.d.a r103 = a(r100);
        if (r103 == null) goto L6;
        if (r102 == null) goto L6;
        return r102.registerExpBizListener(r103, new h(r102, r101));
    L6:
        return null;
    }
}
