package com.stepos.stepclaw.memory.lightmem.evolution;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineTriggerResponse;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateFirstRequest;
import com.stepos.stepclaw.memory.lightmem.remote.OfflineUpdateResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u000bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/evolution/OfflineEvolutionPipelineResult;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "triggerResponse", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerResponse;", "updateRequest", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateFirstRequest;", "updateResponse", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;", "memoryIndexToDocId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerResponse;Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateFirstRequest;Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;Ljava/util/Map;)V", "getTriggerResponse", "()Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerResponse;", "getUpdateRequest", "()Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateFirstRequest;", "getUpdateResponse", "()Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateResponse;", "getMemoryIndexToDocId", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "other", "hashCode", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class OfflineEvolutionPipelineResult {
    private final Map<Long, String> memoryIndexToDocId;
    private final OfflineTriggerResponse triggerResponse;
    private final OfflineUpdateFirstRequest updateRequest;
    private final OfflineUpdateResponse updateResponse;

    public OfflineEvolutionPipelineResult(OfflineTriggerResponse triggerResponse, OfflineUpdateFirstRequest offlineUpdateFirstRequest, OfflineUpdateResponse offlineUpdateResponse, Map<Long, String> memoryIndexToDocId) {
        p.e(triggerResponse, "triggerResponse");
        p.e(memoryIndexToDocId, "memoryIndexToDocId");
        this.triggerResponse = triggerResponse;
        this.updateRequest = offlineUpdateFirstRequest;
        this.updateResponse = offlineUpdateResponse;
        this.memoryIndexToDocId = memoryIndexToDocId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfflineEvolutionPipelineResult copy$default(OfflineEvolutionPipelineResult offlineEvolutionPipelineResult, OfflineTriggerResponse offlineTriggerResponse, OfflineUpdateFirstRequest offlineUpdateFirstRequest, OfflineUpdateResponse offlineUpdateResponse, Map map, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            offlineTriggerResponse = offlineEvolutionPipelineResult.triggerResponse;
        }
        if ((i8 & 2) != 0) {
            offlineUpdateFirstRequest = offlineEvolutionPipelineResult.updateRequest;
        }
        if ((i8 & 4) != 0) {
            offlineUpdateResponse = offlineEvolutionPipelineResult.updateResponse;
        }
        if ((i8 & 8) != 0) {
            map = offlineEvolutionPipelineResult.memoryIndexToDocId;
        }
        return offlineEvolutionPipelineResult.copy(offlineTriggerResponse, offlineUpdateFirstRequest, offlineUpdateResponse, map);
    }

    /* renamed from: component1, reason: from getter */
    public final OfflineTriggerResponse getTriggerResponse() {
        return this.triggerResponse;
    }

    /* renamed from: component2, reason: from getter */
    public final OfflineUpdateFirstRequest getUpdateRequest() {
        return this.updateRequest;
    }

    /* renamed from: component3, reason: from getter */
    public final OfflineUpdateResponse getUpdateResponse() {
        return this.updateResponse;
    }

    public final Map<Long, String> component4() {
        return this.memoryIndexToDocId;
    }

    public final OfflineEvolutionPipelineResult copy(OfflineTriggerResponse triggerResponse, OfflineUpdateFirstRequest updateRequest, OfflineUpdateResponse updateResponse, Map<Long, String> memoryIndexToDocId) {
        p.e(triggerResponse, "triggerResponse");
        p.e(memoryIndexToDocId, "memoryIndexToDocId");
        return new OfflineEvolutionPipelineResult(triggerResponse, updateRequest, updateResponse, memoryIndexToDocId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfflineEvolutionPipelineResult)) {
            return false;
        }
        OfflineEvolutionPipelineResult offlineEvolutionPipelineResult = (OfflineEvolutionPipelineResult) other;
        return p.a(this.triggerResponse, offlineEvolutionPipelineResult.triggerResponse) && p.a(this.updateRequest, offlineEvolutionPipelineResult.updateRequest) && p.a(this.updateResponse, offlineEvolutionPipelineResult.updateResponse) && p.a(this.memoryIndexToDocId, offlineEvolutionPipelineResult.memoryIndexToDocId);
    }

    public final Map<Long, String> getMemoryIndexToDocId() {
        return this.memoryIndexToDocId;
    }

    public final OfflineTriggerResponse getTriggerResponse() {
        return this.triggerResponse;
    }

    public final OfflineUpdateFirstRequest getUpdateRequest() {
        return this.updateRequest;
    }

    public final OfflineUpdateResponse getUpdateResponse() {
        return this.updateResponse;
    }

    public int hashCode() {
        int iHashCode = this.triggerResponse.hashCode() * 31;
        OfflineUpdateFirstRequest offlineUpdateFirstRequest = this.updateRequest;
        int iHashCode2 = (iHashCode + (offlineUpdateFirstRequest == null ? 0 : offlineUpdateFirstRequest.hashCode())) * 31;
        OfflineUpdateResponse offlineUpdateResponse = this.updateResponse;
        return this.memoryIndexToDocId.hashCode() + ((iHashCode2 + (offlineUpdateResponse != null ? offlineUpdateResponse.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "OfflineEvolutionPipelineResult(triggerResponse=" + this.triggerResponse + ", updateRequest=" + this.updateRequest + ", updateResponse=" + this.updateResponse + ", memoryIndexToDocId=" + this.memoryIndexToDocId + ")";
    }
}
