package com.bytedance.bdinstall.d;

import android.content.Context;
import com.bytedance.bdinstall.an;
import com.bytedance.bdinstall.ba;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceParamsLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class n extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f6231e;
    private final an f;
    private final com.bytedance.bdinstall.u g;

    n(Context r4, an r5, com.bytedance.bdinstall.u r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        super(false, true);
        this.f6231e = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
        this.f = r5;
        this.g = r6;
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r4) {
        ba.a(r4, "carrier", com.bytedance.bdinstall.j.q.a(this.f));
        ba.a(r4, "mcc_mnc", com.bytedance.bdinstall.j.q.b(this.f));
        com.bytedance.bdinstall.g.a r0 = (com.bytedance.bdinstall.g.a) ZeusTransformUtils.preCheckCast(com.bytedance.bdinstall.g.d.a(com.bytedance.bdinstall.g.a.class, String.valueOf(this.f.a())), com.bytedance.bdinstall.g.a.class, "com.obric.aiagent.plugin");
        ba.a(r4, "clientudid", r0.a());
        if (this.g.d() == true) goto L5;
        ba.a(r4, "openudid", r0.a(true));
    L5:
        return true;
    }

    @Override // com.bytedance.bdinstall.d.d
    public void b(JSONObject r1) {
        super.b(r1);
        r1.remove("carrier");
        r1.remove("mcc_mnc");
        r1.remove("clientudid");
        r1.remove("openudid");
    }
}
