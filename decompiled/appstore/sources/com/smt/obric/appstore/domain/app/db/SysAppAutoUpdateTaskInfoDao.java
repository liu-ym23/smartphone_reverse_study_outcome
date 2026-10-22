package com.smt.obric.appstore.domain.app.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.bytedanceos.common.ui.AppPermissionActivity;
import he.c;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Dao
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/smt/obric/appstore/domain/app/db/SysAppAutoUpdateTaskInfoDao;", "", "Lhe/c;", "taskInfo", "", "upsert", "(Lhe/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", AppPermissionActivity.EXTRA_APP_PKG, "getByPkg", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface SysAppAutoUpdateTaskInfoDao {
    @Query("SELECT * FROM sys_app_auto_update_task_info WHERE pkg = :pkg LIMIT 1")
    @Nullable
    Object getByPkg(@NotNull String r10, @NotNull Continuation<? super c> r11);

    @Insert(onConflict = 1)
    @Nullable
    Object upsert(@NotNull c r10, @NotNull Continuation<? super Long> r11);
}
