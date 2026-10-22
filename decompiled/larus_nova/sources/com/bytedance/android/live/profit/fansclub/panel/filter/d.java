package com.bytedance.android.live.profit.fansclub.panel.filter;

import com.bytedance.android.live.profit.fansclub.FansClubEntranceParams;
import com.bytedance.android.live.profit.fansclub.panel.f;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yz0.k;

/* JADX INFO: loaded from: classes47.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IEpisode f87355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f87356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n01.a f87357c;

    @Override // com.bytedance.android.live.profit.fansclub.panel.f
    public final void a(FansClubEntranceParams r100, com.bytedance.android.live.profit.fansclub.panel.d r101) {
        Intrinsics.checkNotNullParameter(r100, "entranceParams");
        Intrinsics.checkNotNullParameter(r101, "panelParams");
        if (this.f87355a == null) goto L5;
    L7:
        Function1<x0, Unit> r102 = new VSFansClubFilter$process$1(this);
        if ((r101 instanceof cu0.a.b) == false) goto L11;
        r102.invoke2(((cu0.a.b) r101).f465412b);
        return;
    L11:
        return;
    L5:
        if (this.f87357c.i3() == true) goto L7;
    }

    public d(IEpisode r100, k r101, n01.a r102) {
        Intrinsics.checkNotNullParameter(r101, "roomDataService");
        Intrinsics.checkNotNullParameter(r102, "vsService");
        this.f87355a = r100;
        this.f87356b = r101;
        this.f87357c = r102;
    }
}
