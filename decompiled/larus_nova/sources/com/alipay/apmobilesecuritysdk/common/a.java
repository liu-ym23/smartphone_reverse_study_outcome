package com.alipay.apmobilesecuritysdk.common;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.h;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class a {
    public static boolean a(Context r100) {
        ArrayList r101 = new ArrayList();
        r101.add(h.e(r100));
        if (a(r101) == false) goto L6;
        return true;
    L6:
        if (a(new RushTimeUtil$1()) == false) goto L8;
        return true;
    L8:
        return false;
    }

    public static boolean a(List<String> r100) {
        SimpleDateFormat r101 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        r101.setLenient(false);
        int r102 = ((int) (((Math.random() * 24.0d) * 60.0d) * 60.0d)) * 1;
        Iterator<String> r103 = r100.iterator();     // Catch: Exception -> L16
    L5:
        if (r103.hasNext() == false) goto L15;
        String[] r104 = r103.next().split("&");     // Catch: Exception -> L16
        if (r104 == null) goto L5;
        if (r104.length != 2) goto L5;
        Date r105 = new Date();     // Catch: Exception -> L16
        Date r106 = r101.parse(r104[0] + " 00:00:00");     // Catch: Exception -> L16
        Date r107 = r101.parse(r104[1] + " 23:59:59");     // Catch: Exception -> L16
        Calendar r108 = Calendar.getInstance();     // Catch: Exception -> L16
        r108.setTime(r107);     // Catch: Exception -> L16
        r108.add(13, r102);     // Catch: Exception -> L16
        Date r109 = r108.getTime();     // Catch: Exception -> L16
        if (r105.after(r106) == false) goto L5;
        if (r105.before(r109) == false) goto L5;
        return true;
    L15:
        return false;
    }
}
