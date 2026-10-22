package com.bytedance.android.livesdk.livecommerce.iron.helper;

import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class p implements com.bytedance.android.livesdk.livecommerce.ability.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.ability.f f148706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ il2.a f148707b;

    @Override // com.bytedance.android.livesdk.livecommerce.ability.e
    public final void onSuccess() {
        il2.a r100 = this.f148707b;
        if (r100 == null) goto L8;
        il2.a r101 = il2.a.C6280a.a(r100, "execute_atomic_ability", MapsKt.mapOf(TuplesKt.to("action_name", this.f148706a.f147637a)), false, null, null, null, 60);
        if (r101 == null) goto L9;
        ((LiveActionTracker) r101).e(false);
        return;
    L9:
        return;
    }

    public p(com.bytedance.android.livesdk.livecommerce.ability.f r100, il2.a r101) {
        this.f148706a = r100;
        this.f148707b = r101;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.e
    public final void onFail(int r100, String r110) {
        il2.a r101 = this.f148707b;
        if (r101 == null) goto L8;
        il2.a r102 = il2.a.C6280a.a(r101, "execute_atomic_ability", MapsKt.mapOf(TuplesKt.to("action_name", this.f148706a.f147637a)), false, r110, null, null, 48);
        if (r102 == null) goto L9;
        ((LiveActionTracker) r102).e(false);
        return;
    L9:
        return;
    }
}
