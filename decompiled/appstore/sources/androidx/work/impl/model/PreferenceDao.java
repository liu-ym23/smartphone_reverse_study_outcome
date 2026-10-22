package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Dao
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\f2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/work/impl/model/PreferenceDao;", "", "Landroidx/work/impl/model/c;", "preference", "", "insertPreference", "(Landroidx/work/impl/model/c;)V", "", "key", "", "getLongValue", "(Ljava/lang/String;)Ljava/lang/Long;", "Landroidx/lifecycle/LiveData;", "getObservableLongValue", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface PreferenceDao {
    @Query("SELECT long_value FROM Preference where `key`=:key")
    @Nullable
    Long getLongValue(@NotNull String r10);

    @Query("SELECT long_value FROM Preference where `key`=:key")
    @NotNull
    LiveData getObservableLongValue(@NotNull String r10);

    @Insert(onConflict = 1)
    void insertPreference(@NotNull c r10);
}
