package com.byted.cast.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.api.IHostAddressAdapter;
import com.byted.cast.common.api.IWifiAdapter;
import com.byted.cast.common.config.Config;
import com.byted.cast.common.network.NetworkManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.account.platform.onekey.bpea.BpeaManager;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import f06.b;
import f06.c;
import f06.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public class NetworkUtil {
    private static final String DEFAULT_WIFI_RESULT = "-1";
    private static final int MSG_UPDATE_BASE_INFO = 1;
    private static final int MSG_UPDATE_EXTRA_INFO = 2;
    private static final String TAG = null;
    private static final long UPDATE_BASE_INFO_INTERVAL_IN_MILLIS = 60000;
    private static final long UPDATE_EXTRA_INFO_INTERVAL_IN_MILLIS = 600000;
    private static final long UPDATE_INFO_DELAY_BUFFER_IN_MILLIS = 1000;
    private static String sConnectionIpAdd;
    private static volatile boolean sFlagIsOnUpdateForBaseInfo;
    private static volatile boolean sFlagIsOnUpdateForExtraInfo;
    private static List<String> sIPAddrList;
    public static boolean sIsVpnInUse;
    public static boolean sIsWifiProxyInUse;
    private static long sLastUpdateMillisForBaseInfo;
    private static long sLastUpdateMillisForExtraInfo;
    private static NetworkType sNetworkType;
    private static Handler sUpdateHandler;
    private static Object sUpdateLockForBaseInfo;
    private static Object sUpdateLockForExtraInfo;
    private static HandlerThread sUpdateThread;
    private static String sWifiBandWidth;
    private static String sWifiLossRate;
    private static String sWifiRTT;

    public static final enum NetworkType extends Enum<NetworkType> {
        private static final /* synthetic */ NetworkType[] $VALUES = null;
        public static final NetworkType HOTSPOT = null;
        public static final NetworkType MOBILE = null;
        public static final NetworkType NONE = null;
        public static final NetworkType UNKNOWN = null;
        public static final NetworkType WIFI = null;
        public static final NetworkType WIRED = null;

        static {
            NetworkType r100 = new NetworkType("UNKNOWN", 0);
            UNKNOWN = r100;
            NetworkType r101 = new NetworkType(UserProfileEvent.POSITION_NONE, 1);
            NONE = r101;
            NetworkType r102 = new NetworkType("WIFI", 2);
            WIFI = r102;
            NetworkType r103 = new NetworkType("MOBILE", 3);
            MOBILE = r103;
            NetworkType r104 = new NetworkType("WIRED", 4);
            WIRED = r104;
            NetworkType r105 = new NetworkType("HOTSPOT", 5);
            HOTSPOT = r105;
            $VALUES = new NetworkType[]{r100, r101, r102, r103, r104, r105};
        }

        public static NetworkType[] values() {
            return (NetworkType[]) $VALUES.clone();
        }

        public static NetworkType valueOf(String r100) {
            return (NetworkType) a.a(NetworkType.class, r100);
        }

        private NetworkType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public NetworkUtil() {
    }

    private static void updateWifiProxyStatus() {
        String r100 = System.getProperty("http.proxyHost");     // Catch: Throwable -> L11
        String r101 = System.getProperty("http.proxyPort");     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r100) == false) goto L6;
    L8:
        boolean r102 = false;
    L9:
        sIsWifiProxyInUse = r102;     // Catch: Throwable -> L11
        return;
    L6:
        if (TextUtils.equals(r101, "-1") == true) goto L8;
        r102 = true;
    L11:
        th = move-exception;
        CastLogger.getInstance().e(TAG, " isWifiProxy e : " + th.getLocalizedMessage());
        sIsWifiProxyInUse = false;
    }

    static {
        TAG = "NetworkUtil";
        sIsVpnInUse = false;
        sIsWifiProxyInUse = false;
        sLastUpdateMillisForBaseInfo = 0;
        sLastUpdateMillisForExtraInfo = 0;
        sUpdateLockForBaseInfo = new Object();
        sUpdateLockForExtraInfo = new Object();
        sFlagIsOnUpdateForBaseInfo = false;
        sFlagIsOnUpdateForExtraInfo = false;
        sWifiBandWidth = "-1";
        sWifiRTT = "-1";
        sWifiLossRate = "-1";
        sConnectionIpAdd = "";
        sIPAddrList = Collections.synchronizedList(new ArrayList());
        sNetworkType = NetworkType.UNKNOWN;
    }

    public static void checkAndCreateUpdateThread() {
        if (sUpdateThread != null) goto L6;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("Network-Info-Update");
        sUpdateThread = r100;
        ThreadMethodProxy.start(r100);
    L6:
        if (sUpdateHandler != null) goto L9;
        final Looper r101 = sUpdateThread.getLooper();
        sUpdateHandler = new AnonymousClass1(r101);
        return;
    }

    public static List<String> getCanConnectLocalIpAddress() {
        ArrayList r100 = new ArrayList();
        Enumeration<NetworkInterface> r101 = NetworkInterface.getNetworkInterfaces();     // Catch: Throwable -> L23
    L4:
        if (r101.hasMoreElements() == false) goto L25;
        NetworkInterface r102 = r101.nextElement();     // Catch: Throwable -> L23
        String r103 = r102.getName();     // Catch: Throwable -> L23
        if ("eth0".equalsIgnoreCase(r103) == true) goto L11;
        if ("wlan0".equalsIgnoreCase(r103) == false) goto L4;
    L11:
        Enumeration<InetAddress> r104 = r102.getInetAddresses();     // Catch: Throwable -> L23
    L13:
        if (r104.hasMoreElements() == false) goto L4;
        InetAddress r105 = r104.nextElement();     // Catch: Throwable -> L23
        if (r105.isLoopbackAddress() == true) goto L13;
        if ((r105 instanceof Inet4Address) == false) goto L13;
        if ("eth0".equalsIgnoreCase(r103) == true) goto L20;
        r100.add(r105.getHostAddress().toString());     // Catch: Throwable -> L23
        goto L13
    L20:
        ListProtector.add(r100, 0, r105.getHostAddress().toString());     // Catch: Throwable -> L23
    L25:
        return r100;
    L23:
        th = move-exception;
        th.printStackTrace();
        goto L25
    }

    public static String getWifiBandWidth() {
        return sWifiBandWidth + "Mbps";
    }

    public static String getWifiLossRate() {
        return sWifiLossRate + GXTemplateKey.GAIAX_PE;
    }

    public static String getWifiRTT() {
        return sWifiRTT + "ms";
    }

    private static void updateWifiExtraInfo() {
        if (getCurrentNetworkType(Constants.sAppContext) == NetworkType.WIFI) goto L7;
        sWifiBandWidth = "-1";
        sWifiRTT = "-1";
        sWifiLossRate = "-1";
        return;
    L7:
        if (TextUtils.isEmpty(sConnectionIpAdd) == false) goto L10;
        sWifiBandWidth = "-1";
        sWifiRTT = "-1";
        sWifiLossRate = "-1";
        return;
    L10:
        updateWifiLinkSpeed();
        updateWifiRTTAndLossRate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v6 */
    private static void updateWifiRTTAndLossRate() {
        BufferedReader r100 = null;
        Process r101 = com_byted_cast_common_NetworkUtil_java_lang_Runtime_exec(Runtime.getRuntime(), "ping -c 10 " + sConnectionIpAdd);     // Catch: Throwable -> L51
        InputStreamReader r102 = new InputStreamReader(r101.getInputStream());     // Catch: Throwable -> L49
        InputStreamReader r103 = new InputStreamReader(r101.getErrorStream());     // Catch: Throwable -> L47
        BufferedReader r104 = new BufferedReader(r102);     // Catch: Throwable -> L45
        BufferedReader r105 = new BufferedReader(r103);     // Catch: Throwable -> L42
    L121:
        String r106 = r104.readLine();     // Catch: Throwable -> L40
        if (r106 == null) goto L16;
        if (r106.contains("avg") == false) goto L14;
        int r107 = r106.indexOf(HTTP.URL_DEFAULT, 20) + 1;     // Catch: Throwable -> L40
        sWifiRTT = r106.substring(r107, r106.indexOf(HTTP.URL_DEFAULT, r107));     // Catch: Throwable -> L40
    L14:
        if (r106.contains("packet loss") == false) goto L121;
        r106.indexOf(MessageIndication.STATUS_RECEIVED);     // Catch: Throwable -> L40
        int r108 = r106.indexOf(GXTemplateKey.GAIAX_PE);     // Catch: Throwable -> L40
        sWifiLossRate = r106.substring(r108 - 3, r108).trim();     // Catch: Throwable -> L40
    L16:
        String r109 = r105.readLine();     // Catch: Throwable -> L40
        if (r109 != null) goto L19;
        r104.close();     // Catch: IOException -> L24
    L111:
        r105.close();     // Catch: IOException -> L28
    L148:
        r102.close();     // Catch: IOException -> L32
    L134:
        r103.close();     // Catch: IOException -> L36
    L38:
        r101.destroy();     // Catch: Throwable -> L79
    L129:
        return;
    L36:
        e = move-exception;
        e.printStackTrace();
    L32:
        e = move-exception;
        e.printStackTrace();
    L28:
        e = move-exception;
        e.printStackTrace();
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L111
    L19:
        if (TextUtils.isEmpty(r109) == true) goto L16;
        sWifiLossRate = "-1";     // Catch: Throwable -> L40
        sWifiRTT = "-1";     // Catch: Throwable -> L40
    L40:
        th = th;
    L44:
        r100 = r104;
        ?? r110 = r105;
    L138:
        th.printStackTrace();     // Catch: Throwable -> L82
        if (r100 != null) goto L119;
    L61:
        if (r110 != 0) goto L109;
    L66:
        if (r102 != null) goto L142;
    L71:
        if (r103 != null) goto L125;
    L76:
        if (r101 == null) goto L161;
        r101.destroy();     // Catch: Throwable -> L79
        goto L129
    L161:
        return;
    L125:
        r103.close();     // Catch: IOException -> L74
    L74:
        e = move-exception;
        e.printStackTrace();
        goto L76
    L142:
        r102.close();     // Catch: IOException -> L69
    L69:
        e = move-exception;
        e.printStackTrace();
        goto L71
    L109:
        r110.close();     // Catch: IOException -> L64
    L64:
        e = move-exception;
        e.printStackTrace();
        goto L66
    L119:
        r100.close();     // Catch: IOException -> L59
    L59:
        e = move-exception;
        e.printStackTrace();
    L82:
        th = move-exception;
        if (r100 != null) goto L140;
    L88:
        if (r110 != 0) goto L123;
    L93:
        if (r102 != null) goto L113;
    L98:
        if (r103 != null) goto L146;
    L103:
        if (r101 == null) goto L162;
        r101.destroy();     // Catch: Throwable -> L106
        throw th;
    L106:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L162:
        throw th;
    L146:
        r103.close();     // Catch: IOException -> L101
    L101:
        e = move-exception;
        e.printStackTrace();
        goto L103
    L113:
        r102.close();     // Catch: IOException -> L96
    L96:
        e = move-exception;
        e.printStackTrace();
        goto L98
    L123:
        r110.close();     // Catch: IOException -> L91
    L91:
        e = move-exception;
        e.printStackTrace();
        goto L93
    L140:
        r100.close();     // Catch: IOException -> L86
    L86:
        e = move-exception;
        e.printStackTrace();
    L42:
        th = th;
        r105 = null;
    L45:
        th = th;
        r110 = 0;
    L47:
        th = th;
        r103 = null;
    L54:
        r110 = r103;
    L49:
        th = th;
        r102 = null;
    L53:
        r103 = r102;
    L79:
        th = move-exception;
        th.printStackTrace();
        return;
    L51:
        th = th;
        r101 = null;
        r102 = null;
        goto L53
    }

    private static void updateBaseNetworkInfo() {
        if ((System.currentTimeMillis() - sLastUpdateMillisForBaseInfo) >= 60000) goto L5;
        return;
    L5:
        if (sFlagIsOnUpdateForBaseInfo == true) goto L21;
        Object r100 = sUpdateLockForBaseInfo;
        monitor-enter(r100);
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L15
        if ((r101 - sLastUpdateMillisForBaseInfo) >= 60000) goto L11;
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L15
        sUpdateHandler.sendEmptyMessageDelayed(1, 61000);
        return;
    L11:
        if (sFlagIsOnUpdateForBaseInfo == true) goto L13;
        sFlagIsOnUpdateForBaseInfo = true;     // Catch: Throwable -> L15
        updateLocalIpAddr();     // Catch: Throwable -> L15
        sLastUpdateMillisForBaseInfo = r101;     // Catch: Throwable -> L15
        sFlagIsOnUpdateForBaseInfo = false;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private static void updateExtraNetworkInfo() {
        if ((System.currentTimeMillis() - sLastUpdateMillisForExtraInfo) >= 600000) goto L5;
        return;
    L5:
        if (sFlagIsOnUpdateForExtraInfo == true) goto L21;
        Object r100 = sUpdateLockForExtraInfo;
        monitor-enter(r100);
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L15
        if ((r101 - sLastUpdateMillisForExtraInfo) >= 600000) goto L11;
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L15
        sUpdateHandler.sendEmptyMessageDelayed(2, 601000);
        return;
    L11:
        if (sFlagIsOnUpdateForExtraInfo == true) goto L13;
        sFlagIsOnUpdateForExtraInfo = true;     // Catch: Throwable -> L15
        updateVpnAndWifiProxyStatus();     // Catch: Throwable -> L15
        updateWifiExtraInfo();     // Catch: Throwable -> L15
        sLastUpdateMillisForExtraInfo = r101;     // Catch: Throwable -> L15
        sFlagIsOnUpdateForExtraInfo = false;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    private static void updateLocalIpAddr() {
        Iterator<ContextManager.CastContext> r100 = NetworkManager.getCastContextList().iterator();
        ContextManager.CastContext r101 = null;
        ContextManager.CastContext r102 = null;
        boolean r103 = false;
    L4:
        if (r100.hasNext() == false) goto L18;
        ContextManager.CastContext r104 = r100.next();
        if (r104 == null) goto L4;
        Config r105 = ContextManager.getConfigManager(r104).getInitConfig();
        if (r103 == false) goto L11;
    L13:
        if (r101 == null) goto L15;
    L17:
        r102 = r104;
        goto L4
    L15:
        if (r105.getHostAddressAdapter() == null) goto L17;
        r101 = r104;
        goto L17
    L11:
        if (r105.getAppStateListener() == null) goto L13;
        r103 = r105.getAppStateListener().disableGetHostAddress();
        goto L13
    L18:
        if (r103 == true) goto L29;
        if (r101 != null) goto L22;
        r101 = r102;
    L22:
        doUpdateLocalIpAddr(r101);
        return;
    }

    private static void updateVpnAndWifiProxyStatus() {
        updateVpnStatus();
        updateWifiProxyStatus();
    }

    public static void updateVpnStatus() {
    L13:
        th = move-exception;
        CastLogger.getInstance().d(TAG, "isVpnInUse e : " + th.getLocalizedMessage());
    L15:
        sIsVpnInUse = false;
        return;
    L3:
        if (NetworkInterface.getNetworkInterfaces() == null) goto L15;
        Iterator r100 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();     // Catch: Throwable -> L13
    L6:
        if (r100.hasNext() == false) goto L15;
        NetworkInterface r101 = (NetworkInterface) r100.next();     // Catch: Throwable -> L13
        if (TextUtils.equals("tun0", r101.getName()) == true) goto L11;
        if (TextUtils.equals("ppp0", r101.getName()) == false) goto L6;
    L11:
        sIsVpnInUse = true;     // Catch: Throwable -> L13
    }

    private static void updateWifiLinkSpeed() {
        Iterator<ContextManager.CastContext> r100 = NetworkManager.getCastContextList().iterator();
        IWifiAdapter r101 = null;
    L4:
        if (r100.hasNext() == false) goto L10;
        ContextManager.CastContext r102 = r100.next();
        if (r102 == null) goto L4;
        r101 = ContextManager.getConfigManager(r102).getInitConfig().getWifiAdapter();
        if (r101 == null) goto L4;
    L10:
        doUpdateWifiLinkSpeed(r101);
    }

    public static /* synthetic */ void access$000() {
        updateBaseNetworkInfo();
    }

    public static /* synthetic */ void access$100() {
        updateExtraNetworkInfo();
    }

    public static String getConnectionIpAdd() {
        return sConnectionIpAdd;
    }

    public static boolean isVpnInUse() {
        return sIsVpnInUse;
    }

    public static boolean isWifiProxy() {
        return sIsWifiProxyInUse;
    }

    private static WifiInfo com_byted_cast_common_NetworkUtil_android_net_wifi_WifiManager_getConnectionInfo(WifiManager r110) {
        ArrayList r100 = new ArrayList();
        Object[] r111 = new Object[0];
        b r112 = new b();
        g06.a r101 = ApiHookConfig.f245611b.get(102301);
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
        d r106 = r105.preInvoke(102301, "android/net/wifi/WifiManager", BpeaManager.getConnectionInfo, r110, r111, "android.net.wifi.WifiInfo", r112);     // Catch: Exception -> L22
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L22
    L17:
        if (r106.f474982a == false) goto L21;
        return (WifiInfo) r106.f474983b;
    L21:
        return r110.getConnectionInfo();
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

    private static void doUpdateLocalIpAddr(ContextManager.CastContext r100) {
        ArrayList r101 = new ArrayList();
        Enumeration<NetworkInterface> r102 = NetworkInterface.getNetworkInterfaces();     // Catch: Throwable -> L18
    L4:
        if (r102.hasMoreElements() == false) goto L20;
        Enumeration<InetAddress> r103 = r102.nextElement().getInetAddresses();     // Catch: Throwable -> L18
    L8:
        if (r103.hasMoreElements() == false) goto L4;
        InetAddress r104 = r103.nextElement();     // Catch: Throwable -> L18
        if (r104.isLoopbackAddress() == true) goto L8;
        if ((r104 instanceof Inet4Address) == false) goto L8;
        IHostAddressAdapter r105 = ContextManager.getConfigManager(r100).getInitConfig().getHostAddressAdapter();     // Catch: Throwable -> L18
        if (r105 != null) goto L15;
        r101.add(r104.getHostAddress());     // Catch: Throwable -> L18
        goto L8
    L15:
        r101.add(r105.getHostAddress(r104));     // Catch: Throwable -> L18
    L20:
        sIPAddrList.clear();
        sIPAddrList.addAll(r101);
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    private static void doUpdateWifiLinkSpeed(IWifiAdapter r100) {
        WifiManager r101 = (WifiManager) Constants.sAppContext.getSystemService("wifi");     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        sWifiBandWidth = String.valueOf(r100.getLinkSpeed(r101));     // Catch: Throwable -> L7
    L10:
        return;
    L5:
        sWifiBandWidth = String.valueOf(com_byted_cast_common_NetworkUtil_android_net_wifi_WifiManager_getConnectionInfo(r101).getLinkSpeed());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    public static NetworkType getCurrentNetworkType(Context r100) {
        return sNetworkType;
    }

    public static List<String> getLocalIpAddr(ContextManager.CastContext r100) {
        return sIPAddrList;
    }

    public static boolean isWifiConnect(Context r100) {
        NetworkType r101 = getCurrentNetworkType(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101 != NetworkType.WIFI) goto L9;
        return true;
    L9:
        return false;
    }

    public static void setConnectionIpAdd(String r100) {
        sConnectionIpAdd = r100;
    }

    public static void setNetworkType(NetworkType r100) {
        CastLogger.getInstance().i(TAG, "updateNetworkType: " + r100);
        sNetworkType = r100;
    }

    public static void updateExtraNetworkInfo(Context r100) {
        updateExtraNetworkInfoInDelayMillis(r100, 0);
    }

    public static void updateInstantNetworkInfo(Context r100) {
        CastLogger r101 = CastLogger.getInstance();
        String r102 = TAG;
        r101.i(r102, "updateInstantNetworkInfo");
        updateNetworkType(r100);
        sUpdateHandler.removeMessages(1);
        updateLocalIpAddr();
        CastLogger.getInstance().i(r102, "updateInstantNetworkInfo: networkType: " + sNetworkType + ", localIpAddr: " + sIPAddrList);
        updateBaseNetworkInfoInDelayMillis(r100, 60000);
    }

    private static void updateNetworkType(Context r100) {
        if (r100 != null) goto L5;
        sNetworkType = NetworkType.UNKNOWN;
        return;
    L5:
        Context r101 = r100.getApplicationContext();
        NetworkType r102 = NetworkType.UNKNOWN;
        ConnectivityManager r103 = (ConnectivityManager) r101.getSystemService("connectivity");     // Catch: Throwable -> L31
        if (Build.VERSION.SDK_INT < 23) goto L17;
        NetworkCapabilities r104 = r103.getNetworkCapabilities(r103.getActiveNetwork());     // Catch: Throwable -> L31
        if (r104.hasTransport(1) == false) goto L12;
        r102 = NetworkType.WIFI;     // Catch: Throwable -> L31
    L35:
    L33:
        sNetworkType = r102;
        return;
    L12:
        if (r104.hasTransport(0) == false) goto L15;
        r102 = NetworkType.MOBILE;     // Catch: Throwable -> L31
        goto L35
    L15:
        if (r104.hasTransport(3) == false) goto L35;
        r102 = NetworkType.WIRED;     // Catch: Throwable -> L31
        goto L35
    L17:
        NetworkInfo r105 = r103.getActiveNetworkInfo();     // Catch: Throwable -> L31
        if (r105 == null) goto L30;
        if (r105.isConnected() == false) goto L30;
        int r106 = r105.getType();     // Catch: Throwable -> L31
        if (r106 != 1) goto L24;
        r102 = NetworkType.WIFI;     // Catch: Throwable -> L31
        goto L35
    L24:
        if (r106 != 0) goto L27;
        r102 = NetworkType.MOBILE;     // Catch: Throwable -> L31
        goto L35
    L27:
        if (r106 != 9) goto L35;
        r102 = NetworkType.WIRED;     // Catch: Throwable -> L31
    L30:
        r102 = NetworkType.NONE;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CastLogger.getInstance().e(TAG, th.getMessage());
        goto L33
    }

    private static Process com_byted_cast_common_NetworkUtil_java_lang_Runtime_exec(Runtime r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r111};
        b r112 = new b();
        d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }

    public static boolean compareFirstTwoSegments(String r100, String r101) {
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        String[] r103 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r102.length >= 2) goto L5;
        return false;
    L5:
        if (r103.length >= 2) goto L8;
        return false;
    L8:
        if (r102[0].equals(r103[0]) == true) goto L10;
        return false;
    L10:
        if (r102[1].equals(r103[1]) == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static String filterIp(List<String> r100, String r101) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.size() != 0) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        return (String) ListProtector.get(r100, 0);
    L11:
        if (r101.startsWith(HTTP.URL_DEFAULT) == false) goto L13;
        r101 = r101.substring(1);
    L13:
        int r102 = Utils.conversionIpToInt(r101);
        String r103 = (String) ListProtector.get(r100, 0);
        Iterator<String> r104 = r100.iterator();
        int r105 = Integer.MAX_VALUE;
    L15:
        if (r104.hasNext() == false) goto L19;
        String r106 = r104.next();
        int r107 = Math.abs(Utils.conversionIpToInt(r106) ^ r102);
        if (r107 >= r105) goto L15;
        r103 = r106;
        r105 = r107;
        goto L15
    L19:
        return r103;
    }

    public static String getSameLocalNetworkIP(List<String> r100, String r101) {
        Iterator<String> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next();
        if (isSameLocalNetworkWithoutMask(r103, r101) == false) goto L4;
        return r103;
    L8:
        Iterator<String> r104 = r100.iterator();
    L10:
        if (r104.hasNext() == false) goto L15;
        String r105 = r104.next();
        if (compareFirstTwoSegments(r105, r101) == false) goto L10;
        return r105;
    L15:
        return (String) ListProtector.get(r100, 0);
    }

    public static boolean isSameLocalNetworkWithoutMask(String r100, String r101) {
        if (TextUtils.equals(r100, r101) == false) goto L6;
        return true;
    L6:
        if (r100 == null) goto L45;
        if (r101 == null) goto L45;
        if (r100.startsWith(HTTP.URL_DEFAULT) == false) goto L13;
        r100 = r100.substring(1);
    L13:
        if (r101.startsWith(HTTP.URL_DEFAULT) == false) goto L15;
        r101 = r101.substring(1);
    L15:
        String[] r102 = r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        String[] r103 = r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        if (r102.length < 2) goto L45;
        if (r103.length < 2) goto L45;
        if (r102[0].equals(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ) == false) goto L26;
        if (r103[0].equals(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ) == false) goto L26;
        return true;
    L26:
        if (r102[0].equals("172") == false) goto L37;
        if (r103[0].equals("172") == false) goto L37;
        int r104 = CastIntegerProtector.parseInt(r102[1]);
        int r105 = CastIntegerProtector.parseInt(r103[1]);
        if (r104 < 16) goto L37;
        if (r104 > 31) goto L37;
        if (r105 < 16) goto L37;
        if (r105 > 31) goto L37;
        return true;
    L37:
        if (r102[0].equals("192") == false) goto L45;
        if (r103[0].equals("192") == false) goto L45;
        if (r102[1].equals("168") == false) goto L45;
        if (r103[1].equals("168") == false) goto L45;
        return true;
    L45:
        return false;
    }

    private static void updateBaseNetworkInfoInDelayMillis(Context r100, long r101) {
        CastLogger.getInstance().i(TAG, "updateBaseNetworkInfo in millis: " + r101);
        sUpdateHandler.removeMessages(1);
        sLastUpdateMillisForBaseInfo = 0;
        sFlagIsOnUpdateForBaseInfo = false;
        sUpdateHandler.sendEmptyMessageDelayed(1, r101 + 1000);
    }

    public static void updateExtraNetworkInfoInDelayMillis(Context r100, long r101) {
        CastLogger.getInstance().i(TAG, "updateExtraNetworkInfo in millis: " + r101);
        sUpdateHandler.removeMessages(2);
        sLastUpdateMillisForExtraInfo = 0;
        sFlagIsOnUpdateForExtraInfo = false;
        sUpdateHandler.sendEmptyMessageDelayed(2, r101 + 1000);
    }
}
