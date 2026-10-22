package com.autonavi.aps.amapapi.restruct;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.location.support.bean.wifi.AmapWifi;
import com.autonavi.aps.amapapi.ICollectionManager;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.Reflect;
import com.autonavi.aps.amapapi.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class WifiManagerWrapper {
    public static long lLastWifiChange;

    /* renamed from: t, reason: collision with root package name */
    static long f18323t;

    /* renamed from: u, reason: collision with root package name */
    static long f18324u;

    /* renamed from: v, reason: collision with root package name */
    static long f18325v;

    /* renamed from: w, reason: collision with root package name */
    static long f18326w;

    /* renamed from: a, reason: collision with root package name */
    WifiManager f18328a;

    /* renamed from: d, reason: collision with root package name */
    Context f18331d;

    /* renamed from: m, reason: collision with root package name */
    WifiAgeEstimator f18340m;

    /* renamed from: r, reason: collision with root package name */
    private ICollectionManager f18345r;
    public static HashMap<String, Long> lastResultMap = new HashMap<>(36);
    public static long lastWifiListUpdate = 0;

    /* renamed from: x, reason: collision with root package name */
    static int f18327x = 0;
    public static long lLastCarrierWifiChange = 0;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<AmapWifi> f18329b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    ArrayList<AmapWifi> f18330c = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    boolean f18332e = false;

    /* renamed from: f, reason: collision with root package name */
    StringBuilder f18333f = null;

    /* renamed from: g, reason: collision with root package name */
    boolean f18334g = true;

    /* renamed from: h, reason: collision with root package name */
    boolean f18335h = true;

    /* renamed from: i, reason: collision with root package name */
    boolean f18336i = true;

    /* renamed from: j, reason: collision with root package name */
    private volatile WifiInfoWrapper f18337j = null;

    /* renamed from: k, reason: collision with root package name */
    String f18338k = null;

    /* renamed from: l, reason: collision with root package name */
    TreeMap<Integer, AmapWifi> f18339l = null;
    public boolean isWifiEnabled = true;
    public boolean mSystemWifiEnabled = true;
    public boolean mISStartCollect = false;

    /* renamed from: n, reason: collision with root package name */
    private String f18341n = "";

    /* renamed from: o, reason: collision with root package name */
    long f18342o = 0;

    /* renamed from: p, reason: collision with root package name */
    ConnectivityManager f18343p = null;

    /* renamed from: q, reason: collision with root package name */
    private long f18344q = 30000;

    /* renamed from: s, reason: collision with root package name */
    volatile boolean f18346s = false;

    public WifiManagerWrapper(Context context, WifiManager wifiManager, Handler handler) {
        this.f18328a = wifiManager;
        this.f18331d = context;
        WifiAgeEstimator wifiAgeEstimator = new WifiAgeEstimator(context, "wifiAgee", handler);
        this.f18340m = wifiAgeEstimator;
        wifiAgeEstimator.start();
    }

    public List<AmapWifi> a() {
        List<ScanResult> scanResults;
        if (this.f18328a != null) {
            try {
                if (Utils.hasPerminssion(this.f18331d, Const.ACCESS_WIFI_STATE_SELF_BASE64)) {
                    scanResults = this.f18328a.getScanResults();
                } else {
                    CoreUtil.reportError(new Exception("gst_n_aws"), "OPENSDK_WMW", "gsr_n_aws");
                    scanResults = null;
                }
                HashMap<String, Long> map = new HashMap<>(36);
                if (scanResults != null) {
                    for (ScanResult scanResult : scanResults) {
                        map.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                    }
                }
                if (lastResultMap.isEmpty() || !lastResultMap.equals(map)) {
                    lastResultMap = map;
                    lastWifiListUpdate = Utils.getTimeBoot();
                }
                this.f18338k = null;
                ArrayList arrayList = new ArrayList();
                this.f18341n = "";
                this.f18337j = getWifiAccess();
                if (wifiUseful(this.f18337j)) {
                    this.f18341n = this.f18337j.getBSSID();
                }
                if (scanResults != null && scanResults.size() > 0) {
                    int size = scanResults.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        ScanResult scanResult2 = scanResults.get(i10);
                        AmapWifi amapWifi = new AmapWifi(!TextUtils.isEmpty(this.f18341n) && this.f18341n.equals(scanResult2.BSSID));
                        amapWifi.f18132b = scanResult2.SSID;
                        amapWifi.f18134d = scanResult2.frequency;
                        amapWifi.f18135e = scanResult2.timestamp;
                        amapWifi.f18131a = AmapWifi.d(scanResult2.BSSID);
                        amapWifi.f18133c = (short) scanResult2.level;
                        short sElapsedRealtime = (short) ((SystemClock.elapsedRealtime() - (scanResult2.timestamp / 1000)) / 1000);
                        amapWifi.f18137g = sElapsedRealtime;
                        if (sElapsedRealtime < 0) {
                            amapWifi.f18137g = (short) 0;
                        }
                        amapWifi.f18136f = Utils.getTimeBoot();
                        arrayList.add(amapWifi);
                    }
                }
                this.f18340m.update((List) arrayList);
                return arrayList;
            } catch (SecurityException e10) {
                this.f18338k = e10.getMessage();
            } catch (Throwable th) {
                this.f18338k = null;
                CoreUtil.reportError(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    public boolean b() {
        long timeBoot = Utils.getTimeBoot() - f18323t;
        if (timeBoot < 4900) {
            return false;
        }
        if (this.f18343p == null) {
            this.f18343p = (ConnectivityManager) Utils.getServ(this.f18331d, "connectivity");
        }
        if (wifiAccess(this.f18343p) && timeBoot < Const.MINWIFIUPDATE_ACCESS) {
            return false;
        }
        if (f18327x > 1) {
            long aPWifiScanInterval = this.f18344q;
            if (aPWifiScanInterval == 30000) {
                aPWifiScanInterval = AuthUtil.getAPWifiScanInterval() != -1 ? AuthUtil.getAPWifiScanInterval() : 30000L;
            }
            if (timeBoot < aPWifiScanInterval) {
                return false;
            }
        }
        if (this.f18328a != null) {
            f18323t = Utils.getTimeBoot();
            int i10 = f18327x;
            if (i10 < 2) {
                f18327x = i10 + 1;
            }
            if (Utils.hasPerminssion(this.f18331d, Const.CHANGE_WIFI_STATE_SELF_BASE64)) {
                return this.f18328a.startScan();
            }
            CoreUtil.reportError(new Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
        }
        return false;
    }

    public boolean c() {
        this.isWifiEnabled = this.f18328a == null ? false : Utils.isWifiAble(this.f18331d);
        checkSystemWifiEnabled();
        if (this.isWifiEnabled && this.f18334g) {
            if (f18325v == 0) {
                return true;
            }
            if (Utils.getTimeBoot() - f18325v >= 4900 && Utils.getTimeBoot() - lLastWifiChange >= 1500) {
                Utils.getTimeBoot();
                return true;
            }
        }
        return false;
    }

    public void checkSystemWifiEnabled() {
        try {
            if (Utils.hasPerminssion(this.f18331d, Const.ACCESS_WIFI_STATE_SELF_BASE64)) {
                this.mSystemWifiEnabled = this.f18328a.isWifiEnabled();
            }
        } catch (Throwable unused) {
            DebugUtils.writeCat("WMW | cswe e", false);
        }
    }

    public void d() {
        if (c()) {
            try {
                if (b()) {
                    f18325v = Utils.getTimeBoot();
                }
            } catch (Throwable th) {
                CoreUtil.reportError(th, "WifiManager", "wifiScan");
            }
        }
    }

    public void destroy(boolean z10) {
        resetWifiData();
        this.f18329b.clear();
        this.f18340m.destroy(z10);
    }

    public void enableWifiAlwaysScan(boolean z10) {
        Context context = this.f18331d;
        if (!AuthUtil.isCanAlwaysScanWifi() || !this.f18336i || this.f18328a == null || context == null || !z10 || Utils.getSdk() <= 17) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (((Integer) Reflect.invokeStaticMethod("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                Reflect.invokeStaticMethod("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, (Class<?>[]) new Class[]{ContentResolver.class, String.class, Integer.TYPE});
            }
        } catch (Throwable th) {
            CoreUtil.reportError(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
    }

    public ArrayList<AmapWifi> getAmapWifis() {
        if (!this.mISStartCollect) {
            return this.f18330c;
        }
        updateWifi(true);
        return this.f18330c;
    }

    public WifiInfo getConnectionInfo() {
        try {
            if (this.f18328a == null) {
                return null;
            }
            if (Utils.hasPerminssion(this.f18331d, Const.ACCESS_WIFI_STATE_SELF_BASE64)) {
                return this.f18328a.getConnectionInfo();
            }
            CoreUtil.reportError(new Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");
            return null;
        } catch (Throwable th) {
            CoreUtil.reportError(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    public long getMMacUpdateTime() {
        return this.f18342o;
    }

    public ArrayList<AmapWifi> getScanResultsParam() {
        if (this.f18329b == null) {
            return null;
        }
        ArrayList<AmapWifi> arrayList = new ArrayList<>();
        if (!this.f18329b.isEmpty()) {
            arrayList.addAll(this.f18329b);
        }
        return arrayList;
    }

    public String getSecurityException() {
        return this.f18338k;
    }

    public WifiInfoWrapper getWifiAccess() {
        checkSystemWifiEnabled();
        if (!isSystemWifiEnabled()) {
            return null;
        }
        if (this.f18337j == null) {
            this.f18337j = new WifiInfoWrapper(getConnectionInfo());
        }
        return this.f18337j;
    }

    public String getWifiAge() {
        return String.valueOf(Utils.getTimeBoot() - lLastWifiChange);
    }

    public String getWifiParam() {
        String str;
        StringBuilder sb2 = this.f18333f;
        int i10 = 0;
        if (sb2 == null) {
            this.f18333f = new StringBuilder(700);
        } else {
            sb2.delete(0, sb2.length());
        }
        this.f18332e = false;
        int size = this.f18329b.size();
        boolean z10 = false;
        boolean z11 = false;
        while (true) {
            boolean z12 = true;
            if (i10 >= size) {
                break;
            }
            String strC = AmapWifi.c(this.f18329b.get(i10).f18131a);
            if (!this.f18335h && !"<unknown ssid>".equals(this.f18329b.get(i10).f18132b)) {
                z10 = true;
            }
            if (TextUtils.isEmpty(this.f18341n) || !this.f18341n.equals(strC)) {
                z12 = z11;
                str = "nb";
            } else {
                str = "access";
            }
            this.f18333f.append(String.format(Locale.US, "#%s,%s", strC, str));
            i10++;
            z11 = z12;
        }
        if (this.f18329b.size() == 0) {
            z10 = true;
        }
        if (!this.f18335h && !z10) {
            this.f18332e = true;
        }
        if (!z11 && !TextUtils.isEmpty(this.f18341n)) {
            StringBuilder sb3 = this.f18333f;
            sb3.append(Const.STR_MART_WELL);
            sb3.append(this.f18341n);
            this.f18333f.append(",access");
        }
        return this.f18333f.toString();
    }

    public long getWifiResultAge() {
        return ((Utils.getTimeBoot() - lastWifiListUpdate) / 1000) + 1;
    }

    public boolean isMock() {
        return this.f18332e;
    }

    public boolean isSystemWifiEnabled() {
        return this.mSystemWifiEnabled;
    }

    public boolean isWifiEnabled() {
        return this.isWifiEnabled;
    }

    public void onCollectLocation() {
        try {
            this.mISStartCollect = true;
            List<AmapWifi> listA = a();
            if (listA != null) {
                this.f18329b.clear();
                this.f18329b.addAll(listA);
            }
            a(true);
        } catch (Throwable unused) {
        }
    }

    public void resetWifiAccess() {
        this.f18337j = null;
    }

    public void resetWifiData() {
        this.f18337j = null;
        this.f18329b.clear();
    }

    public void setCollectionManager(ICollectionManager iCollectionManager) {
        this.f18345r = iCollectionManager;
    }

    public void setOption(boolean z10, boolean z11, boolean z12, boolean z13) {
        setOption(z10, z11, z12, z13, 30000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updateWifi(boolean r7) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.restruct.WifiManagerWrapper.updateWifi(boolean):void");
    }

    public boolean wifiAccess(ConnectivityManager connectivityManager) {
        try {
            if (Utils.getNetT(connectivityManager.getActiveNetworkInfo()) == 1) {
                return wifiUseful(getWifiAccess());
            }
            return false;
        } catch (Throwable th) {
            CoreUtil.reportError(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public void wifiResultChange() {
        if (this.f18328a != null && Utils.getTimeBoot() - lLastWifiChange > 4900) {
            lLastWifiChange = Utils.getTimeBoot();
        }
    }

    public void wifiResultUpdateChange() {
        lLastCarrierWifiChange = System.currentTimeMillis();
        ICollectionManager iCollectionManager = this.f18345r;
        if (iCollectionManager != null) {
            iCollectionManager.updateWiFi();
        }
    }

    public void wifiStateChange() {
        if (this.f18328a == null) {
            return;
        }
        this.f18346s = true;
    }

    public boolean wifiUseful(WifiInfoWrapper wifiInfoWrapper) {
        if (wifiInfoWrapper == null) {
            return false;
        }
        return wifiInfoWrapper.isUseFul();
    }

    public void setOption(boolean z10, boolean z11, boolean z12, boolean z13, long j10) {
        this.f18334g = z11;
        this.f18335h = z12;
        this.f18336i = z13;
        if (j10 < 10000) {
            this.f18344q = 10000L;
        } else {
            this.f18344q = j10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r9) {
        /*
            r8 = this;
            java.util.ArrayList<com.amap.location.support.bean.wifi.AmapWifi> r0 = r8.f18329b
            if (r0 == 0) goto Le1
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Lc
            goto Le1
        Lc:
            long r0 = com.autonavi.aps.amapapi.utils.Utils.getTimeBoot()
            long r2 = com.autonavi.aps.amapapi.restruct.WifiManagerWrapper.lLastWifiChange
            long r0 = r0 - r2
            r2 = 3600000(0x36ee80, double:1.7786363E-317)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L1d
            r8.resetWifiData()
        L1d:
            java.util.TreeMap<java.lang.Integer, com.amap.location.support.bean.wifi.AmapWifi> r0 = r8.f18339l
            if (r0 != 0) goto L2c
            java.util.TreeMap r0 = new java.util.TreeMap
            java.util.Comparator r1 = java.util.Collections.reverseOrder()
            r0.<init>(r1)
            r8.f18339l = r0
        L2c:
            java.util.TreeMap<java.lang.Integer, com.amap.location.support.bean.wifi.AmapWifi> r0 = r8.f18339l
            r0.clear()
            boolean r0 = r8.mISStartCollect
            if (r0 == 0) goto L3c
            if (r9 == 0) goto L3c
            java.util.ArrayList<com.amap.location.support.bean.wifi.AmapWifi> r0 = r8.f18330c     // Catch: java.lang.Throwable -> L3c
            r0.clear()     // Catch: java.lang.Throwable -> L3c
        L3c:
            java.util.ArrayList<com.amap.location.support.bean.wifi.AmapWifi> r0 = r8.f18329b
            int r0 = r0.size()
            r1 = 0
            r8.f18342o = r1
            r1 = 0
            r2 = r1
        L48:
            if (r2 >= r0) goto Lbb
            java.util.ArrayList<com.amap.location.support.bean.wifi.AmapWifi> r3 = r8.f18329b
            java.lang.Object r3 = r3.get(r2)
            com.amap.location.support.bean.wifi.AmapWifi r3 = (com.amap.location.support.bean.wifi.AmapWifi) r3
            boolean r4 = r3.f18138h
            if (r4 == 0) goto L5a
            long r4 = r3.f18136f
            r8.f18342o = r4
        L5a:
            long r4 = r3.f18131a
            java.lang.String r4 = com.amap.location.support.bean.wifi.AmapWifi.c(r4)
            boolean r4 = com.autonavi.aps.amapapi.utils.Utils.wifiUseful(r4)
            if (r4 != 0) goto L67
            goto Lb8
        L67:
            r4 = 20
            if (r0 <= r4) goto L82
            int r5 = r3.f18133c
            int r4 = android.net.wifi.WifiManager.calculateSignalLevel(r5, r4)     // Catch: java.lang.ArithmeticException -> L72
            goto L7a
        L72:
            r5 = move-exception
            java.lang.String r6 = "Aps"
            java.lang.String r7 = "wifiSigFine"
            com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r5, r6, r7)
        L7a:
            r5 = 1
            if (r4 < r5) goto L7e
            goto L7f
        L7e:
            r5 = r1
        L7f:
            if (r5 != 0) goto L82
            goto Lb8
        L82:
            boolean r4 = r8.mISStartCollect
            if (r4 == 0) goto L8d
            if (r9 == 0) goto L8d
            java.util.ArrayList<com.amap.location.support.bean.wifi.AmapWifi> r4 = r8.f18330c
            r4.add(r3)
        L8d:
            java.lang.String r4 = r3.f18132b
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto La6
            java.lang.String r4 = r3.f18132b
            java.lang.String r5 = "<unknown ssid>"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto Laa
            java.lang.String r4 = java.lang.String.valueOf(r2)
            r3.f18132b = r4
            goto Laa
        La6:
            java.lang.String r4 = "unkwn"
            r3.f18132b = r4
        Laa:
            java.util.TreeMap<java.lang.Integer, com.amap.location.support.bean.wifi.AmapWifi> r4 = r8.f18339l
            int r5 = r3.f18133c
            int r5 = r5 * 25
            int r5 = r5 + r2
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.put(r5, r3)
        Lb8:
            int r2 = r2 + 1
            goto L48
        Lbb:
            java.util.ArrayList<com.amap.location.support.bean.wifi.AmapWifi> r9 = r8.f18329b
            r9.clear()
            java.util.TreeMap<java.lang.Integer, com.amap.location.support.bean.wifi.AmapWifi> r9 = r8.f18339l
            java.util.Collection r9 = r9.values()
            java.util.Iterator r9 = r9.iterator()
        Lca:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto Ldc
            java.lang.Object r0 = r9.next()
            com.amap.location.support.bean.wifi.AmapWifi r0 = (com.amap.location.support.bean.wifi.AmapWifi) r0
            java.util.ArrayList<com.amap.location.support.bean.wifi.AmapWifi> r1 = r8.f18329b
            r1.add(r0)
            goto Lca
        Ldc:
            java.util.TreeMap<java.lang.Integer, com.amap.location.support.bean.wifi.AmapWifi> r8 = r8.f18339l
            r8.clear()
        Le1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.restruct.WifiManagerWrapper.a(boolean):void");
    }
}
