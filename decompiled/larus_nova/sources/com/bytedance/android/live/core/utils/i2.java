package com.bytedance.android.live.core.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes45.dex */
public final class i2 {
    public static Uri e(Uri r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Set<String> r102 = UriProtector.getQueryParameterNames(r100);
        if (r102 != null) goto L9;
        return r100;
    L9:
        if (r102.contains(r101) == true) goto L11;
        return r100;
    L11:
        Uri.Builder r103 = r100.buildUpon().clearQuery();
        Iterator<String> r104 = r102.iterator();
    L13:
        if (r104.hasNext() == false) goto L18;
        String r105 = r104.next();
        if (r105.equals(r101) == true) goto L13;
        r103.appendQueryParameter(r105, UriProtector.getQueryParameter(r100, r105));
        goto L13
    L18:
        return r103.build();
    }

    public static int c(Uri r100, String r101, int r102) {
        return CastIntegerProtector.parseInt(d(r100, r101, null));
    L5:
        return r102;
    }

    public static String d(Uri r100, String r101, String r102) {
        if (r100 != null) goto L8;
        return r102;
    L8:
        r102 = UriProtector.getQueryParameter(r100, r101);     // Catch: Exception -> L6
        return URLDecoder.decode(r102, "UTF-8");
    L7:
        return r102;
    }

    public static String b(Context r100, Uri r101, String r102, String[] r103) {
        String[] r104 = {"_data"};
        Cursor r105 = null;
        Cursor r106 = a(r100.getContentResolver(), r101, r104, r102, r103);     // Catch: Throwable -> L15
        if (r106 != null) goto L20;
    L12:
        if (r106 == null) goto L14;
        r106.close();
    L14:
        return null;
    L20:
    L10:
        Throwable th10 = th;
        r105 = r106;
    L17:
        if (r105 == null) goto L24;
        r105.close();
        throw th10;
    L24:
        throw th10;
    L6:
        if (r106.moveToFirst() == false) goto L12;
        String r107 = r106.getString(r106.getColumnIndexOrThrow("_data"));     // Catch: Throwable -> L10
        r106.close();
        return r107;
    L15:
        th = move-exception;
        th10 = th;
        goto L17
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, null};
        f06.b r115 = new f06.b();
        f06.d r116 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r115, false);
        return (Cursor) r116.f474983b;
    L6:
        Cursor r117 = r110.query(r111, r112, r113, r114, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r117, r115, true);
        return r117;
    }
}
