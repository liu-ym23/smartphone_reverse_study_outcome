package com.bytedance.bdinstall.d;

import android.content.Context;
import com.bytedance.bdinstall.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppTraitLoader.java */
/* JADX INFO: loaded from: classes.dex */
final class c extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f6208e;
    private final an f;

    c(Context r4, an r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        super(true, false);
        this.f6208e = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.f = r5;
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r4) {
        com.bytedance.bdinstall.c.b r0 = this.f.N();
        com.bytedance.bdinstall.t.a("IAppTraitCallback = " + r0);
        if (r0 == null) goto L7;
        String r3 = r0.a(this.f6208e);
        com.bytedance.bdinstall.t.a("IAppTraitCallback.get = " + r3);
        r4.put("app_trait", r3);
        return true;
    L7:
        return true;
    }
}
