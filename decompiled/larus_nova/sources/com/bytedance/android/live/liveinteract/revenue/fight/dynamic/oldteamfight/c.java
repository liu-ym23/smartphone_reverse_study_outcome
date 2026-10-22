package com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DynamicTeamFightViewManager f78196a;

    public c(DynamicTeamFightViewManager r100) {
        this.f78196a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        DynamicTeamFightViewManager r102 = this.f78196a;
        long r103 = r102.f78185j;
        long r104 = 0;
        if (r103 <= 0) goto L5;
        r104 = r103 - 1;
    L5:
        r102.f78185j = r104;
        r102.f78181f.b(r104);
    }
}
