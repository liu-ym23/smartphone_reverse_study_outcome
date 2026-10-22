package com.bytedance.bdinstall.d;

import android.content.Context;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SimCountryLoader.java */
/* JADX INFO: loaded from: classes.dex */
class aa extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f6205e;
    private final an f;

    aa(Context r4, an r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        super(true, false);
        this.f6205e = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
        this.f = r5;
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r2) {
        ba.a(r2, "sim_region", com.bytedance.bdinstall.j.q.c(this.f));
        return true;
    }
}
