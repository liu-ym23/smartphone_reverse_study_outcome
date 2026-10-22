package com.alipay.sdk.m.b0;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public final class e {
    public static String a(Context r100, String r101, String r102, String r103) {
        return r100.getSharedPreferences(r101, 0).getString(r102, r103);
    }

    public static void a(Context r100, String r101, Map<String, String> r102) {
        SharedPreferences.Editor r103 = r100.getSharedPreferences(r101, 0).edit();
        if (r103 == null) goto L11;
        Iterator<String> r104 = r102.keySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        String r105 = r104.next();
        r103.putString(r105, r102.get(r105));
        goto L6
    L8:
        r103.commit();
        return;
    }
}
