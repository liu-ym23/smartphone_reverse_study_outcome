package com.obric.autogui.platforms.obric.b;

import android.content.Context;
import com.obric.autogui.common.api.platform.system.POILocationInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;

/* JADX INFO: compiled from: ObricLocationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.obric.autogui.platforms.tools.location.b {
    public b() {
    }

    @Override // com.obric.autogui.platforms.tools.location.b, com.obric.autogui.common.api.platform.system.IAutoActionLocationApi
    public Object acquirePOILocation(Context r2, boolean r3, d<? super com.obric.autogui.common.d<POILocationInfo>> r4) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        d<? super com.obric.autogui.common.d<POILocationInfo>> r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        return a.f30064a.a(r1, r3, r5);
    }
}
