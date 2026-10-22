package com.bytedance.android.ec.hybrid.card.util;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xj.a f46597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f46598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f46599c;

    public d(xj.a r100, long r101, String r102) {
        this.f46597a = r100;
        this.f46598b = r101;
        this.f46599c = r102;
    }

    public final void a() {
        b07.b r100 = this.f46597a.f564026c;
        int r101 = f.f46602a;
        JSONObject r102 = new JSONObject();
        r102.put("success", "true");
        r102.put(LocationMonitorConst.IS_TIMEOUT, "false");
        r100.getClass();
        Unit r103 = Unit.INSTANCE;
        JSONObject r104 = new JSONObject();
        xj.a r105 = this.f46597a;
        Long r106 = r105.f564027d;
        if (r106 == null) goto L5;
        long r107 = r106.longValue() - r105.f564024a;
    L6:
        r104.put("timing_lynxservice_init", r107);
        Long r108 = this.f46597a.f564028e;
        if (r108 == null) goto L11;
        long r109 = r108.longValue();
        r104.put("timing_init_eccard_load_start", r109 - this.f46597a.f564024a);
        Long r110 = this.f46597a.f564027d;
        if (r110 == null) goto L11;
        r104.put("timing_eccard_load_start", r109 - r110.longValue());
    L11:
        r104.put("render_duration", this.f46598b - this.f46597a.f564024a);
        xj.a r111 = this.f46597a;
        String r112 = this.f46599c;
        JSONObject r113 = new JSONObject();
        if (r112 == null) goto L14;
        r113.putOpt("schema", r112);
        r113.putOpt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, Integer.valueOf(r111.f564025b));
    L14:
        f.a("ec_lynx_card_render_result", r102, r104, r113);
        return;
    L5:
        r107 = -1;
        goto L6
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
