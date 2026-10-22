package com.byted.cast.linkcommon.cybergarage.upnp.ssdp;

import com.byted.cast.common.ContextManager;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.device.SearchListener;
import com.byted.cast.linkcommon.cybergarage.util.ListenerList;
import com.byted.cast.linkcommon.cybergarage.util.TimerUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes28.dex */
public class SSDPSearchSocket extends HTTPMUSocket implements Runnable {
    private static final String TAG = "SSDPSearchSocket";
    private ListenerList deviceSearchListenerList;
    private Thread deviceSearchThread;
    private boolean useIPv6Address;

    @Override // java.lang.Runnable
    public void run() {
        com_byted_cast_linkcommon_cybergarage_upnp_ssdp_SSDPSearchSocket_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void start() {
        StringBuffer r100 = new StringBuffer("Cyber.SSDPSearchSocket/");
        String r101 = getLocalAddress();
        if (r101 != null) goto L5;
    L7:
        this.mLogger.i(TAG, "will start thread:" + r100.toString());
        PthreadThreadV2 r102 = new PthreadThreadV2(this, r100.toString());
        this.deviceSearchThread = r102;
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
        goto L7
    }

    public void stop() {
        this.mLogger.i(TAG, "stop");
        close();
        this.deviceSearchThread = null;
    }

    public void com_byted_cast_linkcommon_cybergarage_upnp_ssdp_SSDPSearchSocket__run$___twin___() {
        Thread r100 = ThreadMethodProxy.currentThread();
    L4:
        if (this.deviceSearchThread != r100) goto L23;
        Thread.yield();
        SSDPPacket r101 = receive();     // Catch: IOException -> L13
        if (r101 == null) goto L4;
        TimerUtil.waitTime(5);
        if (r101.isDiscover() != true) goto L4;
        performSearchListener(r101);
    L12:
        return;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_byted_cast_linkcommon_cybergarage_upnp_ssdp_SSDPSearchSocket_com_larus_apm_impl_protector_RunnableLancet_run(SSDPSearchSocket r100) {
        r100.com_byted_cast_linkcommon_cybergarage_upnp_ssdp_SSDPSearchSocket__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public void addSearchListener(SearchListener r100) {
        this.deviceSearchListenerList.add(r100);
    }

    public boolean open(String r100) {
        this.useIPv6Address = false;
        if (HostInterface.isIPv6Address(r100) != true) goto L5;
        String r101 = SSDP.getIPv6Address();
        this.useIPv6Address = true;
    L7:
        return open(r101, 1900, r100);
    L5:
        r101 = SSDP.ADDRESS;
        goto L7
    }

    public void performSearchListener(SSDPPacket r100) {
        int r101 = this.deviceSearchListenerList.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((SearchListener) this.deviceSearchListenerList.get(r102)).deviceSearchReceived(r100);
        r102 = r102 + 1;
        goto L3
    }

    public void removeSearchListener(SearchListener r100) {
        this.deviceSearchListenerList.remove(r100);
    }

    public boolean open(Inet6Address r100) {
        this.useIPv6Address = true;
        return open(SSDP.getIPv6Address(), 1900, r100);
    }

    public boolean open(Inet4Address r100) {
        this.useIPv6Address = false;
        return open(SSDP.ADDRESS, 1900, r100);
    }

    public SSDPSearchSocket(ContextManager.CastContext r100, InetAddress r101) {
        super(r100);
        this.deviceSearchListenerList = new ListenerList();
        this.deviceSearchThread = null;
        if (r101.getAddress().length == 4) goto L5;
        open((Inet6Address) r101);
        return;
    L5:
        open((Inet4Address) r101);
    }

    public boolean open(String r100, String r101) {
        if (HostInterface.isIPv6Address(r100) == false) goto L8;
        if (HostInterface.isIPv6Address(r101) == false) goto L8;
        this.useIPv6Address = true;
    L13:
        return open(r101, 1900, r100);
    L8:
        if (HostInterface.isIPv4Address(r100) == false) goto L15;
        if (HostInterface.isIPv4Address(r101) == false) goto L15;
        this.useIPv6Address = false;
    L15:
        throw new IllegalArgumentException("Cannot open a UDP Socket for IPv6 address on IPv4 interface or viceversa");
    }

    public SSDPSearchSocket(ContextManager.CastContext r100, String r101, int r102, String r103) {
        super(r100);
        this.deviceSearchListenerList = new ListenerList();
        this.deviceSearchThread = null;
        open(r101, r103);
    }
}
