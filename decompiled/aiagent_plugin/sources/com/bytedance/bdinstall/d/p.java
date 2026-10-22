package com.bytedance.bdinstall.d;

import android.content.Context;
import com.bytedance.bdinstall.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: FlavorSpecialLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class p extends d {
    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r1) {
        return true;
    }

    p(Context r2, an r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        super(false, false);
    }
}
