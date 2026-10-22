package com.android.ttcjpaysdk.base.h5.utils;

import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayRealNamePasswordCallback;

/* JADX INFO: loaded from: classes28.dex */
public class CallbackUtils {
    private static TTCJPayRealNamePasswordCallback realNamePasswordCallback;

    public CallbackUtils() {
    }

    public static void releaseAll() {
        realNamePasswordCallback = null;
    }

    public static TTCJPayRealNamePasswordCallback getRealNamePasswordCallback() {
        return realNamePasswordCallback;
    }

    public static void setRealNamePasswordCallback(TTCJPayRealNamePasswordCallback r100) {
        realNamePasswordCallback = r100;
    }
}
