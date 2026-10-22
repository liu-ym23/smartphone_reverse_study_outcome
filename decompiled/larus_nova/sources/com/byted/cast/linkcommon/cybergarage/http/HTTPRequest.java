package com.byted.cast.linkcommon.cybergarage.http;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.byted.cast.common.CastLogger;
import com.byted.cast.common.CastMonitor;
import com.byted.cast.common.CommandExecuteStatus;
import com.byted.cast.common.ContextManager;
import com.byted.cast.common.NetworkUtil;
import com.byted.cast.common.source.IPlayerListener;
import com.byted.cast.linkcommon.cybergarage.net.HostInterface;
import com.byted.cast.linkcommon.cybergarage.util.Debug;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.miui.easygo.constant.EasyGoConstant;
import f06.b;
import f06.d;
import g06.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes28.dex */
public class HTTPRequest extends HTTPPacket {
    private static final int SO_TIMEOUT = 15000;
    private static final String TAG = null;
    private HTTPSocket httpSocket;
    private String method;
    private Socket postSocket;
    private String remoteSocketAddress;
    private String requestHost;
    private int requestPort;
    private int soTimeout;
    private int timeout;
    private String uri;

    static {
        TAG = "HTTPRequest";
    }

    public String getHeader() {
        StringBuffer r100 = new StringBuffer();
        r100.append(getFirstLineString());
        r100.append(getHeaderString());
        return r100.toString();
    }

    public String getMethod() {
        String r100 = this.method;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return getFirstLineToken(0);
    }

    public ParameterList getParameterList() {
        ParameterList r100 = new ParameterList();
        String r101 = getURI();
        if (r101 != null) goto L5;
        return r100;
    L5:
        int r102 = r101.indexOf(63);
        if (r102 >= 0) goto L8;
        return r100;
    L8:
        if (r102 <= 0) goto L14;
        int r103 = r102 + 1;
        int r104 = r101.indexOf(61, r103);
        String r105 = r101.substring(r103, r104);
        int r106 = r104 + 1;
        int r107 = r101.indexOf(38, r106);
        if (r107 <= 0) goto L12;
        int r108 = r107;
    L13:
        r100.add(new Parameter(r105, r101.substring(r106, r108)));
        r102 = r107;
        goto L8
    L12:
        r108 = r101.length();
        goto L13
    L14:
        return r100;
    }

    public String getRemoteAddress() {
        HTTPSocket r100 = this.httpSocket;
        if (r100 == null) goto L12;
        Socket r101 = r100.getSocket();
        if (r101 == null) goto L12;
        if (r101.isConnected() == false) goto L12;
        SocketAddress r102 = r101.getRemoteSocketAddress();
        if (r102 == null) goto L12;
        this.remoteSocketAddress = r102.toString();
    L12:
        return this.remoteSocketAddress;
    }

    public String getURI() {
        String r100 = this.uri;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return getFirstLineToken(1);
    }

    public boolean isGetRequest() {
        return isMethod("GET");
    }

    public boolean isHeadRequest() {
        return isMethod("HEAD");
    }

    public boolean isNotifyRequest() {
        return isMethod(HTTP.NOTIFY);
    }

    public boolean isPostRequest() {
        return isMethod("POST");
    }

    public boolean isSOAPAction() {
        return hasHeader(HTTP.SOAP_ACTION);
    }

    public boolean isSubscribeRequest() {
        return isMethod("SUBSCRIBE");
    }

    public boolean isUnsubscribeRequest() {
        return isMethod("UNSUBSCRIBE");
    }

    public void print() {
        System.out.println(toString());
    }

    public boolean returnBadRequest() {
        return returnResponse(400);
    }

    public boolean returnOK() {
        return returnResponse(200);
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer();
        r100.append(getHeader());
        r100.append("\r\n");
        r100.append(getContentString());
        return r100.toString();
    }

    public String getFirstLineString() {
        String r100 = getURI();
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = HTTP.URL_DEFAULT;
    L6:
        return getMethod() + " " + r100 + " " + getHTTPVersion() + "\r\n";
    }

    public String getHTTPVersion() {
        if (hasFirstLine() != true) goto L7;
        return getFirstLineToken(2);
    L7:
        return "HTTP/" + super.getVersion();
    }

    public String getLocalAddress() {
        return getSocket().getLocalAddress();
    }

    public int getLocalPort() {
        return getSocket().getLocalPort();
    }

    public String getRemoteIp() {
        String r100 = getRemoteAddress();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        String[] r101 = r100.split(":");
        if (r101.length >= 1) goto L8;
        return "";
    L8:
        String r102 = r101[0];
        if (r102 == null) goto L11;
        return r102;
    L11:
        return "";
    }

    public boolean isKeepAlive() {
        if (isCloseConnection() != true) goto L6;
        return false;
    L6:
        if (isKeepAliveConnection() != true) goto L9;
        return true;
    L9:
        if (getHTTPVersion().indexOf("1.0") <= 0) goto L11;
        boolean r100 = true;
    L12:
        if (r100 != true) goto L14;
        return false;
    L14:
        return true;
    L11:
        r100 = false;
        goto L12
    }

    public boolean read() {
        return super.read(getSocket());
    }

    public String getRequestHost() {
        return this.requestHost;
    }

    public int getRequestPort() {
        return this.requestPort;
    }

    public HTTPSocket getSocket() {
        return this.httpSocket;
    }

    public HTTPRequest(ContextManager.CastContext r100) {
        super(r100);
        this.method = null;
        this.uri = null;
        this.requestHost = "";
        this.requestPort = -1;
        this.httpSocket = null;
        this.timeout = 15000;
        this.soTimeout = 15000;
        this.postSocket = null;
        setVersion("1.0");
    }

