package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@LiveAtomicAbilityDescriptor(action = "show_promotion_card_guide", description = "展示", service = {"LiveList"})
public final class g0 extends com.bytedance.android.livesdk.livecommerce.ability.d<sl.q> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f147781a;

    public static final class a {
    }

    static {
    }

    public g0(com.bytedance.android.livesdk.livecommerce.promotionlist.presenter.w r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f147781a = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r100, sl.q r101, Object r102, il2.a r103, com.bytedance.android.livesdk.livecommerce.ability.e r104) {
        sl.q r105 = r101;
        if (r105 == null) goto L5;
        String r106 = r105.a();
    L7:
        if (r106 != null) goto L9;
    L20:
        if (r104 == null) goto L27;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r104, 0, null, 3);
        return;
    L27:
        return;
    L9:
        if (r105.c() == null) goto L20;
        if (r105.e() == null) goto L20;
        com.bytedance.android.ec.sdk.helper.q r107 = com.bytedance.android.ec.sdk.helper.q.f48131a;
        int r108 = r107.getInt("ec_live_show_promotion_card_guide_ability_" + r105.a(), 0);
        if (r108 != 0) goto L18;
        this.f147781a.a(r105);
        r107.d("ec_live_show_promotion_card_guide_ability_" + r105.a(), r108 + 1);
        if (r104 == null) goto L23;
        r104.onSuccess();
        return;
    L23:
        return;
    L18:
        if (r104 == null) goto L25;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r104, 1, null, 2);
        return;
    L25:
        return;
    L5:
        r106 = null;
        goto L7
    }
}
