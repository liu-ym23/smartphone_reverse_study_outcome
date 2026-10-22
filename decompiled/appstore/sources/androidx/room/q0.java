package androidx.room;

import android.database.Cursor;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
public class q0 extends SupportSQLiteOpenHelper.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f4638g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f4639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f4640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f4641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f4642f;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final boolean a(SupportSQLiteDatabase r10) {
            kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
            Cursor r11 = r10.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            boolean r12 = false;
            if (r11.moveToFirst() == false) goto L10;
            if (r11.getInt(0) != 0) goto L10;
            r12 = true;
        L10:
            kotlin.io.b.a(r11, null);
            return r12;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            kotlin.io.b.a(r11, th);
            throw th;
        }

        public final boolean b(SupportSQLiteDatabase r10) {
            kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
            Cursor r11 = r10.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            boolean r12 = false;
            if (r11.moveToFirst() == false) goto L10;
            if (r11.getInt(0) == 0) goto L10;
            r12 = true;
        L10:
            kotlin.io.b.a(r11, null);
            return r12;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            kotlin.io.b.a(r11, th);
            throw th;
        }

        public a() {
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4643a;

        public b(int r10) {
            this.f4643a = r10;
        }

        public abstract void a(SupportSQLiteDatabase r10);

        public abstract void b(SupportSQLiteDatabase r10);

        public abstract void c(SupportSQLiteDatabase r10);

        public abstract void d(SupportSQLiteDatabase r10);

        public abstract void e(SupportSQLiteDatabase r10);

        public abstract void f(SupportSQLiteDatabase r10);

        public abstract c g(SupportSQLiteDatabase r10);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f4644a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f4645b;

        public c(boolean r10, String r11) {
            this.f4644a = r10;
            this.f4645b = r11;
        }
    }

    static {
        f4638g = new a(null);
    }

    public q0(h r10, b r11, String r12, String r13) {
        kotlin.jvm.internal.q.g(r10, "configuration");
        kotlin.jvm.internal.q.g(r11, "delegate");
        kotlin.jvm.internal.q.g(r12, "identityHash");
        kotlin.jvm.internal.q.g(r13, "legacyHash");
        super(r11.f4643a);
        this.f4639c = r10;
        this.f4640d = r11;
        this.f4641e = r12;
        this.f4642f = r13;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.a
    public void b(SupportSQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        super.b(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.a
    public void d(SupportSQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        boolean r11 = f4638g.a(r10);
        this.f4640d.a(r10);
        if (r11 == true) goto L9;
        c r12 = this.f4640d.g(r10);
        if (r12.f4644a == true) goto L9;
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r12.f4645b);
    L9:
        j(r10);
        this.f4640d.c(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.a
    public void e(SupportSQLiteDatabase r10, int r11, int r12) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        g(r10, r11, r12);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.a
    public void f(SupportSQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        super.f(r10);
        h(r10);
        this.f4640d.d(r10);
        this.f4639c = null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.a
    public void g(SupportSQLiteDatabase r10, int r11, int r12) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        h r13 = this.f4639c;
        if (r13 == null) goto L15;
        List r14 = r13.f4557d.d(r11, r12);
        if (r14 == null) goto L15;
        this.f4640d.f(r10);
        Iterator r15 = r14.iterator();
    L8:
        if (r15.hasNext() == false) goto L10;
        ((a0.a) r15.next()).a(r10);
        goto L8
    L10:
        c r16 = this.f4640d.g(r10);
        if (r16.f4644a == false) goto L14;
        this.f4640d.e(r10);
        j(r10);
        return;
    L14:
        throw new IllegalStateException("Migration didn't properly handle: " + r16.f4645b);
    L15:
        h r17 = this.f4639c;
        if (r17 == null) goto L22;
        if (r17.a(r11, r12) == true) goto L22;
        this.f4640d.b(r10);
        this.f4640d.a(r10);
        return;
    L22:
        throw new IllegalStateException("A migration from " + r11 + " to " + r12 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    public final void h(SupportSQLiteDatabase r10) {
        if (f4638g.b(r10) == false) goto L23;
        Cursor r11 = r10.query(new c0.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        kotlin.io.b.a(r11, th);
        throw th;
    L6:
        if (r11.moveToFirst() == false) goto L11;
        String r12 = r11.getString(0);     // Catch: Throwable -> L9
    L12:
        kotlin.io.b.a(r11, null);
        if (kotlin.jvm.internal.q.b(this.f4641e, r12) == false) goto L15;
        return;
    L15:
        if (kotlin.jvm.internal.q.b(this.f4642f, r12) == false) goto L18;
        return;
    L18:
        throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + this.f4641e + ", found: " + r12);
    L11:
        r12 = null;
        goto L12
    L23:
        c r13 = this.f4640d.g(r10);
        if (r13.f4644a == false) goto L28;
        this.f4640d.e(r10);
        j(r10);
        return;
    L28:
        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + r13.f4645b);
    }

    public final void i(SupportSQLiteDatabase r10) {
        r10.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    public final void j(SupportSQLiteDatabase r10) {
        i(r10);
        r10.execSQL(p0.a(this.f4641e));
    }
}
