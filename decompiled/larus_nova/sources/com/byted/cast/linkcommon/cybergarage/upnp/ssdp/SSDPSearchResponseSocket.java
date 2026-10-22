package com.byted.cast.linkcommon.cybergarage.upnp.ssdp;

import com.byted.cast.common.Constants;
import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.upnp.ControlPoint;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.net.DatagramSocket;
import java.net.InetAddress;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class SSDPSearchResponseSocket extends HTTPUSocket implements Runnable {
    private static final String TAG = "SSDPSearchResponseSocket";
    private ControlPoint controlPoint;
    private Thread deviceSearchResponseThread;

    @Override // java.lang.Runnable
    public void run() {
        com_byted_cast_linkcommon_cybergarage_upnp_ssdp_SSDPSearchResponseSocket_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void start() {
        StringBuffer r100 = new StringBuffer("Cyber.SSDPSearchResponseSocket/");
        DatagramSocket r101 = getDatagramSocket();
        if (r101 == null) goto L8;
        InetAddress r102 = r101.getLocalAddress();
        if (r102 == null) goto L8;
        r100.append(r102);
        r100.append(':');
        r100.append(r101.getLocalPort());
    L8:
        if (this.deviceSearchResponseThread == null) goto L10;
        return;
    L10:
        this.castLogger.d(TAG, "_DLNA_SEARCH start:" + r100.toString());
        PthreadThreadV2 r103 = new PthreadThreadV2(this, r100.toString());
        this.deviceSearchResponseThread = r103;
        ThreadMethodProxy.start(r103);
    }

    public void stop() {
        this.castLogger.d(TAG, "_DLNA_SEARCH stop");
        this.deviceSearchResponseThread = null;
    }

    public void com_byted_cast_linkcommon_cybergarage_upnp_ssdp_SSDPSearchResponseSocket__run$___twin___() {
        Thread r100 = ThreadMethodProxy.currentThread();
        ControlPoint r101 = getControlPoint();
    L4:
        if (this.deviceSearchResponseThread != r100) goto L11;
        Thread.yield();
        SSDPPacket r102 = receive();
        if (r102 == null) goto L18;
        this.castLogger.d(TAG, "_DLNA_SEARCH receive search package " + r102.toString());
        if (r101 == null) goto L4;
        r101.searchResponseReceived(r102);
        goto L4
    L18:
        return;
    }

    public ControlPoint getControlPoint() {
        return this.controlPoint;
    }

    public SSDPSearchResponseSocket(ContextManager.CastContext r100) {
        super(r100);
        this.controlPoint = null;
        this.deviceSearchResponseThread = null;
        setControlPoint(null);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_byted_cast_linkcommon_cybergarage_upnp_ssdp_SSDPSearchResponseSocket_com_larus_apm_impl_protector_RunnableLancet_run(SSDPSearchResponseSocket r100) {
        r100.com_byted_cast_linkcommon_cybergarage_upnp_ssdp_SSDPSearchResponseSocket__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public void setControlPoint(ControlPoint r100) {
        this.controlPoint = r100;
    }

    public boolean post(String r110, int r111, SSDPSearchRequest r112) {
        this.castLogger.d(TAG, "_DLNA_SEARCH post search request addr:" + r110 + ", port:" + r111 + ", req:" + r112.toString());
        String r100 = r112.toString();
        ControlPoint r113 = this.controlPoint;
        if (r113 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        boolean r114 = post(r110, r111, r100, "source", r101);
        if (r114 == false) goto L16;
        ControlPoint r115 = this.controlPoint;
        if (r115 == null) goto L16;
        if (r115.isSendSearchSuccess() == true) goto L15;
        ContextManager.getMonitor(this.castContext).getSourceMonitor().sendDlnaSearchSendSuccess(null);
    L15:
        this.controlPoint.setSendSearchSuccess(true);
    L16:
        return r114;
    L5:
        if (r113.isSendSearchSuccess() == true) goto L7;
        r101 = true;
        goto L8
    }

    public boolean post(String r100, int r101, SSDPSearchResponse r102) {
        return post(r100, r101, r102.getHeader(), Constants.ROLE_SINK, false);
    }
}
