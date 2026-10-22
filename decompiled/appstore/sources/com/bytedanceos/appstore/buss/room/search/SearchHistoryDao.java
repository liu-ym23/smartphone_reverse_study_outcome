package com.bytedanceos.appstore.buss.room.search;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.bytedanceos.appstore.buss.entity.bean.SearchHistoryEntityBean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Dao
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H'J\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH§@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedanceos/appstore/buss/room/search/SearchHistoryDao;", "", "deleteAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSearchHistory", "Landroidx/lifecycle/LiveData;", "", "Lcom/bytedanceos/appstore/buss/entity/bean/SearchHistoryEntityBean;", "insert", "entityBean", "(Lcom/bytedanceos/appstore/buss/entity/bean/SearchHistoryEntityBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface SearchHistoryDao {
    @Query("delete from tv_search_history_table")
    @Nullable
    Object deleteAll(@NotNull Continuation<? super Unit> r10);

    @Query("select * from tv_search_history_table order by createTime desc limit 0,20")
    @NotNull
    LiveData getSearchHistory();

    @Insert(onConflict = 1)
    @Nullable
    Object insert(@NotNull SearchHistoryEntityBean r10, @NotNull Continuation<? super Unit> r11);
}
