package androidx.room;

import android.database.Cursor;
import android.database.SQLException;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import java.io.IOException;
import y1.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k extends c.a {

    /* renamed from: b, reason: collision with root package name */
    public c f2562b;

    /* renamed from: c, reason: collision with root package name */
    public final a f2563c;

    /* renamed from: d, reason: collision with root package name */
    public final String f2564d;

    /* renamed from: e, reason: collision with root package name */
    public final String f2565e;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f2566a;

        public a(int i10) {
            this.f2566a = i10;
        }

        public abstract void a(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

        public abstract void b(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

        public abstract void c(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

        public abstract void d(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

        public abstract void e(FrameworkSQLiteDatabase frameworkSQLiteDatabase);

        public abstract b f(FrameworkSQLiteDatabase frameworkSQLiteDatabase);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f2567a;

        /* renamed from: b, reason: collision with root package name */
        public final String f2568b;

        public b(String str, boolean z) {
            this.f2567a = z;
            this.f2568b = str;
        }
    }

    public k(c cVar, a aVar, String str, String str2) {
        super(aVar.f2566a);
        this.f2562b = cVar;
        this.f2563c = aVar;
        this.f2564d = str;
        this.f2565e = str2;
    }

    @Override // y1.c.a
    public final void c(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws IOException, SQLException {
        Cursor cursorO0 = frameworkSQLiteDatabase.o0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z = false;
            if (cursorO0.moveToFirst()) {
                if (cursorO0.getInt(0) == 0) {
                    z = true;
                }
            }
            cursorO0.close();
            a aVar = this.f2563c;
            aVar.a(frameworkSQLiteDatabase);
            if (!z) {
                b bVarF = aVar.f(frameworkSQLiteDatabase);
                if (!bVarF.f2567a) {
                    throw new IllegalStateException("Pre-packaged database has an invalid schema: " + bVarF.f2568b);
                }
            }
            g(frameworkSQLiteDatabase);
            aVar.c(frameworkSQLiteDatabase);
        } finally {
        }
    }

    @Override // y1.c.a
    public final void d(FrameworkSQLiteDatabase frameworkSQLiteDatabase, int i10, int i11) throws SQLException {
        f(frameworkSQLiteDatabase, i10, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    @Override // y1.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(androidx.sqlite.db.framework.FrameworkSQLiteDatabase r6) throws java.io.IOException, android.database.SQLException {
        /*
            r5 = this;
            java.lang.String r0 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"
            android.database.Cursor r0 = r6.o0(r0)
            boolean r1 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L15
            r2 = 0
            if (r1 == 0) goto L18
            int r1 = r0.getInt(r2)     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L18
            r1 = 1
            goto L19
        L15:
            r5 = move-exception
            goto L89
        L18:
            r1 = r2
        L19:
            r0.close()
            androidx.room.k$a r0 = r5.f2563c
            r3 = 0
            if (r1 == 0) goto L62
            y1.a r1 = new y1.a
            java.lang.String r4 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            r1.<init>(r4)
            android.database.Cursor r1 = r6.b0(r1)
            boolean r4 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L37
            if (r4 == 0) goto L39
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L37
            goto L3a
        L37:
            r5 = move-exception
            goto L5c
        L39:
            r2 = r3
        L3a:
            r1.close()
            java.lang.String r1 = r5.f2564d
            boolean r4 = r1.equals(r2)
            if (r4 != 0) goto L6d
            java.lang.String r4 = r5.f2565e
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L4e
            goto L6d
        L4e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "
            java.lang.String r0 = ", found: "
            java.lang.String r6 = ai.onnxruntime.a.l(r6, r1, r0, r2)
            r5.<init>(r6)
            throw r5
        L5c:
            throw r5     // Catch: java.lang.Throwable -> L5d
        L5d:
            r6 = move-exception
            mb.y.q(r1, r5)
            throw r6
        L62:
            androidx.room.k$b r1 = r0.f(r6)
            boolean r2 = r1.f2567a
            if (r2 == 0) goto L73
            r5.g(r6)
        L6d:
            r0.d(r6)
            r5.f2562b = r3
            return
        L73:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "Pre-packaged database has an invalid schema: "
            r6.<init>(r0)
            java.lang.String r0 = r1.f2568b
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L89:
            throw r5     // Catch: java.lang.Throwable -> L8a
        L8a:
            r6 = move-exception
            mb.y.q(r0, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.k.e(androidx.sqlite.db.framework.FrameworkSQLiteDatabase):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x007f A[EDGE_INSN: B:73:0x007f->B:37:0x007f BREAK  A[LOOP:1: B:12:0x001e->B:76:?], SYNTHETIC] */
    @Override // y1.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(androidx.sqlite.db.framework.FrameworkSQLiteDatabase r13, int r14, int r15) throws android.database.SQLException {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.k.f(androidx.sqlite.db.framework.FrameworkSQLiteDatabase, int, int):void");
    }

    public final void g(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
        frameworkSQLiteDatabase.n("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        frameworkSQLiteDatabase.n("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + this.f2564d + "')");
    }

    @Override // y1.c.a
    public final void b(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
    }
}
