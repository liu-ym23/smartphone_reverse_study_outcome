package com.bytedance.bdinstall.d;

import android.content.Context;
import com.bytedance.bdinstall.an;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceCategoryLoader.java */
/* JADX INFO: loaded from: classes.dex */
class l extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final an f6224e;

    l(Context r3, an r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super(true, true);
        this.f6224e = r4;
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r2) {
        r2.put("device_category", this.f6224e.Z());     // Catch: JSONException -> L5
        return true;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
