package androidx.room.util;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.collections.b0;
import kotlin.collections.j0;
import kotlin.collections.k0;
import kotlin.collections.q0;
import kotlin.collections.s;
import kotlin.io.b;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public static final Map a(SupportSQLiteDatabase r18, String r19) {
        Cursor r10 = r18.query("PRAGMA table_info(`" + r19 + "`)");
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        b.a(r10, th);
        throw th;
    L4:
        if (r10.getColumnCount() > 0) goto L10;
        Map r11 = k0.h();     // Catch: Throwable -> L8
        b.a(r10, null);
        return r11;
    L10:
        int r12 = r10.getColumnIndex("name");     // Catch: Throwable -> L8
        int r13 = r10.getColumnIndex("type");     // Catch: Throwable -> L8
        int r14 = r10.getColumnIndex("notnull");     // Catch: Throwable -> L8
        int r15 = r10.getColumnIndex("pk");     // Catch: Throwable -> L8
        int r16 = r10.getColumnIndex("dflt_value");     // Catch: Throwable -> L8
        Map r17 = j0.c();     // Catch: Throwable -> L8
    L12:
        if (r10.moveToNext() == false) goto L19;
        String r110 = r10.getString(r12);     // Catch: Throwable -> L8
        String r111 = r10.getString(r13);     // Catch: Throwable -> L8
        if (r10.getInt(r14) == 0) goto L17;
        boolean r112 = true;
    L16:
        boolean r113 = r112;
        int r114 = r10.getInt(r15);     // Catch: Throwable -> L8
        String r115 = r10.getString(r16);     // Catch: Throwable -> L8
        q.f(r110, "name");     // Catch: Throwable -> L8
        q.f(r111, "type");     // Catch: Throwable -> L8
        r17.put(r110, new TableInfo.a(r110, r111, r113, r114, r115, 2));     // Catch: Throwable -> L8
        goto L12
    L17:
        r112 = false;
        goto L16
    L19:
        Map r20 = j0.b(r17);     // Catch: Throwable -> L8
        b.a(r10, null);
        return r20;
    }

    public static final List b(Cursor r11) {
        int r10 = r11.getColumnIndex("id");
        int r12 = r11.getColumnIndex("seq");
        int r13 = r11.getColumnIndex("from");
        int r14 = r11.getColumnIndex("to");
        List r15 = s.c();
    L4:
        if (r11.moveToNext() == false) goto L7;
        int r16 = r11.getInt(r10);
        int r17 = r11.getInt(r12);
        String r18 = r11.getString(r13);
        q.f(r18, "cursor.getString(fromColumnIndex)");
        String r19 = r11.getString(r14);
        q.f(r19, "cursor.getString(toColumnIndex)");
        r15.add(new TableInfo.d(r16, r17, r18, r19));
        goto L4
    L7:
        return b0.s0(s.a(r15));
    }

    public static final Set c(SupportSQLiteDatabase r13, String r14) {
        Cursor r15 = r13.query("PRAGMA foreign_key_list(`" + r14 + "`)");
        int r16 = r15.getColumnIndex("id");     // Catch: Throwable -> L15
        int r10 = r15.getColumnIndex("seq");     // Catch: Throwable -> L15
        int r11 = r15.getColumnIndex("table");     // Catch: Throwable -> L15
        int r12 = r15.getColumnIndex("on_delete");     // Catch: Throwable -> L15
        int r17 = r15.getColumnIndex("on_update");     // Catch: Throwable -> L15
        List r18 = b(r15);     // Catch: Throwable -> L15
        r15.moveToPosition(-1);     // Catch: Throwable -> L15
        Set r19 = q0.b();     // Catch: Throwable -> L15
    L5:
        if (r15.moveToNext() == false) goto L22;
        if (r15.getInt(r10) != 0) goto L5;
        int r20 = r15.getInt(r16);     // Catch: Throwable -> L15
        ArrayList r110 = new ArrayList();     // Catch: Throwable -> L15
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L15
        ArrayList r21 = new ArrayList();     // Catch: Throwable -> L15
        Iterator r22 = r18.iterator();     // Catch: Throwable -> L15
    L11:
        if (r22.hasNext() == false) goto L17;
        Object r23 = r22.next();     // Catch: Throwable -> L15
        if (((TableInfo.d) r23).c() != r20) goto L11;
        r21.add(r23);     // Catch: Throwable -> L15
        goto L11
    L17:
        Iterator r24 = r21.iterator();     // Catch: Throwable -> L15
    L19:
        if (r24.hasNext() == false) goto L21;
        TableInfo.d r25 = (TableInfo.d) r24.next();     // Catch: Throwable -> L15
        r110.add(r25.b());     // Catch: Throwable -> L15
        r111.add(r25.d());     // Catch: Throwable -> L15
        goto L19
    L21:
        String r26 = r15.getString(r11);     // Catch: Throwable -> L15
        q.f(r26, "cursor.getString(tableColumnIndex)");     // Catch: Throwable -> L15
        String r27 = r15.getString(r12);     // Catch: Throwable -> L15
        q.f(r27, "cursor.getString(onDeleteColumnIndex)");     // Catch: Throwable -> L15
        String r112 = r15.getString(r17);     // Catch: Throwable -> L15
        q.f(r112, "cursor.getString(onUpdateColumnIndex)");     // Catch: Throwable -> L15
        r19.add(new TableInfo.c(r26, r27, r112, r110, r111));     // Catch: Throwable -> L15
        goto L5
    L22:
        Set r113 = q0.a(r19);     // Catch: Throwable -> L15
        b.a(r15, null);
        return r113;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        b.a(r15, th);
        throw th;
    }

    public static final TableInfo.e d(SupportSQLiteDatabase r12, String r13, boolean r14) {
        Cursor r15 = r12.query("PRAGMA index_xinfo(`" + r13 + "`)");
        int r10 = r15.getColumnIndex("seqno");     // Catch: Throwable -> L18
        int r11 = r15.getColumnIndex("cid");     // Catch: Throwable -> L18
        int r16 = r15.getColumnIndex("name");     // Catch: Throwable -> L18
        int r17 = r15.getColumnIndex("desc");     // Catch: Throwable -> L18
        if (r10 == (-1)) goto L25;
        if (r11 == (-1)) goto L25;
        if (r16 == (-1)) goto L25;
        if (r17 == (-1)) goto L25;
        TreeMap r18 = new TreeMap();     // Catch: Throwable -> L18
        TreeMap r19 = new TreeMap();     // Catch: Throwable -> L18
    L11:
        if (r15.moveToNext() == false) goto L22;
        if (r15.getInt(r11) < 0) goto L11;
        int r20 = r15.getInt(r10);     // Catch: Throwable -> L18
        String r21 = r15.getString(r16);     // Catch: Throwable -> L18
        if (r15.getInt(r17) <= 0) goto L20;
        String r22 = "DESC";
    L21:
        Integer r110 = Integer.valueOf(r20);     // Catch: Throwable -> L18
        q.f(r21, "columnName");     // Catch: Throwable -> L18
        r18.put(r110, r21);     // Catch: Throwable -> L18
        r19.put(Integer.valueOf(r20), r22);     // Catch: Throwable -> L18
        goto L11
    L20:
        r22 = "ASC";
        goto L21
    L22:
        Collection r23 = r18.values();     // Catch: Throwable -> L18
        q.f(r23, "columnsMap.values");     // Catch: Throwable -> L18
        List r24 = b0.x0(r23);     // Catch: Throwable -> L18
        Collection r25 = r19.values();     // Catch: Throwable -> L18
        q.f(r25, "ordersMap.values");     // Catch: Throwable -> L18
        TableInfo.e r26 = new TableInfo.e(r13, r14, r24, b0.x0(r25));     // Catch: Throwable -> L18
        b.a(r15, null);
        return r26;
    L25:
        b.a(r15, null);
        return null;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        b.a(r15, th);
        throw th;
    }

    public static final Set e(SupportSQLiteDatabase r10, String r11) {
        Cursor r12 = r10.query("PRAGMA index_list(`" + r11 + "`)");
        int r13 = r12.getColumnIndex("name");     // Catch: Throwable -> L23
        int r14 = r12.getColumnIndex(HttpHeaders.ReferrerPolicyValues.ORIGIN);     // Catch: Throwable -> L23
        int r15 = r12.getColumnIndex("unique");     // Catch: Throwable -> L23
        if (r13 == (-1)) goto L28;
        if (r14 == (-1)) goto L28;
        if (r15 == (-1)) goto L28;
        Set r16 = q0.b();     // Catch: Throwable -> L23
    L10:
        if (r12.moveToNext() == false) goto L25;
        if (q.b("c", r12.getString(r14)) == false) goto L10;
        String r17 = r12.getString(r13);     // Catch: Throwable -> L23
        boolean r18 = true;
        if (r12.getInt(r15) == 1) goto L18;
        r18 = false;
    L18:
        q.f(r17, "name");     // Catch: Throwable -> L23
        TableInfo.e r19 = d(r10, r17, r18);     // Catch: Throwable -> L23
        if (r19 == null) goto L20;
        r16.add(r19);     // Catch: Throwable -> L23
        goto L10
    L20:
        b.a(r12, null);
        return null;
    L25:
        Set r20 = q0.a(r16);     // Catch: Throwable -> L23
        b.a(r12, null);
        return r20;
    L28:
        b.a(r12, null);
        return null;
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        b.a(r12, th);
        throw th;
    }

    public static final TableInfo f(SupportSQLiteDatabase r10, String r11) {
        q.g(r10, "database");
        q.g(r11, "tableName");
        return new TableInfo(r11, a(r10, r11), c(r10, r11), e(r10, r11));
    }
}
