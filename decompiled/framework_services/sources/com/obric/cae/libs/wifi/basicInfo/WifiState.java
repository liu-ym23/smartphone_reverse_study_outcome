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
    public final AtomicInteger a;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[NetworkInfo.DetailedState.values().length];
            a = r0;
            r0[NetworkInfo.DetailedState.CONNECTING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L20:
            a[NetworkInfo.DetailedState.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L16:
            a[NetworkInfo.DetailedState.DISCONNECTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L18:
            a[NetworkInfo.DetailedState.DISCONNECTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
            return;
        }
    }

    public WifiState() {
        this.a = new AtomicInteger(-1);
    }

    public int getState() {
        return this.a.get();
    }

    public void handleConnectStateChanged(NetworkInfo.DetailedState r3) {
        switch(a.a[r3.ordinal()]) {
            case 1: goto L8;
            case 2: goto L7;
            case 3: goto L6;
            case 4: goto L5;
            default: goto L4;
        };
    L4:
        LogUtil.e("WifiState", "Set an invalid value for wifi connect state: " + r3);
        return;
    L5:
        this.a.set(7);
        return;
    L6:
        this.a.set(6);
        return;
    L7:
        this.a.set(5);
        return;
    L8:
        this.a.set(4);
    }

    public void handleWifiStateChanged(int r3) {
        switch(r3) {
            case 0: goto L7;
            case 1: goto L6;
            case 2: goto L5;
            case 3: goto L4;
            default: goto L3;
        };
    L3:
        LogUtil.e("WifiState", "Set an invalid value for wifi state: " + r3);
        return;
    L4:
        this.a.set(3);
        return;
    L5:
        this.a.set(2);
        return;
    L6:
        this.a.set(1);
        return;
    L7:
        this.a.set(0);
    }

    public boolean isConnected() {
        if (this.a.get() != 5) goto L5;
        return true;
    L5:
        return false;
    }
}
