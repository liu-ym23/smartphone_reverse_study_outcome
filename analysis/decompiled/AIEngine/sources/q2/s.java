package q2;

import androidx.room.RoomDatabase;
import androidx.work.BackoffPolicy;
import androidx.work.Data;
import androidx.work.OutOfQuotaPolicy;
import com.tonyodev.fetch2.EnqueueAction;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.NetworkType;
import com.tonyodev.fetch2.Priority;
import com.tonyodev.fetch2.Status;
import com.tonyodev.fetch2.database.DownloadInfo;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class s extends androidx.room.e {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f11544d = 0;

    public /* synthetic */ s(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String c() {
        switch (this.f11544d) {
            case 0:
                return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`next_schedule_time_override` = ?,`next_schedule_time_override_generation` = ?,`stop_reason` = ?,`trace_tag` = ?,`required_network_type` = ?,`required_network_request` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
            default:
                return "UPDATE OR REPLACE `requests` SET `_id` = ?,`_namespace` = ?,`_url` = ?,`_file` = ?,`_group` = ?,`_priority` = ?,`_headers` = ?,`_written_bytes` = ?,`_total_bytes` = ?,`_status` = ?,`_error` = ?,`_network_type` = ?,`_created` = ?,`_tag` = ?,`_enqueue_action` = ?,`_identifier` = ?,`_download_on_enqueue` = ?,`_extras` = ?,`_auto_retry_max_attempts` = ?,`_auto_retry_attempts` = ? WHERE `_id` = ?";
        }
    }

    @Override // androidx.room.e
    public final void e(y1.f fVar, Object obj) {
        int i10;
        int i11 = 1;
        switch (this.f11544d) {
            case 0:
                p pVar = (p) obj;
                fVar.Y(1, pVar.f11505a);
                fVar.h0(2, v.i(pVar.f11506b));
                fVar.Y(3, pVar.f11507c);
                fVar.Y(4, pVar.f11508d);
                Data data = pVar.f11509e;
                Data data2 = Data.f2768b;
                fVar.F(Data.b.b(data), 5);
                fVar.F(Data.b.b(pVar.f11510f), 6);
                fVar.h0(7, pVar.f11511g);
                fVar.h0(8, pVar.h);
                fVar.h0(9, pVar.f11512i);
                fVar.h0(10, pVar.f11514k);
                BackoffPolicy backoffPolicy = pVar.f11515l;
                kotlin.jvm.internal.g.f(backoffPolicy, "backoffPolicy");
                int iOrdinal = backoffPolicy.ordinal();
                if (iOrdinal == 0) {
                    i10 = 0;
                } else {
                    if (iOrdinal != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i10 = 1;
                }
                fVar.h0(11, i10);
                fVar.h0(12, pVar.f11516m);
                fVar.h0(13, pVar.f11517n);
                fVar.h0(14, pVar.f11518o);
                fVar.h0(15, pVar.f11519p);
                fVar.h0(16, pVar.f11520q ? 1L : 0L);
                OutOfQuotaPolicy policy = pVar.r;
                kotlin.jvm.internal.g.f(policy, "policy");
                int iOrdinal2 = policy.ordinal();
                if (iOrdinal2 == 0) {
                    i11 = 0;
                } else if (iOrdinal2 != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                fVar.h0(17, i11);
                fVar.h0(18, pVar.f11521s);
                fVar.h0(19, pVar.f11522t);
                fVar.h0(20, pVar.f11523u);
                fVar.h0(21, pVar.f11524v);
                fVar.h0(22, pVar.f11525w);
                String str = pVar.f11526x;
                if (str == null) {
                    fVar.v0(23);
                } else {
                    fVar.Y(23, str);
                }
                h2.c cVar = pVar.f11513j;
                fVar.h0(24, v.g(cVar.f9256a));
                fVar.F(v.b(cVar.f9257b), 25);
                fVar.h0(26, cVar.f9258c ? 1L : 0L);
                fVar.h0(27, cVar.f9259d ? 1L : 0L);
                fVar.h0(28, cVar.f9260e ? 1L : 0L);
                fVar.h0(29, cVar.f9261f ? 1L : 0L);
                fVar.h0(30, cVar.f9262g);
                fVar.h0(31, cVar.h);
                fVar.F(v.h(cVar.f9263i), 32);
                fVar.Y(33, pVar.f11505a);
                return;
            default:
                DownloadInfo downloadInfo = (DownloadInfo) obj;
                fVar.h0(1, downloadInfo.getId());
                fVar.Y(2, downloadInfo.getNamespace());
                fVar.Y(3, downloadInfo.getUrl());
                fVar.Y(4, downloadInfo.getFile());
                fVar.h0(5, downloadInfo.getGroup());
                Priority priority = downloadInfo.getPriority();
                kotlin.jvm.internal.g.f(priority, "priority");
                fVar.h0(6, priority.f8183a);
                fVar.Y(7, za.a.d(downloadInfo.getHeaders()));
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
                fVar.Y(18, za.a.b(downloadInfo.getExtras()));
                fVar.h0(19, downloadInfo.getAutoRetryMaxAttempts());
                fVar.h0(20, downloadInfo.getAutoRetryAttempts());
                fVar.h0(21, downloadInfo.getId());
                return;
        }
    }

    public s(com.stepos.statsrpk.g gVar, RoomDatabase roomDatabase) {
        super(roomDatabase, 0);
    }
}
