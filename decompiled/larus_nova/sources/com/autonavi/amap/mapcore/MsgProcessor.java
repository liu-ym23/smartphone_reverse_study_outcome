package com.autonavi.amap.mapcore;

import android.content.Context;
import com.amap.api.mapcore.util.w6;

/* JADX INFO: loaded from: classes39.dex */
public class MsgProcessor {
    private static w6 mDelegate;

    public static native int nativeInit(Context r100);

    static {
        mDelegate = new w6();
    }

    public MsgProcessor() {
    }

    public static void nativeMsgProcessor(String r100, String r101) {
        mDelegate.a(r100, r101);
    }

    public static void nativeInitInfo(Context r100, boolean r101, String r102, String r110, String r111, String[] r112) {
        mDelegate.a(r100, r101, r102, r110, r111, r112);
        nativeInit(r100);
    }
}
