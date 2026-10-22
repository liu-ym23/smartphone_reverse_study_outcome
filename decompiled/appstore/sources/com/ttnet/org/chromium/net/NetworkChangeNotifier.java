package com.ttnet.org.chromium.net;

import android.net.ConnectivityManager;
import com.ttnet.org.chromium.base.ObserverList;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("net")
public class NetworkChangeNotifier {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static NetworkChangeNotifier f18386f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f18387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObserverList f18388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConnectivityManager f18389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public NetworkChangeNotifierAutoDetect f18390d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f18391e;

    public interface ConnectionTypeObserver {
        void onConnectionTypeChanged(int r10);
    }

    public interface Natives {
        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyConnectionTypeChanged(long r10, NetworkChangeNotifier r11, int r12, long r13);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyMaxBandwidthChanged(long r10, NetworkChangeNotifier r11, int r12);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyOfNetworkConnect(long r10, NetworkChangeNotifier r11, long r12, int r13);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyOfNetworkDisconnect(long r10, NetworkChangeNotifier r11, long r12);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyOfNetworkSoonToDisconnect(long r10, NetworkChangeNotifier r11, long r12);

        @NativeClassQualifiedName("NetworkChangeNotifierDelegateAndroid")
        void notifyPurgeActiveNetworkList(long r10, NetworkChangeNotifier r11, long[] r12);
    }

    public class a implements NetworkChangeNotifierAutoDetect.Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NetworkChangeNotifier f18392a;

        public a(NetworkChangeNotifier r10) {
            this.f18392a = r10;
        }

        @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
        public void onConnectionSubtypeChanged(int r10) {
            this.f18392a.g(r10);
        }

        @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
        public void onConnectionTypeChanged(int r10) {
            NetworkChangeNotifier.a(this.f18392a, r10);
        }

        @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
        public void onNetworkConnect(long r10, int r11) {
            this.f18392a.j(r10, r11);
        }

        @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
        public void onNetworkDisconnect(long r10) {
            this.f18392a.k(r10);
        }

        @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
        public void onNetworkSoonToDisconnect(long r10) {
            this.f18392a.l(r10);
        }

