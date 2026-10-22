package com.byted.cast.linkcommon.cybergarage.upnp.ssdp;

import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.ErrorCode;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.common.Utils;
import com.byted.cast.linkcommon.cybergarage.cast.CastSSDPPacket;
import com.byted.cast.linkcommon.cybergarage.util.Debug;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.HashMap;

/* JADX INFO: loaded from: classes28.dex */
public class HTTPUSocket {
    private static final String TAG = null;
    protected final ContextManager.CastContext castContext;
    protected final CastLogger castLogger;
    private String localAddr;
    private CastMonitor mMonitor;
    private TeaEventTrack mTeaEventTrack;
    private DatagramSocket ssdpUniSock;

    static {
        TAG = "HTTPUSocket";
    }

    public boolean close() {
        DatagramSocket r100 = this.ssdpUniSock;
        if (r100 != null) goto L10;
        return true;
    L10:
        r100.close();     // Catch: Exception -> L7
        this.ssdpUniSock = null;     // Catch: Exception -> L7
        return true;
    L7:
        e = move-exception;
        Debug.warning(e);
        return false;
    }

    public String getLocalAddress() {
        if (this.localAddr.length() > 0) goto L5;
        DatagramSocket r100 = this.ssdpUniSock;
        if (r100 != null) goto L11;
        return this.localAddr;
    L11:
        return r100.getLocalAddress().getHostAddress();
    L5:
        return this.localAddr;
    }

    public boolean open() {
        close();
        this.ssdpUniSock = new DatagramSocket();     // Catch: Exception -> L6
        return true;
    L6:
        e = move-exception;
        Debug.warning(e);
        close();
        return false;
    }

    public SSDPPacket receive() {
        if (Utils.isOppo6() == false) goto L5;
        int r100 = 2048;
    L6:
        SSDPPacket r101 = new SSDPPacket(new byte[r100], r100);
        r101.setLocalAddress(getLocalAddress());
        this.ssdpUniSock.receive(r101.getDatagramPacket());     // Catch: Exception -> L9
        r101.setTimeStamp(System.currentTimeMillis());     // Catch: Exception -> L9
        return r101;
    L9:
        return null;
    L5:
        r100 = 1024;
        goto L6
    }

    public CastSSDPPacket receiveBDlink() {
        if (Utils.isOppo6() == false) goto L5;
        int r100 = 2048;
    L6:
        CastSSDPPacket r101 = new CastSSDPPacket(new byte[r100], r100);
        r101.setLocalAddress(getLocalAddress());
        this.ssdpUniSock.receive(r101.getDatagramPacket());     // Catch: Exception -> L9
        r101.setTimeStamp(System.currentTimeMillis());     // Catch: Exception -> L9
        return r101;
    L9:
        return null;
    L5:
        r100 = 1024;
        goto L6
    }

    public void finalize() {
        close();
    }

    public DatagramSocket getDatagramSocket() {
        return this.ssdpUniSock;
    }

    public DatagramSocket getUDPSocket() {
        return this.ssdpUniSock;
    }

    public HTTPUSocket(ContextManager.CastContext r100) {
        this.ssdpUniSock = null;
        this.localAddr = "";
        this.castContext = r100;
        this.castLogger = ContextManager.getLogger(r100);
        this.mTeaEventTrack = ContextManager.getTeaEventTrack(r100);
        this.mMonitor = ContextManager.getMonitor(r100);
    }

    public boolean open(int r100) {
        close();
        InetSocketAddress r101 = new InetSocketAddress(r100);     // Catch: Exception -> L5
        DatagramSocket r102 = new DatagramSocket(null);     // Catch: Exception -> L5
        this.ssdpUniSock = r102;     // Catch: Exception -> L5
        r102.setReuseAddress(true);     // Catch: Exception -> L5
        this.ssdpUniSock.bind(r101);     // Catch: Exception -> L5
        return true;
    L5:
        close();
        return false;
    }

    public void setLocalAddress(String r100) {
        this.localAddr = r100;
    }

    public boolean open(String r100, int r101) {
        close();
        this.ssdpUniSock = new DatagramSocket(new InetSocketAddress(InetAddress.getByName(r100), r101));     // Catch: Exception -> L6 BindException -> L8
        setLocalAddress(r100);
        return true;
    L6:
        close();
        return false;
    L9:
        if (open(r101) == false) goto L12;
        setLocalAddress(r100);
        return true;
    L12:
        return false;
    }

    public boolean post(String r100, int r101, String r102, String r103, boolean r104) {
        this.ssdpUniSock.send(new DatagramPacket(r102.getBytes(), r102.getBytes().length, InetAddress.getByName(r100), r101));     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        if ("source".equals(r103) == false) goto L13;
        if (r104 == false) goto L12;
        this.mMonitor.getSourceMonitor().sendDlnaBrowseError(ErrorCode.DLNA_SEARCH_SEARCH_POST_ERROR, e.getLocalizedMessage(), null);
        if (this.mTeaEventTrack == null) goto L12;
        HashMap<String, String> r105 = new HashMap();
        r105.put("err_code", String.valueOf(ErrorCode.DLNA_SEARCH_SEARCH_POST_ERROR));
        r105.put(LocationMonitorConst.ERR_MSG, e.getMessage());
        r105.put("err_exception", e.getLocalizedMessage());
        this.mTeaEventTrack.trackDlnaBrowse("failure", r105);
    L12:
        this.castLogger.i(TAG, "_DLNA_SEARCH post search message e :" + e.getLocalizedMessage());
        return false;
    L13:
        this.castLogger.e(TAG, " post search message e :", e);
        return false;
    }
}
