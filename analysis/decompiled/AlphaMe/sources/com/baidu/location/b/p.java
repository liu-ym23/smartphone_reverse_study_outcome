package com.baidu.location.b;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.PoiRegion;
import com.baidu.location.b.m;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class p extends m {

    /* renamed from: h, reason: collision with root package name */
    public static String f5393h = "0";

    /* renamed from: j, reason: collision with root package name */
    public static boolean f5394j = false;

    /* renamed from: k, reason: collision with root package name */
    private static p f5395k;

    /* renamed from: B, reason: collision with root package name */
    private long f5397B;

    /* renamed from: F, reason: collision with root package name */
    private double f5401F;

    /* renamed from: G, reason: collision with root package name */
    private double f5402G;

    /* renamed from: g, reason: collision with root package name */
    public m.c f5421g;

    /* renamed from: l, reason: collision with root package name */
    private boolean f5423l = true;

    /* renamed from: m, reason: collision with root package name */
    private String f5424m = null;

    /* renamed from: n, reason: collision with root package name */
    private BDLocation f5425n = null;

    /* renamed from: o, reason: collision with root package name */
    private BDLocation f5426o = null;

    /* renamed from: p, reason: collision with root package name */
    private Location f5427p = null;

    /* renamed from: q, reason: collision with root package name */
    private com.baidu.location.c.k f5428q = null;

    /* renamed from: r, reason: collision with root package name */
    private com.baidu.location.c.a f5429r = null;

    /* renamed from: s, reason: collision with root package name */
    private HashSet<String> f5430s = null;

    /* renamed from: t, reason: collision with root package name */
    private com.baidu.location.c.k f5431t = null;

    /* renamed from: u, reason: collision with root package name */
    private com.baidu.location.c.a f5432u = null;

    /* renamed from: v, reason: collision with root package name */
    private boolean f5433v = true;

    /* renamed from: w, reason: collision with root package name */
    private volatile boolean f5434w = false;

    /* renamed from: x, reason: collision with root package name */
    private boolean f5435x = false;

    /* renamed from: y, reason: collision with root package name */
    private long f5436y = 0;

    /* renamed from: z, reason: collision with root package name */
    private long f5437z = 0;

    /* renamed from: A, reason: collision with root package name */
    private Address f5396A = null;

    /* renamed from: C, reason: collision with root package name */
    private String f5398C = null;

    /* renamed from: D, reason: collision with root package name */
    private List<Poi> f5399D = null;

    /* renamed from: E, reason: collision with root package name */
    private PoiRegion f5400E = null;

    /* renamed from: H, reason: collision with root package name */
    private boolean f5403H = false;

    /* renamed from: I, reason: collision with root package name */
    private long f5404I = 0;

    /* renamed from: J, reason: collision with root package name */
    private long f5405J = 0;

    /* renamed from: K, reason: collision with root package name */
    private a f5406K = null;

    /* renamed from: L, reason: collision with root package name */
    private boolean f5407L = false;

    /* renamed from: M, reason: collision with root package name */
    private boolean f5408M = false;

    /* renamed from: N, reason: collision with root package name */
    private boolean f5409N = true;

    /* renamed from: i, reason: collision with root package name */
    public final Handler f5422i = new m.b();

    /* renamed from: O, reason: collision with root package name */
    private boolean f5410O = false;

    /* renamed from: P, reason: collision with root package name */
    private boolean f5411P = false;

    /* renamed from: Q, reason: collision with root package name */
    private b f5412Q = null;

    /* renamed from: R, reason: collision with root package name */
    private boolean f5413R = false;

    /* renamed from: S, reason: collision with root package name */
    private int f5414S = 0;
    private long T = 0;

    /* renamed from: U, reason: collision with root package name */
    private boolean f5415U = false;

    /* renamed from: V, reason: collision with root package name */
    private String f5416V = null;

    /* renamed from: W, reason: collision with root package name */
    private boolean f5417W = false;

    /* renamed from: X, reason: collision with root package name */
    private boolean f5418X = false;

    /* renamed from: Y, reason: collision with root package name */
    private boolean f5419Y = false;

    /* renamed from: Z, reason: collision with root package name */
    private long f5420Z = 0;
    private Address aa = null;
    private boolean ab = true;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f5439a;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5439a.f5407L) {
                this.f5439a.f5407L = false;
                boolean unused = this.f5439a.f5408M;
            }
        }
    }

    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.f5413R) {
                p.this.f5413R = false;
            }
            if (p.this.f5435x) {
                p.this.f5435x = false;
                p.this.h(null);
            }
        }
    }

    private p() {
        this.f5421g = null;
        this.f5421g = new m.c();
        this.f5349e = new m.a();
    }

    public static synchronized p c() {
        try {
            if (f5395k == null) {
                f5395k = new p();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f5395k;
    }

    private void l() {
        try {
            String str = null;
            String strA = s.a().a("FirstLocAddr", (String) null);
            if (strA != null) {
                String[] strArrSplit = new String(Base64.decode(strA.getBytes(), 0)).split("_");
                if (strArrSplit.length == 2) {
                    this.f5420Z = Long.parseLong(strArrSplit[0]);
                    str = strArrSplit[1];
                }
                if (str != null) {
                    String[] strArrSplit2 = str.split(";");
                    if (strArrSplit2.length == 11) {
                        this.aa = new Address.Builder().country(strArrSplit2[0]).countryCode(strArrSplit2[1]).province(strArrSplit2[2]).city(strArrSplit2[3]).cityCode(strArrSplit2[4]).district(strArrSplit2[5]).street(strArrSplit2[6]).streetNumber(strArrSplit2[7]).adcode(strArrSplit2[8]).town(strArrSplit2[9]).townCode(strArrSplit2[10]).build();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private String[] m() {
        boolean z4;
        f fVarA;
        int i4;
        String[] strArr = {"", "Location failed beacuse we can not get any loc information!"};
        StringBuffer stringBuffer = new StringBuffer("&apl=");
        int iA = com.baidu.location.e.h.a(com.baidu.location.f.getServiceContext());
        String str = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        if (iA == 1) {
            strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        stringBuffer.append(iA);
        String strD = com.baidu.location.e.h.d(com.baidu.location.f.getServiceContext());
        if (strD.contains("per=0|0|")) {
            strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        stringBuffer.append(strD);
        stringBuffer.append("&loc=");
        int iB = com.baidu.location.e.h.b(com.baidu.location.f.getServiceContext());
        if (iB == 0) {
            strArr[1] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
            z4 = true;
        } else {
            z4 = false;
        }
        stringBuffer.append(iB);
        stringBuffer.append("&lmd=");
        int iB2 = com.baidu.location.e.h.b(com.baidu.location.f.getServiceContext());
        if (iB2 >= 0) {
            stringBuffer.append(iB2);
        }
        String strH = com.baidu.location.c.f.a().h();
        String strN = com.baidu.location.c.f.a().n();
        stringBuffer.append(strN);
        stringBuffer.append(strH);
        stringBuffer.append(com.baidu.location.e.h.e(com.baidu.location.f.getServiceContext()));
        if (iA != 1) {
            if (strD.contains("per=0|0|")) {
                f.a().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
            } else if (z4) {
                f.a().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
            } else if (strH != null && strN != null && strH.equals("&sim=1") && !strN.equals("&wifio=1")) {
                fVarA = f.a();
                i4 = 6;
                str = "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!";
            } else if (!com.baidu.location.e.h.h(com.baidu.location.f.getServiceContext())) {
                f.a().a(62, 9, "Location failed beacuse we can not get any loc information!");
            }
            strArr[0] = stringBuffer.toString();
            return strArr;
        }
        fVarA = f.a();
        i4 = 7;
        fVarA.a(62, i4, str);
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    private void n() {
        this.f5434w = false;
        this.f5408M = false;
        this.f5409N = false;
        this.f5403H = false;
        o();
        if (this.ab) {
            this.ab = false;
        }
    }

    private void o() {
        if (this.f5425n == null || !com.baidu.location.c.f.a().l()) {
            return;
        }
        aa.a().d();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.baidu.location.Address a(com.baidu.location.BDLocation r12) {
        /*
            r11 = this;
            java.lang.String r0 = com.baidu.location.e.h.f5919e
            java.lang.String r1 = "all"
            boolean r0 = r0.equals(r1)
            r1 = 0
            if (r0 != 0) goto L13
            boolean r0 = com.baidu.location.e.h.f5921g
            if (r0 != 0) goto L13
            boolean r0 = com.baidu.location.e.h.f5923i
            if (r0 == 0) goto L35
        L13:
            r0 = 2
            float[] r0 = new float[r0]
            double r2 = r11.f5402G
            double r4 = r11.f5401F
            double r6 = r12.getLatitude()
            double r8 = r12.getLongitude()
            r10 = r0
            android.location.Location.distanceBetween(r2, r4, r6, r8, r10)
            r12 = 0
            r12 = r0[r12]
            double r2 = (double) r12
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L36
            com.baidu.location.Address r11 = r11.f5396A
            if (r11 == 0) goto L35
            return r11
        L35:
            return r1
        L36:
            com.baidu.location.Address r0 = r11.f5396A
            if (r0 != 0) goto L4a
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r11.f5420Z
            long r2 = r2 - r4
            r4 = 3000(0xbb8, double:1.482E-320)
            int r12 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r12 >= 0) goto La6
            com.baidu.location.Address r12 = r11.aa
            goto La7
        L4a:
            double r2 = (double) r12
            r4 = 4652007308841189376(0x408f400000000000, double:1000.0)
            int r12 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r12 >= 0) goto La6
            com.baidu.location.Address$Builder r12 = new com.baidu.location.Address$Builder
            r12.<init>()
            com.baidu.location.Address r0 = r11.f5396A
            java.lang.String r0 = r0.country
            com.baidu.location.Address$Builder r12 = r12.country(r0)
            com.baidu.location.Address r0 = r11.f5396A
            java.lang.String r0 = r0.countryCode
            com.baidu.location.Address$Builder r12 = r12.countryCode(r0)
            com.baidu.location.Address r0 = r11.f5396A
            java.lang.String r0 = r0.province
            com.baidu.location.Address$Builder r12 = r12.province(r0)
            com.baidu.location.Address r0 = r11.f5396A
            java.lang.String r0 = r0.city
            com.baidu.location.Address$Builder r12 = r12.city(r0)
            com.baidu.location.Address r0 = r11.f5396A
            java.lang.String r0 = r0.cityCode
            com.baidu.location.Address$Builder r12 = r12.cityCode(r0)
            com.baidu.location.Address r0 = r11.f5396A
            java.lang.String r0 = r0.district
            com.baidu.location.Address$Builder r12 = r12.district(r0)
            com.baidu.location.Address r0 = r11.f5396A
            java.lang.String r0 = r0.adcode
            com.baidu.location.Address$Builder r12 = r12.adcode(r0)
            com.baidu.location.Address r0 = r11.f5396A
            java.lang.String r0 = r0.town
            com.baidu.location.Address$Builder r12 = r12.town(r0)
            com.baidu.location.Address r0 = r11.f5396A
            java.lang.String r0 = r0.townCode
            com.baidu.location.Address$Builder r12 = r12.townCode(r0)
            com.baidu.location.Address r12 = r12.build()
            goto La7
        La6:
            r12 = r1
        La7:
            r11.f5398C = r1
            r11.f5399D = r1
            r11.f5400E = r1
            r0 = 1
            r11.f5403H = r0
            android.os.Handler r0 = r11.f5422i
            com.baidu.location.b.p$1 r1 = new com.baidu.location.b.p$1
            r1.<init>()
            r0.post(r1)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.p.a(com.baidu.location.BDLocation):com.baidu.location.Address");
    }

    public void b(Message message) {
        if (this.f5410O) {
            c(message);
        }
    }

    public void d() {
        this.f5433v = true;
        this.f5434w = false;
        this.f5410O = true;
        l();
    }

    public void e() {
        this.f5434w = false;
        this.f5435x = false;
        this.f5408M = false;
        this.f5409N = true;
        k();
        this.f5410O = false;
    }

    public String f() {
        return this.f5398C;
    }

    public List<Poi> g() {
        return this.f5399D;
    }

    public PoiRegion h() {
        return this.f5400E;
    }

    public void i() {
        if (this.f5435x) {
            h(null);
            this.f5435x = false;
        }
    }

    public boolean j() {
        return this.f5419Y;
    }

    public void k() {
        this.f5425n = null;
    }

    private void c(Message message) {
        if (!com.baidu.location.e.h.c(com.baidu.location.f.getServiceContext())) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.b.b.a().a(bDLocation);
            return;
        }
        if (com.baidu.location.e.h.b()) {
            Log.d("baidu_location_service", "isInforbiddenTime on request location ...");
        }
        if (message.getData().getBoolean("isWaitingLocTag", false)) {
            f5394j = true;
        }
        com.baidu.location.c.c.a().a(com.baidu.location.f.getServiceContext());
        int iD = com.baidu.location.b.b.a().d(message);
        if (iD == 1) {
            d(message);
            return;
        }
        if (iD == 2) {
            if (com.baidu.location.c.d.a().j()) {
                e(message);
            }
        } else {
            if (iD != 3 && iD != 4) {
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(iD)));
            }
            g(message);
        }
    }

    private void d(Message message) {
        if (com.baidu.location.c.d.a().j()) {
            e(message);
            u.a().c();
        } else {
            g(message);
            u.a().b();
        }
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.c.d.a().f());
        Location locationG = com.baidu.location.c.d.a().g();
        if (locationG != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(locationG.getProvider())) {
            bDLocation.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
        }
        if (locationG != null) {
            bDLocation.setExtrainfo(locationG.getExtras());
        }
        if (com.baidu.location.e.h.f5919e.equals("all") || com.baidu.location.e.h.f5921g || com.baidu.location.e.h.f5923i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.f5402G, this.f5401F, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                Address address = this.f5396A;
                if (address != null) {
                    bDLocation.setAddr(address);
                }
                String str = this.f5398C;
                if (str != null) {
                    bDLocation.setLocationDescribe(str);
                }
                List<Poi> list = this.f5399D;
                if (list != null) {
                    bDLocation.setPoiList(list);
                }
                PoiRegion poiRegion = this.f5400E;
                if (poiRegion != null) {
                    bDLocation.setPoiRegion(poiRegion);
                }
            } else {
                this.f5403H = true;
                g(null);
            }
        }
        this.f5425n = bDLocation;
        this.f5426o = null;
        d(bDLocation);
    }

    private void f(Message message) {
        b bVar;
        if (!com.baidu.location.c.f.a().k()) {
            h(message);
            return;
        }
        this.f5435x = true;
        if (this.f5412Q == null) {
            this.f5412Q = new b();
        }
        if (this.f5413R && (bVar = this.f5412Q) != null) {
            this.f5422i.removeCallbacks(bVar);
        }
        this.f5422i.postDelayed(this.f5412Q, 3500L);
        this.f5413R = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Message message) {
        this.f5414S = 0;
        if (!this.f5433v) {
            f(message);
            this.f5405J = SystemClock.uptimeMillis();
            return;
        }
        this.f5414S = 1;
        this.f5405J = SystemClock.uptimeMillis();
        if (com.baidu.location.c.f.a().b(com.baidu.location.e.h.af)) {
            f(message);
        } else {
            h(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(android.os.Message r19) {
        /*
            Method dump skipped, instructions count: 695
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.p.h(android.os.Message):void");
    }

    @Override // com.baidu.location.b.m
    public void a() {
        a aVar = this.f5406K;
        if (aVar != null && this.f5407L) {
            this.f5407L = false;
            this.f5422i.removeCallbacks(aVar);
        }
        if (com.baidu.location.c.d.a().j()) {
            BDLocation bDLocation = new BDLocation(com.baidu.location.c.d.a().f());
            Location locationG = com.baidu.location.c.d.a().g();
            if (locationG != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(locationG.getProvider())) {
                bDLocation.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
            }
            if (locationG != null) {
                bDLocation.setExtrainfo(locationG.getExtras());
            }
            if (com.baidu.location.e.h.f5919e.equals("all") || com.baidu.location.e.h.f5921g || com.baidu.location.e.h.f5923i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.f5402G, this.f5401F, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address = this.f5396A;
                    if (address != null) {
                        bDLocation.setAddr(address);
                    }
                    String str = this.f5398C;
                    if (str != null) {
                        bDLocation.setLocationDescribe(str);
                    }
                    List<Poi> list = this.f5399D;
                    if (list != null) {
                        bDLocation.setPoiList(list);
                    }
                    PoiRegion poiRegion = this.f5400E;
                    if (poiRegion != null) {
                        bDLocation.setPoiRegion(poiRegion);
                    }
                }
            }
            com.baidu.location.b.b.a().a(bDLocation);
        } else {
            if (this.f5408M) {
                n();
                return;
            }
            if (this.f5423l || this.f5425n == null) {
                BDLocation bDLocation2 = new BDLocation();
                bDLocation2.setLocType(63);
                this.f5425n = null;
                com.baidu.location.b.b.a().a(bDLocation2);
            } else {
                com.baidu.location.b.b.a().a(this.f5425n);
            }
            this.f5426o = null;
        }
        n();
    }

    public void b(BDLocation bDLocation) {
        f fVarA;
        int i4;
        String str;
        String strN;
        BDLocation bDLocation2;
        String str2;
        new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            Address address = bDLocation.getAddress();
            this.f5396A = address;
            if (address != null && (str2 = address.cityCode) != null) {
                f5393h = str2;
                this.f5397B = System.currentTimeMillis();
            }
            this.f5401F = bDLocation.getLongitude();
            this.f5402G = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.f5398C = bDLocation.getLocationDescribe();
            this.f5401F = bDLocation.getLongitude();
            this.f5402G = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.f5399D = bDLocation.getPoiList();
            this.f5401F = bDLocation.getLongitude();
            this.f5402G = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiRegion() != null) {
            this.f5400E = bDLocation.getPoiRegion();
            this.f5401F = bDLocation.getLongitude();
            this.f5402G = bDLocation.getLatitude();
        }
        boolean z4 = false;
        if (com.baidu.location.c.d.a().j()) {
            BDLocation bDLocation3 = new BDLocation(com.baidu.location.c.d.a().f());
            Location locationG = com.baidu.location.c.d.a().g();
            if (locationG != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(locationG.getProvider())) {
                bDLocation3.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
            }
            if (locationG != null) {
                bDLocation3.setExtrainfo(locationG.getExtras());
            }
            if (com.baidu.location.e.h.f5919e.equals("all") || com.baidu.location.e.h.f5921g || com.baidu.location.e.h.f5923i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.f5402G, this.f5401F, bDLocation3.getLatitude(), bDLocation3.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address2 = this.f5396A;
                    if (address2 != null) {
                        bDLocation3.setAddr(address2);
                    }
                    String str3 = this.f5398C;
                    if (str3 != null) {
                        bDLocation3.setLocationDescribe(str3);
                    }
                    List<Poi> list = this.f5399D;
                    if (list != null) {
                        bDLocation3.setPoiList(list);
                    }
                    PoiRegion poiRegion = this.f5400E;
                    if (poiRegion != null) {
                        bDLocation3.setPoiRegion(poiRegion);
                    }
                }
            }
            d(bDLocation3);
            n();
            return;
        }
        if (this.f5408M) {
            float[] fArr2 = new float[2];
            BDLocation bDLocation4 = this.f5425n;
            if (bDLocation4 != null) {
                Location.distanceBetween(bDLocation4.getLatitude(), this.f5425n.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.f5425n = bDLocation;
                if (!this.f5409N) {
                    this.f5409N = false;
                    com.baidu.location.b.b.a().a(bDLocation);
                }
            } else if (bDLocation.getUserIndoorState() > -1) {
                this.f5425n = bDLocation;
                com.baidu.location.b.b.a().a(bDLocation);
            }
            n();
            return;
        }
        if (bDLocation.getLocType() == 167) {
            f.a().a(167, 8, "NetWork location failed because baidu location service can not caculate the location!");
        } else if (bDLocation.getLocType() == 161) {
            int iB = com.baidu.location.e.h.b(com.baidu.location.f.getServiceContext());
            if (iB == 0 || iB == 2) {
                f.a().a(161, 1, "NetWork location successful, open gps will be better!");
            } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("cl") && (strN = com.baidu.location.c.f.a().n()) != null && !strN.equals("&wifio=1")) {
                f.a().a(161, 2, "NetWork location successful, open wifi will be better!");
            }
        } else {
            int i5 = 160;
            if (bDLocation.getLocType() == 160) {
                fVarA = f.a();
                i4 = 10;
                str = "Coarse location successful, open Accurately locate permission will be better!";
            } else if (com.baidu.location.e.h.h(com.baidu.location.f.getServiceContext())) {
                i5 = 62;
                if (bDLocation.getLocType() == 62) {
                    fVarA = f.a();
                    i4 = 11;
                    str = "Coarse location failed because we can not get any loc result";
                }
            }
            fVarA.a(i5, i4, str);
        }
        this.f5426o = null;
        if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && (bDLocation2 = this.f5425n) != null && bDLocation2.getLocType() == 161 && "wf".equals(this.f5425n.getNetworkLocationType()) && System.currentTimeMillis() - this.f5437z < 30000) {
            this.f5426o = bDLocation;
            z4 = true;
        }
        com.baidu.location.b.b bVarA = com.baidu.location.b.b.a();
        if (z4) {
            bVarA.a(this.f5425n);
        } else {
            bVarA.a(bDLocation);
            this.f5437z = System.currentTimeMillis();
        }
        if (!com.baidu.location.e.h.a(bDLocation)) {
            this.f5425n = null;
        } else if (!z4) {
            this.f5425n = bDLocation;
        }
        int iA = com.baidu.location.e.h.a(m.f5345d, "ssid\":\"", "\"");
        if (iA == Integer.MIN_VALUE || this.f5428q == null) {
            this.f5424m = null;
        } else {
            this.f5424m = com.baidu.location.c.f.a().a(iA, this.f5428q);
        }
        com.baidu.location.c.f.a().l();
        n();
    }

    private void d(BDLocation bDLocation) {
        if (com.baidu.location.e.h.f5926l || bDLocation.getMockGpsStrategy() <= 0) {
            com.baidu.location.b.b.a().a(bDLocation);
        } else {
            com.baidu.location.b.b.a().c(bDLocation);
        }
    }

    private void e(BDLocation bDLocation) {
        this.f5419Y = bDLocation != null && bDLocation.isInIndoorPark();
    }

    @Override // com.baidu.location.b.m
    public void a(Message message) {
        a aVar = this.f5406K;
        if (aVar != null && this.f5407L) {
            this.f5407L = false;
            this.f5422i.removeCallbacks(aVar);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        int i4 = message.arg1;
        if (bDLocation != null && bDLocation.getLocType() == 161) {
            b(bDLocation.getTraffic());
            e(bDLocation);
            if (i4 == 1) {
                e.a().a(bDLocation, "gcj02", null);
            }
        }
        if (bDLocation != null && bDLocation.getLocType() == 167 && this.f5411P) {
            bDLocation.setLocType(62);
        }
        if (!this.f5415U && bDLocation != null && bDLocation.getLocType() == 161) {
            String cityCode = bDLocation.getCityCode();
            if (!TextUtils.isEmpty(cityCode)) {
                s.a().b("mapcity", cityCode);
                c.b().a(cityCode);
                this.f5415U = true;
            }
        }
        if (bDLocation != null) {
            l.a().a(bDLocation);
        }
        b(bDLocation);
    }

    public void c(BDLocation bDLocation) {
        this.f5425n = new BDLocation(bDLocation);
    }

    private void b(String str) {
        this.f5418X = str != null && "subway".equals(str.toLowerCase());
    }

    private boolean a(com.baidu.location.c.a aVar, com.baidu.location.c.a aVar2) {
        if (aVar2 == aVar) {
            return false;
        }
        if (aVar2 == null || aVar == null) {
            return true;
        }
        return true ^ aVar.a(aVar2);
    }

    private boolean a(com.baidu.location.c.a aVar, HashSet<String> hashSet) {
        com.baidu.location.c.a aVarF = com.baidu.location.c.f.a().f();
        this.f5347b = aVarF;
        boolean zA = a(aVar, aVarF);
        if (com.baidu.location.e.h.aG == 0) {
            return zA;
        }
        boolean z4 = zA || com.baidu.location.c.f.a().a(aVar, this.f5347b);
        HashSet<String> hashSetC = com.baidu.location.c.f.a().c(this.f5347b);
        this.f5348c = hashSetC;
        return z4 || a(hashSet, hashSetC);
    }

    private boolean a(com.baidu.location.c.k kVar) {
        com.baidu.location.c.k kVarR = com.baidu.location.c.f.a().r();
        this.f5346a = kVarR;
        if (kVar == kVarR) {
            return false;
        }
        if (kVarR == null || kVar == null) {
            return true;
        }
        return !com.baidu.location.c.f.a().a(this.f5346a, kVar, com.baidu.location.e.h.aA);
    }

    private boolean a(HashSet<String> hashSet, HashSet<String> hashSet2) {
        if ((hashSet == null || hashSet.isEmpty()) && (hashSet2 == null || hashSet2.isEmpty())) {
            return false;
        }
        if (hashSet == null || hashSet.isEmpty() || hashSet2 == null || hashSet2.isEmpty()) {
            return true;
        }
        int size = hashSet.size();
        Iterator<String> it = hashSet.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            if (hashSet2.contains(it.next())) {
                i4++;
            }
        }
        return ((float) i4) < ((float) size) * com.baidu.location.e.h.aH;
    }
}
