package com.byted.cast.linkcommon.cybergarage.upnp.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.common.utils.DLNAOptionUtils;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.ControlPoint;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.IOException;
import java.net.InetAddress;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class SSDPNotifySocket extends HTTPMUSocket implements Runnable {
    private static final String TAG = "SSDPNotifySocket";
    private ControlPoint controlPoint;
    private Thread deviceNotifyThread;
    private boolean useIPv6Address;

    @Override // java.lang.Runnable
    public void run() {
        com_byted_cast_linkcommon_cybergarage_upnp_ssdp_SSDPNotifySocket_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void start() {
        StringBuffer r100 = new StringBuffer("Cyber.SSDPNotifySocket/");
        String r101 = getLocalAddress();
        if (r101 != null) goto L5;
    L7:
        this.mLogger.d(TAG, "_DLNA_SEARCH start:" + r100.toString());
        PthreadThreadV2 r102 = new PthreadThreadV2(this, r100.toString());
        this.deviceNotifyThread = r102;
        ThreadMethodProxy.start(r102);
        return;
    L5:
        if (r101.length() <= 0) goto L7;
        r100.append(getLocalAddress());
        r100.append(':');
        r100.append(getLocalPort());
        r100.append(" -> ");
        r100.append(getMulticastAddress());
        r100.append(':');
        r100.append(getMulticastPort());
        r100.append(TAG);
        goto L7
    }

    public void stop() {
        this.mLogger.d(TAG, "_DLNA_SEARCH stop");
        this.deviceNotifyThread = null;
    }

    @Override // com.byted.cast.linkcommon.cybergarage.upnp.ssdp.HTTPMUSocket
    public boolean close() {
        return super.close();
    }

    public void com_byted_cast_linkcommon_cybergarage_upnp_ssdp_SSDPNotifySocket__run$___twin___() {
        Thread r100 = ThreadMethodProxy.currentThread();
        ControlPoint r101 = getControlPoint();
    L4:
        if (this.deviceNotifyThread != r100) goto L34;
        Thread.yield();
        SSDPPacket r102 = receive();     // Catch: IOException -> L17
        if (r102 == null) goto L4;
        InetAddress r103 = getMulticastInetAddress();
        InetAddress r104 = r102.getHostInetAddress();
        if (r103.equals(r104) == true) goto L15;
        if (DLNAOptionUtils.isEnableBroadcastSearch(this.mCastContext) == false) goto L4;
        if (SSDP.BROADCAST_ADDRESS.equals(r104.getHostAddress()) == false) goto L4;
    L15:
        if (r101 == null) goto L4;
        r101.notifyReceived(r102);
    L17:
        e = move-exception;
        this.mLogger.d(TAG, "_DLNA_SEARCH receive notify exception " + e.getMessage());
        return;
    }

    public ControlPoint getControlPoint() {
        return this.controlPoint;
    }

    public SSDPNotifySocket(ContextManager.CastContext r100) {
        super(r100);
        this.controlPoint = null;
        this.deviceNotifyThread = null;
        setMulticastInetAddress(SSDP.ADDRESS, 1900);
        setControlPoint(null);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_byted_cast_linkcommon_cybergarage_upnp_ssdp_SSDPNotifySocket_com_larus_apm_impl_protector_RunnableLancet_run(SSDPNotifySocket r100) {
        r100.com_byted_cast_linkcommon_cybergarage_upnp_ssdp_SSDPNotifySocket__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public boolean open(String r100) {
        this.useIPv6Address = false;
        if (HostInterface.isIPv6Address(r100) != true) goto L5;
        String r101 = SSDP.getIPv6Address();
        this.useIPv6Address = true;
    L7:
        return super.open(r101, 1900, r100);
    L5:
        r101 = SSDP.ADDRESS;
        goto L7
    }

    public boolean post(SSDPNotifyRequest r100) {
        if (this.useIPv6Address != true) goto L5;
        String r101 = SSDP.getIPv6Address();
    L6:
        r100.setHost(r101, 1900);
        return post(r100);
    L5:
        r101 = SSDP.ADDRESS;
        goto L6
    }

    public void setControlPoint(ControlPoint r100) {
        this.controlPoint = r100;
    }

    public boolean post(SSDPNotifyRequest r100, String r101, int r102) {
        if (this.useIPv6Address != true) goto L5;
        String r103 = SSDP.getIPv6Address();
    L6:
        r100.setHost(r103, 1900);
        return post(r100, r101, r102);
    L5:
        r103 = SSDP.ADDRESS;
        goto L6
    }

    public boolean postWithBroadcast(SSDPNotifyRequest r100, String r101, int r102) {
        r100.setHost(SSDP.BROADCAST_ADDRESS, 1900);
        setMulticastInetAddress(SSDP.BROADCAST_ADDRESS, 1900);
        return postWithBroadcast(r100, r101, r102);
    }
}
