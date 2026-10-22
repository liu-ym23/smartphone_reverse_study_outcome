package com.baidu.mapapi;

import android.content.Context;
import com.baidu.mapsdkplatform.comapi.BMapManagerInternal;

/* JADX INFO: loaded from: classes39.dex */
public class BMapManager {
    public static void destroy() {
        BMapManagerInternal.getInstance().c();
    }

    public static Context getContext() {
        return BMapManagerInternal.getInstance().d();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void init() {
        BMapManagerInternal.getInstance().e();     // Catch: IllegalStateException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public BMapManager() {
    }
}
