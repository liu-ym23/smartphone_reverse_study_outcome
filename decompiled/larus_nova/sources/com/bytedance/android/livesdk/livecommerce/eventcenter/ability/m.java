package com.bytedance.android.livesdk.livecommerce.eventcenter.ability;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.local.api.atomic.LiveAtomicAbilityDescriptor;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
@LiveAtomicAbilityDescriptor(action = "live_guide", description = "直播间导流参数拼接", service = {"LiveBase"})
public final class m extends com.bytedance.android.livesdk.livecommerce.ability.d<JSONObject> implements tg2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ tg2.a f147786a;

    @Override // tg2.b
    public final void logE(String r100) {
        this.f147786a.logE(r100);
    }

    public m() {
        this.f147786a = new tg2.a("LiveGuide");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.ability.d
    public final void a(Context r110, JSONObject r111, Object r112, il2.a r210, com.bytedance.android.livesdk.livecommerce.ability.e r211) {
        JSONObject r100 = r111;
        int r101 = 0;
        if (r110 == null) goto L51;
        if (r100 == null) goto L51;
        String r102 = r100.optString("room_id");
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L15;
        this.f147786a.a("room_id is null!");
    L15:
        String r104 = r100.optString("schema");
        if (r104 != null) goto L18;
    L21:
        boolean r105 = true;
    L22:
        if (r105 == false) goto L26;
        logE("schema is null");
        if (r211 == null) goto L62;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r211, 0, "schema is null", 1);
        return;
    L62:
        return;
    L26:
        String r106 = r100.optString("params_type");
        JSONArray r107 = r100.optJSONArray("user_act_params");     // Catch: Exception -> L38
        ArrayList r108 = new ArrayList();     // Catch: Exception -> L38
        if (r107 == null) goto L37;
        int r113 = r107.length();     // Catch: Exception -> L38
    L30:
        if (r101 >= r113) goto L37;
        Object r114 = r107.get(r101);     // Catch: Exception -> L38
        if ((r114 instanceof Object) == true) goto L34;
        r114 = null;
    L34:
        if (r114 == null) goto L36;
        r108.add(r114);     // Catch: Exception -> L38
    L36:
        r101 = r101 + 1;
    L37:
        List r115 = r108;
    L57:
        Map<String, Object> r109 = com.bytedance.android.shopping.extensions.k.z(JSONObjectProtectorUtils.getString(r100, "report_params"));     // Catch: Exception -> L44
        if ((r109 instanceof Map) == false) goto L46;
        Map<String, Object> r116 = r109;
    L47:
        com.bytedance.android.livesdk.livecommerce.params.a.b(r110, r102, null, r104, r106, false, r115, null, null, r116, 384);
        if (r211 == null) goto L64;
        r211.onSuccess();
        return;
    L64:
        return;
    L46:
        r116 = null;
    L44:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L38:
        e = move-exception;
        ECExceptionMonitor.e(e);
        logE("fail to get param [user_act_params]");
        r115 = CollectionsKt.emptyList();
        goto L57
    L18:
        if (r104.length() == 0) goto L21;
        r105 = false;
        goto L22
    L9:
        if (r102.length() == 0) goto L12;
        r103 = false;
    L51:
        if (r211 == null) goto L53;
        com.bytedance.android.livesdk.livecommerce.ability.e.a.a(r211, 0, "context or params is null", 1);
    L53:
        logE("context or params is null");
    }
}