        @Override // com.ttnet.org.chromium.net.NetworkChangeNotifierAutoDetect.Observer
        public void purgeActiveNetworkList(long[] r10) {
            this.f18392a.m(r10);
        }
    }

    static {
    }

    public NetworkChangeNotifier() {
        this.f18391e = 0;
        this.f18387a = new ArrayList();
        this.f18388b = new ObserverList();
        this.f18389c = (ConnectivityManager) com.ttnet.org.chromium.base.e.d().getSystemService("connectivity");
    }

    public static /* synthetic */ void a(NetworkChangeNotifier r10, int r11) {
        r10.q(r11);
    }

    public static NetworkChangeNotifier e() {
        return f18386f;
    }

    @CalledByNative
    public static void fakeConnectionSubtypeChanged(int r10) {
        o(false);
        e().g(r10);
    }

    @CalledByNative
    public static void fakeDefaultNetwork(long r10, int r11) {
        o(false);
        e().i(r11, r10);
    }

    @CalledByNative
    public static void fakeNetworkConnected(long r10, int r11) {
        o(false);
        e().j(r10, r11);
    }

    @CalledByNative
    public static void fakeNetworkDisconnected(long r10) {
        o(false);
        e().k(r10);
    }

    @CalledByNative
    public static void fakeNetworkSoonToBeDisconnected(long r10) {
        o(false);
        e().l(r10);
    }

    @CalledByNative
    public static void fakePurgeActiveNetworkList(long[] r10) {
        o(false);
        e().m(r10);
    }

    @CalledByNative
    public static void forceConnectivityState(boolean r10) {
        o(false);
        e().c(r10);
    }

    @CalledByNative
    public static void forceUpdateNetworkTypeInfo() {
        e().d();
    }

    @CalledByNative
    public static NetworkChangeNotifier init() {
        if (f18386f != null) goto L6;
        f18386f = new NetworkChangeNotifier();
    L6:
        return f18386f;
    }

    @CalledByNative
    public static boolean isProcessBoundToNetwork() {
        return e().f();
    }

    public static void n() {
        e().p(true, new r());
    }

    public static void o(boolean r10) {
        e().p(r10, new s());
    }

    @CalledByNative
    public void addNativeObserver(long r10) {
        this.f18387a.add(Long.valueOf(r10));
    }

    public final void b() {
        NetworkChangeNotifierAutoDetect r10 = this.f18390d;
        if (r10 == null) goto L6;
        r10.m();
        this.f18390d = null;
        return;
    }

    public final void c(boolean r10) {
        int r11 = 0;
        if (this.f18391e == 6) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == r10) goto L12;
        if (r10 == true) goto L10;
        r11 = 6;
    L10:
        q(r11);
        g(!r10 ? 1 : 0);
        return;
    L12:
        return;
    L5:
        r12 = false;
        goto L6
    }

    public final void d() {
        NetworkChangeNotifierAutoDetect r10 = this.f18390d;
        if (r10 == null) goto L8;
        NetworkChangeNotifierAutoDetect.e r11 = r10.o();
        if (this.f18391e == r11.b()) goto L9;
        int r12 = r11.b();
        this.f18391e = r12;
        h(r12);
        return;
    L9:
        return;
    }

    public final boolean f() {
        if (jf.a.b(this.f18389c) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void g(int r10) {
        Iterator r11 = this.f18387a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Long r12 = (Long) r11.next();
        k.b().notifyMaxBandwidthChanged(r12.longValue(), this, r10);
        goto L4
    }

    @CalledByNative
    public int getCurrentConnectionSubtype() {
        NetworkChangeNotifierAutoDetect r10 = this.f18390d;
        if (r10 != null) goto L6;
        return 0;
    L6:
        return r10.o().a();
    }

    @CalledByNative
    public int getCurrentConnectionType() {
        return this.f18391e;
    }

    @CalledByNative
    public long getCurrentDefaultNetId() {
        NetworkChangeNotifierAutoDetect r10 = this.f18390d;
        if (r10 != null) goto L6;
        return -1;
    L6:
        return r10.p();
    }

    @CalledByNative
    public long[] getCurrentNetworksAndTypes() {
        NetworkChangeNotifierAutoDetect r10 = this.f18390d;
        if (r10 != null) goto L6;
        return new long[0];
    L6:
        return r10.q();
    }

    public void h(int r10) {
        i(r10, getCurrentDefaultNetId());
    }

    public final void i(int r10, long r11) {
        Iterator r12 = this.f18387a.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        Long r13 = (Long) r12.next();
        k.b().notifyConnectionTypeChanged(r13.longValue(), this, r10, r11);
        goto L4
    L6:
        Iterator r14 = this.f18388b.iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        ((ConnectionTypeObserver) r14.next()).onConnectionTypeChanged(r10);
        goto L8
    }

    public void j(long r10, int r12) {
        Iterator r11 = this.f18387a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Long r13 = (Long) r11.next();
        k.b().notifyOfNetworkConnect(r13.longValue(), this, r10, r12);
        goto L4
    }

    public void k(long r10) {
        Iterator r11 = this.f18387a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Long r12 = (Long) r11.next();
        k.b().notifyOfNetworkDisconnect(r12.longValue(), this, r10);
        goto L4
    }

    public void l(long r10) {
        Iterator r11 = this.f18387a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Long r12 = (Long) r11.next();
        k.b().notifyOfNetworkSoonToDisconnect(r12.longValue(), this, r10);
        goto L4
    }

    public void m(long[] r10) {
        Iterator r11 = this.f18387a.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Long r12 = (Long) r11.next();
        k.b().notifyPurgeActiveNetworkList(r12.longValue(), this, r10);
        goto L4
    }

    public final void p(boolean r10, NetworkChangeNotifierAutoDetect.f r11) {
        if (r10 == true) goto L4;
        b();
        return;
    L4:
        if (this.f18390d != null) goto L8;
        NetworkChangeNotifierAutoDetect r12 = new NetworkChangeNotifierAutoDetect(new a(this), r11);
        this.f18390d = r12;
        NetworkChangeNotifierAutoDetect.e r13 = r12.o();
        q(r13.b());
        g(r13.a());
        return;
    }

    public final void q(int r10) {
        this.f18391e = r10;
        h(r10);
    }

    @CalledByNative
    public boolean registerNetworkCallbackFailed() {
        NetworkChangeNotifierAutoDetect r10 = this.f18390d;
        if (r10 != null) goto L6;
        return false;
    L6:
        return r10.u();
    }

    @CalledByNative
    public void removeNativeObserver(long r10) {
        this.f18387a.remove(Long.valueOf(r10));
    }
}
