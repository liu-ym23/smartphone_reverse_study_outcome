package com.bytedance.android.ec.core.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.provider.MediaStore;
import java.util.Iterator;
import java.util.Locale;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class j0 extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f45615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45616b;

    public static final class a {
    }

    static {
    }

    public j0() {
        super(null);
    }

    public static boolean b(String r100) {
        Locale r101 = Locale.ROOT;
        if (r100 == null) goto L13;
        String r102 = r100.toLowerCase(r101);
        i0.f45612f.getClass();
        String[] r103 = i0.f45610d;
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
        Context r101 = this.f45615a;
        if (r101 == null) goto L50;
        String[] r102 = {"date_added", "_data"};
        Cursor r103 = null;
        r103 = a(r101.getContentResolver(), MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r102);     // Catch: Throwable -> L31 SQLException -> L35
        if (r103 == null) goto L51;
        int r104 = r103.getCount();     // Catch: Throwable -> L31 SQLException -> L35
        int r105 = this.f45616b;     // Catch: Throwable -> L31 SQLException -> L35
        if (r105 != 0) goto L11;
        this.f45616b = r104;     // Catch: Throwable -> L31 SQLException -> L35
    L13:
        this.f45616b = r104;     // Catch: Throwable -> L31 SQLException -> L35
        if (r103.moveToFirst() == false) goto L42;
        String r106 = r103.getString(r103.getColumnIndex("_data"));     // Catch: Throwable -> L31 SQLException -> L35
        long r107 = r103.getLong(r103.getColumnIndex("date_added"));     // Catch: Throwable -> L31 SQLException -> L35
        long r108 = System.currentTimeMillis() - (r107 * ((long) 1000));     // Catch: Throwable -> L31 SQLException -> L35
        if (r108 < 7000) goto L18;
    L20:
        boolean r109 = false;
    L21:
        if (r109 == false) goto L42;
        if (b(r106) == false) goto L42;
        Iterator<T> r110 = i0.f45608b.values().iterator();     // Catch: Throwable -> L31 SQLException -> L35
    L25:
        if (r110.hasNext() == false) goto L42;
        b1 r111 = (b1) r110.next();     // Catch: Throwable -> L31 SQLException -> L35
        if (r111 == null) goto L25;
        r111.a(r106);     // Catch: Throwable -> L31 SQLException -> L35
        goto L25
    L18:
        if (r108 <= 0) goto L20;
        r109 = true;
    L42:
        r103.close();     // Catch: SQLException -> L39
        return;
    L53:
        return;
    L11:
        if (r105 < r104) goto L13;
    L51:
        return;
    L35:
        if (r103 != null) goto L42;
        return;
    L31:
        th = move-exception;
        if (r103 != null) goto L40;
    L34:
        throw th;
    L40:
        r103.close();     // Catch: SQLException -> L38
        goto L34
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r113 = new f06.c();
        Object[] r114 = {r111, r112, null, null, "date_modified desc "};
        f06.b r115 = new f06.b();
        f06.d r100 = r113.b(240004, "android/content/ContentResolver", "query", r110, r114, "android.database.Cursor", r115);
        if (r100.f474982a == false) goto L6;
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, null, r115, false);
        return (Cursor) r100.f474983b;
    L6:
        Cursor r101 = r110.query(r111, r112, null, null, "date_modified desc ");
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, r101, r115, true);
        return r101;
    }
}
