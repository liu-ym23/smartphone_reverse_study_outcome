package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.android.annie.xbridge.mix.StateMethodFinder;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.MethodFinder;
import com.bytedance.sdk.xbridge.cn.protocol.XBridge3MethodFinder;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "canIUse")
public final class d extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSBridgeManager f38641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m16.b f38642b;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public d(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        this.f38642b = r100;
    }

    public d(JSBridgeManager r100) {
        this.f38641a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.optString(com.alipay.sdk.m.p.e.f25671s);
        JSONObject r104 = new JSONObject();
        JSBridgeManager r105 = this.f38641a;
        int r106 = 1;
        if (r105 == null) goto L10;
        List r107 = CollectionsKt.toMutableList(r105.f38432e);
        if (r107 != null) goto L7;
    L27:
        r106 = 0;
    L28:
        r104.put("isAvailable", r106);
        finishWithResult(r104);
        return;
    L7:
        if (r107.contains(r103) != true) goto L27;
    L10:
        if (this.f38642b == null) goto L27;
        m16.b r108 = this.f38642b;
        if (r108 == null) goto L27;
        s26.d r109 = s26.d.f540305c;
        k16.b r110 = (k16.b) s26.d.f540305c.d("default_bid", k16.b.class);
        if (r110 == null) goto L27;
        List<MethodFinder> r111 = r110.L(r108);
        if (r111 == null) goto L27;
        ArrayList r112 = new ArrayList();
        r112.add(new StateMethodFinder(r108));
        r112.addAll(r111);
        r112.add(new XBridge3MethodFinder());
        Iterator r113 = r112.iterator();
    L19:
        if (r113.hasNext() == false) goto L27;
        MethodFinder r114 = (MethodFinder) r113.next();
        if ((r114 instanceof StateMethodFinder) == false) goto L23;
        String r115 = "webcast";
    L25:
        if (r114.d(r115, r103) == null) goto L19;
    L23:
        r115 = "";
        goto L25
    }
}
