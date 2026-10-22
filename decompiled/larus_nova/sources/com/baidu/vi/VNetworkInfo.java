package com.baidu.vi;

import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes39.dex */
public class VNetworkInfo {
    public int state;
    public int type;
    public String typename;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f33584a = null;

        static {
            int[] r100 = new int[NetworkInfo.State.values().length];
            f33584a = r100;
            r100[NetworkInfo.State.CONNECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f33584a[NetworkInfo.State.CONNECTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f33584a[NetworkInfo.State.DISCONNECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f33584a[NetworkInfo.State.DISCONNECTING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f33584a[NetworkInfo.State.SUSPENDED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public VNetworkInfo(NetworkInfo r100) {
        this.typename = r100.getTypeName();
        this.type = r100.getType();
        int r101 = a.f33584a[r100.getState().ordinal()];
        if (r101 == 1) goto L7;
        if (r101 == 2) goto L6;
        this.state = 0;
        return;
    L6:
        this.state = 1;
        return;
    L7:
        this.state = 2;
    }
}
