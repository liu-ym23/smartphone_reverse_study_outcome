package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class k implements WorkNameDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f5655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.room.j f5656b;

    public class a extends androidx.room.j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ k f5657d;

        public a(k r10, RoomDatabase r11) {
            this.f5657d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
        }

        @Override // androidx.room.j
        public /* bridge */ /* synthetic */ void i(SupportSQLiteStatement r10, Object r11) {
            l(r10, (j) r11);
        }

        public void l(SupportSQLiteStatement r10, j r11) {
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

    public k(RoomDatabase r10) {
        this.f5655a = r10;
        this.f5656b = new a(this, r10);
    }

    public static List a() {
        return Collections.emptyList();
    }

    @Override // androidx.work.impl.model.WorkNameDao
    public List getNamesForWorkSpecId(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5655a.d();
        Cursor r12 = b0.b.c(this.f5655a, r11, false, null);
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

    @Override // androidx.work.impl.model.WorkNameDao
    public List getWorkSpecIdsWithName(String r10) {
        RoomSQLiteQuery r11 = RoomSQLiteQuery.a("SELECT work_spec_id FROM workname WHERE name=?", 1);
        if (r10 != null) goto L5;
        r11.bindNull(1);
    L6:
        this.f5655a.d();
        Cursor r12 = b0.b.c(this.f5655a, r11, false, null);
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

    @Override // androidx.work.impl.model.WorkNameDao
    public void insert(j r10) {
        this.f5655a.d();
        this.f5655a.e();
        this.f5656b.j(r10);     // Catch: Throwable -> L6
        this.f5655a.D();     // Catch: Throwable -> L6
        this.f5655a.i();
        return;
    L6:
        th = move-exception;
        this.f5655a.i();
        throw th;
    }
}
