package com.ttnet.org.chromium.net;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.CalledByNativeUnchecked;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.net.URLConnection;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Enumeration;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
@MainDex
class AndroidNetworkLibrary {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f18362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f18363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static AtomicBoolean f18364c;

    public interface Natives {
        void onCellularAlwaysUp(boolean r10);
    }

    public class a extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConnectivityManager f18365a;

        public a(ConnectivityManager r10) {
            this.f18365a = r10;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network r10) {
            AndroidNetworkLibrary.a().set(false);
            NetworkCapabilities r11 = this.f18365a.getNetworkCapabilities(r10);
            if (r11 != null) goto L5;
        L9:
            com.ttnet.org.chromium.net.a.b().onCellularAlwaysUp(false);
            return;
        L5:
            if (r11.hasTransport(0) == false) goto L9;
            if (r11.hasCapability(12) == false) goto L9;
            com.ttnet.org.chromium.net.a.b().onCellularAlwaysUp(true);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static b f18366a;

        static {
            f18366a = new b();
        }

        public b() {
        }

        public static b a() {
            return f18366a;
        }

        public boolean b() {
            return jf.a.e();
        }

        public boolean c(String r10) {
            return jf.b.a(r10);
        }
    }

    public static class c extends Socket {

        public static class a extends SocketImpl {
            public a(FileDescriptor r10) {
                ((SocketImpl) this).fd = r10;
            }

            @Override // java.net.SocketImpl
            public void accept(SocketImpl r10) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public int available() {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public void bind(InetAddress r10, int r11) {
                throw new RuntimeException("accept not implemented");
            }

            @Override // java.net.SocketImpl
            public void close() {
            }

            @Override // java.net.SocketImpl
            public void connect(InetAddress r10, int r11) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            public void create(boolean r10) {
            }

            @Override // java.net.SocketImpl
            public InputStream getInputStream() {
                throw new RuntimeException("getInputStream not implemented");
            }

            @Override // java.net.SocketOptions
            public Object getOption(int r10) {
                throw new RuntimeException("getOption not implemented");
            }

            @Override // java.net.SocketImpl
            public OutputStream getOutputStream() {
                throw new RuntimeException("getOutputStream not implemented");
            }

            @Override // java.net.SocketImpl
            public void listen(int r10) {
                throw new RuntimeException("listen not implemented");
            }

            @Override // java.net.SocketImpl
            public void sendUrgentData(int r10) {
                throw new RuntimeException("sendUrgentData not implemented");
            }

            @Override // java.net.SocketOptions
            public void setOption(int r10, Object r11) {
                throw new RuntimeException("setOption not implemented");
            }

            @Override // java.net.SocketImpl
            public void connect(SocketAddress r10, int r11) {
                throw new RuntimeException("connect not implemented");
            }

            @Override // java.net.SocketImpl
            public void connect(String r10, int r11) {
                throw new RuntimeException("connect not implemented");
            }
        }

        public c(FileDescriptor r10) {
            super(new a(r10));
        }
    }

    static {
        f18364c = new AtomicBoolean(false);
    }

    public static /* synthetic */ AtomicBoolean a() {
        return f18364c;
    }

    @CalledByNativeUnchecked
    public static void addTestRootCertificate(byte[] r10) throws CertificateException, KeyStoreException, NoSuchAlgorithmException {
        X509Util.b(r10);
    }

    @CalledByNative
    @TargetApi(21)
    private static boolean alwayUpCellular() {
        if (f18364c.compareAndSet(false, true) == false) goto L14;
        ConnectivityManager r10 = (ConnectivityManager) com.ttnet.org.chromium.base.e.d().getSystemService("connectivity");
        if (r10 != null) goto L8;
        f18364c.set(false);
        return false;
    L8:
        NetworkRequest r11 = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        r10.requestNetwork(r11, new a(r10));     // Catch: Exception -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        f18364c.set(false);
        return false;
    L14:
        return true;
    }

    public static boolean b() {
        if (f18362a != null) goto L10;
        if (com.ttnet.org.chromium.base.a.a(com.ttnet.org.chromium.base.e.d(), "android.permission.ACCESS_NETWORK_STATE", Process.myPid(), Process.myUid()) != 0) goto L7;
        boolean r10 = true;
    L8:
        f18362a = Boolean.valueOf(r10);
        goto L10
    L7:
        r10 = false;
    L10:
        return f18362a.booleanValue();
    }

    public static boolean c() {
        if (f18363b != null) goto L10;
        if (com.ttnet.org.chromium.base.a.a(com.ttnet.org.chromium.base.e.d(), "android.permission.ACCESS_WIFI_STATE", Process.myPid(), Process.myUid()) != 0) goto L7;
        boolean r10 = true;
    L8:
        f18363b = Boolean.valueOf(r10);
        goto L10
    L7:
        r10 = false;
    L10:
        return f18363b.booleanValue();
    }

    @CalledByNative
    @TargetApi(21)
    private static boolean checkIsVpnOn() {
        ConnectivityManager r10 = (ConnectivityManager) com.ttnet.org.chromium.base.e.d().getSystemService("connectivity");
        if (r10 != null) goto L5;
        return false;
    L5:
        Network[] r11 = r10.getAllNetworks();
        int r12 = 0;
    L7:
        if (r12 >= r11.length) goto L15;
        if (r10.getNetworkInfo(r11[r12]).isConnected() == false) goto L14;
        if (r10.getNetworkCapabilities(r11[r12]).hasTransport(4) == false) goto L14;
        return true;
    L14:
        r12 = r12 + 1;
        goto L7
    L15:
        return false;
    }

    @CalledByNativeUnchecked
    public static void clearTestRootCertificates() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        X509Util.c();
    }

