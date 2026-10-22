package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g implements SystemIdInfoDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f5644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.j f5645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedSQLiteStatement f5646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedSQLiteStatement f5647d;

    public class a extends androidx.room.j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f5648d;

        public a(g r10, RoomDatabase r11) {
            this.f5648d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
        }

        @Override // androidx.room.j
        public /* bridge */ /* synthetic */ void i(SupportSQLiteStatement r10, Object r11) {
            l(r10, (f) r11);
        }

        public void l(SupportSQLiteStatement r10, f r11) {
            String r12 = r11.f5641a;
            if (r12 != null) goto L5;
            r10.bindNull(1);
        L6:
            r10.bindLong(2, r11.a());
            r10.bindLong(3, r11.f5643c);
            return;
        L5:
            r10.bindString(1, r12);
            goto L6
        }
    }

    public class b extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f5649d;

        public b(g r10, RoomDatabase r11) {
            this.f5649d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?";
        }
    }

    public class c extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g f5650d;

        public c(g r10, RoomDatabase r11) {
            this.f5650d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM SystemIdInfo where work_spec_id=?";
        }
    }

    public g(RoomDatabase r10) {
        this.f5644a = r10;
        this.f5645b = new a(this, r10);
        this.f5646c = new b(this, r10);
        this.f5647d = new c(this, r10);
    }

    public static List a() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public f getSystemIdInfo(String r10, int r11) {
        RoomSQLiteQuery r12 = RoomSQLiteQuery.a("SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?", 2);
        if (r10 != null) goto L5;
        r12.bindNull(1);
    L6:
        r12.bindLong(2, r11);
        this.f5644a.d();
        f r13 = null;
        String r14 = null;
        Cursor r15 = b0.b.c(this.f5644a, r12, false, null);
        int r16 = b0.a.d(r15, "work_spec_id");     // Catch: Throwable -> L15
        int r17 = b0.a.d(r15, "generation");     // Catch: Throwable -> L15
        int r18 = b0.a.d(r15, "system_id");     // Catch: Throwable -> L15
        if (r15.moveToFirst() == true) goto L10;
    L17:
        r15.close();
        r12.c();
        return r13;
    L10:
        if (r15.isNull(r16) == true) goto L13;
        r14 = r15.getString(r16);     // Catch: Throwable -> L15
    L13:
        r13 = new f(r14, r15.getInt(r17), r15.getInt(r18));     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        r15.close();
        r12.c();
        throw th;
    L5:
        r12.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public List getWorkSpecIds() {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.a("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.f5644a.d();
        Cursor r11 = b0.b.c(this.f5644a, r10, false, null);
        ArrayList r12 = new ArrayList(r11.getCount());     // Catch: Throwable -> L12
    L4:
        if (r11.moveToNext() == false) goto L14;
        if (r11.isNull(0) == false) goto L9;
        String r13 = null;
    L10:
        r12.add(r13);     // Catch: Throwable -> L12
        goto L4
    L9:
        r13 = r11.getString(0);     // Catch: Throwable -> L12
        goto L10
    L14:
        r11.close();
        r10.c();
        return r12;
    L12:
        th = move-exception;
        r11.close();
        r10.c();
        throw th;
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void insertSystemIdInfo(f r10) {
        this.f5644a.d();
        this.f5644a.e();
        this.f5645b.j(r10);     // Catch: Throwable -> L6
        this.f5644a.D();     // Catch: Throwable -> L6
        this.f5644a.i();
        return;
    L6:
        th = move-exception;
        this.f5644a.i();
        throw th;
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(String r10, int r11) {
        this.f5644a.d();
        SupportSQLiteStatement r12 = this.f5646c.b();
        if (r10 != null) goto L5;
        r12.bindNull(1);
    L6:
        r12.bindLong(2, r11);
        this.f5644a.e();
        r12.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f5644a.D();     // Catch: Throwable -> L10
        this.f5644a.i();
        this.f5646c.h(r12);
        return;
    L10:
        th = move-exception;
        this.f5644a.i();
        this.f5646c.h(r12);
        throw th;
    L5:
        r12.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(String r10) {
        this.f5644a.d();
        SupportSQLiteStatement r11 = this.f5647d.b();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5644a.e();
        r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f5644a.D();     // Catch: Throwable -> L10
        this.f5644a.i();
        this.f5647d.h(r11);
        return;
    L10:
        th = move-exception;
        this.f5644a.i();
        this.f5647d.h(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public f getSystemIdInfo(i r10) {
        return SystemIdInfoDao.a.a(this, r10);
    }

    @Override // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(i r10) {
        SystemIdInfoDao.a.b(this, r10);
    }
}
