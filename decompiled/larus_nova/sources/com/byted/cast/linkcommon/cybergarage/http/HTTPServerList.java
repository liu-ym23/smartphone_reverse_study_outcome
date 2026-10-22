package com.byted.cast.linkcommon.cybergarage.http;

import android.text.TextUtils;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.ErrorCode;
import com.byted.cast.common.Logger;
import com.byted.cast.common.TeaEventTrack;
import com.byted.cast.common.Utils;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.Device;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Vector;

/* JADX INFO: loaded from: classes28.dex */
public class HTTPServerList extends Vector {
    private static final String TAG = "BDDLNA.HTTPServerList";
    private InetAddress[] binds;
    private boolean enableBdlinkSinkLinkLocalIPv6;
    private final HTTPServerType httpServerType;
    private ContextManager.CastContext mCastContext;
    private CastLogger mLogger;
    private CastMonitor mMonitor;
    private TeaEventTrack mTeaEventTrack;
    private int port;

    public int open() {
        InetAddress[] r100 = this.binds;
        int r101 = 0;
        if (r100 == null) goto L8;
        String[] r102 = new String[r100.length];
        int r103 = 0;
    L6:
        if (r103 >= r100.length) goto L15;
        r102[r103] = r100[r103].getHostAddress();
        r103 = r103 + 1;
    L15:
        int r104 = 0;
    L17:
        if (r101 >= r102.length) goto L30;
        HTTPServer r105 = new HTTPServer(this.mCastContext, this.httpServerType);
        String r106 = r102[r101];
        if (r106 != null) goto L21;
    L24:
        if (r106 != null) goto L26;
        String r107 = this.httpServerType + " Http server bindAddresses null i:" + r101;
    L27:
        trackStartServerInfo(r107);
    L28:
        r101 = r101 + 1;
        goto L17
    L26:
        r107 = this.httpServerType + " Http server bindAddresses open failure i:" + r101 + ",add:" + r106 + ",port:" + this.port;
        goto L27
    L21:
        if (r105.open(r106, this.port) == false) goto L24;
        add(r105);
        r104 = r104 + 1;
        goto L28
    L30:
        if (r104 != 0) goto L34;
        trackStartServerInfo(this.httpServerType + " Http server list open failure. binds:" + Arrays.toString(r100) + ",port:" + this.port);
        if (HTTPServerType.DLNA_SOURCE != this.httpServerType) goto L34;
        this.mLogger.d(TAG, "_DLNA_SEARCH Http server list open failure. binds:" + r100 + ",port:" + this.port);
        trackDlnaBrowseError(null, ErrorCode.DLNA_SEARCH_START_HTTP_SERVER_START_ERROR, "BDDLNA Http server list open failure.", "");
    L34:
        this.mLogger.d(TAG, "open server number = " + r104);
        return r104;
    L8:
        ArrayList<String> r108 = HostInterface.getHostAddresses();
        int r109 = r108.size();
        if (r109 >= 1) goto L11;
        trackStartServerInfo(this.httpServerType + " Http server list nHostAddrs < 1");
    L11:
        String[] r110 = new String[r109];
        int r111 = 0;
    L12:
        if (r111 >= r109) goto L14;
        r110[r111] = (String) ListProtector.get(r108, r111);
        r111 = r111 + 1;
        goto L12
    L14:
        r102 = r110;
        goto L15
    }

