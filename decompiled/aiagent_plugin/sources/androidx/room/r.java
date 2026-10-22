package androidx.room;

import android.database.Cursor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: RoomOpenHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class r extends androidx.sqlite.db.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f2683a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f2684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f2685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f2686e;

    /* JADX INFO: compiled from: RoomOpenHelper.java */
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2687a;

        public abstract void a(androidx.sqlite.db.c r1);

        public abstract void b(androidx.sqlite.db.c r1);

        public abstract void c(androidx.sqlite.db.c r1);

        public abstract void d(androidx.sqlite.db.c r1);

        public void g(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        }

        public void h(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        }

        public a(int r1) {
            this.f2687a = r1;
        }

        @Deprecated
        public void e(androidx.sqlite.db.c r2) {
            androidx.sqlite.db.c r1 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }

        public b f(androidx.sqlite.db.c r3) {
            e((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin"));
            return new b(true, null);
        }
    }

    /* JADX INFO: compiled from: RoomOpenHelper.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f2689b;

        public b(boolean r1, String r2) {
            this.f2688a = r1;
            this.f2689b = r2;
        }
    }

    public r(c r2, a r3, String r4, String r5) {
        super(r3.f2687a);
        this.f2683a = r2;
        this.f2684c = r3;
        this.f2685d = r4;
        this.f2686e = r5;
    }

    @Override // androidx.sqlite.db.d.a
    public void a(androidx.sqlite.db.c r3) {
        super.a((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.sqlite.db.d.a
    public void b(androidx.sqlite.db.c r3) {
        androidx.sqlite.db.c r4 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        boolean r0 = i(r4);
        this.f2684c.b(r4);
        if (r0 == true) goto L9;
        b r1 = this.f2684c.f(r4);
        if (r1.f2688a == true) goto L9;
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r1.f2689b);
    L9:
        f(r4);
        this.f2684c.d(r4);
    }

    @Override // androidx.sqlite.db.d.a
    public void a(androidx.sqlite.db.c r5, int r6, int r7) {
        androidx.sqlite.db.c r8 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r5, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        c r0 = this.f2683a;
        if (r0 == null) goto L15;
        List<androidx.room.a.b> r1 = r0.f2626d.a(r6, r7);
        if (r1 == null) goto L15;
        this.f2684c.g(r8);
        Iterator<androidx.room.a.b> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        ((androidx.room.a.b) ZeusTransformUtils.preCheckCast(r2.next(), androidx.room.a.b.class, "com.obric.aiagent.plugin")).a(r8);
        goto L8
    L10:
        b r3 = this.f2684c.f(r8);
        if (r3.f2688a == false) goto L14;
        this.f2684c.h(r8);
        f(r8);
        boolean r4 = true;
    L16:
        if (r4 == true) goto L24;
        c r9 = this.f2683a;
        if (r9 == null) goto L23;
        if (r9.a(r6, r7) == true) goto L23;
        this.f2684c.a(r8);
        this.f2684c.b(r8);
        return;
    L23:
        throw new IllegalStateException("A migration from " + r6 + " to " + r7 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    L24:
        return;
    L14:
        throw new IllegalStateException("Migration didn't properly handle: " + r3.f2689b);
    L15:
        r4 = false;
        goto L16
    }

    @Override // androidx.sqlite.db.d.a
    public void b(androidx.sqlite.db.c r3, int r4, int r5) {
        a((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // androidx.sqlite.db.d.a
    public void c(androidx.sqlite.db.c r3) {
        androidx.sqlite.db.c r4 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        super.c(r4);
        e(r4);
        this.f2684c.c(r4);
        this.f2683a = null;
    }

    private void e(androidx.sqlite.db.c r4) {
        androidx.sqlite.db.c r5 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r4, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        if (h(r5) == false) goto L18;
        String r0 = null;
        Cursor r6 = r5.query(new androidx.sqlite.db.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
    L15:
        th = move-exception;
        r6.close();
        throw th;
    L6:
        if (r6.moveToFirst() == false) goto L8;
        r0 = r6.getString(0);     // Catch: Throwable -> L15
    L8:
        r6.close();
        if (this.f2685d.equals(r0) == false) goto L11;
        return;
    L11:
        if (this.f2686e.equals(r0) == false) goto L14;
        return;
    L14:
        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
    L18:
        b r1 = this.f2684c.f(r5);
        if (r1.f2688a == false) goto L23;
        this.f2684c.h(r5);
        f(r5);
        return;
    L23:
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r1.f2689b);
    }

    private void f(androidx.sqlite.db.c r3) {
        androidx.sqlite.db.c r4 = (androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin");
        g(r4);
        r4.b(q.a(this.f2685d));
    }

    private void g(androidx.sqlite.db.c r2) {
        ((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin")).b("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean h(androidx.sqlite.db.c r2) {
        Cursor r3 = ((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin")).query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        boolean r1 = false;
        if (r3.moveToFirst() == false) goto L8;
        if (r3.getInt(0) == 0) goto L8;
        r1 = true;
    L8:
        r3.close();
        return r1;
    L10:
        th = move-exception;
        r3.close();
        throw th;
    }

    private static boolean i(androidx.sqlite.db.c r2) {
        Cursor r3 = ((androidx.sqlite.db.c) ZeusTransformUtils.wrapperContextForParams(r2, androidx.sqlite.db.c.class, "com.obric.aiagent.plugin")).query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        boolean r1 = false;
        if (r3.moveToFirst() == false) goto L8;
        if (r3.getInt(0) != 0) goto L8;
        r1 = true;
    L8:
        r3.close();
        return r1;
    L10:
        th = move-exception;
        r3.close();
        throw th;
    }
}
