package androidx.work.impl.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Dao
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\f\u001a\u00020\u0007H'¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/work/impl/model/WorkNameDao;", "", "Landroidx/work/impl/model/j;", "workName", "", "insert", "(Landroidx/work/impl/model/j;)V", "", "name", "", "getWorkSpecIdsWithName", "(Ljava/lang/String;)Ljava/util/List;", "workSpecId", "getNamesForWorkSpecId", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface WorkNameDao {
    @Query("SELECT name FROM workname WHERE work_spec_id=:workSpecId")
    @NotNull
    List<String> getNamesForWorkSpecId(@NotNull String r10);

    @Query("SELECT work_spec_id FROM workname WHERE name=:name")
    @NotNull
    List<String> getWorkSpecIdsWithName(@NotNull String r10);

    @Insert(onConflict = 5)
    void insert(@NotNull j r10);
}
