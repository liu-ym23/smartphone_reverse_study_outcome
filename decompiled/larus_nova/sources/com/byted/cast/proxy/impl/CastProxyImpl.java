package com.byted.cast.proxy.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.proxy.CastProxyMediaType;
import com.byted.cast.proxy.CastProxyMonitor;
import com.byted.cast.proxy.CastProxyOutputResolution;
import com.byted.cast.proxy.CastProxyType;
import com.byted.cast.proxy.Config;
import com.byted.cast.proxy.ErrorCode;
import com.byted.cast.proxy.Event;
import com.byted.cast.proxy.ILogger;
import com.byted.cast.proxy.IMonitor;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes39.dex */
public class CastProxyImpl {
    private static final String TAG = "CastProxy";
    private String appId;
    private Context context;
    private boolean enableDebug;
    private HttpServer httpServer;
    private ILogger logger;
    private IMonitor monitor;
    private int port;
    private CastProxyType type;

    public String getVersion() {
        return "1.0.0";
    }

    private int getPortValue() {
        return this.context.getSharedPreferences("ByteCastLMS", 0).getInt("port", 0);
    }

    public boolean stop() {
        if (this.httpServer != null) goto L6;
        return true;
    L6:
        long r100 = System.currentTimeMillis();
        boolean r101 = this.httpServer.stop();
        long r102 = System.currentTimeMillis();
        notifyEvent(Event.BYTECAST_CASTPROXY_STOP, new Event(this.context, this.appId, r102 - r100, r101));
        if (r101 == true) goto L9;
        CastProxyMonitor.getInstance().notifyError(ErrorCode.ERROR_CODE_FAILED_TO_STOP, ErrorCode.ERROR_MSG_FAILED_TO_STOP);
    L9:
        return r101;
    }

    public CastProxyImpl() {
        this.logger = new AnonymousClass1(this);
    }

    private int checkDefaultPort() {
        ServerSocket r100 = null;
        ServerSocket r101 = new ServerSocket(getPortValue());     // Catch: Throwable -> L15 IOException -> L35
        int r102 = r101.getLocalPort();     // Catch: Throwable -> L12 IOException -> L14
        r101.close();     // Catch: IOException -> L7
    L11:
        return r102;
    L7:
        e = move-exception;
        e.printStackTrace();
        if (this.monitor == null) goto L11;
        this.monitor.onException("socket close fail. ", e);
        goto L11
    L14:
        r100 = r101;
    L12:
        Throwable th10 = th;
    L27:
        if (r101 != null) goto L42;
    L34:
        throw th10;
    L42:
        r101.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        if (this.monitor == null) goto L34;
        this.monitor.onException("socket close fail. ", e);
    L15:
        th = move-exception;
        r101 = r100;
        th10 = th;
    L17:
        printDebugInfo("Couldn't assign port to your service.");     // Catch: Throwable -> L15
        if (r100 == null) goto L47;
        r100.close();     // Catch: IOException -> L21
        return -1;
    L21:
        e = move-exception;
        e.printStackTrace();
        if (this.monitor == null) goto L48;
        this.monitor.onException("socket close fail. ", e);
        return -1;
    L48:
        return -1;
    L47:
        return -1;
    }

