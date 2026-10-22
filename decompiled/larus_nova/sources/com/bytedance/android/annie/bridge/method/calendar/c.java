package com.bytedance.android.annie.bridge.method.calendar;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f38589a = 0;

    static {
    }

    public static Integer b(long r100, ContentResolver r101) {
        Cursor r102 = a(r101, CalendarContract.Reminders.CONTENT_URI, new String[]{DocumentType.MINUTES_NAME}, "event_id=?", new String[]{String.valueOf(r100)});
        if (r102 == null) goto L17;
        Cursor r103 = r102;
        Cursor r104 = r103;     // Catch: Throwable -> L12
        if (r104.moveToNext() == false) goto L9;
        Integer r105 = Integer.valueOf(r104.getInt(0));     // Catch: Throwable -> L12
    L10:
        CloseableKt.closeFinally(r103, null);
        return r105;
    L9:
        r105 = null;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L17:
        return null;
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
