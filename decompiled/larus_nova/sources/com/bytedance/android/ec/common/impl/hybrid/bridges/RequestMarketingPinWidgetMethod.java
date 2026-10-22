package com.bytedance.android.ec.common.impl.hybrid.bridges;

import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import s83.g;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/common/impl/hybrid/bridges/RequestMarketingPinWidgetMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-common-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RequestMarketingPinWidgetMethod extends ECBaseBridgeMethod {
    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "requestMarketingPinWidget";
    }

    public RequestMarketingPinWidgetMethod() {
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r100, final ECBaseBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
        LinkedHashMap r102 = new LinkedHashMap();
        Object r103 = r100.opt("extra");
        if (r103 != null) goto L5;
    L17:
        boolean r104 = ECServiceManager.f42805a;
        ((g) ECServiceManager.c(g.class)).V(r100.optString("key"), r100.optInt(WikiFolderPushPlugin.OPT), r102, new RequestMarketingPinWidgetMethod$handle$3(r101));
        return;
    L5:
        if ((r103 instanceof String) == false) goto L12;
        JSONObject r105 = new JSONObject((String) r103);     // Catch: Exception -> L19
        Iterator<String> r106 = r105.keys();     // Catch: Exception -> L19
    L8:
        if (r106.hasNext() == false) goto L17;
        String r107 = r106.next();     // Catch: Exception -> L19
        r102.put(r107, r105.optString(r107));     // Catch: Exception -> L19
    L12:
        if ((r103 instanceof JSONObject) == false) goto L17;
        JSONObject r108 = (JSONObject) r103;
        Iterator<String> r109 = r108.keys();
    L15:
        if (r109.hasNext() == false) goto L17;
        String r110 = r109.next();
        r102.put(r110, r108.optString(r110));
        goto L15
    }
}