    private int findAvaiablePort() {
        ServerSocket r100 = new ServerSocket(0);     // Catch: Throwable -> L14 IOException -> L16
        int r101 = r100.getLocalPort();     // Catch: IOException -> L12 Throwable -> L30
        r100.close();     // Catch: IOException -> L7
    L11:
        return r101;
    L7:
        e = move-exception;
        e.printStackTrace();
        if (this.monitor == null) goto L11;
        this.monitor.onException("socket close fail. ", e);
    L12:
        IOException e100 = e;
    L18:
        printDebugInfo("Couldn't assign port to your service.");     // Catch: Throwable -> L30
        IMonitor r102 = this.monitor;     // Catch: Throwable -> L30
        if (r102 == null) goto L21;
        r102.onException("Couldn't assign port to your service. ", e100);     // Catch: Throwable -> L30
    L21:
        if (r100 == null) goto L50;
        r100.close();     // Catch: IOException -> L24
        return -1;
    L24:
        e = move-exception;
        e.printStackTrace();
        if (this.monitor == null) goto L51;
        this.monitor.onException("socket close fail. ", e);
        return -1;
    L51:
        return -1;
    L50:
        return -1;
    L30:
        Throwable th10 = th;
    L31:
        if (r100 != null) goto L39;
    L38:
        throw th10;
    L39:
        r100.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
        if (this.monitor == null) goto L38;
        this.monitor.onException("socket close fail. ", e);
        goto L38
    L16:
        e = move-exception;
        r100 = null;
        e100 = e;
    L14:
        th = move-exception;
        r100 = null;
        th10 = th;
        goto L31
    }

    private int getHttpServerPort() {
        int r100 = checkDefaultPort();
        if ((-1) == r100) goto L5;
        return r100;
    L5:
        return findAvaiablePort();
    }

    public static String getIpAddressString() {
        Enumeration<NetworkInterface> r100 = NetworkInterface.getNetworkInterfaces();     // Catch: SocketException -> L14
    L4:
        if (r100.hasMoreElements() == false) goto L27;
        Enumeration<InetAddress> r101 = r100.nextElement().getInetAddresses();     // Catch: SocketException -> L14
    L7:
        if (r101.hasMoreElements() == false) goto L4;
        InetAddress r102 = r101.nextElement();     // Catch: SocketException -> L14
        if ((r102 instanceof Inet4Address) == false) goto L7;
        if (r102.isLoopbackAddress() == true) goto L7;
        return r102.getHostAddress();
    L27:
        return "0.0.0.0";
    L14:
        e = move-exception;
        e.printStackTrace();
        return "0.0.0.0";
    }

    private String encodeUrl(String r100) throws Exception {
        SecretKey r101 = EncryptUtils.generateAes128Key();
        byte[] r102 = EncryptUtils.encrypt(r100, r101.getEncoded());
        byte[] r103 = EncryptUtils.hmac(r100);
        byte[] r104 = AdBaseConstants.BYTEDANCE_PACKAGE_NAME_SUFFIX.getBytes("UTF-8");
        printDebugInfo("prefixKey length is " + r104.length + ", hashData length is " + r103.length);
        byte[] r105 = new byte[32];
        System.arraycopy(r104, 0, r105, 0, r104.length);
        System.arraycopy(r103, 2, r105, r104.length, 32 - r104.length);
        byte[] r106 = EncryptUtils.encrypt(r101.getEncoded(), r105);
        byte[] r107 = new byte[(r106.length + r102.length) + r103.length];
        System.arraycopy(r106, 0, r107, 0, r106.length);
        System.arraycopy(r102, 0, r107, r106.length, r102.length);
        System.arraycopy(r103, 0, r107, r106.length + r102.length, r103.length);
        return EncryptUtils.urlEncoded(Base64.encodeToString(r107, 8));
    }

