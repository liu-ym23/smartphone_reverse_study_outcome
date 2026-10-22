package com.bytedance.apm.battery.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.model.database.columns.CommonColumns;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlinx.coroutines.channels.Channel;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f6355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f6356d;

    public interface CursorGetter<T> {
        T get(b r10);
    }

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Cursor f6357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap f6358b;

        public /* synthetic */ b(Cursor r10, HashMap r11, a r12) {
            this(r10, r11);
        }

        public final int a(String r10) {
            Integer r11 = (Integer) this.f6358b.get(r10);
            if (r11 != null) goto L9;
            r11 = Integer.valueOf(this.f6357a.getColumnIndex(r10));     // Catch: Throwable -> L6
        L7:
            this.f6358b.put(r10, r11);
        L6:
            r11 = -1;
        L9:
            return r11.intValue();
        }

        public int b(String r10) {
            return this.f6357a.getInt(a(r10));
        L4:
            return -1;
        }

        public long c(String r10) {
            return this.f6357a.getLong(a(r10));
        L4:
            return -1;
        }

        public String d(String r10) {
            return this.f6357a.getString(a(r10));
        L4:
            return "";
        }

        public b(Cursor r10, HashMap r11) {
            this.f6357a = r10;
            this.f6358b = r11;
        }
    }

    public BaseDao() {
        this.f6356d = new HashMap();
        Context r10 = c.g();
        this.f6353a = r10;
        this.f6354b = r10.getPackageName() + ".apm";
    }

    public static void g(Cursor r10) {
        if (r10 == null) goto L10;
        if (r10.isClosed() == true) goto L11;
        r10.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public abstract String[] a();

    public String b() {
        return "apm_monitor_t1.db";
    }

    public abstract String c();

    public Uri d() {
        if (this.f6355c != null) goto L6;
        this.f6355c = Uri.parse(CommonColumns.SCHEME + this.f6354b + LibrarianImpl.Constants.SEPARATOR + b() + LibrarianImpl.Constants.SEPARATOR + c());
    L6:
        return this.f6355c;
    }

    public synchronized long e(ContentValues r10) {
        monitor-enter(this);
        if (r10 != null) goto L23;
        monitor-exit(this);
        return -1;
    L23:
        Uri r11 = c.g().getContentResolver().insert(d(), r10);     // Catch: Throwable -> L14 Exception -> L21
        if (r11 != null) goto L26;
        monitor-exit(this);
        return -1;
    L26:
        long r12 = Long.parseLong(r11.getLastPathSegment());     // Catch: Throwable -> L14 Exception -> L16
        monitor-exit(this);
        return r12;
    L17:
        return 1;
    L14:
        th = move-exception;
        throw th;
    L22:
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List f(String r10, String[] r11, String r12, CursorGetter r13) {
        Cursor r14 = null;
        Object[] r15 = 0;
        Cursor r16 = this.f6353a.getContentResolver().query(d(), a(), r10, r11, r12);     // Catch: Throwable -> L31
        if (r16 != null) goto L32;
    L26:
        List r17 = Collections.emptyList();     // Catch: Throwable -> L15
        g(r16);
        return r17;
    L32:
    L15:
        r14 = r16;
        goto L29
    L6:
        if (r16.getCount() <= 0) goto L26;
        if (TextUtils.isEmpty(r12) == true) goto L17;
        int r18 = r12.indexOf("LIMIT");     // Catch: Throwable -> L15
        if (r18 <= 0) goto L17;
        int r19 = r12.indexOf("OFF");     // Catch: Throwable -> L15
        if (r19 <= 0) goto L16;
        int r110 = Integer.valueOf(r12.substring(r18 + 5, r19).trim()).intValue();     // Catch: Throwable -> L15
    L18:
        LinkedList r111 = new LinkedList();     // Catch: Throwable -> L15
        int r20 = 0;
    L20:
        if (r16.moveToNext() == false) goto L24;
        if (r20 >= r110) goto L24;
        r111.add(r13.get(new b(r16, this.f6356d, r15 == true ? 1 : 0)));     // Catch: Throwable -> L15
        r20 = r20 + 1;
    L24:
        g(r16);
        return r111;
    L16:
        r110 = Integer.valueOf(r12.substring(r18 + 5).trim()).intValue();     // Catch: Throwable -> L15
    L17:
        r110 = Channel.UNLIMITED;
    L29:
        g(r14);
        return Collections.emptyList();
    }

    public int h(ContentValues r10, String r11, String[] r12) {
        if (r10 != null) goto L8;
        return -1;
    L8:
        return c.g().getContentResolver().update(d(), r10, r11, r12);
    L7:
        return -1;
    }
}
