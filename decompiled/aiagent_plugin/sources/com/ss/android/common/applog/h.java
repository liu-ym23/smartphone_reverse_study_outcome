package com.ss.android.common.applog;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONArray;

/* JADX INFO: compiled from: EventVerifyBdtracker.java */
/* JADX INFO: loaded from: classes4.dex */
public class h implements com.bytedance.applog.util.i {
    public h() {
    }

    @Override // com.bytedance.applog.util.i
    public void putEvent(String r1, JSONArray r2) {
        com.bytedance.applog.util.h.a(String.valueOf(com.ss.android.deviceregister.g.l()), r1, r2);
    }

    @Override // com.bytedance.applog.util.i
    public boolean isEnable() {
        return com.bytedance.applog.util.h.a(String.valueOf(com.ss.android.deviceregister.g.l()));
    }

    @Override // com.bytedance.applog.util.i
    public void setEventVerifyUrl(String r1) {
        com.bytedance.applog.util.h.a(String.valueOf(com.ss.android.deviceregister.g.l()), r1);
    }

    @Override // com.bytedance.applog.util.i
    public void setEnable(boolean r2, Context r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        com.bytedance.applog.util.h.a(String.valueOf(com.ss.android.deviceregister.g.l()), r2, r1);
    }
}