    public int openBDLink() {
        int r100 = 0;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
        InetAddress[] r104 = this.binds;
        int r110 = 0;
        if (r104 != null) goto L12;
        ArrayList<InetAddress> r105 = HostInterface.getInetAddress(this.enableBdlinkSinkLinkLocalIPv6);
        if (r105.isEmpty() == false) goto L8;
        this.mLogger.d(TAG, "BDLink http server inetAddressList is empty");
        this.mMonitor.sendSinkEvent(CastMonitor.BDLINK_START_SERVER_INFO, "BDLink http server inetAddressList is empty");
        trackBDLinkStartServerResult(0, 0, 0, 0, 0, 0, "", this.port);
        return 0;
    L8:
        int r111 = r105.size();
        InetAddress[] r112 = new InetAddress[r111];
        int r113 = 0;
    L9:
        if (r113 >= r111) goto L11;
        r112[r113] = (InetAddress) ListProtector.get(r105, r113);
        r113 = r113 + 1;
        goto L9
    L11:
        r104 = r112;
    L12:
        int r106 = 0;
        int r114 = 0;
    L14:
        if (r106 >= r104.length) goto L35;
        HTTPServer r115 = new HTTPServer(this.mCastContext, this.httpServerType);
        InetAddress r116 = r104[r106];
        if (r116 != null) goto L18;
    L28:
        if (r116 != null) goto L30;
    L33:
        this.mMonitor.sendSinkEvent(CastMonitor.BDLINK_START_SERVER_INFO, "BDLink Http server bindAddresses null i:" + r106);
    L34:
        r106 = r106 + 1;
        goto L14
    L30:
        if (TextUtils.isEmpty(r116.getHostAddress()) == true) goto L33;
        this.mMonitor.sendSinkEvent(CastMonitor.BDLINK_START_SERVER_INFO, "BDLink Http server bindAddresses open failure i:" + r106 + ",add:" + r116.getHostAddress() + ",port:" + this.port);
        goto L34
    L18:
        if (TextUtils.isEmpty(r116.getHostAddress()) == true) goto L28;
        if (r115.open(r116.getHostAddress(), this.port) == false) goto L28;
        add(r115);
        r114 = r114 + 1;
        if ((r116 instanceof Inet4Address) == false) goto L26;
        r102 = r102 + 1;
        goto L34
    L26:
        if ((r116 instanceof Inet6Address) == false) goto L34;
        r103 = r103 + 1;
        goto L34
    L35:
        StringBuilder r107 = new StringBuilder();
        int r108 = r104.length;
        int r117 = 0;
    L36:
        if (r110 >= r108) goto L49;
        InetAddress r118 = r104[r110];
        if (r118 == null) goto L48;
        if (TextUtils.isEmpty(r118.getHostAddress()) == true) goto L48;
        r117 = r117 + 1;
        r107.append(r118.getHostAddress());
        r107.append(",");
        if ((r118 instanceof Inet4Address) == false) goto L46;
        r100 = r100 + 1;
        goto L48
    L46:
        if ((r118 instanceof Inet6Address) == false) goto L48;
        r101 = r101 + 1;
    L48:
        r110 = r110 + 1;
        goto L36
    L49:
        if (r114 != 0) goto L51;
        Logger.d(TAG, "BDLink Http server list open failure. binds:" + r107 + ",port:" + this.port);
        this.mMonitor.sendSinkEvent(CastMonitor.BDLINK_START_SERVER_INFO, "BDLink Http server list open failure. bindAddresses:" + r107 + ",port:" + this.port);
    L51:
        trackBDLinkStartServerResult(r117, r100, r101, r114, r102, r103, r107.toString(), this.port);
        return r114;
    }

