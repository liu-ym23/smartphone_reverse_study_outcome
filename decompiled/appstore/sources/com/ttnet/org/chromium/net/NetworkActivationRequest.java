package com.ttnet.org.chromium.net;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("net::android")
public class NetworkActivationRequest extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConnectivityManager f18383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f18384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f18385c;

    public interface Natives {
        void notifyAvailable(long r10, long r11);
    }

    public NetworkActivationRequest(long r10, int r11) {
        this.f18384b = new Object();
        ConnectivityManager r12 = (ConnectivityManager) com.ttnet.org.chromium.base.e.d().getSystemService("connectivity");
        this.f18383a = r12;
        if (r12 != null) goto L8;
        return;
    L8:
        r12.requestNetwork(new NetworkRequest.Builder().addTransportType(r11).addCapability(12).build(), this);     // Catch: SecurityException -> L7
        this.f18385c = r10;     // Catch: SecurityException -> L7
        return;
    }

    @CalledByNative
    public static NetworkActivationRequest createMobileNetworkRequest(long r10) {
        return new NetworkActivationRequest(r10, 0);
    }

    @CalledByNative
    private void unregister() {
        Object r10 = this.f18384b;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.f18385c == 0) goto L7;
        boolean r11 = true;
    L8:
        this.f18385c = 0;     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        if (r11 == false) goto L18;
        this.f18383a.unregisterNetworkCallback(this);
        return;
    L18:
        return;
    L7:
        r11 = false;
        goto L8
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network r10) {
        Object r11 = this.f18384b;
        monitor-enter(r11);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.f18385c != 0) goto L10;
        monitor-exit(r11);     // Catch: Throwable -> L8
        return;
    L10:
        j.b().notifyAvailable(this.f18385c, NetworkChangeNotifierAutoDetect.r(r10));     // Catch: Throwable -> L8
        monitor-exit(r11);     // Catch: Throwable -> L8
    }
}
