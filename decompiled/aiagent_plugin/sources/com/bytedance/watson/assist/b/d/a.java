package com.bytedance.watson.assist.b.d;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import com.bytedance.watson.assist.a.c;
import com.bytedance.watson.assist.b.b;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ThermalInfoManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PowerManager f11850c;

    public a(Context r3, c r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin"));
        this.f11850c = (PowerManager) ZeusTransformUtils.preCheckCast(this.f11822a.getSystemService("power"), PowerManager.class, "com.obric.aiagent.plugin");
    }

    public int b() {
        if (Build.VERSION.SDK_INT < 29) goto L8;
        PowerManager r2 = this.f11850c;
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.getCurrentThermalStatus();
    L8:
        return -1;
    }
}
