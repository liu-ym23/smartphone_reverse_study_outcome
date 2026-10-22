package com.byted.cast.linkcommon.cybergarage.upnp.ssdp;

import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.Utils;
import com.byted.cast.linkcommon.cybergarage.cast.CastSSDPPacket;
import com.byted.cast.linkcommon.cybergarage.http.HTTPRequest;
import com.byted.cast.linkcommon.cybergarage.upnp.UPnP;
import com.byted.cast.linkcommon.cybergarage.util.Debug;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes28.dex */
public class HTTPMUSocket {
    private static final String TAG = "HTTPMUSocket";
    protected ContextManager.CastContext mCastContext;
    protected CastLogger mLogger;
    private CastMonitor mMonitor;
    private InetSocketAddress ssdpMultiGroup;
    private NetworkInterface ssdpMultiIf;
    private MulticastSocket ssdpMultiSock;

    public boolean close() {
        MulticastSocket r100 = this.ssdpMultiSock;
        if (r100 != null) goto L9;
        return true;
    L9:
        r100.leaveGroup(this.ssdpMultiGroup, this.ssdpMultiIf);     // Catch: Exception -> L7
        this.ssdpMultiSock.close();     // Catch: Exception -> L7
        this.ssdpMultiSock = null;     // Catch: Exception -> L7
        return true;
    L7:
        return false;
    }

    public String getLocalAddress() {
        InetSocketAddress r100 = this.ssdpMultiGroup;
        if (r100 != null) goto L5;
    L22:
        return "";
    L5:
        if (this.ssdpMultiIf == null) goto L22;
        InetAddress r101 = r100.getAddress();
        Enumeration<InetAddress> r102 = this.ssdpMultiIf.getInetAddresses();
    L9:
        if (r102.hasMoreElements() == false) goto L22;
        InetAddress r103 = r102.nextElement();
        if ((r101 instanceof Inet6Address) == false) goto L17;
        if ((r103 instanceof Inet6Address) == false) goto L17;
        return r103.getHostAddress();
    L17:
        if ((r101 instanceof Inet4Address) == false) goto L9;
        if ((r103 instanceof Inet4Address) == false) goto L9;
        return r103.getHostAddress();
    }

    public String getLocalIPV4Address() {
        InetSocketAddress r100 = this.ssdpMultiGroup;
        if (r100 != null) goto L5;
    L16:
        return "";
    L5:
        if (this.ssdpMultiIf == null) goto L16;
        InetAddress r101 = r100.getAddress();
        Enumeration<InetAddress> r102 = this.ssdpMultiIf.getInetAddresses();
    L9:
        if (r102.hasMoreElements() == false) goto L16;
        InetAddress r103 = r102.nextElement();
        if ((r101 instanceof Inet4Address) == false) goto L9;
        if ((r103 instanceof Inet4Address) == false) goto L9;
        return r103.getHostAddress();
    }

    public int getLocalPort() {
        return this.ssdpMultiSock.getLocalPort();
    }

    public InetAddress getMulticastInetAddress() {
        return this.ssdpMultiGroup.getAddress();
    }

    public int getMulticastPort() {
        return this.ssdpMultiGroup.getPort();
    }

    private HTTPMUSocket() {
        this.ssdpMultiGroup = null;
        this.ssdpMultiSock = null;
        this.ssdpMultiIf = null;
    }

    public String getMulticastAddress() {
        return getMulticastInetAddress().getHostAddress();
    }

    public SSDPPacket receive() throws IOException {
        if (Utils.isOppo6() == false) goto L5;
        int r100 = 2048;
    L6:
        SSDPPacket r101 = new SSDPPacket(new byte[r100], r100);
        r101.setLocalAddress(getLocalIPV4Address());
        MulticastSocket r102 = this.ssdpMultiSock;
        if (r102 == null) goto L15;
        r102.receive(r101.getDatagramPacket());     // Catch: Exception -> L11
        r101.setTimeStamp(System.currentTimeMillis());
        return r101;
    L11:
        e = move-exception;
        this.mLogger.e(TAG, "receive null pointer exception:" + e);
        return null;
    L15:
        throw new IOException("Multicast socket has already been closed.");
    L5:
        r100 = 1024;
        goto L6
    }

