package com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.shopping.orderlist.common.eventcenter.function.OrderCommonUseBridgeFunction$onExecuteAsync$1;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ti.l;

/* JADX INFO: loaded from: classes13.dex */
public final class BridgetLynxComponent implements c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f179854h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f179855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f179856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, d> f179857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f179858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f179859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ViewGroup f179860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final eg3.a f179861g;

    public static final class a {
    }

    static {
    }

    public final OrderCommonBusinessMonitor b() {
        eg3.a r100 = this.f179861g;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.T50();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge.c
    public final void preload() {
        if (this.f179855a != null) goto L5;
    L6:
        final long r100 = System.currentTimeMillis();
        OrderCommonBusinessMonitor r101 = b();
        l r102 = null;
        if (r101 == null) goto L9;
        r101.f179886a = System.currentTimeMillis();
        r101.c("load_lynx_bridge_start", null);
    L9:
        Context r103 = this.f179859e;
        String r104 = ECSettingKeys.F().getLynxBridgeUrl();
        JSONObject r105 = new JSONObject();
        r105.put("module_param", new JSONObject());
        r105.put("mob_data", new JSONObject());
        Unit r106 = Unit.INSTANCE;
        Map<String, Object> r107 = com.bytedance.android.shopping.hybrid.a.b(r105);
        ViewGroup r108 = this.f179860f;
        if (r108 != null) goto L12;
        r108 = new FrameLayout(this.f179859e);
    L12:
        l r109 = ECLiveHybridUtil.b(r103, r104, r107, r108, new b(this), null, null, false, null, null, false, 4064);
        if (r109 == null) goto L15;
        r109.registerMethod("sendNativeBridgeCommandResult", new com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge.a(this));
        r102 = r109;
    L15:
        this.f179855a = r102;
        Lazy r110 = OrderCommonLog.f179948a;
        OrderCommonLog.c("BridgetLynxComponent", new AnonymousClass1(r100));
        return;
    L5:
        if (this.f179856b == false) goto L6;
    }

    public BridgetLynxComponent(Context r100, eg3.a r101) {
        this.f179859e = r100;
        this.f179860f = null;
        this.f179861g = r101;
        this.f179857c = new LinkedHashMap();
        this.f179858d = new LinkedHashMap();
    }

    @Override // com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge.c
    public final void a(final String r100, final JSONObject r101, OrderCommonUseBridgeFunction$onExecuteAsync$1.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeName");
        Intrinsics.checkNotNullParameter(r101, "bridgeParams");
        Lazy r103 = OrderCommonLog.f179948a;
        OrderCommonLog.c("BridgetLynxComponent", new BridgetLynxComponent$useBridge$1(r100, r101));
        if (this.f179855a != null) goto L5;
        OrderCommonLog.c("BridgetLynxComponent", BridgetLynxComponent$useBridge$2.INSTANCE);
        preload();
    L5:
        String r104 = UUID.randomUUID().toString();
        if (r102 == null) goto L8;
        this.f179857c.put(r104, r102);
    L8:
        this.f179858d.put(r104, r100);
        OrderCommonBusinessMonitor r105 = b();
        if (r105 == null) goto L11;
        r105.n(r100);
    L11:
        l r106 = this.f179855a;
        if (r106 == null) goto L15;
        JSONObject r107 = new JSONObject();
        r107.put("session_id", r104);
        r107.put("bridge_name", r100);
        r107.put("bridge_params", r101);
        Unit r108 = Unit.INSTANCE;
        r106.sendJsEvent("repeatNativeBridgeCommand", r107);
        return;
    }
}
