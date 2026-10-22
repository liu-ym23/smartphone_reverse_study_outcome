package com.bytedance.android.livesdk.gecko;

import android.content.Context;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.annotation.GeckoRegister;
import com.bytedance.geckox.settings.IGeckoRegister;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes8.dex */
@GeckoRegister(boeAccessKey = "68f927652a5370ec9f4ae1dbaf56fd85", prodAccessKey = "5fb33cde3ebff01c8433ddc22aac0816", testAccessKey = "36723dc3e85a23e701d1697d57de07ed")
public class LiveGeckoRegister implements IGeckoRegister {
    public LiveGeckoRegister() {
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public Map<String, OptionCheckUpdateParams.CustomValue> registerCustomParams() {
        Lazy r100 = LiveGeckoConfig.f125784a;
        HashMap r101 = new HashMap();
        if (jc1.k.f(IMiddleWareHostContext.class) == null) goto L5;
        r101.put("business_version", k.f125816a);
    L5:
        r101.put("webcast_sdk_version", l.f125817a);
        return r101;
    }

    @Override // com.bytedance.geckox.settings.IGeckoRegister
    public String registerRootDir(Context r100) {
        return LiveGeckoConfig.c();
    }
}
