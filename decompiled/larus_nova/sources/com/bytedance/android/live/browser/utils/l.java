package com.bytedance.android.live.browser.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.provider.MediaStore;
import com.bytedance.android.live.core.log.ALogger;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Locale;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class l extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f64315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f64316b;

    public l() {
        super(null);
    }

    public static boolean b(String r100) {
        Locale r101 = Locale.ROOT;
        if (r100 == null) goto L13;
        String r102 = r100.toLowerCase(r101);
        String[] r103 = k.f64313c;
        int r104 = r103.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L11;
        if (StringsKt.contains$default(r102, r103[r105], false, 2, null) == true) goto L8;
        r105 = r105 + 1;
        goto L5
    L8:
        return true;
    L11:
        return false;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100) {
        super.onChange(r100);
        WeakReference<Context> r101 = this.f64315a;
        if (r101 == null) goto L36;
        Context r102 = r101.get();
        if (r102 == null) goto L50;
        Cursor r103 = null;
        r103 = a(r102.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"date_added", "_data"});     // Catch: Throwable -> L26 SQLException -> L28
        if (r103 == null) goto L51;
        int r104 = r103.getCount();     // Catch: Throwable -> L26 SQLException -> L28
        int r105 = this.f64316b;     // Catch: Throwable -> L26 SQLException -> L28
        if (r105 != 0) goto L13;
        this.f64316b = r104;     // Catch: Throwable -> L26 SQLException -> L28
    L15:
        this.f64316b = r104;     // Catch: Throwable -> L26 SQLException -> L28
        if (r103.moveToFirst() == false) goto L41;
        String r106 = r103.getString(r103.getColumnIndex("_data"));     // Catch: Throwable -> L26 SQLException -> L28
        r103.getLong(r103.getColumnIndex("date_added"));     // Catch: Throwable -> L26 SQLException -> L28
        if (b(r106) == false) goto L41;
        Iterator<T> r107 = k.f64312b.values().iterator();     // Catch: Throwable -> L26 SQLException -> L28
    L20:
        if (r107.hasNext() == false) goto L41;
        i r108 = (i) r107.next();     // Catch: Throwable -> L26 SQLException -> L28
        if (r108 == null) goto L20;
        r108.a(r106);     // Catch: Throwable -> L26 SQLException -> L28
        goto L20
    L41:
        r103.close();     // Catch: SQLException -> L38
        return;
    L54:
        return;
    L13:
        if (r105 < r104) goto L15;
    L51:
        return;
    L28:
        e = move-exception;
        ALogger.e("ScreenShotHelper", "handleContentObserverChange Error" + e.getMessage());     // Catch: Throwable -> L26
        if (r103 != null) goto L41;
        return;
    L26:
        th = move-exception;
        if (r103 != null) goto L39;
    L35:
        throw th;
    L39:
        r103.close();     // Catch: SQLException -> L37
        goto L35
    L50:
        return;
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r113 = new f06.c();
        Object[] r114 = {r111, r112, null, null, "date_modified desc"};
        f06.b r115 = new f06.b();
        f06.d r100 = r113.b(240004, "android/content/ContentResolver", "query", r110, r114, "android.database.Cursor", r115);
        if (r100.f474982a == false) goto L6;
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, null, r115, false);
        return (Cursor) r100.f474983b;
    L6:
        Cursor r101 = r110.query(r111, r112, null, null, "date_modified desc");
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, r101, r115, true);
        return r101;
    }
}
