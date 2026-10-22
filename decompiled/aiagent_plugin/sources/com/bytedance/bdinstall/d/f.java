package com.bytedance.bdinstall.d;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: CdidLoader.java */
/* JADX INFO: loaded from: classes.dex */
final class f extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f6214e;
    private final an f;

    f(Context r3, an r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(true, true);
        this.f6214e = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        this.f = r4;
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r2) {
        String r1 = com.bytedance.bdinstall.n.a(this.f);
        if (TextUtils.isEmpty(r1) == true) goto L6;
        r2.put("cdid", r1);
        return true;
    L6:
        return false;
    }

    @Override // com.bytedance.bdinstall.d.d
    public void b(JSONObject r1) {
        super.b(r1);
        r1.remove("cdid");
    }
}
