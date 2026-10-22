package com.bytedance.android.livesdk.livecommerce.ability;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a implements b {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final <T> void a(Context r100, f<T> r101, com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "action");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final void b(String r100, d<?> r101) {
        Intrinsics.checkNotNullParameter("show_promotion_card_guide", "abilityName");
        Intrinsics.checkNotNullParameter(r101, "ability");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final void c() {
        Intrinsics.checkNotNullParameter("show_promotion_card_guide", "abilityName");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final h e() {
        Intrinsics.checkNotNullParameter("add_cart", "abilityName");
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final <T extends d<?>> T get(String r100) {
        Intrinsics.checkNotNullParameter("tab_resort", "abilityName");
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.b
    public final <T> void d(Context r100, f<T> r101, Object r102, il2.a r103, e r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "action");
        if (r104 == null) goto L6;
        e.a.a(r104, 0, null, 3);
        return;
    }
}
