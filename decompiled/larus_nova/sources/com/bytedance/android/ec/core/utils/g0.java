package com.bytedance.android.ec.core.utils;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45598a = 0;

    static {
    }

    public static boolean a(Context r100) {
        if (r100 != null) goto L6;
    L18:
        boolean r101 = false;
    L19:
        if (r101 == false) goto L41;
        if (r100 == null) goto L30;
        List r102 = CollectionsKt.mutableListOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"});
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L23:
        if (r104.hasNext() == false) goto L28;
        String r105 = (String) r104.next();
        if (ContextCompat.checkSelfPermission(r100, r105) != (-1)) goto L23;
        r103.add(r105);
        goto L23
    L28:
        if ((!r103.isEmpty()) == true) goto L30;
        boolean r106 = true;
    L31:
        if (r106 == false) goto L42;
        return true;
    L42:
        return false;
    L30:
        r106 = false;
        goto L31
    L41:
        return false;
    L6:
        if (Build.VERSION.SDK_INT < 28) goto L34;
        Object r107 = r100.getSystemService("location");
        if ((r107 instanceof LocationManager) == true) goto L10;
        r107 = null;
    L10:
        LocationManager r108 = (LocationManager) r107;
        if (r108 == null) goto L18;
        r101 = r108.isLocationEnabled();
        goto L19
    L34:
        if (Settings.Secure.getInt(r100.getContentResolver(), LocationMonitorConst.LOCATION_MODE) == 0) goto L18;
        r101 = true;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    }
}