    @CalledByNative
    @TargetApi(23)
    public static DnsStatus getDnsStatus(Network r10) {
        if (b() == true) goto L5;
        return null;
    L5:
        ConnectivityManager r11 = (ConnectivityManager) com.ttnet.org.chromium.base.e.d().getSystemService("connectivity");
        if (r11 != null) goto L8;
        return null;
    L8:
        if (r10 != null) goto L10;
        r10 = jf.a.a(r11);
    L10:
        if (r10 != null) goto L18;
        return null;
    L18:
        LinkProperties r12 = r11.getLinkProperties(r10);     // Catch: RuntimeException -> L17
        if (r12 != null) goto L16;
        return null;
    L16:
        return new DnsStatus(r12.getDnsServers(), jf.c.c(r12), jf.c.b(r12));
    L20:
        return null;
    }

    @CalledByNative
    @TargetApi(23)
    private static boolean getIsCaptivePortal() {
        ConnectivityManager r10 = (ConnectivityManager) com.ttnet.org.chromium.base.e.d().getSystemService("connectivity");
        if (r10 != null) goto L5;
        return false;
    L5:
        Network r11 = jf.a.a(r10);
        if (r11 != null) goto L8;
        return false;
    L8:
        NetworkCapabilities r12 = r10.getNetworkCapabilities(r11);
        if (r12 != null) goto L11;
        return false;
    L11:
        if (r12.hasCapability(17) == false) goto L15;
        return true;
    L15:
        return false;
    }

    @CalledByNative
    public static String getMimeTypeFromExtension(String r10) {
        return URLConnection.guessContentTypeFromName("foo." + r10);
    }

    @CalledByNative
    private static String getNetworkOperator() {
        TelephonyManager r10 = (TelephonyManager) com.ttnet.org.chromium.base.e.d().getSystemService("phone");     // Catch: Throwable -> L8
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10.getNetworkOperator();
    L8:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    @CalledByNative
    public static String getWifiSSID() {
        return "";
    }

    @CalledByNative
    public static int getWifiSignalLevel(int r10) {
        if (com.ttnet.org.chromium.base.e.d() != null) goto L6;
        return -1;
    L6:
        if (com.ttnet.org.chromium.base.e.d().getContentResolver() != null) goto L9;
        return -1;
    L9:
        if (c() == false) goto L27;
        WifiManager r11 = (WifiManager) com.ttnet.org.chromium.base.e.d().getSystemService("wifi");
        Log.w("AndroidNetworkLibrary", "lz, getConnectionInfo calles");
        WifiInfo r12 = r11.getConnectionInfo();
        if (r12 != null) goto L13;
        return -1;
    L13:
        int r13 = r12.getRssi();
    L18:
        if (r13 != Integer.MIN_VALUE) goto L20;
        return -1;
    L20:
        int r14 = WifiManager.calculateSignalLevel(r13, r10);
        if (r14 < 0) goto L25;
        if (r14 >= r10) goto L25;
        return r14;
    L25:
        return -1;
    L27:
        Intent r15 = com.ttnet.org.chromium.base.e.d().registerReceiver(null, new IntentFilter("android.net.wifi.RSSI_CHANGED"));     // Catch: IllegalArgumentException -> L26
        if (r15 != null) goto L17;
        return -1;
    L17:
        r13 = r15.getIntExtra("newRssi", Integer.MIN_VALUE);
        goto L18
    }

    @CalledByNative
    public static boolean haveOnlyLoopbackAddresses() {
        Enumeration<NetworkInterface> r10 = NetworkInterface.getNetworkInterfaces();     // Catch: Exception -> L16
        if (r10 != null) goto L7;
        return false;
    L7:
        if (r10.hasMoreElements() == false) goto L14;
        NetworkInterface r11 = r10.nextElement();
        if (r11.isUp() == false) goto L7;
        if (r11.isLoopback() == true) goto L7;
        return false;
    L14:
        return true;
    L16:
        e = move-exception;
        Log.w("AndroidNetworkLibrary", "could not get network interfaces: " + e);
        return false;
    }

    @CalledByNative
    private static boolean isCleartextPermitted(String r10) {
        return b.a().c(r10);
    L5:
        return b.a().b();
    }

    @CalledByNative
    @TargetApi(23)
    private static boolean reportBadDefaultNetwork() {
        ConnectivityManager r10 = (ConnectivityManager) com.ttnet.org.chromium.base.e.d().getSystemService("connectivity");
        if (r10 != null) goto L5;
        return false;
    L5:
        r10.reportNetworkConnectivity(null, false);
        return true;
    }

    @CalledByNative
    private static void tagSocket(int r10, int r11, int r12) throws IOException {
        int r13 = TrafficStats.getThreadStatsTag();
        if (r12 == r13) goto L6;
        TrafficStats.setThreadStatsTag(r12);
    L6:
        if (r11 == (-1)) goto L8;
        x.b(r11);
    L8:
        ParcelFileDescriptor r14 = ParcelFileDescriptor.adoptFd(r10);
        c r15 = new c(r14.getFileDescriptor());
        TrafficStats.tagSocket(r15);
        r15.close();
        r14.detachFd();
        if (r12 == r13) goto L11;
        TrafficStats.setThreadStatsTag(r13);
    L11:
        if (r11 == (-1)) goto L14;
        x.a();
        return;
    }

    @CalledByNative
    public static AndroidCertVerifyResult verifyServerCertificates(byte[][] r10, String r11, String r12) {
        return X509Util.m(r10, r11, r12);
    L6:
        return new AndroidCertVerifyResult(-1);
    L10:
        return new AndroidCertVerifyResult(-1);
    L8:
        return new AndroidCertVerifyResult(-1);
    }
}
