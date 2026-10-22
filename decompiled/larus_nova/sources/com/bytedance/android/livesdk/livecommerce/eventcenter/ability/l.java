package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@LiveAtomicAbilityDescriptor(action = "pop_card_close", description = "关闭讲解卡", service = {"LiveCard"})
public final class l extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> implements tg2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tg2.a f147785a;

    @Override // tg2.b
    public final void logE(String r100) {
        this.f147785a.logE(r100);
    }

    public l() {
        this.f147785a = new tg2.a("CardClose");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r100, JSONObject r101, Object r102, il2.a r110, com.bytedance.android.livesdk.livecommerce.ability.e r111) {
        JSONObject r103 = r101;
        cf.d r112 = null;
        if (r103 == null) goto L12;
        String r104 = r103.optString("promotion_id");
        if (r104 == null) goto L12;
        if (r104.length() <= 0) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L12;
    L13:
        if (r103 == null) goto L22;
        String r106 = r103.optString("product_id");
        if (r106 == null) goto L22;
        if (r106.length() <= 0) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == false) goto L22;
    L23:
        if (r103 == null) goto L25;
        String r108 = r103.optString("room_id");
    L26:
        if (r103 == null) goto L28;
        String r109 = r103.optString("room_unique_key");
    L29:
        String r113 = "try close card, roomId=" + r108 + ", promotionId=" + r104 + ", productId=" + r106;
        tg2.a r114 = this.f147785a;
        if (r114.f545845a == false) goto L32;
        dm.a.b r115 = dm.a.f469202a;
        dm.a.a(r114.f545846b).a(r113);
    L32:
        int r116 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.f151643o;
        cf.d r117 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.a.a(r108, r109).f151649h;
        if ((r117 instanceof com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i) == false) goto L36;
        r112 = r117;
    L36:
        com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i r118 = (com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i) r112;
        if (r118 == null) goto L41;
        r118.k(r106, r104, false);
        if (r111 == null) goto L45;
        r111.onSuccess();
        return;
    L45:
        return;
    L41:
        logE("cannot find the corresponding card controller " + r108);
        if (r111 == null) goto L47;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r111, 0, "cannot find the corresponding card controller " + r108, 1);
        return;
    L47:
        return;
    L28:
        r109 = null;
        goto L29
    L25:
        r108 = null;
        goto L26
    L19:
        r107 = false;
    L22:
        r106 = null;
        goto L23
    L9:
        r105 = false;
    L12:
        r104 = null;
        goto L13
    }
}
