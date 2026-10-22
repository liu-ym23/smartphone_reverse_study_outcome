package com.ttnet.org.chromium.net;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.ttnet.org.chromium.base.ApplicationStatus;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.build.BuildConfig;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NetworkChangeNotifierAutoDetect extends PluginBroadcastReceiver {
    private static final String TAG = "NetworkChangeNotifierAutoDetect";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Looper f37810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f37811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final NetworkConnectivityIntentFilter f37812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f37813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final d f37814e;
    private ConnectivityManager.NetworkCallback f;
    private a g;
    private e h;
    private MyNetworkCallback i;
    private NetworkRequest j;
    private boolean k;
    private b l;
    private boolean m;
    private boolean n;
    private boolean o;

    private class AndroidRDefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        LinkProperties mLinkProperties;
        NetworkCapabilities mNetworkCapabilities;
        final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

        private AndroidRDefaultNetworkCallback(NetworkChangeNotifierAutoDetect r1) {
            this.this$0 = r1;
        }

        /* synthetic */ AndroidRDefaultNetworkCallback(NetworkChangeNotifierAutoDetect r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r1) {
            this.mLinkProperties = null;
            this.mNetworkCapabilities = null;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r10) {
            this.mLinkProperties = null;
            this.mNetworkCapabilities = null;
            if (NetworkChangeNotifierAutoDetect.a(this.this$0) == false) goto L6;
            NetworkChangeNotifierAutoDetect.a(this.this$0, new b(false, -1, -1, false, null, null, false, ""));
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network r1, LinkProperties r2) {
            this.mLinkProperties = r2;
            if (NetworkChangeNotifierAutoDetect.a(this.this$0) == true) goto L5;
            return;
        L5:
            if (this.mLinkProperties != null) goto L7;
            return;
        L7:
            if (this.mNetworkCapabilities == null) goto L12;
            NetworkChangeNotifierAutoDetect.a(this.this$0, getNetworkState(r1));
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r1, NetworkCapabilities r2) {
            this.mNetworkCapabilities = r2;
            if (NetworkChangeNotifierAutoDetect.a(this.this$0) == true) goto L5;
            return;
        L5:
            if (this.mLinkProperties != null) goto L7;
            return;
        L7:
            if (this.mNetworkCapabilities == null) goto L12;
            NetworkChangeNotifierAutoDetect.a(this.this$0, getNetworkState(r1));
            return;
        }

        private b getNetworkState(Network r14) {
            int r2 = 0;
            int r3 = -1;
            if (this.mNetworkCapabilities.hasTransport(1) == false) goto L5;
        L27:
            int r6 = 1;
        L28:
            int r7 = r3;
        L30:
            return new b(true, r6, r7, !this.mNetworkCapabilities.hasCapability(11), String.valueOf(NetworkChangeNotifierAutoDetect.a(r14)), null, com.ttnet.org.chromium.base.compat.d.a(this.mLinkProperties), com.ttnet.org.chromium.base.compat.d.b(this.mLinkProperties));
        L5:
            if (this.mNetworkCapabilities.hasTransport(5) == true) goto L27;
            if (this.mNetworkCapabilities.hasTransport(0) == false) goto L13;
            NetworkInfo r0 = NetworkChangeNotifierAutoDetect.c(this.this$0).a(r14);
            if (r0 == null) goto L15;
            r3 = r0.getSubtype();
        L15:
            r6 = r2;
            goto L28
        L13:
            if (this.mNetworkCapabilities.hasTransport(3) == false) goto L17;
            r2 = 9;
            goto L15
        L17:
            if (this.mNetworkCapabilities.hasTransport(2) == false) goto L20;
            r2 = 7;
            goto L15
        L20:
            if (this.mNetworkCapabilities.hasTransport(4) == false) goto L26;
            NetworkInfo r1 = NetworkChangeNotifierAutoDetect.c(this.this$0).b(r14);
            if (r1 == null) goto L24;
            int r4 = r1.getType();
        L25:
            r2 = r4;
            goto L15
        L24:
            r4 = 17;
            goto L25
        L26:
            r6 = -1;
            r7 = -1;
            goto L30
        }
    }

    private class DefaultNetworkCallback extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

        private DefaultNetworkCallback(NetworkChangeNotifierAutoDetect r1) {
            this.this$0 = r1;
        }

        /* synthetic */ DefaultNetworkCallback(NetworkChangeNotifierAutoDetect r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r1) {
            if (NetworkChangeNotifierAutoDetect.a(this.this$0) == false) goto L6;
            NetworkChangeNotifierAutoDetect.b(this.this$0);
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network r1) {
            onAvailable(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r1, NetworkCapabilities r2) {
            onAvailable(null);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLinkPropertiesChanged(Network r1, LinkProperties r2) {
            onAvailable(null);
        }
    }

    private class MyNetworkCallback extends ConnectivityManager.NetworkCallback {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Network mVpnInPlace;
        final /* synthetic */ NetworkChangeNotifierAutoDetect this$0;

        static {
        }

        private MyNetworkCallback(NetworkChangeNotifierAutoDetect r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MyNetworkCallback(NetworkChangeNotifierAutoDetect r1, AnonymousClass1 r2) {
            this(r1);
        }

        public long getVpnNetId() {
            Network r2 = this.mVpnInPlace;
            if (r2 != null) goto L6;
            return -1;
        L6:
            return NetworkChangeNotifierAutoDetect.a(r2);
        }

        void initializeVpnInPlace() {
            Network[] r0 = NetworkChangeNotifierAutoDetect.a(NetworkChangeNotifierAutoDetect.c(this.this$0), null);
            this.mVpnInPlace = null;
            if (r0.length != 1) goto L10;
            NetworkCapabilities r1 = NetworkChangeNotifierAutoDetect.c(this.this$0).e(r0[0]);
            if (r1 != null) goto L7;
            return;
        L7:
            if (r1.hasTransport(4) == false) goto L12;
            this.mVpnInPlace = r0[0];
            return;
        L12:
            return;
        }

        private boolean ignoreNetworkDueToVpn(Network r1) {
            Network r0 = this.mVpnInPlace;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.equals(r1) == true) goto L7;
            return true;
        }

        private boolean ignoreConnectedInaccessibleVpn(Network r2, NetworkCapabilities r3) {
            if (r3 != null) goto L4;
            r3 = NetworkChangeNotifierAutoDetect.c(this.this$0).e(r2);
        L4:
            if (r3 != null) goto L6;
        L11:
            return true;
        L6:
            if (r3.hasTransport(4) == true) goto L8;
        L10:
            return false;
        L8:
            if (NetworkChangeNotifierAutoDetect.c(this.this$0).d(r2) == true) goto L10;
            goto L10
        }

        private boolean ignoreConnectedNetwork(Network r2, NetworkCapabilities r3) {
            if (ignoreNetworkDueToVpn(r2) == false) goto L5;
        L8:
            return true;
        L5:
            if (ignoreConnectedInaccessibleVpn(r2, r3) == true) goto L8;
            return false;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r9) {
            TraceEvent r0 = TraceEvent.a("NetworkChangeNotifierCallback::onAvailable");
            NetworkCapabilities r1 = NetworkChangeNotifierAutoDetect.c(this.this$0).e(r9);     // Catch: Throwable -> L25
            if (ignoreConnectedNetwork(r9, r1) == false) goto L8;
            if (r0 == null) goto L36;
            r0.close();
            return;
        L36:
            return;
        L8:
            boolean r2 = false;
            if (r1 != null) goto L12;
        L18:
            final boolean r6 = r2;
            if (r6 == false) goto L21;
            this.mVpnInPlace = r9;     // Catch: Throwable -> L25
        L21:
            final long r3 = NetworkChangeNotifierAutoDetect.a(r9);     // Catch: Throwable -> L25
            final int r5 = NetworkChangeNotifierAutoDetect.c(this.this$0).c(r9);     // Catch: Throwable -> L25
            this.this$0.a(new AnonymousClass1(this, r3, r5, r6));     // Catch: Throwable -> L25
            if (r0 == null) goto L37;
            r0.close();
            return;
        L37:
            return;
        L12:
            if (r1.hasTransport(4) == false) goto L18;
            Network r4 = this.mVpnInPlace;     // Catch: Throwable -> L25
            if (r4 != null) goto L16;
        L17:
            r2 = true;
            goto L18
        L16:
            if (r9.equals(r4) == true) goto L18;
        L25:
            th = move-exception;
            if (r0 != null) goto L34;
        L31:
            throw th;
        L34:
            r0.close();     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            th.addSuppressed(th);
            goto L31
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network r8, NetworkCapabilities r9) {
            TraceEvent r0 = TraceEvent.a("NetworkChangeNotifierCallback::onCapabilitiesChanged");
        L18:
            th = move-exception;
            if (r0 != null) goto L27;
        L24:
            throw th;
        L27:
            r0.close();     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            th.addSuppressed(th);
            goto L24
        L4:
            if (ignoreConnectedNetwork(r8, r9) == false) goto L8;
            if (r0 == null) goto L29;
            r0.close();
            return;
        L29:
            return;
        L8:
            final long r3 = NetworkChangeNotifierAutoDetect.a(r8);     // Catch: Throwable -> L18
            final int r5 = NetworkChangeNotifierAutoDetect.c(this.this$0).c(r8);     // Catch: Throwable -> L18
            Network r10 = this.mVpnInPlace;     // Catch: Throwable -> L18
            if (r10 != null) goto L11;
        L13:
            boolean r11 = false;
        L14:
            final boolean r6 = r11;
            this.this$0.a(new AnonymousClass2(this, r3, r5, r6));     // Catch: Throwable -> L18
            if (r0 == null) goto L30;
            r0.close();
            return;
        L30:
            return;
        L11:
            if (r10.equals(r8) == false) goto L13;
            r11 = true;
            goto L14
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLosing(Network r4, int r5) {
            TraceEvent r6 = TraceEvent.a("NetworkChangeNotifierCallback::onLosing");
        L12:
            th = move-exception;
            if (r6 != null) goto L21;
        L18:
            throw th;
        L21:
            r6.close();     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            th.addSuppressed(th);
            goto L18
        L4:
            if (ignoreConnectedNetwork(r4, null) == false) goto L8;
            if (r6 == null) goto L23;
            r6.close();
            return;
        L23:
            return;
        L8:
            final long r0 = NetworkChangeNotifierAutoDetect.a(r4);     // Catch: Throwable -> L12
            this.this$0.a(new AnonymousClass3(this, r0));     // Catch: Throwable -> L12
            if (r6 == null) goto L24;
            r6.close();
            return;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(final Network r6) {
            TraceEvent r0 = TraceEvent.a("NetworkChangeNotifierCallback::onLost");
        L23:
            th = move-exception;
            if (r0 != null) goto L32;
        L29:
            throw th;
        L32:
            r0.close();     // Catch: Throwable -> L27
        L27:
            th = move-exception;
            th.addSuppressed(th);
            goto L29
        L4:
            if (ignoreNetworkDueToVpn(r6) == false) goto L8;
            if (r0 == null) goto L35;
            r0.close();
            return;
        L35:
            return;
        L8:
            Network r1 = this.mVpnInPlace;     // Catch: Throwable -> L23
            int r2 = 0;
            if (r1 != null) goto L11;
        L13:
            final boolean r3 = false;
        L14:
            this.this$0.a(new AnonymousClass4(this, r6, r3));     // Catch: Throwable -> L23
            if (this.mVpnInPlace == null) goto L20;
            this.mVpnInPlace = null;     // Catch: Throwable -> L23
            Network[] r7 = NetworkChangeNotifierAutoDetect.a(NetworkChangeNotifierAutoDetect.c(this.this$0), r6);     // Catch: Throwable -> L23
            int r4 = r7.length;     // Catch: Throwable -> L23
        L17:
            if (r2 >= r4) goto L19;
            onAvailable(r7[r2]);     // Catch: Throwable -> L23
            r2 = r2 + 1;     // Catch: Throwable -> L23
            goto L17
        L19:
            final int r8 = this.this$0.d().f();     // Catch: Throwable -> L23
            this.this$0.a(new AnonymousClass5(this, r8));     // Catch: Throwable -> L23
        L20:
            if (r0 == null) goto L36;
            r0.close();
            return;
        L36:
            return;
        L11:
            if (r1.equals(r6) == false) goto L13;
            r3 = true;
            goto L14
        }
    }

    private static class NetworkConnectivityIntentFilter extends IntentFilter {
        NetworkConnectivityIntentFilter() {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
        }
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f37831a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConnectivityManager f37832b;

        static {
            f37831a = true;
        }

        a(Context r3) {
            this.f37832b = (ConnectivityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin")).getSystemService("connectivity"), ConnectivityManager.class, "com.obric.aiagent.plugin");
        }

        a() {
            this.f37832b = null;
        }

        private NetworkInfo a(NetworkInfo r3) {
            if (r3 != null) goto L6;
            return null;
        L6:
            if (r3.isConnected() == false) goto L9;
            return r3;
        L9:
            if (Build.VERSION.SDK_INT >= 21) goto L12;
            return null;
        L12:
            if (r3.getDetailedState() == NetworkInfo.DetailedState.BLOCKED) goto L15;
            return null;
        L15:
            if (ApplicationStatus.getStateForApplication() == 1) goto L17;
            return null;
        L17:
            return r3;
        }

        b a(e r22) {
            NetworkInfo r1 = null;
            r1 = null;
            Network r2 = null;
        L15:
            Network r3 = null;
        L16:
            NetworkInfo r4 = a(r1);
            if (r4 != null) goto L21;
            return new b(false, -1, -1, false, null, null, false, "");
        L21:
            if (r3 == null) goto L40;
            NetworkCapabilities r0 = e(r3);
            int r5 = 0;
            if (r0 != null) goto L25;
        L27:
            boolean r9 = false;
        L28:
            DnsStatus r6 = AndroidNetworkLibrary.a(r3);
            if (r6 == null) goto L31;
            ArrayList r11 = new ArrayList();
            byte[][] r7 = r6.getDnsServers();     // Catch: UnknownHostException -> L62
            int r8 = r7.length;     // Catch: UnknownHostException -> L62
        L34:
            if (r5 >= r8) goto L38;
            r11.add(InetAddress.getByAddress(r7[r5]));     // Catch: UnknownHostException -> L62
            r5 = r5 + 1;
        L38:
            return new b(true, r4.getType(), r4.getSubtype(), r9, String.valueOf(NetworkChangeNotifierAutoDetect.a(r3)), r11, r6.getPrivateDnsActive(), r6.getPrivateDnsServerName());
        L31:
            return new b(true, r4.getType(), r4.getSubtype(), r9, String.valueOf(NetworkChangeNotifierAutoDetect.a(r3)), null, false, "");
        L25:
            if (r0.hasCapability(11) == true) goto L27;
            r9 = true;
            goto L28
        L40:
            if (f37831a == true) goto L47;
            if (Build.VERSION.SDK_INT < 23) goto L47;
            throw new AssertionError();
        L47:
            if (r4.getType() != 1) goto L60;
            if (Build.VERSION.SDK_INT >= 23) goto L60;
            if (r22 == null) goto L60;
            if (r4.getExtraInfo() == null) goto L58;
            if ("".equals(r4.getExtraInfo()) == true) goto L58;
            return new b(true, r4.getType(), r4.getSubtype(), false, r4.getExtraInfo(), null, false, "");
        L58:
            return new b(true, r4.getType(), r4.getSubtype(), false, r22.a(), null, false, "");
        L60:
            return new b(true, r4.getType(), r4.getSubtype(), false, null, null, false, "");
        L4:
            if (Build.VERSION.SDK_INT < 23) goto L13;
            r3 = b();     // Catch: Throwable -> L15
            NetworkInfo r10 = b(r3);     // Catch: Throwable -> L61
            if (r10 != null) goto L9;
        L12:
            r2 = r3;
            NetworkInfo r12 = r10;
        L14:
            NetworkInfo r20 = r12;
            r3 = r2;
            r1 = r20;
            goto L16
        L9:
            if (r10.getType() != 17) goto L12;
            r12 = this.f37832b.getActiveNetworkInfo();     // Catch: Throwable -> L61
            r2 = r3;
            goto L14
        L13:
            r12 = this.f37832b.getActiveNetworkInfo();     // Catch: Throwable -> L15
            goto L14
        }

        NetworkInfo a(Network r2) {
            return this.f37832b.getNetworkInfo(r2);
        L4:
            return this.f37832b.getNetworkInfo(r2);
        L6:
            return null;
        }

        NetworkInfo b(Network r3) {
            NetworkInfo r4 = a(r3);
            if (r4 != null) goto L5;
            return r4;
        L5:
            if (r4.getType() != 17) goto L13;
            return this.f37832b.getActiveNetworkInfo();
        L8:
            return null;
        L13:
            return r4;
        }

        int c(Network r1) {
            NetworkInfo r0 = b(r1);
            if (r0 != null) goto L5;
            return 6;
        L5:
            if (r0.isConnected() == true) goto L7;
            return 6;
        L7:
            return NetworkChangeNotifierAutoDetect.a(r0.getType(), r0.getSubtype());
        }

        public Network[] a() {
            Network[] r0 = this.f37832b.getAllNetworks();     // Catch: Throwable -> L4
        L5:
            if (r0 == null) goto L7;
            return r0;
        L7:
            return new Network[0];
        L4:
            r0 = null;
            goto L5
        }

        public boolean d(Network r2) {
            Socket r1 = new Socket();
            com.ttnet.org.chromium.base.s r0 = com.ttnet.org.chromium.base.s.a();     // Catch: Throwable -> L17 IOException -> L20
            r2.bindSocket(r1);     // Catch: Throwable -> L10
            if (r0 == null) goto L30;
            r0.close();     // Catch: Throwable -> L17 IOException -> L20
        L30:
            r1.close();     // Catch: IOException -> L23
            return true;
        L37:
            return true;
        L10:
            th = move-exception;
            if (r0 != null) goto L32;
        L16:
            throw th;     // Catch: Throwable -> L17 IOException -> L20
        L32:
            r0.close();     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            th.addSuppressed(th);     // Catch: Throwable -> L17 IOException -> L20
        L17:
            th = move-exception;
            r1.close();     // Catch: IOException -> L24
        L19:
            throw th;
        L34:
            r1.close();     // Catch: IOException -> L25
        L22:
            return false;
        }

        public NetworkCapabilities e(Network r3) {
            int r0 = 0;
        L4:
            if (r0 >= 2) goto L8;
            return this.f37832b.getNetworkCapabilities(r3);
        L7:
            r0 = r0 + 1;
            goto L4
        L8:
            return null;
        }

        void a(NetworkRequest r3, ConnectivityManager.NetworkCallback r4, Handler r5) {
            if (Build.VERSION.SDK_INT < 26) goto L5;
            com.ttnet.org.chromium.base.compat.c.a(this.f37832b, r3, r4, r5);     // Catch: Throwable -> L7
        L8:
            return;
        L5:
            this.f37832b.registerNetworkCallback(r3, r4);     // Catch: Throwable -> L7
        }

        void a(ConnectivityManager.NetworkCallback r1, Handler r2) {
            com.ttnet.org.chromium.base.compat.c.a(this.f37832b, r1, r2);     // Catch: Throwable -> L4
            return;
        }

        void a(ConnectivityManager.NetworkCallback r1) {
            this.f37832b.unregisterNetworkCallback(r1);     // Catch: Throwable -> L4
            return;
        }

        Network b() {
            if (Build.VERSION.SDK_INT >= 23) goto L40;
            Network r0 = null;
        L38:
            NetworkInfo r2 = this.f37832b.getActiveNetworkInfo();     // Catch: Throwable -> L37
            if (r2 != null) goto L13;
            return null;
        L13:
            Network[] r3 = NetworkChangeNotifierAutoDetect.a(this, null);
            int r4 = r3.length;
            int r6 = 0;
        L14:
            if (r6 >= r4) goto L36;
            Network r7 = r3[r6];
            NetworkInfo r8 = a(r7);
            if (r8 == null) goto L35;
            if (r8.getType() != r2.getType()) goto L20;
        L21:
            if (r0 != null) goto L23;
        L32:
            if (r0 == null) goto L34;
            com.ttnet.org.chromium.base.j.e(NetworkChangeNotifierAutoDetect.i(), "defaultNetwork != null", new Object[0]);
        L34:
            r0 = r7;
            goto L35
        L23:
            if (Build.VERSION.SDK_INT < 29) goto L32;
            if (r8.getDetailedState() == NetworkInfo.DetailedState.CONNECTING) goto L35;
            NetworkInfo r9 = a(r0);
            if (r9 == null) goto L32;
            if (r9.getDetailedState() != NetworkInfo.DetailedState.CONNECTING) goto L32;
            r0 = null;
            goto L32
        L20:
            if (r8.getType() == 17) goto L21;
        L35:
            r6 = r6 + 1;
            goto L14
        L36:
            return r0;
        L37:
            return null;
        L40:
            r0 = com.ttnet.org.chromium.base.compat.a.a(this.f37832b);     // Catch: Throwable -> L6
        L7:
            if (r0 == null) goto L38;
            return r0;
        L6:
            r0 = null;
            goto L7
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f37833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f37834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f37835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f37836d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f37837e;
        private final List<InetAddress> f;
        private final boolean g;
        private final String h;

        public b(boolean r3, int r4, int r5, boolean r6, String r7, List<InetAddress> r8, boolean r9, String r10) {
            List<InetAddress> r11 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
            this.f37833a = r3;
            this.f37834b = r4;
            this.f37835c = r5;
            this.f37836d = r6;
            if (r7 != null) goto L5;
            r7 = "";
        L5:
            this.f37837e = r7;
            if (r11 != null) goto L8;
            r11 = new ArrayList();
        L8:
            this.f = r11;
            this.g = r9;
            if (r10 != null) goto L11;
            r10 = "";
        L11:
            this.h = r10;
        }

        public boolean a() {
            return this.f37833a;
        }

        public int b() {
            return this.f37834b;
        }

        public boolean c() {
            return this.f37836d;
        }

        public int d() {
            return this.f37835c;
        }

        public String e() {
            return this.f37837e;
        }

        public int f() {
            if (a() == true) goto L7;
            return 6;
        L7:
            return NetworkChangeNotifierAutoDetect.a(b(), d());
        }

        public int g() {
            if (c() == false) goto L6;
            return 2;
        L6:
            return 1;
        }

        public int h() {
            if (a() == true) goto L6;
            return 1;
        L6:
            int r0 = b();
            if (r0 == 0) goto L12;
            if (r0 == 4) goto L12;
            if (r0 == 5) goto L12;
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

        public List<InetAddress> i() {
            return this.f;
        }

        public boolean j() {
            return this.g;
        }

        public String k() {
            return this.h;
        }
    }

    public interface c {
        void a(int r1);

        void a(long r1);

        void a(long r1, int r3, boolean r4);

        void a(long r1, boolean r3);

        void a(long[] r1);

        void b(int r1);

        void c(int r1);
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f37838a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private NetworkChangeNotifierAutoDetect f37839b;

        public abstract void c();

        static {
            f37838a = true;
        }

        public d() {
        }

        public final void a() {
            if (f37838a == false) goto L5;
        L9:
            this.f37839b.b();
            return;
        L5:
            if (this.f37839b != null) goto L9;
            throw new AssertionError();
        }

        public final void b() {
            if (f37838a == false) goto L5;
        L9:
            this.f37839b.c();
            return;
        L5:
            if (this.f37839b != null) goto L9;
            throw new AssertionError();
        }

        public void a(NetworkChangeNotifierAutoDetect r1) {
            this.f37839b = r1;
        }
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f37840a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f37841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Object f37842c;

        String a() {
            return "";
        }

        static {
            f37840a = true;
        }

        e(Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.f37842c = new Object();
            if (f37840a == false) goto L5;
        L9:
            this.f37841b = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
            return;
        L5:
            if (Build.VERSION.SDK_INT < 23) goto L9;
            throw new AssertionError();
        }

        e() {
            this.f37842c = new Object();
            this.f37841b = ZeusTransformUtils.wrapperContext(null, "com.obric.aiagent.plugin");
        }
    }

    static {
    }

    private static int b(int r4, int r5) {
        if (r4 == 0) goto L21;
        if (r4 == 1) goto L18;
        if (r4 == 4) goto L21;
        if (r4 == 5) goto L21;
        if (r4 != 6) goto L11;
        return 5;
    L11:
        if (r4 != 7) goto L13;
        return 7;
    L13:
        if (r4 == 9) goto L15;
        return 0;
    L15:
        return 1;
    L18:
        return 2;
    L21:
        if (r5 == 20) goto L28;
        switch(r5) {
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

    /* JADX INFO: renamed from: lambda$LeThA6NlulxVy2BtrVrk-_sjYhs, reason: not valid java name */
    public static /* synthetic */ void m1249lambda$LeThA6NlulxVy2BtrVrk_sjYhs(NetworkChangeNotifierAutoDetect r0, Runnable r1) {
        r0.b(r1);
    }

    static /* synthetic */ int a(int r0, int r1) {
        return b(r0, r1);
    }

    static /* synthetic */ void a(NetworkChangeNotifierAutoDetect r0, b r1) {
        r0.a(r1);
    }

    static /* synthetic */ boolean a(NetworkChangeNotifierAutoDetect r0) {
        return r0.k;
    }

    static /* synthetic */ boolean a(NetworkChangeNotifierAutoDetect r0, boolean r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ Network[] a(a r0, Network r1) {
        return b(r0, r1);
    }

    static /* synthetic */ void b(NetworkChangeNotifierAutoDetect r0) {
        r0.l();
    }

    static /* synthetic */ a c(NetworkChangeNotifierAutoDetect r0) {
        return r0.g;
    }

    static /* synthetic */ c d(NetworkChangeNotifierAutoDetect r0) {
        return r0.f37813d;
    }

    static /* synthetic */ boolean e(NetworkChangeNotifierAutoDetect r0) {
        return r0.m;
    }

    static /* synthetic */ String i() {
        return TAG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NetworkChangeNotifierAutoDetect(c r4, d r5) {
        c r6 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        Looper r0 = Looper.myLooper();
        this.f37810a = r0;
        this.f37811b = new Handler(r0);
        this.f37813d = r6;
        this.g = new a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        this.h = new e((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    L5:
        DefaultNetworkCallback r1 = null;
        Object[] r2 = 0;
        Object[] r3 = 0;
        Object[] r7 = 0;
        if (Build.VERSION.SDK_INT < 21) goto L8;
        this.i = new MyNetworkCallback(this, r7 == true ? 1 : 0);
        this.j = new NetworkRequest.Builder().addCapability(12).removeCapability(15).build();
    L10:
        if (Build.VERSION.SDK_INT < 30) goto L13;
        this.f = new AndroidRDefaultNetworkCallback(this, r3 == true ? 1 : 0);
    L16:
        this.l = d();
        this.f37812c = new NetworkConnectivityIntentFilter();
        this.m = false;
        this.n = false;
        this.f37814e = r5;
        r5.a(this);
        this.n = true;
        return;
    L13:
        if (Build.VERSION.SDK_INT < 28) goto L15;
        r1 = new DefaultNetworkCallback(this, r2 == true ? 1 : 0);
    L15:
        this.f = r1;
        goto L16
    L8:
        this.i = null;
        this.j = null;
        goto L10
    }

    private boolean j() {
        if (this.f37810a != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    private void k() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        if (j() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Must be called on NetworkChangeNotifierAutoDetect thread.");
    }

    public void a(Runnable r3) {
        final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (j() == false) goto L5;
        r4.run();
        return;
    L5:
        this.f37811b.post(new $$Lambda$NetworkChangeNotifierAutoDetect$LeThA6NlulxVy2BtrVrk_sjYhs(this, r4));
    }

    private /* synthetic */ void b(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (this.k == false) goto L6;
        r4.run();
        return;
    }

    public void a() {
        k();
        this.f37814e.c();
        c();
    }

    public void b() {
        k();
        if (this.k == false) goto L7;
        l();
        return;
    L7:
        if (this.n == false) goto L9;
        l();
    L9:
        ConnectivityManager.NetworkCallback r1 = this.f;
        if (r1 != null) goto L41;
    L14:
        int r3 = 0;
        if (this.f == null) goto L39;
    L23:
        this.k = true;
        MyNetworkCallback r0 = this.i;
        if (r0 == null) goto L46;
        r0.initializeVpnInPlace();
        this.g.a(this.j, this.i, this.f37811b);     // Catch: RuntimeException -> L28
    L30:
        if (this.o == false) goto L32;
        return;
    L32:
        if (this.n == false) goto L48;
        Network[] r2 = b(this.g, null);
        long[] r4 = new long[r2.length];
    L35:
        if (r3 >= r2.length) goto L37;
        r4[r3] = a(r2[r3]);
        r3 = r3 + 1;
        goto L35
    L37:
        this.f37813d.a(r4);
        return;
    L48:
        return;
    L28:
        this.o = true;
        this.i = null;
        goto L30
    L46:
        return;
    L39:
    L22:
        this.m = false;
        goto L23
    L17:
        if (ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this, this.f37812c, "com.obric.aiagent.plugin") == null) goto L19;
        boolean r5 = true;
    L20:
        this.m = r5;     // Catch: RuntimeException -> L22
        goto L23
    L19:
        r5 = false;
        goto L20
    L41:
        this.g.a(r1, this.f37811b);     // Catch: RuntimeException -> L13
    L13:
        this.f = null;
        goto L14
    }

    public void c() {
        k();
        if (this.k == true) goto L5;
        return;
    L5:
        this.k = false;
        MyNetworkCallback r0 = this.i;
        if (r0 == null) goto L8;
        this.g.a(r0);
    L8:
        ConnectivityManager.NetworkCallback r1 = this.f;
        if (r1 == null) goto L11;
        this.g.a(r1);
        return;
    L11:
        ZeusTransformUtils.unregisterReceiver((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.ttnet.org.chromium.base.d.a(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), this, "com.obric.aiagent.plugin");
    }

    public b d() {
        return this.g.a(this.h);
    }

    private static Network[] b(a r8, Network r9) {
        Network[] r0 = r8.a();
        int r1 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r1) goto L24;
        Network r5 = r0[r3];
        if (r5 == null) goto L22;
        if (r5.equals(r9) == true) goto L22;
        NetworkCapabilities r6 = r8.e(r5);
        if (r6 == null) goto L22;
        if (r6.hasCapability(12) == false) goto L22;
        if (r6.hasTransport(4) == true) goto L18;
        r0[r4] = r5;
        r4 = r4 + 1;
        goto L22
    L18:
        if (r8.d(r5) == false) goto L22;
        return new Network[]{r5};
    L22:
        r3 = r3 + 1;
        goto L3
    L24:
        return (Network[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r0, r4), Network[].class, "com.obric.aiagent.plugin");
    }

    public long[] e() {
        int r1 = 0;
        if (Build.VERSION.SDK_INT < 21) goto L5;
        Network[] r0 = b(this.g, null);
        long[] r2 = new long[r0.length * 2];
        int r3 = r0.length;
        int r4 = 0;
    L7:
        if (r1 >= r3) goto L9;
        Network r5 = r0[r1];
        int r6 = r4 + 1;
        r2[r4] = a(r5);
        r4 = r6 + 1;
        r2[r6] = this.g.c(r5);
        r1 = r1 + 1;
        goto L7
    L9:
        return r2;
    L5:
        return new long[0];
    }

    public long f() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        Network r4 = this.g.b();
        if (r4 != null) goto L9;
        return -1;
    L9:
        return a(r4);
    }

    public long g() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return -1;
    L5:
        MyNetworkCallback r4 = this.i;
        if (r4 != null) goto L9;
        return -1;
    L9:
        return r4.getVpnNetId();
    }

    public boolean h() {
        return this.o;
    }

    public void onReceive(Context r2, Intent r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        a(new AnonymousClass1(this));
    }

    private void l() {
        a(d());
    }

    private void a(b r3) {
        if (r3.f() == this.l.f()) goto L5;
    L12:
        this.f37813d.a(r3.f());
    L14:
        if (r3.f() == this.l.f()) goto L16;
    L17:
        this.f37813d.c(r3.h());
    L19:
        if (r3.g() == this.l.g()) goto L21;
        this.f37813d.b(r3.g());
    L21:
        this.l = r3;
        return;
    L16:
        if (r3.h() == this.l.h()) goto L19;
    L5:
        if (r3.e().equals(this.l.e()) == false) goto L12;
        if (r3.i().equals(this.l.i()) == false) goto L12;
        if (r3.j() != this.l.j()) goto L12;
        if (r3.k().equals(this.l.k()) == true) goto L14;
        goto L12
    }

    public static long a(Network r2) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return com.ttnet.org.chromium.base.compat.a.a(r2);
    L7:
        return Integer.parseInt(r2.toString());
    }
}
