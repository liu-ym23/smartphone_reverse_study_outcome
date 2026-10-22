package com.baidu.platform.comapi;

import android.content.Context;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.engine.NAEngine;

/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    static boolean f8593a = false;

    /* renamed from: b, reason: collision with root package name */
    private NAEngine f8594b;

    public boolean a(Context context) {
        f8593a = false;
        this.f8594b = new NAEngine();
        boolean zA = NAEngine.a(context, null);
        if (OpenLogUtil.isMapLogEnable()) {
            com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("initEngine isEngineSuccess = " + zA);
        }
        if (zA) {
            return zA;
        }
        com.baidu.platform.comapi.d.a.a().a("engine_init_failed");
        return false;
    }

    public boolean b(Context context) {
        boolean zInitLongLinkClient = NAEngine.initLongLinkClient();
        if (zInitLongLinkClient) {
            return zInitLongLinkClient;
        }
        return false;
    }

    public boolean b() {
        f8593a = false;
        return true;
    }

    public void a() {
        if (f8593a) {
            b();
        }
        MessageProxy.destroy();
        NAEngine.c();
        if (this.f8594b != null) {
            this.f8594b = null;
        }
    }
}
