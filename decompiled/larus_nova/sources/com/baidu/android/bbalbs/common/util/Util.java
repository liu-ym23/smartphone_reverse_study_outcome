package com.baidu.android.bbalbs.common.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.bbalbscesium.m.c;
import java.util.Iterator;

/* JADX INFO: loaded from: classes39.dex */
public final class Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f30053a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f30054b = "Util";

    private Util() {
    }

    public static boolean hasOtherServiceRuninMyPid(Context r100, String r101) {
        Iterator<ActivityManager.RunningServiceInfo> r102 = ((ActivityManager) r100.getApplicationContext().getSystemService("activity")).getRunningServices(100).iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        ActivityManager.RunningServiceInfo r103 = r102.next();
        if (r103.pid != Process.myPid()) goto L4;
        if (TextUtils.equals(r103.service.getClassName(), r101) == true) goto L4;
        return true;
    L11:
        return false;
    }

    public static String toHexString(byte[] r100, String r101, boolean r102) {
        return c.a(r100, r101, r102);
    }

    public static String toMd5(byte[] r100, boolean r101) {
        return c.a(r100, r101);
    }
}
