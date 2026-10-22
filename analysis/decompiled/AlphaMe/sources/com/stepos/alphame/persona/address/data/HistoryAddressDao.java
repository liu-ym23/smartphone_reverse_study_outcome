package com.stepos.alphame.persona.address.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Dao
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H'J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H'J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H'¨\u0006\t"}, d2 = {"Lcom/stepos/alphame/persona/address/data/HistoryAddressDao;", "", "getHistoryAddressList", "", "Lcom/stepos/alphame/persona/address/data/AddressEntity;", "insertAddress", "", "addressEntity", "updateAddress", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface HistoryAddressDao {
    @Query("SELECT * FROM history_address ORDER BY update_time DESC LIMIT 5")
    @NotNull
    List<AddressEntity> getHistoryAddressList();

    @Insert(onConflict = 1)
    void insertAddress(@NotNull AddressEntity addressEntity);

    @Update(onConflict = 1)
    void updateAddress(@NotNull AddressEntity addressEntity);
}