    public int openUseRandomPort() {
        int r110 = 0;
        this.port = 0;
        int r100 = 0;
        int r101 = 0;
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
        InetAddress[] r105 = this.binds;
        if (r105 != null) goto L12;
        ArrayList<InetAddress> r106 = HostInterface.getInetAddress(this.enableBdlinkSinkLinkLocalIPv6);
        if (r106.isEmpty() == false) goto L8;
        Logger.d(TAG, "BDLink http server inetAddressList is empty");
        this.mMonitor.sendSinkEvent(CastMonitor.BDLINK_START_SERVER_INFO, "BDLink http server inetAddressList is empty");
        trackBDLinkStartServerResult(0, 0, 0, 0, 0, 0, "", this.port);
        return 0;
    L8:
        int r111 = r106.size();
        InetAddress[] r112 = new InetAddress[r111];
        int r113 = 0;
    L9:
        if (r113 >= r111) goto L11;
        r112[r113] = (InetAddress) ListProtector.get(r106, r113);
        r113 = r113 + 1;
        goto L9
    L11:
        r105 = r112;
    L12:
        int r114 = 0;
    L14:
        if (r114 >= r105.length) goto L38;
        HTTPServer r115 = new HTTPServer(this.mCastContext, this.httpServerType);
        InetAddress r116 = r105[r114];
        if (r116 != null) goto L18;
    L31:
        if (r116 != null) goto L33;
    L36:
        this.mMonitor.sendSinkEvent(CastMonitor.BDLINK_START_SERVER_INFO, "BDLink Http server bindAddresses null i:" + r114);
    L37:
        r114 = r114 + 1;
        goto L14
    L33:
        if (TextUtils.isEmpty(r116.getHostAddress()) == true) goto L36;
        this.mMonitor.sendSinkEvent(CastMonitor.BDLINK_START_SERVER_INFO, "BDLink Http server bindAddresses open failure i:" + r114 + ",add:" + r116.getHostAddress() + ",port:" + this.port);
        goto L37
    L18:
        if (TextUtils.isEmpty(r116.getHostAddress()) == true) goto L31;
        if (r115.open(r116.getHostAddress(), this.port) == false) goto L31;
        add(r115);
        r102 = r102 + 1;
        if (this.port != 0) goto L26;
        this.port = r115.getBindPort();
    L26:
        if ((r116 instanceof Inet4Address) == false) goto L29;
        r103 = r103 + 1;
        goto L37
    L29:
        if ((r116 instanceof Inet6Address) == false) goto L37;
        r104 = r104 + 1;
        goto L37
    L38:
        StringBuilder r107 = new StringBuilder();
        int r117 = r105.length;
        int r118 = 0;
    L39:
        if (r110 >= r117) goto L52;
        InetAddress r119 = r105[r110];
        if (r119 == null) goto L51;
        if (TextUtils.isEmpty(r119.getHostAddress()) == true) goto L51;
        r118 = r118 + 1;
        r107.append(r119.getHostAddress());
        r107.append(",");
        if ((r119 instanceof Inet4Address) == false) goto L49;
        r100 = r100 + 1;
        goto L51
    L49:
        if ((r119 instanceof Inet6Address) == false) goto L51;
        r101 = r101 + 1;
    L51:
        r110 = r110 + 1;
        goto L39
    L52:
        if (r102 != 0) goto L54;
        Logger.d(TAG, "BDLink Http server list open failure. binds:" + r107 + ",port:" + this.port);
        this.mMonitor.sendSinkEvent(CastMonitor.BDLINK_START_SERVER_INFO, "BDLink Http server list open failure. bindAddresses:" + r107 + ",port:" + this.port);
    L54:
        trackBDLinkStartServerResult(r118, r100, r101, r102, r103, r104, r107.toString(), this.port);
        return this.port;
    }

