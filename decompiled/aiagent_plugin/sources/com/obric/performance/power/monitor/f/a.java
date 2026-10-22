package com.obric.performance.power.monitor.f;

import android.content.Context;
import android.os.BatteryManager;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: CurrentMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f36999a = null;

    static {
        f36999a = new a();
    }

    private a() {
    }

    public final float a(Context r3) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.e(r2, "context");
        Object r4 = r2.getSystemService("batterymanager");
        if (ZeusTransformUtils.instanceOf(r4, BatteryManager.class) == false) goto L5;
        BatteryManager r5 = (BatteryManager) ZeusTransformUtils.preCheckCast(r4, BatteryManager.class, "com.obric.aiagent.plugin");
    L6:
        if (r5 != null) goto L9;
        return 0.0f;
    L9:
        float r6 = r5.getLongProperty(2) / 1000;
        ILogDepend.Companion.d("PowerMonitor", "CurrentMonitor getGalvanicNow: " + r6 + "mA");
        return r6;
    L5:
        r5 = null;
        goto L6
    }
}
