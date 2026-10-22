package Z7;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.bugly.proguard.ab;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class W extends SQLiteOpenHelper {

    /* renamed from: c, reason: collision with root package name */
    public static String f7404c = "bugly_db";

    /* renamed from: d, reason: collision with root package name */
    public static int f7405d = 16;

    /* renamed from: a, reason: collision with root package name */
    public Context f7406a;

    /* renamed from: b, reason: collision with root package name */
    public List<N> f7407b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public W(Context context, List<N> list) {
        super(context, f7404c + "_", (SQLiteDatabase.CursorFactory) null, f7405d);
        C1130b.h(context).getClass();
        this.f7406a = context;
        this.f7407b = list;
    }

    public final synchronized boolean b(SQLiteDatabase sQLiteDatabase) {
        try {
            String[] strArr = {"t_lr", "t_ui", "t_pf"};
            for (int i10 = 0; i10 < 3; i10++) {
                sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ".concat(String.valueOf(strArr[i10])), new String[0]);
            }
        } catch (Throwable th) {
            if (!C1139k.g(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase readableDatabase;
        readableDatabase = null;
        int i10 = 0;
        while (readableDatabase == null && i10 < 5) {
            i10++;
            try {
                readableDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                C1139k.i("[Database] Try to get db(count: %d).", Integer.valueOf(i10));
                if (i10 == 5) {
                    C1139k.j("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
        }
        return readableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase writableDatabase;
        writableDatabase = null;
        int i10 = 0;
        while (writableDatabase == null && i10 < 5) {
            i10++;
            try {
                writableDatabase = super.getWritableDatabase();
            } catch (Throwable unused) {
                C1139k.i("[Database] Try to get db(count: %d).", Integer.valueOf(i10));
                if (i10 == 5) {
                    C1139k.j("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
        }
        if (writableDatabase == null) {
            C1139k.i("[Database] db error delay error record 1min.", new Object[0]);
        }
        return writableDatabase;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00e5 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00e7 A[Catch: all -> 0x00df, TRY_ENTER, TryCatch #2 {all -> 0x00df, blocks: (B:11:0x00e1, B:15:0x00e7, B:16:0x00eb, B:18:0x00f1, B:22:0x00fc, B:24:0x0102, B:6:0x00d5, B:8:0x00db, B:3:0x0001, B:19:0x00f7), top: B:30:0x0001, inners: #0, #1 }] */
    @Override // android.database.sqlite.SQLiteOpenHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void onCreate(android.database.sqlite.SQLiteDatabase r5) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z7.W.onCreate(android.database.sqlite.SQLiteDatabase):void");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public final synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        try {
            if (ab.e() >= 11) {
                C1139k.i("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i10), Integer.valueOf(i11));
                List<N> list = this.f7407b;
                if (list != null) {
                    Iterator<N> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            it.next().d(sQLiteDatabase, i10, i11);
                        } catch (Throwable th) {
                            if (!C1139k.g(th)) {
                                th.printStackTrace();
                            }
                        }
                    }
                }
                if (b(sQLiteDatabase)) {
                    onCreate(sQLiteDatabase);
                    return;
                }
                C1139k.i("[Database] Failed to drop, delete db.", new Object[0]);
                File databasePath = this.f7406a.getDatabasePath(f7404c);
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        try {
            C1139k.i("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i10), Integer.valueOf(i11));
            List<N> list = this.f7407b;
            if (list != null) {
                Iterator<N> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().e(sQLiteDatabase, i10, i11);
                    } catch (Throwable th) {
                        if (!C1139k.g(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (b(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
                return;
            }
            C1139k.i("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.f7406a.getDatabasePath(f7404c);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
