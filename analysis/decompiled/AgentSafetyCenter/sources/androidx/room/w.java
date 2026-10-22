package androidx.room;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import n3.r0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w extends r0 {

    /* renamed from: f, reason: collision with root package name */
    public a f1640f;

    /* renamed from: g, reason: collision with root package name */
    public List f1641g;

    /* renamed from: h, reason: collision with root package name */
    public a2.i f1642h;
    public String i;

    /* renamed from: j, reason: collision with root package name */
    public String f1643j;

    @Override // n3.r0
    public final void c(z4.c cVar) throws IOException, SQLException {
        a2.i iVar = this.f1642h;
        Cursor cursorA = cVar.A("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z10 = false;
            if (cursorA.moveToFirst()) {
                if (cursorA.getInt(0) == 0) {
                    z10 = true;
                }
            }
            cursorA.close();
            iVar.getClass();
            a2.i.w(cVar);
            if (!z10) {
                v vVarZ = a2.i.z(cVar);
                if (!vVarZ.f1638a) {
                    ad.o.n(vVarZ.f1639b, "Pre-packaged database has an invalid schema: ");
                    return;
                }
            }
            SQLiteDatabase sQLiteDatabase = cVar.f16385c;
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            String str = this.i;
            str.getClass();
            sQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + str + "')");
            List list = this.f1641g;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((p) it.next()).getClass();
                }
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                t.o.d(cursorA, th);
                throw th2;
            }
        }
    }

    @Override // n3.r0
    public final void d(z4.c cVar, int i, int i3) throws IOException, SQLException {
        j(cVar, i, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    @Override // n3.r0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(z4.c r8) throws java.io.IOException, android.database.SQLException {
        /*
            r7 = this;
            android.database.sqlite.SQLiteDatabase r0 = r8.f16385c
            a2.i r1 = r7.f1642h
            java.lang.String r2 = r7.i
            java.lang.String r3 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"
            android.database.Cursor r3 = r8.A(r3)
            boolean r4 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L1b
            r5 = 0
            if (r4 == 0) goto L1e
            int r4 = r3.getInt(r5)     // Catch: java.lang.Throwable -> L1b
            if (r4 == 0) goto L1e
            r4 = 1
            goto L1f
        L1b:
            r7 = move-exception
            goto Lc3
        L1e:
            r4 = r5
        L1f:
            r3.close()
            r3 = 0
            if (r4 == 0) goto L64
            a4.r r4 = new a4.r
            r4.<init>()
            java.lang.String r6 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            r4.f192c = r6
            android.database.Cursor r4 = r8.C(r4)
            boolean r6 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L3d
            if (r6 == 0) goto L3f
            java.lang.String r5 = r4.getString(r5)     // Catch: java.lang.Throwable -> L3d
            goto L40
        L3d:
            r7 = move-exception
            goto L5e
        L3f:
            r5 = r3
        L40:
            r4.close()
            boolean r4 = yb.k.a(r2, r5)
            if (r4 != 0) goto L8d
            java.lang.String r4 = r7.f1643j
            boolean r4 = yb.k.a(r4, r5)
            if (r4 == 0) goto L52
            goto L8d
        L52:
            java.lang.String r7 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "
            java.lang.String r8 = ", found: "
            java.lang.String r7 = androidx.activity.b.j(r7, r2, r8, r5)
            od.f.e(r7)
            return
        L5e:
            throw r7     // Catch: java.lang.Throwable -> L5f
        L5f:
            r8 = move-exception
            t.o.d(r4, r7)
            throw r8
        L64:
            r1.getClass()
            androidx.room.v r4 = a2.i.z(r8)
            boolean r5 = r4.f1638a
            if (r5 == 0) goto Lbb
            java.lang.String r4 = "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)"
            r0.execSQL(r4)
            r2.getClass()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '"
            r4.<init>(r5)
            r4.append(r2)
            java.lang.String r2 = "')"
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r0.execSQL(r2)
        L8d:
            java.lang.Object r1 = r1.f49f
            androidx.work.impl.WorkDatabase_Impl r1 = (androidx.work.impl.WorkDatabase_Impl) r1
            java.lang.String r2 = "PRAGMA foreign_keys = ON"
            r0.execSQL(r2)
            p4.a r0 = new p4.a
            r0.<init>()
            r0.f9697c = r8
            r1.r(r0)
            java.util.List r0 = r7.f1641g
            if (r0 == 0) goto Lb8
            java.util.Iterator r0 = r0.iterator()
        La8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lb8
            java.lang.Object r1 = r0.next()
            androidx.room.p r1 = (androidx.room.p) r1
            r1.a(r8)
            goto La8
        Lb8:
            r7.f1640f = r3
            return
        Lbb:
            java.lang.String r7 = "Pre-packaged database has an invalid schema: "
            java.lang.String r8 = r4.f1639b
            ad.o.n(r8, r7)
            return
        Lc3:
            throw r7     // Catch: java.lang.Throwable -> Lc4
        Lc4:
            r8 = move-exception
            t.o.d(r3, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.w.f(z4.c):void");
    }

    @Override // n3.r0
    public final void j(z4.c cVar, int i, int i3) throws IOException, SQLException {
        SQLiteDatabase sQLiteDatabase = cVar.f16385c;
        a2.i iVar = this.f1642h;
        a aVar = this.f1640f;
        if (aVar != null) {
            t tVar = aVar.f1487d;
            tVar.getClass();
            List<q4.a> listQ = a.a.q(tVar, i, i3);
            if (listQ != null) {
                iVar.getClass();
                p4.a aVar2 = new p4.a();
                aVar2.f9697c = cVar;
                VarHandle.storeStoreFence();
                td.h.o(aVar2);
                for (q4.a aVar3 : listQ) {
                    aVar3.getClass();
                    aVar3.a(cVar);
                }
                v vVarZ = a2.i.z(cVar);
                if (!vVarZ.f1638a) {
                    ad.o.n(vVarZ.f1639b, "Migration didn't properly handle: ");
                    return;
                }
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                String str = this.i;
                str.getClass();
                sQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + str + "')");
                return;
            }
        }
        a aVar4 = this.f1640f;
        if (aVar4 == null || a.a.M(aVar4, i, i3)) {
            throw new IllegalStateException("A migration from " + i + " to " + i3 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
        if (aVar4.f1501s) {
            Cursor cursorA = cVar.A("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                lb.c cVarO = ac.a.o();
                while (cursorA.moveToNext()) {
                    String string = cursorA.getString(0);
                    string.getClass();
                    if (!hc.o.U(string, "sqlite_", false) && !string.equals("android_metadata")) {
                        cVarO.add(new jb.g(string, Boolean.valueOf(yb.k.a(cursorA.getString(1), "view"))));
                    }
                }
                lb.c cVarK = ac.a.k(cVarO);
                cursorA.close();
                ListIterator listIterator = cVarK.listIterator(0);
                while (true) {
                    lb.a aVar5 = (lb.a) listIterator;
                    if (!aVar5.hasNext()) {
                        break;
                    }
                    jb.g gVar = (jb.g) aVar5.next();
                    String str2 = (String) gVar.f6759c;
                    if (((Boolean) gVar.f6760f).booleanValue()) {
                        sQLiteDatabase.execSQL("DROP VIEW IF EXISTS " + str2);
                    } else {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str2);
                    }
                }
            } finally {
            }
        } else {
            iVar.getClass();
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Dependency`");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkTag`");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkName`");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Preference`");
        }
        List list = this.f1641g;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((p) it.next()).getClass();
            }
        }
        iVar.getClass();
        a2.i.w(cVar);
    }

    @Override // n3.r0
    public final void b(z4.c cVar) {
    }
}
