package aj5;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.middleground.unbundle.cache.db.BenefitDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f3929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f3930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f3931c;

    public final List<a> a() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM BenefitData ORDER BY update_time DESC LIMIT 100", 0);
        this.f3929a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f3929a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "cache_key");     // Catch: Throwable -> L14
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "owner_id");     // Catch: Throwable -> L14
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "source_benefit");     // Catch: Throwable -> L14
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "update_time");     // Catch: Throwable -> L14
        ArrayList r106 = new ArrayList(r101.getCount());     // Catch: Throwable -> L14
    L4:
        if (r101.moveToNext() == false) goto L12;
        a r107 = new a();     // Catch: Throwable -> L14
        r107.f3925a = r101.getString(r102);     // Catch: Throwable -> L14
        r107.f3926b = r101.getString(r103);     // Catch: Throwable -> L14
        r107.f3927c = r101.getString(r104);     // Catch: Throwable -> L14
        if (r101.isNull(r105) == false) goto L9;
        Long r108 = null;
    L10:
        r107.f3928d = r108;     // Catch: Throwable -> L14
        r106.add(r107);     // Catch: Throwable -> L14
        goto L4
    L9:
        r108 = Long.valueOf(r101.getLong(r105));     // Catch: Throwable -> L14
        goto L10
    L12:
        r101.close();
        r100.release();
        return r106;
    L14:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    }

    public final int b() {
        this.f3929a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r100 = this.f3931c.acquire();
        this.f3929a.beginTransaction();
        int r101 = r100.executeUpdateDelete();     // Catch: Throwable -> L6
        this.f3929a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f3929a.endTransaction();
        this.f3931c.release(r100);
        return r101;
    L6:
        th = move-exception;
        this.f3929a.endTransaction();
        this.f3931c.release(r100);
        throw th;
    }

    public e(BenefitDatabase r100) {
        this.f3929a = r100;
        this.f3930b = new c(r100);
        this.f3931c = new d(r100);
    }
}
