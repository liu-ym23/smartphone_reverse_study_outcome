package com.autonavi.aps.amapapi;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.col.jmsl.C1541c2;
import com.amap.api.col.jmsl.C1562i;
import com.amap.api.col.jmsl.C1567j0;
import com.amap.api.col.jmsl.C1604s2;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.location.support.bean.wifi.AmapWifi;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.filters.LocFilter;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.autonavi.aps.amapapi.restruct.AmapSensorManager;
import com.autonavi.aps.amapapi.restruct.Cgi;
import com.autonavi.aps.amapapi.restruct.CgiManager;
import com.autonavi.aps.amapapi.restruct.HistoryLocation;
import com.autonavi.aps.amapapi.restruct.HistoryLocationRecorder;
import com.autonavi.aps.amapapi.restruct.WifiManagerWrapper;
import com.autonavi.aps.amapapi.storage.Cache;
import com.autonavi.aps.amapapi.trans.LocNetManager;
import com.autonavi.aps.amapapi.trans.Parser;
import com.autonavi.aps.amapapi.trans.Req;
import com.autonavi.aps.amapapi.utils.CollectionFactory;
import com.autonavi.aps.amapapi.utils.CoreUtil;
import com.autonavi.aps.amapapi.utils.Reflect;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.autonavi.aps.amapapi.utils.Utils;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.util.ArrayList;
import java.util.Locale;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class Aps {

    /* renamed from: M, reason: collision with root package name */
    private static volatile boolean f18190M = false;
    public static String locBackGroundPermissions = "android.permission.ACCESS_BACKGROUND_LOCATION";
    public static String[] locPermissions = {PolicySdkPermissionManifestUtils.ACCESS_COARSE_LOCATION, PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION};

    /* renamed from: F, reason: collision with root package name */
    private Handler f18196F;

    /* renamed from: G, reason: collision with root package name */
    private HistoryLocationRecorder f18197G;

    /* renamed from: H, reason: collision with root package name */
    boolean f18198H;

    /* renamed from: K, reason: collision with root package name */
    private String f18201K;

    /* renamed from: L, reason: collision with root package name */
    private ICollectionManager f18202L;

    /* renamed from: a, reason: collision with root package name */
    Context f18203a = null;

    /* renamed from: b, reason: collision with root package name */
    ConnectivityManager f18204b = null;

    /* renamed from: c, reason: collision with root package name */
    WifiManagerWrapper f18205c = null;

    /* renamed from: d, reason: collision with root package name */
    CgiManager f18206d = null;

    /* renamed from: e, reason: collision with root package name */
    Cache f18207e = null;

    /* renamed from: f, reason: collision with root package name */
    Parser f18208f = null;

    /* renamed from: g, reason: collision with root package name */
    ArrayList<AmapWifi> f18209g = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    MyBroadcastReceiver f18210h = null;

    /* renamed from: i, reason: collision with root package name */
    AMapLocationClientOption f18211i = new AMapLocationClientOption();

    /* renamed from: j, reason: collision with root package name */
    AMapLocationServer f18212j = null;

    /* renamed from: k, reason: collision with root package name */
    long f18213k = 0;

    /* renamed from: l, reason: collision with root package name */
    private int f18214l = 0;

    /* renamed from: m, reason: collision with root package name */
    Req f18215m = null;

    /* renamed from: n, reason: collision with root package name */
    boolean f18216n = false;

    /* renamed from: o, reason: collision with root package name */
    private String f18217o = null;

    /* renamed from: p, reason: collision with root package name */
    LocNetManager f18218p = null;

    /* renamed from: q, reason: collision with root package name */
    StringBuilder f18219q = new StringBuilder();

    /* renamed from: r, reason: collision with root package name */
    boolean f18220r = true;

    /* renamed from: s, reason: collision with root package name */
    boolean f18221s = true;

    /* renamed from: t, reason: collision with root package name */
    AMapLocationClientOption.GeoLanguage f18222t = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: u, reason: collision with root package name */
    boolean f18223u = true;

    /* renamed from: v, reason: collision with root package name */
    boolean f18224v = false;

    /* renamed from: w, reason: collision with root package name */
    private String f18225w = null;

    /* renamed from: x, reason: collision with root package name */
    StringBuilder f18226x = null;

    /* renamed from: y, reason: collision with root package name */
    boolean f18227y = false;
    public boolean isInit = false;

    /* renamed from: z, reason: collision with root package name */
    int f18228z = 12;

    /* renamed from: A, reason: collision with root package name */
    private boolean f18191A = true;

    /* renamed from: B, reason: collision with root package name */
    AmapSensorManager f18192B = null;

    /* renamed from: C, reason: collision with root package name */
    boolean f18193C = false;

    /* renamed from: D, reason: collision with root package name */
    LocFilter f18194D = null;

    /* renamed from: E, reason: collision with root package name */
    String f18195E = null;

    /* renamed from: I, reason: collision with root package name */
    IntentFilter f18199I = null;

    /* renamed from: J, reason: collision with root package name */
    LocationManager f18200J = null;

    public class MyBroadcastReceiver extends BroadcastReceiver {
        public MyBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WifiManagerWrapper wifiManagerWrapper;
            WifiManagerWrapper wifiManagerWrapper2;
            if (context == null || intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    WifiManagerWrapper wifiManagerWrapper3 = Aps.this.f18205c;
                    if (wifiManagerWrapper3 != null) {
                        wifiManagerWrapper3.wifiResultChange();
                    }
                    try {
                        if (intent.getExtras() == null || !intent.getExtras().getBoolean("resultsUpdated", true) || (wifiManagerWrapper2 = Aps.this.f18205c) == null) {
                            return;
                        }
                        wifiManagerWrapper2.wifiResultUpdateChange();
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                    WifiManagerWrapper wifiManagerWrapper4 = Aps.this.f18205c;
                    if (wifiManagerWrapper4 != null) {
                        wifiManagerWrapper4.wifiStateChange();
                        return;
                    }
                    return;
                }
                if (!action.equals("android.net.wifi.STATE_CHANGE") || (wifiManagerWrapper = Aps.this.f18205c) == null) {
                    return;
                }
                wifiManagerWrapper.resetWifiAccess();
            } catch (Throwable th) {
                CoreUtil.reportError(th, "Aps", "onReceive");
            }
        }
    }

    public Aps(boolean z10) {
        this.f18198H = z10;
    }

    private boolean c() {
        WifiManagerWrapper wifiManagerWrapper = this.f18205c;
        if (wifiManagerWrapper != null) {
            this.f18209g = wifiManagerWrapper.getScanResultsParam();
        }
        ArrayList<AmapWifi> arrayList = this.f18209g;
        return arrayList == null || arrayList.size() <= 0;
    }

    private void d() {
        if (this.f18218p != null) {
            try {
                if (this.f18211i == null) {
                    this.f18211i = new AMapLocationClientOption();
                }
                this.f18218p.setOption(this.f18211i.getHttpTimeOut(), this.f18211i.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS), C1567j0.j());
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a(long j10) {
        if (!this.f18191A) {
            this.f18191A = true;
            return false;
        }
        if (Utils.getTimeBoot() - j10 < 800) {
            if ((Utils.locCorrect(this.f18212j) ? Utils.getTime() - this.f18212j.getTime() : 0L) <= 10000) {
                return true;
            }
        }
        return false;
    }

    public void b() {
        try {
            if (this.f18210h == null) {
                this.f18210h = new MyBroadcastReceiver();
            }
            if (this.f18199I == null) {
                IntentFilter intentFilter = new IntentFilter();
                this.f18199I = intentFilter;
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.f18199I.addAction("android.net.wifi.SCAN_RESULTS");
                this.f18199I.addAction("android.net.wifi.STATE_CHANGE");
            }
            this.f18203a.registerReceiver(this.f18210h, this.f18199I);
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Aps", "initBroadcastListener");
        }
    }

    public void clearLocationDetail() {
        if (this.f18219q.length() > 0) {
            StringBuilder sb2 = this.f18219q;
            sb2.delete(0, sb2.length());
        }
    }

    @SuppressLint({"NewApi"})
    public void destroy() {
        this.f18195E = null;
        this.f18227y = false;
        this.isInit = false;
        Cache cache = this.f18207e;
        if (cache != null) {
            cache.destroy(this.f18203a);
        }
        LocFilter locFilter = this.f18194D;
        if (locFilter != null) {
            locFilter.reset();
        }
        if (this.f18208f != null) {
            this.f18208f = null;
        }
        HistoryLocationRecorder historyLocationRecorder = this.f18197G;
        if (historyLocationRecorder != null) {
            historyLocationRecorder.destroy(this.f18198H);
        }
        destroyCgiWifi();
        ArrayList<AmapWifi> arrayList = this.f18209g;
        if (arrayList != null) {
            arrayList.clear();
        }
        AmapSensorManager amapSensorManager = this.f18192B;
        if (amapSensorManager != null) {
            amapSensorManager.destroy();
        }
        this.f18212j = null;
        this.f18203a = null;
        this.f18226x = null;
        this.f18200J = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void destroyCgiWifi() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.f18203a     // Catch: java.lang.Throwable -> Ld
            if (r1 == 0) goto L15
            com.autonavi.aps.amapapi.Aps$MyBroadcastReceiver r2 = r4.f18210h     // Catch: java.lang.Throwable -> Ld
            if (r2 == 0) goto L15
            r1.unregisterReceiver(r2)     // Catch: java.lang.Throwable -> Ld
            goto L15
        Ld:
            r1 = move-exception
            java.lang.String r2 = "Aps"
            java.lang.String r3 = "destroy"
            com.autonavi.aps.amapapi.utils.CoreUtil.reportError(r1, r2, r3)     // Catch: java.lang.Throwable -> L2a
        L15:
            r4.f18210h = r0
            com.autonavi.aps.amapapi.restruct.CgiManager r0 = r4.f18206d
            if (r0 == 0) goto L20
            boolean r1 = r4.f18198H
            r0.destroy(r1)
        L20:
            com.autonavi.aps.amapapi.restruct.WifiManagerWrapper r0 = r4.f18205c
            if (r0 == 0) goto L29
            boolean r4 = r4.f18198H
            r0.destroy(r4)
        L29:
            return
        L2a:
            r1 = move-exception
            r4.f18210h = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.Aps.destroyCgiWifi():void");
    }

    public void destroyColl() {
        ICollectionManager iCollectionManager = this.f18202L;
        if (iCollectionManager != null) {
            iCollectionManager.destroyColl();
        }
    }

    public void doFirstAddCache(AMapLocationServer aMapLocationServer) {
        if (Utils.locCorrect(aMapLocationServer)) {
            this.f18207e.add(this.f18225w, this.f18226x, aMapLocationServer, this.f18203a, true);
        }
    }

    public AMapLocationServer doFirstCacheLocate(boolean z10) {
        if (this.f18205c.isMock()) {
            return a(15, "networkLocation has been mocked!#1502");
        }
        if (TextUtils.isEmpty(this.f18225w)) {
            return a(this.f18228z, this.f18219q.toString());
        }
        AMapLocationServer aMapLocationServer = this.f18207e.get(this.f18203a, this.f18225w, this.f18226x, true, z10);
        if (Utils.locCorrect(aMapLocationServer) && aMapLocationServer != null) {
            this.f18212j = aMapLocationServer;
        }
        return aMapLocationServer;
    }

    public AMapLocationServer doFirstNetLocate(boolean z10, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        if (z10) {
            aMapLocationStaticsEntity.setLocationType(AMapLocationStaticsEntity.STATICS_LOCATE);
        } else {
            aMapLocationStaticsEntity.setLocationType(AMapLocationStaticsEntity.FIRST_LOCATE);
        }
        if (this.f18203a == null) {
            aMapLocationStaticsEntity.setReason("#0101");
            this.f18219q.append("context is null#0101");
            ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_CONTEXTISNULL);
            return a(1, this.f18219q.toString());
        }
        WifiManagerWrapper wifiManagerWrapper = this.f18205c;
        if (wifiManagerWrapper != null && wifiManagerWrapper.isMock()) {
            aMapLocationStaticsEntity.setReason("#1502");
            return a(15, "networkLocation has been mocked!#1502");
        }
        initNetManager();
        if (TextUtils.isEmpty(this.f18225w)) {
            return a(this.f18228z, this.f18219q.toString());
        }
        AMapLocationServer aMapLocationServerA = a(false, z10, aMapLocationStaticsEntity);
        if (Utils.locCorrect(aMapLocationServerA) && !f18190M) {
            this.f18207e.setLastNb(this.f18226x.toString());
            this.f18207e.setLastCgi(this.f18206d.getMainCgi());
            this.f18212j = aMapLocationServerA;
        }
        f18190M = true;
        return aMapLocationServerA;
    }

    public AMapLocationServer filter(AMapLocationServer aMapLocationServer, String... strArr) {
        this.f18194D.setLocationCahceEnable(this.f18223u);
        return (strArr == null || strArr.length == 0) ? this.f18194D.filterShake(aMapLocationServer) : strArr[0].equals(Const.STR_FLT_SHAKE) ? this.f18194D.filterShake(aMapLocationServer) : strArr[0].equals(Const.STR_FLT_FUSION) ? this.f18194D.filterFusion(aMapLocationServer) : aMapLocationServer;
    }

    public String getErrorMessage() {
        return this.f18217o;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:60|(1:66)(1:65)|67|(1:72)(1:71)|73|(1:75)(2:76|(3:78|(1:80)|81)(11:82|(1:86)|87|(1:89)|112|91|(2:93|(1:95)(2:96|(1:98)(2:99|(1:101)(1:102))))|103|(1:108)(1:107)|109|110))|90|112|91|(0)|103|(2:105|108)(0)|109|110) */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018a A[Catch: all -> 0x01b0, TryCatch #0 {all -> 0x01b0, blocks: (B:91:0x0186, B:93:0x018a, B:95:0x0194, B:98:0x019e, B:101:0x01a8, B:102:0x01ad), top: B:112:0x0186 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.autonavi.aps.amapapi.model.AMapLocationServer getLocation(com.autonavi.aps.amapapi.AMapLocationStaticsEntity r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 506
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.Aps.getLocation(com.autonavi.aps.amapapi.AMapLocationStaticsEntity):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    public String getReqKey(boolean z10, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        CgiManager cgiManager = this.f18206d;
        String string = "";
        if (cgiManager != null && this.f18205c != null) {
            int mainCgiTypeMasked = cgiManager.getMainCgiTypeMasked();
            Cgi mainCgi = this.f18206d.getMainCgi();
            Cgi mainCgiV2 = this.f18206d.getMainCgiV2();
            ArrayList<AmapWifi> arrayList = this.f18209g;
            boolean z11 = arrayList == null || arrayList.isEmpty();
            if (mainCgi == null && mainCgiV2 == null && z11) {
                if (this.f18204b == null) {
                    this.f18204b = (ConnectivityManager) Utils.getServ(this.f18203a, "connectivity");
                }
                if (Utils.getSdk() >= 31) {
                    if (Utils.airPlaneModeOn(this.f18203a) && !this.f18205c.isSystemWifiEnabled()) {
                        this.f18228z = 18;
                        this.f18219q.append(C1562i.a("O105493_17") + "#1802");
                        ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_AIRPLANEMODE_WIFIOFF);
                        aMapLocationStaticsEntity.setReason("#1802");
                        return "";
                    }
                } else if (Utils.airPlaneModeOn(this.f18203a) && !this.f18205c.isWifiEnabled()) {
                    this.f18228z = 18;
                    this.f18219q.append(C1562i.a("O105493_17") + "#1801");
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_AIRPLANEMODE_WIFIOFF);
                    aMapLocationStaticsEntity.setReason("#1801");
                    return "";
                }
                if (Utils.getSdk() >= 28) {
                    if (this.f18200J == null) {
                        this.f18200J = (LocationManager) this.f18203a.getApplicationContext().getSystemService("location");
                    }
                    if (!((Boolean) Reflect.invokeMethod(this.f18200J, "isLocationEnabled", new Object[0])).booleanValue()) {
                        this.f18228z = 12;
                        this.f18219q.append(C1562i.a("O105493_14"));
                        aMapLocationStaticsEntity.setReason("#1206");
                        ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOLOCPERMISSION);
                        return "";
                    }
                }
                if (!Utils.checkLocPerm(this.f18203a)) {
                    this.f18228z = 12;
                    this.f18219q.append(C1562i.a("O105493_08"));
                    aMapLocationStaticsEntity.setReason("#1201");
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOLOCPERMISSION);
                    return "";
                }
                if (Utils.getSdk() >= 24 && Utils.getSdk() < 28 && Settings.Secure.getInt(this.f18203a.getContentResolver(), "location_mode", 0) == 0) {
                    this.f18228z = 12;
                    aMapLocationStaticsEntity.setReason("#1206");
                    this.f18219q.append(C1562i.a("O105493_14"));
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOLOCPERMISSION);
                    return "";
                }
                String securityException = this.f18206d.getSecurityException();
                String securityException2 = this.f18205c.getSecurityException();
                if (this.f18205c.wifiAccess(this.f18204b) && securityException2 != null) {
                    this.f18228z = 12;
                    aMapLocationStaticsEntity.setReason("#1202");
                    this.f18219q.append(C1562i.a("O105493_54"));
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOLOCPERMISSION);
                    return "";
                }
                if (securityException != null) {
                    this.f18228z = 12;
                    if (this.f18205c.isWifiEnabled()) {
                        aMapLocationStaticsEntity.setReason("#1205");
                        this.f18219q.append(C1562i.a("O105493_56"));
                    } else {
                        aMapLocationStaticsEntity.setReason("#1204");
                        this.f18219q.append(C1562i.a("O105493_55"));
                    }
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOLOCPERMISSION);
                    return "";
                }
                if (!this.f18205c.isWifiEnabled() && !this.f18206d.isSimValid()) {
                    this.f18228z = 19;
                    aMapLocationStaticsEntity.setReason("#1901");
                    this.f18219q.append(C1562i.a("O105493_18"));
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_NOCGI_WIFIOFF);
                    return "";
                }
                if (this.f18205c.isWifiEnabled()) {
                    aMapLocationStaticsEntity.setReason("#1302");
                    if (this.f18205c.getConnectionInfo() != null) {
                        this.f18219q.append(C1562i.a("O105493_58"));
                        if (!Utils.checkBackGroundLocPerm(this.f18203a)) {
                            this.f18219q.append(C1562i.a("O105493_59"));
                        }
                        this.f18219q.append("#1302");
                    } else {
                        this.f18219q.append(C1562i.a("O105493_60"));
                        if (!Utils.checkBackGroundLocPerm(this.f18203a)) {
                            this.f18219q.append(C1562i.a("O105493_59"));
                        }
                        this.f18219q.append("#1302");
                    }
                } else {
                    aMapLocationStaticsEntity.setReason("#1301");
                    this.f18219q.append(C1562i.a("O105493_57"));
                }
                this.f18228z = 13;
                ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOCGIANDWIFI);
                return "";
            }
            boolean zWifiUseful = this.f18205c.wifiUseful(this.f18205c.getWifiAccess());
            String str = Const.STR_CACHE_CW;
            if (mainCgiTypeMasked == 0) {
                boolean z12 = !this.f18209g.isEmpty() || zWifiUseful;
                boolean z13 = mainCgiV2 != null;
                if (!z10 && !z13) {
                    if (zWifiUseful && this.f18209g.isEmpty()) {
                        this.f18228z = 2;
                        aMapLocationStaticsEntity.setReason("#0201");
                        this.f18219q.append(C1562i.a("O105493_61"));
                        ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_ONLYMAINWIFI);
                        return "";
                    }
                    if (this.f18209g.size() == 1) {
                        this.f18228z = 2;
                        if (!zWifiUseful) {
                            aMapLocationStaticsEntity.setReason("#0202");
                            this.f18219q.append(C1562i.a("O105493_62"));
                            ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOMAINWIFIANDONLYONE);
                            return "";
                        }
                        if (this.f18209g.get(0).f18138h) {
                            aMapLocationStaticsEntity.setReason("#0202");
                            this.f18219q.append(C1562i.a("O105493_62"));
                            ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_ONLYMAINWIFI);
                            return "";
                        }
                    }
                }
                String str2 = String.format(Locale.US, "#%s#", "network");
                if (z13) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(mainCgiV2.getCellKey());
                    if (this.f18209g.isEmpty() && !zWifiUseful) {
                        str = "cgi";
                    }
                    sb2.append("network");
                    sb2.append(Const.STR_MART_WELL);
                    sb2.append(str);
                    string = sb2.toString();
                } else if (z12) {
                    string = str2 + "wifi";
                } else {
                    this.f18228z = 2;
                    if (this.f18205c.isWifiEnabled()) {
                        aMapLocationStaticsEntity.setReason("#0204");
                        this.f18219q.append(C1562i.a("O105493_13"));
                    } else {
                        aMapLocationStaticsEntity.setReason("#0203");
                        this.f18219q.append(C1562i.a("O105493_51"));
                    }
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_NOMAINWIFIANDONLYONE);
                }
            } else if (mainCgiTypeMasked != 1) {
                if (mainCgiTypeMasked != 2) {
                    this.f18228z = 11;
                    ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_CGIINFOERROR);
                    aMapLocationStaticsEntity.setReason("#1101");
                    this.f18219q.append("get cgi failure#1101");
                } else if (mainCgi != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(mainCgi.mcc);
                    sb3.append(Const.STR_MART_WELL);
                    sb3.append(mainCgi.mnc);
                    sb3.append(Const.STR_MART_WELL);
                    sb3.append(mainCgi.sid);
                    sb3.append(Const.STR_MART_WELL);
                    sb3.append(mainCgi.nid);
                    sb3.append(Const.STR_MART_WELL);
                    sb3.append(mainCgi.bid);
                    sb3.append(Const.STR_MART_WELL);
                    sb3.append("network");
                    sb3.append(Const.STR_MART_WELL);
                    if (this.f18209g.isEmpty() && !zWifiUseful) {
                        str = "cgi";
                    }
                    sb3.append(str);
                    string = sb3.toString();
                }
            } else if (mainCgi != null) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(mainCgi.mcc);
                sb4.append(Const.STR_MART_WELL);
                sb4.append(mainCgi.mnc);
                sb4.append(Const.STR_MART_WELL);
                sb4.append(mainCgi.lac);
                sb4.append(Const.STR_MART_WELL);
                sb4.append(mainCgi.cid);
                sb4.append(Const.STR_MART_WELL);
                sb4.append("network");
                sb4.append(Const.STR_MART_WELL);
                if (this.f18209g.isEmpty() && !zWifiUseful) {
                    str = "cgi";
                }
                sb4.append(str);
                string = sb4.toString();
            }
            if (!TextUtils.isEmpty(string)) {
                if (!string.startsWith(Const.STR_MART_WELL)) {
                    string = Const.STR_MART_WELL + string;
                }
                return Utils.encodeLicense() + string;
            }
        }
        return string;
    }

    public StringBuilder getReqNb(StringBuilder sb2) {
        if (sb2 == null) {
            sb2 = new StringBuilder(700);
        } else {
            sb2.delete(0, sb2.length());
        }
        CgiManager cgiManager = this.f18206d;
        if (cgiManager != null && this.f18205c != null) {
            sb2.append(cgiManager.getCgiParam());
            sb2.append(this.f18205c.getWifiParam());
        }
        return sb2;
    }

    public AMapLocationServer gpsLocationGeo(double d10, double d11, boolean z10) {
        try {
            String strPostReGeo = this.f18218p.postReGeo(this.f18203a, d10, d11, z10);
            if (!strPostReGeo.contains("\"status\":\"1\"")) {
                return null;
            }
            AMapLocationServer geoJsonResult = this.f18208f.parseGeoJsonResult(strPostReGeo);
            geoJsonResult.setLatitude(d10);
            geoJsonResult.setLongitude(d11);
            return geoJsonResult;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void initBase(Context context) {
        try {
            if (this.f18203a != null) {
                return;
            }
            this.f18194D = new LocFilter();
            Context applicationContext = context.getApplicationContext();
            this.f18203a = applicationContext;
            Utils.getAppName(applicationContext);
            if (this.f18205c == null) {
                this.f18205c = new WifiManagerWrapper(this.f18203a, (WifiManager) Utils.getServ(this.f18203a, "wifi"), this.f18196F);
            }
            if (this.f18206d == null) {
                this.f18206d = new CgiManager(this.f18203a, this.f18196F);
            }
            this.f18197G = new HistoryLocationRecorder(context, this.f18196F);
            if (this.f18207e == null) {
                this.f18207e = new Cache();
            }
            if (this.f18208f == null) {
                this.f18208f = new Parser();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            CoreUtil.reportError(th, "Aps", "initBase");
        }
    }

    public void initFirstLocateParam(Context context, AMapLocationStaticsEntity aMapLocationStaticsEntity) {
        try {
        } catch (Throwable th) {
            CoreUtil.reportError(th, "Aps", "initFirstLocateParam");
        }
        if (this.f18227y) {
            return;
        }
        if (this.f18225w != null) {
            this.f18225w = null;
        }
        StringBuilder sb2 = this.f18226x;
        if (sb2 != null) {
            sb2.delete(0, sb2.length());
        }
        if (this.f18224v) {
            b();
        }
        WifiManagerWrapper wifiManagerWrapper = this.f18205c;
        if (wifiManagerWrapper != null) {
            wifiManagerWrapper.updateWifi(this.f18224v);
            this.f18209g = this.f18205c.getScanResultsParam();
        }
        CgiManager cgiManager = this.f18206d;
        if (cgiManager != null) {
            cgiManager.updateCgi(true, c());
        }
        String reqKey = getReqKey(false, aMapLocationStaticsEntity);
        this.f18225w = reqKey;
        if (!TextUtils.isEmpty(reqKey)) {
            this.f18226x = getReqNb(this.f18226x);
        }
        this.f18227y = true;
    }

    public void initHandler(Handler handler) {
        this.f18196F = handler;
    }

    public void initNetManager() {
        this.f18218p = LocNetManager.getInstance(this.f18203a);
        d();
        if (this.f18204b == null) {
            this.f18204b = (ConnectivityManager) Utils.getServ(this.f18203a, "connectivity");
        }
        if (this.f18215m == null) {
            this.f18215m = new Req();
        }
    }

    public void initOther() {
        if (this.f18211i.isLBSLocationEnable()) {
            if (this.f18192B == null) {
                this.f18192B = new AmapSensorManager(this.f18203a);
            }
            b();
            WifiManagerWrapper wifiManagerWrapper = this.f18205c;
            if (wifiManagerWrapper != null) {
                wifiManagerWrapper.updateWifi(false);
                this.f18209g = this.f18205c.getScanResultsParam();
            }
            CgiManager cgiManager = this.f18206d;
            if (cgiManager != null) {
                cgiManager.updateCgi(false, c());
            }
            this.f18207e.loadDB(this.f18203a);
            try {
                if (this.f18203a.checkCallingOrSelfPermission(C1604s2.m(Const.WRITE_SECURE_SETTINGS_SELF_BASE64)) == 0) {
                    this.f18216n = true;
                }
            } catch (Throwable unused) {
            }
            this.isInit = true;
        }
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void notifyLocationStatus(boolean z10) {
        CgiManager cgiManager = this.f18206d;
        if (cgiManager != null) {
            cgiManager.notifyLocationStatus(z10);
        }
    }

    public void reInitIfNeed() {
        CgiManager cgiManager = this.f18206d;
        if (cgiManager != null) {
            cgiManager.reInitIfNeed();
        }
    }

    public void requestSdkAuth(Context context) {
        ICollectionManager iCollectionManager = this.f18202L;
        if (iCollectionManager != null) {
            iCollectionManager.updateToServer();
        }
    }

    public void setExtra(AMapLocationClientOption aMapLocationClientOption) {
        boolean zIsNeedAddress;
        boolean zIsLocationCacheEnable;
        boolean zIsOffset;
        this.f18211i = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f18211i = new AMapLocationClientOption();
        }
        WifiManagerWrapper wifiManagerWrapper = this.f18205c;
        if (wifiManagerWrapper != null) {
            wifiManagerWrapper.setOption(this.f18211i.isWifiActiveScan(), this.f18211i.isWifiScan(), this.f18211i.isMockEnable(), AMapLocationClientOption.isOpenAlwaysScanWifi(), aMapLocationClientOption.getScanWifiInterval());
        }
        d();
        Cache cache = this.f18207e;
        if (cache != null) {
            cache.setOption(this.f18211i);
        }
        Parser parser = this.f18208f;
        if (parser != null) {
            parser.setOption(this.f18211i);
        }
        CgiManager cgiManager = this.f18206d;
        if (cgiManager != null) {
            cgiManager.setNoLocReqCgiEnable(this.f18211i.isNoLocReqCgiEnable());
        }
        AMapLocationClientOption.GeoLanguage geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean z10 = true;
        try {
            geoLanguage = this.f18211i.getGeoLanguage();
            zIsNeedAddress = this.f18211i.isNeedAddress();
            try {
                zIsOffset = this.f18211i.isOffset();
                try {
                    zIsLocationCacheEnable = this.f18211i.isLocationCacheEnable();
                    try {
                        this.f18224v = this.f18211i.isOnceLocationLatest();
                        this.f18193C = this.f18211i.isSensorEnable();
                        if (zIsOffset != this.f18221s || zIsNeedAddress != this.f18220r || zIsLocationCacheEnable != this.f18223u || geoLanguage != this.f18222t) {
                            try {
                                this.f18191A = false;
                                LocFilter locFilter = this.f18194D;
                                if (locFilter != null) {
                                    locFilter.reset();
                                }
                            } catch (Throwable th) {
                                CoreUtil.reportError(th, "Aps", "cleanCache");
                            }
                        }
                    } catch (Throwable unused) {
                        z10 = zIsOffset;
                        zIsOffset = z10;
                        this.f18221s = zIsOffset;
                        this.f18220r = zIsNeedAddress;
                        this.f18223u = zIsLocationCacheEnable;
                        this.f18222t = geoLanguage;
                    }
                } catch (Throwable unused2) {
                    zIsLocationCacheEnable = true;
                }
            } catch (Throwable unused3) {
                zIsLocationCacheEnable = true;
            }
        } catch (Throwable unused4) {
            zIsNeedAddress = true;
            zIsLocationCacheEnable = true;
        }
        this.f18221s = zIsOffset;
        this.f18220r = zIsNeedAddress;
        this.f18223u = zIsLocationCacheEnable;
        this.f18222t = geoLanguage;
    }

    public void setFusionLocation(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            HistoryLocation historyLocation = new HistoryLocation();
            historyLocation.locationType = aMapLocation.getLocationType();
            historyLocation.time = aMapLocation.getTime();
            historyLocation.radius = (int) aMapLocation.getAccuracy();
            historyLocation.latitude = aMapLocation.getLatitude();
            historyLocation.longitude = aMapLocation.getLongitude();
            if (aMapLocation.getLocationType() == 1) {
                this.f18197G.addGpsLocation(historyLocation);
            }
        }
    }

    public void setGpsLocation(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            HistoryLocation historyLocation = new HistoryLocation();
            historyLocation.locationType = aMapLocation.getLocationType();
            historyLocation.time = aMapLocation.getTime();
            historyLocation.radius = (int) aMapLocation.getAccuracy();
            historyLocation.latitude = aMapLocation.getLatitude();
            historyLocation.longitude = aMapLocation.getLongitude();
            if (aMapLocation.getLocationType() == 1) {
                this.f18197G.addGpsLocation(historyLocation);
            }
        }
    }

    public void setNetworkLocation(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer != null && aMapLocationServer.getErrorCode() == 0) {
            HistoryLocation historyLocation = new HistoryLocation();
            historyLocation.time = aMapLocationServer.getTime();
            historyLocation.radius = (int) aMapLocationServer.getAccuracy();
            historyLocation.latitude = aMapLocationServer.getLatitude();
            historyLocation.longitude = aMapLocationServer.getLongitude();
            historyLocation.locationType = aMapLocationServer.getLocationType();
            if (!TextUtils.isEmpty(aMapLocationServer.getRetype())) {
                historyLocation.reType = Integer.parseInt(aMapLocationServer.getRetype());
            }
            historyLocation.reSubType = aMapLocationServer.getSubType();
            this.f18197G.addNetworkLocation(historyLocation);
        }
    }

    public void startColl() {
        try {
            Context context = this.f18203a;
            if (context == null) {
                return;
            }
            if (this.f18202L == null) {
                this.f18202L = CollectionFactory.getCollectionManager(context);
            }
            this.f18202L.startColl(this.f18206d, this.f18205c, this.f18196F);
        } catch (Throwable th) {
            C1541c2.b(th, "as", "stc");
        }
    }

    public void stopColl() {
        ICollectionManager iCollectionManager = this.f18202L;
        if (iCollectionManager != null) {
            iCollectionManager.stopColl();
        }
    }

    public void transformLocationType(AMapLocationServer aMapLocationServer) {
        if (aMapLocationServer.getErrorCode() == 0 && aMapLocationServer.getLocationType() == 0) {
            if (Const.L_LOCATION_TYPE.equals(aMapLocationServer.getRetype()) || "1".equals(aMapLocationServer.getRetype()) || "2".equals(aMapLocationServer.getRetype()) || Const.WIFI_FINGER_LOCATION_TYPE.equals(aMapLocationServer.getRetype()) || Const.WIFI_CELL_FINGER_LOCATION_TYPE.equals(aMapLocationServer.getRetype()) || Const.INDOOR_LOCATION_TYPE.equals(aMapLocationServer.getRetype())) {
                aMapLocationServer.setLocationType(5);
            } else {
                aMapLocationServer.setLocationType(6);
            }
        }
    }

    public byte[] a() throws Throwable {
        if (this.f18215m == null) {
            this.f18215m = new Req();
        }
        if (this.f18211i == null) {
            this.f18211i = new AMapLocationClientOption();
        }
        if (this.f18206d != null && this.f18205c != null) {
            this.f18215m.createReq(this.f18203a, this.f18211i.isNeedAddress(), this.f18211i.isOffset(), this.f18206d, this.f18205c, this.f18204b, null, this.f18195E, false, this.f18197G);
        }
        return this.f18215m.buildBinary();
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x02a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c1  */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.autonavi.aps.amapapi.model.AMapLocationServer a(boolean r18, boolean r19, com.autonavi.aps.amapapi.AMapLocationStaticsEntity r20) {
        /*
            Method dump skipped, instructions count: 1173
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.Aps.a(boolean, boolean, com.autonavi.aps.amapapi.AMapLocationStaticsEntity):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    private AMapLocationServer a(int i10, String str) {
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setErrorCode(i10);
        aMapLocationServer.setLocationDetail(str);
        if (i10 == 15) {
            ReportUtil.reportLocError(null, ReportUtil.EXCEPTION_CODE_MOCKNETLOC);
        }
        return aMapLocationServer;
    }
}
