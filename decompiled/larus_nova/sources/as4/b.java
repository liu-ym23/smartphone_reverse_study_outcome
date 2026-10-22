package as4;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements as4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f16123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f16124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f16125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f16126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f16127e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g f16128f;

    public class a extends EntityInsertionAdapter<BitableResourceData> {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "INSERT OR REPLACE INTO `BitableResourceData` (`base_token`,`block_id`,`res_key`,`obj_token`,`view_id`,`res_value`,`rev1`,`rev2`,`extra`,`timestamp`,`delete_strategy`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        }

        public a(RoomDatabase r100) {
            super(r100);
        }

        @Override // androidx.room.EntityInsertionAdapter
        public final void bind(SupportSQLiteStatement r100, BitableResourceData r101) {
            BitableResourceData r102 = r101;
            if (r102.getBaseToken() != null) goto L5;
            r100.bindNull(1);
        L7:
            if (r102.getBlockId() != null) goto L9;
            r100.bindNull(2);
        L11:
            if (r102.getResKey() != null) goto L13;
            r100.bindNull(3);
        L15:
            if (r102.getObjToken() != null) goto L17;
            r100.bindNull(4);
        L19:
            if (r102.getViewId() != null) goto L21;
            r100.bindNull(5);
        L23:
            if (r102.getResValue() != null) goto L25;
            r100.bindNull(6);
        L27:
            if (r102.getRev1() != null) goto L29;
            r100.bindNull(7);
        L31:
            if (r102.getRev2() != null) goto L33;
            r100.bindNull(8);
        L35:
            if (r102.getExtra() != null) goto L37;
            r100.bindNull(9);
        L39:
            if (r102.getTimestamp() != null) goto L41;
            r100.bindNull(10);
        L43:
            if (r102.getDeleteStrategy() != null) goto L45;
            r100.bindNull(11);
            return;
        L45:
            r100.bindLong(11, r102.getDeleteStrategy().intValue());
            return;
        L41:
            r100.bindLong(10, r102.getTimestamp().longValue());
            goto L43
        L37:
            r100.bindString(9, r102.getExtra());
            goto L39
        L33:
            r100.bindLong(8, r102.getRev2().intValue());
            goto L35
        L29:
            r100.bindLong(7, r102.getRev1().intValue());
            goto L31
        L25:
            r100.bindString(6, r102.getResValue());
            goto L27
        L21:
            r100.bindString(5, r102.getViewId());
            goto L23
        L17:
            r100.bindString(4, r102.getObjToken());
            goto L19
        L13:
            r100.bindString(3, r102.getResKey());
            goto L15
        L9:
            r100.bindString(2, r102.getBlockId());
            goto L11
        L5:
            r100.bindString(1, r102.getBaseToken());
            goto L7
        }
    }

    /* JADX INFO: renamed from: as4.b$b, reason: collision with other inner class name */
    public class C0218b extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "UPDATE BitableResourceData SET timestamp = ?  WHERE base_token=? and block_id= ? and res_key = ? and obj_token = ?";
        }

        public C0218b(RoomDatabase r100) {
            super(r100);
        }
    }

    public class c extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM BitableResourceData WHERE base_token= ?";
        }

        public c(RoomDatabase r100) {
            super(r100);
        }
    }

    public class d extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM BitableResourceData WHERE base_token= ? and res_key = ?";
        }

        public d(RoomDatabase r100) {
            super(r100);
        }
    }

    public class e extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM BitableResourceData WHERE base_token=? and block_id= ? and res_key = ? and obj_token = ?";
        }

        public e(RoomDatabase r100) {
            super(r100);
        }
    }

    public class f extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM BitableResourceData WHERE timestamp < ? and delete_strategy = ?";
        }

        public f(RoomDatabase r100) {
            super(r100);
        }
    }

    public class g extends SharedSQLiteStatement {
        @Override // androidx.room.SharedSQLiteStatement
        public final String createQuery() {
            return "DELETE FROM BitableResourceData WHERE timestamp < ? and res_key LIKE '%' || ? || '%'";
        }

        public g(RoomDatabase r100) {
            super(r100);
        }
    }

    public final List<String> d() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT base_token FROM BitableResourceData group by base_token", 0);
        this.f16123a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f16123a, r100, false, null);
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

    public b(RoomDatabase r100) {
        this.f16123a = r100;
        this.f16124b = new a(r100);
        new C0218b(r100);
        this.f16125c = new c(r100);
        new d(r100);
        this.f16126d = new e(r100);
        this.f16127e = new f(r100);
        this.f16128f = new g(r100);
    }

    public final int a(String r100) {
        this.f16123a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f16125c.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f16123a.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f16123a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f16123a.endTransaction();
        this.f16125c.release(r101);
        return r102;
    L10:
        th = move-exception;
        this.f16123a.endTransaction();
        this.f16125c.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    public final int c(Long r100, int r101) {
        this.f16123a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r102 = this.f16127e.acquire();
        if (r100 != null) goto L5;
        r102.bindNull(1);
    L6:
        r102.bindLong(2, r101);
        this.f16123a.beginTransaction();
        int r103 = r102.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f16123a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f16123a.endTransaction();
        this.f16127e.release(r102);
        return r103;
    L10:
        th = move-exception;
        this.f16123a.endTransaction();
        this.f16127e.release(r102);
        throw th;
    L5:
        r102.bindLong(1, r100.longValue());
        goto L6
    }

    public final int b(String r100, String r101, String r102, String r103) {
        this.f16123a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r104 = this.f16126d.acquire();
        r104.bindString(1, r100);
        r104.bindString(2, r101);
        r104.bindString(3, r102);
        r104.bindString(4, r103);
        this.f16123a.beginTransaction();
        int r105 = r104.executeUpdateDelete();     // Catch: Throwable -> L6
        this.f16123a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f16123a.endTransaction();
        this.f16126d.release(r104);
        return r105;
    L6:
        th = move-exception;
        this.f16123a.endTransaction();
        this.f16126d.release(r104);
        throw th;
    }
}
