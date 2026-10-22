package com.stepos.ailauncher.foundation.appui.card.state;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0080\b\u0018\u00002\u00020\u0001B[\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b \u0010\u0012R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010$R\u001a\u0010\f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\"\u001a\u0004\b%\u0010$R#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/stepos/ailauncher/foundation/appui/card/state/j;", "", "", "schemaVersion", "", "recordId", "Lcom/stepos/ailauncher/foundation/appui/card/state/c;", com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30860s, "stateType", "phase", "", "createdAtWallMs", "updatedAtWallMs", "", "metadata", "<init>", "(ILjava/lang/String;Lcom/stepos/ailauncher/foundation/appui/card/state/c;Ljava/lang/String;Ljava/lang/String;JJLjava/util/Map;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "c", "Lcom/stepos/ailauncher/foundation/appui/card/state/c;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/foundation/appui/card/state/c;", "e", "getPhase", "J", Const.INTENT_KEY_APIKEY, "()J", "getUpdatedAtWallMs", "Ljava/util/Map;", "getMetadata", "()Ljava/util/Map;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.foundation.appui.card.state.j, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class CardUiStateRecord {

    @SerializedName("created_at_wall_ms")
    private final long createdAtWallMs;

    @SerializedName(com.stepos.statsapp.v3.lib.plugin.net.multipart.e.f30860s)
    private final CardStateIdentity identity;
    private final Map<String, String> metadata;
    private final String phase;

    @SerializedName("record_id")
    private final String recordId;

    @SerializedName("schema_version")
    private final int schemaVersion;

    @SerializedName("state_type")
    private final String stateType;

    @SerializedName("updated_at_wall_ms")
    private final long updatedAtWallMs;

    public CardUiStateRecord(int i10, String recordId, CardStateIdentity identity, String stateType, String str, long j10, long j11, Map<String, String> metadata) {
        p.i(recordId, "recordId");
        p.i(identity, "identity");
        p.i(stateType, "stateType");
        p.i(metadata, "metadata");
        this.schemaVersion = i10;
        this.recordId = recordId;
        this.identity = identity;
        this.stateType = stateType;
        this.phase = str;
        this.createdAtWallMs = j10;
        this.updatedAtWallMs = j11;
        this.metadata = metadata;
    }

    /* renamed from: a, reason: from getter */
    public final long getCreatedAtWallMs() {
        return this.createdAtWallMs;
    }

    /* renamed from: b, reason: from getter */
    public final CardStateIdentity getIdentity() {
        return this.identity;
    }

    /* renamed from: c, reason: from getter */
    public final String getRecordId() {
        return this.recordId;
    }

    /* renamed from: d, reason: from getter */
    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    /* renamed from: e, reason: from getter */
    public final String getStateType() {
        return this.stateType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CardUiStateRecord)) {
            return false;
        }
        CardUiStateRecord cardUiStateRecord = (CardUiStateRecord) other;
        return this.schemaVersion == cardUiStateRecord.schemaVersion && p.d(this.recordId, cardUiStateRecord.recordId) && p.d(this.identity, cardUiStateRecord.identity) && p.d(this.stateType, cardUiStateRecord.stateType) && p.d(this.phase, cardUiStateRecord.phase) && this.createdAtWallMs == cardUiStateRecord.createdAtWallMs && this.updatedAtWallMs == cardUiStateRecord.updatedAtWallMs && p.d(this.metadata, cardUiStateRecord.metadata);
    }

    public int hashCode() {
        int iHashCode = ((((((Integer.hashCode(this.schemaVersion) * 31) + this.recordId.hashCode()) * 31) + this.identity.hashCode()) * 31) + this.stateType.hashCode()) * 31;
        String str = this.phase;
        return ((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.createdAtWallMs)) * 31) + Long.hashCode(this.updatedAtWallMs)) * 31) + this.metadata.hashCode();
    }

    public String toString() {
        return "CardUiStateRecord(schemaVersion=" + this.schemaVersion + ", recordId=" + this.recordId + ", identity=" + this.identity + ", stateType=" + this.stateType + ", phase=" + this.phase + ", createdAtWallMs=" + this.createdAtWallMs + ", updatedAtWallMs=" + this.updatedAtWallMs + ", metadata=" + this.metadata + ")";
    }
}
