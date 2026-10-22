package com.smt.obric.appstore.domain.app.db;

import androidx.room.Insert;
import androidx.room.Query;
import com.bytedanceos.common.ui.AppPermissionActivity;
import he.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\t\u001a\u00020\b2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H§@¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH'¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/smt/obric/appstore/domain/app/db/AppInfoDao;", "", "Lhe/a;", "appInfo", "", "upsert", "(Lhe/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "", "upsertBatch", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", AppPermissionActivity.EXTRA_APP_PKG, "Lkotlinx/coroutines/flow/Flow;", "getByPkg", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AppInfoDao {
    @Query("SELECT * FROM app_info WHERE pkg = :pkg ORDER by version_code DESC LIMIT 1")
    @NotNull
    Flow<a> getByPkg(@NotNull String r10);

    @Insert(onConflict = 1)
    @Nullable
    Object upsert(@NotNull a r10, @NotNull Continuation<? super Long> r11);

    @Insert(onConflict = 1)
    @Nullable
    Object upsertBatch(@NotNull List<a> r10, @NotNull Continuation<? super Unit> r11);
}
