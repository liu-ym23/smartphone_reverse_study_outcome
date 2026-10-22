package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import ch.qos.logback.core.spi.AbstractComponentTracker;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.platform.comapi.map.MapController;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.suggest.AppSuggestStorable;
import com.stepos.alphame.utils.Consts;
import com.stepos.alphame.utils.Property;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class g {

    /* renamed from: s, reason: collision with root package name */
    private static char[] f5224s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();

    /* renamed from: a, reason: collision with root package name */
    String f5225a;

    /* renamed from: b, reason: collision with root package name */
    String f5226b;

    /* renamed from: d, reason: collision with root package name */
    private Context f5228d;

    /* renamed from: e, reason: collision with root package name */
    private TelephonyManager f5229e;

    /* renamed from: g, reason: collision with root package name */
    private WifiManager f5231g;

    /* renamed from: i, reason: collision with root package name */
    private String f5233i;

    /* renamed from: j, reason: collision with root package name */
    private String f5234j;

    /* renamed from: k, reason: collision with root package name */
    private LocationClientOption f5235k;

    /* renamed from: l, reason: collision with root package name */
    private a f5236l;

    /* renamed from: n, reason: collision with root package name */
    private String f5238n;

    /* renamed from: o, reason: collision with root package name */
    private String f5239o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5240p;

    /* renamed from: f, reason: collision with root package name */
    private com.baidu.location.c.a f5230f = new com.baidu.location.c.a();

    /* renamed from: h, reason: collision with root package name */
    private com.baidu.location.c.k f5232h = null;

    /* renamed from: m, reason: collision with root package name */
    private String f5237m = null;

    /* renamed from: c, reason: collision with root package name */
    b f5227c = new b();

    /* renamed from: q, reason: collision with root package name */
    private String f5241q = null;

    /* renamed from: r, reason: collision with root package name */
    private long f5242r = 0;

    /* renamed from: t, reason: collision with root package name */
    private boolean f5243t = false;

    /* renamed from: u, reason: collision with root package name */
    private long f5244u = 0;

    /* renamed from: v, reason: collision with root package name */
    private boolean f5245v = false;

    public interface a {
        void onReceiveLocation(BDLocation bDLocation);
    }

    public class c {

        /* renamed from: a, reason: collision with root package name */
        public String f5255a;

        /* renamed from: b, reason: collision with root package name */
        public int f5256b;

        public c(String str, int i4) {
            this.f5255a = str;
            this.f5256b = i4;
        }
    }

    public g(Context context, LocationClientOption locationClientOption, a aVar, String str, boolean z4) {
        StringBuilder sb;
        String str2;
        this.f5228d = null;
        this.f5229e = null;
        this.f5231g = null;
        this.f5233i = null;
        this.f5234j = null;
        this.f5238n = null;
        this.f5239o = null;
        this.f5225a = null;
        this.f5226b = null;
        this.f5240p = false;
        Context applicationContext = context.getApplicationContext();
        this.f5228d = applicationContext;
        try {
            com.baidu.location.e.h.aw = applicationContext.getPackageName();
        } catch (Exception unused) {
        }
        this.f5240p = true;
        this.f5235k = new LocationClientOption(locationClientOption);
        this.f5236l = aVar;
        this.f5225a = this.f5228d.getPackageName();
        this.f5226b = null;
        try {
            this.f5229e = (TelephonyManager) this.f5228d.getSystemService("phone");
            this.f5231g = (WifiManager) this.f5228d.getApplicationContext().getSystemService(AppSuggestStorable.COLUMN_WIFI);
        } catch (Exception unused2) {
        }
        if (this.f5235k.firstLocType == LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC) {
            com.baidu.location.c.f.a().a(this.f5228d);
        }
        this.f5234j = B0.g.r(new StringBuilder("&"), this.f5225a, "&null");
        try {
            this.f5226b = LBSAuthManager.getInstance(this.f5228d).getCUID();
        } catch (Throwable unused3) {
            this.f5226b = null;
            this.f5229e = null;
            this.f5231g = null;
        }
        if (this.f5226b != null) {
            com.baidu.location.e.h.f5928n = "" + this.f5226b;
            sb = new StringBuilder("&prod=");
            sb.append(this.f5235k.prodName);
            sb.append(AwarenessDataItem.USERID_SPLITTER);
            sb.append(this.f5225a);
            sb.append("|&cu=");
            sb.append(this.f5226b);
            str2 = "&coor=";
        } else {
            sb = new StringBuilder("&prod=");
            sb.append(this.f5235k.prodName);
            sb.append(AwarenessDataItem.USERID_SPLITTER);
            sb.append(this.f5225a);
            str2 = "|&im=null&coor=";
        }
        sb.append(str2);
        sb.append(locationClientOption.getCoorType());
        this.f5233i = sb.toString();
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&fw=9.643&sdk=9.643&lt=1&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=12");
        locationClientOption.getAddrType();
        if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals("all")) {
            this.f5233i = B0.g.r(new StringBuilder(), this.f5233i, "&addr=allj2");
            if (locationClientOption.isNeedNewVersionRgc) {
                stringBuffer.append("&adtp=n2");
            }
        }
        if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
            this.f5233i = B0.g.r(new StringBuilder(), this.f5233i, "&sema=");
            if (locationClientOption.isNeedAptag) {
                this.f5233i = B0.g.r(new StringBuilder(), this.f5233i, "aptag|");
            }
            if (locationClientOption.isNeedAptagd) {
                this.f5233i = B0.g.r(new StringBuilder(), this.f5233i, "aptagd2|");
            }
            this.f5238n = com.baidu.location.a.a.b(this.f5228d);
            this.f5239o = com.baidu.location.a.a.c(this.f5228d);
        }
        stringBuffer.append("&first=1");
        if (z4) {
            stringBuffer.append("&state=fore");
        }
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        this.f5233i += stringBuffer.toString();
    }

    private Object a(Object obj, String str) throws Exception {
        return obj.getClass().getField(str).get(obj);
    }

    private boolean i() {
        if (com.baidu.location.b.a.a().f5090d == 0) {
            return false;
        }
        SharedPreferences sharedPreferences = this.f5228d.getApplicationContext().getSharedPreferences("cuidRelate", 0);
        if (!sharedPreferences.contains("isInstalled")) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (!com.baidu.location.e.h.b(this.f5228d, "com.baidu.map.location")) {
                editorEdit.putInt("isInstalled", 0);
                return false;
            }
            editorEdit.putInt("isInstalled", 1);
            editorEdit.apply();
        } else if (sharedPreferences.getInt("isInstalled", -1) == 0) {
            return false;
        }
        return sharedPreferences.getInt("cuidoc", 1) != 0 && (System.currentTimeMillis() - sharedPreferences.getLong("reqtime", 0L)) / 1000 >= sharedPreferences.getLong("cuidfreq", 60L) && com.baidu.location.e.h.b(this.f5228d) >= 2 && a(this.f5231g) && this.f5232h.a() > 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void j() throws java.security.NoSuchAlgorithmException {
        /*
            r11 = this;
            boolean r0 = r11.i()
            r1 = 0
            if (r0 == 0) goto Lc2
            r0 = 1
            r11.f5243t = r0
            com.baidu.location.c.k r2 = r11.f5232h
            r3 = 0
            if (r2 == 0) goto L67
            int r2 = r2.a()
            r4 = 10
            if (r2 < r4) goto L3e
            com.baidu.location.c.f r5 = com.baidu.location.c.f.a()
            com.baidu.location.c.k r6 = r11.f5232h
            java.lang.String r8 = r11.h()
            boolean r9 = r11.f5243t
            com.baidu.location.b.a r2 = com.baidu.location.b.a.a()
            int r10 = r2.f5088b
            r7 = 9
            java.lang.String r2 = r5.a(r6, r7, r8, r9, r10)
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L67
            byte[] r2 = r2.getBytes()
            java.lang.String r2 = com.baidu.location.e.h.a(r2, r1)
            goto L68
        L3e:
            com.baidu.location.c.f r4 = com.baidu.location.c.f.a()
            com.baidu.location.c.k r5 = r11.f5232h
            int r6 = r5.a()
            java.lang.String r7 = r11.h()
            boolean r8 = r11.f5243t
            com.baidu.location.b.a r2 = com.baidu.location.b.a.a()
            int r9 = r2.f5088b
            java.lang.String r2 = r4.a(r5, r6, r7, r8, r9)
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L67
            byte[] r2 = r2.getBytes()
            java.lang.String r2 = com.baidu.location.e.h.a(r2, r1)
            goto L68
        L67:
            r2 = r3
        L68:
            java.util.List r4 = r11.k()
            java.lang.String r4 = r11.a(r4)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L7e
            byte[] r3 = r4.getBytes()
            java.lang.String r3 = com.baidu.location.e.h.a(r3, r1)
        L7e:
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            if (r4 != 0) goto L9f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = r11.f5237m
            r1.append(r4)
            java.lang.String r4 = "&swf5="
            r1.append(r4)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r11.f5237m = r1
            r11.f5243t = r0
            goto La1
        L9f:
            r11.f5243t = r1
        La1:
            boolean r1 = android.text.TextUtils.isEmpty(r3)
            if (r1 != 0) goto Lc4
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r11.f5237m
            r1.append(r2)
            java.lang.String r2 = "&hwf5="
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r11.f5237m = r1
            r11.f5243t = r0
            goto Lc4
        Lc2:
            r11.f5243t = r1
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.g.j():void");
    }

    private List<WifiConfiguration> k() {
        try {
            WifiManager wifiManager = this.f5231g;
            if (wifiManager != null) {
                return wifiManager.getConfiguredNetworks();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public String b() {
        try {
            return a(15);
        } catch (Exception unused) {
            return null;
        }
    }

    public void e() {
        com.baidu.location.c.f.a().c();
    }

    public String g() {
        WifiInfo connectionInfo;
        if (this.f5231g == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f5242r > 1000 && (connectionInfo = this.f5231g.getConnectionInfo()) != null) {
            this.f5241q = connectionInfo.getBSSID();
            this.f5242r = jCurrentTimeMillis;
        }
        return this.f5241q;
    }

    public String h() {
        try {
            String strG = g();
            String strReplace = strG != null ? strG.replace(AwarenessDataItem.USERID_SPLITTER, "") : null;
            if (strReplace == null || strReplace.length() == 12) {
                return new String(strReplace);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private String a(int i4) throws NoSuchAlgorithmException {
        String strConcat;
        String strA;
        com.baidu.location.c.a aVar;
        try {
            com.baidu.location.c.a aVarA = com.baidu.location.c.f.a().a(this.f5230f, this.f5229e);
            this.f5230f = aVarA;
            strConcat = (aVarA == null || !aVarA.b()) ? null : com.baidu.location.c.f.a().b(this.f5230f);
            try {
                if (!TextUtils.isEmpty(strConcat) && (aVar = this.f5230f) != null && aVar.f5554n != null) {
                    strConcat = strConcat + this.f5230f.f5554n;
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strConcat = null;
        }
        try {
            this.f5232h = null;
        } catch (Exception unused3) {
        }
        if (!a(this.f5231g) || this.f5235k.priority == 4) {
            strA = null;
        } else {
            this.f5232h = new com.baidu.location.c.k(this.f5231g.getScanResults(), 0L);
            strA = com.baidu.location.c.f.a().a(this.f5232h, i4, h(), this.f5243t, com.baidu.location.b.a.a().f5088b);
            try {
                LocationClientOption locationClientOption = this.f5235k;
                if (locationClientOption != null && locationClientOption.isOnceLocation()) {
                    this.f5231g.startScan();
                }
            } catch (Exception unused4) {
            }
        }
        if (strConcat == null && strA == null) {
            this.f5237m = null;
            return null;
        }
        if (strA != null) {
            strConcat = strConcat == null ? strA : strConcat.concat(strA);
        }
        if (strConcat == null) {
            return null;
        }
        this.f5237m = strConcat;
        if (this.f5233i != null) {
            this.f5237m += this.f5233i;
        }
        j();
        StringBuilder sbS = B0.g.s(strConcat);
        sbS.append(this.f5233i);
        return sbS.toString();
    }

    public void c() {
        if (this.f5237m == null) {
            int iG = com.baidu.location.e.h.g(this.f5228d);
            int i4 = iG == -1 ? 69 : iG == -2 ? 70 : iG == 0 ? 71 : 62;
            if (!a(this.f5235k)) {
                b(i4);
                return;
            }
        }
        if (a(this.f5235k)) {
            com.baidu.location.c.c cVarA = com.baidu.location.c.c.a();
            String strB = cVarA.b(cVarA.c());
            com.baidu.location.c.c.a().b();
            if (strB == null) {
                b(62);
                return;
            }
            this.f5237m = B0.g.r(B0.g.s(strB), this.f5233i, "&per_c=1");
        }
        if (this.f5240p) {
            if (this.f5228d != null) {
                e.a().a(this.f5228d);
                this.f5237m += e.a().b();
            }
            String strB2 = com.baidu.location.a.a.a().b();
            if (strB2 != null) {
                this.f5237m += "&ak=" + strB2 + "&aks=lbs_locsdk";
            }
            String str = this.f5237m + "&cnloc=" + l.a().b();
            this.f5237m = str;
            this.f5227c.a(str);
        }
    }

    public void d() {
        if ((this.f5231g.isWifiEnabled() || this.f5231g.isScanAlwaysAvailable()) && this.f5235k.priority != 4) {
            com.baidu.location.c.f.a().a(0);
        }
        if (com.baidu.location.e.h.a(this.f5228d, PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION) == 1) {
            com.baidu.location.c.f.a().f();
        }
    }

    public void f() {
        com.baidu.location.c.f.a().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i4) {
        LocationClientOption locationClientOption = this.f5235k;
        if (locationClientOption == null || !locationClientOption.isOnceLocation()) {
            return;
        }
        BDLocation bDLocation = new BDLocation();
        bDLocation.setLocType(i4);
        bDLocation.setLocationID(Jni.en1(this.f5225a + ";" + this.f5226b + ";" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis()))));
        a aVar = this.f5236l;
        if (aVar != null) {
            aVar.onReceiveLocation(bDLocation);
        }
    }

    public class b extends com.baidu.location.e.f {

        /* renamed from: b, reason: collision with root package name */
        LocationManager f5248b;

        /* renamed from: c, reason: collision with root package name */
        a f5249c;

        /* renamed from: a, reason: collision with root package name */
        String f5247a = null;

        /* renamed from: d, reason: collision with root package name */
        boolean f5250d = false;

        public class a implements LocationListener {
            private a() {
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                b.this.c();
                b.this.f5250d = true;
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i4, Bundle bundle) {
            }
        }

        public b() {
            this.el = new HashMap();
        }

        private void b() {
            try {
                this.f5248b = (LocationManager) g.this.f5228d.getSystemService(MapController.LOCATION_LAYER_TAG);
                a aVar = new a();
                this.f5249c = aVar;
                LocationManager locationManager = this.f5248b;
                if (locationManager != null) {
                    try {
                        locationManager.requestLocationUpdates("network", 1000L, Property.DEFAULT_FLOAT_VALUE, aVar, Looper.getMainLooper());
                    } catch (SecurityException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            LocationManager locationManager;
            a aVar = this.f5249c;
            if (aVar == null || (locationManager = this.f5248b) == null) {
                return;
            }
            try {
                locationManager.removeUpdates(aVar);
            } catch (Exception unused) {
            }
        }

        @Override // com.baidu.location.e.f
        public void a() {
            if (g.this.f5238n != null && g.this.f5239o != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f5247a);
                Locale locale = Locale.CHINA;
                sb.append("&ki=" + g.this.f5238n + "&sn=" + g.this.f5239o);
                this.f5247a = sb.toString();
            }
            String strR = B0.g.r(new StringBuilder(), this.f5247a, "&enc=2");
            this.f5247a = strR;
            String strEncodeTp4 = Jni.encodeTp4(strR);
            this.f5247a = null;
            this.el.put("bloc", strEncodeTp4);
            this.el.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        private void a(BDLocation bDLocation) {
            try {
                if (bDLocation.hasAddr()) {
                    Address address = bDLocation.getAddress();
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(address.country);
                    stringBuffer.append(";");
                    stringBuffer.append(address.countryCode);
                    stringBuffer.append(";");
                    stringBuffer.append(address.province);
                    stringBuffer.append(";");
                    stringBuffer.append(address.city);
                    stringBuffer.append(";");
                    stringBuffer.append(address.cityCode);
                    stringBuffer.append(";");
                    stringBuffer.append(address.district);
                    stringBuffer.append(";");
                    stringBuffer.append(address.street);
                    stringBuffer.append(";");
                    stringBuffer.append(address.streetNumber);
                    stringBuffer.append(";");
                    stringBuffer.append(address.adcode);
                    stringBuffer.append(";");
                    stringBuffer.append(address.town);
                    stringBuffer.append(";");
                    stringBuffer.append(address.townCode);
                    String strEncodeToString = Base64.encodeToString((System.currentTimeMillis() + "_" + stringBuffer.toString()).getBytes(Constants.UTF_8_CODE), 0);
                    SharedPreferences sharedPreferencesA = s.a(g.this.f5228d);
                    if (sharedPreferencesA != null) {
                        SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                        editorEdit.putString("FirstLocAddr", strEncodeToString);
                        editorEdit.apply();
                    }
                }
            } catch (Exception unused) {
            }
        }

        public void a(String str) {
            this.f5247a = str;
            b(com.baidu.location.e.d.f5843e);
            if (g.this.f5243t) {
                b();
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() { // from class: com.baidu.location.b.g.b.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        b bVar = b.this;
                        if (!bVar.f5250d) {
                            bVar.c();
                        }
                        timer.cancel();
                        timer.purge();
                    }
                }, AbstractComponentTracker.LINGERING_TIMEOUT);
                SharedPreferences.Editor editorEdit = g.this.f5228d.getSharedPreferences("cuidRelate", 0).edit();
                editorEdit.putLong("reqtime", System.currentTimeMillis());
                editorEdit.apply();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
        
            r6 = r5.ej;
         */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a1 A[Catch: Exception -> 0x0019, TryCatch #2 {Exception -> 0x0019, blocks: (B:6:0x000c, B:8:0x0014, B:24:0x0062, B:26:0x006a, B:28:0x0076, B:31:0x0088, B:33:0x0095, B:35:0x00a1, B:36:0x00a6, B:32:0x008c, B:37:0x00ed, B:23:0x005a, B:11:0x001c, B:18:0x003d, B:13:0x0024, B:15:0x002f, B:19:0x0040, B:21:0x0056), top: B:49:0x000c, inners: #0, #1 }] */
        @Override // com.baidu.location.e.f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a(boolean r6) {
            /*
                Method dump skipped, instructions count: 269
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.g.b.a(boolean):void");
        }
    }

    private String a(List<WifiConfiguration> list) {
        ArrayList<c> arrayList;
        int iIntValue;
        int i4 = 0;
        if (list == null || list.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (WifiConfiguration wifiConfiguration : list) {
                String str = wifiConfiguration.SSID;
                try {
                    iIntValue = ((Integer) a(wifiConfiguration, "numAssociation")).intValue();
                } catch (Throwable unused) {
                    iIntValue = 0;
                }
                if (iIntValue > 0 && !TextUtils.isEmpty(str)) {
                    arrayList.add(new c(str, iIntValue));
                }
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, new Comparator<c>() { // from class: com.baidu.location.b.g.1
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(c cVar, c cVar2) {
                    int i5 = cVar.f5256b;
                    int i6 = cVar2.f5256b;
                    if (i5 > i6) {
                        return -1;
                    }
                    return i5 == i6 ? 0 : 1;
                }
            });
        }
        StringBuffer stringBuffer = new StringBuffer(200);
        for (c cVar : arrayList) {
            stringBuffer.append(cVar.f5255a);
            stringBuffer.append(",");
            stringBuffer.append(cVar.f5256b);
            stringBuffer.append(Consts.SPLITTER_DETAIL);
            i4++;
            if (i4 == 4) {
                break;
            }
        }
        if (arrayList.size() >= 5) {
            stringBuffer.append(((c) arrayList.get(4)).f5255a);
            stringBuffer.append(",");
            stringBuffer.append(((c) arrayList.get(4)).f5256b);
        }
        return stringBuffer.toString();
    }

    public void a() {
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) throws JSONException, NumberFormatException {
        String[] strArrSplit;
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("content");
            String string = jSONObject.has("ideocfre") ? jSONObject.getString("ideocfre") : null;
            if (TextUtils.isEmpty(string) || !string.contains(Consts.SPLITTER_DETAIL) || (strArrSplit = string.split("\\|")) == null || strArrSplit.length < 2) {
                return;
            }
            int i4 = Integer.parseInt(strArrSplit[0]);
            long j4 = Long.parseLong(strArrSplit[1]);
            SharedPreferences.Editor editorEdit = this.f5228d.getSharedPreferences("cuidRelate", 0).edit();
            editorEdit.putInt("cuidoc", i4);
            editorEdit.putLong("cuidfreq", j4);
            editorEdit.apply();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static boolean a(WifiManager wifiManager) {
        try {
            if (!wifiManager.isWifiEnabled()) {
                if (!wifiManager.isScanAlwaysAvailable()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(LocationClientOption locationClientOption) {
        return locationClientOption != null && locationClientOption.isOnceLocation() && com.baidu.location.e.h.h(this.f5228d);
    }
}
