package m5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Object f22084t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static a f22085u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f22086a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f22087b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22088c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f22089d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f22090e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f22091f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f22092g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f22093h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f22094i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f22095j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f22096k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f22097l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TelephonyManager f22098m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ConnectivityManager f22099n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public WifiManager f22100o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public c f22101p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public b f22102q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f22103r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Handler f22104s;

    /* JADX INFO: renamed from: m5.a$a, reason: collision with other inner class name */
    public class HandlerC0313a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22105a;

        public HandlerC0313a(a r10, Looper r11) {
            this.f22105a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            super.handleMessage(r10);
            a.e(this.f22105a, new c(this.f22105a));
            a.g(this.f22105a, new b(this.f22105a));
            IntentFilter r11 = new IntentFilter();
            r11.addAction("android.net.wifi.RSSI_CHANGED");
            r11.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            a.h(this.f22105a).registerReceiver(a.f(this.f22105a), r11);
            a.p(this.f22105a);
        }
    }

    public class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22106a;

        public b(a r10) {
            this.f22106a = r10;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
        L26:
            e = move-exception;
            e.printStackTrace();
            return;
        L3:
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r11.getAction()) == false) goto L31;
            NetworkInfo r12 = a.l(this.f22106a).getActiveNetworkInfo();     // Catch: Exception -> L26
            Object r13 = a.m(this.f22106a);     // Catch: Exception -> L26
            monitor-enter(r13);     // Catch: Exception -> L26
            if (r12 == null) goto L46;
        L10:
            if (r12 != null) goto L12;
        L14:
            a.o(this.f22106a, "DISCONNECTED");     // Catch: Throwable -> L8
        L15:
            monitor-exit(r13);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;     // Catch: Exception -> L26
        L17:
            if ("DISCONNECTED".equals(a.n(this.f22106a)) == false) goto L49;
            Object r14 = a.q(this.f22106a);     // Catch: Exception -> L26
            monitor-enter(r14);     // Catch: Exception -> L26
            a.b(this.f22106a, -1);     // Catch: Throwable -> L23
            monitor-exit(r14);     // Catch: Throwable -> L23
        L50:
            return;
        L23:
            th = move-exception;
            throw th;     // Catch: Exception -> L26
        L49:
            return;
        L12:
            if (r12.isConnected() == false) goto L14;
            a.p(this.f22106a);     // Catch: Throwable -> L8
            a.o(this.f22106a, r12.getTypeName());     // Catch: Throwable -> L8
            goto L15
        L46:
            a.o(this.f22106a, "DISCONNECTED");     // Catch: Throwable -> L8
            goto L10
        L31:
            if ("android.net.wifi.RSSI_CHANGED".equals(r11.getAction()) == false) goto L51;
            Object r15 = a.q(this.f22106a);     // Catch: Exception -> L26
            monitor-enter(r15);     // Catch: Exception -> L26
            int r16 = r11.getIntExtra("newRssi", -70);     // Catch: Throwable -> L37
            a r17 = this.f22106a;     // Catch: Throwable -> L37
            a.b(r17, a.d(r17, r16));     // Catch: Throwable -> L37
            monitor-exit(r15);     // Catch: Throwable -> L37
        L52:
            return;
        L37:
            th = move-exception;
            throw th;     // Catch: Exception -> L26
        }
    }

    public class c extends PhoneStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f22107a;

        public c(a r10) {
            this.f22107a = r10;
        }

        @Override // android.telephony.PhoneStateListener
        public void onDataConnectionStateChanged(int r10, int r11) {
            super.onDataConnectionStateChanged(r10, r11);
            Object r12 = a.a(this.f22107a);
            monitor-enter(r12);
            a r13 = this.f22107a;     // Catch: Throwable -> L6 Exception -> L8
            r13.f22086a = r11;     // Catch: Throwable -> L6 Exception -> L8
            a.c(r13, a.u(r11));     // Catch: Throwable -> L6 Exception -> L8
        L10:
            monitor-exit(r12);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        L8:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L6
            goto L10
        }

        @Override // android.telephony.PhoneStateListener
        public void onServiceStateChanged(ServiceState r10) {
            super.onServiceStateChanged(r10);
            a.i(this.f22107a, r10.toString());     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength r10) {
            super.onSignalStrengthsChanged(r10);
            Object r11 = a.j(this.f22107a);
            monitor-enter(r11);
            a.k(this.f22107a, r10.getLevel());     // Catch: Throwable -> L6
        L8:
            monitor-exit(r11);     // Catch: Throwable -> L10
            return;
        L6:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        }
    }

    static {
        f22084t = new Object();
    }

    public a(Context r10) {
        this.f22086a = -1;
        this.f22088c = "NOT_REGISTERED";
        this.f22089d = "NOT_REGISTERED";
        this.f22090e = -1;
        this.f22091f = -1;
        this.f22092g = false;
        this.f22093h = new Object();
        this.f22094i = new Object();
        this.f22095j = new Object();
        this.f22096k = new Object();
        this.f22097l = new Object();
        this.f22098m = null;
        this.f22099n = null;
        this.f22100o = null;
        this.f22101p = null;
        this.f22102q = null;
        this.f22103r = -1;
        this.f22104s = null;
        this.f22087b = r10;     // Catch: Exception -> L5
        this.f22098m = (TelephonyManager) r10.getSystemService("phone");     // Catch: Exception -> L5
        this.f22099n = (ConnectivityManager) this.f22087b.getSystemService("connectivity");     // Catch: Exception -> L5
        this.f22100o = (WifiManager) this.f22087b.getApplicationContext().getSystemService("wifi");     // Catch: Exception -> L5
        v();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    public static /* synthetic */ Object a(a r10) {
        return r10.f22093h;
    }

    public static /* synthetic */ int b(a r10, int r11) {
        r10.f22091f = r11;
        return r11;
    }

    public static /* synthetic */ String c(a r10, String r11) {
        r10.f22088c = r11;
        return r11;
    }

    public static /* synthetic */ int d(a r10, int r11) {
        return r10.r(r11);
    }

    public static /* synthetic */ c e(a r10, c r11) {
        r10.f22101p = r11;
        return r11;
    }

    public static /* synthetic */ b f(a r10) {
        return r10.f22102q;
    }

    public static /* synthetic */ b g(a r10, b r11) {
        r10.f22102q = r11;
        return r11;
    }

    public static /* synthetic */ Context h(a r10) {
        return r10.f22087b;
    }

    public static /* synthetic */ boolean i(a r10, String r11) {
        return r10.x(r11);
    }

    public static /* synthetic */ Object j(a r10) {
        return r10.f22094i;
    }

    public static /* synthetic */ int k(a r10, int r11) {
        r10.f22090e = r11;
        return r11;
    }

    public static /* synthetic */ ConnectivityManager l(a r10) {
        return r10.f22099n;
    }

    public static /* synthetic */ Object m(a r10) {
        return r10.f22095j;
    }

    public static /* synthetic */ String n(a r10) {
        return r10.f22089d;
    }

    public static /* synthetic */ String o(a r10, String r11) {
        r10.f22089d = r11;
        return r11;
    }

    public static /* synthetic */ boolean p(a r10) {
        return r10.y();
    }

    public static /* synthetic */ Object q(a r10) {
        return r10.f22096k;
    }

    public static a s(Context r10) {
        Object r11 = f22084t;
        monitor-enter(r11);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f22085u != null) goto L9;
        f22085u = new a(r10);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return f22085u;
    }

    public static String u(int r10) {
        switch(r10) {
            case 1: goto L43;
            case 2: goto L41;
            case 3: goto L39;
            case 4: goto L37;
            case 5: goto L35;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L29;
            case 9: goto L27;
            case 10: goto L25;
            case 11: goto L23;
            case 12: goto L21;
            case 13: goto L19;
            case 14: goto L17;
            case 15: goto L15;
            case 16: goto L13;
            case 17: goto L11;
            case 18: goto L9;
            case 19: goto L7;
            case 20: goto L5;
            default: goto L3;
        };
    L3:
        return "UNKNOWN";
    L5:
        return "NR";
    L7:
        return "LTE_CA";
    L9:
        return "IWLAN";
    L11:
        return "TD_SCDMA";
    L13:
        return "GSM";
    L15:
        return "HSPA+";
    L17:
        return "CDMA - eHRPD";
    L19:
        return "LTE";
    L21:
        return "CDMA - EvDo rev. B";
    L23:
        return "iDEN";
    L25:
        return "HSPA";
    L27:
        return "HSUPA";
    L29:
        return "HSDPA";
    L31:
        return "CDMA - 1xRTT";
    L33:
        return "CDMA - EvDo rev. A";
    L35:
        return "CDMA - EvDo rev. 0";
    L37:
        return "CDMA";
    L39:
        return "UMTS";
    L41:
        return "EDGE";
    L43:
        return "GPRS";
    }

    public final int r(int r10) {
        if (r10 > (-88)) goto L7;
        return 0;
    L7:
        if (r10 < (-55)) goto L10;
        return 4;
    L10:
        return ((r10 - (-88)) * 4) / 33;
    }

    public String t() {
        Object r10 = this.f22095j;
        monitor-enter(r10);
        String r11 = this.f22089d;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public String toString() {
        return "NetworkQualityCollect{mGSMType='" + this.f22088c + "', mNetworkType='" + this.f22089d + "', mDataLevel=" + this.f22090e + ", mWifiLevel=" + this.f22091f + ", lastDataSim=" + this.f22103r + ", getIpAvailableType=" + m5.c.a(this.f22087b) + '}';
    }

    public final void v() {
        HandlerThread r10 = new HandlerThread("listener_thread");
        r10.start();
        HandlerC0313a r11 = new HandlerC0313a(this, r10.getLooper());
        this.f22104s = r11;
        r11.sendEmptyMessage(0);
    }

    public boolean w() {
        if (this.f22092g == false) goto L5;
        return true;
    L5:
        if ("NR".equals(this.f22088c) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final boolean x(String r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        Object r11 = this.f22097l;
        monitor-enter(r11);
        this.f22092g = false;     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r10) == false) goto L10;
    L17:
        monitor-exit(r11);     // Catch: Throwable -> L14
        return this.f22092g;
    L10:
        if (r10.contains("nrState=NOT_RESTRICTED") == false) goto L12;
    L16:
        this.f22092g = true;     // Catch: Throwable -> L14
        goto L17
    L12:
        if (r10.contains("nrState=CONNECTED") == false) goto L17;
    L14:
        th = move-exception;
        throw th;
    }

    public final boolean y() {
        int r10 = SubscriptionManager.getDefaultDataSubscriptionId();     // Catch: Exception -> L6
        if (this.f22103r == r10) goto L8;
        TelephonyManager r11 = this.f22098m.createForSubscriptionId(r10);     // Catch: Exception -> L6
        this.f22098m = r11;     // Catch: Exception -> L6
        r11.listen(this.f22101p, 321);     // Catch: Exception -> L6
        this.f22103r = r10;     // Catch: Exception -> L6
        return true;
    L8:
        return true;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}