    private static String com_byted_cast_linkcommon_cybergarage_http_HTTPRequest_android_net_NetworkInfo_getExtraInfo(NetworkInfo r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        b r112 = new b();
        a r101 = ApiHookConfig.f245611b.get(102026);
        if (r101 == null) goto L5;
        f06.a[] r102 = r101.f479473i;
    L6:
        f06.a[] r113 = r102;
        int r103 = r113.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L15;
        f06.a r105 = r113[r104];
        int r114 = r104;
        int r115 = r103;
        d r106 = r105.preInvoke(102026, "android/net/NetworkInfo", "getExtraInfo", r110, r111, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (String) r106.f474983b;
    L21:
        return r110.getExtraInfo();
    L14:
        r104 = r114 + 1;
        r103 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r102 = ApiHookConfig.f245613d;
        goto L6
    }

    private String getLocalHost(String r100) {
        ArrayList<String> r101 = HostInterface.getHostAddresses();
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L23:
        return "";
    L5:
        if (r101.isEmpty() == true) goto L23;
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        Iterator<String> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L23;
        String r104 = r103.next();
        String[] r105 = r104.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r102.length != 4) goto L9;
        if (r105.length != 4) goto L9;
        if (TextUtils.equals(r102[0], r105[0]) == false) goto L9;
        if (TextUtils.equals(r102[1], r105[1]) == false) goto L9;
        if (TextUtils.equals(r102[2], r105[2]) == false) goto L9;
        return r104;
    }

    public String getParameterValue(String r100) {
        return getParameterList().getValue(r100);
    }

    public boolean isMethod(String r100) {
        String r101 = getMethod();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.equalsIgnoreCase(r100);
    }

    public boolean parseRequestLine(String r100) {
        StringTokenizer r101 = new StringTokenizer(r100, " ");
        if (r101.hasMoreTokens() == true) goto L5;
        return false;
    L5:
        setMethod(r101.nextToken());
        if (r101.hasMoreTokens() == true) goto L8;
        return false;
    L8:
        setURI(r101.nextToken());
        if (r101.hasMoreTokens() == true) goto L11;
        return false;
    L11:
        setVersion(r101.nextToken());
        return true;
    }

    public boolean post(HTTPResponse r110) {
        HTTPSocket r100 = getSocket();
        long r101 = r110.getContentLength();
        if (hasContentRange() != true) goto L15;
        long r102 = getContentRangeFirstPosition();
        long r103 = getContentRangeLastPosition();
        if (r103 > 0) goto L7;
        r103 = r101 - 1;
    L7:
        long r111 = r103;
        if (r102 > r101) goto L14;
        if (r111 > r101) goto L14;
        long r104 = r102;
        r110.setContentRange(r104, r111, r101);
        r110.setStatusCode(206);
        long r105 = (r111 - r102) + 1;
    L17:
        return r100.post(r110, r104, r105, isHeadRequest());
    L14:
        return returnResponse(416);
    L15:
        r104 = 0;
        r105 = r101;
        goto L17
    }

    public boolean returnResponse(int r100) {
        HTTPResponse r101 = new HTTPResponse(this.mCastContext);
        r101.setStatusCode(r100);
        r101.setContentLength(0);
        return post(r101);
    }

    public void set(HTTPRequest r100) {
        set(r100);
        setSocket(r100.getSocket());
    }

    public void setMethod(String r100) {
        this.method = r100;
    }

    public void setRequestHost(String r100) {
        this.requestHost = r100;
    }

    public void setRequestPort(int r100) {
        this.requestPort = r100;
    }

    public void setSoTimeout(int r100) {
        this.soTimeout = r100;
    }

    public void setSocket(HTTPSocket r100) {
        this.httpSocket = r100;
    }

    public void setTimeout(int r100) {
        this.timeout = r100;
    }

    public void setURI(String r100) {
        setURI(r100, false);
    }

    public HTTPRequest(ContextManager.CastContext r100, InputStream r101) {
        super(r100, r101);
        this.method = null;
        this.uri = null;
        this.requestHost = "";
        this.requestPort = -1;
        this.httpSocket = null;
        this.timeout = 15000;
        this.soTimeout = 15000;
        this.postSocket = null;
    }

