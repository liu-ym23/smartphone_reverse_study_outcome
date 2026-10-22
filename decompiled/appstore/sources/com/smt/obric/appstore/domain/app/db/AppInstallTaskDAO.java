package com.smt.obric.appstore.domain.app.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.bytedanceos.common.ui.AppPermissionActivity;
import com.smt.obric.appstore.domain.app.entity.AppStatus;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Dao
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0007H'¢\u0006\u0004\b\t\u0010\nJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH§@¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00072\u0006\u0010\u0010\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0002H'¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0017\u0010\u0018J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u000fH§@¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010!\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001fH§@¢\u0006\u0004\b!\u0010\"J\u001e\u0010%\u001a\u00020$2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00020\bH§@¢\u0006\u0004\b%\u0010\u000eJ&\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH§@¢\u0006\u0004\b'\u0010\u000eJ&\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH§@¢\u0006\u0004\b(\u0010\u000eJ\u0018\u0010)\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u000fH§@¢\u0006\u0004\b)\u0010\u001eJ\u001e\u0010+\u001a\u00020$2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\bH§@¢\u0006\u0004\b+\u0010\u000eJ \u0010-\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000bH§@¢\u0006\u0004\b-\u0010.J\u001e\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010/\u001a\u00020$H§@¢\u0006\u0004\b0\u00101J&\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010/\u001a\u00020$2\u0006\u00102\u001a\u00020$H§@¢\u0006\u0004\b3\u00104Jt\u0010?\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u000b2\b\u00105\u001a\u0004\u0018\u00010\u00022\b\u00106\u001a\u0004\u0018\u00010\u00022\b\u00107\u001a\u0004\u0018\u00010\u000f2\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u000f2\u0006\u0010;\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u00022\b\u0010=\u001a\u0004\u0018\u0001082\b\u0010>\u001a\u0004\u0018\u00010\u000fH§@¢\u0006\u0004\b?\u0010@J\u0084\u0001\u0010A\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u000b2\b\u00105\u001a\u0004\u0018\u00010\u00022\b\u00106\u001a\u0004\u0018\u00010\u00022\b\u00107\u001a\u0004\u0018\u00010\u000f2\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u000f2\u0006\u0010;\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u00022\b\u0010=\u001a\u0004\u0018\u0001082\b\u0010>\u001a\u0004\u0018\u00010\u000fH§@¢\u0006\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lcom/smt/obric/appstore/domain/app/db/AppInstallTaskDAO;", "", "", "downloadId", "Lcom/smt/obric/appstore/domain/app/entity/a;", "getByDownloadId", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/Flow;", "", "getAll", "()Lkotlinx/coroutines/flow/Flow;", "Lcom/smt/obric/appstore/domain/app/entity/AppStatus;", "status", "getTasksByState", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", AppPermissionActivity.EXTRA_APP_PKG, "getByPkg", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "versionCode", "getByPkgVer", "(Ljava/lang/String;J)Lkotlinx/coroutines/flow/Flow;", "appInstallTask", "upsert", "(Lcom/smt/obric/appstore/domain/app/entity/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "taskId", "", "updateDownloadId", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTaskToUseCellarData", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "wifiRequired", "updateDownloadWiFiRequired", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadIds", "", "deleteByDownloadId", "statusExcluded", "getAllWifiDownloadTasks", "getWaitWiFiDownloadTasks", "deleteByPkg", "downloadIdsToKeep", "pruneByDownloadIds", "appStatus", "updateAppStatus", "(Ljava/lang/String;Lcom/smt/obric/appstore/domain/app/entity/AppStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMode", "getAllTasksByUpdateMode", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complianceMode", "getAllTasksByUpdateModeAndComplianceMode", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadStatus", "downloadErrorCode", "downloadErrorMessage", "", "downloadProgress", "downloadFilePath", "curBytes", "totalBytes", "downloadSpeed", "downloadModifiedTime", "updateDownloadStatus", "(JLcom/smt/obric/appstore/domain/app/entity/AppStatus;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;FLjava/lang/String;JJLjava/lang/Float;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDownloadStatusByAppPkg", "(Ljava/lang/String;JJLcom/smt/obric/appstore/domain/app/entity/AppStatus;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;FLjava/lang/String;JJLjava/lang/Float;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appstorecommon_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface AppInstallTaskDAO {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object a(AppInstallTaskDAO r10, List r11, Continuation r12, int r13, Object r14) {
            if (r14 != null) goto L9;
            if ((r13 & 1) == 0) goto L7;
            r11 = s.e(AppStatus.f.f17978a);
        L7:
            return r10.getWaitWiFiDownloadTasks(r11, r12);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getWaitWiFiDownloadTasks");
        }
    }

    @Query("DELETE FROM app_install_task WHERE download_id IN (:downloadIds)")
    @Nullable
    Object deleteByDownloadId(@NotNull List<Long> r10, @NotNull Continuation<? super Integer> r11);

    @Query("DELETE FROM app_install_task WHERE pkg = :pkg")
    @Nullable
    Object deleteByPkg(@NotNull String r10, @NotNull Continuation<? super Integer> r11);

    @Query("SELECT * FROM app_install_task ORDER by created_at DESC")
    @NotNull
    Flow<List<com.smt.obric.appstore.domain.app.entity.a>> getAll();

    @Query("SELECT * FROM app_install_task WHERE update_mode = :updateMode")
    @Nullable
    Object getAllTasksByUpdateMode(int r10, @NotNull Continuation<? super List<com.smt.obric.appstore.domain.app.entity.a>> r11);

    @Query("SELECT * FROM app_install_task WHERE update_mode = :updateMode AND compliance_mode = :complianceMode")
    @Nullable
    Object getAllTasksByUpdateModeAndComplianceMode(int r10, int r11, @NotNull Continuation<? super List<com.smt.obric.appstore.domain.app.entity.a>> r12);

    @Query("SELECT * FROM app_install_task WHERE download_wifi_required = true AND status NOT IN (:statusExcluded)")
    @Nullable
    Object getAllWifiDownloadTasks(@NotNull List<? extends AppStatus> r10, @NotNull Continuation<? super List<com.smt.obric.appstore.domain.app.entity.a>> r11);

    @Query("SELECT * FROM app_install_task WHERE download_id = :downloadId LIMIT 1")
    @Nullable
    Object getByDownloadId(long r10, @NotNull Continuation<? super com.smt.obric.appstore.domain.app.entity.a> r11);

    @Query("SELECT * FROM app_install_task WHERE pkg = :pkg ORDER by created_at DESC LIMIT 1")
    @NotNull
    Flow<com.smt.obric.appstore.domain.app.entity.a> getByPkg(@NotNull String r10);

    @Query("SELECT * FROM app_install_task WHERE pkg = :pkg AND version_code = :versionCode ORDER by created_at DESC LIMIT 1")
    @NotNull
    Flow<com.smt.obric.appstore.domain.app.entity.a> getByPkgVer(@NotNull String r10, long r11);

    @Query("SELECT * FROM app_install_task WHERE status IN (:status) ORDER by created_at DESC")
    @Nullable
    Object getTasksByState(@NotNull List<? extends AppStatus> r10, @NotNull Continuation<? super List<com.smt.obric.appstore.domain.app.entity.a>> r11);

    @Query("SELECT * FROM app_install_task WHERE download_wifi_required = true AND status IN (:status)")
    @Nullable
    Object getWaitWiFiDownloadTasks(@NotNull List<? extends AppStatus> r10, @NotNull Continuation<? super List<com.smt.obric.appstore.domain.app.entity.a>> r11);

    @Query("DELETE FROM app_install_task WHERE download_id IS NOT NULL and download_id NOT IN (:downloadIdsToKeep)")
    @Nullable
    Object pruneByDownloadIds(@NotNull List<Long> r10, @NotNull Continuation<? super Integer> r11);

    @Query("UPDATE app_install_task SET status = :appStatus WHERE pkg = :pkg")
    @Nullable
    Object updateAppStatus(@NotNull String r10, @NotNull AppStatus r11, @NotNull Continuation<? super Integer> r12);

    @Query("UPDATE app_install_task SET download_id = :downloadId WHERE id = :taskId")
    @Nullable
    Object updateDownloadId(long r10, long r11, @NotNull Continuation<? super Unit> r12);

    @Query("\n        UPDATE app_install_task SET \n            status = :appStatus,\n            download_status = :downloadStatus,\n            download_error_code = :downloadErrorCode,\n            download_error_message = :downloadErrorMessage,\n            download_progress = :downloadProgress,\n            download_file_path = :downloadFilePath,\n            cur_bytes = :curBytes,\n            total_bytes = :totalBytes,\n            download_speed = :downloadSpeed,\n            download_modified_time = :downloadModifiedTime\n        WHERE download_id = :downloadId \n        ")
    @Nullable
    Object updateDownloadStatus(long r10, @NotNull AppStatus r11, @Nullable Long r12, @Nullable Long r13, @Nullable String r14, float r15, @Nullable String r16, long r17, long r18, @Nullable Float r19, @Nullable String r110, @NotNull Continuation<? super Integer> r111);

    @Query("\n        UPDATE app_install_task SET \n            download_id = :downloadId,\n            status = :appStatus,\n            download_status = :downloadStatus,\n            download_error_code = :downloadErrorCode,\n            download_error_message = :downloadErrorMessage,\n            download_progress = :downloadProgress,\n            download_file_path = :downloadFilePath,\n            cur_bytes = :curBytes,\n            total_bytes = :totalBytes,\n            download_speed = :downloadSpeed,\n            download_modified_time = :downloadModifiedTime\n        WHERE pkg = :pkg AND version_code = :versionCode \n        ")
    @Nullable
    Object updateDownloadStatusByAppPkg(@NotNull String r10, long r11, long r12, @NotNull AppStatus r13, @Nullable Long r14, @Nullable Long r15, @Nullable String r16, float r17, @Nullable String r18, long r19, long r110, @Nullable Float r111, @Nullable String r112, @NotNull Continuation<? super Integer> r113);

    @Query("UPDATE app_install_task SET download_wifi_required = :wifiRequired WHERE pkg = :pkg")
    @Nullable
    Object updateDownloadWiFiRequired(@NotNull String r10, boolean r11, @NotNull Continuation<? super Unit> r12);

    @Query("UPDATE app_install_task SET download_wifi_required = false WHERE pkg = :pkg")
    @Nullable
    Object updateTaskToUseCellarData(@NotNull String r10, @NotNull Continuation<? super Unit> r11);

    @Insert(onConflict = 1)
    @Nullable
    Object upsert(@NotNull com.smt.obric.appstore.domain.app.entity.a r10, @NotNull Continuation<? super Long> r11);
}
