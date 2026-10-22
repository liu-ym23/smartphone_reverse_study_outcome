package com.stepos.alphame.database;

import androidx.annotation.NonNull;
import androidx.room.A;
import androidx.room.B;
import androidx.room.C;
import androidx.room.C0353i;
import androidx.room.D;
import androidx.room.r;
import com.stepos.alphame.app.AppEventDataItem;
import com.stepos.alphame.location.repo.FrequentLocationDao;
import com.stepos.alphame.location.repo.FrequentLocationDao_Impl;
import com.stepos.alphame.persona.address.data.HistoryAddressDao;
import com.stepos.alphame.persona.address.data.HistoryAddressDao_Impl;
import com.stepos.alphame.suggest.AppSuggestStorable;
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
public final class EngineRoomDatabase_Impl extends EngineRoomDatabase {
    private volatile FrequentLocationDao _frequentLocationDao;
    private volatile HistoryAddressDao _historyAddressDao;

    @Override // androidx.room.A
    public void clearAllTables() {
        super.assertNotMainThread();
        InterfaceC0674b writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `frequent_location`");
            writableDatabase.execSQL("DELETE FROM `history_address`");
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
        return new r(this, new HashMap(0), new HashMap(0), "frequent_location", "history_address");
    }

    @Override // androidx.room.A
    @NonNull
    public g createOpenHelper(@NonNull C0353i c0353i) {
        D callback = new D(c0353i, new B(2) { // from class: com.stepos.alphame.database.EngineRoomDatabase_Impl.1
            @Override // androidx.room.B
            public void createAllTables(@NonNull InterfaceC0674b interfaceC0674b) {
                interfaceC0674b.execSQL("CREATE TABLE IF NOT EXISTS `frequent_location` (`id` INTEGER NOT NULL, `longitude` TEXT, `latitude` TEXT, `frequency` REAL NOT NULL, `address` TEXT, `country` TEXT, `province` TEXT, `city` TEXT, `district` TEXT, `total` INTEGER NOT NULL, `home` REAL NOT NULL, `company` REAL NOT NULL, `last_arrival_time` INTEGER NOT NULL, `stay_duration` INTEGER NOT NULL, `day_time_stay_duration` INTEGER NOT NULL, `frequent_wifi_list` TEXT, PRIMARY KEY(`id`))");
                interfaceC0674b.execSQL("CREATE TABLE IF NOT EXISTS `history_address` (`address_name` TEXT NOT NULL, `district` TEXT NOT NULL, `longitude` REAL NOT NULL, `latitude` REAL NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `update_time` INTEGER NOT NULL)");
                interfaceC0674b.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                interfaceC0674b.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3ed20e224a1276086d71cf22a8282bd8')");
            }

            @Override // androidx.room.B
            public void dropAllTables(@NonNull InterfaceC0674b db) {
                db.execSQL("DROP TABLE IF EXISTS `frequent_location`");
                db.execSQL("DROP TABLE IF EXISTS `history_address`");
                List list = ((A) EngineRoomDatabase_Impl.this).mCallbacks;
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
                List list = ((A) EngineRoomDatabase_Impl.this).mCallbacks;
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
                ((A) EngineRoomDatabase_Impl.this).mDatabase = interfaceC0674b;
                EngineRoomDatabase_Impl.this.internalInitInvalidationTracker(interfaceC0674b);
                List list = ((A) EngineRoomDatabase_Impl.this).mCallbacks;
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
                HashMap map = new HashMap(16);
                map.put("id", new b("id", "INTEGER", true, 1, null, 1));
                map.put(AppSuggestStorable.COLUMN_LONGITUDE, new b(AppSuggestStorable.COLUMN_LONGITUDE, "TEXT", false, 0, null, 1));
                map.put(AppSuggestStorable.COLUMN_LATITUDE, new b(AppSuggestStorable.COLUMN_LATITUDE, "TEXT", false, 0, null, 1));
                map.put("frequency", new b("frequency", "REAL", true, 0, null, 1));
                map.put("address", new b("address", "TEXT", false, 0, null, 1));
                map.put("country", new b("country", "TEXT", false, 0, null, 1));
                map.put("province", new b("province", "TEXT", false, 0, null, 1));
                map.put("city", new b("city", "TEXT", false, 0, null, 1));
                map.put("district", new b("district", "TEXT", false, 0, null, 1));
                map.put("total", new b("total", "INTEGER", true, 0, null, 1));
                map.put(AppEventDataItem.APP_HOME, new b(AppEventDataItem.APP_HOME, "REAL", true, 0, null, 1));
                map.put("company", new b("company", "REAL", true, 0, null, 1));
                map.put("last_arrival_time", new b("last_arrival_time", "INTEGER", true, 0, null, 1));
                map.put("stay_duration", new b("stay_duration", "INTEGER", true, 0, null, 1));
                map.put("day_time_stay_duration", new b("day_time_stay_duration", "INTEGER", true, 0, null, 1));
                map.put("frequent_wifi_list", new b("frequent_wifi_list", "TEXT", false, 0, null, 1));
                f fVar = new f("frequent_location", map, new HashSet(0), new HashSet(0));
                f fVarA = f.a(interfaceC0674b, "frequent_location");
                if (!fVar.equals(fVarA)) {
                    return new C(false, "frequent_location(com.stepos.alphame.location.FrequentLocation).\n Expected:\n" + fVar + "\n Found:\n" + fVarA);
                }
                HashMap map2 = new HashMap(6);
                map2.put("address_name", new b("address_name", "TEXT", true, 0, null, 1));
                map2.put("district", new b("district", "TEXT", true, 0, null, 1));
                map2.put(AppSuggestStorable.COLUMN_LONGITUDE, new b(AppSuggestStorable.COLUMN_LONGITUDE, "REAL", true, 0, null, 1));
                map2.put(AppSuggestStorable.COLUMN_LATITUDE, new b(AppSuggestStorable.COLUMN_LATITUDE, "REAL", true, 0, null, 1));
                map2.put("id", new b("id", "INTEGER", true, 1, null, 1));
                map2.put("update_time", new b("update_time", "INTEGER", true, 0, null, 1));
                f fVar2 = new f("history_address", map2, new HashSet(0), new HashSet(0));
                f fVarA2 = f.a(interfaceC0674b, "history_address");
                if (fVar2.equals(fVarA2)) {
                    return new C(true, null);
                }
                return new C(false, "history_address(com.stepos.alphame.persona.address.data.AddressEntity).\n Expected:\n" + fVar2 + "\n Found:\n" + fVarA2);
            }
        }, "3ed20e224a1276086d71cf22a8282bd8", "34815d4da9c92a596ec0a87e073a62d5");
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

    @Override // com.stepos.alphame.database.EngineRoomDatabase
    public FrequentLocationDao getFrequentLocationDao() {
        FrequentLocationDao frequentLocationDao;
        if (this._frequentLocationDao != null) {
            return this._frequentLocationDao;
        }
        synchronized (this) {
            try {
                if (this._frequentLocationDao == null) {
                    this._frequentLocationDao = new FrequentLocationDao_Impl(this);
                }
                frequentLocationDao = this._frequentLocationDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return frequentLocationDao;
    }

    @Override // com.stepos.alphame.database.EngineRoomDatabase
    public HistoryAddressDao getHistoryAddressDao() {
        HistoryAddressDao historyAddressDao;
        if (this._historyAddressDao != null) {
            return this._historyAddressDao;
        }
        synchronized (this) {
            try {
                if (this._historyAddressDao == null) {
                    this._historyAddressDao = new HistoryAddressDao_Impl(this);
                }
                historyAddressDao = this._historyAddressDao;
            } catch (Throwable th) {
                throw th;
            }
        }
        return historyAddressDao;
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
        map.put(FrequentLocationDao.class, FrequentLocationDao_Impl.getRequiredConverters());
        map.put(HistoryAddressDao.class, HistoryAddressDao_Impl.getRequiredConverters());
        return map;
    }
}
