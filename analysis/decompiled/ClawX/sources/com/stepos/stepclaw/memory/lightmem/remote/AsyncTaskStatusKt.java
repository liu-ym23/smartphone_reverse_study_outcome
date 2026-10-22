package com.stepos.stepclaw.memory.lightmem.remote;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.n;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"effectiveUniqueId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerResponse;", "effectiveTaskStatus", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;", "step-memory_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AsyncTaskStatusKt {
    public static final String effectiveTaskStatus(OfflineTriggerResponse offlineTriggerResponse) {
        p.e(offlineTriggerResponse, "<this>");
        String task_status = offlineTriggerResponse.getTask_status();
        return n.t1(task_status) ? offlineTriggerResponse.getTrigger_status() : task_status;
    }

    public static final String effectiveUniqueId(OfflineTriggerResponse offlineTriggerResponse) {
        p.e(offlineTriggerResponse, "<this>");
        String unique_id = offlineTriggerResponse.getUnique_id();
        return n.t1(unique_id) ? offlineTriggerResponse.getTrigger_id() : unique_id;
    }

    public static final String effectiveTaskStatus(OfflineUpdateResponse offlineUpdateResponse) {
        p.e(offlineUpdateResponse, "<this>");
        return offlineUpdateResponse.getTask_status();
    }

    public static final String effectiveUniqueId(OfflineUpdateResponse offlineUpdateResponse) {
        p.e(offlineUpdateResponse, "<this>");
        String unique_id = offlineUpdateResponse.getUnique_id();
        return n.t1(unique_id) ? offlineUpdateResponse.getEvolution_id() : unique_id;
    }
}
