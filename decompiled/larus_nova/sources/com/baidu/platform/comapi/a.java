package com.baidu.platform.comapi;

import android.content.Context;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.engine.NAEngine;

/* JADX INFO: loaded from: classes39.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f32730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NAEngine f32731b;

    public boolean b() {
        f32730a = false;
        return true;
    }

    public void a() {
        if (f32730a == false) goto L5;
        b();
    L5:
        MessageProxy.destroy();
        NAEngine.c();
        if (this.f32731b == null) goto L9;
        this.f32731b = null;
        return;
    }

    public a() {
    }

    public boolean a(Context r100) {
        f32730a = false;
        this.f32731b = new NAEngine();
        boolean r101 = NAEngine.a(r100, null);
        if (OpenLogUtil.isMapLogEnable() == false) goto L5;
        com.baidu.mapsdkplatform.comapi.commonutils.a.a().a("initEngine isEngineSuccess = " + r101);
    L5:
        if (r101 == true) goto L8;
        com.baidu.platform.comapi.c.a.a().a("engine_init_failed");
        return false;
    L8:
        return r101;
    }

    public boolean b(Context r100) {
        boolean r101 = NAEngine.initLongLinkClient();
        if (r101 == true) goto L6;
        return false;
    L6:
        return r101;
    }
}
