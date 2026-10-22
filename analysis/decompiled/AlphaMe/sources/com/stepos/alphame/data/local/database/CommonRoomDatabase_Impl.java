package com.stepos.alphame.data.local.database;

import androidx.annotation.NonNull;
import androidx.room.A;
import androidx.room.B;
import androidx.room.C;
import androidx.room.C0353i;
import androidx.room.D;
import androidx.room.r;
import com.stepos.alphame.data.DataContractKt;
import com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao;
import com.stepos.alphame.data.local.database.dailyusage.DailyUsageDao_Impl;
import h0.AbstractC0587a;
import i0.b;
import i0.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k0.C0676d;
import k0.InterfaceC0674b;
import k0.g;
import kotlin.jvm.internal.Intrinsics;
import t0.C0916b;
import t0.J;

/* loaded from: classes.dex */
public final class CommonRoomDatabase_Impl extends CommonRoomDatabase {
    private volatile DailyUsageDao _dailyUsageDao;

    @Override // androidx.room.A
    public void clearAllTables() {
        super.assertNotMainThread();
        InterfaceC0674b writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `daily_usage`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.A
    @NonNull
    public r createInvalidationTracker() {
        return new r(this, new HashMap(0), new HashMap(0), DataContractKt.DAILY_USAGE_FILE_NAME);
    }

    @Override // androidx.room.A
    @NonNull
    public g createOpenHelper(@NonNull C0353i c0353i) {
        D callback = new D(c0353i, new B(2) { // from class: com.stepos.alphame.data.local.database.CommonRoomDatabase_Impl.1
            @Override // androidx.room.B
            public void createAllTables(@NonNull InterfaceC0674b interfaceC0674b) {
                interfaceC0674b.execSQL("CREATE TABLE IF NOT EXISTS `daily_usage` (`id` TEXT NOT NULL, `date` INTEGER NOT NULL, `mode` INTEGER NOT NULL, `user_id` INTEGER NOT NULL, `time_usage_path` TEXT, `screen_usage_path` TEXT, `notification_usage_path` TEXT, PRIMARY KEY(`id`))");
                interfaceC0674b.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                interfaceC0674b.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '09dc2be0e308847f7f8212881a155c48')");
            }

            @Override // androidx.room.B
            public void dropAllTables(@NonNull InterfaceC0674b db) {
                db.execSQL("DROP TABLE IF EXISTS `daily_usage`");
                List list = ((A) CommonRoomDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((C0916b) it.next()).getClass();
                        Intrinsics.checkNotNullParameter(db, "db");
                    }
                }
            }

            @Override // androidx.room.B
            public void onCreate(@NonNull InterfaceC0674b db) {
                List list = ((A) CommonRoomDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((C0916b) it.next()).getClass();
                        Intrinsics.checkNotNullParameter(db, "db");
                    }
                }
            }

            @Override // androidx.room.B
            public void onOpen(@NonNull InterfaceC0674b interfaceC0674b) {
                ((A) CommonRoomDatabase_Impl.this).mDatabase = interfaceC0674b;
                CommonRoomDatabase_Impl.this.internalInitInvalidationTracker(interfaceC0674b);
                List list = ((A) CommonRoomDatabase_Impl.this).mCallbacks;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((C0916b) it.next()).a(interfaceC0674b);
                    }
                }
            }

            @Override // androidx.room.B
            public void onPostMigrate(@NonNull InterfaceC0674b interfaceC0674b) {
            }

            @Override // androidx.room.B
            public void onPreMigrate(@NonNull InterfaceC0674b interfaceC0674b) {
                J.u(interfaceC0674b);
            }

            @Override // androidx.room.B
            @NonNull
            public C onValidateSchema(@NonNull InterfaceC0674b interfaceC0674b) {
                HashMap map = new HashMap(7);
                map.put("id", new b("id", "TEXT", true, 1, null, 1));
                map.put("date", new b("date", "INTEGER", true, 0, null, 1));
                map.put("mode", new b("mode", "INTEGER", true, 0, null, 1));
                map.put("user_id", new b("user_id", "INTEGER", true, 0, null, 1));
                map.put("time_usage_path", new b("time_usage_path", "TEXT", false, 0, null, 1));
                map.put("screen_usage_path", new b("screen_usage_path", "TEXT", false, 0, null, 1));
                map.put("notification_usage_path", new b("notification_usage_path", "TEXT", false, 0, null, 1));
                f fVar = new f(DataContractKt.DAILY_USAGE_FILE_NAME, map, new HashSet(0), new HashSet(0));
                f fVarA = f.a(interfaceC0674b, DataContractKt.DAILY_USAGE_FILE_NAME);
                if (fVar.equals(fVarA)) {
                    return new C(true, null);
                }
                return new C(false, "daily_usage(com.stepos.alphame.data.model.dailyusage.DailyUsageEntity).\n Expected:\n" + fVar + "\n Found:\n" + fVarA);
            }
        }, "09dc2be0e308847f7f8212881a155c48", "cc87664931c50a26117e0bb631c54663");
        C0676d c0676dD = E3.b.d(c0353i.f4205a);
        c0676dD.f13323b = c0353i.f4206b;
        Intrinsics.checkNotNullParameter(callback, "callback");
        c0676dD.f13324c = callback;
        return c0353i.f4207c.create(c0676dD.a());
    }

    @Override // androidx.room.A
    @NonNull
    public List<AbstractC0587a> getAutoMigrations(@NonNull Map<Class<Object>, Object> map) {
        return new ArrayList();
    }

    @Override // com.stepos.alphame.data.local.database.CommonRoomDatabase
    public DailyUsageDao getDailyUsageDao() {
        DailyUsageDao dailyUsageDao;
        if (this._dailyUsageDao != null) {
            return this._dailyUsageDao;
        }
        synchronized (this) {
            try {
                if (this._dailyUsageDao == null) {
                    this._dailyUsageDao = new DailyUsageDao_Impl(this);
                }
                dailyUsageDao = this._dailyUsageDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dailyUsageDao;
    }

    @Override // androidx.room.A
    @NonNull
    public Set<Class<Object>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.A
    @NonNull
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(DailyUsageDao.class, DailyUsageDao_Impl.getRequiredConverters());
        return map;
    }
}
