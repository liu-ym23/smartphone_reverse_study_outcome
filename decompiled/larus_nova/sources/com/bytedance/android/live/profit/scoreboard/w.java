package com.bytedance.android.live.profit.scoreboard;

import android.view.View;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public final class w implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f89006a;

    public w(v r100) {
        this.f89006a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        jy0.b.d("ScoreboardBannerController", "user clicked banner");
        this.f89006a.f88976c.f().onNext(Unit.INSTANCE);
        v r101 = this.f89006a;
        r101.f88978e.showPlugin(r101.f88975b.isAnchor());
    }
}
