package com.baidu.location;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.g;
import com.baidu.location.b.o;
import com.baidu.location.e.h;
import com.baidu.mshield.x6.EngineImpl;
import com.stepos.activeview.utils.Constants;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class LocationClient implements g.a {
    public static final int CONNECT_HOT_SPOT_FALSE = 0;
    public static final int CONNECT_HOT_SPOT_TRUE = 1;
    public static final int CONNECT_HOT_SPOT_UNKNOWN = -1;

    /* renamed from: I, reason: collision with root package name */
    private static boolean f5026I = false;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_FINE_PERMISSION = 10;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS = 1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI = 2;
    public static final int LOC_DIAGNOSTIC_TYPE_COARSE_FAIL = 11;
    public static final int LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN = 9;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION = 4;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET = 3;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE = 7;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI = 6;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH = 5;
    public static final int LOC_DIAGNOSTIC_TYPE_SERVER_FAIL = 8;

    /* renamed from: x, reason: collision with root package name */
    private static String f5027x;

    /* renamed from: A, reason: collision with root package name */
    private Boolean f5028A;

    /* renamed from: B, reason: collision with root package name */
    private Boolean f5029B;

    /* renamed from: C, reason: collision with root package name */
    private Boolean f5030C;

    /* renamed from: D, reason: collision with root package name */
    private boolean f5031D;

    /* renamed from: E, reason: collision with root package name */
    private g f5032E;

    /* renamed from: F, reason: collision with root package name */
    private boolean f5033F;

    /* renamed from: G, reason: collision with root package name */
    private boolean f5034G;

    /* renamed from: H, reason: collision with root package name */
    private boolean f5035H;

    /* renamed from: J, reason: collision with root package name */
    private String f5036J;

    /* renamed from: K, reason: collision with root package name */
    private ServiceConnection f5037K;

    /* renamed from: c, reason: collision with root package name */
    private LocationClientOption f5040c;

    /* renamed from: d, reason: collision with root package name */
    private LocationClientOption f5041d;

    /* renamed from: f, reason: collision with root package name */
    private Context f5043f;

    /* renamed from: h, reason: collision with root package name */
    private a f5045h;

    /* renamed from: i, reason: collision with root package name */
    private final Messenger f5046i;

    /* renamed from: w, reason: collision with root package name */
    private String f5060w;

    /* renamed from: a, reason: collision with root package name */
    private long f5038a = 0;

    /* renamed from: b, reason: collision with root package name */
    private String f5039b = null;

    /* renamed from: e, reason: collision with root package name */
    private boolean f5042e = false;

    /* renamed from: g, reason: collision with root package name */
    private Messenger f5044g = null;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<BDLocationListener> f5047j = null;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<BDAbstractLocationListener> f5048k = null;

    /* renamed from: l, reason: collision with root package name */
    private BDLocation f5049l = null;

    /* renamed from: m, reason: collision with root package name */
    private BDLocation f5050m = null;

    /* renamed from: n, reason: collision with root package name */
    private boolean f5051n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f5052o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5053p = false;

    /* renamed from: q, reason: collision with root package name */
    private b f5054q = null;

    /* renamed from: r, reason: collision with root package name */
    private boolean f5055r = false;

    /* renamed from: s, reason: collision with root package name */
    private final Object f5056s = new Object();

    /* renamed from: t, reason: collision with root package name */
    private long f5057t = 0;

    /* renamed from: u, reason: collision with root package name */
    private long f5058u = 0;

    /* renamed from: v, reason: collision with root package name */
    private String f5059v = null;

    /* renamed from: y, reason: collision with root package name */
    private boolean f5061y = false;

    /* renamed from: z, reason: collision with root package name */
    private boolean f5062z = true;

    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<LocationClient> f5065a;

        public a(Looper looper, LocationClient locationClient) {
            super(looper);
            this.f5065a = new WeakReference<>(locationClient);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws RemoteException {
            LocationClient locationClient = this.f5065a.get();
            if (locationClient == null) {
                return;
            }
            int i4 = message.what;
            boolean z4 = true;
            if (i4 == 21) {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                if (!locationClient.f5034G && locationClient.f5033F && bDLocation.getLocType() == 66) {
                    return;
                }
                if (!locationClient.f5034G && locationClient.f5033F) {
                    locationClient.f5034G = true;
                    return;
                }
                if (!locationClient.f5034G) {
                    locationClient.f5034G = true;
                }
                locationClient.a(message, 21);
                return;
            }
            try {
                if (i4 == 303) {
                    Bundle data2 = message.getData();
                    int i5 = data2.getInt("loctype");
                    int i6 = data2.getInt("diagtype");
                    byte[] byteArray = data2.getByteArray("diagmessage");
                    if (i5 <= 0 || i6 <= 0 || byteArray == null || locationClient.f5048k == null) {
                        return;
                    }
                    Iterator it = locationClient.f5048k.iterator();
                    while (it.hasNext()) {
                        ((BDAbstractLocationListener) it.next()).onLocDiagnosticMessage(i5, i6, new String(byteArray, Constants.UTF_8_CODE));
                    }
                    return;
                }
                if (i4 == 406) {
                    Bundle data3 = message.getData();
                    byte[] byteArray2 = data3.getByteArray("mac");
                    String str = byteArray2 != null ? new String(byteArray2, Constants.UTF_8_CODE) : null;
                    int i7 = data3.getInt("hotspot", -1);
                    if (locationClient.f5048k != null) {
                        Iterator it2 = locationClient.f5048k.iterator();
                        while (it2.hasNext()) {
                            ((BDAbstractLocationListener) it2.next()).onConnectHotSpotMessage(str, i7);
                        }
                        return;
                    }
                    return;
                }
                if (i4 == 701) {
                    locationClient.b((BDLocation) message.obj);
                    return;
                }
                if (i4 == 1300) {
                    locationClient.c(message);
                    return;
                }
                if (i4 == 1400) {
                    locationClient.d(message);
                    return;
                }
                if (i4 != 54) {
                    z4 = false;
                    if (i4 != 55) {
                        if (i4 == 703) {
                            Bundle data4 = message.getData();
                            int i8 = data4.getInt("id", 0);
                            if (i8 > 0) {
                                locationClient.a(i8, (Notification) data4.getParcelable("notification"));
                                return;
                            }
                            return;
                        }
                        if (i4 == 704) {
                            locationClient.a(message.getData().getBoolean("removenotify"));
                            return;
                        }
                        switch (i4) {
                            case 1:
                                locationClient.a();
                                break;
                            case 2:
                                locationClient.b();
                                break;
                            case 3:
                                locationClient.a(message);
                                break;
                            case 4:
                                locationClient.e();
                                break;
                            case 5:
                                locationClient.b(message);
                                break;
                            case 6:
                                locationClient.e(message);
                                break;
                            default:
                                super.handleMessage(message);
                                break;
                        }
                        return;
                    }
                    if (!locationClient.f5040c.location_change_notify) {
                        return;
                    }
                } else if (!locationClient.f5040c.location_change_notify) {
                    return;
                }
                locationClient.f5055r = z4;
            } catch (Exception unused) {
            }
        }
    }

    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (LocationClient.this.f5056s) {
                try {
                    LocationClient.this.f5053p = false;
                    if (LocationClient.this.f5044g != null && LocationClient.this.f5046i != null) {
                        if (LocationClient.this.f5047j == null || LocationClient.this.f5047j.size() < 1) {
                            if (LocationClient.this.f5048k != null) {
                                if (LocationClient.this.f5048k.size() < 1) {
                                }
                            }
                            return;
                        }
                        if (!LocationClient.this.f5052o) {
                            LocationClient.this.f5045h.obtainMessage(4).sendToTarget();
                            return;
                        }
                        if (LocationClient.this.f5054q == null) {
                            LocationClient locationClient = LocationClient.this;
                            locationClient.f5054q = locationClient.new b();
                        }
                        LocationClient.this.f5045h.postDelayed(LocationClient.this.f5054q, LocationClient.this.f5040c.scanSpan);
                    }
                } finally {
                }
            }
        }
    }

    public class c extends Thread {
        private c() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (LocationClient.this.f5041d.isOnceLocation()) {
                    com.baidu.location.c.c.a().b(LocationClient.this.f5043f);
                }
                com.baidu.location.a.a.a().d();
                if (LocationClient.this.f5030C.booleanValue()) {
                    if (LocationClient.this.f5032E == null) {
                        com.baidu.location.c.f.a().b();
                        LocationClient.this.f5032E = new g(LocationClient.this.f5043f, LocationClient.this.f5041d, LocationClient.this, null, false);
                    }
                    LocationClient locationClient = LocationClient.this;
                    locationClient.f5036J = locationClient.f5032E.g();
                    if (LocationClient.this.f5041d.firstLocType == LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC) {
                        LocationClient.this.f5032E.d();
                        LocationClient.this.f5032E.e();
                    }
                }
                LocationClient.this.f5045h.obtainMessage(1).sendToTarget();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public LocationClient(Context context) throws Exception {
        this.f5040c = new LocationClientOption();
        this.f5041d = new LocationClientOption();
        this.f5043f = null;
        Boolean bool = Boolean.FALSE;
        this.f5028A = bool;
        this.f5029B = bool;
        this.f5030C = Boolean.TRUE;
        this.f5032E = null;
        this.f5033F = false;
        this.f5034G = false;
        this.f5035H = false;
        this.f5036J = null;
        this.f5037K = new ServiceConnection() { // from class: com.baidu.location.LocationClient.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
                LocationClient.this.f5044g = new Messenger(iBinder);
                if (LocationClient.this.f5044g == null) {
                    return;
                }
                LocationClient.this.f5042e = true;
                if (LocationClient.this.f5062z) {
                    LocationClient.this.f5045h.obtainMessage(2).sendToTarget();
                    return;
                }
                try {
                    Message messageObtain = Message.obtain((Handler) null, 11);
                    messageObtain.replyTo = LocationClient.this.f5046i;
                    messageObtain.setData(LocationClient.this.d());
                    LocationClient.this.f5044g.send(messageObtain);
                    LocationClient.this.f5042e = true;
                    if (LocationClient.this.f5040c != null) {
                        LocationClient.this.f5030C.getClass();
                        LocationClient.this.f5045h.obtainMessage(4).sendToTarget();
                    }
                } catch (Exception unused) {
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                LocationClient.this.f5044g = null;
                LocationClient.this.f5042e = false;
            }
        };
        c();
        this.f5043f = context;
        this.f5040c = new LocationClientOption();
        this.f5041d = new LocationClientOption();
        this.f5045h = new a(Looper.getMainLooper(), this);
        this.f5046i = new Messenger(this.f5045h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() throws RemoteException {
        if (!this.f5042e || this.f5044g == null) {
            return;
        }
        Message messageObtain = Message.obtain((Handler) null, 12);
        messageObtain.replyTo = this.f5046i;
        try {
            this.f5044g.send(messageObtain);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            this.f5043f.unbindService(this.f5037K);
            if (this.f5035H) {
                try {
                    this.f5043f.stopService(new Intent(this.f5043f, (Class<?>) f.class));
                } catch (Exception unused) {
                }
                this.f5035H = false;
            }
        } catch (Exception unused2) {
        }
        synchronized (this.f5056s) {
            try {
                if (this.f5053p) {
                    this.f5045h.removeCallbacks(this.f5054q);
                    this.f5053p = false;
                }
            } catch (Exception unused3) {
            }
        }
        this.f5044g = null;
        this.f5052o = false;
        this.f5061y = false;
        this.f5042e = false;
        this.f5033F = false;
        this.f5034G = false;
        this.f5030C = Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle d() {
        if (this.f5040c == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.f5039b);
        bundle.putString("prodName", this.f5040c.prodName);
        bundle.putString("coorType", this.f5040c.coorType);
        bundle.putString("addrType", this.f5040c.addrType);
        bundle.putBoolean("openGPS", this.f5040c.openGps);
        bundle.putBoolean("location_change_notify", this.f5040c.location_change_notify);
        bundle.putInt("scanSpan", this.f5040c.scanSpan);
        bundle.putBoolean("enableSimulateGps", this.f5040c.enableSimulateGps);
        bundle.putInt("timeOut", this.f5040c.timeOut);
        bundle.putInt("priority", this.f5040c.priority);
        bundle.putBoolean("map", this.f5028A.booleanValue());
        bundle.putBoolean("import", this.f5029B.booleanValue());
        bundle.putBoolean("needDirect", this.f5040c.mIsNeedDeviceDirect);
        bundle.putBoolean("isneedaptag", this.f5040c.isNeedAptag);
        bundle.putBoolean("isneedpoiregion", this.f5040c.isNeedPoiRegion);
        bundle.putBoolean("isneedregular", this.f5040c.isNeedRegular);
        bundle.putBoolean("isneedaptagd", this.f5040c.isNeedAptagd);
        bundle.putBoolean("isneedaltitude", this.f5040c.isNeedAltitude);
        bundle.putBoolean("isneednewrgc", this.f5040c.isNeedNewVersionRgc);
        bundle.putInt("autoNotifyMaxInterval", this.f5040c.a());
        bundle.putInt("autoNotifyMinTimeInterval", this.f5040c.getAutoNotifyMinTimeInterval());
        bundle.putInt("autoNotifyMinDistance", this.f5040c.getAutoNotifyMinDistance());
        bundle.putFloat("autoNotifyLocSensitivity", this.f5040c.b());
        bundle.putInt("wifitimeout", this.f5040c.wifiCacheTimeOut);
        bundle.putInt("wfnum", com.baidu.location.b.a.a().f5088b);
        bundle.putBoolean("ischeckper", com.baidu.location.b.a.a().f5087a);
        bundle.putFloat("wfsm", (float) com.baidu.location.b.a.a().f5089c);
        bundle.putDouble("gnmcrm", com.baidu.location.b.a.a().f5092f);
        bundle.putInt("gnmcon", com.baidu.location.b.a.a().f5093g);
        bundle.putInt("iupl", com.baidu.location.b.a.a().f5094h);
        bundle.putInt("lpcs", com.baidu.location.b.a.a().f5091e);
        bundle.putInt("hpdts", com.baidu.location.b.a.a().f5101o);
        bundle.putInt("oldts", com.baidu.location.b.a.a().f5102p);
        bundle.putInt("onic", com.baidu.location.b.a.a().f5103q);
        bundle.putInt("nlcs", com.baidu.location.b.a.a().f5104r);
        bundle.putFloat("ncsr", com.baidu.location.b.a.a().f5105s);
        bundle.putFloat("cscr", com.baidu.location.b.a.a().f5106t);
        bundle.putString("connectBssid", this.f5036J);
        bundle.putInt("cls", com.baidu.location.b.a.a().f5107u);
        bundle.putIntArray("ocs", com.baidu.location.b.a.a().f5108v);
        bundle.putInt("topCellNumber", com.baidu.location.b.a.a().f5109w);
        bundle.putInt("locStrLength", com.baidu.location.b.a.a().f5110x);
        return bundle;
    }

    public static BDLocation getBDLocationInCoorType(BDLocation bDLocation, String str) {
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        double[] dArrCoorEncrypt = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), str);
        bDLocation2.setLatitude(dArrCoorEncrypt[1]);
        bDLocation2.setLongitude(dArrCoorEncrypt[0]);
        return bDLocation2;
    }

    public static void setAgreePrivacy(boolean z4) {
        f5026I = z4;
    }

    public static void setKey(String str) {
        f5027x = str;
    }

    public void disableAssistantLocation() {
        o.a().b();
    }

    public void disableLocInForeground(boolean z4) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("removenotify", z4);
        Message messageObtainMessage = this.f5045h.obtainMessage(704);
        messageObtainMessage.setData(bundle);
        messageObtainMessage.sendToTarget();
    }

    public void enableAssistantLocation(WebView webView) {
        o.a().a(this.f5043f, webView, this);
    }

    public void enableLocInForeground(int i4, Notification notification) {
        if (i4 <= 0 || notification == null) {
            Log.e("baidu_location_Client", "can not startLocInForeground if the param is unlegal");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("id", i4);
        bundle.putParcelable("notification", notification);
        Message messageObtainMessage = this.f5045h.obtainMessage(703);
        messageObtainMessage.setData(bundle);
        messageObtainMessage.sendToTarget();
    }

    public String getAccessKey() {
        try {
            String strB = com.baidu.location.a.a.b(this.f5043f);
            this.f5060w = strB;
            if (TextUtils.isEmpty(strB)) {
                throw new IllegalStateException("please setting key from Manifest.xml");
            }
            return "KEY=" + this.f5060w;
        } catch (Exception unused) {
            return null;
        }
    }

    public BDLocation getLastKnownLocation() {
        return this.f5049l;
    }

    public LocationClientOption getLocOption() {
        return this.f5040c;
    }

    public String getVersion() {
        return "9.6.4.3";
    }

    public boolean isStarted() {
        return this.f5042e;
    }

    public void onReceiveLightLocString(String str) {
    }

    @Override // com.baidu.location.b.g.a
    public void onReceiveLocation(BDLocation bDLocation) {
        if ((!this.f5034G || this.f5033F) && bDLocation != null) {
            Message messageObtainMessage = this.f5045h.obtainMessage(701);
            messageObtainMessage.obj = bDLocation;
            messageObtainMessage.sendToTarget();
        }
    }

    public void registerLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message messageObtainMessage = this.f5045h.obtainMessage(1300);
        messageObtainMessage.obj = bDAbstractLocationListener;
        messageObtainMessage.sendToTarget();
    }

    public boolean requestHotSpotState() throws RemoteException {
        if (this.f5044g != null && this.f5042e) {
            try {
                this.f5044g.send(Message.obtain((Handler) null, 406));
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public int requestLocation() {
        ArrayList<BDAbstractLocationListener> arrayList;
        if (this.f5044g == null || this.f5046i == null) {
            return 1;
        }
        ArrayList<BDLocationListener> arrayList2 = this.f5047j;
        if ((arrayList2 == null || arrayList2.size() < 1) && ((arrayList = this.f5048k) == null || arrayList.size() < 1)) {
            return 2;
        }
        if (System.currentTimeMillis() - this.f5038a < 1000) {
            return 6;
        }
        this.f5052o = true;
        Message messageObtainMessage = this.f5045h.obtainMessage(4);
        messageObtainMessage.arg1 = 0;
        messageObtainMessage.sendToTarget();
        return 0;
    }

    public void restart() {
        stop();
        this.f5062z = false;
        this.f5045h.sendEmptyMessageDelayed(1, 1000L);
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        if (locationClientOption.a() > 0) {
            locationClientOption.setScanSpan(0);
            locationClientOption.setLocationNotify(true);
        }
        this.f5041d = new LocationClientOption(locationClientOption);
        Message messageObtainMessage = this.f5045h.obtainMessage(3);
        messageObtainMessage.obj = locationClientOption;
        messageObtainMessage.sendToTarget();
    }

    public void start() {
        this.f5062z = false;
        f();
        g();
        LBSAuthManager.getInstance(this.f5043f.getApplicationContext()).setPrivacyMode(f5026I);
        com.baidu.location.b.a.a().a(this.f5043f, this.f5041d, (String) null);
        new c().start();
    }

    public void stop() {
        this.f5062z = true;
        this.f5045h.obtainMessage(2).sendToTarget();
        g gVar = this.f5032E;
        if (gVar != null) {
            gVar.f();
            this.f5032E = null;
        }
    }

    public void unRegisterLocationListener(BDAbstractLocationListener bDAbstractLocationListener) {
        if (bDAbstractLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message messageObtainMessage = this.f5045h.obtainMessage(1400);
        messageObtainMessage.obj = bDAbstractLocationListener;
        messageObtainMessage.sendToTarget();
    }

    public boolean updateLocation(Location location) throws RemoteException {
        if (this.f5044g == null || this.f5046i == null || location == null) {
            return false;
        }
        try {
            Message messageObtain = Message.obtain((Handler) null, 57);
            messageObtain.obj = location;
            this.f5044g.send(messageObtain);
            return true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return true;
        }
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) throws Exception {
        this.f5040c = new LocationClientOption();
        this.f5041d = new LocationClientOption();
        this.f5043f = null;
        Boolean bool = Boolean.FALSE;
        this.f5028A = bool;
        this.f5029B = bool;
        this.f5030C = Boolean.TRUE;
        this.f5032E = null;
        this.f5033F = false;
        this.f5034G = false;
        this.f5035H = false;
        this.f5036J = null;
        this.f5037K = new ServiceConnection() { // from class: com.baidu.location.LocationClient.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
                LocationClient.this.f5044g = new Messenger(iBinder);
                if (LocationClient.this.f5044g == null) {
                    return;
                }
                LocationClient.this.f5042e = true;
                if (LocationClient.this.f5062z) {
                    LocationClient.this.f5045h.obtainMessage(2).sendToTarget();
                    return;
                }
                try {
                    Message messageObtain = Message.obtain((Handler) null, 11);
                    messageObtain.replyTo = LocationClient.this.f5046i;
                    messageObtain.setData(LocationClient.this.d());
                    LocationClient.this.f5044g.send(messageObtain);
                    LocationClient.this.f5042e = true;
                    if (LocationClient.this.f5040c != null) {
                        LocationClient.this.f5030C.getClass();
                        LocationClient.this.f5045h.obtainMessage(4).sendToTarget();
                    }
                } catch (Exception unused) {
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                LocationClient.this.f5044g = null;
                LocationClient.this.f5042e = false;
            }
        };
        c();
        this.f5043f = context;
        this.f5040c = locationClientOption;
        this.f5041d = new LocationClientOption(locationClientOption);
        this.f5045h = new a(Looper.getMainLooper(), this);
        this.f5046i = new Messenger(this.f5045h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) obj;
        if (this.f5047j == null) {
            this.f5047j = new ArrayList<>();
        }
        if (this.f5047j.contains(bDLocationListener)) {
            return;
        }
        this.f5047j.add(bDLocationListener);
    }

    private void c() throws Exception {
        if (f5026I) {
            return;
        }
        Log.e("baidu_location_Client", "The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
        throw new Exception("The location function has been stopped because you do not agree with the privacy compliance policy. Please recheck the setAgreePrivacy interface");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() throws RemoteException {
        int i4;
        if (this.f5044g == null) {
            return;
        }
        int iG = h.g(this.f5043f);
        if ((System.currentTimeMillis() - this.f5057t > VehicleBluetoothManager.MIN_CONNECT_DISTANCE || !this.f5040c.location_change_notify || this.f5052o) && iG == 1) {
            if (!this.f5061y || System.currentTimeMillis() - this.f5058u > 20000 || this.f5052o) {
                Message messageObtain = Message.obtain((Handler) null, 22);
                if (this.f5052o) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isWaitingLocTag", this.f5052o);
                    this.f5052o = false;
                    messageObtain.setData(bundle);
                }
                try {
                    messageObtain.replyTo = this.f5046i;
                    this.f5044g.send(messageObtain);
                    this.f5038a = System.currentTimeMillis();
                    this.f5051n = true;
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } else if (iG < 1) {
            BDLocation bDLocation = new BDLocation();
            if (iG == -1) {
                i4 = 69;
            } else if (iG == -2) {
                i4 = 70;
            } else {
                if (iG == 0) {
                    i4 = 71;
                }
                a(bDLocation);
            }
            bDLocation.setLocType(i4);
            a(bDLocation);
        }
        synchronized (this.f5056s) {
            try {
                LocationClientOption locationClientOption = this.f5040c;
                if (locationClientOption != null && locationClientOption.scanSpan >= 1000 && !this.f5053p) {
                    if (this.f5054q == null) {
                        this.f5054q = new b();
                    }
                    this.f5045h.postDelayed(this.f5054q, this.f5040c.scanSpan);
                    this.f5053p = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void f() {
        LocationClientOption locationClientOption = this.f5041d;
        if (locationClientOption == null) {
            return;
        }
        h.aZ = locationClientOption.mProxyHost;
        h.ba = locationClientOption.mProxyPort;
        h.bb = locationClientOption.mUsername;
        h.bc = locationClientOption.mPassword;
    }

    private void g() {
        LBSAuthManager.getInstance(this.f5043f.getApplicationContext()).setPrivacyMode(f5026I);
        com.baidu.location.a.a.a().a(this.f5043f, f5027x);
        com.baidu.location.a.a.a().a(this.f5043f);
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message messageObtainMessage = this.f5045h.obtainMessage(5);
        messageObtainMessage.obj = bDLocationListener;
        messageObtainMessage.sendToTarget();
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message messageObtainMessage = this.f5045h.obtainMessage(6);
        messageObtainMessage.obj = bDLocationListener;
        messageObtainMessage.sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BDLocation bDLocation) {
        if (this.f5062z) {
            return;
        }
        this.f5049l = bDLocation;
        if (!this.f5034G && bDLocation.getLocType() == 161) {
            this.f5033F = true;
            com.baidu.location.b.a.a().a(bDLocation.getLatitude(), bDLocation.getLongitude(), bDLocation.getCoorType());
        }
        if (bDLocation == null || bDLocation.getLocType() != 161 || com.baidu.location.a.a.a().c()) {
            ArrayList<BDLocationListener> arrayList = this.f5047j;
            if (arrayList != null) {
                Iterator<BDLocationListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onReceiveLocation(bDLocation);
                }
            }
            ArrayList<BDAbstractLocationListener> arrayList2 = this.f5048k;
            if (arrayList2 != null) {
                Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().onReceiveLocation(bDLocation);
                }
                return;
            }
            return;
        }
        if (this.f5050m == null) {
            BDLocation bDLocation2 = new BDLocation();
            this.f5050m = bDLocation2;
            bDLocation2.setLocType(505);
        }
        ArrayList<BDLocationListener> arrayList3 = this.f5047j;
        if (arrayList3 != null) {
            Iterator<BDLocationListener> it3 = arrayList3.iterator();
            while (it3.hasNext()) {
                it3.next().onReceiveLocation(this.f5050m);
            }
        }
        ArrayList<BDAbstractLocationListener> arrayList4 = this.f5048k;
        if (arrayList4 != null) {
            Iterator<BDAbstractLocationListener> it4 = arrayList4.iterator();
            while (it4.hasNext()) {
                it4.next().onReceiveLocation(this.f5050m);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) obj;
        if (this.f5048k == null) {
            this.f5048k = new ArrayList<>();
        }
        if (this.f5048k.contains(bDAbstractLocationListener)) {
            return;
        }
        this.f5048k.add(bDAbstractLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        BDAbstractLocationListener bDAbstractLocationListener = (BDAbstractLocationListener) obj;
        ArrayList<BDAbstractLocationListener> arrayList = this.f5048k;
        if (arrayList == null || !arrayList.contains(bDAbstractLocationListener)) {
            return;
        }
        this.f5048k.remove(bDAbstractLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Message message) {
        Object obj;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        BDLocationListener bDLocationListener = (BDLocationListener) obj;
        ArrayList<BDLocationListener> arrayList = this.f5047j;
        if (arrayList == null || !arrayList.contains(bDLocationListener)) {
            return;
        }
        this.f5047j.remove(bDLocationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f5042e) {
            return;
        }
        if (this.f5030C.booleanValue()) {
            boolean zC = h.c(this.f5043f);
            if (this.f5041d.isOnceLocation() || zC) {
                try {
                    new Thread() { // from class: com.baidu.location.LocationClient.2
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                if (LocationClient.this.f5032E != null) {
                                    if (h.g(LocationClient.this.f5043f) > 0) {
                                        LocationClient.this.f5032E.a();
                                    }
                                    LocationClient.this.f5032E.c();
                                }
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    }.start();
                } catch (Throwable unused) {
                }
            }
        }
        if (this.f5041d.isOnceLocation()) {
            return;
        }
        this.f5030C = Boolean.FALSE;
        this.f5039b = this.f5043f.getPackageName();
        this.f5059v = B0.g.r(new StringBuilder(), this.f5039b, "_bdls_v2.9");
        Intent intent = new Intent(this.f5043f, (Class<?>) f.class);
        try {
            intent.putExtra("debug_dev", this.f5031D);
        } catch (Exception unused2) {
        }
        if (this.f5040c == null) {
            this.f5040c = new LocationClientOption();
        }
        intent.putExtra("cache_exception", this.f5040c.isIgnoreCacheException);
        intent.putExtra("kill_process", this.f5040c.isIgnoreKillProcess);
        intent.putExtra("auth_key", f5027x);
        intent.putExtra("proxyHost", this.f5040c.mProxyHost);
        intent.putExtra("proxyPort", this.f5040c.mProxyPort);
        intent.putExtra("username", this.f5040c.mUsername);
        intent.putExtra("password", this.f5040c.mPassword);
        intent.putExtra(EngineImpl.KEY_CUID, LBSAuthManager.getInstance(this.f5043f).getCUID());
        try {
            this.f5043f.bindService(intent, this.f5037K, 1);
        } catch (Exception e4) {
            e4.printStackTrace();
            this.f5042e = false;
        }
    }

    private void a(int i4) {
        if (this.f5049l.getCoorType() == null) {
            this.f5049l.setCoorType(this.f5040c.coorType);
        }
        if (this.f5051n || ((this.f5040c.location_change_notify && this.f5049l.getLocType() == 61) || this.f5049l.getLocType() == 66 || this.f5049l.getLocType() == 67 || this.f5061y || this.f5049l.getLocType() == 161)) {
            ArrayList<BDLocationListener> arrayList = this.f5047j;
            if (arrayList != null) {
                Iterator<BDLocationListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onReceiveLocation(this.f5049l);
                }
            }
            ArrayList<BDAbstractLocationListener> arrayList2 = this.f5048k;
            if (arrayList2 != null) {
                Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().onReceiveLocation(this.f5049l);
                }
            }
            if (this.f5049l.getLocType() == 66 || this.f5049l.getLocType() == 67) {
                return;
            }
            this.f5051n = false;
            this.f5058u = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4, Notification notification) {
        try {
            Intent intent = new Intent(this.f5043f, (Class<?>) f.class);
            intent.putExtra("notification", notification);
            intent.putExtra("id", i4);
            intent.putExtra("command", 1);
            this.f5043f.startForegroundService(intent);
            this.f5035H = true;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) throws RemoteException {
        Object obj;
        this.f5052o = false;
        if (message == null || (obj = message.obj) == null) {
            return;
        }
        LocationClientOption locationClientOption = (LocationClientOption) obj;
        if (this.f5040c.optionEquals(locationClientOption)) {
            return;
        }
        if (this.f5040c.scanSpan != locationClientOption.scanSpan) {
            try {
                synchronized (this.f5056s) {
                    try {
                        if (this.f5053p) {
                            this.f5045h.removeCallbacks(this.f5054q);
                            this.f5053p = false;
                        }
                        if (locationClientOption.scanSpan >= 1000 && !this.f5053p) {
                            if (this.f5054q == null) {
                                this.f5054q = new b();
                            }
                            this.f5045h.postDelayed(this.f5054q, locationClientOption.scanSpan);
                            this.f5053p = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception unused) {
            }
        }
        this.f5040c = new LocationClientOption(locationClientOption);
        if (this.f5044g != null && h.g(this.f5043f) >= 1) {
            try {
                Message messageObtain = Message.obtain((Handler) null, 15);
                messageObtain.replyTo = this.f5046i;
                messageObtain.setData(d());
                this.f5044g.send(messageObtain);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message, int i4) {
        if (this.f5042e) {
            try {
                Bundle data = message.getData();
                data.setClassLoader(BDLocation.class.getClassLoader());
                BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                this.f5049l = bDLocation;
                if (bDLocation.getLocType() == 61) {
                    this.f5057t = System.currentTimeMillis();
                }
                if (this.f5049l.getLocType() == 61 || this.f5049l.getLocType() == 161) {
                    com.baidu.location.b.a.a().a(this.f5049l.getLatitude(), this.f5049l.getLongitude(), this.f5049l.getCoorType());
                }
                a(i4);
            } catch (Exception unused) {
            }
        }
    }

    private void a(BDLocation bDLocation) {
        ArrayList<BDLocationListener> arrayList = this.f5047j;
        if (arrayList != null) {
            Iterator<BDLocationListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onReceiveLocation(bDLocation);
            }
        }
        ArrayList<BDAbstractLocationListener> arrayList2 = this.f5048k;
        if (arrayList2 != null) {
            Iterator<BDAbstractLocationListener> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().onReceiveLocation(bDLocation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z4) {
        try {
            Intent intent = new Intent(this.f5043f, (Class<?>) f.class);
            intent.putExtra("removenotify", z4);
            intent.putExtra("command", 2);
            this.f5043f.startService(intent);
            this.f5035H = true;
        } catch (Exception unused) {
        }
    }
}