    public CastSSDPPacket receiveBDLink() throws IOException {
        if (Utils.isOppo6() == false) goto L5;
        int r100 = 2048;
    L6:
        CastSSDPPacket r101 = new CastSSDPPacket(new byte[r100], r100);
        r101.setLocalAddress(getLocalAddress());
        MulticastSocket r102 = this.ssdpMultiSock;
        if (r102 == null) goto L15;
        r102.receive(r101.getDatagramPacket());     // Catch: NullPointerException -> L11
        r101.setTimeStamp(System.currentTimeMillis());
        return r101;
    L11:
        e = move-exception;
        this.mLogger.e(TAG, "receive null pointer exception:" + e);
        return null;
    L15:
        throw new IOException("Multicast socket has already been closed.");
    L5:
        r100 = 1024;
        goto L6
    }

    public void finalize() {
        close();
    }

    public MulticastSocket getSocket() {
        return this.ssdpMultiSock;
    }

    public HTTPMUSocket(ContextManager.CastContext r100) {
        this.ssdpMultiGroup = null;
        this.ssdpMultiSock = null;
        this.ssdpMultiIf = null;
        this.mCastContext = r100;
        this.mLogger = ContextManager.getLogger(r100);
        this.mMonitor = ContextManager.getMonitor(r100);
    }

    public boolean post(HTTPRequest r100) {
        return send(r100.toString(), null, -1);
    }

    public boolean send(String r100) {
        return send(r100, null, -1);
    }

    public boolean setMulticastInetAddress(String r100, int r101) {
        this.ssdpMultiGroup = new InetSocketAddress(InetAddress.getByName(r100), r101);     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        Debug.warning(e);
        return false;
    }

    public boolean open(String r100, int r101, InetAddress r102) {
        MulticastSocket r103 = new MulticastSocket(null);     // Catch: Exception -> L7
        this.ssdpMultiSock = r103;     // Catch: Exception -> L7
        r103.setReuseAddress(true);     // Catch: Exception -> L7
        InetSocketAddress r104 = new InetSocketAddress(r101);     // Catch: Exception -> L7
        this.ssdpMultiSock.bind(r104);     // Catch: Exception -> L7
        if (this.ssdpMultiGroup != null) goto L5;
        this.ssdpMultiGroup = new InetSocketAddress(InetAddress.getByName(r100), r101);     // Catch: Exception -> L7
    L5:
        NetworkInterface r105 = NetworkInterface.getByInetAddress(r102);     // Catch: Exception -> L7
        this.ssdpMultiIf = r105;     // Catch: Exception -> L7
        this.ssdpMultiSock.joinGroup(this.ssdpMultiGroup, r105);     // Catch: Exception -> L7
        return true;
    L7:
        e = move-exception;
        Debug.warning(e);
        return false;
    }

    public boolean post(HTTPRequest r100, String r101, int r102) {
        return send(r100.toString(), r101, r102);
    }

    public boolean postWithBroadcast(HTTPRequest r100, String r101, int r102) {
        return sendWithBroadcast(r100.toString(), r101, r102);
    }

    public boolean send(String r100, String r101, int r102) {
        if (r101 == null) goto L5;
        if (r102 < 0) goto L5;
        MulticastSocket r103 = new MulticastSocket(null);     // Catch: Exception -> L9
        r103.bind(new InetSocketAddress(r101, r102));     // Catch: Exception -> L9
    L6:
        DatagramPacket r104 = new DatagramPacket(r100.getBytes(), r100.getBytes().length, this.ssdpMultiGroup);     // Catch: Exception -> L9
        r103.setTimeToLive(UPnP.getTimeToLive());     // Catch: Exception -> L9
        r103.send(r104);     // Catch: Exception -> L9
        r103.close();     // Catch: Exception -> L9
        return true;
    L5:
        r103 = new MulticastSocket();     // Catch: Exception -> L9
    L9:
        return false;
    }

    public boolean sendWithBroadcast(String r100, String r101, int r102) {
        if (r101 == null) goto L5;
        if (r102 < 0) goto L5;
        MulticastSocket r103 = new MulticastSocket(null);     // Catch: Exception -> L8
        r103.bind(new InetSocketAddress(r101, r102));     // Catch: Exception -> L8
    L6:
        r103.setBroadcast(true);     // Catch: Exception -> L8
        DatagramPacket r104 = new DatagramPacket(r100.getBytes(), r100.getBytes().length, this.ssdpMultiGroup);     // Catch: Exception -> L8
        r103.setTimeToLive(UPnP.getTimeToLive());     // Catch: Exception -> L8
        r103.send(r104);     // Catch: Exception -> L8
        r103.close();     // Catch: Exception -> L8
        return true;
    L5:
        r103 = new MulticastSocket();     // Catch: Exception -> L8
    L8:
        return false;
    }

    public boolean open(String r100, int r101, String r102) {
        return open(r100, r101, InetAddress.getByName(r102));
    L4:
        e = move-exception;
        Debug.warning(e);
        return false;
    }
}
