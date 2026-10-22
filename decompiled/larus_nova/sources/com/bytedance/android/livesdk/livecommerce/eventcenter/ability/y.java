package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@LiveAtomicAbilityDescriptor(action = "live_report_log", description = "上报埋点", service = {"LiveBase"})
public final class y extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> implements tg2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tg2.a f147805a;

    @Override // tg2.b
    public final void logE(String r100) {
        this.f147805a.logE(r100);
    }

    public y() {
        this.f147805a = new tg2.a("Log");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r100, JSONObject r101, Object r102, il2.a r103, com.bytedance.android.livesdk.livecommerce.ability.e r104) {
        JSONObject r105 = r101;
        if (r105 == null) goto L5;
        String r106 = r105.optString("event");
    L6:
        boolean r107 = false;
        if (r106 != null) goto L9;
    L12:
        boolean r108 = true;
    L13:
        if (r108 == false) goto L16;
        if (r104 == null) goto L35;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r104, 0, "event name is null", 1);
        return;
    L35:
        return;
    L16:
        JSONObject r109 = r105.optJSONObject("params");
        if (r109 == null) goto L19;
        Map<String, String> r110 = z1.j(r109);
    L20:
        String r111 = r105.optString("btm_id");
        if (r111.length() != 0) goto L23;
        r107 = true;
    L23:
        if (r107 == false) goto L26;
        this.f147805a.a("btm_id is null");
    L26:
        if ((r102 instanceof com.bytedance.android.ec.common.api.jump.model.a) == true) goto L28;
        r102 = null;
    L28:
        com.bytedance.android.ec.common.api.jump.model.a r112 = (com.bytedance.android.ec.common.api.jump.model.a) r102;
        if (r112 == null) goto L31;
        oh.a.a(new w(r112, r106, r110, r111));
    L32:
        if (r104 == null) goto L37;
        r104.onSuccess();
        return;
    L37:
        return;
    L31:
        oh.a.a(new x(r111, r106, r110));
        goto L32
    L19:
        r110 = null;
        goto L20
    L9:
        if (r106.length() == 0) goto L12;
        r108 = false;
        goto L13
    L5:
        r106 = null;
        goto L6
    }
}
