package com.bytedance.android.ec.core.frontier;

import com.bytedance.common.wschannel.event.ConnectionState;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f44043a = null;

    static {
        int[] r100 = new int[ConnectionState.values().length];
        f44043a = r100;
        r100[ConnectionState.CONNECTING.ordinal()] = 1;
        r100[ConnectionState.CONNECTED.ordinal()] = 2;
        r100[ConnectionState.CONNECT_FAILED.ordinal()] = 3;
        r100[ConnectionState.CONNECT_CLOSED.ordinal()] = 4;
    }
}
