package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "openByteCert")
public final class o2 extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f142171a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        this.f142171a.clear();
    }

    public o2() {
        this.f142171a = new CompositeDisposable();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Context r103 = r101.getContext();
        if ((r103 instanceof Activity) == false) goto L78;
        Iterator<String> r104 = r102.keys();
        HashMap<String, String> r105 = new HashMap();
        v80.b.a r106 = new v80.b.a();
        r106.f553600a = r103;
    L6:
        if (r104.hasNext() == false) goto L43;
        String r107 = r104.next();
        if (r107 == null) goto L6;
        Object r108 = r102.get(r107);
        if (r108 == null) goto L6;
        if ((!Intrinsics.areEqual(r107, "h5_query_params")) == false) goto L17;
        r105.put(r107, r108.toString());
    L17:
        switch(r107.hashCode()) {
            case -873960692: goto L40;
            case 3357091: goto L37;
            case 109254796: goto L34;
            case 530136847: goto L20;
            default: goto L6;
        };
    L20:
        if (r107.equals("h5_query_params") == false) goto L6;
        if ((r108 instanceof JSONObject) == false) goto L6;
        JSONObject r109 = (JSONObject) r108;
        Iterator<String> r110 = r109.keys();
    L25:
        if (r110.hasNext() == false) goto L6;
        String r111 = r110.next();
        if (r111 == null) goto L25;
        Object r112 = r109.get(r111);
        if (r112 == null) goto L25;
        r105.put("h5-params-".concat(r111), r112.toString());
        goto L25
    L34:
        if (r107.equals("scene") == false) goto L6;
        r106.f553601b = r108.toString();
        goto L6
    L37:
        if (r107.equals("mode") == false) goto L6;
        r106.f553603d = r108.toString();
        goto L6
    L40:
        if (r107.equals("ticket") == false) goto L6;
        r106.f553602c = r108.toString();
        goto L6
    L43:
        if (r105.containsKey("use_new_api") == true) goto L45;
        r105.put("use_new_api", "true");
    L45:
        x80.b r113 = x80.c.a(2);
        r106.f553605f = r105;
        r106.f553604e = new n2(this);
        r113.f562883a.a(new v80.b(r106));
        return;
    }
}
