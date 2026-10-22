package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.bridge.GetSettingsResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "getSettings")
public final class f0 extends com.bytedance.android.annie.bridge.c<com.bytedance.android.annie.bridge.m, GetSettingsResultModel> {
    public f0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        com.bytedance.android.annie.bridge.m r102 = (com.bytedance.android.annie.bridge.m) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<com.bytedance.android.annie.bridge.m.a> r103 = r102.a();
        ArrayList r104 = new ArrayList();
        LinkedHashSet r105 = new LinkedHashSet();
        Iterator<T> r106 = r103.iterator();
    L4:
        if (r106.hasNext() == false) goto L12;
        com.bytedance.android.annie.bridge.m.a r107 = (com.bytedance.android.annie.bridge.m.a) r106.next();
        String r108 = r107.b();
        String r109 = r107.a();
        if (r108.length() <= 0) goto L8;
        boolean r110 = true;
    L9:
        if (r110 == false) goto L4;
        com.bytedance.android.annie.bridge.m.a r111 = new com.bytedance.android.annie.bridge.m.a();
        r111.d(r108);
        r111.c(r109);
        r104.add(r111);
        r105.add(r108);
        goto L4
    L8:
        r110 = false;
        goto L9
    L12:
        if (r104.isEmpty() == false) goto L15;
        GetSettingsResultModel r112 = new GetSettingsResultModel();
        r112.a(GetSettingsResultModel.Code.InvalidParam);
        r112.b("empty key or unsupported key type in params");
        finishWithResult(r112);
        return;
    L15:
        if (r105.size() >= r104.size()) goto L25;
        GetSettingsResultModel r113 = new GetSettingsResultModel();
        r113.a(GetSettingsResultModel.Code.InvalidParam);
        r113.b("duplicate keys in params");
        finishWithResult(r113);
        return;
    L25:
        List r114 = ((a9.f) Annie.getService(a9.f.class, r101.a())).getSettings();     // Catch: Exception -> L23
        GetSettingsResultModel r115 = new GetSettingsResultModel();     // Catch: Exception -> L23
        r115.a(GetSettingsResultModel.Code.Success);     // Catch: Exception -> L23
        LinkedHashMap r116 = new LinkedHashMap();     // Catch: Exception -> L23
        Iterator r117 = r114.iterator();     // Catch: Exception -> L23
    L19:
        if (r117.hasNext() == false) goto L21;
        ((i2) r117.next()).getClass();     // Catch: Exception -> L23
        r116.put(null, null);     // Catch: Exception -> L23
        goto L19
    L21:
        r115.c(r116);     // Catch: Exception -> L23
        finishWithResult(r115);     // Catch: Exception -> L23
        return;
    L23:
        GetSettingsResultModel r118 = new GetSettingsResultModel();
        r118.a(GetSettingsResultModel.Code.Failed);
        r118.b("getSettings not implemented in host");
        finishWithResult(r118);
    }
}
