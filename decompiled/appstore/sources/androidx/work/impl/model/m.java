package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class m implements WorkProgressDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f5660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.j f5661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedSQLiteStatement f5662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f5663d;

    public class a extends androidx.room.j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ m f5664d;

        public a(m r10, RoomDatabase r11) {
            this.f5664d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
        }

        @Override // androidx.room.j
        public /* bridge */ /* synthetic */ void i(SupportSQLiteStatement r10, Object r11) {
            l(r10, (l) r11);
        }

        public void l(SupportSQLiteStatement r10, l r11) {
            if (r11.b() != null) goto L5;
            r10.bindNull(1);
        L6:
            byte[] r12 = androidx.work.c.k(r11.a());
            if (r12 != null) goto L9;
            r10.bindNull(2);
            return;
        L9:
            r10.bindBlob(2, r12);
            return;
        L5:
            r10.bindString(1, r11.b());
            goto L6
        }
    }

    public class b extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ m f5665d;

        public b(m r10, RoomDatabase r11) {
            this.f5665d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE from WorkProgress where work_spec_id=?";
        }
    }

    public class c extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ m f5666d;

        public c(m r10, RoomDatabase r11) {
            this.f5666d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM WorkProgress";
        }
    }

    public m(RoomDatabase r10) {
        this.f5660a = r10;
        this.f5661b = new a(this, r10);
        this.f5662c = new b(this, r10);
        this.f5663d = new c(this, r10);
    }

    public static List a() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void delete(String r10) {
        this.f5660a.d();
        SupportSQLiteStatement r11 = this.f5662c.b();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5660a.e();
        r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f5660a.D();     // Catch: Throwable -> L10
        this.f5660a.i();
        this.f5662c.h(r11);
        return;
    L10:
        th = move-exception;
        this.f5660a.i();
        this.f5662c.h(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void deleteAll() {
        this.f5660a.d();
        SupportSQLiteStatement r10 = this.f5663d.b();
        this.f5660a.e();
        r10.executeUpdateDelete();     // Catch: Throwable -> L6
        this.f5660a.D();     // Catch: Throwable -> L6
        this.f5660a.i();
        this.f5663d.h(r10);
        return;
    L6:
        th = move-exception;
        this.f5660a.i();
        this.f5663d.h(r10);
        throw th;
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public androidx.work.c getProgressForWorkSpecId(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT progress FROM WorkProgress WHERE work_spec_id=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5660a.d();
        androidx.work.c r12 = null;
        Cursor r13 = b0.b.c(this.f5660a, r11, false, null);
    L17:
        th = move-exception;
        r13.close();
        r11.c();
        throw th;
    L8:
        if (r13.moveToFirst() == true) goto L10;
    L19:
        r13.close();
        r11.c();
        return r12;
    L10:
        if (r13.isNull(0) == false) goto L12;
        byte[] r14 = null;
    L13:
        if (r14 == null) goto L19;
        r12 = androidx.work.c.g(r14);     // Catch: Throwable -> L17
        goto L19
    L12:
        r14 = r13.getBlob(0);     // Catch: Throwable -> L17
        goto L13
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkProgressDao
    public void insert(l r10) {
        this.f5660a.d();
        this.f5660a.e();
        this.f5661b.j(r10);     // Catch: Throwable -> L6
        this.f5660a.D();     // Catch: Throwable -> L6
        this.f5660a.i();
        return;
    L6:
        th = move-exception;
        this.f5660a.i();
        throw th;
    }
}
