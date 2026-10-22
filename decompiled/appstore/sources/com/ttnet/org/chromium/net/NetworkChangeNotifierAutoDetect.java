package com.ttnet.org.chromium.net;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import com.ttnet.org.chromium.base.ApplicationStatus;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
@SuppressLint({"NewApi"})
public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Looper f18393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f18394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NetworkConnectivityIntentFilter f18395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Observer f18396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f18397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f18398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f18399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f18400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public NetworkRequest f18401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f18402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f18403k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f18404l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f18405m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f18406n;

    public static class NetworkConnectivityIntentFilter extends IntentFilter {
        public NetworkConnectivityIntentFilter() {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    public interface Observer {
        void onConnectionSubtypeChanged(int r10);

        void onConnectionTypeChanged(int r10);

        void onNetworkConnect(long r10, int r11);

        void onNetworkDisconnect(long r10);

        void onNetworkSoonToDisconnect(long r10);

        void purgeActiveNetworkList(long[] r10);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NetworkChangeNotifierAutoDetect f18407a;

        public a(NetworkChangeNotifierAutoDetect r10) {
            this.f18407a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (NetworkChangeNotifierAutoDetect.c(this.f18407a) == true) goto L6;
            return;
        L6:
            if (NetworkChangeNotifierAutoDetect.h(this.f18407a) == false) goto L9;
            NetworkChangeNotifierAutoDetect.i(this.f18407a, false);
            return;
        L9:
            NetworkChangeNotifierAutoDetect.d(this.f18407a);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConnectivityManager f18408a;

        static {
        }

        public b(Context r10) {
            this.f18408a = (ConnectivityManager) r10.getSystemService("connectivity");
        }

        public Network[] a() {
            Network[] r10 = this.f18408a.getAllNetworks();     // Catch: Throwable -> L4
        L5:
            if (r10 == null) goto L7;
            return r10;
        L7:
            return new Network[0];
        L4:
            r10 = null;
            goto L5
        }

        public int b(Network r10) {
            NetworkInfo r11 = e(r10);
            if (r11 != null) goto L5;
        L9:
            if (r11 != null) goto L11;
            return 6;
        L11:
            if (r11.isConnected() == true) goto L13;
            return 6;
        L13:
            return NetworkChangeNotifierAutoDetect.a(r11.getType(), r11.getSubtype());
        L5:
            if (r11.getType() != 17) goto L9;
            r11 = this.f18408a.getActiveNetworkInfo();     // Catch: Throwable -> L8
        L8:
            r11 = null;
            goto L9
        }

        public Network c() {
            Network r10 = jf.a.a(this.f18408a);     // Catch: Throwable -> L5
        L6:
            if (r10 == null) goto L25;
            return r10;
        L25:
            NetworkInfo r11 = this.f18408a.getActiveNetworkInfo();     // Catch: Throwable -> L22
            if (r11 != null) goto L11;
            return null;
        L11:
            Network[] r12 = NetworkChangeNotifierAutoDetect.b(this, null);
            int r13 = r12.length;
            int r14 = 0;
        L12:
            if (r14 >= r13) goto L21;
            Network r15 = r12[r14];
            NetworkInfo r16 = e(r15);
            if (r16 == null) goto L20;
            if (r16.getType() != r11.getType()) goto L18;
        L19:
            r10 = r15;
            goto L20
        L18:
            if (r16.getType() == 17) goto L19;
        L20:
            r14 = r14 + 1;
            goto L12
        L21:
            return r10;
        L22:
            return null;
        L5:
            r10 = null;
            goto L6
        }

        public NetworkCapabilities d(Network r10) {
            return this.f18408a.getNetworkCapabilities(r10);
        L4:
            return null;
        }

        public final NetworkInfo e(Network r10) {
            return this.f18408a.getNetworkInfo(r10);
        L4:
            return this.f18408a.getNetworkInfo(r10);
        L6:
            return null;
        }

        public e f(g r18) {
            NetworkInfo r10 = null;
            Network r11 = c();     // Catch: Throwable -> L11
            NetworkInfo r12 = jf.a.d(this.f18408a, r11);     // Catch: Throwable -> L35
            if (r12 != null) goto L7;
        L10:
            r10 = r12;
            goto L12
        L7:
            if (r12.getType() != 17) goto L10;
            r10 = this.f18408a.getActiveNetworkInfo();     // Catch: Throwable -> L35
        L12:
            NetworkInfo r13 = g(r10);
            if (r13 == null) goto L15;
            if (r11 == null) goto L24;
            DnsStatus r14 = AndroidNetworkLibrary.getDnsStatus(r11);
            if (r14 != null) goto L22;
            return new e(true, r13.getType(), r13.getSubtype(), String.valueOf(NetworkChangeNotifierAutoDetect.r(r11)), false, "");
        L22:
            return new e(true, r13.getType(), r13.getSubtype(), String.valueOf(NetworkChangeNotifierAutoDetect.r(r11)), r14.getPrivateDnsActive(), r14.getPrivateDnsServerName());
        L24:
            if (r13.getType() != 1) goto L34;
            if (r13.getExtraInfo() == null) goto L32;
            if ("".equals(r13.getExtraInfo()) == true) goto L32;
            return new e(true, r13.getType(), r13.getSubtype(), r13.getExtraInfo(), false, "");
        L32:
            return new e(true, r13.getType(), r13.getSubtype(), r18.a(), false, "");
        L34:
            return new e(true, r13.getType(), r13.getSubtype(), null, false, "");
        L15:
            return new e(false, -1, -1, null, false, "");
        L11:
            r11 = null;
            goto L12
        }

        public final NetworkInfo g(NetworkInfo r10) {
            if (r10 != null) goto L6;
            return null;
        L6:
            if (r10.isConnected() == false) goto L9;
            return r10;
        L9:
            if (r10.getDetailedState() == NetworkInfo.DetailedState.BLOCKED) goto L12;
            return null;
        L12:
            if (ApplicationStatus.getStateForApplication() == 1) goto L14;
            return null;
        L14:
            return r10;
        }

        public void h(ConnectivityManager.NetworkCallback r10, Handler r11) {
            this.f18408a.registerDefaultNetworkCallback(r10, r11);     // Catch: Throwable -> L4
            return;
        }

        public void i(NetworkRequest r10, ConnectivityManager.NetworkCallback r11, Handler r12) {
            this.f18408a.registerNetworkCallback(r10, r11, r12);     // Catch: Throwable -> L4
            return;
        }

        public void j(ConnectivityManager.NetworkCallback r10) {
            this.f18408a.unregisterNetworkCallback(r10);     // Catch: Throwable -> L4
            return;
        }

        public boolean k(Network r10) {
            Socket r11 = new Socket();
            com.ttnet.org.chromium.base.o r12 = com.ttnet.org.chromium.base.o.a();     // Catch: Throwable -> L8 IOException -> L22
            r10.bindSocket(r11);     // Catch: Throwable -> L13
            if (r12 == null) goto L30;
            r12.close();     // Catch: Throwable -> L8 IOException -> L22
        L30:
            r11.close();     // Catch: IOException -> L25
            return true;
        L38:
            return true;
        L13:
            th = move-exception;
            if (r12 != null) goto L28;
        L19:
            throw th;     // Catch: Throwable -> L8 IOException -> L22
        L28:
            r12.close();     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L8 IOException -> L22
        L22:
            r11.close();     // Catch: IOException -> L27
            return false;
        L8:
            th = move-exception;
            r11.close();     // Catch: IOException -> L26
        L21:
            throw th;
        L39:
            return false;
        }
    }

    public class c extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NetworkChangeNotifierAutoDetect f18409a;

        public c(NetworkChangeNotifierAutoDetect r10) {
            this.f18409a = r10;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r10) {
            if (NetworkChangeNotifierAutoDetect.c(this.f18409a) == false) goto L6;
            NetworkChangeNotifierAutoDetect.d(this.f18409a);
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network r10, LinkProperties r11) {
            onAvailable(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r10) {
            onAvailable(null);
        }

        public /* synthetic */ c(NetworkChangeNotifierAutoDetect r10, a r11) {
            this(r10);
        }
    }

    public class d extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Network f18410a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ NetworkChangeNotifierAutoDetect f18411b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f18412a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f18413b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ boolean f18414c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ d f18415d;

            public a(d r10, long r11, int r12, boolean r13) {
                this.f18415d = r10;
                this.f18412a = r11;
                this.f18413b = r12;
                this.f18414c = r13;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.f(this.f18415d.f18411b).onNetworkConnect(this.f18412a, this.f18413b);
                if (this.f18414c == false) goto L6;
                NetworkChangeNotifierAutoDetect.f(this.f18415d.f18411b).onConnectionTypeChanged(this.f18413b);
                NetworkChangeNotifierAutoDetect.f(this.f18415d.f18411b).purgeActiveNetworkList(new long[]{this.f18412a});
                return;
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f18416a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f18417b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ d f18418c;

            public b(d r10, long r11, int r12) {
                this.f18418c = r10;
                this.f18416a = r11;
                this.f18417b = r12;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.f(this.f18418c.f18411b).onNetworkConnect(this.f18416a, this.f18417b);
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f18419a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f18420b;

            public c(d r10, long r11) {
                this.f18420b = r10;
                this.f18419a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.f(this.f18420b.f18411b).onNetworkSoonToDisconnect(this.f18419a);
            }
        }

        /* JADX INFO: renamed from: com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect$d$d, reason: collision with other inner class name */
        public class RunnableC0222d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Network f18421a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f18422b;

            public RunnableC0222d(d r10, Network r11) {
                this.f18422b = r10;
                this.f18421a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.f(this.f18422b.f18411b).onNetworkDisconnect(NetworkChangeNotifierAutoDetect.r(this.f18421a));
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f18423a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f18424b;

            public e(d r10, int r11) {
                this.f18424b = r10;
                this.f18423a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                NetworkChangeNotifierAutoDetect.f(this.f18424b.f18411b).onConnectionTypeChanged(this.f18423a);
            }
        }

        static {
        }

        public d(NetworkChangeNotifierAutoDetect r10) {
            this.f18411b = r10;
        }

        public final boolean a(Network r10, NetworkCapabilities r11) {
            if (r11 != null) goto L4;
            r11 = NetworkChangeNotifierAutoDetect.e(this.f18411b).d(r10);
        L4:
            if (r11 != null) goto L6;
        L11:
            return true;
        L6:
            if (r11.hasTransport(4) == true) goto L8;
        L10:
            return false;
        L8:
            if (NetworkChangeNotifierAutoDetect.e(this.f18411b).k(r10) == true) goto L10;
            goto L10
        }

        public final boolean b(Network r10, NetworkCapabilities r11) {
            if (c(r10) == false) goto L5;
        L8:
            return true;
        L5:
            if (a(r10, r11) == true) goto L8;
            return false;
        }

        public final boolean c(Network r10) {
            Network r11 = this.f18410a;
            if (r11 != null) goto L5;
        L7:
            return false;
        L5:
            if (r11.equals(r10) == true) goto L7;
            return true;
        }

        public void d() {
            Network[] r10 = NetworkChangeNotifierAutoDetect.b(NetworkChangeNotifierAutoDetect.e(this.f18411b), null);
            this.f18410a = null;
            if (r10.length != 1) goto L10;
            NetworkCapabilities r11 = NetworkChangeNotifierAutoDetect.e(this.f18411b).d(r10[0]);
            if (r11 != null) goto L7;
            return;
        L7:
            if (r11.hasTransport(4) == false) goto L12;
            this.f18410a = r10[0];
            return;
        L12:
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r10) {
            NetworkCapabilities r11 = NetworkChangeNotifierAutoDetect.e(this.f18411b).d(r10);
            if (b(r10, r11) == false) goto L6;
            return;
        L6:
            if (r11.hasTransport(4) == false) goto L13;
            Network r12 = this.f18410a;
            if (r12 != null) goto L10;
        L11:
            boolean r13 = true;
        L12:
            boolean r14 = r13;
            if (r14 == false) goto L16;
            this.f18410a = r10;
        L16:
            long r15 = NetworkChangeNotifierAutoDetect.r(r10);
            int r16 = NetworkChangeNotifierAutoDetect.e(this.f18411b).b(r10);
            NetworkChangeNotifierAutoDetect.g(this.f18411b, new a(this, r15, r16, r14));
            return;
        L10:
            if (r10.equals(r12) == false) goto L11;
        L13:
            r13 = false;
            goto L12
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r10, NetworkCapabilities r11) {
            if (b(r10, r11) == false) goto L5;
            return;
        L5:
            long r12 = NetworkChangeNotifierAutoDetect.r(r10);
            int r13 = NetworkChangeNotifierAutoDetect.e(this.f18411b).b(r10);
            NetworkChangeNotifierAutoDetect.g(this.f18411b, new b(this, r12, r13));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network r10, int r11) {
            if (b(r10, null) == false) goto L5;
            return;
        L5:
            long r12 = NetworkChangeNotifierAutoDetect.r(r10);
            NetworkChangeNotifierAutoDetect.g(this.f18411b, new c(this, r12));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r10) {
            if (c(r10) == false) goto L5;
            return;
        L5:
            NetworkChangeNotifierAutoDetect.g(this.f18411b, new RunnableC0222d(this, r10));
            if (this.f18410a == null) goto L13;
            this.f18410a = null;
            Network[] r11 = NetworkChangeNotifierAutoDetect.b(NetworkChangeNotifierAutoDetect.e(this.f18411b), r10);
            int r12 = r11.length;
            int r13 = 0;
        L8:
            if (r13 >= r12) goto L10;
            onAvailable(r11[r13]);
            r13 = r13 + 1;
            goto L8
        L10:
            int r14 = this.f18411b.o().b();
            NetworkChangeNotifierAutoDetect.g(this.f18411b, new e(this, r14));
            return;
        }

        public /* synthetic */ d(NetworkChangeNotifierAutoDetect r10, a r11) {
            this(r10);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f18425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f18427c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f18428d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f18429e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f18430f;

        public e(boolean r10, int r11, int r12, String r13, boolean r14, String r15) {
            this.f18425a = r10;
            this.f18426b = r11;
            this.f18427c = r12;
            if (r13 != null) goto L5;
            r13 = "";
        L5:
            this.f18428d = r13;
            this.f18429e = r14;
            if (r15 != null) goto L8;
            r15 = "";
        L8:
            this.f18430f = r15;
        }

        public int a() {
            if (g() == true) goto L6;
            return 1;
        L6:
            int r10 = e();
            if (r10 == 0) goto L12;
            if (r10 == 4) goto L12;
            if (r10 == 5) goto L12;
            return 0;
        L12:
            switch(d()) {
                case 1: goto L40;
                case 2: goto L38;
                case 3: goto L36;
                case 4: goto L35;
                case 5: goto L33;
                case 6: goto L31;
                case 7: goto L29;
                case 8: goto L27;
                case 9: goto L25;
                case 10: goto L23;
                case 11: goto L22;
                case 12: goto L20;
                case 13: goto L18;
                case 14: goto L16;
                case 15: goto L14;
                default: goto L13;
            };
        L13:
            return 0;
        L14:
            return 17;
        L16:
            return 16;
        L18:
            return 18;
        L20:
            return 13;
        L22:
            return 4;
        L23:
            return 12;
        L25:
            return 15;
        L27:
            return 14;
        L29:
            return 6;
        L31:
            return 11;
        L33:
            return 10;
        L35:
            return 5;
        L36:
            return 9;
        L38:
            return 8;
        L40:
            return 7;
        }

        public int b() {
            if (g() == true) goto L7;
            return 6;
        L7:
            return NetworkChangeNotifierAutoDetect.a(e(), d());
        }

        public String c() {
            return this.f18428d;
        }

        public int d() {
            return this.f18427c;
        }

        public int e() {
            return this.f18426b;
        }

        public String f() {
            return this.f18430f;
        }

        public boolean g() {
            return this.f18425a;
        }

        public boolean h() {
            return this.f18429e;
        }
    }

    public static abstract class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NetworkChangeNotifierAutoDetect f18431a;

        static {
        }

        public f() {
        }

        public abstract void a();

        public void b(NetworkChangeNotifierAutoDetect r10) {
            this.f18431a = r10;
        }

        public final void c() {
            this.f18431a.t();
        }

        public final void d() {
            this.f18431a.w();
        }
    }

    public static class g {
        public abstract String a();
    }

    static {
    }

    public NetworkChangeNotifierAutoDetect(Observer r10, f r11) {
        Looper r12 = Looper.myLooper();
        this.f18393a = r12;
        this.f18394b = new Handler(r12);
        this.f18396d = r10;
        this.f18399g = new b(com.ttnet.org.chromium.base.e.d());
        a r13 = null;
        this.f18400h = new d(this, r13);
        this.f18401i = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
        this.f18398f = new c(this, r13);
        this.f18403k = o();
        this.f18395c = new NetworkConnectivityIntentFilter();
        this.f18404l = false;
        this.f18405m = false;
        this.f18397e = r11;
        r11.b(this);
        this.f18405m = true;
    }

    public static /* synthetic */ int a(int r10, int r11) {
        return l(r10, r11);
    }

    public static /* synthetic */ Network[] b(b r10, Network r11) {
        return n(r10, r11);
    }

    public static /* synthetic */ boolean c(NetworkChangeNotifierAutoDetect r10) {
        return r10.f18402j;
    }

    public static /* synthetic */ void d(NetworkChangeNotifierAutoDetect r10) {
        r10.k();
    }

    public static /* synthetic */ b e(NetworkChangeNotifierAutoDetect r10) {
        return r10.f18399g;
    }

    public static /* synthetic */ Observer f(NetworkChangeNotifierAutoDetect r10) {
        return r10.f18396d;
    }

    public static /* synthetic */ void g(NetworkChangeNotifierAutoDetect r10, Runnable r11) {
        r10.v(r11);
    }

    public static /* synthetic */ boolean h(NetworkChangeNotifierAutoDetect r10) {
        return r10.f18404l;
    }

    public static /* synthetic */ boolean i(NetworkChangeNotifierAutoDetect r10, boolean r11) {
        r10.f18404l = r11;
        return r11;
    }

    public static int l(int r10, int r11) {
        if (r10 == 0) goto L21;
        if (r10 == 1) goto L18;
        if (r10 == 4) goto L21;
        if (r10 == 5) goto L21;
        if (r10 != 6) goto L11;
        return 5;
    L11:
        if (r10 != 7) goto L13;
        return 7;
    L13:
        if (r10 == 9) goto L15;
        return 0;
    L15:
        return 1;
    L18:
        return 2;
    L21:
        if (r11 == 20) goto L28;
        switch(r11) {
            case 1: goto L26;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L26;
            case 5: goto L25;
            case 6: goto L25;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L25;
            case 10: goto L25;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            case 14: goto L25;
            case 15: goto L25;
            default: goto L23;
        };
    L23:
        return 0;
    L24:
        return 5;
    L25:
        return 4;
    L26:
        return 3;
    L28:
        return 8;
    }

    public static Network[] n(b r10, Network r11) {
        Network[] r12 = r10.a();
        int r13 = r12.length;
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r13) goto L21;
        Network r16 = r12[r14];
        if (r16.equals(r11) == true) goto L19;
        NetworkCapabilities r17 = r10.d(r16);
        if (r17 == null) goto L19;
        if (r17.hasCapability(12) == false) goto L19;
        if (r17.hasTransport(4) == true) goto L15;
        r12[r15] = r16;
        r15 = r15 + 1;
        goto L19
    L15:
        if (r10.k(r16) == false) goto L19;
        return new Network[]{r16};
    L19:
        r14 = r14 + 1;
        goto L3
    L21:
        return (Network[]) Arrays.copyOf(r12, r15);
    }

    public static long r(Network r10) {
        return jf.a.c(r10);
    }

    public final void j() {
        if (com.ttnet.org.chromium.base.c.f18315a == true) goto L5;
        return;
    L5:
        if (s() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
    }

    public final void k() {
        e r10 = o();
        if (r10.b() == this.f18403k.b()) goto L5;
    L10:
        this.f18396d.onConnectionTypeChanged(r10.b());
    L12:
        if (r10.b() == this.f18403k.b()) goto L14;
    L15:
        this.f18396d.onConnectionSubtypeChanged(r10.a());
    L16:
        this.f18403k = r10;
        return;
    L14:
        if (r10.a() == this.f18403k.a()) goto L16;
    L5:
        if (r10.c().equals(this.f18403k.c()) == false) goto L10;
        if (r10.h() != this.f18403k.h()) goto L10;
        if (r10.f().equals(this.f18403k.f()) == true) goto L12;
        goto L10
    }

    public void m() {
        j();
        this.f18397e.a();
        w();
    }

    public e o() {
        return this.f18399g.f(null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        v(new a(this));
    }

    public long p() {
        Network r10 = this.f18399g.c();
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r(r10);
    }

    public long[] q() {
        Network[] r10 = n(this.f18399g, null);
        long[] r11 = new long[r10.length * 2];
        int r12 = r10.length;
        int r13 = 0;
        int r14 = 0;
    L3:
        if (r13 >= r12) goto L5;
        Network r15 = r10[r13];
        int r16 = r14 + 1;
        r11[r14] = r(r15);
        r14 = r14 + 2;
        r11[r16] = this.f18399g.b(r15);
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public final boolean s() {
        if (this.f18393a != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public void t() {
        j();
        if (this.f18402j == false) goto L7;
        k();
        return;
    L7:
        if (this.f18405m == false) goto L9;
        k();
    L9:
        c r10 = this.f18398f;
        if (r10 != null) goto L41;
    L14:
        int r11 = 0;
        if (this.f18398f == null) goto L43;
    L23:
        this.f18402j = true;
        d r12 = this.f18400h;
        if (r12 == null) goto L46;
        r12.d();
        this.f18399g.i(this.f18401i, this.f18400h, this.f18394b);     // Catch: RuntimeException -> L28
    L30:
        if (this.f18406n == false) goto L32;
        return;
    L32:
        if (this.f18405m == false) goto L48;
        Network[] r13 = n(this.f18399g, null);
        long[] r14 = new long[r13.length];
    L35:
        if (r11 >= r13.length) goto L37;
        r14[r11] = r(r13[r11]);
        r11 = r11 + 1;
        goto L35
    L37:
        this.f18396d.purgeActiveNetworkList(r14);
        return;
    L48:
        return;
    L28:
        this.f18406n = true;
        this.f18400h = null;
        goto L30
    L46:
        return;
    L43:
    L22:
        this.f18404l = false;
        goto L23
    L17:
        if (com.ttnet.org.chromium.base.e.d().registerReceiver(this, this.f18395c) == null) goto L19;
        boolean r15 = true;
    L20:
        this.f18404l = r15;     // Catch: RuntimeException -> L22
        goto L23
    L19:
        r15 = false;
        goto L20
    L41:
        this.f18399g.h(r10, this.f18394b);     // Catch: RuntimeException -> L13
    L13:
        this.f18398f = null;
        goto L14
    }

    public boolean u() {
        return this.f18406n;
    }

    public final void v(Runnable r10) {
        if (s() == false) goto L5;
        r10.run();
        return;
    L5:
        this.f18394b.post(r10);
    }

    public void w() {
        j();
        if (this.f18402j == true) goto L5;
        return;
    L5:
        this.f18402j = false;
        d r10 = this.f18400h;
        if (r10 == null) goto L8;
        this.f18399g.j(r10);
    L8:
        c r11 = this.f18398f;
        if (r11 == null) goto L11;
        this.f18399g.j(r11);
        return;
    L11:
        com.ttnet.org.chromium.base.e.d().unregisterReceiver(this);
    }
}
