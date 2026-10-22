package com.alipay.android.app.helper;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public class TidHelper extends com.alipay.sdk.tid.TidHelper {
    public TidHelper() {
    }

    public static void clearTID(Context r100) {
        com.alipay.sdk.tid.TidHelper.clearTID(r100);
    }

    public static String getIMEI(Context r100) {
        return com.alipay.sdk.tid.TidHelper.getIMEI(r100);
    }

    public static String getIMSI(Context r100) {
        return com.alipay.sdk.tid.TidHelper.getIMSI(r100);
    }

    public static synchronized String getTIDValue(Context r100) {
        monitor-enter(TidHelper.class);
        String r101 = com.alipay.sdk.tid.TidHelper.getTIDValue(r100);     // Catch: Throwable -> L7
        monitor-exit(TidHelper.class);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static String getVirtualImei(Context r100) {
        return com.alipay.sdk.tid.TidHelper.getVirtualImei(r100);
    }

    public static String getVirtualImsi(Context r100) {
        return com.alipay.sdk.tid.TidHelper.getVirtualImsi(r100);
    }

    public static Tid loadLocalTid(Context r100) {
        return Tid.fromRealTidModel(com.alipay.sdk.tid.TidHelper.loadLocalTid(r100));
    }

    public static synchronized Tid loadOrCreateTID(Context r100) {
        monitor-enter(TidHelper.class);
        Tid r101 = Tid.fromRealTidModel(com.alipay.sdk.tid.TidHelper.loadOrCreateTID(r100));     // Catch: Throwable -> L7
        monitor-exit(TidHelper.class);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static Tid loadTID(Context r100) {
        return Tid.fromRealTidModel(com.alipay.sdk.tid.TidHelper.loadTID(r100));
    }

    public static boolean resetTID(Context r100) throws Exception {
        return com.alipay.sdk.tid.TidHelper.resetTID(r100);
    }
}
