package com.byted.cast.linkcommon.cybergarage.upnp.device;

import com.byted.cast.common.CastLogger;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.utils.DLNAOptionUtils;
import com.byted.cast.linkcommon.cybergarage.upnp.Device;
import com.byted.cast.linkcommon.cybergarage.util.ThreadCore;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class Advertiser extends ThreadCore {
    private static final String TAG = null;
    private Device device;
    private ContextManager.CastContext mCastContext;
    private CastLogger mLogger;

    @Override // com.byted.cast.linkcommon.cybergarage.util.ThreadCore, java.lang.Runnable
    public void run() {
        com_byted_cast_linkcommon_cybergarage_upnp_device_Advertiser_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    static {
        TAG = "Advertiser";
    }

    public void com_byted_cast_linkcommon_cybergarage_upnp_device_Advertiser__run$___twin___() {
        Device r100 = getDevice();
        long r101 = DLNAOptionUtils.getDlnaSinkNotifyInterval();
        if (r101 != 0) goto L9;
        if (DLNAOptionUtils.isOpenDlnaLowPerformanceMode() == false) goto L7;
        r101 = 30000;
        goto L9
    L7:
        r101 = 3000;
    L9:
        if (isRunnable() == false) goto L17;
        Thread.sleep(r101);     // Catch: InterruptedException -> L12
    L14:
        if (r100.isDeviceStart() == true) goto L15;
        this.mLogger.d(TAG, " device is not start,do not announce");
        goto L9
    L15:
        r100.announce();
        goto L9
    }

    public Device getDevice() {
        return this.device;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_byted_cast_linkcommon_cybergarage_upnp_device_Advertiser_com_larus_apm_impl_protector_RunnableLancet_run(Advertiser r100) {
        r100.com_byted_cast_linkcommon_cybergarage_upnp_device_Advertiser__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public void setDevice(Device r100) {
        this.device = r100;
    }

    public Advertiser(Device r100, ContextManager.CastContext r101) {
        setDevice(r100);
        this.mCastContext = r101;
        this.mLogger = ContextManager.getLogger(r101);
    }
}
