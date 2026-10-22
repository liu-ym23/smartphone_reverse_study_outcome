package com.android.server.am;

import android.os.DebugSmtEx;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public interface IBroadcastProxy {
    public static final String REASON_ON_PROXY = "on-broadcast-proxy";
    public static final String REASON_ON_UNPROXY = "on-broadcast-proxy";
    public static final String REASON_PROXYING = "BroadcastProxying";
    public static final String TAG_BROADCAST_PROXY = "BroadcastProxy";

    default void init(ActivityManagerService ams, BroadcastQueue impl, Handler handler) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void proxy(ProcessRecord app, String reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default void unProxy(ProcessRecord app, String reason) {
        DebugSmtEx.printDefaultFunInfo(getClass());
    }

    default boolean processUseProxy(String processName, int uid) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }

    default boolean isBroadcastCanBeProxy(BroadcastRecord r) {
        DebugSmtEx.printDefaultFunInfo(getClass());
        return false;
    }
}