    private boolean isInSameNetwork(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L20:
        return true;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L20;
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        String[] r103 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r102.length != 4) goto L20;
        if (r103.length != 4) goto L20;
        if (TextUtils.equals(r102[0], r103[0]) == true) goto L15;
        return false;
    L15:
        if (TextUtils.equals(r102[1], r103[1]) == true) goto L18;
        return false;
    L18:
        if (TextUtils.equals(r102[2], r103[2]) == true) goto L20;
        return false;
    }

    public HTTPResponse post(String r110, int r111) {
        HTTPResponse r100 = post(r110, r111, false, 0, 0, false);
        if (r100 != null) goto L5;
    L16:
        return r100;
    L5:
        if (r100.isSuccessful() == true) goto L16;
        CommandExecuteStatus r101 = r100.getCommandExecuteStatus();
        if (r101 == null) goto L16;
        if (r101.getPlayErrorCode() == 22530000) goto L13;
        if (r101.getPlayErrorCode() != 22530001) goto L16;
    L13:
        if (isInSameNetwork(r101.getLocalAddrHost(), r110) == true) goto L16;
        return post(r110, r111, false, 0, 0, true);
    }

    public void setURI(String r100, boolean r101) {
        this.uri = r100;
        if (r101 == true) goto L5;
        return;
    L5:
        this.uri = HTTP.toRelativeURL(r100);
    }

    public HTTPRequest(ContextManager.CastContext r100, HTTPSocket r101) {
        this(r100, r101.getInputStream());
        setSocket(r101);
    }

    public HTTPResponse post(String r110, int r111, int r112, int r113) {
        HTTPResponse r100 = post(r110, r111, false, r112, r113, false);
        if (r100 != null) goto L5;
    L16:
        return r100;
    L5:
        if (r100.isSuccessful() == true) goto L16;
        CommandExecuteStatus r101 = r100.getCommandExecuteStatus();
        if (r101 == null) goto L16;
        if (r101.getPlayErrorCode() == 22530000) goto L13;
        if (r101.getPlayErrorCode() != 22530001) goto L16;
    L13:
        if (isInSameNetwork(r101.getLocalAddrHost(), r110) == true) goto L16;
        return post(r110, r111, false, r112, r113, true);
    }

    public HTTPResponse post(Context r100, String r101, String r102, int r110) {
        return post(r100, r101, r102, r110, false);
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    public HTTPResponse post(Context r210, String r211, String r310, int r311, boolean r312) {
        int r100 = r311;
        String r101 = "";
        String r102 = ":";
        String r110 = "ip:";
        String r111 = "PostSocket close failure, ip:";
        HTTPResponse r112 = new HTTPResponse(this.mCastContext);
        setHost(r310);
        if (r312 == false) goto L5;
        String r103 = HTTP.KEEP_ALIVE;
    L6:
        setConnection(r103);
        boolean r104 = isHeadRequest();
        String r212 = "OutputStream close failure, ip:";
        if (this.postSocket == null) goto L405;
        String r105 = ",Exception:";
        String r113 = CastMonitor.HTTP_POST_FAIlURE;
        String r114 = ",cause:";
    L415:
        OutputStream r106 = this.postSocket.getOutputStream();     // Catch: Throwable -> L168 Exception -> L170 IOException -> L172 SocketException -> L176
    L421:
        PrintStream r107 = new PrintStream(r106);     // Catch: Throwable -> L154 Exception -> L158 IOException -> L161 SocketException -> L164
        String r115 = ("" + getHeader()) + "\r\n";     // Catch: Throwable -> L154 Exception -> L158 IOException -> L161 SocketException -> L164
        boolean r116 = isChunked();     // Catch: Throwable -> L154 Exception -> L158 IOException -> L161 SocketException -> L164
        String r117 = getContentString();     // Catch: Throwable -> L154 Exception -> L158 IOException -> L161 SocketException -> L164
        if (r117 != null) goto L409;
        int r118 = 0;
    L93:
        r101 = "";
        if (r118 > 0) goto L96;
        r102 = ":";
    L104:
        boolean r108 = true;
    L105:
        if (r116 != r108) goto L423;
        r115 = (r115 + "0") + "\r\n";     // Catch: Throwable -> L108 Exception -> L110 IOException -> L112 SocketException -> L114
    L114:
        e = move-exception;
        r211 = r211;
        r100 = r311;
        SocketException r109 = e;
        r113 = r113;
        r114 = r114;
    L178:
        InputStream r119 = null;
    L267:
        r212 = r212;
        NetworkInfo r120 = ((ConnectivityManager) r210.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Throwable -> L323
        if (r120 == null) goto L397;
        OutputStream r121 = r106;
    L276:
        if (r120 != null) goto L278;
    L295:
        r105 = r105;
        this.mCastLogger.e("network connected...");     // Catch: Throwable -> L321
    L297:
        r109.printStackTrace();     // Catch: Throwable -> L321
        if ((r109 instanceof ConnectException) == false) goto L300;
        int r122 = 503;
    L301:
        r112.setStatusCode(r122);     // Catch: Throwable -> L321
        CastMonitor r123 = this.mCastMonitor;     // Catch: Throwable -> L321
        StringBuilder r124 = new StringBuilder();     // Catch: Throwable -> L321
        r124.append(r110);     // Catch: Throwable -> L321
        r124.append(r310);     // Catch: Throwable -> L321
        r124.append(r102);     // Catch: Throwable -> L321
        r124.append(r100);     // Catch: Throwable -> L321
        r124.append(",SocketException:");     // Catch: Throwable -> L321
        HTTPResponse r125 = r112;
        r124.append(r109.getMessage());     // Catch: Throwable -> L321
        r124.append(r114);     // Catch: Throwable -> L321
        r124.append(r109.getCause());     // Catch: Throwable -> L321
        r123.sendCustomEvent(r211, r113, r124.toString());     // Catch: Throwable -> L321
        this.mCastLogger.e(r110 + r310 + r102 + r100 + ",SocketException:" + r109.getMessage() + r114 + r109.getCause());     // Catch: Throwable -> L321
        if (r312 == true) goto L431;
        if (r119 != null) goto L349;
    L308:
        String r126 = r105;
    L309:
        if (r121 != null) goto L385;
    L314:
        Socket r127 = this.postSocket;
        if (r127 != null) goto L355;
    L250:
        this.postSocket = null;
        return r125;
    L355:
        r127.close();     // Catch: Exception -> L318
    L318:
        e = move-exception;
        this.mCastMonitor.sendCustomEvent(r211, r113, r111 + r310 + r102 + r100 + r126 + e.getMessage() + r114 + e.getCause());
        goto L250
    L385:
        r121.close();     // Catch: Exception -> L312
    L312:
        e = move-exception;
        this.mCastMonitor.sendCustomEvent(r211, r113, r212 + r310 + r102 + r100 + r126 + e.getMessage() + r114 + e.getCause());
        goto L314
    L349:
        r119.close();     // Catch: Exception -> L306
    L306:
        e = move-exception;
        CastMonitor r128 = this.mCastMonitor;
        StringBuilder r129 = new StringBuilder("InputStream close failure, ip:");
        r129.append(r310);
        r129.append(r102);
        r129.append(r100);
        r126 = r105;
        r129.append(r126);
        r129.append(e.getMessage());
        r129.append(r114);
        r129.append(e.getCause());
        r128.sendCustomEvent(r211, r113, r129.toString());
        goto L309
    L431:
        return r125;
    L300:
        r122 = 501;
    L321:
        th = move-exception;
        r111 = r111;
        r212 = r212;
        r105 = r105;
        Throwable r130 = th;
        r106 = r121;
    L328:
        if (r312 == true) goto L348;
        if (r119 == null) goto L335;
        r119.close();     // Catch: Exception -> L332
    L332:
        e = move-exception;
        this.mCastMonitor.sendCustomEvent(r211, r113, "InputStream close failure, ip:" + r310 + r102 + r100 + r105 + e.getMessage() + r114 + e.getCause());
    L335:
        if (r106 != null) goto L351;
    L340:
        Socket r131 = this.postSocket;
        if (r131 != null) goto L383;
    L346:
        this.postSocket = null;
        throw r130;
    L383:
        r131.close();     // Catch: Exception -> L344
    L344:
        e = move-exception;
        this.mCastMonitor.sendCustomEvent(r211, r113, r111 + r310 + r102 + r100 + r105 + e.getMessage() + r114 + e.getCause());
        goto L346
    L351:
        r106.close();     // Catch: Exception -> L338
    L338:
        e = move-exception;
        this.mCastMonitor.sendCustomEvent(r211, r113, r212 + r310 + r102 + r100 + r105 + e.getMessage() + r114 + e.getCause());
        goto L340
    L348:
        throw r130;
    L278:
        if (r120.isConnected() == true) goto L295;
        this.mCastLogger.e("network disconnected");     // Catch: Throwable -> L293
        this.mCastLogger.e(r120.getDetailedState().toString());     // Catch: Throwable -> L293
        CastLogger r132 = this.mCastLogger;     // Catch: Throwable -> L293
        if (com_byted_cast_linkcommon_cybergarage_http_HTTPRequest_android_net_NetworkInfo_getExtraInfo(r120) != null) goto L282;
        String r133 = r101;
    L283:
        r132.e(r133);     // Catch: Throwable -> L293
        CastLogger r134 = this.mCastLogger;     // Catch: Throwable -> L293
        if (r120.getReason() != null) goto L286;
        String r135 = r101;
    L287:
        r134.e(r135);     // Catch: Throwable -> L293
        CastLogger r136 = this.mCastLogger;     // Catch: Throwable -> L293
        StringBuilder r137 = new StringBuilder();     // Catch: Throwable -> L293
        r105 = r105;
        r137.append("isAvailable=");     // Catch: Throwable -> L291
        r137.append(r120.isAvailable());     // Catch: Throwable -> L291
        r136.e(r137.toString());     // Catch: Throwable -> L291
        this.mCastLogger.e("isConnected=" + r120.isConnected());     // Catch: Throwable -> L291
        this.mCastLogger.e("isConnectedOrConnecting=" + r120.isConnectedOrConnecting());     // Catch: Throwable -> L291
        this.mCastLogger.e("isFailover=" + r120.isFailover());     // Catch: Throwable -> L291
        this.mCastLogger.e("isRoaming=" + r120.isRoaming());     // Catch: Throwable -> L291
    L291:
        th = move-exception;
        r130 = th;
        r106 = r121;
    L254:
        r111 = r111;
        r212 = r212;
        r105 = r105;
    L293:
        th = move-exception;
        r130 = th;
        r106 = r121;
    L260:
        r111 = r111;
        r212 = r212;
        goto L328
    L286:
        r135 = r120.getReason();     // Catch: Throwable -> L293
        goto L287
    L282:
        r133 = com_byted_cast_linkcommon_cybergarage_http_HTTPRequest_android_net_NetworkInfo_getExtraInfo(r120);     // Catch: Throwable -> L293
        goto L283
    L397:
        r121 = r106;
        this.mCastLogger.e("networkInfo == null");     // Catch: Throwable -> L293
    L273:
        th = th;
    L259:
        r130 = th;
    L323:
        Throwable th10 = th;
        r111 = r111;
        r212 = r212;
    L327:
        r130 = th10;
    L112:
        e = move-exception;
        r211 = r211;
        r100 = r311;
        IOException r138 = e;
    L174:
        r119 = null;
    L175:
        r212 = r212;
    L371:
        if ((r138 instanceof SocketTimeoutException) == false) goto L225;
        int r139 = 502;
    L226:
        r212 = r212;
        r112.setStatusCode(r139);     // Catch: Throwable -> L257
        r138.printStackTrace();     // Catch: Throwable -> L257
        CastMonitor r140 = this.mCastMonitor;     // Catch: Throwable -> L257
        r125 = r112;
        StringBuilder r141 = new StringBuilder();     // Catch: Throwable -> L257
        r141.append(r110);     // Catch: Throwable -> L257
        r141.append(r310);     // Catch: Throwable -> L257
        r141.append(r102);     // Catch: Throwable -> L257
        r141.append(r100);     // Catch: Throwable -> L257
        OutputStream r213 = r106;
        r141.append(",IOException:");     // Catch: Throwable -> L255
        r105 = r105;
        r141.append(r138.getMessage());     // Catch: Throwable -> L251
        r141.append(r114);     // Catch: Throwable -> L251
        r141.append(r138.getCause());     // Catch: Throwable -> L251
        r140.sendCustomEvent(r211, r113, r141.toString());     // Catch: Throwable -> L251
        this.mCastLogger.e(r110 + r310 + r102 + r100 + ",IOException:" + r138.getMessage() + r114 + r138.getCause());     // Catch: Throwable -> L251
        if (r312 == true) goto L429;
        if (r119 != null) goto L389;
    L238:
        String r142 = r105;
    L239:
        if (r213 != null) goto L357;
    L244:
        Socket r143 = this.postSocket;
        if (r143 == null) goto L250;
        r143.close();     // Catch: Exception -> L248
    L248:
        e = move-exception;
        this.mCastMonitor.sendCustomEvent(r211, r113, r111 + r310 + r102 + r100 + r142 + e.getMessage() + r114 + e.getCause());
        goto L250
    L357:
        r213.close();     // Catch: Exception -> L242
    L242:
        e = move-exception;
        this.mCastMonitor.sendCustomEvent(r211, r113, r212 + r310 + r102 + r100 + r142 + e.getMessage() + r114 + e.getCause());
        goto L244
    L389:
        r119.close();     // Catch: Exception -> L236
    L236:
        e = move-exception;
        CastMonitor r144 = this.mCastMonitor;
        StringBuilder r145 = new StringBuilder("InputStream close failure, ip:");
        r145.append(r310);
        r145.append(r102);
        r145.append(r100);
        r142 = r105;
        r145.append(r142);
        r145.append(e.getMessage());
        r145.append(r114);
        r145.append(e.getCause());
        r144.sendCustomEvent(r211, r113, r145.toString());
        goto L239
    L429:
        return r125;
    L251:
        Throwable th11 = th;
        r106 = r213;
    L253:
        r130 = th11;
    L255:
        th = th;
        r106 = r213;
    L257:
        th = th;
        goto L259
    L225:
        r139 = 504;
    L261:
        th = move-exception;
        r130 = th;
    L263:
        r111 = r111;
    L110:
        e = move-exception;
        r211 = r211;
        r100 = r311;
        Exception r146 = e;
        r212 = r212;
        r113 = r113;
        r114 = r114;
        r105 = r105;
    L187:
        r119 = null;
    L393:
        r112.setStatusCode(500);     // Catch: Throwable -> L218
        CastMonitor r147 = this.mCastMonitor;     // Catch: Throwable -> L218
        StringBuilder r148 = new StringBuilder();     // Catch: Throwable -> L218
        String r214 = r212;
        r148.append(r110);     // Catch: Throwable -> L215
        r148.append(r310);     // Catch: Throwable -> L215
        r148.append(r102);     // Catch: Throwable -> L215
        r148.append(r100);     // Catch: Throwable -> L215
        r148.append(r105);     // Catch: Throwable -> L215
        OutputStream r215 = r106;
        r148.append(r146.getMessage());     // Catch: Throwable -> L213
        r148.append(r114);     // Catch: Throwable -> L213
        r148.append(r146.getCause());     // Catch: Throwable -> L213
        r147.sendCustomEvent(r211, r113, r148.toString());     // Catch: Throwable -> L213
        this.mCastLogger.e(r110 + r310 + r102 + r100 + r105 + r146.getMessage() + r114 + r146.getCause());     // Catch: Throwable -> L213
        if (r312 == true) goto L428;
        if (r119 != null) goto L359;
    L200:
        if (r215 != null) goto L361;
    L205:
        Socket r149 = this.postSocket;
        if (r149 != null) goto L399;
    L211:
        this.postSocket = null;
        goto L428
    L399:
        r149.close();     // Catch: Exception -> L209
    L209:
        e = move-exception;
        this.mCastMonitor.sendCustomEvent(r211, r113, r111 + r310 + r102 + r100 + r105 + e.getMessage() + r114 + e.getCause());
        goto L211
    L361:
        r215.close();     // Catch: Exception -> L203
    L203:
        e = move-exception;
        this.mCastMonitor.sendCustomEvent(r211, r113, r214 + r310 + r102 + r100 + r105 + e.getMessage() + r114 + e.getCause());
        goto L205
    L359:
        r119.close();     // Catch: Exception -> L198
    L198:
        e = move-exception;
        this.mCastMonitor.sendCustomEvent(r211, r113, "InputStream close failure, ip:" + r310 + r102 + r100 + r105 + e.getMessage() + r114 + e.getCause());
    L428:
        return r112;
    L213:
        th = th;
        r106 = r215;
    L217:
        r130 = th;
        r111 = r111;
        r212 = r214;
    L215:
        th = th;
    L218:
        th = move-exception;
        r130 = th;
        r212 = r212;
    L108:
        th = move-exception;
        r211 = r211;
        r100 = r311;
        r130 = th;
    L157:
        r105 = r105;
    L183:
        r119 = null;
    L423:
        r107.print(r115);     // Catch: Throwable -> L146 Exception -> L148 IOException -> L150 SocketException -> L152
        r107.flush();     // Catch: Throwable -> L146 Exception -> L148 IOException -> L150 SocketException -> L152
        r119 = this.postSocket.getInputStream();     // Catch: Throwable -> L146 Exception -> L148 IOException -> L150 SocketException -> L152
        r112.set(r119, r104);     // Catch: Throwable -> L138 Exception -> L140 IOException -> L142 SocketException -> L144
        if (r312 == true) goto L320;
        if (r119 != null) goto L373;
    L124:
        String r150 = r211;
        int r151 = r311;
        String r152 = r113;
        String r153 = r114;
        String r154 = r105;
    L125:
        if (r106 != null) goto L353;
    L130:
        Socket r155 = this.postSocket;
        if (r155 != null) goto L377;
    L136:
        this.postSocket = null;
        goto L320
    L377:
        r155.close();     // Catch: Exception -> L134
    L134:
        e = move-exception;
        this.mCastMonitor.sendCustomEvent(r150, r152, r111 + r310 + r102 + r151 + r154 + e.getMessage() + r153 + e.getCause());
        goto L136
    L353:
        r106.close();     // Catch: Exception -> L128
    L128:
        e = move-exception;
        this.mCastMonitor.sendCustomEvent(r150, r152, r212 + r310 + r102 + r151 + r154 + e.getMessage() + r153 + e.getCause());
        goto L130
    L373:
        r119.close();     // Catch: Exception -> L122
    L122:
        e = move-exception;
        CastMonitor r156 = this.mCastMonitor;
        StringBuilder r157 = new StringBuilder("InputStream close failure, ip:");
        r157.append(r310);
        r157.append(r102);
        r151 = r311;
        r157.append(r151);
        r154 = r105;
        r157.append(r154);
        r157.append(e.getMessage());
        r153 = r114;
        r157.append(r153);
        r157.append(e.getCause());
        String r158 = r157.toString();
        r150 = r211;
        r152 = r113;
        r156.sendCustomEvent(r150, r152, r158);
    L320:
        return r112;
    L144:
        e = move-exception;
        r211 = r211;
        r100 = r311;
        r113 = r113;
        r114 = r114;
        r109 = e;
        r110 = r110;
        r105 = r105;
    L142:
        e = move-exception;
        r211 = r211;
        r100 = r311;
        r113 = r113;
        r114 = r114;
        r105 = r105;
        r138 = e;
        r110 = r110;
    L140:
        e = e;
        r211 = r211;
        r100 = r311;
        r212 = r212;
        r113 = r113;
        r114 = r114;
        r105 = r105;
    L69:
        r146 = e;
    L138:
        th11 = th;
        r211 = r211;
        r100 = r311;
        r113 = r113;
        r114 = r114;
        goto L253
    L152:
        e = e;
        r100 = r311;
    L166:
        r109 = e;
    L150:
        e = e;
        r100 = r311;
    L163:
        r138 = e;
    L148:
        e = e;
        r100 = r311;
    L160:
        r212 = r212;
        r113 = r113;
        r114 = r114;
        r105 = r105;
        r146 = e;
    L146:
        th = th;
        r100 = r311;
    L156:
        r130 = th;
        goto L157
    L96:
        if (r116 != true) goto L99;
        r102 = ":";
        r115 = (r115 + Long.toHexString(r118)) + "\r\n";     // Catch: Throwable -> L108 Exception -> L110 IOException -> L112 SocketException -> L114
    L100:
        r115 = r115 + r117;     // Catch: Throwable -> L108 Exception -> L110 IOException -> L112 SocketException -> L114
        r108 = true;
        if (r116 != true) goto L105;
        r115 = r115 + "\r\n";     // Catch: Throwable -> L108 Exception -> L110 IOException -> L112 SocketException -> L114
        goto L104
    L99:
        r102 = ":";
        goto L100
    L409:
        r118 = r117.length();     // Catch: Throwable -> L84 Exception -> L86 IOException -> L88 SocketException -> L90
    L90:
        e = e;
        r211 = r211;
        r100 = r100;
        r101 = "";
        r110 = r110;
        r113 = r113;
        r114 = r114;
        r105 = r105;
    L77:
        r119 = null;
        r102 = ":";
        r109 = e;
    L88:
        e = e;
        r211 = r211;
        r100 = r100;
        r102 = ":";
        r110 = r110;
        r113 = r113;
        r114 = r114;
        r105 = r105;
    L73:
        r119 = null;
        r138 = e;
    L86:
        e = e;
        r211 = r211;
        r100 = r100;
        r102 = ":";
        r212 = r212;
        r113 = r113;
        r114 = r114;
        r105 = r105;
    L68:
        r119 = null;
    L84:
        th10 = th;
        r211 = r211;
        r100 = r100;
        r102 = ":";
        r111 = r111;
        r212 = r212;
        r113 = r113;
        r114 = r114;
        r105 = r105;
    L64:
        r119 = null;
        goto L327
    L164:
        e = e;
        r100 = r100;
        r101 = "";
        r102 = ":";
    L161:
        e = e;
        r100 = r100;
        r102 = ":";
    L158:
        e = e;
        r100 = r100;
        r102 = ":";
    L154:
        th = th;
        r100 = r100;
        r102 = ":";
    L176:
        e = move-exception;
        r211 = r211;
        r100 = r100;
        r101 = "";
        r113 = r113;
        r114 = r114;
        r102 = ":";
        r109 = e;
        r110 = r110;
        r106 = null;
    L172:
        e = move-exception;
        r211 = r211;
        r100 = r100;
        r102 = ":";
        r138 = e;
        r106 = null;
    L170:
        e = e;
        r211 = r211;
        r113 = r113;
        r114 = r114;
        r105 = r105;
    L186:
        r146 = e;
        r106 = null;
    L168:
        th = move-exception;
        r211 = r211;
        r113 = r113;
        r114 = r114;
        r130 = th;
        r105 = r105;
    L182:
        r106 = null;
        goto L183
    L405:
        this.postSocket = new Socket();     // Catch: Throwable -> L61 Exception -> L65 IOException -> L70 SocketException -> L74
        boolean r159 = ContextManager.getConfigManager(this.mCastContext).getInitConfig().isEnableBdlinkMultipleIpCorrect();     // Catch: Throwable -> L61 Exception -> L65 IOException -> L70 SocketException -> L74
        CastLogger r160 = this.mCastLogger;     // Catch: Throwable -> L61 Exception -> L65 IOException -> L70 SocketException -> L74
        r113 = CastMonitor.HTTP_POST_FAIlURE;
        r114 = ",cause:";
        r160.d(TAG, "enableBdlinkMultipleIpCorrect is " + r159);     // Catch: Throwable -> L45 Exception -> L47 IOException -> L49 SocketException -> L51
        if (r159 == false) goto L34;
        List<String> r161 = NetworkUtil.getLocalIpAddr(this.mCastContext);     // Catch: Throwable -> L45 Exception -> L47 IOException -> L49 SocketException -> L51
        if (r161 != null) goto L18;
    L30:
        String r162 = "";
    L31:
        CastLogger r163 = this.mCastLogger;     // Catch: Throwable -> L45 Exception -> L47 IOException -> L49 SocketException -> L51
        String r164 = TAG;     // Catch: Throwable -> L45 Exception -> L47 IOException -> L49 SocketException -> L51
        StringBuilder r165 = new StringBuilder();     // Catch: Throwable -> L45 Exception -> L47 IOException -> L49 SocketException -> L51
        r105 = ",Exception:";
        r165.append("sameWifiIp is ");     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41 SocketException -> L43
        r165.append(r162);     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41 SocketException -> L43
        r165.append(", host is ");     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41 SocketException -> L43
        r165.append(r310);     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41 SocketException -> L43
        r165.append(", localIpAddress is ");     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41 SocketException -> L43
        r165.append(r161);     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41 SocketException -> L43
        r163.d(r164, r165.toString());     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41 SocketException -> L43
    L35:
        this.postSocket.setSoTimeout(15000);     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41 SocketException -> L43
        this.postSocket.connect(new InetSocketAddress(r310, r100), this.timeout);     // Catch: Throwable -> L37 Exception -> L39 IOException -> L41 SocketException -> L43
    L43:
        e = e;
        r113 = r113;
        r114 = r114;
        r105 = r105;
    L76:
        r106 = null;
    L41:
        e = e;
        r113 = r113;
        r114 = r114;
        r105 = r105;
    L72:
        r106 = null;
    L39:
        e = e;
        r113 = r113;
        r114 = r114;
        r105 = r105;
    L67:
        r106 = null;
    L37:
        th10 = th;
        r113 = r113;
        r114 = r114;
        r105 = r105;
    L63:
        r106 = null;
        goto L64
    L18:
        if (r161.size() <= 1) goto L30;
        Iterator<String> r166 = r161.iterator();     // Catch: Throwable -> L45 Exception -> L47 IOException -> L49 SocketException -> L51
    L21:
        if (r166.hasNext() == false) goto L25;
        r162 = r166.next();     // Catch: Throwable -> L45 Exception -> L47 IOException -> L49 SocketException -> L51
        if (NetworkUtil.isSameLocalNetworkWithoutMask(r162, r310) == false) goto L21;
    L27:
        if (TextUtils.isEmpty(r162) == true) goto L31;
        this.postSocket.bind(new InetSocketAddress(r162, 0));     // Catch: Throwable -> L45 Exception -> L47 IOException -> L49 SocketException -> L51
        goto L31
    L25:
        r162 = "";
        goto L27
    L34:
        r105 = ",Exception:";
    L51:
        e = e;
        r105 = ",Exception:";
        r113 = r113;
        r114 = r114;
    L49:
        e = e;
        r105 = ",Exception:";
        r113 = r113;
        r114 = r114;
    L47:
        e = e;
        r105 = ",Exception:";
        r113 = r113;
        r114 = r114;
    L45:
        th10 = th;
        r105 = ",Exception:";
        r113 = r113;
        r114 = r114;
        goto L63
    L59:
        e = e;
        r105 = ",Exception:";
        r114 = ",cause:";
        r113 = r113;
    L57:
        e = e;
        r105 = ",Exception:";
        r114 = ",cause:";
        r113 = r113;
    L55:
        e = e;
        r105 = ",Exception:";
        r114 = ",cause:";
        r113 = r113;
    L53:
        th10 = th;
        r105 = ",Exception:";
        r114 = ",cause:";
        r113 = r113;
        goto L63
    L74:
        e = e;
        r105 = ",Exception:";
        r113 = CastMonitor.HTTP_POST_FAIlURE;
        r114 = ",cause:";
    L70:
        e = e;
        r105 = ",Exception:";
        r113 = CastMonitor.HTTP_POST_FAIlURE;
        r114 = ",cause:";
    L65:
        e = e;
        r105 = ",Exception:";
        r113 = CastMonitor.HTTP_POST_FAIlURE;
        r114 = ",cause:";
    L61:
        th10 = th;
        r105 = ",Exception:";
        r113 = CastMonitor.HTTP_POST_FAIlURE;
        r114 = ",cause:";
        goto L63
    L264:
        e = move-exception;
        r211 = r211;
        r100 = r100;
        r101 = "";
        r105 = ",Exception:";
        r113 = CastMonitor.HTTP_POST_FAIlURE;
        r114 = ",cause:";
        r110 = r110;
        r102 = ":";
        r109 = e;
        r106 = null;
        r119 = null;
    L220:
        e = move-exception;
        r211 = r211;
        r100 = r100;
        r102 = ":";
        r105 = ",Exception:";
        r113 = CastMonitor.HTTP_POST_FAIlURE;
        r114 = ",cause:";
        r110 = r110;
        r212 = r212;
        r138 = e;
        r106 = null;
        r119 = null;
    L184:
        e = e;
        r211 = r211;
        r105 = ",Exception:";
        r113 = CastMonitor.HTTP_POST_FAIlURE;
        r114 = ",cause:";
    L180:
        th = move-exception;
        r211 = r211;
        r105 = ",Exception:";
        r113 = CastMonitor.HTTP_POST_FAIlURE;
        r114 = ",cause:";
        r130 = th;
        goto L182
    L5:
        r103 = "close";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.byted.cast.linkcommon.cybergarage.http.HTTPPacket, com.byted.cast.linkcommon.cybergarage.http.HTTPRequest] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public HTTPResponse post(String r110, int r111, boolean r112, int r113, int r210, boolean r211) {
        int r100 = r111;
        ?? r101 = "post hostAddr is :";
        if (r100 < 0) goto L6;
        ?? r102 = r100;
        if (r100 > 65535) goto L6;
    L7:
        HTTPResponse r103 = new HTTPResponse(this.mCastContext);
        setHost(r110, r102);
        if (r112 == false) goto L10;
        String r104 = HTTP.KEEP_ALIVE;
    L11:
        setConnection(r104);
        boolean r105 = isHeadRequest();
        monitor-enter(this);
        String r106 = "";
        int r114 = 0;
        if (this.postSocket != null) goto L35;
        this.postSocket = new Socket();     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L95 SocketException -> L113
        if (r211 == false) goto L22;
        String r115 = getLocalHost(r110);     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L95 SocketException -> L113
        if (TextUtils.isEmpty(r115) == true) goto L22;
        this.postSocket.bind(new InetSocketAddress(r115, 0));     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L95 SocketException -> L113
        this.mCastLogger.d(TAG, "post hostAddr is :" + r115);     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L95 SocketException -> L113
    L22:
        Socket r107 = this.postSocket;     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L95 SocketException -> L113
        InetSocketAddress r116 = new InetSocketAddress(r110, r102);     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L95 SocketException -> L113
        int r108 = 20000;
        if (r113 > 0) goto L25;
        int r109 = 20000;
    L26:
        r107.connect(r116, r109);     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L95 SocketException -> L113
        Socket r117 = this.postSocket;     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L95 SocketException -> L113
        if (r210 <= 0) goto L30;
        r108 = r210;
    L30:
        r117.setSoTimeout(r108);     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L95 SocketException -> L113
        InetAddress r118 = this.postSocket.getLocalAddress();     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L95 SocketException -> L113
        if (r118 == null) goto L35;
        r106 = r118.getHostAddress();     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L95 SocketException -> L113
        if (TextUtils.isEmpty(r106) == true) goto L35;
        r106.replaceAll(HTTP.URL_DEFAULT, "");     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L95 SocketException -> L113
        goto L35
    L25:
        r109 = r113;
    L35:
        r102 = this.postSocket.getOutputStream();     // Catch: Throwable -> L75 IOException -> L77 SocketTimeoutException -> L95 SocketException -> L113
        PrintStream r119 = new PrintStream(r102);     // Catch: Throwable -> L67 IOException -> L69 SocketTimeoutException -> L71 SocketException -> L73
        String r120 = ("" + getHeader()) + "\r\n";     // Catch: Throwable -> L67 IOException -> L69 SocketTimeoutException -> L71 SocketException -> L73
        boolean r121 = isChunked();     // Catch: Throwable -> L67 IOException -> L69 SocketTimeoutException -> L71 SocketException -> L73
        String r122 = getContentString();     // Catch: Throwable -> L67 IOException -> L69 SocketTimeoutException -> L71 SocketException -> L73
        if (r122 == null) goto L39;
        r114 = r122.length();     // Catch: Throwable -> L67 IOException -> L69 SocketTimeoutException -> L71 SocketException -> L73
    L39:
        if (r114 <= 0) goto L45;
        if (r121 == false) goto L42;
        r120 = (r120 + Long.toHexString(r114)) + "\r\n";     // Catch: Throwable -> L67 IOException -> L69 SocketTimeoutException -> L71 SocketException -> L73
    L42:
        r120 = r120 + r122;     // Catch: Throwable -> L67 IOException -> L69 SocketTimeoutException -> L71 SocketException -> L73
        if (r121 == false) goto L45;
        r120 = r120 + "\r\n";     // Catch: Throwable -> L67 IOException -> L69 SocketTimeoutException -> L71 SocketException -> L73
    L45:
        if (r121 == false) goto L47;
        r120 = (r120 + "0") + "\r\n";     // Catch: Throwable -> L67 IOException -> L69 SocketTimeoutException -> L71 SocketException -> L73
    L47:
        r119.print(r120);     // Catch: Throwable -> L67 IOException -> L69 SocketTimeoutException -> L71 SocketException -> L73
        r119.flush();     // Catch: Throwable -> L67 IOException -> L69 SocketTimeoutException -> L71 SocketException -> L73
        InputStream r123 = this.postSocket.getInputStream();     // Catch: Throwable -> L67 IOException -> L69 SocketTimeoutException -> L71 SocketException -> L73
        r103.set(r123, r105);     // Catch: IOException -> L61 SocketTimeoutException -> L63 SocketException -> L65 Throwable -> L133
        if (r112 == true) goto L56;
        if (r123 != null) goto L157;
    L54:
        if (r102 == 0) goto L56;
        r102.close();     // Catch: Exception -> L149 Throwable -> L146
        goto L56
    L157:
        r123.close();     // Catch: Exception -> L53 Throwable -> L146
    L56:
        Socket r124 = this.postSocket;     // Catch: Throwable -> L146
        if (r124 == null) goto L131;
        r124.close();     // Catch: Exception -> L150 Throwable -> L146
    L159:
    L131:
        monitor-exit(this);     // Catch: Throwable -> L146
        return r103;
    L65:
        e = e;
    L115:
        r103.setStatusCode(500);     // Catch: Throwable -> L133
        Debug.warning(e);     // Catch: Throwable -> L133
        CommandExecuteStatus r125 = new CommandExecuteStatus();     // Catch: Throwable -> L133
        r125.setPlayErrorCode(IPlayerListener.ERROR_CODE_BDDLNA_PLAY_SOCKET_EXCEPTION);     // Catch: Throwable -> L133
        if (e.getCause() == null) goto L118;
        r125.setDescription(e.getCause().toString());     // Catch: Throwable -> L133
    L119:
        r125.setException(e.getLocalizedMessage());     // Catch: Throwable -> L133
        r125.setLocalAddrHost(r106);     // Catch: Throwable -> L133
        r103.setCommandExecuteStatus(r125);     // Catch: Throwable -> L133
        if (r112 == true) goto L127;
        if (r123 != null) goto L164;
    L125:
        if (r102 == 0) goto L127;
        r102.close();     // Catch: Exception -> L153 Throwable -> L146
        goto L127
    L164:
        r123.close();     // Catch: Exception -> L124 Throwable -> L146
    L127:
        Socket r126 = this.postSocket;     // Catch: Throwable -> L146
        if (r126 == null) goto L131;
        r126.close();     // Catch: Exception -> L150 Throwable -> L146
        goto L159
    L118:
        r125.setDescription(IPlayerListener.ERROR_MSG_BDDLNA_PLAY_SOCKET_EXCEPTION);     // Catch: Throwable -> L133
    L63:
        e = e;
    L97:
        r103.setStatusCode(500);     // Catch: Throwable -> L133
        Debug.warning(e);     // Catch: Throwable -> L133
        CommandExecuteStatus r127 = new CommandExecuteStatus();     // Catch: Throwable -> L133
        r127.setPlayErrorCode(IPlayerListener.ERROR_CODE_BDDLNA_PLAY_SOCKET_TIMEOUT);     // Catch: Throwable -> L133
        if (e.getCause() == null) goto L100;
        r127.setDescription(e.getCause().toString());     // Catch: Throwable -> L133
    L101:
        r127.setException(e.getLocalizedMessage());     // Catch: Throwable -> L133
        r127.setLocalAddrHost(r106);     // Catch: Throwable -> L133
        r103.setCommandExecuteStatus(r127);     // Catch: Throwable -> L133
        if (r112 == true) goto L109;
        if (r123 != null) goto L172;
    L107:
        if (r102 == 0) goto L109;
        r102.close();     // Catch: Exception -> L152 Throwable -> L146
        goto L109
    L172:
        r123.close();     // Catch: Exception -> L106 Throwable -> L146
    L109:
        Socket r128 = this.postSocket;     // Catch: Throwable -> L146
        if (r128 == null) goto L131;
        r128.close();     // Catch: Exception -> L150 Throwable -> L146
        goto L159
    L100:
        r127.setDescription(IPlayerListener.ERROR_MSG_BDDLNA_PLAY_SOCKET_TIMEOUT);     // Catch: Throwable -> L133
    L61:
        e = e;
    L79:
        r103.setStatusCode(500);     // Catch: Throwable -> L133
        Debug.warning(e);     // Catch: Throwable -> L133
        CommandExecuteStatus r129 = new CommandExecuteStatus();     // Catch: Throwable -> L133
        r129.setPlayErrorCode(IPlayerListener.ERROR_CODE_BDDLNA_PLAY_IO_EXCEPTION);     // Catch: Throwable -> L133
        if (e.getCause() == null) goto L82;
        r129.setDescription(e.getCause().toString());     // Catch: Throwable -> L133
    L83:
        r129.setException(e.getLocalizedMessage());     // Catch: Throwable -> L133
        r103.setCommandExecuteStatus(r129);     // Catch: Throwable -> L133
        if (r112 == true) goto L91;
        if (r123 != null) goto L178;
    L89:
        if (r102 == 0) goto L91;
        r102.close();     // Catch: Exception -> L151 Throwable -> L146
        goto L91
    L178:
        r123.close();     // Catch: Exception -> L88 Throwable -> L146
    L91:
        Socket r130 = this.postSocket;     // Catch: Throwable -> L146
        if (r130 == null) goto L131;
        r130.close();     // Catch: Exception -> L150 Throwable -> L146
        goto L159
    L82:
        r129.setDescription(IPlayerListener.ERROR_MSG_BDDLNA_PLAY_IO_EXCEPTION);     // Catch: Throwable -> L133
        goto L83
    L73:
        e = e;
        r123 = null;
    L71:
        e = e;
        r123 = null;
    L69:
        e = e;
        r123 = null;
    L67:
        th = th;
        r101 = 0;
    L134:
        if (r112 == true) goto L141;
        if (r101 != 0) goto L174;
    L139:
        if (r102 == 0) goto L141;
        r102.close();     // Catch: Exception -> L154 Throwable -> L146
        goto L141
    L174:
        r101.close();     // Catch: Exception -> L138 Throwable -> L146
    L141:
        Socket r131 = this.postSocket;     // Catch: Throwable -> L146
        if (r131 == null) goto L187;
        r131.close();     // Catch: Exception -> L155 Throwable -> L146
    L144:
        this.postSocket = null;     // Catch: Throwable -> L146
        throw th;     // Catch: Throwable -> L146
    L187:
        throw th;     // Catch: Throwable -> L146
    L133:
        th = th;
    L146:
        th = move-exception;
        throw th;
    L113:
        e = e;
        r102 = 0;
        r123 = null;
    L95:
        e = e;
        r102 = 0;
        r123 = null;
    L77:
        e = e;
        r102 = 0;
        r123 = null;
    L75:
        th = th;
        r102 = 0;
        r101 = 0;
    L59:
        this.postSocket = null;     // Catch: Throwable -> L146
        goto L131
    L10:
        r104 = "close";
    L6:
        r102 = 80;
        goto L7
    }
}
