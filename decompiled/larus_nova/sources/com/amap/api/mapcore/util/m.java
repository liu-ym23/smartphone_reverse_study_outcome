package com.amap.api.mapcore.util;

import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f27530a;

    @Override // java.lang.Runnable
    public void run() {
        com_amap_api_mapcore_util_m_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_amap_api_mapcore_util_m__run$___twin___() {
    L6:
        th = move-exception;
        th.printStackTrace();
        w3.a(th);
        return;
    L3:
        if (l.a(this.f27530a) == null) goto L11;
        l.a(this.f27530a).onSurfaceDestory();     // Catch: Throwable -> L6
        return;
    }

    public m(l r100) {
        this.f27530a = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_amap_api_mapcore_util_m_com_larus_apm_impl_protector_RunnableLancet_run(m r100) {
        r100.com_amap_api_mapcore_util_m__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
