package ck5;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.notification.db.NotificationDatabase;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f24037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f24038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f24039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f24040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f24041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f24042f;

    public final int a() {
        this.f24037a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r100 = this.f24040d.acquire();
        this.f24037a.beginTransaction();
        int r101 = r100.executeUpdateDelete();     // Catch: Throwable -> L6
        this.f24037a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f24037a.endTransaction();
        this.f24040d.release(r100);
        return r101;
    L6:
        th = move-exception;
        this.f24037a.endTransaction();
        this.f24040d.release(r100);
        throw th;
    }

    public final List<String> c() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT id FROM Notification WHERE close = 1", 0);
        this.f24037a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f24037a, r100, false, null);
        ArrayList r102 = new ArrayList(r101.getCount());     // Catch: Throwable -> L10
    L5:
        if (r101.moveToNext() == false) goto L8;
        r102.add(r101.getString(0));     // Catch: Throwable -> L10
        goto L5
    L8:
        r101.close();
        r100.release();
        return r102;
    L10:
        th = move-exception;
        r101.close();
        r100.release();
        throw th;
    }

    public h(NotificationDatabase r100) {
        this.f24039c = new a();
        this.f24037a = r100;
        this.f24038b = new c(this, r100);
        this.f24040d = new d(r100);
        this.f24041e = new e(r100);
        this.f24042f = new f(r100);
    }

    public final void b(String r100) {
        this.f24037a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f24041e.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f24037a.beginTransaction();
        r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f24037a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f24037a.endTransaction();
        this.f24041e.release(r101);
        return;
    L10:
        th = move-exception;
        this.f24037a.endTransaction();
        this.f24041e.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    public final int d(String r100) {
        this.f24037a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f24042f.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f24037a.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f24037a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f24037a.endTransaction();
        this.f24042f.release(r101);
        return r102;
    L10:
        th = move-exception;
        this.f24037a.endTransaction();
        this.f24042f.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }
}
