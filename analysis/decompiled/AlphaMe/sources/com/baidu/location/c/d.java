package com.baidu.location.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.GnssMeasurementsEvent;
import android.location.GnssNavigationMessage;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.room.AbstractC0351g;
import ch.qos.logback.core.spi.AbstractComponentTracker;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.aa;
import com.baidu.location.b.p;
import com.baidu.location.b.v;
import com.baidu.location.b.z;
import com.baidu.platform.comapi.UIMsg;
import com.baidu.platform.comapi.map.MapController;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import com.stepos.alphame.utils.Consts;
import com.stepos.alphame.utils.Property;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class d {

    /* renamed from: A, reason: collision with root package name */
    private static int f5628A = 0;

    /* renamed from: B, reason: collision with root package name */
    private static int f5629B = 0;

    /* renamed from: C, reason: collision with root package name */
    private static int f5630C = 0;

    /* renamed from: D, reason: collision with root package name */
    private static long f5631D = 0;

    /* renamed from: R, reason: collision with root package name */
    private static String f5632R = null;
    private static double T = 100.0d;

    /* renamed from: W, reason: collision with root package name */
    private static float f5633W = -1.0f;

    /* renamed from: a, reason: collision with root package name */
    public static int f5634a = 0;
    private static final Lock al = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    public static String f5635b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f5636c = "";

    /* renamed from: f, reason: collision with root package name */
    private static d f5637f = null;

    /* renamed from: j, reason: collision with root package name */
    private static Location f5638j = null;

    /* renamed from: k, reason: collision with root package name */
    private static int f5639k = -1;

    /* renamed from: u, reason: collision with root package name */
    private static int f5640u;

    /* renamed from: v, reason: collision with root package name */
    private static int f5641v;

    /* renamed from: w, reason: collision with root package name */
    private static int f5642w;

    /* renamed from: x, reason: collision with root package name */
    private static int f5643x;

    /* renamed from: y, reason: collision with root package name */
    private static int f5644y;

    /* renamed from: z, reason: collision with root package name */
    private static int f5645z;
    private BDLocation ar;
    private String av;

    /* renamed from: g, reason: collision with root package name */
    private Context f5667g;

    /* renamed from: i, reason: collision with root package name */
    private Location f5669i;

    /* renamed from: n, reason: collision with root package name */
    private GpsStatus f5672n;

    /* renamed from: o, reason: collision with root package name */
    private c f5673o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5674p;

    /* renamed from: r, reason: collision with root package name */
    private boolean f5676r;

    /* renamed from: h, reason: collision with root package name */
    private LocationManager f5668h = null;

    /* renamed from: l, reason: collision with root package name */
    private f f5670l = null;

    /* renamed from: m, reason: collision with root package name */
    private h f5671m = null;

    /* renamed from: q, reason: collision with root package name */
    private C0012d f5675q = null;

    /* renamed from: s, reason: collision with root package name */
    private GpsStatus.NmeaListener f5677s = null;

    /* renamed from: t, reason: collision with root package name */
    private OnNmeaMessageListener f5678t = null;

    /* renamed from: E, reason: collision with root package name */
    private long f5646E = 0;

    /* renamed from: F, reason: collision with root package name */
    private boolean f5647F = false;

    /* renamed from: G, reason: collision with root package name */
    private boolean f5648G = false;

    /* renamed from: H, reason: collision with root package name */
    private String f5649H = null;

    /* renamed from: I, reason: collision with root package name */
    private boolean f5650I = false;

    /* renamed from: J, reason: collision with root package name */
    private long f5651J = 0;

    /* renamed from: K, reason: collision with root package name */
    private long f5652K = 0;

    /* renamed from: L, reason: collision with root package name */
    private double f5653L = -1.0d;

    /* renamed from: M, reason: collision with root package name */
    private double f5654M = 0.0d;

    /* renamed from: N, reason: collision with root package name */
    private double f5655N = 0.0d;

    /* renamed from: O, reason: collision with root package name */
    private long f5656O = 0;

    /* renamed from: P, reason: collision with root package name */
    private long f5657P = 0;

    /* renamed from: Q, reason: collision with root package name */
    private long f5658Q = 0;

    /* renamed from: S, reason: collision with root package name */
    private e f5659S = null;

    /* renamed from: U, reason: collision with root package name */
    private long f5660U = 0;

    /* renamed from: V, reason: collision with root package name */
    private long f5661V = 0;

    /* renamed from: X, reason: collision with root package name */
    private a f5662X = null;

    /* renamed from: Y, reason: collision with root package name */
    private b f5663Y = null;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<ArrayList<Float>> f5665d = new ArrayList<>();

    /* renamed from: Z, reason: collision with root package name */
    private ArrayList<ArrayList<Float>> f5664Z = new ArrayList<>();
    private ArrayList<ArrayList<Float>> aa = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ab = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ac = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ad = new ArrayList<>();
    private ArrayList<ArrayList<Float>> ae = new ArrayList<>();
    private ArrayList<ArrayList<Float>> af = new ArrayList<>();
    private String ag = null;
    private long ah = 0;
    private ArrayList<Integer> ai = new ArrayList<>();
    private final LinkedHashMap<String, Float> aj = new LinkedHashMap<>();
    private long ak = 0;
    private String am = null;
    private String an = null;
    private long ao = 0;
    private long ap = -1;
    private long aq = -1;
    private boolean as = false;
    private boolean at = false;
    private long au = 0;
    private long aw = 0;
    private boolean ax = false;
    private boolean ay = false;
    private boolean az = false;
    private StringBuilder aA = new StringBuilder();
    private String aB = "";
    private long aC = -1;
    private long aD = 0;
    private long aE = 0;
    private boolean aF = false;
    private long aG = 0;
    private long aH = 0;
    private long aI = 0;
    private long aJ = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f5666e = 0;

    @TargetApi(24)
    public class a extends GnssMeasurementsEvent.Callback {

        /* renamed from: a, reason: collision with root package name */
        public int f5680a;

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onGnssMeasurementsReceived(GnssMeasurementsEvent gnssMeasurementsEvent) {
        }

        @Override // android.location.GnssMeasurementsEvent.Callback
        public void onStatusChanged(int i4) {
            this.f5680a = i4;
        }
    }

    @TargetApi(24)
    public class b extends GnssNavigationMessage.Callback {

        /* renamed from: a, reason: collision with root package name */
        public int f5681a;

        private b() {
            this.f5681a = 0;
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onGnssNavigationMessageReceived(GnssNavigationMessage gnssNavigationMessage) {
            if (d.this.f5658Q != 0) {
                aa.a().a(gnssNavigationMessage, d.this.f5658Q);
            } else {
                aa.a().a(gnssNavigationMessage, System.currentTimeMillis() / 1000);
            }
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onStatusChanged(int i4) {
            this.f5681a = i4;
        }
    }

    @TargetApi(24)
    public class c extends GnssStatus.Callback {
        private c() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i4) {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            ArrayList arrayList;
            if (d.this.f5668h == null || gnssStatus == null) {
                return;
            }
            d.this.f5661V = System.currentTimeMillis();
            int satelliteCount = gnssStatus.getSatelliteCount();
            d.this.ac.clear();
            d.this.ad.clear();
            d.this.ae.clear();
            d.this.af.clear();
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < satelliteCount; i7++) {
                i4++;
                ArrayList arrayList2 = new ArrayList();
                int constellationType = gnssStatus.getConstellationType(i7);
                arrayList2.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i7)));
                arrayList2.add(Float.valueOf(gnssStatus.getElevationDegrees(i7)));
                arrayList2.add(Float.valueOf(gnssStatus.getCn0DbHz(i7)));
                if (gnssStatus.usedInFix(i7)) {
                    i5++;
                    arrayList2.add(Float.valueOf(1.0f));
                    if (constellationType == 1) {
                        i6++;
                    }
                } else {
                    arrayList2.add(Float.valueOf(Property.DEFAULT_FLOAT_VALUE));
                }
                arrayList2.add(Float.valueOf(gnssStatus.getSvid(i7)));
                if (constellationType == 1) {
                    arrayList2.add(Float.valueOf(1.0f));
                    arrayList = d.this.ac;
                } else {
                    if (constellationType == 5) {
                        arrayList2.add(Float.valueOf(2.0f));
                        d.this.ad.add(arrayList2);
                        d.this.aD = System.currentTimeMillis();
                    } else if (constellationType == 3) {
                        arrayList2.add(Float.valueOf(3.0f));
                        arrayList = d.this.ae;
                    } else if (constellationType == 6) {
                        arrayList2.add(Float.valueOf(4.0f));
                        arrayList = d.this.af;
                    }
                }
                arrayList.add(arrayList2);
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(d.this.ac);
            arrayList3.addAll(d.this.ad);
            arrayList3.addAll(d.this.ae);
            arrayList3.addAll(d.this.af);
            d.this.b((ArrayList<ArrayList<Float>>) arrayList3);
            d dVar = d.this;
            dVar.f5664Z = dVar.a(true, false, false, false, true, -1.0f);
            d dVar2 = d.this;
            d.f5635b = dVar2.a((ArrayList<ArrayList<Float>>) dVar2.f5664Z);
            d dVar3 = d.this;
            dVar3.aa = dVar3.a(true, true, true, true, true, -1.0f);
            d dVar4 = d.this;
            dVar4.ab = dVar4.a(true, true, true, true, false, -1.0f);
            d dVar5 = d.this;
            d.f5636c = dVar5.a((ArrayList<ArrayList<Float>>) dVar5.ab);
            if (com.baidu.location.b.c.b().bZ == 1) {
                com.baidu.location.b.h.a().a(d.this.ab);
            }
            d.f5634a = i5;
            int unused = d.f5640u = i6;
            int unused2 = d.f5630C = i4;
            long unused3 = d.f5631D = System.currentTimeMillis();
            d dVar6 = d.this;
            int unused4 = d.f5641v = dVar6.a((ArrayList<ArrayList<Float>>) dVar6.ae, true, -1.0f).size();
            d dVar7 = d.this;
            int unused5 = d.f5642w = dVar7.a((ArrayList<ArrayList<Float>>) dVar7.af, true, -1.0f).size();
            d dVar8 = d.this;
            int unused6 = d.f5643x = dVar8.a((ArrayList<ArrayList<Float>>) dVar8.ad, true, -1.0f).size();
            d dVar9 = d.this;
            int unused7 = d.f5644y = dVar9.a((ArrayList<ArrayList<Float>>) dVar9.ac, false, -1.0f).size();
            d dVar10 = d.this;
            int unused8 = d.f5645z = dVar10.a((ArrayList<ArrayList<Float>>) dVar10.ae, false, -1.0f).size();
            d dVar11 = d.this;
            int unused9 = d.f5628A = dVar11.a((ArrayList<ArrayList<Float>>) dVar11.af, false, -1.0f).size();
            d dVar12 = d.this;
            int unused10 = d.f5629B = dVar12.a((ArrayList<ArrayList<Float>>) dVar12.ad, false, -1.0f).size();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            d.this.e((Location) null);
            d.this.b(false);
            d.f5634a = 0;
            int unused = d.f5640u = 0;
            int unused2 = d.f5641v = 0;
            int unused3 = d.f5642w = 0;
            int unused4 = d.f5643x = 0;
            int unused5 = d.f5644y = 0;
            int unused6 = d.f5645z = 0;
            int unused7 = d.f5628A = 0;
            int unused8 = d.f5629B = 0;
            int unused9 = d.f5630C = 0;
            int unused10 = d.f5639k = -1;
            Location unused11 = d.f5638j = null;
        }
    }

    /* renamed from: com.baidu.location.c.d$d, reason: collision with other inner class name */
    public class C0012d implements GpsStatus.Listener {

        /* renamed from: b, reason: collision with root package name */
        private long f5685b;

        private C0012d() {
            this.f5685b = 0L;
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i4) {
            ArrayList arrayList;
            if (d.this.f5668h == null) {
                return;
            }
            int i5 = 0;
            if (i4 == 2) {
                d.this.e((Location) null);
                d.this.b(false);
                d.f5634a = 0;
                int unused = d.f5640u = 0;
                int unused2 = d.f5641v = 0;
                int unused3 = d.f5642w = 0;
                int unused4 = d.f5643x = 0;
                return;
            }
            if (i4 == 4 && d.this.f5648G) {
                try {
                    if (d.this.f5672n == null) {
                        d dVar = d.this;
                        dVar.f5672n = dVar.f5668h.getGpsStatus(null);
                    } else {
                        d.this.f5668h.getGpsStatus(d.this.f5672n);
                    }
                    d.this.f5661V = System.currentTimeMillis();
                    d.this.ac.clear();
                    d.this.ad.clear();
                    d.this.ae.clear();
                    d.this.af.clear();
                    int i6 = 0;
                    for (GpsSatellite gpsSatellite : d.this.f5672n.getSatellites()) {
                        ArrayList arrayList2 = new ArrayList();
                        int prn = gpsSatellite.getPrn();
                        arrayList2.add(Float.valueOf(gpsSatellite.getAzimuth()));
                        arrayList2.add(Float.valueOf(gpsSatellite.getElevation()));
                        arrayList2.add(Float.valueOf(gpsSatellite.getSnr()));
                        if (gpsSatellite.usedInFix()) {
                            i5++;
                            arrayList2.add(Float.valueOf(1.0f));
                            if (prn >= 1 && prn <= 32) {
                                i6++;
                            }
                        } else {
                            arrayList2.add(Float.valueOf(Property.DEFAULT_FLOAT_VALUE));
                        }
                        arrayList2.add(Float.valueOf(prn));
                        if (prn >= 1 && prn <= 32) {
                            arrayList2.add(Float.valueOf(1.0f));
                            arrayList = d.this.ac;
                        } else if (prn >= 201 && prn <= 261) {
                            arrayList2.add(Float.valueOf(2.0f));
                            arrayList = d.this.ad;
                        } else if (prn >= 65 && prn <= 96) {
                            arrayList2.add(Float.valueOf(3.0f));
                            arrayList = d.this.ae;
                        } else if (prn >= 301 && prn <= 336) {
                            arrayList2.add(Float.valueOf(4.0f));
                            arrayList = d.this.af;
                        }
                        arrayList.add(arrayList2);
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.addAll(d.this.ac);
                    arrayList3.addAll(d.this.ad);
                    arrayList3.addAll(d.this.ae);
                    arrayList3.addAll(d.this.af);
                    d.this.b((ArrayList<ArrayList<Float>>) arrayList3);
                    d dVar2 = d.this;
                    dVar2.f5664Z = dVar2.a(true, false, false, false, true, -1.0f);
                    d dVar3 = d.this;
                    d.f5635b = dVar3.a((ArrayList<ArrayList<Float>>) dVar3.f5664Z);
                    d dVar4 = d.this;
                    dVar4.aa = dVar4.a(true, true, true, true, true, -1.0f);
                    d dVar5 = d.this;
                    dVar5.ab = dVar5.a(true, true, true, true, false, -1.0f);
                    d dVar6 = d.this;
                    d.f5636c = dVar6.a((ArrayList<ArrayList<Float>>) dVar6.ab);
                    if (com.baidu.location.b.c.b().bZ == 1) {
                        com.baidu.location.b.h.a().a(d.this.ab);
                    }
                    if (i6 > 0) {
                        int unused5 = d.f5640u = i6;
                    }
                    if (i5 > 0 || System.currentTimeMillis() - this.f5685b > 100) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        this.f5685b = jCurrentTimeMillis;
                        d.f5634a = i5;
                    }
                    long unused6 = d.f5631D = System.currentTimeMillis();
                } catch (Exception unused7) {
                }
            }
        }
    }

    public static class e extends Handler {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<d> f5686a;

        /* renamed from: b, reason: collision with root package name */
        d f5687b;

        public e(d dVar) {
            this.f5686a = new WeakReference<>(dVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Location location;
            String str;
            if (com.baidu.location.f.isServing) {
                d dVar = this.f5686a.get();
                this.f5687b = dVar;
                if (dVar == null) {
                    return;
                }
                int i4 = message.what;
                if (i4 == 1) {
                    Location location2 = (Location) message.obj;
                    this.f5687b.a(location2, com.baidu.location.b.c.b().bZ == 1 ? com.baidu.location.b.h.a().a(location2) : -1);
                    return;
                }
                if (i4 == 3) {
                    location = (Location) message.obj;
                    str = "&og=1";
                } else {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            return;
                        }
                        dVar.a((String) message.obj);
                        return;
                    }
                    location = (Location) message.obj;
                    str = "&og=2";
                }
                dVar.a(str, location);
            }
        }
    }

    public class f implements LocationListener {
        private f() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null && com.baidu.location.e.h.f5920f == 4) {
                return;
            }
            if (com.baidu.location.e.h.h(com.baidu.location.f.getServiceContext())) {
                com.baidu.location.c.c.a().a(location);
                return;
            }
            if (!com.baidu.location.e.h.a(location) && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d) {
                d.this.f5658Q = location.getTime() / 1000;
                d.this.ap = System.currentTimeMillis();
                if (d.this.f5657P != 0) {
                    d.this.f5656O = System.currentTimeMillis() - d.this.f5657P;
                }
                d.this.f5657P = System.currentTimeMillis();
                int i4 = d.f5634a;
                if (i4 == 0) {
                    try {
                        i4 = location.getExtras().getInt("satellites");
                    } catch (Exception unused) {
                    }
                }
                if (i4 == 0 || p.c().j()) {
                    System.currentTimeMillis();
                    long unused2 = d.this.f5661V;
                }
                d.this.b(true);
                d.this.e(location);
                d.this.f5647F = false;
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            d.this.e((Location) null);
            d.this.b(false);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i4, Bundle bundle) {
            if (i4 == 0) {
                d.this.e((Location) null);
            } else if (i4 != 1) {
                if (i4 != 2) {
                    return;
                }
                d.this.f5647F = false;
                return;
            } else {
                d.this.f5646E = System.currentTimeMillis();
                d.this.f5647F = true;
            }
            d.this.b(false);
        }
    }

    public class g implements GpsStatus.NmeaListener {
        private g() {
        }

        @Override // android.location.GpsStatus.NmeaListener
        public void onNmeaReceived(long j4, String str) {
            if (d.this.f5659S != null) {
                d.this.f5659S.sendMessage(d.this.f5659S.obtainMessage(5, str));
            }
        }
    }

    public class h implements LocationListener {

        /* renamed from: b, reason: collision with root package name */
        private long f5691b;

        private h() {
            this.f5691b = 0L;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (!(d.this.f5648G && com.baidu.location.e.h.f5920f == 4) && location != null && TextUtils.equals(location.getProvider(), "gps") && System.currentTimeMillis() - this.f5691b >= AbstractComponentTracker.LINGERING_TIMEOUT && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d && z.a(location, false)) {
                this.f5691b = System.currentTimeMillis();
                if (d.this.f5659S != null) {
                    d.this.f5666e = System.currentTimeMillis();
                    d.this.f5659S.sendMessage(d.this.f5659S.obtainMessage(4, location));
                }
            }
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

    private d() throws ClassNotFoundException {
        this.f5674p = false;
        this.f5676r = false;
        this.av = null;
        try {
            Class.forName("android.location.GnssStatus");
            this.f5674p = true;
        } catch (ClassNotFoundException unused) {
            this.f5674p = false;
        }
        try {
            this.av = Build.MANUFACTURER;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f5676r = false;
    }

    public static String l() {
        long jCurrentTimeMillis = System.currentTimeMillis() - f5631D;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis >= VehicleBluetoothManager.MIN_CONNECT_DISTANCE) {
            return null;
        }
        Locale locale = Locale.US;
        return B0.g.k("&gsvn=", f5630C, "&gsfn=", f5634a);
    }

    private int f(Location location) {
        if (location == null) {
            return 0;
        }
        if (location.isFromMockProvider()) {
            return 100;
        }
        if (Math.abs(this.ap - this.aq) >= VehicleBluetoothManager.MIN_CONNECT_DISTANCE) {
            this.aq = -1L;
            this.at = false;
            this.as = false;
            this.ar = null;
        } else if (this.ar == null) {
            if (!this.as) {
                return 200;
            }
            if (this.at) {
                return UIMsg.MsgDefine.RENDER_STATE_FIRST_FRAME;
            }
        } else if (!this.at && this.as) {
            return UIMsg.MsgDefine.RENDER_STATE_FIRST_TILE;
        }
        if (this.ap > 0) {
            if (this.aq == -1) {
                return 500;
            }
        }
        return 0;
    }

    public BDLocation h() {
        if (this.ar != null && Math.abs(System.currentTimeMillis() - this.aq) <= VehicleBluetoothManager.MIN_CONNECT_DISTANCE) {
            return this.ar;
        }
        return null;
    }

    public synchronized String m() {
        String str;
        str = "-2";
        try {
            if (Math.abs(System.currentTimeMillis() - this.ah) < VehicleBluetoothManager.MIN_CONNECT_DISTANCE) {
                String str2 = this.ag;
                str = str2 == null ? "0" : str2;
            } else {
                str = "-1";
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "&gnsf=" + str;
    }

    public static String b(Location location) {
        String strA = a(location);
        return strA != null ? strA.concat("&g_tp=0") : strA;
    }

    public Location g() {
        if (this.f5669i != null && Math.abs(System.currentTimeMillis() - this.f5669i.getTime()) <= 60000) {
            return this.f5669i;
        }
        return null;
    }

    public boolean i() {
        try {
            System.currentTimeMillis();
            if (f5634a == 0) {
                try {
                    this.f5669i.getExtras().getInt("satellites");
                } catch (Exception unused) {
                }
            }
            Location location = this.f5669i;
            if (location != null && location.getLatitude() != 0.0d) {
                if (this.f5669i.getLongitude() != 0.0d) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused2) {
            Location location2 = this.f5669i;
            return (location2 == null || location2.getLatitude() == 0.0d || this.f5669i.getLongitude() == 0.0d) ? false : true;
        }
    }

    public boolean j() {
        if (!i() || com.baidu.location.e.h.h(com.baidu.location.f.getServiceContext()) || System.currentTimeMillis() - this.f5651J > AbstractComponentTracker.LINGERING_TIMEOUT) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!this.f5647F || jCurrentTimeMillis - this.f5646E >= VehicleBluetoothManager.MIN_CONNECT_DISTANCE) {
            return this.f5650I;
        }
        return true;
    }

    public boolean k() {
        return this.aF;
    }

    public static String c(Location location) {
        String strA = a(location);
        if (strA == null) {
            return strA;
        }
        StringBuilder sbS = B0.g.s(strA);
        sbS.append(f5632R);
        return sbS.toString();
    }

    public static synchronized d a() {
        try {
            if (f5637f == null) {
                f5637f = new d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f5637f;
    }

    public synchronized void b() {
        if (com.baidu.location.f.isServing) {
            Context serviceContext = com.baidu.location.f.getServiceContext();
            this.f5667g = serviceContext;
            try {
                this.f5668h = (LocationManager) serviceContext.getSystemService(MapController.LOCATION_LAYER_TAG);
            } catch (Exception unused) {
            }
            this.f5659S = new e(this);
        }
    }

    public synchronized void e() {
        e eVar;
        d();
        if (this.f5668h == null) {
            return;
        }
        try {
            eVar = this.f5659S;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (eVar == null) {
            this.f5668h = null;
            if (com.baidu.location.b.c.b().bZ == 1) {
                com.baidu.location.b.h.a().c();
            }
            return;
        } else {
            eVar.removeCallbacksAndMessages(null);
            this.f5668h = null;
            if (com.baidu.location.b.c.b().bZ == 1 && com.baidu.location.b.h.a().b()) {
                com.baidu.location.b.h.a().c();
            }
            return;
        }
    }

    public String f() {
        boolean z4;
        if (this.f5669i == null) {
            return null;
        }
        String str = "{\"result\":{\"time\":\"" + com.baidu.location.e.h.a() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
        int accuracy = (int) (this.f5669i.hasAccuracy() ? this.f5669i.getAccuracy() : 10.0f);
        float speed = (float) (this.f5669i.getSpeed() * 3.6d);
        if (!this.f5669i.hasSpeed()) {
            speed = -1.0f;
        }
        double[] dArrCoorEncrypt = new double[2];
        if (com.baidu.location.e.e.a().a(this.f5669i.getLongitude(), this.f5669i.getLatitude())) {
            dArrCoorEncrypt = Jni.coorEncrypt(this.f5669i.getLongitude(), this.f5669i.getLatitude(), BDLocation.BDLOCATION_WGS84_TO_GCJ02);
            if (dArrCoorEncrypt[0] <= 0.0d && dArrCoorEncrypt[1] <= 0.0d) {
                dArrCoorEncrypt[0] = this.f5669i.getLongitude();
                dArrCoorEncrypt[1] = this.f5669i.getLatitude();
            }
            z4 = true;
        } else {
            dArrCoorEncrypt[0] = this.f5669i.getLongitude();
            double latitude = this.f5669i.getLatitude();
            dArrCoorEncrypt[1] = latitude;
            if (dArrCoorEncrypt[0] <= 0.0d && latitude <= 0.0d) {
                dArrCoorEncrypt[0] = this.f5669i.getLongitude();
                dArrCoorEncrypt[1] = this.f5669i.getLatitude();
            }
            z4 = false;
        }
        Locale locale = Locale.CHINA;
        String string = String.format(locale, str, Double.valueOf(dArrCoorEncrypt[0]), Double.valueOf(dArrCoorEncrypt[1]), Integer.valueOf(accuracy), Float.valueOf(this.f5669i.getBearing()), Float.valueOf(speed), Integer.valueOf(f5634a));
        if (!z4) {
            string = string.concat(",\"in_cn\":\"0\"");
        }
        if (!com.baidu.location.e.h.f5926l) {
            StringBuilder sbS = B0.g.s(string);
            sbS.append(String.format(locale, ",\"is_mock\":%d", Integer.valueOf(f(this.f5669i))));
            string = sbS.toString();
        }
        if (this.f5669i.hasAltitude()) {
            StringBuilder sbS2 = B0.g.s(string);
            sbS2.append(String.format(locale, ",\"h\":%.2f}}", Double.valueOf(this.f5669i.getAltitude())));
            return sbS2.toString();
        }
        return AbstractC0351g.p(string, "}}");
    }

    public static String a(Location location) {
        String strConcat;
        if (location == null) {
            return null;
        }
        float speed = (float) (location.getSpeed() * 3.6d);
        if (!location.hasSpeed()) {
            speed = -1.0f;
        }
        int accuracy = (int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f);
        double altitude = location.hasAltitude() ? location.getAltitude() : 555.0d;
        float bearing = location.hasBearing() ? location.getBearing() : -1.0f;
        String str = f5633W < -0.01f ? String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_asn=%d|%d|%d|%d|%d&ll_snr=%.1f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(bearing), Integer.valueOf(accuracy), Integer.valueOf(f5634a), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(f5634a), Integer.valueOf(f5640u), Integer.valueOf(f5641v), Integer.valueOf(f5642w), Integer.valueOf(f5643x), Integer.valueOf(f5630C), Integer.valueOf(f5644y), Integer.valueOf(f5645z), Integer.valueOf(f5628A), Integer.valueOf(f5629B), Double.valueOf(T)) : String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_asn=%d|%d|%d|%d|%d&ll_snr=%.1f&ll_bp=%.2f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(bearing), Integer.valueOf(accuracy), Integer.valueOf(f5634a), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(f5634a), Integer.valueOf(f5640u), Integer.valueOf(f5641v), Integer.valueOf(f5642w), Integer.valueOf(f5643x), Integer.valueOf(f5630C), Integer.valueOf(f5644y), Integer.valueOf(f5645z), Integer.valueOf(f5628A), Integer.valueOf(f5629B), Double.valueOf(T), Float.valueOf(f5633W));
        try {
            if (f5639k != 2 || f5638j == null) {
                strConcat = str + "&ll_fake=" + f5639k;
            } else {
                strConcat = str.concat(String.format(Locale.CHINA, "&ll_fake=%d|%.5f|%.5f|%d", Integer.valueOf(f5639k), Double.valueOf(f5638j.getLongitude()), Double.valueOf(f5638j.getLatitude()), Long.valueOf(f5638j.getTime() / 1000)));
            }
            return strConcat;
        } catch (Exception e4) {
            e4.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ArrayList<ArrayList<Float>> arrayList) {
        String string;
        if (arrayList == null || arrayList.size() <= 0) {
            string = null;
        } else {
            StringBuilder sb = new StringBuilder(100);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.ac);
            sb.append(com.baidu.location.e.c.g(arrayList2));
            sb.append(Consts.SPLITTER_DETAIL);
            sb.append(com.baidu.location.e.c.f(arrayList2));
            sb.append(Consts.SPLITTER_DETAIL);
            sb.append(com.baidu.location.e.c.a(arrayList2));
            sb.append(Consts.SPLITTER_DETAIL);
            sb.append(com.baidu.location.e.c.h(arrayList2));
            sb.append(Consts.SPLITTER_DETAIL);
            sb.append(com.baidu.location.e.c.b(arrayList2));
            sb.append(Consts.SPLITTER_DETAIL);
            sb.append(com.baidu.location.e.c.c(arrayList2));
            sb.append(Consts.SPLITTER_DETAIL);
            sb.append(com.baidu.location.e.c.e(arrayList2));
            sb.append(Consts.SPLITTER_DETAIL);
            sb.append(com.baidu.location.e.c.d(arrayList2));
            string = sb.toString();
        }
        this.ag = string;
        this.ah = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Location location) {
        if (this.f5659S == null || System.currentTimeMillis() - this.aw <= VehicleBluetoothManager.MIN_CONNECT_DISTANCE) {
            return;
        }
        this.f5659S.sendMessage(this.f5659S.obtainMessage(1, location));
    }

    public void d() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        c cVar;
        if (this.f5648G) {
            LocationManager locationManager = this.f5668h;
            if (locationManager != null) {
                try {
                    C0012d c0012d = this.f5675q;
                    if (c0012d != null) {
                        locationManager.removeGpsStatusListener(c0012d);
                        this.f5675q = null;
                    }
                    if (this.f5674p && (cVar = this.f5673o) != null) {
                        this.f5668h.unregisterGnssStatusCallback(cVar);
                        this.f5673o = null;
                    }
                    h hVar = this.f5671m;
                    if (hVar != null) {
                        this.f5668h.removeUpdates(hVar);
                        this.f5671m = null;
                    }
                } catch (Exception unused) {
                }
                try {
                    f fVar = this.f5670l;
                    if (fVar != null) {
                        this.f5668h.removeUpdates(fVar);
                        this.aF = false;
                    }
                    OnNmeaMessageListener onNmeaMessageListener = this.f5678t;
                    if (onNmeaMessageListener != null) {
                        this.f5668h.removeNmeaListener(onNmeaMessageListener);
                    }
                    if (this.f5677s != null) {
                        Class.forName("android.location.LocationManager").getMethod("removeNmeaListener", GpsStatus.NmeaListener.class).invoke(this.f5668h, this.f5677s);
                    }
                    b bVar = this.f5663Y;
                    if (bVar != null) {
                        this.f5668h.unregisterGnssNavigationMessageCallback(bVar);
                    }
                    a(0);
                } catch (Exception unused2) {
                }
            }
            com.baidu.location.e.h.f5918d = 0;
            com.baidu.location.e.h.f5935u = 0;
            this.f5670l = null;
            this.f5648G = false;
            b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(ArrayList<ArrayList<Float>> arrayList) {
        StringBuilder sb = new StringBuilder();
        if (arrayList.size() == 0) {
            return sb.toString();
        }
        Iterator<ArrayList<Float>> it = arrayList.iterator();
        boolean z4 = true;
        while (it.hasNext()) {
            ArrayList<Float> next = it.next();
            if (next.size() == 6) {
                if (z4) {
                    z4 = false;
                } else {
                    sb.append(Consts.SPLITTER_DETAIL);
                }
                sb.append(String.format("%.1f;", next.get(0)));
                sb.append(String.format("%.1f;", next.get(1)));
                sb.append(String.format("%.1f;", next.get(2)));
                sb.append(String.format("%.0f;", next.get(3)));
                sb.append(String.format("%.0f;", next.get(4)));
                sb.append(String.format("%.0f", next.get(5)));
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z4) {
        this.f5650I = z4;
        f5633W = -1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<ArrayList<Float>> a(ArrayList<ArrayList<Float>> arrayList, boolean z4, float f4) {
        ArrayList<ArrayList<Float>> arrayList2 = new ArrayList<>();
        if (arrayList.size() <= 40 && arrayList.size() != 0) {
            Iterator<ArrayList<Float>> it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList<Float> next = it.next();
                if (next.size() == 6) {
                    float fFloatValue = next.get(3).floatValue();
                    float fFloatValue2 = next.get(2).floatValue();
                    if (!z4 || fFloatValue >= 1.0f) {
                        if (f4 <= Property.DEFAULT_FLOAT_VALUE || fFloatValue2 >= f4) {
                            arrayList2.add(next);
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    private boolean b(String str) {
        int i4;
        if (str.indexOf("*") != -1 && str.indexOf("$") != -1 && str.indexOf("$") <= str.indexOf("*") && str.length() >= str.indexOf("*")) {
            byte[] bytes = str.substring(0, str.indexOf("*")).getBytes();
            int i5 = bytes[1];
            for (int i6 = 2; i6 < bytes.length; i6++) {
                i5 ^= bytes[i6];
            }
            String str2 = String.format("%02x", Integer.valueOf(i5));
            int iIndexOf = str.indexOf("*");
            if (iIndexOf != -1 && str.length() >= (i4 = iIndexOf + 3) && str2.equalsIgnoreCase(str.substring(iIndexOf + 1, i4))) {
                return true;
            }
        }
        return false;
    }

    public void c() {
        if (this.f5648G) {
            return;
        }
        try {
            if (!this.f5674p) {
                C0012d c0012d = new C0012d();
                this.f5675q = c0012d;
                this.f5668h.addGpsStatusListener(c0012d);
            } else if (com.baidu.location.e.h.a(this.f5667g, PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION) == 1) {
                c cVar = new c();
                this.f5673o = cVar;
                this.f5668h.registerGnssStatusCallback(cVar);
            }
            h hVar = new h();
            this.f5671m = hVar;
            this.f5668h.requestLocationUpdates("passive", 9000L, Property.DEFAULT_FLOAT_VALUE, hVar);
        } catch (Exception unused) {
        }
        try {
            this.f5670l = new f();
            try {
                if (com.baidu.location.e.h.a(this.f5667g, "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS") == 1) {
                    this.f5668h.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
                }
            } catch (Exception unused2) {
            }
            if (com.baidu.location.e.h.a(this.f5667g, PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION) == 1) {
                this.f5668h.requestLocationUpdates("gps", 1000L, Property.DEFAULT_FLOAT_VALUE, this.f5670l);
                this.aF = true;
            }
            if (this.f5674p && this.f5663Y == null && com.baidu.location.e.h.aC == 1 && new Random().nextDouble() < com.baidu.location.e.h.aB) {
                this.f5663Y = new b();
            }
            b bVar = this.f5663Y;
            if (bVar != null) {
                this.f5668h.registerGnssNavigationMessageCallback(bVar);
            }
            this.f5660U = System.currentTimeMillis();
            if (!com.baidu.location.e.h.f5926l && com.baidu.location.e.h.aX == 1) {
                OnNmeaMessageListener onNmeaMessageListener = new OnNmeaMessageListener() { // from class: com.baidu.location.c.d.1
                    @Override // android.location.OnNmeaMessageListener
                    public void onNmeaMessage(String str, long j4) {
                        if (d.this.f5659S != null) {
                            d.this.f5659S.sendMessage(d.this.f5659S.obtainMessage(5, str));
                        }
                    }
                };
                this.f5678t = onNmeaMessageListener;
                this.f5668h.addNmeaListener(onNmeaMessageListener);
            }
            this.f5648G = true;
        } catch (Exception unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<ArrayList<Float>> a(boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, float f4) {
        ArrayList<ArrayList<Float>> arrayList = new ArrayList<>();
        if (z4) {
            arrayList.addAll(a(this.ac, z8, f4));
        }
        if (z5) {
            arrayList.addAll(a(this.ad, z8, f4));
        }
        if (z6) {
            arrayList.addAll(a(this.ae, z8, f4));
        }
        if (z7) {
            arrayList.addAll(a(this.af, z8, f4));
        }
        return arrayList;
    }

    public void a(int i4) {
        a aVar;
        LocationManager locationManager;
        if (i4 != 0) {
            if (i4 == 2) {
                this.az = false;
            } else if (i4 == 1) {
            }
            if (!this.ay || this.az || !this.f5674p || (aVar = this.f5662X) == null || (locationManager = this.f5668h) == null) {
                return;
            }
            try {
                locationManager.unregisterGnssMeasurementsCallback(aVar);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            this.f5662X = null;
            this.ax = false;
            return;
        }
        this.az = false;
        this.ay = false;
        if (this.ay) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location, int i4) {
        if (location == null) {
            this.f5669i = null;
            return;
        }
        if (f5634a == 0) {
            try {
                location.getExtras().getInt("satellites");
            } catch (Exception unused) {
            }
        }
        if (this.f5676r && com.baidu.location.e.h.a(location.getSpeed(), Property.DEFAULT_FLOAT_VALUE) && !com.baidu.location.e.h.a(this.f5654M, 0.0d) && System.currentTimeMillis() - this.f5655N < 2000.0d) {
            location.setSpeed((float) this.f5654M);
        }
        Location location2 = new Location(location);
        this.f5651J = System.currentTimeMillis();
        this.f5669i = location;
        int i5 = f5634a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f5669i.setTime(jCurrentTimeMillis);
        float speed = (float) (this.f5669i.getSpeed() * 3.6d);
        if (!this.f5669i.hasSpeed()) {
            speed = -1.0f;
        }
        if (i5 == 0) {
            try {
                i5 = this.f5669i.getExtras().getInt("satellites");
            } catch (Exception unused2) {
            }
        }
        this.f5649H = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.f5669i.getLongitude()), Double.valueOf(this.f5669i.getLatitude()), Float.valueOf(speed), Float.valueOf(this.f5669i.getBearing()), Integer.valueOf(i5), Long.valueOf(jCurrentTimeMillis));
        if (this.f5669i != null) {
            BDLocation bDLocation = new BDLocation(f());
            com.baidu.location.b.e.a().a(bDLocation, "gcj02", this.f5669i);
            Bundle extras = location.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putInt("sat_num", i5);
            if (Math.abs(System.currentTimeMillis() - this.aD) >= VehicleBluetoothManager.MIN_CONNECT_DISTANCE) {
                extras.putBoolean("is_support_beidou", false);
            } else {
                extras.putBoolean("is_support_beidou", true);
            }
            bDLocation.setExtrainfo(extras);
            Location location3 = this.f5669i;
            if (location3 != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(location3.getProvider())) {
                bDLocation.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
            }
            a(bDLocation);
            if (f5634a > 2 && z.a(this.f5669i, true) && "gps".equals(this.f5669i.getProvider())) {
                boolean zJ = com.baidu.location.c.f.a().j();
                com.baidu.location.c.a aVarF = com.baidu.location.c.f.a().f();
                if (aVarF != null) {
                    v.a(new com.baidu.location.c.a(aVarF));
                }
                v.a(System.currentTimeMillis());
                v.a(new Location(this.f5669i));
                v.a(com.baidu.location.b.b.a().c());
                v.b(com.baidu.location.b.e.a().c());
                if (!zJ) {
                    aa.a().b();
                }
            }
        }
        if ("gps".equals(location2.getProvider())) {
            aa.a().a(location2, f5634a);
        }
    }

    public void a(BDLocation bDLocation) {
        if (com.baidu.location.e.h.f5926l || f(this.f5669i) <= 0) {
            com.baidu.location.b.b.a().d(bDLocation);
        } else {
            com.baidu.location.b.b.a().c(bDLocation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (TextUtils.isEmpty(str) || !b(str)) {
            return;
        }
        if (str.startsWith("$GPGGA,")) {
            a(str, 2, 4, 6);
        } else if (str.startsWith("$GPRMC,")) {
            a(str, 3, 5, 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.String r11, int r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.d.a(java.lang.String, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Location location) {
        if (location == null) {
            return;
        }
        StringBuilder sbS = B0.g.s(str);
        sbS.append(com.baidu.location.b.b.a().c());
        String string = sbS.toString();
        boolean zJ = com.baidu.location.c.f.a().j();
        com.baidu.location.c.a aVarF = com.baidu.location.c.f.a().f();
        if (aVarF != null) {
            v.a(new com.baidu.location.c.a(aVarF));
        }
        v.a(System.currentTimeMillis());
        v.a(new Location(location));
        v.a(string);
        v.b(com.baidu.location.b.e.a().c());
        if (zJ) {
            return;
        }
        z.a(v.c(), (k) null, v.d(), string, v.e());
    }

    public void a(boolean z4) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (z4) {
            c();
        } else {
            d();
        }
    }

    public static boolean a(Location location, Location location2, boolean z4) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (z4 && ((com.baidu.location.e.h.f5935u == 3 || !com.baidu.location.e.e.a().a(location2.getLongitude(), location2.getLatitude())) && speed < 5.0f)) {
            return true;
        }
        float fDistanceTo = location2.distanceTo(location);
        return speed > com.baidu.location.e.h.f5900K ? fDistanceTo > com.baidu.location.e.h.f5902M : speed > com.baidu.location.e.h.f5899J ? fDistanceTo > com.baidu.location.e.h.f5901L : fDistanceTo > 5.0f;
    }
}
