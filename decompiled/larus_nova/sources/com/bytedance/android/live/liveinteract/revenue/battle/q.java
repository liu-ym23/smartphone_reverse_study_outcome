package com.bytedance.android.live.liveinteract.revenue.battle;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class q extends com.bytedance.android.live.liveinteract.revenuebase.f {
    @Override // com.bytedance.android.live.liveinteract.revenuebase.f, ne0.e
    public final void f() {
        DataCenter r100 = this.f518849a;
        int r101 = ji0.j.f499169a;
        r100.put("guest_battle_is_showing", Boolean.valueOf(GuestBattleContext.Companion.e()));
    }

    public q(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        super(r100);
    }
}
