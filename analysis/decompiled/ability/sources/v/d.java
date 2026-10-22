package v;

import M9.y;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import r.C1871c;

/* loaded from: classes2.dex */
public final class d {
    public static final HashMap d;
    public static final b[] e;
    public static final y[] f;

    /* renamed from: a, reason: collision with root package name */
    public final C1871c f6753a;
    public final Y5.b b;
    public String c;

    static {
        HashMap map = new HashMap();
        d = map;
        map.put("page", new j());
        map.put("launch", new h());
        map.put("terminate", new m());
        map.put("pack", new i());
        e eVar = new e();
        g gVar = new g(null, null);
        JSONObject jSONObject = new JSONObject();
        f fVar = new f();
        fVar.m = "";
        fVar.l = jSONObject.toString();
        b[] bVarArr = {eVar, gVar, fVar};
        e = bVarArr;
        for (int i = 0; i < 3; i++) {
            b bVar = bVarArr[i];
            d.put(bVar.m(), bVar);
        }
        k kVar = new k();
        kVar.m = null;
        kVar.l = null;
        d.put("profile", kVar);
        f = new y[]{new y(1), new y(1), new y(1)};
    }

    public d(C1871c c1871c, String str) {
        this.b = new Y5.b(c1871c.b, str, null, 39, 3);
        this.f6753a = c1871c;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00fa A[DONT_GENERATE, PHI: r11 r15 r19
      0x00fa: PHI (r11v1 android.database.Cursor) = (r11v2 android.database.Cursor), (r11v5 android.database.Cursor) binds: [B:54:0x00f8, B:46:0x00e1] A[DONT_GENERATE, DONT_INLINE]
      0x00fa: PHI (r15v2 long) = (r15v3 long), (r15v5 long) binds: [B:54:0x00f8, B:46:0x00e1] A[DONT_GENERATE, DONT_INLINE]
      0x00fa: PHI (r19v3 long) = (r19v4 long), (r19v6 long) binds: [B:54:0x00f8, B:46:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(int r21, android.database.sqlite.SQLiteDatabase r22, java.lang.String r23, boolean r24, org.json.JSONArray[] r25, long[] r26) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.d.a(int, android.database.sqlite.SQLiteDatabase, java.lang.String, boolean, org.json.JSONArray[], long[]):int");
    }

    public static String b(String str, String str2, boolean z10, long j5) {
        StringBuilder sbV = B7.a.v("DELETE FROM ", str, " WHERE session_id");
        androidx.compose.foundation.b.C(sbV, z10 ? "='" : "!='", str2, "' AND _id<=");
        sbV.append(j5);
        return sbV.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0124 A[DONT_GENERATE, PHI: r4 r16 r18 r19
      0x0124: PHI (r4v20 android.database.Cursor) = (r4v21 android.database.Cursor), (r4v23 android.database.Cursor), (r4v23 android.database.Cursor) binds: [B:60:0x0122, B:48:0x00ee, B:52:0x00ff] A[DONT_GENERATE, DONT_INLINE]
      0x0124: PHI (r16v2 long) = (r16v3 long), (r16v5 long), (r16v5 long) binds: [B:60:0x0122, B:48:0x00ee, B:52:0x00ff] A[DONT_GENERATE, DONT_INLINE]
      0x0124: PHI (r18v3 java.lang.String) = (r18v4 java.lang.String), (r18v7 java.lang.String), (r18v7 java.lang.String) binds: [B:60:0x0122, B:48:0x00ee, B:52:0x00ff] A[DONT_GENERATE, DONT_INLINE]
      0x0124: PHI (r19v2 java.lang.String) = (r19v3 java.lang.String), (r19v5 java.lang.String), (r19v5 java.lang.String) binds: [B:60:0x0122, B:48:0x00ee, B:52:0x00ff] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONArray c(v.h r23, boolean r24, v.m r25, v.j r26, android.database.sqlite.SQLiteDatabase r27) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.d.c(v.h, boolean, v.m, v.j, android.database.sqlite.SQLiteDatabase):org.json.JSONArray");
    }

    public static void e(SQLiteDatabase sQLiteDatabase, HashMap map) {
        h hVar = (h) d.get("launch");
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM launch ORDER BY _id LIMIT 5", null);
                while (cursorRawQuery.moveToNext()) {
                    hVar.d(cursorRawQuery);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        w.g.a().c();
                    } catch (Throwable th) {
                        w.h.b(th);
                    }
                    map.put(hVar.d, jSONObject);
                }
                cursorRawQuery.close();
            } catch (Throwable th2) {
                try {
                    w.h.b(th2);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (Throwable th3) {
                    if (cursorRawQuery != null) {
                        try {
                            cursorRawQuery.close();
                        } catch (Throwable th4) {
                            w.h.b(th4);
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th5) {
            w.h.b(th5);
        }
    }

    public static boolean m(long[] jArr) {
        return jArr[0] > 0 || jArr[1] > 0 || jArr[2] > 0;
    }

    public final JSONObject d(h hVar, JSONObject jSONObject) {
        String str = hVar.m;
        C1871c c1871c = this.f6753a;
        if (TextUtils.equals(str, c1871c.f.g()) && hVar.l == c1871c.f.f()) {
            return jSONObject;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            U7.a.k(jSONObject2, jSONObject);
            jSONObject2.put("app_version", hVar.m);
            jSONObject2.put("version_code", hVar.l);
            return jSONObject2;
        } catch (JSONException e6) {
            w.h.b(e6);
            return jSONObject;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0095 A[Catch: all -> 0x00af, TryCatch #4 {all -> 0x00af, blocks: (B:28:0x008b, B:29:0x008f, B:31:0x0095, B:33:0x00a5, B:36:0x00b1, B:38:0x00bb, B:40:0x00c5, B:41:0x00ca), top: B:63:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00db A[Catch: all -> 0x00eb, LOOP:2: B:45:0x00d5->B:47:0x00db, LOOP_END, TRY_LEAVE, TryCatch #3 {all -> 0x00eb, blocks: (B:44:0x00d1, B:45:0x00d5, B:47:0x00db), top: B:61:0x00d1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.util.ArrayList r10) {
        /*
            r9 = this;
            java.lang.String r0 = "eventv3"
            java.lang.String r1 = "event"
            java.lang.String r2 = "save, "
            java.lang.StringBuilder r2 = M.a.f(r2)
            java.lang.String r3 = r10.toString()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = 0
            w.h.a(r2, r3)
            java.util.ArrayList r2 = new java.util.ArrayList
            r4 = 4
            r2.<init>(r4)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r4)
            Y5.b r9 = r9.b     // Catch: java.lang.Throwable -> L83
            android.database.sqlite.SQLiteDatabase r9 = r9.getWritableDatabase()     // Catch: java.lang.Throwable -> L83
            r9.beginTransaction()     // Catch: java.lang.Throwable -> L4a
            java.util.Iterator r10 = r10.iterator()     // Catch: java.lang.Throwable -> L4a
            r4 = r3
        L32:
            boolean r6 = r10.hasNext()     // Catch: java.lang.Throwable -> L4a
            if (r6 == 0) goto L7f
            java.lang.Object r6 = r10.next()     // Catch: java.lang.Throwable -> L4a
            v.b r6 = (v.b) r6     // Catch: java.lang.Throwable -> L4a
            java.lang.String r7 = r6.m()     // Catch: java.lang.Throwable -> L4a
            if (r4 != 0) goto L4d
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L4a
            r4.<init>()     // Catch: java.lang.Throwable -> L4a
            goto L50
        L4a:
            r10 = move-exception
            r3 = r9
            goto L84
        L4d:
            r4.clear()     // Catch: java.lang.Throwable -> L4a
        L50:
            r6.f(r4)     // Catch: java.lang.Throwable -> L4a
            long r7 = r9.insert(r7, r3, r4)     // Catch: java.lang.Throwable -> L4a
            r6.f6751a = r7     // Catch: java.lang.Throwable -> L4a
            java.lang.String r7 = r6.m()     // Catch: java.lang.Throwable -> L4a
            boolean r7 = r1.equals(r7)     // Catch: java.lang.Throwable -> L4a
            if (r7 == 0) goto L67
            r5.add(r6)     // Catch: java.lang.Throwable -> L4a
            goto L32
        L67:
            java.lang.String r7 = r6.m()     // Catch: java.lang.Throwable -> L4a
            boolean r7 = r0.equals(r7)     // Catch: java.lang.Throwable -> L4a
            if (r7 == 0) goto L75
            r5.add(r6)     // Catch: java.lang.Throwable -> L4a
            goto L32
        L75:
            boolean r7 = r6 instanceof v.h     // Catch: java.lang.Throwable -> L4a
            if (r7 == 0) goto L32
            v.h r6 = (v.h) r6     // Catch: java.lang.Throwable -> L4a
            r2.add(r6)     // Catch: java.lang.Throwable -> L4a
            goto L32
        L7f:
            r9.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4a
            goto L88
        L83:
            r10 = move-exception
        L84:
            w.h.b(r10)     // Catch: java.lang.Throwable -> Lf0
            r9 = r3
        L88:
            U7.a.g(r9)
            java.util.Iterator r9 = r5.iterator()     // Catch: java.lang.Throwable -> Laf
        L8f:
            boolean r10 = r9.hasNext()     // Catch: java.lang.Throwable -> Laf
            if (r10 == 0) goto Ld1
            java.lang.Object r10 = r9.next()     // Catch: java.lang.Throwable -> Laf
            v.b r10 = (v.b) r10     // Catch: java.lang.Throwable -> Laf
            java.lang.String r3 = r10.m()     // Catch: java.lang.Throwable -> Laf
            boolean r3 = r1.equals(r3)     // Catch: java.lang.Throwable -> Laf
            if (r3 == 0) goto Lb1
            v.e r10 = (v.e) r10     // Catch: java.lang.Throwable -> Laf
            w.c r10 = w.c.a()     // Catch: java.lang.Throwable -> Laf
            r10.b()     // Catch: java.lang.Throwable -> Laf
            goto L8f
        Laf:
            r9 = move-exception
            goto Lce
        Lb1:
            java.lang.String r3 = r10.m()     // Catch: java.lang.Throwable -> Laf
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Throwable -> Laf
            if (r3 == 0) goto L8f
            v.g r10 = (v.g) r10     // Catch: java.lang.Throwable -> Laf
            w.c r3 = w.c.a()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r10 = r10.l     // Catch: java.lang.Throwable -> Laf
            if (r10 == 0) goto Lca
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> Laf
            r4.<init>(r10)     // Catch: java.lang.Throwable -> Laf
        Lca:
            r3.c()     // Catch: java.lang.Throwable -> Laf
            goto L8f
        Lce:
            w.h.b(r9)
        Ld1:
            java.util.Iterator r9 = r2.iterator()     // Catch: java.lang.Throwable -> Leb
        Ld5:
            boolean r10 = r9.hasNext()     // Catch: java.lang.Throwable -> Leb
            if (r10 == 0) goto Lef
            java.lang.Object r10 = r9.next()     // Catch: java.lang.Throwable -> Leb
            v.h r10 = (v.h) r10     // Catch: java.lang.Throwable -> Leb
            w.g r0 = w.g.a()     // Catch: java.lang.Throwable -> Leb
            long r1 = r10.f6751a     // Catch: java.lang.Throwable -> Leb
            r0.b()     // Catch: java.lang.Throwable -> Leb
            goto Ld5
        Leb:
            r9 = move-exception
            w.h.b(r9)
        Lef:
            return
        Lf0:
            r9 = move-exception
            U7.a.g(r3)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: v.d.f(java.util.ArrayList):void");
    }

    public final void g(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        SQLiteDatabase writableDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        w.h.a("setResult, " + arrayList + ", " + arrayList2, null);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            i iVar = (i) it.next();
            if (!arrayList3.contains(iVar) && Math.abs(System.currentTimeMillis() - iVar.b) > 864000000) {
                arrayList.add(iVar);
                it.remove();
            }
        }
        try {
            writableDatabase = this.b.getWritableDatabase();
        } catch (Throwable th) {
            th = th;
        }
        try {
            writableDatabase.beginTransaction();
            try {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    i iVar2 = (i) it2.next();
                    if (arrayList3.contains(iVar2)) {
                        k(iVar2, true, writableDatabase, false);
                    } else {
                        writableDatabase.execSQL("DELETE FROM pack WHERE _id=?", new String[]{String.valueOf(iVar2.f6751a)});
                    }
                }
            } catch (Throwable th2) {
                w.h.b(th2);
            }
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                i iVar3 = (i) it3.next();
                if (iVar3.f6757r != null) {
                    l(null);
                }
                if (!arrayList3.contains(iVar3)) {
                    long j5 = iVar3.f6751a;
                    int i = iVar3.m + 1;
                    iVar3.m = i;
                    writableDatabase.execSQL("UPDATE pack SET _fail=" + i + " WHERE _id=" + j5);
                }
            }
            writableDatabase.setTransactionSuccessful();
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabase = writableDatabase;
            try {
                w.h.b(th);
                writableDatabase = sQLiteDatabase;
            } finally {
                U7.a.g(sQLiteDatabase);
            }
        }
    }

    public final void h(JSONObject jSONObject, h hVar, i iVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, ArrayList arrayList, HashMap map) {
        i iVar2;
        i iVar3;
        JSONArray jSONArrayOptJSONArray;
        StringBuilder sbF = M.a.f("packCurrentData, ");
        sbF.append(hVar.d);
        w.h.a(sbF.toString(), null);
        boolean zL = l(hVar.d);
        int iA = a(0, sQLiteDatabase, hVar.d, true, jSONArrayArr, jArr);
        JSONObject jSONObject2 = (JSONObject) map.get(hVar.d);
        JSONArray jSONArray = (jSONObject2 == null || ((jSONArrayOptJSONArray = jSONObject2.optJSONArray("item_impression")) != null && jSONArrayOptJSONArray.length() == 0)) ? null : jSONArrayOptJSONArray;
        int i = w.d.f6801a;
        b[] bVarArr = e;
        if (zL || m(jArr) || jSONArray != null) {
            iVar.p(jSONObject, zL ? hVar : null, null, null, jSONArrayArr, jArr, jSONArray);
            iVar2 = iVar;
            if (jSONArray != null || iA < bVarArr.length) {
                k(iVar2, true, sQLiteDatabase, true);
            } else {
                i iVar4 = (i) iVar2.clone();
                iVar4.q();
                arrayList.add(iVar4);
            }
        } else {
            iVar2 = iVar;
        }
        while (true) {
            int i6 = iA;
            if (i6 >= bVarArr.length) {
                return;
            }
            iA = a(i6, sQLiteDatabase, hVar.d, true, jSONArrayArr, jArr);
            if (m(jArr)) {
                iVar3 = iVar2;
                iVar3.p(jSONObject, l(hVar.d) ? hVar : null, null, null, jSONArrayArr, jArr, null);
                k(iVar3, true, sQLiteDatabase, true);
            } else {
                iVar3 = iVar2;
            }
            iVar2 = iVar3;
        }
    }

    public final void i(JSONObject jSONObject, h hVar, i iVar, j jVar, m mVar, SQLiteDatabase sQLiteDatabase, JSONArray[] jSONArrayArr, long[] jArr, HashMap map) {
        JSONArray jSONArrayOptJSONArray;
        StringBuilder sbF = M.a.f("packHistoryData, ");
        sbF.append(hVar.d);
        w.h.a(sbF.toString(), null);
        JSONArray jSONArrayC = c(hVar, true, mVar, jVar, sQLiteDatabase);
        hVar.n = jSONArrayC.length() == 0;
        int iA = a(0, sQLiteDatabase, hVar.d, true, jSONArrayArr, jArr);
        JSONObject jSONObject2 = (JSONObject) map.get(hVar.d);
        if (jSONObject2 == null || ((jSONArrayOptJSONArray = jSONObject2.optJSONArray("item_impression")) != null && jSONArrayOptJSONArray.length() == 0)) {
            jSONArrayOptJSONArray = null;
        }
        int i = w.d.f6801a;
        if (hVar.n) {
            iVar.p(jSONObject, l(hVar.d) ? hVar : null, null, null, jSONArrayArr, jArr, jSONArrayOptJSONArray);
        } else {
            iVar.p(jSONObject, null, mVar, jSONArrayC, jSONArrayArr, jArr, jSONArrayOptJSONArray);
        }
        k(iVar, true, sQLiteDatabase, true);
        int i6 = iA;
        while (i6 < e.length) {
            int iA2 = a(i6, sQLiteDatabase, hVar.d, true, jSONArrayArr, jArr);
            if (m(jArr)) {
                iVar.p(jSONObject, null, null, null, jSONArrayArr, jArr, null);
                k(iVar, true, sQLiteDatabase, true);
            }
            i6 = iA2;
        }
    }

    public final void j(JSONObject jSONObject, h hVar, m mVar, j jVar, i iVar, SQLiteDatabase sQLiteDatabase, String str, JSONArray[] jSONArrayArr, long[] jArr) {
        i iVar2;
        i iVar3;
        w.h.a("packLostData, " + str, null);
        hVar.d = str;
        iVar.d = str;
        JSONArray jSONArrayC = c(hVar, false, mVar, jVar, sQLiteDatabase);
        int iA = a(0, sQLiteDatabase, str, false, jSONArrayArr, jArr);
        hVar.n = jSONArrayC.length() == 0;
        if (m(jArr) || !hVar.n) {
            boolean z10 = hVar.n;
            iVar.p(jSONObject, null, !z10 ? mVar : null, !z10 ? jSONArrayC : null, jSONArrayArr, jArr, null);
            iVar2 = iVar;
            k(iVar2, false, sQLiteDatabase, true);
        } else {
            iVar2 = iVar;
        }
        int i = iA;
        while (i < e.length) {
            int iA2 = a(i, sQLiteDatabase, str, false, jSONArrayArr, jArr);
            if (m(jArr)) {
                iVar3 = iVar2;
                iVar3.p(jSONObject, null, null, null, jSONArrayArr, jArr, null);
                k(iVar3, false, sQLiteDatabase, true);
            } else {
                iVar3 = iVar2;
            }
            iVar2 = iVar3;
            i = iA2;
        }
    }

    public final void k(i iVar, boolean z10, SQLiteDatabase sQLiteDatabase, boolean z11) {
        s.g gVar;
        if (z11) {
            try {
                C1871c c1871c = this.f6753a;
                if (c1871c == null || (gVar = c1871c.c) == null || !gVar.n || iVar.f6757r != null) {
                    iVar.getClass();
                    ContentValues contentValues = new ContentValues();
                    iVar.f(contentValues);
                    if (sQLiteDatabase.insert("pack", null, contentValues) < 0) {
                        if (iVar.f6757r != null) {
                            l(null);
                            return;
                        }
                        return;
                    }
                } else {
                    w.h.a("DbStore:Filter no launch event.", null);
                }
            } catch (Throwable th) {
                w.h.b(th);
                return;
            }
        }
        long j5 = iVar.o;
        if (j5 > 0) {
            sQLiteDatabase.execSQL(b(NotificationCompat.CATEGORY_EVENT, iVar.d, z10, j5));
        }
        long j6 = iVar.f6756q;
        if (j6 > 0) {
            sQLiteDatabase.execSQL(b("eventv3", iVar.d, z10, j6));
        }
        long j10 = iVar.f6761w;
        if (j10 > 0) {
            sQLiteDatabase.execSQL(b("event_misc", iVar.d, z10, j10));
        }
    }

    public final boolean l(String str) {
        StringBuilder sbF = M.a.f("needLaunch, ");
        sbF.append(this.c);
        sbF.append(", ");
        sbF.append(str);
        w.h.a(sbF.toString(), null);
        if (TextUtils.equals(str, this.c)) {
            return false;
        }
        this.c = str;
        return true;
    }
}
