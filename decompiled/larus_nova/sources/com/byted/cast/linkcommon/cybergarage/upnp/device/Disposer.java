package com.byted.cast.linkcommon.cybergarage.upnp.device;

import com.byted.cast.linkcommon.cybergarage.upnp.ControlPoint;
import com.byted.cast.linkcommon.cybergarage.util.ThreadCore;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class Disposer extends ThreadCore {
    private ControlPoint ctrlPoint;

    @Override // com.byted.cast.linkcommon.cybergarage.util.ThreadCore, java.lang.Runnable
    public void run() {
        com_byted_cast_linkcommon_cybergarage_upnp_device_Disposer_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_byted_cast_linkcommon_cybergarage_upnp_device_Disposer__run$___twin___() {
        ControlPoint r100 = getControlPoint();
        long r101 = r100.getExpiredDeviceMonitoringInterval() * 1000;
    L4:
        if (isRunnable() != true) goto L7;
        Thread.sleep(r101);     // Catch: InterruptedException -> L8
    L6:
        r100.removeExpiredDevices();
        goto L4
    }

    public ControlPoint getControlPoint() {
        return this.ctrlPoint;
    }

    public Disposer(ControlPoint r100) {
        setControlPoint(r100);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_byted_cast_linkcommon_cybergarage_upnp_device_Disposer_com_larus_apm_impl_protector_RunnableLancet_run(Disposer r100) {
        r100.com_byted_cast_linkcommon_cybergarage_upnp_device_Disposer__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public void setControlPoint(ControlPoint r100) {
        this.ctrlPoint = r100;
    }
}
