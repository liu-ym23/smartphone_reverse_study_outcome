package com.stepos.agentframework.adapter.agentbus.bff;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\tR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/bff/n;", "", "", "sessionId", "", "deleted", "<init>", "(Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSessionId", "Z", Const.INTENT_KEY_APIKEY, "()Z", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.agentbus.bff.n, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class SessionDeleteResponseData {

    @SerializedName("deleted")
    private final boolean deleted;

    @SerializedName("session_id")
    private final String sessionId;

    /* JADX WARN: Multi-variable type inference failed */
    public SessionDeleteResponseData() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getDeleted() {
        return this.deleted;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionDeleteResponseData)) {
            return false;
        }
        SessionDeleteResponseData sessionDeleteResponseData = (SessionDeleteResponseData) other;
        return kotlin.jvm.internal.p.d(this.sessionId, sessionDeleteResponseData.sessionId) && this.deleted == sessionDeleteResponseData.deleted;
    }

    public int hashCode() {
        String str = this.sessionId;
        return ((str == null ? 0 : str.hashCode()) * 31) + Boolean.hashCode(this.deleted);
    }

    public String toString() {
        return "SessionDeleteResponseData(sessionId=" + this.sessionId + ", deleted=" + this.deleted + ")";
    }

    public SessionDeleteResponseData(String str, boolean z10) {
        this.sessionId = str;
        this.deleted = z10;
    }

    public /* synthetic */ SessionDeleteResponseData(String str, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? false : z10);
    }
}
