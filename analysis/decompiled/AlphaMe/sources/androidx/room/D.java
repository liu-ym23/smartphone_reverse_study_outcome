package androidx.room;

import android.database.Cursor;
import k0.AbstractC0675c;
import k0.InterfaceC0674b;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class D extends AbstractC0675c {

    /* renamed from: b, reason: collision with root package name */
    public C0353i f4180b;

    /* renamed from: c, reason: collision with root package name */
    public final B f4181c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4182d;

    /* renamed from: e, reason: collision with root package name */
    public final String f4183e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D(C0353i configuration, B delegate, String identityHash, String legacyHash) {
        super(delegate.version);
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(identityHash, "identityHash");
        Intrinsics.checkNotNullParameter(legacyHash, "legacyHash");
        this.f4180b = configuration;
        this.f4181c = delegate;
        this.f4182d = identityHash;
        this.f4183e = legacyHash;
    }

    @Override // k0.AbstractC0675c
    public final void b(InterfaceC0674b db) {
        Intrinsics.checkNotNullParameter(db, "db");
        super.b(db);
    }

    @Override // k0.AbstractC0675c
    public final void c(InterfaceC0674b db) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(db, "db");
        Cursor cursorQuery = db.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            Cursor cursor = cursorQuery;
            boolean z4 = false;
            if (cursor.moveToFirst()) {
                if (cursor.getInt(0) == 0) {
                    z4 = true;
                }
            }
            CloseableKt.closeFinally(cursorQuery, null);
            B b4 = this.f4181c;
            b4.createAllTables(db);
            if (!z4) {
                C cOnValidateSchema = b4.onValidateSchema(db);
                if (!cOnValidateSchema.f4178a) {
                    throw new IllegalStateException("Pre-packaged database has an invalid schema: " + cOnValidateSchema.f4179b);
                }
            }
            g(db);
            b4.onCreate(db);
        } finally {
        }
    }

    @Override // k0.AbstractC0675c
    public final void d(InterfaceC0674b db, int i4, int i5) {
        Intrinsics.checkNotNullParameter(db, "db");
        f(db, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    @Override // k0.AbstractC0675c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(k0.InterfaceC0674b r7) {
        /*
            r6 = this;
            java.lang.String r0 = "db"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'"
            android.database.Cursor r0 = r7.query(r0)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = r0
            android.database.Cursor r1 = (android.database.Cursor) r1     // Catch: java.lang.Throwable -> L25
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L25
            r3 = 0
            if (r2 == 0) goto L28
            int r1 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L25
            if (r1 == 0) goto L28
            r1 = 1
            goto L29
        L25:
            r6 = move-exception
            goto Laf
        L28:
            r1 = r3
        L29:
            r2 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            androidx.room.B r0 = r6.f4181c
            if (r1 == 0) goto L85
            k0.a r1 = new k0.a
            java.lang.String r4 = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"
            r1.<init>(r4)
            android.database.Cursor r1 = r7.query(r1)
            java.io.Closeable r1 = (java.io.Closeable) r1
            r4 = r1
            android.database.Cursor r4 = (android.database.Cursor) r4     // Catch: java.lang.Throwable -> L4c
            boolean r5 = r4.moveToFirst()     // Catch: java.lang.Throwable -> L4c
            if (r5 == 0) goto L4e
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L4c
            goto L4f
        L4c:
            r6 = move-exception
            goto L7f
        L4e:
            r3 = r2
        L4f:
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            java.lang.String r1 = r6.f4182d
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r4 != 0) goto L93
            java.lang.String r4 = r6.f4183e
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r3)
            if (r4 == 0) goto L63
            goto L93
        L63:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: "
            r7.<init>(r0)
            r7.append(r1)
            java.lang.String r0 = ", found: "
            r7.append(r0)
            r7.append(r3)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L7f:
            throw r6     // Catch: java.lang.Throwable -> L80
        L80:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r6)
            throw r7
        L85:
            androidx.room.C r1 = r0.onValidateSchema(r7)
            boolean r3 = r1.f4178a
            if (r3 == 0) goto L99
            r0.onPostMigrate(r7)
            r6.g(r7)
        L93:
            r0.onOpen(r7)
            r6.f4180b = r2
            return
        L99:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r0 = "Pre-packaged database has an invalid schema: "
            r7.<init>(r0)
            java.lang.String r0 = r1.f4179b
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        Laf:
            throw r6     // Catch: java.lang.Throwable -> Lb0
        Lb0:
            r7 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.D.e(k0.b):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0042 A[EDGE_INSN: B:69:0x0042->B:18:0x0042 BREAK  A[LOOP:1: B:12:0x002c->B:72:?], SYNTHETIC] */
    @Override // k0.AbstractC0675c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(k0.InterfaceC0674b r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.D.f(k0.b, int, int):void");
    }

    public final void g(InterfaceC0674b interfaceC0674b) {
        interfaceC0674b.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        String hash = this.f4182d;
        Intrinsics.checkNotNullParameter(hash, "hash");
        interfaceC0674b.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + hash + "')");
    }
}
