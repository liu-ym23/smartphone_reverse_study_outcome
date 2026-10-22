package com.bytedance.android.livesdkapi.depend.event;

/* JADX INFO: loaded from: classes12.dex */
public class NetworkChangeEvent {
    public static final int NETWORK_MOBILE = 1;
    public static final int NETWORK_NO = 0;
    public static final int NETWORK_WIFI = 2;
    public int networkType;

    public NetworkChangeEvent(int r100) {
        this.networkType = r100;
    }
}
