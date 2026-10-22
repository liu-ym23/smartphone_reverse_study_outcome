package com.bytedance.bdinstall.d;

import android.content.Context;
import com.bytedance.bdinstall.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetLoader.java */
/* JADX INFO: loaded from: classes.dex */
class u extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f6234e;

    u(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(true, true);
        this.f6234e = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r2) {
        ba.a(r2, "access", com.bytedance.common.utility.i.f(this.f6234e));
        return true;
    }
}
