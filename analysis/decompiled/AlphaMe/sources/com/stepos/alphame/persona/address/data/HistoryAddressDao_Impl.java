package com.stepos.alphame.persona.address.data;

import Z2.I;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.A;
import androidx.room.E;
import androidx.room.j;
import androidx.room.k;
import com.stepos.alphame.suggest.AppSuggestStorable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import t0.J;

/* loaded from: classes.dex */
public final class HistoryAddressDao_Impl implements HistoryAddressDao {
    private final A __db;
    private final k __insertionAdapterOfAddressEntity;
    private final j __updateAdapterOfAddressEntity;

    public HistoryAddressDao_Impl(@NonNull A a4) {
        this.__db = a4;
        this.__insertionAdapterOfAddressEntity = new k(a4) { // from class: com.stepos.alphame.persona.address.data.HistoryAddressDao_Impl.1
            @Override // androidx.room.G
            @NonNull
            public String createQuery() {
                return "INSERT OR REPLACE INTO `history_address` (`address_name`,`district`,`longitude`,`latitude`,`id`,`update_time`) VALUES (?,?,?,?,nullif(?, 0),?)";
            }

            @Override // androidx.room.k
            public void bind(@NonNull k0.j jVar, @NonNull AddressEntity addressEntity) {
                jVar.bindString(1, addressEntity.getName());
                jVar.bindString(2, addressEntity.getDistrict());
                jVar.bindDouble(3, addressEntity.getLongitude());
                jVar.bindDouble(4, addressEntity.getLatitude());
                jVar.bindLong(5, addressEntity.getId());
                jVar.bindLong(6, addressEntity.getUpdateTime());
            }
        };
        this.__updateAdapterOfAddressEntity = new j(a4) { // from class: com.stepos.alphame.persona.address.data.HistoryAddressDao_Impl.2
            @Override // androidx.room.G
            @NonNull
            public String createQuery() {
                return "UPDATE OR REPLACE `history_address` SET `address_name` = ?,`district` = ?,`longitude` = ?,`latitude` = ?,`id` = ?,`update_time` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.j
            public void bind(@NonNull k0.j jVar, @NonNull AddressEntity addressEntity) {
                jVar.bindString(1, addressEntity.getName());
                jVar.bindString(2, addressEntity.getDistrict());
                jVar.bindDouble(3, addressEntity.getLongitude());
                jVar.bindDouble(4, addressEntity.getLatitude());
                jVar.bindLong(5, addressEntity.getId());
                jVar.bindLong(6, addressEntity.getUpdateTime());
                jVar.bindLong(7, addressEntity.getId());
            }
        };
    }

    @NonNull
    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // com.stepos.alphame.persona.address.data.HistoryAddressDao
    public List<AddressEntity> getHistoryAddressList() {
        E eD = E.d(0, "SELECT * FROM history_address ORDER BY update_time DESC LIMIT 5");
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorH = J.H(this.__db, eD);
        try {
            int iN = I.n(cursorH, "address_name");
            int iN2 = I.n(cursorH, "district");
            int iN3 = I.n(cursorH, AppSuggestStorable.COLUMN_LONGITUDE);
            int iN4 = I.n(cursorH, AppSuggestStorable.COLUMN_LATITUDE);
            int iN5 = I.n(cursorH, "id");
            int iN6 = I.n(cursorH, "update_time");
            ArrayList arrayList = new ArrayList(cursorH.getCount());
            while (cursorH.moveToNext()) {
                AddressEntity addressEntity = new AddressEntity();
                addressEntity.setName(cursorH.getString(iN));
                addressEntity.setDistrict(cursorH.getString(iN2));
                addressEntity.setLongitude(cursorH.getDouble(iN3));
                addressEntity.setLatitude(cursorH.getDouble(iN4));
                addressEntity.setId(cursorH.getInt(iN5));
                addressEntity.setUpdateTime(cursorH.getLong(iN6));
                arrayList.add(addressEntity);
            }
            return arrayList;
        } finally {
            cursorH.close();
            eD.e();
        }
    }

    @Override // com.stepos.alphame.persona.address.data.HistoryAddressDao
    public void insertAddress(AddressEntity addressEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAddressEntity.insert(addressEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.stepos.alphame.persona.address.data.HistoryAddressDao
    public void updateAddress(AddressEntity addressEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfAddressEntity.handle(addressEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
