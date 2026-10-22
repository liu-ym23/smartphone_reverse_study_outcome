package com.bytedance.android.ec.core.monitor;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.apm.ApmAgent;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class ECMonitorService implements pi.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f45110b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f45111a;

    public static final class a {
        public static void a(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
            Intrinsics.checkNotNullParameter(r100, "serviceName");
            boolean r104 = ECServiceManager.f42805a;
            pi.b r105 = (pi.b) ECServiceManager.c(pi.b.class);
            if (r105 == null) goto L6;
            r105.monitorEvent(r100, r101, r102, r103);
            return;
        }
    }

    static {
    }

    public ECMonitorService() {
    }

    @Override // pi.b
    public final void b(HashMap r100) {
        Intrinsics.checkNotNullParameter("event_mall_lynx_template_loaded", "event");
        Intrinsics.checkNotNullParameter(r100, "params");
        int r101 = d.f45144a;
        Intrinsics.checkNotNullParameter("event_mall_lynx_template_loaded", "event");
        Intrinsics.checkNotNullParameter(r100, "params");
        if (com.bytedance.android.ec.core.opt.ab.t.a() != 1) goto L7;
        d.f("event_mall_lynx_template_loaded");
        d.e("event_mall_lynx_template_loaded", r100);
        return;
    }

    @Override // pi.b
    public final void a(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "errorDesc");
        int r104 = d.f45144a;
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "errorDesc");
        if (com.bytedance.android.ec.core.opt.ab.t.a() != 1) goto L17;
        StringBuilder r105 = new StringBuilder("lynx容器异常");
        if (r103 != null) goto L8;
        String r106 = "";
    L9:
        r105.append(r106);
        r105.append(",请排查一下问题，若误报或有任何问题可联系dingyuxun");
        d.f(r105.toString());
        HashMap r107 = new HashMap();
        r107.put("url", r100);
        r107.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, r101);
        if (r102 != null) goto L12;
        r102 = "";
    L12:
        r107.put("scene", r102);
        if (r103 != null) goto L15;
        r103 = "";
    L15:
        r107.put("error", r103);
        d.e("iesec_lynx_container_error_event", r107);
        return;
    L8:
        r106 = r103;
        goto L9
    }

    @Override // pi.b
    public final void monitorEvent(final String r100, final JSONObject r101, final JSONObject r110, final JSONObject r111) {
        Intrinsics.checkNotNullParameter(r100, "serviceName");
        Single.fromCallable(new AnonymousClass1(this, r100, r101, r110, r111)).subscribeOn(Schedulers.io()).subscribe();
    }

    public static final void c(ECMonitorService r100, String r101, JSONObject r102, JSONObject r110, JSONObject r111) {
        r100.getClass();
        ApmAgent.monitorEvent(r101, r102, r110, r111);
        SDKMonitorUtils.getInstance(String.valueOf(6688)).monitorEvent(r101, r102, r110, r111);
        Single.fromCallable(new h(r100, r101, r102, r110, r111)).subscribeOn(Schedulers.io()).subscribe();
    }
}
