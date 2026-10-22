package com.bytedance.bdinstall.d;

import android.content.Context;
import android.os.Bundle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: AppKeyLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f6207e;

    b(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        super(true, false);
        this.f6207e = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.bdinstall.d.d
    public boolean a(JSONObject r3) {
        String r0 = this.f6207e.getPackageName();
        Bundle r2 = this.f6207e.getPackageManager().getApplicationInfo(r0, 128).metaData;     // Catch: Exception -> L7
        if (r2 == null) goto L13;
        r3.put("appkey", r2.getString("UMENG_APPKEY"));     // Catch: Exception -> L7
        return true;
    L13:
        return true;
    L7:
        e = move-exception;
        com.bytedance.bdinstall.t.b("getApplicationInfo error", e);
        return true;
    }
}
