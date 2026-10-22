package com.bytedance.android.live.browser.service;

import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class e0 implements com.bytedance.android.annie.param.n {
    public e0() {
    }

    @Override // com.bytedance.android.annie.param.n
    public final String N0() {
        String r100 = (" WebcastEnv/SaaS." + com.bytedance.android.livesdk.paas.c.b()) + " webcast_AppId/" + ((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).appId();
        String r101 = ((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).ecHostAppId();
        if (mz.c.b(r101) == true) goto L5;
        r100 = r100 + " ecom_host_appid/" + r101;
    L5:
        Map<String, String> r102 = ((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).getFEParamExtra();
        if (r102 == null) goto L15;
        Iterator<String> r103 = r102.keySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L15;
        String r104 = r103.next();
        String r105 = r102.get(r104);
        if (mz.c.b(r104) == true) goto L9;
        if (mz.c.b(r105) == true) goto L9;
        r100 = r100 + ' ' + r104 + '/' + r105;
    L15:
        return r100;
    }
}
