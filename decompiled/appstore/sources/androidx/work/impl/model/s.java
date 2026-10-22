package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class s implements WorkTagDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f5738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.j f5739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedSQLiteStatement f5740c;

    public class a extends androidx.room.j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ s f5741d;

        public a(s r10, RoomDatabase r11) {
            this.f5741d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // androidx.room.j
        public /* bridge */ /* synthetic */ void i(SupportSQLiteStatement r10, Object r11) {
            l(r10, (r) r11);
        }

        public void l(SupportSQLiteStatement r10, r r11) {
            if (r11.a() != null) goto L5;
            r10.bindNull(1);
        L7:
            if (r11.b() != null) goto L9;
            r10.bindNull(2);
            return;
        L9:
            r10.bindString(2, r11.b());
            return;
        L5:
            r10.bindString(1, r11.a());
            goto L7
        }
    }

    public class b extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ s f5742d;

        public b(s r10, RoomDatabase r11) {
            this.f5742d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "DELETE FROM worktag WHERE work_spec_id=?";
        }
    }

    public s(RoomDatabase r10) {
        this.f5738a = r10;
        this.f5739b = new a(this, r10);
        this.f5740c = new b(this, r10);
    }

    public static List a() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public void deleteByWorkSpecId(String r10) {
        this.f5738a.d();
        SupportSQLiteStatement r11 = this.f5740c.b();
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5738a.e();
        r11.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f5738a.D();     // Catch: Throwable -> L10
        this.f5738a.i();
        this.f5740c.h(r11);
        return;
    L10:
        th = move-exception;
        this.f5738a.i();
        this.f5740c.h(r11);
        throw th;
    L5:
        r11.bindString(1, r10);
        goto L6
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public List getTagsForWorkSpecId(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5738a.d();
        Cursor r12 = b0.b.c(this.f5738a, r11, false, null);
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

    @Override // androidx.work.impl.model.WorkTagDao
    public List getWorkSpecIdsWithTag(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT work_spec_id FROM worktag WHERE tag=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5738a.d();
        Cursor r12 = b0.b.c(this.f5738a, r11, false, null);
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

    @Override // androidx.work.impl.model.WorkTagDao
    public void insert(r r10) {
        this.f5738a.d();
        this.f5738a.e();
        this.f5739b.j(r10);     // Catch: Throwable -> L6
        this.f5738a.D();     // Catch: Throwable -> L6
        this.f5738a.i();
        return;
    L6:
        th = move-exception;
        this.f5738a.i();
        throw th;
    }

    @Override // androidx.work.impl.model.WorkTagDao
    public void insertTags(String r10, Set r11) {
        WorkTagDao.a.a(this, r10, r11);
    }
}
