package com.baidu.location.b;

import android.content.Intent;
import android.location.Location;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.LruCache;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;
import com.baidu.location.PoiRegion;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.utils.Consts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static long f5124c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static int f5125d = -1;

    /* renamed from: a, reason: collision with root package name */
    public boolean f5126a;

    /* renamed from: b, reason: collision with root package name */
    boolean f5127b;

    /* renamed from: e, reason: collision with root package name */
    int f5128e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<a> f5129f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f5130g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f5131h;

    /* renamed from: i, reason: collision with root package name */
    private BDLocation f5132i;

    /* renamed from: j, reason: collision with root package name */
    private BDLocation f5133j;

    /* renamed from: k, reason: collision with root package name */
    private Object f5134k;

    /* renamed from: l, reason: collision with root package name */
    private long f5135l;

    /* renamed from: m, reason: collision with root package name */
    private LruCache<String, JSONObject> f5136m;

    /* renamed from: n, reason: collision with root package name */
    private String f5137n;

    /* renamed from: o, reason: collision with root package name */
    private String f5138o;

    /* renamed from: p, reason: collision with root package name */
    private String f5139p;

    /* renamed from: q, reason: collision with root package name */
    private final String[] f5140q;

    /* renamed from: r, reason: collision with root package name */
    private BDLocation f5141r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f5142s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f5143t;

    /* renamed from: u, reason: collision with root package name */
    private c f5144u;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public String f5145a;

        /* renamed from: b, reason: collision with root package name */
        public Messenger f5146b;

        /* renamed from: c, reason: collision with root package name */
        public LocationClientOption f5147c = new LocationClientOption();

        /* renamed from: d, reason: collision with root package name */
        public int f5148d = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f5149e;

        public a(Message message) {
            this.f5145a = null;
            this.f5146b = null;
            this.f5149e = 1;
            this.f5146b = message.replyTo;
            this.f5149e = message.arg1;
            this.f5145a = message.getData().getString("packName");
            this.f5147c.prodName = message.getData().getString("prodName");
            com.baidu.location.e.b.a().a(this.f5147c.prodName, this.f5145a);
            this.f5147c.coorType = message.getData().getString("coorType");
            this.f5147c.addrType = message.getData().getString("addrType");
            this.f5147c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            com.baidu.location.e.h.f5926l = com.baidu.location.e.h.f5926l || this.f5147c.enableSimulateGps;
            if (!com.baidu.location.e.h.f5919e.equals("all")) {
                com.baidu.location.e.h.f5919e = this.f5147c.addrType;
            }
            this.f5147c.openGps = message.getData().getBoolean("openGPS");
            this.f5147c.scanSpan = message.getData().getInt("scanSpan");
            this.f5147c.timeOut = message.getData().getInt("timeOut");
            this.f5147c.priority = message.getData().getInt("priority");
            this.f5147c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.f5147c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.f5147c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            this.f5147c.isNeedNewVersionRgc = message.getData().getBoolean("isneednewrgc", false);
            com.baidu.location.e.h.f5922h = com.baidu.location.e.h.f5922h || this.f5147c.isNeedNewVersionRgc;
            com.baidu.location.e.h.f5921g = com.baidu.location.e.h.f5921g || message.getData().getBoolean("isneedaptag", false);
            com.baidu.location.e.h.f5923i = com.baidu.location.e.h.f5923i || message.getData().getBoolean("isneedaptagd", false);
            com.baidu.location.e.h.f5907R = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i4 = message.getData().getInt("wfnum", com.baidu.location.e.h.ay);
            float f4 = message.getData().getFloat("wfsm", com.baidu.location.e.h.aA);
            int i5 = message.getData().getInt("gnmcon", com.baidu.location.e.h.aC);
            double d4 = message.getData().getDouble("gnmcrm", com.baidu.location.e.h.aB);
            int i6 = message.getData().getInt("iupl", 1);
            com.baidu.location.e.h.aR = message.getData().getInt("ct", 10);
            com.baidu.location.e.h.aS = message.getData().getInt("suci", 3);
            com.baidu.location.e.h.aU = message.getData().getDoubleArray("cgs");
            com.baidu.location.e.h.aV = message.getData().getInt("ums", 1);
            com.baidu.location.e.h.aT = message.getData().getInt("smn", 40);
            if (i6 <= 0) {
                com.baidu.location.e.h.aQ = 0;
            } else if (com.baidu.location.e.h.aQ == -1) {
                com.baidu.location.e.h.aQ = 1;
            }
            if (message.getData().getInt("opetco", 1) == 0) {
                com.baidu.location.e.h.aW = 0;
            }
            if (message.getData().getInt("lpcs", com.baidu.location.e.h.aX) == 0) {
                com.baidu.location.e.h.aX = 0;
            }
            if (i5 == 1) {
                com.baidu.location.e.h.aC = 1;
            }
            if (d4 > com.baidu.location.e.h.aB) {
                com.baidu.location.e.h.aB = d4;
            }
            com.baidu.location.e.h.ax = com.baidu.location.e.h.ax || message.getData().getBoolean("ischeckper", false);
            com.baidu.location.e.h.aY = com.baidu.location.e.h.aY || message.getData().getBoolean("isEnableBeidouMode", false);
            if (i4 > com.baidu.location.e.h.ay) {
                com.baidu.location.e.h.ay = i4;
            }
            if (f4 > com.baidu.location.e.h.aA) {
                com.baidu.location.e.h.aA = f4;
            }
            int i7 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
            if (i7 < com.baidu.location.e.h.af) {
                com.baidu.location.e.h.af = i7;
            }
            int i8 = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i8 >= com.baidu.location.e.h.f5911W) {
                com.baidu.location.e.h.f5911W = i8;
            }
            int i9 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i9 >= com.baidu.location.e.h.f5913Y) {
                com.baidu.location.e.h.f5913Y = i9;
            }
            int i10 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i10 >= com.baidu.location.e.h.f5912X) {
                com.baidu.location.e.h.f5912X = i10;
            }
            LocationClientOption locationClientOption = this.f5147c;
            if (locationClientOption.mIsNeedDeviceDirect || locationClientOption.isNeedAltitude) {
                u.a().a(this.f5147c.mIsNeedDeviceDirect);
                u.a().b();
            }
            b.this.f5127b = b.this.f5127b || this.f5147c.isNeedAltitude;
            if (message.getData().getInt("hpdts", com.baidu.location.e.h.aD) == 1) {
                com.baidu.location.e.h.aD = 1;
            } else {
                com.baidu.location.e.h.aD = 0;
            }
            if (message.getData().getInt("oldts", com.baidu.location.e.h.aE) == 1) {
                com.baidu.location.e.h.aE = 1;
            } else {
                com.baidu.location.e.h.aE = 0;
            }
            int i11 = message.getData().getInt("onic", com.baidu.location.e.h.aF);
            if (i11 == 0) {
                com.baidu.location.e.h.aF = i11;
            }
            int i12 = message.getData().getInt("nlcs", com.baidu.location.e.h.aG);
            if (i12 == 1) {
                com.baidu.location.e.h.aG = i12;
            }
            com.baidu.location.e.h.aH = message.getData().getFloat("ncsr", com.baidu.location.e.h.aH);
            com.baidu.location.e.h.aI = message.getData().getFloat("cscr", com.baidu.location.e.h.aI);
            com.baidu.location.e.h.aJ = message.getData().getInt("cls", com.baidu.location.e.h.aJ);
            int[] intArray = message.getData().getIntArray("ocs");
            com.baidu.location.e.h.aK = intArray;
            com.baidu.location.e.h.aL = com.baidu.location.e.h.a(intArray);
            com.baidu.location.e.h.aM = message.getData().getInt("topCellNumber");
            com.baidu.location.e.h.aN = message.getData().getInt("locStrLength");
            com.baidu.location.e.h.aO = message.getData().getInt("hils");
            com.baidu.location.c.f.a().a((WifiInfo) null, message.getData().getString("connectBssid", null));
        }

        private double a(boolean z4, BDLocation bDLocation, BDLocation bDLocation2) {
            double d4;
            double latitude;
            double longitude;
            double latitude2;
            double longitude2;
            double dA;
            double[] dArrCoorEncrypt;
            if (z4) {
                if (!TextUtils.equals(bDLocation2.getCoorType(), bDLocation.getCoorType())) {
                    if (TextUtils.equals("wgs84", bDLocation.getCoorType())) {
                        dArrCoorEncrypt = new double[]{bDLocation.getLongitude(), bDLocation.getLatitude()};
                    } else {
                        double[] dArrCoorEncrypt2 = TextUtils.equals("bd09", bDLocation.getCoorType()) ? Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02) : TextUtils.equals("bd09ll", bDLocation.getCoorType()) ? Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09LL_TO_GCJ02) : new double[]{bDLocation.getLongitude(), bDLocation.getLatitude()};
                        dArrCoorEncrypt = Jni.coorEncrypt(dArrCoorEncrypt2[0], dArrCoorEncrypt2[1], "gcj2wgs");
                    }
                    bDLocation.setLatitude(dArrCoorEncrypt[1]);
                    d4 = dArrCoorEncrypt[0];
                    bDLocation.setLongitude(d4);
                    bDLocation.setTime(com.baidu.location.e.h.a());
                    bDLocation.setCoorType("wgs84");
                    dA = com.baidu.location.e.h.a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
                } else if (TextUtils.equals("bd09", bDLocation2.getCoorType())) {
                    double[] dArrCoorEncrypt3 = Jni.coorEncrypt(bDLocation2.getLongitude(), bDLocation2.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02);
                    double[] dArrCoorEncrypt4 = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), BDLocation.BDLOCATION_BD09_TO_GCJ02);
                    latitude = dArrCoorEncrypt3[1];
                    longitude = dArrCoorEncrypt3[0];
                    latitude2 = dArrCoorEncrypt4[1];
                    longitude2 = dArrCoorEncrypt4[0];
                    dA = com.baidu.location.e.h.a(latitude, longitude, latitude2, longitude2);
                } else {
                    dA = com.baidu.location.e.h.a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
                }
            } else if (TextUtils.equals(bDLocation2.getCoorType(), bDLocation.getCoorType())) {
                latitude = bDLocation2.getLatitude();
                longitude = bDLocation2.getLongitude();
                latitude2 = bDLocation.getLatitude();
                longitude2 = bDLocation.getLongitude();
                dA = com.baidu.location.e.h.a(latitude, longitude, latitude2, longitude2);
            } else {
                double[] dArrCoorEncrypt5 = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), "gcj2wgs");
                bDLocation.setLatitude(dArrCoorEncrypt5[1]);
                d4 = dArrCoorEncrypt5[0];
                bDLocation.setLongitude(d4);
                bDLocation.setTime(com.baidu.location.e.h.a());
                bDLocation.setCoorType("wgs84");
                dA = com.baidu.location.e.h.a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude());
            }
            bDLocation2.setDisToRealLocation(dA);
            if (bDLocation != null) {
                bDLocation2.setReallLocation(bDLocation);
            }
            return dA;
        }

        private BDLocation b() {
            BDLocation bDLocationH = com.baidu.location.c.d.a().h();
            if (bDLocationH == null) {
                return null;
            }
            double[] dArrCoorEncrypt = Jni.coorEncrypt(bDLocationH.getLongitude(), bDLocationH.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            double[] dArrCoorEncrypt2 = Jni.coorEncrypt(dArrCoorEncrypt[0], dArrCoorEncrypt[1], this.f5147c.coorType);
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLongitude(dArrCoorEncrypt2[0]);
            bDLocation.setLatitude(dArrCoorEncrypt2[1]);
            bDLocation.setTime(com.baidu.location.e.h.a());
            bDLocation.setLocType(61);
            bDLocation.setCoorType(this.f5147c.coorType);
            return bDLocation;
        }

        private BDLocation c() {
            BDLocation bDLocationH = com.baidu.location.c.d.a().h();
            if (bDLocationH == null) {
                return null;
            }
            double[] dArrCoorEncrypt = Jni.coorEncrypt(bDLocationH.getLongitude(), bDLocationH.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLongitude(dArrCoorEncrypt[0]);
            bDLocation.setLatitude(dArrCoorEncrypt[1]);
            bDLocation.setTime(com.baidu.location.e.h.a());
            bDLocation.setLocType(61);
            bDLocation.setCoorType("gcj02");
            return bDLocation;
        }

        private int a(double d4) {
            if (d4 >= 0.0d && d4 <= 10.0d) {
                return 0;
            }
            if (d4 <= 10.0d || d4 > 100.0d) {
                return (d4 <= 100.0d || d4 > 200.0d) ? 3 : 2;
            }
            return 1;
        }

        public int a(int i4, boolean z4, BDLocation bDLocation) {
            double dA;
            if (i4 == 100) {
                if (z4) {
                    BDLocation bDLocationB = b();
                    if (bDLocationB == null) {
                        return 3;
                    }
                    a(true, bDLocationB, bDLocation);
                    return 3;
                }
                BDLocation bDLocationC = c();
                if (bDLocationC == null) {
                    return 3;
                }
                a(false, bDLocationC, bDLocation);
                return 3;
            }
            if (i4 == 200 || i4 == 300) {
                return 1;
            }
            if (i4 != 400) {
                return i4 == 500 ? 1 : 0;
            }
            if (z4) {
                BDLocation bDLocationB2 = b();
                if (bDLocationB2 == null) {
                    return -1;
                }
                dA = a(true, bDLocationB2, bDLocation);
            } else {
                BDLocation bDLocationC2 = c();
                if (bDLocationC2 == null) {
                    return -1;
                }
                dA = a(false, bDLocationC2, bDLocation);
            }
            return a(dA);
        }

        public void a() throws RemoteException {
            if (this.f5147c.location_change_notify) {
                a(com.baidu.location.e.h.f5916b ? 54 : 55);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i4) throws RemoteException {
            Message messageObtain = Message.obtain((Handler) null, i4);
            try {
                Messenger messenger = this.f5146b;
                if (messenger != null) {
                    messenger.send(messageObtain);
                }
                this.f5148d = 0;
            } catch (Exception e4) {
                if (e4 instanceof DeadObjectException) {
                    this.f5148d++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i4, Bundle bundle) throws RemoteException {
            Message messageObtain = Message.obtain((Handler) null, i4);
            messageObtain.setData(bundle);
            try {
                Messenger messenger = this.f5146b;
                if (messenger != null) {
                    messenger.send(messageObtain);
                }
                this.f5148d = 0;
            } catch (Exception e4) {
                if (e4 instanceof DeadObjectException) {
                    this.f5148d++;
                }
                e4.printStackTrace();
            }
        }

        private void a(int i4, String str, BDLocation bDLocation) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putParcelable(str, bDLocation);
            bundle.setClassLoader(BDLocation.class.getClassLoader());
            Message messageObtain = Message.obtain((Handler) null, i4);
            messageObtain.setData(bundle);
            try {
                Messenger messenger = this.f5146b;
                if (messenger != null) {
                    messenger.send(messageObtain);
                }
                this.f5148d = 0;
            } catch (Exception e4) {
                if (e4 instanceof DeadObjectException) {
                    this.f5148d++;
                }
            }
        }

        public void a(BDLocation bDLocation) throws RemoteException {
            a(bDLocation, 21);
        }

        public void a(BDLocation bDLocation, int i4) throws RemoteException {
            int iA;
            String str;
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (i4 == 21) {
                a(27, "locStr", bDLocation2);
            }
            String str2 = this.f5147c.coorType;
            if (str2 != null && !str2.equals("gcj02")) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (longitude != Double.MIN_VALUE && latitude != Double.MIN_VALUE) {
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("gcj02")) || bDLocation2.getCoorType() == null) {
                        double[] dArrCoorEncrypt = Jni.coorEncrypt(longitude, latitude, this.f5147c.coorType);
                        bDLocation2.setLongitude(dArrCoorEncrypt[0]);
                        bDLocation2.setLatitude(dArrCoorEncrypt[1]);
                        str = this.f5147c.coorType;
                    } else if (bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals("wgs84") && !this.f5147c.coorType.equals("bd09ll")) {
                        double[] dArrCoorEncrypt2 = Jni.coorEncrypt(longitude, latitude, "wgs842mc");
                        bDLocation2.setLongitude(dArrCoorEncrypt2[0]);
                        bDLocation2.setLatitude(dArrCoorEncrypt2[1]);
                        str = "wgs84mc";
                    }
                    bDLocation2.setCoorType(str);
                }
                if (!com.baidu.location.e.h.f5926l && bDLocation2.getMockGpsStrategy() > 0) {
                    iA = a(bDLocation2.getMockGpsStrategy(), true, bDLocation2);
                    bDLocation2.setMockGpsProbability(iA);
                }
            } else if (!com.baidu.location.e.h.f5926l && bDLocation2.getMockGpsStrategy() > 0) {
                iA = a(bDLocation2.getMockGpsStrategy(), false, bDLocation2);
                bDLocation2.setMockGpsProbability(iA);
            }
            a(i4, "locStr", bDLocation2);
        }
    }

    /* renamed from: com.baidu.location.b.b$b, reason: collision with other inner class name */
    public static class C0009b {

        /* renamed from: a, reason: collision with root package name */
        private static b f5151a = new b();
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f5152a;

        /* renamed from: b, reason: collision with root package name */
        private int f5153b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f5154c;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5154c) {
                return;
            }
            this.f5153b++;
            this.f5152a.f5143t = false;
        }
    }

    private b() throws JSONException {
        this.f5129f = null;
        this.f5130g = false;
        this.f5131h = true;
        this.f5126a = false;
        this.f5127b = false;
        this.f5132i = null;
        this.f5133j = null;
        this.f5134k = new Object();
        this.f5135l = -1L;
        this.f5137n = null;
        this.f5138o = null;
        this.f5139p = null;
        this.f5140q = new String[]{"name", "mac", "onLng", "onLat", "onLocType", "onTime", "offLng", "offLat", "offLocType", "offTime"};
        this.f5128e = 0;
        this.f5141r = null;
        this.f5142s = false;
        this.f5143t = false;
        this.f5144u = null;
        this.f5129f = new ArrayList<>();
        this.f5136m = new LruCache<>(3);
        this.f5138o = s.a().a("sp_loc_map_end_str", "");
        this.f5137n = s.a().a("sp_loc_navi_end_str", "");
        this.f5139p = s.a().a("sp_loc_last_navi_end_str", "");
        String strA = s.a().a("sp_bluetooth_info", "");
        if (strA == null || "".equals(strA)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(strA);
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                this.f5136m.put(jSONObject.getString("mac"), jSONObject);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }

    private a a(Messenger messenger) {
        if (this.f5129f == null) {
            return null;
        }
        try {
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        synchronized (this.f5134k) {
            try {
                Iterator<a> it = this.f5129f.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    if (next.f5146b.equals(messenger)) {
                        return next;
                    }
                }
                return null;
            } finally {
            }
        }
    }

    private void f() throws Throwable {
        boolean z4;
        boolean z5 = false;
        try {
            try {
                synchronized (this.f5134k) {
                    try {
                        Iterator<a> it = this.f5129f.iterator();
                        z4 = false;
                        while (it.hasNext()) {
                            LocationClientOption locationClientOption = it.next().f5147c;
                            if (locationClientOption.openGps) {
                                z5 = true;
                            }
                            if (locationClientOption.location_change_notify) {
                                z4 = true;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        z4 = false;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            e = e4;
            z4 = false;
        }
        try {
            throw th;
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            com.baidu.location.e.h.f5915a = z4;
            if (this.f5130g != z5 || (!com.baidu.location.c.d.a().k() && this.f5130g)) {
                this.f5130g = z5;
                com.baidu.location.c.d.a().a(this.f5130g);
            }
        }
    }

    private void g() {
        try {
            Iterator<a> it = this.f5129f.iterator();
            while (it.hasNext()) {
                com.baidu.location.e.h.f5920f = Math.min(com.baidu.location.e.h.f5920f, it.next().f5147c.priority);
            }
            if (com.baidu.location.f.isServing) {
                return;
            }
            com.baidu.location.e.h.f5920f = 4;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void b() {
        synchronized (this.f5134k) {
            try {
                ArrayList<a> arrayList = this.f5129f;
                if (arrayList != null) {
                    arrayList.clear();
                }
            } catch (Throwable unused) {
            }
        }
        this.f5132i = null;
        e();
    }

    public String c() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.f5129f.isEmpty()) {
            return "&prod=" + com.baidu.location.e.b.f5799f + AwarenessDataItem.USERID_SPLITTER + com.baidu.location.e.b.f5798e;
        }
        String string = stringBuffer.toString();
        try {
            a aVar = this.f5129f.get(0);
            String str = aVar.f5147c.prodName;
            if (str != null) {
                stringBuffer.append(str);
            }
            if (aVar.f5145a != null) {
                stringBuffer.append(AwarenessDataItem.USERID_SPLITTER);
                stringBuffer.append(aVar.f5145a);
                stringBuffer.append(Consts.SPLITTER_DETAIL);
            }
            if (string != null && !string.equals("")) {
                return "&prod=".concat(string);
            }
            return "&prod=" + com.baidu.location.e.b.f5799f + AwarenessDataItem.USERID_SPLITTER + com.baidu.location.e.b.f5798e;
        } catch (Exception unused) {
            return "&prod=" + com.baidu.location.e.b.f5799f + AwarenessDataItem.USERID_SPLITTER + com.baidu.location.e.b.f5798e;
        }
    }

    public int d(Message message) {
        Messenger messenger;
        a aVarA;
        if (message == null || (messenger = message.replyTo) == null || (aVarA = a(messenger)) == null || aVarA.f5147c == null) {
            return 1;
        }
        return com.baidu.location.e.h.f5920f;
    }

    public int e(Message message) {
        Messenger messenger;
        a aVarA;
        LocationClientOption locationClientOption;
        if (message == null || (messenger = message.replyTo) == null || (aVarA = a(messenger)) == null || (locationClientOption = aVarA.f5147c) == null) {
            return 1000;
        }
        return locationClientOption.scanSpan;
    }

    public static b a() {
        return C0009b.f5151a;
    }

    private void e() throws Throwable {
        f();
        d();
        g();
    }

    public void b(Message message) {
        synchronized (this.f5134k) {
            try {
                a aVarA = a(message.replyTo);
                if (aVarA != null) {
                    this.f5129f.remove(aVarA);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        u.a().c();
        e();
        if (this.f5142s) {
            a("stop");
            this.f5128e = 0;
        }
    }

    public void c(BDLocation bDLocation) {
        Address addressA = p.c().a(bDLocation);
        String strF = p.c().f();
        List<Poi> listG = p.c().g();
        PoiRegion poiRegionH = p.c().h();
        if (addressA != null) {
            bDLocation.setAddr(addressA);
        }
        if (strF != null) {
            bDLocation.setLocationDescribe(strF);
        }
        if (listG != null) {
            bDLocation.setPoiList(listG);
        }
        if (poiRegionH != null) {
            bDLocation.setPoiRegion(poiRegionH);
        }
        a(bDLocation);
        p.c().c(bDLocation);
    }

    public void d() {
        try {
            synchronized (this.f5134k) {
                try {
                    Iterator<a> it = this.f5129f.iterator();
                    while (it.hasNext()) {
                        it.next().a();
                    }
                } finally {
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(Bundle bundle, int i4) {
        synchronized (this.f5134k) {
            Iterator<a> it = this.f5129f.iterator();
            while (it.hasNext()) {
                try {
                    a next = it.next();
                    next.a(i4, bundle);
                    if (next.f5148d > 4) {
                        it.remove();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void b(BDLocation bDLocation) {
        BDLocation bDLocation2;
        if (bDLocation == null || bDLocation.getLocType() != 161 || com.baidu.location.a.a.a().c()) {
            synchronized (this.f5134k) {
                Iterator<a> it = this.f5129f.iterator();
                while (it.hasNext()) {
                    try {
                        a next = it.next();
                        next.a(bDLocation);
                        if (next.f5148d > 4) {
                            it.remove();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        } else {
            if (this.f5133j == null) {
                BDLocation bDLocation3 = new BDLocation();
                this.f5133j = bDLocation3;
                bDLocation3.setLocType(505);
            }
            synchronized (this.f5134k) {
                Iterator<a> it2 = this.f5129f.iterator();
                while (it2.hasNext()) {
                    try {
                        a next2 = it2.next();
                        next2.a(this.f5133j);
                        if (next2.f5148d > 4) {
                            it2.remove();
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        if (bDLocation != null && (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66)) {
            com.baidu.location.b.c.b().a(bDLocation.getLatitude(), bDLocation.getLongitude());
            com.baidu.location.b.c.b().a(bDLocation.getCityCode());
        }
        boolean z4 = p.f5394j;
        if (z4) {
            p.f5394j = false;
        }
        if (com.baidu.location.e.h.f5911W >= 10000) {
            if (bDLocation.getLocType() == 61 || bDLocation.getLocType() == 161 || bDLocation.getLocType() == 66) {
                BDLocation bDLocation4 = this.f5132i;
                if (bDLocation4 != null) {
                    float[] fArr = new float[1];
                    Location.distanceBetween(bDLocation4.getLatitude(), this.f5132i.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                    if (fArr[0] <= com.baidu.location.e.h.f5913Y && !z4) {
                        return;
                    }
                    this.f5132i = null;
                    bDLocation2 = new BDLocation(bDLocation);
                } else {
                    bDLocation2 = new BDLocation(bDLocation);
                }
                this.f5132i = bDLocation2;
            }
        }
    }

    public boolean c(Message message) {
        a aVarA = a(message.replyTo);
        if (aVarA == null) {
            return false;
        }
        LocationClientOption locationClientOption = aVarA.f5147c;
        int i4 = locationClientOption.scanSpan;
        locationClientOption.scanSpan = message.getData().getInt("scanSpan", aVarA.f5147c.scanSpan);
        if (aVarA.f5147c.scanSpan < 1000) {
            u.a().c();
            this.f5126a = false;
        } else {
            this.f5126a = true;
        }
        LocationClientOption locationClientOption2 = aVarA.f5147c;
        if (locationClientOption2.scanSpan > 999 && i4 < 1000) {
            if (locationClientOption2.mIsNeedDeviceDirect || locationClientOption2.isNeedAltitude) {
                u.a().a(aVarA.f5147c.mIsNeedDeviceDirect);
                u.a().b();
            }
            this.f5127b = this.f5127b || aVarA.f5147c.isNeedAltitude;
            z = true;
        }
        aVarA.f5147c.openGps = message.getData().getBoolean("openGPS", aVarA.f5147c.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption3 = aVarA.f5147c;
        if (string == null || string.equals("")) {
            string = aVarA.f5147c.coorType;
        }
        locationClientOption3.coorType = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption4 = aVarA.f5147c;
        if (string2 == null || string2.equals("")) {
            string2 = aVarA.f5147c.addrType;
        }
        locationClientOption4.addrType = string2;
        if (!com.baidu.location.e.h.f5919e.equals(aVarA.f5147c.addrType)) {
            p.c().k();
        }
        aVarA.f5147c.timeOut = message.getData().getInt("timeOut", aVarA.f5147c.timeOut);
        aVarA.f5147c.location_change_notify = message.getData().getBoolean("location_change_notify", aVarA.f5147c.location_change_notify);
        aVarA.f5147c.priority = message.getData().getInt("priority", aVarA.f5147c.priority);
        com.baidu.location.e.h.f5920f = aVarA.f5147c.priority;
        int i5 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
        if (i5 < com.baidu.location.e.h.af) {
            com.baidu.location.e.h.af = i5;
        }
        e();
        return z;
    }

    public void d(BDLocation bDLocation) {
        c(bDLocation);
    }

    public void a(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        f5124c = System.currentTimeMillis();
        this.f5126a = true;
        com.baidu.location.c.f.a().i();
        a(new a(message));
        e();
        if (this.f5142s) {
            a("start");
            this.f5128e = 0;
        }
    }

    public void a(BDLocation bDLocation) {
        b(bDLocation);
    }

    private void a(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.f5134k) {
            try {
                if (a(aVar.f5146b) != null) {
                    aVar.a(14);
                } else {
                    this.f5129f.add(aVar);
                    aVar.a(13);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void a(String str) {
        Intent intent = new Intent("com.baidu.location.flp.log");
        intent.setPackage("com.baidu.baidulocationdemo");
        intent.putExtra("data", str);
        intent.putExtra("pack", com.baidu.location.e.b.f5798e);
        intent.putExtra("tag", "state");
        com.baidu.location.f.getServiceContext().sendBroadcast(intent);
    }

    public void a(boolean z4) {
        this.f5126a = z4;
        f5125d = z4 ? 1 : 0;
    }
}
