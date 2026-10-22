package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class b implements DependencyDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f5631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.j f5632b;

    public class a extends androidx.room.j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ b f5633d;

        public a(b r10, RoomDatabase r11) {
            this.f5633d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
        }

        @Override // androidx.room.j
        public /* bridge */ /* synthetic */ void i(SupportSQLiteStatement r10, Object r11) {
            l(r10, (androidx.work.impl.model.a) r11);
        }

        public void l(SupportSQLiteStatement r10, androidx.work.impl.model.a r11) {
            if (r11.b() != null) goto L5;
            r10.bindNull(1);
        L7:
            if (r11.a() != null) goto L9;
            r10.bindNull(2);
            return;
        L9:
            r10.bindString(2, r11.a());
            return;
        L5:
            r10.bindString(1, r11.b());
            goto L7
        }
    }

    public b(RoomDatabase r10) {
        this.f5631a = r10;
        this.f5632b = new a(this, r10);
    }

    public static List a() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.DependencyDao
    public List getDependentWorkIds(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5631a.d();
        Cursor r12 = b0.b.c(this.f5631a, r11, false, null);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L16
    L8:
        if (r12.moveToNext() == false) goto L18;
        if (r12.isNull(0) == false) goto L13;
        String r14 = null;
    L14:
        r13.add(r14);     // Catch: Throwable -> L16
        goto L8
    L13:
        r14 = r12.getString(0);     // Catch: Throwable -> L16
        goto L14
    L18:
        r12.close();
        r11.c();
        return r13;
    L16:
        th = move-exception;
        r12.close();
        r11.c();
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.DependencyDao
    public List getPrerequisites(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT prerequisite_id FROM dependency WHERE work_spec_id=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5631a.d();
        Cursor r12 = b0.b.c(this.f5631a, r11, false, null);
        ArrayList r13 = new ArrayList(r12.getCount());     // Catch: Throwable -> L16
    L8:
        if (r12.moveToNext() == false) goto L18;
        if (r12.isNull(0) == false) goto L13;
        String r14 = null;
    L14:
        r13.add(r14);     // Catch: Throwable -> L16
        goto L8
    L13:
        r14 = r12.getString(0);     // Catch: Throwable -> L16
        goto L14
    L18:
        r12.close();
        r11.c();
        return r13;
    L16:
        th = move-exception;
        r12.close();
        r11.c();
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.DependencyDao
    public boolean hasCompletedAllPrerequisites(String r10) {
        boolean r11 = true;
        RoomSQLiteQuery r12 = RoomSQLiteQuery.a("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if (r10 != null) goto L5;
        r12.bindNull(1);
    L6:
        this.f5631a.d();
        boolean r13 = false;
        Cursor r14 = b0.b.c(this.f5631a, r12, false, null);
    L14:
        th = move-exception;
        r14.close();
        r12.c();
        throw th;
    L8:
        if (r14.moveToFirst() == false) goto L16;
        if (r14.getInt(0) != 0) goto L13;
        r11 = false;
    L13:
        r13 = r11;
    L16:
        r14.close();
        r12.c();
        return r13;
    L5:
        r12.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.DependencyDao
    public boolean hasDependents(String r10) {
        boolean r11 = true;
        RoomSQLiteQuery r12 = RoomSQLiteQuery.a("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if (r10 != null) goto L5;
        r12.bindNull(1);
    L6:
        this.f5631a.d();
        boolean r13 = false;
        Cursor r14 = b0.b.c(this.f5631a, r12, false, null);
    L14:
        th = move-exception;
        r14.close();
        r12.c();
        throw th;
    L8:
        if (r14.moveToFirst() == false) goto L16;
        if (r14.getInt(0) != 0) goto L13;
        r11 = false;
    L13:
        r13 = r11;
    L16:
        r14.close();
        r12.c();
        return r13;
    L5:
        r12.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.DependencyDao
    public void insertDependency(androidx.work.impl.model.a r10) {
        this.f5631a.d();
        this.f5631a.e();
        this.f5632b.j(r10);     // Catch: Throwable -> L6
        this.f5631a.D();     // Catch: Throwable -> L6
        this.f5631a.i();
        return;
    L6:
        th = move-exception;
        this.f5631a.i();
        throw th;
    }
}