    private CastProxyMediaType getMediaTypeByPath(String r100) {
        printDebugInfo("getMediaTypeByPath path is " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return null;
    L6:
        if (r100.endsWith("m3u8") == false) goto L10;
        return CastProxyMediaType.M3U8;
    L10:
        if (r100.endsWith("flv") == false) goto L14;
        return CastProxyMediaType.FLV;
    L14:
        if (r100.endsWith("mp4") == true) goto L16;
        return null;
    L16:
        return CastProxyMediaType.MP4;
    }

    private void printDebugInfo(String r100) {
        if (this.enableDebug == false) goto L8;
        ILogger r101 = this.logger;
        if (r101 == null) goto L9;
        r101.onDebug("CastProxy", r100);
        return;
    L9:
        return;
    }

    private void printErrorInfo(String r100) {
        ILogger r101 = this.logger;
        if (r101 == null) goto L6;
        r101.onError("CastProxy", r100);
        return;
    }

    private void printWarnInfo(String r100) {
        ILogger r101 = this.logger;
        if (r101 == null) goto L6;
        r101.onWarn("CastProxy", r100);
        return;
    }

    private void setPortValue(int r100) {
        SharedPreferences.Editor r101 = this.context.getSharedPreferences("ByteCastLMS", 0).edit();
        r101.putInt("port", r100);
        r101.apply();
    }

    public String getFileExtensionFromUrl(String r100) {
        String r101 = new URL(r100).getPath();     // Catch: Exception -> L7
        String r102 = r101.substring(r101.lastIndexOf(47) + 1);     // Catch: Exception -> L7
        if (r102.contains(".") == false) goto L12;
        return r102.substring(r102.lastIndexOf(".") + 1);
    L12:
        return "";
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    private void notifyEvent(String r100, Event r101) {
        IMonitor r102 = this.monitor;
        if (r102 == null) goto L5;
        r102.onEvent(r100, r101);
    L5:
        HashMap r103 = new HashMap();
        r103.put("success", String.valueOf(r101.success));
        r103.put("url_type", r101.proxyUrlType);
        r103.put("encrypt_type", r101.urlEncryptType);
        CastProxyMonitor.getInstance().notifyEvent(r100, r103);
    }

    public String getLocalUrl(String r100, String r101) {
        printDebugInfo("getLocalUrl");
        if (TextUtils.isEmpty(r101) == false) goto L6;
        printWarnInfo("remote ip is null");
        String r102 = "http://" + Utils.getDefaultLocalIpAddr() + ":" + this.port + r100;
        printDebugInfo("local url:" + r102);
        return r102;
    L6:
        String r103 = Utils.getConnectionIP(r101);
        if (TextUtils.isEmpty(r103) == false) goto L10;
        printWarnInfo("failed to get local ip");
        CastProxyMonitor.getInstance().notifyError(ErrorCode.ERROR_CODE_FAILED_TO_GET_LOCAL_IP, ErrorCode.ERROR_MSG_FAILED_TO_GET_LOCAL_IP);
        return "";
    L10:
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 34) goto L14;
        boolean r105 = Utils.hasPermissions(this.context, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED");
    L17:
        if (r105 == true) goto L20;
        printWarnInfo("not have read permission");
        CastProxyMonitor.getInstance().notifyError(ErrorCode.ERROR_CODE_DOES_NOT_HAVE_READ_PERMISSION, ErrorCode.ERROR_MSG_DOES_NOT_HAVE_READ_PERMISSION);
        return "";
    L20:
        String r106 = "http://" + r103 + ":" + this.port + r100;
        printDebugInfo("local url:" + r106);
        return r106;
    L14:
        if (r104 < 33) goto L16;
        r105 = Utils.hasPermissions(this.context, BaseConstants.PERMISSION_READ_MEDIA_VIDEO);
        goto L17
    L16:
        r105 = Utils.hasPermissions(this.context, "android.permission.READ_EXTERNAL_STORAGE");
        goto L17
    }

    public boolean start(Context r110, Config r111) {
        boolean r100 = false;
        if (r110 == null) goto L42;
        if (r111 == null) goto L42;
        CastProxyMonitor.getInstance().init(r110, r111);
        long r101 = System.currentTimeMillis();
        this.context = r110;
        Utils.network = r111.getNetwork();
        this.port = getHttpServerPort();
        this.httpServer = new HttpServer(r110, this.port, r111);
        String r102 = r111.getProxy();
        if (TextUtils.isEmpty(r102) == true) goto L9;
        this.httpServer.setProxy(r102);
    L9:
        this.appId = r111.getAppId();
        this.type = r111.getCastProxyType();
        this.enableDebug = r111.isEnableDebug();
        this.logger = r111.getLogger();
        this.monitor = r111.getMonitor();
        if (r111.getDiscardFrameDelay() <= 0) goto L13;
        Utils.discardFrameDelay = r111.getDiscardFrameDelay();
    L13:
        if (r111.isAVFrameOpt() == false) goto L16;
        Utils.isAVFrameOpt = r111.isAVFrameOpt();
    L16:
        if (r111.isOpenInputOpt() == false) goto L19;
        Utils.isOpenInputOpt = r111.isOpenInputOpt();
    L19:
        if (r111.getSwitchSocketOptimization() == false) goto L30;
        Utils.switchSocketOptimization = r111.getSwitchSocketOptimization();
        if (r111.getSocketTimeout() <= 0) goto L24;
        Utils.socketTimeout = r111.getSocketTimeout();
    L24:
        if (r111.getSocketBufferLength() <= 0) goto L27;
        Utils.socketBufferLength = r111.getSocketBufferLength();
    L27:
        if (r111.getQueueLength() <= 0) goto L29;
        Utils.queueLength = r111.getQueueLength();
        goto L30
    L29:
        Utils.queueLength = BmLocated.HALF_LEFT_BOTTOM;
    L30:
        ILogger r103 = this.logger;
        if (r103 == null) goto L44;
        r103.onInfo("CastProxy", "discardFrameDelay: " + r111.getDiscardFrameDelay());
    L44:
        this.httpServer.start();     // Catch: IOException -> L35
        setPortValue(this.port);     // Catch: IOException -> L35
        r100 = true;
    L37:
        notifyEvent(Event.BYTECAST_CASTPROXY_START, new Event(r110, this.appId, System.currentTimeMillis() - r101, r100));
        if (r100 == true) goto L40;
        CastProxyMonitor.getInstance().notifyError(ErrorCode.ERROR_CODE_FAILED_TO_START, ErrorCode.ERROR_MSG_FAILED_TO_START);
    L40:
        printDebugInfo("http://" + Utils.getConnectionIP(getIpAddressString()) + ":" + this.port);
        return r100;
    L35:
        e = move-exception;
        e.printStackTrace();
    L42:
        printErrorInfo("context and config cannot be null");
        return false;
    }

    public String proxyUrl(String r110, String r111, String r112, String r113) {
        long r100 = System.currentTimeMillis();
        if (TextUtils.isEmpty(r112) == false) goto L7;
        if (TextUtils.isEmpty(r113) == true) goto L7;
    L10:
        printDebugInfo("key and iv need both exist");
        long r101 = System.currentTimeMillis();
        notifyEvent(Event.BYTECAST_CASTPROXY_PROXY_URL, new Event(this.context, this.appId, r101 - r100, false));
        return null;
    L7:
        if (TextUtils.isEmpty(r112) == true) goto L13;
        if (TextUtils.isEmpty(r113) == true) goto L10;
    L13:
        if (r112.getBytes().length >= 16) goto L17;
        printDebugInfo("key's length should >= 16");
        long r102 = System.currentTimeMillis();
        notifyEvent(Event.BYTECAST_CASTPROXY_PROXY_URL, new Event(this.context, this.appId, r102 - r100, false));
        return null;
    L17:
        return proxyUrl(r110, r111, r112, r113, null, null);
    }

    public String proxyUrl(String r100, String r101, String r110, CastProxyMediaType r111, CastProxyOutputResolution r112) {
        return proxyUrl(r100, r101, r110, null, r111, r112);
    }

    private String proxyUrl(String r210, String r211, String r212, String r213, CastProxyMediaType r214, CastProxyOutputResolution r215) {
        long r110 = System.currentTimeMillis();
        String r111 = null;
        if (TextUtils.isEmpty(r210) == false) goto L5;
    L29:
        printDebugInfo("ip or url cannot be null");
        notifyEvent(Event.BYTECAST_CASTPROXY_PROXY_URL, new Event(this.context, this.appId, System.currentTimeMillis() - r110, false));
        return null;
    L5:
        if (TextUtils.isEmpty(r211) == true) goto L29;
        String r100 = new URL(r211).getPath();     // Catch: MalformedURLException -> L26
        String r101 = Utils.getConnectionIP(r210);
        if (r214 == null) goto L11;
        CastProxyMediaType r102 = r214;
    L12:
        if (r102 != null) goto L15;
        printWarnInfo("castProxyMediaType is null");
        notifyEvent(Event.BYTECAST_CASTPROXY_PROXY_URL, new Event(this.context, this.appId, System.currentTimeMillis() - r110, false));
        return null;
    L15:
        String r103 = buildProxyUrl(r211, this.httpServer.getProxy(), r101, this.port, r212, r213, r214, r215);
        if (TextUtils.isEmpty(r103) == false) goto L19;
        printWarnInfo("proxyUrl is empty");
        notifyEvent(Event.BYTECAST_CASTPROXY_PROXY_URL, new Event(this.context, this.appId, System.currentTimeMillis() - r110, false));
        return null;
    L19:
        long r104 = System.currentTimeMillis();
        if (this.monitor == null) goto L25;
        if (r214 == null) goto L24;
        r111 = r214.getExtension();
    L24:
        notifyEvent(Event.BYTECAST_CASTPROXY_PROXY_URL, new Event(this.context, this.appId, r104 - r110, r111, !TextUtils.isEmpty(r212), true));
    L25:
        return r103;
    L11:
        r102 = getMediaTypeByPath(r100);
    L26:
        e = move-exception;
        e.printStackTrace();
        printDebugInfo("MalformedURLException: " + e);
        notifyEvent(Event.BYTECAST_CASTPROXY_PROXY_URL, new Event(this.context, this.appId, System.currentTimeMillis() - r110, false));
        return null;
    }

    private String buildProxyUrl(String r110, String r111, String r112, int r210, String r211, String r212, CastProxyMediaType r213, CastProxyOutputResolution r214) {
        if (r110.contains(Constants.PROXY_SUFFIX_NAME) == false) goto L6;
        return r110;
    L6:
        if (TextUtils.isEmpty(r211) == false) goto L8;
        String r100 = "none";
    L10:
        if (TextUtils.isEmpty(r212) == false) goto L12;
        String r101 = "none";
    L13:
        if (r213 != null) goto L15;
        String r102 = "none";
    L17:
        if (r214 != null) goto L19;
        String r103 = null;
    L30:
        String r104 = GsonUtils.toJsonIgnoreException(new UrlData(r110, r100, r101, r102, r103));     // Catch: Exception -> L27
        String r105 = encodeUrl(r104);     // Catch: Exception -> L27
        String r106 = getFileExtensionFromUrl(r110);     // Catch: Exception -> L27
        printDebugInfo("originData is " + r104 + ", encodeUrl is " + r105 + ", extension is " + r106);     // Catch: Exception -> L27
        if (TextUtils.isEmpty(r106) == false) goto L26;
        return "http://" + r112 + ":" + r210 + HTTP.URL_DEFAULT + r111 + "/resource/" + r105 + "/castproxy_resource";
    L26:
        return "http://" + r112 + ":" + r210 + HTTP.URL_DEFAULT + r111 + "/resource/" + r105 + "/castproxy_resource." + r106;
    L27:
        e = move-exception;
        printErrorInfo("encode url exception: " + e);
        return null;
    L19:
        r103 = r214.getResolution();
        goto L30
    L15:
        r102 = r213.getExtension();
        goto L17
    L12:
        r101 = r212;
        goto L13
    L8:
        r100 = r211;
        goto L10
    }
}
