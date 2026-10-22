package com.bytedance.bdtracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.applog.log.LogUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k4 {
    public final i4 a;
    public final e0 b;
    public final j4 c;

    public k4(e0 e0Var, String str) {
        i4 i4Var = new i4(e0Var, str, null, 51);
        this.a = i4Var;
        this.b = e0Var;
        this.c = new j4(e0Var, i4Var);
    }

    public final List<Long> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("local_time_ms")) {
                    try {
                        arrayList.add(Long.valueOf(jSONObjectOptJSONObject.getLong("local_time_ms")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized void a() {
        SQLiteDatabase writableDatabase;
        Throwable th;
        try {
            writableDatabase = this.a.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                for (e4 e4Var : e4.j().values()) {
                    if (r.d(e4Var.a())) {
                        writableDatabase.delete(e4Var.f(), null, null);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                r.a(writableDatabase);
            } catch (Throwable th2) {
                th = th2;
                try {
                    this.b.d.D.error(5, "Clear database failed", th, new Object[0]);
                    o2.a(this.b.q, th);
                } finally {
                    if (writableDatabase != null) {
                        r.a(writableDatabase);
                    }
                }
            }
        } catch (Throwable th3) {
            writableDatabase = null;
            th = th3;
        }
    }

    public void a(JSONObject jSONObject) {
        d(a(jSONObject.optJSONArray("launch")));
        d(a(jSONObject.optJSONArray("terminate")));
        d(a(jSONObject.optJSONArray("event_v3")));
    }

    public synchronized void b(List<n4> list) {
        if (list == null) {
            return;
        }
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = this.a.getWritableDatabase();
            writableDatabase.beginTransaction();
            for (n4 n4Var : list) {
                if (n4Var.A != 0 && (n4Var.A <= 0 || Math.abs(System.currentTimeMillis() - n4Var.c) <= 2592000000L)) {
                    int i = n4Var.A;
                    if (i > 0) {
                        writableDatabase.execSQL("UPDATE packV2 SET _fail= ? WHERE _id= ?", new Object[]{Integer.valueOf(i), Long.valueOf(n4Var.b)});
                    }
                }
                writableDatabase.execSQL("DELETE FROM packV2 WHERE _id=?", new Object[]{Long.valueOf(n4Var.b)});
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final List<o4> c(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = str2 == null ? sQLiteDatabase.rawQuery("SELECT * FROM page WHERE _app_id= ? and user_unique_id is null order by duration desc", new String[]{str}) : sQLiteDatabase.rawQuery("SELECT * FROM page WHERE _app_id= ? and user_unique_id = ? order by duration desc", new String[]{str, str2});
            while (cursorRawQuery.moveToNext()) {
                o4 o4Var = new o4();
                o4Var.a(cursorRawQuery);
                arrayList.add(o4Var);
            }
            r.a(cursorRawQuery);
            z = false;
        } catch (Throwable th) {
            try {
                boolean z2 = th instanceof SQLiteBlobTooBigException;
                this.b.d.D.error(5, "Query pages by userId:{} failed", th, str2);
                o2.a(this.b.q, th);
                r.a(cursorRawQuery);
                z = z2;
            } catch (Throwable th2) {
                r.a(cursorRawQuery);
                throw th2;
            }
        }
        if (z) {
            b();
        }
        return arrayList;
    }

    public final void d(List<Long> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (Long l : list) {
            l2 l2Var = this.b.q;
            long jLongValue = jCurrentTimeMillis - l.longValue();
            if (l2Var != null) {
                ((q2) l2Var).a(new a3(jLongValue));
            }
        }
    }

    public final List<r4> a(List<o4> list, List<o4> list2, boolean z) {
        Iterator it;
        String strD = this.b.d();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (o4 o4Var : list) {
            if (!r.a(o4Var.e, strD)) {
                String strA = r.a((Object) o4Var.e);
                List arrayList2 = (List) map.get(strA);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    map.put(strA, arrayList2);
                }
                arrayList2.add(o4Var);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            HashMap map2 = new HashMap();
            o4 o4Var2 = (o4) ((List) entry.getValue()).get(0);
            Iterator it2 = ((List) entry.getValue()).iterator();
            long j = 0;
            long j2 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                o4 o4Var3 = (o4) it2.next();
                Integer num = (Integer) map2.get(o4Var3.u);
                if (o4Var3.k()) {
                    if (num != null) {
                        int iIntValue = num.intValue() - 1;
                        Integer numValueOf = Integer.valueOf(iIntValue);
                        numValueOf.getClass();
                        if (iIntValue > 0) {
                            map2.put(o4Var3.u, numValueOf);
                        } else {
                            map2.remove(o4Var3.u);
                        }
                    } else {
                        o4Var3.s = 1000L;
                        if (!o4Var3.D) {
                            j += o4Var3.s;
                        }
                        list2.add(o4Var3);
                    }
                    it = it2;
                } else {
                    it = it2;
                    o4Var3.s = Math.max(1000L, o4Var3.s);
                    if (!o4Var3.D) {
                        j += o4Var3.s;
                    }
                    map2.put(o4Var3.u, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
                    list2.add(o4Var3);
                }
                long j3 = !o4Var3.k() ? o4Var3.c : o4Var3.c + o4Var3.s;
                if (!o4Var3.D && j3 > j2) {
                    j2 = j3;
                    o4Var2 = o4Var3;
                }
                it2 = it;
            }
            u1 u1Var = this.b.e;
            if ((u1Var != null && u1Var.s.b.contains("app_terminate")) || !z) {
                this.b.d.D.debug(5, "Terminate event block", new Object[0]);
            } else {
                r4 r4Var = new r4();
                r4Var.e = (String) entry.getKey();
                r4Var.s = j;
                r4Var.c = j2;
                r4Var.f = o4Var2.f;
                r4Var.g = o4Var2.g;
                r4Var.h = o4Var2.h;
                r4Var.i = o4Var2.i;
                r4Var.j = o4Var2.j;
                r4Var.t = j2;
                j0 j0Var = this.b.n;
                r4Var.d = j0Var != null ? j0Var.f.incrementAndGet() : 1000L;
                r4Var.u = null;
                if (!TextUtils.isEmpty(o4Var2.B)) {
                    r4Var.u = o4Var2.B;
                }
                JSONObject jSONObject = o4Var2.o;
                if (jSONObject != null && jSONObject.has("$screen_orientation")) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("$screen_orientation", o4Var2.o.optString("$screen_orientation"));
                        r4Var.o = jSONObject2;
                    } catch (Throwable th) {
                        this.b.d.D.warn(5, "JSON handle failed", th);
                    }
                }
                arrayList.add(r4Var);
            }
        }
        return arrayList;
    }

    public synchronized void b(String str, JSONObject jSONObject) {
        SQLiteDatabase writableDatabase;
        List<s4> listA;
        this.b.d.D.debug(5, "Pack trace events for appId:{} start...", str);
        try {
            writableDatabase = this.a.getWritableDatabase();
            listA = a(writableDatabase, str);
        } catch (Throwable th) {
            this.b.d.D.error(5, "Pack trace events for appId:{} failed", th, str);
            o2.a(this.b.q, th);
        }
        if (listA.isEmpty()) {
            return;
        }
        n4 n4Var = new n4();
        JSONObject jSONObject2 = new JSONObject();
        r.a(jSONObject2, jSONObject);
        jSONObject2.remove("user_unique_id");
        jSONObject2.remove("user_unique_id_type");
        n4Var.y = jSONObject2;
        n4Var.m = str;
        n4Var.x = listA;
        a(writableDatabase, n4Var);
    }

    public synchronized void c(List<p4> list) {
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            try {
                writableDatabase.beginTransaction();
                Iterator<p4> it = list.iterator();
                ContentValues contentValuesA = null;
                while (it.hasNext()) {
                    contentValuesA = it.next().a(contentValuesA);
                    writableDatabase.insert("profile", null, contentValuesA);
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                th = th;
                sQLiteDatabase = writableDatabase;
                try {
                    this.b.d.D.error(5, "Save profiles failed", th, new Object[0]);
                    o2.a(this.b.q, th);
                    writableDatabase = sQLiteDatabase;
                } finally {
                    r.a(sQLiteDatabase);
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.bytedance.bdtracker.l4> b(android.database.sqlite.SQLiteDatabase r6, java.lang.String r7, java.lang.String r8, int r9) {
        /*
            r5 = this;
            if (r9 > 0) goto L8
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            return r5
        L8:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r8 != 0) goto L20
            java.lang.String r1 = "SELECT * FROM eventv3 WHERE _app_id= ? and user_unique_id is null limit 0, ?"
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L1e
            java.lang.String[] r9 = new java.lang.String[]{r7, r9}     // Catch: java.lang.Throwable -> L1e
            android.database.Cursor r6 = r6.rawQuery(r1, r9)     // Catch: java.lang.Throwable -> L1e
            goto L2e
        L1e:
            r6 = move-exception
            goto L47
        L20:
            java.lang.String r1 = "SELECT * FROM eventv3 WHERE _app_id= ? and user_unique_id = ? limit 0, ?"
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L1e
            java.lang.String[] r9 = new java.lang.String[]{r7, r8, r9}     // Catch: java.lang.Throwable -> L1e
            android.database.Cursor r6 = r6.rawQuery(r1, r9)     // Catch: java.lang.Throwable -> L1e
        L2e:
            boolean r9 = r6.moveToNext()     // Catch: java.lang.Throwable -> L45
            if (r9 == 0) goto L40
            com.bytedance.bdtracker.l4 r9 = new com.bytedance.bdtracker.l4     // Catch: java.lang.Throwable -> L45
            r9.<init>()     // Catch: java.lang.Throwable -> L45
            r9.a(r6)     // Catch: java.lang.Throwable -> L45
            r0.add(r9)     // Catch: java.lang.Throwable -> L45
            goto L2e
        L40:
            com.bytedance.bdtracker.r.a(r6)
            r6 = 0
            goto L68
        L45:
            r9 = move-exception
            goto L4b
        L47:
            r9 = 0
            r4 = r9
            r9 = r6
            r6 = r4
        L4b:
            boolean r1 = r9 instanceof android.database.sqlite.SQLiteBlobTooBigException     // Catch: java.lang.Throwable -> L6e
            com.bytedance.bdtracker.e0 r2 = r5.b     // Catch: java.lang.Throwable -> L6e
            com.bytedance.bdtracker.d r2 = r2.d     // Catch: java.lang.Throwable -> L6e
            com.bytedance.applog.log.IAppLogLogger r2 = r2.D     // Catch: java.lang.Throwable -> L6e
            java.lang.String r3 = "Query v3 event by uuid:{} for appId:{} failed"
            java.lang.Object[] r7 = new java.lang.Object[]{r8, r7}     // Catch: java.lang.Throwable -> L6e
            r8 = 5
            r2.error(r8, r3, r9, r7)     // Catch: java.lang.Throwable -> L6e
            com.bytedance.bdtracker.e0 r7 = r5.b     // Catch: java.lang.Throwable -> L6e
            com.bytedance.bdtracker.l2 r7 = r7.q     // Catch: java.lang.Throwable -> L6e
            com.bytedance.bdtracker.o2.a(r7, r9)     // Catch: java.lang.Throwable -> L6e
            com.bytedance.bdtracker.r.a(r6)
            r6 = r1
        L68:
            if (r6 == 0) goto L6d
            r5.b()
        L6d:
            return r0
        L6e:
            r5 = move-exception
            com.bytedance.bdtracker.r.a(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.k4.b(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, int):java.util.List");
    }

    public final List<m4> b(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = str2 == null ? sQLiteDatabase.rawQuery("SELECT * FROM launch WHERE _app_id= ? and user_unique_id is null", new String[]{str}) : sQLiteDatabase.rawQuery("SELECT * FROM launch WHERE _app_id= ? and user_unique_id = ?", new String[]{str, str2});
            while (true) {
                z = false;
                if (!cursorRawQuery.moveToNext()) {
                    break;
                }
                m4 m4Var = new m4();
                m4Var.a(cursorRawQuery);
                arrayList.add(m4Var);
                if (r.d(m4Var.e) && a(sQLiteDatabase, "page", "session_id = ? LIMIT 1", new String[]{m4Var.e}) > 0) {
                    z = true;
                }
                m4Var.u = !z;
            }
        } catch (Throwable th) {
            try {
                z = th instanceof SQLiteBlobTooBigException;
                this.b.d.D.error(5, "Query launch by uuid:{} for appId:{} failed", th, str2, str);
                o2.a(this.b.q, th);
            } finally {
                r.a(cursorRawQuery);
            }
        }
        if (z) {
            b();
        }
        return arrayList;
    }

    public final int a(SQLiteDatabase sQLiteDatabase, String str, String str2, String[] strArr) {
        if (sQLiteDatabase == null) {
            return 0;
        }
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery("SELECT count(1) FROM " + str + " WHERE " + str2, strArr);
        } catch (Throwable th) {
            try {
                this.b.d.D.error(5, "Count table:{} failed", th, str);
                o2.a(this.b.q, th);
            } finally {
                r.a(cursorRawQuery);
            }
        }
        if (cursorRawQuery.moveToNext()) {
            return cursorRawQuery.getInt(0);
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int b(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
            com.bytedance.bdtracker.i4 r2 = r7.a     // Catch: java.lang.Throwable -> L28
            android.database.sqlite.SQLiteDatabase r2 = r2.getReadableDatabase()     // Catch: java.lang.Throwable -> L28
            java.lang.String[] r8 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> L28
            java.lang.String r3 = "SELECT * FROM packV2 WHERE _app_id= ? ORDER BY _id DESC LIMIT 8"
            android.database.Cursor r1 = r2.rawQuery(r3, r8)     // Catch: java.lang.Throwable -> L28
            if (r1 != 0) goto L18
            com.bytedance.bdtracker.r.a(r1)
            return r0
        L18:
            r8 = r0
        L19:
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L26
            if (r2 == 0) goto L22
            int r8 = r8 + 1
            goto L19
        L22:
            com.bytedance.bdtracker.r.a(r1)
            goto L45
        L26:
            r2 = move-exception
            goto L2a
        L28:
            r2 = move-exception
            r8 = r0
        L2a:
            boolean r3 = r2 instanceof android.database.sqlite.SQLiteBlobTooBigException     // Catch: java.lang.Throwable -> L4b
            com.bytedance.bdtracker.e0 r4 = r7.b     // Catch: java.lang.Throwable -> L4b
            com.bytedance.bdtracker.d r4 = r4.d     // Catch: java.lang.Throwable -> L4b
            com.bytedance.applog.log.IAppLogLogger r4 = r4.D     // Catch: java.lang.Throwable -> L4b
            java.lang.String r5 = "Query event packs count failed"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L4b
            r6 = 5
            r4.error(r6, r5, r2, r0)     // Catch: java.lang.Throwable -> L4b
            com.bytedance.bdtracker.e0 r0 = r7.b     // Catch: java.lang.Throwable -> L4b
            com.bytedance.bdtracker.l2 r0 = r0.q     // Catch: java.lang.Throwable -> L4b
            com.bytedance.bdtracker.o2.a(r0, r2)     // Catch: java.lang.Throwable -> L4b
            com.bytedance.bdtracker.r.a(r1)
            r0 = r3
        L45:
            if (r0 == 0) goto L4a
            r7.b()
        L4a:
            return r8
        L4b:
            r7 = move-exception
            com.bytedance.bdtracker.r.a(r1)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.k4.b(java.lang.String):int");
    }

    public synchronized void a(List<p4> list) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = this.a.getWritableDatabase();
            writableDatabase.beginTransaction();
            Iterator<p4> it = list.iterator();
            while (it.hasNext()) {
                writableDatabase.delete("profile", "_id=?", new String[]{String.valueOf(it.next().b)});
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final Set<String> a(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        boolean z;
        HashSet hashSet = new HashSet();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery("SELECT `user_unique_id` FROM " + str + " WHERE _app_id= ?", new String[]{str2});
            while (true) {
                z = false;
                if (!cursorRawQuery.moveToNext()) {
                    break;
                }
                hashSet.add(cursorRawQuery.getString(0));
            }
        } catch (Throwable th) {
            try {
                z = th instanceof SQLiteBlobTooBigException;
                this.b.d.D.error(5, "Query uuid set from table:{} for appId:{} failed", th, str, str2);
                o2.a(this.b.q, th);
            } finally {
                r.a(cursorRawQuery);
            }
        }
        if (z) {
            b();
        }
        return hashSet;
    }

    public final void b() {
        try {
            Field declaredField = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            declaredField.setAccessible(true);
            int i = declaredField.getInt(null);
            if (i > 0 && i <= 8388608) {
                int i2 = i * 2;
                declaredField.setInt(null, i2);
                this.b.d.D.debug("tryIncreaseCursorWindowSize set new curCursorWindowSize = " + i2, new Object[0]);
                return;
            }
            this.b.d.D.debug("tryIncreaseCursorWindowSize curCursorWindowSize invalid = " + i, new Object[0]);
        } catch (Throwable th) {
            this.b.d.D.error(5, "tryIncreaseCursorWindowSize", th, new Object[0]);
        }
    }

    public synchronized boolean a(String str, JSONObject jSONObject) {
        SQLiteDatabase readableDatabase;
        List<r4> list;
        List<h4> list2;
        this.b.d.D.debug(5, "Pack events for appId:{} start...", str);
        try {
            readableDatabase = this.a.getReadableDatabase();
        } catch (Throwable th) {
            this.b.d.D.error(5, "Open db failed", th, new Object[0]);
            o2.a(this.b.q, th);
            readableDatabase = null;
        }
        HashSet<String> hashSet = new HashSet();
        if (readableDatabase != null) {
            hashSet.addAll(a(readableDatabase, "launch", str));
            hashSet.addAll(a(readableDatabase, "page", str));
            hashSet.addAll(a(readableDatabase, "eventv3", str));
            hashSet.addAll(a(readableDatabase, "custom_event", str));
        }
        if (hashSet.isEmpty()) {
            return false;
        }
        HashSet hashSet2 = new HashSet();
        try {
            SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
            for (String str2 : hashSet) {
                n4 n4Var = new n4();
                n4Var.m = str;
                JSONObject jSONObject2 = new JSONObject();
                r.a(jSONObject2, jSONObject);
                jSONObject2.remove("ssid");
                jSONObject2.put("user_unique_id", r.c(str2) ? JSONObject.NULL : str2);
                n4Var.y = jSONObject2;
                n4Var.v = b(writableDatabase, str, str2);
                List<o4> listC = c(writableDatabase, str, str2);
                ArrayList arrayList = new ArrayList();
                List<r4> listA = a(listC, arrayList, this.b.e.c.isLaunchTerminateEnabled());
                n4Var.u = arrayList;
                n4Var.w = listA;
                n4Var.t = a(writableDatabase, str, str2, n4Var.k());
                int iK = n4Var.k();
                List<h4> list3 = n4Var.t;
                if (list3 != null) {
                    iK -= list3.size();
                }
                n4Var.s = b(writableDatabase, str, str2, iK);
                List<m4> list4 = n4Var.v;
                if ((list4 != null && !list4.isEmpty()) || (((list = n4Var.w) != null && !list.isEmpty()) || n4Var.a((Set<String>) null).length() != 0 || ((list2 = n4Var.t) != null && !list2.isEmpty()))) {
                    n4Var.m();
                    n4Var.n();
                    if (!this.b.a(jSONObject2)) {
                        this.b.d.D.warn(5, "Register to get ssid by temp header failed.", new Object[0]);
                    } else {
                        this.b.d.D.debug(5, n4Var.toString(), new Object[0]);
                        hashSet2.add(str2);
                        a(writableDatabase, n4Var);
                    }
                }
            }
        } catch (Throwable th2) {
            this.b.d.D.warn(5, "Pack events for appId:{} failed", th2, str);
            o2.a(this.b.q, th2);
        }
        return !hashSet2.isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.bytedance.bdtracker.h4> a(android.database.sqlite.SQLiteDatabase r6, java.lang.String r7, java.lang.String r8, int r9) {
        /*
            r5 = this;
            if (r9 > 0) goto L8
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            return r5
        L8:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r8 != 0) goto L20
            java.lang.String r1 = "SELECT * FROM custom_event WHERE _app_id= ? and user_unique_id is null limit 0, ?"
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L1e
            java.lang.String[] r9 = new java.lang.String[]{r7, r9}     // Catch: java.lang.Throwable -> L1e
            android.database.Cursor r6 = r6.rawQuery(r1, r9)     // Catch: java.lang.Throwable -> L1e
            goto L2e
        L1e:
            r6 = move-exception
            goto L47
        L20:
            java.lang.String r1 = "SELECT * FROM custom_event WHERE _app_id= ? and user_unique_id = ? limit 0, ?"
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L1e
            java.lang.String[] r9 = new java.lang.String[]{r7, r8, r9}     // Catch: java.lang.Throwable -> L1e
            android.database.Cursor r6 = r6.rawQuery(r1, r9)     // Catch: java.lang.Throwable -> L1e
        L2e:
            boolean r9 = r6.moveToNext()     // Catch: java.lang.Throwable -> L45
            if (r9 == 0) goto L40
            com.bytedance.bdtracker.h4 r9 = new com.bytedance.bdtracker.h4     // Catch: java.lang.Throwable -> L45
            r9.<init>()     // Catch: java.lang.Throwable -> L45
            r9.a(r6)     // Catch: java.lang.Throwable -> L45
            r0.add(r9)     // Catch: java.lang.Throwable -> L45
            goto L2e
        L40:
            com.bytedance.bdtracker.r.a(r6)
            r6 = 0
            goto L68
        L45:
            r9 = move-exception
            goto L4b
        L47:
            r9 = 0
            r4 = r9
            r9 = r6
            r6 = r4
        L4b:
            boolean r1 = r9 instanceof android.database.sqlite.SQLiteBlobTooBigException     // Catch: java.lang.Throwable -> L6e
            com.bytedance.bdtracker.e0 r2 = r5.b     // Catch: java.lang.Throwable -> L6e
            com.bytedance.bdtracker.d r2 = r2.d     // Catch: java.lang.Throwable -> L6e
            com.bytedance.applog.log.IAppLogLogger r2 = r2.D     // Catch: java.lang.Throwable -> L6e
            java.lang.String r3 = "Query custom event by uuid:{} for appId:{} failed"
            java.lang.Object[] r7 = new java.lang.Object[]{r8, r7}     // Catch: java.lang.Throwable -> L6e
            r8 = 5
            r2.error(r8, r3, r9, r7)     // Catch: java.lang.Throwable -> L6e
            com.bytedance.bdtracker.e0 r7 = r5.b     // Catch: java.lang.Throwable -> L6e
            com.bytedance.bdtracker.l2 r7 = r7.q     // Catch: java.lang.Throwable -> L6e
            com.bytedance.bdtracker.o2.a(r7, r9)     // Catch: java.lang.Throwable -> L6e
            com.bytedance.bdtracker.r.a(r6)
            r6 = r1
        L68:
            if (r6 == 0) goto L6d
            r5.b()
        L6d:
            return r0
        L6e:
            r5 = move-exception
            com.bytedance.bdtracker.r.a(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.k4.a(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, int):java.util.List");
    }

    public synchronized Map<String, List<p4>> a(String str) {
        HashMap map;
        boolean z;
        map = new HashMap();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = this.a.getWritableDatabase().rawQuery("SELECT * FROM profile WHERE _app_id=? ORDER BY _id DESC LIMIT 200", new String[]{str});
            while (cursorRawQuery.moveToNext()) {
                p4 p4Var = new p4();
                p4Var.a(cursorRawQuery);
                String strA = r.a((Object) p4Var.g);
                List arrayList = (List) map.get(strA);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(strA, arrayList);
                }
                arrayList.add(p4Var);
            }
            z = false;
        } catch (Throwable th) {
            try {
                boolean z2 = th instanceof SQLiteBlobTooBigException;
                this.b.d.D.error(5, "Query profiles for appId:{} failed", th, str);
                o2.a(this.b.q, th);
                r.a(cursorRawQuery);
                z = z2;
            } finally {
                r.a(cursorRawQuery);
            }
        }
        if (z) {
            b();
        }
        return map;
    }

    public final List<s4> a(SQLiteDatabase sQLiteDatabase, String str) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM trace WHERE _app_id= ? ", new String[]{str});
            while (cursorRawQuery.moveToNext()) {
                s4 s4Var = new s4();
                s4Var.a(cursorRawQuery);
                arrayList.add(s4Var);
            }
            r.a(cursorRawQuery);
            z = false;
        } catch (Throwable th) {
            try {
                boolean z2 = th instanceof SQLiteBlobTooBigException;
                this.b.d.D.error(5, "Query trace for appId:{} failed", th, str);
                o2.a(this.b.q, th);
                r.a(cursorRawQuery);
                z = z2;
            } catch (Throwable th2) {
                r.a(cursorRawQuery);
                throw th2;
            }
        }
        if (z) {
            b();
        }
        return arrayList;
    }

    public final synchronized void a(SQLiteDatabase sQLiteDatabase, n4 n4Var) {
        try {
            sQLiteDatabase.beginTransaction();
        } finally {
            try {
            } finally {
            }
        }
        if (sQLiteDatabase.insert("packV2", null, n4Var.a((ContentValues) null)) < 0) {
            return;
        }
        List<m4> list = n4Var.v;
        if (list != null) {
            for (m4 m4Var : list) {
                sQLiteDatabase.delete("launch", "_id = ?", new String[]{String.valueOf(m4Var.b)});
                LogUtils.sendObject("event_pack", m4Var);
            }
        }
        List<o4> list2 = n4Var.u;
        if (list2 != null) {
            for (o4 o4Var : list2) {
                sQLiteDatabase.delete("page", "session_id = ? and page_key = ?", new String[]{String.valueOf(o4Var.e), r.a((Object) o4Var.u)});
                LogUtils.sendObject("event_pack", o4Var);
            }
        }
        List<h4> list3 = n4Var.t;
        if (list3 != null) {
            for (h4 h4Var : list3) {
                sQLiteDatabase.delete("custom_event", "_id = ?", new String[]{String.valueOf(h4Var.b)});
                LogUtils.sendObject("event_pack", h4Var);
            }
        }
        List<l4> list4 = n4Var.s;
        if (list4 != null) {
            for (l4 l4Var : list4) {
                sQLiteDatabase.delete("eventv3", "_id = ?", new String[]{String.valueOf(l4Var.b)});
                LogUtils.sendObject("event_pack", l4Var);
            }
        }
        if (n4Var.x != null) {
            sQLiteDatabase.delete("trace", "_app_id= ? ", new String[]{String.valueOf(n4Var.m)});
            if (!LogUtils.isDisabled()) {
                Iterator<s4> it = n4Var.x.iterator();
                while (it.hasNext()) {
                    LogUtils.sendObject("event_pack", it.next());
                }
            }
        }
        sQLiteDatabase.setTransactionSuccessful();
    }

    public synchronized void a(String str, String str2) {
        SQLiteDatabase writableDatabase = null;
        try {
            writableDatabase = this.a.getWritableDatabase();
            writableDatabase.beginTransaction();
            writableDatabase.execSQL("UPDATE launch SET ssid = ? WHERE user_unique_id = ? AND LENGTH(ssid) = 0", new String[]{str2, str});
            writableDatabase.execSQL("UPDATE page SET ssid = ? WHERE user_unique_id = ? AND LENGTH(ssid) = 0", new String[]{str2, str});
            writableDatabase.execSQL("UPDATE eventv3 SET ssid = ? WHERE user_unique_id = ? AND LENGTH(ssid) = 0", new String[]{str2, str});
            writableDatabase.execSQL("UPDATE profile SET ssid = ? WHERE user_unique_id = ? AND LENGTH(ssid) = 0", new String[]{str2, str});
            writableDatabase.execSQL("UPDATE trace SET ssid = ? WHERE user_unique_id = ? AND LENGTH(ssid) = 0", new String[]{str2, str});
            writableDatabase.setTransactionSuccessful();
        } finally {
            try {
            } finally {
            }
        }
    }
}
