package com.bytedance.android.livehostapi;

import android.content.Context;

/* JADX INFO: loaded from: classes7.dex */
public class TTMiddlewareLiveSDK {
    public static volatile Context sAppContext;
    public static volatile IMiddleHostService sHostService;

    public TTMiddlewareLiveSDK() {
    }

    public static Context getContext() {
        return sAppContext;
    }

    public static IMiddleHostService hostMiddlewareService() {
        return sHostService;
    }
}
