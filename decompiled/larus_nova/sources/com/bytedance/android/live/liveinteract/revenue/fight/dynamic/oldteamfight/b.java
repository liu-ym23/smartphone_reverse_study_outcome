package com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DynamicTeamFightViewManager f78195a;

    public b(DynamicTeamFightViewManager r100) {
        this.f78195a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        DynamicTeamFightViewManager r102 = this.f78195a;
        long r103 = r102.f78185j;
        long r104 = 0;
        if (r103 <= 0) goto L5;
        r104 = r103 - 1;
    L6:
        r102.f78185j = r104;
        DynamicTeamFightViewManager r105 = this.f78195a;
        r105.f78181f.b(r105.f78185j);
        return;
    L5:
        ALogger.e("DynamicTeamFightViewManager", "fight countdown time is up");
        goto L6
    }
}
