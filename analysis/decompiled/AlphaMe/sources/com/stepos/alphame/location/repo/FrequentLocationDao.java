package com.stepos.alphame.location.repo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.stepos.alphame.location.FrequentLocation;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Dao
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH'J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u000b"}, d2 = {"Lcom/stepos/alphame/location/repo/FrequentLocationDao;", "", "deleteAllFrequentLocation", "", "deleteFrequentLocation", "frequentLocation", "Lcom/stepos/alphame/location/FrequentLocation;", "getFrequentLocationList", "", "insertFrequentLocation", "updateFrequentLocation", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface FrequentLocationDao {
    @Query("DELETE FROM frequent_location")
    void deleteAllFrequentLocation();

    @Delete
    void deleteFrequentLocation(@NotNull FrequentLocation frequentLocation);

    @Query("SELECT * FROM frequent_location ORDER BY id ASC")
    @NotNull
    List<FrequentLocation> getFrequentLocationList();

    @Insert(onConflict = 1)
    void insertFrequentLocation(@NotNull FrequentLocation frequentLocation);

    @Update(onConflict = 1)
    void updateFrequentLocation(@NotNull FrequentLocation frequentLocation);
}