    public void close() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        HTTPServer r102 = getHTTPServer(r101);
        if (r102 == null) goto L7;
        r102.close();
    L7:
        r101 = r101 + 1;
        goto L3
    }

    public String getFirstIPv4Address() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L21;
        HTTPServer r102 = getHTTPServer(r101);     // Catch: Exception -> L11
        if (r102 == null) goto L10;
        if (Utils.IPV4_PATTERN.matcher(r102.getBindAddress()).matches() == false) goto L10;
        return r102.getBindAddress();
    L10:
        r101 = r101 + 1;
    L11:
        e = move-exception;
        Logger.d(TAG, "e msg is" + e.getMessage());
        return null;
    L21:
        return null;
    }

    public String getFirstIPv6Address() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L12;
        HTTPServer r102 = getHTTPServer(r101);
        if (r102 == null) goto L11;
        InetAddress r103 = r102.getBindInetAddress();
        if ((r103 instanceof Inet6Address) == false) goto L11;
        return r103.toString();
    L11:
        r101 = r101 + 1;
        goto L3
    L12:
        return null;
    }

    public void start() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        HTTPServer r102 = getHTTPServer(r101);
        if (r102 == null) goto L7;
        r102.start();
    L7:
        r101 = r101 + 1;
        goto L3
    }

    public void stop() {
        int r100 = size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        HTTPServer r102 = getHTTPServer(r101);
        if (r102 == null) goto L7;
        r102.stop();
    L7:
        r101 = r101 + 1;
        goto L3
    }

    private void trackStartServerInfo(String r100) {
        this.mLogger.d(TAG, r100);
        HTTPServerType r101 = HTTPServerType.DLNA_SINK;
        HTTPServerType r102 = this.httpServerType;
        if (r101 != r102) goto L6;
        this.mMonitor.sendSinkEvent(CastMonitor.BDDLNA_START_SERVER_INFO, r100);
        return;
    L6:
        if (HTTPServerType.BDLINK_SINK != r102) goto L9;
        this.mMonitor.sendSinkEvent(CastMonitor.BDLINK_START_SERVER_INFO, r100);
        return;
    L9:
        if (HTTPServerType.BDLINK_SOURCE != r102) goto L14;
        this.mMonitor.sendSourceEvent(CastMonitor.BDLINK_START_SERVER_INFO, r100);
        return;
    }

    public void addRequestListener(HTTPRequestListener r100) {
        int r101 = size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        HTTPServer r103 = getHTTPServer(r102);
        if (r103 == null) goto L7;
        r103.addRequestListener(r100);
    L7:
        r102 = r102 + 1;
        goto L3
    }

    public HTTPServer getHTTPServer(int r100) {
        return (HTTPServer) get(r100);
    L4:
        return null;
    }

    public int open(boolean r100) {
        InetAddress[] r101 = this.binds;
        int r102 = 0;
        if (r101 == null) goto L8;
        String[] r103 = new String[r101.length];
        int r104 = 0;
    L6:
        if (r104 >= r101.length) goto L19;
        r103[r104] = r101[r104].getHostAddress();
        r104 = r104 + 1;
    L19:
        ArrayList r105 = new ArrayList();
        int r106 = 0;
    L21:
        if (r102 >= r103.length) goto L30;
        HTTPServer r107 = new HTTPServer(this.mCastContext, this.httpServerType);
        String r108 = r103[r102];
        if (r108 != null) goto L25;
        trackStartServerInfo(this.httpServerType + " Http server bindAddresses null i:" + r102);
    L29:
        r102 = r102 + 1;
        goto L21
    L25:
        HashMap<String, String> r109 = r107.openServer(r108, this.port);
        if (Boolean.parseBoolean(r109.get("result")) == false) goto L28;
        add(r107);
        r106 = r106 + 1;
        goto L29
    L28:
        r105.add(r109.get("err_exception"));
        goto L29
    L30:
        if (r106 != 0) goto L38;
        trackStartServerInfo(this.httpServerType + " Http server list open failure. binds:" + Arrays.toString(r101) + ",port:" + this.port);
        if (r100 == false) goto L38;
        if (HTTPServerType.DLNA_SINK.equals(this.httpServerType) == false) goto L38;
        if (r103.length <= 0) goto L38;
        trackSinkServerStartFailed(ErrorCode.ERROR_CODE_DLNA_SERVER_START_BIND_EXCEPTION, ErrorCode.ERROR_MSG_DLNA_SERVER_START_BIND_EXCEPTION, r105.toString());
    L38:
        this.mLogger.d(TAG, "open server number = " + r106);
        return r106;
    L8:
        ArrayList<String> r110 = HostInterface.getHostAddresses();
        int r111 = r110.size();
        if (r111 >= 1) goto L15;
        trackStartServerInfo(this.httpServerType + " Http server list nHostAddrs < 1");
        if (r100 == false) goto L15;
        if (HTTPServerType.DLNA_SINK.equals(this.httpServerType) == false) goto L15;
        trackSinkServerStartFailed(ErrorCode.ERROR_CODE_DLNA_SERVER_START_BINDS_NULL, ErrorCode.ERROR_MSG_DLNA_SERVER_START_BINDS_NULL, "");
    L15:
        String[] r112 = new String[r111];
        int r113 = 0;
    L16:
        if (r113 >= r111) goto L18;
        r112[r113] = (String) ListProtector.get(r110, r113);
        r113 = r113 + 1;
        goto L16
    L18:
        r103 = r112;
        goto L19
    }

    public boolean openBDLink(int r100) {
        this.port = r100;
        if (openBDLink() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void updateCastContext(ContextManager.CastContext r100) {
        this.mCastContext = r100;
        this.mLogger = ContextManager.getLogger(r100);
        this.mMonitor = ContextManager.getMonitor(r100);
        this.mTeaEventTrack = ContextManager.getTeaEventTrack(r100);
        this.enableBdlinkSinkLinkLocalIPv6 = ContextManager.getConfigManager(r100).getInitConfig().isEnableBdlinkSinkLinkLocalIPv6();
    }

    public boolean open(int r100) {
        this.port = r100;
        if (open() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public HTTPServerList(ContextManager.CastContext r100, HTTPServerType r101) {
        this.binds = null;
        this.port = 4004;
        this.enableBdlinkSinkLinkLocalIPv6 = false;
        this.httpServerType = r101;
        updateCastContext(r100);
    }

    public boolean open(int r100, boolean r101) {
        this.port = r100;
        if (open(r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void trackSinkServerStartFailed(int r100, String r101, String r102) {
        HashMap r103 = new HashMap();
        r103.put("cast_protocol", "BDDLNA".toLowerCase(Locale.ROOT));
        r103.put("state", "failure");
        r103.put(LocationMonitorConst.ERR_MSG, r101);
        r103.put("err_code", String.valueOf(r100));
        r103.put("err_exception", r102);
        TeaEventTrack.getInstance().trackSinkEvent(TeaEventTrack.BYTECASTSDK_INDICATOR_START_SERVER, new Map[]{r103});
    }

    public HTTPServerList(ContextManager.CastContext r100, InetAddress[] r101, int r102, HTTPServerType r103) {
        this.enableBdlinkSinkLinkLocalIPv6 = false;
        this.binds = r101;
        this.port = r102;
        this.httpServerType = r103;
        updateCastContext(r100);
    }

    public void trackDlnaBrowseError(Device r100, int r101, String r102, String r103) {
        if (r100 == null) goto L5;
        HashMap<String, String> r104 = new HashMap();
        r104.put("manufacture", r100.getManufacture());
        r104.put("friendlyName", r100.getFriendlyName());
        r104.put("location", r100.getLocation());
        r104.put("urlBase", r100.getURLBase());
        r104.put("modelName", r100.getModelName());
        r104.put("err_exception", r103);
    L6:
        this.mMonitor.getSourceMonitor().sendDlnaBrowseError(r101, r102, r104);
        if (this.mTeaEventTrack == null) goto L13;
        HashMap<String, String> r105 = new HashMap();
        if (r100 == null) goto L11;
        r105.putAll(r100.getDeviceMap());
    L11:
        r105.put("err_code", String.valueOf(r101));
        r105.put(LocationMonitorConst.ERR_MSG, r102);
        r105.put("err_exception", r103);
        this.mTeaEventTrack.trackDlnaBrowse("failure", r105);
        return;
    L13:
        return;
    L5:
        r104 = null;
        goto L6
    }

    private void trackBDLinkStartServerResult(int r100, int r101, int r102, int r103, int r104, int r105, String r106, int r110) {
        HashMap r107 = new HashMap();
        r107.put("ip_count", String.valueOf(r100));
        r107.put("ipv4_count", String.valueOf(r101));
        r107.put("ipv6_count", String.valueOf(r102));
        r107.put("success_count", String.valueOf(r103));
        r107.put("ipv4_success_count", String.valueOf(r104));
        r107.put("ipv6_success_count", String.valueOf(r105));
        String r108 = "success";
        if (r103 <= 0) goto L5;
        Object r109 = "success";
    L6:
        r107.put("result", r109);
        r107.put("is_enable_link_local_ipv6", String.valueOf(this.enableBdlinkSinkLinkLocalIPv6));
        if (r104 <= 0) goto L9;
        Object r111 = "success";
    L10:
        r107.put("ipv4_result", r111);
        if (r105 > 0) goto L14;
        r108 = "failure";
    L14:
        r107.put("ipv6_result", r108);
        r107.put("port", String.valueOf(r110));
        HashMap r112 = new HashMap();
        r112.put("address", r106);
        this.mMonitor.sendSinkEvent(CastMonitor.BDLINK_START_SERVER_RESULT, r107, r112);
        TeaEventTrack r113 = this.mTeaEventTrack;
        if (r113 == null) goto L18;
        r113.trackSinkEvent(TeaEventTrack.BDLINK_INDICATOR_START_SERVER_RESULT, new Map[]{r107, r112});
        return;
    L18:
        return;
    L9:
        r111 = "failure";
        goto L10
    L5:
        r109 = "failure";
        goto L6
    }
}
