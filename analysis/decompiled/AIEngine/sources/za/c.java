package za;

import com.tonyodev.fetch2.EnqueueAction;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.Priority;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.DownloadInfo;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends androidx.room.e {
    @Override // androidx.room.SharedSQLiteStatement
    public final String c() {
        return "INSERT OR ABORT INTO `requests` (`_id`,`_namespace`,`_url`,`_file`,`_group`,`_priority`,`_headers`,`_written_bytes`,`_total_bytes`,`_status`,`_error`,`_network_type`,`_created`,`_tag`,`_enqueue_action`,`_identifier`,`_download_on_enqueue`,`_extras`,`_auto_retry_max_attempts`,`_auto_retry_attempts`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override // androidx.room.e
    public final void e(y1.f fVar, Object obj) {
        DownloadInfo downloadInfo = (DownloadInfo) obj;
        fVar.h0(1, downloadInfo.getId());
        fVar.Y(2, downloadInfo.getNamespace());
        fVar.Y(3, downloadInfo.getUrl());
        fVar.Y(4, downloadInfo.getFile());
        fVar.h0(5, downloadInfo.getGroup());
        Priority priority = downloadInfo.getPriority();
        kotlin.jvm.internal.g.f(priority, "priority");
        fVar.h0(6, priority.f8183a);
        fVar.Y(7, a.d(downloadInfo.getHeaders()));
        fVar.h0(8, downloadInfo.getDownloaded());
        fVar.h0(9, downloadInfo.getTotal());
        Status status = downloadInfo.getStatus();
        kotlin.jvm.internal.g.f(status, "status");
        fVar.h0(10, status.f8199a);
        Error error = downloadInfo.getError();
        kotlin.jvm.internal.g.f(error, "error");
        fVar.h0(11, error.f8172a);
        NetworkType networkType = downloadInfo.getNetworkType();
        kotlin.jvm.internal.g.f(networkType, "networkType");
        fVar.h0(12, networkType.f8178a);
        fVar.h0(13, downloadInfo.getCreated());
        if (downloadInfo.getTag() == null) {
            fVar.v0(14);
        } else {
            fVar.Y(14, downloadInfo.getTag());
        }
        EnqueueAction enqueueAction = downloadInfo.getEnqueueAction();
        kotlin.jvm.internal.g.f(enqueueAction, "enqueueAction");
        fVar.h0(15, enqueueAction.f8152a);
        fVar.h0(16, downloadInfo.getIdentifier());
        fVar.h0(17, downloadInfo.getDownloadOnEnqueue() ? 1L : 0L);
        fVar.Y(18, a.b(downloadInfo.getExtras()));
        fVar.h0(19, downloadInfo.getAutoRetryMaxAttempts());
        fVar.h0(20, downloadInfo.getAutoRetryAttempts());
    }
}
