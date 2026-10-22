package com.byted.cast.linkcommon.cybergarage.upnp.control;

import com.byted.cast.linkcommon.cybergarage.upnp.ControlPoint;
import com.byted.cast.linkcommon.cybergarage.util.ThreadCore;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class RenewSubscriber extends ThreadCore {
    public static final long INTERVAL = 120;
    private ControlPoint ctrlPoint;

    @Override // com.byted.cast.linkcommon.cybergarage.util.ThreadCore, java.lang.Runnable
    public void run() {
        com_byted_cast_linkcommon_cybergarage_upnp_control_RenewSubscriber_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_byted_cast_linkcommon_cybergarage_upnp_control_RenewSubscriber__run$___twin___() {
        ControlPoint r100 = getControlPoint();
    L4:
        if (isRunnable() != true) goto L8;
        Thread.sleep(120000);     // Catch: InterruptedException -> L9
    L7:
        r100.renewSubscriberService();
        goto L4
    }

    public ControlPoint getControlPoint() {
        return this.ctrlPoint;
    }

    public RenewSubscriber(ControlPoint r100) {
        setControlPoint(r100);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_byted_cast_linkcommon_cybergarage_upnp_control_RenewSubscriber_com_larus_apm_impl_protector_RunnableLancet_run(RenewSubscriber r100) {
        r100.com_byted_cast_linkcommon_cybergarage_upnp_control_RenewSubscriber__run$___twin___();     // Catch: Throwable -> L4
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
