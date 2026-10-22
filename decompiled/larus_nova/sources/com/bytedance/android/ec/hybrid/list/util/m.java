package com.bytedance.android.ec.hybrid.list.util;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f47342a;

    public m(l r100) {
        this.f47342a = r100;
    }

    public final void a() {
        int r100 = com.bytedance.android.ec.hybrid.card.util.f.f46602a;
        JSONObject r101 = new JSONObject();
        com.bytedance.android.ec.hybrid.monitor.h r102 = this.f47342a.f47335a;
        if (r102 == null) goto L6;
        String r103 = r102.f47562a;
        if (r103 == null) goto L6;
    L7:
        r101.put("monitor_scene", r103);
        Unit r104 = Unit.INSTANCE;
        JSONObject r105 = new JSONObject();
        this.f47342a.getClass();
        r105.put("t_load_bundle_start", null);
        this.f47342a.getClass();
        r105.put("t_load_bundle_end", null);
        Long r106 = this.f47342a.f47340f;
        if (r106 == null) goto L15;
        long r107 = r106.longValue();
        r105.put("t_list_first_screen", r107);
        Long r108 = this.f47342a.f47336b;
        if (r108 == null) goto L12;
        long r109 = r108.longValue();
        r105.put("t_open_time", r109);
        r105.put("ec_list_kit_first_screen", r107 - r109);
    L12:
        Long r110 = this.f47342a.f47339e;
        if (r110 == null) goto L15;
        long r111 = r110.longValue();
        r105.put("t_list_load_start", r111);
        r105.put("ec_list_kit_load_cost", r107 - r111);
    L15:
        Long r112 = this.f47342a.f47338d;
        if (r112 == null) goto L20;
        long r113 = r112.longValue();
        r105.put("t_net_end", r113);
        Long r114 = this.f47342a.f47337c;
        if (r114 == null) goto L20;
        long r115 = r114.longValue();
        r105.put("t_net_start", r115);
        r105.put("ec_list_kit_data_request_cost", r113 - r115);
    L20:
        com.bytedance.android.ec.hybrid.card.util.f.a("ec_list_kit_first_screen", r101, r105, null);
        return;
    L6:
        r103 = "default";
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
