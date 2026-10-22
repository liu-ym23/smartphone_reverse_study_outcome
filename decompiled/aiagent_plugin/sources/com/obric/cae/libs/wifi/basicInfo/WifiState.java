package com.obric.cae.libs.wifi.basicInfo;

import android.net.NetworkInfo;
import com.obric.cae.libs.utils.LogUtil;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class WifiState {
    public static final int STATE_CONNECTED = 5;
    public static final int STATE_CONNECTING = 4;
    public static final int STATE_DISCONNECTED = 7;
    public static final int STATE_DISCONNECTING = 6;
    public static final int STATE_OFF = 1;
    public static final int STATE_ON = 3;
    public static final int STATE_TURNING_OFF = 0;
    public static final int STATE_TURNING_ON = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f31840a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31841a = null;

        static {
            int[] r0 = new int[NetworkInfo.DetailedState.values().length];
            f31841a = r0;
            r0[NetworkInfo.DetailedState.CONNECTING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f31841a[NetworkInfo.DetailedState.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f31841a[NetworkInfo.DetailedState.DISCONNECTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f31841a[NetworkInfo.DetailedState.DISCONNECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public WifiState() {
        this.f31840a = new AtomicInteger(-1);
    }

    public int getState() {
        return this.f31840a.get();
    }

    public void handleConnectStateChanged(NetworkInfo.DetailedState r4) {
        int r0 = a.f31841a[r4.ordinal()];
        if (r0 != 1) goto L5;
        this.f31840a.set(4);
        return;
    L5:
        if (r0 != 2) goto L7;
        this.f31840a.set(5);
        return;
    L7:
        if (r0 == 3) goto L11;
        if (r0 == 4) goto L10;
        LogUtil.e("WifiState", "Set an invalid value for wifi connect state: " + r4);
        return;
    L10:
        this.f31840a.set(7);
        return;
    L11:
        this.f31840a.set(6);
    }

    public void handleWifiStateChanged(int r2) {
        if (r2 != 0) goto L4;
        this.f31840a.set(0);
        return;
    L4:
        if (r2 != 1) goto L6;
        this.f31840a.set(1);
        return;
    L6:
        if (r2 != 2) goto L8;
        this.f31840a.set(2);
        return;
    L8:
        if (r2 == 3) goto L10;
        LogUtil.e("WifiState", "Set an invalid value for wifi state: " + r2);
        return;
    L10:
        this.f31840a.set(3);
    }

    public boolean isConnected() {
        if (this.f31840a.get() != 5) goto L5;
        return true;
    L5:
        return false;
    }
}
