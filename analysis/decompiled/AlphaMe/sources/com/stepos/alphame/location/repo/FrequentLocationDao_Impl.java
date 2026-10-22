package com.stepos.alphame.location.repo;

import Z2.I;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.A;
import androidx.room.E;
import androidx.room.G;
import androidx.room.j;
import androidx.room.k;
import com.stepos.alphame.app.AppEventDataItem;
import com.stepos.alphame.location.FrequentLocation;
import com.stepos.alphame.suggest.AppSuggestStorable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import t0.J;

/* loaded from: classes.dex */
public final class FrequentLocationDao_Impl implements FrequentLocationDao {
    private final A __db;
    private final j __deletionAdapterOfFrequentLocation;
    private final k __insertionAdapterOfFrequentLocation;
    private final LocationConverters __locationConverters = new LocationConverters();
    private final G __preparedStmtOfDeleteAllFrequentLocation;
    private final j __updateAdapterOfFrequentLocation;

    public FrequentLocationDao_Impl(@NonNull A a4) {
        this.__db = a4;
        this.__insertionAdapterOfFrequentLocation = new k(a4) { // from class: com.stepos.alphame.location.repo.FrequentLocationDao_Impl.1
            @Override // androidx.room.G
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `frequent_location` (`id`,`longitude`,`latitude`,`frequency`,`address`,`country`,`province`,`city`,`district`,`total`,`home`,`company`,`last_arrival_time`,`stay_duration`,`day_time_stay_duration`,`frequent_wifi_list`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.k
            public void bind(@NonNull k0.j jVar, @NonNull FrequentLocation frequentLocation) {
                jVar.bindLong(1, frequentLocation.getId());
                jVar.bindString(2, frequentLocation.getLongitude());
                jVar.bindString(3, frequentLocation.getLatitude());
                jVar.bindDouble(4, frequentLocation.getFrequency());
                jVar.bindString(5, frequentLocation.getAddress());
                jVar.bindString(6, frequentLocation.getCountry());
                jVar.bindString(7, frequentLocation.getProvince());
                jVar.bindString(8, frequentLocation.getCity());
                jVar.bindString(9, frequentLocation.getDistrict());
                jVar.bindLong(10, frequentLocation.getTotal());
                jVar.bindDouble(11, frequentLocation.home);
                jVar.bindDouble(12, frequentLocation.company);
                jVar.bindLong(13, frequentLocation.getLastArrivalTime());
                jVar.bindLong(14, frequentLocation.getStayDuration());
                jVar.bindLong(15, frequentLocation.getDayTimeStayDuration());
                jVar.bindString(16, FrequentLocationDao_Impl.this.__locationConverters.objectToString(frequentLocation.getFrequentWifiList()));
            }
        };
        this.__deletionAdapterOfFrequentLocation = new j(a4) { // from class: com.stepos.alphame.location.repo.FrequentLocationDao_Impl.2
            @Override // androidx.room.G
            @NonNull
            public String createQuery() {
                return "DELETE FROM `frequent_location` WHERE `id` = ?";
            }

            @Override // androidx.room.j
            public void bind(@NonNull k0.j jVar, @NonNull FrequentLocation frequentLocation) {
                jVar.bindLong(1, frequentLocation.getId());
            }
        };
        this.__updateAdapterOfFrequentLocation = new j(a4) { // from class: com.stepos.alphame.location.repo.FrequentLocationDao_Impl.3
            @Override // androidx.room.G
            @NonNull
            public String createQuery() {
                return "UPDATE OR REPLACE `frequent_location` SET `id` = ?,`longitude` = ?,`latitude` = ?,`frequency` = ?,`address` = ?,`country` = ?,`province` = ?,`city` = ?,`district` = ?,`total` = ?,`home` = ?,`company` = ?,`last_arrival_time` = ?,`stay_duration` = ?,`day_time_stay_duration` = ?,`frequent_wifi_list` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.j
            public void bind(@NonNull k0.j jVar, @NonNull FrequentLocation frequentLocation) {
                jVar.bindLong(1, frequentLocation.getId());
                jVar.bindString(2, frequentLocation.getLongitude());
                jVar.bindString(3, frequentLocation.getLatitude());
                jVar.bindDouble(4, frequentLocation.getFrequency());
                jVar.bindString(5, frequentLocation.getAddress());
                jVar.bindString(6, frequentLocation.getCountry());
                jVar.bindString(7, frequentLocation.getProvince());
                jVar.bindString(8, frequentLocation.getCity());
                jVar.bindString(9, frequentLocation.getDistrict());
                jVar.bindLong(10, frequentLocation.getTotal());
                jVar.bindDouble(11, frequentLocation.home);
                jVar.bindDouble(12, frequentLocation.company);
                jVar.bindLong(13, frequentLocation.getLastArrivalTime());
                jVar.bindLong(14, frequentLocation.getStayDuration());
                jVar.bindLong(15, frequentLocation.getDayTimeStayDuration());
                jVar.bindString(16, FrequentLocationDao_Impl.this.__locationConverters.objectToString(frequentLocation.getFrequentWifiList()));
                jVar.bindLong(17, frequentLocation.getId());
            }
        };
        this.__preparedStmtOfDeleteAllFrequentLocation = new G(a4) { // from class: com.stepos.alphame.location.repo.FrequentLocationDao_Impl.4
            @Override // androidx.room.G
            @NonNull
            public String createQuery() {
                return "DELETE FROM frequent_location";
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.stepos.alphame.location.repo.FrequentLocationDao
    public void deleteAllFrequentLocation() {
        this.__db.assertNotSuspendingTransaction();
        k0.j jVarAcquire = this.__preparedStmtOfDeleteAllFrequentLocation.acquire();
        try {
            this.__db.beginTransaction();
            try {
                jVarAcquire.executeUpdateDelete();
                this.__db.setTransactionSuccessful();
            } finally {
                this.__db.endTransaction();
            }
        } finally {
            this.__preparedStmtOfDeleteAllFrequentLocation.release(jVarAcquire);
        }
    }

    @Override // com.stepos.alphame.location.repo.FrequentLocationDao
    public void deleteFrequentLocation(FrequentLocation frequentLocation) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfFrequentLocation.handle(frequentLocation);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.stepos.alphame.location.repo.FrequentLocationDao
    public List<FrequentLocation> getFrequentLocationList() throws Throwable {
        E e4;
        int iN;
        int iN2;
        int iN3;
        int iN4;
        int iN5;
        int iN6;
        int iN7;
        int iN8;
        int iN9;
        int iN10;
        int iN11;
        int iN12;
        int iN13;
        E eD = E.d(0, "SELECT * FROM frequent_location ORDER BY id ASC");
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(this.__db, eD);
        try {
            iN = I.n(cursorH, "id");
            iN2 = I.n(cursorH, AppSuggestStorable.COLUMN_LONGITUDE);
            iN3 = I.n(cursorH, AppSuggestStorable.COLUMN_LATITUDE);
            iN4 = I.n(cursorH, "frequency");
            iN5 = I.n(cursorH, "address");
            iN6 = I.n(cursorH, "country");
            iN7 = I.n(cursorH, "province");
            iN8 = I.n(cursorH, "city");
            iN9 = I.n(cursorH, "district");
            iN10 = I.n(cursorH, "total");
            iN11 = I.n(cursorH, AppEventDataItem.APP_HOME);
            iN12 = I.n(cursorH, "company");
            iN13 = I.n(cursorH, "last_arrival_time");
            e4 = eD;
        } catch (Throwable th) {
            th = th;
            e4 = eD;
        }
        try {
            int iN14 = I.n(cursorH, "stay_duration");
            int iN15 = I.n(cursorH, "day_time_stay_duration");
            int iN16 = I.n(cursorH, "frequent_wifi_list");
            int i4 = iN14;
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (cursorH.moveToNext()) {
                FrequentLocation frequentLocation = new FrequentLocation();
                ArrayList arrayList2 = arrayList;
                frequentLocation.setId(cursorH.getInt(iN));
                frequentLocation.setLongitude(cursorH.getString(iN2));
                frequentLocation.setLatitude(cursorH.getString(iN3));
                frequentLocation.setFrequency(cursorH.getFloat(iN4));
                frequentLocation.setAddress(cursorH.getString(iN5));
                frequentLocation.setCountry(cursorH.getString(iN6));
                frequentLocation.setProvince(cursorH.getString(iN7));
                frequentLocation.setCity(cursorH.getString(iN8));
                frequentLocation.setDistrict(cursorH.getString(iN9));
                frequentLocation.setTotal(cursorH.getInt(iN10));
                frequentLocation.home = cursorH.getFloat(iN11);
                frequentLocation.company = cursorH.getFloat(iN12);
                int i5 = iN;
                int i6 = iN2;
                frequentLocation.setLastArrivalTime(cursorH.getLong(iN13));
                int i7 = i4;
                int i8 = iN3;
                frequentLocation.setStayDuration(cursorH.getLong(i7));
                int i9 = iN15;
                int i10 = iN4;
                frequentLocation.setDayTimeStayDuration(cursorH.getLong(i9));
                int i11 = iN16;
                frequentLocation.setFrequentWifiList(this.__locationConverters.stringToObject(cursorH.getString(i11)));
                arrayList2.add(frequentLocation);
                arrayList = arrayList2;
                iN4 = i10;
                iN = i5;
                iN15 = i9;
                iN16 = i11;
                iN3 = i8;
                iN2 = i6;
                i4 = i7;
            }
            ArrayList arrayList3 = arrayList;
            cursorH.close();
            e4.e();
            return arrayList3;
        } catch (Throwable th2) {
            th = th2;
            cursorH.close();
            e4.e();
            throw th;
        }
    }

    @Override // com.stepos.alphame.location.repo.FrequentLocationDao
    public void insertFrequentLocation(FrequentLocation frequentLocation) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfFrequentLocation.insert(frequentLocation);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.stepos.alphame.location.repo.FrequentLocationDao
    public void updateFrequentLocation(FrequentLocation frequentLocation) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfFrequentLocation.handle(frequentLocation);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
